package Catalano.Imaging.Filters.Artistic;

import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class Blend implements IApplyInPlace {

    /* loaded from: classes6.dex */
    public enum Algorithm {
        Lighten,
        Darken,
        Multiply,
        Average,
        Add,
        Subtract,
        Difference,
        Negation,
        Screen,
        Exclusion,
        Overlay,
        SoftLight,
        HardLight,
        ColorDodge,
        ColorBurn,
        LinearLight,
        VividLight,
        PinLight,
        Reflect,
        Phoenix
    }

    /* renamed from: Catalano.Imaging.Filters.Artistic.Blend$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[Algorithm.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[Algorithm.Lighten.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[Algorithm.Darken.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[Algorithm.Multiply.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getAuthRequestContext[Algorithm.Average.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                getAuthRequestContext[Algorithm.Add.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                getAuthRequestContext[Algorithm.Subtract.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                getAuthRequestContext[Algorithm.Difference.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                getAuthRequestContext[Algorithm.Negation.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                getAuthRequestContext[Algorithm.Screen.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                getAuthRequestContext[Algorithm.Exclusion.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                getAuthRequestContext[Algorithm.Overlay.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                getAuthRequestContext[Algorithm.SoftLight.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                getAuthRequestContext[Algorithm.HardLight.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                getAuthRequestContext[Algorithm.ColorDodge.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                getAuthRequestContext[Algorithm.ColorBurn.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                getAuthRequestContext[Algorithm.LinearLight.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                getAuthRequestContext[Algorithm.VividLight.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                getAuthRequestContext[Algorithm.PinLight.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                getAuthRequestContext[Algorithm.Reflect.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                getAuthRequestContext[Algorithm.Phoenix.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }
}
