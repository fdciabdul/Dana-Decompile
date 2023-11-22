package id.dana.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.Transition;
import at.wirecube.additiveanimations.additive_animator.AdditiveAnimator;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.richview.boundcard.BoundCardView;
import id.dana.richview.boundcard.DanaBalanceCardView;
import id.dana.richview.boundcard.DebitCardView;
import id.dana.richview.boundcard.model.BoundCard;
import id.dana.utils.AnimationUtil;
import id.dana.utils.ConstraintUtils;
import id.dana.utils.SizeUtil;

/* loaded from: classes9.dex */
public class PaymentCardsView extends BaseRichView {
    private int BuiltInFictitiousFunctionClassFactory;
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private BoundCard PlaceComponentResult;
    @BindView(R.id.bcv_cards)
    BoundCardView bcvPaymentMethod;
    @BindView(R.id.cl_choosen_card_swapper)
    ConstraintLayout clChoosenCardSwapper;
    @BindView(R.id.cl_highlighted_card_swapper)
    ConstraintLayout clHighlightedCardSwapper;
    @BindView(R.id.cl_main_parent)
    ConstraintLayout clMainParent;
    @BindView(R.id.dbv_card)
    DanaBalanceCardView dbvCard;
    @BindView(R.id.dbv_choosen_card_swapper)
    DanaBalanceCardView dbvChoosenCardSwapper;
    @BindView(R.id.dbv_highlighted_card_swapper)
    DanaBalanceCardView dbvHighlightedCardSwapper;
    @BindView(R.id.dcv_choosen_card_swapper)
    DebitCardView dcvChoosenCardSwapper;
    @BindView(R.id.dcv_debit)
    DebitCardView dcvDebit;
    @BindView(R.id.dcv_highlighted_card_swapper)
    DebitCardView dcvHighlightedCardSwapper;
    private View getAuthRequestContext;
    @BindView(R.id.ll_single_card)
    LinearLayout llSingleCard;
    @BindView(R.id.view_dummy)
    View viewDummy;

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_payment_cards;
    }

    public PaymentCardsView(Context context) {
        super(context);
    }

    public PaymentCardsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PaymentCardsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PaymentCardsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        ConstraintUtils.KClassImpl$Data$declaredNonStaticMembers$2(new ConstraintUtils.TransitionListener() { // from class: id.dana.richview.PaymentCardsView.1
            @Override // id.dana.utils.ConstraintUtils.TransitionListener, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                PaymentCardsView.access$000(PaymentCardsView.this);
            }
        });
        this.llSingleCard.setLayoutAnimationListener(new AnimationUtil.AnimationListener() { // from class: id.dana.richview.PaymentCardsView.2
            @Override // id.dana.utils.AnimationUtil.AnimationListener, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PaymentCardsView.access$000(PaymentCardsView.this);
            }
        });
        this.dbvCard.initListener(new DanaBalanceCardView.OnBalanceCardViewListener() { // from class: id.dana.richview.PaymentCardsView$$ExternalSyntheticLambda1
            @Override // id.dana.richview.boundcard.DanaBalanceCardView.OnBalanceCardViewListener
            public final void getAuthRequestContext() {
                PaymentCardsView.this.m2812lambda$initBalanceCard$0$iddanarichviewPaymentCardsView();
            }
        });
        this.bcvPaymentMethod.initListener(new BoundCardView.OnBoundCardViewListener() { // from class: id.dana.richview.PaymentCardsView.3
            @Override // id.dana.richview.boundcard.BoundCardView.OnBoundCardViewListener
            public final void BuiltInFictitiousFunctionClassFactory(BoundCard boundCard) {
                PaymentCardsView.this.PlaceComponentResult(boundCard);
            }

            @Override // id.dana.richview.boundcard.BoundCardView.OnBoundCardViewListener
            public final void getAuthRequestContext(BoundCard boundCard, View view) {
                PaymentCardsView.this.PlaceComponentResult = boundCard;
                PaymentCardsView.access$400(PaymentCardsView.this, view, SizeUtil.KClassImpl$Data$declaredNonStaticMembers$2(view) - PaymentCardsView.this.BuiltInFictitiousFunctionClassFactory);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initBalanceCard$0$id-dana-richview-PaymentCardsView  reason: not valid java name */
    public /* synthetic */ void m2812lambda$initBalanceCard$0$iddanarichviewPaymentCardsView() {
        BoundCardView boundCardView = this.bcvPaymentMethod;
        if (boundCardView != null) {
            boundCardView.getBoundCards();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PlaceComponentResult(BoundCard boundCard) {
        DanaBalanceCardView danaBalanceCardView;
        if (boundCard != null && boundCard.KClassImpl$Data$declaredNonStaticMembers$2()) {
            DebitCardView debitCardView = this.dcvDebit;
            if (debitCardView != null && this.dbvCard != null) {
                debitCardView.setVisibility(8);
                this.dbvCard.setVisibility(0);
                this.dbvCard.setData(boundCard);
            }
        } else if (this.dcvDebit != null && (danaBalanceCardView = this.dbvCard) != null) {
            danaBalanceCardView.setVisibility(8);
            this.dcvDebit.setVisibility(0);
            this.dcvDebit.setData(boundCard);
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
            this.llSingleCard.post(new Runnable() { // from class: id.dana.richview.PaymentCardsView$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    PaymentCardsView.this.m2815x9170af2d();
                }
            });
            this.llSingleCard.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startExpandingAnimation$1$id-dana-richview-PaymentCardsView  reason: not valid java name */
    public /* synthetic */ void m2815x9170af2d() {
        LinearLayout linearLayout;
        if (getVisibility() != 0 || (linearLayout = this.llSingleCard) == null) {
            return;
        }
        this.MyBillsEntityDataFactory = true;
        linearLayout.startLayoutAnimation();
        BoundCardView boundCardView = this.bcvPaymentMethod;
        if (boundCardView != null) {
            boundCardView.post(new Runnable() { // from class: id.dana.richview.PaymentCardsView$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    PaymentCardsView.this.m2813x2ba6175c();
                }
            });
            this.bcvPaymentMethod.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startCardListExpandingAnimation$2$id-dana-richview-PaymentCardsView  reason: not valid java name */
    public /* synthetic */ void m2813x2ba6175c() {
        BoundCardView boundCardView = this.bcvPaymentMethod;
        if (boundCardView != null) {
            boundCardView.startExpandingAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startCloseAnimation$3$id-dana-richview-PaymentCardsView  reason: not valid java name */
    public /* synthetic */ void m2814lambda$startCloseAnimation$3$iddanarichviewPaymentCardsView() {
        this.bcvPaymentMethod.startCloseAnimation();
        ConstraintUtils.BuiltInFictitiousFunctionClassFactory(this.llSingleCard, this.clMainParent);
        ConstraintUtils.KClassImpl$Data$declaredNonStaticMembers$2(this.llSingleCard, this.clMainParent);
        ConstraintUtils.getAuthRequestContext(this.llSingleCard, this.clMainParent);
    }

    public void closeClicked() {
        this.bcvPaymentMethod.setCloseAnimation();
        if (this.MyBillsEntityDataFactory) {
            return;
        }
        this.MyBillsEntityDataFactory = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 2;
        this.llSingleCard.post(new Runnable() { // from class: id.dana.richview.PaymentCardsView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PaymentCardsView.this.m2814lambda$startCloseAnimation$3$iddanarichviewPaymentCardsView();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startSwappingCardAnimation$4$id-dana-richview-PaymentCardsView  reason: not valid java name */
    public /* synthetic */ void m2816x858a12f9(int i) {
        ((AdditiveAnimator) AdditiveAnimator.getAuthRequestContext(this.clChoosenCardSwapper).BuiltInFictitiousFunctionClassFactory(0).MyBillsEntityDataFactory(300L)).KClassImpl$Data$declaredNonStaticMembers$2();
        AnimationUtil.MyBillsEntityDataFactory(this.clHighlightedCardSwapper);
        ConstraintUtils.getAuthRequestContext(this.clChoosenCardSwapper, this.clMainParent, true);
        ConstraintUtils.KClassImpl$Data$declaredNonStaticMembers$2(this.clHighlightedCardSwapper, this.clMainParent, true, i);
    }

    public void setParentPosY(int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    private void BuiltInFictitiousFunctionClassFactory(boolean z) {
        this.dcvHighlightedCardSwapper.setVisibility(z ? 4 : 0);
        this.dbvHighlightedCardSwapper.setVisibility(z ? 0 : 4);
    }

    private void PlaceComponentResult(boolean z) {
        this.dcvChoosenCardSwapper.setVisibility(z ? 4 : 0);
        this.dbvChoosenCardSwapper.setVisibility(z ? 0 : 4);
    }

    public void setEntryPoint(String str) {
        this.dbvCard.setEntryPoint(str);
        this.dbvChoosenCardSwapper.setEntryPoint(str);
        this.dbvHighlightedCardSwapper.setEntryPoint(str);
        this.bcvPaymentMethod.setEntryPoint(str);
    }

    static /* synthetic */ void access$000(PaymentCardsView paymentCardsView) {
        int i = paymentCardsView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i == 0) {
            paymentCardsView.MyBillsEntityDataFactory = false;
            paymentCardsView.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
        } else if (i != 1) {
            BoundCardView boundCardView = paymentCardsView.bcvPaymentMethod;
            if (boundCardView != null) {
                boundCardView.setVisibility(4);
            }
            LinearLayout linearLayout = paymentCardsView.llSingleCard;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            BaseActivity baseActivity = paymentCardsView.getBaseActivity();
            if (baseActivity != null) {
                baseActivity.finish();
            }
        } else {
            View view = paymentCardsView.getAuthRequestContext;
            if (view != null) {
                view.setVisibility(0);
                paymentCardsView.llSingleCard.setVisibility(0);
                paymentCardsView.getAuthRequestContext = null;
            }
            ConstraintLayout constraintLayout = paymentCardsView.clHighlightedCardSwapper;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(4);
                ConstraintLayout constraintLayout2 = paymentCardsView.clChoosenCardSwapper;
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(4);
                    ConstraintUtils.getAuthRequestContext(paymentCardsView.clHighlightedCardSwapper, paymentCardsView.clMainParent, false);
                    ConstraintUtils.getAuthRequestContext(paymentCardsView.clChoosenCardSwapper, paymentCardsView.clMainParent, false);
                }
            }
            paymentCardsView.MyBillsEntityDataFactory = false;
            paymentCardsView.PlaceComponentResult(paymentCardsView.PlaceComponentResult);
            BoundCardView boundCardView2 = paymentCardsView.bcvPaymentMethod;
            if (boundCardView2 != null) {
                boundCardView2.onCardSwapped();
            }
        }
    }

    static /* synthetic */ void access$400(final PaymentCardsView paymentCardsView, View view, final int i) {
        if (paymentCardsView.MyBillsEntityDataFactory) {
            return;
        }
        paymentCardsView.getAuthRequestContext = view;
        view.setVisibility(4);
        ConstraintUtils.KClassImpl$Data$declaredNonStaticMembers$2(paymentCardsView.clChoosenCardSwapper, paymentCardsView.clMainParent, false, i);
        if (paymentCardsView.dbvCard.getVisibility() == 0) {
            paymentCardsView.dbvHighlightedCardSwapper.setData(paymentCardsView.dbvCard.getKClassImpl$Data$declaredNonStaticMembers$2());
            paymentCardsView.BuiltInFictitiousFunctionClassFactory(true);
        } else if (paymentCardsView.dcvDebit.getVisibility() == 0) {
            paymentCardsView.dcvHighlightedCardSwapper.setData(paymentCardsView.dcvDebit.getData());
            paymentCardsView.BuiltInFictitiousFunctionClassFactory(false);
        }
        BoundCard boundCard = paymentCardsView.PlaceComponentResult;
        if (boundCard != null && boundCard.KClassImpl$Data$declaredNonStaticMembers$2()) {
            paymentCardsView.dbvChoosenCardSwapper.setData(paymentCardsView.PlaceComponentResult);
            paymentCardsView.PlaceComponentResult(true);
        } else {
            paymentCardsView.dcvChoosenCardSwapper.setData(paymentCardsView.PlaceComponentResult);
            paymentCardsView.dbvChoosenCardSwapper.setVisibility(4);
            paymentCardsView.dcvChoosenCardSwapper.setVisibility(0);
            paymentCardsView.PlaceComponentResult(false);
        }
        paymentCardsView.clHighlightedCardSwapper.setVisibility(0);
        paymentCardsView.MyBillsEntityDataFactory = true;
        view.setVisibility(4);
        paymentCardsView.llSingleCard.setVisibility(4);
        paymentCardsView.clChoosenCardSwapper.post(new Runnable() { // from class: id.dana.richview.PaymentCardsView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                PaymentCardsView.this.m2816x858a12f9(i);
            }
        });
        paymentCardsView.clHighlightedCardSwapper.setVisibility(0);
        paymentCardsView.clChoosenCardSwapper.setVisibility(0);
        paymentCardsView.clChoosenCardSwapper.setAlpha(0.0f);
    }
}
