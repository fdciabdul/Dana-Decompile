package id.dana.danapoly.domain.config.interactor;

import dagger.internal.Factory;
import id.dana.danapoly.domain.config.DanapolyConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveShownTutorial_Factory implements Factory<SaveShownTutorial> {
    private final Provider<DanapolyConfigRepository> PlaceComponentResult;

    private SaveShownTutorial_Factory(Provider<DanapolyConfigRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static SaveShownTutorial_Factory getAuthRequestContext(Provider<DanapolyConfigRepository> provider) {
        return new SaveShownTutorial_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveShownTutorial(this.PlaceComponentResult.get());
    }
}
