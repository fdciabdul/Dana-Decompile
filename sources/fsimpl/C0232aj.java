package fsimpl;

import android.graphics.Typeface;
import java.util.WeakHashMap;

/* renamed from: fsimpl.aj  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0232aj {

    /* renamed from: a  reason: collision with root package name */
    private WeakHashMap f7853a = new WeakHashMap();
    private bG b;

    public C0232aj(bG bGVar) {
        this.b = bGVar;
    }

    public String a(Typeface typeface) {
        return (String) this.f7853a.get(typeface);
    }

    public void a(Typeface typeface, Typeface typeface2) {
        String str = (String) this.f7853a.get(typeface2);
        if (str != null) {
            this.f7853a.put(typeface, str);
        }
    }

    public void a(Typeface typeface, String str) {
        this.f7853a.put(typeface, str);
    }

    public Integer b(Typeface typeface) {
        String a2 = a(typeface);
        if (a2 == null) {
            return null;
        }
        return (Integer) this.b.A().get(a2);
    }
}
