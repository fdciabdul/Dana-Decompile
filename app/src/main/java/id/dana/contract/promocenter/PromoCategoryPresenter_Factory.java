package id.dana.contract.promocenter;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.contract.promocenter.PromoCategoryContract;
import id.dana.domain.promocenter.interactor.GetPromoCategoryList;
import id.dana.promocenter.mapper.CategoryModelMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PromoCategoryPresenter_Factory implements Factory<PromoCategoryPresenter> {
    private final Provider<CategoryModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PromoCategoryContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<GetPromoCategoryList> getAuthRequestContext;

    private PromoCategoryPresenter_Factory(Provider<PromoCategoryContract.View> provider, Provider<GetPromoCategoryList> provider2, Provider<CategoryModelMapper> provider3, Provider<Context> provider4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.PlaceComponentResult = provider4;
    }

    public static PromoCategoryPresenter_Factory getAuthRequestContext(Provider<PromoCategoryContract.View> provider, Provider<GetPromoCategoryList> provider2, Provider<CategoryModelMapper> provider3, Provider<Context> provider4) {
        return new PromoCategoryPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PromoCategoryPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
