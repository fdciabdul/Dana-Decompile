package id.dana.sync_engine.data.source.local;

import com.google.gson.Gson;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.base.BasePersistenceDao;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ContactEntityDataLocal_Factory implements Factory<ContactEntityDataLocal> {
    private final Provider<PreferenceFacade> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Gson> PlaceComponentResult;
    private final Provider<BasePersistenceDao> getAuthRequestContext;

    private ContactEntityDataLocal_Factory(Provider<PreferenceFacade> provider, Provider<BasePersistenceDao> provider2, Provider<Gson> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static ContactEntityDataLocal_Factory PlaceComponentResult(Provider<PreferenceFacade> provider, Provider<BasePersistenceDao> provider2, Provider<Gson> provider3) {
        return new ContactEntityDataLocal_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactEntityDataLocal(this.BuiltInFictitiousFunctionClassFactory.get(), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), this.PlaceComponentResult.get());
    }
}
