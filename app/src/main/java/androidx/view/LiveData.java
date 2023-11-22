package androidx.view;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.view.Lifecycle;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class LiveData<T> {
    public static final Object MyBillsEntityDataFactory = new Object();
    public volatile Object BuiltInFictitiousFunctionClassFactory;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    private SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Runnable NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean PlaceComponentResult;
    final Object getAuthRequestContext;
    int getErrorConfigVersion;
    private boolean lookAheadTest;
    volatile Object moveToNextValue;
    private boolean scheduleImpl;

    public void BuiltInFictitiousFunctionClassFactory() {
    }

    public void getAuthRequestContext() {
    }

    public LiveData(T t) {
        this.getAuthRequestContext = new Object();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SafeIterableMap<>();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        this.moveToNextValue = MyBillsEntityDataFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object obj;
                synchronized (LiveData.this.getAuthRequestContext) {
                    obj = LiveData.this.moveToNextValue;
                    LiveData.this.moveToNextValue = LiveData.MyBillsEntityDataFactory;
                }
                LiveData.this.PlaceComponentResult((LiveData) obj);
            }
        };
        this.BuiltInFictitiousFunctionClassFactory = t;
        this.getErrorConfigVersion = 0;
    }

    public LiveData() {
        this.getAuthRequestContext = new Object();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SafeIterableMap<>();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        Object obj = MyBillsEntityDataFactory;
        this.moveToNextValue = obj;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                synchronized (LiveData.this.getAuthRequestContext) {
                    obj2 = LiveData.this.moveToNextValue;
                    LiveData.this.moveToNextValue = LiveData.MyBillsEntityDataFactory;
                }
                LiveData.this.PlaceComponentResult((LiveData) obj2);
            }
        };
        this.BuiltInFictitiousFunctionClassFactory = obj;
        this.getErrorConfigVersion = -1;
    }

    private void getAuthRequestContext(LiveData<T>.ObserverWrapper observerWrapper) {
        if (observerWrapper.KClassImpl$Data$declaredNonStaticMembers$2) {
            if (!observerWrapper.BuiltInFictitiousFunctionClassFactory()) {
                observerWrapper.BuiltInFictitiousFunctionClassFactory(false);
                return;
            }
            int i = observerWrapper.BuiltInFictitiousFunctionClassFactory;
            int i2 = this.getErrorConfigVersion;
            if (i >= i2) {
                return;
            }
            observerWrapper.BuiltInFictitiousFunctionClassFactory = i2;
            observerWrapper.NetworkUserEntityData$$ExternalSyntheticLambda0.onChanged((Object) this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    final void MyBillsEntityDataFactory(LiveData<T>.ObserverWrapper observerWrapper) {
        if (this.lookAheadTest) {
            this.scheduleImpl = true;
            return;
        }
        this.lookAheadTest = true;
        do {
            this.scheduleImpl = false;
            if (observerWrapper != null) {
                getAuthRequestContext(observerWrapper);
                observerWrapper = null;
            } else {
                SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> safeIterableMap = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = new SafeIterableMap.IteratorWithAdditions();
                safeIterableMap.BuiltInFictitiousFunctionClassFactory.put(iteratorWithAdditions, Boolean.FALSE);
                while (iteratorWithAdditions.hasNext()) {
                    getAuthRequestContext((ObserverWrapper) iteratorWithAdditions.next().getValue());
                    if (this.scheduleImpl) {
                        break;
                    }
                }
            }
        } while (this.scheduleImpl);
        this.lookAheadTest = false;
    }

    public void PlaceComponentResult(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        KClassImpl$Data$declaredNonStaticMembers$2("observe");
        if (lifecycleOwner.getLifecycle().PlaceComponentResult() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
        LiveData<T>.ObserverWrapper BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(observer, lifecycleBoundObserver);
        if (BuiltInFictitiousFunctionClassFactory != null && !BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(lifecycleOwner)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return;
        }
        lifecycleOwner.getLifecycle().BuiltInFictitiousFunctionClassFactory(lifecycleBoundObserver);
    }

    public final void getAuthRequestContext(Observer<? super T> observer) {
        KClassImpl$Data$declaredNonStaticMembers$2("observeForever");
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(observer);
        LiveData<T>.ObserverWrapper BuiltInFictitiousFunctionClassFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(observer, alwaysActiveObserver);
        if (BuiltInFictitiousFunctionClassFactory instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return;
        }
        alwaysActiveObserver.BuiltInFictitiousFunctionClassFactory(true);
    }

    public void BuiltInFictitiousFunctionClassFactory(Observer<? super T> observer) {
        KClassImpl$Data$declaredNonStaticMembers$2("removeObserver");
        LiveData<T>.ObserverWrapper KClassImpl$Data$declaredNonStaticMembers$2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(observer);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(false);
    }

    public final void PlaceComponentResult(LifecycleOwner lifecycleOwner) {
        KClassImpl$Data$declaredNonStaticMembers$2("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> it = this.NetworkUserEntityData$$ExternalSyntheticLambda0.iterator();
        while (it.hasNext()) {
            Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper> next = it.next();
            if (next.getValue().PlaceComponentResult(lifecycleOwner)) {
                BuiltInFictitiousFunctionClassFactory((Observer) next.getKey());
            }
        }
    }

    public void BuiltInFictitiousFunctionClassFactory(T t) {
        boolean z;
        synchronized (this.getAuthRequestContext) {
            z = this.moveToNextValue == MyBillsEntityDataFactory;
            this.moveToNextValue = t;
        }
        if (z) {
            ArchTaskExecutor.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void PlaceComponentResult(T t) {
        KClassImpl$Data$declaredNonStaticMembers$2("setValue");
        this.getErrorConfigVersion++;
        this.BuiltInFictitiousFunctionClassFactory = t;
        MyBillsEntityDataFactory(null);
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 > 0;
    }

    final void getAuthRequestContext(int i) {
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i + i2;
        if (this.PlaceComponentResult) {
            return;
        }
        this.PlaceComponentResult = true;
        while (true) {
            try {
                int i3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (i2 == i3) {
                    return;
                }
                boolean z = i2 == 0 && i3 > 0;
                boolean z2 = i2 > 0 && i3 == 0;
                if (z) {
                    BuiltInFictitiousFunctionClassFactory();
                } else if (z2) {
                    getAuthRequestContext();
                }
                i2 = i3;
            } finally {
                this.PlaceComponentResult = false;
            }
        }
    }

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends ObserverWrapper implements LifecycleEventObserver {
        final LifecycleOwner PlaceComponentResult;

        LifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            super(observer);
            this.PlaceComponentResult = lifecycleOwner;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        final boolean BuiltInFictitiousFunctionClassFactory() {
            return this.PlaceComponentResult.getLifecycle().PlaceComponentResult().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // androidx.view.LifecycleEventObserver
        public void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State PlaceComponentResult = this.PlaceComponentResult.getLifecycle().PlaceComponentResult();
            if (PlaceComponentResult == Lifecycle.State.DESTROYED) {
                LiveData.this.BuiltInFictitiousFunctionClassFactory((Observer) this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                return;
            }
            Lifecycle.State state = null;
            while (state != PlaceComponentResult) {
                BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory());
                state = PlaceComponentResult;
                PlaceComponentResult = this.PlaceComponentResult.getLifecycle().PlaceComponentResult();
            }
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        final boolean PlaceComponentResult(LifecycleOwner lifecycleOwner) {
            return this.PlaceComponentResult == lifecycleOwner;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        final void MyBillsEntityDataFactory() {
            this.PlaceComponentResult.getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class ObserverWrapper {
        int BuiltInFictitiousFunctionClassFactory = -1;
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final Observer<? super T> NetworkUserEntityData$$ExternalSyntheticLambda0;

        abstract boolean BuiltInFictitiousFunctionClassFactory();

        void MyBillsEntityDataFactory() {
        }

        boolean PlaceComponentResult(LifecycleOwner lifecycleOwner) {
            return false;
        }

        ObserverWrapper(Observer<? super T> observer) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = observer;
        }

        final void BuiltInFictitiousFunctionClassFactory(boolean z) {
            if (z == this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            LiveData.this.getAuthRequestContext(z ? 1 : -1);
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                LiveData.this.MyBillsEntityDataFactory(this);
            }
        }
    }

    /* loaded from: classes.dex */
    class AlwaysActiveObserver extends ObserverWrapper {
        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        final boolean BuiltInFictitiousFunctionClassFactory() {
            return true;
        }

        AlwaysActiveObserver(Observer<? super T> observer) {
            super(observer);
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (ArchTaskExecutor.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot invoke ");
        sb.append(str);
        sb.append(" on a background thread");
        throw new IllegalStateException(sb.toString());
    }
}
