package id.dana.showcase.contentviewmanager;

import android.widget.ImageView;
import id.dana.showcase.target.Target;
import id.dana.showcase.view.PointerView;

/* loaded from: classes5.dex */
public class PointerPositionManagerFactory {
    private PointerPositionManagerFactory() {
    }

    public static PointerPositionManager BuiltInFictitiousFunctionClassFactory(ImageView imageView, PointerView pointerView, Target target) {
        if (target.BuiltInFictitiousFunctionClassFactory()) {
            return new TopPointerPositionManager(imageView, pointerView, target);
        }
        return new BottomPointerPositionManager(imageView, pointerView, target);
    }
}
