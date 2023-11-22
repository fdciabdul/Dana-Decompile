package fsimpl;

import com.fullstory.rust.RustInterface;
import com.fullstory.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public class aU {

    /* renamed from: a  reason: collision with root package name */
    private RustInterface f7835a;

    public aU(RustInterface rustInterface) {
        this.f7835a = rustInterface;
    }

    public void a(List list, int i) {
        if (list == null) {
            return;
        }
        C0350eu.b("String serialization only off main thread", new Object[0]);
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = (String) list.get(i2);
            if (str != null && this.f7835a.c(str) != i2 + i + 1) {
                Log.w("Native String Table returned different ID than Android Cache");
            }
        }
    }
}
