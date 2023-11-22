package id.dana.animation.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0005\u001a\u00020\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012"}, d2 = {"Lid/dana/home/view/GridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "p0", "Landroid/view/View;", "p1", "Landroidx/recyclerview/widget/RecyclerView;", "p2", "Landroidx/recyclerview/widget/RecyclerView$State;", "p3", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "", "PlaceComponentResult", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "<init>", "(Landroid/content/Context;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GridItemDecoration extends RecyclerView.ItemDecoration {
    private final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final int MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    public GridItemDecoration(Context context, int i, int i2) {
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.MyBillsEntityDataFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
        if (context != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (int) (i2 * context.getResources().getDisplayMetrics().density);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect p0, View p1, RecyclerView p2, RecyclerView.State p3) {
        int i;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        int childAdapterPosition = p2.getChildAdapterPosition(p1) + 1;
        if (p3.BuiltInFictitiousFunctionClassFactory) {
            i = p3.getErrorConfigVersion - p3.PlaceComponentResult;
        } else {
            i = p3.scheduleImpl;
        }
        p0.top = this.KClassImpl$Data$declaredNonStaticMembers$2 / 2;
        p0.bottom = this.KClassImpl$Data$declaredNonStaticMembers$2 / 2;
        p0.right = this.KClassImpl$Data$declaredNonStaticMembers$2 / 2;
        p0.left = this.KClassImpl$Data$declaredNonStaticMembers$2 / 2;
        if (childAdapterPosition <= this.MyBillsEntityDataFactory) {
            p0.top = 0;
        }
        if ((i - this.MyBillsEntityDataFactory) + 1 <= childAdapterPosition && childAdapterPosition <= i) {
            p0.bottom = 0;
        }
        if (childAdapterPosition % this.MyBillsEntityDataFactory == 0) {
            p0.right = 0;
        }
        if (childAdapterPosition % this.MyBillsEntityDataFactory == 1) {
            p0.left = 0;
        }
        if (i % 2 == 1 && childAdapterPosition == i - 1) {
            p0.bottom = this.KClassImpl$Data$declaredNonStaticMembers$2 / 2;
        }
    }
}
