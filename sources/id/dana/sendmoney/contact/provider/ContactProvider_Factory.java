package id.dana.sendmoney.contact.provider;

import android.content.ContentResolver;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ContactProvider_Factory implements Factory<ContactProvider> {
    private final Provider<ContentResolver> KClassImpl$Data$declaredNonStaticMembers$2;

    private ContactProvider_Factory(Provider<ContentResolver> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ContactProvider_Factory PlaceComponentResult(Provider<ContentResolver> provider) {
        return new ContactProvider_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactProvider(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
