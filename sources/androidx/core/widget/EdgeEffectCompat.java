package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public final class EdgeEffectCompat {
    private final EdgeEffect PlaceComponentResult;

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.PlaceComponentResult = InstrumentInjector.maybeWrapEdgeEffect(new EdgeEffect(context), context);
    }

    public static EdgeEffect KClassImpl$Data$declaredNonStaticMembers$2(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.getAuthRequestContext(context, attributeSet);
        }
        return new EdgeEffect(context);
    }

    public static float getAuthRequestContext(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.PlaceComponentResult(edgeEffect);
        }
        return 0.0f;
    }

    @Deprecated
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        this.PlaceComponentResult.setSize(i, i2);
    }

    @Deprecated
    public final boolean getAuthRequestContext() {
        return this.PlaceComponentResult.isFinished();
    }

    @Deprecated
    public final void MyBillsEntityDataFactory() {
        this.PlaceComponentResult.finish();
    }

    @Deprecated
    public final boolean PlaceComponentResult(float f) {
        this.PlaceComponentResult.onPull(f);
        return true;
    }

    public static void MyBillsEntityDataFactory(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.getAuthRequestContext(edgeEffect, f, f2);
        } else {
            edgeEffect.onPull(f);
        }
    }

    public static float getAuthRequestContext(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.MyBillsEntityDataFactory(edgeEffect, f, f2);
        }
        MyBillsEntityDataFactory(edgeEffect, f, f2);
        return f;
    }

    @Deprecated
    public final boolean PlaceComponentResult() {
        this.PlaceComponentResult.onRelease();
        return this.PlaceComponentResult.isFinished();
    }

    @Deprecated
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        this.PlaceComponentResult.onAbsorb(i);
        return true;
    }

    @Deprecated
    public final boolean MyBillsEntityDataFactory(Canvas canvas) {
        return this.PlaceComponentResult.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api31Impl {
        private Api31Impl() {
        }

        public static EdgeEffect getAuthRequestContext(Context context, AttributeSet attributeSet) {
            try {
                return InstrumentInjector.maybeWrapEdgeEffect(new EdgeEffect(context, attributeSet), context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float MyBillsEntityDataFactory(EdgeEffect edgeEffect, float f, float f2) {
            try {
                return edgeEffect.onPullDistance(f, f2);
            } catch (Throwable unused) {
                edgeEffect.onPull(f, f2);
                return 0.0f;
            }
        }

        public static float PlaceComponentResult(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static void getAuthRequestContext(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }
}
