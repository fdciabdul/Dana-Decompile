package fsimpl;

/* loaded from: classes8.dex */
public class eT {

    /* renamed from: a  reason: collision with root package name */
    private static final Runtime f7961a = Runtime.getRuntime();

    public static int a(long j, long j2) {
        return (int) ((j * 100) / j2);
    }

    public static long a() {
        return f7961a.maxMemory();
    }

    public static long a(long j) {
        return j - (f7961a.totalMemory() - f7961a.freeMemory());
    }
}
