package Catalano.Imaging.Filters;

import Catalano.Imaging.IExtract;

/* loaded from: classes6.dex */
public class ExtractNormalizedRGBChannel implements IExtract {

    /* loaded from: classes6.dex */
    public enum Channel {
        R,
        G,
        B
    }

    /* renamed from: Catalano.Imaging.Filters.ExtractNormalizedRGBChannel$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[Channel.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[Channel.R.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[Channel.G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[Channel.B.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
