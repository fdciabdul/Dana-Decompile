package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements MenuBuilder.ItemInvoker, MenuView, AdapterView.OnItemClickListener {
    private int PlaceComponentResult;
    private MenuBuilder getAuthRequestContext;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {104, -68, 0, 44, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int BuiltInFictitiousFunctionClassFactory = 15;
    private static final int[] MyBillsEntityDataFactory = {16842964, 16843049};

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray authRequestContext = TintTypedArray.getAuthRequestContext(context, attributeSet, MyBillsEntityDataFactory, i, 0);
        if (authRequestContext.getAuthRequestContext(0)) {
            setBackgroundDrawable(__fsTypeCheck_03006d36da53514240897610a74f16fc(authRequestContext, 0));
        }
        if (authRequestContext.getAuthRequestContext(1)) {
            setDivider(__fsTypeCheck_03006d36da53514240897610a74f16fc(authRequestContext, 1));
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory.recycle();
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public final void initialize(MenuBuilder menuBuilder) {
        this.getAuthRequestContext = menuBuilder;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public final boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.getAuthRequestContext.performItemAction(menuItemImpl, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        invokeItem((MenuItemImpl) getAdapter().getItem(i));
    }

    public final int getWindowAnimations() {
        return this.PlaceComponentResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004c -> B:15:0x0053). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray r10, int r11) {
        /*
            byte[] r0 = androidx.appcompat.view.menu.ExpandedMenuView.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 2
            r1 = r0[r1]
            byte r1 = (byte) r1
            byte r2 = (byte) r1
            byte r3 = (byte) r2
            int r1 = r1 * 3
            int r1 = r1 + 4
            int r2 = r2 * 4
            int r2 = r2 + 97
            int r3 = r3 * 3
            int r3 = r3 + 23
            byte[] r4 = new byte[r3]
            int r3 = r3 + (-1)
            r5 = 0
            if (r0 != 0) goto L24
            r8 = r3
            r6 = r4
            r7 = 0
            r3 = r2
            r4 = r8
            r2 = r0
            r0 = r11
            r11 = r10
            goto L53
        L24:
            r6 = r4
            r7 = 0
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r11
            r11 = r10
        L2c:
            byte r8 = (byte) r3
            r6[r7] = r8
            if (r7 != r4) goto L4c
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6, r5)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L47
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L47:
            android.graphics.drawable.Drawable r10 = r11.BuiltInFictitiousFunctionClassFactory(r0)
            return r10
        L4c:
            int r7 = r7 + 1
            r8 = r1[r2]
            r9 = r2
            r2 = r1
            r1 = r9
        L53:
            int r8 = -r8
            int r3 = r3 + r8
            int r3 = r3 + (-8)
            int r1 = r1 + 1
            r9 = r2
            r2 = r1
            r1 = r9
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ExpandedMenuView.__fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray, int):android.graphics.drawable.Drawable");
    }
}
