package androidx.recyclerview.widget;

import android.os.Handler;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
class MessageThreadUtil<T> implements ThreadUtil<T> {
    MessageThreadUtil() {
    }

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements ThreadUtil.MainThreadCallback<T> {
        private final Handler BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ ThreadUtil.MainThreadCallback MyBillsEntityDataFactory;
        final MessageQueue PlaceComponentResult;
        private Runnable getAuthRequestContext;

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public final void MyBillsEntityDataFactory(int i, int i2) {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(SyncQueueItem.BuiltInFictitiousFunctionClassFactory(1, i, i2));
            this.BuiltInFictitiousFunctionClassFactory.post(this.getAuthRequestContext);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public final void getAuthRequestContext(int i, TileList.Tile<T> tile) {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(SyncQueueItem.PlaceComponentResult(2, i, tile));
            this.BuiltInFictitiousFunctionClassFactory.post(this.getAuthRequestContext);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public final void getAuthRequestContext(int i, int i2) {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(SyncQueueItem.BuiltInFictitiousFunctionClassFactory(3, i, i2));
            this.BuiltInFictitiousFunctionClassFactory.post(this.getAuthRequestContext);
        }

        /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes6.dex */
        class RunnableC00081 implements Runnable {
            final /* synthetic */ AnonymousClass1 PlaceComponentResult;

            @Override // java.lang.Runnable
            public void run() {
                SyncQueueItem MyBillsEntityDataFactory = this.PlaceComponentResult.PlaceComponentResult.MyBillsEntityDataFactory();
                while (MyBillsEntityDataFactory != null) {
                    int i = MyBillsEntityDataFactory.getErrorConfigVersion;
                    if (i == 1) {
                        this.PlaceComponentResult.MyBillsEntityDataFactory.MyBillsEntityDataFactory(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.MyBillsEntityDataFactory);
                    } else if (i == 2) {
                        this.PlaceComponentResult.MyBillsEntityDataFactory.getAuthRequestContext(MyBillsEntityDataFactory.getAuthRequestContext, (TileList.Tile) MyBillsEntityDataFactory.scheduleImpl);
                    } else if (i == 3) {
                        this.PlaceComponentResult.MyBillsEntityDataFactory.getAuthRequestContext(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.MyBillsEntityDataFactory);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Unsupported message, what=");
                        sb.append(MyBillsEntityDataFactory.getErrorConfigVersion);
                        InstrumentInjector.log_e("ThreadUtil", sb.toString());
                    }
                    MyBillsEntityDataFactory = this.PlaceComponentResult.PlaceComponentResult.MyBillsEntityDataFactory();
                }
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 implements ThreadUtil.BackgroundCallback<T> {
        final /* synthetic */ ThreadUtil.BackgroundCallback BuiltInFictitiousFunctionClassFactory;
        final MessageQueue KClassImpl$Data$declaredNonStaticMembers$2;
        AtomicBoolean MyBillsEntityDataFactory;
        private final Executor PlaceComponentResult;
        private Runnable getAuthRequestContext;

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public final void getAuthRequestContext(int i) {
            PlaceComponentResult(SyncQueueItem.PlaceComponentResult(1, i, null));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public final void MyBillsEntityDataFactory(int i, int i2, int i3, int i4, int i5) {
            PlaceComponentResult(SyncQueueItem.PlaceComponentResult(2, i, i2, i3, i4, i5, null));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public final void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            getAuthRequestContext(SyncQueueItem.BuiltInFictitiousFunctionClassFactory(3, i, i2));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public final void PlaceComponentResult(TileList.Tile<T> tile) {
            getAuthRequestContext(SyncQueueItem.PlaceComponentResult(4, 0, tile));
        }

        private void getAuthRequestContext(SyncQueueItem syncQueueItem) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(syncQueueItem);
            if (this.MyBillsEntityDataFactory.compareAndSet(false, true)) {
                this.PlaceComponentResult.execute(this.getAuthRequestContext);
            }
        }

        private void PlaceComponentResult(SyncQueueItem syncQueueItem) {
            MessageQueue messageQueue = this.KClassImpl$Data$declaredNonStaticMembers$2;
            synchronized (messageQueue) {
                syncQueueItem.moveToNextValue = messageQueue.MyBillsEntityDataFactory;
                messageQueue.MyBillsEntityDataFactory = syncQueueItem;
            }
            if (this.MyBillsEntityDataFactory.compareAndSet(false, true)) {
                this.PlaceComponentResult.execute(this.getAuthRequestContext);
            }
        }

        /* renamed from: androidx.recyclerview.widget.MessageThreadUtil$2$1  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ AnonymousClass2 BuiltInFictitiousFunctionClassFactory;

            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    SyncQueueItem MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                    if (MyBillsEntityDataFactory != null) {
                        int i = MyBillsEntityDataFactory.getErrorConfigVersion;
                        if (i == 1) {
                            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(1);
                            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(MyBillsEntityDataFactory.getAuthRequestContext);
                        } else if (i == 2) {
                            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(2);
                            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(3);
                            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.MyBillsEntityDataFactory, MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.PlaceComponentResult);
                        } else if (i == 3) {
                            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.MyBillsEntityDataFactory);
                        } else if (i == 4) {
                            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult((TileList.Tile) MyBillsEntityDataFactory.scheduleImpl);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unsupported message, what=");
                            sb.append(MyBillsEntityDataFactory.getErrorConfigVersion);
                            InstrumentInjector.log_e("ThreadUtil", sb.toString());
                        }
                    } else {
                        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.set(false);
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SyncQueueItem {
        private static SyncQueueItem NetworkUserEntityData$$ExternalSyntheticLambda0;
        private static final Object lookAheadTest = new Object();
        public int BuiltInFictitiousFunctionClassFactory;
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        public int MyBillsEntityDataFactory;
        public int PlaceComponentResult;
        public int getAuthRequestContext;
        public int getErrorConfigVersion;
        SyncQueueItem moveToNextValue;
        public Object scheduleImpl;

        SyncQueueItem() {
        }

        final void MyBillsEntityDataFactory() {
            this.moveToNextValue = null;
            this.PlaceComponentResult = 0;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            this.BuiltInFictitiousFunctionClassFactory = 0;
            this.MyBillsEntityDataFactory = 0;
            this.getAuthRequestContext = 0;
            this.getErrorConfigVersion = 0;
            this.scheduleImpl = null;
            synchronized (lookAheadTest) {
                SyncQueueItem syncQueueItem = NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (syncQueueItem != null) {
                    this.moveToNextValue = syncQueueItem;
                }
                NetworkUserEntityData$$ExternalSyntheticLambda0 = this;
            }
        }

        static SyncQueueItem PlaceComponentResult(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (lookAheadTest) {
                syncQueueItem = NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (syncQueueItem == null) {
                    syncQueueItem = new SyncQueueItem();
                } else {
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = syncQueueItem.moveToNextValue;
                    syncQueueItem.moveToNextValue = null;
                }
                syncQueueItem.getErrorConfigVersion = i;
                syncQueueItem.getAuthRequestContext = i2;
                syncQueueItem.MyBillsEntityDataFactory = i3;
                syncQueueItem.BuiltInFictitiousFunctionClassFactory = i4;
                syncQueueItem.KClassImpl$Data$declaredNonStaticMembers$2 = i5;
                syncQueueItem.PlaceComponentResult = i6;
                syncQueueItem.scheduleImpl = obj;
            }
            return syncQueueItem;
        }

        static SyncQueueItem BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3) {
            return PlaceComponentResult(i, i2, i3, 0, 0, 0, null);
        }

        static SyncQueueItem PlaceComponentResult(int i, int i2, Object obj) {
            return PlaceComponentResult(i, i2, 0, 0, 0, 0, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class MessageQueue {
        SyncQueueItem MyBillsEntityDataFactory;

        MessageQueue() {
        }

        final SyncQueueItem MyBillsEntityDataFactory() {
            synchronized (this) {
                SyncQueueItem syncQueueItem = this.MyBillsEntityDataFactory;
                if (syncQueueItem == null) {
                    return null;
                }
                this.MyBillsEntityDataFactory = syncQueueItem.moveToNextValue;
                return syncQueueItem;
            }
        }

        final void BuiltInFictitiousFunctionClassFactory(SyncQueueItem syncQueueItem) {
            synchronized (this) {
                SyncQueueItem syncQueueItem2 = this.MyBillsEntityDataFactory;
                if (syncQueueItem2 == null) {
                    this.MyBillsEntityDataFactory = syncQueueItem;
                    return;
                }
                while (syncQueueItem2.moveToNextValue != null) {
                    syncQueueItem2 = syncQueueItem2.moveToNextValue;
                }
                syncQueueItem2.moveToNextValue = syncQueueItem;
            }
        }

        final void BuiltInFictitiousFunctionClassFactory(int i) {
            synchronized (this) {
                while (true) {
                    SyncQueueItem syncQueueItem = this.MyBillsEntityDataFactory;
                    if (syncQueueItem == null || syncQueueItem.getErrorConfigVersion != i) {
                        break;
                    }
                    SyncQueueItem syncQueueItem2 = this.MyBillsEntityDataFactory;
                    this.MyBillsEntityDataFactory = syncQueueItem2.moveToNextValue;
                    syncQueueItem2.MyBillsEntityDataFactory();
                }
                SyncQueueItem syncQueueItem3 = this.MyBillsEntityDataFactory;
                if (syncQueueItem3 != null) {
                    SyncQueueItem syncQueueItem4 = syncQueueItem3.moveToNextValue;
                    while (syncQueueItem4 != null) {
                        SyncQueueItem syncQueueItem5 = syncQueueItem4.moveToNextValue;
                        if (syncQueueItem4.getErrorConfigVersion == i) {
                            syncQueueItem3.moveToNextValue = syncQueueItem5;
                            syncQueueItem4.MyBillsEntityDataFactory();
                        } else {
                            syncQueueItem3 = syncQueueItem4;
                        }
                        syncQueueItem4 = syncQueueItem5;
                    }
                }
            }
        }
    }
}
