package fsimpl;

import java.util.Map;

/* renamed from: fsimpl.ei  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0338ei extends AbstractC0340ek {

    /* renamed from: a  reason: collision with root package name */
    private final String f7970a;
    private final Map b;

    public C0338ei(String str, Map map) {
        this.f7970a = str;
        this.b = map;
    }

    @Override // fsimpl.InterfaceC0339ej
    public void a(fi fiVar, eJ eJVar) {
        eJVar.a(a(fiVar, (byte) 13, C0281ce.a(fiVar, fiVar.a("user"), fiVar.a(this.f7970a), eS.a(fiVar, this.b))));
    }
}
