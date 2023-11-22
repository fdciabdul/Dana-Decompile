package id.dana.cashier.data.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CashierPreference_Factory implements Factory<CashierPreference> {
    private final Provider<Context> contextProvider;

    public CashierPreference_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CashierPreference get() {
        return newInstance(this.contextProvider.get());
    }

    public static CashierPreference_Factory create(Provider<Context> provider) {
        return new CashierPreference_Factory(provider);
    }

    public static CashierPreference newInstance(Context context) {
        return new CashierPreference(context);
    }
}
