package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes3.dex */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {
    private Animatable getAuthRequestContext;

    protected abstract void MyBillsEntityDataFactory(Z z);

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    public final Drawable BuiltInFictitiousFunctionClassFactory() {
        return ((ImageView) this.MyBillsEntityDataFactory).getDrawable();
    }

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    public final void MyBillsEntityDataFactory(Drawable drawable) {
        ((ImageView) this.MyBillsEntityDataFactory).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        PlaceComponentResult(null);
        ((ImageView) this.MyBillsEntityDataFactory).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        PlaceComponentResult(null);
        ((ImageView) this.MyBillsEntityDataFactory).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.getAuthRequestContext;
        if (animatable != null) {
            animatable.stop();
        }
        PlaceComponentResult(null);
        ((ImageView) this.MyBillsEntityDataFactory).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Z z, Transition<? super Z> transition) {
        if (transition == null || !transition.MyBillsEntityDataFactory(z, this)) {
            PlaceComponentResult(z);
        } else if (z instanceof Animatable) {
            Animatable animatable = (Animatable) z;
            this.getAuthRequestContext = animatable;
            animatable.start();
        } else {
            this.getAuthRequestContext = null;
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Animatable animatable = this.getAuthRequestContext;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Animatable animatable = this.getAuthRequestContext;
        if (animatable != null) {
            animatable.stop();
        }
    }

    private void PlaceComponentResult(Z z) {
        MyBillsEntityDataFactory((ImageViewTarget<Z>) z);
        if (z instanceof Animatable) {
            Animatable animatable = (Animatable) z;
            this.getAuthRequestContext = animatable;
            animatable.start();
            return;
        }
        this.getAuthRequestContext = null;
    }
}
