package id.dana.savings.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.saving.interactor.GetSavingDetail;
import id.dana.domain.saving.interactor.RevokeSaving;
import id.dana.savings.contract.SavingDetailContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SavingDetailPresenter_Factory implements Factory<SavingDetailPresenter> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetSavingDetail> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<RevokeSaving> MyBillsEntityDataFactory;
    private final Provider<SavingDetailContract.View> getAuthRequestContext;

    private SavingDetailPresenter_Factory(Provider<Context> provider, Provider<SavingDetailContract.View> provider2, Provider<GetSavingDetail> provider3, Provider<RevokeSaving> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static SavingDetailPresenter_Factory PlaceComponentResult(Provider<Context> provider, Provider<SavingDetailContract.View> provider2, Provider<GetSavingDetail> provider3, Provider<RevokeSaving> provider4) {
        return new SavingDetailPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SavingDetailPresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
