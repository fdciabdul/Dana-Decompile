package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes3.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public Drawable MyBillsEntityDataFactory;
    private final Rect PlaceComponentResult = new Rect();
    private int scheduleImpl;
    public static final byte[] getAuthRequestContext = {40, 6, -7, -65, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 181;
    private static final int[] KClassImpl$Data$declaredNonStaticMembers$2 = {16843284};

    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0072 -> B:24:0x0078). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DividerItemDecoration(android.content.Context r14, int r15) {
        /*
            r13 = this;
            r13.<init>()
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r13.PlaceComponentResult = r0
            int[] r0 = androidx.recyclerview.widget.DividerItemDecoration.KClassImpl$Data$declaredNonStaticMembers$2
            android.content.res.TypedArray r14 = r14.obtainStyledAttributes(r0)
            byte[] r0 = androidx.recyclerview.widget.DividerItemDecoration.getAuthRequestContext
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 4
            r3 = 97
            r4 = 1
            r5 = 0
            r9 = r13
            if (r0 != 0) goto L28
            r3 = r0
            r6 = r1
            r7 = 4
            r8 = 97
            r10 = 0
            r0 = r14
            r1 = r15
            r15 = r0
            goto L78
        L28:
            r2 = r0
            r3 = r1
            r6 = 97
            r7 = 4
            r8 = 0
            r0 = r14
            r1 = r15
            r15 = r0
        L31:
            byte r10 = (byte) r6
            r3[r8] = r10
            int r10 = r8 + 1
            r11 = 22
            if (r8 != r11) goto L72
            java.lang.String r2 = new java.lang.String
            r2.<init>(r3, r5)
            java.lang.Class r2 = java.lang.Class.forName(r2)
            boolean r14 = r2.isInstance(r14)
            if (r14 == 0) goto L50
            android.content.Context r15 = (android.content.Context) r15
            android.graphics.drawable.Drawable r14 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r15, r5)
            goto L54
        L50:
            android.graphics.drawable.Drawable r14 = r15.getDrawable(r5)
        L54:
            r9.MyBillsEntityDataFactory = r14
            if (r14 != 0) goto L5f
            java.lang.String r14 = "DividerItem"
            java.lang.String r15 = "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()"
            com.fullstory.instrumentation.InstrumentInjector.log_w(r14, r15)
        L5f:
            r0.recycle()
            if (r1 == 0) goto L6f
            if (r1 != r4) goto L67
            goto L6f
        L67:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r15 = "Invalid orientation. It should be either HORIZONTAL or VERTICAL"
            r14.<init>(r15)
            throw r14
        L6f:
            r9.scheduleImpl = r1
            return
        L72:
            r8 = r2[r7]
            r12 = r3
            r3 = r2
            r2 = r6
            r6 = r12
        L78:
            int r2 = r2 + r8
            int r2 = r2 + (-8)
            int r7 = r7 + r4
            r8 = r10
            r12 = r6
            r6 = r2
            r2 = r3
            r3 = r12
            goto L31
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.DividerItemDecoration.<init>(android.content.Context, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int height;
        int i;
        int width;
        int i2;
        if (recyclerView.getLayoutManager() == null || this.MyBillsEntityDataFactory == null) {
            return;
        }
        int i3 = 0;
        if (this.scheduleImpl == 1) {
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i2 = recyclerView.getPaddingLeft();
                width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                canvas.clipRect(i2, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
            } else {
                width = recyclerView.getWidth();
                i2 = 0;
            }
            int childCount = recyclerView.getChildCount();
            while (i3 < childCount) {
                View childAt = recyclerView.getChildAt(i3);
                recyclerView.getDecoratedBoundsWithMargins(childAt, this.PlaceComponentResult);
                int round = this.PlaceComponentResult.bottom + Math.round(childAt.getTranslationY());
                this.MyBillsEntityDataFactory.setBounds(i2, round - this.MyBillsEntityDataFactory.getIntrinsicHeight(), width, round);
                this.MyBillsEntityDataFactory.draw(canvas);
                i3++;
            }
            canvas.restore();
            return;
        }
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            i = 0;
        }
        int childCount2 = recyclerView.getChildCount();
        while (i3 < childCount2) {
            View childAt2 = recyclerView.getChildAt(i3);
            recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt2, this.PlaceComponentResult);
            int round2 = this.PlaceComponentResult.right + Math.round(childAt2.getTranslationX());
            this.MyBillsEntityDataFactory.setBounds(round2 - this.MyBillsEntityDataFactory.getIntrinsicWidth(), i, round2, height);
            this.MyBillsEntityDataFactory.draw(canvas);
            i3++;
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Drawable drawable = this.MyBillsEntityDataFactory;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.scheduleImpl == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }
}
