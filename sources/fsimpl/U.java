package fsimpl;

/* loaded from: classes4.dex */
public abstract class U {
    public static U a(bG bGVar) {
        V v = null;
        return bGVar.J() ? new W() : new X();
    }

    public static Y b(C0370t c0370t) {
        return c0370t.a() ? Y.Masked : c0370t.b() ? Y.Unmasked : Y.Unknown;
    }

    public abstract void a(Object obj, C0248az c0248az, Y y, C0304da c0304da);

    abstract void a(Object obj, C0248az c0248az, Y y, Object obj2);

    public abstract void a(Object obj, C0248az c0248az, Y y, String str);

    public abstract void a(Object obj, C0248az c0248az, C0370t c0370t, C0304da c0304da);

    public abstract void a(Object obj, C0248az c0248az, C0370t c0370t, Object obj2);

    public abstract void a(Object obj, C0248az c0248az, C0370t c0370t, String str);
}
