package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.MyFeedsContract;
import id.dana.social.contract.MyFeedsPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyFeedsModule_ProvideMyFeedsPresenterFactory implements Factory<MyFeedsContract.Presenter> {
    private final Provider<MyFeedsPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final MyFeedsModule MyBillsEntityDataFactory;

    private MyFeedsModule_ProvideMyFeedsPresenterFactory(MyFeedsModule myFeedsModule, Provider<MyFeedsPresenter> provider) {
        this.MyBillsEntityDataFactory = myFeedsModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static MyFeedsModule_ProvideMyFeedsPresenterFactory KClassImpl$Data$declaredNonStaticMembers$2(MyFeedsModule myFeedsModule, Provider<MyFeedsPresenter> provider) {
        return new MyFeedsModule_ProvideMyFeedsPresenterFactory(myFeedsModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MyFeedsContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
