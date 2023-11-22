package id.dana.showcase.contentviewmanager;

import android.widget.ImageView;
import id.dana.showcase.target.Target;
import id.dana.showcase.view.PointerView;

/* loaded from: classes5.dex */
public class BottomPointerPositionManager extends PointerPositionManager {
    public BottomPointerPositionManager(ImageView imageView, PointerView pointerView, Target target) {
        super(imageView, pointerView, target);
    }

    @Override // id.dana.showcase.contentviewmanager.PointerPositionManager
    public final float KClassImpl$Data$declaredNonStaticMembers$2() {
        double d = this.MyBillsEntityDataFactory.lookAheadTest.y;
        double KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2();
        double height = this.BuiltInFictitiousFunctionClassFactory.getHeight();
        double containerPadding = this.BuiltInFictitiousFunctionClassFactory.getContainerPadding();
        Double.isNaN(KClassImpl$Data$declaredNonStaticMembers$2);
        Double.isNaN(d);
        Double.isNaN(height);
        Double.isNaN(containerPadding);
        return (float) (((d - (KClassImpl$Data$declaredNonStaticMembers$2 * 0.5d)) - height) - containerPadding);
    }

    @Override // id.dana.showcase.contentviewmanager.PointerPositionManager
    public final float BuiltInFictitiousFunctionClassFactory() {
        double height = this.BuiltInFictitiousFunctionClassFactory.getHeight();
        double height2 = this.PlaceComponentResult.getHeight();
        Double.isNaN(height2);
        Double.isNaN(height);
        return (float) (height - (height2 * 1.5d));
    }

    @Override // id.dana.showcase.contentviewmanager.PointerPositionManager
    public final float MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory.getHeight() - this.PlaceComponentResult.getHeight();
    }
}
