package id.dana.sendmoney.util;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/viewpager2/widget/ViewPager2;", "", "p0", "", "p1", "", "MyBillsEntityDataFactory", "(Landroidx/viewpager2/widget/ViewPager2;IZ)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewPagerExtKt {
    public static final void MyBillsEntityDataFactory(ViewPager2 viewPager2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(viewPager2, "");
        if (viewPager2.getCurrentItem() + 1 < i) {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1, z);
        }
    }
}
