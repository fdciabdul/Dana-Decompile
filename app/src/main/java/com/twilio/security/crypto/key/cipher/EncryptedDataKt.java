package com.twilio.security.crypto.key.cipher;

import android.util.Base64;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "p0", "Lcom/twilio/security/crypto/key/cipher/EncryptedData;", "PlaceComponentResult", "([B)Lcom/twilio/security/crypto/key/cipher/EncryptedData;", "getAuthRequestContext", "(Lcom/twilio/security/crypto/key/cipher/EncryptedData;)[B"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class EncryptedDataKt {
    public static final EncryptedData PlaceComponentResult(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "");
        JSONObject jSONObject = new JSONObject(new String(bArr, Charsets.UTF_8));
        JSONObject jSONObject2 = jSONObject.getJSONObject("algorithmParameters");
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "");
        byte[] decode = Base64.decode(jSONObject2.getString("encoded"), 0);
        Intrinsics.checkExpressionValueIsNotNull(decode, "");
        String string = jSONObject2.getString("provider");
        Intrinsics.checkExpressionValueIsNotNull(string, "");
        String string2 = jSONObject2.getString("algorithm");
        Intrinsics.checkExpressionValueIsNotNull(string2, "");
        AlgorithmParametersSpec algorithmParametersSpec = new AlgorithmParametersSpec(decode, string, string2);
        byte[] decode2 = Base64.decode(jSONObject.getString("encrypted"), 0);
        Intrinsics.checkExpressionValueIsNotNull(decode2, "");
        return new EncryptedData(algorithmParametersSpec, decode2);
    }

    public static final byte[] getAuthRequestContext(EncryptedData encryptedData) {
        Intrinsics.checkParameterIsNotNull(encryptedData, "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("encrypted", Base64.encodeToString(encryptedData.getPlaceComponentResult(), 0));
        AlgorithmParametersSpec algorithmParametersSpec = encryptedData.KClassImpl$Data$declaredNonStaticMembers$2;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("encoded", Base64.encodeToString(algorithmParametersSpec.getBuiltInFictitiousFunctionClassFactory(), 0));
        jSONObject2.put("provider", algorithmParametersSpec.PlaceComponentResult);
        jSONObject2.put("algorithm", algorithmParametersSpec.getAuthRequestContext);
        jSONObject.put("algorithmParameters", jSONObject2);
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject3, "");
        Charset charset = Charsets.UTF_8;
        if (jSONObject3 != null) {
            byte[] bytes = jSONObject3.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "");
            return bytes;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
