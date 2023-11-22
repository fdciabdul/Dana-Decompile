package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class UpdateSubscriptionBill_Factory implements Factory<UpdateSubscriptionBill> {
    private final Provider<MyBillsRepository> BuiltInFictitiousFunctionClassFactory;

    private UpdateSubscriptionBill_Factory(Provider<MyBillsRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static UpdateSubscriptionBill_Factory PlaceComponentResult(Provider<MyBillsRepository> provider) {
        return new UpdateSubscriptionBill_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UpdateSubscriptionBill(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
