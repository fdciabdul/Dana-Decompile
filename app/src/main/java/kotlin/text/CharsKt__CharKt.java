package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0002\u0010\f\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\u0006\u001a\u00020\u0000*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\b\u001a\u0013\u0010\t\u001a\u0004\u0018\u00010\u0000*\u00020\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\t\u001a\u0004\u0018\u00010\u0000*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\u000b\u001a#\u0010\u000f\u001a\u00020\r*\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0011\u0010\u0011\u001a\u00020\r*\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00012\u0006\u0010\f\u001a\u00020\u0013H\u0086\n¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0011\u0010\u0016\u001a\u00020\u0013*\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0017"}, d2 = {"", "", "digitToChar", "(I)C", "radix", "(II)C", "digitToInt", "(C)I", "(CI)I", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "other", "", "ignoreCase", "equals", "(CCZ)Z", "isSurrogate", "(C)Z", "", "plus", "(CLjava/lang/String;)Ljava/lang/String;", "titlecase", "(C)Ljava/lang/String;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/CharsKt")
/* loaded from: classes.dex */
public class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public static final boolean isSurrogate(char c) {
        return 55296 <= c && c < 57344;
    }

    public static final int digitToInt(char c) {
        int digitOf = CharsKt.digitOf(c, 10);
        if (digitOf >= 0) {
            return digitOf;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Char ");
        sb.append(c);
        sb.append(" is not a decimal digit");
        throw new IllegalArgumentException(sb.toString());
    }

    public static final int digitToInt(char c, int i) {
        Integer digitToIntOrNull = CharsKt.digitToIntOrNull(c, i);
        if (digitToIntOrNull != null) {
            return digitToIntOrNull.intValue();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Char ");
        sb.append(c);
        sb.append(" is not a digit in the given radix=");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static final Integer digitToIntOrNull(char c) {
        Integer valueOf = Integer.valueOf(CharsKt.digitOf(c, 10));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    public static final Integer digitToIntOrNull(char c, int i) {
        CharsKt.checkRadix(i);
        Integer valueOf = Integer.valueOf(CharsKt.digitOf(c, i));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    public static final char digitToChar(int i) {
        boolean z = false;
        if (i >= 0 && i < 10) {
            z = true;
        }
        if (z) {
            return (char) (i + 48);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Int ");
        sb.append(i);
        sb.append(" is not a decimal digit");
        throw new IllegalArgumentException(sb.toString());
    }

    public static final char digitToChar(int i, int i2) {
        boolean z = false;
        if (2 <= i2 && i2 < 37) {
            z = true;
        }
        if (!z) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid radix: ");
            sb.append(i2);
            sb.append(". Valid radix values are in range 2..36");
            throw new IllegalArgumentException(sb.toString());
        } else if (i >= 0 && i < i2) {
            return (char) (i < 10 ? i + 48 : ((char) (i + 65)) - '\n');
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Digit ");
            sb2.append(i);
            sb2.append(" does not represent a valid digit in radix ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public static final String titlecase(char c) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl(c);
    }

    private static final String plus(char c, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        sb.append(str);
        return sb.toString();
    }

    public static /* synthetic */ boolean equals$default(char c, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return CharsKt.equals(c, c2, z);
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(c);
            char upperCase2 = Character.toUpperCase(c2);
            return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
        }
        return false;
    }
}
