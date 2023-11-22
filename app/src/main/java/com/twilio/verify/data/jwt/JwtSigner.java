package com.twilio.verify.data.jwt;

import com.twilio.security.crypto.key.template.ECP256SignerTemplate;
import com.twilio.security.crypto.key.template.SignerTemplate;
import com.twilio.verify.data.KeyStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0007\u0010\nR\u0014\u0010\u0007\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\f"}, d2 = {"Lcom/twilio/verify/data/jwt/JwtSigner;", "", "Lcom/twilio/security/crypto/key/template/SignerTemplate;", "p0", "", "p1", "", "PlaceComponentResult", "(Lcom/twilio/security/crypto/key/template/SignerTemplate;Ljava/lang/String;)[B", "", "([B)[B", "Lcom/twilio/verify/data/KeyStorage;", "Lcom/twilio/verify/data/KeyStorage;", "<init>", "(Lcom/twilio/verify/data/KeyStorage;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class JwtSigner {
    private final KeyStorage PlaceComponentResult;

    public JwtSigner(KeyStorage keyStorage) {
        Intrinsics.checkParameterIsNotNull(keyStorage, "");
        this.PlaceComponentResult = keyStorage;
    }

    public final byte[] PlaceComponentResult(SignerTemplate p0, String p1) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        byte[] authRequestContext = this.PlaceComponentResult.getAuthRequestContext(p0.getGetAuthRequestContext(), p1);
        return p0 instanceof ECP256SignerTemplate ? PlaceComponentResult(authRequestContext) : authRequestContext;
    }

    private static byte[] PlaceComponentResult(byte[] bArr) {
        int i;
        if (bArr.length < 8 || bArr[0] != 48) {
            throw new IllegalArgumentException("Invalid ECDSA signature format");
        }
        byte b = bArr[1];
        if (b > 0) {
            i = 2;
        } else if (b != -127) {
            throw new IllegalArgumentException("Invalid ECDSA signature format");
        } else {
            i = 3;
        }
        int i2 = bArr[i + 1];
        int i3 = i2;
        while (i3 > 0 && bArr[((i + 2) + i2) - i3] == 0) {
            i3--;
        }
        int i4 = i + 2 + i2;
        int i5 = bArr[i4 + 1];
        int i6 = i5;
        while (i6 > 0 && bArr[((i4 + 2) + i5) - i6] == 0) {
            i6--;
        }
        int max = Math.max(Math.max(i3, i6), 32);
        int i7 = bArr[i - 1] & 255;
        if (i7 != bArr.length - i || i7 != i2 + 2 + 2 + i5 || bArr[i] != 2 || bArr[i4] != 2) {
            throw new IllegalArgumentException("Invalid ECDSA signature format");
        }
        int i8 = max * 2;
        byte[] bArr2 = new byte[i8];
        System.arraycopy(bArr, i4 - i3, bArr2, max - i3, i3);
        System.arraycopy(bArr, ((i4 + 2) + i5) - i6, bArr2, i8 - i6, i6);
        return bArr2;
    }
}
