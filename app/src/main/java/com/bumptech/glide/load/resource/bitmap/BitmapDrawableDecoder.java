package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;

/* loaded from: classes3.dex */
public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {
    private final Resources KClassImpl$Data$declaredNonStaticMembers$2;
    private final ResourceDecoder<DataType, Bitmap> PlaceComponentResult;

    public BitmapDrawableDecoder(Resources resources, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (Resources) Preconditions.PlaceComponentResult(resources);
        this.PlaceComponentResult = (ResourceDecoder) Preconditions.PlaceComponentResult(resourceDecoder);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(DataType datatype, Options options) throws IOException {
        return this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(datatype, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final Resource<BitmapDrawable> BuiltInFictitiousFunctionClassFactory(DataType datatype, int i, int i2, Options options) throws IOException {
        return LazyBitmapDrawableResource.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(datatype, i, i2, options));
    }
}
