package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class CircleImageView extends ImageView {
    private Animation.AnimationListener BuiltInFictitiousFunctionClassFactory;
    int PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleImageView(Context context) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f = getContext().getResources().getDisplayMetrics().density;
        int i = (int) (1.75f * f);
        int i2 = (int) (0.0f * f);
        this.PlaceComponentResult = (int) (3.5f * f);
        if (PlaceComponentResult()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.MyBillsEntityDataFactory(this, f * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShadow(this.PlaceComponentResult));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.PlaceComponentResult, i2, i, 503316480);
            int i3 = this.PlaceComponentResult;
            setPadding(i3, i3, i3, i3);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(-328966);
        ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this, shapeDrawable);
    }

    private static boolean PlaceComponentResult() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (PlaceComponentResult()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth() + (this.PlaceComponentResult * 2), getMeasuredHeight() + (this.PlaceComponentResult * 2));
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.BuiltInFictitiousFunctionClassFactory = animationListener;
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.BuiltInFictitiousFunctionClassFactory;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.BuiltInFictitiousFunctionClassFactory;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void setBackgroundColorRes(int i) {
        setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), i));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    /* loaded from: classes6.dex */
    class OvalShadow extends OvalShape {
        private Paint KClassImpl$Data$declaredNonStaticMembers$2 = new Paint();
        private RadialGradient getAuthRequestContext;

        OvalShadow(int i) {
            CircleImageView.this.PlaceComponentResult = i;
            MyBillsEntityDataFactory((int) rect().width());
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        protected void onResize(float f, float f2) {
            super.onResize(f, f2);
            MyBillsEntityDataFactory((int) f);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            float width = CircleImageView.this.getWidth() / 2;
            float height = CircleImageView.this.getHeight() / 2;
            canvas.drawCircle(width, height, width, this.KClassImpl$Data$declaredNonStaticMembers$2);
            canvas.drawCircle(width, height, r0 - CircleImageView.this.PlaceComponentResult, paint);
        }

        private void MyBillsEntityDataFactory(int i) {
            float f = i / 2;
            RadialGradient radialGradient = new RadialGradient(f, f, CircleImageView.this.PlaceComponentResult, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.getAuthRequestContext = radialGradient;
            this.KClassImpl$Data$declaredNonStaticMembers$2.setShader(radialGradient);
        }
    }
}
