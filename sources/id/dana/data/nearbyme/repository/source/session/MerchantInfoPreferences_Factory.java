package id.dana.data.nearbyme.repository.source.session;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MerchantInfoPreferences_Factory implements Factory<MerchantInfoPreferences> {
    private final Provider<Context> contextProvider;

    public MerchantInfoPreferences_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final MerchantInfoPreferences get() {
        return newInstance(this.contextProvider.get());
    }

    public static MerchantInfoPreferences_Factory create(Provider<Context> provider) {
        return new MerchantInfoPreferences_Factory(provider);
    }

    public static MerchantInfoPreferences newInstance(Context context) {
        return new MerchantInfoPreferences(context);
    }
}
