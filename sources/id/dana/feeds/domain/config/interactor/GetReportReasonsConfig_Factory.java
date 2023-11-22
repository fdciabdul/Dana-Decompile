package id.dana.feeds.domain.config.interactor;

import dagger.internal.Factory;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetReportReasonsConfig_Factory implements Factory<GetReportReasonsConfig> {
    private final Provider<FeedsConfigRepository> MyBillsEntityDataFactory;

    private GetReportReasonsConfig_Factory(Provider<FeedsConfigRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetReportReasonsConfig_Factory BuiltInFictitiousFunctionClassFactory(Provider<FeedsConfigRepository> provider) {
        return new GetReportReasonsConfig_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetReportReasonsConfig(this.MyBillsEntityDataFactory.get());
    }
}
