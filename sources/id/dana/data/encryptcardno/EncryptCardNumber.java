package id.dana.data.encryptcardno;

import com.alipay.iap.android.common.utils.security.RSAHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\n\u001a\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/encryptcardno/EncryptCardNumber;", "", "", "p0", "p1", "", "p2", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/Map;Ljava/lang/String;Z)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EncryptCardNumber {
    public static final EncryptCardNumber INSTANCE = new EncryptCardNumber();

    private EncryptCardNumber() {
    }

    @JvmStatic
    public static final String MyBillsEntityDataFactory(String p0, String p1, boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (p2) {
            String encrypt = RSAHelper.encrypt(new JSONObject().put(CardCredInfo.CARD_NO, p0).toString(), p1);
            Intrinsics.checkNotNullExpressionValue(encrypt, "");
            return encrypt;
        }
        return "";
    }

    @JvmStatic
    public static final String BuiltInFictitiousFunctionClassFactory(Map<String, String> p0, String p1, boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (p2) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : p0.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            String encrypt = RSAHelper.encrypt(jSONObject.toString(), p1);
            Intrinsics.checkNotNullExpressionValue(encrypt, "");
            return encrypt;
        }
        return "";
    }
}
