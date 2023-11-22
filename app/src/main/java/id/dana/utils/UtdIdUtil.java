package id.dana.utils;

import android.content.Context;
import com.alipay.iap.android.common.utils.MiscUtils;
import com.iap.ac.config.lite.ConfigCenter;
import id.dana.lib.gcontainer.GContainer;

/* loaded from: classes2.dex */
public class UtdIdUtil {
    private UtdIdUtil() {
    }

    public static String PlaceComponentResult() {
        Context context;
        ConfigCenter configCenter = ConfigCenter.getInstance();
        try {
            context = GContainer.getApplicationContext();
        } catch (IllegalStateException unused) {
            context = null;
        }
        return (!configCenter.isInitialized() || context == null) ? "" : configCenter.getConfigContext().getIdentifierProvider().getUtdId(context);
    }

    public static String MyBillsEntityDataFactory() {
        String md5 = MiscUtils.md5(PlaceComponentResult());
        return md5.length() >= 16 ? md5.substring(0, 16).toUpperCase() : "";
    }
}
