package id.dana.data.foundation.facade;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SecurityGuardFacade_Factory implements Factory<SecurityGuardFacade> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;

    private SecurityGuardFacade_Factory(Provider<Context> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static SecurityGuardFacade_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider) {
        return new SecurityGuardFacade_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SecurityGuardFacade(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
