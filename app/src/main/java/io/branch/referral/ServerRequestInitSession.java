package io.branch.referral;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import io.branch.indexing.ContentDiscoverer;
import io.branch.indexing.ContentDiscoveryManifest;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import io.branch.referral.validators.DeepLinkRoutingValidator;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class ServerRequestInitSession extends ServerRequest {
    private final ContentDiscoveryManifest getErrorConfigVersion;
    private final Context moveToNextValue;

    @Override // io.branch.referral.ServerRequest
    protected final boolean GetContactSyncConfig() {
        return true;
    }

    public abstract boolean PrepareContext();

    public abstract String initRecordTimeStamp();

    public ServerRequestInitSession(Context context, String str) {
        super(context, str);
        this.moveToNextValue = context;
        this.getErrorConfigVersion = ContentDiscoveryManifest.getAuthRequestContext(context);
    }

    public ServerRequestInitSession(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
        this.moveToNextValue = context;
        this.getErrorConfigVersion = ContentDiscoveryManifest.getAuthRequestContext(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0088, code lost:
    
        if ((r5 - r3) < 86400000) goto L37;
     */
    @Override // io.branch.referral.ServerRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void MyBillsEntityDataFactory(org.json.JSONObject r12) throws org.json.JSONException {
        /*
            r11 = this;
            super.MyBillsEntityDataFactory(r12)
            io.branch.referral.DeviceInfo r0 = io.branch.referral.DeviceInfo.getAuthRequestContext()
            android.content.Context r0 = r0.PlaceComponentResult
            java.lang.String r0 = io.branch.referral.SystemObserver.MyBillsEntityDataFactory(r0)
            boolean r1 = io.branch.referral.DeviceInfo.getAuthRequestContext(r0)
            if (r1 != 0) goto L1c
            io.branch.referral.Defines$Jsonkey r1 = io.branch.referral.Defines.Jsonkey.AppVersion
            java.lang.String r1 = r1.getKey()
            r12.put(r1, r0)
        L1c:
            io.branch.referral.Defines$Jsonkey r0 = io.branch.referral.Defines.Jsonkey.FaceBookAppLinkChecked
            java.lang.String r0 = r0.getKey()
            io.branch.referral.PrefHelper r1 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r1 = io.branch.referral.PrefHelper.scheduleImpl()
            r12.put(r0, r1)
            io.branch.referral.Defines$Jsonkey r0 = io.branch.referral.Defines.Jsonkey.IsReferrable
            java.lang.String r0 = r0.getKey()
            io.branch.referral.PrefHelper r1 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            io.branch.referral.PrefHelper r1 = io.branch.referral.PrefHelper.MyBillsEntityDataFactory
            android.content.SharedPreferences r1 = r1.KClassImpl$Data$declaredNonStaticMembers$2
            r2 = 0
            java.lang.String r3 = "bnc_is_referrable"
            int r1 = r1.getInt(r3, r2)
            r12.put(r0, r1)
            io.branch.referral.Defines$Jsonkey r0 = io.branch.referral.Defines.Jsonkey.Debug
            java.lang.String r0 = r0.getKey()
            boolean r1 = io.branch.referral.BranchUtil.getAuthRequestContext()
            r12.put(r0, r1)
            io.branch.referral.DeviceInfo r0 = io.branch.referral.DeviceInfo.getAuthRequestContext()
            android.content.Context r0 = r0.PlaceComponentResult
            java.lang.String r0 = io.branch.referral.SystemObserver.MyBillsEntityDataFactory(r0)
            io.branch.referral.DeviceInfo r1 = io.branch.referral.DeviceInfo.getAuthRequestContext()
            android.content.Context r1 = r1.PlaceComponentResult
            long r3 = io.branch.referral.SystemObserver.KClassImpl$Data$declaredNonStaticMembers$2(r1)
            io.branch.referral.DeviceInfo r1 = io.branch.referral.DeviceInfo.getAuthRequestContext()
            android.content.Context r1 = r1.PlaceComponentResult
            long r5 = io.branch.referral.SystemObserver.getAuthRequestContext(r1)
            io.branch.referral.PrefHelper r1 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            io.branch.referral.PrefHelper r1 = io.branch.referral.PrefHelper.MyBillsEntityDataFactory
            android.content.SharedPreferences r1 = r1.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r7 = "bnc_app_version"
            java.lang.String r8 = "bnc_no_value"
            java.lang.String r1 = r1.getString(r7, r8)
            boolean r1 = r8.equals(r1)
            r9 = 2
            if (r1 == 0) goto L8b
            long r0 = r5 - r3
            r7 = 86400000(0x5265c00, double:4.2687272E-316)
            int r10 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r10 >= 0) goto L9d
            goto L9e
        L8b:
            io.branch.referral.PrefHelper r1 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            io.branch.referral.PrefHelper r1 = io.branch.referral.PrefHelper.MyBillsEntityDataFactory
            android.content.SharedPreferences r1 = r1.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r1 = r1.getString(r7, r8)
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L9d
            r2 = 1
            goto L9e
        L9d:
            r2 = 2
        L9e:
            io.branch.referral.Defines$Jsonkey r0 = io.branch.referral.Defines.Jsonkey.Update
            java.lang.String r0 = r0.getKey()
            r12.put(r0, r2)
            io.branch.referral.Defines$Jsonkey r0 = io.branch.referral.Defines.Jsonkey.FirstInstallTime
            java.lang.String r0 = r0.getKey()
            r12.put(r0, r3)
            io.branch.referral.Defines$Jsonkey r0 = io.branch.referral.Defines.Jsonkey.LastUpdateTime
            java.lang.String r0 = r0.getKey()
            r12.put(r0, r5)
            io.branch.referral.PrefHelper r0 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r0 = "bnc_original_install_time"
            long r1 = io.branch.referral.PrefHelper.NetworkUserEntityData$$ExternalSyntheticLambda0(r0)
            r7 = 0
            int r9 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r9 != 0) goto Lcd
            io.branch.referral.PrefHelper r1 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            io.branch.referral.PrefHelper.BuiltInFictitiousFunctionClassFactory(r0, r3)
            goto Lce
        Lcd:
            r3 = r1
        Lce:
            io.branch.referral.Defines$Jsonkey r0 = io.branch.referral.Defines.Jsonkey.OriginalInstallTime
            java.lang.String r0 = r0.getKey()
            r12.put(r0, r3)
            io.branch.referral.PrefHelper r0 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r0 = "bnc_last_known_update_time"
            long r1 = io.branch.referral.PrefHelper.NetworkUserEntityData$$ExternalSyntheticLambda0(r0)
            java.lang.String r3 = "bnc_previous_update_time"
            int r4 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r4 >= 0) goto Lef
            io.branch.referral.PrefHelper r4 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            io.branch.referral.PrefHelper.BuiltInFictitiousFunctionClassFactory(r3, r1)
            io.branch.referral.PrefHelper r1 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            io.branch.referral.PrefHelper.BuiltInFictitiousFunctionClassFactory(r0, r5)
        Lef:
            io.branch.referral.Defines$Jsonkey r0 = io.branch.referral.Defines.Jsonkey.PreviousUpdateTime
            java.lang.String r0 = r0.getKey()
            io.branch.referral.PrefHelper r1 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            long r1 = io.branch.referral.PrefHelper.NetworkUserEntityData$$ExternalSyntheticLambda0(r3)
            r12.put(r0, r1)
            r11.getAuthRequestContext(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestInitSession.MyBillsEntityDataFactory(org.json.JSONObject):void");
    }

    public static boolean MyBillsEntityDataFactory(String str) {
        if (str != null) {
            return str.equalsIgnoreCase("open") || str.equalsIgnoreCase("install");
        }
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    public void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
        long j;
        long j2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        try {
            PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_link_click_identifier", "bnc_no_value");
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_google_search_install_identifier", "bnc_no_value");
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            PrefHelper prefHelper3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_google_play_install_referrer_extras", "bnc_no_value");
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            PrefHelper prefHelper4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_external_intent_uri", "bnc_no_value");
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            PrefHelper prefHelper5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_external_intent_extra", "bnc_no_value");
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            PrefHelper prefHelper6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_app_link", "bnc_no_value");
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            PrefHelper prefHelper7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_push_identifier", "bnc_no_value");
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            PrefHelper prefHelper8 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.MyBillsEntityDataFactory(Boolean.FALSE);
            PrefHelper prefHelper9 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.getAuthRequestContext("bnc_install_referrer", "bnc_no_value");
            PrefHelper prefHelper10 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.lookAheadTest();
            Object obj = serverResponse.PlaceComponentResult;
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
            } else {
                jSONObject = new JSONObject();
            }
            if (jSONObject != null) {
                Object obj2 = serverResponse.PlaceComponentResult;
                if (obj2 instanceof JSONObject) {
                    jSONObject2 = (JSONObject) obj2;
                } else {
                    jSONObject2 = new JSONObject();
                }
                if (jSONObject2.has(Defines.Jsonkey.Data.getKey())) {
                    Object obj3 = serverResponse.PlaceComponentResult;
                    if (obj3 instanceof JSONObject) {
                        jSONObject3 = (JSONObject) obj3;
                    } else {
                        jSONObject3 = new JSONObject();
                    }
                    JSONObject jSONObject4 = new JSONObject(jSONObject3.getString(Defines.Jsonkey.Data.getKey()));
                    if (jSONObject4.optBoolean(Defines.Jsonkey.Clicked_Branch_Link.getKey())) {
                        String str = this instanceof ServerRequestRegisterInstall ? "Branch Install" : "Branch Open";
                        ExtendedAnswerProvider extendedAnswerProvider = new ExtendedAnswerProvider();
                        PrefHelper prefHelper11 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                        extendedAnswerProvider.PlaceComponentResult(str, jSONObject4, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_identity_id", "bnc_no_value"));
                    }
                }
            }
        } catch (JSONException unused) {
        }
        PrefHelper prefHelper12 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        j = PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getLong("bnc_previous_update_time", 0L);
        if (j == 0) {
            PrefHelper prefHelper13 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper prefHelper14 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            j2 = PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getLong("bnc_last_known_update_time", 0L);
            PrefHelper.BuiltInFictitiousFunctionClassFactory("bnc_previous_update_time", j2);
        }
    }

    public final void PlaceComponentResult(ServerResponse serverResponse, Branch branch) {
        JSONObject jSONObject;
        int i;
        ContentDiscoveryManifest contentDiscoveryManifest = this.getErrorConfigVersion;
        if (contentDiscoveryManifest != null) {
            Object obj = serverResponse.PlaceComponentResult;
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
            } else {
                jSONObject = new JSONObject();
            }
            if (jSONObject.has(RVParams.CAN_DESTROY)) {
                contentDiscoveryManifest.BuiltInFictitiousFunctionClassFactory = true;
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(RVParams.CAN_DESTROY);
                    if (jSONObject2.has("mv")) {
                        contentDiscoveryManifest.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject2.getString("mv");
                    }
                    if (jSONObject2.has("mhl")) {
                        contentDiscoveryManifest.getErrorConfigVersion = jSONObject2.getInt("mhl");
                    }
                    if (jSONObject2.has("m")) {
                        contentDiscoveryManifest.PlaceComponentResult = jSONObject2.getJSONArray("m");
                    }
                    if (jSONObject2.has("mtl") && (i = jSONObject2.getInt("mtl")) > 0) {
                        contentDiscoveryManifest.scheduleImpl = i;
                    }
                    if (jSONObject2.has("mps")) {
                        contentDiscoveryManifest.MyBillsEntityDataFactory = jSONObject2.getInt("mps");
                    }
                    contentDiscoveryManifest.getAuthRequestContext.put("mv", contentDiscoveryManifest.KClassImpl$Data$declaredNonStaticMembers$2);
                    contentDiscoveryManifest.getAuthRequestContext.put("m", contentDiscoveryManifest.PlaceComponentResult);
                    contentDiscoveryManifest.lookAheadTest.edit().putString("BNC_CD_MANIFEST", contentDiscoveryManifest.getAuthRequestContext.toString()).apply();
                } catch (JSONException unused) {
                }
            } else {
                contentDiscoveryManifest.BuiltInFictitiousFunctionClassFactory = false;
            }
            if (branch.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                try {
                    ContentDiscoverer MyBillsEntityDataFactory = ContentDiscoverer.MyBillsEntityDataFactory();
                    Activity activity = branch.KClassImpl$Data$declaredNonStaticMembers$2.get();
                    PrefHelper prefHelper = branch.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    String lookAheadTest = PrefHelper.lookAheadTest("bnc_external_intent_uri");
                    if (lookAheadTest.equals("bnc_no_value")) {
                        lookAheadTest = null;
                    }
                    MyBillsEntityDataFactory.PlaceComponentResult = new ArrayList<>();
                    MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(activity, lookAheadTest);
                } catch (Exception unused2) {
                }
            }
        }
        DeepLinkRoutingValidator.KClassImpl$Data$declaredNonStaticMembers$2(branch.KClassImpl$Data$declaredNonStaticMembers$2);
        UniversalResourceAnalyser.KClassImpl$Data$declaredNonStaticMembers$2(branch.PlaceComponentResult);
        UniversalResourceAnalyser.getAuthRequestContext(branch.PlaceComponentResult);
    }

    public final void isLayoutRequested() {
        boolean authRequestContext;
        PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        String string = PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_link_click_identifier", "bnc_no_value");
        if (!string.equals("bnc_no_value")) {
            try {
                this.PlaceComponentResult.put(Defines.Jsonkey.LinkIdentifier.getKey(), string);
                JSONObject jSONObject = this.PlaceComponentResult;
                String key = Defines.Jsonkey.FaceBookAppLinkChecked.getKey();
                PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                jSONObject.put(key, PrefHelper.scheduleImpl());
            } catch (JSONException unused) {
            }
        }
        PrefHelper prefHelper3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        String lookAheadTest = PrefHelper.lookAheadTest("bnc_google_search_install_identifier");
        if (!lookAheadTest.equals("bnc_no_value")) {
            try {
                this.PlaceComponentResult.put(Defines.Jsonkey.GoogleSearchInstallReferrer.getKey(), lookAheadTest);
            } catch (JSONException unused2) {
            }
        }
        PrefHelper prefHelper4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        String lookAheadTest2 = PrefHelper.lookAheadTest("bnc_google_play_install_referrer_extras");
        if (!lookAheadTest2.equals("bnc_no_value")) {
            try {
                this.PlaceComponentResult.put(Defines.Jsonkey.GooglePlayInstallReferrer.getKey(), lookAheadTest2);
            } catch (JSONException unused3) {
            }
        }
        PrefHelper prefHelper5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        authRequestContext = PrefHelper.getAuthRequestContext("bnc_is_full_app_conversion");
        if (authRequestContext) {
            try {
                JSONObject jSONObject2 = this.PlaceComponentResult;
                String key2 = Defines.Jsonkey.AndroidAppLinkURL.getKey();
                PrefHelper prefHelper6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                jSONObject2.put(key2, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_app_link", "bnc_no_value"));
                this.PlaceComponentResult.put(Defines.Jsonkey.IsFullAppConv.getKey(), true);
            } catch (JSONException unused4) {
            }
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(ServerResponse serverResponse) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        if (serverResponse != null) {
            Object obj = serverResponse.PlaceComponentResult;
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
            } else {
                jSONObject = new JSONObject();
            }
            if (jSONObject != null) {
                Object obj2 = serverResponse.PlaceComponentResult;
                if (obj2 instanceof JSONObject) {
                    jSONObject2 = (JSONObject) obj2;
                } else {
                    jSONObject2 = new JSONObject();
                }
                if (jSONObject2.has(Defines.Jsonkey.BranchViewData.getKey())) {
                    try {
                        Object obj3 = serverResponse.PlaceComponentResult;
                        if (obj3 instanceof JSONObject) {
                            jSONObject3 = (JSONObject) obj3;
                        } else {
                            jSONObject3 = new JSONObject();
                        }
                        JSONObject jSONObject4 = jSONObject3.getJSONObject(Defines.Jsonkey.BranchViewData.getKey());
                        String initRecordTimeStamp = initRecordTimeStamp();
                        if (Branch.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2 != null && Branch.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2.get() != null) {
                            Activity activity = Branch.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2.get();
                            if (activity instanceof Branch.IBranchViewControl ? true ^ ((Branch.IBranchViewControl) activity).getAuthRequestContext() : true) {
                                return BranchViewHandler.getAuthRequestContext().PlaceComponentResult(jSONObject4, initRecordTimeStamp, activity, Branch.BuiltInFictitiousFunctionClassFactory());
                            }
                            return BranchViewHandler.getAuthRequestContext().MyBillsEntityDataFactory(jSONObject4, initRecordTimeStamp);
                        }
                        return BranchViewHandler.getAuthRequestContext().MyBillsEntityDataFactory(jSONObject4, initRecordTimeStamp);
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    public void lookAheadTest() {
        JSONObject jSONObject = this.PlaceComponentResult;
        try {
            PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (!PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_app_link", "bnc_no_value").equals("bnc_no_value")) {
                String key = Defines.Jsonkey.AndroidAppLinkURL.getKey();
                PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                jSONObject.put(key, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_app_link", "bnc_no_value"));
            }
            PrefHelper prefHelper3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (!PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_push_identifier", "bnc_no_value").equals("bnc_no_value")) {
                String key2 = Defines.Jsonkey.AndroidPushIdentifier.getKey();
                PrefHelper prefHelper4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                jSONObject.put(key2, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_push_identifier", "bnc_no_value"));
            }
            PrefHelper prefHelper5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (!PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_external_intent_uri", "bnc_no_value").equals("bnc_no_value")) {
                String key3 = Defines.Jsonkey.External_Intent_URI.getKey();
                PrefHelper prefHelper6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                jSONObject.put(key3, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_external_intent_uri", "bnc_no_value"));
            }
            PrefHelper prefHelper7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (!PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_external_intent_extra", "bnc_no_value").equals("bnc_no_value")) {
                String key4 = Defines.Jsonkey.External_Intent_Extra.getKey();
                PrefHelper prefHelper8 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                jSONObject.put(key4, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_external_intent_extra", "bnc_no_value"));
            }
            if (this.getErrorConfigVersion != null) {
                JSONObject jSONObject2 = new JSONObject();
                ContentDiscoveryManifest contentDiscoveryManifest = this.getErrorConfigVersion;
                jSONObject2.put("mv", TextUtils.isEmpty(contentDiscoveryManifest.KClassImpl$Data$declaredNonStaticMembers$2) ? "-1" : contentDiscoveryManifest.KClassImpl$Data$declaredNonStaticMembers$2);
                jSONObject2.put("pn", this.moveToNextValue.getPackageName());
                jSONObject.put(RVParams.CAN_DESTROY, jSONObject2);
            }
        } catch (JSONException unused) {
        }
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean moveToNextValue() {
        JSONObject jSONObject = this.PlaceComponentResult;
        if (jSONObject.has(Defines.Jsonkey.AndroidAppLinkURL.getKey()) || jSONObject.has(Defines.Jsonkey.AndroidPushIdentifier.getKey()) || jSONObject.has(Defines.Jsonkey.LinkIdentifier.getKey())) {
            jSONObject.remove(Defines.Jsonkey.DeviceFingerprintID.getKey());
            jSONObject.remove(Defines.Jsonkey.IdentityID.getKey());
            jSONObject.remove(Defines.Jsonkey.FaceBookAppLinkChecked.getKey());
            jSONObject.remove(Defines.Jsonkey.External_Intent_Extra.getKey());
            jSONObject.remove(Defines.Jsonkey.External_Intent_URI.getKey());
            jSONObject.remove(Defines.Jsonkey.FirstInstallTime.getKey());
            jSONObject.remove(Defines.Jsonkey.LastUpdateTime.getKey());
            jSONObject.remove(Defines.Jsonkey.OriginalInstallTime.getKey());
            jSONObject.remove(Defines.Jsonkey.PreviousUpdateTime.getKey());
            jSONObject.remove(Defines.Jsonkey.InstallBeginTimeStamp.getKey());
            jSONObject.remove(Defines.Jsonkey.ClickedReferrerTimeStamp.getKey());
            jSONObject.remove(Defines.Jsonkey.HardwareID.getKey());
            jSONObject.remove(Defines.Jsonkey.IsHardwareIDReal.getKey());
            jSONObject.remove(Defines.Jsonkey.LocalIP.getKey());
            try {
                jSONObject.put(Defines.Jsonkey.TrackingDisabled.getKey(), true);
            } catch (JSONException unused) {
            }
            return true;
        }
        return super.moveToNextValue();
    }
}
