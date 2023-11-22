package fsimpl;

import com.fullstory.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class dW {

    /* renamed from: a  reason: collision with root package name */
    public final Method[] f7928a;
    public final Method[] b;
    public final Class[] c;
    private boolean d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dW(int i) {
        this.f7928a = new Method[i];
        this.b = new Method[i];
        this.c = new Class[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, Method method, Method method2, Class cls) {
        this.f7928a[i] = method;
        this.b[i] = method2;
        this.c[i] = cls;
        if (method == null || method2 != null) {
            return;
        }
        this.d = true;
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to hook all of the expected FS methods: platform method=");
        sb.append(method);
        Log.e(sb.toString());
    }

    public boolean a() {
        return this.d;
    }
}
