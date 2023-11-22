package id.dana.sendmoney.data.repository.globalsend.source.local;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalGlobalSendEntityData_Factory implements Factory<LocalGlobalSendEntityData> {
    private final Provider<GlobalSendPreference> getAuthRequestContext;

    private LocalGlobalSendEntityData_Factory(Provider<GlobalSendPreference> provider) {
        this.getAuthRequestContext = provider;
    }

    public static LocalGlobalSendEntityData_Factory getAuthRequestContext(Provider<GlobalSendPreference> provider) {
        return new LocalGlobalSendEntityData_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LocalGlobalSendEntityData(this.getAuthRequestContext.get());
    }
}
