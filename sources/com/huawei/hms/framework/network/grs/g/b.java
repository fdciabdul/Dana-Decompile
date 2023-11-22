package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.g.h;
import org.json.JSONException;

/* loaded from: classes7.dex */
public class b {
    private final com.huawei.hms.framework.network.grs.e.a BuiltInFictitiousFunctionClassFactory;
    private final Context MyBillsEntityDataFactory;
    private final GrsBaseInfo getAuthRequestContext;

    public b(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo) {
        this.MyBillsEntityDataFactory = context;
        this.getAuthRequestContext = grsBaseInfo;
        this.BuiltInFictitiousFunctionClassFactory = aVar;
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        String str;
        PLSharedPreferences pLSharedPreferences;
        String str2 = com.huawei.hms.framework.network.grs.a.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.getAuthRequestContext("geoipCountryCode", ""), "geoip.countrycode").get("ROOT");
        StringBuilder sb = new StringBuilder();
        sb.append("geoIpCountry is: ");
        sb.append(str2);
        Logger.i("GeoipCountry", sb.toString());
        String authRequestContext = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.getAuthRequestContext("geoipCountryCodetime", "0");
        long j = 0;
        if (!TextUtils.isEmpty(authRequestContext) && authRequestContext.matches("\\d+")) {
            try {
                j = Long.parseLong(authRequestContext);
            } catch (NumberFormatException e) {
                Logger.w("GeoipCountry", "convert urlParamKey from String to Long catch NumberFormatException.", e);
            }
        }
        if (TextUtils.isEmpty(str2) || com.huawei.hms.framework.network.grs.h.e.MyBillsEntityDataFactory(Long.valueOf(j))) {
            com.huawei.hms.framework.network.grs.g.k.c cVar = new com.huawei.hms.framework.network.grs.g.k.c(this.getAuthRequestContext, this.MyBillsEntityDataFactory);
            cVar.KClassImpl$Data$declaredNonStaticMembers$2.add("geoip.countrycode");
            com.huawei.hms.framework.network.grs.e.c cVar2 = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
            if (cVar2 != null) {
                try {
                    str = i.getAuthRequestContext(cVar2.getAuthRequestContext("services", ""), cVar.KClassImpl$Data$declaredNonStaticMembers$2.size() == 0 ? cVar.PlaceComponentResult() : cVar.KClassImpl$Data$declaredNonStaticMembers$2());
                } catch (JSONException e2) {
                    Logger.w("GeoipCountry", "getGeoipCountry merge services occure jsonException. %s", StringUtils.anonymizeMessage(e2.getMessage()));
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && (pLSharedPreferences = cVar2.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                    synchronized (pLSharedPreferences) {
                        cVar2.KClassImpl$Data$declaredNonStaticMembers$2.putString("services", str);
                    }
                }
            }
            if (z) {
                d KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(cVar, "geoip.countrycode", cVar2);
                if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    str2 = com.huawei.hms.framework.network.grs.a.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, "geoip.countrycode").get("ROOT");
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("sync request to query geoip.countrycode is:");
                sb2.append(str2);
                Logger.i("GeoipCountry", sb2.toString());
            } else {
                Logger.i("GeoipCountry", "async request to query geoip.countrycode");
                h hVar = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0;
                hVar.getAuthRequestContext.execute(new h.b(cVar, "geoip.countrycode", cVar2, null));
            }
        }
        return str2;
    }
}
