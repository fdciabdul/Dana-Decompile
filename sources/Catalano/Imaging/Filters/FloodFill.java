package Catalano.Imaging.Filters;

import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class FloodFill implements IApplyInPlace {

    /* loaded from: classes6.dex */
    public enum Algorithm {
        FourWay,
        EightWay
    }

    /* renamed from: Catalano.Imaging.Filters.FloodFill$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[Algorithm.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[Algorithm.FourWay.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Algorithm.EightWay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
