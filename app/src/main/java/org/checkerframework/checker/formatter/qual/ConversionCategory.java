package org.checkerframework.checker.formatter.qual;

import j$.util.StringJoiner;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.checkerframework.dataflow.qual.Pure;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 org.checkerframework.checker.formatter.qual.ConversionCategory, still in use, count: 1, list:
  (r0v0 org.checkerframework.checker.formatter.qual.ConversionCategory) from 0x00c6: FILLED_NEW_ARRAY 
  (r0v0 org.checkerframework.checker.formatter.qual.ConversionCategory)
  (r5v4 org.checkerframework.checker.formatter.qual.ConversionCategory)
  (r10v6 org.checkerframework.checker.formatter.qual.ConversionCategory)
  (r11v4 org.checkerframework.checker.formatter.qual.ConversionCategory)
  (r12v5 org.checkerframework.checker.formatter.qual.ConversionCategory)
 A[WRAPPED] elemType: org.checkerframework.checker.formatter.qual.ConversionCategory
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:152)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:117)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:89)
	at java.base/java.util.ArrayList.forEach(Unknown Source)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:88)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:239)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class ConversionCategory {
    GENERAL("bBhHsS", null),
    CHAR("cC", Character.class, Byte.class, Short.class, Integer.class),
    INT("doxX", Byte.class, Short.class, Integer.class, Long.class, BigInteger.class),
    FLOAT("eEfgGaA", Float.class, Double.class, BigDecimal.class),
    TIME("tT", Long.class, Calendar.class, Date.class),
    CHAR_AND_INT(null, Byte.class, Short.class, Integer.class),
    INT_AND_TIME(null, Long.class),
    NULL(null, new Class[0]),
    UNUSED(null, null);

    private static final ConversionCategory[] conversionCategoriesForIntersect;
    private static final ConversionCategory[] conversionCategoriesForUnion;
    private static final ConversionCategory[] conversionCategoriesWithChar;
    public final String chars;
    public final Class<?>[] types;

    public static ConversionCategory valueOf(String str) {
        return (ConversionCategory) Enum.valueOf(ConversionCategory.class, str);
    }

    public static ConversionCategory[] values() {
        return (ConversionCategory[]) $VALUES.clone();
    }

    static {
        ConversionCategory conversionCategory = CHAR;
        ConversionCategory conversionCategory2 = INT;
        ConversionCategory conversionCategory3 = FLOAT;
        ConversionCategory conversionCategory4 = TIME;
        ConversionCategory conversionCategory5 = CHAR_AND_INT;
        ConversionCategory conversionCategory6 = INT_AND_TIME;
        ConversionCategory conversionCategory7 = NULL;
        conversionCategoriesWithChar = new ConversionCategory[]{r0, conversionCategory, conversionCategory2, conversionCategory3, conversionCategory4};
        conversionCategoriesForIntersect = new ConversionCategory[]{conversionCategory, conversionCategory2, conversionCategory3, conversionCategory4, conversionCategory5, conversionCategory6, conversionCategory7};
        conversionCategoriesForUnion = new ConversionCategory[]{conversionCategory7, conversionCategory5, conversionCategory6, conversionCategory, conversionCategory2, conversionCategory3, conversionCategory4};
    }

    private ConversionCategory(String str, Class... clsArr) {
        this.chars = str;
        if (clsArr == null) {
            this.types = clsArr;
            return;
        }
        ArrayList arrayList = new ArrayList(clsArr.length);
        for (Class cls : clsArr) {
            arrayList.add(cls);
            Class<? extends Object> unwrapPrimitive = unwrapPrimitive(cls);
            if (unwrapPrimitive != null) {
                arrayList.add(unwrapPrimitive);
            }
        }
        this.types = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    private static Class<? extends Object> unwrapPrimitive(Class<?> cls) {
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        return null;
    }

    public static ConversionCategory fromConversionChar(char c) {
        for (ConversionCategory conversionCategory : conversionCategoriesWithChar) {
            if (conversionCategory.chars.contains(String.valueOf(c))) {
                return conversionCategory;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bad conversion character ");
        sb.append(c);
        throw new IllegalArgumentException(sb.toString());
    }

    private static <E> Set<E> arrayToSet(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    public static boolean isSubsetOf(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        return intersect(conversionCategory, conversionCategory2) == conversionCategory;
    }

    public static ConversionCategory intersect(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        ConversionCategory conversionCategory3 = UNUSED;
        if (conversionCategory == conversionCategory3) {
            return conversionCategory2;
        }
        if (conversionCategory2 == conversionCategory3) {
            return conversionCategory;
        }
        ConversionCategory conversionCategory4 = GENERAL;
        if (conversionCategory == conversionCategory4) {
            return conversionCategory2;
        }
        if (conversionCategory2 == conversionCategory4) {
            return conversionCategory;
        }
        Set arrayToSet = arrayToSet(conversionCategory.types);
        arrayToSet.retainAll(arrayToSet(conversionCategory2.types));
        for (ConversionCategory conversionCategory5 : conversionCategoriesForIntersect) {
            if (arrayToSet(conversionCategory5.types).equals(arrayToSet)) {
                return conversionCategory5;
            }
        }
        throw new RuntimeException();
    }

    public static ConversionCategory union(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        ConversionCategory conversionCategory3 = UNUSED;
        if (conversionCategory == conversionCategory3 || conversionCategory2 == conversionCategory3 || conversionCategory == (conversionCategory3 = GENERAL) || conversionCategory2 == conversionCategory3) {
            return conversionCategory3;
        }
        ConversionCategory conversionCategory4 = CHAR_AND_INT;
        if ((conversionCategory == conversionCategory4 && conversionCategory2 == INT_AND_TIME) || (conversionCategory == INT_AND_TIME && conversionCategory2 == conversionCategory4)) {
            return INT;
        }
        Set arrayToSet = arrayToSet(conversionCategory.types);
        arrayToSet.addAll(arrayToSet(conversionCategory2.types));
        for (ConversionCategory conversionCategory5 : conversionCategoriesForUnion) {
            if (arrayToSet(conversionCategory5.types).equals(arrayToSet)) {
                return conversionCategory5;
            }
        }
        return GENERAL;
    }

    public final boolean isAssignableFrom(Class<?> cls) {
        if (this.types == null || cls == Void.TYPE) {
            return true;
        }
        for (Class<?> cls2 : this.types) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Enum
    @Pure
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append(" conversion category");
        Class<?>[] clsArr = this.types;
        if (clsArr == null || clsArr.length == 0) {
            return sb.toString();
        }
        StringJoiner stringJoiner = new StringJoiner(", ", "(one of: ", ")");
        for (Class<?> cls : this.types) {
            stringJoiner.BuiltInFictitiousFunctionClassFactory(cls.getSimpleName());
        }
        sb.append(" ");
        sb.append(stringJoiner);
        return sb.toString();
    }
}
