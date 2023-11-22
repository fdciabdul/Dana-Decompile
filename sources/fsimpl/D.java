package fsimpl;

/* loaded from: classes8.dex */
/* synthetic */ class D {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f7801a;

    static {
        int[] iArr = new int[I.values().length];
        f7801a = iArr;
        try {
            iArr[I.MOTION.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f7801a[I.TOUCH.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f7801a[I.TRACKBALL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
