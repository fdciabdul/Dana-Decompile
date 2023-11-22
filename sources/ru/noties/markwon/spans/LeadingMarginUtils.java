package ru.noties.markwon.spans;

import android.text.Spanned;

/* loaded from: classes6.dex */
abstract class LeadingMarginUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean PlaceComponentResult(int i, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanStart(obj) == i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getAuthRequestContext(int i, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanEnd(obj) == i;
    }

    private LeadingMarginUtils() {
    }
}
