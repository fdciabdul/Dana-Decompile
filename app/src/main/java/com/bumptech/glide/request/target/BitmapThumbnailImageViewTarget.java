package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes7.dex */
public class BitmapThumbnailImageViewTarget extends ThumbnailImageViewTarget<Bitmap> {
    @Override // com.bumptech.glide.request.target.ThumbnailImageViewTarget
    protected final /* synthetic */ Drawable PlaceComponentResult(Bitmap bitmap) {
        return new BitmapDrawable(((ImageView) this.MyBillsEntityDataFactory).getResources(), bitmap);
    }
}
