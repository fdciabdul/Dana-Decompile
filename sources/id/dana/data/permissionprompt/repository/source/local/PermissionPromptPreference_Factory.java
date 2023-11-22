package id.dana.data.permissionprompt.repository.source.local;

import com.google.gson.Gson;
import dagger.internal.Factory;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PermissionPromptPreference_Factory implements Factory<PermissionPromptPreference> {
    private final Provider<PreferenceFacade> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Gson> MyBillsEntityDataFactory;

    private PermissionPromptPreference_Factory(Provider<PreferenceFacade> provider, Provider<Gson> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static PermissionPromptPreference_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<PreferenceFacade> provider, Provider<Gson> provider2) {
        return new PermissionPromptPreference_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PermissionPromptPreference(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
