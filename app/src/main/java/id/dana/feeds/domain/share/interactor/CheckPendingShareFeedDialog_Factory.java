package id.dana.feeds.domain.share.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class CheckPendingShareFeedDialog_Factory implements Factory<CheckPendingShareFeedDialog> {
    private final Provider<FeedsShareRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private CheckPendingShareFeedDialog_Factory(Provider<FeedsShareRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static CheckPendingShareFeedDialog_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<FeedsShareRepository> provider) {
        return new CheckPendingShareFeedDialog_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CheckPendingShareFeedDialog(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
