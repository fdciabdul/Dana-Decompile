package Catalano.Imaging.Filters;

import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class ExtractYCbCrChannel implements IApplyInPlace {

    /* loaded from: classes6.dex */
    public enum Channel {
        Y,
        Cb,
        Cr
    }

    /* renamed from: Catalano.Imaging.Filters.ExtractYCbCrChannel$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[Channel.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[Channel.Y.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[Channel.Cb.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                PlaceComponentResult[Channel.Cr.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
