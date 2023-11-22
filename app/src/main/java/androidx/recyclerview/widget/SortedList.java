package androidx.recyclerview.widget;

import java.util.Comparator;

/* loaded from: classes6.dex */
public class SortedList<T> {

    /* loaded from: classes6.dex */
    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract void BuiltInFictitiousFunctionClassFactory(int i, int i2);

        @Override // java.util.Comparator
        public abstract int compare(T2 t2, T2 t22);

        public void getAuthRequestContext(int i, int i2, Object obj) {
            BuiltInFictitiousFunctionClassFactory(i, i2);
        }
    }

    /* loaded from: classes6.dex */
    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback PlaceComponentResult;
        final Callback<T2> getAuthRequestContext;

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t2, T2 t22) {
            return this.getAuthRequestContext.compare(t2, t22);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public final void PlaceComponentResult(int i, int i2) {
            this.PlaceComponentResult.PlaceComponentResult(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(i, i2);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public final void getAuthRequestContext(int i, int i2) {
            BatchingListUpdateCallback batchingListUpdateCallback = this.PlaceComponentResult;
            batchingListUpdateCallback.getAuthRequestContext();
            batchingListUpdateCallback.getAuthRequestContext.getAuthRequestContext(i, i2);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public final void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            this.PlaceComponentResult.getAuthRequestContext(i, i2, null);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public final void getAuthRequestContext(int i, int i2, Object obj) {
            this.PlaceComponentResult.getAuthRequestContext(i, i2, obj);
        }
    }
}
