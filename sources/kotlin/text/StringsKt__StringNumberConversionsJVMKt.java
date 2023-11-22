package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\b\u001a4\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0082\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0014\u0010\b\u001a\u00020\u0007*\u00020\u0001H\u0086\b¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0086\b¢\u0006\u0004\b\b\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007*\u00020\u0001¢\u0006\u0004\b\r\u0010\t\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\f\u001a\u0014\u0010\u000f\u001a\u00020\u000e*\u00020\u0001H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u000f\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0013\u001a\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000e*\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0010\u001a\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000e*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0013\u001a\u0014\u0010\u0016\u001a\u00020\u0015*\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0016\u0010\u0018\u001a\u00020\u0015*\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0017\u001a\u0014\u0010\u001a\u001a\u00020\u0019*\u00020\u0001H\u0086\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u001a\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\b¢\u0006\u0004\b\u001a\u0010\u001c\u001a\u0014\u0010\u001e\u001a\u00020\u001d*\u00020\u0001H\u0086\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0013\u0010 \u001a\u0004\u0018\u00010\u001d*\u00020\u0001¢\u0006\u0004\b \u0010!\u001a\u0014\u0010#\u001a\u00020\"*\u00020\u0001H\u0086\b¢\u0006\u0004\b#\u0010$\u001a\u0013\u0010%\u001a\u0004\u0018\u00010\"*\u00020\u0001¢\u0006\u0004\b%\u0010&\u001a\u0014\u0010'\u001a\u00020\u0011*\u00020\u0001H\u0086\b¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010'\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\b¢\u0006\u0004\b'\u0010)\u001a\u0014\u0010+\u001a\u00020**\u00020\u0001H\u0086\b¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010+\u001a\u00020**\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\b¢\u0006\u0004\b+\u0010-\u001a\u0014\u0010/\u001a\u00020.*\u00020\u0001H\u0086\b¢\u0006\u0004\b/\u00100\u001a\u001c\u0010/\u001a\u00020.*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\b¢\u0006\u0004\b/\u00101\u001a\u001c\u00102\u001a\u00020\u0001*\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\b¢\u0006\u0004\b2\u00103\u001a\u001c\u00102\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\b¢\u0006\u0004\b2\u00104\u001a\u001c\u00102\u001a\u00020\u0001*\u00020*2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\b¢\u0006\u0004\b2\u00105\u001a\u001c\u00102\u001a\u00020\u0001*\u00020.2\u0006\u0010\u0012\u001a\u00020\u0011H\u0086\b¢\u0006\u0004\b2\u00106"}, d2 = {"T", "", "str", "Lkotlin/Function1;", "parse", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Ljava/math/BigDecimal;", "toBigDecimal", "(Ljava/lang/String;)Ljava/math/BigDecimal;", "Ljava/math/MathContext;", "mathContext", "(Ljava/lang/String;Ljava/math/MathContext;)Ljava/math/BigDecimal;", "toBigDecimalOrNull", "Ljava/math/BigInteger;", "toBigInteger", "(Ljava/lang/String;)Ljava/math/BigInteger;", "", "radix", "(Ljava/lang/String;I)Ljava/math/BigInteger;", "toBigIntegerOrNull", "", "toBoolean", "(Ljava/lang/String;)Z", "toBooleanNullable", "", "toByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "", "toDouble", "(Ljava/lang/String;)D", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "", "toFloat", "(Ljava/lang/String;)F", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "", "toLong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "", "toShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toString", "(BI)Ljava/lang/String;", "(II)Ljava/lang/String;", "(JI)Ljava/lang/String;", "(SI)Ljava/lang/String;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    private static final String toString(byte b, int i) {
        String num = Integer.toString(b, CharsKt.checkRadix(CharsKt.checkRadix(i)));
        Intrinsics.checkNotNullExpressionValue(num, "");
        return num;
    }

    private static final String toString(short s, int i) {
        String num = Integer.toString(s, CharsKt.checkRadix(CharsKt.checkRadix(i)));
        Intrinsics.checkNotNullExpressionValue(num, "");
        return num;
    }

    private static final String toString(int i, int i2) {
        String num = Integer.toString(i, CharsKt.checkRadix(i2));
        Intrinsics.checkNotNullExpressionValue(num, "");
        return num;
    }

    private static final String toString(long j, int i) {
        String l = Long.toString(j, CharsKt.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(l, "");
        return l;
    }

    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    private static final /* synthetic */ boolean toBoolean(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return Boolean.parseBoolean(str);
    }

    private static final boolean toBooleanNullable(String str) {
        return Boolean.parseBoolean(str);
    }

    private static final byte toByte(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return Byte.parseByte(str);
    }

    private static final byte toByte(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        return Byte.parseByte(str, CharsKt.checkRadix(i));
    }

    private static final short toShort(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return Short.parseShort(str);
    }

    private static final short toShort(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        return Short.parseShort(str, CharsKt.checkRadix(i));
    }

    private static final int toInt(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return Integer.parseInt(str);
    }

    private static final int toInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        return Integer.parseInt(str, CharsKt.checkRadix(i));
    }

    private static final long toLong(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return Long.parseLong(str);
    }

    private static final long toLong(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        return Long.parseLong(str, CharsKt.checkRadix(i));
    }

    private static final float toFloat(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return Float.parseFloat(str);
    }

    private static final double toDouble(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return Double.parseDouble(str);
    }

    private static final BigInteger toBigInteger(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new BigInteger(str);
    }

    private static final BigInteger toBigInteger(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        return new BigInteger(str, CharsKt.checkRadix(i));
    }

    public static final BigInteger toBigIntegerOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.toBigIntegerOrNull(str, 10);
    }

    public static final BigInteger toBigIntegerOrNull(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length != 0) {
            if (length == 1) {
                if (CharsKt.digitOf(str.charAt(0), i) < 0) {
                    return null;
                }
            } else {
                for (int i2 = str.charAt(0) != '-' ? 0 : 1; i2 < length; i2++) {
                    if (CharsKt.digitOf(str.charAt(i2), i) < 0) {
                        return null;
                    }
                }
            }
            return new BigInteger(str, CharsKt.checkRadix(i));
        }
        return null;
    }

    private static final BigDecimal toBigDecimal(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new BigDecimal(str);
    }

    private static final BigDecimal toBigDecimal(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(mathContext, "");
        return new BigDecimal(str, mathContext);
    }

    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (ScreenFloatValueRegEx.value.matches(str)) {
                return function1.invoke(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final Float toFloatOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        try {
            if (ScreenFloatValueRegEx.value.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final Double toDoubleOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        try {
            if (ScreenFloatValueRegEx.value.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final BigDecimal toBigDecimalOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        try {
            if (ScreenFloatValueRegEx.value.matches(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final BigDecimal toBigDecimalOrNull(String str, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(mathContext, "");
        try {
            if (ScreenFloatValueRegEx.value.matches(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
