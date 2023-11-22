package id.dana.core.ui.showcase.contentviewmanager;

import android.widget.ImageView;
import id.dana.core.ui.showcase.target.Target;
import id.dana.core.ui.showcase.view.PointerView;

/* loaded from: classes4.dex */
public class BottomPointerPositionManager extends PointerPositionManager {
    public BottomPointerPositionManager(ImageView imageView, PointerView pointerView, Target target) {
        super(imageView, pointerView, target);
    }

    @Override // id.dana.core.ui.showcase.contentviewmanager.PointerPositionManager
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        double d = this.MyBillsEntityDataFactory.scheduleImpl.y;
        double PlaceComponentResult = this.MyBillsEntityDataFactory.moveToNextValue.PlaceComponentResult();
        double height = this.BuiltInFictitiousFunctionClassFactory.getHeight();
        double containerPadding = this.BuiltInFictitiousFunctionClassFactory.getContainerPadding();
        Double.isNaN(PlaceComponentResult);
        Double.isNaN(d);
        Double.isNaN(height);
        Double.isNaN(containerPadding);
        return (float) (((d - (PlaceComponentResult * 0.5d)) - height) - containerPadding);
    }

    @Override // id.dana.core.ui.showcase.contentviewmanager.PointerPositionManager
    public final float BuiltInFictitiousFunctionClassFactory() {
        double height = this.BuiltInFictitiousFunctionClassFactory.getHeight();
        double height2 = this.KClassImpl$Data$declaredNonStaticMembers$2.getHeight();
        Double.isNaN(height2);
        Double.isNaN(height);
        return (float) (height - (height2 * 1.5d));
    }

    @Override // id.dana.core.ui.showcase.contentviewmanager.PointerPositionManager
    public final float getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory.getHeight() - this.KClassImpl$Data$declaredNonStaticMembers$2.getHeight();
    }
}
