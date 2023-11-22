package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes2.dex */
public final class CoroutinesModule_ProvidesDefaultDispatcherFactory implements Factory<CoroutineDispatcher> {
    public static CoroutineDispatcher BuiltInFictitiousFunctionClassFactory() {
        return (CoroutineDispatcher) Preconditions.BuiltInFictitiousFunctionClassFactory(CoroutinesModule.PlaceComponentResult());
    }

    /* loaded from: classes8.dex */
    static final class InstanceHolder {
        private static final CoroutinesModule_ProvidesDefaultDispatcherFactory BuiltInFictitiousFunctionClassFactory = new CoroutinesModule_ProvidesDefaultDispatcherFactory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CoroutineDispatcher) Preconditions.BuiltInFictitiousFunctionClassFactory(CoroutinesModule.PlaceComponentResult());
    }
}
