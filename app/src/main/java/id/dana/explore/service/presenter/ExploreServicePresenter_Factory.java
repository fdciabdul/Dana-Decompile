package id.dana.explore.service.presenter;

import dagger.internal.Factory;
import id.dana.explore.domain.sku.interactor.GetCategoryExploreDana;
import id.dana.explore.service.ExploreServiceContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class ExploreServicePresenter_Factory implements Factory<ExploreServicePresenter> {
    private final Provider<ExploreServiceContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetCategoryExploreDana> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ExploreServicePresenter(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
