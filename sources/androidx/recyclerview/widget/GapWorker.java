package androidx.recyclerview.widget;

import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class GapWorker implements Runnable {
    long BuiltInFictitiousFunctionClassFactory;
    long getAuthRequestContext;
    static final ThreadLocal<GapWorker> MyBillsEntityDataFactory = new ThreadLocal<>();
    static Comparator<Task> KClassImpl$Data$declaredNonStaticMembers$2 = new Comparator<Task>() { // from class: androidx.recyclerview.widget.GapWorker.1
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Task task, Task task2) {
            Task task3 = task;
            Task task4 = task2;
            if ((task3.MyBillsEntityDataFactory == null) != (task4.MyBillsEntityDataFactory == null)) {
                return task3.MyBillsEntityDataFactory == null ? 1 : -1;
            } else if (task3.PlaceComponentResult != task4.PlaceComponentResult) {
                return task3.PlaceComponentResult ? -1 : 1;
            } else {
                int i = task4.BuiltInFictitiousFunctionClassFactory - task3.BuiltInFictitiousFunctionClassFactory;
                if (i != 0) {
                    return i;
                }
                int i2 = task3.getAuthRequestContext - task4.getAuthRequestContext;
                if (i2 != 0) {
                    return i2;
                }
                return 0;
            }
        }
    };
    ArrayList<RecyclerView> PlaceComponentResult = new ArrayList<>();
    private ArrayList<Task> lookAheadTest = new ArrayList<>();

    /* loaded from: classes3.dex */
    static class Task {
        public int BuiltInFictitiousFunctionClassFactory;
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        public RecyclerView MyBillsEntityDataFactory;
        public boolean PlaceComponentResult;
        public int getAuthRequestContext;

        Task() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        int BuiltInFictitiousFunctionClassFactory;
        int[] MyBillsEntityDataFactory;
        int PlaceComponentResult;
        int getAuthRequestContext;

        final void BuiltInFictitiousFunctionClassFactory(RecyclerView recyclerView, boolean z) {
            this.getAuthRequestContext = 0;
            int[] iArr = this.MyBillsEntityDataFactory;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || layoutManager == null || !layoutManager.isItemPrefetchEnabled()) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                layoutManager.collectAdjacentPrefetchPositions(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, recyclerView.mState, this);
            }
            if (this.getAuthRequestContext > layoutManager.mPrefetchMaxCountObserved) {
                layoutManager.mPrefetchMaxCountObserved = this.getAuthRequestContext;
                layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                recyclerView.mRecycler.PlaceComponentResult();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public final void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.getAuthRequestContext * 2;
            int[] iArr = this.MyBillsEntityDataFactory;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.MyBillsEntityDataFactory = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.MyBillsEntityDataFactory = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.MyBillsEntityDataFactory;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.getAuthRequestContext++;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean getAuthRequestContext(int i) {
            if (this.MyBillsEntityDataFactory != null) {
                int i2 = this.getAuthRequestContext;
                for (int i3 = 0; i3 < i2 * 2; i3 += 2) {
                    if (this.MyBillsEntityDataFactory[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.getAuthRequestContext == 0) {
            this.getAuthRequestContext = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
        layoutPrefetchRegistryImpl.BuiltInFictitiousFunctionClassFactory = i;
        layoutPrefetchRegistryImpl.PlaceComponentResult = i2;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(RecyclerView recyclerView, int i) {
        int MyBillsEntityDataFactory2 = recyclerView.mChildHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        for (int i2 = 0; i2 < MyBillsEntityDataFactory2; i2++) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.MyBillsEntityDataFactory.getAuthRequestContext(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private static RecyclerView.ViewHolder KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView recyclerView, int i, long j) {
        if (BuiltInFictitiousFunctionClassFactory(recyclerView, i)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder KClassImpl$Data$declaredNonStaticMembers$22 = recycler.KClassImpl$Data$declaredNonStaticMembers$2(i, j);
            if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                if (KClassImpl$Data$declaredNonStaticMembers$22.isBound() && !KClassImpl$Data$declaredNonStaticMembers$22.isInvalid()) {
                    recycler.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22.itemView);
                } else {
                    recycler.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$22, false);
                }
            }
            return KClassImpl$Data$declaredNonStaticMembers$22;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView recyclerView;
        Task task;
        long j = 0;
        try {
            TraceCompat.BuiltInFictitiousFunctionClassFactory("RV Prefetch");
            if (!this.PlaceComponentResult.isEmpty()) {
                int size = this.PlaceComponentResult.size();
                long j2 = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView2 = this.PlaceComponentResult.get(i);
                    if (recyclerView2.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView2.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    long nanos = TimeUnit.MILLISECONDS.toNanos(j2) + this.BuiltInFictitiousFunctionClassFactory;
                    int size2 = this.PlaceComponentResult.size();
                    int i2 = 0;
                    for (int i3 = 0; i3 < size2; i3++) {
                        RecyclerView recyclerView3 = this.PlaceComponentResult.get(i3);
                        if (recyclerView3.getWindowVisibility() == 0) {
                            recyclerView3.mPrefetchRegistry.BuiltInFictitiousFunctionClassFactory(recyclerView3, false);
                            i2 += recyclerView3.mPrefetchRegistry.getAuthRequestContext;
                        }
                    }
                    this.lookAheadTest.ensureCapacity(i2);
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < size2) {
                        RecyclerView recyclerView4 = this.PlaceComponentResult.get(i4);
                        if (recyclerView4.getWindowVisibility() == 0) {
                            LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView4.mPrefetchRegistry;
                            int abs = Math.abs(layoutPrefetchRegistryImpl.BuiltInFictitiousFunctionClassFactory) + Math.abs(layoutPrefetchRegistryImpl.PlaceComponentResult);
                            for (int i6 = 0; i6 < layoutPrefetchRegistryImpl.getAuthRequestContext * 2; i6 += 2) {
                                if (i5 >= this.lookAheadTest.size()) {
                                    task = new Task();
                                    this.lookAheadTest.add(task);
                                } else {
                                    task = this.lookAheadTest.get(i5);
                                }
                                int i7 = layoutPrefetchRegistryImpl.MyBillsEntityDataFactory[i6 + 1];
                                task.PlaceComponentResult = i7 <= abs;
                                task.BuiltInFictitiousFunctionClassFactory = abs;
                                task.getAuthRequestContext = i7;
                                task.MyBillsEntityDataFactory = recyclerView4;
                                task.KClassImpl$Data$declaredNonStaticMembers$2 = layoutPrefetchRegistryImpl.MyBillsEntityDataFactory[i6];
                                i5++;
                            }
                        }
                        try {
                            i4++;
                            j = 0;
                        } catch (Throwable th) {
                            th = th;
                            j = 0;
                            this.getAuthRequestContext = j;
                            throw th;
                        }
                    }
                    Collections.sort(this.lookAheadTest, KClassImpl$Data$declaredNonStaticMembers$2);
                    for (int i8 = 0; i8 < this.lookAheadTest.size(); i8++) {
                        Task task2 = this.lookAheadTest.get(i8);
                        if (task2.MyBillsEntityDataFactory == null) {
                            break;
                        }
                        RecyclerView.ViewHolder KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(task2.MyBillsEntityDataFactory, task2.KClassImpl$Data$declaredNonStaticMembers$2, task2.PlaceComponentResult ? LongCompanionObject.MAX_VALUE : nanos);
                        if (KClassImpl$Data$declaredNonStaticMembers$22 != null && KClassImpl$Data$declaredNonStaticMembers$22.mNestedRecyclerView != null && KClassImpl$Data$declaredNonStaticMembers$22.isBound() && !KClassImpl$Data$declaredNonStaticMembers$22.isInvalid() && (recyclerView = KClassImpl$Data$declaredNonStaticMembers$22.mNestedRecyclerView.get()) != null) {
                            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.MyBillsEntityDataFactory.MyBillsEntityDataFactory() != 0) {
                                recyclerView.removeAndRecycleViews();
                            }
                            LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl2 = recyclerView.mPrefetchRegistry;
                            layoutPrefetchRegistryImpl2.BuiltInFictitiousFunctionClassFactory(recyclerView, true);
                            if (layoutPrefetchRegistryImpl2.getAuthRequestContext != 0) {
                                try {
                                    TraceCompat.BuiltInFictitiousFunctionClassFactory("RV Nested Prefetch");
                                    RecyclerView.State state = recyclerView.mState;
                                    RecyclerView.Adapter adapter = recyclerView.mAdapter;
                                    state.lookAheadTest = 1;
                                    state.scheduleImpl = adapter.getItemCount();
                                    state.BuiltInFictitiousFunctionClassFactory = false;
                                    state.PrepareContext = false;
                                    state.moveToNextValue = false;
                                    for (int i9 = 0; i9 < layoutPrefetchRegistryImpl2.getAuthRequestContext * 2; i9 += 2) {
                                        KClassImpl$Data$declaredNonStaticMembers$2(recyclerView, layoutPrefetchRegistryImpl2.MyBillsEntityDataFactory[i9], nanos);
                                    }
                                    TraceCompat.BuiltInFictitiousFunctionClassFactory();
                                } finally {
                                    TraceCompat.BuiltInFictitiousFunctionClassFactory();
                                }
                            }
                        }
                        task2.PlaceComponentResult = false;
                        task2.BuiltInFictitiousFunctionClassFactory = 0;
                        task2.getAuthRequestContext = 0;
                        task2.MyBillsEntityDataFactory = null;
                        task2.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                    }
                    j = 0;
                }
            }
            this.getAuthRequestContext = j;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
