package id.dana.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017JY\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/utils/SplashSpan;", "Landroid/text/style/ReplacementSpan;", "Landroid/graphics/Canvas;", "p0", "", "p1", "", "p2", "p3", "", "p4", "p5", "p6", "p7", "Landroid/graphics/Paint;", "p8", "", "draw", "(Landroid/graphics/Canvas;Ljava/lang/CharSequence;IIFIIILandroid/graphics/Paint;)V", "Landroid/graphics/Paint$FontMetricsInt;", "getSize", "(Landroid/graphics/Paint;Ljava/lang/CharSequence;IILandroid/graphics/Paint$FontMetricsInt;)I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SplashSpan extends ReplacementSpan {
    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint p0, CharSequence p1, int p2, int p3, Paint.FontMetricsInt p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        int i = p3 - p2;
        float[] fArr = new float[i];
        float[] fArr2 = new float[1];
        p0.getTextWidths(p1, p2, p3, fArr);
        p0.getTextWidths("/", fArr2);
        int roundToInt = MathKt.roundToInt(fArr2[0]);
        for (int i2 = 0; i2 < i; i2++) {
            roundToInt += (int) fArr[i2];
        }
        return roundToInt;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas p0, CharSequence p1, int p2, int p3, float p4, int p5, int p6, int p7, Paint p8) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p8, "");
        if (p1 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append('/');
            sb.append((Object) p1.subSequence(p2, p3));
            String obj = sb.toString();
            p0.drawText(obj, 0, obj.length(), p4, p6, p8);
        }
    }
}
