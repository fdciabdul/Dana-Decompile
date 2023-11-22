package id.dana.data.promotion.repository.source.persistence;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PromoPreference_Factory implements Factory<PromoPreference> {
    private final Provider<Context> contextProvider;

    public PromoPreference_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PromoPreference get() {
        return newInstance(this.contextProvider.get());
    }

    public static PromoPreference_Factory create(Provider<Context> provider) {
        return new PromoPreference_Factory(provider);
    }

    public static PromoPreference newInstance(Context context) {
        return new PromoPreference(context);
    }
}
