package id.dana.sendmoney.di.module.globalsend;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.sendmoney.data.repository.globalsend.source.network.GlobalSendSecureApi;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes2.dex */
public final class GlobalSendApiModule_ProvideGlobalSendApiFactory implements Factory<GlobalSendSecureApi> {
    private final Provider<Retrofit.Builder> BuiltInFictitiousFunctionClassFactory;
    private final GlobalSendApiModule getAuthRequestContext;

    private GlobalSendApiModule_ProvideGlobalSendApiFactory(GlobalSendApiModule globalSendApiModule, Provider<Retrofit.Builder> provider) {
        this.getAuthRequestContext = globalSendApiModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GlobalSendApiModule_ProvideGlobalSendApiFactory BuiltInFictitiousFunctionClassFactory(GlobalSendApiModule globalSendApiModule, Provider<Retrofit.Builder> provider) {
        return new GlobalSendApiModule_ProvideGlobalSendApiFactory(globalSendApiModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GlobalSendSecureApi) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
