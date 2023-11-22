package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ServerRequestLogout extends ServerRequest {
    private Branch.LogoutStatusListener getErrorConfigVersion;

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.branch.referral.ServerRequest
    public final boolean scheduleImpl() {
        return false;
    }

    public ServerRequestLogout(Context context, Branch.LogoutStatusListener logoutStatusListener) {
        super(context, Defines.RequestPath.Logout.getPath());
        this.getErrorConfigVersion = logoutStatusListener;
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
            MyBillsEntityDataFactory(jSONObject);
        } catch (JSONException unused) {
            this.MyBillsEntityDataFactory = true;
        }
    }

    public ServerRequestLogout(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    @Override // io.branch.referral.ServerRequest
    public final void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
        Branch.LogoutStatusListener logoutStatusListener;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        try {
            PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Object obj = serverResponse.PlaceComponentResult;
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
            } else {
                jSONObject = new JSONObject();
            }
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_session_id", jSONObject.getString(Defines.Jsonkey.SessionID.getKey()));
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Object obj2 = serverResponse.PlaceComponentResult;
            if (obj2 instanceof JSONObject) {
                jSONObject2 = (JSONObject) obj2;
            } else {
                jSONObject2 = new JSONObject();
            }
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_identity_id", jSONObject2.getString(Defines.Jsonkey.IdentityID.getKey()));
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            PrefHelper prefHelper3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Object obj3 = serverResponse.PlaceComponentResult;
            if (obj3 instanceof JSONObject) {
                jSONObject3 = (JSONObject) obj3;
            } else {
                jSONObject3 = new JSONObject();
            }
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_user_url", jSONObject3.getString(Defines.Jsonkey.Link.getKey()));
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            PrefHelper prefHelper4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_install_params", "bnc_no_value");
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            PrefHelper prefHelper5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_session_params", "bnc_no_value");
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            PrefHelper prefHelper6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_identity", "bnc_no_value");
            PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
            PrefHelper prefHelper7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Iterator<String> it = PrefHelper.MyBillsEntityDataFactory().iterator();
            while (it.hasNext()) {
                PrefHelper.getAuthRequestContext(it.next(), 0);
            }
            PrefHelper.PlaceComponentResult(new ArrayList());
            Iterator<String> it2 = PrefHelper.BuiltInFictitiousFunctionClassFactory().iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                ArrayList<String> BuiltInFictitiousFunctionClassFactory = PrefHelper.BuiltInFictitiousFunctionClassFactory();
                if (!BuiltInFictitiousFunctionClassFactory.contains(next)) {
                    BuiltInFictitiousFunctionClassFactory.add(next);
                    PrefHelper.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("bnc_total_base_");
                sb.append(next);
                PrefHelper.PlaceComponentResult(sb.toString(), 0);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("bnc_balance_base_");
                sb2.append(next);
                PrefHelper.PlaceComponentResult(sb2.toString(), 0);
            }
            PrefHelper.MyBillsEntityDataFactory(new ArrayList());
            logoutStatusListener = this.getErrorConfigVersion;
            if (logoutStatusListener == null) {
                return;
            }
        } catch (JSONException unused) {
            logoutStatusListener = this.getErrorConfigVersion;
            if (logoutStatusListener == null) {
                return;
            }
        } catch (Throwable th) {
            Branch.LogoutStatusListener logoutStatusListener2 = this.getErrorConfigVersion;
            if (logoutStatusListener2 != null) {
                logoutStatusListener2.onLogoutFinished(true, null);
            }
            throw th;
        }
        logoutStatusListener.onLogoutFinished(true, null);
    }

    @Override // io.branch.referral.ServerRequest
    public final void PlaceComponentResult(int i, String str) {
        Branch.LogoutStatusListener logoutStatusListener = this.getErrorConfigVersion;
        if (logoutStatusListener != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Logout error. ");
            sb.append(str);
            logoutStatusListener.onLogoutFinished(false, new BranchError(sb.toString(), i));
        }
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean getAuthRequestContext(Context context) {
        if (ServerRequest.PlaceComponentResult(context)) {
            return false;
        }
        Branch.LogoutStatusListener logoutStatusListener = this.getErrorConfigVersion;
        if (logoutStatusListener != null) {
            logoutStatusListener.onLogoutFinished(false, new BranchError("Logout failed", -102));
            return true;
        }
        return true;
    }

    @Override // io.branch.referral.ServerRequest
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getErrorConfigVersion = null;
    }
}
