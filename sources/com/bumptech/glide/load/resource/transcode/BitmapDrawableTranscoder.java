package com.bumptech.glide.load.resource.transcode;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {
    private final Resources MyBillsEntityDataFactory;

    public BitmapDrawableTranscoder(Resources resources) {
        this.MyBillsEntityDataFactory = (Resources) Preconditions.PlaceComponentResult(resources);
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public final Resource<BitmapDrawable> BuiltInFictitiousFunctionClassFactory(Resource<Bitmap> resource, Options options) {
        return LazyBitmapDrawableResource.PlaceComponentResult(this.MyBillsEntityDataFactory, resource);
    }
}
