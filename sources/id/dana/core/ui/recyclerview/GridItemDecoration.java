package id.dana.core.ui.recyclerview;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0005\u001a\u00020\u0011\u0012\u0006\u0010\u0007\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0014\u0010\u000e\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012"}, d2 = {"Lid/dana/core/ui/recyclerview/GridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "p0", "Landroid/view/View;", "p1", "Landroidx/recyclerview/widget/RecyclerView;", "p2", "Landroidx/recyclerview/widget/RecyclerView$State;", "p3", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "MyBillsEntityDataFactory", "", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GridItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final int BuiltInFictitiousFunctionClassFactory = 2;

    public GridItemDecoration(Context context) {
        this.MyBillsEntityDataFactory = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 8;
        if (context != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (int) (context.getResources().getDisplayMetrics().density * 8.0f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        if ((((((int) java.lang.Math.ceil(r2 / r4)) - 1) * r9) + 1 <= r8 && r8 <= r1) != false) goto L23;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getItemOffsets(android.graphics.Rect r7, android.view.View r8, androidx.recyclerview.widget.RecyclerView r9, androidx.recyclerview.widget.RecyclerView.State r10) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r8 = r9.getChildAdapterPosition(r8)
            r0 = 1
            int r8 = r8 + r0
            boolean r1 = r10.BuiltInFictitiousFunctionClassFactory
            if (r1 == 0) goto L1e
            int r1 = r10.getErrorConfigVersion
            int r10 = r10.PlaceComponentResult
            int r1 = r1 - r10
            goto L20
        L1e:
            int r1 = r10.scheduleImpl
        L20:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r9 = r9.getLayoutManager()
            boolean r10 = r9 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r10 == 0) goto L2b
            androidx.recyclerview.widget.GridLayoutManager r9 = (androidx.recyclerview.widget.GridLayoutManager) r9
            goto L2c
        L2b:
            r9 = 0
        L2c:
            if (r9 == 0) goto L31
            int r9 = r9.getErrorConfigVersion
            goto L32
        L31:
            r9 = 1
        L32:
            int r10 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            int r10 = r10 / 2
            r7.top = r10
            int r10 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            int r10 = r10 / 2
            r7.bottom = r10
            int r10 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            int r10 = r10 / 2
            r7.right = r10
            int r10 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            int r10 = r10 / 2
            r7.left = r10
            r10 = 0
            if (r8 > r9) goto L4f
            r7.top = r10
        L4f:
            if (r1 <= r9) goto L6c
            double r2 = (double) r1
            double r4 = (double) r9
            java.lang.Double.isNaN(r2)
            java.lang.Double.isNaN(r4)
            double r2 = r2 / r4
            double r2 = java.lang.Math.ceil(r2)
            int r2 = (int) r2
            int r2 = r2 - r0
            int r2 = r2 * r9
            int r2 = r2 + r0
            if (r2 > r8) goto L69
            if (r8 > r1) goto L69
            r1 = 1
            goto L6a
        L69:
            r1 = 0
        L6a:
            if (r1 == 0) goto L6e
        L6c:
            r7.bottom = r10
        L6e:
            int r8 = r8 % r9
            if (r8 != 0) goto L73
            r7.right = r10
        L73:
            if (r8 != r0) goto L77
            r7.left = r10
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.recyclerview.GridItemDecoration.getItemOffsets(android.graphics.Rect, android.view.View, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }
}
