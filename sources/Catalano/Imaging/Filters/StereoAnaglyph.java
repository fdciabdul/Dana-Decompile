package Catalano.Imaging.Filters;

import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class StereoAnaglyph implements IApplyInPlace {

    /* loaded from: classes6.dex */
    public enum Algorithm {
        TrueAnaglyph,
        GrayAnaglyph,
        ColorAnaglyph,
        HalfColorAnaglyph,
        OptimizedAnaglyph
    }

    /* renamed from: Catalano.Imaging.Filters.StereoAnaglyph$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[Algorithm.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[Algorithm.TrueAnaglyph.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[Algorithm.GrayAnaglyph.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[Algorithm.ColorAnaglyph.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                getAuthRequestContext[Algorithm.HalfColorAnaglyph.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                getAuthRequestContext[Algorithm.OptimizedAnaglyph.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
