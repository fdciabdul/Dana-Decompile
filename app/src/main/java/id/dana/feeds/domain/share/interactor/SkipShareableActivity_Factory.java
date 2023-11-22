package id.dana.feeds.domain.share.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SkipShareableActivity_Factory implements Factory<SkipShareableActivity> {
    private final Provider<FeedsShareRepository> MyBillsEntityDataFactory;

    private SkipShareableActivity_Factory(Provider<FeedsShareRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static SkipShareableActivity_Factory MyBillsEntityDataFactory(Provider<FeedsShareRepository> provider) {
        return new SkipShareableActivity_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SkipShareableActivity(this.MyBillsEntityDataFactory.get());
    }
}
