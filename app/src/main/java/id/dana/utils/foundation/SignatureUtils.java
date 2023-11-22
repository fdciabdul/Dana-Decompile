package id.dana.utils.foundation;

import android.content.Context;
import com.alipay.iap.android.common.utils.MiscUtils;

/* loaded from: classes2.dex */
public class SignatureUtils {
    private static String PlaceComponentResult(Context context) {
        try {
            return MiscUtils.md5(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean getAuthRequestContext(Context context) {
        return "861d4dd28461268b3288f87aefdf275d".equalsIgnoreCase(PlaceComponentResult(context));
    }
}
