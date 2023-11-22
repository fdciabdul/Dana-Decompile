package id.dana.showcase;

import android.animation.TimeInterpolator;
import android.app.Activity;
import id.dana.R;
import id.dana.showcase.target.Target;

/* loaded from: classes3.dex */
public class SimpleShowcaseBuilder extends AbstractShowcaseBuilder<SimpleShowcaseBuilder> {
    protected String DatabaseTableConfigUtil;
    protected boolean GetContactSyncConfig;
    protected String NetworkUserEntityData$$ExternalSyntheticLambda1;
    public Target NetworkUserEntityData$$ExternalSyntheticLambda2;
    protected boolean initRecordTimeStamp;
    protected String isLayoutRequested;

    @Override // id.dana.showcase.AbstractShowcaseBuilder
    protected final /* bridge */ /* synthetic */ SimpleShowcaseBuilder MyBillsEntityDataFactory() {
        return this;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.showcase.AbstractShowcaseBuilder, id.dana.showcase.SimpleShowcaseBuilder] */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ SimpleShowcaseBuilder BuiltInFictitiousFunctionClassFactory(float f) {
        return super.BuiltInFictitiousFunctionClassFactory(f);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.showcase.AbstractShowcaseBuilder, id.dana.showcase.SimpleShowcaseBuilder] */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ SimpleShowcaseBuilder BuiltInFictitiousFunctionClassFactory(OnShowcaseStateListener onShowcaseStateListener) {
        return super.BuiltInFictitiousFunctionClassFactory(onShowcaseStateListener);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.showcase.AbstractShowcaseBuilder, id.dana.showcase.SimpleShowcaseBuilder] */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ SimpleShowcaseBuilder BuiltInFictitiousFunctionClassFactory(boolean z) {
        return super.BuiltInFictitiousFunctionClassFactory(z);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.showcase.AbstractShowcaseBuilder, id.dana.showcase.SimpleShowcaseBuilder] */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ SimpleShowcaseBuilder KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return super.KClassImpl$Data$declaredNonStaticMembers$2(i);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.showcase.AbstractShowcaseBuilder, id.dana.showcase.SimpleShowcaseBuilder] */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ SimpleShowcaseBuilder MyBillsEntityDataFactory(int i) {
        return super.MyBillsEntityDataFactory(i);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.showcase.AbstractShowcaseBuilder, id.dana.showcase.SimpleShowcaseBuilder] */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ SimpleShowcaseBuilder getAuthRequestContext(int i) {
        return super.getAuthRequestContext(i);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.showcase.AbstractShowcaseBuilder, id.dana.showcase.SimpleShowcaseBuilder] */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ SimpleShowcaseBuilder getAuthRequestContext(TimeInterpolator timeInterpolator) {
        return super.getAuthRequestContext(timeInterpolator);
    }

    public SimpleShowcaseBuilder(Activity activity) {
        super(activity);
        this.GetContactSyncConfig = true;
        this.initRecordTimeStamp = false;
        this.DatabaseTableConfigUtil = activity.getString(R.string.bottom_on_boarding_button_finish);
    }

    public final SimpleShowcaseBuilder PlaceComponentResult(String str) {
        this.DatabaseTableConfigUtil = str;
        return this;
    }

    public final SimpleShowcaseBuilder BuiltInFictitiousFunctionClassFactory(String str) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str;
        return this;
    }

    public final SimpleShowcaseBuilder MyBillsEntityDataFactory(String str) {
        this.isLayoutRequested = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public Params getAuthRequestContext() {
        return new SimpleParams(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.PlaceComponentResult, this.getErrorConfigVersion, this.KClassImpl$Data$declaredNonStaticMembers$2, this.DatabaseTableConfigUtil, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.isLayoutRequested, this.lookAheadTest, this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory);
    }

    public Showcase PlaceComponentResult() {
        return new SimpleShowcase(getAuthRequestContext(), this.MyBillsEntityDataFactory.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.moveToNextValue, this.GetContactSyncConfig, this.initRecordTimeStamp).NetworkUserEntityData$$ExternalSyntheticLambda0();
    }
}
