package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u00012\u0010\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a?\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00012\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\u0010\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a-\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00010\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a=\u0010\u0018\u001a\u00028\u0001\"\u0010\b\u0000\u0010\u0014*\u0006\u0012\u0002\b\u00030\u0001*\u00028\u0001\"\u0004\b\u0001\u0010\u0015*\u00028\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a6\u0010\u001a\u001a\u00020\u0003*\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\u0086\b\u0082\u0002\u0019\n\u0017\b\u0000\u0012\r\u0010ÿÿÿÿÿÿÿÿÿ\u0001\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aI\u0010\u001d\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00110\u001c\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0015*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001c0\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"T", "", "other", "", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "result", "", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "", "flatten", "([[Ljava/lang/Object;)Ljava/util/List;", "C", "R", "Lkotlin/Function0;", "defaultValue", "ifEmpty", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "Lkotlin/Pair;", "unzip", "([Lkotlin/Pair;)Lkotlin/Pair;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes.dex */
public class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    public static final <T> List<T> flatten(T[][] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "");
        T[][] tArr2 = tArr;
        int i = 0;
        for (T[] tArr3 : tArr2) {
            i += tArr3.length;
        }
        ArrayList arrayList = new ArrayList(i);
        int length = tArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            CollectionsKt.addAll(arrayList, tArr[i2]);
        }
        return arrayList;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Pair<? extends T, ? extends R>[] pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "");
        ArrayList arrayList = new ArrayList(pairArr.length);
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        for (Pair<? extends T, ? extends R> pair : pairArr) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return TuplesKt.to(arrayList, arrayList2);
    }

    private static final boolean isNullOrEmpty(Object[] objArr) {
        if (objArr != null) {
            return objArr.length == 0;
        }
        return true;
    }

    private static final Object ifEmpty(Object[] objArr, Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        return objArr.length == 0 ? function0.invoke() : objArr;
    }

    public static final <T> boolean contentDeepEquals(T[] tArr, T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == null || tArr2 == null || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            T t = tArr[i];
            T t2 = tArr2[i];
            if (t != t2) {
                if (t != null && t2 != null) {
                    if ((t instanceof Object[]) && (t2 instanceof Object[])) {
                        if (!ArraysKt.contentDeepEquals((Object[]) t, (Object[]) t2)) {
                            return false;
                        }
                    } else if ((t instanceof byte[]) && (t2 instanceof byte[])) {
                        if (!Arrays.equals((byte[]) t, (byte[]) t2)) {
                            return false;
                        }
                    } else if ((t instanceof short[]) && (t2 instanceof short[])) {
                        if (!Arrays.equals((short[]) t, (short[]) t2)) {
                            return false;
                        }
                    } else if ((t instanceof int[]) && (t2 instanceof int[])) {
                        if (!Arrays.equals((int[]) t, (int[]) t2)) {
                            return false;
                        }
                    } else if ((t instanceof long[]) && (t2 instanceof long[])) {
                        if (!Arrays.equals((long[]) t, (long[]) t2)) {
                            return false;
                        }
                    } else if ((t instanceof float[]) && (t2 instanceof float[])) {
                        if (!Arrays.equals((float[]) t, (float[]) t2)) {
                            return false;
                        }
                    } else if ((t instanceof double[]) && (t2 instanceof double[])) {
                        if (!Arrays.equals((double[]) t, (double[]) t2)) {
                            return false;
                        }
                    } else if ((t instanceof char[]) && (t2 instanceof char[])) {
                        if (!Arrays.equals((char[]) t, (char[]) t2)) {
                            return false;
                        }
                    } else if ((t instanceof boolean[]) && (t2 instanceof boolean[])) {
                        if (!Arrays.equals((boolean[]) t, (boolean[]) t2)) {
                            return false;
                        }
                    } else if ((t instanceof UByteArray) && (t2 instanceof UByteArray)) {
                        if (!UArraysKt.m3721contentEqualskV0jMPg(((UByteArray) t).getStorage(), ((UByteArray) t2).getStorage())) {
                            return false;
                        }
                    } else if ((t instanceof UShortArray) && (t2 instanceof UShortArray)) {
                        if (!UArraysKt.m3718contentEqualsFGO6Aew(((UShortArray) t).getStorage(), ((UShortArray) t2).getStorage())) {
                            return false;
                        }
                    } else if ((t instanceof UIntArray) && (t2 instanceof UIntArray)) {
                        if (!UArraysKt.m3719contentEqualsKJPZfPQ(((UIntArray) t).getStorage(), ((UIntArray) t2).getStorage())) {
                            return false;
                        }
                    } else if ((t instanceof ULongArray) && (t2 instanceof ULongArray)) {
                        if (!UArraysKt.m3723contentEqualslec5QzE(((ULongArray) t).getStorage(), ((ULongArray) t2).getStorage())) {
                            return false;
                        }
                    } else if (!Intrinsics.areEqual(t, t2)) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static final <T> String contentDeepToString(T[] tArr) {
        if (tArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder((RangesKt.coerceAtMost(tArr.length, 429496729) * 5) + 2);
        contentDeepToStringInternal$ArraysKt__ArraysKt(tArr, sb, new ArrayList());
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] tArr, StringBuilder sb, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            T t = tArr[i];
            if (t == null) {
                sb.append("null");
            } else if (t instanceof Object[]) {
                contentDeepToStringInternal$ArraysKt__ArraysKt((Object[]) t, sb, list);
            } else if (t instanceof byte[]) {
                String arrays = Arrays.toString((byte[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays, "");
                sb.append(arrays);
            } else if (t instanceof short[]) {
                String arrays2 = Arrays.toString((short[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays2, "");
                sb.append(arrays2);
            } else if (t instanceof int[]) {
                String arrays3 = Arrays.toString((int[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays3, "");
                sb.append(arrays3);
            } else if (t instanceof long[]) {
                String arrays4 = Arrays.toString((long[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays4, "");
                sb.append(arrays4);
            } else if (t instanceof float[]) {
                String arrays5 = Arrays.toString((float[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays5, "");
                sb.append(arrays5);
            } else if (t instanceof double[]) {
                String arrays6 = Arrays.toString((double[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays6, "");
                sb.append(arrays6);
            } else if (t instanceof char[]) {
                String arrays7 = Arrays.toString((char[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays7, "");
                sb.append(arrays7);
            } else if (t instanceof boolean[]) {
                String arrays8 = Arrays.toString((boolean[]) t);
                Intrinsics.checkNotNullExpressionValue(arrays8, "");
                sb.append(arrays8);
            } else if (t instanceof UByteArray) {
                UByteArray uByteArray = (UByteArray) t;
                sb.append(UArraysKt.m3735contentToString2csIQuQ(uByteArray != null ? uByteArray.getStorage() : null));
            } else if (t instanceof UShortArray) {
                UShortArray uShortArray = (UShortArray) t;
                sb.append(UArraysKt.m3739contentToStringd6D3K8(uShortArray != null ? uShortArray.getStorage() : null));
            } else if (t instanceof UIntArray) {
                UIntArray uIntArray = (UIntArray) t;
                sb.append(UArraysKt.m3738contentToStringXUkPCBk(uIntArray != null ? uIntArray.getStorage() : null));
            } else if (t instanceof ULongArray) {
                ULongArray uLongArray = (ULongArray) t;
                sb.append(UArraysKt.m3741contentToStringuLth9ew(uLongArray != null ? uLongArray.getStorage() : null));
            } else {
                sb.append(t.toString());
            }
        }
        sb.append(']');
        list.remove(CollectionsKt.getLastIndex(list));
    }
}
