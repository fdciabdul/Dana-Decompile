package id.dana.feeds.domain.share.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.share.FeedsShareRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetPreviewActivity_Factory implements Factory<GetPreviewActivity> {
    private final Provider<FeedsConfigRepository> MyBillsEntityDataFactory;
    private final Provider<FeedsShareRepository> getAuthRequestContext;

    private GetPreviewActivity_Factory(Provider<FeedsShareRepository> provider, Provider<FeedsConfigRepository> provider2) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static GetPreviewActivity_Factory MyBillsEntityDataFactory(Provider<FeedsShareRepository> provider, Provider<FeedsConfigRepository> provider2) {
        return new GetPreviewActivity_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetPreviewActivity(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
