package id.dana.core.ui.di.module.coroutines;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

/* loaded from: classes8.dex */
public final class CoroutineDispatchersModule_ProvideIOCoroutineDispatcherFactory implements Factory<CoroutineDispatcher> {

    /* loaded from: classes8.dex */
    static final class InstanceHolder {
        private static final CoroutineDispatchersModule_ProvideIOCoroutineDispatcherFactory getAuthRequestContext = new CoroutineDispatchersModule_ProvideIOCoroutineDispatcherFactory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CoroutineDispatcher) Preconditions.BuiltInFictitiousFunctionClassFactory(CoroutineDispatchersModule.getAuthRequestContext());
    }
}
