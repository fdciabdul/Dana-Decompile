package androidx.recyclerview.widget;

import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
    static final ItemTouchUIUtil MyBillsEntityDataFactory = new ItemTouchUIUtilImpl();

    ItemTouchUIUtilImpl() {
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public final void MyBillsEntityDataFactory(RecyclerView recyclerView, View view, float f, float f2, boolean z) {
        if (Build.VERSION.SDK_INT >= 21 && z && view.getTag(R.id.PlaceComponentResult) == null) {
            float errorConfigVersion = ViewCompat.getErrorConfigVersion(view);
            int childCount = recyclerView.getChildCount();
            float f3 = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != view) {
                    float errorConfigVersion2 = ViewCompat.getErrorConfigVersion(childAt);
                    if (errorConfigVersion2 > f3) {
                        f3 = errorConfigVersion2;
                    }
                }
            }
            ViewCompat.MyBillsEntityDataFactory(view, f3 + 1.0f);
            view.setTag(R.id.PlaceComponentResult, Float.valueOf(errorConfigVersion));
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public final void PlaceComponentResult(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object tag = view.getTag(R.id.PlaceComponentResult);
            if (tag instanceof Float) {
                ViewCompat.MyBillsEntityDataFactory(view, ((Float) tag).floatValue());
            }
            view.setTag(R.id.PlaceComponentResult, null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }
}
