package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* loaded from: classes6.dex */
class TileList<T> {
    Tile<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final SparseArray<Tile<T>> getAuthRequestContext;

    /* loaded from: classes6.dex */
    public static class Tile<T> {
        public final T[] KClassImpl$Data$declaredNonStaticMembers$2;
        public int MyBillsEntityDataFactory;
        public int PlaceComponentResult;
        Tile<T> getAuthRequestContext;

        public Tile(Class<T> cls, int i) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        }
    }
}
