package id.dana.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.deeplink.model.DeepLinkPayload;
import id.dana.model.DeepLinkPayloadModel;
import id.dana.oauth.mapper.OauthParamsModelMapper;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class DeepLinkPayloadModelMapper extends BaseMapper<DeepLinkPayload, DeepLinkPayloadModel> {
    private final OauthParamsModelMapper getAuthRequestContext;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ DeepLinkPayloadModel map(DeepLinkPayload deepLinkPayload) {
        DeepLinkPayload deepLinkPayload2 = deepLinkPayload;
        if (deepLinkPayload2 != null) {
            DeepLinkPayloadModel deepLinkPayloadModel = new DeepLinkPayloadModel();
            deepLinkPayloadModel.getAuthRequestContext = deepLinkPayload2.getInnerUrl();
            deepLinkPayloadModel.getErrorConfigVersion = deepLinkPayload2.getPath();
            deepLinkPayloadModel.PlaceComponentResult = deepLinkPayload2.getFullUrl();
            deepLinkPayloadModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = deepLinkPayload2.isSkipHomePage();
            deepLinkPayloadModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = deepLinkPayload2.getShortCode();
            deepLinkPayloadModel.scheduleImpl = deepLinkPayload2.getReferralCode();
            deepLinkPayloadModel.MyBillsEntityDataFactory = deepLinkPayload2.getAction();
            deepLinkPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2 = deepLinkPayload2.getCodeValue();
            deepLinkPayloadModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = deepLinkPayload2.getParams();
            deepLinkPayloadModel.BuiltInFictitiousFunctionClassFactory = deepLinkPayload2.getDestinationPath();
            deepLinkPayloadModel.lookAheadTest = deepLinkPayload2.getOrderId();
            deepLinkPayloadModel.moveToNextValue = this.getAuthRequestContext.apply(deepLinkPayload2.getOauthParams());
            return deepLinkPayloadModel;
        }
        return null;
    }

    @Inject
    public DeepLinkPayloadModelMapper(OauthParamsModelMapper oauthParamsModelMapper) {
        this.getAuthRequestContext = oauthParamsModelMapper;
    }
}
