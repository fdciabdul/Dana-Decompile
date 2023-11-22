package id.dana.contract.oauth;

import dagger.internal.Factory;
import id.dana.contract.oauth.OauthGrantContract;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.featureconfig.interactor.GetShowAlipayConnectBrandConfig;
import id.dana.domain.oauth.interactor.ConfirmScopes;
import id.dana.domain.oauth.interactor.GetGnBindingBenefits;
import id.dana.domain.oauth.interactor.GetScopes;
import id.dana.domain.oauth.interactor.GnAuthAgreement;
import id.dana.domain.oauth.interactor.GnAuthApply;
import id.dana.oauth.mapper.OauthInitModelMapper;
import id.dana.oauth.tracker.OauthGrantTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OauthGrantPresenter_Factory implements Factory<OauthGrantPresenter> {
    private final Provider<GetPhoneNumber> BuiltInFictitiousFunctionClassFactory;
    private final Provider<OauthGrantContract.View> DatabaseTableConfigUtil;
    private final Provider<GetAvatarUrl> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ConfirmScopes> MyBillsEntityDataFactory;
    private final Provider<GnAuthApply> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetScopes> PlaceComponentResult;
    private final Provider<GetGnBindingBenefits> getAuthRequestContext;
    private final Provider<GnAuthAgreement> getErrorConfigVersion;
    private final Provider<GetShowAlipayConnectBrandConfig> lookAheadTest;
    private final Provider<OauthGrantTracker> moveToNextValue;
    private final Provider<OauthInitModelMapper> scheduleImpl;

    private OauthGrantPresenter_Factory(Provider<GetScopes> provider, Provider<OauthGrantContract.View> provider2, Provider<OauthInitModelMapper> provider3, Provider<GetPhoneNumber> provider4, Provider<ConfirmScopes> provider5, Provider<GnAuthAgreement> provider6, Provider<GnAuthApply> provider7, Provider<GetGnBindingBenefits> provider8, Provider<GetShowAlipayConnectBrandConfig> provider9, Provider<OauthGrantTracker> provider10, Provider<GetAvatarUrl> provider11) {
        this.PlaceComponentResult = provider;
        this.DatabaseTableConfigUtil = provider2;
        this.scheduleImpl = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.getErrorConfigVersion = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider7;
        this.getAuthRequestContext = provider8;
        this.lookAheadTest = provider9;
        this.moveToNextValue = provider10;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider11;
    }

    public static OauthGrantPresenter_Factory getAuthRequestContext(Provider<GetScopes> provider, Provider<OauthGrantContract.View> provider2, Provider<OauthInitModelMapper> provider3, Provider<GetPhoneNumber> provider4, Provider<ConfirmScopes> provider5, Provider<GnAuthAgreement> provider6, Provider<GnAuthApply> provider7, Provider<GetGnBindingBenefits> provider8, Provider<GetShowAlipayConnectBrandConfig> provider9, Provider<OauthGrantTracker> provider10, Provider<GetAvatarUrl> provider11) {
        return new OauthGrantPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OauthGrantPresenter(this.PlaceComponentResult.get(), this.DatabaseTableConfigUtil.get(), this.scheduleImpl.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.getErrorConfigVersion.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.getAuthRequestContext.get(), this.lookAheadTest.get(), this.moveToNextValue.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
