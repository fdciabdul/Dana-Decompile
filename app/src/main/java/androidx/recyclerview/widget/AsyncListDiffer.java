package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class AsyncListDiffer<T> {
    private static final Executor getErrorConfigVersion = new MainThreadExecutor();
    final AsyncDifferConfig<T> BuiltInFictitiousFunctionClassFactory;
    final List<ListListener<T>> KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory;
    List<T> PlaceComponentResult;
    Executor getAuthRequestContext;
    final ListUpdateCallback lookAheadTest;
    public List<T> moveToNextValue;

    /* loaded from: classes3.dex */
    public interface ListListener<T> {
    }

    /* loaded from: classes3.dex */
    static class MainThreadExecutor implements Executor {
        final Handler BuiltInFictitiousFunctionClassFactory = new Handler(Looper.getMainLooper());

        MainThreadExecutor() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.BuiltInFictitiousFunctionClassFactory.post(runnable);
        }
    }

    public AsyncListDiffer(RecyclerView.Adapter adapter, DiffUtil.ItemCallback<T> itemCallback) {
        this(new AdapterListUpdateCallback(adapter), new AsyncDifferConfig.Builder(itemCallback).PlaceComponentResult());
    }

    public AsyncListDiffer(ListUpdateCallback listUpdateCallback, AsyncDifferConfig<T> asyncDifferConfig) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new CopyOnWriteArrayList();
        this.moveToNextValue = Collections.emptyList();
        this.lookAheadTest = listUpdateCallback;
        this.BuiltInFictitiousFunctionClassFactory = asyncDifferConfig;
        if (asyncDifferConfig.BuiltInFictitiousFunctionClassFactory != null) {
            this.getAuthRequestContext = asyncDifferConfig.BuiltInFictitiousFunctionClassFactory;
        } else {
            this.getAuthRequestContext = getErrorConfigVersion;
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(final List<T> list, final Runnable runnable) {
        final int i = this.MyBillsEntityDataFactory + 1;
        this.MyBillsEntityDataFactory = i;
        final List<T> list2 = this.PlaceComponentResult;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (list == null) {
            int size = list2.size();
            this.PlaceComponentResult = null;
            this.moveToNextValue = Collections.emptyList();
            this.lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(0, size);
            MyBillsEntityDataFactory(runnable);
        } else if (list2 == null) {
            this.PlaceComponentResult = list;
            this.moveToNextValue = Collections.unmodifiableList(list);
            this.lookAheadTest.PlaceComponentResult(0, list.size());
            MyBillsEntityDataFactory(runnable);
        } else {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1
                @Override // java.lang.Runnable
                public void run() {
                    final DiffUtil.DiffResult authRequestContext = DiffUtil.getAuthRequestContext(new DiffUtil.Callback() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.1
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public final int getAuthRequestContext() {
                            return list2.size();
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public final int PlaceComponentResult() {
                            return list.size();
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i2, int i3) {
                            Object obj = list2.get(i2);
                            Object obj2 = list.get(i3);
                            if (obj == null || obj2 == null) {
                                return obj == null && obj2 == null;
                            }
                            return AsyncListDiffer.this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.getAuthRequestContext(obj, obj2);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public final boolean MyBillsEntityDataFactory(int i2, int i3) {
                            Object obj = list2.get(i2);
                            Object obj2 = list.get(i3);
                            if (obj == null || obj2 == null) {
                                if (obj == null && obj2 == null) {
                                    return true;
                                }
                                throw new AssertionError();
                            }
                            return AsyncListDiffer.this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(obj, obj2);
                        }

                        @Override // androidx.recyclerview.widget.DiffUtil.Callback
                        public final Object PlaceComponentResult(int i2, int i3) {
                            Object obj = list2.get(i2);
                            Object obj2 = list.get(i3);
                            if (obj == null || obj2 == null) {
                                throw new AssertionError();
                            }
                            DiffUtil.ItemCallback<T> itemCallback = AsyncListDiffer.this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                            return DiffUtil.ItemCallback.getAuthRequestContext();
                        }
                    });
                    AsyncListDiffer.this.getAuthRequestContext.execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AsyncListDiffer.this.MyBillsEntityDataFactory == i) {
                                AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                                List<T> list3 = list;
                                DiffUtil.DiffResult diffResult = authRequestContext;
                                Runnable runnable2 = runnable;
                                List<T> list4 = asyncListDiffer.moveToNextValue;
                                asyncListDiffer.PlaceComponentResult = list3;
                                asyncListDiffer.moveToNextValue = Collections.unmodifiableList(list3);
                                diffResult.MyBillsEntityDataFactory(asyncListDiffer.lookAheadTest);
                                asyncListDiffer.MyBillsEntityDataFactory(runnable2);
                            }
                        }
                    });
                }
            });
        }
    }

    final void MyBillsEntityDataFactory(Runnable runnable) {
        for (ListListener<T> listListener : this.KClassImpl$Data$declaredNonStaticMembers$2) {
        }
        if (runnable != null) {
            runnable.run();
        }
    }
}
