package id.dana.globalnetwork.currency;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.globalnetwork.interactor.DecodeGnQr;
import id.dana.domain.globalnetwork.interactor.GetCountryCodeByLocationBlacklistedCountry;
import id.dana.domain.globalnetwork.interactor.GetGnCScanBBlacklistedCountry;
import id.dana.domain.globalnetwork.interactor.GetPayRequest;
import id.dana.domain.globalnetwork.interactor.GetWalletOauth;
import id.dana.domain.globalnetwork.interactor.IsAlipayConnectServiceFirstTime;
import id.dana.domain.globalnetwork.interactor.IsCScanBEnabled;
import id.dana.domain.globalnetwork.interactor.OpenMerchantCashier;
import id.dana.domain.globalnetwork.interactor.SaveAlipayConnectServiceFirstTime;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.globalnetwork.currency.GlobalNetworkContract;
import id.dana.globalnetwork.tracker.GlobalNetworkTracker;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GlobalNetworkPresenter_Factory implements Factory<GlobalNetworkPresenter> {
    private final Provider<GetCountryCodeByLocationBlacklistedCountry> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GlobalNetworkContract.View> DatabaseTableConfigUtil;
    private final Provider<GetAuthCode> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetGnCScanBBlacklistedCountry> MyBillsEntityDataFactory;
    private final Provider<GetWalletOauth> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<OpenMerchantCashier> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<SaveAlipayConnectServiceFirstTime> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<GetPayRequest> PlaceComponentResult;
    private final Provider<DecodeGnQr> getAuthRequestContext;
    private final Provider<IsCScanBEnabled> getErrorConfigVersion;
    private final Provider<GetUserInfoWithKyc> lookAheadTest;
    private final Provider<IsAlipayConnectServiceFirstTime> moveToNextValue;
    private final Provider<GlobalNetworkTracker> scheduleImpl;

    private GlobalNetworkPresenter_Factory(Provider<GlobalNetworkContract.View> provider, Provider<IsCScanBEnabled> provider2, Provider<DecodeGnQr> provider3, Provider<OpenMerchantCashier> provider4, Provider<GetGnCScanBBlacklistedCountry> provider5, Provider<GetUserInfoWithKyc> provider6, Provider<GlobalNetworkTracker> provider7, Provider<GetCountryCodeByLocationBlacklistedCountry> provider8, Provider<IsAlipayConnectServiceFirstTime> provider9, Provider<SaveAlipayConnectServiceFirstTime> provider10, Provider<GetWalletOauth> provider11, Provider<GetAuthCode> provider12, Provider<GetPayRequest> provider13) {
        this.DatabaseTableConfigUtil = provider;
        this.getErrorConfigVersion = provider2;
        this.getAuthRequestContext = provider3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.lookAheadTest = provider6;
        this.scheduleImpl = provider7;
        this.BuiltInFictitiousFunctionClassFactory = provider8;
        this.moveToNextValue = provider9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider10;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider11;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider12;
        this.PlaceComponentResult = provider13;
    }

    public static GlobalNetworkPresenter_Factory getAuthRequestContext(Provider<GlobalNetworkContract.View> provider, Provider<IsCScanBEnabled> provider2, Provider<DecodeGnQr> provider3, Provider<OpenMerchantCashier> provider4, Provider<GetGnCScanBBlacklistedCountry> provider5, Provider<GetUserInfoWithKyc> provider6, Provider<GlobalNetworkTracker> provider7, Provider<GetCountryCodeByLocationBlacklistedCountry> provider8, Provider<IsAlipayConnectServiceFirstTime> provider9, Provider<SaveAlipayConnectServiceFirstTime> provider10, Provider<GetWalletOauth> provider11, Provider<GetAuthCode> provider12, Provider<GetPayRequest> provider13) {
        return new GlobalNetworkPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        GlobalNetworkPresenter globalNetworkPresenter = new GlobalNetworkPresenter(DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl));
        GlobalNetworkPresenter_MembersInjector.getAuthRequestContext(globalNetworkPresenter, DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
        GlobalNetworkPresenter_MembersInjector.BuiltInFictitiousFunctionClassFactory(globalNetworkPresenter, DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
        GlobalNetworkPresenter_MembersInjector.BuiltInFictitiousFunctionClassFactory(globalNetworkPresenter, DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
        return globalNetworkPresenter;
    }
}
