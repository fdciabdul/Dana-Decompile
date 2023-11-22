package androidx.appcompat.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.ResourcesCompat;

/* loaded from: classes.dex */
public final class AppCompatResources {
    private AppCompatResources() {
    }

    public static ColorStateList getAuthRequestContext(Context context, int i) {
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(context.getResources(), i, context.getTheme());
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static Drawable KClassImpl$Data$declaredNonStaticMembers$2(Context context, int i) {
        return ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(context, i);
    }
}
