package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.FeedsCommentReportContract;
import id.dana.social.presenter.FeedsCommentReportPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FeedsCommentReportModule_ProvidePresenterFactory implements Factory<FeedsCommentReportContract.Presenter> {
    private final FeedsCommentReportModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedsCommentReportPresenter> getAuthRequestContext;

    private FeedsCommentReportModule_ProvidePresenterFactory(FeedsCommentReportModule feedsCommentReportModule, Provider<FeedsCommentReportPresenter> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedsCommentReportModule;
        this.getAuthRequestContext = provider;
    }

    public static FeedsCommentReportModule_ProvidePresenterFactory MyBillsEntityDataFactory(FeedsCommentReportModule feedsCommentReportModule, Provider<FeedsCommentReportPresenter> provider) {
        return new FeedsCommentReportModule_ProvidePresenterFactory(feedsCommentReportModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedsCommentReportContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
