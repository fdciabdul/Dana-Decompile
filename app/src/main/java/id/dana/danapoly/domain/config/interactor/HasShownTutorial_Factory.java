package id.dana.danapoly.domain.config.interactor;

import dagger.internal.Factory;
import id.dana.danapoly.domain.config.DanapolyConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class HasShownTutorial_Factory implements Factory<HasShownTutorial> {
    private final Provider<DanapolyConfigRepository> PlaceComponentResult;

    private HasShownTutorial_Factory(Provider<DanapolyConfigRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static HasShownTutorial_Factory PlaceComponentResult(Provider<DanapolyConfigRepository> provider) {
        return new HasShownTutorial_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HasShownTutorial(this.PlaceComponentResult.get());
    }
}
