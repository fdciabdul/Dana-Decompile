package id.dana.social.presenter;

import dagger.internal.Factory;
import id.dana.feeds.domain.config.interactor.GetReportReasonsConfig;
import id.dana.social.contract.FeedsCommentReportContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class FeedsCommentReportPresenter_Factory implements Factory<FeedsCommentReportPresenter> {
    private final Provider<GetReportReasonsConfig> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedsCommentReportContract.View> MyBillsEntityDataFactory;

    private FeedsCommentReportPresenter_Factory(Provider<FeedsCommentReportContract.View> provider, Provider<GetReportReasonsConfig> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static FeedsCommentReportPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<FeedsCommentReportContract.View> provider, Provider<GetReportReasonsConfig> provider2) {
        return new FeedsCommentReportPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsCommentReportPresenter(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
