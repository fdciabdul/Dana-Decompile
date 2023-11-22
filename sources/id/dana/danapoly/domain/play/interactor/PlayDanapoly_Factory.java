package id.dana.danapoly.domain.play.interactor;

import dagger.internal.Factory;
import id.dana.danapoly.domain.config.DanapolyConfigRepository;
import id.dana.danapoly.domain.play.DanapolyPlayRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PlayDanapoly_Factory implements Factory<PlayDanapoly> {
    private final Provider<DanapolyConfigRepository> PlaceComponentResult;
    private final Provider<DanapolyPlayRepository> getAuthRequestContext;

    private PlayDanapoly_Factory(Provider<DanapolyConfigRepository> provider, Provider<DanapolyPlayRepository> provider2) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
    }

    public static PlayDanapoly_Factory PlaceComponentResult(Provider<DanapolyConfigRepository> provider, Provider<DanapolyPlayRepository> provider2) {
        return new PlayDanapoly_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PlayDanapoly(this.PlaceComponentResult.get(), this.getAuthRequestContext.get());
    }
}
