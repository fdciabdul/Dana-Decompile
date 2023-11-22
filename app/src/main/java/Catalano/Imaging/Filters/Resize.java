package Catalano.Imaging.Filters;

import Catalano.Imaging.IApply;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class Resize implements IApply, IApplyInPlace {

    /* loaded from: classes6.dex */
    public enum Algorithm {
        BILINEAR,
        BICUBIC,
        NEAREST_NEIGHBOR
    }

    /* renamed from: Catalano.Imaging.Filters.Resize$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[Algorithm.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[Algorithm.BILINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[Algorithm.BICUBIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[Algorithm.NEAREST_NEIGHBOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
