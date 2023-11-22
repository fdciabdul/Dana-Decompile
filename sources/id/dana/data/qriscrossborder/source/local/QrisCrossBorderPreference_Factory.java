package id.dana.data.qriscrossborder.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class QrisCrossBorderPreference_Factory implements Factory<QrisCrossBorderPreference> {
    private final Provider<Serializer> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> PlaceComponentResult;

    private QrisCrossBorderPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.PlaceComponentResult = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static QrisCrossBorderPreference_Factory getAuthRequestContext(Provider<Context> provider, Provider<Serializer> provider2) {
        return new QrisCrossBorderPreference_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new QrisCrossBorderPreference(this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
