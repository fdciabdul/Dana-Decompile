package id.dana.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private float BuiltInFictitiousFunctionClassFactory;
    private float KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private int PlaceComponentResult;
    private final Paint getAuthRequestContext;

    public DividerItemDecoration(Context context, int i, float f, char c) {
        this(context, i, 0.5f, 80, f);
        this.MyBillsEntityDataFactory = true;
    }

    public DividerItemDecoration(Context context, int i, float f, byte b) {
        this(context, i, 0.5f, 80, f);
    }

    public DividerItemDecoration(Context context, int i, byte b) {
        this(context, i, 0.5f, 48, 0.0f);
    }

    public DividerItemDecoration(Context context, int i, float f) {
        this(context, i, f, 80, 0.0f);
    }

    private DividerItemDecoration(Context context, int i, float f, int i2, float f2) {
        this.PlaceComponentResult = 80;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        Paint paint = new Paint();
        this.getAuthRequestContext = paint;
        paint.setColor(i);
        paint.setStrokeWidth(TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics()));
        this.PlaceComponentResult = i2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = f2;
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
    }

    public DividerItemDecoration(Context context, int i, int i2) {
        this.PlaceComponentResult = 80;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        Paint paint = new Paint();
        this.getAuthRequestContext = paint;
        this.PlaceComponentResult = i2;
        paint.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, 17170445));
        paint.setStrokeWidth(context.getResources().getDimension(i));
    }

    public DividerItemDecoration(Context context, int i) {
        this.PlaceComponentResult = 80;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0.0f;
        this.BuiltInFictitiousFunctionClassFactory = 0.0f;
        Paint paint = new Paint();
        this.getAuthRequestContext = paint;
        paint.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, 17170445));
        paint.setStrokeWidth(context.getResources().getDimension(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        float strokeWidth = this.getAuthRequestContext.getStrokeWidth() / 2.0f;
        for (int i2 = 0; i2 < recyclerView.getChildCount(); i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int absoluteAdapterPosition = ((RecyclerView.LayoutParams) childAt.getLayoutParams()).getAbsoluteAdapterPosition();
            if (state.BuiltInFictitiousFunctionClassFactory) {
                i = state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                i = state.scheduleImpl;
            }
            if (absoluteAdapterPosition < i) {
                canvas.drawLine(childAt.getLeft() + this.KClassImpl$Data$declaredNonStaticMembers$2, childAt.getBottom() + strokeWidth, childAt.getRight() - this.BuiltInFictitiousFunctionClassFactory, childAt.getBottom() + strokeWidth, this.getAuthRequestContext);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i;
        int i2;
        int absoluteAdapterPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getAbsoluteAdapterPosition();
        if (this.MyBillsEntityDataFactory) {
            if (state.BuiltInFictitiousFunctionClassFactory) {
                i2 = state.getErrorConfigVersion - state.PlaceComponentResult;
            } else {
                i2 = state.scheduleImpl;
            }
            i = i2 - 1;
        } else if (state.BuiltInFictitiousFunctionClassFactory) {
            i = state.getErrorConfigVersion - state.PlaceComponentResult;
        } else {
            i = state.scheduleImpl;
        }
        if (absoluteAdapterPosition < i) {
            int i3 = this.PlaceComponentResult;
            if (i3 != 3) {
                if (i3 != 5) {
                    if (i3 == 48) {
                        rect.set(0, (int) this.getAuthRequestContext.getStrokeWidth(), 0, 0);
                        return;
                    } else if (i3 != 8388611) {
                        if (i3 != 8388613) {
                            rect.set(0, 0, 0, (int) this.getAuthRequestContext.getStrokeWidth());
                            return;
                        }
                    }
                }
                rect.set(0, 0, (int) this.getAuthRequestContext.getStrokeWidth(), 0);
                return;
            }
            rect.set((int) this.getAuthRequestContext.getStrokeWidth(), 0, 0, 0);
            return;
        }
        rect.setEmpty();
    }
}
