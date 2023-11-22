package com.twilio.security.crypto.key.cipher;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\u0012R\u0011\u0010\u0010\u001a\u00020\tX\u0007¢\u0006\u0006\n\u0004\b\u0014\u0010\r"}, d2 = {"Lcom/twilio/security/crypto/key/cipher/AlgorithmParametersSpec;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getAuthRequestContext", "", "PlaceComponentResult", "[B", "()[B", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "p2", "<init>", "([BLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final /* data */ class AlgorithmParametersSpec {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final byte[] BuiltInFictitiousFunctionClassFactory;

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AlgorithmParametersSpec(BuiltInFictitiousFunctionClassFactory=");
        sb.append(Arrays.toString(this.BuiltInFictitiousFunctionClassFactory));
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(")");
        return sb.toString();
    }

    public AlgorithmParametersSpec(byte[] bArr, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(bArr, "");
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(str2, "");
        this.BuiltInFictitiousFunctionClassFactory = bArr;
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = str2;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final byte[] getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if ((!Intrinsics.areEqual(getClass(), p0 != null ? p0.getClass() : null)) == true) {
            return false;
        }
        if (p0 != null) {
            AlgorithmParametersSpec algorithmParametersSpec = (AlgorithmParametersSpec) p0;
            return (!Arrays.equals(this.BuiltInFictitiousFunctionClassFactory, algorithmParametersSpec.BuiltInFictitiousFunctionClassFactory) || (Intrinsics.areEqual(this.PlaceComponentResult, algorithmParametersSpec.PlaceComponentResult) ^ true) || (Intrinsics.areEqual(this.getAuthRequestContext, algorithmParametersSpec.getAuthRequestContext) ^ true)) ? false : true;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.twilio.security.crypto.key.cipher.AlgorithmParametersSpec");
    }

    public final int hashCode() {
        return (((Arrays.hashCode(this.BuiltInFictitiousFunctionClassFactory) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.getAuthRequestContext.hashCode();
    }
}
