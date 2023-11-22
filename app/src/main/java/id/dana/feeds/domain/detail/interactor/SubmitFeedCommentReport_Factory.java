package id.dana.feeds.domain.detail.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.detail.FeedsDetailRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SubmitFeedCommentReport_Factory implements Factory<SubmitFeedCommentReport> {
    private final Provider<MixpanelRepository> BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsDetailRepository> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SubmitFeedCommentReport(this.MyBillsEntityDataFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
