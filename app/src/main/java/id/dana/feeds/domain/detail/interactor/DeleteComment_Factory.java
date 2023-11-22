package id.dana.feeds.domain.detail.interactor;

import dagger.internal.Factory;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.detail.FeedsDetailRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class DeleteComment_Factory implements Factory<DeleteComment> {
    private final Provider<MixpanelRepository> MyBillsEntityDataFactory;
    private final Provider<FeedsDetailRepository> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DeleteComment(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
