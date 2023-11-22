package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R;
import com.fullstory.instrumentation.FSDraw;

/* loaded from: classes3.dex */
class RoundRectDrawableWithShadow extends Drawable implements FSDraw {
    static RoundRectHelper BuiltInFictitiousFunctionClassFactory;
    private static final double getErrorConfigVersion = Math.cos(Math.toRadians(45.0d));
    ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
    float NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Path NetworkUserEntityData$$ExternalSyntheticLambda1;
    private Paint NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda8;
    float getAuthRequestContext;
    private Paint initRecordTimeStamp;
    private float isLayoutRequested;
    final int lookAheadTest;
    private final RectF moveToNextValue;
    float scheduleImpl;
    boolean MyBillsEntityDataFactory = true;
    boolean PlaceComponentResult = true;
    private boolean DatabaseTableConfigUtil = false;
    private Paint GetContactSyncConfig = new Paint(5);

    /* loaded from: classes3.dex */
    interface RoundRectHelper {
        void PlaceComponentResult(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = resources.getColor(R.color.BuiltInFictitiousFunctionClassFactory);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = resources.getColor(R.color.PlaceComponentResult);
        this.lookAheadTest = resources.getDimensionPixelSize(R.dimen.getAuthRequestContext);
        MyBillsEntityDataFactory(colorStateList);
        Paint paint = new Paint(5);
        this.initRecordTimeStamp = paint;
        paint.setStyle(Paint.Style.FILL);
        this.getAuthRequestContext = (int) (f + 0.5f);
        this.moveToNextValue = new RectF();
        Paint paint2 = new Paint(this.initRecordTimeStamp);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = paint2;
        paint2.setAntiAlias(false);
        KClassImpl$Data$declaredNonStaticMembers$2(f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = colorStateList;
        this.GetContactSyncConfig.setColor(colorStateList.getColorForState(getState(), this.KClassImpl$Data$declaredNonStaticMembers$2.getDefaultColor()));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.GetContactSyncConfig.setAlpha(i);
        this.initRecordTimeStamp.setAlpha(i);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.MyBillsEntityDataFactory = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(MyBillsEntityDataFactory(this.scheduleImpl, this.getAuthRequestContext, this.PlaceComponentResult));
        float f = this.scheduleImpl;
        float f2 = this.getAuthRequestContext;
        if (this.PlaceComponentResult) {
            double d = f;
            double d2 = f2;
            double d3 = 1.0d - getErrorConfigVersion;
            Double.isNaN(d2);
            Double.isNaN(d);
            f = (float) (d + (d3 * d2));
        }
        int ceil2 = (int) Math.ceil(f);
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float MyBillsEntityDataFactory(float f, float f2, boolean z) {
        if (z) {
            double d = f * 1.5f;
            double d2 = f2;
            double d3 = 1.0d - getErrorConfigVersion;
            Double.isNaN(d2);
            Double.isNaN(d);
            return (float) (d + (d3 * d2));
        }
        return f * 1.5f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float PlaceComponentResult(float f, float f2, boolean z) {
        if (z) {
            double d = f;
            double d2 = f2;
            double d3 = 1.0d - getErrorConfigVersion;
            Double.isNaN(d2);
            Double.isNaN(d);
            return (float) (d + (d3 * d2));
        }
        return f;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.GetContactSyncConfig.getColor() == colorForState) {
            return false;
        }
        this.GetContactSyncConfig.setColor(colorForState);
        this.MyBillsEntityDataFactory = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.GetContactSyncConfig.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        if (this.MyBillsEntityDataFactory) {
            Rect bounds = getBounds();
            float f = this.scheduleImpl * 1.5f;
            this.moveToNextValue.set(bounds.left + this.scheduleImpl, bounds.top + f, bounds.right - this.scheduleImpl, bounds.bottom - f);
            float f2 = this.getAuthRequestContext;
            float f3 = -f2;
            RectF rectF = new RectF(f3, f3, f2, f2);
            RectF rectF2 = new RectF(rectF);
            float f4 = -this.isLayoutRequested;
            rectF2.inset(f4, f4);
            Path path = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (path == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Path();
            } else {
                path.reset();
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.setFillType(Path.FillType.EVEN_ODD);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.moveTo(-this.getAuthRequestContext, 0.0f);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.rLineTo(-this.isLayoutRequested, 0.0f);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.arcTo(rectF2, 180.0f, 90.0f, false);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.arcTo(rectF, 270.0f, -90.0f, false);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.close();
            float f5 = this.getAuthRequestContext;
            float f6 = this.isLayoutRequested;
            Paint paint = this.initRecordTimeStamp;
            int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            paint.setShader(new RadialGradient(0.0f, 0.0f, f5 + f6, new int[]{i2, i2, this.NetworkUserEntityData$$ExternalSyntheticLambda7}, new float[]{0.0f, f5 / (f6 + f5), 1.0f}, Shader.TileMode.CLAMP));
            Paint paint2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            float f7 = -this.getAuthRequestContext;
            float f8 = this.isLayoutRequested;
            int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            paint2.setShader(new LinearGradient(0.0f, f7 + f8, 0.0f, f7 - f8, new int[]{i3, i3, this.NetworkUserEntityData$$ExternalSyntheticLambda7}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.setAntiAlias(false);
            this.MyBillsEntityDataFactory = false;
        }
        canvas.translate(0.0f, this.NetworkUserEntityData$$ExternalSyntheticLambda0 / 2.0f);
        float f9 = this.getAuthRequestContext;
        float f10 = (-f9) - this.isLayoutRequested;
        float f11 = f9 + this.lookAheadTest + (this.NetworkUserEntityData$$ExternalSyntheticLambda0 / 2.0f);
        float f12 = f11 * 2.0f;
        boolean z = this.moveToNextValue.width() - f12 > 0.0f;
        boolean z2 = this.moveToNextValue.height() - f12 > 0.0f;
        int save = canvas.save();
        canvas.translate(this.moveToNextValue.left + f11, this.moveToNextValue.top + f11);
        canvas.drawPath(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.initRecordTimeStamp);
        if (z) {
            i = save;
            canvas.drawRect(0.0f, f10, this.moveToNextValue.width() - f12, -this.getAuthRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        } else {
            i = save;
        }
        canvas.restoreToCount(i);
        int save2 = canvas.save();
        canvas.translate(this.moveToNextValue.right - f11, this.moveToNextValue.bottom - f11);
        canvas.rotate(180.0f);
        canvas.drawPath(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.initRecordTimeStamp);
        if (z) {
            canvas.drawRect(0.0f, f10, this.moveToNextValue.width() - f12, (-this.getAuthRequestContext) + this.isLayoutRequested, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.moveToNextValue.left + f11, this.moveToNextValue.bottom - f11);
        canvas.rotate(270.0f);
        canvas.drawPath(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.initRecordTimeStamp);
        if (z2) {
            canvas.drawRect(0.0f, f10, this.moveToNextValue.height() - f12, -this.getAuthRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.moveToNextValue.right - f11, this.moveToNextValue.top + f11);
        canvas.rotate(90.0f);
        canvas.drawPath(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.initRecordTimeStamp);
        if (z2) {
            canvas.drawRect(0.0f, f10, this.moveToNextValue.height() - f12, -this.getAuthRequestContext, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
        canvas.restoreToCount(save4);
        canvas.translate(0.0f, (-this.NetworkUserEntityData$$ExternalSyntheticLambda0) / 2.0f);
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(canvas, this.moveToNextValue, this.getAuthRequestContext, this.GetContactSyncConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(float f, float f2) {
        if (f < 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid shadow size ");
            sb.append(f);
            sb.append(". Must be >= 0");
            throw new IllegalArgumentException(sb.toString());
        } else if (f2 < 0.0f) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid max shadow size ");
            sb2.append(f2);
            sb2.append(". Must be >= 0");
            throw new IllegalArgumentException(sb2.toString());
        } else {
            int i = (int) (f + 0.5f);
            if (i % 2 == 1) {
                i--;
            }
            float f3 = i;
            int i2 = (int) (f2 + 0.5f);
            if (i2 % 2 == 1) {
                i2--;
            }
            float f4 = i2;
            if (f3 > f4) {
                if (!this.DatabaseTableConfigUtil) {
                    this.DatabaseTableConfigUtil = true;
                }
                f3 = f4;
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == f3 && this.scheduleImpl == f4) {
                return;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f3;
            this.scheduleImpl = f4;
            this.isLayoutRequested = (int) ((f3 * 1.5f) + this.lookAheadTest + 0.5f);
            this.MyBillsEntityDataFactory = true;
            invalidateSelf();
        }
    }
}
