package zoloz.ap.com.toolkit.ui;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes9.dex */
public class FontUtils {
    public static boolean setFont(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith(".ttf")) {
            try {
                Typeface typefaceCreateFromAsset = InstrumentInjector.typefaceCreateFromAsset(textView.getContext().getAssets(), str);
                if (typefaceCreateFromAsset != null) {
                    textView.setTypeface(typefaceCreateFromAsset, 0);
                }
            } catch (Exception unused) {
            }
            return true;
        }
        int identifier = textView.getResources().getIdentifier(str, "font", textView.getContext().getPackageName());
        if (identifier != 0) {
            textView.setTypeface(ResourcesCompat.PlaceComponentResult(textView.getContext(), identifier), 0);
            return true;
        }
        return false;
    }
}
