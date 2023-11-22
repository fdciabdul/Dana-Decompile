package id.dana.di.modules;

import dagger.internal.Factory;

/* loaded from: classes4.dex */
public final class VerifyNumberModule_ProvidesIsVerifyingToResetPinFactory implements Factory<Boolean> {
    private final VerifyNumberModule MyBillsEntityDataFactory;

    private VerifyNumberModule_ProvidesIsVerifyingToResetPinFactory(VerifyNumberModule verifyNumberModule) {
        this.MyBillsEntityDataFactory = verifyNumberModule;
    }

    public static VerifyNumberModule_ProvidesIsVerifyingToResetPinFactory KClassImpl$Data$declaredNonStaticMembers$2(VerifyNumberModule verifyNumberModule) {
        return new VerifyNumberModule_ProvidesIsVerifyingToResetPinFactory(verifyNumberModule);
    }

    private static boolean PlaceComponentResult(VerifyNumberModule verifyNumberModule) {
        return verifyNumberModule.getBuiltInFictitiousFunctionClassFactory();
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return Boolean.valueOf(PlaceComponentResult(this.MyBillsEntityDataFactory));
    }
}
