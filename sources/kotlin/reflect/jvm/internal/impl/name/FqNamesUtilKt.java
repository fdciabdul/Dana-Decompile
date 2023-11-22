package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public final class FqNamesUtilKt {

    /* loaded from: classes.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.BEGINNING.ordinal()] = 1;
            iArr[State.AFTER_DOT.ordinal()] = 2;
            iArr[State.MIDDLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isSubpackageOf(FqName fqName, FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName, "");
        Intrinsics.checkNotNullParameter(fqName2, "");
        if (Intrinsics.areEqual(fqName, fqName2) || fqName2.isRoot()) {
            return true;
        }
        String asString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "");
        String asString2 = fqName2.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "");
        return isSubpackageOf(asString, asString2);
    }

    public static final boolean isChildOf(FqName fqName, FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName, "");
        Intrinsics.checkNotNullParameter(fqName2, "");
        return Intrinsics.areEqual(parentOrNull(fqName), fqName2);
    }

    private static final boolean isSubpackageOf(String str, String str2) {
        return StringsKt.startsWith$default(str, str2, false, 2, (Object) null) && str.charAt(str2.length()) == '.';
    }

    public static final FqName tail(FqName fqName, FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName, "");
        Intrinsics.checkNotNullParameter(fqName2, "");
        if (!isSubpackageOf(fqName, fqName2) || fqName2.isRoot()) {
            return fqName;
        }
        if (Intrinsics.areEqual(fqName, fqName2)) {
            FqName fqName3 = FqName.ROOT;
            Intrinsics.checkNotNullExpressionValue(fqName3, "");
            return fqName3;
        }
        String asString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "");
        String substring = asString.substring(fqName2.asString().length() + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        return new FqName(substring);
    }

    public static final FqName parentOrNull(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "");
        if (fqName.isRoot()) {
            return null;
        }
        return fqName.parent();
    }

    public static final boolean isValidJavaFqName(String str) {
        if (str == null) {
            return false;
        }
        State state = State.BEGINNING;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
                state = State.MIDDLE;
            } else if (i2 != 3) {
                continue;
            } else if (charAt == '.') {
                state = State.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(charAt)) {
                return false;
            }
        }
        return state != State.AFTER_DOT;
    }

    public static final <V> V findValueForMostSpecificFqname(FqName fqName, Map<FqName, ? extends V> map) {
        Object next;
        Intrinsics.checkNotNullParameter(fqName, "");
        Intrinsics.checkNotNullParameter(map, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<FqName, ? extends V>> it = map.entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<FqName, ? extends V> next2 = it.next();
            FqName key = next2.getKey();
            if (!Intrinsics.areEqual(fqName, key) && !isChildOf(fqName, key)) {
                z = false;
            }
            if (z) {
                linkedHashMap.put(next2.getKey(), next2.getValue());
            }
        }
        if ((!linkedHashMap.isEmpty()) == false) {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return null;
        }
        Iterator it2 = linkedHashMap.entrySet().iterator();
        if (it2.hasNext()) {
            next = it2.next();
            if (it2.hasNext()) {
                int length = tail((FqName) ((Map.Entry) next).getKey(), fqName).asString().length();
                do {
                    Object next3 = it2.next();
                    int length2 = tail((FqName) ((Map.Entry) next3).getKey(), fqName).asString().length();
                    if (length > length2) {
                        next = next3;
                        length = length2;
                    }
                } while (it2.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (V) entry.getValue();
        }
        return null;
    }
}
