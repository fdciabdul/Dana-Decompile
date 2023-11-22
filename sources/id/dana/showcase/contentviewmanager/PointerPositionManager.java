package id.dana.showcase.contentviewmanager;

import android.widget.ImageView;
import id.dana.showcase.target.Target;
import id.dana.showcase.view.PointerView;

/* loaded from: classes5.dex */
public abstract class PointerPositionManager {
    public final PointerView BuiltInFictitiousFunctionClassFactory;
    public final float KClassImpl$Data$declaredNonStaticMembers$2;
    public final Target MyBillsEntityDataFactory;
    public final ImageView PlaceComponentResult;

    public abstract float BuiltInFictitiousFunctionClassFactory();

    public abstract float KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract float MyBillsEntityDataFactory();

    /* JADX INFO: Access modifiers changed from: package-private */
    public PointerPositionManager(ImageView imageView, PointerView pointerView, Target target) {
        this.PlaceComponentResult = imageView;
        this.BuiltInFictitiousFunctionClassFactory = pointerView;
        this.MyBillsEntityDataFactory = target;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView.getWidth() * 0.5f;
    }
}
