package fsimpl;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;

/* renamed from: fsimpl.p  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0366p {

    /* renamed from: a  reason: collision with root package name */
    private RectF f7998a = new RectF();
    private Region b = new Region();
    private float[] c = new float[8];
    private Region d = new Region();

    public void a() {
        synchronized (this.d) {
            this.d.setEmpty();
        }
    }

    public void a(Matrix matrix, int i, int i2, int i3, int i4) {
        Path path = new Path();
        float[] fArr = this.c;
        float f = i;
        fArr[0] = f;
        float f2 = i2;
        fArr[1] = f2;
        float f3 = i3;
        fArr[2] = f3;
        fArr[3] = f2;
        fArr[4] = f3;
        float f4 = i4;
        fArr[5] = f4;
        fArr[6] = f;
        fArr[7] = f4;
        matrix.mapPoints(fArr);
        float[] fArr2 = this.c;
        path.moveTo(fArr2[0], fArr2[1]);
        float[] fArr3 = this.c;
        path.lineTo(fArr3[2], fArr3[3]);
        float[] fArr4 = this.c;
        path.lineTo(fArr4[4], fArr4[5]);
        float[] fArr5 = this.c;
        path.lineTo(fArr5[6], fArr5[7]);
        path.close();
        this.b.set(-10000, -10000, 10000, 10000);
        Region region = this.b;
        region.setPath(path, region);
        this.d.op(this.b, Region.Op.UNION);
    }

    public boolean a(int i, int i2) {
        return this.d.contains(i, i2);
    }
}
