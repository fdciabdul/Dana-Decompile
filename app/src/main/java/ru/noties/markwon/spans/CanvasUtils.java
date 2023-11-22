package ru.noties.markwon.spans;

import android.graphics.Paint;

/* loaded from: classes6.dex */
abstract class CanvasUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static float getAuthRequestContext(int i, int i2, Paint paint) {
        return (int) ((i + ((i2 - i) / 2)) - (((paint.descent() + paint.ascent()) / 2.0f) + 0.5f));
    }

    private CanvasUtils() {
    }
}
