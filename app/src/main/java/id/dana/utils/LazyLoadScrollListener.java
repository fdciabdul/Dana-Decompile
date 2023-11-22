package id.dana.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/utils/LazyLoadScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "p0", "", "PlaceComponentResult", "(Landroidx/recyclerview/widget/RecyclerView;)Z", "", "p1", "", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "p2", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "I", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/LazyLoadScrollListener$LazyLoadInteraction;", "MyBillsEntityDataFactory", "Lid/dana/utils/LazyLoadScrollListener$LazyLoadInteraction;", "<init>", "(ILid/dana/utils/LazyLoadScrollListener$LazyLoadInteraction;)V", "LazyLoadInteraction"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LazyLoadScrollListener extends RecyclerView.OnScrollListener {
    private final LazyLoadInteraction MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final int BuiltInFictitiousFunctionClassFactory;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lid/dana/utils/LazyLoadScrollListener$LazyLoadInteraction;", "", "onScrollingBottom", "", "onScrollingTop", "onTouchBottom", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface LazyLoadInteraction {

        /* renamed from: id.dana.utils.LazyLoadScrollListener$LazyLoadInteraction$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void MyBillsEntityDataFactory() {
            }
        }

        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void PlaceComponentResult();
    }

    public LazyLoadScrollListener(int i, LazyLoadInteraction lazyLoadInteraction) {
        Intrinsics.checkNotNullParameter(lazyLoadInteraction, "");
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.MyBillsEntityDataFactory = lazyLoadInteraction;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView p0, int p1, int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onScrolled(p0, p1, p2);
        boolean PlaceComponentResult = PlaceComponentResult(p0);
        if (p2 < 0 && !PlaceComponentResult) {
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        } else {
            this.MyBillsEntityDataFactory.PlaceComponentResult();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onScrollStateChanged(p0, p1);
        if (p0.canScrollVertically(130)) {
            return;
        }
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final boolean PlaceComponentResult(RecyclerView p0) {
        int BuiltInFictitiousFunctionClassFactory;
        RecyclerView.LayoutManager layoutManager = p0.getLayoutManager();
        int i = -1;
        if (layoutManager instanceof LinearLayoutManager) {
            i = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] iArr = new int[1];
            for (int i2 = 0; i2 <= 0; i2++) {
                iArr[0] = -1;
            }
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            if (1 < staggeredGridLayoutManager.moveToNextValue) {
                StringBuilder sb = new StringBuilder();
                sb.append("Provided int[]'s size must be more than or equal to span count. Expected:");
                sb.append(staggeredGridLayoutManager.moveToNextValue);
                sb.append(", array size:");
                sb.append(1);
                throw new IllegalArgumentException(sb.toString());
            }
            for (int i3 = 0; i3 < staggeredGridLayoutManager.moveToNextValue; i3++) {
                StaggeredGridLayoutManager.Span span = staggeredGridLayoutManager.NetworkUserEntityData$$ExternalSyntheticLambda0[i3];
                if (StaggeredGridLayoutManager.this.MyBillsEntityDataFactory) {
                    BuiltInFictitiousFunctionClassFactory = span.BuiltInFictitiousFunctionClassFactory(span.BuiltInFictitiousFunctionClassFactory.size() - 1, -1, true, true, false);
                } else {
                    BuiltInFictitiousFunctionClassFactory = span.BuiltInFictitiousFunctionClassFactory(0, span.BuiltInFictitiousFunctionClassFactory.size(), true, true, false);
                }
                iArr[i3] = BuiltInFictitiousFunctionClassFactory;
            }
            i = ArraysKt.first(iArr);
        }
        return i == this.BuiltInFictitiousFunctionClassFactory;
    }
}
