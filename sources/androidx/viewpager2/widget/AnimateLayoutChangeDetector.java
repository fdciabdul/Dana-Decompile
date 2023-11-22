package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class AnimateLayoutChangeDetector {
    private static final ViewGroup.MarginLayoutParams BuiltInFictitiousFunctionClassFactory;
    private LinearLayoutManager KClassImpl$Data$declaredNonStaticMembers$2;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        BuiltInFictitiousFunctionClassFactory = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimateLayoutChangeDetector(LinearLayoutManager linearLayoutManager) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = linearLayoutManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory() {
        return (!BuiltInFictitiousFunctionClassFactory() || this.KClassImpl$Data$declaredNonStaticMembers$2.getChildCount() <= 1) && getAuthRequestContext();
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int top;
        int i;
        int bottom;
        int i2;
        int childCount = this.KClassImpl$Data$declaredNonStaticMembers$2.getChildCount();
        if (childCount == 0) {
            return true;
        }
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2.getOrientation() == 0;
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, childCount, 2);
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.KClassImpl$Data$declaredNonStaticMembers$2.getChildAt(i3);
            if (childAt == null) {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = BuiltInFictitiousFunctionClassFactory;
            }
            int[] iArr2 = iArr[i3];
            if (z) {
                top = childAt.getLeft();
                i = marginLayoutParams.leftMargin;
            } else {
                top = childAt.getTop();
                i = marginLayoutParams.topMargin;
            }
            iArr2[0] = top - i;
            int[] iArr3 = iArr[i3];
            if (z) {
                bottom = childAt.getRight();
                i2 = marginLayoutParams.rightMargin;
            } else {
                bottom = childAt.getBottom();
                i2 = marginLayoutParams.bottomMargin;
            }
            iArr3[1] = bottom + i2;
        }
        Arrays.sort(iArr, new Comparator<int[]>() { // from class: androidx.viewpager2.widget.AnimateLayoutChangeDetector.1
            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(int[] iArr4, int[] iArr5) {
                return iArr4[0] - iArr5[0];
            }
        });
        for (int i4 = 1; i4 < childCount; i4++) {
            if (iArr[i4 - 1][1] != iArr[i4][0]) {
                return false;
            }
        }
        int[] iArr4 = iArr[0];
        int i5 = iArr4[1];
        int i6 = iArr4[0];
        return i6 <= 0 && iArr[childCount - 1][1] >= i5 - i6;
    }

    private boolean getAuthRequestContext() {
        int childCount = this.KClassImpl$Data$declaredNonStaticMembers$2.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean MyBillsEntityDataFactory(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (MyBillsEntityDataFactory(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
