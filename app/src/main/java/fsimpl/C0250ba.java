package fsimpl;

import android.graphics.Path;

/* renamed from: fsimpl.ba  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C0250ba implements InterfaceC0253bd {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7882a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0250ba() {
        Path path = new Path();
        path.addRoundRect(0.0f, 0.0f, 50.0f, 100.0f, 10.0f, 15.0f, Path.Direction.CCW);
        this.f7882a = path.approximate(1.0f).length > 20;
    }

    @Override // fsimpl.InterfaceC0253bd
    public int a(fi fiVar, Path path, int i) {
        if (path == null || path.isEmpty()) {
            return 0;
        }
        return C0294cr.a(fiVar, i, C0294cr.a(fiVar, path.approximate(1.0f)), 0);
    }

    @Override // fsimpl.InterfaceC0253bd
    public boolean a() {
        return this.f7882a;
    }
}
