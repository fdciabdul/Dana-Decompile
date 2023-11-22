package com.yalantis.ucrop.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes8.dex */
public class FastBitmapDrawable extends Drawable implements FSDraw {
    private int BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    public Bitmap MyBillsEntityDataFactory;
    private final Paint PlaceComponentResult = new Paint(2);
    private int getAuthRequestContext = 255;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public FastBitmapDrawable(Bitmap bitmap) {
        this.MyBillsEntityDataFactory = bitmap;
        if (bitmap != null) {
            this.BuiltInFictitiousFunctionClassFactory = bitmap.getWidth();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.getHeight();
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        this.BuiltInFictitiousFunctionClassFactory = 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.MyBillsEntityDataFactory;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.MyBillsEntityDataFactory, (Rect) null, getBounds(), this.PlaceComponentResult);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.PlaceComponentResult.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.PlaceComponentResult.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.getAuthRequestContext;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.getAuthRequestContext = i;
        this.PlaceComponentResult.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
