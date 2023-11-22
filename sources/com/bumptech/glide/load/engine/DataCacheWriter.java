package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: classes3.dex */
class DataCacheWriter<DataType> implements DiskCache.Writer {
    private final Options BuiltInFictitiousFunctionClassFactory;
    private final DataType KClassImpl$Data$declaredNonStaticMembers$2;
    private final Encoder<DataType> MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataCacheWriter(Encoder<DataType> encoder, DataType datatype, Options options) {
        this.MyBillsEntityDataFactory = encoder;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = datatype;
        this.BuiltInFictitiousFunctionClassFactory = options;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Writer
    public final boolean BuiltInFictitiousFunctionClassFactory(File file) {
        return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, file, this.BuiltInFictitiousFunctionClassFactory);
    }
}
