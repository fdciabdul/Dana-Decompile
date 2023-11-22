package id.dana.domain.danah5.interactor;

import dagger.internal.Factory;
import id.dana.domain.danah5.H5Repository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class OpenH5_Factory implements Factory<OpenH5> {
    private final Provider<H5Repository> repositoryProvider;

    public OpenH5_Factory(Provider<H5Repository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final OpenH5 get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static OpenH5_Factory create(Provider<H5Repository> provider) {
        return new OpenH5_Factory(provider);
    }

    public static OpenH5 newInstance(H5Repository h5Repository) {
        return new OpenH5(h5Repository);
    }
}
