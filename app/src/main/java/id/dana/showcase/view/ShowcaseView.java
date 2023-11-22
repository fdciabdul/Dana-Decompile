package id.dana.showcase.view;

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
import id.dana.showcase.AnimatorListener;
import id.dana.showcase.OnShowcaseClickListener;
import id.dana.showcase.target.Target;
import id.dana.splitbill.view.SplitBillIntroductionActivity;

/* loaded from: classes5.dex */
public class ShowcaseView extends FrameLayout {
    private int BuiltInFictitiousFunctionClassFactory;
    private Target KClassImpl$Data$declaredNonStaticMembers$2;
    private final Paint MyBillsEntityDataFactory;
    private ValueAnimator PlaceComponentResult;
    private final Paint getAuthRequestContext;

    public ShowcaseView(Context context) {
        super(context);
        this.getAuthRequestContext = new Paint();
        this.MyBillsEntityDataFactory = new Paint();
    }

    public ShowcaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.getAuthRequestContext = new Paint();
        this.MyBillsEntityDataFactory = new Paint();
    }

    public ShowcaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.getAuthRequestContext = new Paint();
        this.MyBillsEntityDataFactory = new Paint();
    }

    public ShowcaseView(Context context, int i, final OnShowcaseClickListener onShowcaseClickListener) {
        super(context, null);
        this.getAuthRequestContext = new Paint();
        Paint paint = new Paint();
        this.MyBillsEntityDataFactory = paint;
        this.BuiltInFictitiousFunctionClassFactory = i;
        bringToFront();
        setWillNotDraw(false);
        setLayerType(2, null);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setOnClickListener(new View.OnClickListener() { // from class: id.dana.showcase.view.ShowcaseView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShowcaseView.this.m2949lambda$new$0$iddanashowcaseviewShowcaseView(onShowcaseClickListener, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$id-dana-showcase-view-ShowcaseView  reason: not valid java name */
    public /* synthetic */ void m2949lambda$new$0$iddanashowcaseviewShowcaseView(OnShowcaseClickListener onShowcaseClickListener, View view) {
        ValueAnimator valueAnimator = this.PlaceComponentResult;
        if (valueAnimator == null || valueAnimator.isRunning() || ((Float) this.PlaceComponentResult.getAnimatedValue()).floatValue() <= 0.0f || onShowcaseClickListener == null) {
            return;
        }
        onShowcaseClickListener.getAuthRequestContext();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.getAuthRequestContext.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), this.BuiltInFictitiousFunctionClassFactory));
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.getAuthRequestContext);
        if (this.PlaceComponentResult == null || !hasActiveTarget()) {
            return;
        }
        PointF pointF = new PointF();
        if (!BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            pointF.x = this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest.x;
        } else {
            PointF pointF2 = this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest;
            PointF pointF3 = new PointF();
            pointF3.x = pointF2.x - (SplitBillIntroductionActivity.SPOTLIGHT_SIZE * 0.6f);
            pointF3.y = pointF2.y;
            pointF = pointF3;
        }
        pointF.y = this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest.y;
        this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(canvas, this.MyBillsEntityDataFactory, pointF, ((Float) this.PlaceComponentResult.getAnimatedValue()).floatValue());
    }

    private void getAuthRequestContext(long j, TimeInterpolator timeInterpolator, AnimatorListener animatorListener, float f, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", f, f2);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.addListener(animatorListener);
        ofFloat.start();
    }

    private void getAuthRequestContext(AnimatorListener animatorListener, float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        this.PlaceComponentResult = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: id.dana.showcase.view.ShowcaseView$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShowcaseView.this.m2948lambda$animateSpotlight$1$iddanashowcaseviewShowcaseView(valueAnimator);
            }
        });
        this.PlaceComponentResult.setInterpolator(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2);
        this.PlaceComponentResult.setDuration(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory);
        this.PlaceComponentResult.addListener(animatorListener);
        this.PlaceComponentResult.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$animateSpotlight$1$id-dana-showcase-view-ShowcaseView  reason: not valid java name */
    public /* synthetic */ void m2948lambda$animateSpotlight$1$iddanashowcaseviewShowcaseView(ValueAnimator valueAnimator) {
        invalidate();
    }

    public void startShowcase(long j, TimeInterpolator timeInterpolator, AnimatorListener animatorListener) {
        getAuthRequestContext(j, timeInterpolator, animatorListener, 0.0f, 1.0f);
    }

    public void finishShowcase(long j, TimeInterpolator timeInterpolator, AnimatorListener animatorListener) {
        getAuthRequestContext(j, timeInterpolator, animatorListener, 1.0f, 0.0f);
    }

    public void startSpotlight(Target target, AnimatorListener animatorListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = target;
        getAuthRequestContext(animatorListener, 0.0f, 1.0f);
    }

    public void finishSpotlight(AnimatorListener animatorListener) {
        if (hasActiveTarget()) {
            getAuthRequestContext(animatorListener, 1.0f, 0.0f);
        }
    }

    public boolean hasActiveTarget() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 != null;
    }

    private boolean BuiltInFictitiousFunctionClassFactory(Target target) {
        return target.lookAheadTest.x + (((float) SplitBillIntroductionActivity.SPOTLIGHT_SIZE) * 0.6f) >= ((float) getWidth());
    }
}
