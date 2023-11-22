package androidx.viewpager2.widget;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public final class CompositePageTransformer implements ViewPager2.PageTransformer {
    private final List<ViewPager2.PageTransformer> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public final void KClassImpl$Data$declaredNonStaticMembers$2(View view, float f) {
        Iterator<ViewPager2.PageTransformer> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it.hasNext()) {
            it.next().KClassImpl$Data$declaredNonStaticMembers$2(view, f);
        }
    }
}
