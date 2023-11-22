package Catalano.Imaging.Filters.Artistic;

import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class SpecularBloom implements IApplyInPlace {
    private AdaptiveThreshold MyBillsEntityDataFactory = AdaptiveThreshold.Rosin;
    private int PlaceComponentResult = 180;
    private int KClassImpl$Data$declaredNonStaticMembers$2 = 20;
    private boolean getAuthRequestContext = true;

    /* loaded from: classes6.dex */
    public enum AdaptiveThreshold {
        Otsu,
        Rosin,
        Sis
    }

    /* renamed from: Catalano.Imaging.Filters.Artistic.SpecularBloom$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[AdaptiveThreshold.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[AdaptiveThreshold.Otsu.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[AdaptiveThreshold.Rosin.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[AdaptiveThreshold.Sis.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
