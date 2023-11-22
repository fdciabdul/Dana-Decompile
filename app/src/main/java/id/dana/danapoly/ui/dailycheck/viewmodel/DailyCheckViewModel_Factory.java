package id.dana.danapoly.ui.dailycheck.viewmodel;

import dagger.internal.Factory;
import id.dana.danapoly.domain.dailycheck.interactor.DoCheckIn;
import id.dana.danapoly.domain.dailycheck.interactor.FetchCheckInHistory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DailyCheckViewModel_Factory implements Factory<DailyCheckViewModel> {
    private final Provider<FetchCheckInHistory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<DoCheckIn> getAuthRequestContext;

    private DailyCheckViewModel_Factory(Provider<FetchCheckInHistory> provider, Provider<DoCheckIn> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
    }

    public static DailyCheckViewModel_Factory getAuthRequestContext(Provider<FetchCheckInHistory> provider, Provider<DoCheckIn> provider2) {
        return new DailyCheckViewModel_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DailyCheckViewModel(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get());
    }
}
