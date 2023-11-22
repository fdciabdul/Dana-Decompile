package id.dana.savings.presenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.saving.interactor.InitSavingUpdate;
import id.dana.domain.saving.interactor.UpdateSaving;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.savings.contract.SavingUpdateContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SavingUpdatePresenter_Factory implements Factory<SavingUpdatePresenter> {
    private final Provider<UpdateSaving> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<InitSavingUpdate> MyBillsEntityDataFactory;
    private final Provider<SavingUpdateContract.View> PlaceComponentResult;
    private final Provider<GetUserInfoWithKyc> getAuthRequestContext;

    private SavingUpdatePresenter_Factory(Provider<Context> provider, Provider<SavingUpdateContract.View> provider2, Provider<InitSavingUpdate> provider3, Provider<UpdateSaving> provider4, Provider<GetUserInfoWithKyc> provider5) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.PlaceComponentResult = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.getAuthRequestContext = provider5;
    }

    public static SavingUpdatePresenter_Factory PlaceComponentResult(Provider<Context> provider, Provider<SavingUpdateContract.View> provider2, Provider<InitSavingUpdate> provider3, Provider<UpdateSaving> provider4, Provider<GetUserInfoWithKyc> provider5) {
        return new SavingUpdatePresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SavingUpdatePresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}
