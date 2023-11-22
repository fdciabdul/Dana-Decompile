package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.ImageReader;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
    private final Downsampler getAuthRequestContext;

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* synthetic */ Resource<Bitmap> BuiltInFictitiousFunctionClassFactory(ByteBuffer byteBuffer, int i, int i2, Options options) throws IOException {
        InputStream PlaceComponentResult = ByteBufferUtil.PlaceComponentResult(byteBuffer);
        Downsampler downsampler = this.getAuthRequestContext;
        return downsampler.PlaceComponentResult(new ImageReader.InputStreamImageReader(PlaceComponentResult, downsampler.getErrorConfigVersion, downsampler.scheduleImpl), i, i2, options, Downsampler.PlaceComponentResult);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(ByteBuffer byteBuffer, Options options) throws IOException {
        return BuiltInFictitiousFunctionClassFactory();
    }

    public ByteBufferBitmapDecoder(Downsampler downsampler) {
        this.getAuthRequestContext = downsampler;
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        return Downsampler.getAuthRequestContext();
    }
}
