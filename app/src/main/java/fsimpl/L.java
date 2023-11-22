package fsimpl;

import android.view.View;
import android.view.Window;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class L implements InterfaceC0242at {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ K f7807a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(K k) {
        this.f7807a = k;
    }

    @Override // fsimpl.InterfaceC0242at
    public void a(Window window, View view) {
        C0360j c0360j;
        C0239aq.a(window);
        c0360j = this.f7807a.c;
        c0360j.a(view);
    }
}
