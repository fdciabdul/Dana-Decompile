package ru.noties.markwon.html.impl;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public abstract class AppendableUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void PlaceComponentResult(Appendable appendable, char c) {
        try {
            appendable.append(c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(Appendable appendable, CharSequence charSequence) {
        try {
            appendable.append(charSequence);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private AppendableUtils() {
    }
}
