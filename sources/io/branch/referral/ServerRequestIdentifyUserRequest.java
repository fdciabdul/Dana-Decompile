package io.branch.referral;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ServerRequestIdentifyUserRequest extends ServerRequest {
    String getErrorConfigVersion;
    public Branch.BranchReferralInitListener scheduleImpl;

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return true;
    }

    public ServerRequestIdentifyUserRequest(Context context, Branch.BranchReferralInitListener branchReferralInitListener, String str) {
        super(context, Defines.RequestPath.IdentifyUser.getPath());
        this.scheduleImpl = branchReferralInitListener;
        this.getErrorConfigVersion = str;
        JSONObject jSONObject = new JSONObject();
        try {
            String key = Defines.Jsonkey.IdentityID.getKey();
            PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
            jSONObject.put(key, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_identity_id", "bnc_no_value"));
            String key2 = Defines.Jsonkey.DeviceFingerprintID.getKey();
            PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            jSONObject.put(key2, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_device_fingerprint_id", "bnc_no_value"));
            String key3 = Defines.Jsonkey.SessionID.getKey();
            PrefHelper prefHelper3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            jSONObject.put(key3, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_session_id", "bnc_no_value"));
            PrefHelper prefHelper4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (!PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_link_click_id", "bnc_no_value").equals("bnc_no_value")) {
                String key4 = Defines.Jsonkey.LinkClickID.getKey();
                PrefHelper prefHelper5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                jSONObject.put(key4, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_link_click_id", "bnc_no_value"));
            }
            jSONObject.put(Defines.Jsonkey.Identity.getKey(), str);
            MyBillsEntityDataFactory(jSONObject);
        } catch (JSONException unused) {
            this.MyBillsEntityDataFactory = true;
        }
    }

    public ServerRequestIdentifyUserRequest(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
        this.getErrorConfigVersion = null;
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
            sb.append("Trouble setting the user alias. ");
            sb.append(str);
            branchReferralInitListener.onInitFinished(jSONObject, new BranchError(sb.toString(), i));
        }
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean getAuthRequestContext(Context context) {
        if (!ServerRequest.PlaceComponentResult(context)) {
            Branch.BranchReferralInitListener branchReferralInitListener = this.scheduleImpl;
            if (branchReferralInitListener != null) {
                branchReferralInitListener.onInitFinished(null, new BranchError("Trouble setting the user alias.", -102));
            }
            return true;
        }
        try {
            String string = this.PlaceComponentResult.getString(Defines.Jsonkey.Identity.getKey());
            if (string != null && string.length() != 0) {
                PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (!string.equals(PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_identity", "bnc_no_value"))) {
                    return false;
                }
            }
        } catch (JSONException unused) {
        }
        return true;
    }

    @Override // io.branch.referral.ServerRequest
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.scheduleImpl = null;
    }

    public final boolean initRecordTimeStamp() {
        try {
            String string = this.PlaceComponentResult.getString(Defines.Jsonkey.Identity.getKey());
            if (string != null) {
                PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
                return string.equals(PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_identity", "bnc_no_value"));
            }
            return false;
        } catch (JSONException unused) {
            return false;
        }
    }

    @Override // io.branch.referral.ServerRequest
    public final void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        try {
            if (this.PlaceComponentResult != null && this.PlaceComponentResult.has(Defines.Jsonkey.Identity.getKey())) {
                PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_identity", this.PlaceComponentResult.getString(Defines.Jsonkey.Identity.getKey()));
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            }
            PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Object obj = serverResponse.PlaceComponentResult;
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
            } else {
                jSONObject = new JSONObject();
            }
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_identity_id", jSONObject.getString(Defines.Jsonkey.IdentityID.getKey()));
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            PrefHelper prefHelper3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Object obj2 = serverResponse.PlaceComponentResult;
            if (obj2 instanceof JSONObject) {
                jSONObject2 = (JSONObject) obj2;
            } else {
                jSONObject2 = new JSONObject();
            }
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_user_url", jSONObject2.getString(Defines.Jsonkey.Link.getKey()));
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            Object obj3 = serverResponse.PlaceComponentResult;
            if (obj3 instanceof JSONObject) {
                jSONObject3 = (JSONObject) obj3;
            } else {
                jSONObject3 = new JSONObject();
            }
            if (jSONObject3.has(Defines.Jsonkey.ReferringData.getKey())) {
                Object obj4 = serverResponse.PlaceComponentResult;
                if (obj4 instanceof JSONObject) {
                    jSONObject4 = (JSONObject) obj4;
                } else {
                    jSONObject4 = new JSONObject();
                }
                String string = jSONObject4.getString(Defines.Jsonkey.ReferringData.getKey());
                PrefHelper prefHelper4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_install_params", string);
                PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            }
            Branch.BranchReferralInitListener branchReferralInitListener = this.scheduleImpl;
            if (branchReferralInitListener != null) {
                PrefHelper prefHelper5 = branch.NetworkUserEntityData$$ExternalSyntheticLambda1;
                branchReferralInitListener.onInitFinished(branch.BuiltInFictitiousFunctionClassFactory(Branch.MyBillsEntityDataFactory(PrefHelper.lookAheadTest("bnc_install_params"))), null);
            }
        } catch (JSONException unused) {
        }
    }
}
