package Catalano.Imaging.Texture;

/* loaded from: classes6.dex */
public class GrayLevelDifferenceMethod {

    /* loaded from: classes6.dex */
    public enum Degree {
        Degree_0,
        Degree_45,
        Degree_90,
        Degree_135
    }

    /* renamed from: Catalano.Imaging.Texture.GrayLevelDifferenceMethod$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[Degree.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[Degree.Degree_0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[Degree.Degree_45.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                MyBillsEntityDataFactory[Degree.Degree_90.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                MyBillsEntityDataFactory[Degree.Degree_135.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
