package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
public class BytesResource implements Resource<byte[]> {
    private final byte[] KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // com.bumptech.glide.load.engine.Resource
    public final void lookAheadTest() {
    }

    public BytesResource(byte[] bArr) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (byte[]) Preconditions.PlaceComponentResult(bArr);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final Class<byte[]> KClassImpl$Data$declaredNonStaticMembers$2() {
        return byte[].class;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public byte[] getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.length;
    }
}
