package id.dana.feeds.views;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes8.dex */
public class FeedsDividerDecoration extends RecyclerView.ItemDecoration {
    private Drawable BuiltInFictitiousFunctionClassFactory;
    public static final byte[] getAuthRequestContext = {3, -83, -69, 19, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int PlaceComponentResult = 117;
    private static final int[] MyBillsEntityDataFactory = {16843284};

    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004e -> B:15:0x0056). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FeedsDividerDecoration(android.content.Context r13) {
        /*
            r12 = this;
            r12.<init>()
            int[] r0 = id.dana.feeds.views.FeedsDividerDecoration.MyBillsEntityDataFactory
            android.content.res.TypedArray r13 = r13.obtainStyledAttributes(r0)
            byte[] r0 = id.dana.feeds.views.FeedsDividerDecoration.getAuthRequestContext
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 97
            r4 = 0
            r5 = 4
            r9 = r12
            if (r0 != 0) goto L21
            r5 = r0
            r6 = r1
            r7 = 4
            r8 = 0
            r10 = 22
            r0 = r13
            r1 = r0
            goto L56
        L21:
            r3 = r0
            r5 = r1
            r6 = 97
            r7 = 4
            r8 = 0
            r0 = r13
            r1 = r0
        L29:
            byte r10 = (byte) r6
            r5[r8] = r10
            if (r8 != r2) goto L4e
            java.lang.String r2 = new java.lang.String
            r2.<init>(r5, r4)
            java.lang.Class r2 = java.lang.Class.forName(r2)
            boolean r13 = r2.isInstance(r13)
            if (r13 == 0) goto L44
            android.content.Context r0 = (android.content.Context) r0
            android.graphics.drawable.Drawable r13 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r0, r4)
            goto L48
        L44:
            android.graphics.drawable.Drawable r13 = r0.getDrawable(r4)
        L48:
            r9.BuiltInFictitiousFunctionClassFactory = r13
            r1.recycle()
            return
        L4e:
            r10 = r3[r7]
            int r8 = r8 + 1
            r11 = r5
            r5 = r3
            r3 = r6
            r6 = r11
        L56:
            int r3 = r3 + r10
            int r3 = r3 + (-8)
            int r7 = r7 + 1
            r11 = r6
            r6 = r3
            r3 = r5
            r5 = r11
            goto L29
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.views.FeedsDividerDecoration.<init>(android.content.Context):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth();
        int paddingRight = recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.BuiltInFictitiousFunctionClassFactory.setBounds(paddingLeft, bottom, width - paddingRight, this.BuiltInFictitiousFunctionClassFactory.getIntrinsicHeight() + bottom);
            this.BuiltInFictitiousFunctionClassFactory.draw(canvas);
        }
    }
}
