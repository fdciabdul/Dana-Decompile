package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes6.dex */
class GhostViewUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static GhostView KClassImpl$Data$declaredNonStaticMembers$2(View view, ViewGroup viewGroup, Matrix matrix) {
        if (Build.VERSION.SDK_INT == 28) {
            return GhostViewPlatform.PlaceComponentResult(view, viewGroup, matrix);
        }
        return GhostViewPort.BuiltInFictitiousFunctionClassFactory(view, viewGroup, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            GhostViewPlatform.BuiltInFictitiousFunctionClassFactory(view);
        } else {
            GhostViewPort.KClassImpl$Data$declaredNonStaticMembers$2(view);
        }
    }

    private GhostViewUtils() {
    }
}
