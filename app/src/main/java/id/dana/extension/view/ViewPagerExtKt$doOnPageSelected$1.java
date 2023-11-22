package id.dana.extension.view;

import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/extension/view/ViewPagerExtKt$doOnPageSelected$1;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "p0", "", "onPageSelected", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes5.dex */
public final class ViewPagerExtKt$doOnPageSelected$1 extends ViewPager2.OnPageChangeCallback {
    final /* synthetic */ Function1<Integer, Unit> PlaceComponentResult;

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageSelected(int p0) {
        this.PlaceComponentResult.invoke(Integer.valueOf(p0));
    }
}
