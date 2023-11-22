package androidx.core.text;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class TextUtilsCompat {
    private static final Locale getAuthRequestContext = new Locale("", "");

    public static int PlaceComponentResult(Locale locale) {
        if (Build.VERSION.SDK_INT < 17) {
            if (locale == null || locale.equals(getAuthRequestContext)) {
                return 0;
            }
            String PlaceComponentResult = ICUCompat.PlaceComponentResult(locale);
            if (PlaceComponentResult == null) {
                return MyBillsEntityDataFactory(locale);
            }
            return (PlaceComponentResult.equalsIgnoreCase("Arab") || PlaceComponentResult.equalsIgnoreCase("Hebr")) ? 1 : 0;
        }
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }

    private static int MyBillsEntityDataFactory(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }

    private TextUtilsCompat() {
    }

    /* loaded from: classes3.dex */
    static class Api17Impl {
        private Api17Impl() {
        }
    }
}
