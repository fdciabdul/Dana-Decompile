package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes2.dex */
public final class CoroutinesModule_ProvidesMainDispatcherFactory implements Factory<CoroutineDispatcher> {
    public static CoroutinesModule_ProvidesMainDispatcherFactory MyBillsEntityDataFactory() {
        return InstanceHolder.MyBillsEntityDataFactory;
    }

    public static CoroutineDispatcher getAuthRequestContext() {
        return (CoroutineDispatcher) Preconditions.BuiltInFictitiousFunctionClassFactory(CoroutinesModule.MyBillsEntityDataFactory());
    }

    /* loaded from: classes4.dex */
    static final class InstanceHolder {
        private static final CoroutinesModule_ProvidesMainDispatcherFactory MyBillsEntityDataFactory = new CoroutinesModule_ProvidesMainDispatcherFactory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CoroutineDispatcher) Preconditions.BuiltInFictitiousFunctionClassFactory(CoroutinesModule.MyBillsEntityDataFactory());
    }
}
