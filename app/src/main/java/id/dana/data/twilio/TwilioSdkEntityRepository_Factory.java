package id.dana.data.twilio;

import com.twilio.verify.TwilioVerify;
import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TwilioSdkEntityRepository_Factory implements Factory<TwilioSdkEntityRepository> {
    private final Provider<TwilioVerify> MyBillsEntityDataFactory;
    private final Provider<AccountEntityDataFactory> PlaceComponentResult;

    private TwilioSdkEntityRepository_Factory(Provider<TwilioVerify> provider, Provider<AccountEntityDataFactory> provider2) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
    }

    public static TwilioSdkEntityRepository_Factory PlaceComponentResult(Provider<TwilioVerify> provider, Provider<AccountEntityDataFactory> provider2) {
        return new TwilioSdkEntityRepository_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TwilioSdkEntityRepository(this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get());
    }
}
