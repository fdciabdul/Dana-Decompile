package id.dana.contract.homeinfo;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.homeinfo.HomeRevampContract;
import id.dana.domain.permissionprompt.interactor.CheckLocationPermissionPromptFeature;
import id.dana.domain.permissionprompt.interactor.SaveNumberOfLocationPermissionShownData;
import id.dana.domain.preventscreenshot.interactor.GetPreventScreenshotConfig;
import id.dana.domain.profilemenu.interactor.GetProfileRevampConfig;
import id.dana.domain.transactionhistory.interactor.GetTransactionHistoryConfig;
import id.dana.domain.wallet_v3.interactor.GetWalletConfig;
import id.dana.explore.domain.globalsearch.interactor.GetGlobalSearchConfig;
import id.dana.kyb.domain.interactor.IsKybNativeEnabled;
import id.dana.kyb.domain.interactor.IsQrisPaymentEnabled;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class HomeRevampPresenter_Factory implements Factory<HomeRevampPresenter> {
    private final Provider<GetPreventScreenshotConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CheckLocationPermissionPromptFeature> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetTransactionHistoryConfig> MyBillsEntityDataFactory;
    private final Provider<SaveNumberOfLocationPermissionShownData> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetProfileRevampConfig> PlaceComponentResult;
    private final Provider<GetGlobalSearchConfig> getAuthRequestContext;
    private final Provider<HomeRevampContract.View> getErrorConfigVersion;
    private final Provider<IsQrisPaymentEnabled> lookAheadTest;
    private final Provider<IsKybNativeEnabled> moveToNextValue;
    private final Provider<GetWalletConfig> scheduleImpl;

    private HomeRevampPresenter_Factory(Provider<HomeRevampContract.View> provider, Provider<GetGlobalSearchConfig> provider2, Provider<GetProfileRevampConfig> provider3, Provider<IsKybNativeEnabled> provider4, Provider<GetWalletConfig> provider5, Provider<IsQrisPaymentEnabled> provider6, Provider<CheckLocationPermissionPromptFeature> provider7, Provider<SaveNumberOfLocationPermissionShownData> provider8, Provider<GetTransactionHistoryConfig> provider9, Provider<GetPreventScreenshotConfig> provider10) {
        this.getErrorConfigVersion = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
        this.moveToNextValue = provider4;
        this.scheduleImpl = provider5;
        this.lookAheadTest = provider6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider8;
        this.MyBillsEntityDataFactory = provider9;
        this.BuiltInFictitiousFunctionClassFactory = provider10;
    }

    public static HomeRevampPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<HomeRevampContract.View> provider, Provider<GetGlobalSearchConfig> provider2, Provider<GetProfileRevampConfig> provider3, Provider<IsKybNativeEnabled> provider4, Provider<GetWalletConfig> provider5, Provider<IsQrisPaymentEnabled> provider6, Provider<CheckLocationPermissionPromptFeature> provider7, Provider<SaveNumberOfLocationPermissionShownData> provider8, Provider<GetTransactionHistoryConfig> provider9, Provider<GetPreventScreenshotConfig> provider10) {
        return new HomeRevampPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HomeRevampPresenter(DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory));
    }
}
