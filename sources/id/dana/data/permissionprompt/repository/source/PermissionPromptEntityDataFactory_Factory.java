package id.dana.data.permissionprompt.repository.source;

import dagger.internal.Factory;
import id.dana.data.permissionprompt.repository.PermissionPromptEntityData;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PermissionPromptEntityDataFactory_Factory implements Factory<PermissionPromptEntityDataFactory> {
    private final Provider<PermissionPromptEntityData> BuiltInFictitiousFunctionClassFactory;

    private PermissionPromptEntityDataFactory_Factory(Provider<PermissionPromptEntityData> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static PermissionPromptEntityDataFactory_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<PermissionPromptEntityData> provider) {
        return new PermissionPromptEntityDataFactory_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PermissionPromptEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
