package fsimpl;

import android.app.Activity;
import com.fullstory.rust.RustInterface;
import java.util.List;

/* renamed from: fsimpl.bi  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0258bi {
    private AbstractC0258bi() {
    }

    public static AbstractC0258bi a(bG bGVar, RustInterface rustInterface, aA aAVar) {
        if (bGVar.x()) {
            try {
                return new C0261bl(new C0257bh(rustInterface, aAVar));
            } catch (Throwable unused) {
            }
        }
        return new C0260bk();
    }

    public abstract List a();

    public abstract void a(Activity activity);

    public abstract void b(Activity activity);
}
