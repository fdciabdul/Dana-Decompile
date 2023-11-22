package fsimpl;

import java.util.ArrayList;
import java.util.List;

/* renamed from: fsimpl.v  reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0372v {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8003a;
    private boolean b;
    private boolean c;
    private K d;
    private List e;

    private C0372v() {
        this.f8003a = true;
        this.b = false;
        this.c = true;
        this.d = null;
        this.e = new ArrayList();
    }

    public static /* synthetic */ K a(C0372v c0372v, K k) {
        c0372v.d = k;
        return k;
    }

    public static /* synthetic */ List a(C0372v c0372v, List list) {
        c0372v.e = list;
        return list;
    }

    public static /* synthetic */ boolean a(C0372v c0372v) {
        return c0372v.f8003a;
    }

    public static /* synthetic */ boolean a(C0372v c0372v, boolean z) {
        c0372v.f8003a = z;
        return z;
    }

    public static /* synthetic */ boolean b(C0372v c0372v) {
        return c0372v.b;
    }

    public static /* synthetic */ boolean b(C0372v c0372v, boolean z) {
        c0372v.c = z;
        return z;
    }

    public static /* synthetic */ K c(C0372v c0372v) {
        return c0372v.d;
    }

    public static /* synthetic */ boolean c(C0372v c0372v, boolean z) {
        c0372v.b = z;
        return z;
    }

    public static /* synthetic */ List d(C0372v c0372v) {
        return c0372v.e;
    }

    public static /* synthetic */ boolean e(C0372v c0372v) {
        return c0372v.c;
    }
}
