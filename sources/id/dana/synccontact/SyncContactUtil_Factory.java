package id.dana.synccontact;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class SyncContactUtil_Factory implements Factory<SyncContactUtil> {
    public static SyncContactUtil_Factory BuiltInFictitiousFunctionClassFactory() {
        return InstanceHolder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final SyncContactUtil_Factory KClassImpl$Data$declaredNonStaticMembers$2 = new SyncContactUtil_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SyncContactUtil();
    }
}
