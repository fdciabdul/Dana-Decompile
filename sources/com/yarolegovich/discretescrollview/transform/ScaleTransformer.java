package com.yarolegovich.discretescrollview.transform;

import android.view.View;
import com.yarolegovich.discretescrollview.transform.Pivot;

/* loaded from: classes8.dex */
public class ScaleTransformer implements DiscreteScrollItemTransformer {
    private Pivot BuiltInFictitiousFunctionClassFactory = Pivot.X.CENTER.create();
    private Pivot KClassImpl$Data$declaredNonStaticMembers$2 = Pivot.Y.CENTER.create();
    private float getAuthRequestContext = 0.8f;
    private float PlaceComponentResult = 0.2f;

    /* loaded from: classes8.dex */
    public static class Builder {
        private ScaleTransformer KClassImpl$Data$declaredNonStaticMembers$2 = new ScaleTransformer();
        private float PlaceComponentResult = 1.0f;
    }

    @Override // com.yarolegovich.discretescrollview.transform.DiscreteScrollItemTransformer
    public final void KClassImpl$Data$declaredNonStaticMembers$2(View view, float f) {
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(view);
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(view);
        float abs = this.getAuthRequestContext + (this.PlaceComponentResult * (1.0f - Math.abs(f)));
        view.setScaleX(abs);
        view.setScaleY(abs);
    }
}
