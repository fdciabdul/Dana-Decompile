package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.material.R;
import com.google.common.base.Ascii;

/* loaded from: classes3.dex */
public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;
    public static final byte[] PlaceComponentResult = {56, -13, -61, 104, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int MyBillsEntityDataFactory = 22;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TintTypedArray MyBillsEntityDataFactory2 = TintTypedArray.MyBillsEntityDataFactory(context, attributeSet, R.styleable.TabItem);
        this.text = MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getText(R.styleable.TabItem_android_text);
        this.icon = __fsTypeCheck_03006d36da53514240897610a74f16fc(MyBillsEntityDataFactory2, R.styleable.TabItem_android_icon);
        this.customLayout = MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.TabItem_android_layout, 0);
        MyBillsEntityDataFactory2.BuiltInFictitiousFunctionClassFactory.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0042 -> B:15:0x0048). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray r9, int r10) {
        /*
            byte[] r0 = com.google.android.material.tabs.TabItem.PlaceComponentResult
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 3
            r4 = -1
            if (r0 != 0) goto L15
            r4 = r1
            r5 = 3
            r6 = -1
            r7 = 22
            r1 = r0
            r0 = r10
            r10 = r9
            goto L48
        L15:
            r5 = 97
            r3 = r1
            r4 = 3
            r6 = -1
            r1 = r0
            r0 = r10
            r10 = r9
        L1d:
            int r6 = r6 + 1
            int r4 = r4 + 1
            byte r7 = (byte) r5
            r3[r6] = r7
            if (r6 != r2) goto L42
            java.lang.String r1 = new java.lang.String
            r2 = 0
            r1.<init>(r3, r2)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r9 = r1.isInstance(r9)
            if (r9 == 0) goto L3d
            android.content.Context r10 = (android.content.Context) r10
            android.graphics.drawable.Drawable r9 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r10, r0)
            return r9
        L3d:
            android.graphics.drawable.Drawable r9 = r10.BuiltInFictitiousFunctionClassFactory(r0)
            return r9
        L42:
            r7 = r1[r4]
            r8 = r4
            r4 = r3
            r3 = r5
            r5 = r8
        L48:
            int r3 = r3 + r7
            int r3 = r3 + (-8)
            r8 = r5
            r5 = r3
            r3 = r4
            r4 = r8
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabItem.__fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray, int):android.graphics.drawable.Drawable");
    }
}
