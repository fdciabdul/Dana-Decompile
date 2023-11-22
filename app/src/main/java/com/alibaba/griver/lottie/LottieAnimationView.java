package com.alibaba.griver.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.adapter.impl.SwitchConfigUtilsAdapter;
import com.alibaba.griver.beehive.lottie.constants.LottieConstants;
import com.alibaba.griver.lottie.model.KeyPath;
import com.alibaba.griver.lottie.utils.Utils;
import com.alibaba.griver.lottie.value.LottieFrameInfo;
import com.alibaba.griver.lottie.value.LottieValueCallback;
import com.alibaba.griver.lottie.value.SimpleLottieValueCallback;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes6.dex */
public class LottieAnimationView extends ImageView {
    private static final String ASYNC_LOAD_CONFIG = "LottieAnimationView_ASYNC_LOAD";
    public static Executor EXECUTOR = AsyncTask.THREAD_POOL_EXECUTOR;
    private static final String TAG = "LottieAnimationView";
    private String animationName;
    private int animationResId;
    private boolean autoPlay;
    private int buildDrawingCacheDepth;
    private LottieComposition composition;
    private LottieTask<LottieComposition> compositionTask;
    private LottieListener<Throwable> errorListener;
    private final LottieListener<Throwable> failureListener;
    private final Handler handler;
    private boolean isInitialized;
    private final LottieListener<LottieComposition> loadedListener;
    private final LottieDrawable lottieDrawable;
    private String lottieJson;
    private Set<LottieOnCompositionLoadedListener> lottieOnCompositionLoadedListeners;
    private float progressWhenDetached;
    private RenderMode renderMode;
    private LottieListener<LottieComposition> successListener;
    private boolean wasAnimatingWhenDetached;
    private boolean wasAnimatingWhenNotShown;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.griver.lottie.LottieAnimationView$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass1 implements LottieListener<LottieComposition> {
        AnonymousClass1() {
        }

        @Override // com.alibaba.griver.lottie.LottieListener
        public void onResult(final LottieComposition lottieComposition) {
            if (SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue(LottieAnimationView.ASYNC_LOAD_CONFIG))) {
                GriverLogger.d(LottieAnimationView.TAG, "setComposition async");
                LottieAnimationView.EXECUTOR.execute(new Runnable() { // from class: com.alibaba.griver.lottie.LottieAnimationView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final boolean compositionAsync = LottieAnimationView.this.setCompositionAsync(lottieComposition);
                        LottieAnimationView.this.handler.post(new Runnable() { // from class: com.alibaba.griver.lottie.LottieAnimationView.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LottieAnimationView.this.afterSetCompositionAsync(compositionAsync);
                                if (LottieAnimationView.this.successListener != null) {
                                    LottieAnimationView.this.successListener.onResult(lottieComposition);
                                }
                            }
                        });
                    }
                });
                return;
            }
            GriverLogger.d(LottieAnimationView.TAG, "setComposition sync");
            LottieAnimationView.this.setComposition(lottieComposition);
            if (LottieAnimationView.this.successListener != null) {
                LottieAnimationView.this.successListener.onResult(lottieComposition);
            }
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.loadedListener = new AnonymousClass1();
        this.successListener = null;
        this.errorListener = null;
        this.failureListener = new LottieListener<Throwable>() { // from class: com.alibaba.griver.lottie.LottieAnimationView.2
            @Override // com.alibaba.griver.lottie.LottieListener
            public void onResult(Throwable th) {
                String str = LottieAnimationView.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("lottie动画解释出错,lottieJson=");
                sb.append(LottieAnimationView.this.lottieJson);
                GriverLogger.w(str, sb.toString());
                HashMap hashMap = new HashMap(4);
                hashMap.put("biz_name", LottieConstants.RENDER_TYPE_LOTTIE);
                hashMap.put("sub_name", LottieAnimationView.TAG);
                hashMap.put("fail_code", "parse_error");
                hashMap.put("fail_reason", th.getLocalizedMessage());
                GriverLogger.e(LottieAnimationView.TAG, "lottie动画解释出错：", th);
                if (LottieAnimationView.this.errorListener != null) {
                    LottieAnimationView.this.errorListener.onResult(th);
                }
            }
        };
        this.lottieDrawable = new LottieDrawable();
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.renderMode = RenderMode.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.buildDrawingCacheDepth = 0;
        this.progressWhenDetached = -1.0f;
        this.handler = new Handler(Looper.getMainLooper());
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loadedListener = new AnonymousClass1();
        this.successListener = null;
        this.errorListener = null;
        this.failureListener = new LottieListener<Throwable>() { // from class: com.alibaba.griver.lottie.LottieAnimationView.2
            @Override // com.alibaba.griver.lottie.LottieListener
            public void onResult(Throwable th) {
                String str = LottieAnimationView.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("lottie动画解释出错,lottieJson=");
                sb.append(LottieAnimationView.this.lottieJson);
                GriverLogger.w(str, sb.toString());
                HashMap hashMap = new HashMap(4);
                hashMap.put("biz_name", LottieConstants.RENDER_TYPE_LOTTIE);
                hashMap.put("sub_name", LottieAnimationView.TAG);
                hashMap.put("fail_code", "parse_error");
                hashMap.put("fail_reason", th.getLocalizedMessage());
                GriverLogger.e(LottieAnimationView.TAG, "lottie动画解释出错：", th);
                if (LottieAnimationView.this.errorListener != null) {
                    LottieAnimationView.this.errorListener.onResult(th);
                }
            }
        };
        this.lottieDrawable = new LottieDrawable();
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.renderMode = RenderMode.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.buildDrawingCacheDepth = 0;
        this.progressWhenDetached = -1.0f;
        this.handler = new Handler(Looper.getMainLooper());
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.loadedListener = new AnonymousClass1();
        this.successListener = null;
        this.errorListener = null;
        this.failureListener = new LottieListener<Throwable>() { // from class: com.alibaba.griver.lottie.LottieAnimationView.2
            @Override // com.alibaba.griver.lottie.LottieListener
            public void onResult(Throwable th) {
                String str = LottieAnimationView.TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("lottie动画解释出错,lottieJson=");
                sb.append(LottieAnimationView.this.lottieJson);
                GriverLogger.w(str, sb.toString());
                HashMap hashMap = new HashMap(4);
                hashMap.put("biz_name", LottieConstants.RENDER_TYPE_LOTTIE);
                hashMap.put("sub_name", LottieAnimationView.TAG);
                hashMap.put("fail_code", "parse_error");
                hashMap.put("fail_reason", th.getLocalizedMessage());
                GriverLogger.e(LottieAnimationView.TAG, "lottie动画解释出错：", th);
                if (LottieAnimationView.this.errorListener != null) {
                    LottieAnimationView.this.errorListener.onResult(th);
                }
            }
        };
        this.lottieDrawable = new LottieDrawable();
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.renderMode = RenderMode.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        this.buildDrawingCacheDepth = 0;
        this.progressWhenDetached = -1.0f;
        this.handler = new Handler(Looper.getMainLooper());
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        String string;
        Utils.setAnimatorsEnabled();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView);
        if (!isInEditMode()) {
            boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
            boolean hasValue3 = obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_url);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_fileName);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_url)) != null) {
                setAnimationFromUrl(string);
            }
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.wasAnimatingWhenDetached = true;
            this.autoPlay = true;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.lottieDrawable.setRepeatCount(-1);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        enableMergePathsForKitKatAndAbove(obtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            addValueCallback(new KeyPath("**"), (KeyPath) LottieProperty.COLOR_FILTER, (LottieValueCallback<KeyPath>) new LottieValueCallback(new SimpleColorFilter(obtainStyledAttributes.getColor(R.styleable.LottieAnimationView_lottie_colorFilter, 0))));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
            this.lottieDrawable.setScale(obtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_renderMode)) {
            int i = obtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_renderMode, RenderMode.AUTOMATIC.ordinal());
            if (i >= RenderMode.values().length) {
                i = RenderMode.AUTOMATIC.ordinal();
            }
            this.renderMode = RenderMode.values()[i];
        }
        obtainStyledAttributes.recycle();
        enableOrDisableHardwareLayer();
        this.isInitialized = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        cancelLoaderTask();
        super.setImageResource(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (drawable2 == lottieDrawable) {
            super.invalidateDrawable(lottieDrawable);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.animationName = this.animationName;
        savedState.animationResId = this.animationResId;
        savedState.progress = this.lottieDrawable.getProgress();
        savedState.isAnimating = this.lottieDrawable.isAnimating();
        savedState.imageAssetsFolder = this.lottieDrawable.getImageAssetsFolder();
        savedState.repeatMode = this.lottieDrawable.getRepeatMode();
        savedState.repeatCount = this.lottieDrawable.getRepeatCount();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.animationName;
        this.animationName = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.animationName);
        }
        int i = savedState.animationResId;
        this.animationResId = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.progress);
        if (savedState.isAnimating) {
            playAnimation();
        }
        this.lottieDrawable.setImagesAssetsFolder(savedState.imageAssetsFolder);
        setRepeatMode(savedState.repeatMode);
        setRepeatCount(savedState.repeatCount);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        if (this.isInitialized) {
            if (isShown()) {
                if (this.wasAnimatingWhenNotShown) {
                    resumeAnimation();
                    this.wasAnimatingWhenNotShown = false;
                }
            } else if (isAnimating()) {
                pauseAnimation();
                this.wasAnimatingWhenNotShown = true;
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay || this.wasAnimatingWhenDetached) {
            playAnimation();
            float f = this.progressWhenDetached;
            if (f > 0.0f) {
                setProgress(f);
                this.progressWhenDetached = -1.0f;
            }
            this.autoPlay = false;
            this.wasAnimatingWhenDetached = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            this.progressWhenDetached = getProgress();
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        super.onDetachedFromWindow();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.lottieDrawable.enableMergePathsForKitKatAndAbove(z);
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.isMergePathsEnabledForKitKatAndAbove();
    }

    public void setAnimation(int i) {
        this.animationResId = i;
        this.animationName = null;
        setCompositionTask(LottieCompositionFactory.fromRawRes(getContext(), i));
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(LottieCompositionFactory.fromAsset(getContext(), str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromJson(String str, String str2) {
        this.lottieJson = str;
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setAnimation(InputStream inputStream, String str) {
        setCompositionTask(LottieCompositionFactory.fromJsonInputStream(inputStream, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), str));
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = lottieTask.addListener(this.loadedListener).addFailureListener(this.failureListener);
    }

    private void cancelLoaderTask() {
        LottieTask<LottieComposition> lottieTask = this.compositionTask;
        if (lottieTask != null) {
            lottieTask.removeListener(this.loadedListener);
            this.compositionTask.removeFailureListener(this.failureListener);
        }
    }

    public void setComposition(LottieComposition lottieComposition) {
        if (L.DBG) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Set Composition \n");
            sb.append(lottieComposition);
            InstrumentInjector.log_v(str, sb.toString());
        }
        this.lottieDrawable.setCallback(this);
        this.composition = lottieComposition;
        try {
            boolean composition = this.lottieDrawable.setComposition(lottieComposition);
            this.lottieDrawable.afterSetComposition();
            enableOrDisableHardwareLayer();
            if (getDrawable() != this.lottieDrawable || composition) {
                setImageDrawable(null);
                setImageDrawable(this.lottieDrawable);
                onVisibilityChanged(this, getVisibility());
                requestLayout();
                Iterator<LottieOnCompositionLoadedListener> it = this.lottieOnCompositionLoadedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onCompositionLoaded(lottieComposition);
                }
            }
        } catch (Exception e) {
            GriverLogger.e(TAG, "lottie动画错误：节点位置错误:", e);
            this.composition = null;
            try {
                this.lottieDrawable.clearComposition();
            } catch (Exception unused) {
            }
            this.failureListener.onResult(e);
        }
    }

    public boolean setCompositionAsync(LottieComposition lottieComposition) {
        if (L.DBG) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Set Composition \n");
            sb.append(lottieComposition);
            InstrumentInjector.log_v(str, sb.toString());
        }
        this.lottieDrawable.setCallback(this);
        this.composition = lottieComposition;
        try {
            return this.lottieDrawable.setComposition(lottieComposition);
        } catch (Exception e) {
            GriverLogger.e(TAG, "lottie动画错误：节点位置错误:", e);
            this.composition = null;
            try {
                this.lottieDrawable.clearComposition();
            } catch (Exception unused) {
            }
            this.failureListener.onResult(e);
            return false;
        }
    }

    public void afterSetCompositionAsync(boolean z) {
        this.lottieDrawable.afterSetComposition();
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.lottieDrawable || z) {
            setImageDrawable(null);
            setImageDrawable(this.lottieDrawable);
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<LottieOnCompositionLoadedListener> it = this.lottieOnCompositionLoadedListeners.iterator();
            while (it.hasNext()) {
                it.next().onCompositionLoaded(this.composition);
            }
        }
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public boolean hasMasks() {
        return this.lottieDrawable.hasMasks();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.hasMatte();
    }

    public void playAnimation() {
        StringBuilder sb = new StringBuilder();
        sb.append("playAnimation()  isShown=");
        sb.append(isShown());
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(this);
        InstrumentInjector.log_i(TAG, sb.toString());
        if (isShown()) {
            this.lottieDrawable.playAnimation();
            enableOrDisableHardwareLayer();
            return;
        }
        this.wasAnimatingWhenNotShown = true;
    }

    public void resumeAnimation() {
        StringBuilder sb = new StringBuilder();
        sb.append("resumeAnimation()  isShown=");
        sb.append(isShown());
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(this);
        InstrumentInjector.log_i(TAG, sb.toString());
        if (isShown()) {
            this.lottieDrawable.resumeAnimation();
            enableOrDisableHardwareLayer();
            return;
        }
        this.wasAnimatingWhenNotShown = true;
    }

    public void setMinFrame(int i) {
        this.lottieDrawable.setMinFrame(i);
    }

    public float getMinFrame() {
        return this.lottieDrawable.getMinFrame();
    }

    public void setMinProgress(float f) {
        this.lottieDrawable.setMinProgress(f);
    }

    public void setMaxFrame(int i) {
        this.lottieDrawable.setMaxFrame(i);
    }

    public float getMaxFrame() {
        return this.lottieDrawable.getMaxFrame();
    }

    public void setMaxProgress(float f) {
        this.lottieDrawable.setMaxProgress(f);
    }

    public void setMinFrame(String str) {
        this.lottieDrawable.setMinFrame(str);
    }

    public void setMaxFrame(String str) {
        this.lottieDrawable.setMaxFrame(str);
    }

    public void setMinAndMaxFrame(String str) {
        this.lottieDrawable.setMinAndMaxFrame(str);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.lottieDrawable.setMinAndMaxFrame(i, i2);
    }

    public void setMinAndMaxProgress(float f, float f2) {
        this.lottieDrawable.setMinAndMaxProgress(f, f2);
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.lottieDrawable.setSpeed(f);
    }

    public float getSpeed() {
        return this.lottieDrawable.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.removeAnimatorUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.addAnimatorListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.removeAnimatorListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.removeAllAnimatorListeners();
    }

    @Deprecated
    public void loop(boolean z) {
        this.lottieDrawable.setRepeatCount(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.lottieDrawable.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.lottieDrawable.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.lottieDrawable.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.lottieDrawable.getRepeatCount();
    }

    public boolean isLooping() {
        return this.lottieDrawable.isLooping();
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.setImagesAssetsFolder(str);
    }

    public String getImageAssetsFolder() {
        return this.lottieDrawable.getImageAssetsFolder();
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        return this.lottieDrawable.updateBitmap(str, bitmap);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.lottieDrawable.setImageAssetDelegate(imageAssetDelegate);
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.lottieDrawable.setFontAssetDelegate(fontAssetDelegate);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.lottieDrawable.setTextDelegate(textDelegate);
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        return this.lottieDrawable.resolveKeyPath(keyPath);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, (KeyPath) t, (LottieValueCallback<KeyPath>) lottieValueCallback);
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, final SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, (KeyPath) t, (LottieValueCallback<KeyPath>) new LottieValueCallback<T>() { // from class: com.alibaba.griver.lottie.LottieAnimationView.3
            @Override // com.alibaba.griver.lottie.value.LottieValueCallback
            public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
                return (T) simpleLottieValueCallback.getValue(lottieFrameInfo);
            }
        });
    }

    public void setScale(float f) {
        this.lottieDrawable.setScale(f);
        if (getDrawable() == this.lottieDrawable) {
            setImageDrawable(null);
            setImageDrawable(this.lottieDrawable);
        }
    }

    public float getScale() {
        return this.lottieDrawable.getScale();
    }

    public void cancelAnimation() {
        StringBuilder sb = new StringBuilder();
        sb.append("cancelAnimation() @");
        sb.append(this);
        InstrumentInjector.log_i(TAG, sb.toString());
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.lottieDrawable.cancelAnimation();
        enableOrDisableHardwareLayer();
    }

    public void pauseAnimation() {
        StringBuilder sb = new StringBuilder();
        sb.append("pauseAnimation() @");
        sb.append(this);
        InstrumentInjector.log_i(TAG, sb.toString());
        this.autoPlay = false;
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.lottieDrawable.pauseAnimation();
        enableOrDisableHardwareLayer();
    }

    public void setFrame(int i) {
        this.lottieDrawable.setFrame(i);
    }

    public int getFrame() {
        return this.lottieDrawable.getFrame();
    }

    public void setProgress(float f) {
        this.lottieDrawable.setProgress(f);
    }

    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public long getDuration() {
        if (this.composition != null) {
            return r0.getDuration();
        }
        return 0L;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lottieDrawable.setPerformanceTrackingEnabled(z);
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.lottieDrawable.getPerformanceTracker();
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.clearComposition();
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        this.buildDrawingCacheDepth++;
        super.buildDrawingCache(z);
        if (this.buildDrawingCacheDepth == 1 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.buildDrawingCacheDepth--;
    }

    public void setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
        enableOrDisableHardwareLayer();
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bb, code lost:
    
        if (r3 != 0) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void enableOrDisableHardwareLayer() {
        /*
            r7 = this;
            com.alibaba.griver.lottie.RenderMode r0 = r7.renderMode
            com.alibaba.griver.lottie.RenderMode r1 = com.alibaba.griver.lottie.RenderMode.SOFTWARE
            r2 = 0
            r3 = 0
            if (r0 == r1) goto L7d
            com.alibaba.griver.lottie.RenderMode r0 = r7.renderMode
            com.alibaba.griver.lottie.RenderMode r1 = com.alibaba.griver.lottie.RenderMode.FORCE_HARDWARE
            if (r0 == r1) goto L7d
            com.alibaba.griver.lottie.utils.SharedPreferenceUtil r0 = com.alibaba.griver.lottie.utils.SharedPreferenceUtil.getInstance()
            android.content.Context r1 = r7.getContext()
            android.content.SharedPreferences r0 = r0.getDefaultSharedPreference(r1)
            java.lang.String r1 = "LottieAnimationView_to_LAYER_TYPE_SOFTWARE"
            boolean r4 = r0.contains(r1)
            if (r4 == 0) goto L33
            boolean r0 = r0.getBoolean(r1, r3)     // Catch: java.lang.Exception -> L2b
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Exception -> L2b
            goto L34
        L2b:
            r0 = move-exception
            java.lang.String r1 = com.alibaba.griver.lottie.LottieAnimationView.TAG
            java.lang.String r4 = "LottieAnimationView_to_LAYER_TYPE_SOFTWARE开关读取异常："
            com.alibaba.griver.base.common.logger.GriverLogger.e(r1, r4, r0)
        L33:
            r0 = r2
        L34:
            java.lang.String r1 = com.alibaba.griver.lottie.LottieAnimationView.TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "downGradeToSoftware="
            r4.append(r5)
            r4.append(r0)
            java.lang.String r5 = ",SDK_INT="
            r4.append(r5)
            int r5 = android.os.Build.VERSION.SDK_INT
            r4.append(r5)
            java.lang.String r5 = ",currentRenderMode="
            r4.append(r5)
            com.alibaba.griver.lottie.RenderMode r5 = r7.renderMode
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.alibaba.griver.base.common.logger.GriverLogger.d(r1, r4)
            java.lang.String r1 = "true"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L79
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L7d
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 == r1) goto L79
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 25
            if (r0 != r1) goto L7d
        L79:
            com.alibaba.griver.lottie.RenderMode r0 = com.alibaba.griver.lottie.RenderMode.SOFTWARE
            r7.renderMode = r0
        L7d:
            int[] r0 = com.alibaba.griver.lottie.LottieAnimationView.AnonymousClass4.$SwitchMap$com$alibaba$griver$lottie$RenderMode
            com.alibaba.griver.lottie.RenderMode r1 = r7.renderMode
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r4 = 1
            if (r0 == r4) goto Lc0
            if (r0 == r1) goto Lc0
            r5 = 3
            if (r0 == r5) goto Lbe
            r5 = 4
            if (r0 == r5) goto Lc1
            r6 = 5
            if (r0 == r6) goto L97
            goto Lbe
        L97:
            com.alibaba.griver.lottie.LottieComposition r0 = r7.composition
            if (r0 == 0) goto La8
            boolean r0 = r0.hasDashPattern()
            if (r0 == 0) goto La8
            int r0 = android.os.Build.VERSION.SDK_INT
            r6 = 28
            if (r0 >= r6) goto La8
            goto Lbb
        La8:
            com.alibaba.griver.lottie.LottieComposition r0 = r7.composition
            if (r0 == 0) goto Lb3
            int r0 = r0.getMaskAndMatteCount()
            if (r0 <= r5) goto Lb3
            goto Lbb
        Lb3:
            int r0 = android.os.Build.VERSION.SDK_INT
            r5 = 21
            if (r0 >= r5) goto Lba
            goto Lbb
        Lba:
            r3 = 1
        Lbb:
            if (r3 == 0) goto Lbe
            goto Lc0
        Lbe:
            r3 = 1
            goto Lc1
        Lc0:
            r3 = 2
        Lc1:
            int r0 = r7.getLayerType()
            if (r3 == r0) goto Lca
            r7.setLayerType(r3, r2)
        Lca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.lottie.LottieAnimationView.enableOrDisableHardwareLayer():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.alibaba.griver.lottie.LottieAnimationView$4  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$griver$lottie$RenderMode;

        static {
            int[] iArr = new int[RenderMode.values().length];
            $SwitchMap$com$alibaba$griver$lottie$RenderMode = iArr;
            try {
                iArr[RenderMode.FORCE_HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$griver$lottie$RenderMode[RenderMode.HARDWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$griver$lottie$RenderMode[RenderMode.SOFTWARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$griver$lottie$RenderMode[RenderMode.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$griver$lottie$RenderMode[RenderMode.AUTOMATIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public boolean addLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            lottieOnCompositionLoadedListener.onCompositionLoaded(lottieComposition);
        }
        return this.lottieOnCompositionLoadedListeners.add(lottieOnCompositionLoadedListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.lottieOnCompositionLoadedListeners.remove(lottieOnCompositionLoadedListener);
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.alibaba.griver.lottie.LottieAnimationView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        String animationName;
        int animationResId;
        String imageAssetsFolder;
        boolean isAnimating;
        float progress;
        int repeatCount;
        int repeatMode;

        /* synthetic */ SavedState(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.animationName = parcel.readString();
            this.progress = parcel.readFloat();
            this.isAnimating = parcel.readInt() == 1;
            this.imageAssetsFolder = parcel.readString();
            this.repeatMode = parcel.readInt();
            this.repeatCount = parcel.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.animationName);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.isAnimating ? 1 : 0);
            parcel.writeString(this.imageAssetsFolder);
            parcel.writeInt(this.repeatMode);
            parcel.writeInt(this.repeatCount);
        }
    }

    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    public void useHardwareAcceleration() {
        setRenderMode(RenderMode.HARDWARE);
    }

    public void useHardwareAcceleration(boolean z) {
        setRenderMode(z ? RenderMode.HARDWARE : RenderMode.SOFTWARE);
    }

    public void playAnimation(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("resumeAnimation()  isShown=");
        sb.append(isShown());
        sb.append(",startFrame=");
        sb.append(i);
        sb.append(",endFrame=");
        sb.append(i2);
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(this);
        InstrumentInjector.log_i(TAG, sb.toString());
        if (isShown()) {
            this.lottieDrawable.playAnimation(i, i2);
            enableOrDisableHardwareLayer();
            return;
        }
        this.lottieDrawable.setMinAndMaxFrame(i, i2);
        this.wasAnimatingWhenNotShown = true;
    }

    public void playAnimation(float f, float f2) {
        StringBuilder sb = new StringBuilder();
        sb.append("resumeAnimation()  isShown=");
        sb.append(isShown());
        sb.append(",startProgress=");
        sb.append(f);
        sb.append(",endProgress=");
        sb.append(f2);
        sb.append(AUScreenAdaptTool.PREFIX_ID);
        sb.append(this);
        InstrumentInjector.log_i(TAG, sb.toString());
        if (isShown()) {
            this.lottieDrawable.playAnimation(f, f2);
            enableOrDisableHardwareLayer();
            return;
        }
        this.lottieDrawable.setMinAndMaxProgress(f, f2);
        this.wasAnimatingWhenNotShown = true;
    }

    public void setSuccessListener(LottieListener<LottieComposition> lottieListener) {
        this.successListener = lottieListener;
    }

    public void setErrorListener(LottieListener<Throwable> lottieListener) {
        this.errorListener = lottieListener;
    }

    public LottieDrawable getLottieDrawable() {
        return this.lottieDrawable;
    }

    public void setDynamicLayerEnable(boolean z) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("setDynamicLayerEnable:");
        sb.append(z);
        GriverLogger.d(str, sb.toString());
        this.lottieDrawable.setEnableDynamicLayer(z);
    }

    public String hitTestDynamicLayerInView(float f, float f2) {
        return this.lottieDrawable.hitTestDynamicLayer(f, f2, getImageMatrix());
    }

    public RectF getDynamicLayerRectInView(String str) {
        return this.lottieDrawable.getDynamicLayerRect(str, getImageMatrix());
    }
}
