package Catalano.Math.Functions;

/* loaded from: classes6.dex */
public final class Gabor {

    /* loaded from: classes6.dex */
    public enum Config {
        Real,
        Imaginary,
        Magnitude,
        SquaredMagnitude
    }

    private Gabor() {
    }

    /* renamed from: Catalano.Math.Functions.Gabor$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[Config.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[Config.Real.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[Config.Imaginary.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[Config.Magnitude.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getAuthRequestContext[Config.SquaredMagnitude.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
