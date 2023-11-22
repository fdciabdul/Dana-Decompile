package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes2.dex */
public final class CoroutinesModule_ProvidesIoDispatcherFactory implements Factory<CoroutineDispatcher> {
    public static CoroutinesModule_ProvidesIoDispatcherFactory BuiltInFictitiousFunctionClassFactory() {
        return InstanceHolder.getAuthRequestContext;
    }

    public static CoroutineDispatcher getAuthRequestContext() {
        return (CoroutineDispatcher) Preconditions.BuiltInFictitiousFunctionClassFactory(CoroutinesModule.BuiltInFictitiousFunctionClassFactory());
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CoroutinesModule_ProvidesIoDispatcherFactory getAuthRequestContext = new CoroutinesModule_ProvidesIoDispatcherFactory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CoroutineDispatcher) Preconditions.BuiltInFictitiousFunctionClassFactory(CoroutinesModule.BuiltInFictitiousFunctionClassFactory());
    }
}
