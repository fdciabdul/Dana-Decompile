package Catalano.Imaging.Filters;

import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class ReplaceRGBChannel implements IApplyInPlace {

    /* loaded from: classes6.dex */
    public enum RGB {
        R,
        G,
        B
    }

    /* renamed from: Catalano.Imaging.Filters.ReplaceRGBChannel$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[RGB.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[RGB.R.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[RGB.G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[RGB.B.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
