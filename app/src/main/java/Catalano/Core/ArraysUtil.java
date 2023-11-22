package Catalano.Core;

import java.util.Comparator;

/* loaded from: classes6.dex */
public class ArraysUtil {
    private ArraysUtil() {
    }

    /* renamed from: Catalano.Core.ArraysUtil$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Comparator<Integer> {
        final /* synthetic */ double[] KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ boolean getAuthRequestContext;

        @Override // java.util.Comparator
        public /* synthetic */ int compare(Integer num, Integer num2) {
            return (this.getAuthRequestContext ? 1 : -1) * Double.compare(this.KClassImpl$Data$declaredNonStaticMembers$2[num.intValue()], this.KClassImpl$Data$declaredNonStaticMembers$2[num2.intValue()]);
        }
    }

    /* renamed from: Catalano.Core.ArraysUtil$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 implements Comparator<Integer> {
        final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ int[] PlaceComponentResult;

        @Override // java.util.Comparator
        public /* synthetic */ int compare(Integer num, Integer num2) {
            return (this.BuiltInFictitiousFunctionClassFactory ? 1 : -1) * Integer.compare(this.PlaceComponentResult[num.intValue()], this.PlaceComponentResult[num2.intValue()]);
        }
    }

    /* renamed from: Catalano.Core.ArraysUtil$3  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass3 implements Comparator<Integer> {
        final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ float[] KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // java.util.Comparator
        public /* synthetic */ int compare(Integer num, Integer num2) {
            return (this.BuiltInFictitiousFunctionClassFactory ? 1 : -1) * Float.compare(this.KClassImpl$Data$declaredNonStaticMembers$2[num.intValue()], this.KClassImpl$Data$declaredNonStaticMembers$2[num2.intValue()]);
        }
    }

    public static float[] PlaceComponentResult(double[] dArr) {
        float[] fArr = new float[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            fArr[i] = (float) dArr[i];
        }
        return fArr;
    }
}
