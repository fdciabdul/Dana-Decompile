package fsimpl;

import java.io.File;
import java.net.URL;

/* loaded from: classes.dex */
class dB implements dK {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dA f7911a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dB(dA dAVar) {
        this.f7911a = dAVar;
    }

    @Override // fsimpl.dK
    public void a() {
        InterfaceC0319dq interfaceC0319dq;
        C0324dv c0324dv;
        C0324dv c0324dv2;
        C0324dv c0324dv3;
        C0324dv c0324dv4;
        C0324dv c0324dv5;
        interfaceC0319dq = this.f7911a.f7910a.h;
        c0324dv = this.f7911a.b;
        File file = c0324dv.b;
        c0324dv2 = this.f7911a.b;
        String str = c0324dv2.f;
        c0324dv3 = this.f7911a.b;
        URL url = c0324dv3.j;
        c0324dv4 = this.f7911a.b;
        String str2 = c0324dv4.k;
        c0324dv5 = this.f7911a.b;
        interfaceC0319dq.a(file, str, url, str2, c0324dv5.l);
    }
}
