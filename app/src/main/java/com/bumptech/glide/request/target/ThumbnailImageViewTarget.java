package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;

/* loaded from: classes7.dex */
public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    protected abstract Drawable PlaceComponentResult(T t);

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    protected final void MyBillsEntityDataFactory(T t) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.MyBillsEntityDataFactory).getLayoutParams();
        Drawable PlaceComponentResult = PlaceComponentResult((ThumbnailImageViewTarget<T>) t);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            PlaceComponentResult = new FixedSizeDrawable(PlaceComponentResult, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.MyBillsEntityDataFactory).setImageDrawable(PlaceComponentResult);
    }
}
