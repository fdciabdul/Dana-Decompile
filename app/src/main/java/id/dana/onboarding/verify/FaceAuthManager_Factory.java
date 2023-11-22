package id.dana.onboarding.verify;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class FaceAuthManager_Factory implements Factory<FaceAuthManager> {
    public static FaceAuthManager_Factory MyBillsEntityDataFactory() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final FaceAuthManager_Factory BuiltInFictitiousFunctionClassFactory = new FaceAuthManager_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FaceAuthManager();
    }
}
