package com.twilio.security.crypto.key.cipher;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013"}, d2 = {"Lcom/twilio/security/crypto/key/cipher/EncryptedData;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lcom/twilio/security/crypto/key/cipher/AlgorithmParametersSpec;", "BuiltInFictitiousFunctionClassFactory", "Lcom/twilio/security/crypto/key/cipher/AlgorithmParametersSpec;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "[B", "getAuthRequestContext", "()[B", "PlaceComponentResult", "p1", "<init>", "(Lcom/twilio/security/crypto/key/cipher/AlgorithmParametersSpec;[B)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final /* data */ class EncryptedData {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final AlgorithmParametersSpec KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final byte[] PlaceComponentResult;

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EncryptedData(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(Arrays.toString(this.PlaceComponentResult));
        sb.append(")");
        return sb.toString();
    }

    public EncryptedData(AlgorithmParametersSpec algorithmParametersSpec, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(algorithmParametersSpec, "");
        Intrinsics.checkParameterIsNotNull(bArr, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = algorithmParametersSpec;
        this.PlaceComponentResult = bArr;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final byte[] getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if ((!Intrinsics.areEqual(getClass(), p0 != null ? p0.getClass() : null)) == true) {
            return false;
        }
        if (p0 != null) {
            EncryptedData encryptedData = (EncryptedData) p0;
            return !(Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, encryptedData.KClassImpl$Data$declaredNonStaticMembers$2) ^ true) && Arrays.equals(this.PlaceComponentResult, encryptedData.PlaceComponentResult);
        }
        throw new TypeCastException("null cannot be cast to non-null type com.twilio.security.crypto.key.cipher.EncryptedData");
    }

    public final int hashCode() {
        return (this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + Arrays.hashCode(this.PlaceComponentResult);
    }
}
