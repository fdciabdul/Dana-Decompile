package io.branch.referral;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import io.branch.referral.Defines;
import io.branch.referral.SystemObserver;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class ServerRequest {
    long BuiltInFictitiousFunctionClassFactory;
    protected final PrefHelper KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean MyBillsEntityDataFactory;
    String NetworkUserEntityData$$ExternalSyntheticLambda0;
    JSONObject PlaceComponentResult;
    final Set<PROCESS_WAIT_LOCK> getAuthRequestContext;
    boolean lookAheadTest;
    private final Context scheduleImpl;

    /* loaded from: classes.dex */
    public enum BRANCH_API_VERSION {
        V1,
        V1_CPID,
        V1_LATD,
        V2
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum PROCESS_WAIT_LOCK {
        FB_APP_LINK_WAIT_LOCK,
        GAID_FETCH_WAIT_LOCK,
        INTENT_PENDING_WAIT_LOCK,
        STRONG_MATCH_PENDING_WAIT_LOCK,
        INSTALL_REFERRER_FETCH_WAIT_LOCK
    }

    protected boolean GetContactSyncConfig() {
        return false;
    }

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract boolean NetworkUserEntityData$$ExternalSyntheticLambda0();

    public boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return false;
    }

    public abstract void PlaceComponentResult(int i, String str);

    public abstract void getAuthRequestContext(ServerResponse serverResponse, Branch branch);

    public abstract boolean getAuthRequestContext(Context context);

    public void lookAheadTest() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean moveToNextValue() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean scheduleImpl() {
        return true;
    }

    public ServerRequest(Context context, String str) {
        this.BuiltInFictitiousFunctionClassFactory = 0L;
        this.MyBillsEntityDataFactory = false;
        this.lookAheadTest = false;
        this.scheduleImpl = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = PrefHelper.BuiltInFictitiousFunctionClassFactory(context);
        this.PlaceComponentResult = new JSONObject();
        this.getAuthRequestContext = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ServerRequest(String str, JSONObject jSONObject, Context context) {
        this.BuiltInFictitiousFunctionClassFactory = 0L;
        this.MyBillsEntityDataFactory = false;
        this.lookAheadTest = false;
        this.scheduleImpl = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        this.PlaceComponentResult = jSONObject;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = PrefHelper.BuiltInFictitiousFunctionClassFactory(context);
        this.getAuthRequestContext = new HashSet();
    }

    public String MyBillsEntityDataFactory() {
        StringBuilder sb = new StringBuilder();
        sb.append(PrefHelper.getAuthRequestContext());
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void MyBillsEntityDataFactory(JSONObject jSONObject) throws JSONException {
        this.PlaceComponentResult = jSONObject;
        try {
            if (PlaceComponentResult() == BRANCH_API_VERSION.V2) {
                JSONObject jSONObject2 = new JSONObject();
                this.PlaceComponentResult.put(Defines.Jsonkey.UserData.getKey(), jSONObject2);
                DeviceInfo.getAuthRequestContext().PlaceComponentResult(this.scheduleImpl, this.KClassImpl$Data$declaredNonStaticMembers$2, jSONObject2);
            } else if (PlaceComponentResult() == BRANCH_API_VERSION.V1_CPID) {
                JSONObject jSONObject3 = new JSONObject();
                this.PlaceComponentResult.put(Defines.Jsonkey.UserData.getKey(), jSONObject3);
                DeviceInfo.getAuthRequestContext().PlaceComponentResult(this.scheduleImpl, this.KClassImpl$Data$declaredNonStaticMembers$2, jSONObject3);
            } else if (PlaceComponentResult() == BRANCH_API_VERSION.V1_LATD) {
                JSONObject jSONObject4 = new JSONObject();
                this.PlaceComponentResult.put(Defines.Jsonkey.UserData.getKey(), jSONObject4);
                DeviceInfo.getAuthRequestContext().PlaceComponentResult(this.scheduleImpl, this.KClassImpl$Data$declaredNonStaticMembers$2, jSONObject4);
                DeviceInfo.getAuthRequestContext();
                DeviceInfo.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, jSONObject4);
            } else {
                DeviceInfo authRequestContext = DeviceInfo.getAuthRequestContext();
                JSONObject jSONObject5 = this.PlaceComponentResult;
                try {
                    SystemObserver systemObserver = authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
                    SystemObserver.UniqueId authRequestContext2 = SystemObserver.getAuthRequestContext(authRequestContext.PlaceComponentResult, DeviceInfo.BuiltInFictitiousFunctionClassFactory());
                    if (!DeviceInfo.getAuthRequestContext(authRequestContext2.PlaceComponentResult)) {
                        jSONObject5.put(Defines.Jsonkey.HardwareID.getKey(), authRequestContext2.PlaceComponentResult);
                        jSONObject5.put(Defines.Jsonkey.IsHardwareIDReal.getKey(), authRequestContext2.getAuthRequestContext());
                    }
                    String moveToNextValue = SystemObserver.moveToNextValue();
                    if (!DeviceInfo.getAuthRequestContext(moveToNextValue)) {
                        jSONObject5.put(Defines.Jsonkey.Brand.getKey(), moveToNextValue);
                    }
                    String lookAheadTest = SystemObserver.lookAheadTest();
                    if (!DeviceInfo.getAuthRequestContext(lookAheadTest)) {
                        jSONObject5.put(Defines.Jsonkey.Model.getKey(), lookAheadTest);
                    }
                    DisplayMetrics errorConfigVersion = SystemObserver.getErrorConfigVersion(authRequestContext.PlaceComponentResult);
                    jSONObject5.put(Defines.Jsonkey.ScreenDpi.getKey(), errorConfigVersion.densityDpi);
                    jSONObject5.put(Defines.Jsonkey.ScreenHeight.getKey(), errorConfigVersion.heightPixels);
                    jSONObject5.put(Defines.Jsonkey.ScreenWidth.getKey(), errorConfigVersion.widthPixels);
                    jSONObject5.put(Defines.Jsonkey.WiFi.getKey(), SystemObserver.lookAheadTest(authRequestContext.PlaceComponentResult));
                    jSONObject5.put(Defines.Jsonkey.UIMode.getKey(), SystemObserver.NetworkUserEntityData$$ExternalSyntheticLambda0(authRequestContext.PlaceComponentResult));
                    String BuiltInFictitiousFunctionClassFactory = SystemObserver.BuiltInFictitiousFunctionClassFactory();
                    if (!DeviceInfo.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory)) {
                        jSONObject5.put(Defines.Jsonkey.OS.getKey(), BuiltInFictitiousFunctionClassFactory);
                    }
                    jSONObject5.put(Defines.Jsonkey.OSVersion.getKey(), SystemObserver.PlaceComponentResult());
                    String authRequestContext3 = SystemObserver.getAuthRequestContext();
                    if (!TextUtils.isEmpty(authRequestContext3)) {
                        jSONObject5.put(Defines.Jsonkey.Country.getKey(), authRequestContext3);
                    }
                    String MyBillsEntityDataFactory = SystemObserver.MyBillsEntityDataFactory();
                    if (!TextUtils.isEmpty(MyBillsEntityDataFactory)) {
                        jSONObject5.put(Defines.Jsonkey.Language.getKey(), MyBillsEntityDataFactory);
                    }
                    String KClassImpl$Data$declaredNonStaticMembers$2 = SystemObserver.KClassImpl$Data$declaredNonStaticMembers$2();
                    if (!TextUtils.isEmpty(KClassImpl$Data$declaredNonStaticMembers$2)) {
                        jSONObject5.put(Defines.Jsonkey.LocalIP.getKey(), KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                    if (PrefHelper.BuiltInFictitiousFunctionClassFactory(authRequestContext.PlaceComponentResult).getErrorConfigVersion()) {
                        String PlaceComponentResult = SystemObserver.PlaceComponentResult(authRequestContext.PlaceComponentResult);
                        if (DeviceInfo.getAuthRequestContext(PlaceComponentResult)) {
                            return;
                        }
                        jSONObject5.put(Defines.ModuleNameKeys.imei.getKey(), PlaceComponentResult);
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException | Exception unused2) {
        }
    }

    public final JSONObject BuiltInFictitiousFunctionClassFactory(ConcurrentHashMap<String, String> concurrentHashMap) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.PlaceComponentResult != null) {
                JSONObject jSONObject2 = new JSONObject(this.PlaceComponentResult.toString());
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject.put(next, jSONObject2.get(next));
                }
            }
            if (concurrentHashMap.size() > 0) {
                JSONObject jSONObject3 = new JSONObject();
                for (String str : concurrentHashMap.keySet()) {
                    jSONObject3.put(str, concurrentHashMap.get(str));
                    concurrentHashMap.remove(str);
                }
                jSONObject.put(Defines.Jsonkey.Branch_Instrumentation.getKey(), jSONObject3);
                return jSONObject;
            }
            return jSONObject;
        } catch (ConcurrentModificationException unused) {
            return this.PlaceComponentResult;
        } catch (JSONException unused2) {
            return jSONObject;
        }
    }

    public final JSONObject NetworkUserEntityData$$ExternalSyntheticLambda2() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("REQ_POST", this.PlaceComponentResult);
            jSONObject.put("REQ_POST_PATH", this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|2|3|(6:5|6|7|(2:9|(1:55)(2:13|(2:15|16)(2:18|(2:20|21)(2:22|(2:24|25)(2:26|(2:28|29)(2:30|(2:32|33)(2:34|(2:36|37)(2:38|(2:40|41)(2:42|(2:44|45)(2:46|(2:48|49)(2:50|(2:52|53)(1:54))))))))))))|58|(2:11|55)(1:56))|61|6|7|(0)|58|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[Catch: JSONException -> 0x001c, TRY_LEAVE, TryCatch #0 {JSONException -> 0x001c, blocks: (B:8:0x0011, B:10:0x0017), top: B:49:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static io.branch.referral.ServerRequest BuiltInFictitiousFunctionClassFactory(org.json.JSONObject r4, android.content.Context r5) {
        /*
            java.lang.String r0 = "REQ_POST_PATH"
            java.lang.String r1 = "REQ_POST"
            r2 = 0
            boolean r3 = r4.has(r1)     // Catch: org.json.JSONException -> L10
            if (r3 == 0) goto L10
            org.json.JSONObject r1 = r4.getJSONObject(r1)     // Catch: org.json.JSONException -> L10
            goto L11
        L10:
            r1 = r2
        L11:
            boolean r3 = r4.has(r0)     // Catch: org.json.JSONException -> L1c
            if (r3 == 0) goto L1c
            java.lang.String r4 = r4.getString(r0)     // Catch: org.json.JSONException -> L1c
            goto L1e
        L1c:
            java.lang.String r4 = ""
        L1e:
            if (r4 == 0) goto Ldc
            int r0 = r4.length()
            if (r0 <= 0) goto Ldc
            io.branch.referral.Defines$RequestPath r0 = io.branch.referral.Defines.RequestPath.CompletedAction
            java.lang.String r0 = r0.getPath()
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 == 0) goto L39
            io.branch.referral.ServerRequestActionCompleted r2 = new io.branch.referral.ServerRequestActionCompleted
            r2.<init>(r4, r1, r5)
            goto Ldc
        L39:
            io.branch.referral.Defines$RequestPath r0 = io.branch.referral.Defines.RequestPath.GetURL
            java.lang.String r0 = r0.getPath()
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 == 0) goto L4c
            io.branch.referral.ServerRequestCreateUrl r2 = new io.branch.referral.ServerRequestCreateUrl
            r2.<init>(r4, r1, r5)
            goto Ldc
        L4c:
            io.branch.referral.Defines$RequestPath r0 = io.branch.referral.Defines.RequestPath.GetCreditHistory
            java.lang.String r0 = r0.getPath()
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 == 0) goto L5f
            io.branch.referral.ServerRequestGetRewardHistory r2 = new io.branch.referral.ServerRequestGetRewardHistory
            r2.<init>(r4, r1, r5)
            goto Ldc
        L5f:
            io.branch.referral.Defines$RequestPath r0 = io.branch.referral.Defines.RequestPath.GetCredits
            java.lang.String r0 = r0.getPath()
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 == 0) goto L71
            io.branch.referral.ServerRequestGetRewards r2 = new io.branch.referral.ServerRequestGetRewards
            r2.<init>(r4, r1, r5)
            goto Ldc
        L71:
            io.branch.referral.Defines$RequestPath r0 = io.branch.referral.Defines.RequestPath.IdentifyUser
            java.lang.String r0 = r0.getPath()
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 == 0) goto L83
            io.branch.referral.ServerRequestIdentifyUserRequest r2 = new io.branch.referral.ServerRequestIdentifyUserRequest
            r2.<init>(r4, r1, r5)
            goto Ldc
        L83:
            io.branch.referral.Defines$RequestPath r0 = io.branch.referral.Defines.RequestPath.Logout
            java.lang.String r0 = r0.getPath()
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 == 0) goto L95
            io.branch.referral.ServerRequestLogout r2 = new io.branch.referral.ServerRequestLogout
            r2.<init>(r4, r1, r5)
            goto Ldc
        L95:
            io.branch.referral.Defines$RequestPath r0 = io.branch.referral.Defines.RequestPath.RedeemRewards
            java.lang.String r0 = r0.getPath()
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 == 0) goto La7
            io.branch.referral.ServerRequestRedeemRewards r2 = new io.branch.referral.ServerRequestRedeemRewards
            r2.<init>(r4, r1, r5)
            goto Ldc
        La7:
            io.branch.referral.Defines$RequestPath r0 = io.branch.referral.Defines.RequestPath.RegisterClose
            java.lang.String r0 = r0.getPath()
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 == 0) goto Lb9
            io.branch.referral.ServerRequestRegisterClose r2 = new io.branch.referral.ServerRequestRegisterClose
            r2.<init>(r4, r1, r5)
            goto Ldc
        Lb9:
            io.branch.referral.Defines$RequestPath r0 = io.branch.referral.Defines.RequestPath.RegisterInstall
            java.lang.String r0 = r0.getPath()
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 == 0) goto Lcb
            io.branch.referral.ServerRequestRegisterInstall r2 = new io.branch.referral.ServerRequestRegisterInstall
            r2.<init>(r4, r1, r5)
            goto Ldc
        Lcb:
            io.branch.referral.Defines$RequestPath r0 = io.branch.referral.Defines.RequestPath.RegisterOpen
            java.lang.String r0 = r0.getPath()
            boolean r0 = r4.equalsIgnoreCase(r0)
            if (r0 == 0) goto Ldc
            io.branch.referral.ServerRequestRegisterOpen r2 = new io.branch.referral.ServerRequestRegisterOpen
            r2.<init>(r4, r1, r5)
        Ldc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequest.BuiltInFictitiousFunctionClassFactory(org.json.JSONObject, android.content.Context):io.branch.referral.ServerRequest");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        JSONObject optJSONObject;
        if (PlaceComponentResult() != BRANCH_API_VERSION.V2 || (optJSONObject = this.PlaceComponentResult.optJSONObject(Defines.Jsonkey.UserData.getKey())) == null) {
            return;
        }
        try {
            optJSONObject.put(Defines.Jsonkey.DeveloperIdentity.getKey(), PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_identity", "bnc_no_value"));
            optJSONObject.put(Defines.Jsonkey.DeviceFingerprintID.getKey(), PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_device_fingerprint_id", "bnc_no_value"));
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean PlaceComponentResult(Context context) {
        int checkCallingOrSelfPermission = context.checkCallingOrSelfPermission("android.permission.INTERNET");
        if (!(checkCallingOrSelfPermission == 0)) {
            PrefHelper.MyBillsEntityDataFactory("Trouble executing your request. Please add 'android.permission.INTERNET' in your applications manifest file");
        }
        return checkCallingOrSelfPermission == 0;
    }

    public final boolean getErrorConfigVersion() {
        return this.getAuthRequestContext.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(JSONObject jSONObject) {
        try {
            String key = (DeviceInfo.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2() ? Defines.Jsonkey.NativeApp : Defines.Jsonkey.InstantApp).getKey();
            if (PlaceComponentResult() == BRANCH_API_VERSION.V2) {
                JSONObject optJSONObject = jSONObject.optJSONObject(Defines.Jsonkey.UserData.getKey());
                if (optJSONObject != null) {
                    optJSONObject.put(Defines.Jsonkey.Environment.getKey(), key);
                    return;
                }
                return;
            }
            jSONObject.put(Defines.Jsonkey.Environment.getKey(), key);
        } catch (Exception unused) {
        }
    }

    public BRANCH_API_VERSION PlaceComponentResult() {
        return BRANCH_API_VERSION.V1;
    }

    public final void DatabaseTableConfigUtil() {
        StringBuilder sb = new StringBuilder();
        sb.append("Requested operation cannot be completed since tracking is disabled [");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append("]");
        PrefHelper.MyBillsEntityDataFactory(sb.toString());
        PlaceComponentResult(-117, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext() {
        boolean moveToNextValue;
        try {
            JSONObject jSONObject = new JSONObject();
            Iterator<String> keys = this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl.get(next));
            }
            JSONObject optJSONObject = this.PlaceComponentResult.optJSONObject(Defines.Jsonkey.Metadata.getKey());
            if (optJSONObject != null) {
                Iterator<String> keys2 = optJSONObject.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    jSONObject.put(next2, optJSONObject.get(next2));
                }
            }
            if ((this instanceof ServerRequestRegisterInstall) && this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.length() > 0) {
                Iterator<String> keys3 = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.keys();
                while (keys3.hasNext()) {
                    String next3 = keys3.next();
                    this.PlaceComponentResult.putOpt(next3, this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.get(next3));
                }
            }
            this.PlaceComponentResult.put(Defines.Jsonkey.Metadata.getKey(), jSONObject);
        } catch (JSONException unused) {
            PrefHelper.MyBillsEntityDataFactory("Could not merge metadata, ignoring user metadata.");
        }
        if (GetContactSyncConfig()) {
            JSONObject optJSONObject2 = PlaceComponentResult() == BRANCH_API_VERSION.V1 ? this.PlaceComponentResult : this.PlaceComponentResult.optJSONObject(Defines.Jsonkey.UserData.getKey());
            if (optJSONObject2 == null || !(moveToNextValue = PrefHelper.moveToNextValue())) {
                return;
            }
            try {
                optJSONObject2.putOpt(Defines.Jsonkey.limitFacebookTracking.getKey(), Boolean.valueOf(moveToNextValue));
            } catch (JSONException unused2) {
            }
        }
    }
}
