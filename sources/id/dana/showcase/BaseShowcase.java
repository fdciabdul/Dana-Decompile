package id.dana.showcase;

import android.animation.Animator;
import android.animation.LayoutTransition;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import id.dana.showcase.constant.PointerViewPositioningConstant;
import id.dana.showcase.target.Target;
import id.dana.showcase.view.PointerView;
import id.dana.showcase.view.ShowcaseView;
import id.dana.showcase.view.SkipShowCaseView;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class BaseShowcase implements Showcase {
    private int BuiltInFictitiousFunctionClassFactory;
    private View GetContactSyncConfig;
    WeakReference<Activity> KClassImpl$Data$declaredNonStaticMembers$2;
    WeakReference<ShowcaseView> MyBillsEntityDataFactory;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private OnShowcaseStateListener NetworkUserEntityData$$ExternalSyntheticLambda2;
    protected final Params PlaceComponentResult;
    WeakReference<PointerView> getAuthRequestContext;
    private int getErrorConfigVersion;
    private boolean lookAheadTest;
    private boolean moveToNextValue;
    private boolean scheduleImpl;

    protected abstract Target BuiltInFictitiousFunctionClassFactory();

    protected abstract View KClassImpl$Data$declaredNonStaticMembers$2();

    public int MyBillsEntityDataFactory() {
        return -2;
    }

    protected abstract void moveToNextValue();

    public int scheduleImpl() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseShowcase(Params params, Activity activity, OnShowcaseStateListener onShowcaseStateListener) {
        this.lookAheadTest = true;
        this.PlaceComponentResult = params;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new WeakReference<>(activity);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = onShowcaseStateListener;
        this.scheduleImpl = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.moveToNextValue = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseShowcase(Params params, Activity activity, OnShowcaseStateListener onShowcaseStateListener, byte b) {
        this.lookAheadTest = true;
        this.PlaceComponentResult = params;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new WeakReference<>(activity);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = onShowcaseStateListener;
        this.scheduleImpl = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.moveToNextValue = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseShowcase(Params params, Activity activity, OnShowcaseStateListener onShowcaseStateListener, boolean z, boolean z2) {
        this.lookAheadTest = true;
        this.PlaceComponentResult = params;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new WeakReference<>(activity);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = onShowcaseStateListener;
        this.scheduleImpl = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z2;
        this.moveToNextValue = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseShowcase(Params params, Activity activity, OnShowcaseStateListener onShowcaseStateListener, boolean z, boolean z2, int i, int i2) {
        this.lookAheadTest = true;
        this.PlaceComponentResult = params;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new WeakReference<>(activity);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = onShowcaseStateListener;
        this.scheduleImpl = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z2;
        this.moveToNextValue = false;
        this.getErrorConfigVersion = i;
        this.BuiltInFictitiousFunctionClassFactory = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseShowcase(Params params, Activity activity, OnShowcaseStateListener onShowcaseStateListener, boolean z, boolean z2, byte b) {
        this.lookAheadTest = true;
        this.PlaceComponentResult = params;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new WeakReference<>(activity);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = onShowcaseStateListener;
        this.scheduleImpl = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z2;
        this.moveToNextValue = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseShowcase(Params params, Activity activity, OnShowcaseStateListener onShowcaseStateListener, boolean z, boolean z2, boolean z3, boolean z4) {
        this.lookAheadTest = true;
        this.PlaceComponentResult = params;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new WeakReference<>(activity);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = onShowcaseStateListener;
        this.scheduleImpl = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = z2;
        this.moveToNextValue = z3;
        this.lookAheadTest = z4;
    }

    @Override // id.dana.showcase.Showcase
    public Showcase NetworkUserEntityData$$ExternalSyntheticLambda0() {
        PointerView pointerView;
        if (lookAheadTest()) {
            return this;
        }
        View decorView = this.KClassImpl$Data$declaredNonStaticMembers$2.get().getWindow().getDecorView();
        ShowcaseView showcaseView = new ShowcaseView(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, new OnShowcaseClickListener() { // from class: id.dana.showcase.BaseShowcase$$ExternalSyntheticLambda0
            @Override // id.dana.showcase.OnShowcaseClickListener
            public final void getAuthRequestContext() {
                BaseShowcase.this.getErrorConfigVersion();
            }
        });
        showcaseView.setPadding(this.PlaceComponentResult.MyBillsEntityDataFactory, 0, this.PlaceComponentResult.scheduleImpl, 0);
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.disableTransitionType(3);
        showcaseView.setLayoutTransition(layoutTransition);
        this.MyBillsEntityDataFactory = new WeakReference<>(showcaseView);
        if (this.BuiltInFictitiousFunctionClassFactory != 0 && this.getErrorConfigVersion != 0) {
            pointerView = new PointerView(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), BuiltInFictitiousFunctionClassFactory(), this.moveToNextValue, this.lookAheadTest, getAuthRequestContext(), this.getErrorConfigVersion, this.BuiltInFictitiousFunctionClassFactory);
        } else {
            pointerView = new PointerView(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), BuiltInFictitiousFunctionClassFactory(), this.moveToNextValue, this.lookAheadTest, getAuthRequestContext());
        }
        pointerView.setContainerPadding(this.PlaceComponentResult.getAuthRequestContext);
        pointerView.setLayoutParams(new ViewGroup.MarginLayoutParams(scheduleImpl(), MyBillsEntityDataFactory()));
        pointerView.setClickable(true);
        this.getAuthRequestContext = new WeakReference<>(pointerView);
        pointerView.addContentView(KClassImpl$Data$declaredNonStaticMembers$2());
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            SkipShowCaseView skipShowCaseView = new SkipShowCaseView(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
            skipShowCaseView.setOnSkipButtonClickListener(new View.OnClickListener() { // from class: id.dana.showcase.BaseShowcase$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseShowcase.this.PlaceComponentResult();
                }
            });
            showcaseView.addView(skipShowCaseView);
        }
        ((ViewGroup) decorView).addView(showcaseView);
        if (this.scheduleImpl) {
            showcaseView.addView(pointerView);
        }
        if (this.MyBillsEntityDataFactory.get() != null) {
            this.MyBillsEntityDataFactory.get().startShowcase(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult.PlaceComponentResult, new AnimatorListener() { // from class: id.dana.showcase.BaseShowcase.1
                @Override // id.dana.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    BaseShowcase.MyBillsEntityDataFactory(BaseShowcase.this);
                }

                @Override // id.dana.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BaseShowcase.this.moveToNextValue();
                }
            });
        }
        return this;
    }

    @Override // id.dana.showcase.Showcase
    public void PlaceComponentResult() {
        BuiltInFictitiousFunctionClassFactory(2);
    }

    public PointerViewPositioningConstant getAuthRequestContext() {
        return PointerViewPositioningConstant.DYNAMIC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(int i) {
        OnShowcaseStateListener onShowcaseStateListener = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (onShowcaseStateListener != null) {
            onShowcaseStateListener.onTargetSelected(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void getErrorConfigVersion() {
        if (this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2()) {
            BuiltInFictitiousFunctionClassFactory(3);
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(BaseShowcase baseShowcase) {
        OnShowcaseStateListener onShowcaseStateListener = baseShowcase.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (onShowcaseStateListener != null) {
            onShowcaseStateListener.onStarted();
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BaseShowcase baseShowcase, int i) {
        OnShowcaseStateListener onShowcaseStateListener = baseShowcase.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (onShowcaseStateListener != null) {
            onShowcaseStateListener.onFinished(i);
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(Target target) {
        if (target.getAuthRequestContext != null) {
            Target.OnTargetStateListener onTargetStateListener = target.getAuthRequestContext;
        }
    }

    static /* synthetic */ void getAuthRequestContext(BaseShowcase baseShowcase, final Target target) {
        baseShowcase.MyBillsEntityDataFactory.get().startSpotlight(target, new AnimatorListener() { // from class: id.dana.showcase.BaseShowcase.5
            @Override // id.dana.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BaseShowcase.getAuthRequestContext(target);
            }
        });
    }

    static /* synthetic */ void getAuthRequestContext(Target target) {
        if (target.getAuthRequestContext != null) {
            Target.OnTargetStateListener onTargetStateListener = target.getAuthRequestContext;
        }
    }

    public void BuiltInFictitiousFunctionClassFactory(final int i) {
        if (this.MyBillsEntityDataFactory.get() != null) {
            this.MyBillsEntityDataFactory.get().finishShowcase(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult.PlaceComponentResult, new AnimatorListener() { // from class: id.dana.showcase.BaseShowcase.2
                @Override // id.dana.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Activity activity = BaseShowcase.this.KClassImpl$Data$declaredNonStaticMembers$2.get();
                    if (activity != null) {
                        ((ViewGroup) activity.getWindow().getDecorView()).removeView(BaseShowcase.this.MyBillsEntityDataFactory.get());
                        BaseShowcase.KClassImpl$Data$declaredNonStaticMembers$2(BaseShowcase.this, i);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean lookAheadTest() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.get() == null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final Target target) {
        ShowcaseView showcaseView = this.MyBillsEntityDataFactory.get();
        if (target.scheduleImpl != null) {
            if (this.GetContactSyncConfig != null) {
                this.MyBillsEntityDataFactory.get().removeView(this.GetContactSyncConfig);
            }
            View view = target.scheduleImpl;
            this.GetContactSyncConfig = view;
            showcaseView.addView(view);
        }
        if (this.getAuthRequestContext.get() != null) {
            this.getAuthRequestContext.get().showPointer(target, new AnimatorListener() { // from class: id.dana.showcase.BaseShowcase.4
                @Override // id.dana.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BaseShowcase.getAuthRequestContext(BaseShowcase.this, target);
                }
            });
        }
    }
}
