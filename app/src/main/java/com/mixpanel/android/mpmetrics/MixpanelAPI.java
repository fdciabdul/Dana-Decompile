package com.mixpanel.android.mpmetrics;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.Constants;
import com.mixpanel.android.BuildConfig;
import com.mixpanel.android.R;
import com.mixpanel.android.mpmetrics.AnalyticsMessages;
import com.mixpanel.android.mpmetrics.DecideMessages;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.InstallReferrerPlay;
import com.mixpanel.android.mpmetrics.SharedPreferencesLoader;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.takeoverinapp.TakeoverInAppActivity;
import com.mixpanel.android.util.ActivityImageUtils;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.TrackingDebug;
import com.mixpanel.android.viewcrawler.UpdatesFromMixpanel;
import com.mixpanel.android.viewcrawler.ViewCrawler;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MixpanelAPI {
    private static Future<SharedPreferences> GetContactSyncConfig;
    final Context BuiltInFictitiousFunctionClassFactory;
    public final Map<String, Long> KClassImpl$Data$declaredNonStaticMembers$2;
    public final Map<String, String> MyBillsEntityDataFactory;
    final UpdatesFromMixpanel NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final TrackingDebug NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final UpdatesListener NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final Map<String, GroupImpl> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final SessionMetadata NetworkUserEntityData$$ExternalSyntheticLambda8;
    final MPConfig PlaceComponentResult;
    private MixpanelActivityLifecycleCallbacks PrepareContext;
    public final AnalyticsMessages getAuthRequestContext;
    public final String getErrorConfigVersion;
    private final ConnectIntegrations isLayoutRequested;
    public final PersistentIdentity moveToNextValue;
    private final DecideMessages newProxyInstance;
    public final PeopleImpl scheduleImpl;
    public static final byte[] lookAheadTest = {61, 16, -46, 32, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int initRecordTimeStamp = 223;
    private static final Map<String, Map<Context, MixpanelAPI>> NetworkUserEntityData$$ExternalSyntheticLambda2 = new HashMap();
    private static final SharedPreferencesLoader NetworkUserEntityData$$ExternalSyntheticLambda1 = new SharedPreferencesLoader();
    private static final Tweaks DatabaseTableConfigUtil = new Tweaks();

    /* loaded from: classes.dex */
    public interface Group {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class GroupImpl implements Group {
    }

    /* loaded from: classes.dex */
    public interface InstanceProcessor {
        void getAuthRequestContext(MixpanelAPI mixpanelAPI);
    }

    /* loaded from: classes.dex */
    public interface People {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(Activity activity);

        void BuiltInFictitiousFunctionClassFactory(String str);

        People KClassImpl$Data$declaredNonStaticMembers$2(String str);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, double d);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, InAppNotification inAppNotification, JSONObject jSONObject);

        void KClassImpl$Data$declaredNonStaticMembers$2(String str, Object obj);

        void MyBillsEntityDataFactory(InAppNotification inAppNotification, Activity activity);

        void MyBillsEntityDataFactory(String str);

        void MyBillsEntityDataFactory(String str, Object obj);

        void MyBillsEntityDataFactory(String str, JSONObject jSONObject);

        void MyBillsEntityDataFactory(JSONObject jSONObject);

        void PlaceComponentResult();

        void PlaceComponentResult(JSONObject jSONObject);

        boolean getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface UpdatesListener extends DecideMessages.OnNewResultsListener {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x001f -> B:23:0x0027). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.Object[] r8) {
        /*
            byte[] r0 = com.mixpanel.android.mpmetrics.MixpanelAPI.lookAheadTest
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 97
            r3 = 4
            r4 = 0
            if (r0 != 0) goto Lf
            r5 = 4
            r6 = 0
            goto L27
        Lf:
            r5 = 0
        L10:
            byte r6 = (byte) r2
            r1[r5] = r6
            r6 = 22
            if (r5 != r6) goto L1f
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1, r4)
            r8[r4] = r0
            return
        L1f:
            int r5 = r5 + 1
            r6 = r0[r3]
            r7 = r5
            r5 = r2
            r2 = r6
            r6 = r7
        L27:
            int r3 = r3 + 1
            int r5 = r5 + r2
            int r2 = r5 + (-8)
            r5 = r6
            goto L10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MixpanelAPI.a(java.lang.Object[]):void");
    }

    public static void getAuthRequestContext(Context context, Intent intent, String str) {
        KClassImpl$Data$declaredNonStaticMembers$2(context, intent, str, new JSONObject());
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, Intent intent, String str, JSONObject jSONObject) {
        if (intent.hasExtra("mp") && intent.hasExtra("mp_campaign_id") && intent.hasExtra("mp_message_id")) {
            String stringExtra = intent.getStringExtra("mp_message_id");
            String stringExtra2 = intent.getStringExtra("mp_campaign_id");
            getAuthRequestContext(context, Integer.valueOf(stringExtra2), Integer.valueOf(stringExtra), intent.getStringExtra("mp_canonical_notification_id"), intent.getStringExtra("mp"), str, jSONObject);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Intent is missing Mixpanel notification metadata, not tracking event: \"");
        sb.append(str);
        sb.append("\"");
        MPLog.getAuthRequestContext("MixpanelAPI.API", sb.toString());
    }

    public static void getAuthRequestContext(Context context, Integer num, Integer num2, String str, String str2, String str3, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(str2);
            if (jSONObject2.optString("token") == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("\"token\" not found in mp payload, not tracking event: \"");
                sb.append(str3);
                sb.append("\"");
                MPLog.getAuthRequestContext("MixpanelAPI.API", sb.toString());
                return;
            }
            jSONObject2.remove("token");
            if (jSONObject2.optString("distinct_id") == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\"distinct_id\" not found in mp payload, not tracking event: \"");
                sb2.append(str3);
                sb2.append("\"");
                MPLog.getAuthRequestContext("MixpanelAPI.API", sb2.toString());
                return;
            }
            jSONObject2.remove("distinct_id");
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
                jSONObject2.put(Constants.MessagePayloadKeys.MSGID_SERVER, num2);
                jSONObject2.put("campaign_id", num);
                jSONObject2.put("$android_notification_id", str);
            } catch (JSONException e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Error setting tracking JSON properties.", e);
            }
            MixpanelAPI MyBillsEntityDataFactory = MyBillsEntityDataFactory(context, str2);
            if (MyBillsEntityDataFactory == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Got null instance, not tracking \"");
                sb3.append(str3);
                sb3.append("\"");
                MPLog.getAuthRequestContext("MixpanelAPI.API", sb3.toString());
                return;
            }
            if (!MyBillsEntityDataFactory.getAuthRequestContext()) {
                MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(str3, jSONObject2, false);
            }
            if (MyBillsEntityDataFactory.getAuthRequestContext()) {
                return;
            }
            MyBillsEntityDataFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new AnalyticsMessages.FlushDescription(MyBillsEntityDataFactory.getErrorConfigVersion, false));
        } catch (JSONException e2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Exception parsing mp payload from intent extras, not tracking event: \"");
            sb4.append(str3);
            sb4.append("\"");
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", sb4.toString(), e2);
        }
    }

    public static MixpanelAPI MyBillsEntityDataFactory(Context context, String str) {
        try {
            String optString = new JSONObject(str).optString("token");
            if (optString == null) {
                return null;
            }
            return PlaceComponentResult(context, optString);
        } catch (JSONException unused) {
            return null;
        }
    }

    private MixpanelAPI(Context context, Future<SharedPreferences> future, String str) {
        this(context, future, str, MPConfig.getAuthRequestContext(context), false, null);
    }

    private MixpanelAPI(Context context, Future<SharedPreferences> future, String str, MPConfig mPConfig, boolean z, JSONObject jSONObject) {
        UpdatesFromMixpanel noOpUpdatesFromMixpanel;
        UpdatesListener supportedUpdatesListener;
        File file;
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.getErrorConfigVersion = str;
        this.scheduleImpl = new PeopleImpl(this, (byte) 0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new HashMap();
        this.PlaceComponentResult = mPConfig;
        HashMap hashMap = new HashMap();
        hashMap.put("$android_lib_version", BuildConfig.MIXPANEL_VERSION);
        hashMap.put("$android_os", "Android");
        hashMap.put("$android_os_version", Build.VERSION.RELEASE == null ? "UNKNOWN" : Build.VERSION.RELEASE);
        hashMap.put("$android_manufacturer", Build.MANUFACTURER == null ? "UNKNOWN" : Build.MANUFACTURER);
        hashMap.put("$android_brand", Build.BRAND == null ? "UNKNOWN" : Build.BRAND);
        hashMap.put("$android_model", Build.MODEL != null ? Build.MODEL : "UNKNOWN");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            hashMap.put("$android_app_version", packageInfo.versionName);
            hashMap.put("$android_app_version_code", Integer.toString(packageInfo.versionCode));
        } catch (PackageManager.NameNotFoundException e) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Exception getting app version name", e);
        }
        this.MyBillsEntityDataFactory = Collections.unmodifiableMap(hashMap);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new SessionMetadata();
        if (Build.VERSION.SDK_INT < 16) {
            MPLog.MyBillsEntityDataFactory("MixpanelAPI.API", "SDK version is lower than 16. Web Configuration, A/B Testing, and Dynamic Tweaks are disabled.");
            noOpUpdatesFromMixpanel = new NoOpUpdatesFromMixpanel(DatabaseTableConfigUtil);
        } else if (this.PlaceComponentResult.getErrorConfigVersion() || Arrays.asList(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2).contains(str)) {
            MPLog.MyBillsEntityDataFactory("MixpanelAPI.API", "DisableViewCrawler is set to true. Web Configuration, A/B Testing, and Dynamic Tweaks are disabled.");
            noOpUpdatesFromMixpanel = new NoOpUpdatesFromMixpanel(DatabaseTableConfigUtil);
        } else {
            noOpUpdatesFromMixpanel = new ViewCrawler(this.BuiltInFictitiousFunctionClassFactory, this.getErrorConfigVersion, this, DatabaseTableConfigUtil);
        }
        UpdatesFromMixpanel updatesFromMixpanel = noOpUpdatesFromMixpanel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = updatesFromMixpanel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = updatesFromMixpanel instanceof ViewCrawler ? (TrackingDebug) updatesFromMixpanel : null;
        AnalyticsMessages BuiltInFictitiousFunctionClassFactory = AnalyticsMessages.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
        SharedPreferencesLoader.OnPrefsLoadedListener onPrefsLoadedListener = new SharedPreferencesLoader.OnPrefsLoadedListener() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.4
            {
                MixpanelAPI.this = this;
            }

            @Override // com.mixpanel.android.mpmetrics.SharedPreferencesLoader.OnPrefsLoadedListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(SharedPreferences sharedPreferences) {
                String MyBillsEntityDataFactory = PersistentIdentity.MyBillsEntityDataFactory(sharedPreferences);
                if (MyBillsEntityDataFactory != null) {
                    MixpanelAPI.KClassImpl$Data$declaredNonStaticMembers$2(MixpanelAPI.this, MyBillsEntityDataFactory);
                }
            }
        };
        StringBuilder sb = new StringBuilder();
        sb.append("com.mixpanel.android.mpmetrics.MixpanelAPI_");
        sb.append(str);
        String obj = sb.toString();
        SharedPreferencesLoader sharedPreferencesLoader = NetworkUserEntityData$$ExternalSyntheticLambda1;
        FutureTask futureTask = new FutureTask(new SharedPreferencesLoader.LoadSharedPreferences(context, obj, onPrefsLoadedListener));
        sharedPreferencesLoader.KClassImpl$Data$declaredNonStaticMembers$2.execute(futureTask);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("com.mixpanel.android.mpmetrics.MixpanelAPI.TimeEvents_");
        sb2.append(str);
        FutureTask futureTask2 = new FutureTask(new SharedPreferencesLoader.LoadSharedPreferences(context, sb2.toString(), null));
        sharedPreferencesLoader.KClassImpl$Data$declaredNonStaticMembers$2.execute(futureTask2);
        FutureTask futureTask3 = new FutureTask(new SharedPreferencesLoader.LoadSharedPreferences(context, "com.mixpanel.android.mpmetrics.Mixpanel", null));
        sharedPreferencesLoader.KClassImpl$Data$declaredNonStaticMembers$2.execute(futureTask3);
        PersistentIdentity persistentIdentity = new PersistentIdentity(future, futureTask, futureTask2, futureTask3);
        this.moveToNextValue = persistentIdentity;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = persistentIdentity.DatabaseTableConfigUtil();
        if (Build.VERSION.SDK_INT < 16) {
            MPLog.MyBillsEntityDataFactory("MixpanelAPI.API", "Notifications are not supported on this Android OS Version");
            supportedUpdatesListener = new UnsupportedUpdatesListener(this, (byte) 0);
        } else {
            supportedUpdatesListener = new SupportedUpdatesListener(this, (byte) 0);
        }
        UpdatesListener updatesListener = supportedUpdatesListener;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = updatesListener;
        DecideMessages decideMessages = new DecideMessages(this.BuiltInFictitiousFunctionClassFactory, str, updatesListener, updatesFromMixpanel, this.moveToNextValue.GetContactSyncConfig());
        this.newProxyInstance = decideMessages;
        this.isLayoutRequested = new ConnectIntegrations(this, this.BuiltInFictitiousFunctionClassFactory);
        String initRecordTimeStamp2 = persistentIdentity.initRecordTimeStamp();
        decideMessages.KClassImpl$Data$declaredNonStaticMembers$2(initRecordTimeStamp2 == null ? persistentIdentity.lookAheadTest() : initRecordTimeStamp2);
        file = MPDbAdapter.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory).getAuthRequestContext.getAuthRequestContext;
        boolean exists = file.exists();
        if (Build.VERSION.SDK_INT >= 14) {
            if (this.BuiltInFictitiousFunctionClassFactory.getApplicationContext() instanceof Application) {
                Application application = (Application) this.BuiltInFictitiousFunctionClassFactory.getApplicationContext();
                MixpanelActivityLifecycleCallbacks mixpanelActivityLifecycleCallbacks = new MixpanelActivityLifecycleCallbacks(this, this.PlaceComponentResult);
                this.PrepareContext = mixpanelActivityLifecycleCallbacks;
                application.registerActivityLifecycleCallbacks(mixpanelActivityLifecycleCallbacks);
            } else {
                MPLog.MyBillsEntityDataFactory("MixpanelAPI.API", "Context is not an Application, Mixpanel will not automatically show in-app notifications or A/B test experiments. We won't be able to automatically flush on an app background.");
            }
        }
        if (ConfigurationChecker.getAuthRequestContext(GetContactSyncConfig)) {
            new InstallReferrerPlay(this.BuiltInFictitiousFunctionClassFactory, new InstallReferrerPlay.ReferrerCallback() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.1
                {
                    MixpanelAPI.this = this;
                }

                @Override // com.mixpanel.android.mpmetrics.InstallReferrerPlay.ReferrerCallback
                public final void MyBillsEntityDataFactory() {
                    AnalyticsMessages analyticsMessages = MixpanelAPI.this.getAuthRequestContext;
                    AnalyticsMessages.UpdateEventsPropertiesDescription updateEventsPropertiesDescription = new AnalyticsMessages.UpdateEventsPropertiesDescription(MixpanelAPI.this.getErrorConfigVersion, MixpanelAPI.this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2());
                    Message obtain = Message.obtain();
                    obtain.what = 8;
                    obtain.obj = updateEventsPropertiesDescription;
                    analyticsMessages.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(obtain);
                }
            }).getAuthRequestContext();
        }
        if (persistentIdentity.MyBillsEntityDataFactory(exists, this.getErrorConfigVersion)) {
            BuiltInFictitiousFunctionClassFactory("$ae_first_open", null, true);
            persistentIdentity.getErrorConfigVersion(this.getErrorConfigVersion);
        }
        if (!this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2()) {
            Message obtain = Message.obtain();
            obtain.what = 12;
            obtain.obj = decideMessages;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(obtain);
        }
        if (getErrorConfigVersion() && !getAuthRequestContext()) {
            BuiltInFictitiousFunctionClassFactory("$app_open", null, false);
        }
        if (!persistentIdentity.PlaceComponentResult(this.getErrorConfigVersion)) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mp_lib", "Android");
                jSONObject2.put("lib", "Android");
                jSONObject2.put("distinct_id", str);
                jSONObject2.put("$lib_version", BuildConfig.MIXPANEL_VERSION);
                jSONObject2.put("$user_id", str);
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(new AnalyticsMessages.EventDescription("Integration", jSONObject2, "85053bf24bba75239b16a601d9387e17"));
                BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(new AnalyticsMessages.FlushDescription("85053bf24bba75239b16a601d9387e17", false));
                persistentIdentity.scheduleImpl(this.getErrorConfigVersion);
            } catch (JSONException unused) {
            }
        }
        if (this.moveToNextValue.BuiltInFictitiousFunctionClassFactory((String) hashMap.get("$android_app_version_code"))) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("$ae_updated_version", hashMap.get("$android_app_version"));
                BuiltInFictitiousFunctionClassFactory("$ae_updated", jSONObject3, true);
            } catch (JSONException unused2) {
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory();
        if (this.PlaceComponentResult.PlaceComponentResult()) {
            return;
        }
        ExceptionHandler.BuiltInFictitiousFunctionClassFactory();
    }

    public static MixpanelAPI KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        return PlaceComponentResult(context, str);
    }

    public static MixpanelAPI PlaceComponentResult(Context context, String str) {
        MixpanelAPI mixpanelAPI;
        if (str == null || context == null) {
            return null;
        }
        Map<String, Map<Context, MixpanelAPI>> map = NetworkUserEntityData$$ExternalSyntheticLambda2;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            if (GetContactSyncConfig == null) {
                SharedPreferencesLoader sharedPreferencesLoader = NetworkUserEntityData$$ExternalSyntheticLambda1;
                FutureTask futureTask = new FutureTask(new SharedPreferencesLoader.LoadSharedPreferences(context, "com.mixpanel.android.mpmetrics.ReferralInfo", null));
                sharedPreferencesLoader.KClassImpl$Data$declaredNonStaticMembers$2.execute(futureTask);
                GetContactSyncConfig = futureTask;
            }
            Map<Context, MixpanelAPI> map2 = map.get(str);
            if (map2 == null) {
                map2 = new HashMap<>();
                map.put(str, map2);
            }
            mixpanelAPI = map2.get(applicationContext);
            if (mixpanelAPI == null && ConfigurationChecker.KClassImpl$Data$declaredNonStaticMembers$2(applicationContext)) {
                mixpanelAPI = new MixpanelAPI(applicationContext, GetContactSyncConfig, str);
                try {
                    try {
                        try {
                            try {
                                Class<?> cls = Class.forName("androidx.localbroadcastmanager.content.LocalBroadcastManager");
                                Object[] objArr = new Object[1];
                                a(objArr);
                                cls.getMethod("registerReceiver", BroadcastReceiver.class, IntentFilter.class).invoke(cls.getMethod("getInstance", Class.forName((String) objArr[0])).invoke(null, context), new BroadcastReceiver() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.5
                                    {
                                        MixpanelAPI.this = mixpanelAPI;
                                    }

                                    @Override // android.content.BroadcastReceiver
                                    public void onReceive(Context context2, Intent intent) {
                                        JSONObject jSONObject = new JSONObject();
                                        Bundle bundleExtra = intent.getBundleExtra("event_args");
                                        if (bundleExtra != null) {
                                            for (String str2 : bundleExtra.keySet()) {
                                                try {
                                                    jSONObject.put(str2, bundleExtra.get(str2));
                                                } catch (JSONException e) {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append("failed to add key \"");
                                                    sb.append(str2);
                                                    sb.append("\" to properties for tracking bolts event");
                                                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.AL", sb.toString(), e);
                                                }
                                            }
                                        }
                                        MixpanelAPI mixpanelAPI2 = MixpanelAPI.this;
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("$");
                                        sb2.append(intent.getStringExtra("event_name"));
                                        mixpanelAPI2.KClassImpl$Data$declaredNonStaticMembers$2(sb2.toString(), jSONObject);
                                    }
                                }, new IntentFilter("com.parse.bolts.measurement_event"));
                            } catch (NoSuchMethodException e) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("To enable App Links tracking android.support.v4 must be installed: ");
                                sb.append(e.getMessage());
                                MPLog.PlaceComponentResult("MixpanelAPI.AL", sb.toString());
                            }
                        } catch (IllegalAccessException e2) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("App Links tracking will not be enabled due to this exception: ");
                            sb2.append(e2.getMessage());
                            MPLog.PlaceComponentResult("MixpanelAPI.AL", sb2.toString());
                        }
                    } catch (ClassNotFoundException e3) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("To enable App Links tracking android.support.v4 must be installed: ");
                        sb3.append(e3.getMessage());
                        MPLog.PlaceComponentResult("MixpanelAPI.AL", sb3.toString());
                    }
                } catch (InvocationTargetException e4) {
                    MPLog.getAuthRequestContext("MixpanelAPI.AL", "Failed to invoke LocalBroadcastManager.registerReceiver() -- App Links tracking will not be enabled due to this exception", e4);
                }
                map2.put(applicationContext, mixpanelAPI);
                if (ConfigurationChecker.getAuthRequestContext(applicationContext)) {
                    try {
                        MixpanelFCMMessagingService.init();
                    } catch (Exception e5) {
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Push notification could not be initialized", e5);
                    }
                }
            }
            if (context instanceof Activity) {
                try {
                    try {
                        Class<?> cls2 = Class.forName("bolts.AppLinks");
                        Intent intent = ((Activity) context).getIntent();
                        Object[] objArr2 = new Object[1];
                        a(objArr2);
                        cls2.getMethod("getTargetUrlFromInboundIntent", Class.forName((String) objArr2[0]), Intent.class).invoke(null, context, intent);
                    } catch (IllegalAccessException e6) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Unable to detect inbound App Links: ");
                        sb4.append(e6.getMessage());
                        MPLog.PlaceComponentResult("MixpanelAPI.AL", sb4.toString());
                    } catch (NoSuchMethodException e7) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Please install the Bolts library >= 1.1.2 to track App Links: ");
                        sb5.append(e7.getMessage());
                        MPLog.PlaceComponentResult("MixpanelAPI.AL", sb5.toString());
                    }
                } catch (ClassNotFoundException e8) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Please install the Bolts library >= 1.1.2 to track App Links: ");
                    sb6.append(e8.getMessage());
                    MPLog.PlaceComponentResult("MixpanelAPI.AL", sb6.toString());
                } catch (InvocationTargetException e9) {
                    MPLog.getAuthRequestContext("MixpanelAPI.AL", "Failed to invoke bolts.AppLinks.getTargetUrlFromInboundIntent() -- Unable to detect inbound App Links", e9);
                }
            } else {
                MPLog.PlaceComponentResult("MixpanelAPI.AL", "Context is not an instance of Activity. To detect inbound App Links, pass an instance of an Activity to getInstance.");
            }
        }
        return mixpanelAPI;
    }

    public final void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        if (getAuthRequestContext()) {
            return;
        }
        if (str2 == null) {
            str2 = this.moveToNextValue.lookAheadTest();
        }
        if (str.equals(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Attempted to alias identical distinct_ids ");
            sb.append(str);
            sb.append(". Alias message will not be sent.");
            MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.API", sb.toString());
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("alias", str);
            jSONObject.put("original", str2);
            KClassImpl$Data$declaredNonStaticMembers$2("$create_alias", jSONObject);
        } catch (JSONException e) {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Failed to alias", e);
        }
        if (getAuthRequestContext()) {
            return;
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new AnalyticsMessages.FlushDescription(this.getErrorConfigVersion));
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, JSONObject jSONObject) {
        if (getAuthRequestContext()) {
            return;
        }
        BuiltInFictitiousFunctionClassFactory(str, jSONObject, false);
    }

    public final void MyBillsEntityDataFactory(String str) {
        if (getAuthRequestContext() || getAuthRequestContext()) {
            return;
        }
        BuiltInFictitiousFunctionClassFactory(str, null, false);
    }

    public final JSONObject MyBillsEntityDataFactory() {
        JSONObject jSONObject = new JSONObject();
        this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(jSONObject);
        return jSONObject;
    }

    public final void PlaceComponentResult(SuperPropertyUpdate superPropertyUpdate) {
        if (getAuthRequestContext()) {
            return;
        }
        PersistentIdentity persistentIdentity = this.moveToNextValue;
        synchronized (persistentIdentity.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            JSONObject KClassImpl$Data$declaredNonStaticMembers$2 = persistentIdentity.KClassImpl$Data$declaredNonStaticMembers$2();
            JSONObject jSONObject = new JSONObject();
            try {
                Iterator<String> keys = KClassImpl$Data$declaredNonStaticMembers$2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, KClassImpl$Data$declaredNonStaticMembers$2.get(next));
                }
                JSONObject MyBillsEntityDataFactory = superPropertyUpdate.MyBillsEntityDataFactory(jSONObject);
                if (MyBillsEntityDataFactory == null) {
                    MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.PIdentity", "An update to Mixpanel's super properties returned null, and will have no effect.");
                    return;
                }
                persistentIdentity.GetContactSyncConfig = MyBillsEntityDataFactory;
                persistentIdentity.NetworkUserEntityData$$ExternalSyntheticLambda0();
            } catch (JSONException e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Can't copy from one JSONObject to another", e);
            }
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.MixpanelAPI$2 */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements SuperPropertyUpdate {
        final /* synthetic */ Object KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ String MyBillsEntityDataFactory;

        @Override // com.mixpanel.android.mpmetrics.SuperPropertyUpdate
        public final JSONObject MyBillsEntityDataFactory(JSONObject jSONObject) {
            try {
                jSONObject.accumulate(this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2);
            } catch (JSONException e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Failed to add groups superProperty", e);
            }
            return jSONObject;
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.MixpanelAPI$3 */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements SuperPropertyUpdate {
        final /* synthetic */ Object BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ MixpanelAPI MyBillsEntityDataFactory;

        @Override // com.mixpanel.android.mpmetrics.SuperPropertyUpdate
        public final JSONObject MyBillsEntityDataFactory(JSONObject jSONObject) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(this.KClassImpl$Data$declaredNonStaticMembers$2);
                JSONArray jSONArray2 = new JSONArray();
                if (jSONArray.length() <= 1) {
                    jSONObject.remove(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    this.MyBillsEntityDataFactory.scheduleImpl.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
                } else {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (!jSONArray.get(i).equals(this.BuiltInFictitiousFunctionClassFactory)) {
                            jSONArray2.put(jSONArray.get(i));
                        }
                    }
                    jSONObject.put(this.KClassImpl$Data$declaredNonStaticMembers$2, jSONArray2);
                    PeopleImpl peopleImpl = this.MyBillsEntityDataFactory.scheduleImpl;
                    String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    Object obj = this.BuiltInFictitiousFunctionClassFactory;
                    if (!MixpanelAPI.this.getAuthRequestContext()) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(str, obj);
                            MixpanelAPI.PlaceComponentResult(MixpanelAPI.this, peopleImpl.getAuthRequestContext("$remove", jSONObject2));
                        } catch (JSONException e) {
                            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Exception appending a property", e);
                        }
                    }
                }
            } catch (JSONException unused) {
                jSONObject.remove(this.KClassImpl$Data$declaredNonStaticMembers$2);
                this.MyBillsEntityDataFactory.scheduleImpl.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return jSONObject;
        }
    }

    public final boolean getAuthRequestContext() {
        return this.moveToNextValue.getAuthRequestContext(this.getErrorConfigVersion);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        if (Build.VERSION.SDK_INT >= 14) {
            MixpanelActivityLifecycleCallbacks mixpanelActivityLifecycleCallbacks = this.PrepareContext;
            if (mixpanelActivityLifecycleCallbacks != null) {
                return mixpanelActivityLifecycleCallbacks.BuiltInFictitiousFunctionClassFactory();
            }
            return false;
        }
        MPLog.getAuthRequestContext("MixpanelAPI.API", "Your build version is below 14. This method will always return false.");
        return false;
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.getAuthRequestContext();
    }

    public static void getAuthRequestContext(InstanceProcessor instanceProcessor) {
        Map<String, Map<Context, MixpanelAPI>> map = NetworkUserEntityData$$ExternalSyntheticLambda2;
        synchronized (map) {
            Iterator<Map<Context, MixpanelAPI>> it = map.values().iterator();
            while (it.hasNext()) {
                Iterator<MixpanelAPI> it2 = it.next().values().iterator();
                while (it2.hasNext()) {
                    instanceProcessor.getAuthRequestContext(it2.next());
                }
            }
        }
    }

    private boolean getErrorConfigVersion() {
        return !this.PlaceComponentResult.MyBillsEntityDataFactory();
    }

    /* loaded from: classes.dex */
    public class PeopleImpl implements People {
        private PeopleImpl() {
            MixpanelAPI.this = r1;
        }

        /* synthetic */ PeopleImpl(MixpanelAPI mixpanelAPI, byte b) {
            this();
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public void BuiltInFictitiousFunctionClassFactory(String str) {
            if (MixpanelAPI.this.getAuthRequestContext()) {
                return;
            }
            if (str != null) {
                synchronized (MixpanelAPI.this.moveToNextValue) {
                    PersistentIdentity persistentIdentity = MixpanelAPI.this.moveToNextValue;
                    synchronized (persistentIdentity) {
                        if (!persistentIdentity.scheduleImpl) {
                            persistentIdentity.BuiltInFictitiousFunctionClassFactory();
                        }
                        persistentIdentity.getErrorConfigVersion = str;
                        persistentIdentity.scheduleImpl();
                    }
                    MixpanelAPI.this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(str);
                }
                MixpanelAPI.KClassImpl$Data$declaredNonStaticMembers$2(MixpanelAPI.this, str);
                return;
            }
            MPLog.getAuthRequestContext("MixpanelAPI.API", "Can't identify with null distinct_id.");
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void PlaceComponentResult(JSONObject jSONObject) {
            if (MixpanelAPI.this.getAuthRequestContext()) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(MixpanelAPI.this.MyBillsEntityDataFactory);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
                MixpanelAPI.PlaceComponentResult(MixpanelAPI.this, getAuthRequestContext("$set", jSONObject2));
            } catch (JSONException e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Exception setting people properties", e);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void MyBillsEntityDataFactory(String str, Object obj) {
            if (MixpanelAPI.this.getAuthRequestContext()) {
                return;
            }
            try {
                PlaceComponentResult(new JSONObject().put(str, obj));
            } catch (JSONException e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "set", e);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void MyBillsEntityDataFactory(JSONObject jSONObject) {
            if (MixpanelAPI.this.getAuthRequestContext()) {
                return;
            }
            try {
                MixpanelAPI.PlaceComponentResult(MixpanelAPI.this, getAuthRequestContext("$set_once", jSONObject));
            } catch (JSONException unused) {
                MPLog.getAuthRequestContext("MixpanelAPI.API", "Exception setting people properties");
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void MyBillsEntityDataFactory(String str, JSONObject jSONObject) {
            if (MixpanelAPI.this.getAuthRequestContext()) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(str, jSONObject);
                MixpanelAPI.PlaceComponentResult(MixpanelAPI.this, getAuthRequestContext("$merge", jSONObject2));
            } catch (JSONException e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Exception merging a property", e);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, double d) {
            if (MixpanelAPI.this.getAuthRequestContext()) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(str, Double.valueOf(d));
            if (MixpanelAPI.this.getAuthRequestContext()) {
                return;
            }
            try {
                MixpanelAPI.PlaceComponentResult(MixpanelAPI.this, getAuthRequestContext("$add", new JSONObject(hashMap)));
            } catch (JSONException e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Exception incrementing properties", e);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, Object obj) {
            if (MixpanelAPI.this.getAuthRequestContext()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, obj);
                MixpanelAPI.PlaceComponentResult(MixpanelAPI.this, getAuthRequestContext("$append", jSONObject));
            } catch (JSONException e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Exception appending a property", e);
            }
        }

        public final void getAuthRequestContext(String str) {
            if (MixpanelAPI.this.getAuthRequestContext()) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str);
                MixpanelAPI.PlaceComponentResult(MixpanelAPI.this, getAuthRequestContext("$unset", jSONArray));
            } catch (JSONException e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Exception unsetting a property", e);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void BuiltInFictitiousFunctionClassFactory(Activity activity) {
            if (Build.VERSION.SDK_INT < 16) {
                return;
            }
            if (Build.VERSION.SDK_INT < 16) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Will not show notifications, os version is too low.");
            } else {
                activity.runOnUiThread(new AnonymousClass2(null, activity));
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, InAppNotification inAppNotification, JSONObject jSONObject) {
            if (MixpanelAPI.this.getAuthRequestContext()) {
                return;
            }
            JSONObject MyBillsEntityDataFactory = inAppNotification.MyBillsEntityDataFactory();
            if (jSONObject != null) {
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        MyBillsEntityDataFactory.put(next, jSONObject.get(next));
                    }
                } catch (JSONException e) {
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Exception merging provided properties with notification properties", e);
                }
            }
            MixpanelAPI.this.KClassImpl$Data$declaredNonStaticMembers$2(str, MyBillsEntityDataFactory);
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void PlaceComponentResult() {
            MixpanelAPI.this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(MixpanelAPI.this.newProxyInstance.BuiltInFictitiousFunctionClassFactory());
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void BuiltInFictitiousFunctionClassFactory() {
            getAuthRequestContext("$transactions");
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            try {
                MixpanelAPI.PlaceComponentResult(MixpanelAPI.this, getAuthRequestContext("$delete", JSONObject.NULL));
            } catch (JSONException unused) {
                MPLog.getAuthRequestContext("MixpanelAPI.API", "Exception deleting a user");
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void MyBillsEntityDataFactory(String str) {
            synchronized (MixpanelAPI.this.moveToNextValue) {
                StringBuilder sb = new StringBuilder();
                sb.append("Setting push token on people profile: ");
                sb.append(str);
                MPLog.PlaceComponentResult("MixpanelAPI.API", sb.toString());
                PersistentIdentity persistentIdentity = MixpanelAPI.this.moveToNextValue;
                synchronized (persistentIdentity) {
                    try {
                        SharedPreferences.Editor edit = persistentIdentity.NetworkUserEntityData$$ExternalSyntheticLambda0.get().edit();
                        edit.putString("push_id", str);
                        PersistentIdentity.getAuthRequestContext(edit);
                    } catch (InterruptedException e) {
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Can't write push id to shared preferences", e);
                    } catch (ExecutionException e2) {
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Can't write push id to shared preferences", e2.getCause());
                    }
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str);
                if (!MixpanelAPI.this.getAuthRequestContext()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("$android_devices", jSONArray);
                        MixpanelAPI.PlaceComponentResult(MixpanelAPI.this, getAuthRequestContext("$union", jSONObject));
                    } catch (JSONException unused) {
                        MPLog.getAuthRequestContext("MixpanelAPI.API", "Exception unioning a property");
                    }
                }
            }
        }

        public String MyBillsEntityDataFactory() {
            return MixpanelAPI.this.moveToNextValue.initRecordTimeStamp();
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final People KClassImpl$Data$declaredNonStaticMembers$2(final String str) {
            if (str == null) {
                return null;
            }
            return new PeopleImpl() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.PeopleImpl.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(MixpanelAPI.this, (byte) 0);
                    PeopleImpl.this = this;
                }

                @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.PeopleImpl
                public final String MyBillsEntityDataFactory() {
                    return str;
                }

                @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.PeopleImpl, com.mixpanel.android.mpmetrics.MixpanelAPI.People
                public final void BuiltInFictitiousFunctionClassFactory(String str2) {
                    throw new RuntimeException("This MixpanelPeople object has a fixed, constant distinctId");
                }
            };
        }

        final JSONObject getAuthRequestContext(String str, Object obj) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            String MyBillsEntityDataFactory = MyBillsEntityDataFactory();
            String moveToNextValue = MixpanelAPI.this.moveToNextValue.moveToNextValue();
            jSONObject.put(str, obj);
            jSONObject.put("$token", MixpanelAPI.this.getErrorConfigVersion);
            jSONObject.put("$time", System.currentTimeMillis());
            jSONObject.put("$had_persisted_distinct_id", MixpanelAPI.this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1());
            if (moveToNextValue != null) {
                jSONObject.put("$device_id", moveToNextValue);
            }
            if (MyBillsEntityDataFactory != null) {
                jSONObject.put("$distinct_id", MyBillsEntityDataFactory);
                jSONObject.put("$user_id", MyBillsEntityDataFactory);
            }
            jSONObject.put("$mp_metadata", MixpanelAPI.this.NetworkUserEntityData$$ExternalSyntheticLambda8.MyBillsEntityDataFactory(false));
            return jSONObject;
        }

        /* renamed from: com.mixpanel.android.mpmetrics.MixpanelAPI$PeopleImpl$2 */
        /* loaded from: classes.dex */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ Activity BuiltInFictitiousFunctionClassFactory;
            final /* synthetic */ InAppNotification KClassImpl$Data$declaredNonStaticMembers$2;

            AnonymousClass2(InAppNotification inAppNotification, Activity activity) {
                PeopleImpl.this = r1;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = inAppNotification;
                this.BuiltInFictitiousFunctionClassFactory = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                ReentrantLock authRequestContext = UpdateDisplayState.getAuthRequestContext();
                authRequestContext.lock();
                try {
                    if (UpdateDisplayState.MyBillsEntityDataFactory()) {
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "DisplayState is locked, will not show notifications.");
                        return;
                    }
                    InAppNotification inAppNotification = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (inAppNotification == null) {
                        PeopleImpl peopleImpl = PeopleImpl.this;
                        inAppNotification = MixpanelAPI.this.newProxyInstance.MyBillsEntityDataFactory(MixpanelAPI.this.PlaceComponentResult.DatabaseTableConfigUtil());
                    }
                    if (inAppNotification == null) {
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "No notification available, will not show.");
                        return;
                    }
                    InAppNotification.Type authRequestContext2 = inAppNotification.getAuthRequestContext();
                    if (authRequestContext2 == InAppNotification.Type.TAKEOVER && !ConfigurationChecker.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.getApplicationContext())) {
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Application is not configured to show takeover notifications, none will be shown.");
                        return;
                    }
                    int BuiltInFictitiousFunctionClassFactory = UpdateDisplayState.BuiltInFictitiousFunctionClassFactory(new UpdateDisplayState.DisplayState.InAppNotificationState(inAppNotification, ActivityImageUtils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory)), PeopleImpl.this.MyBillsEntityDataFactory(), MixpanelAPI.this.getErrorConfigVersion);
                    if (BuiltInFictitiousFunctionClassFactory <= 0) {
                        MPLog.getAuthRequestContext("MixpanelAPI.API", "DisplayState Lock in inconsistent state! Please report this issue to Mixpanel");
                        return;
                    }
                    int i = AnonymousClass6.BuiltInFictitiousFunctionClassFactory[authRequestContext2.ordinal()];
                    if (i == 1) {
                        UpdateDisplayState MyBillsEntityDataFactory = UpdateDisplayState.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                        if (MyBillsEntityDataFactory == null) {
                            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Notification's display proposal was already consumed, no notification will be shown.");
                            return;
                        }
                        InAppFragment inAppFragment = new InAppFragment();
                        MixpanelAPI mixpanelAPI = MixpanelAPI.this;
                        UpdateDisplayState.DisplayState.InAppNotificationState inAppNotificationState = (UpdateDisplayState.DisplayState.InAppNotificationState) MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                        inAppFragment.KClassImpl$Data$declaredNonStaticMembers$2 = mixpanelAPI;
                        inAppFragment.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
                        inAppFragment.MyBillsEntityDataFactory = inAppNotificationState;
                        inAppFragment.setRetainInstance(true);
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Attempting to show mini notification.");
                        FragmentTransaction beginTransaction = this.BuiltInFictitiousFunctionClassFactory.getFragmentManager().beginTransaction();
                        beginTransaction.setCustomAnimations(0, R.animator.res_0x7f020004_kclassimpl_data_declarednonstaticmembers_2);
                        beginTransaction.add(16908290, inAppFragment);
                        try {
                            beginTransaction.commit();
                        } catch (IllegalStateException unused) {
                            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Unable to show notification.");
                            DecideMessages decideMessages = MixpanelAPI.this.newProxyInstance;
                            synchronized (decideMessages) {
                                if (!MPConfig.MyBillsEntityDataFactory) {
                                    if (inAppNotification.moveToNextValue()) {
                                        decideMessages.MyBillsEntityDataFactory.add(inAppNotification);
                                    } else {
                                        decideMessages.getAuthRequestContext.add(inAppNotification);
                                    }
                                }
                            }
                        }
                    } else if (i != 2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unrecognized notification type ");
                        sb.append(authRequestContext2);
                        sb.append(" can't be shown");
                        MPLog.getAuthRequestContext("MixpanelAPI.API", sb.toString());
                    } else {
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Sending intent for takeover notification.");
                        Intent intent = new Intent(this.BuiltInFictitiousFunctionClassFactory.getApplicationContext(), TakeoverInAppActivity.class);
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        intent.addFlags(AntDetector.SCENE_ID_LOGIN_REGIST);
                        intent.putExtra(TakeoverInAppActivity.INTENT_ID_KEY, BuiltInFictitiousFunctionClassFactory);
                        this.BuiltInFictitiousFunctionClassFactory.startActivity(intent);
                    }
                    if (!MixpanelAPI.this.PlaceComponentResult.DatabaseTableConfigUtil()) {
                        PeopleImpl peopleImpl2 = PeopleImpl.this;
                        if (inAppNotification != null) {
                            PersistentIdentity persistentIdentity = MixpanelAPI.this.moveToNextValue;
                            Integer valueOf = Integer.valueOf(inAppNotification.PlaceComponentResult());
                            synchronized (persistentIdentity) {
                                try {
                                    SharedPreferences sharedPreferences = persistentIdentity.NetworkUserEntityData$$ExternalSyntheticLambda0.get();
                                    SharedPreferences.Editor edit = sharedPreferences.edit();
                                    String string = sharedPreferences.getString("seen_campaign_ids", "");
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(string);
                                    sb2.append(valueOf);
                                    sb2.append(",");
                                    edit.putString("seen_campaign_ids", sb2.toString());
                                    PersistentIdentity.getAuthRequestContext(edit);
                                } catch (InterruptedException e) {
                                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Can't write campaign id to shared preferences", e);
                                } catch (ExecutionException e2) {
                                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Can't write campaign d to shared preferences", e2.getCause());
                                }
                            }
                            if (!MixpanelAPI.this.getAuthRequestContext()) {
                                peopleImpl2.KClassImpl$Data$declaredNonStaticMembers$2("$campaign_delivery", inAppNotification, null);
                                People KClassImpl$Data$declaredNonStaticMembers$2 = MixpanelAPI.this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(peopleImpl2.MyBillsEntityDataFactory());
                                if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                                    JSONObject MyBillsEntityDataFactory2 = inAppNotification.MyBillsEntityDataFactory();
                                    try {
                                        MyBillsEntityDataFactory2.put("$time", simpleDateFormat.format(new Date()));
                                    } catch (JSONException e3) {
                                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Exception trying to track an in-app notification seen", e3);
                                    }
                                    KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("$campaigns", Integer.valueOf(inAppNotification.PlaceComponentResult()));
                                    KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2("$notifications", MyBillsEntityDataFactory2);
                                } else {
                                    MPLog.getAuthRequestContext("MixpanelAPI.API", "No identity found. Make sure to call getPeople().identify() before showing in-app notifications.");
                                }
                            }
                        }
                    }
                } finally {
                    authRequestContext.unlock();
                }
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final boolean getAuthRequestContext() {
            return MyBillsEntityDataFactory() != null;
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void MyBillsEntityDataFactory(InAppNotification inAppNotification, Activity activity) {
            if (inAppNotification != null) {
                if (Build.VERSION.SDK_INT < 16) {
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", "Will not show notifications, os version is too low.");
                } else {
                    activity.runOnUiThread(new AnonymousClass2(inAppNotification, activity));
                }
            }
        }
    }

    /* renamed from: com.mixpanel.android.mpmetrics.MixpanelAPI$6 */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[InAppNotification.Type.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[InAppNotification.Type.MINI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[InAppNotification.Type.TAKEOVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class UnsupportedUpdatesListener implements UpdatesListener {
        @Override // com.mixpanel.android.mpmetrics.DecideMessages.OnNewResultsListener
        public final void MyBillsEntityDataFactory() {
        }

        private UnsupportedUpdatesListener() {
            MixpanelAPI.this = r1;
        }

        /* synthetic */ UnsupportedUpdatesListener(MixpanelAPI mixpanelAPI, byte b) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class SupportedUpdatesListener implements UpdatesListener, Runnable {
        private final Set<OnMixpanelUpdatesReceivedListener> MyBillsEntityDataFactory;
        private final Executor PlaceComponentResult;

        private SupportedUpdatesListener() {
            MixpanelAPI.this = r1;
            this.MyBillsEntityDataFactory = Collections.newSetFromMap(new ConcurrentHashMap());
            this.PlaceComponentResult = Executors.newSingleThreadExecutor();
        }

        /* synthetic */ SupportedUpdatesListener(MixpanelAPI mixpanelAPI, byte b) {
            this();
        }

        @Override // com.mixpanel.android.mpmetrics.DecideMessages.OnNewResultsListener
        public final void MyBillsEntityDataFactory() {
            this.PlaceComponentResult.execute(this);
        }

        /* JADX WARN: Removed duplicated region for block: B:71:0x0067 A[Catch: Exception -> 0x0110, IllegalAccessException -> 0x0117, InvocationTargetException -> 0x011c, NoSuchMethodException -> 0x0121, ClassNotFoundException -> 0x0128, TryCatch #2 {ClassNotFoundException -> 0x0128, IllegalAccessException -> 0x0117, NoSuchMethodException -> 0x0121, InvocationTargetException -> 0x011c, Exception -> 0x0110, blocks: (B:65:0x003c, B:69:0x0060, B:71:0x0067, B:73:0x00ab, B:75:0x00b1, B:77:0x00c7, B:79:0x00cd, B:81:0x00e3, B:83:0x00e9, B:85:0x00fe), top: B:103:0x003c }] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x00fe A[Catch: Exception -> 0x0110, IllegalAccessException -> 0x0117, InvocationTargetException -> 0x011c, NoSuchMethodException -> 0x0121, ClassNotFoundException -> 0x0128, TRY_LEAVE, TryCatch #2 {ClassNotFoundException -> 0x0128, IllegalAccessException -> 0x0117, NoSuchMethodException -> 0x0121, InvocationTargetException -> 0x011c, Exception -> 0x0110, blocks: (B:65:0x003c, B:69:0x0060, B:71:0x0067, B:73:0x00ab, B:75:0x00b1, B:77:0x00c7, B:79:0x00cd, B:81:0x00e3, B:83:0x00e9, B:85:0x00fe), top: B:103:0x003c }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x0100 -> B:87:0x0105). Please submit an issue!!! */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 303
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MixpanelAPI.SupportedUpdatesListener.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class NoOpUpdatesFromMixpanel implements UpdatesFromMixpanel {
        private final Tweaks getAuthRequestContext;

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        public final void BuiltInFictitiousFunctionClassFactory() {
        }

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        public final void BuiltInFictitiousFunctionClassFactory(JSONArray jSONArray) {
        }

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        public final void PlaceComponentResult(JSONArray jSONArray) {
        }

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        public final void getAuthRequestContext() {
        }

        @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
        public final void getAuthRequestContext(JSONArray jSONArray) {
        }

        public NoOpUpdatesFromMixpanel(Tweaks tweaks) {
            MixpanelAPI.this = r1;
            this.getAuthRequestContext = tweaks;
        }
    }

    public final void PlaceComponentResult() {
        if (getAuthRequestContext()) {
            return;
        }
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new AnalyticsMessages.FlushDescription(this.getErrorConfigVersion, false));
    }

    public final void BuiltInFictitiousFunctionClassFactory(String str, JSONObject jSONObject, boolean z) {
        Long l;
        if (getAuthRequestContext()) {
            return;
        }
        if (!z || this.newProxyInstance.getAuthRequestContext()) {
            synchronized (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                l = this.KClassImpl$Data$declaredNonStaticMembers$2.get(str);
                this.KClassImpl$Data$declaredNonStaticMembers$2.remove(str);
                this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(str);
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, String> entry : this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda2().entrySet()) {
                    jSONObject2.put(entry.getKey(), entry.getValue());
                }
                this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(jSONObject2);
                double currentTimeMillis = System.currentTimeMillis();
                Double.isNaN(currentTimeMillis);
                double d = currentTimeMillis / 1000.0d;
                long j = (long) d;
                String lookAheadTest2 = this.moveToNextValue.lookAheadTest();
                String moveToNextValue = this.moveToNextValue.moveToNextValue();
                String errorConfigVersion = this.moveToNextValue.getErrorConfigVersion();
                jSONObject2.put("time", j);
                jSONObject2.put("distinct_id", lookAheadTest2);
                jSONObject2.put("$had_persisted_distinct_id", this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1());
                if (moveToNextValue != null) {
                    jSONObject2.put("$device_id", moveToNextValue);
                }
                if (errorConfigVersion != null) {
                    jSONObject2.put("$user_id", errorConfigVersion);
                }
                if (l != null) {
                    double longValue = l.longValue();
                    Double.isNaN(longValue);
                    jSONObject2.put("$duration", d - (longValue / 1000.0d));
                }
                if (jSONObject != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!jSONObject.isNull(next)) {
                            jSONObject2.put(next, jSONObject.get(next));
                        }
                    }
                }
                AnalyticsMessages.EventDescription eventDescription = new AnalyticsMessages.EventDescription(str, jSONObject2, this.getErrorConfigVersion, z, this.NetworkUserEntityData$$ExternalSyntheticLambda8.MyBillsEntityDataFactory(true));
                this.getAuthRequestContext.MyBillsEntityDataFactory(eventDescription);
                WeakReference<Activity> weakReference = this.PrepareContext.MyBillsEntityDataFactory;
                if ((weakReference != null ? weakReference.get() : null) != null) {
                    PeopleImpl peopleImpl = this.scheduleImpl;
                    InAppNotification authRequestContext = this.newProxyInstance.getAuthRequestContext(eventDescription, this.PlaceComponentResult.DatabaseTableConfigUtil());
                    WeakReference<Activity> weakReference2 = this.PrepareContext.MyBillsEntityDataFactory;
                    peopleImpl.MyBillsEntityDataFactory(authRequestContext, weakReference2 != null ? weakReference2.get() : null);
                }
                TrackingDebug trackingDebug = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
                if (trackingDebug != null) {
                    trackingDebug.BuiltInFictitiousFunctionClassFactory(str);
                }
            } catch (JSONException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Exception tracking event ");
                sb.append(str);
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.API", sb.toString(), e);
            }
        }
    }

    static /* synthetic */ void PlaceComponentResult(MixpanelAPI mixpanelAPI, JSONObject jSONObject) {
        if (mixpanelAPI.getAuthRequestContext()) {
            return;
        }
        AnalyticsMessages analyticsMessages = mixpanelAPI.getAuthRequestContext;
        AnalyticsMessages.PeopleDescription peopleDescription = new AnalyticsMessages.PeopleDescription(jSONObject, mixpanelAPI.getErrorConfigVersion);
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = peopleDescription;
        analyticsMessages.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(obtain);
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MixpanelAPI mixpanelAPI, String str) {
        AnalyticsMessages analyticsMessages = mixpanelAPI.getAuthRequestContext;
        AnalyticsMessages.PushAnonymousPeopleDescription pushAnonymousPeopleDescription = new AnalyticsMessages.PushAnonymousPeopleDescription(str, mixpanelAPI.getErrorConfigVersion);
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = pushAnonymousPeopleDescription;
        analyticsMessages.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(obtain);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (getAuthRequestContext()) {
            return;
        }
        if (str == null) {
            MPLog.getAuthRequestContext("MixpanelAPI.API", "Can't identify with null distinct_id.");
            return;
        }
        synchronized (this.moveToNextValue) {
            String lookAheadTest2 = this.moveToNextValue.lookAheadTest();
            PersistentIdentity persistentIdentity = this.moveToNextValue;
            synchronized (persistentIdentity) {
                if (!persistentIdentity.scheduleImpl) {
                    persistentIdentity.BuiltInFictitiousFunctionClassFactory();
                }
                if (persistentIdentity.MyBillsEntityDataFactory == null) {
                    persistentIdentity.MyBillsEntityDataFactory = lookAheadTest2;
                    persistentIdentity.PlaceComponentResult = true;
                    persistentIdentity.scheduleImpl();
                }
            }
            PersistentIdentity persistentIdentity2 = this.moveToNextValue;
            synchronized (persistentIdentity2) {
                if (!persistentIdentity2.scheduleImpl) {
                    persistentIdentity2.BuiltInFictitiousFunctionClassFactory();
                }
                persistentIdentity2.KClassImpl$Data$declaredNonStaticMembers$2 = str;
                persistentIdentity2.scheduleImpl();
            }
            PersistentIdentity persistentIdentity3 = this.moveToNextValue;
            synchronized (persistentIdentity3) {
                if (!persistentIdentity3.scheduleImpl) {
                    persistentIdentity3.BuiltInFictitiousFunctionClassFactory();
                }
                persistentIdentity3.BuiltInFictitiousFunctionClassFactory = true;
                persistentIdentity3.scheduleImpl();
            }
            String initRecordTimeStamp2 = this.moveToNextValue.initRecordTimeStamp();
            if (initRecordTimeStamp2 == null) {
                initRecordTimeStamp2 = this.moveToNextValue.lookAheadTest();
            }
            this.newProxyInstance.KClassImpl$Data$declaredNonStaticMembers$2(initRecordTimeStamp2);
            if (!str.equals(lookAheadTest2)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("$anon_distinct_id", lookAheadTest2);
                    if (!getAuthRequestContext()) {
                        BuiltInFictitiousFunctionClassFactory("$identify", jSONObject, false);
                    }
                } catch (JSONException unused) {
                    MPLog.getAuthRequestContext("MixpanelAPI.API", "Could not track $identify event");
                }
            }
        }
    }

    public final void PlaceComponentResult(String str) {
        PersistentIdentity persistentIdentity = this.moveToNextValue;
        String str2 = this.getErrorConfigVersion;
        synchronized (persistentIdentity) {
            persistentIdentity.moveToNextValue = Boolean.FALSE;
            persistentIdentity.MyBillsEntityDataFactory(str2);
        }
        if (str != null) {
            KClassImpl$Data$declaredNonStaticMembers$2(str);
        }
        if (getAuthRequestContext()) {
            return;
        }
        BuiltInFictitiousFunctionClassFactory("$opt_in", null, false);
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        AnalyticsMessages BuiltInFictitiousFunctionClassFactory = AnalyticsMessages.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
        AnalyticsMessages.MixpanelDescription mixpanelDescription = new AnalyticsMessages.MixpanelDescription(this.getErrorConfigVersion);
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.obj = mixpanelDescription;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(obtain);
        if (this.scheduleImpl.getAuthRequestContext()) {
            this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2();
            this.scheduleImpl.BuiltInFictitiousFunctionClassFactory();
        }
        PersistentIdentity persistentIdentity = this.moveToNextValue;
        synchronized (persistentIdentity) {
            try {
                SharedPreferences.Editor edit = persistentIdentity.NetworkUserEntityData$$ExternalSyntheticLambda0.get().edit();
                edit.clear();
                edit.apply();
                persistentIdentity.PlaceComponentResult();
                persistentIdentity.BuiltInFictitiousFunctionClassFactory();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getCause());
            } catch (ExecutionException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        synchronized (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
            try {
                SharedPreferences.Editor edit2 = this.moveToNextValue.DatabaseTableConfigUtil.get().edit();
                edit2.clear();
                edit2.apply();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        PersistentIdentity persistentIdentity2 = this.moveToNextValue;
        synchronized (PersistentIdentity.getAuthRequestContext) {
            try {
                SharedPreferences.Editor edit3 = persistentIdentity2.lookAheadTest.get().edit();
                edit3.clear();
                edit3.apply();
            } catch (InterruptedException e3) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e3);
            } catch (ExecutionException e4) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e4.getCause());
            }
        }
        PersistentIdentity persistentIdentity3 = this.moveToNextValue;
        String str = this.getErrorConfigVersion;
        synchronized (persistentIdentity3) {
            persistentIdentity3.moveToNextValue = Boolean.TRUE;
            persistentIdentity3.MyBillsEntityDataFactory(str);
        }
    }
}
