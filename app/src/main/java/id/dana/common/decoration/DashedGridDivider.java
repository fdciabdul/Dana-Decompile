package id.dana.common.decoration;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.utils.SizeUtil;

/* loaded from: classes4.dex */
public class DashedGridDivider extends RecyclerView.ItemDecoration {
    private boolean[] BuiltInFictitiousFunctionClassFactory;
    private final int KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean[] MyBillsEntityDataFactory;
    private final Rect PlaceComponentResult;
    private float[] getAuthRequestContext;
    private Paint moveToNextValue;

    /* loaded from: classes4.dex */
    public static class Builder {
        public int PlaceComponentResult;
        public int KClassImpl$Data$declaredNonStaticMembers$2 = SizeUtil.getAuthRequestContext(2);
        public int getAuthRequestContext = SizeUtil.getAuthRequestContext(4);
        public int MyBillsEntityDataFactory = SizeUtil.getAuthRequestContext(1);
        public boolean[] BuiltInFictitiousFunctionClassFactory = {true, true, true, true};
        public boolean[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {false, false, false, false};
        public float[] moveToNextValue = {0.0f, 0.0f, 0.0f, 0.0f};
    }

    public /* synthetic */ DashedGridDivider(int i, int i2, int i3, int i4, boolean[] zArr, boolean[] zArr2, float[] fArr, byte b) {
        this(i, i2, i3, i4, zArr, zArr2, fArr);
    }

    private DashedGridDivider(int i, int i2, int i3, int i4, boolean[] zArr, boolean[] zArr2, float[] fArr) {
        this.PlaceComponentResult = new Rect();
        Paint paint = new Paint(1);
        this.moveToNextValue = paint;
        paint.setColor(i4);
        this.moveToNextValue.setStyle(Paint.Style.STROKE);
        this.moveToNextValue.setStrokeWidth(i3);
        this.moveToNextValue.setPathEffect(new DashPathEffect(new float[]{i2, i}, 0.0f));
        this.MyBillsEntityDataFactory = zArr;
        this.BuiltInFictitiousFunctionClassFactory = zArr2;
        this.getAuthRequestContext = fArr;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getLayoutManager() == null) {
            return;
        }
        boolean[] zArr = this.MyBillsEntityDataFactory;
        int i = 1;
        if (zArr[1] || zArr[3]) {
            canvas.save();
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                int i2 = layoutManager instanceof GridLayoutManager ? ((GridLayoutManager) layoutManager).getErrorConfigVersion : 0;
                int childCount = recyclerView.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = recyclerView.getChildAt(i3);
                    if (!getAuthRequestContext(recyclerView, childAt)) {
                        layoutManager.getDecoratedBoundsWithMargins(childAt, this.PlaceComponentResult);
                        float translationX = this.PlaceComponentResult.left + childAt.getTranslationX() + this.getAuthRequestContext[0];
                        float translationX2 = (this.PlaceComponentResult.right - childAt.getTranslationX()) - this.getAuthRequestContext[2];
                        if (!this.MyBillsEntityDataFactory[3]) {
                            float translationY = this.PlaceComponentResult.top + childAt.getTranslationY() + this.moveToNextValue.getStrokeWidth();
                            canvas.drawLine(translationX, translationY, translationX2, translationY, this.moveToNextValue);
                        } else {
                            if (this.BuiltInFictitiousFunctionClassFactory[3]) {
                                int i4 = childCount % i2;
                                if (i4 == 0) {
                                    if (i3 < childCount - i2) {
                                        float translationY2 = (this.PlaceComponentResult.bottom - childAt.getTranslationY()) - this.moveToNextValue.getStrokeWidth();
                                        canvas.drawLine(translationX, translationY2, translationX2, translationY2, this.moveToNextValue);
                                    }
                                } else if (i3 < childCount - i4 && i3 < childCount - i2) {
                                    float translationY3 = (this.PlaceComponentResult.bottom - childAt.getTranslationY()) - this.moveToNextValue.getStrokeWidth();
                                    canvas.drawLine(translationX, translationY3, translationX2, translationY3, this.moveToNextValue);
                                }
                            }
                            if (this.MyBillsEntityDataFactory[1] && i3 < i2 && !this.BuiltInFictitiousFunctionClassFactory[1]) {
                                float translationY4 = this.PlaceComponentResult.top + childAt.getTranslationY() + this.moveToNextValue.getStrokeWidth();
                                canvas.drawLine(translationX, translationY4, translationX2, translationY4, this.moveToNextValue);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }
        boolean[] zArr2 = this.MyBillsEntityDataFactory;
        if (zArr2[0] || zArr2[2]) {
            canvas.save();
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            if (layoutManager2 != null) {
                boolean z = layoutManager2 instanceof GridLayoutManager;
                int i5 = z ? ((GridLayoutManager) layoutManager2).getErrorConfigVersion : 0;
                int childCount2 = recyclerView.getChildCount();
                int i6 = 0;
                while (i6 < childCount2) {
                    View childAt2 = recyclerView.getChildAt(i6);
                    if (!getAuthRequestContext(recyclerView, childAt2)) {
                        layoutManager2.getDecoratedBoundsWithMargins(childAt2, this.PlaceComponentResult);
                        float translationY5 = this.PlaceComponentResult.top + childAt2.getTranslationY() + this.getAuthRequestContext[i];
                        float translationY6 = (this.PlaceComponentResult.bottom + childAt2.getTranslationY()) - this.getAuthRequestContext[3];
                        int BuiltInFictitiousFunctionClassFactory = z ? ((GridLayoutManager) layoutManager2).moveToNextValue.BuiltInFictitiousFunctionClassFactory(recyclerView.getChildAdapterPosition(childAt2), i5) : i6;
                        if (!this.MyBillsEntityDataFactory[2]) {
                            float translationX3 = this.PlaceComponentResult.left + childAt2.getTranslationX() + this.moveToNextValue.getStrokeWidth();
                            canvas.drawLine(translationX3, translationY5, translationX3, translationY6, this.moveToNextValue);
                        } else if (!this.BuiltInFictitiousFunctionClassFactory[2] || (BuiltInFictitiousFunctionClassFactory + i) % i5 != 0) {
                            float translationX4 = (this.PlaceComponentResult.right - childAt2.getTranslationX()) - this.moveToNextValue.getStrokeWidth();
                            canvas.drawLine(translationX4, translationY5, translationX4, translationY6, this.moveToNextValue);
                            if (this.MyBillsEntityDataFactory[0] && i6 % i5 == 0 && !this.BuiltInFictitiousFunctionClassFactory[0]) {
                                float translationX5 = this.PlaceComponentResult.left + childAt2.getTranslationX() + this.moveToNextValue.getStrokeWidth();
                                canvas.drawLine(translationX5, translationY5, translationX5, translationY6, this.moveToNextValue);
                            }
                        }
                    }
                    i6++;
                    i = 1;
                }
                canvas.restore();
            }
        }
    }

    private static boolean getAuthRequestContext(RecyclerView recyclerView, View view) {
        return (recyclerView.getAdapter() != null ? recyclerView.getAdapter().getItemViewType(((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition()) : 0) == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if ((recyclerView.getAdapter() != null ? recyclerView.getAdapter().getItemViewType(((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition()) : 0) == 1) {
            rect.setEmpty();
        }
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        rect.set(i, i, i, i);
    }
}
