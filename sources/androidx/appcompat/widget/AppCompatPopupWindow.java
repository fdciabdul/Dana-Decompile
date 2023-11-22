package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;

/* loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {
    private static final boolean PlaceComponentResult;
    private boolean BuiltInFictitiousFunctionClassFactory;
    public static final byte[] MyBillsEntityDataFactory = {22, 66, -65, -82, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int getAuthRequestContext = 5;

    static {
        PlaceComponentResult = Build.VERSION.SDK_INT < 21;
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KClassImpl$Data$declaredNonStaticMembers$2(context, attributeSet, i, 0);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        KClassImpl$Data$declaredNonStaticMembers$2(context, attributeSet, i, i2);
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Context context, AttributeSet attributeSet, int i, int i2) {
        TintTypedArray authRequestContext = TintTypedArray.getAuthRequestContext(context, attributeSet, R.styleable.getPhoneMask, i, i2);
        if (authRequestContext.getAuthRequestContext(R.styleable.onPolygonsChanged)) {
            MyBillsEntityDataFactory(authRequestContext.getAuthRequestContext(R.styleable.onPolygonsChanged, false));
        }
        setBackgroundDrawable(PlaceComponentResult(authRequestContext, R.styleable.getRecommendationData));
        authRequestContext.BuiltInFictitiousFunctionClassFactory.recycle();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (PlaceComponentResult && this.BuiltInFictitiousFunctionClassFactory) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (PlaceComponentResult && this.BuiltInFictitiousFunctionClassFactory) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        if (PlaceComponentResult && this.BuiltInFictitiousFunctionClassFactory) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    private void MyBillsEntityDataFactory(boolean z) {
        if (PlaceComponentResult) {
            this.BuiltInFictitiousFunctionClassFactory = z;
        } else {
            PopupWindowCompat.getAuthRequestContext(this, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004d -> B:15:0x0059). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable PlaceComponentResult(androidx.appcompat.widget.TintTypedArray r10, int r11) {
        /*
            int r0 = androidx.appcompat.widget.AppCompatPopupWindow.getAuthRequestContext
            int r0 = r0 + (-5)
            byte r0 = (byte) r0
            byte r1 = (byte) r0
            byte r2 = (byte) r1
            byte[] r3 = androidx.appcompat.widget.AppCompatPopupWindow.MyBillsEntityDataFactory
            int r1 = r1 * 3
            int r1 = 4 - r1
            int r2 = r2 * 4
            int r2 = 23 - r2
            int r0 = r0 * 2
            int r0 = r0 + 97
            byte[] r4 = new byte[r2]
            int r2 = r2 + (-1)
            r5 = 0
            if (r3 != 0) goto L25
            r6 = r3
            r7 = r4
            r8 = 0
            r3 = r2
            r4 = r3
            r2 = r1
            r1 = r11
            r11 = r10
            goto L59
        L25:
            r6 = r4
            r7 = 0
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r11
            r11 = r10
        L2d:
            byte r8 = (byte) r1
            r6[r7] = r8
            if (r7 != r3) goto L4d
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6, r5)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L48
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L48:
            android.graphics.drawable.Drawable r10 = r11.BuiltInFictitiousFunctionClassFactory(r0)
            return r10
        L4d:
            int r7 = r7 + 1
            r8 = r4[r2]
            r9 = r1
            r1 = r0
            r0 = r8
            r8 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r9
        L59:
            int r0 = -r0
            int r3 = r3 + r0
            int r0 = r3 + (-8)
            int r2 = r2 + 1
            r3 = r4
            r4 = r6
            r6 = r7
            r7 = r8
            r9 = r1
            r1 = r0
            r0 = r9
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatPopupWindow.PlaceComponentResult(androidx.appcompat.widget.TintTypedArray, int):android.graphics.drawable.Drawable");
    }
}
