package id.dana.social.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.FeedsCommentReportContract;

/* loaded from: classes5.dex */
public final class FeedsCommentReportModule_ProvideViewFactory implements Factory<FeedsCommentReportContract.View> {
    private final FeedsCommentReportModule KClassImpl$Data$declaredNonStaticMembers$2;

    private FeedsCommentReportModule_ProvideViewFactory(FeedsCommentReportModule feedsCommentReportModule) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedsCommentReportModule;
    }

    public static FeedsCommentReportModule_ProvideViewFactory getAuthRequestContext(FeedsCommentReportModule feedsCommentReportModule) {
        return new FeedsCommentReportModule_ProvideViewFactory(feedsCommentReportModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedsCommentReportContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getPlaceComponentResult());
    }
}
