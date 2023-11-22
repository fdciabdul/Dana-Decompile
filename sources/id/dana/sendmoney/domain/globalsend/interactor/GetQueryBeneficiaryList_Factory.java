package id.dana.sendmoney.domain.globalsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetQueryBeneficiaryList_Factory implements Factory<GetQueryBeneficiaryList> {
    private final Provider<GlobalSendRepository> MyBillsEntityDataFactory;

    private GetQueryBeneficiaryList_Factory(Provider<GlobalSendRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetQueryBeneficiaryList_Factory MyBillsEntityDataFactory(Provider<GlobalSendRepository> provider) {
        return new GetQueryBeneficiaryList_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetQueryBeneficiaryList(this.MyBillsEntityDataFactory.get());
    }
}
