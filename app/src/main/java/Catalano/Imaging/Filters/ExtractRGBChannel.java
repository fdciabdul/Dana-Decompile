package Catalano.Imaging.Filters;

import Catalano.Imaging.IExtract;

/* loaded from: classes6.dex */
public class ExtractRGBChannel implements IExtract {

    /* loaded from: classes6.dex */
    public enum Channel {
        R,
        G,
        B
    }

    /* renamed from: Catalano.Imaging.Filters.ExtractRGBChannel$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[Channel.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[Channel.R.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Channel.G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Channel.B.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
