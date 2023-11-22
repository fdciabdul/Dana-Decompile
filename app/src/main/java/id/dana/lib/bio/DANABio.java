package id.dana.lib.bio;

import android.content.Context;
import com.alipay.mobile.security.bio.service.local.apsecurity.ApSecurityService;
import com.ap.zoloz.hummer.api.EkycFacade;

/* loaded from: classes5.dex */
public class DANABio {
    private static DANABio PlaceComponentResult;

    private DANABio() {
    }

    public static DANABio KClassImpl$Data$declaredNonStaticMembers$2() {
        if (PlaceComponentResult == null) {
            synchronized (DANABio.class) {
                if (PlaceComponentResult == null) {
                    PlaceComponentResult = new DANABio();
                }
            }
        }
        return PlaceComponentResult;
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        EkycFacade.init(context);
        ApSecurityService.setStaticApDidToken(str);
    }
}
