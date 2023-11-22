package id.dana.sendmoney.domain.groupsend.interactor;

import dagger.internal.Factory;
import id.dana.domain.account.AccountRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetPhoneNumber_Factory implements Factory<GetPhoneNumber> {
    private final Provider<AccountRepository> PlaceComponentResult;

    private GetPhoneNumber_Factory(Provider<AccountRepository> provider) {
        this.PlaceComponentResult = provider;
    }

    public static GetPhoneNumber_Factory MyBillsEntityDataFactory(Provider<AccountRepository> provider) {
        return new GetPhoneNumber_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetPhoneNumber(this.PlaceComponentResult.get());
    }
}
