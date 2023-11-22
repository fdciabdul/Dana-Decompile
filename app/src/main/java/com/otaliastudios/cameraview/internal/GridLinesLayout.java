package com.otaliastudios.cameraview.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.otaliastudios.cameraview.controls.Grid;

/* loaded from: classes2.dex */
public class GridLinesLayout extends View {
    public static final int DEFAULT_COLOR = Color.argb((int) BlobStatic.MONITOR_IMAGE_WIDTH, 255, 255, 255);
    private final float BuiltInFictitiousFunctionClassFactory;
    private ColorDrawable KClassImpl$Data$declaredNonStaticMembers$2;
    private ColorDrawable MyBillsEntityDataFactory;
    private int PlaceComponentResult;
    DrawCallback callback;
    private Grid getAuthRequestContext;

    /* loaded from: classes8.dex */
    interface DrawCallback {
    }

    public GridLinesLayout(Context context) {
        this(context, null);
    }

    public GridLinesLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PlaceComponentResult = DEFAULT_COLOR;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ColorDrawable(this.PlaceComponentResult);
        this.MyBillsEntityDataFactory = new ColorDrawable(this.PlaceComponentResult);
        this.BuiltInFictitiousFunctionClassFactory = TypedValue.applyDimension(1, 0.9f, context.getResources().getDisplayMetrics());
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.KClassImpl$Data$declaredNonStaticMembers$2.setBounds(i, 0, i3, (int) this.BuiltInFictitiousFunctionClassFactory);
        this.MyBillsEntityDataFactory.setBounds(0, i2, (int) this.BuiltInFictitiousFunctionClassFactory, i4);
    }

    public Grid getGridMode() {
        return this.getAuthRequestContext;
    }

    public void setGridMode(Grid grid) {
        this.getAuthRequestContext = grid;
        postInvalidate();
    }

    public int getGridColor() {
        return this.PlaceComponentResult;
    }

    public void setGridColor(int i) {
        this.PlaceComponentResult = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setColor(i);
        this.MyBillsEntityDataFactory.setColor(i);
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.otaliastudios.cameraview.internal.GridLinesLayout$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[Grid.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[Grid.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[Grid.DRAW_3X3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[Grid.DRAW_PHI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[Grid.DRAW_4X4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private int getAuthRequestContext() {
        int i = AnonymousClass1.MyBillsEntityDataFactory[this.getAuthRequestContext.ordinal()];
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 0 : 3;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        int authRequestContext = getAuthRequestContext();
        for (int i = 0; i < authRequestContext; i++) {
            int authRequestContext2 = getAuthRequestContext();
            if (this.getAuthRequestContext == Grid.DRAW_PHI) {
                f = 0.38196602f;
                if (i != 1) {
                    f = 0.618034f;
                }
            } else {
                f = (1.0f / (authRequestContext2 + 1)) * (i + 1.0f);
            }
            canvas.translate(0.0f, getHeight() * f);
            this.KClassImpl$Data$declaredNonStaticMembers$2.draw(canvas);
            float f2 = -f;
            canvas.translate(0.0f, getHeight() * f2);
            canvas.translate(f * getWidth(), 0.0f);
            this.MyBillsEntityDataFactory.draw(canvas);
            canvas.translate(f2 * getWidth(), 0.0f);
        }
    }
}
