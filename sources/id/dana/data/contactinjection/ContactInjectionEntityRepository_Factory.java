package id.dana.data.contactinjection;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ContactInjectionEntityRepository_Factory implements Factory<ContactInjectionEntityRepository> {
    private final Provider<Context> MyBillsEntityDataFactory;

    private ContactInjectionEntityRepository_Factory(Provider<Context> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static ContactInjectionEntityRepository_Factory getAuthRequestContext(Provider<Context> provider) {
        return new ContactInjectionEntityRepository_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactInjectionEntityRepository(this.MyBillsEntityDataFactory.get());
    }
}
