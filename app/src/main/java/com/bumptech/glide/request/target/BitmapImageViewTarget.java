package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
    public BitmapImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
    public void MyBillsEntityDataFactory(Bitmap bitmap) {
        ((ImageView) this.MyBillsEntityDataFactory).setImageBitmap(bitmap);
    }
}
