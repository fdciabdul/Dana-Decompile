package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import id.dana.analytics.tracker.TrackerKey;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class e {

    /* loaded from: classes8.dex */
    static final class a implements Runnable {
        final /* synthetic */ ArrayList BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ JSONArray KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ long MyBillsEntityDataFactory;

        a(long j, ArrayList arrayList, JSONArray jSONArray) {
            this.MyBillsEntityDataFactory = j;
            this.BuiltInFictitiousFunctionClassFactory = arrayList;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONArray;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            com.huawei.hms.framework.network.grs.g.k.a aVar = new com.huawei.hms.framework.network.grs.g.k.a();
            aVar.put("total_time", this.MyBillsEntityDataFactory);
            Iterator it = this.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar.MyBillsEntityDataFactory() || dVar.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    aVar.put(e.PlaceComponentResult(dVar));
                    it.remove();
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z && this.BuiltInFictitiousFunctionClassFactory.size() > 0) {
                ArrayList arrayList = this.BuiltInFictitiousFunctionClassFactory;
                d dVar2 = (d) arrayList.get(arrayList.size() - 1);
                aVar.put(e.PlaceComponentResult(dVar2));
                this.BuiltInFictitiousFunctionClassFactory.remove(dVar2);
            }
            if (this.BuiltInFictitiousFunctionClassFactory.size() > 0) {
                Iterator it2 = this.BuiltInFictitiousFunctionClassFactory.iterator();
                while (it2.hasNext()) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.put(new JSONObject(e.PlaceComponentResult((d) it2.next())));
                }
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.length() > 0) {
                aVar.put("failed_info", this.KClassImpl$Data$declaredNonStaticMembers$2.toString());
            }
            Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", new JSONObject(aVar.get()));
            HianalyticsHelper.getInstance().onEvent(aVar.get(), "grs_request");
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(ArrayList<d> arrayList, long j, JSONArray jSONArray, Context context) {
        if (context == null || arrayList.size() <= 0 || !HianalyticsHelper.getInstance().isEnableReportNoSeed(context)) {
            return;
        }
        HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j, arrayList, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static LinkedHashMap<String, String> PlaceComponentResult(d dVar) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception exc = dVar.GetContactSyncConfig;
        if (exc != null) {
            linkedHashMapPack.put(TrackerKey.Property.ERROR_CODE_FIREBASE, ExceptionCode.getErrorCodeFromException(exc));
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, exc.getClass().getSimpleName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(exc.getMessage()));
        } else {
            linkedHashMapPack.put(TrackerKey.Property.ERROR_CODE_FIREBASE, dVar.PlaceComponentResult);
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, dVar.scheduleImpl);
        }
        try {
            linkedHashMapPack.put("domain", new URL(dVar.NetworkUserEntityData$$ExternalSyntheticLambda1).getHost());
        } catch (MalformedURLException e) {
            Logger.w("HaReportHelper", "report host MalformedURLException", e);
        }
        linkedHashMapPack.put("req_start_time", dVar.KClassImpl$Data$declaredNonStaticMembers$2);
        linkedHashMapPack.put("req_end_time", dVar.getAuthRequestContext);
        linkedHashMapPack.put("req_total_time", dVar.MyBillsEntityDataFactory);
        return linkedHashMapPack.getAll();
    }
}
