package id.dana.mybills.swipeaction;

import android.content.Context;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\r\u0012\u0006\u0010\u0005\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000e"}, d2 = {"Lid/dana/mybills/swipeaction/MyBillsSwipeController;", "Lid/dana/mybills/swipeaction/SwipeController;", "Landroid/graphics/Canvas;", "p0", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "p1", "", "PlaceComponentResult", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "Landroidx/recyclerview/widget/RecyclerView;", "", "getMovementFlags", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)I", "Landroid/content/Context;", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Lid/dana/mybills/swipeaction/SwipeControllerActions;", "<init>", "(Landroid/content/Context;Lid/dana/mybills/swipeaction/SwipeControllerActions;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBillsSwipeController extends SwipeController {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyBillsSwipeController(Context context, SwipeControllerActions swipeControllerActions) {
        super(swipeControllerActions);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(swipeControllerActions, "");
        this.MyBillsEntityDataFactory = context;
    }

    @Override // id.dana.mybills.swipeaction.SwipeController, androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final int getMovementFlags(RecyclerView p0, RecyclerView.ViewHolder p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (p1.getItemViewType() == 2) {
            return 0;
        }
        return ItemTouchHelper.Callback.makeMovementFlags(0, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a3  */
    @Override // id.dana.mybills.swipeaction.SwipeController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(android.graphics.Canvas r13, androidx.recyclerview.widget.RecyclerView.ViewHolder r14) {
        /*
            r12 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            int r1 = r12.getGetAuthRequestContext()
            android.view.View r2 = r14.itemView
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            android.graphics.Paint r3 = new android.graphics.Paint
            r3.<init>()
            android.content.Context r4 = r12.MyBillsEntityDataFactory
            r5 = 2131233392(0x7f080a70, float:1.808292E38)
            android.graphics.drawable.Drawable r4 = androidx.core.content.ContextCompat.PlaceComponentResult(r4, r5)
            int r6 = r14.getItemViewType()
            r7 = 1
            if (r6 == 0) goto L4b
            if (r6 == r7) goto L29
            goto L6c
        L29:
            android.content.Context r4 = r12.MyBillsEntityDataFactory
            r5 = 2131955589(0x7f130f85, float:1.954771E38)
            java.lang.String r4 = r4.getString(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.content.Context r0 = r12.MyBillsEntityDataFactory
            r5 = 2131099753(0x7f060069, float:1.7811868E38)
            int r0 = androidx.core.content.ContextCompat.BuiltInFictitiousFunctionClassFactory(r0, r5)
            r3.setColor(r0)
            android.content.Context r0 = r12.MyBillsEntityDataFactory
            r5 = 2131233389(0x7f080a6d, float:1.8082914E38)
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.PlaceComponentResult(r0, r5)
            goto L69
        L4b:
            android.content.Context r4 = r12.MyBillsEntityDataFactory
            r6 = 2131955590(0x7f130f86, float:1.9547712E38)
            java.lang.String r4 = r4.getString(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.content.Context r0 = r12.MyBillsEntityDataFactory
            r6 = 2131099979(0x7f06014b, float:1.7812326E38)
            int r0 = androidx.core.content.ContextCompat.BuiltInFictitiousFunctionClassFactory(r0, r6)
            r3.setColor(r0)
            android.content.Context r0 = r12.MyBillsEntityDataFactory
            android.graphics.drawable.Drawable r0 = androidx.core.content.ContextCompat.PlaceComponentResult(r0, r5)
        L69:
            r11 = r4
            r4 = r0
            r0 = r11
        L6c:
            r5 = 0
            if (r4 == 0) goto L7c
            int r6 = r4.getIntrinsicWidth()
            int r8 = r4.getIntrinsicHeight()
            android.graphics.Bitmap r4 = androidx.core.graphics.drawable.DrawableKt.PlaceComponentResult(r4, r6, r8)
            goto L7d
        L7c:
            r4 = r5
        L7d:
            int r6 = r2.getRight()
            float r6 = (float) r6
            int r1 = r1 + (-20)
            float r1 = (float) r1
            int r8 = r2.getTop()
            float r8 = (float) r8
            int r9 = r2.getRight()
            float r9 = (float) r9
            int r2 = r2.getBottom()
            float r2 = (float) r2
            android.graphics.RectF r10 = new android.graphics.RectF
            float r6 = r6 - r1
            r10.<init>(r6, r8, r9, r2)
            r1 = 1098907648(0x41800000, float:16.0)
            r13.drawRoundRect(r10, r1, r1, r3)
            r1 = 1094713344(0x41400000, float:12.0)
            if (r4 == 0) goto Lba
            float r2 = r10.centerX()
            int r6 = r4.getWidth()
            int r6 = r6 / 2
            float r6 = (float) r6
            float r8 = r10.top
            int r9 = id.dana.extension.view.ViewExtKt.PlaceComponentResult(r1)
            float r9 = (float) r9
            float r2 = r2 - r6
            float r8 = r8 + r9
            r13.drawBitmap(r4, r2, r8, r5)
        Lba:
            float r2 = id.dana.extension.view.ViewExtKt.MyBillsEntityDataFactory()
            android.content.Context r4 = r12.MyBillsEntityDataFactory
            r5 = 2131296266(0x7f09000a, float:1.8210444E38)
            android.graphics.Typeface r4 = androidx.core.content.res.ResourcesCompat.PlaceComponentResult(r4, r5)
            r3.setTypeface(r4)
            r4 = -1
            r3.setColor(r4)
            r3.setAntiAlias(r7)
            r3.setTextSize(r2)
            float r2 = r3.measureText(r0)
            float r4 = r10.centerX()
            r5 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r5
            float r5 = r10.bottom
            int r1 = id.dana.extension.view.ViewExtKt.PlaceComponentResult(r1)
            float r1 = (float) r1
            float r4 = r4 - r2
            float r5 = r5 - r1
            r13.drawText(r0, r4, r5, r3)
            r12.BuiltInFictitiousFunctionClassFactory(r10)
            super.PlaceComponentResult(r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.swipeaction.MyBillsSwipeController.PlaceComponentResult(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView$ViewHolder):void");
    }
}
