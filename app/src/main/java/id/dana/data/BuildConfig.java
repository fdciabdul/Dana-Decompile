package id.dana.data;

import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import o.whenAvailable;

/* loaded from: classes8.dex */
public final class BuildConfig {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String AMCS_ENVIRONMENT = "prod";
    public static final String AMCS_LITE_APP_ID = "4B3A8BA311135";
    public static final String AMCS_LITE_GATEWAY_APP_ID = "RTC2347987";
    public static final String AMCS_LITE_GATEWAY_URL = "https://gw-dana.ebuckler.com/imgw.htm";
    public static final String AMCS_LITE_GATEWAY_WORKSPACE_ID = "default";
    public static final String AMCS_LITE_WORKSPACE_ID = "default";
    public static final String APHOME_APPKEY = "23936057";
    public static final String APP_ID = "6CC59C4231550";
    public static final String APP_VERSION_CODE = "2470106";
    public static final String BASE_LOYALTY_WEB_URL = "https://web-loyalty.dana.id";
    public static final String BASE_URL = "https://m.dana.id";
    public static final String BASE_URL_SECURE = "https://m.dana.id";
    public static final String BRANCH_KEY = "key_live_maIkM32pF0ULJer3wXep0aihxukdG5Sq";
    public static final String BUILD_NUMBER = "6";
    public static final String BUILD_TYPE = "release";
    public static final String DB_KEY;
    public static final boolean DEBUG = false;
    public static final String DEEPLINK_ALTERNATE_URL = "danaindonesia-alternate.app.link";
    public static final String DEEPLINK_URL = "link.dana.id";
    public static final String DEFAULT_RPC_GATEWAY = "https://mgs-gw.m.dana.id/mgw.htm";
    public static final String FLAVOR = "production";
    public static final String GOOGLE_API_KEY = "AIzaSyBr8axhuN2K9uREP6j4SjOmbp8OsDnrdC8";
    public static final String HERE_API_KEY = "xbqhfiDFmIRmlcre1uUwvcMIfQZsE3nyDUaFTgRn0-M";
    public static final String HERE_KEY_ID = "TQkf1iPYvmjmvU_tVmIVtg";
    public static final String HERE_KEY_SECRET = "EH3tKuueP_pAm2uR4_xXah-hV2f0b0VQkwfD5USMxeHuTk2FU72zvJ3FU02n8-rn91jS0YdIJyHv-912crnApg";
    public static final boolean IS_ONLINE_ENV = true;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    public static final String LIBRARY_PACKAGE_NAME = "id.dana.data";
    public static final String LOYALTY_BASE_URL = "https://gateway-loyalty.dana.id";
    public static final String MIXPANEL_KEY = "ded2d68965bbd813d33d686ee165bae7";
    public static final String MOCK_BASE_URL = "http://127.0.0.1:7001/data/skywalker/";
    private static long MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 1;
    public static final String RPC_APPKEY = "6CC59C4231550_ANDROID";
    public static final String SIGN_AUTHCODE = "0ce8";
    public static final String SPLIT_KEY_TT_DEVICE = "8jbd3qchur8ehofuhfgqubveas9f6bmsghm0";
    public static final String SPLIT_KEY_TT_USER = "mrclscm2mg1nlni41s5tp9cuq3fh4epmpi68";
    public static final String TENANT_ID = "FKPZXBCN";
    public static final String WORKSPACE_ID = "prod";
    private static char[] getAuthRequestContext;

    static {
        getAuthRequestContext();
        Object[] objArr = new Object[1];
        a(ExpandableListView.getPackedPositionType(0L), ExpandableListView.getPackedPositionChild(0L) + 41, (char) (52479 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), objArr);
        DB_KEY = ((String) objArr[0]).intern();
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    static void getAuthRequestContext() {
        getAuthRequestContext = new char[]{16264, 1202, 18878, 36431, 54019, 6024, 23790, 41376, 58912, 11101, 28563, 46287, 63999, 15921, 819, 18335, 36053, 53505, 5693, 23355, 40877, 58510, 10586, 28224, 45868, 63486, 15543, 275, 17948, 35458, 53218, 5305, 22898, 40534, 57995, 10171, 27814, 45433, 63064, 15046};
        MyBillsEntityDataFactory = -325163684973918085L;
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        int i3 = $10 + 31;
        $11 = i3 % 128;
        int i4 = i3 % 2;
        while (true) {
            if (whenavailable.BuiltInFictitiousFunctionClassFactory >= i2) {
                break;
            }
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getAuthRequestContext[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ MyBillsEntityDataFactory))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i2];
        try {
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                if (!(whenavailable.BuiltInFictitiousFunctionClassFactory >= i2)) {
                    int i5 = $10 + 11;
                    $11 = i5 % 128;
                    int i6 = i5 % 2;
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                } else {
                    objArr[0] = new String(cArr);
                    return;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
