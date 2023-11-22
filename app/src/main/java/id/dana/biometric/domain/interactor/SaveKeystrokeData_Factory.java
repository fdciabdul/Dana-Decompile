package id.dana.biometric.domain.interactor;

import dagger.internal.Factory;
import id.dana.biometric.domain.RiskTrackerRepository;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SaveKeystrokeData_Factory implements Factory<SaveKeystrokeData> {
    private final Provider<RiskTrackerRepository> getAuthRequestContext;

    private SaveKeystrokeData_Factory(Provider<RiskTrackerRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static SaveKeystrokeData_Factory getAuthRequestContext(Provider<RiskTrackerRepository> provider) {
        return new SaveKeystrokeData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveKeystrokeData(this.getAuthRequestContext.get());
    }
}
