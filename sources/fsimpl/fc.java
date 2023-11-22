package fsimpl;

import android.graphics.drawable.Drawable;
import com.fullstory.util.Log;
import java.util.Arrays;

/* loaded from: classes.dex */
public class fc {

    /* renamed from: a  reason: collision with root package name */
    public int f7983a;

    private fc(int i) {
        this.f7983a = i;
    }

    public static fc a(Drawable drawable) {
        if (!fd.a(drawable)) {
            Log.e("Only VectorDrawables and AnimatedVectorDrawables are allowed");
        }
        return new fc(drawable.getAlpha());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f7983a == ((fc) obj).f7983a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f7983a)});
    }
}
