package fsimpl;

import android.graphics.drawable.Drawable;
import java.util.HashMap;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class aX {

    /* renamed from: a  reason: collision with root package name */
    private WeakHashMap f7838a = new WeakHashMap();

    public aY a(Drawable drawable) {
        aY aYVar;
        if (fd.b(drawable)) {
            this.f7838a.remove(drawable);
            return null;
        }
        HashMap hashMap = (HashMap) this.f7838a.get(drawable);
        if (hashMap == null || (aYVar = (aY) hashMap.get(fc.a(drawable))) == null) {
            return null;
        }
        return aYVar;
    }

    public void a(Drawable drawable, String str, int i, int i2) {
        if (fd.b(drawable)) {
            return;
        }
        HashMap hashMap = (HashMap) this.f7838a.get(drawable);
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        aY aYVar = new aY(this);
        aYVar.f7839a = str;
        aYVar.b = i;
        aYVar.c = i2;
        hashMap.put(fc.a(drawable), aYVar);
        this.f7838a.put(drawable, hashMap);
    }
}
