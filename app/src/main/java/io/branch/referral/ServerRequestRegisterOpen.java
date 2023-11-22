package io.branch.referral;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.sendmoney.summary.SummaryActivity;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ServerRequestRegisterOpen extends ServerRequestInitSession {
    Branch.BranchReferralInitListener scheduleImpl;

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return false;
    }

    @Override // io.branch.referral.ServerRequestInitSession
    public final String initRecordTimeStamp() {
        return "open";
    }

    public ServerRequestRegisterOpen(Context context, Branch.BranchReferralInitListener branchReferralInitListener) {
        super(context, Defines.RequestPath.RegisterOpen.getPath());
        this.scheduleImpl = branchReferralInitListener;
        JSONObject jSONObject = new JSONObject();
        try {
            String key = Defines.Jsonkey.DeviceFingerprintID.getKey();
            PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
            jSONObject.put(key, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_device_fingerprint_id", "bnc_no_value"));
            String key2 = Defines.Jsonkey.IdentityID.getKey();
            PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            jSONObject.put(key2, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_identity_id", "bnc_no_value"));
            MyBillsEntityDataFactory(jSONObject);
        } catch (JSONException unused) {
            this.MyBillsEntityDataFactory = true;
        }
    }

    public ServerRequestRegisterOpen(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    @Override // io.branch.referral.ServerRequestInitSession, io.branch.referral.ServerRequest
    public final void lookAheadTest() {
        super.lookAheadTest();
        if (Branch.BuiltInFictitiousFunctionClassFactory().NetworkUserEntityData$$ExternalSyntheticLambda0) {
            Branch.BranchReferralInitListener branchReferralInitListener = this.scheduleImpl;
            Branch BuiltInFictitiousFunctionClassFactory = Branch.BuiltInFictitiousFunctionClassFactory();
            PrefHelper prefHelper = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
            branchReferralInitListener.onInitFinished(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params"))), null);
            Branch BuiltInFictitiousFunctionClassFactory2 = Branch.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory2.getErrorConfigVersion.put(Defines.Jsonkey.InstantDeepLinkSession.getKey(), SummaryActivity.CHECKED);
            Branch.BuiltInFictitiousFunctionClassFactory().NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            Branch.BuiltInFictitiousFunctionClassFactory().lookAheadTest = true;
        }
    }

    @Override // io.branch.referral.ServerRequestInitSession, io.branch.referral.ServerRequest
    public final void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        JSONObject jSONObject7;
        super.getAuthRequestContext(serverResponse, branch);
        try {
            Object obj = serverResponse.PlaceComponentResult;
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
            } else {
                jSONObject = new JSONObject();
            }
            if (jSONObject.has(Defines.Jsonkey.LinkClickID.getKey())) {
                PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
                Object obj2 = serverResponse.PlaceComponentResult;
                if (obj2 instanceof JSONObject) {
                    jSONObject7 = (JSONObject) obj2;
                } else {
                    jSONObject7 = new JSONObject();
                }
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_link_click_id", jSONObject7.getString(Defines.Jsonkey.LinkClickID.getKey()));
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            } else {
                PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_link_click_id", "bnc_no_value");
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            }
            Object obj3 = serverResponse.PlaceComponentResult;
            if (obj3 instanceof JSONObject) {
                jSONObject2 = (JSONObject) obj3;
            } else {
                jSONObject2 = new JSONObject();
            }
            if (jSONObject2.has(Defines.Jsonkey.Data.getKey())) {
                Object obj4 = serverResponse.PlaceComponentResult;
                if (obj4 instanceof JSONObject) {
                    jSONObject5 = (JSONObject) obj4;
                } else {
                    jSONObject5 = new JSONObject();
                }
                JSONObject jSONObject8 = new JSONObject(jSONObject5.getString(Defines.Jsonkey.Data.getKey()));
                if (jSONObject8.has(Defines.Jsonkey.Clicked_Branch_Link.getKey()) && jSONObject8.getBoolean(Defines.Jsonkey.Clicked_Branch_Link.getKey())) {
                    PrefHelper prefHelper3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_install_params", "bnc_no_value").equals("bnc_no_value")) {
                        PrefHelper prefHelper4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getInt("bnc_is_referrable", 0) == 1) {
                            Object obj5 = serverResponse.PlaceComponentResult;
                            if (obj5 instanceof JSONObject) {
                                jSONObject6 = (JSONObject) obj5;
                            } else {
                                jSONObject6 = new JSONObject();
                            }
                            String string = jSONObject6.getString(Defines.Jsonkey.Data.getKey());
                            PrefHelper prefHelper5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_install_params", string);
                            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
                        }
                    }
                }
            }
            Object obj6 = serverResponse.PlaceComponentResult;
            if (obj6 instanceof JSONObject) {
                jSONObject3 = (JSONObject) obj6;
            } else {
                jSONObject3 = new JSONObject();
            }
            if (!jSONObject3.has(Defines.Jsonkey.Data.getKey())) {
                PrefHelper prefHelper6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_session_params", "bnc_no_value");
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            } else {
                Object obj7 = serverResponse.PlaceComponentResult;
                if (obj7 instanceof JSONObject) {
                    jSONObject4 = (JSONObject) obj7;
                } else {
                    jSONObject4 = new JSONObject();
                }
                String string2 = jSONObject4.getString(Defines.Jsonkey.Data.getKey());
                PrefHelper prefHelper7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_session_params", string2);
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            }
            if (this.scheduleImpl != null && !branch.lookAheadTest) {
                Branch.BranchReferralInitListener branchReferralInitListener = this.scheduleImpl;
                PrefHelper prefHelper8 = branch.NetworkUserEntityData$$ExternalSyntheticLambda1;
                branchReferralInitListener.onInitFinished(branch.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params"))), null);
            }
            PrefHelper prefHelper9 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_app_version", SystemObserver.MyBillsEntityDataFactory(DeviceInfo.getAuthRequestContext().PlaceComponentResult));
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
        } catch (Exception unused) {
        }
        PlaceComponentResult(serverResponse, branch);
    }

    @Override // io.branch.referral.ServerRequest
    public final void PlaceComponentResult(int i, String str) {
        if (this.scheduleImpl != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TrackerKey.Property.ERROR_MESSAGE_FIREBASE, "Trouble reaching server. Please try again in a few minutes");
            } catch (JSONException unused) {
            }
            Branch.BranchReferralInitListener branchReferralInitListener = this.scheduleImpl;
            StringBuilder sb = new StringBuilder();
            sb.append("Trouble initializing Branch. ");
            sb.append(str);
            branchReferralInitListener.onInitFinished(jSONObject, new BranchError(sb.toString(), i));
        }
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean getAuthRequestContext(Context context) {
        if (ServerRequestInitSession.PlaceComponentResult(context)) {
            return false;
        }
        Branch.BranchReferralInitListener branchReferralInitListener = this.scheduleImpl;
        if (branchReferralInitListener != null) {
            branchReferralInitListener.onInitFinished(null, new BranchError("Trouble initializing Branch.", -102));
            return true;
        }
        return true;
    }

    @Override // io.branch.referral.ServerRequest
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.scheduleImpl = null;
    }

    @Override // io.branch.referral.ServerRequestInitSession
    public final boolean PrepareContext() {
        return this.scheduleImpl != null;
    }
}
