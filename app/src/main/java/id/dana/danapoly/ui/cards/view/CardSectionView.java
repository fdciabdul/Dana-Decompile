package id.dana.danapoly.ui.cards.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.showcase.AnimatorListener;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.ViewCardSectionBinding;
import id.dana.danapoly.ui.model.CardItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010+\u001a\u00020)¢\u0006\u0004\b,\u0010-J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u0005J\u001b\u0010\u000b\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u001b\u0010\u0011\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R.\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00030\u00198\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR4\u0010$\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u00030\u00198\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001f"}, d2 = {"Lid/dana/danapoly/ui/cards/view/CardSectionView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/danapoly/databinding/ViewCardSectionBinding;", "", "hideSection", "()V", "inflateViewBinding", "()Lid/dana/danapoly/databinding/ViewCardSectionBinding;", "onCollapse", "Lkotlin/Function0;", "onFinishExpand", "onExpand", "(Lkotlin/jvm/functions/Function0;)V", "setup", "", "Lid/dana/danapoly/ui/model/CardItemModel;", "cards", "showCardItems", "(Ljava/util/List;)V", "Landroid/widget/LinearLayout;", "PlaceComponentResult", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "", "MyBillsEntityDataFactory", "Lkotlin/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "getOnCardItemClicked", "()Lkotlin/jvm/functions/Function1;", "setOnCardItemClicked", "(Lkotlin/jvm/functions/Function1;)V", "onCardItemClicked", "getAuthRequestContext", "getOnExpandClicked", "setOnExpandClicked", "onExpandClicked", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardSectionView extends BaseViewBindingRichView<ViewCardSectionBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function1<? super CardItemModel, Unit> onCardItemClicked;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final List<CardItemModel> PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final List<LinearLayout> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Function1<? super List<CardItemModel>, Unit> onExpandClicked;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardSectionView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardSectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardSectionView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ CardSectionView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardSectionView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this.onCardItemClicked = new Function1<CardItemModel, Unit>() { // from class: id.dana.danapoly.ui.cards.view.CardSectionView$onCardItemClicked$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CardItemModel cardItemModel) {
                Intrinsics.checkNotNullParameter(cardItemModel, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CardItemModel cardItemModel) {
                invoke2(cardItemModel);
                return Unit.INSTANCE;
            }
        };
        this.onExpandClicked = new Function1<List<? extends CardItemModel>, Unit>() { // from class: id.dana.danapoly.ui.cards.view.CardSectionView$onExpandClicked$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<CardItemModel> list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends CardItemModel> list) {
                invoke2((List<CardItemModel>) list);
                return Unit.INSTANCE;
            }
        };
        this.BuiltInFictitiousFunctionClassFactory = CollectionsKt.listOf((Object[]) new LinearLayout[]{getBinding().BuiltInFictitiousFunctionClassFactory, getBinding().MyBillsEntityDataFactory, getBinding().KClassImpl$Data$declaredNonStaticMembers$2});
        this.PlaceComponentResult = new ArrayList();
    }

    @JvmName(name = "getOnCardItemClicked")
    public final Function1<CardItemModel, Unit> getOnCardItemClicked() {
        return this.onCardItemClicked;
    }

    @JvmName(name = "setOnCardItemClicked")
    public final void setOnCardItemClicked(Function1<? super CardItemModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.onCardItemClicked = function1;
    }

    @JvmName(name = "getOnExpandClicked")
    public final Function1<List<CardItemModel>, Unit> getOnExpandClicked() {
        return this.onExpandClicked;
    }

    @JvmName(name = "setOnExpandClicked")
    public final void setOnExpandClicked(Function1<? super List<CardItemModel>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.onExpandClicked = function1;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewCardSectionBinding inflateViewBinding() {
        ViewCardSectionBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewCardSectionBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void onExpand(final Function0<Unit> onFinishExpand) {
        Intrinsics.checkNotNullParameter(onFinishExpand, "");
        Iterator<T> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            View childAt = ((LinearLayout) it.next()).getChildAt(0);
            CardItemView cardItemView = childAt instanceof CardItemView ? (CardItemView) childAt : null;
            if (cardItemView != null) {
                cardItemView.renderNormalView();
            }
        }
        LottieAnimationView lottieAnimationView = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
        lottieAnimationView.setVisibility(8);
        getBinding().moveToNextValue.setTransition(R.id.res_0x7f0a06b0_summaryvoucherview_externalsyntheticlambda1);
        getBinding().moveToNextValue.transitionToEnd(new Runnable() { // from class: id.dana.danapoly.ui.cards.view.CardSectionView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                CardSectionView.$r8$lambda$zNFek0UjgnRxnFvvS44pHlXghtE(CardSectionView.this, onFinishExpand);
            }
        });
    }

    public final void onCollapse() {
        Iterator<T> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            View childAt = ((LinearLayout) it.next()).getChildAt(0);
            CardItemView cardItemView = childAt instanceof CardItemView ? (CardItemView) childAt : null;
            if (cardItemView != null) {
                cardItemView.renderStackedView();
            }
        }
        getBinding().moveToNextValue.setTransition(R.id.collapseCardStep2to1);
        getBinding().moveToNextValue.transitionToEnd(new Runnable() { // from class: id.dana.danapoly.ui.cards.view.CardSectionView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                CardSectionView.$r8$lambda$meVnm7e7nU6Srsi7lVsBkgFoaNw(CardSectionView.this);
            }
        });
    }

    public final void hideSection() {
        MotionLayout motionLayout = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(motionLayout, "");
        motionLayout.setVisibility(8);
    }

    public final void showCardItems(List<CardItemModel> cards) {
        Intrinsics.checkNotNullParameter(cards, "");
        if (cards.isEmpty()) {
            MotionLayout motionLayout = getBinding().moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(motionLayout, "");
            motionLayout.setVisibility(8);
        }
        if (cards.size() > 1) {
            AppCompatImageView appCompatImageView = getBinding().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            ViewExtKt.PlaceComponentResult(appCompatImageView, 0);
            getBinding().getAuthRequestContext.bringToFront();
        } else {
            AppCompatImageView appCompatImageView2 = getBinding().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
            ViewExtKt.PlaceComponentResult(appCompatImageView2, 8);
        }
        this.PlaceComponentResult.clear();
        Iterator<T> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            LinearLayout linearLayout = (LinearLayout) it.next();
            LinearLayout linearLayout2 = linearLayout instanceof ViewGroup ? linearLayout : null;
            if (linearLayout2 != null) {
                int childCount = linearLayout2.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    linearLayout2.removeViewAt(i);
                }
            }
        }
        int i2 = 0;
        for (Object obj : this.BuiltInFictitiousFunctionClassFactory) {
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LinearLayout linearLayout3 = (LinearLayout) obj;
            if (i2 > cards.size() - 1) {
                return;
            }
            this.PlaceComponentResult.add(cards.get(i2));
            CardItemModel cardItemModel = cards.get(i2);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            CardItemView cardItemView = new CardItemView(context, null, 0, 0, 14, null);
            cardItemView.setCard(cardItemModel);
            cardItemView.setOnCardItemClicked(this.onCardItemClicked);
            cardItemView.setStackIndex(i2);
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "");
            LinearLayout linearLayout4 = linearLayout3 instanceof ViewGroup ? linearLayout3 : null;
            if (linearLayout4 != null) {
                int childCount2 = linearLayout4.getChildCount();
                for (int i3 = 0; i3 < childCount2; i3++) {
                    linearLayout4.removeViewAt(i3);
                }
                linearLayout4.addView(cardItemView);
            }
            i2++;
        }
    }

    public static /* synthetic */ void $r8$lambda$1BGZhFAn8cpS_HTrUsXhKazNTIk(CardSectionView cardSectionView, View view) {
        Intrinsics.checkNotNullParameter(cardSectionView, "");
        cardSectionView.onExpandClicked.invoke(cardSectionView.PlaceComponentResult);
    }

    public static /* synthetic */ void $r8$lambda$C6IaUoTaemD1OGwPZPBPwdMaX54(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }

    public static /* synthetic */ void $r8$lambda$meVnm7e7nU6Srsi7lVsBkgFoaNw(final CardSectionView cardSectionView) {
        Intrinsics.checkNotNullParameter(cardSectionView, "");
        AppCompatImageView appCompatImageView = cardSectionView.getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(8);
        final LottieAnimationView lottieAnimationView = cardSectionView.getBinding().PlaceComponentResult;
        lottieAnimationView.bringToFront();
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.addAnimatorListener(new AnimatorListener() { // from class: id.dana.danapoly.ui.cards.view.CardSectionView$onCollapse$2$1$1
            @Override // id.dana.core.ui.showcase.AnimatorListener, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator p0) {
                ViewCardSectionBinding binding;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onAnimationEnd(p0);
                LottieAnimationView lottieAnimationView2 = LottieAnimationView.this;
                Intrinsics.checkNotNullExpressionValue(lottieAnimationView2, "");
                lottieAnimationView2.setVisibility(8);
                binding = cardSectionView.getBinding();
                AppCompatImageView appCompatImageView2 = binding.getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                appCompatImageView2.setVisibility(0);
            }
        });
        lottieAnimationView.playAnimation();
        Iterator<T> it = cardSectionView.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            View childAt = ((LinearLayout) it.next()).getChildAt(0);
            CardItemView cardItemView = childAt instanceof CardItemView ? (CardItemView) childAt : null;
            if (cardItemView != null) {
                cardItemView.checkIfNeedToShowStackPreview();
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$zNFek0UjgnRxnFvvS44pHlXghtE(CardSectionView cardSectionView, final Function0 function0) {
        Intrinsics.checkNotNullParameter(cardSectionView, "");
        Intrinsics.checkNotNullParameter(function0, "");
        cardSectionView.getBinding().moveToNextValue.setTransition(R.id.expandCardStep3to4);
        cardSectionView.getBinding().moveToNextValue.transitionToEnd(new Runnable() { // from class: id.dana.danapoly.ui.cards.view.CardSectionView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                CardSectionView.$r8$lambda$C6IaUoTaemD1OGwPZPBPwdMaX54(Function0.this);
            }
        });
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        LocaleUtil localeUtil = LocaleUtil.INSTANCE;
        getBinding().PlaceComponentResult.setAnimation(LocaleUtil.PlaceComponentResult() ? "json/lottie/wallet_expand_detail_page_id.lottie" : "json/lottie/wallet_expand_detail_page_en.lottie");
        ViewCardSectionBinding binding = getBinding();
        binding.KClassImpl$Data$declaredNonStaticMembers$2.bringToFront();
        binding.MyBillsEntityDataFactory.bringToFront();
        binding.BuiltInFictitiousFunctionClassFactory.bringToFront();
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.cards.view.CardSectionView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardSectionView.$r8$lambda$1BGZhFAn8cpS_HTrUsXhKazNTIk(CardSectionView.this, view);
            }
        });
    }
}
