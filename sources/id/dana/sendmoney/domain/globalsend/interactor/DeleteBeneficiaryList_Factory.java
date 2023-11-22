package id.dana.sendmoney.domain.globalsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DeleteBeneficiaryList_Factory implements Factory<DeleteBeneficiaryList> {
    private final Provider<GlobalSendRepository> getAuthRequestContext;

    private DeleteBeneficiaryList_Factory(Provider<GlobalSendRepository> provider) {
        this.getAuthRequestContext = provider;
    }

    public static DeleteBeneficiaryList_Factory getAuthRequestContext(Provider<GlobalSendRepository> provider) {
        return new DeleteBeneficiaryList_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DeleteBeneficiaryList(this.getAuthRequestContext.get());
    }
}
