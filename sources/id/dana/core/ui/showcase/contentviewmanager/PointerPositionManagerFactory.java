package id.dana.core.ui.showcase.contentviewmanager;

import android.widget.ImageView;
import id.dana.core.ui.showcase.target.Target;
import id.dana.core.ui.showcase.view.PointerView;

/* loaded from: classes4.dex */
public class PointerPositionManagerFactory {
    private PointerPositionManagerFactory() {
    }

    public static PointerPositionManager BuiltInFictitiousFunctionClassFactory(ImageView imageView, PointerView pointerView, Target target) {
        if (target.MyBillsEntityDataFactory()) {
            return new TopPointerPositionManager(imageView, pointerView, target);
        }
        return new BottomPointerPositionManager(imageView, pointerView, target);
    }
}
