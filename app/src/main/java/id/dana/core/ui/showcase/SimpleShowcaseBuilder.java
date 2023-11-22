package id.dana.core.ui.showcase;

import android.app.Activity;
import id.dana.core.ui.R;
import id.dana.core.ui.showcase.target.Target;

/* loaded from: classes4.dex */
public class SimpleShowcaseBuilder extends AbstractShowcaseBuilder<SimpleShowcaseBuilder> {
    public boolean DatabaseTableConfigUtil;
    public Target GetContactSyncConfig;
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    protected boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private String initRecordTimeStamp;
    private String isLayoutRequested;

    @Override // id.dana.core.ui.showcase.AbstractShowcaseBuilder
    protected final /* bridge */ /* synthetic */ SimpleShowcaseBuilder PlaceComponentResult() {
        return this;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.core.ui.showcase.AbstractShowcaseBuilder, id.dana.core.ui.showcase.SimpleShowcaseBuilder] */
    @Override // id.dana.core.ui.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ SimpleShowcaseBuilder KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        return super.KClassImpl$Data$declaredNonStaticMembers$2(z);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.core.ui.showcase.AbstractShowcaseBuilder, id.dana.core.ui.showcase.SimpleShowcaseBuilder] */
    @Override // id.dana.core.ui.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ SimpleShowcaseBuilder getAuthRequestContext(OnShowcaseStateListener onShowcaseStateListener) {
        return super.getAuthRequestContext(onShowcaseStateListener);
    }

    public SimpleShowcaseBuilder(Activity activity) {
        super(activity);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        this.DatabaseTableConfigUtil = true;
        this.initRecordTimeStamp = activity.getString(R.string.bottom_on_boarding_button_finish);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.core.ui.showcase.AbstractShowcaseBuilder
    public final Params getAuthRequestContext() {
        return new SimpleParams(this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.MyBillsEntityDataFactory, this.initRecordTimeStamp, this.isLayoutRequested, this.DatabaseTableConfigUtil, this.lookAheadTest, this.moveToNextValue, this.getAuthRequestContext);
    }

    public Showcase BuiltInFictitiousFunctionClassFactory() {
        return new SimpleShowcase(getAuthRequestContext(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.GetContactSyncConfig, this.getErrorConfigVersion, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.NetworkUserEntityData$$ExternalSyntheticLambda2).moveToNextValue();
    }
}
