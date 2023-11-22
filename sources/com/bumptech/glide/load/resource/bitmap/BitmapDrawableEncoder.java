package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

/* loaded from: classes3.dex */
public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {
    private final ResourceEncoder<Bitmap> PlaceComponentResult;
    private final BitmapPool getAuthRequestContext;

    public BitmapDrawableEncoder(BitmapPool bitmapPool, ResourceEncoder<Bitmap> resourceEncoder) {
        this.getAuthRequestContext = bitmapPool;
        this.PlaceComponentResult = resourceEncoder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.bumptech.glide.load.Encoder
    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2(Resource<BitmapDrawable> resource, File file, Options options) {
        return this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(new BitmapResource(resource.getAuthRequestContext().getBitmap(), this.getAuthRequestContext), file, options);
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public final EncodeStrategy KClassImpl$Data$declaredNonStaticMembers$2(Options options) {
        return this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(options);
    }
}
