package id.dana;

import dagger.internal.Factory;

/* loaded from: classes.dex */
public final class UIThread_Factory implements Factory<UIThread> {
    public static UIThread_Factory BuiltInFictitiousFunctionClassFactory() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final UIThread_Factory MyBillsEntityDataFactory = new UIThread_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UIThread();
    }
}
