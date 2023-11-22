package id.dana.lib.drawbitmap.style.font;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import id.dana.lib.drawbitmap.R;

/* loaded from: classes5.dex */
public class FontTypeFactory {
    private Context context;

    public FontTypeFactory(Context context) {
        this.context = context;
    }

    public Typeface getFont(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -738822430) {
            if (hashCode == 199069218 && str.equals(FontTypeVariant.OPEN_SANS_SEMIBOLD)) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals(FontTypeVariant.SF_PRO_REGULAR)) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            return toOpenSansSemiBold(this.context);
        }
        return toSFProRegular(this.context);
    }

    private Typeface toOpenSansSemiBold(Context context) {
        return ResourcesCompat.PlaceComponentResult(context, R.font.open_sans_bold);
    }

    private Typeface toSFProRegular(Context context) {
        return ResourcesCompat.PlaceComponentResult(context, R.font.sf_pro_regular);
    }
}
