package id.dana.core.ui.showcase.view;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import id.dana.component.utils.SizeUtil;
import id.dana.core.ui.showcase.AnimatorListener;
import id.dana.core.ui.showcase.OnShowcaseClickListener;
import id.dana.core.ui.showcase.target.Target;

/* loaded from: classes4.dex */
public class ShowcaseView extends FrameLayout {
    private Target BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private final Paint MyBillsEntityDataFactory;
    private final Paint PlaceComponentResult;
    private ValueAnimator getAuthRequestContext;

    public ShowcaseView(Context context) {
        super(context);
        this.MyBillsEntityDataFactory = new Paint();
        this.PlaceComponentResult = new Paint();
    }

    public ShowcaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MyBillsEntityDataFactory = new Paint();
        this.PlaceComponentResult = new Paint();
    }

    public ShowcaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MyBillsEntityDataFactory = new Paint();
        this.PlaceComponentResult = new Paint();
    }

    public ShowcaseView(Context context, int i, final OnShowcaseClickListener onShowcaseClickListener) {
        super(context, null);
        this.MyBillsEntityDataFactory = new Paint();
        Paint paint = new Paint();
        this.PlaceComponentResult = paint;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        bringToFront();
        setWillNotDraw(false);
        setLayerType(2, null);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.showcase.view.ShowcaseView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShowcaseView.this.m622lambda$new$0$iddanacoreuishowcaseviewShowcaseView(onShowcaseClickListener, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$id-dana-core-ui-showcase-view-ShowcaseView  reason: not valid java name */
    public /* synthetic */ void m622lambda$new$0$iddanacoreuishowcaseviewShowcaseView(OnShowcaseClickListener onShowcaseClickListener, View view) {
        ValueAnimator valueAnimator = this.getAuthRequestContext;
        if (valueAnimator == null || valueAnimator.isRunning() || ((Float) this.getAuthRequestContext.getAnimatedValue()).floatValue() <= 0.0f || onShowcaseClickListener == null) {
            return;
        }
        onShowcaseClickListener.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.MyBillsEntityDataFactory.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), this.KClassImpl$Data$declaredNonStaticMembers$2));
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.MyBillsEntityDataFactory);
        if (this.getAuthRequestContext == null || !hasActiveTarget()) {
            return;
        }
        PointF pointF = new PointF();
        if (!BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory)) {
            pointF.x = this.BuiltInFictitiousFunctionClassFactory.scheduleImpl.x;
        } else {
            PointF pointF2 = this.BuiltInFictitiousFunctionClassFactory.scheduleImpl;
            PointF pointF3 = new PointF();
            pointF3.x = pointF2.x - (SizeUtil.PlaceComponentResult(20) * 0.6f);
            pointF3.y = pointF2.y;
            pointF = pointF3;
        }
        pointF.y = this.BuiltInFictitiousFunctionClassFactory.scheduleImpl.y;
        this.BuiltInFictitiousFunctionClassFactory.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(canvas, this.PlaceComponentResult, pointF, ((Float) this.getAuthRequestContext.getAnimatedValue()).floatValue());
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(long j, TimeInterpolator timeInterpolator, AnimatorListener animatorListener, float f, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", f, f2);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.addListener(animatorListener);
        ofFloat.start();
    }

    private void MyBillsEntityDataFactory(AnimatorListener animatorListener, float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        this.getAuthRequestContext = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: id.dana.core.ui.showcase.view.ShowcaseView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShowcaseView.this.m621xa6986257(valueAnimator);
            }
        });
        this.getAuthRequestContext.setInterpolator(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        this.getAuthRequestContext.setDuration(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
        this.getAuthRequestContext.addListener(animatorListener);
        this.getAuthRequestContext.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$animateSpotlight$1$id-dana-core-ui-showcase-view-ShowcaseView  reason: not valid java name */
    public /* synthetic */ void m621xa6986257(ValueAnimator valueAnimator) {
        invalidate();
    }

    public void startShowcase(long j, TimeInterpolator timeInterpolator, AnimatorListener animatorListener) {
        KClassImpl$Data$declaredNonStaticMembers$2(j, timeInterpolator, animatorListener, 0.0f, 1.0f);
    }

    public void finishShowcase(long j, TimeInterpolator timeInterpolator, AnimatorListener animatorListener) {
        KClassImpl$Data$declaredNonStaticMembers$2(j, timeInterpolator, animatorListener, 1.0f, 0.0f);
    }

    public void startSpotlight(Target target, AnimatorListener animatorListener) {
        this.BuiltInFictitiousFunctionClassFactory = target;
        MyBillsEntityDataFactory(animatorListener, 0.0f, 1.0f);
    }

    public void finishSpotlight(AnimatorListener animatorListener) {
        if (hasActiveTarget()) {
            MyBillsEntityDataFactory(animatorListener, 1.0f, 0.0f);
        }
    }

    public boolean hasActiveTarget() {
        return this.BuiltInFictitiousFunctionClassFactory != null;
    }

    private boolean BuiltInFictitiousFunctionClassFactory(Target target) {
        return target.scheduleImpl.x + (((float) SizeUtil.PlaceComponentResult(20)) * 0.6f) >= ((float) getWidth());
    }
}
