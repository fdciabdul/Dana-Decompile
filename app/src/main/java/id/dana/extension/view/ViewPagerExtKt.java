package id.dana.extension.view;

import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import id.dana.usereducation.constant.BottomSheetType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0006\u001a&\u0010\t\u001a\u00020\u0001*\u00020\u00042\u0014\b\u0004\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"attachViewPager", "", "Lcom/google/android/material/tabs/TabLayout;", BottomSheetType.VIEW_PAGER, "Landroidx/viewpager2/widget/ViewPager2;", "onConfigureTab", "Lkotlin/Function2;", "Lcom/google/android/material/tabs/TabLayout$Tab;", "", "doOnPageSelected", "action", "Lkotlin/Function1;", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewPagerExtKt {
    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(TabLayout tabLayout, ViewPager2 viewPager2) {
        getAuthRequestContext(tabLayout, viewPager2, new Function2<TabLayout.Tab, Integer, Unit>() { // from class: id.dana.extension.view.ViewPagerExtKt$attachViewPager$1
            public final void invoke(TabLayout.Tab tab, int i) {
                Intrinsics.checkNotNullParameter(tab, "");
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
                invoke(tab, num.intValue());
                return Unit.INSTANCE;
            }
        });
    }

    public static final void getAuthRequestContext(TabLayout tabLayout, ViewPager2 viewPager2, final Function2<? super TabLayout.Tab, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(tabLayout, "");
        Intrinsics.checkNotNullParameter(viewPager2, "");
        Intrinsics.checkNotNullParameter(function2, "");
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() { // from class: id.dana.extension.view.ViewPagerExtKt$$ExternalSyntheticLambda0
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                ViewPagerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(Function2.this, tab, i);
            }
        }).attach();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Function2 function2, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(function2, "");
        Intrinsics.checkNotNullParameter(tab, "");
        function2.invoke(tab, Integer.valueOf(i));
    }
}
