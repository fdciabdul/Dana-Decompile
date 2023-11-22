package id.dana.showcase.contentviewmanager;

import android.widget.ImageView;
import id.dana.showcase.target.Target;
import id.dana.showcase.view.PointerView;

/* loaded from: classes5.dex */
public class TopPointerPositionManager extends PointerPositionManager {
    @Override // id.dana.showcase.contentviewmanager.PointerPositionManager
    public final float MyBillsEntityDataFactory() {
        return 0.0f;
    }

    public TopPointerPositionManager(ImageView imageView, PointerView pointerView, Target target) {
        super(imageView, pointerView, target);
    }

    @Override // id.dana.showcase.contentviewmanager.PointerPositionManager
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory.lookAheadTest.y + (this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2() * 0.4f) + this.BuiltInFictitiousFunctionClassFactory.getContainerPadding();
    }

    @Override // id.dana.showcase.contentviewmanager.PointerPositionManager
    public final float BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult.getHeight() * 0.4f;
    }
}
