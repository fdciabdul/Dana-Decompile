package fsimpl;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import com.fullstory.rust.RustInterface;
import com.fullstory.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class N {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7809a = false;
    private final InputMethodManager b;
    private final RustInterface c;
    private Method d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(Context context, RustInterface rustInterface) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        this.b = inputMethodManager;
        this.c = rustInterface;
        Method a2 = eV.a(inputMethodManager.getClass(), "getInputMethodWindowVisibleHeight", new Class[0]);
        this.d = a2;
        if (a2 == null) {
            Log.e("Unable to locate method for soft keyboard detection");
        }
    }

    int a() {
        Method method = this.d;
        if (method == null) {
            return 0;
        }
        try {
            Integer num = (Integer) method.invoke(this.b, new Object[0]);
            if (num != null) {
                return num.intValue();
            }
        } catch (Throwable th) {
            this.d = null;
            Log.e("Unable to invoke method for soft keyboard detection", th);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int a2 = a();
        boolean z = a2 > 0;
        if (this.f7809a != z) {
            this.f7809a = z;
            StringBuilder sb = new StringBuilder();
            sb.append("enqueueing keyboard visible=");
            sb.append(this.f7809a);
            Log.i(sb.toString());
            this.c.b(this.f7809a);
        }
        return a2;
    }
}
