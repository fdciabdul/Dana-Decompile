package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.Preconditions;
import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;

/* loaded from: classes.dex */
public final class EditorInfoCompat {
    private static final String[] BuiltInFictitiousFunctionClassFactory = new String[0];

    private static boolean MyBillsEntityDataFactory(int i) {
        int i2 = i & ARiverTrackWatchDogEventConstant.STARTUP_FLAG;
        return i2 == 129 || i2 == 225 || i2 == 18;
    }

    public static void PlaceComponentResult(EditorInfo editorInfo, String[] strArr) {
        if (Build.VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = strArr;
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
        editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", strArr);
    }

    public static String[] MyBillsEntityDataFactory(EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 25) {
            String[] strArr = editorInfo.contentMimeTypes;
            return strArr == null ? BuiltInFictitiousFunctionClassFactory : strArr;
        } else if (editorInfo.extras == null) {
            return BuiltInFictitiousFunctionClassFactory;
        } else {
            String[] stringArray = editorInfo.extras.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
            if (stringArray == null) {
                stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
            }
            return stringArray == null ? BuiltInFictitiousFunctionClassFactory : stringArray;
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT < 30) {
            BuiltInFictitiousFunctionClassFactory(editorInfo, charSequence, 0);
        } else {
            editorInfo.setInitialSurroundingSubText(charSequence, 0);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(EditorInfo editorInfo, CharSequence charSequence, int i) {
        int i2;
        int i3;
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(charSequence);
        if (Build.VERSION.SDK_INT < 30) {
            if (editorInfo.initialSelStart > editorInfo.initialSelEnd) {
                i2 = editorInfo.initialSelEnd;
            } else {
                i2 = editorInfo.initialSelStart;
            }
            int i4 = i2 - i;
            if (editorInfo.initialSelStart > editorInfo.initialSelEnd) {
                i3 = editorInfo.initialSelStart;
            } else {
                i3 = editorInfo.initialSelEnd;
            }
            int i5 = i3 - i;
            int length = charSequence.length();
            if (i < 0 || i4 < 0 || i5 > length) {
                PlaceComponentResult(editorInfo, null, 0, 0);
                return;
            } else if (MyBillsEntityDataFactory(editorInfo.inputType)) {
                PlaceComponentResult(editorInfo, null, 0, 0);
                return;
            } else if (length <= 2048) {
                PlaceComponentResult(editorInfo, charSequence, i4, i5);
                return;
            } else {
                BuiltInFictitiousFunctionClassFactory(editorInfo, charSequence, i4, i5);
                return;
            }
        }
        editorInfo.setInitialSurroundingSubText(charSequence, i);
    }

    private static void BuiltInFictitiousFunctionClassFactory(EditorInfo editorInfo, CharSequence charSequence, int i, int i2) {
        CharSequence subSequence;
        int i3 = i2 - i;
        int i4 = i3 > 1024 ? 0 : i3;
        int length = charSequence.length();
        int i5 = 2048 - i4;
        double d = i5;
        Double.isNaN(d);
        int min = Math.min(length - i2, i5 - Math.min(i, (int) (d * 0.8d)));
        int min2 = Math.min(i, i5 - min);
        int i6 = i - min2;
        if (PlaceComponentResult(charSequence, i6, 0)) {
            i6++;
            min2--;
        }
        if (PlaceComponentResult(charSequence, (i2 + min) - 1, 1)) {
            min--;
        }
        if (i4 != i3) {
            subSequence = TextUtils.concat(charSequence.subSequence(i6, i6 + min2), charSequence.subSequence(i2, min + i2));
        } else {
            subSequence = charSequence.subSequence(i6, min2 + i4 + min + i6);
        }
        int i7 = min2 + 0;
        PlaceComponentResult(editorInfo, subSequence, i7, i4 + i7);
    }

    private static boolean PlaceComponentResult(CharSequence charSequence, int i, int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return false;
            }
            return Character.isHighSurrogate(charSequence.charAt(i));
        }
        return Character.isLowSurrogate(charSequence.charAt(i));
    }

    private static void PlaceComponentResult(EditorInfo editorInfo, CharSequence charSequence, int i, int i2) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i2);
    }

    @Deprecated
    public EditorInfoCompat() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }
    }
}
