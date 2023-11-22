package io.branch.referral;

import android.content.Context;
import io.branch.indexing.ContentDiscoverer;
import io.branch.referral.Defines;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ServerRequestRegisterClose extends ServerRequest {
    @Override // io.branch.referral.ServerRequest
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return false;
    }

    @Override // io.branch.referral.ServerRequest
    public final void PlaceComponentResult(int i, String str) {
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean scheduleImpl() {
        return false;
    }

    public ServerRequestRegisterClose(Context context) {
        super(context, Defines.RequestPath.RegisterClose.getPath());
        JSONObject jSONObject = new JSONObject();
        try {
            String key = Defines.Jsonkey.DeviceFingerprintID.getKey();
            PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
            jSONObject.put(key, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_device_fingerprint_id", "bnc_no_value"));
            String key2 = Defines.Jsonkey.IdentityID.getKey();
            PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            jSONObject.put(key2, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_identity_id", "bnc_no_value"));
            String key3 = Defines.Jsonkey.SessionID.getKey();
            PrefHelper prefHelper3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            jSONObject.put(key3, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_session_id", "bnc_no_value"));
            PrefHelper prefHelper4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (!PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_link_click_id", "bnc_no_value").equals("bnc_no_value")) {
                String key4 = Defines.Jsonkey.LinkClickID.getKey();
                PrefHelper prefHelper5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                jSONObject.put(key4, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_link_click_id", "bnc_no_value"));
            }
            JSONObject authRequestContext = ContentDiscoverer.MyBillsEntityDataFactory().getAuthRequestContext(context);
            if (authRequestContext != null) {
                jSONObject.put(Defines.Jsonkey.ContentDiscovery.getKey(), authRequestContext);
            }
            if (DeviceInfo.getAuthRequestContext() != null) {
                jSONObject.put(Defines.Jsonkey.AppVersion.getKey(), SystemObserver.MyBillsEntityDataFactory(DeviceInfo.getAuthRequestContext().PlaceComponentResult));
            }
            MyBillsEntityDataFactory(jSONObject);
        } catch (JSONException unused) {
            this.MyBillsEntityDataFactory = true;
        }
    }

    public ServerRequestRegisterClose(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean getAuthRequestContext(Context context) {
        return !ServerRequest.PlaceComponentResult(context);
    }

    @Override // io.branch.referral.ServerRequest
    public final void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
        PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        PrefHelper.MyBillsEntityDataFactory.moveToNextValue.putString("bnc_session_params", "bnc_no_value");
        PrefHelper.MyBillsEntityDataFactory.moveToNextValue.apply();
    }
}
