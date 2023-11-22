package id.dana.domain.permissionprompt.interactor;

import dagger.internal.Factory;
import id.dana.domain.permissionprompt.PermissionPromptRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveNumberOfLocationPermissionShownData_Factory implements Factory<SaveNumberOfLocationPermissionShownData> {
    private final Provider<PermissionPromptRepository> permissionPromptRepositoryProvider;

    public SaveNumberOfLocationPermissionShownData_Factory(Provider<PermissionPromptRepository> provider) {
        this.permissionPromptRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveNumberOfLocationPermissionShownData get() {
        return newInstance(this.permissionPromptRepositoryProvider.get());
    }

    public static SaveNumberOfLocationPermissionShownData_Factory create(Provider<PermissionPromptRepository> provider) {
        return new SaveNumberOfLocationPermissionShownData_Factory(provider);
    }

    public static SaveNumberOfLocationPermissionShownData newInstance(PermissionPromptRepository permissionPromptRepository) {
        return new SaveNumberOfLocationPermissionShownData(permissionPromptRepository);
    }
}
