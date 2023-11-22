package androidx.core.text;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;

/* loaded from: classes3.dex */
public final class HtmlCompat {
    public static Spanned PlaceComponentResult(String str, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.PlaceComponentResult(str, i);
        }
        return Html.fromHtml(str);
    }

    private HtmlCompat() {
    }

    /* loaded from: classes3.dex */
    static class Api24Impl {
        private Api24Impl() {
        }

        static Spanned PlaceComponentResult(String str, int i) {
            return Html.fromHtml(str, i);
        }
    }
}
