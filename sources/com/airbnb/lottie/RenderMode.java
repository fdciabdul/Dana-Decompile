package com.airbnb.lottie;

/* loaded from: classes3.dex */
public enum RenderMode {
    AUTOMATIC,
    HARDWARE,
    SOFTWARE;

    /* renamed from: com.airbnb.lottie.RenderMode$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[RenderMode.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public final boolean useSoftwareRendering(int i, boolean z, int i2) {
        int i3 = AnonymousClass1.getAuthRequestContext[ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return (z && i < 28) || i2 > 4 || i <= 25;
            }
            return true;
        }
        return false;
    }
}
