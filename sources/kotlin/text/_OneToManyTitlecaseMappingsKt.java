package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\f\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "titlecaseImpl", "(C)Ljava/lang/String;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class _OneToManyTitlecaseMappingsKt {
    public static final String titlecaseImpl(char c) {
        String upperCase = String.valueOf(c).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        if (upperCase.length() > 1) {
            if (c != 329) {
                char charAt = upperCase.charAt(0);
                String substring = upperCase.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "");
                String lowerCase = substring.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                StringBuilder sb = new StringBuilder();
                sb.append(charAt);
                sb.append(lowerCase);
                return sb.toString();
            }
            return upperCase;
        }
        return String.valueOf(Character.toTitleCase(c));
    }
}
