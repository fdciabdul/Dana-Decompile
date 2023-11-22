package id.dana.danapoly.ui.cards.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.MetricAffectingSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.glide.GlideApp;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.ViewDanapolyCardItemBinding;
import id.dana.danapoly.ui.enums.CardStatus;
import id.dana.danapoly.ui.enums.RewardType;
import id.dana.danapoly.ui.enums.RewardTypeKt;
import id.dana.danapoly.ui.model.CardItemModel;
import id.dana.danapoly.ui.model.play.LocalizationModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\u001f\u0012\b\b\u0002\u0010,\u001a\u00020\u001f¢\u0006\u0004\b-\u0010.J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u0005J\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0005R*\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\r\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R.\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\u00178\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010&\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\u001f8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%"}, d2 = {"Lid/dana/danapoly/ui/cards/view/CardItemView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/danapoly/databinding/ViewDanapolyCardItemBinding;", "", "checkIfNeedToShowStackPreview", "()V", "inflateViewBinding", "()Lid/dana/danapoly/databinding/ViewDanapolyCardItemBinding;", "renderNormalView", "renderStackedView", "setup", "Lid/dana/danapoly/ui/model/CardItemModel;", "value", "PlaceComponentResult", "Lid/dana/danapoly/ui/model/CardItemModel;", "getCard", "()Lid/dana/danapoly/ui/model/CardItemModel;", "setCard", "(Lid/dana/danapoly/ui/model/CardItemModel;)V", "card", "", "MyBillsEntityDataFactory", "J", "Lkotlin/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "getOnCardItemClicked", "()Lkotlin/jvm/functions/Function1;", "setOnCardItemClicked", "(Lkotlin/jvm/functions/Function1;)V", "onCardItemClicked", "", "getAuthRequestContext", "I", "getStackIndex", "()I", "setStackIndex", "(I)V", "stackIndex", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardItemView extends BaseViewBindingRichView<ViewDanapolyCardItemBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function1<? super CardItemModel, Unit> onCardItemClicked;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private long PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private CardItemModel card;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int stackIndex;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardItemView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CardItemView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ CardItemView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this.card = new CardItemModel(null, null, null, null, null, null, 0L, 0, null, null, null, null, ARiverTrackWatchDogEventConstant.STARTUP_FLAG, null);
        this.onCardItemClicked = new Function1<CardItemModel, Unit>() { // from class: id.dana.danapoly.ui.cards.view.CardItemView$onCardItemClicked$1
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
        this.PlaceComponentResult = System.currentTimeMillis();
    }

    @JvmName(name = "getCard")
    public final CardItemModel getCard() {
        return this.card;
    }

    @JvmName(name = "setCard")
    public final void setCard(CardItemModel cardItemModel) {
        String localized;
        String quantityString;
        Intrinsics.checkNotNullParameter(cardItemModel, "");
        this.card = cardItemModel;
        getBinding().getErrorConfigVersion.setText(LocalizationModel.INSTANCE.localized(this.card.getName()));
        AppCompatTextView appCompatTextView = getBinding().BuiltInFictitiousFunctionClassFactory;
        if (this.card.getCardType() == RewardType.DARE && Intrinsics.areEqual(this.card.getStatus(), CardStatus.EXPIRED.name())) {
            localized = getContext().getString(R.string.res_0x7f130754_networkuserentitydata_externalsyntheticlambda5);
        } else {
            localized = LocalizationModel.INSTANCE.localized(this.card.getDescription());
        }
        appCompatTextView.setText(localized);
        RewardType cardType = this.card.getCardType();
        if (cardType != null) {
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(this.card.getUrl()).getErrorConfigVersion(RewardTypeKt.BuiltInFictitiousFunctionClassFactory(cardType)).PlaceComponentResult(RewardTypeKt.BuiltInFictitiousFunctionClassFactory(cardType)).MyBillsEntityDataFactory((ImageView) getBinding().MyBillsEntityDataFactory);
        }
        if (!Intrinsics.areEqual(this.card.getStatus(), CardStatus.PENDING.name())) {
            AppCompatTextView appCompatTextView2 = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
            appCompatTextView2.setVisibility(0);
            AppCompatTextView appCompatTextView3 = getBinding().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView3, "");
            appCompatTextView3.setVisibility(8);
            ShapeableImageView shapeableImageView = getBinding().MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
            ViewExtKt.MyBillsEntityDataFactory((ImageView) shapeableImageView, true);
            getBinding().MyBillsEntityDataFactory.setBackground(ContextCompat.PlaceComponentResult(getContext(), R.color.moveToNextValue_res_0x7f0600c9));
            return;
        }
        AppCompatTextView appCompatTextView4 = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView4, "");
        appCompatTextView4.setVisibility(8);
        AppCompatTextView appCompatTextView5 = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView5, "");
        appCompatTextView5.setVisibility(0);
        long expiredTime = this.card.getExpiredTime();
        long j = this.PlaceComponentResult;
        if (j != 0) {
            int i = (int) (((expiredTime - j) / 1000) / 60);
            if (i < 60) {
                quantityString = getContext().getResources().getQuantityString(R.plurals.getAuthRequestContext, i, Integer.valueOf(i));
            } else {
                int i2 = i / 60;
                quantityString = getContext().getResources().getQuantityString(R.plurals.PlaceComponentResult, i2, Integer.valueOf(i2));
            }
            Intrinsics.checkNotNullExpressionValue(quantityString, "");
            AppCompatTextView appCompatTextView6 = getBinding().getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append(getContext().getString(R.string.cards_ends_with));
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(quantityString);
            String obj = sb.toString();
            int indexOf$default = StringsKt.indexOf$default((CharSequence) obj, quantityString, 0, false, 6, (Object) null);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(obj);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.NetworkUserEntityData$$ExternalSyntheticLambda1)), indexOf$default, quantityString.length() + indexOf$default, 33);
            spannableStringBuilder.setSpan(new MetricAffectingSpan() { // from class: id.dana.danapoly.ui.cards.view.CardItemView$getFormattedRemainingTime$1$1
                @Override // android.text.style.CharacterStyle
                public final void updateDrawState(TextPaint p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    PlaceComponentResult(p0);
                }

                @Override // android.text.style.MetricAffectingSpan
                public final void updateMeasureState(TextPaint p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    PlaceComponentResult(p0);
                }

                private final void PlaceComponentResult(TextPaint p0) {
                    Typeface PlaceComponentResult = ResourcesCompat.PlaceComponentResult(CardItemView.this.getContext(), R.font.getAuthRequestContext);
                    int style = PlaceComponentResult != null ? PlaceComponentResult.getStyle() : 0;
                    if (style != 0) {
                        p0.setTypeface(InstrumentInjector.typefaceCreateDerived(PlaceComponentResult, style));
                    }
                }
            }, indexOf$default, quantityString.length() + indexOf$default, 33);
            appCompatTextView6.setText(spannableStringBuilder);
        }
        ShapeableImageView shapeableImageView2 = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(shapeableImageView2, "");
        ViewExtKt.MyBillsEntityDataFactory((ImageView) shapeableImageView2, false);
        getBinding().MyBillsEntityDataFactory.setBackground(ContextCompat.PlaceComponentResult(getContext(), R.color.lookAheadTest_res_0x7f0600c8));
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

    @JvmName(name = "getStackIndex")
    public final int getStackIndex() {
        return this.stackIndex;
    }

    @JvmName(name = "setStackIndex")
    public final void setStackIndex(int i) {
        this.stackIndex = i;
        renderStackedView();
        checkIfNeedToShowStackPreview();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewDanapolyCardItemBinding inflateViewBinding() {
        ViewDanapolyCardItemBinding PlaceComponentResult = ViewDanapolyCardItemBinding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.cards.view.CardItemView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardItemView.$r8$lambda$KQyyeqfcsXBds0xqPqYeeplyazY(CardItemView.this, view);
            }
        });
    }

    public final void renderNormalView() {
        View view = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(view, "");
        view.setVisibility(8);
        ConstraintLayout constraintLayout = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        Float valueOf = Float.valueOf(0.0f);
        ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout, valueOf, valueOf, valueOf, valueOf);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(getResources(), R.drawable.bg_rounded_white_8dp, null));
    }

    public final void renderStackedView() {
        if (this.stackIndex > 0) {
            ConstraintLayout constraintLayout = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            int i = this.stackIndex;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            int i2 = i * 8;
            ViewExtKt.PlaceComponentResult(constraintLayout, Integer.valueOf(i2), Integer.valueOf(i2), Integer.valueOf(i2), 8);
            if (this.stackIndex == 1) {
                getBinding().moveToNextValue.setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(getResources(), R.drawable.bg_rounded_grey10_8dp, null));
            }
            if (this.stackIndex == 2) {
                getBinding().moveToNextValue.setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(getResources(), R.drawable.bg_rounded_grey20_8dp, null));
            }
        }
    }

    public final void checkIfNeedToShowStackPreview() {
        View view = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(view, "");
        int i = this.stackIndex;
        boolean z = true;
        if (i != 1 && i != 2) {
            z = false;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public static /* synthetic */ void $r8$lambda$KQyyeqfcsXBds0xqPqYeeplyazY(CardItemView cardItemView, View view) {
        Intrinsics.checkNotNullParameter(cardItemView, "");
        if (cardItemView.stackIndex <= 0) {
            cardItemView.onCardItemClicked.invoke(cardItemView.card);
        }
    }
}
