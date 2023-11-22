package id.dana.domain.otp.interactor;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ReceiveSmsFlow_Factory implements Factory<ReceiveSmsFlow> {
    private final Provider<ReceiveSms> receiveSmsProvider;

    public ReceiveSmsFlow_Factory(Provider<ReceiveSms> provider) {
        this.receiveSmsProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ReceiveSmsFlow get() {
        return newInstance(this.receiveSmsProvider.get());
    }

    public static ReceiveSmsFlow_Factory create(Provider<ReceiveSms> provider) {
        return new ReceiveSmsFlow_Factory(provider);
    }

    public static ReceiveSmsFlow newInstance(ReceiveSms receiveSms) {
        return new ReceiveSmsFlow(receiveSms);
    }
}
