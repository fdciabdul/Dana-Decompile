package id.dana.feeds.data.mapper;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.storage.Serializer;
import id.dana.feeds.data.synccontact.FeedsContactProvider;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ContactDeviceNameMapper_Factory implements Factory<ContactDeviceNameMapper> {
    private final Provider<FeedsContactProvider> BuiltInFictitiousFunctionClassFactory;
    private final Provider<AccountEntityDataFactory> MyBillsEntityDataFactory;
    private final Provider<Serializer> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;

    private ContactDeviceNameMapper_Factory(Provider<FeedsContactProvider> provider, Provider<Serializer> provider2, Provider<AccountEntityDataFactory> provider3, Provider<Context> provider4) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
        this.MyBillsEntityDataFactory = provider3;
        this.getAuthRequestContext = provider4;
    }

    public static ContactDeviceNameMapper_Factory MyBillsEntityDataFactory(Provider<FeedsContactProvider> provider, Provider<Serializer> provider2, Provider<AccountEntityDataFactory> provider3, Provider<Context> provider4) {
        return new ContactDeviceNameMapper_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactDeviceNameMapper(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
