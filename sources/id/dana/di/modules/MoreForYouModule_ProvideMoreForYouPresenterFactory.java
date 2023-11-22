package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.richview.moreforyou.MoreForYouContract;
import id.dana.richview.moreforyou.MoreForYouPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class MoreForYouModule_ProvideMoreForYouPresenterFactory implements Factory<MoreForYouContract.Presenter> {
    private final Provider<MoreForYouPresenter> MyBillsEntityDataFactory;
    private final MoreForYouModule getAuthRequestContext;

    private MoreForYouModule_ProvideMoreForYouPresenterFactory(MoreForYouModule moreForYouModule, Provider<MoreForYouPresenter> provider) {
        this.getAuthRequestContext = moreForYouModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static MoreForYouModule_ProvideMoreForYouPresenterFactory MyBillsEntityDataFactory(MoreForYouModule moreForYouModule, Provider<MoreForYouPresenter> provider) {
        return new MoreForYouModule_ProvideMoreForYouPresenterFactory(moreForYouModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MoreForYouContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.MyBillsEntityDataFactory.get()));
    }
}
