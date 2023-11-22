package id.dana.showcase;

import android.animation.Animator;
import android.app.Activity;
import android.view.View;
import id.dana.showcase.constant.PointerViewPositioningConstant;
import id.dana.showcase.target.Target;
import id.dana.showcase.view.PagerContentView;
import id.dana.showcase.view.SimpleTooltipView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class PagerShowcase extends BaseShowcase {
    private int BuiltInFictitiousFunctionClassFactory;
    private List<? extends Target> moveToNextValue;

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

    public PagerShowcase(List<? extends Target> list, Activity activity, Params params, OnShowcaseStateListener onShowcaseStateListener) {
        super(params, activity, onShowcaseStateListener);
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.moveToNextValue = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.showcase.BaseShowcase
    public final boolean lookAheadTest() {
        List<? extends Target> list;
        return super.lookAheadTest() || (list = this.moveToNextValue) == null || list.isEmpty();
    }

    public final void PlaceComponentResult(int i) {
        if (NetworkUserEntityData$$ExternalSyntheticLambda2() && KClassImpl$Data$declaredNonStaticMembers$2(i)) {
            final Target target = this.moveToNextValue.get(i);
            this.BuiltInFictitiousFunctionClassFactory = i;
            MyBillsEntityDataFactory(i);
            if (!this.MyBillsEntityDataFactory.get().hasActiveTarget()) {
                KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue.get(this.BuiltInFictitiousFunctionClassFactory));
            } else {
                this.MyBillsEntityDataFactory.get().finishSpotlight(new AnimatorListener() { // from class: id.dana.showcase.BaseShowcase.3
                    @Override // id.dana.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        BaseShowcase.this.getAuthRequestContext.get().hidePointer();
                    }

                    @Override // id.dana.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        BaseShowcase.MyBillsEntityDataFactory(target);
                        BaseShowcase.this.KClassImpl$Data$declaredNonStaticMembers$2(target);
                    }
                });
            }
        }
    }

    @Override // id.dana.showcase.BaseShowcase
    protected final View KClassImpl$Data$declaredNonStaticMembers$2() {
        PagerContentView pagerContentView = new PagerContentView(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Target> it = this.moveToNextValue.iterator();
        while (it.hasNext()) {
            Content content = it.next().PlaceComponentResult;
            arrayList.add(new SimpleTooltipView(content.KClassImpl$Data$declaredNonStaticMembers$2, content.PlaceComponentResult, content.getAuthRequestContext));
        }
        pagerContentView.setViewList(arrayList);
        pagerContentView.setPagerContentActionListener(new PagerContentView.PagerContentActionListener() { // from class: id.dana.showcase.PagerShowcase.1
            @Override // id.dana.showcase.view.PagerContentView.PagerContentActionListener
            public final void PlaceComponentResult() {
                PagerShowcase.this.BuiltInFictitiousFunctionClassFactory(1);
            }

            @Override // id.dana.showcase.view.PagerContentView.PagerContentActionListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                PagerShowcase.this.BuiltInFictitiousFunctionClassFactory(0);
            }

            @Override // id.dana.showcase.view.PagerContentView.PagerContentActionListener
            public final void PlaceComponentResult(int i) {
                PagerShowcase.this.PlaceComponentResult(i);
            }

            @Override // id.dana.showcase.view.PagerContentView.PagerContentActionListener
            public final void getAuthRequestContext() {
                PagerShowcase.this.BuiltInFictitiousFunctionClassFactory(2);
            }
        });
        pagerContentView.setScrollable(((PagerParams) this.PlaceComponentResult).BuiltInFictitiousFunctionClassFactory());
        return pagerContentView;
    }

    @Override // id.dana.showcase.BaseShowcase
    protected final void moveToNextValue() {
        PlaceComponentResult(0);
    }

    @Override // id.dana.showcase.BaseShowcase
    protected final Target BuiltInFictitiousFunctionClassFactory() {
        return this.moveToNextValue.get(this.BuiltInFictitiousFunctionClassFactory);
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return i < this.moveToNextValue.size() && i >= 0;
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return (this.moveToNextValue == null || this.MyBillsEntityDataFactory.get() == null || this.moveToNextValue.isEmpty()) ? false : true;
    }
}
