package kotlin.text;

import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u00008\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u0004H\u0086\b¢\u0006\u0004\b\t\u0010\n\u001a\u0014\u0010\u000b\u001a\u00020\b*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u000b\u0010\n\u001a\u0014\u0010\f\u001a\u00020\b*\u00020\u0004H\u0086\b¢\u0006\u0004\b\f\u0010\n\u001a\u0014\u0010\r\u001a\u00020\b*\u00020\u0004H\u0086\b¢\u0006\u0004\b\r\u0010\n\u001a\u0014\u0010\u000e\u001a\u00020\b*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u000e\u0010\n\u001a\u0014\u0010\u000f\u001a\u00020\b*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u000f\u0010\n\u001a\u0014\u0010\u0010\u001a\u00020\b*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0010\u0010\n\u001a\u0014\u0010\u0011\u001a\u00020\b*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0011\u0010\n\u001a\u0014\u0010\u0012\u001a\u00020\b*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0012\u0010\n\u001a\u0014\u0010\u0013\u001a\u00020\b*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0013\u0010\n\u001a\u0014\u0010\u0014\u001a\u00020\b*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0014\u0010\n\u001a\u0014\u0010\u0015\u001a\u00020\b*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0015\u0010\n\u001a\u0014\u0010\u0016\u001a\u00020\b*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0016\u0010\n\u001a\u0011\u0010\u0017\u001a\u00020\b*\u00020\u0004¢\u0006\u0004\b\u0017\u0010\n\u001a\u0014\u0010\u0019\u001a\u00020\u0018*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u0019\u001a\u00020\u0018*\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0019\u0010\u001d\u001a\u0014\u0010\u001e\u001a\u00020\u0004*\u00020\u0004H\u0086\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0019\u0010 \u001a\u00020\u0018*\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b \u0010\u001d\u001a\u0014\u0010!\u001a\u00020\u0004*\u00020\u0004H\u0086\b¢\u0006\u0004\b!\u0010\u001f\u001a\u0014\u0010\"\u001a\u00020\u0004*\u00020\u0004H\u0087\b¢\u0006\u0004\b\"\u0010\u001f\u001a\u0014\u0010#\u001a\u00020\u0004*\u00020\u0004H\u0087\b¢\u0006\u0004\b#\u0010\u001f\u001a\u0014\u0010$\u001a\u00020\u0004*\u00020\u0004H\u0087\b¢\u0006\u0004\b$\u0010\u001f\u001a\u0014\u0010%\u001a\u00020\u0018*\u00020\u0004H\u0086\b¢\u0006\u0004\b%\u0010\u001a\u001a\u0019\u0010%\u001a\u00020\u0018*\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b%\u0010\u001d\u001a\u0014\u0010&\u001a\u00020\u0004*\u00020\u0004H\u0086\b¢\u0006\u0004\b&\u0010\u001f\"\u0015\u0010*\u001a\u00020'*\u00020\u00048G¢\u0006\u0006\u001a\u0004\b(\u0010)\"\u0015\u0010.\u001a\u00020+*\u00020\u00048G¢\u0006\u0006\u001a\u0004\b,\u0010-"}, d2 = {"", "radix", "checkRadix", "(I)I", "", "char", "digitOf", "(CI)I", "", "isDefined", "(C)Z", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "", "lowercase", "(C)Ljava/lang/String;", "Ljava/util/Locale;", "locale", "(CLjava/util/Locale;)Ljava/lang/String;", "lowercaseChar", "(C)C", "titlecase", "titlecaseChar", "toLowerCase", "toTitleCase", "toUpperCase", "uppercase", "uppercaseChar", "Lkotlin/text/CharCategory;", "getCategory", "(C)Lkotlin/text/CharCategory;", "category", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "directionality"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/CharsKt")
/* loaded from: classes.dex */
public class CharsKt__CharJVMKt {
    @JvmName(name = "getCategory")
    public static final CharCategory getCategory(char c) {
        return CharCategory.INSTANCE.valueOf(Character.getType(c));
    }

    private static final boolean isDefined(char c) {
        return Character.isDefined(c);
    }

    private static final boolean isLetter(char c) {
        return Character.isLetter(c);
    }

    private static final boolean isLetterOrDigit(char c) {
        return Character.isLetterOrDigit(c);
    }

    private static final boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private static final boolean isIdentifierIgnorable(char c) {
        return Character.isIdentifierIgnorable(c);
    }

    private static final boolean isISOControl(char c) {
        return Character.isISOControl(c);
    }

    private static final boolean isJavaIdentifierPart(char c) {
        return Character.isJavaIdentifierPart(c);
    }

    private static final boolean isJavaIdentifierStart(char c) {
        return Character.isJavaIdentifierStart(c);
    }

    public static final boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    private static final boolean isUpperCase(char c) {
        return Character.isUpperCase(c);
    }

    private static final boolean isLowerCase(char c) {
        return Character.isLowerCase(c);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toUpperCase(char c) {
        return Character.toUpperCase(c);
    }

    private static final char uppercaseChar(char c) {
        return Character.toUpperCase(c);
    }

    private static final String uppercase(char c) {
        String upperCase = String.valueOf(c).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        return upperCase;
    }

    public static final String uppercase(char c, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "");
        String upperCase = String.valueOf(c).toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        return upperCase;
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toLowerCase(char c) {
        return Character.toLowerCase(c);
    }

    private static final char lowercaseChar(char c) {
        return Character.toLowerCase(c);
    }

    private static final String lowercase(char c) {
        String lowerCase = String.valueOf(c).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return lowerCase;
    }

    public static final String lowercase(char c, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "");
        String lowerCase = String.valueOf(c).toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return lowerCase;
    }

    private static final boolean isTitleCase(char c) {
        return Character.isTitleCase(c);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toTitleCase(char c) {
        return Character.toTitleCase(c);
    }

    private static final char titlecaseChar(char c) {
        return Character.toTitleCase(c);
    }

    public static final String titlecase(char c, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "");
        String uppercase = CharsKt.uppercase(c, locale);
        if (uppercase.length() <= 1) {
            String upperCase = String.valueOf(c).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            return !Intrinsics.areEqual(uppercase, upperCase) ? uppercase : String.valueOf(Character.toTitleCase(c));
        } else if (c != 329) {
            char charAt = uppercase.charAt(0);
            String substring = uppercase.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            String lowerCase = substring.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
            StringBuilder sb = new StringBuilder();
            sb.append(charAt);
            sb.append(lowerCase);
            return sb.toString();
        } else {
            return uppercase;
        }
    }

    @JvmName(name = "getDirectionality")
    public static final CharDirectionality getDirectionality(char c) {
        return CharDirectionality.INSTANCE.valueOf(Character.getDirectionality(c));
    }

    private static final boolean isHighSurrogate(char c) {
        return Character.isHighSurrogate(c);
    }

    private static final boolean isLowSurrogate(char c) {
        return Character.isLowSurrogate(c);
    }

    public static final int digitOf(char c, int i) {
        return Character.digit((int) c, i);
    }

    public static final int checkRadix(int i) {
        boolean z = false;
        if (2 <= i && i < 37) {
            z = true;
        }
        if (z) {
            return i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("radix ");
        sb.append(i);
        sb.append(" was not in valid range ");
        sb.append(new IntRange(2, 36));
        throw new IllegalArgumentException(sb.toString());
    }
}
