package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: classes3.dex */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {
    private final LinearLayoutManager BuiltInFictitiousFunctionClassFactory;
    ViewPager2.PageTransformer PlaceComponentResult;

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageSelected(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.BuiltInFictitiousFunctionClassFactory = linearLayoutManager;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageScrolled(int i, float f, int i2) {
        if (this.PlaceComponentResult == null) {
            return;
        }
        float f2 = -f;
        for (int i3 = 0; i3 < this.BuiltInFictitiousFunctionClassFactory.getChildCount(); i3++) {
            View childAt = this.BuiltInFictitiousFunctionClassFactory.getChildAt(i3);
            if (childAt == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.getChildCount())));
            }
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(childAt, (this.BuiltInFictitiousFunctionClassFactory.getPosition(childAt) - i) + f2);
        }
    }
}
