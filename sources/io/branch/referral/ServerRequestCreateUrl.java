package io.branch.referral;

import android.content.Context;
import com.huawei.hms.framework.common.ContainerUtils;
import io.branch.referral.Branch;
import io.branch.referral.Defines;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ServerRequestCreateUrl extends ServerRequest {
    private boolean DatabaseTableConfigUtil;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    boolean getErrorConfigVersion;
    BranchLinkData moveToNextValue;
    Branch.BranchLinkCreateListener scheduleImpl;

    @Override // io.branch.referral.ServerRequest
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.branch.referral.ServerRequest
    public final boolean moveToNextValue() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.branch.referral.ServerRequest
    public final boolean scheduleImpl() {
        return false;
    }

    public ServerRequestCreateUrl(Context context, String str, int i, int i2, Collection<String> collection, String str2, String str3, String str4, String str5, JSONObject jSONObject, Branch.BranchLinkCreateListener branchLinkCreateListener, boolean z, boolean z2) {
        super(context, Defines.RequestPath.GetURL.getPath());
        this.scheduleImpl = branchLinkCreateListener;
        this.DatabaseTableConfigUtil = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = z2;
        BranchLinkData branchLinkData = new BranchLinkData();
        this.moveToNextValue = branchLinkData;
        try {
            String key = Defines.Jsonkey.IdentityID.getKey();
            PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
            branchLinkData.put(key, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_identity_id", "bnc_no_value"));
            BranchLinkData branchLinkData2 = this.moveToNextValue;
            String key2 = Defines.Jsonkey.DeviceFingerprintID.getKey();
            PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            branchLinkData2.put(key2, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_device_fingerprint_id", "bnc_no_value"));
            BranchLinkData branchLinkData3 = this.moveToNextValue;
            String key3 = Defines.Jsonkey.SessionID.getKey();
            PrefHelper prefHelper3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            branchLinkData3.put(key3, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_session_id", "bnc_no_value"));
            PrefHelper prefHelper4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (!PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_link_click_id", "bnc_no_value").equals("bnc_no_value")) {
                BranchLinkData branchLinkData4 = this.moveToNextValue;
                String key4 = Defines.Jsonkey.LinkClickID.getKey();
                PrefHelper prefHelper5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                branchLinkData4.put(key4, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_link_click_id", "bnc_no_value"));
            }
            BranchLinkData branchLinkData5 = this.moveToNextValue;
            if (i != 0) {
                branchLinkData5.getErrorConfigVersion = i;
                branchLinkData5.put(Defines.LinkParam.Type.getKey(), i);
            }
            BranchLinkData branchLinkData6 = this.moveToNextValue;
            if (i2 > 0) {
                branchLinkData6.PlaceComponentResult = i2;
                branchLinkData6.put(Defines.LinkParam.Duration.getKey(), i2);
            }
            BranchLinkData branchLinkData7 = this.moveToNextValue;
            if (collection != null) {
                branchLinkData7.scheduleImpl = collection;
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = collection.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                branchLinkData7.put(Defines.LinkParam.Tags.getKey(), jSONArray);
            }
            BranchLinkData branchLinkData8 = this.moveToNextValue;
            if (str != null) {
                branchLinkData8.BuiltInFictitiousFunctionClassFactory = str;
                branchLinkData8.put(Defines.LinkParam.Alias.getKey(), str);
            }
            BranchLinkData branchLinkData9 = this.moveToNextValue;
            if (str2 != null) {
                branchLinkData9.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
                branchLinkData9.put(Defines.LinkParam.Channel.getKey(), str2);
            }
            BranchLinkData branchLinkData10 = this.moveToNextValue;
            if (str3 != null) {
                branchLinkData10.getAuthRequestContext = str3;
                branchLinkData10.put(Defines.LinkParam.Feature.getKey(), str3);
            }
            BranchLinkData branchLinkData11 = this.moveToNextValue;
            if (str4 != null) {
                branchLinkData11.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
                branchLinkData11.put(Defines.LinkParam.Stage.getKey(), str4);
            }
            BranchLinkData branchLinkData12 = this.moveToNextValue;
            if (str5 != null) {
                branchLinkData12.MyBillsEntityDataFactory = str5;
                branchLinkData12.put(Defines.LinkParam.Campaign.getKey(), str5);
            }
            BranchLinkData branchLinkData13 = this.moveToNextValue;
            branchLinkData13.lookAheadTest = jSONObject;
            branchLinkData13.put(Defines.LinkParam.Data.getKey(), jSONObject);
            MyBillsEntityDataFactory(this.moveToNextValue);
        } catch (JSONException unused) {
            this.MyBillsEntityDataFactory = true;
        }
    }

    public ServerRequestCreateUrl(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
        this.DatabaseTableConfigUtil = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    @Override // io.branch.referral.ServerRequest
    public final boolean getAuthRequestContext(Context context) {
        if (ServerRequest.PlaceComponentResult(context)) {
            return false;
        }
        Branch.BranchLinkCreateListener branchLinkCreateListener = this.scheduleImpl;
        if (branchLinkCreateListener != null) {
            branchLinkCreateListener.onLinkCreate(null, new BranchError("Trouble creating a URL.", -102));
            return true;
        }
        return true;
    }

    @Override // io.branch.referral.ServerRequest
    public final void PlaceComponentResult(int i, String str) {
        if (this.scheduleImpl != null) {
            String isLayoutRequested = this.NetworkUserEntityData$$ExternalSyntheticLambda1 ? isLayoutRequested() : null;
            Branch.BranchLinkCreateListener branchLinkCreateListener = this.scheduleImpl;
            StringBuilder sb = new StringBuilder();
            sb.append("Trouble creating a URL. ");
            sb.append(str);
            branchLinkCreateListener.onLinkCreate(isLayoutRequested, new BranchError(sb.toString(), i));
        }
    }

    public final String isLayoutRequested() {
        PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (!PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_user_url", "bnc_no_value").equals("bnc_no_value")) {
            PrefHelper prefHelper2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return PlaceComponentResult(PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_user_url", "bnc_no_value"));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("https://bnc.lt/a/");
        PrefHelper prefHelper3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (PrefHelper.getAuthRequestContext == null) {
            PrefHelper.getAuthRequestContext = PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_branch_key", "bnc_no_value");
        }
        sb.append(PrefHelper.getAuthRequestContext);
        return PlaceComponentResult(sb.toString());
    }

    @Override // io.branch.referral.ServerRequest
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.scheduleImpl = null;
    }

    public final boolean PrepareContext() {
        return this.DatabaseTableConfigUtil;
    }

    private String PlaceComponentResult(String str) {
        try {
            if (Branch.BuiltInFictitiousFunctionClassFactory().scheduleImpl() && !str.contains("https://bnc.lt/a/")) {
                str = str.replace(new URL(str).getQuery(), "");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str.contains("?") ? "" : "?");
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append(obj.endsWith("?") ? "" : ContainerUtils.FIELD_DELIMITER);
            String obj2 = sb2.toString();
            Collection<String> collection = this.moveToNextValue.scheduleImpl;
            if (collection != null) {
                for (String str2 : collection) {
                    if (str2 != null && str2.length() > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(obj2);
                        sb3.append(Defines.LinkParam.Tags);
                        sb3.append("=");
                        sb3.append(URLEncoder.encode(str2, "UTF8"));
                        sb3.append(ContainerUtils.FIELD_DELIMITER);
                        obj2 = sb3.toString();
                    }
                }
            }
            String str3 = this.moveToNextValue.BuiltInFictitiousFunctionClassFactory;
            if (str3 != null && str3.length() > 0) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(obj2);
                sb4.append(Defines.LinkParam.Alias);
                sb4.append("=");
                sb4.append(URLEncoder.encode(str3, "UTF8"));
                sb4.append(ContainerUtils.FIELD_DELIMITER);
                obj2 = sb4.toString();
            }
            String str4 = this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str4 != null && str4.length() > 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(obj2);
                sb5.append(Defines.LinkParam.Channel);
                sb5.append("=");
                sb5.append(URLEncoder.encode(str4, "UTF8"));
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                obj2 = sb5.toString();
            }
            String str5 = this.moveToNextValue.getAuthRequestContext;
            if (str5 != null && str5.length() > 0) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(obj2);
                sb6.append(Defines.LinkParam.Feature);
                sb6.append("=");
                sb6.append(URLEncoder.encode(str5, "UTF8"));
                sb6.append(ContainerUtils.FIELD_DELIMITER);
                obj2 = sb6.toString();
            }
            String str6 = this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (str6 != null && str6.length() > 0) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(obj2);
                sb7.append(Defines.LinkParam.Stage);
                sb7.append("=");
                sb7.append(URLEncoder.encode(str6, "UTF8"));
                sb7.append(ContainerUtils.FIELD_DELIMITER);
                obj2 = sb7.toString();
            }
            String str7 = this.moveToNextValue.MyBillsEntityDataFactory;
            if (str7 != null && str7.length() > 0) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(obj2);
                sb8.append(Defines.LinkParam.Campaign);
                sb8.append("=");
                sb8.append(URLEncoder.encode(str7, "UTF8"));
                sb8.append(ContainerUtils.FIELD_DELIMITER);
                obj2 = sb8.toString();
            }
            long j = this.moveToNextValue.getErrorConfigVersion;
            StringBuilder sb9 = new StringBuilder();
            sb9.append(obj2);
            sb9.append(Defines.LinkParam.Type);
            sb9.append("=");
            sb9.append(j);
            sb9.append(ContainerUtils.FIELD_DELIMITER);
            String obj3 = sb9.toString();
            long j2 = this.moveToNextValue.PlaceComponentResult;
            StringBuilder sb10 = new StringBuilder();
            sb10.append(obj3);
            sb10.append(Defines.LinkParam.Duration);
            sb10.append("=");
            sb10.append(j2);
            String obj4 = sb10.toString();
            String jSONObject = this.moveToNextValue.lookAheadTest.toString();
            if (jSONObject == null || jSONObject.length() <= 0) {
                return obj4;
            }
            String encode = URLEncoder.encode(Base64.BuiltInFictitiousFunctionClassFactory(jSONObject.getBytes()), "UTF8");
            StringBuilder sb11 = new StringBuilder();
            sb11.append(obj4);
            sb11.append("&source=android&data=");
            sb11.append(encode);
            return sb11.toString();
        } catch (Exception unused) {
            this.scheduleImpl.onLinkCreate(null, new BranchError("Trouble creating a URL.", -116));
            return str;
        }
    }

    private boolean newProxyInstance() {
        return this.getErrorConfigVersion;
    }

    public final void initRecordTimeStamp() {
        JSONObject MyBillsEntityDataFactory = this.moveToNextValue.MyBillsEntityDataFactory();
        if (newProxyInstance()) {
            ExtendedAnswerProvider extendedAnswerProvider = new ExtendedAnswerProvider();
            PrefHelper prefHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
            extendedAnswerProvider.PlaceComponentResult("Branch Share", MyBillsEntityDataFactory, PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getString("bnc_identity_id", "bnc_no_value"));
        }
    }

    @Override // io.branch.referral.ServerRequest
    public final void getAuthRequestContext(ServerResponse serverResponse, Branch branch) {
        JSONObject jSONObject;
        try {
            Object obj = serverResponse.PlaceComponentResult;
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
            } else {
                jSONObject = new JSONObject();
            }
            String string = jSONObject.getString("url");
            Branch.BranchLinkCreateListener branchLinkCreateListener = this.scheduleImpl;
            if (branchLinkCreateListener != null) {
                branchLinkCreateListener.onLinkCreate(string, null);
            }
            initRecordTimeStamp();
        } catch (Exception unused) {
        }
    }
}
