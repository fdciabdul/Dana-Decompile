package id.dana.sync_engine.domain.interactor;

import dagger.internal.Factory;
import id.dana.sync_engine.domain.ContactRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetConfigRepeatBackgroundJobUseCase_Factory implements Factory<GetConfigRepeatBackgroundJobUseCase> {
    private final Provider<ContactRepository> BuiltInFictitiousFunctionClassFactory;

    private GetConfigRepeatBackgroundJobUseCase_Factory(Provider<ContactRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GetConfigRepeatBackgroundJobUseCase_Factory getAuthRequestContext(Provider<ContactRepository> provider) {
        return new GetConfigRepeatBackgroundJobUseCase_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetConfigRepeatBackgroundJobUseCase(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
