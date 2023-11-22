package id.dana.cardbinding.view;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Executors;
import id.dana.R;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.base.BaseRichView;
import id.dana.cashier.model.QueryCardPolicyInfoModel;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.core.ui.glide.GlideRequests;
import id.dana.data.constant.DanaUrl;
import id.dana.utils.ImageResize;
import id.dana.utils.TextUtil;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 E2\u00020\u0001:\u0001EB'\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\u000e¢\u0006\u0004\b@\u0010AB+\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010>\u001a\u0004\u0018\u00010=\u0012\u0006\u0010B\u001a\u00020\u000e\u0012\u0006\u0010C\u001a\u00020\u000e¢\u0006\u0004\b@\u0010DJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0011¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\"J!\u0010%\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010$\u001a\u00020\u0011¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0002¢\u0006\u0004\b(\u0010\u001dJ\u0015\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\b*\u0010\u001dJ\u0015\u0010,\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0002¢\u0006\u0004\b,\u0010\u001dJ\u000f\u0010-\u001a\u00020\u000bH\u0016¢\u0006\u0004\b-\u0010\"R\"\u00103\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u0010\u001dR\"\u00109\u001a\u00020\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u0010 R\u0013\u00104\u001a\u00020:X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b;\u0010<"}, d2 = {"Lid/dana/cardbinding/view/CardView;", "Lid/dana/base/BaseRichView;", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/view/View;", "visibleView", "inVisibleView", "", "flipCard", "(Landroid/content/Context;Landroid/view/View;Landroid/view/View;)V", "", "getLayout", "()I", "", "isReverse", "Lkotlin/Function0;", "setBackground", "performCardAnimation", "(ZLkotlin/jvm/functions/Function0;)V", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "queryCardPolicyInfoModel", "setCardBankBackground", "(Lid/dana/cashier/model/QueryCardPolicyInfoModel;)V", "instId", "setCardBankLogo", "(Ljava/lang/String;)V", "defaultColor", "setCardBankTextColor", "(Z)V", "setCardBankToDefault", "()V", "cardSchemeIcon", "isOneKlik", "setCardScheme", "(Ljava/lang/String;Z)V", "cardType", "setCardType", "inputNumberDate", "setTextViewCardDate", "inputNumberCard", "setTextViewCardNumber", "setup", "MyBillsEntityDataFactory", "Ljava/lang/String;", "getCurrentBankBackground", "()Ljava/lang/String;", "setCurrentBankBackground", "currentBankBackground", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "getHasPerfromCardAnimate", "()Z", "setHasPerfromCardAnimate", "hasPerfromCardAnimate", "Landroidx/transition/AutoTransition;", "PlaceComponentResult", "Lkotlin/Lazy;", "Landroid/util/AttributeSet;", "attrs", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CardView extends BaseRichView {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean hasPerfromCardAnimate;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String currentBankBackground;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_binding_card;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    @JvmName(name = "getCurrentBankBackground")
    public final String getCurrentBankBackground() {
        return this.currentBankBackground;
    }

    @JvmName(name = "setCurrentBankBackground")
    public final void setCurrentBankBackground(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.currentBankBackground = str;
    }

    @JvmName(name = "getHasPerfromCardAnimate")
    public final boolean getHasPerfromCardAnimate() {
        return this.hasPerfromCardAnimate;
    }

    @JvmName(name = "setHasPerfromCardAnimate")
    public final void setHasPerfromCardAnimate(boolean z) {
        this.hasPerfromCardAnimate = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.currentBankBackground = "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(CardView$transition$2.INSTANCE);
    }

    public /* synthetic */ CardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.currentBankBackground = "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(CardView$transition$2.INSTANCE);
    }

    public static /* synthetic */ void performCardAnimation$default(CardView cardView, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        cardView.performCardAnimation(z, function0);
    }

    public final void performCardAnimation(boolean isReverse, Function0<Unit> setBackground) {
        float f;
        Intrinsics.checkNotNullParameter(setBackground, "");
        TransitionManager.getAuthRequestContext((ConstraintLayout) _$_findCachedViewById(R.id.getMissionActiveImage).findViewById(R.id.res_0x7f0a0380_setindex_kotlin_stdlib), (AutoTransition) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
        setBackground.invoke();
        if (isReverse) {
            f = ((ConstraintLayout) _$_findCachedViewById(R.id.getMissionActiveImage).findViewById(R.id.res_0x7f0a0380_setindex_kotlin_stdlib)).getWidth();
        } else {
            f = -((ConstraintLayout) _$_findCachedViewById(R.id.getMissionActiveImage).findViewById(R.id.res_0x7f0a0380_setindex_kotlin_stdlib)).getWidth();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((AppCompatImageView) _$_findCachedViewById(R.id.getMissionActiveImage).findViewById(R.id.MenuItemActionViewCollapseEvent), "translationX", f, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String BuiltInFictitiousFunctionClassFactory(String p0) {
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String lowerCase = p0.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        String format = String.format(DanaUrl.BANK_BACKGROUND_URL, Arrays.copyOf(new Object[]{lowerCase}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    public final void setCardBankLogo(String instId) {
        String str;
        Object[] objArr = new Object[1];
        if (instId != null) {
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "");
            str = instId.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "");
        } else {
            str = null;
        }
        objArr[0] = str;
        String format = String.format(DanaUrl.BANK_LOGO_LIGHT_URL, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(format).BuiltInFictitiousFunctionClassFactory(new RequestListener<Drawable>() { // from class: id.dana.cardbinding.view.CardView$setCardBankLogo$1
            @Override // com.bumptech.glide.request.RequestListener
            public final /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                return getAuthRequestContext();
            }

            @Override // com.bumptech.glide.request.RequestListener
            public final boolean onLoadFailed(GlideException p0, Object p1, Target<Drawable> p2, boolean p3) {
                ((AppCompatImageView) CardView.this._$_findCachedViewById(R.id.mirrorYUV420)).setVisibility(4);
                ((AppCompatImageView) CardView.this._$_findCachedViewById(R.id.res_0x7f0a09ef_dropshadowkeyframeanimation_1)).setVisibility(0);
                return false;
            }

            private boolean getAuthRequestContext() {
                ((AppCompatImageView) CardView.this._$_findCachedViewById(R.id.mirrorYUV420)).setVisibility(0);
                ((AppCompatImageView) CardView.this._$_findCachedViewById(R.id.res_0x7f0a09ef_dropshadowkeyframeanimation_1)).setVisibility(4);
                return false;
            }
        }).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.mirrorYUV420)));
    }

    public final void setCardBankTextColor(boolean defaultColor) {
        if (defaultColor) {
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2((TextView) _$_findCachedViewById(R.id.clearPyGenericServices), (int) R.style.f49852132017439);
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2((TextView) _$_findCachedViewById(R.id.ProductProfileKeys), (int) R.style.f49912132017451);
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2((TextView) _$_findCachedViewById(R.id.BranchModule), (int) R.style.f49912132017451);
            return;
        }
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2((TextView) _$_findCachedViewById(R.id.clearPyGenericServices), (int) R.style.f49842132017438);
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2((TextView) _$_findCachedViewById(R.id.ProductProfileKeys), (int) R.style.f49902132017450);
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2((TextView) _$_findCachedViewById(R.id.BranchModule), (int) R.style.f49902132017450);
    }

    public final void setTextViewCardNumber(String inputNumberCard) {
        Intrinsics.checkNotNullParameter(inputNumberCard, "");
        String BuiltInFictitiousFunctionClassFactory = TextUtil.BuiltInFictitiousFunctionClassFactory(inputNumberCard, inputNumberCard.length());
        if (BuiltInFictitiousFunctionClassFactory == null || BuiltInFictitiousFunctionClassFactory.length() == 0) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.ProductProfileKeys);
            if (textView != null) {
                textView.setText(getContext().getString(R.string.card_binding_default_debit_number));
                return;
            }
            return;
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.ProductProfileKeys);
        if (textView2 != null) {
            textView2.setText(BuiltInFictitiousFunctionClassFactory);
        }
    }

    public final void setTextViewCardDate(String inputNumberDate) {
        Intrinsics.checkNotNullParameter(inputNumberDate, "");
        String KClassImpl$Data$declaredNonStaticMembers$2 = TextUtil.KClassImpl$Data$declaredNonStaticMembers$2(inputNumberDate, inputNumberDate.length());
        if (inputNumberDate.length() == 0) {
            TextView textView = (TextView) _$_findCachedViewById(R.id.BranchModule);
            if (textView != null) {
                Context context = getContext();
                textView.setText(context != null ? context.getString(R.string.card_binding_default_thru_date) : null);
            }
        } else if (inputNumberDate.length() == 4) {
            StringBuilder deleteCharAt = new StringBuilder(KClassImpl$Data$declaredNonStaticMembers$2).deleteCharAt(KClassImpl$Data$declaredNonStaticMembers$2.length() - 1);
            TextView textView2 = (TextView) _$_findCachedViewById(R.id.BranchModule);
            if (textView2 != null) {
                textView2.setText(deleteCharAt);
            }
        } else {
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.BranchModule);
            if (textView3 != null) {
                textView3.setText(KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
    }

    public static /* synthetic */ void setCardScheme$default(CardView cardView, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        cardView.setCardScheme(str, z);
    }

    public final void setCardScheme(String cardSchemeIcon, boolean isOneKlik) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.DeviceLimitErrorKey);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(isOneKlik ? 0 : 8);
        }
        if (cardSchemeIcon == null || (appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0a34_camera_onzoomchangelistener)) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        AppCompatImageView appCompatImageView3 = appCompatImageView;
        String lowerCase = cardSchemeIcon.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        GlideRequests authRequestContext = GlideApp.getAuthRequestContext(appCompatImageView3.getContext());
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String lowerCase2 = lowerCase.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "");
        String format = String.format(DanaUrl.BANK_CARD_SCHEME_URL, Arrays.copyOf(new Object[]{lowerCase2}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        authRequestContext.PlaceComponentResult(format).MyBillsEntityDataFactory((ImageView) appCompatImageView3);
        appCompatImageView3.setVisibility(0);
        appCompatImageView.setVisibility(isOneKlik ^ true ? 0 : 8);
    }

    public final void setCardType(String cardType) {
        Intrinsics.checkNotNullParameter(cardType, "");
        if (Intrinsics.areEqual(cardType, "CREDIT_CARD")) {
            ((TextView) _$_findCachedViewById(R.id.clearPyGenericServices)).setText(getContext().getString(R.string.card_credit_text));
        } else if (Intrinsics.areEqual(cardType, "DEBIT_CARD")) {
            ((TextView) _$_findCachedViewById(R.id.clearPyGenericServices)).setText(getContext().getString(R.string.card_debit_text));
        } else {
            ((TextView) _$_findCachedViewById(R.id.clearPyGenericServices)).setText("");
        }
    }

    public final void setCardBankToDefault() {
        performCardAnimation(true, new Function0<Unit>() { // from class: id.dana.cardbinding.view.CardView$setCardBankToDefault$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CardView.access$reverseCardBankBackground(CardView.this);
            }
        });
        setCardBankLogo(null);
        setCardBankTextColor(true);
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0a34_camera_onzoomchangelistener);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(8);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.DeviceLimitErrorKey);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(8);
        }
        setTextViewCardDate("");
        setCardType("");
    }

    public final void flipCard(Context context, View visibleView, final View inVisibleView) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(visibleView, "");
        Intrinsics.checkNotNullParameter(inVisibleView, "");
        try {
            visibleView.setVisibility(0);
            float f = context.getResources().getDisplayMetrics().density * 30000.0f;
            visibleView.setCameraDistance(f);
            inVisibleView.setCameraDistance(f);
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, R.animator.f5162130837513);
            if (loadAnimator == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.animation.AnimatorSet");
            }
            AnimatorSet animatorSet = (AnimatorSet) loadAnimator;
            animatorSet.setTarget(inVisibleView);
            Animator loadAnimator2 = AnimatorInflater.loadAnimator(context, R.animator.f5152130837512);
            if (loadAnimator2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.animation.AnimatorSet");
            }
            AnimatorSet animatorSet2 = (AnimatorSet) loadAnimator2;
            animatorSet2.setTarget(visibleView);
            animatorSet.start();
            animatorSet2.start();
            Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: id.dana.cardbinding.view.CardView$flipCard$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    inVisibleView.setVisibility(8);
                }
            };
            animatorSet2.addListener(animatorListener);
            Animator.AnimatorListener animatorListener2 = animatorListener;
        } catch (Exception unused) {
        }
    }

    public static final /* synthetic */ void access$reverseCardBankBackground(final CardView cardView) {
        Executor executor;
        loadBankBackground$default(cardView, null, null, true, 2, null);
        String str = cardView.currentBankBackground;
        if (str.length() == 0) {
            str = BuiltInFictitiousFunctionClassFactory("default");
        }
        GlideRequest<Drawable> PlaceComponentResult = GlideApp.getAuthRequestContext(cardView.getContext()).PlaceComponentResult(str).getErrorConfigVersion((int) R.drawable.bg_default_horizontal).PlaceComponentResult((int) R.drawable.bg_default_horizontal);
        CustomTarget<Drawable> customTarget = new CustomTarget<Drawable>() { // from class: id.dana.cardbinding.view.CardView$resetBankBackground$1
            @Override // com.bumptech.glide.request.target.Target
            public final void onLoadCleared(Drawable p0) {
            }

            @Override // com.bumptech.glide.request.target.Target
            public final /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                Drawable drawable = (Drawable) obj;
                Intrinsics.checkNotNullParameter(drawable, "");
                ((ConstraintLayout) CardView.this._$_findCachedViewById(R.id.getMissionActiveImage).findViewById(R.id.res_0x7f0a0380_setindex_kotlin_stdlib)).setBackground(drawable);
            }
        };
        executor = Executors.PlaceComponentResult;
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(customTarget, null, PlaceComponentResult, executor);
        cardView.currentBankBackground = "";
        cardView.hasPerfromCardAnimate = false;
    }

    static /* synthetic */ void loadBankBackground$default(final CardView cardView, String str, final String str2, final boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        GlideRequest<Drawable> PlaceComponentResult = GlideApp.getAuthRequestContext(cardView.getContext()).PlaceComponentResult(str);
        Transformation<Bitmap>[] transformationArr = new Transformation[2];
        transformationArr[0] = new CenterCrop();
        Context context = cardView.getContext();
        if (context != null) {
            transformationArr[1] = new RoundedCornersTransformation(ImageResize.PlaceComponentResult((Activity) context, 16), 0, RoundedCornersTransformation.CornerType.ALL);
            GlideRequest<Drawable> errorConfigVersion = PlaceComponentResult.PlaceComponentResult(transformationArr).getErrorConfigVersion((int) R.drawable.bg_default_horizontal);
            GlideRequest<Drawable> PlaceComponentResult2 = GlideApp.getAuthRequestContext(cardView.getContext()).PlaceComponentResult(BuiltInFictitiousFunctionClassFactory(str2 == null ? "default" : str2));
            Transformation<Bitmap>[] transformationArr2 = new Transformation[2];
            transformationArr2[0] = new CenterCrop();
            Context context2 = cardView.getContext();
            if (context2 != null) {
                transformationArr2[1] = new RoundedCornersTransformation(ImageResize.PlaceComponentResult((Activity) context2, 16), 0, RoundedCornersTransformation.CornerType.ALL);
                errorConfigVersion.MyBillsEntityDataFactory((RequestBuilder<Drawable>) PlaceComponentResult2.PlaceComponentResult(transformationArr2)).BuiltInFictitiousFunctionClassFactory(new RequestListener<Drawable>() { // from class: id.dana.cardbinding.view.CardView$loadBankBackground$1
                    @Override // com.bumptech.glide.request.RequestListener
                    public final /* bridge */ /* synthetic */ boolean onResourceReady(Drawable drawable, Object obj2, Target<Drawable> target, DataSource dataSource, boolean z2) {
                        return false;
                    }

                    @Override // com.bumptech.glide.request.RequestListener
                    public final boolean onLoadFailed(GlideException p0, Object p1, Target<Drawable> p2, boolean p3) {
                        String BuiltInFictitiousFunctionClassFactory;
                        if (z) {
                            return false;
                        }
                        CardView cardView2 = cardView;
                        String str3 = str2;
                        if (str3 == null) {
                            str3 = "default";
                        }
                        BuiltInFictitiousFunctionClassFactory = CardView.BuiltInFictitiousFunctionClassFactory(str3);
                        cardView2.setCurrentBankBackground(BuiltInFictitiousFunctionClassFactory);
                        return false;
                    }
                }).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) cardView._$_findCachedViewById(R.id.MenuItemActionViewCollapseEvent)));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    public final void setCardBankBackground(QueryCardPolicyInfoModel queryCardPolicyInfoModel) {
        String BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(queryCardPolicyInfoModel, "");
        String str = queryCardPolicyInfoModel.PlaceComponentResult;
        if (!(str == null || str.length() == 0)) {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(queryCardPolicyInfoModel.PlaceComponentResult);
        } else {
            String str2 = queryCardPolicyInfoModel.moveToNextValue;
            if (str2 == null) {
                str2 = "default";
            }
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(str2);
        }
        String str3 = BuiltInFictitiousFunctionClassFactory;
        this.currentBankBackground = str3;
        loadBankBackground$default(this, str3, queryCardPolicyInfoModel.moveToNextValue, false, 4, null);
        ((ConstraintLayout) _$_findCachedViewById(R.id.getMissionActiveImage).findViewById(R.id.res_0x7f0a0380_setindex_kotlin_stdlib)).setBackgroundResource(R.drawable.bg_default_horizontal);
    }
}
