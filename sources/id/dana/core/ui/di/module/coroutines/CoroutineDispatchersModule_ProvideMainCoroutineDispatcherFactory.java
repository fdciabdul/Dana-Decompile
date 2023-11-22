package id.dana.core.ui.di.module.coroutines;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* loaded from: classes8.dex */
public final class CoroutineDispatchersModule_ProvideMainCoroutineDispatcherFactory implements Factory<CoroutineDispatcher> {

    /* loaded from: classes8.dex */
    static final class InstanceHolder {
        private static final CoroutineDispatchersModule_ProvideMainCoroutineDispatcherFactory PlaceComponentResult = new CoroutineDispatchersModule_ProvideMainCoroutineDispatcherFactory();

        private InstanceHolder() {
        }
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        CoroutineDispatcher main;
        main = Dispatchers.getMain();
        return (CoroutineDispatcher) Preconditions.BuiltInFictitiousFunctionClassFactory(main);
    }
}
