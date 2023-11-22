package id.dana.data.sendmoney.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SortingSendMoneyPreference_Factory implements Factory<SortingSendMoneyPreference> {
    private final Provider<Context> contextProvider;

    public SortingSendMoneyPreference_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SortingSendMoneyPreference get() {
        return newInstance(this.contextProvider.get());
    }

    public static SortingSendMoneyPreference_Factory create(Provider<Context> provider) {
        return new SortingSendMoneyPreference_Factory(provider);
    }

    public static SortingSendMoneyPreference newInstance(Context context) {
        return new SortingSendMoneyPreference(context);
    }
}
