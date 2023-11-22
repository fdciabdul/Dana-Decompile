package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes8.dex */
public final class m extends Thread {
    public final /* synthetic */ Context BuiltInFictitiousFunctionClassFactory;
    public final /* synthetic */ String PlaceComponentResult;

    public m(Context context, String str) {
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.PlaceComponentResult = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean PlaceComponentResult;
        boolean authRequestContext;
        String KClassImpl$Data$declaredNonStaticMembers$2;
        if (p.PlaceComponentResult()) {
            PlaceComponentResult = n.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
            if (PlaceComponentResult) {
                return;
            }
            String PlaceComponentResult2 = o.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
            if (!TextUtils.isEmpty(PlaceComponentResult2)) {
                authRequestContext = n.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult2, this.PlaceComponentResult);
                if (!authRequestContext) {
                    HMSLog.d("ReportAaidToken", "This time need not report.");
                    return;
                }
                String BuiltInFictitiousFunctionClassFactory = AGConnectServicesConfig.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory("region");
                if (TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory)) {
                    HMSLog.i("ReportAaidToken", "The data storage region is empty.");
                    return;
                }
                String KClassImpl$Data$declaredNonStaticMembers$22 = e.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, "com.huawei.hms.opendevicesdk", "ROOT", BuiltInFictitiousFunctionClassFactory);
                if (TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$22)) {
                    return;
                }
                KClassImpl$Data$declaredNonStaticMembers$2 = n.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult2, this.PlaceComponentResult);
                Context context = this.BuiltInFictitiousFunctionClassFactory;
                StringBuilder sb = new StringBuilder();
                sb.append(KClassImpl$Data$declaredNonStaticMembers$22);
                sb.append("/rest/appdata/v1/aaid/report");
                n.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, d.BuiltInFictitiousFunctionClassFactory(context, sb.toString(), KClassImpl$Data$declaredNonStaticMembers$2), PlaceComponentResult2, this.PlaceComponentResult);
                return;
            }
            HMSLog.w("ReportAaidToken", "AAID is empty.");
            return;
        }
        HMSLog.d("ReportAaidToken", "Not HW Phone.");
    }
}
