package id.dana.sendmoney.domain.globalsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class SaveSortBeneficiaryList_Factory implements Factory<SaveSortBeneficiaryList> {
    private final Provider<GlobalSendRepository> BuiltInFictitiousFunctionClassFactory;

    private SaveSortBeneficiaryList_Factory(Provider<GlobalSendRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static SaveSortBeneficiaryList_Factory MyBillsEntityDataFactory(Provider<GlobalSendRepository> provider) {
        return new SaveSortBeneficiaryList_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SaveSortBeneficiaryList(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
