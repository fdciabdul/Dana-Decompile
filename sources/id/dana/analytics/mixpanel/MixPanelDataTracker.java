package id.dana.analytics.mixpanel;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import com.fullstory.instrumentation.InstrumentInjector;
import com.mixpanel.android.mpmetrics.AnalyticsMessages;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.PersistentIdentity;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.rum.Rum;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MixPanelDataTracker {
    private static boolean getAuthRequestContext;

    private MixPanelDataTracker() {
    }

    public static void MyBillsEntityDataFactory(boolean z) {
        getAuthRequestContext = z;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, boolean z) {
        MixpanelAPI KClassImpl$Data$declaredNonStaticMembers$2 = getAuthRequestContext ? MixpanelAPI.KClassImpl$Data$declaredNonStaticMembers$2(context, "ded2d68965bbd813d33d686ee165bae7") : null;
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null || TextUtils.isEmpty(str)) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(str, null);
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.lookAheadTest());
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new AnalyticsMessages.FlushDescription(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion));
    }

    public static String MyBillsEntityDataFactory(Context context) {
        MixpanelAPI KClassImpl$Data$declaredNonStaticMembers$2 = getAuthRequestContext ? MixpanelAPI.KClassImpl$Data$declaredNonStaticMembers$2(context, "ded2d68965bbd813d33d686ee165bae7") : null;
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            return KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.lookAheadTest();
        }
        return null;
    }

    public static void PlaceComponentResult(Context context, String str, boolean z) {
        MixpanelAPI KClassImpl$Data$declaredNonStaticMembers$2 = getAuthRequestContext ? MixpanelAPI.KClassImpl$Data$declaredNonStaticMembers$2(context, "ded2d68965bbd813d33d686ee165bae7") : null;
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null || TextUtils.isEmpty(str)) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(str);
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl.BuiltInFictitiousFunctionClassFactory(str);
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new AnalyticsMessages.FlushDescription(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion));
    }

    public static void PlaceComponentResult(Context context) {
        MixpanelAPI KClassImpl$Data$declaredNonStaticMembers$2 = getAuthRequestContext ? MixpanelAPI.KClassImpl$Data$declaredNonStaticMembers$2(context, "ded2d68965bbd813d33d686ee165bae7") : null;
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null || !KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(UserInfoManager.instance().getUserId());
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context) {
        MixpanelAPI KClassImpl$Data$declaredNonStaticMembers$2 = getAuthRequestContext ? MixpanelAPI.KClassImpl$Data$declaredNonStaticMembers$2(context, "ded2d68965bbd813d33d686ee165bae7") : null;
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null || KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, JSONObject jSONObject) {
        MixpanelAPI KClassImpl$Data$declaredNonStaticMembers$2 = getAuthRequestContext ? MixpanelAPI.KClassImpl$Data$declaredNonStaticMembers$2(context, "ded2d68965bbd813d33d686ee165bae7") : null;
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null || KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.PlaceComponentResult(jSONObject);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        MixpanelAPI KClassImpl$Data$declaredNonStaticMembers$2 = getAuthRequestContext ? MixpanelAPI.KClassImpl$Data$declaredNonStaticMembers$2(context, "ded2d68965bbd813d33d686ee165bae7") : null;
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            JSONObject MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
            if (!KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
                KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new AnalyticsMessages.FlushDescription(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion));
            }
            if (KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
                return;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.PlaceComponentResult(MyBillsEntityDataFactory);
        }
    }

    public static void getAuthRequestContext(Context context, JSONObject jSONObject) {
        MixpanelAPI.PeopleImpl peopleImpl;
        MixpanelAPI KClassImpl$Data$declaredNonStaticMembers$2 = getAuthRequestContext ? MixpanelAPI.KClassImpl$Data$declaredNonStaticMembers$2(context, "ded2d68965bbd813d33d686ee165bae7") : null;
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null || (peopleImpl = KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl) == null) {
            return;
        }
        peopleImpl.PlaceComponentResult(jSONObject);
        peopleImpl.KClassImpl$Data$declaredNonStaticMembers$2("Update Count", 1.0d);
        if (KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new AnalyticsMessages.FlushDescription(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion));
    }

    public static void MyBillsEntityDataFactory(Context context, JSONObject jSONObject) {
        MixpanelAPI.PeopleImpl peopleImpl;
        MixpanelAPI KClassImpl$Data$declaredNonStaticMembers$2 = getAuthRequestContext ? MixpanelAPI.KClassImpl$Data$declaredNonStaticMembers$2(context, "ded2d68965bbd813d33d686ee165bae7") : null;
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null || (peopleImpl = KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl) == null) {
            return;
        }
        peopleImpl.MyBillsEntityDataFactory(jSONObject);
        if (KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new AnalyticsMessages.FlushDescription(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion));
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        MixpanelAPI KClassImpl$Data$declaredNonStaticMembers$2 = getAuthRequestContext ? MixpanelAPI.KClassImpl$Data$declaredNonStaticMembers$2(context, "ded2d68965bbd813d33d686ee165bae7") : null;
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null || KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2) {
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.put(str, Long.valueOf(currentTimeMillis));
            PersistentIdentity persistentIdentity = KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue;
            Long valueOf = Long.valueOf(currentTimeMillis);
            try {
                SharedPreferences.Editor edit = persistentIdentity.DatabaseTableConfigUtil.get().edit();
                edit.putLong(str, valueOf.longValue());
                PersistentIdentity.getAuthRequestContext(edit);
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    public static void PlaceComponentResult(Context context, String str, JSONObject jSONObject) {
        MixpanelAPI KClassImpl$Data$declaredNonStaticMembers$2 = getAuthRequestContext ? MixpanelAPI.KClassImpl$Data$declaredNonStaticMembers$2(context, "ded2d68965bbd813d33d686ee165bae7") : null;
        StringBuilder sb = new StringBuilder();
        sb.append("track: ");
        sb.append(str);
        InstrumentInjector.log_d("Mixpanel", sb.toString());
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            try {
                jSONObject.put(TrackerDataKey.SuperProperties.SPLUNK_SESSION_ID, Rum.CC.BuiltInFictitiousFunctionClassFactory());
            } catch (JSONException unused) {
            }
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(str, jSONObject);
            if (!KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
                KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new AnalyticsMessages.FlushDescription(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion));
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("track: ");
            sb2.append(str);
            sb2.append("success");
            InstrumentInjector.log_d("Mixpanel", sb2.toString());
        }
    }
}
