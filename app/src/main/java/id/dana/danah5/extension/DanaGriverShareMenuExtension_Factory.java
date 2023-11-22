package id.dana.danah5.extension;

import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DanaGriverShareMenuExtension_Factory implements Factory<DanaGriverShareMenuExtension> {
    private final Provider<SplitFacade> splitFacadeProvider;

    public DanaGriverShareMenuExtension_Factory(Provider<SplitFacade> provider) {
        this.splitFacadeProvider = provider;
    }

    @Override // javax.inject.Provider
    public final DanaGriverShareMenuExtension get() {
        return newInstance(this.splitFacadeProvider.get());
    }

    public static DanaGriverShareMenuExtension_Factory create(Provider<SplitFacade> provider) {
        return new DanaGriverShareMenuExtension_Factory(provider);
    }

    public static DanaGriverShareMenuExtension newInstance(SplitFacade splitFacade) {
        return new DanaGriverShareMenuExtension(splitFacade);
    }
}
