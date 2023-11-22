package Catalano.Imaging.Filters;

import Catalano.Core.FloatRange;
import Catalano.Imaging.IApplyInPlace;

/* loaded from: classes6.dex */
public class SaturationCorrection implements IApplyInPlace {
    private HSLLinear KClassImpl$Data$declaredNonStaticMembers$2 = new HSLLinear();
    private float PlaceComponentResult;

    public SaturationCorrection() {
        float max = Math.max(-1.0f, Math.min(1.0f, 0.1f));
        this.PlaceComponentResult = max;
        if (max > 0.0f) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = new FloatRange(0.0f, 1.0f - max);
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = new FloatRange(this.PlaceComponentResult, 1.0f);
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = new FloatRange(-max, 1.0f);
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = new FloatRange(0.0f, this.PlaceComponentResult + 1.0f);
    }
}
