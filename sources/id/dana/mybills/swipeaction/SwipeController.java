package id.dana.mybills.swipeaction;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.extension.view.ViewExtKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 12\u00020\u0001:\u000221B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u001c¢\u0006\u0004\b/\u00100J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJG\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u001f\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010#R\u0017\u0010&\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010$\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010(R\u001c\u0010+\u001a\u0004\u0018\u00010\u001e@\u0007X\u0087\n¢\u0006\f\n\u0004\b)\u0010 \"\u0004\b\u001f\u0010*R\u0016\u0010.\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b,\u0010-"}, d2 = {"Lid/dana/mybills/swipeaction/SwipeController;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "", "p0", "p1", "convertToAbsoluteDirection", "(II)I", "Landroid/graphics/Canvas;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "PlaceComponentResult", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "Landroidx/recyclerview/widget/RecyclerView;", "getMovementFlags", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)I", "p2", "", "p3", "p4", "p5", "", "p6", "onChildDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;FFIZ)V", "onMove", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "onSwiped", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Lid/dana/mybills/swipeaction/SwipeControllerActions;", "Lid/dana/mybills/swipeaction/SwipeControllerActions;", "Landroid/graphics/RectF;", "BuiltInFictitiousFunctionClassFactory", "Landroid/graphics/RectF;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/swipeaction/SwipeController$ButtonState;", "Lid/dana/mybills/swipeaction/SwipeController$ButtonState;", "MyBillsEntityDataFactory", "I", "getAuthRequestContext", "()I", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(Landroid/graphics/RectF;)V", "lookAheadTest", "scheduleImpl", "Z", "getErrorConfigVersion", "<init>", "(Lid/dana/mybills/swipeaction/SwipeControllerActions;)V", "Companion", "ButtonState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class SwipeController extends ItemTouchHelper.Callback {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private RectF KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private ButtonState BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final int getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private RectF lookAheadTest;
    private SwipeControllerActions PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public RecyclerView.ViewHolder MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Lid/dana/mybills/swipeaction/SwipeController$ButtonState;", "", "<init>", "(Ljava/lang/String;I)V", "GONE", "RIGHT_VISIBLE"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum ButtonState {
        GONE,
        RIGHT_VISIBLE
    }

    public static /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView p0, RecyclerView.ViewHolder p1, RecyclerView.ViewHolder p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    public SwipeController(SwipeControllerActions swipeControllerActions) {
        Intrinsics.checkNotNullParameter(swipeControllerActions, "");
        this.BuiltInFictitiousFunctionClassFactory = ButtonState.GONE;
        this.getAuthRequestContext = ViewExtKt.PlaceComponentResult(70.0f);
        this.lookAheadTest = new RectF();
        this.PlaceComponentResult = swipeControllerActions;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final int getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final void BuiltInFictitiousFunctionClassFactory(RectF rectF) {
        this.lookAheadTest = rectF;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView p0, RecyclerView.ViewHolder p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return ItemTouchHelper.Callback.makeMovementFlags(0, 12);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int convertToAbsoluteDirection(int p0, int p1) {
        if (this.getErrorConfigVersion) {
            this.getErrorConfigVersion = this.BuiltInFictitiousFunctionClassFactory != ButtonState.GONE;
            return 0;
        }
        return super.convertToAbsoluteDirection(p0, p1);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onChildDraw(final android.graphics.Canvas r17, final androidx.recyclerview.widget.RecyclerView r18, final androidx.recyclerview.widget.RecyclerView.ViewHolder r19, final float r20, final float r21, final int r22, final boolean r23) {
        /*
            r16 = this;
            r9 = r16
            r10 = r18
            r11 = r19
            java.lang.String r0 = ""
            r12 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1
            r13 = r22
            if (r13 != r0) goto L61
            id.dana.mybills.swipeaction.SwipeController$ButtonState r0 = r9.BuiltInFictitiousFunctionClassFactory
            id.dana.mybills.swipeaction.SwipeController$ButtonState r1 = id.dana.mybills.swipeaction.SwipeController.ButtonState.GONE
            if (r0 == r1) goto L45
            id.dana.mybills.swipeaction.SwipeController$ButtonState r0 = r9.BuiltInFictitiousFunctionClassFactory
            id.dana.mybills.swipeaction.SwipeController$ButtonState r1 = id.dana.mybills.swipeaction.SwipeController.ButtonState.RIGHT_VISIBLE
            if (r0 != r1) goto L30
            int r0 = r9.getAuthRequestContext
            float r0 = (float) r0
            float r0 = -r0
            r14 = r20
            float r0 = java.lang.Math.min(r14, r0)
            r14 = r0
            goto L32
        L30:
            r14 = r20
        L32:
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r14
            r5 = r21
            r6 = r22
            r7 = r23
            super.onChildDraw(r1, r2, r3, r4, r5, r6, r7)
            goto L64
        L45:
            r14 = r20
            id.dana.mybills.swipeaction.SwipeController$$ExternalSyntheticLambda0 r15 = new id.dana.mybills.swipeaction.SwipeController$$ExternalSyntheticLambda0
            r0 = r15
            r1 = r16
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r21
            r7 = r22
            r8 = r23
            r0.<init>()
            r10.setOnTouchListener(r15)
            goto L63
        L61:
            r14 = r20
        L63:
            r4 = r14
        L64:
            id.dana.mybills.swipeaction.SwipeController$ButtonState r0 = r9.BuiltInFictitiousFunctionClassFactory
            id.dana.mybills.swipeaction.SwipeController$ButtonState r1 = id.dana.mybills.swipeaction.SwipeController.ButtonState.GONE
            if (r0 != r1) goto L7b
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r5 = r21
            r6 = r22
            r7 = r23
            super.onChildDraw(r1, r2, r3, r4, r5, r6, r7)
        L7b:
            r9.MyBillsEntityDataFactory = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.swipeaction.SwipeController.onChildDraw(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$ViewHolder, float, float, int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BuiltInFictitiousFunctionClassFactory(final SwipeController swipeController, float f, final Canvas canvas, final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder, final float f2, final int i, final boolean z, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(swipeController, "");
        Intrinsics.checkNotNullParameter(canvas, "");
        Intrinsics.checkNotNullParameter(recyclerView, "");
        Intrinsics.checkNotNullParameter(viewHolder, "");
        boolean z2 = true;
        if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
            z2 = false;
        }
        swipeController.getErrorConfigVersion = z2;
        if (z2) {
            if (f < (-swipeController.getAuthRequestContext)) {
                swipeController.BuiltInFictitiousFunctionClassFactory = ButtonState.RIGHT_VISIBLE;
            }
            if (swipeController.BuiltInFictitiousFunctionClassFactory != ButtonState.GONE) {
                recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.mybills.swipeaction.SwipeController$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent2) {
                        boolean BuiltInFictitiousFunctionClassFactory;
                        BuiltInFictitiousFunctionClassFactory = SwipeController.BuiltInFictitiousFunctionClassFactory(SwipeController.this, canvas, recyclerView, viewHolder, f2, i, z, motionEvent2);
                        return BuiltInFictitiousFunctionClassFactory;
                    }
                });
                int childCount = recyclerView.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    recyclerView.getChildAt(i2).setClickable(false);
                }
            }
        }
        return false;
    }

    public void PlaceComponentResult(Canvas p0, RecyclerView.ViewHolder p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        if (this.BuiltInFictitiousFunctionClassFactory == ButtonState.RIGHT_VISIBLE) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this.lookAheadTest;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BuiltInFictitiousFunctionClassFactory(final SwipeController swipeController, final Canvas canvas, final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder, final float f, final int i, final boolean z, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(swipeController, "");
        Intrinsics.checkNotNullParameter(canvas, "");
        Intrinsics.checkNotNullParameter(recyclerView, "");
        Intrinsics.checkNotNullParameter(viewHolder, "");
        if (motionEvent.getAction() == 0) {
            recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.mybills.swipeaction.SwipeController$$ExternalSyntheticLambda2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent2) {
                    boolean PlaceComponentResult;
                    PlaceComponentResult = SwipeController.PlaceComponentResult(SwipeController.this, canvas, recyclerView, viewHolder, f, i, z, motionEvent2);
                    return PlaceComponentResult;
                }
            });
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PlaceComponentResult(SwipeController swipeController, Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, int i, boolean z, MotionEvent motionEvent) {
        RectF rectF;
        SwipeControllerActions swipeControllerActions;
        Intrinsics.checkNotNullParameter(swipeController, "");
        Intrinsics.checkNotNullParameter(canvas, "");
        Intrinsics.checkNotNullParameter(recyclerView, "");
        Intrinsics.checkNotNullParameter(viewHolder, "");
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 2) {
            super.onChildDraw(canvas, recyclerView, viewHolder, 0.0f, f, i, z);
            recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.mybills.swipeaction.SwipeController$$ExternalSyntheticLambda3
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent2) {
                    return SwipeController.BuiltInFictitiousFunctionClassFactory();
                }
            });
            int childCount = recyclerView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                recyclerView.getChildAt(i2).setClickable(true);
            }
            swipeController.getErrorConfigVersion = false;
            if (swipeController.PlaceComponentResult != null && (rectF = swipeController.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                if ((rectF != null && rectF.contains(motionEvent.getX(), motionEvent.getY())) && swipeController.BuiltInFictitiousFunctionClassFactory == ButtonState.RIGHT_VISIBLE && (swipeControllerActions = swipeController.PlaceComponentResult) != null) {
                    swipeControllerActions.PlaceComponentResult(viewHolder.getBindingAdapterPosition());
                }
            }
            swipeController.BuiltInFictitiousFunctionClassFactory = ButtonState.GONE;
            swipeController.MyBillsEntityDataFactory = null;
        }
        return false;
    }
}
