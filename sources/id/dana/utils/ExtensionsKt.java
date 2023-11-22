package id.dana.utils;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"reduceDragSensitivity", "", "Landroidx/viewpager2/widget/ViewPager2;", "reduceStrength", "", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ExtensionsKt {
    public static /* synthetic */ void MyBillsEntityDataFactory(ViewPager2 viewPager2) {
        getAuthRequestContext(viewPager2, 7);
    }

    public static final void getAuthRequestContext(ViewPager2 viewPager2, int i) {
        Intrinsics.checkNotNullParameter(viewPager2, "");
        Field declaredField = ViewPager2.class.getDeclaredField("mRecyclerView");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(viewPager2);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        }
        RecyclerView recyclerView = (RecyclerView) obj;
        Field declaredField2 = RecyclerView.class.getDeclaredField("mTouchSlop");
        declaredField2.setAccessible(true);
        Object obj2 = declaredField2.get(recyclerView);
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        declaredField2.set(recyclerView, Integer.valueOf(((Integer) obj2).intValue() * i));
    }
}
