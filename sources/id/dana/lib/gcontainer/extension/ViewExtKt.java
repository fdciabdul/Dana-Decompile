package id.dana.lib.gcontainer.extension;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/graphics/drawable/Drawable;", "", "color", "applyTint", "(Landroid/graphics/drawable/Drawable;I)Landroid/graphics/drawable/Drawable;"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class ViewExtKt {
    public static final Drawable applyTint(Drawable drawable, int i) {
        Drawable mutate;
        if (drawable != null && (mutate = drawable.mutate()) != null) {
            mutate.setColorFilter(i, PorterDuff.Mode.SRC_IN);
        }
        return drawable;
    }
}
