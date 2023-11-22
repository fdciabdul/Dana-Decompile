package id.dana.nearbyme.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0011\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0018"}, d2 = {"Lid/dana/nearbyme/adapter/NearbyDividerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "p0", "Landroid/view/View;", "p1", "Landroidx/recyclerview/widget/RecyclerView;", "p2", "Landroidx/recyclerview/widget/RecyclerView$State;", "p3", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/graphics/Canvas;", "onDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "", "getAuthRequestContext", "Z", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "MyBillsEntityDataFactory", "<init>", "(Landroid/content/Context;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class NearbyDividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Paint MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    public NearbyDividerItemDecoration(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.PlaceComponentResult = z;
        Paint paint = new Paint();
        paint.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.GetContactSyncConfig_res_0x7f060337));
        paint.setStrokeWidth(TypedValue.applyDimension(1, 0.5f, context.getResources().getDisplayMetrics()));
        this.MyBillsEntityDataFactory = paint;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas p0, RecyclerView p1, RecyclerView.State p2) {
        int i;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        int strokeWidth = (int) (this.MyBillsEntityDataFactory.getStrokeWidth() / 2.0f);
        int childCount = !this.PlaceComponentResult ? p1.getChildCount() - 1 : p1.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ViewGroup.LayoutParams layoutParams = p1.getChildAt(i2).getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            }
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            float applyDimension = !this.PlaceComponentResult ? 0.0f : TypedValue.applyDimension(1, 16.0f, this.BuiltInFictitiousFunctionClassFactory.getResources().getDisplayMetrics());
            int viewAdapterPosition = layoutParams2.getViewAdapterPosition();
            if (p2.BuiltInFictitiousFunctionClassFactory) {
                i = p2.getErrorConfigVersion - p2.PlaceComponentResult;
            } else {
                i = p2.scheduleImpl;
            }
            if (viewAdapterPosition < i) {
                float f = strokeWidth;
                p0.drawLine(r4.getLeft() + applyDimension, r4.getBottom() + f, r4.getRight() - applyDimension, f + r4.getBottom(), this.MyBillsEntityDataFactory);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect p0, View p1, RecyclerView p2, RecyclerView.State p3) {
        int i;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        int childAdapterPosition = p2.getChildAdapterPosition(p1);
        if (p3.BuiltInFictitiousFunctionClassFactory) {
            i = p3.getErrorConfigVersion - p3.PlaceComponentResult;
        } else {
            i = p3.scheduleImpl;
        }
        if (childAdapterPosition == i - 1 && !this.PlaceComponentResult) {
            p0.setEmpty();
        } else {
            p0.set(0, 0, 0, (int) this.MyBillsEntityDataFactory.getStrokeWidth());
        }
    }
}
