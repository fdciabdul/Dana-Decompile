package io.branch.referral;

import android.text.TextUtils;
import io.branch.referral.Defines;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class BranchLinkData extends JSONObject {
    String BuiltInFictitiousFunctionClassFactory;
    String KClassImpl$Data$declaredNonStaticMembers$2;
    String MyBillsEntityDataFactory;
    String NetworkUserEntityData$$ExternalSyntheticLambda0;
    int PlaceComponentResult;
    String getAuthRequestContext;
    int getErrorConfigVersion;
    JSONObject lookAheadTest;
    Collection<String> scheduleImpl;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BranchLinkData branchLinkData = (BranchLinkData) obj;
            String str = this.BuiltInFictitiousFunctionClassFactory;
            if (str == null) {
                if (branchLinkData.BuiltInFictitiousFunctionClassFactory != null) {
                    return false;
                }
            } else if (!str.equals(branchLinkData.BuiltInFictitiousFunctionClassFactory)) {
                return false;
            }
            String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str2 == null) {
                if (branchLinkData.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    return false;
                }
            } else if (!str2.equals(branchLinkData.KClassImpl$Data$declaredNonStaticMembers$2)) {
                return false;
            }
            String str3 = this.getAuthRequestContext;
            if (str3 == null) {
                if (branchLinkData.getAuthRequestContext != null) {
                    return false;
                }
            } else if (!str3.equals(branchLinkData.getAuthRequestContext)) {
                return false;
            }
            JSONObject jSONObject = this.lookAheadTest;
            if (jSONObject == null) {
                if (branchLinkData.lookAheadTest != null) {
                    return false;
                }
            } else if (!jSONObject.equals(branchLinkData.lookAheadTest)) {
                return false;
            }
            String str4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (str4 == null) {
                if (branchLinkData.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                    return false;
                }
            } else if (!str4.equals(branchLinkData.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                return false;
            }
            String str5 = this.MyBillsEntityDataFactory;
            if (str5 == null) {
                if (branchLinkData.MyBillsEntityDataFactory != null) {
                    return false;
                }
            } else if (!str5.equals(branchLinkData.MyBillsEntityDataFactory)) {
                return false;
            }
            if (this.getErrorConfigVersion == branchLinkData.getErrorConfigVersion && this.PlaceComponentResult == branchLinkData.PlaceComponentResult) {
                Collection<String> collection = this.scheduleImpl;
                if (collection == null) {
                    if (branchLinkData.scheduleImpl != null) {
                        return false;
                    }
                } else if (!collection.toString().equals(branchLinkData.scheduleImpl.toString())) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = this.getErrorConfigVersion;
        String str = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = str == null ? 0 : str.toLowerCase().hashCode();
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode2 = str2 == null ? 0 : str2.toLowerCase().hashCode();
        String str3 = this.getAuthRequestContext;
        int hashCode3 = str3 == null ? 0 : str3.toLowerCase().hashCode();
        String str4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode4 = str4 == null ? 0 : str4.toLowerCase().hashCode();
        String str5 = this.MyBillsEntityDataFactory;
        int hashCode5 = str5 == null ? 0 : str5.toLowerCase().hashCode();
        JSONObject jSONObject = this.lookAheadTest;
        int hashCode6 = ((((((((((((((i + 19) * 19) + hashCode) * 19) + hashCode2) * 19) + hashCode3) * 19) + hashCode4) * 19) + hashCode5) * 19) + (jSONObject != null ? jSONObject.toString().toLowerCase().hashCode() : 0)) * 19) + this.PlaceComponentResult;
        Collection<String> collection = this.scheduleImpl;
        if (collection != null) {
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                hashCode6 = (hashCode6 * 19) + it.next().toLowerCase().hashCode();
            }
        }
        return hashCode6;
    }

    public final JSONObject MyBillsEntityDataFactory() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("~");
                sb.append(Defines.LinkParam.Channel.getKey());
                jSONObject.put(sb.toString(), this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (!TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("~");
                sb2.append(Defines.LinkParam.Alias.getKey());
                jSONObject.put(sb2.toString(), this.BuiltInFictitiousFunctionClassFactory);
            }
            if (!TextUtils.isEmpty(this.getAuthRequestContext)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("~");
                sb3.append(Defines.LinkParam.Feature.getKey());
                jSONObject.put(sb3.toString(), this.getAuthRequestContext);
            }
            if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("~");
                sb4.append(Defines.LinkParam.Stage.getKey());
                jSONObject.put(sb4.toString(), this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
            if (!TextUtils.isEmpty(this.MyBillsEntityDataFactory)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("~");
                sb5.append(Defines.LinkParam.Campaign.getKey());
                jSONObject.put(sb5.toString(), this.MyBillsEntityDataFactory);
            }
            if (has(Defines.LinkParam.Tags.getKey())) {
                jSONObject.put(Defines.LinkParam.Tags.getKey(), getJSONArray(Defines.LinkParam.Tags.getKey()));
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("~");
            sb6.append(Defines.LinkParam.Type.getKey());
            jSONObject.put(sb6.toString(), this.getErrorConfigVersion);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("~");
            sb7.append(Defines.LinkParam.Duration.getKey());
            jSONObject.put(sb7.toString(), this.PlaceComponentResult);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
