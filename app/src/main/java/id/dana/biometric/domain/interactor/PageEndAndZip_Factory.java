package id.dana.biometric.domain.interactor;

import dagger.internal.Factory;
import id.dana.biometric.domain.RiskTrackerRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class PageEndAndZip_Factory implements Factory<PageEndAndZip> {
    private final Provider<RiskTrackerRepository> getAuthRequestContext;

    private PageEndAndZip_Factory(Provider<RiskTrackerRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static PageEndAndZip_Factory BuiltInFictitiousFunctionClassFactory(Provider<RiskTrackerRepository> provider) {
        return new PageEndAndZip_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PageEndAndZip(this.getAuthRequestContext.get());
    }
}
