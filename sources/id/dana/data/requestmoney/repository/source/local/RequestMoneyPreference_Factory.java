package id.dana.data.requestmoney.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RequestMoneyPreference_Factory implements Factory<RequestMoneyPreference> {
    private final Provider<Context> contextProvider;

    public RequestMoneyPreference_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RequestMoneyPreference get() {
        return newInstance(this.contextProvider.get());
    }

    public static RequestMoneyPreference_Factory create(Provider<Context> provider) {
        return new RequestMoneyPreference_Factory(provider);
    }

    public static RequestMoneyPreference newInstance(Context context) {
        return new RequestMoneyPreference(context);
    }
}
