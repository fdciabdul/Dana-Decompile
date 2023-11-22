package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes7.dex */
public class e {
    private static final String BuiltInFictitiousFunctionClassFactory = "e";
    public static final Set<String> getAuthRequestContext = Collections.unmodifiableSet(new a(16));

    /* loaded from: classes7.dex */
    static final class a extends HashSet<String> {
        a(int i) {
            super(i);
            add("ser_country");
            add("reg_country");
            add("issue_country");
            add("geo_ip");
        }
    }

    public static String PlaceComponentResult(Context context, com.huawei.hms.framework.network.grs.e.a aVar, String str, GrsBaseInfo grsBaseInfo, boolean z) {
        String str2;
        StringBuilder sb;
        String str3;
        if (TextUtils.isEmpty(str)) {
            Logger.w(BuiltInFictitiousFunctionClassFactory, "routeBy must be not empty string or null.");
            return null;
        } else if ("no_route".equals(str) || "unconditional".equals(str)) {
            Logger.v(BuiltInFictitiousFunctionClassFactory, "routeBy equals NO_ROUTE_POLICY");
            return "no_route_country";
        } else {
            String serCountry = grsBaseInfo.getSerCountry();
            String regCountry = grsBaseInfo.getRegCountry();
            String issueCountry = grsBaseInfo.getIssueCountry();
            for (String str4 : str.split(SimpleComparison.GREATER_THAN_OPERATION)) {
                if (getAuthRequestContext.contains(str4.trim())) {
                    if ("ser_country".equals(str4.trim()) && !TextUtils.isEmpty(serCountry) && !"UNKNOWN".equals(serCountry)) {
                        str2 = BuiltInFictitiousFunctionClassFactory;
                        sb = new StringBuilder();
                        str3 = "current route_by is serCountry and routerCountry is:";
                    } else if ("reg_country".equals(str4.trim()) && !TextUtils.isEmpty(regCountry) && !"UNKNOWN".equals(regCountry)) {
                        String str5 = BuiltInFictitiousFunctionClassFactory;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("current route_by is regCountry and routerCountry is:");
                        sb2.append(regCountry);
                        Logger.i(str5, sb2.toString());
                        return regCountry;
                    } else if ("issue_country".equals(str4.trim()) && !TextUtils.isEmpty(issueCountry) && !"UNKNOWN".equals(issueCountry)) {
                        String str6 = BuiltInFictitiousFunctionClassFactory;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("current route_by is issueCountry and routerCountry is:");
                        sb3.append(issueCountry);
                        Logger.i(str6, sb3.toString());
                        return issueCountry;
                    } else if ("geo_ip".equals(str4.trim())) {
                        serCountry = new com.huawei.hms.framework.network.grs.g.b(context, aVar, grsBaseInfo).KClassImpl$Data$declaredNonStaticMembers$2(z);
                        str2 = BuiltInFictitiousFunctionClassFactory;
                        sb = new StringBuilder();
                        str3 = "current route_by is geo_ip and routerCountry is: ";
                    }
                    sb.append(str3);
                    sb.append(serCountry);
                    Logger.i(str2, sb.toString());
                    return serCountry;
                }
            }
            return "";
        }
    }
}
