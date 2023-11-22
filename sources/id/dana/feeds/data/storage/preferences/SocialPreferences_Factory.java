package id.dana.feeds.data.storage.preferences;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SocialPreferences_Factory implements Factory<SocialPreferences> {
    private final Provider<Serializer> MyBillsEntityDataFactory;
    private final Provider<Context> getAuthRequestContext;

    private SocialPreferences_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static SocialPreferences_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<Serializer> provider2) {
        return new SocialPreferences_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SocialPreferences(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
