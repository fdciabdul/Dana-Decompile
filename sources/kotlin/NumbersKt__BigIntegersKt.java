package kotlin;

import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0000*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u0014\u0010\b\u001a\u00020\u0000*\u00020\u0000H\u0086\b¢\u0006\u0004\b\b\u0010\u0005\u001a\u001c\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\t\u0010\u0003\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\n\u0010\u0003\u001a\u001c\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u001c\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\f\u0010\u0003\u001a\u001c\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0086\f¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0086\f¢\u0006\u0004\b\u0011\u0010\u0010\u001a\u001c\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u0012\u0010\u0003\u001a\u0014\u0010\u0014\u001a\u00020\u0013*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a(\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u0000*\u00020\rH\u0086\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0014\u0010\u001a\u001a\u00020\u0000*\u00020\u001cH\u0086\b¢\u0006\u0004\b\u001a\u0010\u001d\u001a\u0014\u0010\u001e\u001a\u00020\u0000*\u00020\u0000H\u0086\n¢\u0006\u0004\b\u001e\u0010\u0005\u001a\u001c\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\f¢\u0006\u0004\b\u001f\u0010\u0003"}, d2 = {"Ljava/math/BigInteger;", "other", "and", "(Ljava/math/BigInteger;Ljava/math/BigInteger;)Ljava/math/BigInteger;", "dec", "(Ljava/math/BigInteger;)Ljava/math/BigInteger;", "div", "inc", "inv", "minus", "or", "plus", "rem", "", "n", "shl", "(Ljava/math/BigInteger;I)Ljava/math/BigInteger;", "shr", "times", "Ljava/math/BigDecimal;", "toBigDecimal", "(Ljava/math/BigInteger;)Ljava/math/BigDecimal;", H5MapRenderOptimizer.KEY_SCALE, "Ljava/math/MathContext;", "mathContext", "(Ljava/math/BigInteger;ILjava/math/MathContext;)Ljava/math/BigDecimal;", "toBigInteger", "(I)Ljava/math/BigInteger;", "", "(J)Ljava/math/BigInteger;", "unaryMinus", "xor"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/NumbersKt")
/* loaded from: classes9.dex */
class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt {
    private static final BigInteger plus(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        Intrinsics.checkNotNullParameter(bigInteger2, "");
        BigInteger add = bigInteger.add(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(add, "");
        return add;
    }

    private static final BigInteger minus(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        Intrinsics.checkNotNullParameter(bigInteger2, "");
        BigInteger subtract = bigInteger.subtract(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(subtract, "");
        return subtract;
    }

    private static final BigInteger times(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        Intrinsics.checkNotNullParameter(bigInteger2, "");
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(multiply, "");
        return multiply;
    }

    private static final BigInteger div(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        Intrinsics.checkNotNullParameter(bigInteger2, "");
        BigInteger divide = bigInteger.divide(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(divide, "");
        return divide;
    }

    private static final BigInteger rem(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        Intrinsics.checkNotNullParameter(bigInteger2, "");
        BigInteger remainder = bigInteger.remainder(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(remainder, "");
        return remainder;
    }

    private static final BigInteger unaryMinus(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        BigInteger negate = bigInteger.negate();
        Intrinsics.checkNotNullExpressionValue(negate, "");
        return negate;
    }

    private static final BigInteger inc(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        BigInteger add = bigInteger.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(add, "");
        return add;
    }

    private static final BigInteger dec(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        BigInteger subtract = bigInteger.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(subtract, "");
        return subtract;
    }

    private static final BigInteger inv(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        BigInteger not = bigInteger.not();
        Intrinsics.checkNotNullExpressionValue(not, "");
        return not;
    }

    private static final BigInteger and(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        Intrinsics.checkNotNullParameter(bigInteger2, "");
        BigInteger and = bigInteger.and(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(and, "");
        return and;
    }

    private static final BigInteger or(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        Intrinsics.checkNotNullParameter(bigInteger2, "");
        BigInteger or = bigInteger.or(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(or, "");
        return or;
    }

    private static final BigInteger xor(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        Intrinsics.checkNotNullParameter(bigInteger2, "");
        BigInteger xor = bigInteger.xor(bigInteger2);
        Intrinsics.checkNotNullExpressionValue(xor, "");
        return xor;
    }

    private static final BigInteger shl(BigInteger bigInteger, int i) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        BigInteger shiftLeft = bigInteger.shiftLeft(i);
        Intrinsics.checkNotNullExpressionValue(shiftLeft, "");
        return shiftLeft;
    }

    private static final BigInteger shr(BigInteger bigInteger, int i) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        BigInteger shiftRight = bigInteger.shiftRight(i);
        Intrinsics.checkNotNullExpressionValue(shiftRight, "");
        return shiftRight;
    }

    private static final BigInteger toBigInteger(int i) {
        BigInteger valueOf = BigInteger.valueOf(i);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        return valueOf;
    }

    private static final BigInteger toBigInteger(long j) {
        BigInteger valueOf = BigInteger.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(valueOf, "");
        return valueOf;
    }

    private static final BigDecimal toBigDecimal(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        return new BigDecimal(bigInteger);
    }

    static /* synthetic */ BigDecimal toBigDecimal$default(BigInteger bigInteger, int i, MathContext mathContext, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            Intrinsics.checkNotNullExpressionValue(mathContext, "");
        }
        Intrinsics.checkNotNullParameter(bigInteger, "");
        Intrinsics.checkNotNullParameter(mathContext, "");
        return new BigDecimal(bigInteger, i, mathContext);
    }

    private static final BigDecimal toBigDecimal(BigInteger bigInteger, int i, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(bigInteger, "");
        Intrinsics.checkNotNullParameter(mathContext, "");
        return new BigDecimal(bigInteger, i, mathContext);
    }
}
