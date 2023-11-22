package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public final class InputStreamRewinder implements DataRewinder<InputStream> {
    public final RecyclableBufferedInputStream MyBillsEntityDataFactory;

    public InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.MyBillsEntityDataFactory = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
    }

    /* loaded from: classes3.dex */
    public static final class Factory implements DataRewinder.Factory<InputStream> {
        private final ArrayPool BuiltInFictitiousFunctionClassFactory;

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public final /* synthetic */ DataRewinder<InputStream> BuiltInFictitiousFunctionClassFactory(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.BuiltInFictitiousFunctionClassFactory);
        }

        public Factory(ArrayPool arrayPool) {
            this.BuiltInFictitiousFunctionClassFactory = arrayPool;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public final Class<InputStream> KClassImpl$Data$declaredNonStaticMembers$2() {
            return InputStream.class;
        }
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public final /* synthetic */ InputStream PlaceComponentResult() throws IOException {
        this.MyBillsEntityDataFactory.reset();
        return this.MyBillsEntityDataFactory;
    }
}
