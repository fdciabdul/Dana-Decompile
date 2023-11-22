package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class GhostViewPort extends ViewGroup implements GhostView {
    private Matrix BuiltInFictitiousFunctionClassFactory;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    final View MyBillsEntityDataFactory;
    ViewGroup PlaceComponentResult;
    View getAuthRequestContext;
    private final ViewTreeObserver.OnPreDrawListener scheduleImpl;

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    private GhostViewPort(View view) {
        super(view.getContext());
        this.scheduleImpl = new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.transition.GhostViewPort.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(GhostViewPort.this);
                if (GhostViewPort.this.PlaceComponentResult == null || GhostViewPort.this.getAuthRequestContext == null) {
                    return true;
                }
                GhostViewPort.this.PlaceComponentResult.endViewTransition(GhostViewPort.this.getAuthRequestContext);
                ViewCompat.VerifyPinStateManager$executeRiskChallenge$2$2(GhostViewPort.this.PlaceComponentResult);
                GhostViewPort.this.PlaceComponentResult = null;
                GhostViewPort.this.getAuthRequestContext = null;
                return true;
            }
        };
        this.MyBillsEntityDataFactory = view;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, null);
    }

    @Override // android.view.View, androidx.transition.GhostView
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (((GhostViewPort) this.MyBillsEntityDataFactory.getTag(R.id.KClassImpl$Data$declaredNonStaticMembers$2)) == this) {
            ViewUtils.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, i == 0 ? 4 : 0);
        }
    }

    @Override // androidx.transition.GhostView
    public final void BuiltInFictitiousFunctionClassFactory(ViewGroup viewGroup, View view) {
        this.PlaceComponentResult = viewGroup;
        this.getAuthRequestContext = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.MyBillsEntityDataFactory.setTag(R.id.KClassImpl$Data$declaredNonStaticMembers$2, this);
        this.MyBillsEntityDataFactory.getViewTreeObserver().addOnPreDrawListener(this.scheduleImpl);
        ViewUtils.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, 4);
        if (this.MyBillsEntityDataFactory.getParent() != null) {
            ((View) this.MyBillsEntityDataFactory.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.MyBillsEntityDataFactory.getViewTreeObserver().removeOnPreDrawListener(this.scheduleImpl);
        ViewUtils.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, 0);
        this.MyBillsEntityDataFactory.setTag(R.id.KClassImpl$Data$declaredNonStaticMembers$2, null);
        if (this.MyBillsEntityDataFactory.getParent() != null) {
            ((View) this.MyBillsEntityDataFactory.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        CanvasUtils.getAuthRequestContext(canvas, true);
        canvas.setMatrix(this.BuiltInFictitiousFunctionClassFactory);
        ViewUtils.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, 0);
        this.MyBillsEntityDataFactory.invalidate();
        ViewUtils.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, 4);
        drawChild(canvas, this.MyBillsEntityDataFactory, getDrawingTime());
        CanvasUtils.getAuthRequestContext(canvas, false);
    }

    private static void MyBillsEntityDataFactory(View view, View view2) {
        ViewUtils.getAuthRequestContext(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GhostViewPort BuiltInFictitiousFunctionClassFactory(View view, ViewGroup viewGroup, Matrix matrix) {
        int i;
        GhostViewHolder ghostViewHolder;
        if (!(view.getParent() instanceof ViewGroup)) {
            throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
        }
        GhostViewHolder MyBillsEntityDataFactory = GhostViewHolder.MyBillsEntityDataFactory(viewGroup);
        GhostViewPort ghostViewPort = (GhostViewPort) view.getTag(R.id.KClassImpl$Data$declaredNonStaticMembers$2);
        int i2 = 0;
        if (ghostViewPort == null || (ghostViewHolder = (GhostViewHolder) ghostViewPort.getParent()) == MyBillsEntityDataFactory) {
            i = 0;
        } else {
            i = ghostViewPort.KClassImpl$Data$declaredNonStaticMembers$2;
            ghostViewHolder.removeView(ghostViewPort);
            ghostViewPort = null;
        }
        if (ghostViewPort == null) {
            if (matrix == null) {
                matrix = new Matrix();
                ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                matrix.reset();
                ViewUtils.MyBillsEntityDataFactory(viewGroup2, matrix);
                matrix.preTranslate(-viewGroup2.getScrollX(), -viewGroup2.getScrollY());
                ViewUtils.BuiltInFictitiousFunctionClassFactory(viewGroup, matrix);
            }
            ghostViewPort = new GhostViewPort(view);
            ghostViewPort.BuiltInFictitiousFunctionClassFactory = matrix;
            if (MyBillsEntityDataFactory == null) {
                MyBillsEntityDataFactory = new GhostViewHolder(viewGroup);
            } else if (!MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory) {
                throw new IllegalStateException("This GhostViewHolder is detached!");
            } else {
                ViewGroupUtils.getAuthRequestContext(MyBillsEntityDataFactory.PlaceComponentResult).KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
                ViewGroupUtils.getAuthRequestContext(MyBillsEntityDataFactory.PlaceComponentResult).getAuthRequestContext(MyBillsEntityDataFactory);
            }
            MyBillsEntityDataFactory(viewGroup, MyBillsEntityDataFactory);
            MyBillsEntityDataFactory(viewGroup, ghostViewPort);
            ArrayList arrayList = new ArrayList();
            GhostViewHolder.getAuthRequestContext(ghostViewPort.MyBillsEntityDataFactory, arrayList);
            ArrayList arrayList2 = new ArrayList();
            int childCount = MyBillsEntityDataFactory.getChildCount() - 1;
            while (i2 <= childCount) {
                int i3 = (i2 + childCount) / 2;
                GhostViewHolder.getAuthRequestContext(((GhostViewPort) MyBillsEntityDataFactory.getChildAt(i3)).MyBillsEntityDataFactory, arrayList2);
                if (GhostViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(arrayList, arrayList2)) {
                    i2 = i3 + 1;
                } else {
                    childCount = i3 - 1;
                }
                arrayList2.clear();
            }
            if (i2 < 0 || i2 >= MyBillsEntityDataFactory.getChildCount()) {
                MyBillsEntityDataFactory.addView(ghostViewPort);
            } else {
                MyBillsEntityDataFactory.addView(ghostViewPort, i2);
            }
            ghostViewPort.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        } else if (matrix != null) {
            ghostViewPort.BuiltInFictitiousFunctionClassFactory = matrix;
        }
        ghostViewPort.KClassImpl$Data$declaredNonStaticMembers$2++;
        return ghostViewPort;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        GhostViewPort ghostViewPort = (GhostViewPort) view.getTag(R.id.KClassImpl$Data$declaredNonStaticMembers$2);
        if (ghostViewPort != null) {
            int i = ghostViewPort.KClassImpl$Data$declaredNonStaticMembers$2 - 1;
            ghostViewPort.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            if (i <= 0) {
                ((GhostViewHolder) ghostViewPort.getParent()).removeView(ghostViewPort);
            }
        }
    }
}
