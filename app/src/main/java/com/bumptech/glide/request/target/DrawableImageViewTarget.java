package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class DrawableImageViewTarget extends ImageViewTarget<Drawable> {
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    protected final /* synthetic */ void MyBillsEntityDataFactory(Drawable drawable) {
        ((ImageView) this.MyBillsEntityDataFactory).setImageDrawable(drawable);
    }

    public DrawableImageViewTarget(ImageView imageView) {
        super(imageView);
    }
}
