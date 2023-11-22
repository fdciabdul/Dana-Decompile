package id.dana.sendmoney.domain.globalsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class GetSenderDetail_Factory implements Factory<GetSenderDetail> {
    private final Provider<GlobalSendRepository> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetSenderDetail(this.MyBillsEntityDataFactory.get());
    }
}
