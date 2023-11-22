package id.dana.core.ui.custom.tooltip;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import com.fullstory.instrumentation.FSDraw;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0018\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001c"}, d2 = {"Lid/dana/core/ui/custom/tooltip/ArrowDrawable;", "Landroid/graphics/drawable/ColorDrawable;", "Landroid/graphics/Canvas;", "p0", "", "draw", "(Landroid/graphics/Canvas;)V", "", "getOpacity", "()I", "Landroid/graphics/Rect;", "onBoundsChange", "(Landroid/graphics/Rect;)V", "setAlpha", "(I)V", "setColor", "Landroid/graphics/ColorFilter;", "setColorFilter", "(Landroid/graphics/ColorFilter;)V", "PlaceComponentResult", "I", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/graphics/Paint;", "MyBillsEntityDataFactory", "Landroid/graphics/Paint;", "getAuthRequestContext", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "p1", "<init>", "(II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ArrowDrawable extends ColorDrawable implements FSDraw {
    private final int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Paint getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Path MyBillsEntityDataFactory;

    public ArrowDrawable(int i, int i2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
        Paint paint = new Paint(1);
        paint.setColor(i);
        this.getAuthRequestContext = paint;
        this.MyBillsEntityDataFactory = new Path();
    }

    @Override // android.graphics.drawable.Drawable
    protected final void onBoundsChange(Rect p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onBoundsChange(p0);
        synchronized (this) {
            float width = (p0.width() * 5) / 100;
            float height = (p0.height() * 5) / 100;
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i == 48) {
                float f = width * 2.5f;
                float f2 = 3.0f * f;
                float f3 = height * 10.0f;
                float f4 = f * 2.0f;
                float f5 = height / 4.0f;
                this.MyBillsEntityDataFactory.moveTo(0.0f, 0.0f);
                this.MyBillsEntityDataFactory.cubicTo(0.0f, 0.0f, f4, f5, f2, f3);
                this.MyBillsEntityDataFactory.cubicTo(f2, f3, p0.width() / 2, p0.height() * 1.5f, p0.width() - f2, f3);
                this.MyBillsEntityDataFactory.cubicTo(p0.width() - f2, f3, p0.width() - f4, f5, p0.width(), 0.0f);
            } else if (i == 80) {
                float f6 = width * 2.5f;
                float f7 = 3.0f * f6;
                float f8 = f6 * 2.0f;
                float height2 = p0.height() - (height / 4.0f);
                float height3 = p0.height() - (height * 10.0f);
                this.MyBillsEntityDataFactory.moveTo(0.0f, p0.height());
                this.MyBillsEntityDataFactory.cubicTo(0.0f, p0.height(), f8, height2, f7, height3);
                this.MyBillsEntityDataFactory.cubicTo(f7, height3, p0.width() / 2, -height3, p0.width() - f7, height3);
                this.MyBillsEntityDataFactory.cubicTo(p0.width() - f7, height3, p0.width() - f8, height2, p0.width(), p0.height());
            } else if (i == 8388611) {
                float f9 = height * 2.5f;
                float f10 = width * 10.0f;
                float f11 = 3.0f * f9;
                float f12 = width / 4.0f;
                float f13 = f9 * 2.0f;
                this.MyBillsEntityDataFactory.moveTo(0.0f, 0.0f);
                this.MyBillsEntityDataFactory.cubicTo(0.0f, 0.0f, f12, f13, f10, f11);
                this.MyBillsEntityDataFactory.cubicTo(f10, f11, p0.width() * 1.5f, p0.height() / 2, f10, p0.height() - f11);
                this.MyBillsEntityDataFactory.cubicTo(f10, p0.height() - f11, f12, p0.height() - f13, 0.0f, p0.height());
            } else if (i == 8388613) {
                float f14 = height * 2.5f;
                float f15 = 3.0f * f14;
                float f16 = f14 * 2.0f;
                float width2 = p0.width() - (width / 4.0f);
                float width3 = p0.width() - (width * 10.0f);
                this.MyBillsEntityDataFactory.moveTo(p0.width(), 0.0f);
                this.MyBillsEntityDataFactory.cubicTo(p0.width(), 0.0f, width2, f16, width3, f15);
                this.MyBillsEntityDataFactory.cubicTo(width3, f15, -width3, p0.height() / 2, width3, p0.height() - f15);
                this.MyBillsEntityDataFactory.cubicTo(width3, p0.height() - f15, width2, p0.height() - f16, p0.width(), p0.height());
            }
            this.MyBillsEntityDataFactory.close();
        }
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.drawColor(this.BuiltInFictitiousFunctionClassFactory);
        p0.drawPath(this.MyBillsEntityDataFactory, this.getAuthRequestContext);
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int p0) {
        this.getAuthRequestContext.setAlpha(p0);
    }

    @Override // android.graphics.drawable.ColorDrawable
    public final void setColor(int p0) {
        this.getAuthRequestContext.setColor(p0);
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter p0) {
        this.getAuthRequestContext.setColorFilter(p0);
    }

    @Override // android.graphics.drawable.ColorDrawable, android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        if (this.getAuthRequestContext.getColorFilter() != null) {
            return -3;
        }
        int color = this.getAuthRequestContext.getColor() >>> 24;
        if (color != 0) {
            return color != 255 ? -3 : -1;
        }
        return -2;
    }
}
