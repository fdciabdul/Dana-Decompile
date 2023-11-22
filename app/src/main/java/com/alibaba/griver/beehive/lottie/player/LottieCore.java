package com.alibaba.griver.beehive.lottie.player;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewTreeObserver;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder;
import com.alibaba.griver.beehive.lottie.adapter.impl.ApplicationAapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.H5UtilsAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.SwitchConfigUtilsAdapter;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.beehive.lottie.util.CommonUtils;
import com.alibaba.griver.beehive.lottie.util.DownloadFileUtils;
import com.alibaba.griver.beehive.lottie.util.MD5Util;
import com.alibaba.griver.beehive.lottie.util.MultiThreadUtils;
import com.alibaba.griver.beehive.lottie.util.StringUtils;
import com.alibaba.griver.image.photo.PhotoContext;
import com.alibaba.griver.lottie.FontAssetDelegate;
import com.alibaba.griver.lottie.ImageAssetDelegate;
import com.alibaba.griver.lottie.LottieAnimationView;
import com.alibaba.griver.lottie.LottieImageAsset;
import com.alibaba.griver.lottie.LottieListener;
import com.alibaba.griver.lottie.RenderMode;
import com.alibaba.griver.lottie.TextDelegate;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.fullstory.instrumentation.InstrumentInjector;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class LottieCore implements ICorePlayer<LottieAnimationView, String>, LottieListener<Throwable> {
    private static final String TAG = "LottiePlayer:LottieCore";
    private final Context mContext;
    private String mFailedMessage;
    private LottieAnimationView mLottieAnimationView;
    private FramePlayController mPlayController;
    private LottiePlayer mPlayer;
    private LottieParams params;
    private String mLatestLottieJsonMd5 = null;
    private CountDownLatch mBitmapLatch = new CountDownLatch(0);
    private List<CountDownTextView> cacheCountDownTextViewList = new ArrayList();
    private List<DynamicLayerModel> cacheCountDownLayerModelList = new ArrayList();
    private List<DynamicLayerModel> cacheVideoLayerModelList = new ArrayList();
    private final ImageAssetDelegate mImageAssetDelegate = new ImageAssetDelegate() { // from class: com.alibaba.griver.beehive.lottie.player.LottieCore.1
        {
            LottieCore.this = this;
        }

        @Override // com.alibaba.griver.lottie.ImageAssetDelegate
        public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
            if (LottieCore.this.params == null) {
                return Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            }
            String id2 = lottieImageAsset.getId();
            AbstractLottieAsset abstractLottieAsset = LottieCore.this.params.getAssets().get(id2);
            if (abstractLottieAsset == null || abstractLottieAsset.getBitmap() == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("fetchBitmap failed,id=");
                sb.append(id2);
                sb.append(",");
                sb.append(LottieCore.this.mPlayer.getLottieSource());
                GriverLogger.e(LottieCore.TAG, sb.toString());
                if (LottieCore.this.params.canDowngrade()) {
                    LottieCore.this.mPlayer.downgradeToPlaceholder();
                }
                return Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("fetchBitmap success,id=");
            sb2.append(id2);
            sb2.append(",");
            sb2.append(LottieCore.this.mPlayer.getLottieSource());
            GriverLogger.d(LottieCore.TAG, sb2.toString());
            return abstractLottieAsset.getBitmap();
        }
    };
    private final FontAssetDelegate mFontAssetDelegate = new FontAssetDelegate() { // from class: com.alibaba.griver.beehive.lottie.player.LottieCore.2
        {
            LottieCore.this = this;
        }

        @Override // com.alibaba.griver.lottie.FontAssetDelegate
        public Typeface fetchFont(String str) {
            if (LottieCore.this.params != null) {
                Typeface typeface = LottieCore.this.params.getFonts().get(str);
                if (typeface != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("fetchFont success,fontName=");
                    sb.append(str);
                    sb.append(",");
                    sb.append(LottieCore.this.mPlayer.getLottieSource());
                    GriverLogger.d(LottieCore.TAG, sb.toString());
                    return typeface;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("fetchFont failed,fontName=");
                sb2.append(str);
                sb2.append(",");
                sb2.append(LottieCore.this.mPlayer.getLottieSource());
                GriverLogger.e(LottieCore.TAG, sb2.toString());
                return Typeface.DEFAULT;
            }
            return Typeface.DEFAULT;
        }

        @Override // com.alibaba.griver.lottie.FontAssetDelegate
        public String getFontPath(String str) {
            GriverLogger.e(LottieCore.TAG, "FontAssetDelegate.getFontPath not implement");
            return null;
        }
    };
    private final TextDelegate mTextDelegate = new TextDelegate() { // from class: com.alibaba.griver.beehive.lottie.player.LottieCore.3
        {
            LottieCore.this = this;
        }

        @Override // com.alibaba.griver.lottie.TextDelegate
        public String fetchText(String str) {
            Map<String, String> lottieParams;
            return (str == null || !str.startsWith("TEXT@") || !str.endsWith(AUScreenAdaptTool.PREFIX_ID) || (lottieParams = LottieCore.this.params.getLottieParams()) == null) ? str : lottieParams.get(str);
        }
    };
    private boolean mIsLoadSuccess = true;

    public void addVideoView() {
    }

    private void pauseVideoPlayer() {
    }

    private void playVideoPlayer() {
    }

    public void prepareVideoResource(List<DynamicLayerModel> list) {
    }

    private void resumeVideoPlayer() {
    }

    private void stopVideoPlayer() {
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void sendEvent(String str, String str2) {
    }

    public String toString() {
        return TAG;
    }

    public LottieCore(Context context, LottiePlayer lottiePlayer) {
        this.mContext = context;
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.mLottieAnimationView = lottieAnimationView;
        lottieAnimationView.setErrorListener(this);
        this.mPlayer = lottiePlayer;
        this.mLottieAnimationView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.alibaba.griver.beehive.lottie.player.LottieCore.4
            {
                LottieCore.this = this;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (CommonUtils.getHasCountDownLayer(LottieCore.this.params.getDynamicLayerModelList()) || CommonUtils.getHasVideoLayer(LottieCore.this.params.getDynamicLayerModelList())) {
                    if (LottieCore.this.mLottieAnimationView.getImageMatrix() == null || LottieCore.this.mLottieAnimationView.getLottieDrawable().getDynamicLayers() == null || LottieCore.this.mLottieAnimationView.getLottieDrawable().getDynamicLayers().size() <= 0) {
                        return;
                    }
                    LottieCore.this.addCountDownView();
                    LottieCore.this.addVideoView();
                    LottieCore.this.mLottieAnimationView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    return;
                }
                LottieCore.this.mLottieAnimationView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void setPlayController(FramePlayController framePlayController) {
        this.mPlayController = framePlayController;
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public boolean hasPlayController() {
        return this.mPlayController != null;
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void play() {
        FramePlayController framePlayController = this.mPlayController;
        if (framePlayController != null) {
            framePlayController.play();
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void play(float f, float f2) {
        this.mLottieAnimationView.playAnimation(f, f2);
        resumeCountDown();
        playVideoPlayer();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void play(int i, int i2) {
        this.mLottieAnimationView.playAnimation(i, i2);
        resumeCountDown();
        playVideoPlayer();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public boolean isPlaying() {
        return this.mLottieAnimationView.isAnimating();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void pause() {
        this.mLottieAnimationView.pauseAnimation();
        pauseCountDown();
        pauseVideoPlayer();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void stop() {
        FramePlayController framePlayController = this.mPlayController;
        if (framePlayController != null) {
            framePlayController.stop();
        }
        this.mLottieAnimationView.setProgress(0.0f);
        this.mLottieAnimationView.cancelAnimation();
        pauseCountDown();
        stopVideoPlayer();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void goToAndStop(float f) {
        this.mLottieAnimationView.cancelAnimation();
        setProgress(f);
        pauseCountDown();
        stopVideoPlayer();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void goToAndPlay(float f) {
        this.mLottieAnimationView.playAnimation();
        setProgress(f);
        resumeCountDown();
        playVideoPlayer();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void setProgress(float f) {
        this.mLottieAnimationView.setProgress(f);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public float getProgress() {
        return this.mLottieAnimationView.getProgress();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void setSpeed(float f) {
        this.mLottieAnimationView.setSpeed(f);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void setRepeatCount(int i) {
        if (i < 0) {
            this.mLottieAnimationView.loop(true);
            return;
        }
        this.mLottieAnimationView.loop(false);
        this.mLottieAnimationView.setRepeatCount(i);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public long getDuration() {
        return this.mLottieAnimationView.getDuration();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void hide() {
        this.mLottieAnimationView.cancelAnimation();
        this.mLottieAnimationView.setVisibility(8);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void destroy() {
        try {
            this.mLottieAnimationView.cancelAnimation();
            this.mLottieAnimationView.removeAllAnimatorListeners();
            stopVideoPlayer();
        } catch (Exception unused) {
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public LottieAnimationView getView() {
        return this.mLottieAnimationView;
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.mLottieAnimationView.addAnimatorListener(animatorListener);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mLottieAnimationView.addAnimatorUpdateListener(animatorUpdateListener);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.mLottieAnimationView.removeAnimatorListener(animatorListener);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void setPlayerParams(LottieParams lottieParams) {
        StringBuilder sb = new StringBuilder();
        sb.append("setPlayerParams,params is set:");
        sb.append(lottieParams != null);
        sb.append(" @");
        sb.append(this.mPlayer.getLottieSource());
        GriverLogger.d(TAG, sb.toString());
        this.params = lottieParams;
        if (lottieParams != null) {
            if (TextUtils.isEmpty(SwitchConfigUtilsAdapter.getConfigValue("LottiePlayer_downgradeLevel_HARDWARE_close"))) {
                if ("HARDWARE".equals(lottieParams.getDowngradeLevel())) {
                    this.mLottieAnimationView.setRenderMode(RenderMode.FORCE_HARDWARE);
                } else if ("SOFTWARE".equals(lottieParams.getDowngradeLevel())) {
                    this.mLottieAnimationView.setRenderMode(RenderMode.SOFTWARE);
                }
            }
            this.mLottieAnimationView.setDynamicLayerEnable(lottieParams.getDynamicLayerEnable());
            this.mLottieAnimationView.setImageAssetDelegate(this.mImageAssetDelegate);
            this.mLottieAnimationView.setFontAssetDelegate(this.mFontAssetDelegate);
            this.mLottieAnimationView.setTextDelegate(this.mTextDelegate);
            String encrypt = MD5Util.encrypt(lottieParams.getLottieJson());
            if (lottieParams.getLottieComposition() != null) {
                this.mLottieAnimationView.setComposition(lottieParams.getLottieComposition());
            } else {
                this.mLottieAnimationView.setAnimationFromJson(lottieParams.getLottieJson());
            }
            long currentTimeMillis = System.currentTimeMillis();
            String configValue = SwitchConfigUtilsAdapter.getConfigValue("LottiePlayer_multi_update_play_close");
            int i = 300;
            if (!TextUtils.isEmpty(configValue)) {
                try {
                    i = Integer.parseInt(configValue);
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("LottiePlayer_multi_update_play_close开关解释出错：");
                    sb2.append(e);
                    GriverLogger.w(TAG, sb2.toString());
                }
            }
            if (!lottieParams.isAutoPlay() && currentTimeMillis - this.mPlayer.getLatestParamsTimestamp() <= i && StringUtils.equal(encrypt, this.mLatestLottieJsonMd5) && i > 0) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("相同资源在短时间多次初始化，时间间隔：");
                sb3.append(currentTimeMillis - this.mPlayer.getLatestParamsTimestamp());
                sb3.append(",multiUpdateSwitchValue=");
                sb3.append(i);
                sb3.append(" @");
                sb3.append(this.mPlayer.getLottieSource());
                GriverLogger.w(TAG, sb3.toString());
                this.mPlayer.play();
            }
            this.mLatestLottieJsonMd5 = encrypt;
            return;
        }
        this.mPlayer.downgradeToPlaceholder();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public String getLottieSource() {
        return this.mPlayer.getLottieSource();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void initCorePlayer(final LottieParams lottieParams, final String str) {
        final Map hashMap = lottieParams.animationAssetsMap != null ? lottieParams.animationAssetsMap : new HashMap();
        final Map hashMap2 = lottieParams.animationFontsMap != null ? lottieParams.animationFontsMap : new HashMap();
        final List<DynamicLayerModel> videoZoneModel = CommonUtils.getVideoZoneModel(lottieParams.getDynamicLayerModelList());
        MultiThreadUtils.runOnBackgroundThreadOrder(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottieCore.5
            {
                LottieCore.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                List list;
                if (hashMap.isEmpty() && hashMap2.isEmpty() && ((list = videoZoneModel) == null || list.size() <= 0)) {
                    LottieCore.this.initFinished(lottieParams);
                    return;
                }
                List list2 = videoZoneModel;
                LottieCore.this.mBitmapLatch = new CountDownLatch(hashMap.size() + hashMap2.size() + (list2 != null ? list2.size() : 0));
                LottieCore.this.prepareAssetsBitmap(lottieParams, hashMap, str);
                LottieCore.this.prepareFontsTypeface(lottieParams, hashMap2, str);
                LottieCore.this.prepareVideoResource(videoZoneModel);
                try {
                    String configValue = SwitchConfigUtilsAdapter.getConfigValue("BeeLottiePlayer_await_time");
                    int i = 20;
                    if (!TextUtils.isEmpty(configValue)) {
                        try {
                            i = Integer.parseInt(configValue);
                        } catch (Exception e) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("BeeLottiePlayer_await_time 开关解释出错：");
                            sb.append(e);
                            GriverLogger.w(LottieCore.TAG, sb.toString());
                        }
                    }
                    if (!LottieCore.this.mBitmapLatch.await(i, TimeUnit.SECONDS)) {
                        LottieCore.this.mIsLoadSuccess = false;
                        LottieCore lottieCore = LottieCore.this;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("prepareAssetsBitmap|prepareFontsTypeface 处理超时：");
                        sb2.append(i);
                        lottieCore.mFailedMessage = sb2.toString();
                        GriverLogger.w(LottieCore.TAG, LottieCore.this.mFailedMessage);
                    }
                    LottieCore.this.initFinished(lottieParams);
                } catch (InterruptedException e2) {
                    GriverLogger.e(LottieCore.TAG, "初始化LottieCore 10秒超时异常：", e2);
                    LottiePlayer lottiePlayer = LottieCore.this.mPlayer;
                    LottieCore lottieCore2 = LottieCore.this;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("initCorePlayer,并发错误:");
                    sb3.append(e2.getLocalizedMessage());
                    lottiePlayer.onCorePlayerInitFailed(lottieCore2, sb3.toString());
                }
            }
        }, this.mPlayer.getThreadOrderKey());
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void setProgressWithFrame(int i) {
        this.mLottieAnimationView.setFrame(i);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public Bitmap getSnapshot() {
        if (!this.mPlayer.isDrawingCacheEnabled()) {
            this.mPlayer.setDrawingCacheEnabled(true);
            this.mPlayer.buildDrawingCache();
            Bitmap drawingCache = this.mPlayer.getDrawingCache();
            if (drawingCache == null) {
                return null;
            }
            Bitmap copy = drawingCache.copy(drawingCache.getConfig(), false);
            this.mPlayer.setDrawingCacheEnabled(false);
            return copy;
        }
        this.mPlayer.destroyDrawingCache();
        this.mPlayer.buildDrawingCache();
        Bitmap drawingCache2 = this.mPlayer.getDrawingCache();
        if (drawingCache2 == null) {
            return null;
        }
        Bitmap copy2 = drawingCache2.copy(drawingCache2.getConfig(), false);
        this.mPlayer.destroyDrawingCache();
        return copy2;
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void resume() {
        this.mLottieAnimationView.resumeAnimation();
        resumeCountDown();
        resumeVideoPlayer();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void playByDynamicSpeed(long j) {
        if (j < 0) {
            return;
        }
        this.mLottieAnimationView.setSpeed((float) (j / (this.mLottieAnimationView.getDuration() * (Math.max(this.params.getRepeatCount(), 0) + 1))));
        this.mLottieAnimationView.playAnimation();
        setProgress(0.0f);
        resumeCountDown();
        playVideoPlayer();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ICorePlayer
    public void receiveParams(LottieParams lottieParams) {
        this.params = lottieParams;
    }

    public void initFinished(LottieParams lottieParams) {
        if (this.mIsLoadSuccess) {
            this.mPlayer.onCorePlayerInitSuccess(this, lottieParams);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("initFinished：初始化失败：");
        sb.append(this.mFailedMessage);
        GriverLogger.e(TAG, sb.toString());
        this.mPlayer.onCorePlayerInitFailed(this, this.mFailedMessage);
    }

    public void prepareAssetsBitmap(LottieParams lottieParams, Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append("lottie asset -> ");
            sb.append(key);
            sb.append(",");
            sb.append(getLottieSource());
            GriverLogger.d(TAG, sb.toString());
            getBitmapsFromAssets(lottieParams, key, value, str);
        }
    }

    public void prepareFontsTypeface(LottieParams lottieParams, Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append("lottie font -> ");
            sb.append(key);
            sb.append(",");
            sb.append(value);
            GriverLogger.d(TAG, sb.toString());
            getTypefaceFromFonts(lottieParams, key, value, str);
        }
    }

    @Override // com.alibaba.griver.lottie.LottieListener
    public void onResult(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("LottieCore LottieJsonStr解释失败:");
        sb.append(th);
        this.mPlayer.onRenderFailed(this, sb.toString());
    }

    private void getTypefaceFromFonts(final LottieParams lottieParams, final String str, final String str2, String str3) {
        String transferApPathToLocalPath;
        if (str2.startsWith("./")) {
            String substring = str2.substring(2);
            if (TextUtils.isEmpty(lottieParams.getAssetsPath()) && lottieParams.getLottieFile() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("file:");
                sb.append(lottieParams.getLottieFile().getAbsolutePath());
                sb.append(File.separator);
                sb.append(substring);
                str2 = sb.toString();
            } else if (TextUtils.isEmpty(lottieParams.getAssetsPath()) && BeeLottiePlayerBuilder.FILE_LOCAL_TYPE_ASSETS.equals(lottieParams.getAnimationFileLocalType())) {
                String assetsImageDir = lottieParams.getAssetsImageDir();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(assetsImageDir.startsWith("file:///[asset]/") ? "" : "file:///[asset]/");
                sb2.append(assetsImageDir);
                sb2.append(assetsImageDir.endsWith(File.separator) ? "" : File.separator);
                sb2.append(substring);
                str2 = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(lottieParams.getAssetsPath());
                sb3.append(substring);
                str2 = sb3.toString();
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("getTypefaceFromFonts，fontName=");
        sb4.append(str);
        sb4.append(",finalUrl=");
        sb4.append(str2);
        GriverLogger.d(TAG, sb4.toString());
        DownloadFileUtils.WrapResponseListener wrapResponseListener = new DownloadFileUtils.WrapResponseListener() { // from class: com.alibaba.griver.beehive.lottie.player.LottieCore.6
            {
                LottieCore.this = this;
            }

            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public void onSuccess(InputStream inputStream, String str4) throws Exception {
                GriverLogger.e("font资源加载成功：", str2);
                LottieCore.this.mBitmapLatch.countDown();
            }

            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public void onError(String str4) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str2);
                sb5.append(",");
                sb5.append(str4);
                GriverLogger.e("font资源加载出错：", sb5.toString());
                if (TextUtils.isEmpty(LottieCore.this.mFailedMessage)) {
                    LottieCore.this.mFailedMessage = str4;
                }
                LottieCore.this.setLoadFontTypefaceError();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("getTypefaceFromFonts -> ");
                sb6.append(str4);
                GriverLogger.e(LottieCore.TAG, sb6.toString());
                lottieParams.getFonts().put(str, null);
                LottieCore.this.mBitmapLatch.countDown();
            }
        };
        if (str2.startsWith("/")) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("font获取，暂不支持小程序：");
            sb5.append(str2);
            wrapResponseListener.onError(sb5.toString());
        } else if (str2.startsWith("file:///[asset]/")) {
            try {
                Context context = this.mContext;
                if (context == null) {
                    context = ApplicationAapter.getApplicationContext();
                }
                AssetManager assets = context.getAssets();
                String substring2 = str2.substring(16);
                Typeface typefaceCreateFromAsset = InstrumentInjector.typefaceCreateFromAsset(assets, substring2);
                if (typefaceCreateFromAsset != null) {
                    lottieParams.getFonts().put(str, typefaceCreateFromAsset);
                    wrapResponseListener.onSuccess(null, substring2);
                    return;
                }
                wrapResponseListener.onError("从文件创建asset失败");
            } catch (Throwable th) {
                wrapResponseListener.onError(th.toString());
            }
        } else if (str2.startsWith(H5ResourceHandlerUtil.RESOURCE) || str2.startsWith("file:")) {
            try {
                if (str2.startsWith("file:")) {
                    transferApPathToLocalPath = str2.startsWith(PhotoContext.FILE_SCHEME) ? str2.substring(7) : str2.substring(5);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("本地font资源，url=");
                    sb6.append(str2);
                    sb6.append(",localFile=");
                    sb6.append(transferApPathToLocalPath);
                    GriverLogger.d(TAG, sb6.toString());
                } else {
                    transferApPathToLocalPath = H5UtilsAdapter.transferApPathToLocalPath(str2);
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("小程序font资源，apFile=");
                    sb7.append(str2);
                    sb7.append(",localFile=");
                    sb7.append(transferApPathToLocalPath);
                    GriverLogger.d(TAG, sb7.toString());
                }
                if (TextUtils.isEmpty(transferApPathToLocalPath)) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("font资源:");
                    sb8.append(str2);
                    sb8.append(",转换本地资源为空");
                    wrapResponseListener.onError(sb8.toString());
                    return;
                }
                Typeface createFromFile = Typeface.createFromFile(transferApPathToLocalPath);
                if (createFromFile != null) {
                    lottieParams.getFonts().put(str, createFromFile);
                    wrapResponseListener.onSuccess(null, transferApPathToLocalPath);
                    return;
                }
                wrapResponseListener.onError("从文件创建font失败");
            } catch (Throwable th2) {
                wrapResponseListener.onError(th2.toString());
            }
        } else {
            LottieHelper.downloadFontFromRemoteSync(lottieParams, str, str2, wrapResponseListener, getLottieSource());
        }
    }

    private void getBitmapsFromAssets(final LottieParams lottieParams, final String str, String str2, String str3) {
        String str4;
        str4 = "";
        if (str2.contains(";base64,")) {
            byte[] bArr = null;
            try {
                bArr = Base64.decode(str2.substring(str2.indexOf(";base64,") + 8), 2);
            } catch (Exception e) {
                str4 = e.getLocalizedMessage();
                GriverLogger.e(TAG, "Base64图片解码出错：", e);
            }
            if (bArr == null || bArr.length == 0) {
                if (TextUtils.isEmpty(this.mFailedMessage)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Base64 decode failed:");
                    sb.append(str4);
                    this.mFailedMessage = sb.toString();
                }
                setLoadAssetsBitmapsError();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getBitmapsFromAssets: base64 decode failed.");
                sb2.append(getLottieSource());
                GriverLogger.e(TAG, sb2.toString());
            }
            LottieParams.Asset asset = new LottieParams.Asset(bArr);
            if (asset.getBitmap() == null) {
                setLoadAssetsBitmapsError();
            }
            lottieParams.getAssets().put(str, asset);
            this.mBitmapLatch.countDown();
            return;
        }
        if (TextUtils.isEmpty(lottieParams.getAssetsPath()) && lottieParams.getLottieFile() != null && !str2.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("file:");
            sb3.append(lottieParams.getLottieFile().getAbsolutePath());
            sb3.append(File.separator);
            sb3.append(str2);
            str2 = sb3.toString();
        } else if (TextUtils.isEmpty(lottieParams.getAssetsPath()) && !str2.startsWith(SemanticAttributes.FaasTriggerValues.HTTP) && BeeLottiePlayerBuilder.FILE_LOCAL_TYPE_ASSETS.equals(lottieParams.getAnimationFileLocalType())) {
            String assetsImageDir = lottieParams.getAssetsImageDir();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(assetsImageDir.startsWith("file:///[asset]/") ? "" : "file:///[asset]/");
            sb4.append(assetsImageDir);
            sb4.append(assetsImageDir.endsWith(File.separator) ? "" : File.separator);
            sb4.append(str2);
            str2 = sb4.toString();
        } else if (!str2.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(lottieParams.getAssetsPath());
            sb5.append(str2);
            str2 = sb5.toString();
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("url -> ");
        sb6.append(str2);
        GriverLogger.d(TAG, sb6.toString());
        this.mPlayer.getResourceWithUrl(str2, new DownloadFileUtils.WrapResponseListener() { // from class: com.alibaba.griver.beehive.lottie.player.LottieCore.7
            {
                LottieCore.this = this;
            }

            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public void onSuccess(InputStream inputStream, String str5) throws Exception {
                LottieParams.Asset asset2 = new LottieParams.Asset(inputStream);
                if (asset2.getBitmap() == null) {
                    LottieCore.this.setLoadAssetsBitmapsError();
                }
                lottieParams.getAssets().put(str, asset2);
                LottieCore.this.mBitmapLatch.countDown();
            }

            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public LottieParams getLottieParams() {
                return lottieParams;
            }

            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public void onError(String str5) {
                if (TextUtils.isEmpty(LottieCore.this.mFailedMessage)) {
                    LottieCore.this.mFailedMessage = str5;
                }
                LottieCore.this.setLoadAssetsBitmapsError();
                StringBuilder sb7 = new StringBuilder();
                sb7.append("getBitmapsFromAssets -> ");
                sb7.append(str5);
                GriverLogger.e(LottieCore.TAG, sb7.toString());
                lottieParams.getAssets().put(str, null);
                LottieCore.this.mBitmapLatch.countDown();
            }
        }, this.mContext, getLottieSource());
    }

    public void setLoadAssetsBitmapsError() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lottie图片资源加载出错:");
        sb.append(this.mFailedMessage);
        GriverLogger.w(TAG, sb.toString());
        if (this.mIsLoadSuccess) {
            this.mIsLoadSuccess = false;
        }
    }

    public void setLoadFontTypefaceError() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lottie字体加载出错:");
        sb.append(this.mFailedMessage);
        GriverLogger.w(TAG, sb.toString());
        if (this.mIsLoadSuccess) {
            this.mIsLoadSuccess = false;
        }
    }

    public void destroyAll() {
        this.mLottieAnimationView.setImageAssetDelegate(null);
        this.mLottieAnimationView.setFontAssetDelegate(null);
        this.mLottieAnimationView.setTextDelegate(null);
        this.mLottieAnimationView = new LottieAnimationView(this.mContext);
    }

    public String hitTestDynamicLayerInView(float f, float f2) {
        return this.mLottieAnimationView.hitTestDynamicLayerInView(f, f2);
    }

    public RectF getDynamicLayerRectInView(String str) {
        return this.mLottieAnimationView.getDynamicLayerRectInView(str);
    }

    public void addCountDownView() {
        List<DynamicLayerModel> timerZoneModel = CommonUtils.getTimerZoneModel(this.params.getDynamicLayerModelList());
        if (timerZoneModel != null && timerZoneModel.size() > 0) {
            if (this.cacheCountDownLayerModelList.size() <= 0) {
                for (DynamicLayerModel dynamicLayerModel : timerZoneModel) {
                    CountDownTextView countDownTextView = new CountDownTextView(this.mPlayer.getContext());
                    countDownTextView.setTimerLayerModel(dynamicLayerModel.getTimerParams());
                    countDownTextView.addToParentView(this.mPlayer, getDynamicLayerRectInView(dynamicLayerModel.getLayerId()));
                    this.cacheCountDownLayerModelList.add(dynamicLayerModel);
                    this.cacheCountDownTextViewList.add(countDownTextView);
                }
                return;
            }
            for (CountDownTextView countDownTextView2 : this.cacheCountDownTextViewList) {
                if (countDownTextView2 != null && countDownTextView2.hasPause()) {
                    countDownTextView2.resumeTimer();
                }
            }
            return;
        }
        this.cacheCountDownTextViewList.clear();
        this.cacheCountDownLayerModelList.clear();
        int childCount = this.mPlayer.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mPlayer.getChildAt(i);
            if (childAt instanceof CountDownTextView) {
                this.mPlayer.removeView(childAt);
            }
        }
    }

    private void pauseCountDown() {
        List<CountDownTextView> list = this.cacheCountDownTextViewList;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<CountDownTextView> it = this.cacheCountDownTextViewList.iterator();
        while (it.hasNext()) {
            it.next().pauseTimer();
        }
    }

    private void resumeCountDown() {
        List<CountDownTextView> list = this.cacheCountDownTextViewList;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<CountDownTextView> it = this.cacheCountDownTextViewList.iterator();
        while (it.hasNext()) {
            it.next().resumeTimer();
        }
    }
}
