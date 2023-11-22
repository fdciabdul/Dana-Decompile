package id.dana.contract.deeplink.path;

import dagger.internal.Factory;
import id.dana.contract.deeplink.path.OauthContract;
import id.dana.domain.account.interactor.GetKycLevel;
import id.dana.domain.account.interactor.GetNickname;
import id.dana.domain.oauth.interactor.GetAddingNameWhitelistedMerchantId;
import id.dana.domain.oauth.interactor.GetWhitelistedSubMerchantId;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.oauth.mapper.OauthParamsModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OauthPresenter_Factory implements Factory<OauthPresenter> {
    private final Provider<GetUserInfoWithKyc> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetWhitelistedSubMerchantId> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetNickname> MyBillsEntityDataFactory;
    private final Provider<GetAddingNameWhitelistedMerchantId> PlaceComponentResult;
    private final Provider<GetKycLevel> getAuthRequestContext;
    private final Provider<OauthContract.View> getErrorConfigVersion;
    private final Provider<OauthParamsModelMapper> moveToNextValue;

    private OauthPresenter_Factory(Provider<OauthContract.View> provider, Provider<OauthParamsModelMapper> provider2, Provider<GetKycLevel> provider3, Provider<GetUserInfoWithKyc> provider4, Provider<GetNickname> provider5, Provider<GetWhitelistedSubMerchantId> provider6, Provider<GetAddingNameWhitelistedMerchantId> provider7) {
        this.getErrorConfigVersion = provider;
        this.moveToNextValue = provider2;
        this.getAuthRequestContext = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider6;
        this.PlaceComponentResult = provider7;
    }

    public static OauthPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<OauthContract.View> provider, Provider<OauthParamsModelMapper> provider2, Provider<GetKycLevel> provider3, Provider<GetUserInfoWithKyc> provider4, Provider<GetNickname> provider5, Provider<GetWhitelistedSubMerchantId> provider6, Provider<GetAddingNameWhitelistedMerchantId> provider7) {
        return new OauthPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        OauthPresenter oauthPresenter = new OauthPresenter(this.getErrorConfigVersion.get(), this.moveToNextValue.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
        OauthPresenter_MembersInjector.getAuthRequestContext(oauthPresenter, this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get());
        return oauthPresenter;
    }
}
