package com.huawei.secure.android.common.encrypt.hash;

import android.os.Build;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/* loaded from: classes8.dex */
public abstract class PBKDF2 {
    private static final String PlaceComponentResult = "PBKDF2";

    public static byte[] getAuthRequestContext(char[] cArr, byte[] bArr, int i) {
        return getAuthRequestContext(cArr, bArr, 10000, i, false);
    }

    private static byte[] getAuthRequestContext(char[] cArr, byte[] bArr, int i, int i2, boolean z) {
        SecretKeyFactory secretKeyFactory;
        try {
            PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr, bArr, 10000, i2);
            if (z) {
                secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            } else {
                secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            }
            return secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            String str = PlaceComponentResult;
            StringBuilder sb = new StringBuilder();
            sb.append("pbkdf exception : ");
            sb.append(e.getMessage());
            b.PlaceComponentResult(str, sb.toString());
            return new byte[0];
        }
    }

    public static byte[] BuiltInFictitiousFunctionClassFactory(char[] cArr, byte[] bArr, int i) {
        byte[] bArr2 = new byte[0];
        if (Build.VERSION.SDK_INT < 26) {
            b.PlaceComponentResult(PlaceComponentResult, "system version not high than 26");
            return bArr2;
        }
        return getAuthRequestContext(cArr, bArr, 10000, i, true);
    }
}
