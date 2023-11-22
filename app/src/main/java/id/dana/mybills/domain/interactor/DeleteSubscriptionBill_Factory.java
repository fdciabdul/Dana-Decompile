package id.dana.mybills.domain.interactor;

import dagger.internal.Factory;
import id.dana.mybills.domain.MyBillsRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DeleteSubscriptionBill_Factory implements Factory<DeleteSubscriptionBill> {
    private final Provider<MyBillsRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private DeleteSubscriptionBill_Factory(Provider<MyBillsRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static DeleteSubscriptionBill_Factory MyBillsEntityDataFactory(Provider<MyBillsRepository> provider) {
        return new DeleteSubscriptionBill_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DeleteSubscriptionBill(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
