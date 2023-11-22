package id.dana.sendmoney.domain.globalsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetMaxBeneficiaryPageSize_Factory implements Factory<GetMaxBeneficiaryPageSize> {
    private final Provider<GlobalSendRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private GetMaxBeneficiaryPageSize_Factory(Provider<GlobalSendRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static GetMaxBeneficiaryPageSize_Factory getAuthRequestContext(Provider<GlobalSendRepository> provider) {
        return new GetMaxBeneficiaryPageSize_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetMaxBeneficiaryPageSize(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
