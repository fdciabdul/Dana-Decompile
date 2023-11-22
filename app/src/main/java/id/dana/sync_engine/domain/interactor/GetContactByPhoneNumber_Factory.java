package id.dana.sync_engine.domain.interactor;

import dagger.internal.Factory;
import id.dana.sync_engine.domain.ContactRepository;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class GetContactByPhoneNumber_Factory implements Factory<GetContactByPhoneNumber> {
    private final Provider<ContactRepository> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetContactByPhoneNumber(this.MyBillsEntityDataFactory.get());
    }
}
