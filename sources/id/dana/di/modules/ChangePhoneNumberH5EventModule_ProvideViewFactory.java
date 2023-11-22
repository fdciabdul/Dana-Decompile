package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.h5event.ChangePhoneNumberH5EventContract;

/* loaded from: classes4.dex */
public final class ChangePhoneNumberH5EventModule_ProvideViewFactory implements Factory<ChangePhoneNumberH5EventContract.View> {
    private final ChangePhoneNumberH5EventModule KClassImpl$Data$declaredNonStaticMembers$2;

    public static ChangePhoneNumberH5EventContract.View getAuthRequestContext(ChangePhoneNumberH5EventModule changePhoneNumberH5EventModule) {
        return (ChangePhoneNumberH5EventContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(changePhoneNumberH5EventModule.BuiltInFictitiousFunctionClassFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ChangePhoneNumberH5EventContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory());
    }
}
