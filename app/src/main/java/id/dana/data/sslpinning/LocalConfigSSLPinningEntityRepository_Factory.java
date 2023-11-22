package id.dana.data.sslpinning;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.network.IOkHttpSSLPinningManager;
import id.dana.data.sslpinning.source.SslPinningEntityDataFactory;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalConfigSSLPinningEntityRepository_Factory implements Factory<LocalConfigSSLPinningEntityRepository> {
    private final Provider<IOkHttpSSLPinningManager> okHttpSSLPinningManagerProvider;
    private final Provider<SharedPrefStartupConfig> sharedPrefStartupConfigProvider;
    private final Provider<SplitConfigEntityData> splitConfigEntityDataProvider;
    private final Provider<SslPinningEntityDataFactory> sslPinningEntityDataFactoryProvider;
    private final Provider<ThreadExecutor> threadExecutorProvider;

    public LocalConfigSSLPinningEntityRepository_Factory(Provider<SslPinningEntityDataFactory> provider, Provider<SharedPrefStartupConfig> provider2, Provider<ThreadExecutor> provider3, Provider<IOkHttpSSLPinningManager> provider4, Provider<SplitConfigEntityData> provider5) {
        this.sslPinningEntityDataFactoryProvider = provider;
        this.sharedPrefStartupConfigProvider = provider2;
        this.threadExecutorProvider = provider3;
        this.okHttpSSLPinningManagerProvider = provider4;
        this.splitConfigEntityDataProvider = provider5;
    }

    @Override // javax.inject.Provider
    public final LocalConfigSSLPinningEntityRepository get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.sslPinningEntityDataFactoryProvider), DoubleCheck.MyBillsEntityDataFactory(this.sharedPrefStartupConfigProvider), this.threadExecutorProvider.get(), DoubleCheck.MyBillsEntityDataFactory(this.okHttpSSLPinningManagerProvider), DoubleCheck.MyBillsEntityDataFactory(this.splitConfigEntityDataProvider));
    }

    public static LocalConfigSSLPinningEntityRepository_Factory create(Provider<SslPinningEntityDataFactory> provider, Provider<SharedPrefStartupConfig> provider2, Provider<ThreadExecutor> provider3, Provider<IOkHttpSSLPinningManager> provider4, Provider<SplitConfigEntityData> provider5) {
        return new LocalConfigSSLPinningEntityRepository_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static LocalConfigSSLPinningEntityRepository newInstance(Lazy<SslPinningEntityDataFactory> lazy, Lazy<SharedPrefStartupConfig> lazy2, ThreadExecutor threadExecutor, Lazy<IOkHttpSSLPinningManager> lazy3, Lazy<SplitConfigEntityData> lazy4) {
        return new LocalConfigSSLPinningEntityRepository(lazy, lazy2, threadExecutor, lazy3, lazy4);
    }
}
