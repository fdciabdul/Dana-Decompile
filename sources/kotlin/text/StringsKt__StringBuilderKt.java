package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u001aG\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u001d\u0010\u0007\u001a\u0019\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\t\u0010\n\u001a?\u0010\t\u001a\u00020\b2\u001d\u0010\u0007\u001a\u0019\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\t\u0010\u000b\u001a&\u0010\u000e\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0087\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a1\u0010\u000e\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u00042\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u0010\"\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u0012\u001a1\u0010\u000e\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u00042\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0010\"\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u0004H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a&\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0086\b¢\u0006\u0004\b\u0014\u0010\u000f\u001a$\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0011\u001a\u00020\u0016H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0017\u001a$\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0011\u001a\u00020\u0018H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0019\u001a$\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0011\u001a\u00020\u001aH\u0086\b¢\u0006\u0004\b\u0014\u0010\u001b\u001a&\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u001cH\u0086\b¢\u0006\u0004\b\u0014\u0010\u001d\u001a&\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004*\u00060\u0003j\u0002`\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0086\b¢\u0006\u0004\b\u0014\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"", "capacity", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "", "buildString", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/String;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "", "obj", "append", "(Ljava/lang/StringBuilder;Ljava/lang/Object;)Ljava/lang/StringBuilder;", "", "value", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "appendLine", "(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Z)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;C)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;[C)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}))
    private static final StringBuilder append(StringBuilder sb, Object obj) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(obj);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final String buildString(Function1<? super StringBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        StringBuilder sb = new StringBuilder();
        function1.invoke(sb);
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    private static final String buildString(int i, Function1<? super StringBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        StringBuilder sb = new StringBuilder(i);
        function1.invoke(sb);
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public static final StringBuilder append(StringBuilder sb, String... strArr) {
        Intrinsics.checkNotNullParameter(sb, "");
        Intrinsics.checkNotNullParameter(strArr, "");
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }

    public static final StringBuilder append(StringBuilder sb, Object... objArr) {
        Intrinsics.checkNotNullParameter(sb, "");
        Intrinsics.checkNotNullParameter(objArr, "");
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, String str) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(str);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, Object obj) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(obj);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, char[] cArr) {
        Intrinsics.checkNotNullParameter(sb, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        sb.append(cArr);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, char c) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(c);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, boolean z) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(z);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }
}
