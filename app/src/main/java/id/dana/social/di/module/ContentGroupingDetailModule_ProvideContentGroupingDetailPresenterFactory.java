package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.ContentGroupingDetailContract;
import id.dana.social.presenter.ContentGroupingDetailPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ContentGroupingDetailModule_ProvideContentGroupingDetailPresenterFactory implements Factory<ContentGroupingDetailContract.Presenter> {
    private final ContentGroupingDetailModule MyBillsEntityDataFactory;
    private final Provider<ContentGroupingDetailPresenter> PlaceComponentResult;

    public static ContentGroupingDetailContract.Presenter MyBillsEntityDataFactory(ContentGroupingDetailModule contentGroupingDetailModule, ContentGroupingDetailPresenter contentGroupingDetailPresenter) {
        return (ContentGroupingDetailContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(contentGroupingDetailModule.KClassImpl$Data$declaredNonStaticMembers$2(contentGroupingDetailPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ContentGroupingDetailContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
