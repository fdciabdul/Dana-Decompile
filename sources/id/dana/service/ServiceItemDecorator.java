package id.dana.service;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public class ServiceItemDecorator extends RecyclerView.ItemDecoration {
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private final Paint getAuthRequestContext;

    public ServiceItemDecorator(Context context, int i) {
        Paint paint = new Paint();
        this.getAuthRequestContext = paint;
        paint.setColor(i);
        paint.setStrokeWidth(TypedValue.applyDimension(1, 8.0f, context.getResources().getDisplayMetrics()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int strokeWidth = (int) (this.getAuthRequestContext.getStrokeWidth() / 2.0f);
        for (int i = 0; i < recyclerView.getChildCount(); i++) {
            if (1 == (recyclerView.getAdapter() != null ? recyclerView.getAdapter().getItemViewType(((RecyclerView.LayoutParams) recyclerView.getChildAt(i).getLayoutParams()).getBindingAdapterPosition()) : 0)) {
                float f = strokeWidth;
                canvas.drawLine(r2.getLeft(), r2.getTop() - f, r2.getRight(), r2.getTop() - f, this.getAuthRequestContext);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int bindingAdapterPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getBindingAdapterPosition();
        if (1 == (recyclerView.getAdapter() != null ? recyclerView.getAdapter().getItemViewType(bindingAdapterPosition) : 0)) {
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2 && bindingAdapterPosition == 0) {
                rect.setEmpty();
            } else {
                rect.set(0, (int) this.getAuthRequestContext.getStrokeWidth(), 0, 0);
            }
        }
    }
}
