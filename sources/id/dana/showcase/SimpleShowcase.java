package id.dana.showcase;

import android.app.Activity;
import android.view.View;
import id.dana.showcase.constant.PointerViewPositioningConstant;
import id.dana.showcase.target.Target;
import id.dana.showcase.view.SimpleContentView;

/* loaded from: classes5.dex */
public class SimpleShowcase extends BaseShowcase {
    private final Target BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.showcase.BaseShowcase
    public final /* bridge */ /* synthetic */ void BuiltInFictitiousFunctionClassFactory(int i) {
        super.BuiltInFictitiousFunctionClassFactory(i);
    }

    @Override // id.dana.showcase.BaseShowcase
    public final /* bridge */ /* synthetic */ int MyBillsEntityDataFactory() {
        return super.MyBillsEntityDataFactory();
    }

    @Override // id.dana.showcase.BaseShowcase, id.dana.showcase.Showcase
    public final /* bridge */ /* synthetic */ Showcase NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return super.NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    @Override // id.dana.showcase.BaseShowcase, id.dana.showcase.Showcase
    public final /* bridge */ /* synthetic */ void PlaceComponentResult() {
        super.PlaceComponentResult();
    }

    @Override // id.dana.showcase.BaseShowcase
    public final /* bridge */ /* synthetic */ PointerViewPositioningConstant getAuthRequestContext() {
        return super.getAuthRequestContext();
    }

    @Override // id.dana.showcase.BaseShowcase
    public final /* bridge */ /* synthetic */ int scheduleImpl() {
        return super.scheduleImpl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleShowcase(Params params, Activity activity, Target target, OnShowcaseStateListener onShowcaseStateListener) {
        super(params, activity, onShowcaseStateListener);
        this.BuiltInFictitiousFunctionClassFactory = target;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleShowcase(Params params, Activity activity, Target target, OnShowcaseStateListener onShowcaseStateListener, boolean z, boolean z2) {
        super(params, activity, onShowcaseStateListener, z, z2);
        this.BuiltInFictitiousFunctionClassFactory = target;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleShowcase(Params params, Activity activity, Target target, OnShowcaseStateListener onShowcaseStateListener, boolean z, boolean z2, byte b) {
        super(params, activity, onShowcaseStateListener, z, z2, (byte) 0);
        this.BuiltInFictitiousFunctionClassFactory = target;
    }

    @Override // id.dana.showcase.BaseShowcase
    protected final Target BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.showcase.BaseShowcase
    protected final void moveToNextValue() {
        KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.showcase.BaseShowcase
    public final boolean lookAheadTest() {
        return super.lookAheadTest() || this.BuiltInFictitiousFunctionClassFactory == null;
    }

    @Override // id.dana.showcase.BaseShowcase
    protected View KClassImpl$Data$declaredNonStaticMembers$2() {
        SimpleContentView simpleContentView = new SimpleContentView(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
        simpleContentView.setOnSimpleContentActionListener(new SimpleContentView.OnSimpleContentActionListener() { // from class: id.dana.showcase.SimpleShowcase$$ExternalSyntheticLambda0
            @Override // id.dana.showcase.view.SimpleContentView.OnSimpleContentActionListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                SimpleShowcase.this.GetContactSyncConfig();
            }
        });
        simpleContentView.setButtonText(((SimpleParams) this.PlaceComponentResult).BuiltInFictitiousFunctionClassFactory);
        simpleContentView.setButtonContentDescription(((SimpleParams) this.PlaceComponentResult).PlaceComponentResult);
        simpleContentView.setTitleContentDesciption(((SimpleParams) this.PlaceComponentResult).PlaceComponentResult);
        return simpleContentView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void GetContactSyncConfig() {
        super.BuiltInFictitiousFunctionClassFactory(2);
    }
}
