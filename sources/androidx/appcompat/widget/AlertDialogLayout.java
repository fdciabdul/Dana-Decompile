package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes6.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(i, i2)) {
            return;
        }
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
    
        r14 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AlertDialogLayout.KClassImpl$Data$declaredNonStaticMembers$2(int, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
        /*
            r10 = this;
            int r11 = r10.getPaddingLeft()
            int r14 = r14 - r12
            int r12 = r10.getPaddingRight()
            int r0 = r10.getPaddingRight()
            int r1 = r10.getMeasuredHeight()
            int r2 = r10.getChildCount()
            int r3 = r10.getGravity()
            r4 = r3 & 112(0x70, float:1.57E-43)
            r5 = 16
            if (r4 == r5) goto L31
            r5 = 80
            if (r4 == r5) goto L28
            int r13 = r10.getPaddingTop()
            goto L3b
        L28:
            int r4 = r10.getPaddingTop()
            int r4 = r4 + r15
            int r4 = r4 - r13
            int r13 = r4 - r1
            goto L3b
        L31:
            int r4 = r10.getPaddingTop()
            int r15 = r15 - r13
            int r15 = r15 - r1
            int r15 = r15 / 2
            int r13 = r4 + r15
        L3b:
            android.graphics.drawable.Drawable r15 = r10.getDividerDrawable()
            r1 = 0
            if (r15 != 0) goto L44
            r15 = 0
            goto L48
        L44:
            int r15 = r15.getIntrinsicHeight()
        L48:
            if (r1 >= r2) goto Lac
            android.view.View r4 = r10.getChildAt(r1)
            if (r4 == 0) goto La9
            int r5 = r4.getVisibility()
            r6 = 8
            if (r5 == r6) goto La9
            int r5 = r4.getMeasuredWidth()
            int r6 = r4.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r7 = r4.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r7 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r7
            int r8 = r7.gravity
            if (r8 >= 0) goto L6e
            r8 = 8388615(0x800007, float:1.1754953E-38)
            r8 = r8 & r3
        L6e:
            int r9 = androidx.core.view.ViewCompat.initRecordTimeStamp(r10)
            int r8 = androidx.core.view.GravityCompat.BuiltInFictitiousFunctionClassFactory(r8, r9)
            r8 = r8 & 7
            r9 = 1
            if (r8 == r9) goto L88
            r9 = 5
            if (r8 == r9) goto L82
            int r8 = r7.leftMargin
            int r8 = r8 + r11
            goto L95
        L82:
            int r8 = r14 - r12
            int r8 = r8 - r5
            int r9 = r7.rightMargin
            goto L94
        L88:
            int r8 = r14 - r11
            int r8 = r8 - r0
            int r8 = r8 - r5
            int r8 = r8 / 2
            int r8 = r8 + r11
            int r9 = r7.leftMargin
            int r8 = r8 + r9
            int r9 = r7.rightMargin
        L94:
            int r8 = r8 - r9
        L95:
            boolean r9 = r10.hasDividerBeforeChildAt(r1)
            if (r9 == 0) goto L9c
            int r13 = r13 + r15
        L9c:
            int r9 = r7.topMargin
            int r13 = r13 + r9
            int r5 = r5 + r8
            int r9 = r6 + r13
            r4.layout(r8, r13, r5, r9)
            int r4 = r7.bottomMargin
            int r6 = r6 + r4
            int r13 = r13 + r6
        La9:
            int r1 = r1 + 1
            goto L48
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AlertDialogLayout.onLayout(boolean, int, int, int, int):void");
    }
}
