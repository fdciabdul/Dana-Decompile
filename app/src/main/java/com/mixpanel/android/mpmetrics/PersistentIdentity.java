package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.SharedPreferences;
import com.mixpanel.android.util.MPLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PersistentIdentity {
    private static Boolean NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
    static final Object getAuthRequestContext = new Object();
    private static Integer initRecordTimeStamp = null;
    private static boolean isLayoutRequested = true;
    boolean BuiltInFictitiousFunctionClassFactory;
    public final Future<SharedPreferences> DatabaseTableConfigUtil;
    String KClassImpl$Data$declaredNonStaticMembers$2;
    String MyBillsEntityDataFactory;
    final Future<SharedPreferences> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Future<SharedPreferences> NetworkUserEntityData$$ExternalSyntheticLambda7;
    boolean PlaceComponentResult;
    String getErrorConfigVersion;
    final Future<SharedPreferences> lookAheadTest;
    Boolean moveToNextValue;
    Object NetworkUserEntityData$$ExternalSyntheticLambda1 = new Object();
    JSONObject GetContactSyncConfig = null;
    private Map<String, String> newProxyInstance = null;
    boolean scheduleImpl = false;
    private final SharedPreferences.OnSharedPreferenceChangeListener PrepareContext = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.mixpanel.android.mpmetrics.PersistentIdentity.1
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            synchronized (PersistentIdentity.getAuthRequestContext) {
                PersistentIdentity.this.isLayoutRequested();
                PersistentIdentity.getAuthRequestContext();
            }
        }
    };

    static /* synthetic */ boolean getAuthRequestContext() {
        isLayoutRequested = false;
        return false;
    }

    public static String MyBillsEntityDataFactory(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("people_distinct_id", null);
    }

    public static void getAuthRequestContext(Context context, String str, Map<String, String> map) {
        synchronized (getAuthRequestContext) {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                edit.putString(entry.getKey(), entry.getValue());
            }
            edit.apply();
            isLayoutRequested = true;
        }
    }

    public PersistentIdentity(Future<SharedPreferences> future, Future<SharedPreferences> future2, Future<SharedPreferences> future3, Future<SharedPreferences> future4) {
        this.lookAheadTest = future;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = future2;
        this.DatabaseTableConfigUtil = future3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = future4;
    }

    public final void BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject) {
        synchronized (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            JSONObject KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
            Iterator<String> keys = KClassImpl$Data$declaredNonStaticMembers$2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    jSONObject.put(next, KClassImpl$Data$declaredNonStaticMembers$2.get(next));
                } catch (JSONException e) {
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Object read from one JSON Object cannot be written to another", e);
                }
            }
        }
    }

    public final void PlaceComponentResult(JSONObject jSONObject) {
        synchronized (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            JSONObject KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    KClassImpl$Data$declaredNonStaticMembers$2.put(next, jSONObject.get(next));
                } catch (JSONException e) {
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Exception registering super property.", e);
                }
            }
            NetworkUserEntityData$$ExternalSyntheticLambda0();
        }
    }

    public final Map<String, String> NetworkUserEntityData$$ExternalSyntheticLambda2() {
        synchronized (getAuthRequestContext) {
            if (isLayoutRequested || this.newProxyInstance == null) {
                isLayoutRequested();
                isLayoutRequested = false;
            }
        }
        return this.newProxyInstance;
    }

    public final String moveToNextValue() {
        String str;
        synchronized (this) {
            if (!this.scheduleImpl) {
                BuiltInFictitiousFunctionClassFactory();
            }
            str = this.MyBillsEntityDataFactory;
        }
        return str;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        boolean z;
        synchronized (this) {
            if (!this.scheduleImpl) {
                BuiltInFictitiousFunctionClassFactory();
            }
            z = this.PlaceComponentResult;
        }
        return z;
    }

    public final String lookAheadTest() {
        String str;
        synchronized (this) {
            if (!this.scheduleImpl) {
                BuiltInFictitiousFunctionClassFactory();
            }
            str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return str;
    }

    public final String getErrorConfigVersion() {
        synchronized (this) {
            if (!this.scheduleImpl) {
                BuiltInFictitiousFunctionClassFactory();
            }
            if (this.BuiltInFictitiousFunctionClassFactory) {
                return this.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            return null;
        }
    }

    public final String initRecordTimeStamp() {
        String str;
        synchronized (this) {
            if (!this.scheduleImpl) {
                BuiltInFictitiousFunctionClassFactory();
            }
            str = this.getErrorConfigVersion;
        }
        return str;
    }

    public final Map<String, Long> DatabaseTableConfigUtil() {
        HashMap hashMap = new HashMap();
        try {
            for (Map.Entry<String, ?> entry : this.DatabaseTableConfigUtil.get().getAll().entrySet()) {
                hashMap.put(entry.getKey(), Long.valueOf(entry.getValue().toString()));
            }
        } catch (InterruptedException | ExecutionException unused) {
        }
        return hashMap;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        try {
            SharedPreferences.Editor edit = this.DatabaseTableConfigUtil.get().edit();
            edit.remove(str);
            edit.apply();
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    public final boolean PlaceComponentResult(String str) {
        boolean z;
        synchronized (this) {
            z = false;
            try {
                z = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().getBoolean(str, false);
            } catch (InterruptedException e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Couldn't read internal Mixpanel from shared preferences.", e);
            } catch (ExecutionException e2) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Couldn't read internal Mixpanel shared preferences.", e2.getCause());
            }
        }
        return z;
    }

    public final void scheduleImpl(String str) {
        synchronized (this) {
            try {
                try {
                    SharedPreferences.Editor edit = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().edit();
                    edit.putBoolean(str, true);
                    edit.apply();
                } catch (InterruptedException e) {
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel from shared preferences.", e);
                }
            } catch (ExecutionException e2) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e2.getCause());
            }
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String str) {
        synchronized (this) {
            if (str == null) {
                return false;
            }
            Integer valueOf = Integer.valueOf(str);
            try {
                try {
                    if (initRecordTimeStamp == null) {
                        Integer valueOf2 = Integer.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().getInt("latest_version_code", -1));
                        initRecordTimeStamp = valueOf2;
                        if (valueOf2.intValue() == -1) {
                            initRecordTimeStamp = valueOf;
                            SharedPreferences.Editor edit = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().edit();
                            edit.putInt("latest_version_code", valueOf.intValue());
                            edit.apply();
                        }
                    }
                    if (initRecordTimeStamp.intValue() < valueOf.intValue()) {
                        SharedPreferences.Editor edit2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().edit();
                        edit2.putInt("latest_version_code", valueOf.intValue());
                        edit2.apply();
                        return true;
                    }
                } catch (ExecutionException e) {
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e.getCause());
                }
            } catch (InterruptedException e2) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel from shared preferences.", e2);
            }
            return false;
        }
    }

    public final boolean MyBillsEntityDataFactory(boolean z, String str) {
        boolean booleanValue;
        synchronized (this) {
            if (NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                try {
                    SharedPreferences sharedPreferences = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get();
                    StringBuilder sb = new StringBuilder();
                    sb.append("has_launched_");
                    sb.append(str);
                    if (sharedPreferences.getBoolean(sb.toString(), false)) {
                        NetworkUserEntityData$$ExternalSyntheticLambda2 = Boolean.FALSE;
                    } else {
                        Boolean valueOf = Boolean.valueOf(!z);
                        NetworkUserEntityData$$ExternalSyntheticLambda2 = valueOf;
                        if (!valueOf.booleanValue()) {
                            getErrorConfigVersion(str);
                        }
                    }
                } catch (InterruptedException unused) {
                    NetworkUserEntityData$$ExternalSyntheticLambda2 = Boolean.FALSE;
                } catch (ExecutionException unused2) {
                    NetworkUserEntityData$$ExternalSyntheticLambda2 = Boolean.FALSE;
                }
            }
            booleanValue = NetworkUserEntityData$$ExternalSyntheticLambda2.booleanValue();
        }
        return booleanValue;
    }

    public final void getErrorConfigVersion(String str) {
        synchronized (this) {
            try {
                try {
                    SharedPreferences.Editor edit = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().edit();
                    StringBuilder sb = new StringBuilder();
                    sb.append("has_launched_");
                    sb.append(str);
                    edit.putBoolean(sb.toString(), true);
                    edit.apply();
                } catch (InterruptedException e) {
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e);
                }
            } catch (ExecutionException e2) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e2.getCause());
            }
        }
    }

    public final HashSet<Integer> GetContactSyncConfig() {
        HashSet<Integer> hashSet;
        synchronized (this) {
            hashSet = new HashSet<>();
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().getString("seen_campaign_ids", ""), ",");
                while (stringTokenizer.hasMoreTokens()) {
                    hashSet.add(Integer.valueOf(stringTokenizer.nextToken()));
                }
            } catch (InterruptedException e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Couldn't read Mixpanel shared preferences.", e);
            } catch (ExecutionException e2) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Couldn't read Mixpanel shared preferences.", e2.getCause());
            }
        }
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026 A[Catch: all -> 0x004a, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:13:0x0026, B:14:0x0042, B:8:0x000f, B:10:0x0018), top: B:20:0x0001, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean getAuthRequestContext(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.Boolean r0 = r3.moveToNextValue     // Catch: java.lang.Throwable -> L4a
            if (r0 != 0) goto L42
            java.util.concurrent.Future<android.content.SharedPreferences> r0 = r3.NetworkUserEntityData$$ExternalSyntheticLambda7     // Catch: java.lang.InterruptedException -> Le java.util.concurrent.ExecutionException -> L17 java.lang.Throwable -> L4a
            java.lang.Object r0 = r0.get()     // Catch: java.lang.InterruptedException -> Le java.util.concurrent.ExecutionException -> L17 java.lang.Throwable -> L4a
            android.content.SharedPreferences r0 = (android.content.SharedPreferences) r0     // Catch: java.lang.InterruptedException -> Le java.util.concurrent.ExecutionException -> L17 java.lang.Throwable -> L4a
            goto L24
        Le:
            r0 = move-exception
            java.lang.String r1 = "MixpanelAPI.PIdentity"
            java.lang.String r2 = "Cannot read opt out flag from sharedPreferences."
            com.mixpanel.android.util.MPLog.KClassImpl$Data$declaredNonStaticMembers$2(r1, r2, r0)     // Catch: java.lang.Throwable -> L4a
            goto L23
        L17:
            r0 = move-exception
            java.lang.String r1 = "MixpanelAPI.PIdentity"
            java.lang.String r2 = "Cannot read opt out flag from sharedPreferences."
            java.lang.Throwable r0 = r0.getCause()     // Catch: java.lang.Throwable -> L4a
            com.mixpanel.android.util.MPLog.KClassImpl$Data$declaredNonStaticMembers$2(r1, r2, r0)     // Catch: java.lang.Throwable -> L4a
        L23:
            r0 = 0
        L24:
            if (r0 == 0) goto L42
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a
            r1.<init>()     // Catch: java.lang.Throwable -> L4a
            java.lang.String r2 = "opt_out_"
            r1.append(r2)     // Catch: java.lang.Throwable -> L4a
            r1.append(r4)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L4a
            r1 = 0
            boolean r4 = r0.getBoolean(r4, r1)     // Catch: java.lang.Throwable -> L4a
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L4a
            r3.moveToNextValue = r4     // Catch: java.lang.Throwable -> L4a
        L42:
            java.lang.Boolean r4 = r3.moveToNextValue     // Catch: java.lang.Throwable -> L4a
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> L4a
            monitor-exit(r3)
            return r4
        L4a:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.PersistentIdentity.getAuthRequestContext(java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JSONObject KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.GetContactSyncConfig == null) {
            PlaceComponentResult();
        }
        return this.GetContactSyncConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PlaceComponentResult() {
        JSONObject jSONObject;
        try {
            try {
                try {
                    try {
                        String string = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().getString("super_properties", "{}");
                        StringBuilder sb = new StringBuilder();
                        sb.append("Loading Super Properties ");
                        sb.append(string);
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", sb.toString());
                        this.GetContactSyncConfig = new JSONObject(string);
                    } catch (ExecutionException e) {
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Cannot load superProperties from SharedPreferences.", e.getCause());
                        if (this.GetContactSyncConfig == null) {
                            jSONObject = new JSONObject();
                            this.GetContactSyncConfig = jSONObject;
                        }
                    }
                } catch (InterruptedException e2) {
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Cannot load superProperties from SharedPreferences.", e2);
                    if (this.GetContactSyncConfig == null) {
                        jSONObject = new JSONObject();
                        this.GetContactSyncConfig = jSONObject;
                    }
                }
            } catch (JSONException unused) {
                MPLog.getAuthRequestContext("MixpanelAPI.PIdentity", "Cannot parse stored superProperties");
                NetworkUserEntityData$$ExternalSyntheticLambda0();
                if (this.GetContactSyncConfig == null) {
                    jSONObject = new JSONObject();
                    this.GetContactSyncConfig = jSONObject;
                }
            }
        } catch (Throwable th) {
            if (this.GetContactSyncConfig == null) {
                this.GetContactSyncConfig = new JSONObject();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isLayoutRequested() {
        this.newProxyInstance = new HashMap();
        try {
            SharedPreferences sharedPreferences = this.lookAheadTest.get();
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.PrepareContext);
            sharedPreferences.registerOnSharedPreferenceChangeListener(this.PrepareContext);
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                this.newProxyInstance.put(entry.getKey(), entry.getValue().toString());
            }
        } catch (InterruptedException e) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e);
        } catch (ExecutionException e2) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e2.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        JSONObject jSONObject = this.GetContactSyncConfig;
        if (jSONObject == null) {
            MPLog.getAuthRequestContext("MixpanelAPI.PIdentity", "storeSuperProperties should not be called with uninitialized superPropertiesCache.");
            return;
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Storing Super Properties ");
        sb.append(jSONObject2);
        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", sb.toString());
        try {
            SharedPreferences.Editor edit = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().edit();
            edit.putString("super_properties", jSONObject2);
            edit.apply();
        } catch (InterruptedException e) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Cannot store superProperties in shared preferences.", e);
        } catch (ExecutionException e2) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Cannot store superProperties in shared preferences.", e2.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory() {
        /*
            r4 = this;
            java.lang.String r0 = "Cannot read distinct ids from sharedPreferences."
            java.lang.String r1 = "MixpanelAPI.PIdentity"
            r2 = 0
            java.util.concurrent.Future<android.content.SharedPreferences> r3 = r4.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.InterruptedException -> Le java.util.concurrent.ExecutionException -> L13
            java.lang.Object r3 = r3.get()     // Catch: java.lang.InterruptedException -> Le java.util.concurrent.ExecutionException -> L13
            android.content.SharedPreferences r3 = (android.content.SharedPreferences) r3     // Catch: java.lang.InterruptedException -> Le java.util.concurrent.ExecutionException -> L13
            goto L1c
        Le:
            r3 = move-exception
            com.mixpanel.android.util.MPLog.KClassImpl$Data$declaredNonStaticMembers$2(r1, r0, r3)
            goto L1b
        L13:
            r3 = move-exception
            java.lang.Throwable r3 = r3.getCause()
            com.mixpanel.android.util.MPLog.KClassImpl$Data$declaredNonStaticMembers$2(r1, r0, r3)
        L1b:
            r3 = r2
        L1c:
            if (r3 != 0) goto L1f
            return
        L1f:
            java.lang.String r0 = "events_distinct_id"
            java.lang.String r0 = r3.getString(r0, r2)
            r4.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            r0 = 0
            java.lang.String r1 = "events_user_id_present"
            boolean r1 = r3.getBoolean(r1, r0)
            r4.BuiltInFictitiousFunctionClassFactory = r1
            java.lang.String r1 = "people_distinct_id"
            java.lang.String r1 = r3.getString(r1, r2)
            r4.getErrorConfigVersion = r1
            java.lang.String r1 = "anonymous_id"
            java.lang.String r1 = r3.getString(r1, r2)
            r4.MyBillsEntityDataFactory = r1
            java.lang.String r1 = "had_persisted_distinct_id"
            boolean r1 = r3.getBoolean(r1, r0)
            r4.PlaceComponentResult = r1
            java.lang.String r1 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            if (r1 != 0) goto L5d
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            r4.MyBillsEntityDataFactory = r1
            r4.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            r4.BuiltInFictitiousFunctionClassFactory = r0
            r4.scheduleImpl()
        L5d:
            r0 = 1
            r4.scheduleImpl = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.PersistentIdentity.BuiltInFictitiousFunctionClassFactory():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(String str) {
        try {
            SharedPreferences.Editor edit = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().edit();
            StringBuilder sb = new StringBuilder();
            sb.append("opt_out_");
            sb.append(str);
            edit.putBoolean(sb.toString(), this.moveToNextValue.booleanValue());
            edit.apply();
        } catch (InterruptedException e) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Can't write opt-out shared preferences.", e);
        } catch (ExecutionException e2) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Can't write opt-out shared preferences.", e2.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void scheduleImpl() {
        try {
            SharedPreferences.Editor edit = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().edit();
            edit.putString("events_distinct_id", this.KClassImpl$Data$declaredNonStaticMembers$2);
            edit.putBoolean("events_user_id_present", this.BuiltInFictitiousFunctionClassFactory);
            edit.putString("people_distinct_id", this.getErrorConfigVersion);
            edit.putString("anonymous_id", this.MyBillsEntityDataFactory);
            edit.putBoolean("had_persisted_distinct_id", this.PlaceComponentResult);
            edit.apply();
        } catch (InterruptedException e) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Can't write distinct ids to shared preferences.", e);
        } catch (ExecutionException e2) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Can't write distinct ids to shared preferences.", e2.getCause());
        }
    }

    public static void getAuthRequestContext(SharedPreferences.Editor editor) {
        editor.apply();
    }
}
