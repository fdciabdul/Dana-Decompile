package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents INSTANCE = new SignatureBuildingComponents();

    private SignatureBuildingComponents() {
    }

    public final String javaLang(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        StringBuilder sb = new StringBuilder();
        sb.append("java/lang/");
        sb.append(str);
        return sb.toString();
    }

    public final String javaUtil(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        StringBuilder sb = new StringBuilder();
        sb.append("java/util/");
        sb.append(str);
        return sb.toString();
    }

    public final String javaFunction(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        StringBuilder sb = new StringBuilder();
        sb.append("java/util/function/");
        sb.append(str);
        return sb.toString();
    }

    public final Set<String> inJavaLang(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(strArr, "");
        return inClass(javaLang(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final Set<String> inJavaUtil(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(strArr, "");
        return inClass(javaUtil(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final Set<String> inClass(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(strArr, "");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('.');
            sb.append(str2);
            linkedHashSet.add(sb.toString());
        }
        return linkedHashSet;
    }

    public final String signature(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('.');
        sb.append(str2);
        return sb.toString();
    }

    public final String jvmDescriptor(String str, List<String> list, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str2, "");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('(');
        sb.append(CollectionsKt.joinToString$default(list, "", null, null, 0, null, new Function1<String, CharSequence>() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents$jvmDescriptor$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String str3) {
                String escapeClassName;
                Intrinsics.checkNotNullParameter(str3, "");
                escapeClassName = SignatureBuildingComponents.INSTANCE.escapeClassName(str3);
                return escapeClassName;
            }
        }, 30, null));
        sb.append(')');
        sb.append(escapeClassName(str2));
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String escapeClassName(String str) {
        if (str.length() > 1) {
            StringBuilder sb = new StringBuilder();
            sb.append('L');
            sb.append(str);
            sb.append(';');
            return sb.toString();
        }
        return str;
    }

    public final String[] constructors(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("<init>(");
            sb.append(str);
            sb.append(")V");
            arrayList.add(sb.toString());
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array);
        return (String[]) array;
    }
}
