package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import id.dana.data.geocode.mapper.GeocoderResultMapperKt;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class n {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public enum a {
        MOBILE("1"),
        PC("2"),
        TABLET("3"),
        TV("4"),
        SOUNDBOX("5"),
        GLASS("6"),
        WATCH("7"),
        VEHICLE("8"),
        OFFICE_DEVICE(PrepareException.ERROR_OFFLINE_APP),
        IOT_DEVICES("10"),
        HEALTHY("11"),
        ENTERTAINMENT("12"),
        TRANSPORT_DEVICES("13");


        /* renamed from: o  reason: collision with root package name */
        public String f7476o;

        a(String str) {
            this.f7476o = str;
        }

        public final String a() {
            return this.f7476o;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public enum b {
        IOS("ios"),
        ANDROID("android"),
        HARMONY("harmony"),
        WINDOWS(ResourceAttributes.OsTypeValues.WINDOWS),
        EMBED("embed"),
        OTHERS("others");

        public String h;

        b(String str) {
            this.h = str;
        }

        public final String a() {
            return this.h;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("timezone", TimeZone.getDefault().getID());
            jSONObject2.put(GeocoderResultMapperKt.COUNTRY, SystemUtils.getLocalCountry());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("agent_version", new PackageManagerHelper(context).getPackageVersionName("com.huawei.android.pushagent"));
            jSONObject3.put("hms_version", String.valueOf(Util.getHmsVersion(context)));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("dev_type", a.MOBILE.a());
            jSONObject4.put("dev_sub_type", "phone");
            jSONObject4.put("os_type", b.ANDROID.a());
            jSONObject4.put("os_version", String.valueOf(HwBuildEx.VERSION.EMUI_SDK_INT));
            jSONObject.put("id", UUID.randomUUID().toString());
            jSONObject.put("global", jSONObject2);
            jSONObject.put("push_agent", jSONObject3);
            jSONObject.put("hardware", jSONObject4);
            jSONObject.put("aaid", str);
            jSONObject.put("token", str2);
            jSONObject.put("app_id", AGConnectServicesConfig.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory("client/app_id"));
            jSONObject.put("region", AGConnectServicesConfig.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory("region"));
            return jSONObject.toString();
        } catch (JSONException unused) {
            HMSLog.e("ReportAaidToken", "Catch JSONException.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getAuthRequestContext(Context context, String str, String str2) {
        i BuiltInFictitiousFunctionClassFactory = i.BuiltInFictitiousFunctionClassFactory(context);
        if (!BuiltInFictitiousFunctionClassFactory.getAuthRequestContext("reportAaidAndToken")) {
            HMSLog.d("ReportAaidToken", "It hasn't been reported, this time needs report.");
            return true;
        }
        SharedPreferences sharedPreferences = BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
        if (TextUtils.isEmpty(sharedPreferences != null ? sharedPreferences.getString("reportAaidAndToken", "") : "")) {
            HMSLog.e("ReportAaidToken", "It has been reported, but sp file is empty, this time needs report.");
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        return !r1.equals(r.PlaceComponentResult(sb.toString(), "SHA-256"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean PlaceComponentResult(Context context) {
        int packageVersionCode = new PackageManagerHelper(context).getPackageVersionCode("com.huawei.android.pushagent");
        StringBuilder sb = new StringBuilder();
        sb.append("NC version code: ");
        sb.append(packageVersionCode);
        HMSLog.d("ReportAaidToken", sb.toString());
        return (90101400 <= packageVersionCode && packageVersionCode < 100000000) || packageVersionCode >= 100001301;
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        new m(context, str).start();
    }

    public static /* synthetic */ void getAuthRequestContext(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            HMSLog.e("ReportAaidToken", "Https response is empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("ret", 256);
            if (optInt == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append(str2);
                boolean MyBillsEntityDataFactory = i.BuiltInFictitiousFunctionClassFactory(context).MyBillsEntityDataFactory("reportAaidAndToken", r.PlaceComponentResult(sb.toString(), "SHA-256"));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Report success ");
                sb2.append(MyBillsEntityDataFactory ? "and save success." : "but save failure.");
                HMSLog.d("ReportAaidToken", sb2.toString());
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Https response body's ret code: ");
            sb3.append(optInt);
            sb3.append(", error message: ");
            sb3.append(jSONObject.optString("msg"));
            HMSLog.e("ReportAaidToken", sb3.toString());
        } catch (JSONException unused) {
            HMSLog.e("ReportAaidToken", "Has JSONException.");
        } catch (Exception unused2) {
            HMSLog.e("ReportAaidToken", "Exception occur.");
        }
    }
}
