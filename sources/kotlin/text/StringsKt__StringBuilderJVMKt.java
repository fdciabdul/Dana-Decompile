package kotlin.text;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\u001a&\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a$\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0007\u001a$\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\u0004\u0010\t\u001a$\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\nH\u0086\b¢\u0006\u0004\b\u0004\u0010\u000b\u001a$\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\fH\u0086\b¢\u0006\u0004\b\u0004\u0010\r\u001a$\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\u0004\u0010\u000f\u001a$\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0010H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0011\u001a,\u0010\u0004\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u000e\u0010\u0003\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0012\u001a4\u0010\u0016\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0086\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a4\u0010\u0016\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0086\b¢\u0006\u0004\b\u0016\u0010\u0019\u001a\u001b\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b*\u00060\u001aj\u0002`\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a$\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b*\u00060\u001aj\u0002`\u001b2\u0006\u0010\u0003\u001a\u00020\u001eH\u0087\b¢\u0006\u0004\b\u001c\u0010\u001f\u001a&\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b*\u00060\u001aj\u0002`\u001b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0018H\u0087\b¢\u0006\u0004\b\u001c\u0010 \u001a\u001b\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0007¢\u0006\u0004\b\u001c\u0010!\u001a&\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0087\b¢\u0006\u0004\b\u001c\u0010\u0005\u001a&\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\"H\u0087\b¢\u0006\u0004\b\u001c\u0010#\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020$H\u0087\b¢\u0006\u0004\b\u001c\u0010%\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u001c\u0010\u0007\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u001eH\u0087\b¢\u0006\u0004\b\u001c\u0010&\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b\u001c\u0010'\u001a&\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0018H\u0087\b¢\u0006\u0004\b\u001c\u0010(\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\bH\u0087\b¢\u0006\u0004\b\u001c\u0010\t\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\nH\u0087\b¢\u0006\u0004\b\u001c\u0010\u000b\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u001c\u0010\r\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\u001c\u0010\u000f\u001a$\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0003\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b\u001c\u0010\u0011\u001a&\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010)H\u0087\b¢\u0006\u0004\b\u001c\u0010*\u001a,\u0010\u001c\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u000e\u0010\u0003\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\u0087\b¢\u0006\u0004\b\u001c\u0010\u0012\u001a\u0019\u0010+\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b+\u0010!\u001a$\u0010-\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010,\u001a\u00020\fH\u0086\b¢\u0006\u0004\b-\u0010\r\u001a,\u0010.\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0086\b¢\u0006\u0004\b.\u0010/\u001a<\u00100\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0086\b¢\u0006\u0004\b0\u00101\u001a<\u00100\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0086\b¢\u0006\u0004\b0\u00102\u001a(\u00104\u001a\u000203*\u00060\u0000j\u0002`\u00012\u0006\u0010,\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u001eH\u0086\n¢\u0006\u0004\b4\u00105\u001a4\u00106\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020)H\u0086\b¢\u0006\u0004\b6\u00107\u001a>\u0010:\u001a\u000203*\u00060\u0000j\u0002`\u00012\u0006\u00108\u001a\u00020\u00132\b\b\u0002\u00109\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0086\b¢\u0006\u0004\b:\u0010;"}, d2 = {"Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Ljava/lang/StringBuffer;", "value", "appendLine", "(Ljava/lang/StringBuilder;Ljava/lang/StringBuffer;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;B)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;D)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;F)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;I)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;J)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;S)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;", "", "startIndex", "endIndex", "appendRange", "(Ljava/lang/StringBuilder;[CII)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "appendln", "(Ljava/lang/Appendable;)Ljava/lang/Appendable;", "", "(Ljava/lang/Appendable;C)Ljava/lang/Appendable;", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Ljava/lang/Object;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Z)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;C)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[C)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "clear", "index", "deleteAt", "deleteRange", "(Ljava/lang/StringBuilder;II)Ljava/lang/StringBuilder;", "insertRange", "(Ljava/lang/StringBuilder;I[CII)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;ILjava/lang/CharSequence;II)Ljava/lang/StringBuilder;", "", "set", "(Ljava/lang/StringBuilder;IC)V", "setRange", "(Ljava/lang/StringBuilder;IILjava/lang/String;)Ljava/lang/StringBuilder;", FirebaseAnalytics.Param.DESTINATION, "destinationOffset", "toCharArray", "(Ljava/lang/StringBuilder;[CIII)V"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    public static final StringBuilder clear(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.setLength(0);
        return sb;
    }

    private static final void set(StringBuilder sb, int i, char c) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.setCharAt(i, c);
    }

    private static final StringBuilder setRange(StringBuilder sb, int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(sb, "");
        Intrinsics.checkNotNullParameter(str, "");
        StringBuilder replace = sb.replace(i, i2, str);
        Intrinsics.checkNotNullExpressionValue(replace, "");
        return replace;
    }

    private static final StringBuilder deleteAt(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, "");
        StringBuilder deleteCharAt = sb.deleteCharAt(i);
        Intrinsics.checkNotNullExpressionValue(deleteCharAt, "");
        return deleteCharAt;
    }

    private static final StringBuilder deleteRange(StringBuilder sb, int i, int i2) {
        Intrinsics.checkNotNullParameter(sb, "");
        StringBuilder delete = sb.delete(i, i2);
        Intrinsics.checkNotNullExpressionValue(delete, "");
        return delete;
    }

    static /* synthetic */ void toCharArray$default(StringBuilder sb, char[] cArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sb.length();
        }
        Intrinsics.checkNotNullParameter(sb, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        sb.getChars(i2, i3, cArr, i);
    }

    private static final void toCharArray(StringBuilder sb, char[] cArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sb, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        sb.getChars(i2, i3, cArr, i);
    }

    private static final StringBuilder appendRange(StringBuilder sb, char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(sb, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        sb.append(cArr, i, i2 - i);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder appendRange(StringBuilder sb, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(sb, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        sb.append(charSequence, i, i2);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder insertRange(StringBuilder sb, int i, char[] cArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sb, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        StringBuilder insert = sb.insert(i, cArr, i2, i3 - i2);
        Intrinsics.checkNotNullExpressionValue(insert, "");
        return insert;
    }

    private static final StringBuilder insertRange(StringBuilder sb, int i, CharSequence charSequence, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sb, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        StringBuilder insert = sb.insert(i, charSequence, i2, i3);
        Intrinsics.checkNotNullExpressionValue(insert, "");
        return insert;
    }

    private static final StringBuilder appendLine(StringBuilder sb, StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(stringBuffer);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append((CharSequence) sb2);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(i);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, short s) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append((int) s);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, byte b) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append((int) b);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, long j) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(j);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, float f) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(f);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    private static final StringBuilder appendLine(StringBuilder sb, double d) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(d);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        sb.append('\n');
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final Appendable appendln(Appendable appendable) {
        Intrinsics.checkNotNullParameter(appendable, "");
        Appendable append = appendable.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(append, "");
        return append;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final Appendable appendln(Appendable appendable, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(appendable, "");
        Appendable append = appendable.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(append, "");
        return StringsKt.appendln(append);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final Appendable appendln(Appendable appendable, char c) {
        Intrinsics.checkNotNullParameter(appendable, "");
        Appendable append = appendable.append(c);
        Intrinsics.checkNotNullExpressionValue(append, "");
        return StringsKt.appendln(append);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final StringBuilder appendln(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return sb;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder sb, StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(stringBuffer);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return StringsKt.appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder sb, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return StringsKt.appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder sb, String str) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(str);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return StringsKt.appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder sb, Object obj) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(obj);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return StringsKt.appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder sb, StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append((CharSequence) sb2);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return StringsKt.appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder sb, char[] cArr) {
        Intrinsics.checkNotNullParameter(sb, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        sb.append(cArr);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return StringsKt.appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder sb, char c) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(c);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return StringsKt.appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder sb, boolean z) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(z);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return StringsKt.appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder sb, int i) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(i);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return StringsKt.appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder sb, short s) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append((int) s);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return StringsKt.appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder sb, byte b) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append((int) b);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return StringsKt.appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder sb, long j) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(j);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return StringsKt.appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder sb, float f) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(f);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return StringsKt.appendln(sb);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder sb, double d) {
        Intrinsics.checkNotNullParameter(sb, "");
        sb.append(d);
        Intrinsics.checkNotNullExpressionValue(sb, "");
        return StringsKt.appendln(sb);
    }
}
