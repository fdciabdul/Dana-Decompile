package fsimpl;

import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes8.dex */
public class aM extends aL {
    private fg b = new fg();

    private int b(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, false);
        return ((Float.floatToIntBits(rectF.top) ^ Integer.rotateLeft(Float.floatToIntBits(rectF.left), 8)) ^ Integer.rotateLeft(Float.floatToIntBits(rectF.bottom), 16)) ^ Integer.rotateLeft(Float.floatToIntBits(rectF.right), 24);
    }

    @Override // fsimpl.aL
    public int a(Path path) {
        int b = b(path);
        if (this.b.a(path) && this.b.b(path) != b) {
            this.f7829a.d(path);
        }
        this.b.a(path, b);
        return super.a((Object) path);
    }
}
