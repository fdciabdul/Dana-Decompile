package id.dana.data.foundation.logger.rds;

import android.content.Context;
import android.content.pm.PackageManager;
import com.alipay.alipaysecuritysdk.rds.v2.face.RDSClient;
import java.util.HashMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class RDSTracker {
    private static RDSClient KClassImpl$Data$declaredNonStaticMembers$2;
    private static Context getAuthRequestContext;

    @Inject
    public RDSTracker(Context context) {
        getAuthRequestContext = context;
        KClassImpl$Data$declaredNonStaticMembers$2 = new RDSClient();
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2.onPageEndAndZip(getAuthRequestContext, str);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void getAuthRequestContext(RDSEventMapper rDSEventMapper) {
        char c;
        String str;
        String str2;
        String str3 = rDSEventMapper.KClassImpl$Data$declaredNonStaticMembers$2;
        str3.hashCode();
        switch (str3.hashCode()) {
            case -1832046799:
                if (str3.equals("rds_on_page")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -728703201:
                if (str3.equals("rds_on_lost_focus")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -401273308:
                if (str3.equals("rds_on_key_down")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1027841476:
                if (str3.equals("rds_on_control_click")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 2094732302:
                if (str3.equals("rds_on_touch_screen")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c != 0) {
            if (c == 1) {
                KClassImpl$Data$declaredNonStaticMembers$2.onLostFocus(rDSEventMapper.BuiltInFictitiousFunctionClassFactory, rDSEventMapper.getAuthRequestContext, rDSEventMapper.getAuthRequestContext());
                return;
            } else if (c == 2) {
                KClassImpl$Data$declaredNonStaticMembers$2.onKeyDown(rDSEventMapper.BuiltInFictitiousFunctionClassFactory, rDSEventMapper.getAuthRequestContext, rDSEventMapper.PlaceComponentResult);
                return;
            } else if (c == 3) {
                KClassImpl$Data$declaredNonStaticMembers$2.onControlClick(rDSEventMapper.BuiltInFictitiousFunctionClassFactory, rDSEventMapper.getAuthRequestContext);
                return;
            } else if (c != 4) {
                return;
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2.onTouchScreen(rDSEventMapper.BuiltInFictitiousFunctionClassFactory, rDSEventMapper.getAuthRequestContext, rDSEventMapper.lookAheadTest, rDSEventMapper.moveToNextValue);
                return;
            }
        }
        HashMap hashMap = new HashMap();
        try {
            str = getAuthRequestContext.getPackageName();
        } catch (PackageManager.NameNotFoundException unused) {
            str = "";
        }
        try {
            str2 = getAuthRequestContext.getPackageManager().getPackageInfo(getAuthRequestContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused2) {
            str2 = "";
            hashMap.put("page", "Onboarding");
            hashMap.put("appname", str);
            hashMap.put("appver", str2);
            hashMap.put("user", "");
            hashMap.put(RDSConstant.KEY_PAGE_SRC, "");
            hashMap.put(RDSConstant.KEY_PRE_PAGE, "");
            hashMap.put("appkey", RDSConstant.APP_KEY);
            hashMap.put(RDSConstant.KEY_PB_SWITCH, RDSConstant.PB_SWITCH);
            KClassImpl$Data$declaredNonStaticMembers$2.onPage(getAuthRequestContext, hashMap, false);
        }
        hashMap.put("page", "Onboarding");
        hashMap.put("appname", str);
        hashMap.put("appver", str2);
        hashMap.put("user", "");
        hashMap.put(RDSConstant.KEY_PAGE_SRC, "");
        hashMap.put(RDSConstant.KEY_PRE_PAGE, "");
        hashMap.put("appkey", RDSConstant.APP_KEY);
        hashMap.put(RDSConstant.KEY_PB_SWITCH, RDSConstant.PB_SWITCH);
        KClassImpl$Data$declaredNonStaticMembers$2.onPage(getAuthRequestContext, hashMap, false);
    }
}
