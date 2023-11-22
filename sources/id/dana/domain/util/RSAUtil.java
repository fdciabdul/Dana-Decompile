package id.dana.domain.util;

import android.util.Base64;
import com.iap.ac.android.common.utils.security.RSAHelper;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/util/RSAUtil;", "", "", "data", "key", "decrypt", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Ljava/security/PrivateKey;", "getPrivateKeyFromPKCS8", "(Ljava/lang/String;)Ljava/security/PrivateKey;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RSAUtil {
    public static final RSAUtil INSTANCE = new RSAUtil();

    private RSAUtil() {
    }

    @JvmStatic
    public static final PrivateKey getPrivateKeyFromPKCS8(String key) {
        if (key != null) {
            try {
                byte[] bytes = StringsKt.trim((CharSequence) key).toString().getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "");
                return KeyFactory.getInstance(RSAHelper.DEFAULT_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(bytes, 0)));
            } catch (NoSuchAlgorithmException e) {
                return null;
            } catch (InvalidKeySpecException e2) {
                return null;
            }
        }
        return null;
    }

    @JvmStatic
    public static final String decrypt(String data, String key) {
        String str;
        Intrinsics.checkNotNullParameter(key, "");
        if (data != null) {
            try {
                byte[] decryptBytes = com.alipay.iap.android.common.utils.security.RSAHelper.decryptBytes(Base64.decode(data, 0), getPrivateKeyFromPKCS8(key));
                Intrinsics.checkNotNullExpressionValue(decryptBytes, "");
                Charset charset = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(charset, "");
                str = new String(decryptBytes, charset);
            } catch (Exception e) {
                str = "";
            }
        } else {
            str = null;
        }
        return str == null ? "" : str;
    }
}
