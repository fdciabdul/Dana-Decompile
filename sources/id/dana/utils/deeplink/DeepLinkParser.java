package id.dana.utils.deeplink;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import id.dana.utils.deeplink.DeepLinkConstant;

/* loaded from: classes2.dex */
public class DeepLinkParser {
    private static boolean BuiltInFictitiousFunctionClassFactory;
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private static boolean MyBillsEntityDataFactory;
    private static boolean PlaceComponentResult;
    private static boolean getAuthRequestContext;
    private static String scheduleImpl;

    private DeepLinkParser() {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Activity activity) {
        if (activity != null) {
            moveToNextValue(activity);
            BuiltInFictitiousFunctionClassFactory = scheduleImpl(activity);
            PlaceComponentResult = BuiltInFictitiousFunctionClassFactory(activity);
            KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory(activity);
            MyBillsEntityDataFactory = lookAheadTest(activity);
            getAuthRequestContext = getAuthRequestContext(activity);
        }
    }

    public static void getErrorConfigVersion() {
        getAuthRequestContext = false;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Activity activity) {
        return KClassImpl$Data$declaredNonStaticMembers$2(activity, DeepLinkConstant.DeepLinkPath.CASHOUT);
    }

    private static boolean MyBillsEntityDataFactory(Activity activity) {
        return KClassImpl$Data$declaredNonStaticMembers$2(activity, DeepLinkConstant.DeepLinkPath.LUCKY_MONEY);
    }

    private static boolean lookAheadTest(Activity activity) {
        return KClassImpl$Data$declaredNonStaticMembers$2(activity, DeepLinkConstant.DeepLinkPath.SPIN_THE_WHEEL);
    }

    private static boolean scheduleImpl(Activity activity) {
        Intent intent = activity.getIntent();
        return ((intent.getFlags() & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) == 1048576 || intent == null || !"android.nfc.action.TECH_DISCOVERED".equals(intent.getAction())) ? false : true;
    }

    private static boolean getAuthRequestContext(Activity activity) {
        String str;
        return (!PlaceComponentResult(activity) || (str = scheduleImpl) == null || str.isEmpty()) ? false : true;
    }

    private static boolean PlaceComponentResult(Activity activity) {
        return KClassImpl$Data$declaredNonStaticMembers$2(activity, DeepLinkConstant.DeepLinkPath.LINK_PAYMENT) || KClassImpl$Data$declaredNonStaticMembers$2(activity, DeepLinkConstant.DeepLinkPath.LINK_PAYMENT_P2M);
    }

    public static void getAuthRequestContext() {
        KClassImpl$Data$declaredNonStaticMembers$2(null);
    }

    public static boolean scheduleImpl() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static boolean PlaceComponentResult() {
        return PlaceComponentResult;
    }

    public static boolean lookAheadTest() {
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static boolean moveToNextValue() {
        return getAuthRequestContext;
    }

    public static String BuiltInFictitiousFunctionClassFactory() {
        return scheduleImpl;
    }

    public static boolean MyBillsEntityDataFactory() {
        return PlaceComponentResult || KClassImpl$Data$declaredNonStaticMembers$2 || MyBillsEntityDataFactory || BuiltInFictitiousFunctionClassFactory || getAuthRequestContext;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Activity activity, String str) {
        Uri uri;
        if (activity == null || (uri = activity.getIntent().getData()) == null) {
            uri = null;
        }
        String path = uri != null ? uri.getPath() : null;
        return path != null && path.equals(str);
    }

    private static void moveToNextValue(Activity activity) {
        Uri uri;
        if (activity == null || (uri = activity.getIntent().getData()) == null) {
            uri = null;
        }
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("params");
            if (queryParameter != null && PlaceComponentResult(activity) && queryParameter.contains("[orderId=")) {
                scheduleImpl = queryParameter.replace("[orderId=", "").replace("]", "");
            } else {
                scheduleImpl = uri.getQueryParameter("orderId");
            }
        }
    }
}
