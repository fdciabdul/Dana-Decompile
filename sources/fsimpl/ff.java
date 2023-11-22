package fsimpl;

import android.view.View;
import android.view.ViewParent;
import com.fullstory.instrumentation.frameworks.compose.FSComposeAndroidComposeView;
import com.fullstory.instrumentation.frameworks.compose.FSComposeLayoutNode;

/* loaded from: classes.dex */
public class ff {
    public static Object a(Object obj) {
        if (obj instanceof View) {
            ViewParent parent = ((View) obj).getParent();
            if (parent instanceof View) {
                return parent;
            }
            return null;
        } else if (!(obj instanceof FSComposeLayoutNode)) {
            c(obj);
            return null;
        } else {
            FSComposeLayoutNode fSComposeLayoutNode = (FSComposeLayoutNode) obj;
            FSComposeLayoutNode _fsGetParent = fSComposeLayoutNode._fsGetParent();
            if (_fsGetParent != null) {
                return _fsGetParent;
            }
            Object _fsGetOwner = fSComposeLayoutNode._fsGetOwner();
            if ((_fsGetOwner instanceof View) && C0262bm.a((View) _fsGetOwner) && ((FSComposeAndroidComposeView) _fsGetOwner)._fsGetRoot() == fSComposeLayoutNode) {
                return _fsGetOwner;
            }
            return null;
        }
    }

    public static void b(Object obj) {
    }

    public static void c(Object obj) {
    }
}
