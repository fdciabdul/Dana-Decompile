package id.dana.contract.deeplink.path;

import dagger.MembersInjector;
import id.dana.domain.oauth.interactor.GetAddingNameWhitelistedMerchantId;
import id.dana.domain.oauth.interactor.GetWhitelistedSubMerchantId;

/* loaded from: classes4.dex */
public final class OauthPresenter_MembersInjector implements MembersInjector<OauthPresenter> {
    public static void getAuthRequestContext(OauthPresenter oauthPresenter, GetWhitelistedSubMerchantId getWhitelistedSubMerchantId, GetAddingNameWhitelistedMerchantId getAddingNameWhitelistedMerchantId) {
        oauthPresenter.MyBillsEntityDataFactory = getWhitelistedSubMerchantId;
        oauthPresenter.PlaceComponentResult = getAddingNameWhitelistedMerchantId;
    }
}
