package id.dana.expresspurchase.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.zhuinden.simplestack.Backstack;
import com.zhuinden.simplestack.navigator.Navigator;
import id.dana.R;
import id.dana.core.ui.glide.ImageAttacherFactory;
import id.dana.data.constant.DanaUrl;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchaseAction;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchaseType;
import id.dana.expresspurchase.constant.ExpressPurchaseResult;
import id.dana.expresspurchase.constant.ExpressPurchaseResultStatus;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.extension.ContextExtKt;
import id.dana.richview.PromptCTAView;
import id.dana.utils.ImageOss;
import id.dana.utils.UrlUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019B+\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J7\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/expresspurchase/view/ExpressPurchaseResultView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "onFinishInflate", "()V", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "p0", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;", "p1", "", "p2", "p3", "PlaceComponentResult", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel;Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Ljava/lang/String;Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;Ljava/lang/String;)V", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/expresspurchase/model/ExpressPurchaseModel;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttribute", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "attrs", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ExpressPurchaseResultView extends ConstraintLayout {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpressPurchaseResultView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpressPurchaseResultView(Context context, AttributeSet attributeSet) {
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
    public ExpressPurchaseResultView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ ExpressPurchaseResultView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressPurchaseResultView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        Bundle bundle;
        String string;
        String string2;
        ExpressPurchaseModel expressPurchaseModel;
        super.onFinishInflate();
        if (isInEditMode()) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        if (!Navigator.isNavigatorAvailable((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context)) || (bundle = ((ExpressPurchaseResultScreen) Backstack.getKey(getContext())).BuiltInFictitiousFunctionClassFactory) == null || (string = bundle.getString(ExpressPurchaseActivity.QUICK_BUY_RESULT)) == null || (string2 = bundle.getString(ExpressPurchaseActivity.BIZ_ORDER_ID)) == null || (expressPurchaseModel = (ExpressPurchaseModel) bundle.getParcelable(ExpressPurchaseActivity.EXPRESS_PURCHASE_PAYLOAD)) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(string, "");
        getAuthRequestContext(string, string2, expressPurchaseModel);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        ExpressPurchaseActivity expressPurchaseActivity = (ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context2);
        ExpressPurchaseResultStatus expressPurchaseResultStatus = ExpressPurchaseResultStatus.INSTANCE;
        expressPurchaseActivity.trackExpressPurchaseResult(ExpressPurchaseResultStatus.BuiltInFictitiousFunctionClassFactory(string), (r16 & 2) != 0 ? "" : "", (r16 & 4) != 0 ? "" : "", expressPurchaseModel, (r16 & 16) != 0 ? "" : null, (r16 & 32) != 0 ? "" : null);
    }

    static /* synthetic */ void getAuthRequestContext$default(ExpressPurchaseResultView expressPurchaseResultView, String str, String str2, ExpressPurchaseModel expressPurchaseModel, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        expressPurchaseResultView.getAuthRequestContext(str, str2, expressPurchaseModel);
    }

    private final void getAuthRequestContext(String p0, String p1, ExpressPurchaseModel p2) {
        switch (p0.hashCode()) {
            case -1867169789:
                if (p0.equals("success")) {
                    ExpressPurchaseModel.PaymentResultContent paymentResultContent = p2.PlaceComponentResult;
                    if (paymentResultContent != null) {
                        KClassImpl$Data$declaredNonStaticMembers$2(paymentResultContent, p0);
                        PlaceComponentResult$default(this, p2, paymentResultContent, p0, null, 8, null);
                    }
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "");
                    ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context)).saveDismissAction(p2.getAuthRequestContext.getAuthRequestContext, ExpressPurchaseAction.SUCCESS.name(), ExpressPurchaseType.ADDON.name());
                    return;
                }
                break;
            case -1281977283:
                if (p0.equals("failed")) {
                    ExpressPurchaseModel.PaymentResultContent paymentResultContent2 = p2.MyBillsEntityDataFactory;
                    if (paymentResultContent2 != null) {
                        KClassImpl$Data$declaredNonStaticMembers$2(paymentResultContent2, p0);
                        PlaceComponentResult$default(this, p2, paymentResultContent2, p0, null, 8, null);
                        return;
                    }
                    return;
                }
                break;
            case -682587753:
                if (p0.equals("pending")) {
                    ExpressPurchaseModel.PaymentResultContent paymentResultContent3 = p2.BuiltInFictitiousFunctionClassFactory;
                    if (paymentResultContent3 != null) {
                        KClassImpl$Data$declaredNonStaticMembers$2(paymentResultContent3, p0);
                        PlaceComponentResult(p2, paymentResultContent3, p0, p1);
                    }
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "");
                    ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context2)).saveDismissAction(p2.getAuthRequestContext.getAuthRequestContext, ExpressPurchaseAction.SUCCESS.name(), ExpressPurchaseType.ADDON.name());
                    return;
                }
                break;
            case -135867911:
                if (p0.equals(ExpressPurchaseResult.FAILED_NOT_ENOUGH_BALANCE_RESULT)) {
                    ExpressPurchaseModel.PaymentResultContent paymentResultContent4 = p2.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (paymentResultContent4 != null) {
                        KClassImpl$Data$declaredNonStaticMembers$2(paymentResultContent4, p0);
                        PlaceComponentResult$default(this, p2, paymentResultContent4, p0, null, 8, null);
                        return;
                    }
                    return;
                }
                break;
        }
        KClassImpl$Data$declaredNonStaticMembers$2$default(this, null, null, 3, null);
        PlaceComponentResult$default(this, p2, null, p0, null, 10, null);
    }

    static /* synthetic */ void PlaceComponentResult$default(ExpressPurchaseResultView expressPurchaseResultView, ExpressPurchaseModel expressPurchaseModel, ExpressPurchaseModel.PaymentResultContent paymentResultContent, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            paymentResultContent = null;
        }
        if ((i & 8) != 0) {
            str2 = "";
        }
        expressPurchaseResultView.PlaceComponentResult(expressPurchaseModel, paymentResultContent, str, str2);
    }

    private final void PlaceComponentResult(final ExpressPurchaseModel p0, ExpressPurchaseModel.PaymentResultContent p1, final String p2, final String p3) {
        String string;
        String string2;
        PromptCTAView promptCTAView = (PromptCTAView) _$_findCachedViewById(R.id.cta_express_purchase_result);
        if (promptCTAView != null) {
            promptCTAView.setHeaderText("");
            if (Intrinsics.areEqual(p2, ExpressPurchaseResult.FAILED_NOT_ENOUGH_BALANCE_RESULT)) {
                PromptCTAView.setButtonPositive$default(promptCTAView, "", false, null, 4, null);
                if (p1 == null || (string2 = p1.getAuthRequestContext) == null) {
                    string2 = promptCTAView.getContext().getString(R.string.close);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                }
                PromptCTAView.setButtonNegative$default(promptCTAView, string2, true, null, 4, null);
            } else {
                if (p1 == null || (string = p1.getAuthRequestContext) == null) {
                    string = promptCTAView.getContext().getString(R.string.try_again);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                }
                String string3 = (Intrinsics.areEqual(p2, "success") && (p0 instanceof ExpressPurchaseModel.Gold)) ? getContext().getString(R.string.sdet_btn_open_emas) : "";
                Intrinsics.checkNotNullExpressionValue(string3, "");
                promptCTAView.setButtonPositive(string, true, string3);
                String string4 = promptCTAView.getContext().getString(R.string.close);
                Intrinsics.checkNotNullExpressionValue(string4, "");
                String string5 = Intrinsics.areEqual(p2, "success") ? getContext().getString(R.string.sdet_btn_close) : "";
                Intrinsics.checkNotNullExpressionValue(string5, "");
                promptCTAView.setButtonNegative(string4, true, string5);
                promptCTAView.setOnBtnPositiveClickListener(new Function1<View, Unit>() { // from class: id.dana.expresspurchase.view.ExpressPurchaseResultView$setCTA$1$1
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
                        ExpressPurchaseResultView.access$onClickPositiveBtn(ExpressPurchaseResultView.this, p0, p2, p3);
                    }
                });
            }
            promptCTAView.setOnBtnNegativeClickListener(new Function1<View, Unit>() { // from class: id.dana.expresspurchase.view.ExpressPurchaseResultView$setCTA$1$2
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
                    Intrinsics.checkNotNullParameter(view, "");
                    ExpressPurchaseResultView.access$getActivity(ExpressPurchaseResultView.this).getNavigationManager().MyBillsEntityDataFactory.finish();
                }
            });
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2$default(ExpressPurchaseResultView expressPurchaseResultView, ExpressPurchaseModel.PaymentResultContent paymentResultContent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            paymentResultContent = null;
        }
        if ((i & 2) != 0) {
            str = "";
        }
        expressPurchaseResultView.KClassImpl$Data$declaredNonStaticMembers$2(paymentResultContent, str);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchaseModel.PaymentResultContent p0, String p1) {
        String string;
        String string2;
        String str;
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.illus_express_purchase_result);
        if (appCompatImageView != null) {
            AppCompatImageView appCompatImageView2 = appCompatImageView;
            final Context context = appCompatImageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            if (p0 == null || (str = p0.BuiltInFictitiousFunctionClassFactory) == null) {
                str = "";
            }
            ImageOss.MyBillsEntityDataFactory(str, appCompatImageView2, new ImageOss.EventListener() { // from class: id.dana.expresspurchase.view.ExpressPurchaseResultView$$ExternalSyntheticLambda0
                public final /* synthetic */ int MyBillsEntityDataFactory = R.drawable.ic_illustration_express_purchase_result_error;

                @Override // id.dana.utils.ImageOss.EventListener
                public final void PlaceComponentResult(String str2, ImageView imageView) {
                    ExpressPurchaseResultView.m2586$r8$lambda$s7jHhm7inJ2QACRwZsPaz7Mfns(context, this.MyBillsEntityDataFactory, str2, imageView);
                }
            });
            String string3 = appCompatImageView.getContext().getString(R.string.sdet_img_result_success);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            if (!Intrinsics.areEqual(p1, "success")) {
                string3 = "";
            }
            appCompatImageView.setContentDescription(string3);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.text_header_result);
        if (appCompatTextView != null) {
            if (p0 == null || (string2 = p0.PlaceComponentResult) == null) {
                string2 = appCompatTextView.getContext().getString(R.string.ep_general_error_header);
            }
            appCompatTextView.setText(string2);
            String string4 = appCompatTextView.getContext().getString(R.string.sdet_lbl_result_success);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            appCompatTextView.setContentDescription(Intrinsics.areEqual(p1, "success") ? string4 : "");
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.res_0x7f0a12fc_cashierphonechallengefragment_createphonenumbervalidator_1);
        if (appCompatTextView2 != null) {
            if (p0 == null || (string = p0.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                string = getContext().getString(R.string.ep_general_error_desc);
            }
            appCompatTextView2.setText(string);
        }
    }

    /* renamed from: $r8$lambda$s7jHhm7inJ2QACRwZs-Paz7Mfns  reason: not valid java name */
    public static /* synthetic */ void m2586$r8$lambda$s7jHhm7inJ2QACRwZsPaz7Mfns(Context context, int i, String str, ImageView imageView) {
        Intrinsics.checkNotNullParameter(context, "");
        ImageAttacherFactory imageAttacherFactory = new ImageAttacherFactory();
        if (str == null) {
            str = "";
        }
        imageAttacherFactory.KClassImpl$Data$declaredNonStaticMembers$2(context, imageView, str, i);
    }

    public static final /* synthetic */ ExpressPurchaseActivity access$getActivity(ExpressPurchaseResultView expressPurchaseResultView) {
        Context context = expressPurchaseResultView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        return (ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context);
    }

    public static final /* synthetic */ void access$onClickPositiveBtn(ExpressPurchaseResultView expressPurchaseResultView, ExpressPurchaseModel expressPurchaseModel, String str, String str2) {
        String str3;
        if (!Intrinsics.areEqual(str, "success")) {
            if (Intrinsics.areEqual(str, "pending")) {
                Context context = expressPurchaseResultView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "");
                ExpressPurchaseNavigationManager navigationManager = ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context)).getNavigationManager();
                Context context2 = expressPurchaseResultView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                navigationManager.getAuthRequestContext(((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context2)).getTransactionDetailContentUrl(str2), true);
            } else if (!(expressPurchaseModel instanceof ExpressPurchaseModel.Gold)) {
                if (expressPurchaseModel instanceof ExpressPurchaseModel.Insurance) {
                    Context context3 = expressPurchaseResultView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "");
                    ExpressPurchaseInsuranceViewExtender expressPurchaseInsuranceExtender = ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context3)).expressPurchaseInsuranceExtender();
                    ExpressPurchaseModel.Insurance insurance = (ExpressPurchaseModel.Insurance) expressPurchaseModel;
                    String str4 = insurance.getAuthRequestContext;
                    String str5 = insurance.PlaceComponentResult;
                    Map<String, String> map = insurance.KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkNotNullParameter(str4, "");
                    Intrinsics.checkNotNullParameter(str5, "");
                    Intrinsics.checkNotNullParameter(map, "");
                    expressPurchaseInsuranceExtender.PlaceComponentResult.getAuthRequestContext(str4, str5, map);
                }
            } else {
                Context context4 = expressPurchaseResultView.getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "");
                ((ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context4)).expressPurchaseGoldExtender().BuiltInFictitiousFunctionClassFactory((ExpressPurchaseModel.Gold) expressPurchaseModel);
            }
        } else if (!(expressPurchaseModel instanceof ExpressPurchaseModel.Gold)) {
            if (expressPurchaseModel instanceof ExpressPurchaseModel.Insurance) {
                Context context5 = expressPurchaseResultView.getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "");
                ExpressPurchaseActivity expressPurchaseActivity = (ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context5);
                String authRequestContext = UrlUtil.getAuthRequestContext(DanaUrl.MY_INSURANCE);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                expressPurchaseActivity.openUrl(authRequestContext, true);
            }
        } else {
            Context context6 = expressPurchaseResultView.getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "");
            ExpressPurchaseActivity expressPurchaseActivity2 = (ExpressPurchaseActivity) ContextExtKt.getAuthRequestContext(context6);
            ExpressPurchaseModel.PaymentResultContent paymentResultContent = expressPurchaseModel.PlaceComponentResult;
            if (paymentResultContent == null || (str3 = paymentResultContent.MyBillsEntityDataFactory) == null) {
                return;
            }
            ExpressPurchaseActivity.openUrl$default(expressPurchaseActivity2, str3, false, 2, null);
        }
    }
}
