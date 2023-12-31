package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class ImageViewTargetFactory {
    public static <Z> ViewTarget<ImageView, Z> PlaceComponentResult(ImageView imageView, Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new BitmapImageViewTarget(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new DrawableImageViewTarget(imageView);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unhandled class: ");
        sb.append(cls);
        sb.append(", try .as*(Class).transcode(ResourceTranscoder)");
        throw new IllegalArgumentException(sb.toString());
    }
}
