package id.dana.utils;

import dagger.internal.Factory;

/* loaded from: classes5.dex */
public final class TimerUtil_Factory implements Factory<TimerUtil> {
    public static TimerUtil_Factory getAuthRequestContext() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final TimerUtil_Factory BuiltInFictitiousFunctionClassFactory = new TimerUtil_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new TimerUtil();
    }
}
