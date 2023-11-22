package id.dana.cashier.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cashier.data.repository.source.network.CashierSecureApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes.dex */
public final class CashierApiModule_ProvideSecureCashierApiFactory implements Factory<CashierSecureApi> {
    private final Provider<Retrofit.Builder> builderProvider;
    private final CashierApiModule module;

    public CashierApiModule_ProvideSecureCashierApiFactory(CashierApiModule cashierApiModule, Provider<Retrofit.Builder> provider) {
        this.module = cashierApiModule;
        this.builderProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CashierSecureApi get() {
        return provideSecureCashierApi(this.module, this.builderProvider.get());
    }

    public static CashierApiModule_ProvideSecureCashierApiFactory create(CashierApiModule cashierApiModule, Provider<Retrofit.Builder> provider) {
        return new CashierApiModule_ProvideSecureCashierApiFactory(cashierApiModule, provider);
    }

    public static CashierSecureApi provideSecureCashierApi(CashierApiModule cashierApiModule, Retrofit.Builder builder) {
        return (CashierSecureApi) Preconditions.BuiltInFictitiousFunctionClassFactory(cashierApiModule.provideSecureCashierApi(builder));
    }
}
