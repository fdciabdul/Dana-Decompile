package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0014\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0006\u0010\u0002\u001a\u001c\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001c\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\b\u0010\u0005\u001a\u001c\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\t\u0010\u0005\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\n\u0010\u0005\u001a\u0014\u0010\f\u001a\u00020\u0000*\u00020\u000bH\u0086\b¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\f\u0010\u0010\u001a\u0014\u0010\f\u001a\u00020\u0000*\u00020\u0011H\u0086\b¢\u0006\u0004\b\f\u0010\u0012\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\f\u0010\u0013\u001a\u0014\u0010\f\u001a\u00020\u0000*\u00020\u0014H\u0086\b¢\u0006\u0004\b\f\u0010\u0015\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\f\u0010\u0016\u001a\u0014\u0010\f\u001a\u00020\u0000*\u00020\u0017H\u0086\b¢\u0006\u0004\b\f\u0010\u0018\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\f\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u0000*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u001a\u0010\u0002"}, d2 = {"Ljava/math/BigDecimal;", "dec", "(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;", "other", "div", "(Ljava/math/BigDecimal;Ljava/math/BigDecimal;)Ljava/math/BigDecimal;", "inc", "minus", "plus", "rem", "times", "", "toBigDecimal", "(D)Ljava/math/BigDecimal;", "Ljava/math/MathContext;", "mathContext", "(DLjava/math/MathContext;)Ljava/math/BigDecimal;", "", "(F)Ljava/math/BigDecimal;", "(FLjava/math/MathContext;)Ljava/math/BigDecimal;", "", "(I)Ljava/math/BigDecimal;", "(ILjava/math/MathContext;)Ljava/math/BigDecimal;", "", "(J)Ljava/math/BigDecimal;", "(JLjava/math/MathContext;)Ljava/math/BigDecimal;", "unaryMinus"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/NumbersKt")
/* loaded from: classes9.dex */
class NumbersKt__BigDecimalsKt {
    private static final BigDecimal plus(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "");
        Intrinsics.checkNotNullParameter(bigDecimal2, "");
        BigDecimal add = bigDecimal.add(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(add, "");
        return add;
    }

    private static final BigDecimal minus(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "");
        Intrinsics.checkNotNullParameter(bigDecimal2, "");
        BigDecimal subtract = bigDecimal.subtract(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(subtract, "");
        return subtract;
    }

    private static final BigDecimal times(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "");
        Intrinsics.checkNotNullParameter(bigDecimal2, "");
        BigDecimal multiply = bigDecimal.multiply(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(multiply, "");
        return multiply;
    }

    private static final BigDecimal div(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "");
        Intrinsics.checkNotNullParameter(bigDecimal2, "");
        BigDecimal divide = bigDecimal.divide(bigDecimal2, RoundingMode.HALF_EVEN);
        Intrinsics.checkNotNullExpressionValue(divide, "");
        return divide;
    }

    private static final BigDecimal rem(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.checkNotNullParameter(bigDecimal, "");
        Intrinsics.checkNotNullParameter(bigDecimal2, "");
        BigDecimal remainder = bigDecimal.remainder(bigDecimal2);
        Intrinsics.checkNotNullExpressionValue(remainder, "");
        return remainder;
    }

    private static final BigDecimal unaryMinus(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "");
        BigDecimal negate = bigDecimal.negate();
        Intrinsics.checkNotNullExpressionValue(negate, "");
        return negate;
    }

    private static final BigDecimal inc(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "");
        BigDecimal add = bigDecimal.add(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(add, "");
        return add;
    }

    private static final BigDecimal dec(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "");
        BigDecimal subtract = bigDecimal.subtract(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(subtract, "");
        return subtract;
    }

    private static final BigDecimal toBigDecimal(int i) {
        BigDecimal valueOf = BigDecimal.valueOf(i);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        return valueOf;
    }

    private static final BigDecimal toBigDecimal(int i, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "");
        return new BigDecimal(i, mathContext);
    }

    private static final BigDecimal toBigDecimal(long j) {
        BigDecimal valueOf = BigDecimal.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        return valueOf;
    }

    private static final BigDecimal toBigDecimal(long j, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "");
        return new BigDecimal(j, mathContext);
    }

    private static final BigDecimal toBigDecimal(float f) {
        return new BigDecimal(String.valueOf(f));
    }

    private static final BigDecimal toBigDecimal(float f, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "");
        return new BigDecimal(String.valueOf(f), mathContext);
    }

    private static final BigDecimal toBigDecimal(double d) {
        return new BigDecimal(String.valueOf(d));
    }

    private static final BigDecimal toBigDecimal(double d, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(mathContext, "");
        return new BigDecimal(String.valueOf(d), mathContext);
    }
}
