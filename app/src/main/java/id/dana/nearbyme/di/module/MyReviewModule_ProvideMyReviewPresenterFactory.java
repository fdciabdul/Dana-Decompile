package id.dana.nearbyme.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.nearbyme.MyReviewContract;
import id.dana.contract.nearbyme.MyReviewPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MyReviewModule_ProvideMyReviewPresenterFactory implements Factory<MyReviewContract.Presenter> {
    private final MyReviewModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<MyReviewPresenter> getAuthRequestContext;

    private MyReviewModule_ProvideMyReviewPresenterFactory(MyReviewModule myReviewModule, Provider<MyReviewPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = myReviewModule;
        this.getAuthRequestContext = provider;
    }

    public static MyReviewModule_ProvideMyReviewPresenterFactory getAuthRequestContext(MyReviewModule myReviewModule, Provider<MyReviewPresenter> provider) {
        return new MyReviewModule_ProvideMyReviewPresenterFactory(myReviewModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MyReviewContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.get()));
    }
}
