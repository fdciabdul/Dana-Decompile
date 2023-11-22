package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetListHighlightMyBills_Factory implements Factory<GetListHighlightMyBills> {
    private final Provider<MyBillsRepository> MyBillsEntityDataFactory;

    private GetListHighlightMyBills_Factory(Provider<MyBillsRepository> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static GetListHighlightMyBills_Factory BuiltInFictitiousFunctionClassFactory(Provider<MyBillsRepository> provider) {
        return new GetListHighlightMyBills_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetListHighlightMyBills(this.MyBillsEntityDataFactory.get());
    }
}
