package androidx.emoji2.text;

import android.os.Build;
import android.text.TextPaint;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {
    private static final ThreadLocal<StringBuilder> MyBillsEntityDataFactory = new ThreadLocal<>();
    private final TextPaint PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultGlyphChecker() {
        TextPaint textPaint = new TextPaint();
        this.PlaceComponentResult = textPaint;
        textPaint.setTextSize(10.0f);
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public boolean KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 23 || i3 <= Build.VERSION.SDK_INT) {
            ThreadLocal<StringBuilder> threadLocal = MyBillsEntityDataFactory;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = threadLocal.get();
            sb.setLength(0);
            while (i < i2) {
                sb.append(charSequence.charAt(i));
                i++;
            }
            return PaintCompat.PlaceComponentResult(this.PlaceComponentResult, sb.toString());
        }
        return false;
    }
}
