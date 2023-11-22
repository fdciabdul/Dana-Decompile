package com.alipay.plus.push.core.api.util;

import android.util.Base64;
import com.iap.ac.android.common.utils.security.RSAHelper;
import id.dana.data.here.HereOauthManager;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

/* loaded from: classes7.dex */
public class SignUtil {
    public static String sign(String str, String str2, String str3) {
        try {
            PrivateKey privateKeyFromX509 = getPrivateKeyFromX509(RSAHelper.DEFAULT_ALGORITHM, str2);
            Signature signature = Signature.getInstance("SHA256WithRSA");
            signature.initSign(privateKeyFromX509);
            signature.update(str.getBytes(str3));
            return new String(Base64.encode(signature.sign(), 0));
        } catch (Exception unused) {
            return null;
        }
    }

    private static PrivateKey getPrivateKeyFromX509(String str, String str2) {
        try {
            return KeyFactory.getInstance(str).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str2.getBytes(HereOauthManager.ENC), 0)));
        } catch (Exception unused) {
            return null;
        }
    }
}
