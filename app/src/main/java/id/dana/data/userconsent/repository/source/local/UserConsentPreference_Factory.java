package id.dana.data.userconsent.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserConsentPreference_Factory implements Factory<UserConsentPreference> {
    private final Provider<Context> MyBillsEntityDataFactory;

    private UserConsentPreference_Factory(Provider<Context> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static UserConsentPreference_Factory MyBillsEntityDataFactory(Provider<Context> provider) {
        return new UserConsentPreference_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserConsentPreference(this.MyBillsEntityDataFactory.get());
    }
}
