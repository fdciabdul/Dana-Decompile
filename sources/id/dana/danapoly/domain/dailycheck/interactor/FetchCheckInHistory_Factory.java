package id.dana.danapoly.domain.dailycheck.interactor;

import dagger.internal.Factory;
import id.dana.danapoly.domain.dailycheck.DanapolyCheckInRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FetchCheckInHistory_Factory implements Factory<FetchCheckInHistory> {
    private final Provider<DanapolyCheckInRepository> getAuthRequestContext;

    private FetchCheckInHistory_Factory(Provider<DanapolyCheckInRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static FetchCheckInHistory_Factory BuiltInFictitiousFunctionClassFactory(Provider<DanapolyCheckInRepository> provider) {
        return new FetchCheckInHistory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FetchCheckInHistory(this.getAuthRequestContext.get());
    }
}
