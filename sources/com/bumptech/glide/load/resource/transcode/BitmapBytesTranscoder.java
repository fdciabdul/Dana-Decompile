package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import java.io.ByteArrayOutputStream;

/* loaded from: classes3.dex */
public class BitmapBytesTranscoder implements ResourceTranscoder<Bitmap, byte[]> {
    private final Bitmap.CompressFormat KClassImpl$Data$declaredNonStaticMembers$2;
    private final int MyBillsEntityDataFactory;

    public BitmapBytesTranscoder() {
        this(Bitmap.CompressFormat.JPEG);
    }

    private BitmapBytesTranscoder(Bitmap.CompressFormat compressFormat) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = compressFormat;
        this.MyBillsEntityDataFactory = 100;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public final Resource<byte[]> BuiltInFictitiousFunctionClassFactory(Resource<Bitmap> resource, Options options) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        resource.getAuthRequestContext().compress(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, byteArrayOutputStream);
        resource.lookAheadTest();
        return new BytesResource(byteArrayOutputStream.toByteArray());
    }
}
