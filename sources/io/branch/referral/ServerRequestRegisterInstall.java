package io.branch.referral;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ServerRequestRegisterInstall extends ServerRequestInitSession {
    Branch.BranchReferralInitListener getErrorConfigVersion;

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return false;
    }

    @Override // io.branch.referral.ServerRequestInitSession
    public final String initRecordTimeStamp() {
        return "install";
    }

    public ServerRequestRegisterInstall(Context context, Branch.BranchReferralInitListener branchReferralInitListener, String str) {
        super(context, Defines.RequestPath.RegisterInstall.getPath());
        this.getErrorConfigVersion = branchReferralInitListener;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!str.equals("bnc_no_value")) {
                jSONObject.put(Defines.Jsonkey.LinkClickID.getKey(), str);
            }
            MyBillsEntityDataFactory(jSONObject);
        } catch (JSONException unused) {
            this.MyBillsEntityDataFactory = true;
        }
    }

    public ServerRequestRegisterInstall(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    @Override // io.branch.referral.ServerRequestInitSession, io.branch.referral.ServerRequest
    public final void lookAheadTest() {
        long j;
        long j2;
        super.lookAheadTest();
        PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        j = PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getLong("bnc_referrer_click_ts", 0L);
        PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        j2 = PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getLong("bnc_install_begin_ts", 0L);
        if (j > 0) {
            try {
                this.PlaceComponentResult.put(Defines.Jsonkey.ClickedReferrerTimeStamp.getKey(), j);
            } catch (JSONException unused) {
                return;
            }
        }
        if (j2 > 0) {
            this.PlaceComponentResult.put(Defines.Jsonkey.InstallBeginTimeStamp.getKey(), j2);
        }
    }

    @Override // io.branch.referral.ServerRequestInitSession
    public final boolean PrepareContext() {
        return this.getErrorConfigVersion != null;
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
        JSONObject jSONObject8;
        super.getAuthRequestContext(serverResponse, branch);
        try {
            PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Object obj = serverResponse.PlaceComponentResult;
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
            } else {
                jSONObject = new JSONObject();
            }
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_user_url", jSONObject.getString(Defines.Jsonkey.Link.getKey()));
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            Object obj2 = serverResponse.PlaceComponentResult;
            if (obj2 instanceof JSONObject) {
                jSONObject2 = (JSONObject) obj2;
            } else {
                jSONObject2 = new JSONObject();
            }
            if (jSONObject2.has(Defines.Jsonkey.Data.getKey())) {
                Object obj3 = serverResponse.PlaceComponentResult;
                if (obj3 instanceof JSONObject) {
                    jSONObject7 = (JSONObject) obj3;
                } else {
                    jSONObject7 = new JSONObject();
                }
                JSONObject jSONObject9 = new JSONObject(jSONObject7.getString(Defines.Jsonkey.Data.getKey()));
                if (jSONObject9.has(Defines.Jsonkey.Clicked_Branch_Link.getKey()) && jSONObject9.getBoolean(Defines.Jsonkey.Clicked_Branch_Link.getKey())) {
                    PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_install_params", "bnc_no_value").equals("bnc_no_value")) {
                        PrefHelper prefHelper3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getInt("bnc_is_referrable", 0) == 1) {
                            Object obj4 = serverResponse.PlaceComponentResult;
                            if (obj4 instanceof JSONObject) {
                                jSONObject8 = (JSONObject) obj4;
                            } else {
                                jSONObject8 = new JSONObject();
                            }
                            String string = jSONObject8.getString(Defines.Jsonkey.Data.getKey());
                            PrefHelper prefHelper4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_install_params", string);
                            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
                        }
                    }
                }
            }
            Object obj5 = serverResponse.PlaceComponentResult;
            if (obj5 instanceof JSONObject) {
                jSONObject3 = (JSONObject) obj5;
            } else {
                jSONObject3 = new JSONObject();
            }
            if (jSONObject3.has(Defines.Jsonkey.LinkClickID.getKey())) {
                PrefHelper prefHelper5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                Object obj6 = serverResponse.PlaceComponentResult;
                if (obj6 instanceof JSONObject) {
                    jSONObject6 = (JSONObject) obj6;
                } else {
                    jSONObject6 = new JSONObject();
                }
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_link_click_id", jSONObject6.getString(Defines.Jsonkey.LinkClickID.getKey()));
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            } else {
                PrefHelper prefHelper6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_link_click_id", "bnc_no_value");
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            }
            Object obj7 = serverResponse.PlaceComponentResult;
            if (obj7 instanceof JSONObject) {
                jSONObject4 = (JSONObject) obj7;
            } else {
                jSONObject4 = new JSONObject();
            }
            if (!jSONObject4.has(Defines.Jsonkey.Data.getKey())) {
                PrefHelper prefHelper7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_session_params", "bnc_no_value");
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            } else {
                Object obj8 = serverResponse.PlaceComponentResult;
                if (obj8 instanceof JSONObject) {
                    jSONObject5 = (JSONObject) obj8;
                } else {
                    jSONObject5 = new JSONObject();
                }
                String string2 = jSONObject5.getString(Defines.Jsonkey.Data.getKey());
                PrefHelper prefHelper8 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_session_params", string2);
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            }
            if (this.getErrorConfigVersion != null && !branch.lookAheadTest) {
                Branch.BranchReferralInitListener branchReferralInitListener = this.getErrorConfigVersion;
                PrefHelper prefHelper9 = branch.NetworkUserEntityData$$ExternalSyntheticLambda1;
                branchReferralInitListener.onInitFinished(branch.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_session_params"))), null);
            }
            PrefHelper prefHelper10 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_app_version", SystemObserver.MyBillsEntityDataFactory(DeviceInfo.getAuthRequestContext().PlaceComponentResult));
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
        } catch (Exception unused) {
        }
        PlaceComponentResult(serverResponse, branch);
    }

    @Override // io.branch.referral.ServerRequest
    public final void PlaceComponentResult(int i, String str) {
        if (this.getErrorConfigVersion != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TrackerKey.Property.ERROR_MESSAGE_FIREBASE, "Trouble reaching server. Please try again in a few minutes");
            } catch (JSONException unused) {
            }
            Branch.BranchReferralInitListener branchReferralInitListener = this.getErrorConfigVersion;
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
        Branch.BranchReferralInitListener branchReferralInitListener = this.getErrorConfigVersion;
        if (branchReferralInitListener != null) {
            branchReferralInitListener.onInitFinished(null, new BranchError("Trouble initializing Branch.", -102));
            return true;
        }
        return true;
    }

    @Override // io.branch.referral.ServerRequest
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getErrorConfigVersion = null;
    }
}
