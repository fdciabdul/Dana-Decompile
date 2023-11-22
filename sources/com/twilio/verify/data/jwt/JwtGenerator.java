package com.twilio.verify.data.jwt;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.twilio.security.crypto.key.template.ECP256SignerTemplate;
import com.twilio.security.crypto.key.template.SignerTemplate;
import com.twilio.verify.data.Base64EncoderKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/twilio/verify/data/jwt/JwtGenerator;", "", "Lcom/twilio/security/crypto/key/template/SignerTemplate;", "p0", "Lorg/json/JSONObject;", "p1", "p2", "", "PlaceComponentResult", "(Lcom/twilio/security/crypto/key/template/SignerTemplate;Lorg/json/JSONObject;Lorg/json/JSONObject;)Ljava/lang/String;", "Lcom/twilio/verify/data/jwt/JwtSigner;", "getAuthRequestContext", "Lcom/twilio/verify/data/jwt/JwtSigner;", "<init>", "(Lcom/twilio/verify/data/jwt/JwtSigner;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class JwtGenerator {
    private final JwtSigner getAuthRequestContext;

    public JwtGenerator(JwtSigner jwtSigner) {
        Intrinsics.checkParameterIsNotNull(jwtSigner, "");
        this.getAuthRequestContext = jwtSigner;
    }

    public final String PlaceComponentResult(SignerTemplate p0, JSONObject p1, JSONObject p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        p1.put(ClientData.KEY_TYPE, "JWT");
        if (p0 instanceof ECP256SignerTemplate) {
            p1.put("alg", "ES256");
        }
        StringBuilder sb = new StringBuilder();
        String jSONObject = p1.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "");
        Charset charset = Charsets.UTF_8;
        if (jSONObject != null) {
            byte[] bytes = jSONObject.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "");
            sb.append(Base64EncoderKt.PlaceComponentResult(bytes, 11));
            sb.append('.');
            String jSONObject2 = p2.toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "");
            Charset charset2 = Charsets.UTF_8;
            if (jSONObject2 != null) {
                byte[] bytes2 = jSONObject2.getBytes(charset2);
                Intrinsics.checkExpressionValueIsNotNull(bytes2, "");
                sb.append(Base64EncoderKt.PlaceComponentResult(bytes2, 11));
                String obj = sb.toString();
                byte[] PlaceComponentResult = this.getAuthRequestContext.PlaceComponentResult(p0, obj);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append('.');
                sb2.append(Base64EncoderKt.PlaceComponentResult(PlaceComponentResult, 11));
                return sb2.toString();
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
