package androidx.room;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.InvalidationTracker;
import androidx.view.LiveData;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class RoomTrackingLiveData<T> extends LiveData<T> {
    final InvalidationTracker.Observer DatabaseTableConfigUtil;
    final Callable<T> PlaceComponentResult;
    final RoomDatabase lookAheadTest;
    private final InvalidationLiveDataContainer newProxyInstance;
    final AtomicBoolean GetContactSyncConfig = new AtomicBoolean(true);
    final AtomicBoolean NetworkUserEntityData$$ExternalSyntheticLambda0 = new AtomicBoolean(false);
    final AtomicBoolean NetworkUserEntityData$$ExternalSyntheticLambda1 = new AtomicBoolean(false);
    final Runnable initRecordTimeStamp = new Runnable() { // from class: androidx.room.RoomTrackingLiveData.1
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (RoomTrackingLiveData.this.NetworkUserEntityData$$ExternalSyntheticLambda1.compareAndSet(false, true)) {
                InvalidationTracker invalidationTracker = RoomTrackingLiveData.this.lookAheadTest.getInvalidationTracker();
                invalidationTracker.MyBillsEntityDataFactory(new InvalidationTracker.WeakObserver(invalidationTracker, RoomTrackingLiveData.this.DatabaseTableConfigUtil));
            }
            do {
                if (RoomTrackingLiveData.this.NetworkUserEntityData$$ExternalSyntheticLambda0.compareAndSet(false, true)) {
                    T t = null;
                    z = false;
                    while (RoomTrackingLiveData.this.GetContactSyncConfig.compareAndSet(true, false)) {
                        try {
                            try {
                                t = RoomTrackingLiveData.this.PlaceComponentResult.call();
                                z = true;
                            } catch (Exception e) {
                                throw new RuntimeException("Exception while computing database live data.", e);
                            }
                        } finally {
                            RoomTrackingLiveData.this.NetworkUserEntityData$$ExternalSyntheticLambda0.set(false);
                        }
                    }
                    if (z) {
                        RoomTrackingLiveData.this.BuiltInFictitiousFunctionClassFactory((RoomTrackingLiveData) t);
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    return;
                }
            } while (RoomTrackingLiveData.this.GetContactSyncConfig.get());
        }
    };
    final Runnable NetworkUserEntityData$$ExternalSyntheticLambda2 = new Runnable() { // from class: androidx.room.RoomTrackingLiveData.2
        @Override // java.lang.Runnable
        public void run() {
            Executor queryExecutor;
            boolean MyBillsEntityDataFactory = RoomTrackingLiveData.this.MyBillsEntityDataFactory();
            if (RoomTrackingLiveData.this.GetContactSyncConfig.compareAndSet(false, true) && MyBillsEntityDataFactory) {
                RoomTrackingLiveData roomTrackingLiveData = RoomTrackingLiveData.this;
                if (roomTrackingLiveData.scheduleImpl) {
                    queryExecutor = roomTrackingLiveData.lookAheadTest.getTransactionExecutor();
                } else {
                    queryExecutor = roomTrackingLiveData.lookAheadTest.getQueryExecutor();
                }
                queryExecutor.execute(RoomTrackingLiveData.this.initRecordTimeStamp);
            }
        }
    };
    final boolean scheduleImpl = true;

    public RoomTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, Callable<T> callable, String[] strArr) {
        this.lookAheadTest = roomDatabase;
        this.PlaceComponentResult = callable;
        this.newProxyInstance = invalidationLiveDataContainer;
        this.DatabaseTableConfigUtil = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.RoomTrackingLiveData.3
            @Override // androidx.room.InvalidationTracker.Observer
            public final void PlaceComponentResult(Set<String> set) {
                ArchTaskExecutor MyBillsEntityDataFactory = ArchTaskExecutor.MyBillsEntityDataFactory();
                Runnable runnable = RoomTrackingLiveData.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory()) {
                    runnable.run();
                } else {
                    MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(runnable);
                }
            }
        };
    }

    @Override // androidx.view.LiveData
    public final void BuiltInFictitiousFunctionClassFactory() {
        Executor queryExecutor;
        super.BuiltInFictitiousFunctionClassFactory();
        this.newProxyInstance.BuiltInFictitiousFunctionClassFactory.add(this);
        if (this.scheduleImpl) {
            queryExecutor = this.lookAheadTest.getTransactionExecutor();
        } else {
            queryExecutor = this.lookAheadTest.getQueryExecutor();
        }
        queryExecutor.execute(this.initRecordTimeStamp);
    }

    @Override // androidx.view.LiveData
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        this.newProxyInstance.BuiltInFictitiousFunctionClassFactory.remove(this);
    }
}
