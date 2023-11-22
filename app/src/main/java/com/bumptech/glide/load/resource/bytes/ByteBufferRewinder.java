package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.data.DataRewinder;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class ByteBufferRewinder implements DataRewinder<ByteBuffer> {
    private final ByteBuffer BuiltInFictitiousFunctionClassFactory;

    @Override // com.bumptech.glide.load.data.DataRewinder
    public final void MyBillsEntityDataFactory() {
    }

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.BuiltInFictitiousFunctionClassFactory = byteBuffer;
    }

    /* loaded from: classes3.dex */
    public static class Factory implements DataRewinder.Factory<ByteBuffer> {
        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public final /* synthetic */ DataRewinder<ByteBuffer> BuiltInFictitiousFunctionClassFactory(ByteBuffer byteBuffer) {
            return new ByteBufferRewinder(byteBuffer);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public final Class<ByteBuffer> KClassImpl$Data$declaredNonStaticMembers$2() {
            return ByteBuffer.class;
        }
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public final /* synthetic */ ByteBuffer PlaceComponentResult() throws IOException {
        this.BuiltInFictitiousFunctionClassFactory.position(0);
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
