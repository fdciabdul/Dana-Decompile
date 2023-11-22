package id.dana.contract.sendmoney.bank;

import dagger.internal.Factory;
import id.dana.contract.sendmoney.bank.SavedBankCardContract;
import id.dana.domain.recentbank.interactor.GetMaxSavedBank;
import id.dana.domain.recentbank.interactor.GetRecentBank;
import id.dana.domain.recentbank.interactor.SearchRecentBank;
import id.dana.sendmoney.mapper.RecentBankModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SavedBankCardPresenter_Factory implements Factory<SavedBankCardPresenter> {
    private final Provider<SearchRecentBank> BuiltInFictitiousFunctionClassFactory;
    private final Provider<RecentBankModelMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetRecentBank> MyBillsEntityDataFactory;
    private final Provider<SavedBankCardContract.View> PlaceComponentResult;
    private final Provider<GetMaxSavedBank> getAuthRequestContext;

    private SavedBankCardPresenter_Factory(Provider<SavedBankCardContract.View> provider, Provider<GetRecentBank> provider2, Provider<GetMaxSavedBank> provider3, Provider<SearchRecentBank> provider4, Provider<RecentBankModelMapper> provider5) {
        this.PlaceComponentResult = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider5;
    }

    public static SavedBankCardPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<SavedBankCardContract.View> provider, Provider<GetRecentBank> provider2, Provider<GetMaxSavedBank> provider3, Provider<SearchRecentBank> provider4, Provider<RecentBankModelMapper> provider5) {
        return new SavedBankCardPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SavedBankCardPresenter(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
