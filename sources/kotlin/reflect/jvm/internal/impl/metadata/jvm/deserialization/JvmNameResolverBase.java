package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public class JvmNameResolverBase implements NameResolver {
    public static final Companion Companion = new Companion(null);
    private static final List<String> PREDEFINED_STRINGS;
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP;

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f8263kotlin;
    private final Set<Integer> localNameIndices;
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    private final String[] strings;

    /* loaded from: classes.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JvmNameResolverBase(String[] strArr, Set<Integer> set, List<JvmProtoBuf.StringTableTypes.Record> list) {
        Intrinsics.checkNotNullParameter(strArr, "");
        Intrinsics.checkNotNullParameter(set, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.strings = strArr;
        this.localNameIndices = set;
        this.records = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int i) {
        String str;
        JvmProtoBuf.StringTableTypes.Record record = this.records.get(i);
        if (record.hasString()) {
            str = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                List<String> list = PREDEFINED_STRINGS;
                int size = list.size();
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex < size) {
                    str = list.get(record.getPredefinedIndex());
                }
            }
            str = this.strings[i];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            Intrinsics.checkNotNullExpressionValue(substringIndexList, "");
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            Intrinsics.checkNotNullExpressionValue(num, "");
            if (num.intValue() >= 0) {
                int intValue = num.intValue();
                Intrinsics.checkNotNullExpressionValue(num2, "");
                if (intValue <= num2.intValue() && num2.intValue() <= str.length()) {
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    str = str.substring(num.intValue(), num2.intValue());
                    Intrinsics.checkNotNullExpressionValue(str, "");
                }
            }
        }
        String str2 = str;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            Intrinsics.checkNotNullExpressionValue(replaceCharList, "");
            Integer num3 = replaceCharList.get(0);
            Integer num4 = replaceCharList.get(1);
            Intrinsics.checkNotNullExpressionValue(str2, "");
            str2 = StringsKt.replace$default(str2, (char) num3.intValue(), (char) num4.intValue(), false, 4, (Object) null);
        }
        String str3 = str2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i2 == 2) {
            Intrinsics.checkNotNullExpressionValue(str3, "");
            str3 = StringsKt.replace$default(str3, (char) Typography.dollar, '.', false, 4, (Object) null);
        } else if (i2 == 3) {
            if (str3.length() >= 2) {
                Intrinsics.checkNotNullExpressionValue(str3, "");
                str3 = str3.substring(1, str3.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str3, "");
            }
            String str4 = str3;
            Intrinsics.checkNotNullExpressionValue(str4, "");
            str3 = StringsKt.replace$default(str4, (char) Typography.dollar, '.', false, 4, (Object) null);
        }
        Intrinsics.checkNotNullExpressionValue(str3, "");
        return str3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i) {
        return this.localNameIndices.contains(Integer.valueOf(i));
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        f8263kotlin = joinToString$default;
        StringBuilder sb = new StringBuilder();
        sb.append(joinToString$default);
        sb.append("/Any");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(joinToString$default);
        sb2.append("/Nothing");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(joinToString$default);
        sb3.append("/Unit");
        StringBuilder sb4 = new StringBuilder();
        sb4.append(joinToString$default);
        sb4.append("/Throwable");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(joinToString$default);
        sb5.append("/Number");
        StringBuilder sb6 = new StringBuilder();
        sb6.append(joinToString$default);
        sb6.append("/Byte");
        StringBuilder sb7 = new StringBuilder();
        sb7.append(joinToString$default);
        sb7.append("/Double");
        StringBuilder sb8 = new StringBuilder();
        sb8.append(joinToString$default);
        sb8.append("/Float");
        StringBuilder sb9 = new StringBuilder();
        sb9.append(joinToString$default);
        sb9.append("/Int");
        StringBuilder sb10 = new StringBuilder();
        sb10.append(joinToString$default);
        sb10.append("/Long");
        StringBuilder sb11 = new StringBuilder();
        sb11.append(joinToString$default);
        sb11.append("/Short");
        StringBuilder sb12 = new StringBuilder();
        sb12.append(joinToString$default);
        sb12.append("/Boolean");
        StringBuilder sb13 = new StringBuilder();
        sb13.append(joinToString$default);
        sb13.append("/Char");
        StringBuilder sb14 = new StringBuilder();
        sb14.append(joinToString$default);
        sb14.append("/CharSequence");
        StringBuilder sb15 = new StringBuilder();
        sb15.append(joinToString$default);
        sb15.append("/String");
        StringBuilder sb16 = new StringBuilder();
        sb16.append(joinToString$default);
        sb16.append("/Comparable");
        StringBuilder sb17 = new StringBuilder();
        sb17.append(joinToString$default);
        sb17.append("/Enum");
        StringBuilder sb18 = new StringBuilder();
        sb18.append(joinToString$default);
        sb18.append("/Array");
        StringBuilder sb19 = new StringBuilder();
        sb19.append(joinToString$default);
        sb19.append("/ByteArray");
        StringBuilder sb20 = new StringBuilder();
        sb20.append(joinToString$default);
        sb20.append("/DoubleArray");
        StringBuilder sb21 = new StringBuilder();
        sb21.append(joinToString$default);
        sb21.append("/FloatArray");
        StringBuilder sb22 = new StringBuilder();
        sb22.append(joinToString$default);
        sb22.append("/IntArray");
        StringBuilder sb23 = new StringBuilder();
        sb23.append(joinToString$default);
        sb23.append("/LongArray");
        StringBuilder sb24 = new StringBuilder();
        sb24.append(joinToString$default);
        sb24.append("/ShortArray");
        StringBuilder sb25 = new StringBuilder();
        sb25.append(joinToString$default);
        sb25.append("/BooleanArray");
        StringBuilder sb26 = new StringBuilder();
        sb26.append(joinToString$default);
        sb26.append("/CharArray");
        StringBuilder sb27 = new StringBuilder();
        sb27.append(joinToString$default);
        sb27.append("/Cloneable");
        StringBuilder sb28 = new StringBuilder();
        sb28.append(joinToString$default);
        sb28.append("/Annotation");
        StringBuilder sb29 = new StringBuilder();
        sb29.append(joinToString$default);
        sb29.append("/collections/Iterable");
        StringBuilder sb30 = new StringBuilder();
        sb30.append(joinToString$default);
        sb30.append("/collections/MutableIterable");
        StringBuilder sb31 = new StringBuilder();
        sb31.append(joinToString$default);
        sb31.append("/collections/Collection");
        StringBuilder sb32 = new StringBuilder();
        sb32.append(joinToString$default);
        sb32.append("/collections/MutableCollection");
        StringBuilder sb33 = new StringBuilder();
        sb33.append(joinToString$default);
        sb33.append("/collections/List");
        StringBuilder sb34 = new StringBuilder();
        sb34.append(joinToString$default);
        sb34.append("/collections/MutableList");
        StringBuilder sb35 = new StringBuilder();
        sb35.append(joinToString$default);
        sb35.append("/collections/Set");
        StringBuilder sb36 = new StringBuilder();
        sb36.append(joinToString$default);
        sb36.append("/collections/MutableSet");
        StringBuilder sb37 = new StringBuilder();
        sb37.append(joinToString$default);
        sb37.append("/collections/Map");
        StringBuilder sb38 = new StringBuilder();
        sb38.append(joinToString$default);
        sb38.append("/collections/MutableMap");
        StringBuilder sb39 = new StringBuilder();
        sb39.append(joinToString$default);
        sb39.append("/collections/Map.Entry");
        StringBuilder sb40 = new StringBuilder();
        sb40.append(joinToString$default);
        sb40.append("/collections/MutableMap.MutableEntry");
        StringBuilder sb41 = new StringBuilder();
        sb41.append(joinToString$default);
        sb41.append("/collections/Iterator");
        StringBuilder sb42 = new StringBuilder();
        sb42.append(joinToString$default);
        sb42.append("/collections/MutableIterator");
        StringBuilder sb43 = new StringBuilder();
        sb43.append(joinToString$default);
        sb43.append("/collections/ListIterator");
        StringBuilder sb44 = new StringBuilder();
        sb44.append(joinToString$default);
        sb44.append("/collections/MutableListIterator");
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{sb.toString(), sb2.toString(), sb3.toString(), sb4.toString(), sb5.toString(), sb6.toString(), sb7.toString(), sb8.toString(), sb9.toString(), sb10.toString(), sb11.toString(), sb12.toString(), sb13.toString(), sb14.toString(), sb15.toString(), sb16.toString(), sb17.toString(), sb18.toString(), sb19.toString(), sb20.toString(), sb21.toString(), sb22.toString(), sb23.toString(), sb24.toString(), sb25.toString(), sb26.toString(), sb27.toString(), sb28.toString(), sb29.toString(), sb30.toString(), sb31.toString(), sb32.toString(), sb33.toString(), sb34.toString(), sb35.toString(), sb36.toString(), sb37.toString(), sb38.toString(), sb39.toString(), sb40.toString(), sb41.toString(), sb42.toString(), sb43.toString(), sb44.toString()});
        PREDEFINED_STRINGS = listOf;
        Iterable<IndexedValue> withIndex = CollectionsKt.withIndex(listOf);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(withIndex, 10)), 16));
        for (IndexedValue indexedValue : withIndex) {
            linkedHashMap.put((String) indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
        }
        PREDEFINED_STRINGS_MAP = linkedHashMap;
    }
}
