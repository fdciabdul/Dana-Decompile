package id.dana.danapoly.domain.config.interactor;

import dagger.internal.Factory;
import id.dana.danapoly.domain.config.DanapolyConfigRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveLastBackgroundColor_Factory implements Factory<SaveLastBackgroundColor> {
    private final Provider<DanapolyConfigRepository> getAuthRequestContext;

    private SaveLastBackgroundColor_Factory(Provider<DanapolyConfigRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static SaveLastBackgroundColor_Factory MyBillsEntityDataFactory(Provider<DanapolyConfigRepository> provider) {
        return new SaveLastBackgroundColor_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveLastBackgroundColor(this.getAuthRequestContext.get());
    }
}
