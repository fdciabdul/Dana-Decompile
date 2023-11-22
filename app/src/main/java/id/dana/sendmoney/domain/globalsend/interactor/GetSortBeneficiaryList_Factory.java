package id.dana.sendmoney.domain.globalsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetSortBeneficiaryList_Factory implements Factory<GetSortBeneficiaryList> {
    private final Provider<GlobalSendRepository> getAuthRequestContext;

    private GetSortBeneficiaryList_Factory(Provider<GlobalSendRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static GetSortBeneficiaryList_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GlobalSendRepository> provider) {
        return new GetSortBeneficiaryList_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetSortBeneficiaryList(this.getAuthRequestContext.get());
    }
}
