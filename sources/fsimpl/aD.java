package fsimpl;

import android.graphics.BitmapShader;
import android.graphics.Shader;
import com.fullstory.util.Log;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class aD {

    /* renamed from: a  reason: collision with root package name */
    private static final Field f7821a = eV.a(31, 30, BitmapShader.class, "mTileX");
    private static final Field b = eV.a(31, 30, BitmapShader.class, "mTileY");
    private static final boolean c;

    static {
        Field field = f7821a;
        if (field != null && !field.getType().equals(Shader.TileMode.class) && !f7821a.getType().equals(Integer.TYPE)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected type for mTileX: ");
            sb.append(f7821a.getType());
            Log.e(sb.toString());
        }
        Field field2 = b;
        if (field2 != null && !field2.getType().equals(Shader.TileMode.class) && !b.getType().equals(Integer.TYPE)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected type for mTileY: ");
            sb2.append(b.getType());
            Log.e(sb2.toString());
        }
        boolean z = f7821a == null || b == null;
        c = z;
        if (z) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to locate BitmapShader bits: tileX=");
            sb3.append(f7821a);
            sb3.append("; tileY=");
            sb3.append(b);
            Log.e(sb3.toString());
        }
    }

    private int a(Object obj) {
        return obj instanceof Shader.TileMode ? aR.a((Shader.TileMode) obj) : ((Integer) obj).intValue() + 1;
    }

    private void b(cQ cQVar, BitmapShader bitmapShader) {
        try {
            cQVar.p(a(f7821a.get(bitmapShader)));
            cQVar.q(a(b.get(bitmapShader)));
        } catch (Throwable th) {
            cS.a("Failed to read bitmap shader", th);
        }
    }

    public void a(cQ cQVar, BitmapShader bitmapShader) {
        if (bitmapShader == null || c) {
            return;
        }
        b(cQVar, bitmapShader);
    }
}
