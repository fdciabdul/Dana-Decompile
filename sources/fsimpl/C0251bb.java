package fsimpl;

import android.graphics.Path;
import android.graphics.PathMeasure;
import java.util.Arrays;

/* renamed from: fsimpl.bb  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C0251bb implements InterfaceC0253bd {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f7883a = new float[2];
    private final float[] b = new float[384];

    @Override // fsimpl.InterfaceC0253bd
    public int a(fi fiVar, Path path, int i) {
        if (path == null || path.isEmpty()) {
            return 0;
        }
        PathMeasure pathMeasure = new PathMeasure(path, false);
        int i2 = 0;
        do {
            float length = pathMeasure.getLength();
            pathMeasure.getPosTan(0.0f, this.f7883a, null);
            float[] fArr = this.b;
            int i3 = i2 * 3;
            fArr[i3] = i2;
            int i4 = i3 + 1;
            float[] fArr2 = this.f7883a;
            fArr[i4] = fArr2[0];
            fArr[i4] = fArr2[1];
            int i5 = i2 + 1;
            pathMeasure.getPosTan(length / 2.0f, fArr2, null);
            float[] fArr3 = this.b;
            int i6 = i5 * 3;
            fArr3[i6] = i5;
            int i7 = i6 + 1;
            float[] fArr4 = this.f7883a;
            fArr3[i7] = fArr4[0];
            fArr3[i7] = fArr4[1];
            int i8 = i5 + 1;
            pathMeasure.getPosTan(length, fArr4, null);
            float[] fArr5 = this.b;
            int i9 = i8 * 3;
            fArr5[i9] = i8;
            int i10 = i9 + 1;
            float[] fArr6 = this.f7883a;
            fArr5[i10] = fArr6[0];
            fArr5[i10] = fArr6[1];
            i2 = i8 + 1;
            if (i2 > 120) {
                break;
            }
        } while (pathMeasure.nextContour());
        return C0294cr.a(fiVar, i, C0294cr.a(fiVar, Arrays.copyOf(this.b, i2 * 3)), 0);
    }

    @Override // fsimpl.InterfaceC0253bd
    public boolean a() {
        return true;
    }
}
