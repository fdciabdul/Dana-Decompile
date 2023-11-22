package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes3.dex */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    private final int KClassImpl$Data$declaredNonStaticMembers$2;

    public MarginPageTransformer(int i) {
        Preconditions.MyBillsEntityDataFactory(i, "Margin must be non-negative");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public final void KClassImpl$Data$declaredNonStaticMembers$2(View view, float f) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            ViewPager2 viewPager2 = (ViewPager2) parent2;
            float f2 = this.KClassImpl$Data$declaredNonStaticMembers$2 * f;
            if (viewPager2.getOrientation() == 0) {
                if (viewPager2.isRtl()) {
                    f2 = -f2;
                }
                view.setTranslationX(f2);
                return;
            }
            view.setTranslationY(f2);
            return;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }
}
