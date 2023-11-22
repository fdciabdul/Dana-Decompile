package me.zhanghai.android.materialprogressbar.internal;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat;

/* loaded from: classes9.dex */
public class AnimationScaleListDrawableCompat extends DrawableContainerCompat implements Animatable {
    private static final String TAG = "AnimationScaleListDrawableCompat";
    private AnimationScaleListState mAnimationScaleListState;
    private boolean mMutated;

    public AnimationScaleListDrawableCompat(Drawable[] drawableArr) {
        setConstantState(new AnimationScaleListState(null, this, null));
        for (Drawable drawable : drawableArr) {
            this.mAnimationScaleListState.addDrawable(drawable);
        }
        onStateChange(getState());
    }

    private AnimationScaleListDrawableCompat(AnimationScaleListState animationScaleListState, Resources resources) {
        setConstantState(new AnimationScaleListState(animationScaleListState, this, resources));
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        return selectDrawable(this.mAnimationScaleListState.getCurrentDrawableIndexBasedOnScale()) || super.onStateChange(iArr);
    }

    @Override // me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.mAnimationScaleListState.mutate();
            this.mMutated = true;
        }
        return this;
    }

    @Override // me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable current = getCurrent();
        if (current == null || !(current instanceof Animatable)) {
            return;
        }
        ((Animatable) current).start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable current = getCurrent();
        if (current == null || !(current instanceof Animatable)) {
            return;
        }
        ((Animatable) current).stop();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable current = getCurrent();
        if (current == null || !(current instanceof Animatable)) {
            return false;
        }
        return ((Animatable) current).isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class AnimationScaleListState extends DrawableContainerCompat.DrawableContainerState {
        int mAnimatableDrawableIndex;
        int mStaticDrawableIndex;
        int[] mThemeAttrs;

        AnimationScaleListState(AnimationScaleListState animationScaleListState, AnimationScaleListDrawableCompat animationScaleListDrawableCompat, Resources resources) {
            super(animationScaleListState, animationScaleListDrawableCompat, resources);
            this.mThemeAttrs = null;
            this.mStaticDrawableIndex = -1;
            this.mAnimatableDrawableIndex = -1;
            if (animationScaleListState != null) {
                this.mThemeAttrs = animationScaleListState.mThemeAttrs;
                this.mStaticDrawableIndex = animationScaleListState.mStaticDrawableIndex;
                this.mAnimatableDrawableIndex = animationScaleListState.mAnimatableDrawableIndex;
            }
        }

        @Override // me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat.DrawableContainerState
        void mutate() {
            int[] iArr = this.mThemeAttrs;
            this.mThemeAttrs = iArr != null ? (int[]) iArr.clone() : null;
        }

        int addDrawable(Drawable drawable) {
            int addChild = addChild(drawable);
            if (drawable instanceof Animatable) {
                this.mAnimatableDrawableIndex = addChild;
            } else {
                this.mStaticDrawableIndex = addChild;
            }
            return addChild;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [me.zhanghai.android.materialprogressbar.internal.AnimationScaleListDrawableCompat$1, android.content.res.Resources] */
        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            ?? r1 = 0;
            return new AnimationScaleListDrawableCompat(this, r1);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new AnimationScaleListDrawableCompat(this, resources);
        }

        @Override // me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat.DrawableContainerState, android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mThemeAttrs != null || super.canApplyTheme();
        }

        public int getCurrentDrawableIndexBasedOnScale() {
            if (!ValueAnimatorCompat.areAnimatorsEnabled()) {
                return this.mStaticDrawableIndex;
            }
            return this.mAnimatableDrawableIndex;
        }
    }

    @Override // me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // me.zhanghai.android.materialprogressbar.internal.DrawableContainerCompat
    public void setConstantState(DrawableContainerCompat.DrawableContainerState drawableContainerState) {
        super.setConstantState(drawableContainerState);
        if (drawableContainerState instanceof AnimationScaleListState) {
            this.mAnimationScaleListState = (AnimationScaleListState) drawableContainerState;
        }
    }
}
