package com.alibaba.griver.beehive.lottie.player;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.adapter.impl.APDecodeResultAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.APImageInfoAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.H5UtilsAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.SwitchConfigUtilsAdapter;
import com.alibaba.griver.beehive.lottie.constants.LottieConstants;
import com.alibaba.griver.beehive.lottie.downgrade.DowngradeRuler;
import com.alibaba.griver.beehive.lottie.player.FramePlayController;
import com.alibaba.griver.beehive.lottie.util.CommonUtils;
import com.alibaba.griver.beehive.lottie.util.DownloadFileUtils;
import com.alibaba.griver.beehive.lottie.util.MultiThreadUtils;
import com.alibaba.griver.beehive.lottie.util.SceneUtils;
import com.alibaba.griver.beehive.lottie.util.StringUtils;
import com.alibaba.griver.beehive.lottie.util.TouchDetector;
import com.alibaba.griver.image.framework.utils.Format;
import com.alibaba.griver.lottie.LottieAnimationView;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* loaded from: classes6.dex */
public class LottiePlayer extends FrameLayout implements ILottiePlayer, Animator.AnimatorListener, TouchDetector.Callback {
    private static final String TAG = "LottiePlayer";
    public static final int TAG_PLACEHOLDER_KEY = -12345;
    protected String animationPlaceHolderFilePath;
    private BeeLotttieJSONModel beeLotttieJSONModel;
    private List<PlaceholderZoneModel> cacheClickPlaceholderZoneModelList;
    private List<CountDownTextView> cachePlaceholderCountDownTextViewList;
    private List<PlaceholderZoneModel> cacheTimerPlaceholderZoneModelList;
    private List<ImageView> cacheVideoPlaceholdeImageViewList;
    private List<PlaceholderZoneModel> cacheVideoPlaceholderZoneModelList;
    private String canvasRenderScene;
    private boolean corePlayeHasInited;
    private String currentRenderType;
    private DispatchEventListener dispatchEventListener;
    protected DowngradeRuler downgradeRuler;
    private boolean firstFrameRendered;
    private int fr;
    private FramePlayController.FrameAnimationListener frameAnimationListener;
    private int h;
    private boolean hasClickLayer;
    boolean hasDowngradeToPlaceholder;
    private boolean hasEnd;
    private boolean hasLoadDowngrade;
    protected boolean hasLoadPlaceholder;
    private boolean hasPaused;
    protected boolean isDowngrade;
    protected boolean loadPlaceholderFirst;
    public Rect lottieRect;
    private boolean lottieSuccess;
    protected Context mContext;
    protected String mFailedMessage;
    protected ICorePlayer mICorePlayer;
    protected ILottieDataStatus mILottieDataStatus;
    protected boolean mIsLoadSuccess;
    protected boolean mIsPlaying;
    private long mLatestParamsTimestamp;
    protected ViewGroup.LayoutParams mLayoutParams;
    protected String mLottieSource;
    protected LottieParams mParams;
    public ImageView mPlaceholder;
    protected float mProgress;
    public String mSource;
    protected OnFillVariableValueListener mVariableFilledListener;
    private boolean needMemCacahe;
    protected boolean placeHolderAnimationInited;
    private Rect placeHolderRect;
    private boolean placeHolderSuccess;
    private IRenderFailedListener renderFailedListener;
    private String sceneForLog;
    private Queue<Runnable> taskListQueueWhenCorePlayNotInited;
    private String threadOrderKey;
    private Runnable timerAction;
    private TouchDetector touchDetector;
    private int w;

    /* loaded from: classes6.dex */
    public interface DispatchEventListener {
        boolean dispatchEvent(String str, String str2);
    }

    /* loaded from: classes6.dex */
    public interface OnFillVariableValueListener {
        void onFillVariableValue(Map<String, String> map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trace(String str) {
    }

    @Override // com.alibaba.griver.beehive.lottie.util.TouchDetector.Callback
    public void onLongClick(View view, MotionEvent motionEvent) {
    }

    public LottiePlayer(Context context) {
        this(context, "unknown");
    }

    public LottiePlayer(Context context, String str) {
        super(context);
        this.mIsPlaying = false;
        this.mProgress = 0.0f;
        this.mLottieSource = "";
        this.mLatestParamsTimestamp = -1L;
        this.loadPlaceholderFirst = true;
        this.isDowngrade = false;
        this.sceneForLog = "";
        this.canvasRenderScene = null;
        this.placeHolderSuccess = false;
        this.lottieSuccess = false;
        this.hasPaused = false;
        this.hasEnd = true;
        this.renderFailedListener = null;
        this.hasLoadPlaceholder = false;
        this.hasLoadDowngrade = false;
        this.needMemCacahe = false;
        this.cacheClickPlaceholderZoneModelList = new ArrayList();
        this.cachePlaceholderCountDownTextViewList = new ArrayList();
        this.cacheTimerPlaceholderZoneModelList = new ArrayList();
        this.cacheVideoPlaceholderZoneModelList = new ArrayList();
        this.cacheVideoPlaceholdeImageViewList = new ArrayList();
        this.hasDowngradeToPlaceholder = false;
        this.placeHolderAnimationInited = false;
        this.mIsLoadSuccess = true;
        this.mFailedMessage = "";
        this.taskListQueueWhenCorePlayNotInited = new LinkedList();
        this.corePlayeHasInited = false;
        this.firstFrameRendered = false;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(this);
        this.mLottieSource = sb.toString();
        this.mSource = str;
        this.mContext = getContext();
        this.downgradeRuler = new DowngradeRuler();
        ImageView imageView = new ImageView(context);
        this.mPlaceholder = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        this.mLayoutParams = layoutParams;
        addView(this.mPlaceholder, layoutParams);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("new LottiePlayer@");
        sb2.append(this);
        sb2.append(" source : ");
        sb2.append(str);
        GriverLogger.d(TAG, sb2.toString());
        this.touchDetector = new TouchDetector(this);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (LottiePlayer.this.hasClickLayer) {
                    if (LottiePlayer.this.hasLoadDowngrade || (LottiePlayer.this.mICorePlayer != null && (LottiePlayer.this.mICorePlayer instanceof LottieCore))) {
                        return LottiePlayer.this.touchDetector.onTouch(view, motionEvent);
                    }
                    return false;
                }
                return false;
            }
        });
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void play() {
        if (this.mPlaceholder.isShown() && !TextUtils.isEmpty(this.animationPlaceHolderFilePath)) {
            startPlaceHolderAnimation();
        }
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.2
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.play();
                }
            });
        } else if (!this.corePlayeHasInited) {
            StringBuilder sb = new StringBuilder();
            sb.append("will play(),");
            sb.append(this.mLottieSource);
            GriverLogger.d(TAG, sb.toString());
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.play();
                }
            });
        } else if (this.hasPaused && !this.hasEnd) {
            resume();
        } else {
            this.hasEnd = false;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("play() ");
            sb2.append(this.mLottieSource);
            sb2.append(" param -> ");
            sb2.append(this.mParams);
            GriverLogger.d(TAG, sb2.toString());
            trace("play");
            if (this.mICorePlayer.hasPlayController()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.mICorePlayer);
                sb3.append(",play(),");
                sb3.append(this.mLottieSource);
                GriverLogger.d(TAG, sb3.toString());
                this.mICorePlayer.play();
                return;
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("default play(),");
            sb4.append(this.mLottieSource);
            GriverLogger.d(TAG, sb4.toString());
            this.mICorePlayer.setProgress(this.mProgress);
            this.mICorePlayer.goToAndPlay(this.mProgress);
            this.mProgress = 0.0f;
        }
    }

    public void playOnce() {
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.4
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.playOnce();
                }
            });
        } else if (!this.corePlayeHasInited) {
            StringBuilder sb = new StringBuilder();
            sb.append("will playOnce(),");
            sb.append(this.mLottieSource);
            GriverLogger.d(TAG, sb.toString());
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.playOnce();
                }
            });
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("playOnce(),");
            sb2.append(this.mLottieSource);
            GriverLogger.d(TAG, sb2.toString());
            trace("playOnce");
            setRepeatCount(0);
            this.mProgress = 0.0f;
            this.mICorePlayer.setProgress(0.0f);
            this.mICorePlayer.goToAndPlay(this.mProgress);
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void play(final float f, final float f2) {
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.6
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.play(f, f2);
                }
            });
        } else if (!this.corePlayeHasInited) {
            StringBuilder sb = new StringBuilder();
            sb.append("will play(");
            sb.append(f);
            sb.append("f, ");
            sb.append(f);
            sb.append("f),");
            sb.append(this.mLottieSource);
            GriverLogger.d(TAG, sb.toString());
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.7
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.play(f, f2);
                }
            });
        } else {
            float min = Math.min(Math.max(f, 0.0f), 1.0f);
            float min2 = Math.min(Math.max(f2, 0.0f), 1.0f);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mICorePlayer);
            sb2.append(",play(");
            sb2.append(min);
            sb2.append("f, ");
            sb2.append(min2);
            sb2.append("f),");
            sb2.append(this.mLottieSource);
            GriverLogger.d(TAG, sb2.toString());
            trace(LottieConstants.METHOD_PLAY_FROM_MIN_TO_MAX_PROGRESS);
            this.hasEnd = false;
            this.mICorePlayer.play(min, min2);
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void play(final int i, final int i2) {
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.8
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.play(i, i2);
                }
            });
        } else if (!this.corePlayeHasInited) {
            StringBuilder sb = new StringBuilder();
            sb.append("will play(");
            sb.append(i);
            sb.append(", ");
            sb.append(i2);
            sb.append("),");
            sb.append(this.mLottieSource);
            GriverLogger.d(TAG, sb.toString());
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.9
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.play(i, i2);
                }
            });
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mICorePlayer);
            sb2.append(",play(");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            sb2.append("),");
            sb2.append(this.mLottieSource);
            GriverLogger.d(TAG, sb2.toString());
            trace(LottieConstants.METHOD_PLAY_FROM_MIN_TO_MAX_FRAME);
            this.hasEnd = false;
            this.mICorePlayer.play(i, i2);
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public boolean isPlaying() {
        ICorePlayer iCorePlayer = this.mICorePlayer;
        return iCorePlayer != null && iCorePlayer.isPlaying();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void pause() {
        pausePlaceholderAnimation();
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        this.mLatestParamsTimestamp = -1L;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.10
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.pause();
                }
            });
        } else if (!this.corePlayeHasInited) {
            StringBuilder sb = new StringBuilder();
            sb.append("will pause(),");
            sb.append(this.mLottieSource);
            GriverLogger.d(TAG, sb.toString());
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.11
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.pause();
                }
            });
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mICorePlayer);
            sb2.append(",pause() ,");
            sb2.append(this.mLottieSource);
            GriverLogger.d(TAG, sb2.toString());
            trace("pause");
            ICorePlayer iCorePlayer = this.mICorePlayer;
            if (iCorePlayer != null) {
                iCorePlayer.pause();
                this.hasPaused = true;
            }
        }
    }

    private void pauseAndSaveCurrentProgress() {
        if (SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("Lottie_player_pause_save_progress")) || this.mICorePlayer.isPlaying()) {
            this.mProgress = this.mICorePlayer.getProgress();
        }
    }

    public void pauseSync() {
        pausePlaceholderAnimation();
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        this.mLatestParamsTimestamp = -1L;
        if (!this.corePlayeHasInited) {
            StringBuilder sb = new StringBuilder();
            sb.append("will pauseSync(),");
            sb.append(this.mLottieSource);
            GriverLogger.d(TAG, sb.toString());
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.12
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.pauseSync();
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("pauseSync(),");
        sb2.append(this.mLottieSource);
        GriverLogger.d(TAG, sb2.toString());
        this.mICorePlayer.pause();
        this.hasPaused = true;
    }

    public void resume() {
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        if (!this.corePlayeHasInited) {
            StringBuilder sb = new StringBuilder();
            sb.append("will resume(),");
            sb.append(this.mLottieSource);
            GriverLogger.d(TAG, sb.toString());
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.13
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.resume();
                }
            });
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("resume(),");
        sb2.append(this.mLottieSource);
        GriverLogger.d(TAG, sb2.toString());
        this.mICorePlayer.resume();
        this.hasPaused = false;
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void stop() {
        stopPlaceholderAnimation();
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        this.mLatestParamsTimestamp = -1L;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.14
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.stop();
                }
            });
        } else if (!this.corePlayeHasInited) {
            StringBuilder sb = new StringBuilder();
            sb.append("will stop(),");
            sb.append(this.mLottieSource);
            GriverLogger.d(TAG, sb.toString());
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.15
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.stop();
                }
            });
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mICorePlayer);
            sb2.append(",stop() ,");
            sb2.append(this.mLottieSource);
            GriverLogger.d(TAG, sb2.toString());
            trace("stop");
            this.mICorePlayer.stop();
            Runnable runnable = this.timerAction;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.timerAction = null;
            }
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void goToAndStop(final float f) {
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        this.mLatestParamsTimestamp = -1L;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.16
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.goToAndStop(f);
                }
            });
        } else if (!this.corePlayeHasInited) {
            StringBuilder sb = new StringBuilder();
            sb.append("will goToAndStop(");
            sb.append(f);
            sb.append("),");
            sb.append(this.mLottieSource);
            GriverLogger.d(TAG, sb.toString());
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.17
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.goToAndStop(f);
                }
            });
        } else {
            float min = Math.min(Math.max(f, 0.0f), 1.0f);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("goToAndStop(");
            sb2.append(min);
            sb2.append(") ,");
            sb2.append(this.mLottieSource);
            GriverLogger.d(TAG, sb2.toString());
            trace(LottieConstants.METHOD_GO_TO_AND_STOP);
            this.mICorePlayer.goToAndStop(min);
            this.mProgress = min;
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void goToAndPlay(final float f) {
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.18
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.goToAndPlay(f);
                }
            });
        } else if (!this.corePlayeHasInited) {
            StringBuilder sb = new StringBuilder();
            sb.append("will goToAndPlay(");
            sb.append(f);
            sb.append(") ,");
            sb.append(this.mLottieSource);
            GriverLogger.d(TAG, sb.toString());
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.19
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.goToAndPlay(f);
                }
            });
        } else {
            float min = Math.min(Math.max(f, 0.0f), 1.0f);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("goToAndPlay(");
            sb2.append(min);
            sb2.append(") ,");
            sb2.append(this.mLottieSource);
            GriverLogger.d(TAG, sb2.toString());
            trace(LottieConstants.METHOD_GO_TO_AND_PLAY);
            this.mLatestParamsTimestamp = System.currentTimeMillis();
            this.mICorePlayer.setProgress(min);
            this.mICorePlayer.goToAndPlay(min);
            this.mProgress = 0.0f;
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void setProgress(final float f) {
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        if (!this.corePlayeHasInited) {
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.20
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.setProgress(f);
                }
            });
            return;
        }
        this.mICorePlayer.setProgress(Math.min(Math.max(f, 0.0f), 1.0f));
    }

    public void setProgressWithFrame(final int i) {
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        if (!this.corePlayeHasInited) {
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.21
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.setProgressWithFrame(i);
                }
            });
        } else {
            this.mICorePlayer.setProgressWithFrame(i);
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public float getProgress() {
        ICorePlayer iCorePlayer = this.mICorePlayer;
        if (iCorePlayer != null) {
            return iCorePlayer.getProgress();
        }
        return 0.0f;
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void setSpeed(final float f) {
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        if (!this.corePlayeHasInited) {
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.22
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.setSpeed(f);
                }
            });
            return;
        }
        this.mParams.setSpeed(f);
        this.mICorePlayer.setSpeed(f);
        trace(LottieConstants.METHOD_SET_SPEED);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void setRepeatCount(final int i) {
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        if (!this.corePlayeHasInited) {
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.23
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.setRepeatCount(i);
                }
            });
        } else {
            this.mICorePlayer.setRepeatCount(i);
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public long getDuration() {
        trace(LottieConstants.METHOD_GET_DURATION);
        ICorePlayer iCorePlayer = this.mICorePlayer;
        if (iCorePlayer != null) {
            return iCorePlayer.getDuration();
        }
        return 0L;
    }

    void downgrade() {
        this.hasLoadDowngrade = true;
        preparePlaceHolder(this.mParams.getDowngrade(), true);
        downgradeToPlaceholder();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void downgradeToPlaceholder() {
        LottieParams lottieParams = this.mParams;
        if (lottieParams != null && lottieParams.getDowngrade() != null && !this.mParams.getDowngrade().equals(this.mPlaceholder.getTag(TAG_PLACEHOLDER_KEY))) {
            this.hasLoadDowngrade = true;
            preparePlaceHolder(this.mParams.getDowngrade(), false);
        }
        startPlaceHolderAnimation();
        MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.24
            @Override // java.lang.Runnable
            public void run() {
                LottiePlayer.this.downgradeToPlaceholderPrivate();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downgradeToPlaceholderPrivate() {
        trace(LottieConstants.METHOD_DOWNGRADE_TO_PLACEHOLDER);
        StringBuilder sb = new StringBuilder();
        sb.append("downgradeToPlaceholder().");
        sb.append(this.mLottieSource);
        GriverLogger.d(TAG, sb.toString());
        ICorePlayer iCorePlayer = this.mICorePlayer;
        if (iCorePlayer != null) {
            iCorePlayer.hide();
            removeView(this.mICorePlayer.getView());
        } else if (!this.taskListQueueWhenCorePlayNotInited.isEmpty()) {
            try {
                this.taskListQueueWhenCorePlayNotInited.clear();
            } catch (Exception unused) {
            }
        }
        this.mPlaceholder.setVisibility(0);
        this.mPlaceholder.bringToFront();
        List<PlaceholderZoneModel> timerPlaceholderZoneModel = CommonUtils.getTimerPlaceholderZoneModel(this.mParams.getDynamicLayerModelList(), this.mPlaceholder);
        if (timerPlaceholderZoneModel != null && timerPlaceholderZoneModel.size() > 0) {
            if (this.cacheTimerPlaceholderZoneModelList.size() <= 0) {
                for (PlaceholderZoneModel placeholderZoneModel : timerPlaceholderZoneModel) {
                    CountDownTextView countDownTextView = new CountDownTextView(getContext());
                    countDownTextView.setTimerLayerModel(placeholderZoneModel.getTimerLayerModel());
                    countDownTextView.addToParentView(this, placeholderZoneModel.getMapRect());
                    this.cachePlaceholderCountDownTextViewList.add(countDownTextView);
                    this.cacheTimerPlaceholderZoneModelList.add(placeholderZoneModel);
                }
            }
        } else {
            this.cachePlaceholderCountDownTextViewList.clear();
            this.cacheTimerPlaceholderZoneModelList.clear();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof CountDownTextView) {
                    removeView(childAt);
                }
            }
        }
        List<PlaceholderZoneModel> videoPlaceholderZoneModel = CommonUtils.getVideoPlaceholderZoneModel(this.mParams.getDynamicLayerModelList(), this.mPlaceholder);
        if (videoPlaceholderZoneModel != null && videoPlaceholderZoneModel.size() > 0) {
            if (this.cacheVideoPlaceholderZoneModelList.size() <= 0) {
                for (PlaceholderZoneModel placeholderZoneModel2 : videoPlaceholderZoneModel) {
                    PlaceHolderImgeView placeHolderImgeView = new PlaceHolderImgeView(getContext());
                    placeHolderImgeView.addToParentView(this, placeholderZoneModel2.getMapRect());
                    this.cacheVideoPlaceholderZoneModelList.add(placeholderZoneModel2);
                    this.cacheVideoPlaceholdeImageViewList.add(placeHolderImgeView);
                }
                return;
            }
            return;
        }
        this.cacheVideoPlaceholderZoneModelList.clear();
        this.cacheVideoPlaceholdeImageViewList.clear();
        int childCount2 = getChildCount();
        for (int i2 = 0; i2 < childCount2; i2++) {
            View childAt2 = getChildAt(i2);
            if (childAt2 instanceof PlaceHolderImgeView) {
                removeView(childAt2);
            }
        }
    }

    public void downgradeAndRecycleResource() {
        StringBuilder sb = new StringBuilder();
        sb.append("downgradeAndRecycleResource,placeHolderSuccess=");
        sb.append(this.placeHolderSuccess);
        sb.append(",hasDowngradeToPlaceholder=");
        sb.append(this.hasDowngradeToPlaceholder);
        sb.append(",mParams is set ");
        sb.append(this.mParams != null);
        sb.append(",");
        sb.append(this.mLottieSource);
        GriverLogger.d(TAG, sb.toString());
        if (this.hasDowngradeToPlaceholder || SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("Lottie_player_downgrade_recycle_disable"))) {
            return;
        }
        trace(LottieParams.KEY_DOWNGRADE);
        final Runnable runnable = new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.25
            @Override // java.lang.Runnable
            public void run() {
                LottiePlayer.this.hasDowngradeToPlaceholder = true;
                LottiePlayer.this.downgradeToPlaceholderPrivate();
                LottiePlayer.this.recycleAntmationResource();
                if (LottiePlayer.this.mICorePlayer instanceof LottieCore) {
                    try {
                        LottieAnimationView view = ((LottieCore) LottiePlayer.this.mICorePlayer).getView();
                        if (view != null && view.getComposition() != null) {
                            view.getComposition().getLayers().clear();
                            view.getComposition().getImages().clear();
                        }
                    } catch (Exception e) {
                        GriverLogger.e(LottiePlayer.TAG, "downgradeAndRecycleResource:", e);
                    }
                    ((LottieCore) LottiePlayer.this.mICorePlayer).destroyAll();
                }
                LottiePlayer.this.mICorePlayer = null;
                if (LottiePlayer.this.mParams != null) {
                    LottiePlayer.this.mParams.setLottieJson("");
                    if (LottiePlayer.this.mParams.getLottieComposition() != null) {
                        try {
                            LottiePlayer.this.mParams.getLottieComposition().getLayers().clear();
                            LottiePlayer.this.mParams.getLottieComposition().getImages().clear();
                        } catch (Exception e2) {
                            GriverLogger.e(LottiePlayer.TAG, "downgradeAndRecycleResource:", e2);
                        }
                    }
                    LottiePlayer.this.mParams.setLottieComposition(null);
                }
            }
        };
        if (this.placeHolderSuccess) {
            LottieParams lottieParams = this.mParams;
            if (lottieParams != null && lottieParams.getDowngrade() != null && !this.mParams.getDowngrade().equals(this.mPlaceholder.getTag(TAG_PLACEHOLDER_KEY))) {
                this.hasLoadDowngrade = true;
                MultiThreadUtils.runOnBackgroundThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.26
                    @Override // java.lang.Runnable
                    public void run() {
                        LottiePlayer lottiePlayer = LottiePlayer.this;
                        lottiePlayer.preparePlaceHolder(lottiePlayer.mParams.getDowngrade(), false, false, runnable);
                    }
                });
                return;
            }
            MultiThreadUtils.runOnUiThread(runnable);
            return;
        }
        MultiThreadUtils.runOnBackgroundThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.27
            @Override // java.lang.Runnable
            public void run() {
                if (LottiePlayer.this.mParams != null) {
                    LottiePlayer lottiePlayer = LottiePlayer.this;
                    lottiePlayer.preparePlaceHolder(lottiePlayer.mParams.getDowngrade(), false, false, runnable);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int startPlaceHolderAnimation() {
        if (TextUtils.isEmpty(this.animationPlaceHolderFilePath)) {
            return 0;
        }
        MultiThreadUtils.runOnBackgroundThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.28
            @Override // java.lang.Runnable
            public void run() {
                if (LottiePlayer.this.placeHolderAnimationInited) {
                    return;
                }
                LottiePlayer.this.placeHolderAnimationInited = true;
            }
        });
        return 0;
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void applyParams(final LottieParams lottieParams) {
        StringBuilder sb = new StringBuilder();
        sb.append("applyParams(),params is set:");
        sb.append(lottieParams != null);
        sb.append(",corePlayeHasInited=");
        sb.append(this.corePlayeHasInited);
        sb.append(",");
        sb.append(this.mLottieSource);
        GriverLogger.d(TAG, sb.toString());
        this.corePlayeHasInited = false;
        if (Looper.myLooper() == Looper.getMainLooper() && !SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("LottiePlayer_apply_work_thread_disabled"))) {
            MultiThreadUtils.runOnBackgroundThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.29
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.applyParamsAndInitView(lottieParams);
                }
            });
        } else {
            applyParamsAndInitView(lottieParams);
        }
    }

    private void initCorePlayerAndSetPlayerParams(final LottieParams lottieParams, final AbstractPlayCommand[] abstractPlayCommandArr, final String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("initCorePlayerAndSetPlayerParams(),renderType=");
        sb.append(str);
        sb.append(",params.getRenderType()=");
        sb.append(lottieParams.getRenderType());
        sb.append(",");
        sb.append(this.mLottieSource);
        GriverLogger.d(TAG, sb.toString());
        MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.30
            @Override // java.lang.Runnable
            public void run() {
                LottiePlayer.this.initCorePlayer(str, lottieParams, abstractPlayCommandArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCorePlayer(String str, LottieParams lottieParams, AbstractPlayCommand[] abstractPlayCommandArr) {
        if (this.mICorePlayer == null || !StringUtils.equal(this.currentRenderType, str)) {
            ICorePlayer iCorePlayer = this.mICorePlayer;
            if (iCorePlayer != null) {
                removeView(iCorePlayer.getView());
                this.mICorePlayer.destroy();
            }
            LottieCore lottieCore = new LottieCore(this.mContext, this);
            this.mICorePlayer = lottieCore;
            lottieCore.receiveParams(lottieParams);
            addView(this.mICorePlayer.getView(), new FrameLayout.LayoutParams(this.mLayoutParams));
            this.mICorePlayer.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.31
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (LottiePlayer.this.mICorePlayer.getView().getParent() == null || LottiePlayer.this.mPlaceholder.getVisibility() == 8) {
                        return;
                    }
                    LottiePlayer.this.mPlaceholder.setVisibility(8);
                    LottiePlayer.this.stopPlaceholderAnimation();
                }
            });
            this.mICorePlayer.addAnimatorListener(this);
        }
        this.currentRenderType = str;
        if (abstractPlayCommandArr != null && abstractPlayCommandArr.length > 0) {
            FramePlayController framePlayController = new FramePlayController(abstractPlayCommandArr, this.mICorePlayer);
            framePlayController.setListener(this.frameAnimationListener);
            this.mICorePlayer.setPlayController(framePlayController);
        } else {
            this.mICorePlayer.setPlayController(null);
        }
        this.mICorePlayer.initCorePlayer(lottieParams, this.currentRenderType);
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void attach() {
        if (this.mIsPlaying) {
            applyParams(this.mParams);
            play();
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void detach() {
        this.mIsPlaying = isPlaying();
        pause();
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void destroy() {
        StringBuilder sb = new StringBuilder();
        sb.append("destroy(),");
        sb.append(this.mLottieSource);
        GriverLogger.d(TAG, sb.toString());
        recycleAntmationResource();
        stopPlaceholderAnimation();
        Runnable runnable = this.timerAction;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.timerAction = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recycleAntmationResource() {
        ICorePlayer iCorePlayer = this.mICorePlayer;
        if (iCorePlayer != null) {
            iCorePlayer.destroy();
        }
        this.mILottieDataStatus = null;
        try {
            Queue<Runnable> queue = this.taskListQueueWhenCorePlayNotInited;
            if (queue != null && !queue.isEmpty()) {
                Iterator<Runnable> it = queue.iterator();
                while (it.hasNext()) {
                    it.next();
                    it.remove();
                }
            }
        } catch (Exception unused) {
        }
        try {
            LottieParams lottieParams = this.mParams;
            if (lottieParams != null) {
                Iterator<Map.Entry<String, AbstractLottieAsset>> it2 = lottieParams.getAssets().entrySet().iterator();
                while (it2.hasNext()) {
                    it2.next().getValue().destory();
                }
            }
        } catch (Exception unused2) {
        }
    }

    private void pausePlaceholderAnimation() {
        if (TextUtils.isEmpty(this.animationPlaceHolderFilePath)) {
            return;
        }
        MultiThreadUtils.runOnBackgroundThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.32
            @Override // java.lang.Runnable
            public void run() {
                if (LottiePlayer.this.cachePlaceholderCountDownTextViewList == null || LottiePlayer.this.cachePlaceholderCountDownTextViewList.size() <= 0) {
                    return;
                }
                Iterator it = LottiePlayer.this.cachePlaceholderCountDownTextViewList.iterator();
                while (it.hasNext()) {
                    ((CountDownTextView) it.next()).pauseTimer();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPlaceholderAnimation() {
        if (TextUtils.isEmpty(this.animationPlaceHolderFilePath)) {
            return;
        }
        MultiThreadUtils.runOnBackgroundThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.33
            @Override // java.lang.Runnable
            public void run() {
                if (LottiePlayer.this.cachePlaceholderCountDownTextViewList == null || LottiePlayer.this.cachePlaceholderCountDownTextViewList.size() <= 0) {
                    return;
                }
                Iterator it = LottiePlayer.this.cachePlaceholderCountDownTextViewList.iterator();
                while (it.hasNext()) {
                    ((CountDownTextView) it.next()).pauseTimer();
                }
            }
        });
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public View getView() {
        ICorePlayer iCorePlayer = this.mICorePlayer;
        if (iCorePlayer != null) {
            return iCorePlayer.getView();
        }
        return null;
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public LottieAnimationView getLottie() {
        ICorePlayer iCorePlayer = this.mICorePlayer;
        if (iCorePlayer instanceof LottieCore) {
            return (LottieAnimationView) iCorePlayer.getView();
        }
        return null;
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void addAnimatorListener(final Animator.AnimatorListener animatorListener) {
        if (!this.corePlayeHasInited) {
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.34
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.addAnimatorListener(animatorListener);
                }
            });
        } else {
            this.mICorePlayer.addAnimatorListener(animatorListener);
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void removeAnimatorListener(final Animator.AnimatorListener animatorListener) {
        if (!this.corePlayeHasInited) {
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.35
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.removeAnimatorListener(animatorListener);
                }
            });
        } else {
            this.mICorePlayer.removeAnimatorListener(animatorListener);
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void playByDynamicSpeed(final long j) {
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.36
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.playByDynamicSpeed(j);
                }
            });
        } else if (!this.corePlayeHasInited) {
            StringBuilder sb = new StringBuilder();
            sb.append("will playByDynamicSpeed(");
            sb.append(j);
            sb.append("),");
            sb.append(this.mLottieSource);
            GriverLogger.d(TAG, sb.toString());
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.37
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.playByDynamicSpeed(j);
                }
            });
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mICorePlayer);
            sb2.append(",playByDynamicSpeed(");
            sb2.append(j);
            sb2.append("),");
            sb2.append(this.mLottieSource);
            GriverLogger.d(TAG, sb2.toString());
            trace("playByDynamicSpeed");
            this.hasEnd = false;
            this.mICorePlayer.playByDynamicSpeed(j);
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void playByTotalDuration(final long j, final IPlayByTotalDurationListener iPlayByTotalDurationListener) {
        if (this.hasDowngradeToPlaceholder) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.38
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.playByTotalDuration(j, iPlayByTotalDurationListener);
                }
            });
        } else if (!this.corePlayeHasInited) {
            StringBuilder sb = new StringBuilder();
            sb.append("will playByTotalDuration(");
            sb.append(j);
            sb.append("),");
            sb.append(this.mLottieSource);
            GriverLogger.d(TAG, sb.toString());
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.39
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.playByTotalDuration(j, iPlayByTotalDurationListener);
                }
            });
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.mICorePlayer);
            sb2.append(",playByTotalDuration(");
            sb2.append(j);
            sb2.append("),");
            sb2.append(this.mLottieSource);
            GriverLogger.d(TAG, sb2.toString());
            trace("playByDynamicSpeed");
            this.hasEnd = false;
            this.mICorePlayer.setProgress(this.mProgress);
            this.mICorePlayer.goToAndPlay(this.mProgress);
            this.mProgress = 0.0f;
            Runnable runnable = new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.40
                @Override // java.lang.Runnable
                public void run() {
                    if (LottiePlayer.this.mICorePlayer != null) {
                        LottiePlayer.this.mICorePlayer.stop();
                    }
                    IPlayByTotalDurationListener iPlayByTotalDurationListener2 = iPlayByTotalDurationListener;
                    if (iPlayByTotalDurationListener2 != null) {
                        iPlayByTotalDurationListener2.playEnd();
                    }
                }
            };
            this.timerAction = runnable;
            postDelayed(runnable, j);
        }
    }

    @Override // com.alibaba.griver.beehive.lottie.player.ILottiePlayer
    public void sendEvent(String str, String str2) {
        ICorePlayer iCorePlayer = this.mICorePlayer;
        if (iCorePlayer != null) {
            iCorePlayer.sendEvent(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnDataFailed() {
        MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.41
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb = new StringBuilder();
                sb.append("isDowngrade=");
                sb.append(LottiePlayer.this.isDowngrade);
                sb.append(",fireOnDataFailed ");
                sb.append(LottiePlayer.this.mLottieSource);
                GriverLogger.e(LottiePlayer.TAG, sb.toString());
                if (LottiePlayer.this.mILottieDataStatus != null) {
                    LottiePlayer.this.mILottieDataStatus.onDataFailed(LottiePlayer.this.mFailedMessage);
                }
            }
        });
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAnimationStart,isReverse=");
        sb.append(z);
        sb.append(",");
        sb.append(this.mLottieSource);
        GriverLogger.d(TAG, sb.toString());
        onAnimationStart(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAnimationStart,");
        sb.append(this.mLottieSource);
        GriverLogger.d(TAG, sb.toString());
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAnimationEnd,isReverse=");
        sb.append(z);
        sb.append(",");
        sb.append(this.mLottieSource);
        GriverLogger.d(TAG, sb.toString());
        this.hasEnd = true;
        onAnimationEnd(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAnimationEnd,");
        sb.append(this.mLottieSource);
        GriverLogger.d(TAG, sb.toString());
        this.hasEnd = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAnimationCancel,");
        sb.append(this.mLottieSource);
        GriverLogger.d(TAG, sb.toString());
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        ICorePlayer iCorePlayer = this.mICorePlayer;
        String valueOf = (iCorePlayer == null || iCorePlayer.getView() == null) ? "" : String.valueOf(this.mICorePlayer.getView().getLayerType());
        StringBuilder sb = new StringBuilder();
        sb.append("onAnimationRepeat,");
        sb.append(this.mLottieSource);
        sb.append(",layerType=");
        sb.append(valueOf);
        GriverLogger.d(TAG, sb.toString());
        LottieParams lottieParams = this.mParams;
        if (lottieParams != null && lottieParams.isAutoReverse()) {
            setSpeed(this.mParams.getSpeed() * (-1.0f));
        }
    }

    public void fillVariableValue(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("fillVariableValue ->");
        sb.append(map.toString());
        GriverLogger.d(TAG, sb.toString());
        OnFillVariableValueListener onFillVariableValueListener = this.mVariableFilledListener;
        if (onFillVariableValueListener != null) {
            onFillVariableValueListener.onFillVariableValue(map);
            return;
        }
        this.mParams.setLottieParams(map);
        prepareAssetsAndPlayController(this.mParams);
    }

    public void setLottieDataStatus(ILottieDataStatus iLottieDataStatus) {
        this.mILottieDataStatus = iLottieDataStatus;
    }

    private String getCurrentScene(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) ? SceneUtils.buildScene(str2, str3, str4) : str;
    }

    public String getCurrentScene() {
        LottieParams lottieParams = this.mParams;
        if (lottieParams == null) {
            return this.sceneForLog;
        }
        String currentScene = getCurrentScene(lottieParams.getScene(), this.mParams.getDjangoId(), this.mParams.getPath(), this.mParams.getAssetsAnimationPath());
        this.sceneForLog = currentScene;
        return currentScene;
    }

    public String getSource() {
        return this.mSource;
    }

    public void setCanvasRenderScene(String str) {
        this.canvasRenderScene = str;
    }

    public String getCanvasRenderScene() {
        return this.canvasRenderScene;
    }

    public Bitmap getSnapshot() {
        ICorePlayer iCorePlayer = this.mICorePlayer;
        if (iCorePlayer != null) {
            try {
                return iCorePlayer.getSnapshot();
            } catch (Throwable th) {
                GriverLogger.e(TAG, "getSnapshot,截屏出错：", th);
                return null;
            }
        }
        return null;
    }

    @Override // com.alibaba.griver.beehive.lottie.util.TouchDetector.Callback
    public void onClick(View view, MotionEvent motionEvent) {
        if (this.mPlaceholder.getVisibility() == 0 || this.hasDowngradeToPlaceholder) {
            handlePlaceHolderClickEvent(motionEvent);
            return;
        }
        ICorePlayer iCorePlayer = this.mICorePlayer;
        if (iCorePlayer == null || !(iCorePlayer instanceof LottieCore)) {
            return;
        }
        String hitTestDynamicLayerInView = ((LottieCore) iCorePlayer).hitTestDynamicLayerInView(motionEvent.getX(), motionEvent.getY());
        if (TextUtils.isEmpty(hitTestDynamicLayerInView)) {
            DispatchEventListener dispatchEventListener = this.dispatchEventListener;
            if (dispatchEventListener != null) {
                dispatchEventListener.dispatchEvent("", "");
                return;
            }
            return;
        }
        DynamicLayerModel dynamicLayerModelByLayerid = CommonUtils.getDynamicLayerModelByLayerid(this.mParams.getDynamicLayerModelList(), hitTestDynamicLayerInView);
        if (dynamicLayerModelByLayerid != null && dynamicLayerModelByLayerid.dynamicLayerAction != null) {
            if (dynamicLayerModelByLayerid.dynamicLayerAction.clickable) {
                DispatchEventListener dispatchEventListener2 = this.dispatchEventListener;
                if (dispatchEventListener2 == null || dispatchEventListener2.dispatchEvent(dynamicLayerModelByLayerid.layerId, dynamicLayerModelByLayerid.dynamicLayerAction.actionUrl)) {
                    return;
                }
                H5UtilsAdapter.openUrl(dynamicLayerModelByLayerid.dynamicLayerAction.actionUrl);
                return;
            }
            DispatchEventListener dispatchEventListener3 = this.dispatchEventListener;
            if (dispatchEventListener3 != null) {
                dispatchEventListener3.dispatchEvent(dynamicLayerModelByLayerid.layerId, "");
                return;
            }
            return;
        }
        DispatchEventListener dispatchEventListener4 = this.dispatchEventListener;
        if (dispatchEventListener4 != null) {
            dispatchEventListener4.dispatchEvent("", "");
        }
    }

    public void setOnFillVariableValueListener(OnFillVariableValueListener onFillVariableValueListener) {
        this.mVariableFilledListener = onFillVariableValueListener;
    }

    public String getLottieSource() {
        return this.mLottieSource;
    }

    public long getLatestParamsTimestamp() {
        return this.mLatestParamsTimestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyParamsAndInitView(LottieParams lottieParams) {
        File lottieUnzipDir;
        if (lottieParams == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("applyParams: params is null.");
            sb.append(this.mLottieSource);
            processError(sb.toString());
        } else if (this.hasDowngradeToPlaceholder) {
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("applyParams ->");
            sb2.append(lottieParams.toString());
            GriverLogger.d(TAG, sb2.toString());
            this.mParams = lottieParams;
            if (!TextUtils.isEmpty(lottieParams.getRenderType())) {
                this.currentRenderType = this.mParams.getRenderType();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.mParams.getDjangoId());
            sb3.append(AUScreenAdaptTool.PREFIX_ID);
            sb3.append(this.mSource);
            sb3.append(AUScreenAdaptTool.PREFIX_ID);
            sb3.append(this);
            sb3.append(AUScreenAdaptTool.PREFIX_ID);
            sb3.append(this.mContext);
            this.mLottieSource = sb3.toString();
            String resourceId = this.mParams.getResourceId();
            if (this.threadOrderKey == null) {
                this.threadOrderKey = resourceId;
            }
            this.downgradeRuler.setPlaceHolder(this.mParams.getDowngrade()).setDowngradeLevel(this.mParams.getDowngradeLevel()).setOptimize(this.mParams.isOptimize()).setLottieDjangoId(this.mParams.getDjangoId()).setLottiePath(this.mParams.getPath()).setScene(this.mParams.getScene()).setAssetsAnimationPath(this.mParams.getAssetsAnimationPath());
            boolean downgradeToPlaceholder = this.downgradeRuler.downgradeToPlaceholder();
            this.isDowngrade = downgradeToPlaceholder;
            if (downgradeToPlaceholder && !TextUtils.isEmpty(this.mParams.getDjangoId()) && TextUtils.isEmpty(this.mParams.getDowngrade()) && ((lottieUnzipDir = DownloadFileUtils.getLottieUnzipDir(this.mParams.getDjangoId())) == null || !lottieUnzipDir.exists())) {
                LottieHelper.getResourceFromDjangoIdForLottieZip(this.mParams.getDjangoId(), this.mParams.getMd5(), null, new DownloadFileUtils.WrapResponseListener() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.42
                    @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
                    public void onSuccess(InputStream inputStream, String str) throws Exception {
                        if (LottiePlayer.this.mParams.canDowngrade()) {
                            LottiePlayer.this.downgrade();
                        } else if (LottiePlayer.this.mParams.canDowngrade()) {
                        } else {
                            LottiePlayer.this.processError("兜底图为空，降级失败.");
                        }
                    }

                    @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
                    public void onError(String str) {
                        LottiePlayer.this.processError("Lottie资源下载失败，降级失败.");
                    }
                }, this.mSource);
                return;
            }
            if (this.loadPlaceholderFirst && !this.hasLoadPlaceholder) {
                this.hasLoadPlaceholder = true;
                preparePlaceHolder(this.mParams.getPlaceholder(), false, true, null);
            }
            if (this.isDowngrade && this.mParams.canDowngrade()) {
                downgrade();
            } else if (this.isDowngrade && !this.mParams.canDowngrade()) {
                processError("兜底图为空，降级失败.");
            } else if (!TextUtils.isEmpty(this.mParams.getLottieJson())) {
                parseAssetsFromParams();
            } else {
                String path = this.mParams.getPath();
                if (TextUtils.isEmpty(path)) {
                    String djangoId = this.mParams.getDjangoId();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("applyParams: path is empty.");
                    sb4.append(this.mLottieSource);
                    GriverLogger.d(TAG, sb4.toString());
                    if (TextUtils.isEmpty(djangoId)) {
                        String assetsAnimationPath = this.mParams.getAssetsAnimationPath();
                        if (TextUtils.isEmpty(assetsAnimationPath)) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("applyParams: djangoId & assetsAnimationPath is empty.");
                            sb5.append(this.mLottieSource);
                            GriverLogger.e(TAG, sb5.toString());
                            processError("参数错误:DjangoId & AssetsAnimationPath都为空");
                            return;
                        }
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(assetsAnimationPath);
                        sb6.append(AUScreenAdaptTool.PREFIX_ID);
                        sb6.append(this.mSource);
                        sb6.append(AUScreenAdaptTool.PREFIX_ID);
                        sb6.append(this);
                        sb6.append(AUScreenAdaptTool.PREFIX_ID);
                        sb6.append(this.mContext);
                        this.mLottieSource = sb6.toString();
                        parseFromAssets(assetsAnimationPath, this.mParams.getRenderType());
                        return;
                    }
                    parseAssetsFromDjangoId(djangoId, this.mParams.getRenderType(), this.mParams.getMd5());
                    return;
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append(path);
                sb7.append(AUScreenAdaptTool.PREFIX_ID);
                sb7.append(this.mSource);
                sb7.append(AUScreenAdaptTool.PREFIX_ID);
                sb7.append(this);
                sb7.append(AUScreenAdaptTool.PREFIX_ID);
                sb7.append(this.mContext);
                this.mLottieSource = sb7.toString();
                parseLottieFromUrl(path);
            }
        }
    }

    private void parseFromAssets(String str, String str2) {
        String str3;
        if (!str.endsWith(".json")) {
            if (str.endsWith("/")) {
                str3 = str;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("/");
                str3 = sb.toString();
            }
            try {
                String str4 = null;
                for (String str5 : LottieHelper.listAssetsDir(this.mContext, str)) {
                    if (str5.endsWith(".json")) {
                        if (LottieConstants.RENDER_TYPE_ANTMATIONS.equals(str2)) {
                            if ("antmation.json".equals(str5)) {
                                str4 = str5;
                                break;
                            }
                            str4 = str5;
                        } else if (LottieConstants.RENDER_TYPE_MARS.equals(str2)) {
                            if ("mars.json".equals(str5)) {
                                str4 = str5;
                                break;
                            }
                            str4 = str5;
                        } else {
                            if (!"antmation.json".equals(str5) && !"mars.json".equals(str5)) {
                                str4 = str5;
                                break;
                            }
                            str4 = str5;
                        }
                    }
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str3);
                sb2.append(str4);
                str = sb2.toString();
            } catch (IOException e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("assets操作异常：");
                sb3.append(e);
                processError(sb3.toString());
                return;
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("file:///[asset]/");
        sb4.append(str);
        getResourceWithUrl(sb4.toString(), new DownloadFileUtils.WrapResponseListener() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.43
            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public void onSuccess(InputStream inputStream, String str6) throws Exception {
                LottiePlayer.this.parseParams(inputStream);
            }

            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public void onError(String str6) {
                LottiePlayer lottiePlayer = LottiePlayer.this;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("parseFromAssets failed:");
                sb5.append(str6);
                lottiePlayer.processError(sb5.toString());
            }
        }, this.mContext, this.mSource);
    }

    private void parseAssetsFromParams() {
        if (this.mParams.isVariableLottie()) {
            StringBuilder sb = new StringBuilder();
            sb.append("this is variable lottie,");
            sb.append(this.mLottieSource);
            GriverLogger.d(TAG, sb.toString());
            if (this.mParams.getLottieParams() == null) {
                fireOnDataLoadReady();
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("variable param is set , send dataReady event...");
            sb2.append(this.mLottieSource);
            GriverLogger.d(TAG, sb2.toString());
            prepareAssetsAndPlayController(this.mParams);
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("this is not variable lottie,");
        sb3.append(this.mLottieSource);
        GriverLogger.d(TAG, sb3.toString());
        prepareAssetsAndPlayController(this.mParams);
    }

    protected void fireOnDataLoadReady() {
        MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.44
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb = new StringBuilder();
                sb.append("variable param is not set , send dataLoadReady event...");
                sb.append(LottiePlayer.this.mLottieSource);
                GriverLogger.d(LottiePlayer.TAG, sb.toString());
                if (LottiePlayer.this.mILottieDataStatus != null) {
                    LottiePlayer.this.mILottieDataStatus.onDataLoadReady();
                }
            }
        });
    }

    private void parseAssetsFromDjangoId(final String str, String str2, String str3) {
        LottieHelper.getResourceFromDjangoIdForLottieZip(str, str3, str2, new DownloadFileUtils.WrapResponseListener() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.45
            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public void onSuccess(InputStream inputStream, String str4) throws Exception {
                LottiePlayer.this.mParams.setLottieFile(DownloadFileUtils.getLottieUnzipDir(str));
                LottiePlayer.this.parseParams(inputStream);
            }

            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public void onError(String str4) {
                LottiePlayer lottiePlayer = LottiePlayer.this;
                StringBuilder sb = new StringBuilder();
                sb.append("parseLottieFromDjangoId failed:");
                sb.append(str4);
                lottiePlayer.processError(sb.toString());
            }
        }, this.mSource);
    }

    private void parseLottieFromUrl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("parseLottieFromUrl : ");
        sb.append(str);
        sb.append(",");
        sb.append(this.mLottieSource);
        GriverLogger.d(TAG, sb.toString());
        getResourceWithUrl(str, new DownloadFileUtils.WrapResponseListener() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.46
            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public void onSuccess(InputStream inputStream, String str2) throws Exception {
                LottiePlayer.this.parseParams(inputStream);
            }

            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public void onError(String str2) {
                LottiePlayer lottiePlayer = LottiePlayer.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("parseLottieFromUrl failed:");
                sb2.append(str2);
                lottiePlayer.processError(sb2.toString());
            }
        }, this.mContext, this.mSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseParams(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("parseLottieFromUrl.");
        sb.append(this.mLottieSource);
        GriverLogger.d(TAG, sb.toString());
        byte[] bArr = new byte[inputStream.available()];
        inputStream.read(bArr);
        String str = new String(bArr);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        sb2.append(this.mParams.getElementId());
        sb2.append("] origin json -> ");
        sb2.append(str);
        GriverLogger.d(TAG, sb2.toString());
        this.mParams.setLottieJson(str);
        parseAssetsFromParams();
    }

    void prepareAssetsAndPlayController(final LottieParams lottieParams) {
        StringBuilder sb = new StringBuilder();
        sb.append("preview,");
        sb.append(lottieParams.getPreviewSchema());
        GriverLogger.d(TAG, sb.toString());
        if (SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("BeeLottiePlayer_Report_Lottie_ENABLE"))) {
            HashMap hashMap = new HashMap(3);
            hashMap.put("path", lottieParams.getPath());
            hashMap.put(LottieParams.KEY_DJANGO_ID, SceneUtils.getResourceId(lottieParams.getDjangoId(), null, lottieParams.getAssetsAnimationPath()));
            StringBuilder sb2 = new StringBuilder();
            if (lottieParams.getLottieParams() != null && !lottieParams.getLottieParams().isEmpty()) {
                for (Map.Entry<String, String> entry : lottieParams.getLottieParams().entrySet()) {
                    sb2.append(entry.getKey());
                    sb2.append("=");
                    sb2.append(URLEncoder.encode(String.valueOf(entry.getValue())));
                }
            }
            hashMap.put(LottieParams.KEY_VARIABLE_MAP, sb2.toString());
        }
        MultiThreadUtils.runOnBackgroundThreadOrder(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.47
            @Override // java.lang.Runnable
            public void run() {
                GriverLogger.d(LottiePlayer.TAG, "preview,prepareAssetsAndPlayControllerSyncByJsonReader");
                LottiePlayer.this.prepareAssetsAndPlayControllerSyncByJsonReader(lottieParams);
            }
        }, getThreadOrderKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0125, code lost:
    
        if (com.alibaba.griver.beehive.lottie.constants.LottieConstants.RENDER_TYPE_MARS.equals(r10.getRenderType()) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x016e, code lost:
    
        if (r10.getPath().endsWith("mars.json") != false) goto L90;
     */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0393 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:330:0x038f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void prepareAssetsAndPlayControllerSyncByJsonReader(com.alibaba.griver.beehive.lottie.player.LottieParams r33) {
        /*
            Method dump skipped, instructions count: 1802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.player.LottiePlayer.prepareAssetsAndPlayControllerSyncByJsonReader(com.alibaba.griver.beehive.lottie.player.LottieParams):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        if (com.alibaba.griver.beehive.lottie.constants.LottieConstants.RENDER_TYPE_SKOTTIE.equals(getGraySwitchRenderType(r4)) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        if (com.alibaba.griver.beehive.lottie.constants.LottieConstants.RENDER_TYPE_SKOTTIE.equals(r10) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0070, code lost:
    
        if (com.alibaba.griver.beehive.lottie.constants.LottieConstants.RENDER_TYPE_SKOTTIE.equals(r10) == false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getRenderType(com.alibaba.griver.beehive.lottie.player.LottieParams r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, java.lang.String r10) {
        /*
            r3 = this;
            java.lang.String r0 = "mars"
            java.lang.String r1 = "antmation"
            java.lang.String r2 = "skottie"
            if (r5 == 0) goto L2f
            if (r7 != 0) goto L2f
            if (r9 != 0) goto L2f
            java.lang.String r5 = r4.getRenderType()
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L18
            r10 = r5
        L18:
            boolean r5 = android.text.TextUtils.isEmpty(r10)
            if (r5 == 0) goto L28
            java.lang.String r4 = r3.getGraySwitchRenderType(r4)
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L73
        L28:
            boolean r4 = r2.equals(r10)
            if (r4 == 0) goto L77
            goto L73
        L2f:
            if (r5 != 0) goto L36
            if (r6 != 0) goto L75
            if (r7 == 0) goto L36
            goto L75
        L36:
            if (r5 != 0) goto L3d
            if (r8 != 0) goto L79
            if (r9 == 0) goto L3d
            goto L79
        L3d:
            if (r5 == 0) goto L41
            if (r7 != 0) goto L45
        L41:
            if (r5 == 0) goto L77
            if (r9 == 0) goto L77
        L45:
            java.lang.String r5 = r4.getRenderType()
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L50
            r10 = r5
        L50:
            boolean r5 = android.text.TextUtils.isEmpty(r10)
            if (r5 == 0) goto L60
            java.lang.String r4 = r3.getGraySwitchRenderType(r4)
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L73
        L60:
            boolean r4 = r1.equals(r10)
            if (r4 != 0) goto L75
            boolean r4 = r0.equals(r10)
            if (r4 != 0) goto L79
            boolean r4 = r2.equals(r10)
            if (r4 != 0) goto L73
            goto L77
        L73:
            r0 = r2
            goto L79
        L75:
            r0 = r1
            goto L79
        L77:
            java.lang.String r0 = "lottie"
        L79:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.player.LottiePlayer.getRenderType(com.alibaba.griver.beehive.lottie.player.LottieParams, boolean, boolean, boolean, boolean, boolean, java.lang.String):java.lang.String");
    }

    private String getGraySwitchRenderType(LottieParams lottieParams) {
        String resourceId = lottieParams.getResourceId();
        String grayRenderType = GrayHelper.getGrayRenderType(resourceId);
        StringBuilder sb = new StringBuilder();
        sb.append("resourceId=");
        sb.append(resourceId);
        sb.append(",grayRenderType=");
        sb.append(grayRenderType);
        GriverLogger.d(TAG, sb.toString());
        return grayRenderType;
    }

    public void preparePlaceHolder(String str, boolean z) {
        preparePlaceHolder(str, z, false, null);
    }

    public void preparePlaceHolder(final String str, final boolean z, final boolean z2, final Runnable runnable) {
        StringBuilder sb = new StringBuilder();
        sb.append("setPlaceHolder: url=");
        sb.append(str);
        sb.append(",");
        sb.append(this.mSource);
        GriverLogger.d(TAG, sb.toString());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hasLoadPlaceholder = true;
        this.mPlaceholder.setTag(TAG_PLACEHOLDER_KEY, str);
        MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.52
            @Override // java.lang.Runnable
            public void run() {
                LottiePlayer.this.mPlaceholder.setVisibility(0);
            }
        });
        getResourceWithUrl(str, new DownloadFileUtils.WrapResponseListener() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.53
            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public void onSuccess(InputStream inputStream, String str2) throws Exception {
                Runnable runnable2;
                Runnable runnable3;
                Runnable runnable4;
                Runnable runnable5;
                boolean z3;
                try {
                    boolean z4 = z;
                    if (z4) {
                        LottiePlayer.this.fireOnDataReady(z4);
                    }
                    if (LottiePlayer.this.placeHolderSuccess && z2 && LottiePlayer.this.hasLoadDowngrade) {
                        GriverLogger.w(LottiePlayer.TAG, "已经加载降级图，忽略placeHolder");
                        if (!z3 || runnable2 == null) {
                            return;
                        }
                        return;
                    }
                    if ((!TextUtils.isEmpty(str2) && str2.startsWith("file:///[asset]/") && str2.endsWith(Format.SUFFIX_GIF)) ? true : !TextUtils.isEmpty(str2) ? MultimediaServiceAdapter.isAnimationFile(str2) : false) {
                        LottiePlayer.this.animationPlaceHolderFilePath = str2;
                        LottiePlayer.this.startPlaceHolderAnimation();
                        try {
                            APImageInfoAdapter parseImageInfo = MultimediaServiceAdapter.parseImageInfo(str2);
                            if (parseImageInfo != null) {
                                LottiePlayer.this.placeHolderRect = new Rect(0, 0, parseImageInfo.width, parseImageInfo.height);
                            }
                        } catch (Exception e) {
                            GriverLogger.e(LottiePlayer.TAG, "解释图片宽高异常：", e);
                        }
                        LottiePlayer.this.placeHolderSuccess = true;
                        if (!LottiePlayer.this.placeHolderSuccess || (runnable5 = runnable) == null) {
                            return;
                        }
                        MultiThreadUtils.runOnUiThread(runnable5);
                        return;
                    }
                    APDecodeResultAdapter decodeBitmap = MultimediaServiceAdapter.decodeBitmap(inputStream);
                    final Bitmap bitmap = decodeBitmap.isSuccess() ? decodeBitmap.bitmap : null;
                    if (bitmap == null) {
                        GriverLogger.e(LottiePlayer.TAG, "setPlaceHolder -> onGetResponse: decode bitmap failed.");
                        if (!LottiePlayer.this.placeHolderSuccess || (runnable4 = runnable) == null) {
                            return;
                        }
                        MultiThreadUtils.runOnUiThread(runnable4);
                        return;
                    }
                    LottiePlayer.this.placeHolderSuccess = true;
                    LottiePlayer.this.placeHolderRect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                    MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.53.1
                        @Override // java.lang.Runnable
                        public void run() {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("preparePlaceHolder,success:");
                            sb2.append(bitmap);
                            GriverLogger.d(LottiePlayer.TAG, sb2.toString());
                            LottiePlayer.this.mPlaceholder.setImageBitmap(bitmap);
                            LottiePlayer.this.mPlaceholder.postInvalidate();
                        }
                    });
                    if (LottiePlayer.this.needMemCacahe && !TextUtils.equals(SummaryActivity.CHECKED, SwitchConfigUtilsAdapter.getConfigValue("placeholder_memory_cache_disable"))) {
                        MultimediaServiceAdapter.doSaveCacheBitmap(bitmap, str, "MULTI_MEDIA_BIZ_TYPE");
                    }
                    if (!LottiePlayer.this.placeHolderSuccess || (runnable3 = runnable) == null) {
                        return;
                    }
                    MultiThreadUtils.runOnUiThread(runnable3);
                } finally {
                    if (LottiePlayer.this.placeHolderSuccess && (runnable2 = runnable) != null) {
                        MultiThreadUtils.runOnUiThread(runnable2);
                    }
                }
            }

            @Override // com.alibaba.griver.beehive.lottie.util.DownloadFileUtils.WrapResponseListener
            public void onError(String str2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("preparePlaceHolder error -> ");
                sb2.append(str2);
                sb2.append(",isDowngrade=");
                sb2.append(z);
                GriverLogger.e(LottiePlayer.TAG, sb2.toString());
                if (LottiePlayer.this.mParams != null) {
                    String localPlaceHolderFilePath = z2 ? LottieHelper.getLocalPlaceHolderFilePath(LottiePlayer.this.mParams.getDjangoId()) : LottieHelper.getLocalDowngradeFilePath(LottiePlayer.this.mParams.getDjangoId());
                    if (!TextUtils.isEmpty(localPlaceHolderFilePath) && !localPlaceHolderFilePath.equals(str)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("preparePlaceHolder error -> localDowngradeFile=");
                        sb3.append(localPlaceHolderFilePath);
                        GriverLogger.e(LottiePlayer.TAG, sb3.toString());
                        LottiePlayer.this.preparePlaceHolder(localPlaceHolderFilePath, z, z2, null);
                        return;
                    }
                }
                if (z) {
                    LottiePlayer.this.mFailedMessage = str2;
                    LottiePlayer.this.fireOnDataFailed();
                }
            }
        }, this.mContext, this.mSource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnDataReady(final boolean z) {
        this.lottieSuccess = true;
        MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.54
            @Override // java.lang.Runnable
            public void run() {
                if (LottiePlayer.this.mILottieDataStatus == null || !LottiePlayer.this.mIsLoadSuccess) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("isDowngrade=");
                sb.append(z);
                sb.append(",onDataReady ");
                sb.append(LottiePlayer.this.mLottieSource);
                GriverLogger.d(LottiePlayer.TAG, sb.toString());
                LottiePlayer.this.mILottieDataStatus.onDataReady();
            }
        });
    }

    public void processError(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Lottie处理出错了：");
        sb.append(str);
        sb.append(",");
        sb.append(this.mLottieSource);
        GriverLogger.e(TAG, sb.toString());
        this.mIsLoadSuccess = false;
        this.mFailedMessage = str;
        MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.55
            @Override // java.lang.Runnable
            public void run() {
                LottiePlayer.this.downgradeToPlaceholder();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onDataFailed: ");
                sb2.append(LottiePlayer.this.mFailedMessage);
                sb2.append(", ");
                sb2.append(LottiePlayer.this.mLottieSource);
                GriverLogger.e(LottiePlayer.TAG, sb2.toString());
                LottiePlayer.this.trace("createFail");
                LottiePlayer.this.fireOnDataFailed();
            }
        });
    }

    public JSONObject getLottieInfo() {
        if (this.mParams != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("w", (Object) Integer.valueOf(this.w));
            jSONObject.put("h", (Object) Integer.valueOf(this.h));
            jSONObject.put("fr", (Object) Integer.valueOf(this.fr));
            jSONObject.put(LottieParams.KEY_RENDER_TYPE, (Object) this.currentRenderType);
            return jSONObject;
        }
        return null;
    }

    public void setLoadPlaceholderFirst(boolean z) {
        this.loadPlaceholderFirst = z;
    }

    public ImageView getPlaceholder() {
        return this.mPlaceholder;
    }

    public boolean hasContent() {
        return this.placeHolderSuccess || this.lottieSuccess;
    }

    public Rect getPlaceHolderRect() {
        return this.placeHolderRect;
    }

    public void setScaleType(final ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return;
        }
        this.mPlaceholder.setScaleType(scaleType);
        if (!this.corePlayeHasInited) {
            addToTaskQueue(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.56
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.setScaleType(scaleType);
                }
            });
        } else if (this.mICorePlayer.getView() instanceof LottieAnimationView) {
            ((LottieAnimationView) this.mICorePlayer.getView()).setScaleType(scaleType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCorePlayerInitSuccess(final ICorePlayer iCorePlayer, final LottieParams lottieParams) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.57
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.onCorePlayerInitSuccess(iCorePlayer, lottieParams);
                }
            });
            return;
        }
        if ((lottieParams == null || TextUtils.isEmpty(lottieParams.getLottieJson())) && this.mIsLoadSuccess) {
            StringBuilder sb = new StringBuilder();
            sb.append("LottieJson参数为空：");
            sb.append(this.mLottieSource);
            GriverLogger.e(TAG, sb.toString());
            this.mFailedMessage = "lottieplayer_json_is_empty";
            HashMap hashMap = new HashMap(4);
            hashMap.put("biz_name", LottieConstants.RENDER_TYPE_LOTTIE);
            hashMap.put("sub_name", TAG);
            hashMap.put("fail_code", "empty_json");
            hashMap.put("fail_reason", "lottieplayer_json_is_empty");
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onCorePlayerInitSuccess,mIsLoadSuccess=");
        sb2.append(this.mIsLoadSuccess);
        sb2.append(",");
        sb2.append(getLottieSource());
        GriverLogger.d(TAG, sb2.toString());
        this.corePlayeHasInited = true;
        if (SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("Lottie_player_setPlayerParams_onMain"))) {
            setParamsForCoreplayer(iCorePlayer, lottieParams);
            onCorePlayerInitSuccessOnMain(lottieParams);
            return;
        }
        MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.58
            @Override // java.lang.Runnable
            public void run() {
                try {
                    LottiePlayer.this.setParamsForCoreplayer(iCorePlayer, lottieParams);
                    LottiePlayer.this.onCorePlayerInitSuccessOnMain(lottieParams);
                } catch (Exception unused) {
                    LottiePlayer.this.onCorePlayerInitSuccessOnMain(lottieParams);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParamsForCoreplayer(ICorePlayer iCorePlayer, LottieParams lottieParams) {
        int repeatCount = lottieParams.getRepeatCount();
        setSpeed(lottieParams.getSpeed());
        setRepeatCount(repeatCount);
        if (lottieParams.isAutoReverse()) {
            setRepeatCount((repeatCount * 2) + 1);
        }
        iCorePlayer.setPlayerParams(lottieParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCorePlayerInitSuccessOnMain(final LottieParams lottieParams) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.59
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.onCorePlayerInitSuccessOnMain(lottieParams);
                }
            });
            return;
        }
        executeTaskQueue();
        if (this.mIsLoadSuccess) {
            if (lottieParams.isAutoPlay()) {
                play();
            }
            if (this.mICorePlayer.getView().getParent() != null && this.mPlaceholder.getVisibility() != 8) {
                this.mPlaceholder.setVisibility(8);
                stopPlaceholderAnimation();
            }
            fireOnDataReady(false);
            return;
        }
        downgradeToPlaceholder();
        StringBuilder sb = new StringBuilder();
        sb.append("onDataFailed: ");
        sb.append(this.mFailedMessage);
        sb.append(", ");
        sb.append(this.mLottieSource);
        GriverLogger.e(TAG, sb.toString());
        trace("createFail");
        fireOnDataFailed();
    }

    private void executeTaskQueue() {
        if (this.taskListQueueWhenCorePlayNotInited.isEmpty()) {
            return;
        }
        try {
            for (Runnable runnable : new ArrayList(this.taskListQueueWhenCorePlayNotInited)) {
                StringBuilder sb = new StringBuilder();
                sb.append("ICorePlayer is inited,开始执行暂存任务:");
                sb.append(runnable);
                GriverLogger.d(TAG, sb.toString());
                runnable.run();
            }
            this.taskListQueueWhenCorePlayNotInited.clear();
        } catch (Exception e) {
            GriverLogger.e(TAG, "executeTaskQueue异常：", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCorePlayerInitFailed(final ICorePlayer iCorePlayer, final String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.60
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.onCorePlayerInitFailed(iCorePlayer, str);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onCorePlayerInitFailed：");
        sb.append(str);
        sb.append(",");
        sb.append(getLottieSource());
        GriverLogger.e(TAG, sb.toString());
        this.taskListQueueWhenCorePlayNotInited.clear();
        processError(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onRenderFailed(final ICorePlayer iCorePlayer, final String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.61
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.onRenderFailed(iCorePlayer, str);
                }
            });
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onRenderFailed:");
        sb.append(str);
        sb.append(",");
        sb.append(getLottieSource());
        GriverLogger.e(TAG, sb.toString());
        LottieParams lottieParams = this.mParams;
        if (lottieParams != null && lottieParams.canDowngrade()) {
            downgradeToPlaceholder();
        }
        IRenderFailedListener iRenderFailedListener = this.renderFailedListener;
        if (iRenderFailedListener != null) {
            iRenderFailedListener.onRenderFailed(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToTaskQueue(final Runnable runnable) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.player.LottiePlayer.62
                @Override // java.lang.Runnable
                public void run() {
                    LottiePlayer.this.addToTaskQueue(runnable);
                }
            });
        } else if (!this.hasLoadDowngrade || SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("Lottie_player_add_to_queue"))) {
            this.taskListQueueWhenCorePlayNotInited.add(runnable);
        } else {
            this.taskListQueueWhenCorePlayNotInited.clear();
        }
    }

    public void setRenderFailedListener(IRenderFailedListener iRenderFailedListener) {
        this.renderFailedListener = iRenderFailedListener;
    }

    void onFirstFrameRendered() {
        this.firstFrameRendered = true;
    }

    public void setFrameAnimationListener(FramePlayController.FrameAnimationListener frameAnimationListener) {
        this.frameAnimationListener = frameAnimationListener;
    }

    public BeeLotttieJSONModel getBeeLottieJSONModel() {
        return this.beeLotttieJSONModel;
    }

    public ICorePlayer getCorePlayer() {
        return this.mICorePlayer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getResourceWithUrl(String str, DownloadFileUtils.WrapResponseListener wrapResponseListener, Context context, String str2) {
        LottieHelper.getResourceWithUrl(str, wrapResponseListener, context, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getThreadOrderKey() {
        return SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("BeeLottiePlay_orderKey_opt_disable")) ? this : this.threadOrderKey;
    }

    public void setPlaceholderFromCache(String str) {
        Bitmap doLoadCacheBitmap;
        this.needMemCacahe = true;
        if (TextUtils.equals(SummaryActivity.CHECKED, SwitchConfigUtilsAdapter.getConfigValue("placeholder_memory_cache_disable")) || (doLoadCacheBitmap = MultimediaServiceAdapter.doLoadCacheBitmap(str)) == null) {
            return;
        }
        this.mPlaceholder.setVisibility(0);
        this.placeHolderSuccess = true;
        this.placeHolderRect = new Rect(0, 0, doLoadCacheBitmap.getWidth(), doLoadCacheBitmap.getHeight());
        StringBuilder sb = new StringBuilder();
        sb.append("preparePlaceHolder,success:");
        sb.append(doLoadCacheBitmap);
        GriverLogger.d(TAG, sb.toString());
        this.mPlaceholder.setImageBitmap(doLoadCacheBitmap);
        this.mPlaceholder.postInvalidate();
    }

    public void setDispatchEventListener(DispatchEventListener dispatchEventListener) {
        this.dispatchEventListener = dispatchEventListener;
    }

    public DispatchEventListener getDispatchEventListener() {
        return this.dispatchEventListener;
    }

    private void handlePlaceHolderClickEvent(MotionEvent motionEvent) {
        boolean z;
        DispatchEventListener dispatchEventListener;
        if (this.cacheClickPlaceholderZoneModelList.size() <= 0) {
            this.cacheClickPlaceholderZoneModelList = CommonUtils.getClickPlaceholdZoneModelList(this.mParams.getDynamicLayerModelList(), this.mPlaceholder);
        }
        if (this.cacheClickPlaceholderZoneModelList.size() > 0) {
            Iterator<PlaceholderZoneModel> it = this.cacheClickPlaceholderZoneModelList.iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    break;
                }
                PlaceholderZoneModel next = it.next();
                if (CommonUtils.pointInRect(motionEvent, next.getMapRect())) {
                    if (next != null && next.dynamicLayerAction != null) {
                        if (next.dynamicLayerAction.clickable) {
                            DispatchEventListener dispatchEventListener2 = this.dispatchEventListener;
                            if (dispatchEventListener2 != null && !dispatchEventListener2.dispatchEvent(next.layerId, next.dynamicLayerAction.actionUrl)) {
                                H5UtilsAdapter.openUrl(next.dynamicLayerAction.actionUrl);
                            }
                        } else {
                            DispatchEventListener dispatchEventListener3 = this.dispatchEventListener;
                            if (dispatchEventListener3 != null) {
                                dispatchEventListener3.dispatchEvent(next.layerId, "");
                            }
                        }
                        z = true;
                    }
                }
            }
            if (z || (dispatchEventListener = this.dispatchEventListener) == null) {
                return;
            }
            dispatchEventListener.dispatchEvent("", "");
            return;
        }
        DispatchEventListener dispatchEventListener4 = this.dispatchEventListener;
        if (dispatchEventListener4 != null) {
            dispatchEventListener4.dispatchEvent("", "");
        }
    }

    public void setLottieParam(LottieParams lottieParams) {
        if (lottieParams != null) {
            this.mParams = lottieParams;
            this.hasClickLayer = CommonUtils.getHasClickLayer(lottieParams.getDynamicLayerModelList());
        }
    }

    public String getUrlByLayerId(String str) {
        return CommonUtils.getUrlByLayerId(str, this.mParams.getDynamicLayerModelList());
    }
}
