package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes6.dex */
public abstract class RoundedBitmapDrawable extends Drawable implements FSDraw {
    private int DatabaseTableConfigUtil;
    private final BitmapShader KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    final Bitmap PlaceComponentResult;
    private float getErrorConfigVersion;
    private int lookAheadTest;
    private boolean scheduleImpl;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0 = 119;
    private final Paint NetworkUserEntityData$$ExternalSyntheticLambda1 = new Paint(3);
    private final Matrix GetContactSyncConfig = new Matrix();
    final Rect BuiltInFictitiousFunctionClassFactory = new Rect();
    private final RectF moveToNextValue = new RectF();
    private boolean getAuthRequestContext = true;

    private static boolean BuiltInFictitiousFunctionClassFactory(float f) {
        return f > 0.05f;
    }

    private void PlaceComponentResult() {
        this.lookAheadTest = this.PlaceComponentResult.getScaledWidth(this.DatabaseTableConfigUtil);
        this.MyBillsEntityDataFactory = this.PlaceComponentResult.getScaledHeight(this.DatabaseTableConfigUtil);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.setFilterBitmap(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.setDither(z);
        invalidateSelf();
    }

    void PlaceComponentResult(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MyBillsEntityDataFactory() {
        if (this.getAuthRequestContext) {
            if (this.scheduleImpl) {
                int min = Math.min(this.lookAheadTest, this.MyBillsEntityDataFactory);
                PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, min, min, getBounds(), this.BuiltInFictitiousFunctionClassFactory);
                int min2 = Math.min(this.BuiltInFictitiousFunctionClassFactory.width(), this.BuiltInFictitiousFunctionClassFactory.height());
                this.BuiltInFictitiousFunctionClassFactory.inset(Math.max(0, (this.BuiltInFictitiousFunctionClassFactory.width() - min2) / 2), Math.max(0, (this.BuiltInFictitiousFunctionClassFactory.height() - min2) / 2));
                this.getErrorConfigVersion = min2 * 0.5f;
            } else {
                PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, this.MyBillsEntityDataFactory, getBounds(), this.BuiltInFictitiousFunctionClassFactory);
            }
            this.moveToNextValue.set(this.BuiltInFictitiousFunctionClassFactory);
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                this.GetContactSyncConfig.setTranslate(this.moveToNextValue.left, this.moveToNextValue.top);
                this.GetContactSyncConfig.preScale(this.moveToNextValue.width() / this.PlaceComponentResult.getWidth(), this.moveToNextValue.height() / this.PlaceComponentResult.getHeight());
                this.KClassImpl$Data$declaredNonStaticMembers$2.setLocalMatrix(this.GetContactSyncConfig);
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.setShader(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            this.getAuthRequestContext = false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.PlaceComponentResult;
        if (bitmap == null) {
            return;
        }
        MyBillsEntityDataFactory();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            return;
        }
        RectF rectF = this.moveToNextValue;
        float f = this.getErrorConfigVersion;
        canvas.drawRoundRect(rectF, f, f, this.NetworkUserEntityData$$ExternalSyntheticLambda1);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAlpha()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1.getColorFilter();
    }

    public void getAuthRequestContext(boolean z) {
        this.scheduleImpl = z;
        this.getAuthRequestContext = true;
        if (z) {
            getAuthRequestContext();
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.setShader(this.KClassImpl$Data$declaredNonStaticMembers$2);
            invalidateSelf();
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(0.0f);
    }

    private void getAuthRequestContext() {
        this.getErrorConfigVersion = Math.min(this.MyBillsEntityDataFactory, this.lookAheadTest) / 2;
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(float f) {
        if (this.getErrorConfigVersion == f) {
            return;
        }
        this.scheduleImpl = false;
        if (BuiltInFictitiousFunctionClassFactory(f)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.setShader(this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.setShader(null);
        }
        this.getErrorConfigVersion = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.scheduleImpl) {
            getAuthRequestContext();
        }
        this.getAuthRequestContext = true;
    }

    public float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.lookAheadTest;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap;
        return (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != 119 || this.scheduleImpl || (bitmap = this.PlaceComponentResult) == null || bitmap.hasAlpha() || this.NetworkUserEntityData$$ExternalSyntheticLambda1.getAlpha() < 255 || BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion)) ? -3 : -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        this.DatabaseTableConfigUtil = BlobStatic.MONITOR_IMAGE_WIDTH;
        if (resources != null) {
            this.DatabaseTableConfigUtil = resources.getDisplayMetrics().densityDpi;
        }
        this.PlaceComponentResult = bitmap;
        if (bitmap != null) {
            PlaceComponentResult();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new BitmapShader(bitmap, tileMode, tileMode);
            return;
        }
        this.MyBillsEntityDataFactory = -1;
        this.lookAheadTest = -1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }
}
