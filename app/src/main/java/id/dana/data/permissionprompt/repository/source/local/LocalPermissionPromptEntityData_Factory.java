package id.dana.data.permissionprompt.repository.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalPermissionPromptEntityData_Factory implements Factory<LocalPermissionPromptEntityData> {
    private final Provider<PermissionPromptPreference> PlaceComponentResult;

    private LocalPermissionPromptEntityData_Factory(Provider<PermissionPromptPreference> provider) {
        this.PlaceComponentResult = provider;
    }

    public static LocalPermissionPromptEntityData_Factory getAuthRequestContext(Provider<PermissionPromptPreference> provider) {
        return new LocalPermissionPromptEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LocalPermissionPromptEntityData(this.PlaceComponentResult.get());
    }
}
