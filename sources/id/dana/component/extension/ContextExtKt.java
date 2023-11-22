package id.dana.component.extension;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"\u0017\u0010\u0007\u001a\u00020\u0006*\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b"}, d2 = {"Landroid/content/Context;", "", "p0", "Landroid/graphics/drawable/Drawable;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;)Z"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class ContextExtKt {
    public static final Drawable KClassImpl$Data$declaredNonStaticMembers$2(Context context, int i) {
        Drawable BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(context, "");
        BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(context, i);
        return BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public static final boolean BuiltInFictitiousFunctionClassFactory(Context context) {
        if (context != null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (activity.isDestroyed() || activity.isFinishing()) {
                }
            }
            return true;
        }
        return false;
    }
}
