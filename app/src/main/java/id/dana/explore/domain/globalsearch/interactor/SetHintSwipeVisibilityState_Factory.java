package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SetHintSwipeVisibilityState_Factory implements Factory<SetHintSwipeVisibilityState> {
    private final Provider<GlobalSearchRepository> getAuthRequestContext;

    private SetHintSwipeVisibilityState_Factory(Provider<GlobalSearchRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static SetHintSwipeVisibilityState_Factory BuiltInFictitiousFunctionClassFactory(Provider<GlobalSearchRepository> provider) {
        return new SetHintSwipeVisibilityState_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SetHintSwipeVisibilityState(this.getAuthRequestContext.get());
    }
}
