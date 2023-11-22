package id.dana.domain.permissionprompt.interactor;

import dagger.internal.Factory;
import id.dana.domain.permissionprompt.PermissionPromptRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckLocationPermissionPromptFeature_Factory implements Factory<CheckLocationPermissionPromptFeature> {
    private final Provider<PermissionPromptRepository> permissionPromptRepositoryProvider;

    public CheckLocationPermissionPromptFeature_Factory(Provider<PermissionPromptRepository> provider) {
        this.permissionPromptRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckLocationPermissionPromptFeature get() {
        return newInstance(this.permissionPromptRepositoryProvider.get());
    }

    public static CheckLocationPermissionPromptFeature_Factory create(Provider<PermissionPromptRepository> provider) {
        return new CheckLocationPermissionPromptFeature_Factory(provider);
    }

    public static CheckLocationPermissionPromptFeature newInstance(PermissionPromptRepository permissionPromptRepository) {
        return new CheckLocationPermissionPromptFeature(permissionPromptRepository);
    }
}
