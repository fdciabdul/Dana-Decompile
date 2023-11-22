package id.dana.contract.deeplink.path;

import id.dana.base.AbstractContract;
import id.dana.contract.deeplink.path.OauthPresenter;
import id.dana.domain.deeplink.model.OauthParams;
import id.dana.oauth.model.OauthParamsModel;

/* loaded from: classes4.dex */
public interface OauthContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2(OauthPresenter.GetNicknameCallback getNicknameCallback);

        void KClassImpl$Data$declaredNonStaticMembers$2(OauthParams oauthParams);

        void MyBillsEntityDataFactory(OauthPresenter.GetKycStatusCallback getKycStatusCallback);

        void getAuthRequestContext(String str, OauthPresenter.AddingNameSubMerchantIdListener addingNameSubMerchantIdListener);

        void getAuthRequestContext(String str, OauthPresenter.WhitelistedSubMerchantIdListener whitelistedSubMerchantIdListener);
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void MyBillsEntityDataFactory(OauthParamsModel oauthParamsModel);
    }
}
