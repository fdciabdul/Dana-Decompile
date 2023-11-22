package id.dana.data.permissionprompt.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PermissionPromptModule_ProvidePermissionPromptPreferenceFactory implements Factory<PreferenceFacade> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Serializer> PlaceComponentResult;

    private PermissionPromptModule_ProvidePermissionPromptPreferenceFactory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static PermissionPromptModule_ProvidePermissionPromptPreferenceFactory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<Serializer> provider2) {
        return new PermissionPromptModule_ProvidePermissionPromptPreferenceFactory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PreferenceFacade) Preconditions.BuiltInFictitiousFunctionClassFactory(PermissionPromptModule.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get()));
    }
}
