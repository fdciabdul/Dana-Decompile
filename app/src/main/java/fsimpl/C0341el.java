package fsimpl;

import java.util.Map;
import java.util.UUID;

/* renamed from: fsimpl.el  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0341el extends AbstractC0340ek {

    /* renamed from: a  reason: collision with root package name */
    private final EnumC0343en f7971a;
    private final Map b;
    private final boolean c;
    private final UUID d;

    public C0341el(EnumC0343en enumC0343en, Map map) {
        this(enumC0343en, map, false, null);
    }

    public C0341el(EnumC0343en enumC0343en, Map map, boolean z, UUID uuid) {
        this.f7971a = enumC0343en;
        this.b = map;
        this.c = z;
        this.d = uuid;
    }

    @Override // fsimpl.InterfaceC0339ej
    public void a(fi fiVar, eJ eJVar) {
        Map map = this.b;
        if (map == null || map.isEmpty()) {
            return;
        }
        int a2 = fiVar.a(this.f7971a.c);
        int a3 = eS.a(fiVar, this.b);
        UUID uuid = this.d;
        eJVar.a(a(fiVar, (byte) 14, C0282cf.a(fiVar, a2, a3, this.c, uuid != null ? fiVar.a(uuid.toString()) : 0)));
    }
}
