package id.dana.utils;

import androidx.viewpager2.widget.ViewPager2;
import id.dana.base.BaseFragmentViewPager2StateAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/utils/ViewPager2Adapter;", "", "", "MyBillsEntityDataFactory", "()Z", "Lid/dana/base/BaseFragmentViewPager2StateAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/base/BaseFragmentViewPager2StateAdapter;", "Landroidx/viewpager2/widget/ViewPager2;", "getAuthRequestContext", "Landroidx/viewpager2/widget/ViewPager2;", "p0", "p1", "<init>", "(Landroidx/viewpager2/widget/ViewPager2;Lid/dana/base/BaseFragmentViewPager2StateAdapter;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewPager2Adapter {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final BaseFragmentViewPager2StateAdapter MyBillsEntityDataFactory;
    public final ViewPager2 getAuthRequestContext;

    public /* synthetic */ ViewPager2Adapter(ViewPager2 viewPager2, BaseFragmentViewPager2StateAdapter baseFragmentViewPager2StateAdapter, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewPager2, baseFragmentViewPager2StateAdapter);
    }

    private ViewPager2Adapter(ViewPager2 viewPager2, BaseFragmentViewPager2StateAdapter baseFragmentViewPager2StateAdapter) {
        viewPager2.setAdapter(baseFragmentViewPager2StateAdapter);
        this.getAuthRequestContext = viewPager2;
        this.MyBillsEntityDataFactory = baseFragmentViewPager2StateAdapter;
    }

    public final boolean MyBillsEntityDataFactory() {
        BaseFragmentViewPager2StateAdapter baseFragmentViewPager2StateAdapter = this.MyBillsEntityDataFactory;
        return baseFragmentViewPager2StateAdapter.PlaceComponentResult.get(this.getAuthRequestContext.getCurrentItem()).onBackPressed();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/utils/ViewPager2Adapter$Companion;", "", "Landroidx/viewpager2/widget/ViewPager2;", "p0", "Lid/dana/base/BaseFragmentViewPager2StateAdapter;", "p1", "Lid/dana/utils/ViewPager2Adapter;", "PlaceComponentResult", "(Landroidx/viewpager2/widget/ViewPager2;Lid/dana/base/BaseFragmentViewPager2StateAdapter;)Lid/dana/utils/ViewPager2Adapter;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ViewPager2Adapter PlaceComponentResult(ViewPager2 p0, BaseFragmentViewPager2StateAdapter p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return new ViewPager2Adapter(p0, p1, null);
        }
    }
}
