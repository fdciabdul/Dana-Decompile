package id.dana.model;

import id.dana.oauth.model.OauthParamsModel;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes5.dex */
public class DeepLinkPayloadModel {
    public String BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public Map<String, String> NetworkUserEntityData$$ExternalSyntheticLambda0;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    public String NetworkUserEntityData$$ExternalSyntheticLambda2;
    public String PlaceComponentResult;
    public String getAuthRequestContext;
    public String getErrorConfigVersion;
    public String lookAheadTest;
    public OauthParamsModel moveToNextValue;
    public String scheduleImpl;

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DeepLinkPayloadModel deepLinkPayloadModel = (DeepLinkPayloadModel) obj;
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1 == deepLinkPayloadModel.NetworkUserEntityData$$ExternalSyntheticLambda1 && Objects.equals(this.PlaceComponentResult, deepLinkPayloadModel.PlaceComponentResult) && Objects.equals(this.getAuthRequestContext, deepLinkPayloadModel.getAuthRequestContext) && Objects.equals(this.getErrorConfigVersion, deepLinkPayloadModel.getErrorConfigVersion) && Objects.equals(this.scheduleImpl, deepLinkPayloadModel.scheduleImpl) && Objects.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda2, deepLinkPayloadModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Objects.equals(this.MyBillsEntityDataFactory, deepLinkPayloadModel.MyBillsEntityDataFactory) && Objects.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda0, deepLinkPayloadModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Objects.equals(this.moveToNextValue, deepLinkPayloadModel.moveToNextValue) && Objects.equals(this.KClassImpl$Data$declaredNonStaticMembers$2, deepLinkPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public int hashCode() {
        return Objects.hash(this.PlaceComponentResult, this.getAuthRequestContext, this.getErrorConfigVersion, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.MyBillsEntityDataFactory, Boolean.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda1), this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeepLinkPayloadModel{fullUrl='");
        sb.append(this.PlaceComponentResult);
        sb.append('\'');
        sb.append(", innerUrl='");
        sb.append(this.getAuthRequestContext);
        sb.append('\'');
        sb.append(", path='");
        sb.append(this.getErrorConfigVersion);
        sb.append('\'');
        sb.append(", referralCode='");
        sb.append(this.scheduleImpl);
        sb.append('\'');
        sb.append(", shortCode='");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append('\'');
        sb.append(", action='");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append('\'');
        sb.append(", skipHomePage=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", params=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", oauthParams=");
        sb.append(this.moveToNextValue);
        sb.append(", codeValue=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append('}');
        return sb.toString();
    }
}
