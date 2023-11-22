package id.dana.data.sendmoney.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SendMoneyPreference_Factory implements Factory<SendMoneyPreference> {
    private final Provider<Context> contextProvider;

    public SendMoneyPreference_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SendMoneyPreference get() {
        return newInstance(this.contextProvider.get());
    }

    public static SendMoneyPreference_Factory create(Provider<Context> provider) {
        return new SendMoneyPreference_Factory(provider);
    }

    public static SendMoneyPreference newInstance(Context context) {
        return new SendMoneyPreference(context);
    }
}
