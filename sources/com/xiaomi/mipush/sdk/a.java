package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.iap.ac.android.acs.plugin.interceptor.Interceptor4getAppToken;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {
    private static volatile a KClassImpl$Data$declaredNonStaticMembers$2;
    C0157a BuiltInFictitiousFunctionClassFactory;
    String MyBillsEntityDataFactory;
    Map<String, C0157a> PlaceComponentResult = new HashMap();
    Context getAuthRequestContext;

    /* renamed from: com.xiaomi.mipush.sdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0157a {
        public String BuiltInFictitiousFunctionClassFactory;
        public String MyBillsEntityDataFactory;
        public String NetworkUserEntityData$$ExternalSyntheticLambda0;
        public String NetworkUserEntityData$$ExternalSyntheticLambda2;
        Context PlaceComponentResult;
        public String getErrorConfigVersion;
        public String initRecordTimeStamp;
        public String lookAheadTest;
        public String scheduleImpl;
        public boolean getAuthRequestContext = true;
        public boolean moveToNextValue = false;
        public int KClassImpl$Data$declaredNonStaticMembers$2 = 1;

        public C0157a(Context context) {
            this.PlaceComponentResult = context;
        }

        public static String MyBillsEntityDataFactory(C0157a c0157a) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", c0157a.MyBillsEntityDataFactory);
                jSONObject.put(Interceptor4getAppToken.APP_TOKEN, c0157a.BuiltInFictitiousFunctionClassFactory);
                jSONObject.put("regId", c0157a.lookAheadTest);
                jSONObject.put("regSec", c0157a.getErrorConfigVersion);
                jSONObject.put("devId", c0157a.scheduleImpl);
                jSONObject.put("vName", c0157a.NetworkUserEntityData$$ExternalSyntheticLambda0);
                jSONObject.put("valid", c0157a.getAuthRequestContext);
                jSONObject.put("paused", c0157a.moveToNextValue);
                jSONObject.put("envType", c0157a.KClassImpl$Data$declaredNonStaticMembers$2);
                jSONObject.put("regResource", c0157a.NetworkUserEntityData$$ExternalSyntheticLambda2);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(th);
                return null;
            }
        }

        public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3) {
            this.MyBillsEntityDataFactory = str;
            this.BuiltInFictitiousFunctionClassFactory = str2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str3;
            SharedPreferences.Editor edit = a.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult).edit();
            edit.putString("appId", this.MyBillsEntityDataFactory);
            edit.putString(Interceptor4getAppToken.APP_TOKEN, str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public final boolean BuiltInFictitiousFunctionClassFactory() {
            return getAuthRequestContext(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory);
        }

        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            a.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult).edit().clear().commit();
            this.MyBillsEntityDataFactory = null;
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.lookAheadTest = null;
            this.getErrorConfigVersion = null;
            this.scheduleImpl = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
            this.getAuthRequestContext = false;
            this.moveToNextValue = false;
            this.initRecordTimeStamp = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
        }

        public final boolean getAuthRequestContext(String str, String str2) {
            boolean equals = TextUtils.equals(this.MyBillsEntityDataFactory, str);
            boolean equals2 = TextUtils.equals(this.BuiltInFictitiousFunctionClassFactory, str2);
            boolean z = !TextUtils.isEmpty(this.lookAheadTest);
            boolean z2 = !TextUtils.isEmpty(this.getErrorConfigVersion);
            boolean z3 = TextUtils.equals(this.scheduleImpl, com.xiaomi.channel.commonutils.android.c.getErrorConfigVersion(this.PlaceComponentResult)) || TextUtils.equals(this.scheduleImpl, com.xiaomi.channel.commonutils.android.c.moveToNextValue(this.PlaceComponentResult));
            boolean z4 = equals && equals2 && z && z2 && z3;
            if (!z4) {
                com.xiaomi.channel.commonutils.logger.b.moveToNextValue(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
            }
            return z4;
        }
    }

    public static SharedPreferences BuiltInFictitiousFunctionClassFactory(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    public static a PlaceComponentResult(Context context) {
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            synchronized (a.class) {
                if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    KClassImpl$Data$declaredNonStaticMembers$2 = new a(context);
                }
            }
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        if (this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("Don't send message before initialization succeeded!");
        return false;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
    }

    public final boolean MyBillsEntityDataFactory() {
        return (TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory) || TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory) || TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory.lookAheadTest) || TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion)) ? false : true;
    }

    public final boolean MyBillsEntityDataFactory(String str, String str2) {
        return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(str, str2);
    }

    public final boolean PlaceComponentResult() {
        Context context = this.getAuthRequestContext;
        return !TextUtils.equals(com.xiaomi.channel.commonutils.android.a.BuiltInFictitiousFunctionClassFactory(context, context.getPackageName()), this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    public final boolean getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
    }

    public final boolean scheduleImpl() {
        return !this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
    }

    private a(Context context) {
        this.getAuthRequestContext = context;
        this.BuiltInFictitiousFunctionClassFactory = new C0157a(context);
        SharedPreferences sharedPreferences = this.getAuthRequestContext.getSharedPreferences("mipush", 0);
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = sharedPreferences.getString("appId", null);
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = sharedPreferences.getString(Interceptor4getAppToken.APP_TOKEN, null);
        this.BuiltInFictitiousFunctionClassFactory.lookAheadTest = sharedPreferences.getString("regId", null);
        this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = sharedPreferences.getString("regSec", null);
        this.BuiltInFictitiousFunctionClassFactory.scheduleImpl = sharedPreferences.getString("devId", null);
        if (!TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory.scheduleImpl) && com.xiaomi.channel.commonutils.android.c.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.scheduleImpl)) {
            this.BuiltInFictitiousFunctionClassFactory.scheduleImpl = com.xiaomi.channel.commonutils.android.c.getErrorConfigVersion(this.getAuthRequestContext);
            sharedPreferences.edit().putString("devId", this.BuiltInFictitiousFunctionClassFactory.scheduleImpl).commit();
        }
        this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = sharedPreferences.getString("vName", null);
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = sharedPreferences.getBoolean("valid", true);
        this.BuiltInFictitiousFunctionClassFactory.moveToNextValue = sharedPreferences.getBoolean("paused", false);
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = sharedPreferences.getInt("envType", 1);
        this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = sharedPreferences.getString("regResource", null);
        this.BuiltInFictitiousFunctionClassFactory.initRecordTimeStamp = sharedPreferences.getString("appRegion", null);
    }

    public final void getAuthRequestContext(int i) {
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.getAuthRequestContext.getSharedPreferences("mipush", 0).edit().putInt("envType", i).commit();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory.moveToNextValue = z;
        this.getAuthRequestContext.getSharedPreferences("mipush", 0).edit().putBoolean("paused", z).commit();
    }
}
