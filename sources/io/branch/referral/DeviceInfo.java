package io.branch.referral;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import io.branch.referral.Defines;
import io.branch.referral.SystemObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DeviceInfo {
    private static DeviceInfo BuiltInFictitiousFunctionClassFactory;
    final SystemObserver KClassImpl$Data$declaredNonStaticMembers$2 = new SystemObserverInstance();
    final Context PlaceComponentResult;

    public static DeviceInfo KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = new DeviceInfo(context);
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static DeviceInfo getAuthRequestContext() {
        return BuiltInFictitiousFunctionClassFactory;
    }

    private DeviceInfo(Context context) {
        this.PlaceComponentResult = context;
    }

    public static void BuiltInFictitiousFunctionClassFactory(PrefHelper prefHelper, JSONObject jSONObject) {
        int i;
        if (prefHelper != null) {
            try {
                String key = Defines.Jsonkey.LATDAttributionWindow.getKey();
                i = PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getInt("bnc_latd_attributon_window", 0);
                jSONObject.put(key, i);
            } catch (JSONException unused) {
            }
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return SystemObserver.scheduleImpl(this.PlaceComponentResult);
    }

    public static boolean BuiltInFictitiousFunctionClassFactory() {
        return Branch.getAuthRequestContext() || BranchUtil.getAuthRequestContext();
    }

    public static String MyBillsEntityDataFactory() {
        return SystemObserver.BuiltInFictitiousFunctionClassFactory();
    }

    private static String BuiltInFictitiousFunctionClassFactory(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                return WebSettings.getDefaultUserAgent(context);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class SystemObserverInstance extends SystemObserver {
        public SystemObserverInstance() {
            DeviceInfo.this = r1;
        }
    }

    public static boolean getAuthRequestContext(String str) {
        return TextUtils.isEmpty(str) || str.equals("bnc_no_value");
    }

    public final void PlaceComponentResult(Context context, PrefHelper prefHelper, JSONObject jSONObject) {
        try {
            SystemObserver.UniqueId authRequestContext = SystemObserver.getAuthRequestContext(this.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory());
            if (!getAuthRequestContext(authRequestContext.PlaceComponentResult) && authRequestContext.getAuthRequestContext()) {
                jSONObject.put(Defines.Jsonkey.AndroidID.getKey(), authRequestContext.PlaceComponentResult);
            } else {
                jSONObject.put(Defines.Jsonkey.UnidentifiedDevice.getKey(), true);
            }
            String moveToNextValue = SystemObserver.moveToNextValue();
            if (!getAuthRequestContext(moveToNextValue)) {
                jSONObject.put(Defines.Jsonkey.Brand.getKey(), moveToNextValue);
            }
            String lookAheadTest = SystemObserver.lookAheadTest();
            if (!getAuthRequestContext(lookAheadTest)) {
                jSONObject.put(Defines.Jsonkey.Model.getKey(), lookAheadTest);
            }
            DisplayMetrics errorConfigVersion = SystemObserver.getErrorConfigVersion(this.PlaceComponentResult);
            jSONObject.put(Defines.Jsonkey.ScreenDpi.getKey(), errorConfigVersion.densityDpi);
            jSONObject.put(Defines.Jsonkey.ScreenHeight.getKey(), errorConfigVersion.heightPixels);
            jSONObject.put(Defines.Jsonkey.ScreenWidth.getKey(), errorConfigVersion.widthPixels);
            String BuiltInFictitiousFunctionClassFactory2 = SystemObserver.BuiltInFictitiousFunctionClassFactory();
            if (!getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2)) {
                jSONObject.put(Defines.Jsonkey.OS.getKey(), BuiltInFictitiousFunctionClassFactory2);
            }
            jSONObject.put(Defines.Jsonkey.OSVersion.getKey(), SystemObserver.PlaceComponentResult());
            String authRequestContext2 = SystemObserver.getAuthRequestContext();
            if (!TextUtils.isEmpty(authRequestContext2)) {
                jSONObject.put(Defines.Jsonkey.Country.getKey(), authRequestContext2);
            }
            String MyBillsEntityDataFactory = SystemObserver.MyBillsEntityDataFactory();
            if (!TextUtils.isEmpty(MyBillsEntityDataFactory)) {
                jSONObject.put(Defines.Jsonkey.Language.getKey(), MyBillsEntityDataFactory);
            }
            String KClassImpl$Data$declaredNonStaticMembers$2 = SystemObserver.KClassImpl$Data$declaredNonStaticMembers$2();
            if (!TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$2)) {
                jSONObject.put(Defines.Jsonkey.LocalIP.getKey(), KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (prefHelper != null) {
                if (!getAuthRequestContext(PrefHelper.lookAheadTest("bnc_device_fingerprint_id"))) {
                    jSONObject.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), PrefHelper.lookAheadTest("bnc_device_fingerprint_id"));
                }
                String lookAheadTest2 = PrefHelper.lookAheadTest("bnc_identity");
                if (!getAuthRequestContext(lookAheadTest2)) {
                    jSONObject.put(Defines.Jsonkey.DeveloperIdentity.getKey(), lookAheadTest2);
                }
            }
            if (prefHelper != null && prefHelper.getErrorConfigVersion()) {
                String PlaceComponentResult = SystemObserver.PlaceComponentResult(this.PlaceComponentResult);
                if (!getAuthRequestContext(PlaceComponentResult)) {
                    jSONObject.put(Defines.ModuleNameKeys.imei.getKey(), PlaceComponentResult);
                }
            }
            jSONObject.put(Defines.Jsonkey.AppVersion.getKey(), SystemObserver.MyBillsEntityDataFactory(this.PlaceComponentResult));
            jSONObject.put(Defines.Jsonkey.SDK.getKey(), "android");
            jSONObject.put(Defines.Jsonkey.SdkVersion.getKey(), BuildConfig.VERSION_NAME);
            jSONObject.put(Defines.Jsonkey.UserAgent.getKey(), BuiltInFictitiousFunctionClassFactory(context));
        } catch (JSONException unused) {
        }
    }
}
