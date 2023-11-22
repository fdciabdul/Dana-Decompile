package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.multigateway.sdk.decision.condition.Condition;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: kotlin */
    private static final String f8262kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
    private static final Map<String, String> map;

    private ClassMapperLite() {
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"Boolean", "Z", "Char", "C", "Byte", DiskFormatter.B, "Short", "S", "Int", "I", "Float", LogConstants.RESULT_FALSE, "Long", "J", "Double", SummaryActivity.DAYS});
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, listOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f8262kotlin;
                sb.append(str);
                sb.append('/');
                sb.append((String) listOf.get(i));
                int i2 = i + 1;
                linkedHashMap.put(sb.toString(), listOf.get(i2));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append('/');
                sb2.append((String) listOf.get(i));
                sb2.append("Array");
                String obj = sb2.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append('[');
                sb3.append((String) listOf.get(i2));
                linkedHashMap.put(obj, sb3.toString());
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(f8262kotlin);
        sb4.append("/Unit");
        linkedHashMap.put(sb4.toString(), "V");
        m4439map$lambda0$add(linkedHashMap, "Any", "java/lang/Object");
        m4439map$lambda0$add(linkedHashMap, "Nothing", "java/lang/Void");
        m4439map$lambda0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : CollectionsKt.listOf((Object[]) new String[]{"String", "CharSequence", "Throwable", "Cloneable", Condition.VALUE_TYPE_NUMBER, "Comparable", "Enum"})) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("java/lang/");
            sb5.append(str2);
            m4439map$lambda0$add(linkedHashMap, str2, sb5.toString());
        }
        for (String str3 : CollectionsKt.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"})) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("collections/");
            sb6.append(str3);
            String obj2 = sb6.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append("java/util/");
            sb7.append(str3);
            m4439map$lambda0$add(linkedHashMap, obj2, sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append("collections/Mutable");
            sb8.append(str3);
            String obj3 = sb8.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append("java/util/");
            sb9.append(str3);
            m4439map$lambda0$add(linkedHashMap, obj3, sb9.toString());
        }
        m4439map$lambda0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        m4439map$lambda0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        m4439map$lambda0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        m4439map$lambda0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i3 = 0; i3 < 23; i3++) {
            StringBuilder sb10 = new StringBuilder();
            sb10.append("Function");
            sb10.append(i3);
            String obj4 = sb10.toString();
            StringBuilder sb11 = new StringBuilder();
            String str4 = f8262kotlin;
            sb11.append(str4);
            sb11.append("/jvm/functions/Function");
            sb11.append(i3);
            m4439map$lambda0$add(linkedHashMap, obj4, sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append("reflect/KFunction");
            sb12.append(i3);
            String obj5 = sb12.toString();
            StringBuilder sb13 = new StringBuilder();
            sb13.append(str4);
            sb13.append("/reflect/KFunction");
            m4439map$lambda0$add(linkedHashMap, obj5, sb13.toString());
        }
        for (String str5 : CollectionsKt.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"})) {
            StringBuilder sb14 = new StringBuilder();
            sb14.append(str5);
            sb14.append(".Companion");
            String obj6 = sb14.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append(f8262kotlin);
            sb15.append("/jvm/internal/");
            sb15.append(str5);
            sb15.append("CompanionObject");
            m4439map$lambda0$add(linkedHashMap, obj6, sb15.toString());
        }
        map = linkedHashMap;
    }

    /* renamed from: map$lambda-0$add */
    private static final void m4439map$lambda0$add(Map<String, String> map2, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(f8262kotlin);
        sb.append('/');
        sb.append(str);
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append('L');
        sb2.append(str2);
        sb2.append(';');
        map2.put(obj, sb2.toString());
    }

    @JvmStatic
    public static final String mapClass(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = map.get(str);
        if (str2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('L');
            sb.append(StringsKt.replace$default(str, '.', (char) Typography.dollar, false, 4, (Object) null));
            sb.append(';');
            return sb.toString();
        }
        return str2;
    }
}
