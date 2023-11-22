package io.branch.referral;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import com.alibaba.ariver.kernel.RVParams;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.plus.security.lite.SecLiteException;
import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.sendmoney.summary.SummaryActivity;
import io.branch.indexing.ContentDiscoverer;
import io.branch.referral.BranchStrongMatchHelper;
import io.branch.referral.BranchViewHandler;
import io.branch.referral.DeferredAppLinkDataHandler;
import io.branch.referral.Defines;
import io.branch.referral.InstallListener;
import io.branch.referral.ServerRequest;
import io.branch.referral.SystemObserver;
import io.branch.referral.network.BranchRemoteInterface;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Branch implements BranchViewHandler.IBranchViewEvents, SystemObserver.GAdsParamsFetchEvents, InstallListener.IInstallReferrerEvents {
    public static Branch BuiltInFictitiousFunctionClassFactory = null;
    private static long FragmentBottomSheetPaymentSettingBinding = 1500;
    static boolean MyBillsEntityDataFactory = false;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda3 = false;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
    static boolean getAuthRequestContext = true;
    private static boolean initRecordTimeStamp = false;
    private static boolean newProxyInstance = false;
    private boolean B;
    private INTENT_STATE BottomSheetCardBindingView$watcherCardNumberView$1;
    private Map<BranchLinkData, String> C;
    private ShareLinkManager D;
    private int E;
    private final TrackingController F;
    WeakReference<Activity> KClassImpl$Data$declaredNonStaticMembers$2;
    public PrefHelper NetworkUserEntityData$$ExternalSyntheticLambda1;
    private WeakReference<BranchReferralInitListener> NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final DeviceInfo NetworkUserEntityData$$ExternalSyntheticLambda5;
    private BranchRemoteInterface NetworkUserEntityData$$ExternalSyntheticLambda6;
    public Context PlaceComponentResult;
    private boolean getCallingPid;
    public final ConcurrentHashMap<String, String> getErrorConfigVersion;
    private Semaphore getOnBoardingScenario;
    private final ServerRequestQueue getValueOfTouchPositionAbsolute;
    final Object moveToNextValue;
    public JSONObject scheduleImpl;
    private boolean whenAvailable;
    private static CUSTOM_REFERRABLE_SETTINGS isLayoutRequested = CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT;
    private static String DatabaseTableConfigUtil = "app.link";
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = 2500;
    private static final String[] GetContactSyncConfig = {"extra_launch_uri", "branch_intent"};
    private static boolean PrepareContext = true;
    private boolean getSupportButtonTintMode = false;
    private SESSION_STATE A = SESSION_STATE.UNINITIALISED;
    boolean lookAheadTest = false;
    private CountDownLatch readMicros = null;
    private CountDownLatch SubSequence = null;
    private boolean VerifyPinStateManager$executeRiskChallenge$2$2 = false;
    boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
    private boolean VerifyPinStateManager$executeRiskChallenge$2$1 = false;

    /* loaded from: classes.dex */
    public interface BranchLinkCreateListener {
        void onLinkCreate(String str, BranchError branchError);
    }

    /* loaded from: classes2.dex */
    public interface BranchLinkShareListener {
        void BuiltInFictitiousFunctionClassFactory(String str);

        void MyBillsEntityDataFactory(String str, String str2, BranchError branchError);
    }

    /* loaded from: classes2.dex */
    public interface BranchListResponseListener {
    }

    /* loaded from: classes.dex */
    public interface BranchReferralInitListener {
        void onInitFinished(JSONObject jSONObject, BranchError branchError);
    }

    /* loaded from: classes2.dex */
    public interface BranchReferralStateChangedListener {
    }

    /* loaded from: classes2.dex */
    public interface BranchUniversalReferralInitListener {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum CUSTOM_REFERRABLE_SETTINGS {
        USE_DEFAULT,
        REFERRABLE,
        NON_REFERRABLE
    }

    /* loaded from: classes2.dex */
    public enum CreditHistoryOrder {
        kMostRecentFirst,
        kLeastRecentFirst
    }

    /* loaded from: classes2.dex */
    public interface ExtendedBranchLinkShareListener extends BranchLinkShareListener {
        boolean BuiltInFictitiousFunctionClassFactory();
    }

    /* loaded from: classes2.dex */
    public interface IBranchViewControl {
        boolean getAuthRequestContext();
    }

    /* loaded from: classes2.dex */
    public interface IChannelProperties {
        String MyBillsEntityDataFactory();

        String getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum INTENT_STATE {
        PENDING,
        READY
    }

    /* loaded from: classes.dex */
    public interface LogoutStatusListener {
        void onLogoutFinished(boolean z, BranchError branchError);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum SESSION_STATE {
        INITIALISED,
        INITIALISING,
        UNINITIALISED
    }

    /* loaded from: classes2.dex */
    public static class ShareLinkBuilder {
        Drawable BuiltInFictitiousFunctionClassFactory;
        String KClassImpl$Data$declaredNonStaticMembers$2;
        Drawable MyBillsEntityDataFactory;
        String PlaceComponentResult;
        String getAuthRequestContext;
        String getErrorConfigVersion;
        String lookAheadTest;
        public BranchShortLinkBuilder moveToNextValue;
        String scheduleImpl;
    }

    static /* synthetic */ int NetworkUserEntityData$$ExternalSyntheticLambda0(Branch branch) {
        branch.E = 0;
        return 0;
    }

    private Branch(Context context) {
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = INTENT_STATE.PENDING;
        this.whenAvailable = false;
        this.B = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = PrefHelper.BuiltInFictitiousFunctionClassFactory(context);
        TrackingController trackingController = new TrackingController(context);
        this.F = trackingController;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = BranchRemoteInterface.getAuthRequestContext(context);
        DeviceInfo KClassImpl$Data$declaredNonStaticMembers$2 = DeviceInfo.KClassImpl$Data$declaredNonStaticMembers$2(context);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = KClassImpl$Data$declaredNonStaticMembers$2;
        this.getValueOfTouchPositionAbsolute = ServerRequestQueue.BuiltInFictitiousFunctionClassFactory(context);
        this.getOnBoardingScenario = new Semaphore(1);
        this.moveToNextValue = new Object();
        this.E = 0;
        this.getCallingPid = true;
        this.C = new HashMap();
        this.getErrorConfigVersion = new ConcurrentHashMap<>();
        if (!trackingController.KClassImpl$Data$declaredNonStaticMembers$2()) {
            this.B = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(context, this);
        }
        if (Build.VERSION.SDK_INT >= 15) {
            this.whenAvailable = true;
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = INTENT_STATE.PENDING;
            return;
        }
        this.whenAvailable = false;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = INTENT_STATE.READY;
    }

    public final boolean scheduleImpl() {
        return this.F.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static Branch BuiltInFictitiousFunctionClassFactory() {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            PrefHelper.MyBillsEntityDataFactory("Branch instance is not created yet. Make sure you have initialised Branch. [Consider Calling getInstance(Context ctx) if you still have issue.]");
        } else if (newProxyInstance && !NetworkUserEntityData$$ExternalSyntheticLambda7) {
            PrefHelper.MyBillsEntityDataFactory("Branch instance is not properly initialised. Make sure your Application class is extending BranchApp class. If you are not extending BranchApp class make sure you are initialising Branch in your Applications onCreate()");
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    private static Branch BuiltInFictitiousFunctionClassFactory(Context context, boolean z) {
        boolean errorConfigVersion;
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = new Branch(context.getApplicationContext());
            boolean authRequestContext = BranchUtil.getAuthRequestContext(context);
            byte b = 0;
            if (z) {
                authRequestContext = false;
            }
            BranchUtil.PlaceComponentResult(authRequestContext);
            String str = null;
            String PlaceComponentResult = TextUtils.isEmpty(null) ? BranchUtil.PlaceComponentResult(context) : null;
            if (TextUtils.isEmpty(PlaceComponentResult)) {
                try {
                    Resources resources = context.getResources();
                    str = resources.getString(resources.getIdentifier("io.branch.apiKey", "string", context.getPackageName()));
                } catch (Exception unused) {
                }
                if (!TextUtils.isEmpty(str)) {
                    errorConfigVersion = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1.getErrorConfigVersion(str);
                } else {
                    PrefHelper.MyBillsEntityDataFactory("Warning: Please enter your branch_key in your project's Manifest file!");
                    errorConfigVersion = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1.getErrorConfigVersion("bnc_no_value");
                }
            } else {
                errorConfigVersion = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1.getErrorConfigVersion(PlaceComponentResult);
            }
            if (errorConfigVersion) {
                BuiltInFictitiousFunctionClassFactory.C.clear();
                BuiltInFictitiousFunctionClassFactory.getValueOfTouchPositionAbsolute.BuiltInFictitiousFunctionClassFactory();
            }
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = context.getApplicationContext();
            if (context instanceof Application) {
                newProxyInstance = true;
                Application application = (Application) context;
                try {
                    BranchActivityLifeCycleObserver branchActivityLifeCycleObserver = new BranchActivityLifeCycleObserver(BuiltInFictitiousFunctionClassFactory, b);
                    application.unregisterActivityLifecycleCallbacks(branchActivityLifeCycleObserver);
                    application.registerActivityLifecycleCallbacks(branchActivityLifeCycleObserver);
                    NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
                } catch (NoClassDefFoundError | NoSuchMethodError unused2) {
                    NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
                    newProxyInstance = false;
                    PrefHelper.MyBillsEntityDataFactory(new BranchError("", -108).BuiltInFictitiousFunctionClassFactory);
                }
            }
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static Branch BuiltInFictitiousFunctionClassFactory(Context context) {
        return BuiltInFictitiousFunctionClassFactory(context, true);
    }

    public static Branch getAuthRequestContext(Context context) {
        return BuiltInFictitiousFunctionClassFactory(context, false);
    }

    public static Branch PlaceComponentResult(Context context) {
        newProxyInstance = true;
        isLayoutRequested = CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT;
        BuiltInFictitiousFunctionClassFactory(context, true ^ BranchUtil.getAuthRequestContext(context));
        BranchPreinstall.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, context);
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static boolean getAuthRequestContext() {
        return NetworkUserEntityData$$ExternalSyntheticLambda8;
    }

    public final Branch MyBillsEntityDataFactory(String str, String str2) {
        PrefHelper prefHelper = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (str != null) {
            try {
                prefHelper.PlaceComponentResult.putOpt(str, str2);
            } catch (JSONException unused) {
            }
        }
        return this;
    }

    public final boolean PlaceComponentResult(BranchReferralInitListener branchReferralInitListener) {
        return getAuthRequestContext(branchReferralInitListener, (Activity) null);
    }

    private boolean getAuthRequestContext(BranchReferralInitListener branchReferralInitListener, Activity activity) {
        if (isLayoutRequested == CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT) {
            KClassImpl$Data$declaredNonStaticMembers$2(branchReferralInitListener, activity, true);
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2(branchReferralInitListener, activity, isLayoutRequested == CUSTOM_REFERRABLE_SETTINGS.REFERRABLE);
        }
        return true;
    }

    private boolean getAuthRequestContext(BranchReferralInitListener branchReferralInitListener, Uri uri, Activity activity) {
        KClassImpl$Data$declaredNonStaticMembers$2(uri, activity);
        return getAuthRequestContext(branchReferralInitListener, activity);
    }

    public final boolean PlaceComponentResult(Activity activity, BranchReferralInitListener branchReferralInitListener) {
        Uri data;
        if (activity == null) {
            return false;
        }
        Intent intent = activity.getIntent();
        if (intent == null || (data = intent.getData()) == null) {
            return true;
        }
        this.A = SESSION_STATE.INITIALISING;
        PrefHelper.getAuthRequestContext("bnc_external_intent_uri", data.toString());
        PrefHelper.getAuthRequestContext("bnc_app_link", data.toString());
        this.lookAheadTest = false;
        BuiltInFictitiousFunctionClassFactory(branchReferralInitListener);
        getAuthRequestContext(branchReferralInitListener, data, activity);
        return true;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(BranchReferralInitListener branchReferralInitListener, Activity activity, boolean z) {
        if (activity != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new WeakReference<>(activity);
        }
        if (branchReferralInitListener != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = new WeakReference<>(branchReferralInitListener);
        }
        if (DatabaseTableConfigUtil() && NetworkUserEntityData$$ExternalSyntheticLambda2() && this.A == SESSION_STATE.INITIALISED) {
            KClassImpl$Data$declaredNonStaticMembers$2(branchReferralInitListener);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            return;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 && KClassImpl$Data$declaredNonStaticMembers$2(branchReferralInitListener)) {
            this.getErrorConfigVersion.put(Defines.Jsonkey.InstantDeepLinkSession.getKey(), SummaryActivity.CHECKED);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
        if (z) {
            PrefHelper.PlaceComponentResult("bnc_is_referrable", 1);
        } else {
            PrefHelper.PlaceComponentResult("bnc_is_referrable", 0);
        }
        if (this.A != SESSION_STATE.INITIALISING) {
            this.A = SESSION_STATE.INITIALISING;
            BuiltInFictitiousFunctionClassFactory(branchReferralInitListener);
        } else if (branchReferralInitListener != null) {
            this.getValueOfTouchPositionAbsolute.PlaceComponentResult(branchReferralInitListener);
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(BranchReferralInitListener branchReferralInitListener) {
        if (branchReferralInitListener != null) {
            if (newProxyInstance) {
                if (!this.lookAheadTest) {
                    branchReferralInitListener.onInitFinished(BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params"))), null);
                    this.lookAheadTest = true;
                } else {
                    branchReferralInitListener.onInitFinished(new JSONObject(), null);
                }
            } else {
                branchReferralInitListener.onInitFinished(new JSONObject(), null);
            }
        }
        return this.lookAheadTest;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, Activity activity) {
        String obj;
        String obj2;
        if (!PrepareContext && ((this.BottomSheetCardBindingView$watcherCardNumberView$1 == INTENT_STATE.READY || this.VerifyPinStateManager$executeRiskChallenge$2$1) && activity != null && activity.getIntent() != null && this.A != SESSION_STATE.INITIALISED && !KClassImpl$Data$declaredNonStaticMembers$2(activity.getIntent()))) {
            Intent intent = activity.getIntent();
            try {
                if (intent.getData() == null || (!this.VerifyPinStateManager$executeRiskChallenge$2$1 && MyBillsEntityDataFactory(activity))) {
                    if (!PrefHelper.lookAheadTest("bnc_install_params").equals("bnc_no_value")) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(Defines.Jsonkey.Clicked_Branch_Link.getKey(), false);
                        jSONObject.put(Defines.Jsonkey.IsFirstSession.getKey(), false);
                        PrefHelper.getAuthRequestContext("bnc_session_params", jSONObject.toString());
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                    }
                } else if (!TextUtils.isEmpty(intent.getStringExtra(Defines.Jsonkey.BranchData.getKey()))) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(intent.getStringExtra(Defines.Jsonkey.BranchData.getKey()));
                        jSONObject2.put(Defines.Jsonkey.Clicked_Branch_Link.getKey(), true);
                        PrefHelper.getAuthRequestContext("bnc_session_params", jSONObject2.toString());
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                    } catch (JSONException unused) {
                    }
                    intent.removeExtra(Defines.Jsonkey.BranchData.getKey());
                    activity.setIntent(intent);
                } else if (uri.getQueryParameterNames() != null && Boolean.valueOf(uri.getQueryParameter(Defines.Jsonkey.Instant.getKey())).booleanValue()) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (String str : uri.getQueryParameterNames()) {
                        jSONObject3.put(str, uri.getQueryParameter(str));
                    }
                    jSONObject3.put(Defines.Jsonkey.Clicked_Branch_Link.getKey(), true);
                    PrefHelper.getAuthRequestContext("bnc_session_params", jSONObject3.toString());
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                }
            } catch (JSONException unused2) {
            }
        }
        if (initRecordTimeStamp) {
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = INTENT_STATE.READY;
        }
        if (this.BottomSheetCardBindingView$watcherCardNumberView$1 == INTENT_STATE.READY) {
            if (uri != null) {
                try {
                    if (!MyBillsEntityDataFactory(activity)) {
                        String MyBillsEntityDataFactory2 = UniversalResourceAnalyser.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult).MyBillsEntityDataFactory(uri.toString());
                        PrefHelper.getAuthRequestContext("bnc_external_intent_uri", MyBillsEntityDataFactory2);
                        if (MyBillsEntityDataFactory2 != null && MyBillsEntityDataFactory2.equals(uri.toString()) && activity != null && activity.getIntent() != null && activity.getIntent().getExtras() != null) {
                            Bundle extras = activity.getIntent().getExtras();
                            Set<String> keySet = extras.keySet();
                            if (keySet.size() > 0) {
                                JSONObject jSONObject4 = new JSONObject();
                                for (String str2 : GetContactSyncConfig) {
                                    if (keySet.contains(str2)) {
                                        jSONObject4.put(str2, extras.get(str2));
                                    }
                                }
                                if (jSONObject4.length() > 0) {
                                    PrefHelper.getAuthRequestContext("bnc_external_intent_extra", jSONObject4.toString());
                                }
                            }
                        }
                    }
                } catch (Exception unused3) {
                }
            }
            if (activity != null) {
                try {
                    if (activity.getIntent() != null && activity.getIntent().getExtras() != null && !MyBillsEntityDataFactory(activity)) {
                        Object obj3 = activity.getIntent().getExtras().get(Defines.Jsonkey.AndroidPushNotificationKey.getKey());
                        if (obj3 instanceof String) {
                            obj = (String) obj3;
                        } else {
                            obj = obj3 instanceof Uri ? ((Uri) obj3).toString() : null;
                        }
                        if (!TextUtils.isEmpty(obj)) {
                            PrefHelper.getAuthRequestContext("bnc_push_identifier", obj);
                            Intent intent2 = activity.getIntent();
                            intent2.putExtra(Defines.Jsonkey.BranchLinkUsed.getKey(), true);
                            activity.setIntent(intent2);
                            return false;
                        }
                    }
                } catch (Exception unused4) {
                }
            }
            if (uri != null && uri.isHierarchical() && activity != null && !getAuthRequestContext(activity)) {
                try {
                    if (uri.getQueryParameter(Defines.Jsonkey.LinkClickID.getKey()) == null) {
                        String scheme = uri.getScheme();
                        Intent intent3 = activity.getIntent();
                        if (scheme != null && intent3 != null && ((scheme.equalsIgnoreCase(SemanticAttributes.FaasTriggerValues.HTTP) || scheme.equalsIgnoreCase("https")) && uri.getHost() != null && uri.getHost().length() > 0 && !MyBillsEntityDataFactory(activity))) {
                            if (uri.toString().equalsIgnoreCase(UniversalResourceAnalyser.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult).MyBillsEntityDataFactory(uri.toString()))) {
                                PrefHelper.getAuthRequestContext("bnc_app_link", uri.toString());
                            }
                            intent3.putExtra(Defines.Jsonkey.BranchLinkUsed.getKey(), true);
                            activity.setIntent(intent3);
                        }
                    } else {
                        PrefHelper.getAuthRequestContext("bnc_link_click_identifier", uri.getQueryParameter(Defines.Jsonkey.LinkClickID.getKey()));
                        StringBuilder sb = new StringBuilder();
                        sb.append("link_click_id=");
                        sb.append(uri.getQueryParameter(Defines.Jsonkey.LinkClickID.getKey()));
                        String obj4 = sb.toString();
                        String dataString = activity.getIntent() != null ? activity.getIntent().getDataString() : null;
                        if (uri.getQuery().length() == obj4.length()) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("\\?");
                            sb2.append(obj4);
                            obj2 = sb2.toString();
                        } else if (dataString != null && dataString.length() - obj4.length() == dataString.indexOf(obj4)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(ContainerUtils.FIELD_DELIMITER);
                            sb3.append(obj4);
                            obj2 = sb3.toString();
                        } else {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(obj4);
                            sb4.append(ContainerUtils.FIELD_DELIMITER);
                            obj2 = sb4.toString();
                        }
                        if (dataString != null) {
                            activity.getIntent().setData(Uri.parse(dataString.replaceFirst(obj2, "")));
                            activity.getIntent().putExtra(Defines.Jsonkey.BranchLinkUsed.getKey(), true);
                        } else {
                            PrefHelper.MyBillsEntityDataFactory("Warning: URI for the launcher activity is null. Please make sure that intent data is not set to null before calling Branch#InitSession ");
                        }
                        return true;
                    }
                } catch (Exception unused5) {
                }
            }
        }
        return false;
    }

    private static boolean MyBillsEntityDataFactory(Activity activity) {
        return (activity == null || activity.getIntent() == null || !activity.getIntent().getBooleanExtra(Defines.Jsonkey.BranchLinkUsed.getKey(), false)) ? false : true;
    }

    private static boolean getAuthRequestContext(Activity activity) {
        return (activity == null || activity.getIntent() == null || (activity.getIntent().getFlags() & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) == 0) ? false : true;
    }

    @Override // io.branch.referral.SystemObserver.GAdsParamsFetchEvents
    public final void getErrorConfigVersion() {
        this.B = false;
        this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory(ServerRequest.PROCESS_WAIT_LOCK.GAID_FETCH_WAIT_LOCK);
        if (this.VerifyPinStateManager$executeRiskChallenge$2$2) {
            newProxyInstance();
            this.VerifyPinStateManager$executeRiskChallenge$2$2 = false;
            return;
        }
        isLayoutRequested();
    }

    @Override // io.branch.referral.InstallListener.IInstallReferrerEvents
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory(ServerRequest.PROCESS_WAIT_LOCK.INSTALL_REFERRER_FETCH_WAIT_LOCK);
        isLayoutRequested();
    }

    public final JSONObject BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = this.scheduleImpl;
                if (jSONObject2 != null) {
                    if (jSONObject2.length() > 0) {
                        PrefHelper.MyBillsEntityDataFactory("You're currently in deep link debug mode. Please comment out 'setDeepLinkDebugMode' to receive the deep link parameters from a real Branch link");
                    }
                    Iterator<String> keys = this.scheduleImpl.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.put(next, this.scheduleImpl.get(next));
                    }
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getAuthRequestContext(ServerRequestCreateUrl serverRequestCreateUrl) {
        if (!serverRequestCreateUrl.MyBillsEntityDataFactory && !serverRequestCreateUrl.getAuthRequestContext(this.PlaceComponentResult)) {
            if (this.C.containsKey(serverRequestCreateUrl.moveToNextValue)) {
                String str = this.C.get(serverRequestCreateUrl.moveToNextValue);
                BranchLinkCreateListener branchLinkCreateListener = serverRequestCreateUrl.scheduleImpl;
                if (branchLinkCreateListener != null) {
                    branchLinkCreateListener.onLinkCreate(str, null);
                }
                serverRequestCreateUrl.initRecordTimeStamp();
                return str;
            } else if (!serverRequestCreateUrl.PrepareContext()) {
                return MyBillsEntityDataFactory(serverRequestCreateUrl);
            } else {
                getAuthRequestContext((ServerRequest) serverRequestCreateUrl);
            }
        }
        return null;
    }

    private String MyBillsEntityDataFactory(ServerRequestCreateUrl serverRequestCreateUrl) {
        ServerResponse serverResponse;
        JSONObject jSONObject;
        int i;
        if (this.F.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return serverRequestCreateUrl.isLayoutRequested();
        }
        if (this.A == SESSION_STATE.INITIALISED) {
            try {
                i = PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getInt("bnc_timeout", 5500);
                serverResponse = new getShortLinkTask(this, (byte) 0).execute(serverRequestCreateUrl).get(i + 2000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                serverResponse = null;
            }
            String isLayoutRequested2 = serverRequestCreateUrl.NetworkUserEntityData$$ExternalSyntheticLambda8() ? serverRequestCreateUrl.isLayoutRequested() : null;
            if (serverResponse != null && serverResponse.BuiltInFictitiousFunctionClassFactory == 200) {
                try {
                    Object obj = serverResponse.PlaceComponentResult;
                    if (obj instanceof JSONObject) {
                        jSONObject = (JSONObject) obj;
                    } else {
                        jSONObject = new JSONObject();
                    }
                    isLayoutRequested2 = jSONObject.getString("url");
                    if (serverRequestCreateUrl.moveToNextValue != null) {
                        this.C.put(serverRequestCreateUrl.moveToNextValue, isLayoutRequested2);
                    }
                } catch (JSONException unused2) {
                }
            }
            return isLayoutRequested2;
        }
        PrefHelper.MyBillsEntityDataFactory("Warning: User session has not been initialized");
        return null;
    }

    public static JSONObject MyBillsEntityDataFactory(String str) {
        if (str.equals("bnc_no_value")) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            try {
                return new JSONObject(new String(Base64.MyBillsEntityDataFactory(str.getBytes())));
            } catch (JSONException unused2) {
                return new JSONObject();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isLayoutRequested() {
        try {
            this.getOnBoardingScenario.acquire();
            if (this.E == 0 && this.getValueOfTouchPositionAbsolute.lookAheadTest() > 0) {
                this.E = 1;
                ServerRequest NetworkUserEntityData$$ExternalSyntheticLambda0 = this.getValueOfTouchPositionAbsolute.NetworkUserEntityData$$ExternalSyntheticLambda0();
                this.getOnBoardingScenario.release();
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                    if (!NetworkUserEntityData$$ExternalSyntheticLambda0.getErrorConfigVersion()) {
                        if (!(NetworkUserEntityData$$ExternalSyntheticLambda0 instanceof ServerRequestRegisterInstall) && !DatabaseTableConfigUtil()) {
                            PrefHelper.MyBillsEntityDataFactory("Branch Error: User session has not been initialized!");
                            this.E = 0;
                            KClassImpl$Data$declaredNonStaticMembers$2(this.getValueOfTouchPositionAbsolute.lookAheadTest() - 1, SecLiteException.ERROR_API_KEY_OR_SIGN);
                            return;
                        } else if (BuiltInFictitiousFunctionClassFactory(NetworkUserEntityData$$ExternalSyntheticLambda0) && !PrepareContext()) {
                            this.E = 0;
                            KClassImpl$Data$declaredNonStaticMembers$2(this.getValueOfTouchPositionAbsolute.lookAheadTest() - 1, SecLiteException.ERROR_API_KEY_OR_SIGN);
                            return;
                        } else {
                            new BranchPostTask(NetworkUserEntityData$$ExternalSyntheticLambda0).KClassImpl$Data$declaredNonStaticMembers$2(new Void[0]);
                            return;
                        }
                    }
                    this.E = 0;
                    return;
                }
                this.getValueOfTouchPositionAbsolute.KClassImpl$Data$declaredNonStaticMembers$2((ServerRequest) null);
                return;
            }
            this.getOnBoardingScenario.release();
        } catch (Exception unused) {
        }
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(ServerRequest serverRequest) {
        return ((serverRequest instanceof ServerRequestInitSession) || (serverRequest instanceof ServerRequestCreateUrl)) ? false : true;
    }

    private boolean PrepareContext() {
        return NetworkUserEntityData$$ExternalSyntheticLambda2() && initRecordTimeStamp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        ServerRequest authRequestContext;
        if (i >= this.getValueOfTouchPositionAbsolute.lookAheadTest()) {
            authRequestContext = this.getValueOfTouchPositionAbsolute.getAuthRequestContext(r2.lookAheadTest() - 1);
        } else {
            authRequestContext = this.getValueOfTouchPositionAbsolute.getAuthRequestContext(i);
        }
        if (authRequestContext != null) {
            authRequestContext.PlaceComponentResult(i2, "");
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(ServerRequest serverRequest, BranchReferralInitListener branchReferralInitListener) {
        if (this.getValueOfTouchPositionAbsolute.getAuthRequestContext()) {
            if (branchReferralInitListener != null) {
                this.getValueOfTouchPositionAbsolute.PlaceComponentResult(branchReferralInitListener);
            }
            this.getValueOfTouchPositionAbsolute.getAuthRequestContext(serverRequest, this.E);
        } else if (this.E == 0) {
            this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory(serverRequest, 0);
        } else {
            this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory(serverRequest, 1);
        }
        isLayoutRequested();
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(BranchReferralInitListener branchReferralInitListener, ServerRequest.PROCESS_WAIT_LOCK process_wait_lock) {
        ServerRequest.PROCESS_WAIT_LOCK process_wait_lock2;
        ServerRequest.PROCESS_WAIT_LOCK process_wait_lock3;
        ServerRequest MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(branchReferralInitListener);
        if (process_wait_lock != null) {
            MyBillsEntityDataFactory2.getAuthRequestContext.add(process_wait_lock);
        }
        if (this.B && (process_wait_lock3 = ServerRequest.PROCESS_WAIT_LOCK.GAID_FETCH_WAIT_LOCK) != null) {
            MyBillsEntityDataFactory2.getAuthRequestContext.add(process_wait_lock3);
        }
        if (this.BottomSheetCardBindingView$watcherCardNumberView$1 != INTENT_STATE.READY && !GetContactSyncConfig() && (process_wait_lock2 = ServerRequest.PROCESS_WAIT_LOCK.INTENT_PENDING_WAIT_LOCK) != null) {
            MyBillsEntityDataFactory2.getAuthRequestContext.add(process_wait_lock2);
        }
        if (getAuthRequestContext && (MyBillsEntityDataFactory2 instanceof ServerRequestRegisterInstall) && !InstallListener.unReportedReferrerAvailable) {
            ServerRequest.PROCESS_WAIT_LOCK process_wait_lock4 = ServerRequest.PROCESS_WAIT_LOCK.INSTALL_REFERRER_FETCH_WAIT_LOCK;
            if (process_wait_lock4 != null) {
                MyBillsEntityDataFactory2.getAuthRequestContext.add(process_wait_lock4);
            }
            new InstallListener().captureInstallReferrer(this.PlaceComponentResult, FragmentBottomSheetPaymentSettingBinding, this);
        }
        BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2, branchReferralInitListener);
    }

    private ServerRequest MyBillsEntityDataFactory(BranchReferralInitListener branchReferralInitListener) {
        if (DatabaseTableConfigUtil()) {
            return new ServerRequestRegisterOpen(this.PlaceComponentResult, branchReferralInitListener);
        }
        return new ServerRequestRegisterInstall(this.PlaceComponentResult, branchReferralInitListener, InstallListener.getInstallationID());
    }

    private void newProxyInstance() {
        if (this.F.KClassImpl$Data$declaredNonStaticMembers$2()) {
            return;
        }
        WeakReference<Activity> weakReference = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Activity activity = weakReference != null ? weakReference.get() : null;
        Context applicationContext = activity != null ? activity.getApplicationContext() : null;
        if (applicationContext != null) {
            this.getValueOfTouchPositionAbsolute.scheduleImpl();
            BranchStrongMatchHelper.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(applicationContext, DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda5, this.NetworkUserEntityData$$ExternalSyntheticLambda1, new BranchStrongMatchHelper.StrongMatchCheckEvents() { // from class: io.branch.referral.Branch.2
                @Override // io.branch.referral.BranchStrongMatchHelper.StrongMatchCheckEvents
                public final void BuiltInFictitiousFunctionClassFactory() {
                    Branch.this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory(ServerRequest.PROCESS_WAIT_LOCK.STRONG_MATCH_PENDING_WAIT_LOCK);
                    Branch.this.isLayoutRequested();
                }
            });
        }
    }

    public final void getAuthRequestContext(ServerRequest serverRequest) {
        if (this.F.KClassImpl$Data$declaredNonStaticMembers$2() && !serverRequest.moveToNextValue()) {
            serverRequest.DatabaseTableConfigUtil();
            return;
        }
        if (this.A != SESSION_STATE.INITIALISED && !(serverRequest instanceof ServerRequestInitSession)) {
            if (serverRequest instanceof ServerRequestLogout) {
                serverRequest.PlaceComponentResult(SecLiteException.ERROR_API_KEY_OR_SIGN, "");
                PrefHelper.MyBillsEntityDataFactory("Branch is not initialized, cannot logout");
                return;
            } else if (serverRequest instanceof ServerRequestRegisterClose) {
                PrefHelper.MyBillsEntityDataFactory("Branch is not initialized, cannot close session");
                return;
            } else {
                WeakReference<Activity> weakReference = this.KClassImpl$Data$declaredNonStaticMembers$2;
                Activity activity = weakReference != null ? weakReference.get() : null;
                if (isLayoutRequested == CUSTOM_REFERRABLE_SETTINGS.USE_DEFAULT) {
                    KClassImpl$Data$declaredNonStaticMembers$2(null, activity, true);
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$2(null, activity, isLayoutRequested == CUSTOM_REFERRABLE_SETTINGS.REFERRABLE);
                }
            }
        }
        if (!(serverRequest instanceof ServerRequestPing)) {
            this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory(serverRequest);
            serverRequest.BuiltInFictitiousFunctionClassFactory = System.currentTimeMillis();
        }
        isLayoutRequested();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class BranchActivityLifeCycleObserver implements Application.ActivityLifecycleCallbacks {
        private int PlaceComponentResult;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        private BranchActivityLifeCycleObserver() {
            this.PlaceComponentResult = 0;
        }

        /* synthetic */ BranchActivityLifeCycleObserver(Branch branch, byte b) {
            this();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Branch branch = Branch.this;
            branch.BottomSheetCardBindingView$watcherCardNumberView$1 = branch.whenAvailable ? INTENT_STATE.PENDING : INTENT_STATE.READY;
            Branch.this.VerifyPinStateManager$executeRiskChallenge$2$1 = true;
            if (BranchViewHandler.getAuthRequestContext().MyBillsEntityDataFactory(activity.getApplicationContext())) {
                BranchViewHandler.getAuthRequestContext().getAuthRequestContext(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Branch branch = Branch.this;
            branch.BottomSheetCardBindingView$watcherCardNumberView$1 = branch.whenAvailable ? INTENT_STATE.PENDING : INTENT_STATE.READY;
            if (Branch.this.A == SESSION_STATE.INITIALISED) {
                try {
                    ContentDiscoverer MyBillsEntityDataFactory = ContentDiscoverer.MyBillsEntityDataFactory();
                    PrefHelper prefHelper = Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    String lookAheadTest = PrefHelper.lookAheadTest("bnc_external_intent_uri");
                    if (lookAheadTest.equals("bnc_no_value")) {
                        lookAheadTest = null;
                    }
                    MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(activity, lookAheadTest);
                } catch (Exception unused) {
                }
            }
            if (this.PlaceComponentResult <= 0) {
                if (Branch.this.A == SESSION_STATE.INITIALISED) {
                    Branch.this.A = SESSION_STATE.UNINITIALISED;
                }
                Branch.MyBillsEntityDataFactory(Branch.this, activity);
            } else if (Branch.KClassImpl$Data$declaredNonStaticMembers$2(activity.getIntent())) {
                Branch.this.A = SESSION_STATE.UNINITIALISED;
                Branch.MyBillsEntityDataFactory(Branch.this, activity);
            }
            this.PlaceComponentResult++;
            Branch.this.VerifyPinStateManager$executeRiskChallenge$2$1 = false;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (Branch.KClassImpl$Data$declaredNonStaticMembers$2(activity.getIntent())) {
                Branch.this.A = SESSION_STATE.UNINITIALISED;
                Branch.MyBillsEntityDataFactory(Branch.this, activity);
            }
            Branch.this.KClassImpl$Data$declaredNonStaticMembers$2 = new WeakReference<>(activity);
            if (!Branch.this.whenAvailable || Branch.initRecordTimeStamp) {
                return;
            }
            Branch.this.BottomSheetCardBindingView$watcherCardNumberView$1 = INTENT_STATE.READY;
            Branch.MyBillsEntityDataFactory(Branch.this, activity, (activity.getIntent() == null || Branch.this.A == SESSION_STATE.INITIALISED) ? false : true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (Branch.this.D != null) {
                Branch.this.D.PlaceComponentResult(true);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            ContentDiscoverer MyBillsEntityDataFactory = ContentDiscoverer.MyBillsEntityDataFactory();
            WeakReference<Activity> weakReference = MyBillsEntityDataFactory.MyBillsEntityDataFactory;
            if (weakReference != null && weakReference.get() != null && MyBillsEntityDataFactory.MyBillsEntityDataFactory.get().getClass().getName().equals(activity.getClass().getName())) {
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.removeCallbacks(MyBillsEntityDataFactory.getAuthRequestContext);
                MyBillsEntityDataFactory.MyBillsEntityDataFactory = null;
            }
            try {
                JSONObject jSONObject = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                if (jSONObject != null) {
                    jSONObject.put(RVParams.TITLE_COLOR, System.currentTimeMillis());
                }
            } catch (JSONException unused) {
            }
            Iterator<WeakReference<ViewTreeObserver>> it = MyBillsEntityDataFactory.scheduleImpl.values().iterator();
            while (it.hasNext()) {
                ViewTreeObserver viewTreeObserver = it.next().get();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnScrollChangedListener(MyBillsEntityDataFactory.getErrorConfigVersion);
                }
            }
            MyBillsEntityDataFactory.scheduleImpl.clear();
            int i = this.PlaceComponentResult - 1;
            this.PlaceComponentResult = i;
            if (i <= 0) {
                Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                Branch.this.lookAheadTest();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (Branch.this.KClassImpl$Data$declaredNonStaticMembers$2 != null && Branch.this.KClassImpl$Data$declaredNonStaticMembers$2.get() == activity) {
                Branch.this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
            }
            BranchViewHandler authRequestContext = BranchViewHandler.getAuthRequestContext();
            String str = authRequestContext.BuiltInFictitiousFunctionClassFactory;
            if (str == null || !str.equalsIgnoreCase(activity.getClass().getName())) {
                return;
            }
            authRequestContext.getAuthRequestContext = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Intent intent) {
        if (intent != null) {
            try {
                if (intent.getBooleanExtra(Defines.Jsonkey.ForceNewBranchSession.getKey(), false)) {
                    try {
                        intent.putExtra(Defines.Jsonkey.ForceNewBranchSession.getKey(), false);
                    } catch (Throwable unused) {
                    }
                } else if (intent.getStringExtra(Defines.Jsonkey.AndroidPushNotificationKey.getKey()) == null) {
                    return false;
                } else {
                    if (intent.getBooleanExtra(Defines.Jsonkey.BranchLinkUsed.getKey(), false)) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused2) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class getShortLinkTask extends AsyncTask<ServerRequest, Void, ServerResponse> {
        private getShortLinkTask() {
        }

        /* synthetic */ getShortLinkTask(Branch branch, byte b) {
            this();
        }

        @Override // android.os.AsyncTask
        protected /* synthetic */ ServerResponse doInBackground(ServerRequest[] serverRequestArr) {
            BranchRemoteInterface branchRemoteInterface = Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            JSONObject jSONObject = serverRequestArr[0].PlaceComponentResult;
            StringBuilder sb = new StringBuilder();
            PrefHelper unused = Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            sb.append(PrefHelper.getAuthRequestContext());
            sb.append("v1/url");
            String obj = sb.toString();
            String path = Defines.RequestPath.GetURL.getPath();
            PrefHelper unused2 = Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (PrefHelper.getAuthRequestContext == null) {
                PrefHelper.getAuthRequestContext = PrefHelper.lookAheadTest("bnc_branch_key");
            }
            return branchRemoteInterface.MyBillsEntityDataFactory(jSONObject, obj, path, PrefHelper.getAuthRequestContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class BranchPostTask extends BranchAsyncTask<Void, Void, ServerResponse> {
        ServerRequest PlaceComponentResult;

        @Override // android.os.AsyncTask
        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            JSONObject optJSONObject;
            Void[] voidArr = (Void[]) objArr;
            Branch branch = Branch.this;
            StringBuilder sb = new StringBuilder();
            sb.append(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append("-");
            sb.append(Defines.Jsonkey.Queue_Wait_Time.getKey());
            String obj = sb.toString();
            ServerRequest serverRequest = this.PlaceComponentResult;
            branch.getErrorConfigVersion.put(obj, String.valueOf(serverRequest.BuiltInFictitiousFunctionClassFactory > 0 ? System.currentTimeMillis() - serverRequest.BuiltInFictitiousFunctionClassFactory : 0L));
            ServerRequest serverRequest2 = this.PlaceComponentResult;
            if (serverRequest2 instanceof ServerRequestInitSession) {
                ((ServerRequestInitSession) serverRequest2).isLayoutRequested();
            }
            serverRequest2.BuiltInFictitiousFunctionClassFactory();
            if (!BranchUtil.PlaceComponentResult()) {
                ServerRequest.BRANCH_API_VERSION PlaceComponentResult = serverRequest2.PlaceComponentResult();
                int i = DeviceInfo.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
                String str = DeviceInfo.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                try {
                    if (!TextUtils.isEmpty(str)) {
                        if (PlaceComponentResult != ServerRequest.BRANCH_API_VERSION.V2 && PlaceComponentResult != ServerRequest.BRANCH_API_VERSION.V1_CPID && PlaceComponentResult != ServerRequest.BRANCH_API_VERSION.V1_LATD) {
                            serverRequest2.PlaceComponentResult.put(Defines.Jsonkey.GoogleAdvertisingID.getKey(), str);
                            serverRequest2.PlaceComponentResult.put(Defines.Jsonkey.LATVal.getKey(), i);
                        }
                        JSONObject optJSONObject2 = serverRequest2.PlaceComponentResult.optJSONObject(Defines.Jsonkey.UserData.getKey());
                        if (optJSONObject2 != null) {
                            optJSONObject2.put(Defines.Jsonkey.AAID.getKey(), str);
                            optJSONObject2.put(Defines.Jsonkey.LimitedAdTracking.getKey(), i);
                            optJSONObject2.remove(Defines.Jsonkey.UnidentifiedDevice.getKey());
                        }
                    } else if (PlaceComponentResult == ServerRequest.BRANCH_API_VERSION.V2 || PlaceComponentResult == ServerRequest.BRANCH_API_VERSION.V1_CPID) {
                        if ((PlaceComponentResult == ServerRequest.BRANCH_API_VERSION.V2 || PlaceComponentResult == ServerRequest.BRANCH_API_VERSION.V1_CPID || PlaceComponentResult == ServerRequest.BRANCH_API_VERSION.V1_LATD) && (optJSONObject = serverRequest2.PlaceComponentResult.optJSONObject(Defines.Jsonkey.UserData.getKey())) != null && !optJSONObject.has(Defines.Jsonkey.AndroidID.getKey())) {
                            optJSONObject.put(Defines.Jsonkey.UnidentifiedDevice.getKey(), true);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            if (!Branch.this.scheduleImpl() || this.PlaceComponentResult.moveToNextValue()) {
                if (this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                    BranchRemoteInterface branchRemoteInterface = Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    String MyBillsEntityDataFactory = this.PlaceComponentResult.MyBillsEntityDataFactory();
                    JSONObject jSONObject = this.PlaceComponentResult.PlaceComponentResult;
                    String str2 = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    PrefHelper unused2 = Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (PrefHelper.getAuthRequestContext == null) {
                        PrefHelper.getAuthRequestContext = PrefHelper.lookAheadTest("bnc_branch_key");
                    }
                    return branchRemoteInterface.PlaceComponentResult(MyBillsEntityDataFactory, jSONObject, str2, PrefHelper.getAuthRequestContext);
                }
                BranchRemoteInterface branchRemoteInterface2 = Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda6;
                JSONObject BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(Branch.this.getErrorConfigVersion);
                String MyBillsEntityDataFactory2 = this.PlaceComponentResult.MyBillsEntityDataFactory();
                String str3 = this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0;
                PrefHelper unused3 = Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (PrefHelper.getAuthRequestContext == null) {
                    PrefHelper.getAuthRequestContext = PrefHelper.lookAheadTest("bnc_branch_key");
                }
                return branchRemoteInterface2.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory2, str3, PrefHelper.getAuthRequestContext);
            }
            return new ServerResponse(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0, -117);
        }

        @Override // android.os.AsyncTask
        protected /* synthetic */ void onPostExecute(Object obj) {
            JSONObject jSONObject;
            JSONObject jSONObject2;
            JSONObject jSONObject3;
            ServerResponse serverResponse = (ServerResponse) obj;
            super.onPostExecute(serverResponse);
            if (serverResponse != null) {
                try {
                    int i = serverResponse.BuiltInFictitiousFunctionClassFactory;
                    Branch.this.getCallingPid = true;
                    if (serverResponse.BuiltInFictitiousFunctionClassFactory == -117) {
                        this.PlaceComponentResult.DatabaseTableConfigUtil();
                        Branch.this.getValueOfTouchPositionAbsolute.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
                    } else {
                        int i2 = 0;
                        if (i == 200) {
                            Branch.this.getCallingPid = true;
                            ServerRequest serverRequest = this.PlaceComponentResult;
                            if (!(serverRequest instanceof ServerRequestCreateUrl)) {
                                if (serverRequest instanceof ServerRequestLogout) {
                                    Branch.this.C.clear();
                                    Branch.this.getValueOfTouchPositionAbsolute.BuiltInFictitiousFunctionClassFactory();
                                }
                            } else {
                                Object obj2 = serverResponse.PlaceComponentResult;
                                if (obj2 instanceof JSONObject) {
                                    jSONObject2 = (JSONObject) obj2;
                                } else {
                                    jSONObject2 = new JSONObject();
                                }
                                if (jSONObject2 != null) {
                                    Object obj3 = serverResponse.PlaceComponentResult;
                                    if (obj3 instanceof JSONObject) {
                                        jSONObject3 = (JSONObject) obj3;
                                    } else {
                                        jSONObject3 = new JSONObject();
                                    }
                                    Branch.this.C.put(((ServerRequestCreateUrl) this.PlaceComponentResult).moveToNextValue, jSONObject3.getString("url"));
                                }
                            }
                            Branch.this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory();
                            ServerRequest serverRequest2 = this.PlaceComponentResult;
                            if (!(serverRequest2 instanceof ServerRequestInitSession) && !(serverRequest2 instanceof ServerRequestIdentifyUserRequest)) {
                                serverRequest2.getAuthRequestContext(serverResponse, Branch.BuiltInFictitiousFunctionClassFactory);
                            }
                            Object obj4 = serverResponse.PlaceComponentResult;
                            if (obj4 instanceof JSONObject) {
                                jSONObject = (JSONObject) obj4;
                            } else {
                                jSONObject = new JSONObject();
                            }
                            if (jSONObject != null) {
                                if (!Branch.this.scheduleImpl()) {
                                    if (jSONObject.has(Defines.Jsonkey.SessionID.getKey())) {
                                        PrefHelper unused = Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                        PrefHelper.getAuthRequestContext("bnc_session_id", jSONObject.getString(Defines.Jsonkey.SessionID.getKey()));
                                        i2 = 1;
                                    }
                                    if (jSONObject.has(Defines.Jsonkey.IdentityID.getKey())) {
                                        String string = jSONObject.getString(Defines.Jsonkey.IdentityID.getKey());
                                        PrefHelper unused2 = Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                        if (!PrefHelper.lookAheadTest("bnc_identity_id").equals(string)) {
                                            Branch.this.C.clear();
                                            PrefHelper unused3 = Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                            PrefHelper.getAuthRequestContext("bnc_identity_id", jSONObject.getString(Defines.Jsonkey.IdentityID.getKey()));
                                            i2 = 1;
                                        }
                                    }
                                    if (jSONObject.has(Defines.Jsonkey.DeviceFingerprintID.getKey())) {
                                        PrefHelper unused4 = Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                        PrefHelper.getAuthRequestContext("bnc_device_fingerprint_id", jSONObject.getString(Defines.Jsonkey.DeviceFingerprintID.getKey()));
                                        i2 = 1;
                                    }
                                }
                                if (i2 != 0) {
                                    Branch.lookAheadTest(Branch.this);
                                }
                                ServerRequest serverRequest3 = this.PlaceComponentResult;
                                if (!(serverRequest3 instanceof ServerRequestInitSession)) {
                                    serverRequest3.getAuthRequestContext(serverResponse, Branch.BuiltInFictitiousFunctionClassFactory);
                                } else {
                                    Branch.this.A = SESSION_STATE.INITIALISED;
                                    this.PlaceComponentResult.getAuthRequestContext(serverResponse, Branch.BuiltInFictitiousFunctionClassFactory);
                                    if (!Branch.this.lookAheadTest && !((ServerRequestInitSession) this.PlaceComponentResult).BuiltInFictitiousFunctionClassFactory(serverResponse)) {
                                        Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda1();
                                    }
                                    if (((ServerRequestInitSession) this.PlaceComponentResult).PrepareContext()) {
                                        Branch.this.lookAheadTest = true;
                                    }
                                    if (Branch.this.SubSequence != null) {
                                        Branch.this.SubSequence.countDown();
                                    }
                                    if (Branch.this.readMicros != null) {
                                        Branch.this.readMicros.countDown();
                                    }
                                }
                            }
                        } else {
                            if (this.PlaceComponentResult instanceof ServerRequestInitSession) {
                                Branch.this.A = SESSION_STATE.UNINITIALISED;
                            }
                            if (i == 400 || i == 409) {
                                Branch.this.getValueOfTouchPositionAbsolute.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
                                ServerRequest serverRequest4 = this.PlaceComponentResult;
                                if (!(serverRequest4 instanceof ServerRequestCreateUrl)) {
                                    PrefHelper.PlaceComponentResult("Branch API Error: Conflicting resource error code from API");
                                    Branch.this.KClassImpl$Data$declaredNonStaticMembers$2(0, i);
                                } else {
                                    BranchLinkCreateListener branchLinkCreateListener = ((ServerRequestCreateUrl) serverRequest4).scheduleImpl;
                                    if (branchLinkCreateListener != null) {
                                        branchLinkCreateListener.onLinkCreate(null, new BranchError("Trouble creating a URL.", BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS));
                                    }
                                }
                            } else {
                                Branch.this.getCallingPid = false;
                                ArrayList arrayList = new ArrayList();
                                while (i2 < Branch.this.getValueOfTouchPositionAbsolute.lookAheadTest()) {
                                    arrayList.add(Branch.this.getValueOfTouchPositionAbsolute.getAuthRequestContext(i2));
                                    i2++;
                                }
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    ServerRequest serverRequest5 = (ServerRequest) it.next();
                                    if (serverRequest5 == null || !serverRequest5.NetworkUserEntityData$$ExternalSyntheticLambda1()) {
                                        Branch.this.getValueOfTouchPositionAbsolute.KClassImpl$Data$declaredNonStaticMembers$2(serverRequest5);
                                    }
                                }
                                Branch.NetworkUserEntityData$$ExternalSyntheticLambda0(Branch.this);
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    ServerRequest serverRequest6 = (ServerRequest) it2.next();
                                    if (serverRequest6 != null) {
                                        serverRequest6.PlaceComponentResult(i, serverResponse.MyBillsEntityDataFactory());
                                        if (serverRequest6.NetworkUserEntityData$$ExternalSyntheticLambda1()) {
                                            serverRequest6.KClassImpl$Data$declaredNonStaticMembers$2();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Branch.NetworkUserEntityData$$ExternalSyntheticLambda0(Branch.this);
                    if (!Branch.this.getCallingPid || Branch.this.A == SESSION_STATE.UNINITIALISED) {
                        return;
                    }
                    Branch.this.isLayoutRequested();
                } catch (JSONException unused5) {
                }
            }
        }

        public BranchPostTask(ServerRequest serverRequest) {
            this.PlaceComponentResult = serverRequest;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.PlaceComponentResult.lookAheadTest();
            this.PlaceComponentResult.getAuthRequestContext();
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(JSONObject jSONObject, ActivityInfo activityInfo) {
        if (activityInfo.metaData.getString("io.branch.sdk.auto_link_keys") != null) {
            for (String str : activityInfo.metaData.getString("io.branch.sdk.auto_link_keys").split(",")) {
                if (jSONObject.has(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean getAuthRequestContext(org.json.JSONObject r4, android.content.pm.ActivityInfo r5) {
        /*
            r0 = 0
            io.branch.referral.Defines$Jsonkey r1 = io.branch.referral.Defines.Jsonkey.AndroidDeepLinkPath     // Catch: org.json.JSONException -> L30
            java.lang.String r1 = r1.getKey()     // Catch: org.json.JSONException -> L30
            boolean r1 = r4.has(r1)     // Catch: org.json.JSONException -> L30
            if (r1 == 0) goto L19
            io.branch.referral.Defines$Jsonkey r1 = io.branch.referral.Defines.Jsonkey.AndroidDeepLinkPath     // Catch: org.json.JSONException -> L30
            java.lang.String r1 = r1.getKey()     // Catch: org.json.JSONException -> L30
            java.lang.String r4 = r4.getString(r1)     // Catch: org.json.JSONException -> L30
        L17:
            r0 = r4
            goto L31
        L19:
            io.branch.referral.Defines$Jsonkey r1 = io.branch.referral.Defines.Jsonkey.DeepLinkPath     // Catch: org.json.JSONException -> L30
            java.lang.String r1 = r1.getKey()     // Catch: org.json.JSONException -> L30
            boolean r1 = r4.has(r1)     // Catch: org.json.JSONException -> L30
            if (r1 == 0) goto L31
            io.branch.referral.Defines$Jsonkey r1 = io.branch.referral.Defines.Jsonkey.DeepLinkPath     // Catch: org.json.JSONException -> L30
            java.lang.String r1 = r1.getKey()     // Catch: org.json.JSONException -> L30
            java.lang.String r4 = r4.getString(r1)     // Catch: org.json.JSONException -> L30
            goto L17
        L30:
        L31:
            android.os.Bundle r4 = r5.metaData
            java.lang.String r1 = "io.branch.sdk.auto_link_path"
            java.lang.String r4 = r4.getString(r1)
            r2 = 0
            if (r4 == 0) goto L5f
            if (r0 == 0) goto L5f
            android.os.Bundle r4 = r5.metaData
            java.lang.String r4 = r4.getString(r1)
            java.lang.String r5 = ","
            java.lang.String[] r4 = r4.split(r5)
            int r5 = r4.length
            r1 = 0
        L4c:
            if (r1 >= r5) goto L5f
            r3 = r4[r1]
            java.lang.String r3 = r3.trim()
            boolean r3 = getAuthRequestContext(r3, r0)
            if (r3 == 0) goto L5c
            r4 = 1
            return r4
        L5c:
            int r1 = r1 + 1
            goto L4c
        L5f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.Branch.getAuthRequestContext(org.json.JSONObject, android.content.pm.ActivityInfo):boolean");
    }

    private static boolean getAuthRequestContext(String str, String str2) {
        String[] split = str.split("\\?")[0].split("/");
        String[] split2 = str2.split("\\?")[0].split("/");
        if (split.length != split2.length) {
            return false;
        }
        for (int i = 0; i < split.length && i < split2.length; i++) {
            String str3 = split[i];
            if (!str3.equals(split2[i]) && !str3.contains("*")) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean moveToNextValue() {
        return NetworkUserEntityData$$ExternalSyntheticLambda3;
    }

    private static boolean GetContactSyncConfig() {
        return MyBillsEntityDataFactory;
    }

    @Override // io.branch.referral.BranchViewHandler.IBranchViewEvents
    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        if (ServerRequestInitSession.MyBillsEntityDataFactory(str)) {
            NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
    }

    @Override // io.branch.referral.BranchViewHandler.IBranchViewEvents
    public final void PlaceComponentResult(String str) {
        if (ServerRequestInitSession.MyBillsEntityDataFactory(str)) {
            NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
    }

    @Override // io.branch.referral.BranchViewHandler.IBranchViewEvents
    public final void getAuthRequestContext(String str) {
        if (ServerRequestInitSession.MyBillsEntityDataFactory(str)) {
            NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(Branch branch, Activity activity, boolean z) {
        branch.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory(ServerRequest.PROCESS_WAIT_LOCK.INTENT_PENDING_WAIT_LOCK);
        if (z) {
            branch.KClassImpl$Data$declaredNonStaticMembers$2(activity.getIntent().getData(), activity);
            if (!branch.scheduleImpl() && DatabaseTableConfigUtil != null) {
                PrefHelper prefHelper = branch.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (PrefHelper.getAuthRequestContext == null) {
                    PrefHelper.getAuthRequestContext = PrefHelper.lookAheadTest("bnc_branch_key");
                }
                if (PrefHelper.getAuthRequestContext != null) {
                    PrefHelper prefHelper2 = branch.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (PrefHelper.getAuthRequestContext == null) {
                        PrefHelper.getAuthRequestContext = PrefHelper.lookAheadTest("bnc_branch_key");
                    }
                    if (!PrefHelper.getAuthRequestContext.equalsIgnoreCase("bnc_no_value")) {
                        if (branch.B) {
                            branch.VerifyPinStateManager$executeRiskChallenge$2$2 = true;
                            return;
                        } else {
                            branch.newProxyInstance();
                            return;
                        }
                    }
                }
            }
            branch.isLayoutRequested();
            return;
        }
        branch.isLayoutRequested();
    }

    static /* synthetic */ void lookAheadTest(Branch branch) {
        JSONObject jSONObject;
        for (int i = 0; i < branch.getValueOfTouchPositionAbsolute.lookAheadTest(); i++) {
            try {
                ServerRequest authRequestContext = branch.getValueOfTouchPositionAbsolute.getAuthRequestContext(i);
                if (authRequestContext != null && (jSONObject = authRequestContext.PlaceComponentResult) != null) {
                    if (jSONObject.has(Defines.Jsonkey.SessionID.getKey())) {
                        JSONObject jSONObject2 = authRequestContext.PlaceComponentResult;
                        String key = Defines.Jsonkey.SessionID.getKey();
                        PrefHelper prefHelper = branch.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        jSONObject2.put(key, PrefHelper.lookAheadTest("bnc_session_id"));
                    }
                    if (jSONObject.has(Defines.Jsonkey.IdentityID.getKey())) {
                        JSONObject jSONObject3 = authRequestContext.PlaceComponentResult;
                        String key2 = Defines.Jsonkey.IdentityID.getKey();
                        PrefHelper prefHelper2 = branch.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        jSONObject3.put(key2, PrefHelper.lookAheadTest("bnc_identity_id"));
                    }
                    if (jSONObject.has(Defines.Jsonkey.DeviceFingerprintID.getKey())) {
                        JSONObject jSONObject4 = authRequestContext.PlaceComponentResult;
                        String key3 = Defines.Jsonkey.DeviceFingerprintID.getKey();
                        PrefHelper prefHelper3 = branch.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        jSONObject4.put(key3, PrefHelper.lookAheadTest("bnc_device_fingerprint_id"));
                    }
                }
            } catch (JSONException unused) {
                return;
            }
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(Branch branch, Activity activity) {
        Uri data = activity.getIntent() != null ? activity.getIntent().getData() : null;
        WeakReference<BranchReferralInitListener> weakReference = branch.NetworkUserEntityData$$ExternalSyntheticLambda4;
        BranchReferralInitListener branchReferralInitListener = weakReference != null ? weakReference.get() : null;
        branch.lookAheadTest = false;
        branch.getAuthRequestContext(branchReferralInitListener, data, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        WeakReference<Activity> weakReference;
        JSONObject BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params")));
        String str = null;
        try {
            if (BuiltInFictitiousFunctionClassFactory2.has(Defines.Jsonkey.Clicked_Branch_Link.getKey()) && BuiltInFictitiousFunctionClassFactory2.getBoolean(Defines.Jsonkey.Clicked_Branch_Link.getKey()) && BuiltInFictitiousFunctionClassFactory2.length() > 0) {
                ApplicationInfo applicationInfo = this.PlaceComponentResult.getPackageManager().getApplicationInfo(this.PlaceComponentResult.getPackageName(), 128);
                if (applicationInfo.metaData == null || !applicationInfo.metaData.getBoolean("io.branch.sdk.auto_link_disable", false)) {
                    ActivityInfo[] activityInfoArr = this.PlaceComponentResult.getPackageManager().getPackageInfo(this.PlaceComponentResult.getPackageName(), 129).activities;
                    int i = 1501;
                    if (activityInfoArr != null) {
                        for (ActivityInfo activityInfo : activityInfoArr) {
                            if (activityInfo != null && activityInfo.metaData != null && ((activityInfo.metaData.getString("io.branch.sdk.auto_link_keys") != null || activityInfo.metaData.getString("io.branch.sdk.auto_link_path") != null) && (KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2, activityInfo) || getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2, activityInfo)))) {
                                str = activityInfo.name;
                                i = activityInfo.metaData.getInt("io.branch.sdk.auto_link_request_code", 1501);
                                break;
                            }
                        }
                    }
                    if (str == null || (weakReference = this.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                        return;
                    }
                    Activity activity = weakReference.get();
                    if (activity != null) {
                        Intent intent = new Intent(activity, Class.forName(str));
                        intent.putExtra("io.branch.sdk.auto_linked", SummaryActivity.CHECKED);
                        intent.putExtra(Defines.Jsonkey.ReferringData.getKey(), BuiltInFictitiousFunctionClassFactory2.toString());
                        Iterator<String> keys = BuiltInFictitiousFunctionClassFactory2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            intent.putExtra(next, BuiltInFictitiousFunctionClassFactory2.getString(next));
                        }
                        activity.startActivityForResult(intent, i);
                        return;
                    }
                    PrefHelper.MyBillsEntityDataFactory("No activity reference to launch deep linked activity");
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            PrefHelper.MyBillsEntityDataFactory("Warning: Please make sure Activity names set for auto deep link are correct!");
        } catch (ClassNotFoundException unused2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Warning: Please make sure Activity names set for auto deep link are correct! Error while looking for activity ");
            sb.append((String) null);
            PrefHelper.MyBillsEntityDataFactory(sb.toString());
        } catch (Exception unused3) {
        }
    }

    private boolean initRecordTimeStamp() {
        return !PrefHelper.lookAheadTest("bnc_device_fingerprint_id").equals("bnc_no_value");
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return !PrefHelper.lookAheadTest("bnc_session_id").equals("bnc_no_value");
    }

    private boolean DatabaseTableConfigUtil() {
        return !PrefHelper.lookAheadTest("bnc_identity_id").equals("bnc_no_value");
    }

    private void BuiltInFictitiousFunctionClassFactory(BranchReferralInitListener branchReferralInitListener) {
        if (PrefHelper.getAuthRequestContext == null) {
            PrefHelper.getAuthRequestContext = PrefHelper.lookAheadTest("bnc_branch_key");
        }
        if (PrefHelper.getAuthRequestContext != null) {
            if (PrefHelper.getAuthRequestContext == null) {
                PrefHelper.getAuthRequestContext = PrefHelper.lookAheadTest("bnc_branch_key");
            }
            if (!PrefHelper.getAuthRequestContext.equalsIgnoreCase("bnc_no_value")) {
                if (PrefHelper.getAuthRequestContext == null) {
                    PrefHelper.getAuthRequestContext = PrefHelper.lookAheadTest("bnc_branch_key");
                }
                if (PrefHelper.getAuthRequestContext != null) {
                    if (PrefHelper.getAuthRequestContext == null) {
                        PrefHelper.getAuthRequestContext = PrefHelper.lookAheadTest("bnc_branch_key");
                    }
                    if (PrefHelper.getAuthRequestContext.startsWith("key_test_")) {
                        PrefHelper.MyBillsEntityDataFactory("Warning: You are using your test app's Branch Key. Remember to change it to live Branch Key during deployment.");
                    }
                }
                String lookAheadTest = PrefHelper.lookAheadTest("bnc_external_intent_uri");
                if (lookAheadTest.equals("bnc_no_value")) {
                    lookAheadTest = null;
                }
                if (lookAheadTest != null || !this.getSupportButtonTintMode) {
                    KClassImpl$Data$declaredNonStaticMembers$2(branchReferralInitListener, (ServerRequest.PROCESS_WAIT_LOCK) null);
                    return;
                } else if (DeferredAppLinkDataHandler.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, new DeferredAppLinkDataHandler.AppLinkFetchEvents() { // from class: io.branch.referral.Branch.1
                    @Override // io.branch.referral.DeferredAppLinkDataHandler.AppLinkFetchEvents
                    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
                        PrefHelper unused = Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        PrefHelper.KClassImpl$Data$declaredNonStaticMembers$2("bnc_triggered_by_fb_app_link", Boolean.TRUE);
                        if (str != null) {
                            String queryParameter = Uri.parse(str).getQueryParameter(Defines.Jsonkey.LinkClickID.getKey());
                            if (!TextUtils.isEmpty(queryParameter)) {
                                PrefHelper unused2 = Branch.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                PrefHelper.getAuthRequestContext("bnc_link_click_identifier", queryParameter);
                            }
                        }
                        Branch.this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory(ServerRequest.PROCESS_WAIT_LOCK.FB_APP_LINK_WAIT_LOCK);
                        Branch.this.isLayoutRequested();
                    }
                }).booleanValue()) {
                    KClassImpl$Data$declaredNonStaticMembers$2(branchReferralInitListener, ServerRequest.PROCESS_WAIT_LOCK.FB_APP_LINK_WAIT_LOCK);
                    return;
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$2(branchReferralInitListener, (ServerRequest.PROCESS_WAIT_LOCK) null);
                    return;
                }
            }
        }
        this.A = SESSION_STATE.UNINITIALISED;
        if (branchReferralInitListener != null) {
            branchReferralInitListener.onInitFinished(null, new BranchError("Trouble initializing Branch.", -114));
        }
        PrefHelper.MyBillsEntityDataFactory("Warning: Please enter your branch_key in your project's res/values/strings.xml!");
    }

    final void lookAheadTest() {
        if (this.A != SESSION_STATE.UNINITIALISED) {
            if (!this.getCallingPid) {
                ServerRequest NetworkUserEntityData$$ExternalSyntheticLambda0 = this.getValueOfTouchPositionAbsolute.NetworkUserEntityData$$ExternalSyntheticLambda0();
                if ((NetworkUserEntityData$$ExternalSyntheticLambda0 != null && (NetworkUserEntityData$$ExternalSyntheticLambda0 instanceof ServerRequestRegisterInstall)) || (NetworkUserEntityData$$ExternalSyntheticLambda0 instanceof ServerRequestRegisterOpen)) {
                    this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory();
                }
            } else if (!this.getValueOfTouchPositionAbsolute.KClassImpl$Data$declaredNonStaticMembers$2()) {
                getAuthRequestContext(new ServerRequestRegisterClose(this.PlaceComponentResult));
            }
            this.A = SESSION_STATE.UNINITIALISED;
        }
        PrefHelper.getAuthRequestContext("bnc_external_intent_uri", (String) null);
        TrackingController trackingController = this.F;
        PrefHelper.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult);
        trackingController.PlaceComponentResult = PrefHelper.getAuthRequestContext("bnc_tracking_state");
    }
}
