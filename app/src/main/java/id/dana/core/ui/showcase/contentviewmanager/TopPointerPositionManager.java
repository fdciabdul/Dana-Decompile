package id.dana.core.ui.showcase.contentviewmanager;

import android.widget.ImageView;
import id.dana.core.ui.showcase.target.Target;
import id.dana.core.ui.showcase.view.PointerView;

/* loaded from: classes4.dex */
public class TopPointerPositionManager extends PointerPositionManager {
    @Override // id.dana.core.ui.showcase.contentviewmanager.PointerPositionManager
    public final float getAuthRequestContext() {
        return 0.0f;
    }

    public TopPointerPositionManager(ImageView imageView, PointerView pointerView, Target target) {
        super(imageView, pointerView, target);
    }

    @Override // id.dana.core.ui.showcase.contentviewmanager.PointerPositionManager
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory.scheduleImpl.y + (this.MyBillsEntityDataFactory.moveToNextValue.PlaceComponentResult() * 0.4f) + this.BuiltInFictitiousFunctionClassFactory.getContainerPadding();
    }

    @Override // id.dana.core.ui.showcase.contentviewmanager.PointerPositionManager
    public final float BuiltInFictitiousFunctionClassFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getHeight() * 0.4f;
    }
}
