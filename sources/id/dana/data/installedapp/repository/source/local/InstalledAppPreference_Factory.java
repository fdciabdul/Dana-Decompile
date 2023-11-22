package id.dana.data.installedapp.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class InstalledAppPreference_Factory implements Factory<InstalledAppPreference> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;

    private InstalledAppPreference_Factory(Provider<Context> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static InstalledAppPreference_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider) {
        return new InstalledAppPreference_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InstalledAppPreference(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
