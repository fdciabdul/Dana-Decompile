package id.dana.core.ui.showcase;

import android.app.Activity;
import android.view.View;
import id.dana.core.ui.showcase.constant.PointerViewPositioningConstant;
import id.dana.core.ui.showcase.target.Target;
import id.dana.core.ui.showcase.view.SimpleContentView;

/* loaded from: classes4.dex */
public class SimpleShowcase extends BaseShowcase {
    private final Target MyBillsEntityDataFactory;

    @Override // id.dana.core.ui.showcase.BaseShowcase, id.dana.core.ui.showcase.Showcase
    public final /* bridge */ /* synthetic */ void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
    }

    @Override // id.dana.core.ui.showcase.BaseShowcase
    public final /* bridge */ /* synthetic */ void MyBillsEntityDataFactory(int i) {
        super.MyBillsEntityDataFactory(i);
    }

    @Override // id.dana.core.ui.showcase.BaseShowcase
    public final /* bridge */ /* synthetic */ int PlaceComponentResult() {
        return super.PlaceComponentResult();
    }

    @Override // id.dana.core.ui.showcase.BaseShowcase
    public final /* bridge */ /* synthetic */ PointerViewPositioningConstant lookAheadTest() {
        return super.lookAheadTest();
    }

    @Override // id.dana.core.ui.showcase.BaseShowcase, id.dana.core.ui.showcase.Showcase
    public final /* bridge */ /* synthetic */ Showcase moveToNextValue() {
        return super.moveToNextValue();
    }

    @Override // id.dana.core.ui.showcase.BaseShowcase
    public final /* bridge */ /* synthetic */ int scheduleImpl() {
        return super.scheduleImpl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleShowcase(Params params, Activity activity, Target target, OnShowcaseStateListener onShowcaseStateListener, boolean z, boolean z2) {
        super(params, activity, onShowcaseStateListener, z, z2);
        this.MyBillsEntityDataFactory = target;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleShowcase(Params params, Activity activity, Target target, OnShowcaseStateListener onShowcaseStateListener, boolean z, boolean z2, byte b) {
        super(params, activity, onShowcaseStateListener, z, z2, (byte) 0);
        this.MyBillsEntityDataFactory = target;
    }

    @Override // id.dana.core.ui.showcase.BaseShowcase
    protected final Target KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.showcase.BaseShowcase
    protected final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        getAuthRequestContext(this.MyBillsEntityDataFactory);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.core.ui.showcase.BaseShowcase
    public final boolean getErrorConfigVersion() {
        return super.getErrorConfigVersion() || this.MyBillsEntityDataFactory == null;
    }

    @Override // id.dana.core.ui.showcase.BaseShowcase
    protected View getAuthRequestContext() {
        SimpleContentView simpleContentView = new SimpleContentView(this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory);
        simpleContentView.setOnSimpleContentActionListener(new SimpleContentView.OnSimpleContentActionListener() { // from class: id.dana.core.ui.showcase.SimpleShowcase$$ExternalSyntheticLambda0
            @Override // id.dana.core.ui.showcase.view.SimpleContentView.OnSimpleContentActionListener
            public final void getAuthRequestContext() {
                SimpleShowcase.this.DatabaseTableConfigUtil();
            }
        });
        simpleContentView.setButtonVisibility(((SimpleParams) this.KClassImpl$Data$declaredNonStaticMembers$2).getPlaceComponentResult());
        simpleContentView.setButtonText(((SimpleParams) this.KClassImpl$Data$declaredNonStaticMembers$2).getAuthRequestContext);
        simpleContentView.setButtonContentDescription(((SimpleParams) this.KClassImpl$Data$declaredNonStaticMembers$2).KClassImpl$Data$declaredNonStaticMembers$2);
        return simpleContentView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void DatabaseTableConfigUtil() {
        super.MyBillsEntityDataFactory(2);
    }
}
