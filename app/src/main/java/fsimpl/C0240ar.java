package fsimpl;

import android.view.View;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: fsimpl.ar  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0240ar {

    /* renamed from: a  reason: collision with root package name */
    static final Field f7860a = eV.a(C0355ez.c, "mWindow");
    private InterfaceC0242at b;
    private final fg c = new fg();
    private final WeakHashMap d = new WeakHashMap();
    private InterfaceC0243au e = new C0241as(this);

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(View view) {
        if (C0355ez.e != null) {
            return C0355ez.e.isInstance(view);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Window e(View view) {
        Object obj;
        if (f7860a == null || !C0355ez.c.isInstance(view)) {
            for (Field field : view.getClass().getDeclaredFields()) {
                if (Window.class.isAssignableFrom(field.getType())) {
                    field.setAccessible(true);
                    obj = field.get(view);
                }
            }
            return null;
        }
        obj = f7860a.get(view);
        return (Window) obj;
    }

    public Window a(View view) {
        WeakReference weakReference = (WeakReference) this.d.get(view);
        if (weakReference == null) {
            return null;
        }
        return (Window) weakReference.get();
    }

    public List a() {
        List b = dV.b();
        Iterator it = b.iterator();
        while (it.hasNext()) {
            this.e.a((View) it.next());
        }
        return b;
    }

    public void a(InterfaceC0242at interfaceC0242at) {
        this.b = interfaceC0242at;
    }
}
