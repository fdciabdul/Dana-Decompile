package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes3.dex */
public final class DirectedAcyclicGraph<T> {
    final Pools.Pool<ArrayList<T>> getAuthRequestContext = new Pools.SimplePool(10);
    final SimpleArrayMap<T, ArrayList<T>> KClassImpl$Data$declaredNonStaticMembers$2 = new SimpleArrayMap<>();
    final ArrayList<T> MyBillsEntityDataFactory = new ArrayList<>();
    final HashSet<T> BuiltInFictitiousFunctionClassFactory = new HashSet<>();

    public final boolean MyBillsEntityDataFactory(T t) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.containsKey(t);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(T t) {
        int size = this.KClassImpl$Data$declaredNonStaticMembers$2.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue[(i << 1) + 1];
            if (arrayList != null && arrayList.contains(t)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        ArrayList<T> arrayList2 = this.KClassImpl$Data$declaredNonStaticMembers$2.get(t);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                BuiltInFictitiousFunctionClassFactory(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }
}
