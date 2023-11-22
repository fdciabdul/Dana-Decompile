package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pair;

/* loaded from: classes6.dex */
public final class PaintCompat {
    private static final ThreadLocal<Pair<Rect, Rect>> PlaceComponentResult = new ThreadLocal<>();

    public static boolean PlaceComponentResult(Paint paint, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.BuiltInFictitiousFunctionClassFactory(paint, str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText("\udfffd");
        float measureText2 = paint.measureText("m");
        float measureText3 = paint.measureText(str);
        float f = 0.0f;
        if (measureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > measureText2 * 2.0f) {
                return false;
            }
            int i = 0;
            while (i < length) {
                int charCount = Character.charCount(str.codePointAt(i)) + i;
                f += paint.measureText(str, i, charCount);
                i = charCount;
            }
            if (measureText3 >= f) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        Pair<Rect, Rect> KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        paint.getTextBounds("\udfffd", 0, 2, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
        paint.getTextBounds(str, 0, length, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
        return !KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.equals(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
    }

    private static Pair<Rect, Rect> KClassImpl$Data$declaredNonStaticMembers$2() {
        ThreadLocal<Pair<Rect, Rect>> threadLocal = PlaceComponentResult;
        Pair<Rect, Rect> pair = threadLocal.get();
        if (pair == null) {
            Pair<Rect, Rect> pair2 = new Pair<>(new Rect(), new Rect());
            threadLocal.set(pair2);
            return pair2;
        }
        pair.getAuthRequestContext.setEmpty();
        pair.PlaceComponentResult.setEmpty();
        return pair;
    }

    private PaintCompat() {
    }

    /* loaded from: classes6.dex */
    static class Api29Impl {
        private Api29Impl() {
        }
    }

    /* loaded from: classes6.dex */
    static class Api23Impl {
        private Api23Impl() {
        }

        static boolean BuiltInFictitiousFunctionClassFactory(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }
}
