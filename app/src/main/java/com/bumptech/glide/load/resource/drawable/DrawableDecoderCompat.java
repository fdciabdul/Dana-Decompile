package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* loaded from: classes3.dex */
public final class DrawableDecoderCompat {
    private static volatile boolean BuiltInFictitiousFunctionClassFactory = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable BuiltInFictitiousFunctionClassFactory(Context context, Context context2, int i) {
        return getAuthRequestContext(context, context2, i, null);
    }

    public static Drawable PlaceComponentResult(Context context, int i, Resources.Theme theme) {
        return getAuthRequestContext(context, context, i, theme);
    }

    private static Drawable getAuthRequestContext(Context context, Context context2, int i, Resources.Theme theme) {
        Drawable BuiltInFictitiousFunctionClassFactory2;
        try {
            if (BuiltInFictitiousFunctionClassFactory) {
                BuiltInFictitiousFunctionClassFactory2 = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(theme != null ? new ContextThemeWrapper(context2, theme) : context2, i);
                return BuiltInFictitiousFunctionClassFactory2;
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e;
            }
            return ContextCompat.PlaceComponentResult(context2, i);
        } catch (NoClassDefFoundError unused2) {
            BuiltInFictitiousFunctionClassFactory = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return ResourcesCompat.BuiltInFictitiousFunctionClassFactory(context2.getResources(), i, theme);
    }
}
