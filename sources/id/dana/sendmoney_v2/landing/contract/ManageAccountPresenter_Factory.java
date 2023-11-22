package id.dana.sendmoney_v2.landing.contract;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.recentbank.interactor.RemoveRecentSavedBank;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.recentcontact.interactor.RemoveRecentSavedContact;
import id.dana.domain.recentrecipient.interactor.GetMaxFavoriteAccount;
import id.dana.domain.recentrecipient.interactor.RemoveRecentGroup;
import id.dana.domain.sendmoney.interactor.DeleteGroup;
import id.dana.sendmoney_v2.landing.contract.ManageAccountContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ManageAccountPresenter_Factory implements Factory<ManageAccountPresenter> {
    private final Provider<GetMaxFavoriteAccount> BuiltInFictitiousFunctionClassFactory;
    private final Provider<RemoveRecentSavedBank> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<DeleteGroup> PlaceComponentResult;
    private final Provider<RemoveRecentGroup> getAuthRequestContext;
    private final Provider<SaveRecentBank> getErrorConfigVersion;
    private final Provider<RemoveRecentSavedContact> lookAheadTest;
    private final Provider<ManageAccountContract.View> moveToNextValue;

    private ManageAccountPresenter_Factory(Provider<Context> provider, Provider<ManageAccountContract.View> provider2, Provider<SaveRecentBank> provider3, Provider<RemoveRecentSavedBank> provider4, Provider<RemoveRecentSavedContact> provider5, Provider<RemoveRecentGroup> provider6, Provider<GetMaxFavoriteAccount> provider7, Provider<DeleteGroup> provider8) {
        this.MyBillsEntityDataFactory = provider;
        this.moveToNextValue = provider2;
        this.getErrorConfigVersion = provider3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider4;
        this.lookAheadTest = provider5;
        this.getAuthRequestContext = provider6;
        this.BuiltInFictitiousFunctionClassFactory = provider7;
        this.PlaceComponentResult = provider8;
    }

    public static ManageAccountPresenter_Factory PlaceComponentResult(Provider<Context> provider, Provider<ManageAccountContract.View> provider2, Provider<SaveRecentBank> provider3, Provider<RemoveRecentSavedBank> provider4, Provider<RemoveRecentSavedContact> provider5, Provider<RemoveRecentGroup> provider6, Provider<GetMaxFavoriteAccount> provider7, Provider<DeleteGroup> provider8) {
        return new ManageAccountPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ManageAccountPresenter(this.MyBillsEntityDataFactory.get(), this.moveToNextValue.get(), this.getErrorConfigVersion.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.lookAheadTest.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
