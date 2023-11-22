package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {
    private final Downsampler PlaceComponentResult;

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* synthetic */ Resource<Bitmap> BuiltInFictitiousFunctionClassFactory(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, Options options) throws IOException {
        Downsampler downsampler = this.PlaceComponentResult;
        return downsampler.PlaceComponentResult(new ImageReader.ParcelFileDescriptorImageReader(parcelFileDescriptor, downsampler.getErrorConfigVersion, downsampler.scheduleImpl), i, i2, options, Downsampler.PlaceComponentResult);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(ParcelFileDescriptor parcelFileDescriptor, Options options) throws IOException {
        return getAuthRequestContext();
    }

    public ParcelFileDescriptorBitmapDecoder(Downsampler downsampler) {
        this.PlaceComponentResult = downsampler;
    }

    private boolean getAuthRequestContext() {
        boolean BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory = ParcelFileDescriptorRewinder.BuiltInFictitiousFunctionClassFactory();
        return BuiltInFictitiousFunctionClassFactory;
    }
}
