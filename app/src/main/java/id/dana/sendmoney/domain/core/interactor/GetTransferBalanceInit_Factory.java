package id.dana.sendmoney.domain.core.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.core.SendMoneyCoreRepository;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class GetTransferBalanceInit_Factory implements Factory<GetTransferBalanceInit> {
    private final Provider<SendMoneyCoreRepository> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetTransferBalanceInit(this.MyBillsEntityDataFactory.get());
    }
}
