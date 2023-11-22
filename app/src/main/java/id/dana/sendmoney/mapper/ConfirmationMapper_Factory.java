package id.dana.sendmoney.mapper;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ConfirmationMapper_Factory implements Factory<ConfirmationMapper> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;

    private ConfirmationMapper_Factory(Provider<Context> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ConfirmationMapper_Factory getAuthRequestContext(Provider<Context> provider) {
        return new ConfirmationMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ConfirmationMapper(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
