package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class ValidateFormUseCase_Factory implements Factory<ValidateFormUseCase> {
    public static ValidateFormUseCase_Factory BuiltInFictitiousFunctionClassFactory() {
        return InstanceHolder.getAuthRequestContext;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final ValidateFormUseCase_Factory getAuthRequestContext = new ValidateFormUseCase_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ValidateFormUseCase();
    }
}
