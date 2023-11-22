package com.alibaba.griver.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.lottie.manager.FontAssetManager;
import com.alibaba.griver.lottie.manager.ImageAssetManager;
import com.alibaba.griver.lottie.model.KeyPath;
import com.alibaba.griver.lottie.model.Marker;
import com.alibaba.griver.lottie.model.layer.BaseLayer;
import com.alibaba.griver.lottie.model.layer.CompositionLayer;
import com.alibaba.griver.lottie.parser.LayerParser;
import com.alibaba.griver.lottie.utils.Logger;
import com.alibaba.griver.lottie.utils.LottieValueAnimator;
import com.alibaba.griver.lottie.utils.MiscUtils;
import com.alibaba.griver.lottie.value.LottieFrameInfo;
import com.alibaba.griver.lottie.value.LottieValueCallback;
import com.alibaba.griver.lottie.value.SimpleLottieValueCallback;
import com.fullstory.instrumentation.FSDraw;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable, FSDraw {
    public static final int INFINITE = -1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private static final String TAG = "LottieDrawable";
    private int alpha;
    private final LottieValueAnimator animator;
    private final Set<ColorFilterData> colorFilterData;
    private LottieComposition composition;
    private CompositionLayer compositionLayer;
    private final HashMap<String, BaseLayer> dynamicLayers;
    private boolean enableDynamicLayer;
    private boolean enableMergePaths;
    FontAssetDelegate fontAssetDelegate;
    private FontAssetManager fontAssetManager;
    private ImageAssetDelegate imageAssetDelegate;
    private ImageAssetManager imageAssetManager;
    private String imageAssetsFolder;
    private boolean isDirty;
    private final ArrayList<LazyCompositionTask> lazyCompositionTasks;
    private final Matrix matrix = new Matrix();
    private boolean performanceTrackingEnabled;
    private float scale;
    private boolean systemAnimationsEnabled;
    TextDelegate textDelegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface LazyCompositionTask {
        void run(LottieComposition lottieComposition);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface RepeatMode {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean useTextGlyphs() {
        return false;
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.animator = lottieValueAnimator;
        this.scale = 1.0f;
        this.systemAnimationsEnabled = true;
        this.enableDynamicLayer = false;
        this.colorFilterData = new HashSet();
        this.lazyCompositionTasks = new ArrayList<>();
        this.alpha = 255;
        this.dynamicLayers = new HashMap<>();
        this.isDirty = false;
        lottieValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.alibaba.griver.lottie.LottieDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (LottieDrawable.this.compositionLayer != null) {
                    LottieDrawable.this.compositionLayer.setProgress(LottieDrawable.this.animator.getAnimatedValueAbsolute());
                }
            }
        });
    }

    public void setEnableDynamicLayer(boolean z) {
        this.enableDynamicLayer = z;
    }

    public boolean isEnableDynamicLayer() {
        return this.enableDynamicLayer;
    }

    public HashMap<String, BaseLayer> getDynamicLayers() {
        return this.dynamicLayers;
    }

    public boolean hasMasks() {
        CompositionLayer compositionLayer = this.compositionLayer;
        return compositionLayer != null && compositionLayer.hasMasks();
    }

    public boolean hasMatte() {
        CompositionLayer compositionLayer = this.compositionLayer;
        return compositionLayer != null && compositionLayer.hasMatte();
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        if (this.enableMergePaths == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            Logger.warning("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.enableMergePaths = z;
        if (this.composition != null) {
            buildCompositionLayer();
        }
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public void setImagesAssetsFolder(String str) {
        this.imageAssetsFolder = str;
    }

    public String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    public boolean setComposition(LottieComposition lottieComposition) {
        if (this.composition == lottieComposition) {
            return false;
        }
        this.isDirty = false;
        clearComposition();
        this.composition = lottieComposition;
        buildCompositionLayer();
        this.animator.setComposition(lottieComposition);
        setProgress(this.animator.getAnimatedFraction());
        setScale(this.scale);
        updateBounds();
        return true;
    }

    public void afterSetComposition() {
        Iterator it = new ArrayList(this.lazyCompositionTasks).iterator();
        while (it.hasNext()) {
            ((LazyCompositionTask) it.next()).run(this.composition);
            it.remove();
        }
        this.lazyCompositionTasks.clear();
        this.composition.setPerformanceTrackingEnabled(this.performanceTrackingEnabled);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.performanceTrackingEnabled = z;
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            lottieComposition.setPerformanceTrackingEnabled(z);
        }
    }

    public PerformanceTracker getPerformanceTracker() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            return lottieComposition.getPerformanceTracker();
        }
        return null;
    }

    private void buildCompositionLayer() {
        this.compositionLayer = new CompositionLayer(this, LayerParser.parse(this.composition), this.composition.getLayers(), this.composition);
    }

    public void clearComposition() {
        if (this.animator.isRunning()) {
            this.animator.cancel();
        }
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        this.animator.clearComposition();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.isDirty) {
            return;
        }
        this.isDirty = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.alpha = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Logger.warning("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f;
        this.isDirty = false;
        L.beginSection("Drawable#draw");
        if (this.compositionLayer == null) {
            return;
        }
        float f2 = this.scale;
        float maxScale = getMaxScale(canvas);
        if (f2 > maxScale) {
            f = this.scale / maxScale;
        } else {
            maxScale = f2;
            f = 1.0f;
        }
        int i = -1;
        if (f > 1.0f) {
            i = canvas.save();
            float width = this.composition.getBounds().width() / 2.0f;
            float height = this.composition.getBounds().height() / 2.0f;
            float f3 = width * maxScale;
            float f4 = height * maxScale;
            canvas.translate((getScale() * width) - f3, (getScale() * height) - f4);
            canvas.scale(f, f, f3, f4);
        }
        this.matrix.reset();
        this.matrix.preScale(maxScale, maxScale);
        this.compositionLayer.draw(canvas, this.matrix, this.alpha);
        L.endSection("Drawable#draw");
        if (i > 0) {
            canvas.restoreToCount(i);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        playAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        endAnimation();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return isAnimating();
    }

    public void playAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.2
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.playAnimation();
                }
            });
            return;
        }
        if (this.systemAnimationsEnabled || getRepeatCount() == 0) {
            this.animator.playAnimation();
        }
        if (this.systemAnimationsEnabled) {
            return;
        }
        setFrame((int) (getSpeed() < 0.0f ? getMinFrame() : getMaxFrame()));
    }

    public void endAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.endAnimation();
    }

    public void resumeAnimation() {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.3
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.resumeAnimation();
                }
            });
        } else {
            this.animator.resumeAnimation();
        }
    }

    public void setMinFrame(final int i) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.4
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinFrame(i);
                }
            });
        } else {
            this.animator.setMinFrame(i);
        }
    }

    public float getMinFrame() {
        return this.animator.getMinFrame();
    }

    public void setMinProgress(final float f) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.5
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.setMinProgress(f);
                }
            });
        } else {
            setMinFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f));
        }
    }

    public void setMaxFrame(final int i) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.6
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMaxFrame(i);
                }
            });
        } else {
            this.animator.setMaxFrame(i + 0.99f);
        }
    }

    public float getMaxFrame() {
        return this.animator.getMaxFrame();
    }

    public void setMaxProgress(final float f) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.7
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.setMaxProgress(f);
                }
            });
        } else {
            setMaxFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f));
        }
    }

    public void setMinFrame(final String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.8
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.setMinFrame(str);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find marker with name ");
            sb.append(str);
            sb.append(".");
            throw new IllegalArgumentException(sb.toString());
        }
        setMinFrame((int) marker.startFrame);
    }

    public void setMaxFrame(final String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.9
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.setMaxFrame(str);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find marker with name ");
            sb.append(str);
            sb.append(".");
            throw new IllegalArgumentException(sb.toString());
        }
        setMaxFrame((int) (marker.startFrame + marker.durationFrames));
    }

    public void setMinAndMaxFrame(final String str) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.10
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.setMinAndMaxFrame(str);
                }
            });
            return;
        }
        Marker marker = lottieComposition.getMarker(str);
        if (marker == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot find marker with name ");
            sb.append(str);
            sb.append(".");
            throw new IllegalArgumentException(sb.toString());
        }
        int i = (int) marker.startFrame;
        setMinAndMaxFrame(i, ((int) marker.durationFrames) + i);
    }

    public void setMinAndMaxFrame(final int i, final int i2) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.11
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setMinAndMaxFrame(i, i2);
                }
            });
        } else {
            this.animator.setMinAndMaxFrames(i, i2 + 0.99f);
        }
    }

    public void setMinAndMaxProgress(final float f, final float f2) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.12
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.setMinAndMaxProgress(f, f2);
                }
            });
        } else {
            setMinAndMaxFrame((int) MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f), (int) MiscUtils.lerp(this.composition.getStartFrame(), this.composition.getEndFrame(), f2));
        }
    }

    public void reverseAnimationSpeed() {
        this.animator.reverseAnimationSpeed();
    }

    public void setSpeed(float f) {
        this.animator.setSpeed(f);
    }

    public float getSpeed() {
        return this.animator.getSpeed();
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.addUpdateListener(animatorUpdateListener);
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.removeUpdateListener(animatorUpdateListener);
    }

    public void removeAllUpdateListeners() {
        this.animator.removeAllUpdateListeners();
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.addListener(animatorListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.removeListener(animatorListener);
    }

    public void removeAllAnimatorListeners() {
        this.animator.removeAllListeners();
    }

    public void setFrame(final int i) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.13
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.setFrame(i);
                }
            });
        } else {
            this.animator.setFrame(i);
        }
    }

    public int getFrame() {
        return (int) this.animator.getFrame();
    }

    public void setProgress(final float f) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.14
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition2) {
                    LottieDrawable.this.setProgress(f);
                }
            });
        } else {
            this.animator.setFrame(MiscUtils.lerp(lottieComposition.getStartFrame(), this.composition.getEndFrame(), f));
        }
    }

    @Deprecated
    public void loop(boolean z) {
        this.animator.setRepeatCount(z ? -1 : 0);
    }

    public void setRepeatMode(int i) {
        this.animator.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.animator.getRepeatMode();
    }

    public void setRepeatCount(int i) {
        this.animator.setRepeatCount(i);
    }

    public int getRepeatCount() {
        return this.animator.getRepeatCount();
    }

    public boolean isLooping() {
        return this.animator.getRepeatCount() == -1;
    }

    public boolean isAnimating() {
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    void setSystemAnimationsAreEnabled(Boolean bool) {
        this.systemAnimationsEnabled = bool.booleanValue();
    }

    public void setScale(float f) {
        this.scale = f;
        updateBounds();
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.imageAssetDelegate = imageAssetDelegate;
        ImageAssetManager imageAssetManager = this.imageAssetManager;
        if (imageAssetManager != null) {
            imageAssetManager.setDelegate(imageAssetDelegate);
        }
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.fontAssetDelegate = fontAssetDelegate;
        FontAssetManager fontAssetManager = this.fontAssetManager;
        if (fontAssetManager != null) {
            fontAssetManager.setDelegate(fontAssetDelegate);
        }
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.textDelegate = textDelegate;
    }

    public TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public float getScale() {
        return this.scale;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    private void updateBounds() {
        if (this.composition == null) {
            return;
        }
        float scale = getScale();
        setBounds(0, 0, (int) (this.composition.getBounds().width() * scale), (int) (this.composition.getBounds().height() * scale));
    }

    public void cancelAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.cancel();
    }

    public void pauseAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.pauseAnimation();
    }

    public float getProgress() {
        return this.animator.getAnimatedValueAbsolute();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (r0.getBounds().width() * getScale());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.composition == null) {
            return -1;
        }
        return (int) (r0.getBounds().height() * getScale());
    }

    public List<KeyPath> resolveKeyPath(KeyPath keyPath) {
        if (this.compositionLayer == null) {
            Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.compositionLayer.resolveKeyPath(keyPath, 0, arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    public <T> void addValueCallback(final KeyPath keyPath, final T t, final LottieValueCallback<T> lottieValueCallback) {
        if (this.compositionLayer == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.15
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.addValueCallback(keyPath, (KeyPath) t, (LottieValueCallback<KeyPath>) lottieValueCallback);
                }
            });
            return;
        }
        boolean z = true;
        if (keyPath.getResolvedElement() != null) {
            keyPath.getResolvedElement().addValueCallback(t, lottieValueCallback);
        } else {
            List<KeyPath> resolveKeyPath = resolveKeyPath(keyPath);
            for (int i = 0; i < resolveKeyPath.size(); i++) {
                resolveKeyPath.get(i).getResolvedElement().addValueCallback(t, lottieValueCallback);
            }
            z = true ^ resolveKeyPath.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == LottieProperty.TIME_REMAP) {
                setProgress(getProgress());
            }
        }
    }

    public <T> void addValueCallback(KeyPath keyPath, T t, final SimpleLottieValueCallback<T> simpleLottieValueCallback) {
        addValueCallback(keyPath, (KeyPath) t, (LottieValueCallback<KeyPath>) new LottieValueCallback<T>() { // from class: com.alibaba.griver.lottie.LottieDrawable.16
            @Override // com.alibaba.griver.lottie.value.LottieValueCallback
            public T getValue(LottieFrameInfo<T> lottieFrameInfo) {
                return (T) simpleLottieValueCallback.getValue(lottieFrameInfo);
            }
        });
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        ImageAssetManager imageAssetManager = getImageAssetManager();
        if (imageAssetManager == null) {
            Logger.warning("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap updateBitmap = imageAssetManager.updateBitmap(str, bitmap);
        invalidateSelf();
        return updateBitmap;
    }

    public Bitmap getImageAsset(String str) {
        ImageAssetManager imageAssetManager = getImageAssetManager();
        if (imageAssetManager != null) {
            return imageAssetManager.bitmapForId(str);
        }
        return null;
    }

    private ImageAssetManager getImageAssetManager() {
        if (getCallback() == null) {
            return null;
        }
        ImageAssetManager imageAssetManager = this.imageAssetManager;
        if (imageAssetManager != null && !imageAssetManager.hasSameContext(getContext())) {
            this.imageAssetManager = null;
        }
        if (this.imageAssetManager == null) {
            this.imageAssetManager = new ImageAssetManager(getCallback(), this.imageAssetsFolder, this.imageAssetDelegate, this.composition.getImages());
        }
        return this.imageAssetManager;
    }

    public Typeface getTypeface(String str, String str2, String str3) {
        FontAssetManager fontAssetManager = getFontAssetManager();
        if (fontAssetManager != null) {
            return fontAssetManager.getTypeface(str, str2, str3);
        }
        return Typeface.DEFAULT;
    }

    private FontAssetManager getFontAssetManager() {
        if (getCallback() == null) {
            return null;
        }
        if (this.fontAssetManager == null) {
            this.fontAssetManager = new FontAssetManager(getCallback(), this.fontAssetDelegate);
        }
        return this.fontAssetManager;
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    private float getMaxScale(Canvas canvas) {
        return Math.min(canvas.getWidth() / this.composition.getBounds().width(), canvas.getHeight() / this.composition.getBounds().height());
    }

    /* loaded from: classes6.dex */
    static class ColorFilterData {
        final ColorFilter colorFilter;
        final String contentName;
        final String layerName;

        ColorFilterData(String str, String str2, ColorFilter colorFilter) {
            this.layerName = str;
            this.contentName = str2;
            this.colorFilter = colorFilter;
        }

        public int hashCode() {
            String str = this.layerName;
            int hashCode = str != null ? str.hashCode() * 527 : 17;
            String str2 = this.contentName;
            return str2 != null ? hashCode * 31 * str2.hashCode() : hashCode;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ColorFilterData) {
                ColorFilterData colorFilterData = (ColorFilterData) obj;
                return hashCode() == colorFilterData.hashCode() && this.colorFilter == colorFilterData.colorFilter;
            }
            return false;
        }
    }

    public void playAnimation(final int i, final int i2) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.17
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.playAnimation(i, i2);
                }
            });
            return;
        }
        setMinAndMaxFrame(i, i2);
        playAnimation();
    }

    public void playAnimation(final float f, final float f2) {
        if (this.composition == null) {
            this.lazyCompositionTasks.add(new LazyCompositionTask() { // from class: com.alibaba.griver.lottie.LottieDrawable.18
                @Override // com.alibaba.griver.lottie.LottieDrawable.LazyCompositionTask
                public void run(LottieComposition lottieComposition) {
                    LottieDrawable.this.playAnimation(f, f2);
                }
            });
            return;
        }
        setMinAndMaxProgress(f, f2);
        playAnimation();
    }

    public String hitTestDynamicLayer(float f, float f2, Matrix matrix) {
        CompositionLayer compositionLayer = this.compositionLayer;
        if (compositionLayer != null) {
            return compositionLayer.hitTestDynamicLayer(f, f2, matrix);
        }
        GriverLogger.d(TAG, "hitTestDynamicLayer: compositionLayer == null");
        return null;
    }

    public RectF getDynamicLayerRect(String str, Matrix matrix) {
        CompositionLayer compositionLayer = this.compositionLayer;
        if (compositionLayer != null) {
            return compositionLayer.getDynamicLayerRect(str, matrix);
        }
        GriverLogger.d(TAG, "getDynamicLayerRect: compositionLayer == null");
        return null;
    }
}
