package id.dana.oauth.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.deeplink.model.OauthParams;
import id.dana.oauth.model.OauthParamsModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class OauthParamsModelMapper extends BaseMapper<OauthParams, OauthParamsModel> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ OauthParamsModel map(OauthParams oauthParams) {
        OauthParams oauthParams2 = oauthParams;
        if (oauthParams2 != null) {
            OauthParamsModel oauthParamsModel = new OauthParamsModel();
            oauthParamsModel.BuiltInFictitiousFunctionClassFactory = oauthParams2.getClientId();
            oauthParamsModel.MyBillsEntityDataFactory = oauthParams2.getCodeChallenge();
            oauthParamsModel.GetContactSyncConfig = oauthParams2.getPhoneNumber();
            oauthParamsModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = oauthParams2.getResponseType();
            oauthParamsModel.isLayoutRequested = oauthParams2.getScope();
            oauthParamsModel.newProxyInstance = oauthParams2.getState();
            oauthParamsModel.getErrorConfigVersion = Boolean.valueOf(oauthParams2.isNeedMobileToken());
            oauthParamsModel.DatabaseTableConfigUtil = oauthParams2.getRedirectUrl();
            oauthParamsModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = oauthParams2.getMerchantId();
            oauthParamsModel.lookAheadTest = oauthParams2.getMerchantName();
            oauthParamsModel.initRecordTimeStamp = oauthParams2.getReferringLink();
            oauthParamsModel.PlaceComponentResult = Boolean.valueOf(oauthParams2.isIpgBinding());
            return oauthParamsModel;
        }
        return null;
    }

    @Inject
    public OauthParamsModelMapper() {
    }
}
