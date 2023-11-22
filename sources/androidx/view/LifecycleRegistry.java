package androidx.view;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.view.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {
    private boolean BuiltInFictitiousFunctionClassFactory;
    public Lifecycle.State KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final boolean getAuthRequestContext;
    private final WeakReference<LifecycleOwner> getErrorConfigVersion;
    private ArrayList<Lifecycle.State> lookAheadTest;
    private boolean scheduleImpl;

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        this(lifecycleOwner, (byte) 0);
    }

    private LifecycleRegistry(LifecycleOwner lifecycleOwner, byte b) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new FastSafeIterableMap<>();
        this.MyBillsEntityDataFactory = 0;
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.scheduleImpl = false;
        this.lookAheadTest = new ArrayList<>();
        this.getErrorConfigVersion = new WeakReference<>(lifecycleOwner);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = Lifecycle.State.INITIALIZED;
        this.getAuthRequestContext = true;
    }

    public final void BuiltInFictitiousFunctionClassFactory(Lifecycle.Event event) {
        PlaceComponentResult("handleLifecycleEvent");
        getAuthRequestContext(event.getTargetState());
    }

    public final void getAuthRequestContext(Lifecycle.State state) {
        Lifecycle.State state2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (state2 == state) {
            return;
        }
        if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
            StringBuilder sb = new StringBuilder();
            sb.append("no event down from ");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            throw new IllegalStateException(sb.toString());
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = state;
        if (this.BuiltInFictitiousFunctionClassFactory || this.MyBillsEntityDataFactory != 0) {
            this.scheduleImpl = true;
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = true;
        MyBillsEntityDataFactory();
        this.BuiltInFictitiousFunctionClassFactory = false;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == Lifecycle.State.DESTROYED) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new FastSafeIterableMap<>();
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory == 0) {
            return true;
        }
        Lifecycle.State state = this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.getValue().PlaceComponentResult;
        Lifecycle.State state2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext.getValue().PlaceComponentResult;
        return state == state2 && this.KClassImpl$Data$declaredNonStaticMembers$2 == state2;
    }

    private Lifecycle.State getAuthRequestContext(LifecycleObserver lifecycleObserver) {
        FastSafeIterableMap<LifecycleObserver, ObserverWithState> fastSafeIterableMap = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Lifecycle.State state = null;
        SafeIterableMap.Entry<LifecycleObserver, ObserverWithState> entry = fastSafeIterableMap.BuiltInFictitiousFunctionClassFactory(lifecycleObserver) ? fastSafeIterableMap.PlaceComponentResult.get(lifecycleObserver).getAuthRequestContext : null;
        Lifecycle.State state2 = entry != null ? entry.getValue().PlaceComponentResult : null;
        if (!this.lookAheadTest.isEmpty()) {
            state = this.lookAheadTest.get(r0.size() - 1);
        }
        Lifecycle.State state3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (state2 == null || state2.compareTo(state3) >= 0) {
            state2 = state3;
        }
        return (state == null || state.compareTo(state2) >= 0) ? state2 : state;
    }

    @Override // androidx.view.Lifecycle
    public final void BuiltInFictitiousFunctionClassFactory(LifecycleObserver lifecycleObserver) {
        LifecycleOwner lifecycleOwner;
        PlaceComponentResult("addObserver");
        ObserverWithState observerWithState = new ObserverWithState(lifecycleObserver, this.KClassImpl$Data$declaredNonStaticMembers$2 == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(lifecycleObserver, observerWithState) == null && (lifecycleOwner = this.getErrorConfigVersion.get()) != null) {
            boolean z = this.MyBillsEntityDataFactory != 0 || this.BuiltInFictitiousFunctionClassFactory;
            Lifecycle.State authRequestContext = getAuthRequestContext(lifecycleObserver);
            this.MyBillsEntityDataFactory++;
            while (observerWithState.PlaceComponentResult.compareTo(authRequestContext) < 0 && this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(lifecycleObserver)) {
                this.lookAheadTest.add(observerWithState.PlaceComponentResult);
                Lifecycle.Event upFrom = Lifecycle.Event.upFrom(observerWithState.PlaceComponentResult);
                if (upFrom == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("no event up from ");
                    sb.append(observerWithState.PlaceComponentResult);
                    throw new IllegalStateException(sb.toString());
                }
                observerWithState.BuiltInFictitiousFunctionClassFactory(lifecycleOwner, upFrom);
                ArrayList<Lifecycle.State> arrayList = this.lookAheadTest;
                arrayList.remove(arrayList.size() - 1);
                authRequestContext = getAuthRequestContext(lifecycleObserver);
            }
            if (!z) {
                MyBillsEntityDataFactory();
            }
            this.MyBillsEntityDataFactory--;
        }
    }

    @Override // androidx.view.Lifecycle
    public final void KClassImpl$Data$declaredNonStaticMembers$2(LifecycleObserver lifecycleObserver) {
        PlaceComponentResult("removeObserver");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(lifecycleObserver);
    }

    @Override // androidx.view.Lifecycle
    public final Lifecycle.State PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(LifecycleOwner lifecycleOwner) {
        FastSafeIterableMap<LifecycleObserver, ObserverWithState> fastSafeIterableMap = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = new SafeIterableMap.IteratorWithAdditions();
        fastSafeIterableMap.BuiltInFictitiousFunctionClassFactory.put(iteratorWithAdditions, Boolean.FALSE);
        while (iteratorWithAdditions.hasNext() && !this.scheduleImpl) {
            Map.Entry next = iteratorWithAdditions.next();
            ObserverWithState observerWithState = (ObserverWithState) next.getValue();
            while (observerWithState.PlaceComponentResult.compareTo(this.KClassImpl$Data$declaredNonStaticMembers$2) < 0 && !this.scheduleImpl && this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory((LifecycleObserver) next.getKey())) {
                this.lookAheadTest.add(observerWithState.PlaceComponentResult);
                Lifecycle.Event upFrom = Lifecycle.Event.upFrom(observerWithState.PlaceComponentResult);
                if (upFrom == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("no event up from ");
                    sb.append(observerWithState.PlaceComponentResult);
                    throw new IllegalStateException(sb.toString());
                }
                observerWithState.BuiltInFictitiousFunctionClassFactory(lifecycleOwner, upFrom);
                this.lookAheadTest.remove(r3.size() - 1);
            }
        }
    }

    private void PlaceComponentResult(LifecycleOwner lifecycleOwner) {
        FastSafeIterableMap<LifecycleObserver, ObserverWithState> fastSafeIterableMap = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        SafeIterableMap.DescendingIterator descendingIterator = new SafeIterableMap.DescendingIterator(fastSafeIterableMap.getAuthRequestContext, fastSafeIterableMap.KClassImpl$Data$declaredNonStaticMembers$2);
        fastSafeIterableMap.BuiltInFictitiousFunctionClassFactory.put(descendingIterator, Boolean.FALSE);
        while (descendingIterator.hasNext() && !this.scheduleImpl) {
            Map.Entry next = descendingIterator.next();
            ObserverWithState observerWithState = (ObserverWithState) next.getValue();
            while (observerWithState.PlaceComponentResult.compareTo(this.KClassImpl$Data$declaredNonStaticMembers$2) > 0 && !this.scheduleImpl && this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory((LifecycleObserver) next.getKey())) {
                Lifecycle.Event downFrom = Lifecycle.Event.downFrom(observerWithState.PlaceComponentResult);
                if (downFrom == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("no event down from ");
                    sb.append(observerWithState.PlaceComponentResult);
                    throw new IllegalStateException(sb.toString());
                }
                this.lookAheadTest.add(downFrom.getTargetState());
                observerWithState.BuiltInFictitiousFunctionClassFactory(lifecycleOwner, downFrom);
                this.lookAheadTest.remove(r3.size() - 1);
            }
        }
    }

    private void MyBillsEntityDataFactory() {
        LifecycleOwner lifecycleOwner = this.getErrorConfigVersion.get();
        if (lifecycleOwner == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!BuiltInFictitiousFunctionClassFactory()) {
            this.scheduleImpl = false;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.compareTo(this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.getValue().PlaceComponentResult) < 0) {
                PlaceComponentResult(lifecycleOwner);
            }
            SafeIterableMap.Entry<LifecycleObserver, ObserverWithState> entry = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext;
            if (!this.scheduleImpl && entry != null && this.KClassImpl$Data$declaredNonStaticMembers$2.compareTo(entry.getValue().PlaceComponentResult) > 0) {
                KClassImpl$Data$declaredNonStaticMembers$2(lifecycleOwner);
            }
        }
        this.scheduleImpl = false;
    }

    public final void PlaceComponentResult(String str) {
        if (!this.getAuthRequestContext || ArchTaskExecutor.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Method ");
        sb.append(str);
        sb.append(" must be called on the main thread");
        throw new IllegalStateException(sb.toString());
    }

    static Lifecycle.State getAuthRequestContext(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ObserverWithState {
        Lifecycle.State PlaceComponentResult;
        LifecycleEventObserver getAuthRequestContext;

        ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State state) {
            this.getAuthRequestContext = Lifecycling.getAuthRequestContext(lifecycleObserver);
            this.PlaceComponentResult = state;
        }

        final void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State targetState = event.getTargetState();
            this.PlaceComponentResult = LifecycleRegistry.getAuthRequestContext(this.PlaceComponentResult, targetState);
            this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(lifecycleOwner, event);
            this.PlaceComponentResult = targetState;
        }
    }
}
