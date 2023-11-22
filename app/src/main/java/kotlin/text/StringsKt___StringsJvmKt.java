package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\t\u001a\u00020\u0007*\u00020\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"", "", "index", "", "elementAt", "(Ljava/lang/CharSequence;I)C", "Lkotlin/Function1;", "Ljava/math/BigDecimal;", "selector", "sumOfBigDecimal", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "Ljava/util/SortedSet;", "toSortedSet", "(Ljava/lang/CharSequence;)Ljava/util/SortedSet;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt___StringsJvmKt extends StringsKt__StringsKt {
    private static final char elementAt(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return charSequence.charAt(i);
    }

    public static final SortedSet<Character> toSortedSet(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return (SortedSet) StringsKt.toCollection(charSequence, new TreeSet());
    }

    private static final BigDecimal sumOfBigDecimal(CharSequence charSequence, Function1<? super Character, ? extends BigDecimal> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        for (int i = 0; i < charSequence.length(); i++) {
            valueOf = valueOf.add(function1.invoke(Character.valueOf(charSequence.charAt(i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(CharSequence charSequence, Function1<? super Character, ? extends BigInteger> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        for (int i = 0; i < charSequence.length(); i++) {
            valueOf = valueOf.add(function1.invoke(Character.valueOf(charSequence.charAt(i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
        }
        return valueOf;
    }
}
