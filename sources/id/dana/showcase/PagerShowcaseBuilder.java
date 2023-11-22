package id.dana.showcase;

import android.animation.TimeInterpolator;
import android.app.Activity;
import id.dana.showcase.target.Target;
import java.util.List;

/* loaded from: classes5.dex */
public class PagerShowcaseBuilder extends AbstractShowcaseBuilder<PagerShowcaseBuilder> {
    private boolean DatabaseTableConfigUtil;
    public List<? extends Target> GetContactSyncConfig;

    @Override // id.dana.showcase.AbstractShowcaseBuilder
    protected final /* bridge */ /* synthetic */ PagerShowcaseBuilder MyBillsEntityDataFactory() {
        return this;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.showcase.PagerShowcaseBuilder, id.dana.showcase.AbstractShowcaseBuilder] */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ PagerShowcaseBuilder BuiltInFictitiousFunctionClassFactory(float f) {
        return super.BuiltInFictitiousFunctionClassFactory(f);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.showcase.PagerShowcaseBuilder, id.dana.showcase.AbstractShowcaseBuilder] */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ PagerShowcaseBuilder BuiltInFictitiousFunctionClassFactory(OnShowcaseStateListener onShowcaseStateListener) {
        return super.BuiltInFictitiousFunctionClassFactory(onShowcaseStateListener);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.showcase.PagerShowcaseBuilder, id.dana.showcase.AbstractShowcaseBuilder] */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ PagerShowcaseBuilder BuiltInFictitiousFunctionClassFactory(boolean z) {
        return super.BuiltInFictitiousFunctionClassFactory(z);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.showcase.PagerShowcaseBuilder, id.dana.showcase.AbstractShowcaseBuilder] */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ PagerShowcaseBuilder KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return super.KClassImpl$Data$declaredNonStaticMembers$2(i);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.showcase.PagerShowcaseBuilder, id.dana.showcase.AbstractShowcaseBuilder] */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ PagerShowcaseBuilder MyBillsEntityDataFactory(int i) {
        return super.MyBillsEntityDataFactory(i);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.showcase.PagerShowcaseBuilder, id.dana.showcase.AbstractShowcaseBuilder] */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ PagerShowcaseBuilder getAuthRequestContext(int i) {
        return super.getAuthRequestContext(i);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [id.dana.showcase.PagerShowcaseBuilder, id.dana.showcase.AbstractShowcaseBuilder] */
    @Override // id.dana.showcase.AbstractShowcaseBuilder
    public final /* bridge */ /* synthetic */ PagerShowcaseBuilder getAuthRequestContext(TimeInterpolator timeInterpolator) {
        return super.getAuthRequestContext(timeInterpolator);
    }

    public PagerShowcaseBuilder(Activity activity) {
        super(activity);
        this.DatabaseTableConfigUtil = true;
    }

    @Override // id.dana.showcase.AbstractShowcaseBuilder
    protected final Params getAuthRequestContext() {
        return new PagerParams(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.DatabaseTableConfigUtil, this.PlaceComponentResult, this.getErrorConfigVersion, this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, this.scheduleImpl, this.BuiltInFictitiousFunctionClassFactory);
    }

    public final Showcase PlaceComponentResult() {
        return new PagerShowcase(this.GetContactSyncConfig, this.MyBillsEntityDataFactory.get(), getAuthRequestContext(), this.moveToNextValue).NetworkUserEntityData$$ExternalSyntheticLambda0();
    }
}
