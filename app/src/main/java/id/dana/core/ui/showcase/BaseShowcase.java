package id.dana.core.ui.showcase;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import id.dana.core.ui.showcase.constant.PointerViewPositioningConstant;
import id.dana.core.ui.showcase.target.Target;
import id.dana.core.ui.showcase.view.PointerView;
import id.dana.core.ui.showcase.view.ShowcaseView;
import id.dana.core.ui.showcase.view.SkipShowCaseView;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class BaseShowcase implements Showcase {
    WeakReference<ShowcaseView> BuiltInFictitiousFunctionClassFactory;
    protected final Params KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    WeakReference<Activity> PlaceComponentResult;
    WeakReference<PointerView> getAuthRequestContext;
    private View getErrorConfigVersion;
    private OnShowcaseStateListener lookAheadTest;
    private boolean scheduleImpl;
    private boolean moveToNextValue = true;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = false;

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
    }

    protected abstract Target KClassImpl$Data$declaredNonStaticMembers$2();

    protected abstract void NetworkUserEntityData$$ExternalSyntheticLambda1();

    public int PlaceComponentResult() {
        return -2;
    }

    protected abstract View getAuthRequestContext();

    public int scheduleImpl() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseShowcase(Params params, Activity activity, OnShowcaseStateListener onShowcaseStateListener, boolean z, boolean z2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = params;
        this.PlaceComponentResult = new WeakReference<>(activity);
        this.lookAheadTest = onShowcaseStateListener;
        this.MyBillsEntityDataFactory = z;
        this.scheduleImpl = z2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseShowcase(Params params, Activity activity, OnShowcaseStateListener onShowcaseStateListener, boolean z, boolean z2, byte b) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = params;
        this.PlaceComponentResult = new WeakReference<>(activity);
        this.lookAheadTest = onShowcaseStateListener;
        this.MyBillsEntityDataFactory = z;
        this.scheduleImpl = z2;
    }

    @Override // id.dana.core.ui.showcase.Showcase
    public Showcase moveToNextValue() {
        if (getErrorConfigVersion()) {
            return this;
        }
        View decorView = this.PlaceComponentResult.get().getWindow().getDecorView();
        ShowcaseView showcaseView = new ShowcaseView(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, new OnShowcaseClickListener() { // from class: id.dana.core.ui.showcase.BaseShowcase$$ExternalSyntheticLambda1
            @Override // id.dana.core.ui.showcase.OnShowcaseClickListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                BaseShowcase.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
        });
        showcaseView.setPadding(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, 0, this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0, 0);
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.disableTransitionType(3);
        showcaseView.setLayoutTransition(layoutTransition);
        this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(showcaseView);
        PointerView pointerView = new PointerView(this.PlaceComponentResult.get(), KClassImpl$Data$declaredNonStaticMembers$2(), this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.moveToNextValue, lookAheadTest());
        pointerView.setContainerPadding(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
        pointerView.setLayoutParams(new ViewGroup.MarginLayoutParams(scheduleImpl(), PlaceComponentResult()));
        pointerView.setClickable(true);
        this.getAuthRequestContext = new WeakReference<>(pointerView);
        pointerView.addContentView(getAuthRequestContext());
        if (this.scheduleImpl) {
            SkipShowCaseView skipShowCaseView = new SkipShowCaseView(this.PlaceComponentResult.get());
            skipShowCaseView.setOnSkipButtonClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.showcase.BaseShowcase$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseShowcase.this.MyBillsEntityDataFactory();
                }
            });
            showcaseView.addView(skipShowCaseView);
        }
        ((ViewGroup) decorView).addView(showcaseView);
        if (this.MyBillsEntityDataFactory) {
            showcaseView.addView(pointerView);
        }
        if (this.BuiltInFictitiousFunctionClassFactory.get() != null) {
            this.BuiltInFictitiousFunctionClassFactory.get().startShowcase(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, new AnimatorListener() { // from class: id.dana.core.ui.showcase.BaseShowcase.1
                @Override // id.dana.core.ui.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    BaseShowcase.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.core.ui.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BaseShowcase.this.NetworkUserEntityData$$ExternalSyntheticLambda1();
                }
            });
        }
        return this;
    }

    @Override // id.dana.core.ui.showcase.Showcase
    public void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory(2);
    }

    public PointerViewPositioningConstant lookAheadTest() {
        return PointerViewPositioningConstant.DYNAMIC;
    }

    /* renamed from: id.dana.core.ui.showcase.BaseShowcase$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass3 extends AnimatorListener {
        final /* synthetic */ BaseShowcase KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ Target PlaceComponentResult;

        @Override // id.dana.core.ui.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.get().hidePointer();
        }

        @Override // id.dana.core.ui.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseShowcase.MyBillsEntityDataFactory(this.PlaceComponentResult);
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(this.PlaceComponentResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory()) {
            MyBillsEntityDataFactory(3);
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BaseShowcase baseShowcase) {
        OnShowcaseStateListener onShowcaseStateListener = baseShowcase.lookAheadTest;
        if (onShowcaseStateListener != null) {
            onShowcaseStateListener.PlaceComponentResult();
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(Target target) {
        if (target.getAuthRequestContext != null) {
            Target.OnTargetStateListener onTargetStateListener = target.getAuthRequestContext;
        }
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BaseShowcase baseShowcase, final Target target) {
        baseShowcase.BuiltInFictitiousFunctionClassFactory.get().startSpotlight(target, new AnimatorListener() { // from class: id.dana.core.ui.showcase.BaseShowcase.5
            @Override // id.dana.core.ui.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseShowcase.KClassImpl$Data$declaredNonStaticMembers$2(target);
            }
        });
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Target target) {
        if (target.getAuthRequestContext != null) {
            Target.OnTargetStateListener onTargetStateListener = target.getAuthRequestContext;
        }
    }

    public void MyBillsEntityDataFactory(final int i) {
        if (this.BuiltInFictitiousFunctionClassFactory.get() != null) {
            this.BuiltInFictitiousFunctionClassFactory.get().finishShowcase(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, new AnimatorListener() { // from class: id.dana.core.ui.showcase.BaseShowcase.2
                @Override // id.dana.core.ui.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Activity activity = BaseShowcase.this.PlaceComponentResult.get();
                    if (activity != null) {
                        ((ViewGroup) activity.getWindow().getDecorView()).removeView(BaseShowcase.this.BuiltInFictitiousFunctionClassFactory.get());
                        BaseShowcase.KClassImpl$Data$declaredNonStaticMembers$2(BaseShowcase.this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getErrorConfigVersion() {
        return this.PlaceComponentResult.get() == null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(final Target target) {
        ShowcaseView showcaseView = this.BuiltInFictitiousFunctionClassFactory.get();
        if (target.PlaceComponentResult != null) {
            if (this.getErrorConfigVersion != null) {
                this.BuiltInFictitiousFunctionClassFactory.get().removeView(this.getErrorConfigVersion);
            }
            View view = target.PlaceComponentResult;
            this.getErrorConfigVersion = view;
            showcaseView.addView(view);
        }
        if (this.getAuthRequestContext.get() != null) {
            this.getAuthRequestContext.get().showPointer(target, new AnimatorListener() { // from class: id.dana.core.ui.showcase.BaseShowcase.4
                @Override // id.dana.core.ui.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BaseShowcase.BuiltInFictitiousFunctionClassFactory(BaseShowcase.this, target);
                }
            });
        }
    }
}
