package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes6.dex */
public class SharedValues {
    private SparseIntArray KClassImpl$Data$declaredNonStaticMembers$2 = new SparseIntArray();
    HashMap<Integer, HashSet<WeakReference<SharedValuesListener>>> PlaceComponentResult = new HashMap<>();

    /* loaded from: classes6.dex */
    public interface SharedValuesListener {
    }

    public final void getAuthRequestContext(int i, SharedValuesListener sharedValuesListener) {
        HashSet<WeakReference<SharedValuesListener>> hashSet = this.PlaceComponentResult.get(Integer.valueOf(i));
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.PlaceComponentResult.put(Integer.valueOf(i), hashSet);
        }
        hashSet.add(new WeakReference<>(sharedValuesListener));
    }
}
