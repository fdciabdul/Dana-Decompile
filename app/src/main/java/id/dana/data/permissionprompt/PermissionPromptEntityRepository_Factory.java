package id.dana.data.permissionprompt;

import dagger.internal.Factory;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.permissionprompt.repository.source.PermissionPromptEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PermissionPromptEntityRepository_Factory implements Factory<PermissionPromptEntityRepository> {
    private final Provider<PermissionPromptEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ConfigEntityDataFactory> MyBillsEntityDataFactory;

    private PermissionPromptEntityRepository_Factory(Provider<ConfigEntityDataFactory> provider, Provider<PermissionPromptEntityDataFactory> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static PermissionPromptEntityRepository_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<ConfigEntityDataFactory> provider, Provider<PermissionPromptEntityDataFactory> provider2) {
        return new PermissionPromptEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PermissionPromptEntityRepository(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
