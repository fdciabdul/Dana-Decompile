package kotlin.text;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a7\u0010\u0006\u001a\u00028\u0000\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u0001*\u00028\u00002\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a;\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u00012\u0006\u0010\b\u001a\u00028\u00002\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u000e\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u0001H\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a$\u0010\u000e\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\u0006\u0010\u0005\u001a\u00020\u0010H\u0086\b¢\u0006\u0004\b\u000e\u0010\u0011\u001a&\u0010\u000e\u001a\u00060\u0000j\u0002`\u0001*\u00060\u0000j\u0002`\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0086\b¢\u0006\u0004\b\u000e\u0010\u0012\u001a7\u0010\u0016\u001a\u00028\u0000\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u0001*\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017"}, d2 = {"Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "T", "", "", "value", "append", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", LottieParams.KEY_ELEMENT_ID, "Lkotlin/Function1;", "transform", "", "appendElement", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "appendLine", "(Ljava/lang/Appendable;)Ljava/lang/Appendable;", "", "(Ljava/lang/Appendable;C)Ljava/lang/Appendable;", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "", "startIndex", "endIndex", "appendRange", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__AppendableKt {
    public static final <T extends Appendable> T appendRange(T t, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(t, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        T t2 = (T) t.append(charSequence, i, i2);
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
    }

    public static final <T extends Appendable> T append(T t, CharSequence... charSequenceArr) {
        Intrinsics.checkNotNullParameter(t, "");
        Intrinsics.checkNotNullParameter(charSequenceArr, "");
        for (CharSequence charSequence : charSequenceArr) {
            t.append(charSequence);
        }
        return t;
    }

    private static final Appendable appendLine(Appendable appendable) {
        Intrinsics.checkNotNullParameter(appendable, "");
        Appendable append = appendable.append('\n');
        Intrinsics.checkNotNullExpressionValue(append, "");
        return append;
    }

    private static final Appendable appendLine(Appendable appendable, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(appendable, "");
        Appendable append = appendable.append(charSequence);
        Intrinsics.checkNotNullExpressionValue(append, "");
        Appendable append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "");
        return append2;
    }

    private static final Appendable appendLine(Appendable appendable, char c) {
        Intrinsics.checkNotNullParameter(appendable, "");
        Appendable append = appendable.append(c);
        Intrinsics.checkNotNullExpressionValue(append, "");
        Appendable append2 = append.append('\n');
        Intrinsics.checkNotNullExpressionValue(append2, "");
        return append2;
    }

    public static final <T> void appendElement(Appendable appendable, T t, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(appendable, "");
        if (function1 != null) {
            appendable.append(function1.invoke(t));
            return;
        }
        if (t == null ? true : t instanceof CharSequence) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
