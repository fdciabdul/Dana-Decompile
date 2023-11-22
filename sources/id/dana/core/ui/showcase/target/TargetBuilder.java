package id.dana.core.ui.showcase.target;

import android.app.Activity;

/* loaded from: classes4.dex */
public class TargetBuilder extends AbstractTargetBuilder<TargetBuilder, Target> {
    @Override // id.dana.core.ui.showcase.target.AbstractTargetBuilder
    protected final /* bridge */ /* synthetic */ TargetBuilder getAuthRequestContext() {
        return this;
    }

    public TargetBuilder(Activity activity) {
        super(activity);
    }

    public final Target MyBillsEntityDataFactory() {
        return new Target(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.lookAheadTest, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, this.getErrorConfigVersion, this.moveToNextValue);
    }
}
