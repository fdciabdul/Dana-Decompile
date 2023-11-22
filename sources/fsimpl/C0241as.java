package fsimpl;

import android.view.View;
import android.view.Window;
import com.fullstory.util.Log;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: fsimpl.as  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0241as implements InterfaceC0243au {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0240ar f7861a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0241as(C0240ar c0240ar) {
        this.f7861a = c0240ar;
    }

    @Override // fsimpl.InterfaceC0243au
    public void a(View view) {
        fg fgVar;
        boolean d;
        Window e;
        WeakHashMap weakHashMap;
        InterfaceC0242at interfaceC0242at;
        if (view == null || view.getHandler() == null) {
            return;
        }
        fgVar = this.f7861a.c;
        if (fgVar.a(view, 1) != 1) {
            d = C0240ar.d(view);
            if (d) {
                return;
            }
            try {
                e = C0240ar.e(view);
                if (e != null) {
                    weakHashMap = this.f7861a.d;
                    weakHashMap.put(view, new WeakReference(e));
                    interfaceC0242at = this.f7861a.b;
                    interfaceC0242at.a(e, view);
                } else if ("FSPreviewMode".equals(view.getTag())) {
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Couldn't get a window from a view: ");
                    sb.append(view.getClass());
                    Log.e(sb.toString());
                }
            } catch (IllegalAccessException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Exception getting a window from a view: ");
                sb2.append(view.getClass());
                Log.e(sb2.toString());
            }
        }
    }
}
