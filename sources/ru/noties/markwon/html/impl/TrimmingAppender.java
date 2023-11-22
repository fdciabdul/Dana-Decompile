package ru.noties.markwon.html.impl;

import id.dana.cashier.view.InputCardNumberView;

/* loaded from: classes6.dex */
abstract class TrimmingAppender {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <T extends Appendable & CharSequence> void PlaceComponentResult(T t, String str);

    TrimmingAppender() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TrimmingAppender KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Impl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Impl extends TrimmingAppender {
        Impl() {
        }

        @Override // ru.noties.markwon.html.impl.TrimmingAppender
        final <T extends Appendable & CharSequence> void PlaceComponentResult(T t, String str) {
            int length;
            T t2 = t;
            int length2 = t2.length();
            int length3 = str.length();
            boolean z = false;
            for (int i = 0; i < length3; i++) {
                char charAt = str.charAt(i);
                if (Character.isWhitespace(charAt)) {
                    z = true;
                } else {
                    if (z && (length = t2.length()) > 0 && !Character.isWhitespace(t2.charAt(length - 1))) {
                        AppendableUtils.PlaceComponentResult(t, InputCardNumberView.DIVIDER);
                    }
                    AppendableUtils.PlaceComponentResult(t, charAt);
                    z = false;
                }
            }
            if (!z || length2 >= t2.length()) {
                return;
            }
            AppendableUtils.PlaceComponentResult(t, InputCardNumberView.DIVIDER);
        }
    }
}
