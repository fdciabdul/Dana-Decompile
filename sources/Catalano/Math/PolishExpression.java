package Catalano.Math;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class PolishExpression {
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static final Map<String, int[]> getAuthRequestContext;

    /* loaded from: classes6.dex */
    public enum Associativity {
        Left,
        Right
    }

    static {
        HashMap hashMap = new HashMap();
        getAuthRequestContext = hashMap;
        hashMap.put("+", new int[]{0, BuiltInFictitiousFunctionClassFactory});
        hashMap.put("-", new int[]{0, BuiltInFictitiousFunctionClassFactory});
        hashMap.put("*", new int[]{1, BuiltInFictitiousFunctionClassFactory});
        hashMap.put("/", new int[]{1, BuiltInFictitiousFunctionClassFactory});
        hashMap.put("%", new int[]{1, BuiltInFictitiousFunctionClassFactory});
        hashMap.put("mod", new int[]{1, BuiltInFictitiousFunctionClassFactory});
        hashMap.put("abs", new int[]{1, KClassImpl$Data$declaredNonStaticMembers$2});
        hashMap.put("ln", new int[]{1, KClassImpl$Data$declaredNonStaticMembers$2});
        hashMap.put("sin", new int[]{1, KClassImpl$Data$declaredNonStaticMembers$2});
        hashMap.put("cos", new int[]{1, KClassImpl$Data$declaredNonStaticMembers$2});
        hashMap.put("sum", new int[]{1, KClassImpl$Data$declaredNonStaticMembers$2});
        hashMap.put("^", new int[]{2, KClassImpl$Data$declaredNonStaticMembers$2});
        hashMap.put("pow", new int[]{2, KClassImpl$Data$declaredNonStaticMembers$2});
    }

    /* renamed from: Catalano.Math.PolishExpression$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[Associativity.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[Associativity.Left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[Associativity.Right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
