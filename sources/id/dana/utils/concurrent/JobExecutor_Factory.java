package id.dana.utils.concurrent;

import dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class JobExecutor_Factory implements Factory<JobExecutor> {
    public static JobExecutor_Factory BuiltInFictitiousFunctionClassFactory() {
        return InstanceHolder.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes5.dex */
    static final class InstanceHolder {
        private static final JobExecutor_Factory BuiltInFictitiousFunctionClassFactory = new JobExecutor_Factory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new JobExecutor();
    }
}
