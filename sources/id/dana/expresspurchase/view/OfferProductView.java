package id.dana.expresspurchase.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.afollestad.materialdialogs.MaterialDialog;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.zhuinden.simplestack.Backstack;
import com.zhuinden.simplestack.navigator.Navigator;
import id.dana.R;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchaseAction;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchaseType;
import id.dana.expresspurchase.constant.ExpressPurchaseResultStatus;
import id.dana.expresspurchase.model.CTAModel;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.expresspurchase.model.PriceModel;
import id.dana.expresspurchase.model.VoucherExpressInfoModel;
import id.dana.expresspurchase.view.ExpressPurchaseTncActivity;
import id.dana.extension.ContextExtKt;
import id.dana.richview.LogoProgressView;
import id.dana.richview.PromptCTAView;
import id.dana.utils.UrlUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001'B'\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"B+\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\u0006\u0010%\u001a\u00020\u001f¢\u0006\u0004\b!\u0010&J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/expresspurchase/view/OfferProductView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel;)Lkotlin/Unit;", "Lid/dana/expresspurchase/view/OfferProductView$DismissLoadingDialogEvent;", "event", "dismissDanaLoadingProgress", "(Lid/dana/expresspurchase/view/OfferProductView$DismissLoadingDialogEvent;)V", "onFinishInflate", "()V", "Lid/dana/expresspurchase/model/CTAModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/expresspurchase/model/CTAModel;)V", "MyBillsEntityDataFactory", "Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/dialog/DanaLoadingDialog;", "PlaceComponentResult", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "getErrorConfigVersion", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttribute", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "attrs", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "DismissLoadingDialogEvent"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OfferProductView extends ConstraintLayout {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private DanaLoadingDialog PlaceComponentResult;
    private FrameLayout MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private MaterialDialog BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private ExpressPurchaseModel KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/expresspurchase/view/OfferProductView$DismissLoadingDialogEvent;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DismissLoadingDialogEvent {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfferProductView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfferProductView(Context context, AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferProductView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ OfferProductView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferProductView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        ExpressPurchaseModel expressPurchaseModel;
        String name;
        super.onFinishInflate();
        if (isInEditMode()) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        if (Navigator.isNavigatorAvailable(ContextExtKt.getAuthRequestContext(context))) {
            try {
                Bundle bundle = ((OfferProductScreen) Backstack.getKey(getContext())).BuiltInFictitiousFunctionClassFactory;
                if (bundle == null || (expressPurchaseModel = (ExpressPurchaseModel) bundle.getParcelable(ExpressPurchaseActivity.EXPRESS_PURCHASE_PAYLOAD)) == null) {
                    return;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = expressPurchaseModel;
                this.MyBillsEntityDataFactory = (FrameLayout) findViewById(R.id.flDanaLoading);
                final ExpressPurchaseModel expressPurchaseModel2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                ExpressPurchaseModel expressPurchaseModel3 = null;
                if (expressPurchaseModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    expressPurchaseModel2 = null;
                }
                if (expressPurchaseModel2 instanceof ExpressPurchaseModel.Gold) {
                    getAuthRequestContext(expressPurchaseModel2);
                    ExpressPurchaseModel.Gold gold = (ExpressPurchaseModel.Gold) expressPurchaseModel2;
                    String str = gold.moveToNextValue.PrepareContext;
                    String str2 = gold.moveToNextValue.getAuthRequestContext;
                    String string = getContext().getString(R.string.sdet_btn_buy_now);
                    String string2 = getContext().getString(R.string.sdet_btn_skip);
                    String string3 = getContext().getString(R.string.sdet_txt_notes);
                    String string4 = getContext().getString(R.string.ep_gold_maybe_later_button_label);
                    Intrinsics.checkNotNullExpressionValue(string4, "");
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    Intrinsics.checkNotNullExpressionValue(string3, "");
                    BuiltInFictitiousFunctionClassFactory(new CTAModel(str, str2, string4, string, string2, null, null, string3, null, 352, null));
                } else if (expressPurchaseModel2 instanceof ExpressPurchaseModel.Insurance) {
                    getAuthRequestContext(expressPurchaseModel2);
                    ExpressPurchaseModel.Insurance insurance = (ExpressPurchaseModel.Insurance) expressPurchaseModel2;
                    String str3 = insurance.MyBillsEntityDataFactory.PrepareContext;
                    String str4 = insurance.MyBillsEntityDataFactory.getAuthRequestContext;
                    String string5 = getContext().getString(R.string.sdet_btn_buy_now);
                    String string6 = getContext().getString(R.string.sdet_btn_skip);
                    String string7 = getContext().getString(R.string.sdet_txt_notes);
                    String string8 = getContext().getString(R.string.menu_skip);
                    Intrinsics.checkNotNullExpressionValue(string8, "");
                    Intrinsics.checkNotNullExpressionValue(string5, "");
                    Intrinsics.checkNotNullExpressionValue(string6, "");
                    Intrinsics.checkNotNullExpressionValue(string7, "");
                    BuiltInFictitiousFunctionClassFactory(new CTAModel(str3, str4, string8, string5, string6, null, null, string7, null, 352, null));
                } else if (expressPurchaseModel2 instanceof ExpressPurchaseModel.Paylater) {
                    getAuthRequestContext(expressPurchaseModel2);
                    String string9 = getContext().getString(R.string.ep_paylater_activation_tnc_remark);
                    String string10 = getContext().getString(R.string.ep_paylater_activation_activate_btn_label);
                    String string11 = getContext().getString(R.string.ep_paylater_activation_maybe_later_btn_label);
                    String string12 = getContext().getString(R.string.tnc);
                    String string13 = getContext().getString(R.string.sdet_btn_ep_paylater_landing_activate);
                    String string14 = getContext().getString(R.string.sdet_btn_ep_paylater_landing_later);
                    String string15 = getContext().getString(R.string.sdet_btn_ep_paylater_landing_tnc);
                    Intrinsics.checkNotNullExpressionValue(string9, "");
                    Intrinsics.checkNotNullExpressionValue(string10, "");
                    Intrinsics.checkNotNullExpressionValue(string11, "");
                    Intrinsics.checkNotNullExpressionValue(string13, "");
                    Intrinsics.checkNotNullExpressionValue(string14, "");
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.expresspurchase.view.OfferProductView$initExpressPurchaseView$ctaModel$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            ExpressPurchaseTncActivity.Companion companion = ExpressPurchaseTncActivity.INSTANCE;
                            Context context2 = OfferProductView.this.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "");
                            ExpressPurchaseTncActivity.Companion.BuiltInFictitiousFunctionClassFactory(context2, ((ExpressPurchaseModel.Paylater) expressPurchaseModel2).MyBillsEntityDataFactory);
                        }
                    };
                    Intrinsics.checkNotNullExpressionValue(string15, "");
                    BuiltInFictitiousFunctionClassFactory(new CTAModel(string9, string10, string11, string13, string14, string12, function0, string15, null, 256, null));
                } else if (expressPurchaseModel2 instanceof ExpressPurchaseModel.Deals) {
                    getAuthRequestContext(expressPurchaseModel2);
                    String string16 = getContext().getString(R.string.deals_express_voucher_tnc_remark);
                    Intrinsics.checkNotNullExpressionValue(string16, "");
                    String str5 = ((ExpressPurchaseModel.Deals) expressPurchaseModel2).GetContactSyncConfig.getAuthRequestContext;
                    String string17 = getContext().getString(R.string.deals_express_voucher_maybe_later_btn_label);
                    Intrinsics.checkNotNullExpressionValue(string17, "");
                    BuiltInFictitiousFunctionClassFactory(new CTAModel(string16, str5, string17, null, null, null, null, null, CTAModel.CtaStyle.TOP_DOWN, 248, null));
                }
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                ExpressPurchaseActivity expressPurchaseActivity = (ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context2);
                ExpressPurchaseModel expressPurchaseModel4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (expressPurchaseModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    expressPurchaseModel4 = null;
                }
                expressPurchaseActivity.trackExpressPurchaseOpen(expressPurchaseModel4);
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "");
                ExpressPurchaseActivity expressPurchaseActivity2 = (ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context3);
                ExpressPurchaseModel expressPurchaseModel5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (expressPurchaseModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    expressPurchaseModel5 = null;
                }
                String str6 = expressPurchaseModel5.getAuthRequestContext.getAuthRequestContext;
                String name2 = ExpressPurchaseAction.DISMISS.name();
                ExpressPurchaseModel expressPurchaseModel6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (expressPurchaseModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    expressPurchaseModel3 = expressPurchaseModel6;
                }
                if (expressPurchaseModel3 instanceof ExpressPurchaseModel.Paylater) {
                    name = ExpressPurchaseType.PAYLATER.name();
                } else {
                    name = ExpressPurchaseType.ADDON.name();
                }
                expressPurchaseActivity2.saveDismissAction(str6, name2, name);
                Context context4 = getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "");
                ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context4)).startEpTimer();
                EventBus.getDefault().register(this);
            } catch (Exception e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.EXPRESS_PURCHASE_OFFER_PRODUCT_VIEW, e.getMessage());
            }
        }
    }

    private final Unit getAuthRequestContext(ExpressPurchaseModel p0) {
        OfferInfoDeals offerInfoDeals;
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.flContent);
        if (frameLayout != null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(new ConstraintLayout.LayoutParams(-1));
            if (p0 instanceof ExpressPurchaseModel.Gold) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "");
                OfferInfoEmas offerInfoEmas = new OfferInfoEmas(context, null, 0, 0, 14, null);
                offerInfoEmas.setLayoutParams(layoutParams);
                offerInfoEmas.setupViews((ExpressPurchaseModel.Gold) p0);
                offerInfoDeals = offerInfoEmas;
            } else if (p0 instanceof ExpressPurchaseModel.Insurance) {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                OfferInfoInsurance offerInfoInsurance = new OfferInfoInsurance(context2, null, 0, 6, null);
                offerInfoInsurance.setLayoutParams(layoutParams);
                offerInfoInsurance.setupViews(((ExpressPurchaseModel.Insurance) p0).MyBillsEntityDataFactory);
                offerInfoDeals = offerInfoInsurance;
            } else if (p0 instanceof ExpressPurchaseModel.Paylater) {
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "");
                OfferInfoPaylater offerInfoPaylater = new OfferInfoPaylater(context3, null, 0, 6, null);
                offerInfoPaylater.setLayoutParams(layoutParams);
                offerInfoPaylater.setupViews((ExpressPurchaseModel.Paylater) p0);
                offerInfoDeals = offerInfoPaylater;
            } else if (p0 instanceof ExpressPurchaseModel.Deals) {
                Context context4 = getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "");
                OfferInfoDeals offerInfoDeals2 = new OfferInfoDeals(context4, null, 0, 6, null);
                ExpressPurchaseModel.Deals deals = (ExpressPurchaseModel.Deals) p0;
                offerInfoDeals2.setupViews(deals);
                String str = deals.getErrorConfigVersion;
                Context context5 = getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "");
                ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context5)).getDealsShopLocation(str);
                offerInfoDeals2.setOnClickDealsShopLocationTryAgain(new Function0<Unit>() { // from class: id.dana.expresspurchase.view.OfferProductView$setOfferEpView$4$1
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
                        OfferProductView.access$getActivity(OfferProductView.this).getPermissionRequest().check();
                    }
                });
                offerInfoDeals = offerInfoDeals2;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            frameLayout.addView(offerInfoDeals);
            return Unit.INSTANCE;
        }
        return null;
    }

    private final void BuiltInFictitiousFunctionClassFactory(CTAModel p0) {
        PromptCTAView promptCTAView = (PromptCTAView) _$_findCachedViewById(R.id.cta_express_purchase_offer);
        if (promptCTAView != null) {
            Intrinsics.checkNotNullExpressionValue(promptCTAView, "");
            promptCTAView.setCtaStyle(p0.KClassImpl$Data$declaredNonStaticMembers$2.getValue());
            promptCTAView.setHeaderText(p0.lookAheadTest);
            promptCTAView.setHeaderTextContentDesc(p0.BuiltInFictitiousFunctionClassFactory);
            promptCTAView.setButtonPositive(p0.getErrorConfigVersion, true, p0.moveToNextValue);
            promptCTAView.setButtonNegative(p0.MyBillsEntityDataFactory, true, p0.getAuthRequestContext);
            promptCTAView.setOnBtnPositiveClickListener(new Function1<View, Unit>() { // from class: id.dana.expresspurchase.view.OfferProductView$setCTA$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    ExpressPurchaseModel expressPurchaseModel;
                    Intrinsics.checkNotNullParameter(view, "");
                    OfferProductView offerProductView = OfferProductView.this;
                    expressPurchaseModel = offerProductView.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (expressPurchaseModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        expressPurchaseModel = null;
                    }
                    OfferProductView.access$handleBtnPositiveClickListener(offerProductView, expressPurchaseModel);
                }
            });
            promptCTAView.setOnBtnNegativeClickListener(new Function1<View, Unit>() { // from class: id.dana.expresspurchase.view.OfferProductView$setCTA$1$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    ExpressPurchaseModel expressPurchaseModel;
                    Intrinsics.checkNotNullParameter(view, "");
                    OfferProductView offerProductView = OfferProductView.this;
                    expressPurchaseModel = offerProductView.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (expressPurchaseModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        expressPurchaseModel = null;
                    }
                    OfferProductView.access$handleBtnNegativeListener(offerProductView, expressPurchaseModel);
                }
            });
            String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (str != null) {
                PromptCTAView.setHeaderColoredSpan$default(promptCTAView, 0, str, false, p0.PlaceComponentResult, 5, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        FrameLayout frameLayout = this.MyBillsEntityDataFactory;
        if (frameLayout == null) {
            if (this.PlaceComponentResult == null && frameLayout == null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "");
                this.PlaceComponentResult = new DanaLoadingDialog((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context));
            }
            DanaLoadingDialog danaLoadingDialog = this.PlaceComponentResult;
            if (danaLoadingDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                danaLoadingDialog = null;
            }
            if (danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                return;
            }
            danaLoadingDialog.MyBillsEntityDataFactory.show();
            danaLoadingDialog.getAuthRequestContext.startRefresh();
            return;
        }
        frameLayout.setVisibility(0);
        LogoProgressView logoProgressView = (LogoProgressView) _$_findCachedViewById(R.id.lpvLoading);
        if (logoProgressView != null) {
            logoProgressView.startRefresh();
        }
    }

    @Subscribe
    public final void dismissDanaLoadingProgress(DismissLoadingDialogEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        FrameLayout frameLayout = this.MyBillsEntityDataFactory;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
            LogoProgressView logoProgressView = (LogoProgressView) _$_findCachedViewById(R.id.lpvLoading);
            if (logoProgressView != null) {
                logoProgressView.stopRefresh();
            }
        }
        DanaLoadingDialog danaLoadingDialog = this.PlaceComponentResult;
        if (danaLoadingDialog != null) {
            if (danaLoadingDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                danaLoadingDialog = null;
            }
            danaLoadingDialog.PlaceComponentResult();
        }
    }

    public static final /* synthetic */ ExpressPurchaseDealsViewExtender access$dealsView(OfferProductView offerProductView) {
        Context context = offerProductView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        return ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context)).expressPurchaseDealsExtender();
    }

    public static final /* synthetic */ ExpressPurchaseActivity access$getActivity(OfferProductView offerProductView) {
        Context context = offerProductView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        return (ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context);
    }

    public static final /* synthetic */ void access$handleBtnNegativeListener(OfferProductView offerProductView, ExpressPurchaseModel expressPurchaseModel) {
        Context context = offerProductView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context)).handleConsultCancelSurveyExpressPurchase();
        Context context2 = offerProductView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        ExpressPurchaseActivity expressPurchaseActivity = (ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context2);
        ExpressPurchaseResultStatus expressPurchaseResultStatus = ExpressPurchaseResultStatus.INSTANCE;
        expressPurchaseActivity.trackExpressPurchaseResult(ExpressPurchaseResultStatus.BuiltInFictitiousFunctionClassFactory(""), (r16 & 2) != 0 ? "" : null, (r16 & 4) != 0 ? "" : null, expressPurchaseModel, (r16 & 16) != 0 ? "" : null, (r16 & 32) != 0 ? "" : null);
    }

    public static final /* synthetic */ void access$handleBtnPositiveClickListener(final OfferProductView offerProductView, final ExpressPurchaseModel expressPurchaseModel) {
        PriceModel priceModel;
        if (expressPurchaseModel instanceof ExpressPurchaseModel.Gold) {
            offerProductView.MyBillsEntityDataFactory();
            Context context = offerProductView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context)).validateGoldPrice((ExpressPurchaseModel.Gold) expressPurchaseModel);
            return;
        }
        String str = null;
        MaterialDialog materialDialog = null;
        str = null;
        if (expressPurchaseModel instanceof ExpressPurchaseModel.Insurance) {
            StringBuilder sb = new StringBuilder();
            sb.append("epAddonId=");
            ExpressPurchaseModel.Insurance insurance = (ExpressPurchaseModel.Insurance) expressPurchaseModel;
            sb.append(insurance.getAuthRequestContext);
            final String PlaceComponentResult = UrlUtil.PlaceComponentResult(insurance.MyBillsEntityDataFactory.PlaceComponentResult, sb.toString());
            final String str2 = insurance.initRecordTimeStamp;
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            final String str3 = insurance.getAuthRequestContext;
            final String str4 = insurance.PlaceComponentResult;
            final Map<String, String> map = insurance.KClassImpl$Data$declaredNonStaticMembers$2;
            Context context2 = offerProductView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "");
            CustomDialog.Builder builder = new CustomDialog.Builder(context2);
            builder.SubSequence = offerProductView.getContext().getString(R.string.ep_confirmation_title);
            builder.GetContactSyncConfig = offerProductView.getContext().getString(R.string.ep_confirmation_desc);
            CustomDialog.Builder PlaceComponentResult2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
            PlaceComponentResult2.moveToNextValue = 0L;
            MaterialDialog BuiltInFictitiousFunctionClassFactory = PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory(offerProductView.getContext().getString(R.string.dialog_positive), new Function1<View, Unit>() { // from class: id.dana.expresspurchase.view.OfferProductView$showConfirmationDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                    if (Intrinsics.areEqual(str2, "STANDALONE_INSURANCE_TEMPLATE")) {
                        OfferProductView.access$getActivity(offerProductView).getNavigationManager().getAuthRequestContext(PlaceComponentResult, true);
                    } else if (Intrinsics.areEqual(str2, "BUNDLED_INSURANCE_TEMPLATE")) {
                        ExpressPurchaseInsuranceViewExtender access$insuranceView = OfferProductView.access$insuranceView(offerProductView);
                        String str5 = str3;
                        String str6 = str4;
                        Map<String, String> map2 = map;
                        Intrinsics.checkNotNullParameter(str5, "");
                        Intrinsics.checkNotNullParameter(str6, "");
                        Intrinsics.checkNotNullParameter(map2, "");
                        access$insuranceView.PlaceComponentResult.getAuthRequestContext(str5, str6, map2);
                    }
                }
            }).KClassImpl$Data$declaredNonStaticMembers$2(offerProductView.getContext().getString(R.string.dialog_negative), new Function1<View, Unit>() { // from class: id.dana.expresspurchase.view.OfferProductView$showConfirmationDialog$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    MaterialDialog materialDialog2;
                    Intrinsics.checkNotNullParameter(view, "");
                    materialDialog2 = OfferProductView.this.BuiltInFictitiousFunctionClassFactory;
                    if (materialDialog2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        materialDialog2 = null;
                    }
                    materialDialog2.dismiss();
                }
            }).BuiltInFictitiousFunctionClassFactory();
            offerProductView.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
            if (BuiltInFictitiousFunctionClassFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                materialDialog = BuiltInFictitiousFunctionClassFactory;
            }
            materialDialog.show();
        } else if (!(expressPurchaseModel instanceof ExpressPurchaseModel.Paylater)) {
            if (expressPurchaseModel instanceof ExpressPurchaseModel.Deals) {
                Context context3 = offerProductView.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "");
                ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context3)).trackExpressPurchaseConfirmationDeals();
                Context context4 = offerProductView.getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "");
                ExpressPurchaseModel.Deals deals = (ExpressPurchaseModel.Deals) expressPurchaseModel;
                ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context4)).trackExpressDealsPurchase(deals.DatabaseTableConfigUtil);
                Context context5 = offerProductView.getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "");
                CustomDialog.Builder builder2 = new CustomDialog.Builder(context5);
                Resources resources = offerProductView.getContext().getResources();
                Object[] objArr = new Object[1];
                VoucherExpressInfoModel voucherExpressInfoModel = deals.SubSequence;
                if (voucherExpressInfoModel != null && (priceModel = voucherExpressInfoModel.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                    str = priceModel.getAuthRequestContext;
                }
                objArr[0] = str != null ? str : "";
                builder2.SubSequence = resources.getString(R.string.deals_express_confirmation_title, objArr);
                builder2.GetContactSyncConfig = offerProductView.getContext().getResources().getString(R.string.deals_express_confirmation_desc);
                builder2.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory(offerProductView.getContext().getResources().getString(R.string.deals_express_confirmation_positive), new Function1<View, Unit>() { // from class: id.dana.expresspurchase.view.OfferProductView$handleBtnPositiveClickListener$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                        OfferProductView.this.MyBillsEntityDataFactory();
                        ExpressPurchaseDealsViewExtender access$dealsView = OfferProductView.access$dealsView(OfferProductView.this);
                        ExpressPurchaseModel.Deals deals2 = (ExpressPurchaseModel.Deals) expressPurchaseModel;
                        Intrinsics.checkNotNullParameter(deals2, "");
                        access$dealsView.getAuthRequestContext.PlaceComponentResult(deals2);
                    }
                }).KClassImpl$Data$declaredNonStaticMembers$2(offerProductView.getContext().getResources().getString(R.string.deals_express_voucher_maybe_later_btn_label), new Function1<View, Unit>() { // from class: id.dana.expresspurchase.view.OfferProductView$handleBtnPositiveClickListener$2
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }
                }).BuiltInFictitiousFunctionClassFactory().show();
            }
        } else {
            Context context6 = offerProductView.getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "");
            ExpressPurchaseModel.Paylater paylater = (ExpressPurchaseModel.Paylater) expressPurchaseModel;
            ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context6)).trackExpressPurchasePaylaterActivation(paylater);
            Context context7 = offerProductView.getContext();
            Intrinsics.checkNotNullExpressionValue(context7, "");
            ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context7)).getNavigationManager().getAuthRequestContext(paylater.BuiltInFictitiousFunctionClassFactory, true);
        }
    }

    public static final /* synthetic */ ExpressPurchaseInsuranceViewExtender access$insuranceView(OfferProductView offerProductView) {
        Context context = offerProductView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        return ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context)).expressPurchaseInsuranceExtender();
    }
}
