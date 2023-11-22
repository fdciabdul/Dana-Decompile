package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* loaded from: classes3.dex */
public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {
    private final BitmapPool BuiltInFictitiousFunctionClassFactory;
    private final ResourceTranscoder<GifDrawable, byte[]> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ResourceTranscoder<Bitmap, byte[]> PlaceComponentResult;

    public DrawableBytesTranscoder(BitmapPool bitmapPool, ResourceTranscoder<Bitmap, byte[]> resourceTranscoder, ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder2) {
        this.BuiltInFictitiousFunctionClassFactory = bitmapPool;
        this.PlaceComponentResult = resourceTranscoder;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = resourceTranscoder2;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public final Resource<byte[]> BuiltInFictitiousFunctionClassFactory(Resource<Drawable> resource, Options options) {
        Drawable authRequestContext = resource.getAuthRequestContext();
        if (authRequestContext instanceof BitmapDrawable) {
            return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(BitmapResource.MyBillsEntityDataFactory(((BitmapDrawable) authRequestContext).getBitmap(), this.BuiltInFictitiousFunctionClassFactory), options);
        }
        if (authRequestContext instanceof GifDrawable) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(resource, options);
        }
        return null;
    }
}
