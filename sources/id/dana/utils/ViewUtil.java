package id.dana.utils;

import android.widget.TextView;

/* loaded from: classes5.dex */
public class ViewUtil {
    private ViewUtil() {
    }

    public static void PlaceComponentResult(int i, TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            if (textView != null) {
                textView.setTextColor(i);
            }
        }
    }
}
