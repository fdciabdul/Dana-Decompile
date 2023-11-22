package id.dana.cardbinding.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cardbinding.data.repository.source.network.CardBindingSecureApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes.dex */
public final class CardBindingApiModule_ProvideCardBindingApiFactory implements Factory<CardBindingSecureApi> {
    private final Provider<Retrofit.Builder> BuiltInFictitiousFunctionClassFactory;
    private final CardBindingApiModule MyBillsEntityDataFactory;

    private CardBindingApiModule_ProvideCardBindingApiFactory(CardBindingApiModule cardBindingApiModule, Provider<Retrofit.Builder> provider) {
        this.MyBillsEntityDataFactory = cardBindingApiModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static CardBindingApiModule_ProvideCardBindingApiFactory MyBillsEntityDataFactory(CardBindingApiModule cardBindingApiModule, Provider<Retrofit.Builder> provider) {
        return new CardBindingApiModule_ProvideCardBindingApiFactory(cardBindingApiModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CardBindingSecureApi) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
