package io.branch.referral;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PrefHelper {
    public static JSONObject BuiltInFictitiousFunctionClassFactory;
    public static PrefHelper MyBillsEntityDataFactory;
    private static String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public static String getAuthRequestContext;
    private static boolean getErrorConfigVersion;
    public SharedPreferences KClassImpl$Data$declaredNonStaticMembers$2;
    final JSONObject PlaceComponentResult;
    private final JSONObject lookAheadTest;
    SharedPreferences.Editor moveToNextValue;
    final JSONObject scheduleImpl;

    private PrefHelper(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("branch_referral_shared_pref", 0);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sharedPreferences;
        this.moveToNextValue = sharedPreferences.edit();
        this.scheduleImpl = new JSONObject();
        this.PlaceComponentResult = new JSONObject();
        this.lookAheadTest = new JSONObject();
    }

    public static PrefHelper BuiltInFictitiousFunctionClassFactory(Context context) {
        if (MyBillsEntityDataFactory == null) {
            MyBillsEntityDataFactory = new PrefHelper(context);
        }
        return MyBillsEntityDataFactory;
    }

    public static String getAuthRequestContext() {
        if (URLUtil.isHttpsUrl(NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            return NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        return Build.VERSION.SDK_INT >= 20 ? "https://api2.branch.io/" : "https://api.branch.io/";
    }

    public final boolean getErrorConfigVersion(String str) {
        getAuthRequestContext = str;
        String string = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_branch_key", "bnc_no_value");
        if (str == null || string == null || !string.equals(str)) {
            String string2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_link_click_id", "bnc_no_value");
            String string3 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_link_click_identifier", "bnc_no_value");
            String string4 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_app_link", "bnc_no_value");
            String string5 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_push_identifier", "bnc_no_value");
            this.moveToNextValue.clear();
            MyBillsEntityDataFactory.moveToNextValue.putString("bnc_link_click_id", string2);
            MyBillsEntityDataFactory.moveToNextValue.apply();
            MyBillsEntityDataFactory.moveToNextValue.putString("bnc_link_click_identifier", string3);
            MyBillsEntityDataFactory.moveToNextValue.apply();
            MyBillsEntityDataFactory.moveToNextValue.putString("bnc_app_link", string4);
            MyBillsEntityDataFactory.moveToNextValue.apply();
            MyBillsEntityDataFactory.moveToNextValue.putString("bnc_push_identifier", string5);
            MyBillsEntityDataFactory.moveToNextValue.apply();
            MyBillsEntityDataFactory.moveToNextValue.apply();
            MyBillsEntityDataFactory.moveToNextValue.putString("bnc_branch_key", str);
            MyBillsEntityDataFactory.moveToNextValue.apply();
            return true;
        }
        return false;
    }

    public static boolean scheduleImpl() {
        return getAuthRequestContext("bnc_triggered_by_fb_app_link");
    }

    public static void lookAheadTest() {
        MyBillsEntityDataFactory.moveToNextValue.putBoolean("bnc_is_full_app_conversion", Boolean.FALSE.booleanValue());
        MyBillsEntityDataFactory.moveToNextValue.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean moveToNextValue() {
        return getAuthRequestContext("bnc_limit_facebook_tracking");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(ArrayList<String> arrayList) {
        if (arrayList.size() != 0) {
            MyBillsEntityDataFactory.moveToNextValue.putString("bnc_buckets", getAuthRequestContext(arrayList));
            MyBillsEntityDataFactory.moveToNextValue.apply();
            return;
        }
        MyBillsEntityDataFactory.moveToNextValue.putString("bnc_buckets", "bnc_no_value");
        MyBillsEntityDataFactory.moveToNextValue.apply();
    }

    public static void getAuthRequestContext(String str, int i) {
        ArrayList<String> MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
        if (!MyBillsEntityDataFactory2.contains(str)) {
            MyBillsEntityDataFactory2.add(str);
            PlaceComponentResult(MyBillsEntityDataFactory2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bnc_credit_base_");
        sb.append(str);
        MyBillsEntityDataFactory.moveToNextValue.putInt(sb.toString(), i);
        MyBillsEntityDataFactory.moveToNextValue.apply();
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("bnc_credit_base_");
        sb.append(str);
        return MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getInt(sb.toString(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(ArrayList<String> arrayList) {
        if (arrayList.size() != 0) {
            MyBillsEntityDataFactory.moveToNextValue.putString("bnc_actions", getAuthRequestContext(arrayList));
            MyBillsEntityDataFactory.moveToNextValue.apply();
            return;
        }
        MyBillsEntityDataFactory.moveToNextValue.putString("bnc_actions", "bnc_no_value");
        MyBillsEntityDataFactory.moveToNextValue.apply();
    }

    private static String getAuthRequestContext(ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        String str = "";
        while (it.hasNext()) {
            String next = it.next();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(next);
            sb.append(",");
            str = sb.toString();
        }
        return str.substring(0, str.length() - 1);
    }

    public static String lookAheadTest(String str) {
        return MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString(str, "bnc_no_value");
    }

    public static boolean getAuthRequestContext(String str) {
        return MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getBoolean(str, false);
    }

    public static void PlaceComponentResult(String str, int i) {
        MyBillsEntityDataFactory.moveToNextValue.putInt(str, i);
        MyBillsEntityDataFactory.moveToNextValue.apply();
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str, long j) {
        MyBillsEntityDataFactory.moveToNextValue.putLong(str, j);
        MyBillsEntityDataFactory.moveToNextValue.apply();
    }

    public static void getAuthRequestContext(String str, String str2) {
        MyBillsEntityDataFactory.moveToNextValue.putString(str, str2);
        MyBillsEntityDataFactory.moveToNextValue.apply();
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, Boolean bool) {
        MyBillsEntityDataFactory.moveToNextValue.putBoolean(str, bool.booleanValue());
        MyBillsEntityDataFactory.moveToNextValue.apply();
    }

    public static int BuiltInFictitiousFunctionClassFactory(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("bnc_branch_view_use_");
        sb.append(str);
        return MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getInt(sb.toString(), 0);
    }

    public static JSONObject KClassImpl$Data$declaredNonStaticMembers$2() {
        JSONObject jSONObject = BuiltInFictitiousFunctionClassFactory;
        if (jSONObject == null) {
            String string = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_branch_analytical_data", "bnc_no_value");
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(string) && !string.equals("bnc_no_value")) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            return jSONObject2;
        }
        return jSONObject;
    }

    public final void MyBillsEntityDataFactory(String str, String str2) {
        if (str == null) {
            return;
        }
        if (this.scheduleImpl.has(str) && str2 == null) {
            this.scheduleImpl.remove(str);
        }
        try {
            this.scheduleImpl.put(str, str2);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String scheduleImpl(String str) {
        if (str == null) {
            return null;
        }
        try {
            return this.PlaceComponentResult.get(str).toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String moveToNextValue(String str) {
        if (str == null) {
            return null;
        }
        try {
            return this.lookAheadTest.get(str).toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getErrorConfigVersion() {
        return this.lookAheadTest.length() != 0;
    }

    public static void MyBillsEntityDataFactory(String str) {
        if ((BranchUtil.getAuthRequestContext() || getErrorConfigVersion) && !TextUtils.isEmpty(str)) {
            InstrumentInjector.log_i("BranchSDK", str);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, Throwable th) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InstrumentInjector.log_e("BranchSDK", str, th);
    }

    public static void PlaceComponentResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InstrumentInjector.log_i("BranchSDK", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult() {
        getErrorConfigVersion = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<String> BuiltInFictitiousFunctionClassFactory() {
        String string = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_actions", "bnc_no_value");
        if (string.equals("bnc_no_value")) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, string.split(","));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<String> MyBillsEntityDataFactory() {
        String string = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_buckets", "bnc_no_value");
        if (string.equals("bnc_no_value")) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, string.split(","));
        return arrayList;
    }

    public static void MyBillsEntityDataFactory(Boolean bool) {
        MyBillsEntityDataFactory.moveToNextValue.putBoolean("bnc_triggered_by_fb_app_link", bool.booleanValue());
        MyBillsEntityDataFactory.moveToNextValue.apply();
    }
}
