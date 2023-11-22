package fsimpl;

import android.graphics.Path;
import java.util.Map;

/* renamed from: fsimpl.bc  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0252bc {

    /* renamed from: a  reason: collision with root package name */
    private final InterfaceC0253bd f7884a = a();

    private static InterfaceC0253bd a() {
        InterfaceC0253bd a2 = a(new C0254be());
        if (a2 == null) {
            InterfaceC0253bd a3 = a(new C0250ba());
            if (a3 == null) {
                InterfaceC0253bd a4 = a(new C0251bb());
                if (a4 == null) {
                    return null;
                }
                return a4;
            }
            return a3;
        }
        return a2;
    }

    private static InterfaceC0253bd a(InterfaceC0253bd interfaceC0253bd) {
        if (interfaceC0253bd.a()) {
            return interfaceC0253bd;
        }
        return null;
    }

    public int a(Map map, fi fiVar) {
        int i;
        C0350eu.a("PathSerializer.serialize", new Object[0]);
        if (map == null) {
            return 0;
        }
        int[] iArr = new int[map.size()];
        int i2 = 0;
        for (Map.Entry entry : map.entrySet()) {
            Path path = (Path) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            InterfaceC0253bd interfaceC0253bd = this.f7884a;
            if (interfaceC0253bd == null || path == null) {
                i = i2 + 1;
                iArr[i2] = C0294cr.a(fiVar, intValue, 0, 0);
            } else {
                int a2 = interfaceC0253bd.a(fiVar, path, intValue);
                if (a2 != 0) {
                    iArr[i2] = a2;
                    i2++;
                } else {
                    i = i2 + 1;
                    iArr[i2] = C0294cr.a(fiVar, intValue, 0, 0);
                }
            }
            i2 = i;
        }
        return C0291co.b(fiVar, iArr);
    }
}
