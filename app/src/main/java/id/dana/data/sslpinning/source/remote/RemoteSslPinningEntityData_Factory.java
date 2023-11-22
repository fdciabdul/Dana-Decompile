package id.dana.data.sslpinning.source.remote;

import android.content.Context;
import com.alipay.imobile.network.sslpinning.api.ISSLPinningManager;
import dagger.internal.Factory;
import id.dana.data.network.IOkHttpSSLPinningManager;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class RemoteSslPinningEntityData_Factory implements Factory<RemoteSslPinningEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<IOkHttpSSLPinningManager> okHttpSSLPinningManagerProvider;
    private final Provider<ISSLPinningManager> sslPinningManagerProvider;

    public RemoteSslPinningEntityData_Factory(Provider<Context> provider, Provider<ISSLPinningManager> provider2, Provider<IOkHttpSSLPinningManager> provider3) {
        this.contextProvider = provider;
        this.sslPinningManagerProvider = provider2;
        this.okHttpSSLPinningManagerProvider = provider3;
    }

    @Override // javax.inject.Provider
    public final RemoteSslPinningEntityData get() {
        return newInstance(this.contextProvider.get(), this.sslPinningManagerProvider.get(), this.okHttpSSLPinningManagerProvider.get());
    }

    public static RemoteSslPinningEntityData_Factory create(Provider<Context> provider, Provider<ISSLPinningManager> provider2, Provider<IOkHttpSSLPinningManager> provider3) {
        return new RemoteSslPinningEntityData_Factory(provider, provider2, provider3);
    }

    public static RemoteSslPinningEntityData newInstance(Context context, ISSLPinningManager iSSLPinningManager, IOkHttpSSLPinningManager iOkHttpSSLPinningManager) {
        return new RemoteSslPinningEntityData(context, iSSLPinningManager, iOkHttpSSLPinningManager);
    }
}
