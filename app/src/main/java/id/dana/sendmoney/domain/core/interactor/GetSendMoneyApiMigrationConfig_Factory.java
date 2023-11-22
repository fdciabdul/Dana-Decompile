package id.dana.sendmoney.domain.core.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.core.SendMoneyCoreRepository;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class GetSendMoneyApiMigrationConfig_Factory implements Factory<GetSendMoneyApiMigrationConfig> {
    private final Provider<SendMoneyCoreRepository> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetSendMoneyApiMigrationConfig(this.getAuthRequestContext.get());
    }
}
