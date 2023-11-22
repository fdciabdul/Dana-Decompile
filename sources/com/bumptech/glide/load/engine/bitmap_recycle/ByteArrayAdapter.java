package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: classes3.dex */
public final class ByteArrayAdapter implements ArrayAdapterInterface<byte[]> {
    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public final String BuiltInFictitiousFunctionClassFactory() {
        return "ByteArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public final /* bridge */ /* synthetic */ int BuiltInFictitiousFunctionClassFactory(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public final /* synthetic */ byte[] BuiltInFictitiousFunctionClassFactory(int i) {
        return getAuthRequestContext(i);
    }

    private static byte[] getAuthRequestContext(int i) {
        return new byte[i];
    }
}
