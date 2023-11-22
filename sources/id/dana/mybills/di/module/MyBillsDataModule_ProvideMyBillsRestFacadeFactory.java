package id.dana.mybills.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.mybills.data.repository.source.network.MyBillsRestFacade;
import javax.inject.Provider;
import retrofit2.Retrofit;

/* loaded from: classes5.dex */
public final class MyBillsDataModule_ProvideMyBillsRestFacadeFactory implements Factory<MyBillsRestFacade> {
    private final Provider<Retrofit.Builder> BuiltInFictitiousFunctionClassFactory;
    private final MyBillsDataModule KClassImpl$Data$declaredNonStaticMembers$2;

    private MyBillsDataModule_ProvideMyBillsRestFacadeFactory(MyBillsDataModule myBillsDataModule, Provider<Retrofit.Builder> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = myBillsDataModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static MyBillsDataModule_ProvideMyBillsRestFacadeFactory MyBillsEntityDataFactory(MyBillsDataModule myBillsDataModule, Provider<Retrofit.Builder> provider) {
        return new MyBillsDataModule_ProvideMyBillsRestFacadeFactory(myBillsDataModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MyBillsRestFacade) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
