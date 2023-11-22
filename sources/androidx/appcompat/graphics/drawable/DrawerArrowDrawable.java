package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import com.fullstory.instrumentation.FSDraw;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public class DrawerArrowDrawable extends Drawable implements FSDraw {
    private static final float KClassImpl$Data$declaredNonStaticMembers$2 = (float) Math.toRadians(45.0d);
    private float BuiltInFictitiousFunctionClassFactory;
    private final int DatabaseTableConfigUtil;
    private final Path GetContactSyncConfig;
    public boolean MyBillsEntityDataFactory;
    private final Paint NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private float PlaceComponentResult;
    public float getAuthRequestContext;
    private int getErrorConfigVersion;
    private float lookAheadTest;
    private float moveToNextValue;
    private float scheduleImpl;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ArrowDirection {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = paint;
        this.GetContactSyncConfig = new Path();
        this.MyBillsEntityDataFactory = false;
        this.getErrorConfigVersion = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.RequestMoneyQrContract$View, R.attr.getSupportButtonTintMode, R.style.BuiltInFictitiousFunctionClassFactory);
        int color = obtainStyledAttributes.getColor(R.styleable.z, 0);
        if (color != this.NetworkUserEntityData$$ExternalSyntheticLambda0.getColor()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.setColor(color);
            invalidateSelf();
        }
        float dimension = obtainStyledAttributes.getDimension(R.styleable.OtpRegistrationPresenter$input$1, 0.0f);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.getStrokeWidth() != dimension) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.setStrokeWidth(dimension);
            double d = dimension / 2.0f;
            double cos = Math.cos(KClassImpl$Data$declaredNonStaticMembers$2);
            Double.isNaN(d);
            this.lookAheadTest = (float) (d * cos);
            invalidateSelf();
        }
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.FlowableReduce$ReduceSubscriber, true);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 != z) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = z;
            invalidateSelf();
        }
        float round = Math.round(obtainStyledAttributes.getDimension(R.styleable.FlowableCreate$BufferAsyncEmitter, 0.0f));
        if (round != this.scheduleImpl) {
            this.scheduleImpl = round;
            invalidateSelf();
        }
        this.DatabaseTableConfigUtil = obtainStyledAttributes.getDimensionPixelSize(R.styleable.getCardNumberOCR, 0);
        this.moveToNextValue = Math.round(obtainStyledAttributes.getDimension(R.styleable.initAnimators, 0.0f));
        this.PlaceComponentResult = Math.round(obtainStyledAttributes.getDimension(R.styleable.y, 0.0f));
        this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getDimension(R.styleable.setNetAuthId, 0.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i = this.getErrorConfigVersion;
        boolean z = false;
        if (i != 0 && (i == 1 || (i == 3 ? DrawableCompat.PlaceComponentResult(this) == 0 : DrawableCompat.PlaceComponentResult(this) == 1))) {
            z = true;
        }
        float f = this.PlaceComponentResult;
        float sqrt = (float) Math.sqrt(f * f * 2.0f);
        float f2 = this.moveToNextValue;
        float f3 = this.getAuthRequestContext;
        float f4 = ((sqrt - f2) * f3) + f2;
        float f5 = f2 + ((this.BuiltInFictitiousFunctionClassFactory - f2) * f3);
        float round = Math.round(((this.lookAheadTest - 0.0f) * f3) + 0.0f);
        float f6 = ((KClassImpl$Data$declaredNonStaticMembers$2 - 0.0f) * this.getAuthRequestContext) + 0.0f;
        float f7 = z ? 0.0f : -180.0f;
        float f8 = f7 + (((z ? 180.0f : 0.0f) - f7) * this.getAuthRequestContext);
        double d = f4;
        double d2 = f6;
        double cos = Math.cos(d2);
        Double.isNaN(d);
        boolean z2 = z;
        float round2 = (float) Math.round(cos * d);
        double sin = Math.sin(d2);
        Double.isNaN(d);
        float round3 = (float) Math.round(d * sin);
        this.GetContactSyncConfig.rewind();
        float strokeWidth = this.scheduleImpl + this.NetworkUserEntityData$$ExternalSyntheticLambda0.getStrokeWidth();
        float f9 = strokeWidth + (((-this.lookAheadTest) - strokeWidth) * this.getAuthRequestContext);
        float f10 = (-f5) / 2.0f;
        this.GetContactSyncConfig.moveTo(f10 + round, 0.0f);
        this.GetContactSyncConfig.rLineTo(f5 - (round * 2.0f), 0.0f);
        this.GetContactSyncConfig.moveTo(f10, f9);
        this.GetContactSyncConfig.rLineTo(round2, round3);
        this.GetContactSyncConfig.moveTo(f10, -f9);
        this.GetContactSyncConfig.rLineTo(round2, -round3);
        this.GetContactSyncConfig.close();
        canvas.save();
        float strokeWidth2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.getStrokeWidth();
        float height = bounds.height();
        canvas.translate(bounds.centerX(), ((((int) ((height - (3.0f * strokeWidth2)) - (2.0f * r5))) / 4) * 2) + (strokeWidth2 * 1.5f) + this.scheduleImpl);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            canvas.rotate(f8 * (this.MyBillsEntityDataFactory ^ z2 ? -1 : 1));
        } else if (z2) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.GetContactSyncConfig, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAlpha()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.DatabaseTableConfigUtil;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.DatabaseTableConfigUtil;
    }

    public void setProgress(float f) {
        if (this.getAuthRequestContext != f) {
            this.getAuthRequestContext = f;
            invalidateSelf();
        }
    }
}
