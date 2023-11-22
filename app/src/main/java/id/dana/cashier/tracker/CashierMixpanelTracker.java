package id.dana.cashier.tracker;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.cashier.helper.CashierCheckoutModelExt;
import id.dana.cashier.model.AddOnTrackingModel;
import id.dana.cashier.model.AssetCardModel;
import id.dana.cashier.model.AttributeModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.cashier.model.PayResultModel;
import id.dana.cashier.model.PaylaterCicilCheckoutModel;
import id.dana.cashier.model.featureTime.FeatureTimeModel;
import id.dana.cashier.model.tracker.PaymentConfirmationOpenTrackerParams;
import id.dana.cashier.model.tracker.PaymentExecutionTrackerParams;
import id.dana.cashier.model.tracker.PaymentResultTrackerParams;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.cashier.utils.PaymentExecutionTimeUtil;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.domain.payasset.model.PayMethod;
import id.dana.domain.paylater.model.PaylaterRepaymentType;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import id.dana.tracker.EventPropertiesModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.TextUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J!\u0010\u001d\u001a\u00020\u00152\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00150\u001f¢\u0006\u0002\b H\u0002J\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J2\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J(\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\u0015H\u0016J\b\u0010+\u001a\u00020\u0015H\u0016J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020\bH\u0016J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020\u00152\u0006\u0010/\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u00152\u0006\u0010/\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u00020\bH\u0016J1\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010\u00132\b\u0010;\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010<J\u0018\u0010=\u001a\u00020\u00152\u0006\u00108\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010>\u001a\u00020\u00152\u0006\u00108\u001a\u00020\bH\u0016J\u0012\u0010?\u001a\u00020\u00152\b\u00108\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010@\u001a\u00020\u00152\u0006\u0010A\u001a\u00020\bH\u0016J,\u0010B\u001a\u00020\u0015*\u00020\u00172\u0006\u0010C\u001a\u00020D2\u0006\u0010\u0012\u001a\u00020\u00132\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0002J\f\u0010E\u001a\u00020\b*\u00020FH\u0002J\u0016\u0010G\u001a\u00020\u0015*\u00020\u00172\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\u0014\u0010J\u001a\u00020\u0015*\u00020\u00172\u0006\u0010K\u001a\u00020LH\u0002J\u0014\u0010M\u001a\u00020\u0015*\u00020\u00172\u0006\u0010N\u001a\u00020FH\u0002J$\u0010O\u001a\u00020\u0015*\u00020\u00172\u0006\u0010P\u001a\u0002042\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020RH\u0002J\u0014\u0010T\u001a\u00020\u0015*\u00020\u00172\u0006\u0010K\u001a\u00020LH\u0002J\f\u0010U\u001a\u00020\b*\u00020VH\u0002J\u0014\u0010W\u001a\n X*\u0004\u0018\u00010\b0\b*\u00020\u0019H\u0002J\u0014\u0010Y\u001a\u00020R*\u0002042\u0006\u0010Q\u001a\u00020RH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006["}, d2 = {"Lid/dana/cashier/tracker/CashierMixpanelTracker;", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", HummerConstants.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "paymentSelectedMethods", "", "getPaymentSelectedMethods", "()Ljava/lang/String;", "setPaymentSelectedMethods", "(Ljava/lang/String;)V", "composeAddOnNameWithPrice", "availableAddons", "", "Lid/dana/cashier/model/AddOnTrackingModel$AddOn;", "selectedAddons", "isPaymentConfirmation", "", "composePaylaterProperties", "", "builder", "Lid/dana/tracker/EventTrackerModel$Builder;", InvoiceConstant.PAYMENT_METHOD, "Lid/dana/cashier/model/CashierPayMethodModel;", "composePaylaterRepaymentTypeProperties", "paylaterRepaymentType", "Lid/dana/domain/paylater/model/PaylaterRepaymentType;", "execute", "composeEvent", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "getAddOnDefaultState", "getAddOnIds", "getTrackedAddOns", "trackDisplayedError", "throwable", "", "operationType", "displayedMessage", "source", "trackNpsSurveyShow", "trackNpsSurveySubmit", "trackPaymentBannerOpen", "bannerName", "trackPaymentConfirmationOpen", "params", "Lid/dana/cashier/model/tracker/PaymentConfirmationOpenTrackerParams;", "trackPaymentExecution", "Lid/dana/cashier/model/tracker/PaymentExecutionTrackerParams;", "trackPaymentResult", "Lid/dana/cashier/model/tracker/PaymentResultTrackerParams;", "trackPaymentResultAction", "actionType", "trackPaymentRiskChallenge", CashierKeyParams.CASHIER_ORDER_ID, "riskType", "isShowPin", "isFaceVerification", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "trackPaymentSelectMethod", "trackPaymentTopupAndPayOpen", "trackPaymentTryAgainAction", "trackSmartpayOffering", "activationResult", "addAddOnProperties", "addOnTrackingModel", "Lid/dana/cashier/model/AddOnTrackingModel;", "checkPaymentStatus", "Lid/dana/cashier/model/PayResultModel;", "composeFeatureTime", "featureTimeModel", "Lid/dana/cashier/model/featureTime/FeatureTimeModel;", "composePaylaterCicilCheckoutModel", "paylaterCicilCheckoutModel", "Lid/dana/cashier/model/PaylaterCicilCheckoutModel;", "composePaymentMethodProperty", "payResultModel1", "composePaymentResultFeatureTime", "paymentResultTrackerParams", "executionTime", "", "processingTime", "composePropertyDANACICILisTrue", "getDefaultPaymentMethodForTracking", "Lid/dana/cashier/model/CashierCheckoutModel;", "getPaymentMethodForTracking", "kotlin.jvm.PlatformType", "getProcessingTime", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierMixpanelTracker implements CashierAnalyticTracker {
    public static final Companion BuiltInFictitiousFunctionClassFactory = new Companion(null);
    String PlaceComponentResult;
    public final Context getAuthRequestContext;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[PaylaterRepaymentType.values().length];
            iArr[PaylaterRepaymentType.PAYLATER_CICIL.ordinal()] = 1;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    @Inject
    public CashierMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.getAuthRequestContext = context;
        this.PlaceComponentResult = "";
    }

    @Override // id.dana.cashier.tracker.CashierAnalyticTracker
    @JvmName(name = "setPaymentSelectedMethods")
    public final void getAuthRequestContext(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = str;
    }

    @Override // id.dana.cashier.tracker.CashierAnalyticTracker
    public final void PlaceComponentResult(final PaymentConfirmationOpenTrackerParams paymentConfirmationOpenTrackerParams) {
        Intrinsics.checkNotNullParameter(paymentConfirmationOpenTrackerParams, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.CashierMixpanelTracker$trackPaymentConfirmationOpen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                List<AssetCardModel> list;
                Intrinsics.checkNotNullParameter(builder, "");
                PaymentConfirmationOpenTrackerParams paymentConfirmationOpenTrackerParams2 = PaymentConfirmationOpenTrackerParams.this;
                CashierMixpanelTracker cashierMixpanelTracker = this;
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYMENT_CONFIRMATION_OPEN;
                builder.MyBillsEntityDataFactory("Source", paymentConfirmationOpenTrackerParams2.getErrorConfigVersion);
                builder.MyBillsEntityDataFactory("App Name", TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.CASHIER_ORDER_ID, paymentConfirmationOpenTrackerParams2.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult);
                builder.MyBillsEntityDataFactory("Merchant ID", paymentConfirmationOpenTrackerParams2.NetworkUserEntityData$$ExternalSyntheticLambda0);
                AttributeModel attributeModel = paymentConfirmationOpenTrackerParams2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.BIZ_ORDER_ID, attributeModel != null ? attributeModel.getErrorConfigVersion : null);
                CashierCheckoutModelExt cashierCheckoutModelExt = CashierCheckoutModelExt.INSTANCE;
                builder.MyBillsEntityDataFactory("Merchant Name", CashierCheckoutModelExt.BuiltInFictitiousFunctionClassFactory(paymentConfirmationOpenTrackerParams2.BuiltInFictitiousFunctionClassFactory));
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.DEFAULT_PAYMENT_METHOD, CashierMixpanelTracker.getAuthRequestContext(paymentConfirmationOpenTrackerParams2.BuiltInFictitiousFunctionClassFactory));
                if (paymentConfirmationOpenTrackerParams2.PlaceComponentResult != null) {
                    CashierMixpanelTracker.getAuthRequestContext(builder, paymentConfirmationOpenTrackerParams2.PlaceComponentResult, true, (List<String>) CollectionsKt.emptyList());
                }
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.IS_BALANCE_SUFFICIENT, paymentConfirmationOpenTrackerParams2.getScheduleImpl());
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.CONFIRMATION_READY, paymentConfirmationOpenTrackerParams2.MyBillsEntityDataFactory);
                AttributeModel attributeModel2 = paymentConfirmationOpenTrackerParams2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                builder.MyBillsEntityDataFactory("productCode", attributeModel2 != null ? attributeModel2.shouldRecycleViewType : null);
                CashierMixpanelTracker.MyBillsEntityDataFactory(builder, paymentConfirmationOpenTrackerParams2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
                ArrayList arrayList = new ArrayList();
                AttributeModel attributeModel3 = paymentConfirmationOpenTrackerParams2.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
                if (attributeModel3 != null && (list = attributeModel3.PlaceComponentResult) != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        String str = ((AssetCardModel) it.next()).NetworkUserEntityData$$ExternalSyntheticLambda3;
                        if (str != null) {
                            arrayList.add(str);
                        }
                    }
                }
                builder.MyBillsEntityDataFactory("Institution Name", CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null));
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.IS_AUTOROUTING, paymentConfirmationOpenTrackerParams2.getKClassImpl$Data$declaredNonStaticMembers$2());
                CashierMixpanelTracker.getAuthRequestContext(builder, paymentConfirmationOpenTrackerParams2.getAuthRequestContext);
            }
        });
    }

    @Override // id.dana.cashier.tracker.CashierAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String str, final CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.CashierMixpanelTracker$trackPaymentSelectMethod$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYMENT_SELECT_METHOD;
                builder.MyBillsEntityDataFactory("App Name", TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.CASHIER_ORDER_ID, str);
                builder.MyBillsEntityDataFactory("Payment Method", this.PlaceComponentResult);
                CashierPayMethodModel cashierPayMethodModel2 = cashierPayMethodModel;
                if (cashierPayMethodModel2 instanceof CashierPayMethodModel.CardPayMethod) {
                    builder.MyBillsEntityDataFactory("Institution Name", ((CashierPayMethodModel.CardPayMethod) cashierPayMethodModel2).KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda3);
                }
            }
        });
    }

    @Override // id.dana.cashier.tracker.CashierAnalyticTracker
    public final void MyBillsEntityDataFactory(final PaymentExecutionTrackerParams paymentExecutionTrackerParams) {
        Intrinsics.checkNotNullParameter(paymentExecutionTrackerParams, "");
        PaymentExecutionTimeUtil paymentExecutionTimeUtil = PaymentExecutionTimeUtil.INSTANCE;
        PaymentExecutionTimeUtil.PlaceComponentResult();
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.CashierMixpanelTracker$trackPaymentExecution$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                PaymentExecutionTrackerParams paymentExecutionTrackerParams2 = PaymentExecutionTrackerParams.this;
                CashierMixpanelTracker cashierMixpanelTracker = this;
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYMENT_EXECUTION;
                builder.MyBillsEntityDataFactory("App Name", TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.CASHIER_ORDER_ID, paymentExecutionTrackerParams2.getAuthRequestContext);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.IS_MIX_PAYMENT, paymentExecutionTrackerParams2.MyBillsEntityDataFactory.getMyBillsEntityDataFactory());
                CashierPayMethodModel.NewCardData scheduleImpl = CashierPayMethodModelKt.scheduleImpl(paymentExecutionTrackerParams2.MyBillsEntityDataFactory);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.IS_SAVE_CARD, scheduleImpl != null ? scheduleImpl.getMoveToNextValue() : false);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.IS_UPGRADE_CARD, paymentExecutionTrackerParams2.MyBillsEntityDataFactory.getMoveToNextValue());
                if (paymentExecutionTrackerParams2.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    CashierMixpanelTracker.getAuthRequestContext(builder, paymentExecutionTrackerParams2.KClassImpl$Data$declaredNonStaticMembers$2, false, (List<String>) paymentExecutionTrackerParams2.lookAheadTest);
                }
                builder.MyBillsEntityDataFactory("Source", paymentExecutionTrackerParams2.getErrorConfigVersion);
                CashierMixpanelTracker.getAuthRequestContext(builder, paymentExecutionTrackerParams2.MyBillsEntityDataFactory);
                String str = paymentExecutionTrackerParams2.BuiltInFictitiousFunctionClassFactory;
                if (str != null) {
                    builder.MyBillsEntityDataFactory(TrackerKey.PaylaterProperties.PRODUCT_NAME, PaylaterRepaymentType.valueOf(str).getPaylaterName());
                }
                builder.MyBillsEntityDataFactory("Payment Method", CashierMixpanelTracker.MyBillsEntityDataFactory(cashierMixpanelTracker, paymentExecutionTrackerParams2.MyBillsEntityDataFactory));
                builder.MyBillsEntityDataFactory("productCode", paymentExecutionTrackerParams2.NetworkUserEntityData$$ExternalSyntheticLambda0);
                if (paymentExecutionTrackerParams2.MyBillsEntityDataFactory instanceof CashierPayMethodModel.CardPayMethod) {
                    builder.MyBillsEntityDataFactory("Institution Name", ((CashierPayMethodModel.CardPayMethod) paymentExecutionTrackerParams2.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda3);
                    builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_ACQUIRER, ((CashierPayMethodModel.CardPayMethod) paymentExecutionTrackerParams2.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_BIN, ((CashierPayMethodModel.CardPayMethod) paymentExecutionTrackerParams2.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
                }
                CashierMixpanelTracker.getAuthRequestContext(builder, paymentExecutionTrackerParams2.PlaceComponentResult);
            }
        });
    }

    @Override // id.dana.cashier.tracker.CashierAnalyticTracker
    public final void PlaceComponentResult(final PaymentResultTrackerParams paymentResultTrackerParams) {
        Intrinsics.checkNotNullParameter(paymentResultTrackerParams, "");
        PaymentExecutionTimeUtil paymentExecutionTimeUtil = PaymentExecutionTimeUtil.INSTANCE;
        PaymentExecutionTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2 = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.CashierMixpanelTracker$trackPaymentResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                PaymentResultTrackerParams paymentResultTrackerParams2 = PaymentResultTrackerParams.this;
                CashierMixpanelTracker cashierMixpanelTracker = this;
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYMENT_RESULT;
                builder.MyBillsEntityDataFactory("App Name", TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
                PayResultModel payResultModel = paymentResultTrackerParams2.BuiltInFictitiousFunctionClassFactory;
                if (payResultModel != null) {
                    builder.MyBillsEntityDataFactory("Source", paymentResultTrackerParams2.lookAheadTest);
                    builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.CASHIER_ORDER_ID, payResultModel.getErrorConfigVersion);
                    builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.BIZ_ORDER_ID, payResultModel.BuiltInFictitiousFunctionClassFactory);
                    builder.MyBillsEntityDataFactory("Merchant ID", payResultModel.PrepareContext);
                    builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.BUSINESS_TYPE_ID, payResultModel.getAuthRequestContext);
                    builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.PAYMENT_STATUS, CashierMixpanelTracker.PlaceComponentResult(payResultModel));
                    builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.TRANSACTION_SCHEMA, payResultModel.L);
                    builder.MyBillsEntityDataFactory("Fail Reason", payResultModel.GetContactSyncConfig);
                    if (paymentResultTrackerParams2.MyBillsEntityDataFactory != null) {
                        AddOnTrackingModel addOnTrackingModel = paymentResultTrackerParams2.MyBillsEntityDataFactory;
                        List<String> list = paymentResultTrackerParams2.BuiltInFictitiousFunctionClassFactory.G;
                        if (list == null) {
                            list = CollectionsKt.emptyList();
                        }
                        CashierMixpanelTracker.getAuthRequestContext(builder, addOnTrackingModel, false, (List<String>) list);
                    }
                    builder.MyBillsEntityDataFactory("Source", paymentResultTrackerParams2.lookAheadTest);
                    CashierPayMethodModel cashierPayMethodModel = payResultModel.I;
                    if (cashierPayMethodModel != null) {
                        CashierMixpanelTracker.getAuthRequestContext(builder, cashierPayMethodModel);
                    }
                    builder.MyBillsEntityDataFactory("productCode", payResultModel.VerifyPinStateManager$executeRiskChallenge$2$2);
                    builder.MyBillsEntityDataFactory("Merchant Name", payResultModel.FragmentBottomSheetPaymentSettingBinding);
                    builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.IS_DEEPLINK_PAYMENT, payResultModel.getInitRecordTimeStamp());
                    CashierMixpanelTracker.BuiltInFictitiousFunctionClassFactory(builder, payResultModel);
                    if (payResultModel.I instanceof CashierPayMethodModel.CardPayMethod) {
                        CashierPayMethodModel cashierPayMethodModel2 = payResultModel.I;
                        if (cashierPayMethodModel2 != null) {
                            builder.MyBillsEntityDataFactory("Institution Name", ((CashierPayMethodModel.CardPayMethod) cashierPayMethodModel2).KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda3);
                            CashierPayMethodModel cashierPayMethodModel3 = payResultModel.I;
                            if (cashierPayMethodModel3 != null) {
                                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_ACQUIRER, ((CashierPayMethodModel.CardPayMethod) cashierPayMethodModel3).KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0);
                                CashierPayMethodModel cashierPayMethodModel4 = payResultModel.I;
                                if (cashierPayMethodModel4 != null) {
                                    builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_BIN, ((CashierPayMethodModel.CardPayMethod) cashierPayMethodModel4).KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type id.dana.cashier.model.CashierPayMethodModel.CardPayMethod");
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type id.dana.cashier.model.CashierPayMethodModel.CardPayMethod");
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type id.dana.cashier.model.CashierPayMethodModel.CardPayMethod");
                        }
                    }
                    String str = payResultModel.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;
                    if (str != null) {
                        CashierMixpanelTracker.BuiltInFictitiousFunctionClassFactory(PaylaterRepaymentType.valueOf(str), builder);
                    }
                }
                builder.MyBillsEntityDataFactory("Risk Type", paymentResultTrackerParams2.PlaceComponentResult);
                PaymentExecutionTimeUtil paymentExecutionTimeUtil2 = PaymentExecutionTimeUtil.INSTANCE;
                long MyBillsEntityDataFactory = PaymentExecutionTimeUtil.MyBillsEntityDataFactory();
                PaymentExecutionTimeUtil.BuiltInFictitiousFunctionClassFactory();
                long j = MyBillsEntityDataFactory <= 0 ? 0L : MyBillsEntityDataFactory;
                if (j > 0) {
                    builder.BuiltInFictitiousFunctionClassFactory("Execution Time", j);
                }
                long PlaceComponentResult = CashierMixpanelTracker.PlaceComponentResult(paymentResultTrackerParams2, j);
                if (PlaceComponentResult > 0) {
                    builder.BuiltInFictitiousFunctionClassFactory("Processing Time", PlaceComponentResult);
                }
                CashierMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(builder, paymentResultTrackerParams2, j, PlaceComponentResult);
                builder.PlaceComponentResult(TrackerKey.CashierProperties.PAY_QUERY_COUNT, paymentResultTrackerParams2.KClassImpl$Data$declaredNonStaticMembers$2);
            }
        });
    }

    @Override // id.dana.cashier.tracker.CashierAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String str) {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.CashierMixpanelTracker$trackPaymentTryAgainAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYMENT_TRY_AGAIN_ACTION;
                String str2 = str;
                if (str2 != null) {
                    builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.CASHIER_ORDER_ID, str2);
                }
                builder.MyBillsEntityDataFactory("Payment Method", this.PlaceComponentResult);
            }
        });
    }

    @Override // id.dana.cashier.tracker.CashierAnalyticTracker
    public final void PlaceComponentResult(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.CashierMixpanelTracker$trackPaymentResultAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYMENT_RESULT_DETAIL_OPEN;
                builder.MyBillsEntityDataFactory("Purpose", str);
            }
        });
    }

    @Override // id.dana.cashier.tracker.CashierAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.CashierMixpanelTracker$trackPaymentTopupAndPayOpen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.TOPUP_METHOD_PAGE_OPEN;
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.CASHIER_ORDER_ID, str);
            }
        });
    }

    @Override // id.dana.cashier.tracker.CashierAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory(final String str, final String str2, final Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        final Boolean bool2 = null;
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.CashierMixpanelTracker$trackPaymentRiskChallenge$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYMENT_RISK_CHALLENGE;
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.CASHIER_ORDER_ID, str);
                builder.MyBillsEntityDataFactory("Risk Type", str2);
                Boolean bool3 = bool2;
                if (bool3 != null) {
                    builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.IS_SHOW_PIN, bool3.booleanValue());
                }
                Boolean bool4 = bool;
                if (bool4 != null) {
                    builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.IS_FACE_VERIFICATION, bool4.booleanValue());
                }
            }
        });
    }

    @Override // id.dana.cashier.tracker.CashierAnalyticTracker
    public final void MyBillsEntityDataFactory(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.CashierMixpanelTracker$trackPaymentBannerOpen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYMENT_RESULT_BANNER_OPEN;
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.BANNER_NAME, str);
            }
        });
    }

    private static String BuiltInFictitiousFunctionClassFactory(List<AddOnTrackingModel.AddOn> list, List<String> list2, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (AddOnTrackingModel.AddOn addOn : KClassImpl$Data$declaredNonStaticMembers$2(list, list2, z)) {
            StringBuilder sb = new StringBuilder();
            sb.append(addOn.getAuthRequestContext);
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(addOn.BuiltInFictitiousFunctionClassFactory);
            arrayList.add(sb.toString());
        }
        String joinToString$default = CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null);
        if (joinToString$default.length() == 0) {
            joinToString$default = " ";
        }
        return joinToString$default;
    }

    private static List<AddOnTrackingModel.AddOn> KClassImpl$Data$declaredNonStaticMembers$2(List<AddOnTrackingModel.AddOn> list, List<String> list2, boolean z) {
        if (z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (list2.contains(((AddOnTrackingModel.AddOn) obj).KClassImpl$Data$declaredNonStaticMembers$2)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static List<String> BuiltInFictitiousFunctionClassFactory(List<AddOnTrackingModel.AddOn> list) {
        List<AddOnTrackingModel.AddOn> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((AddOnTrackingModel.AddOn) it.next()).KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return arrayList;
    }

    private static List<String> MyBillsEntityDataFactory(List<AddOnTrackingModel.AddOn> list) {
        List<AddOnTrackingModel.AddOn> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((AddOnTrackingModel.AddOn) it.next()).getPlaceComponentResult() ? "Checked" : "Unchecked");
        }
        return arrayList;
    }

    private final void MyBillsEntityDataFactory(Function1<? super EventTrackerModel.Builder, Unit> function1) {
        String str;
        EventPropertiesModel eventPropertiesModel;
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.getAuthRequestContext);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        function1.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTrackerModel eventTrackerModel = new EventTrackerModel(PlaceComponentResult, (byte) 0);
        EventTracker.PlaceComponentResult(eventTrackerModel);
        StringBuilder sb = new StringBuilder();
        sb.append("key=");
        str = eventTrackerModel.getAuthRequestContext.MyBillsEntityDataFactory;
        sb.append(str);
        sb.append(" \n properties=");
        eventPropertiesModel = eventTrackerModel.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        sb.append(eventPropertiesModel.MyBillsEntityDataFactory);
        DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.MIXPANEL_CASHIER_NATIVE, sb.toString());
    }

    @Override // id.dana.cashier.tracker.CashierAnalyticTracker
    public final void lookAheadTest(final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.CashierMixpanelTracker$trackSmartpayOffering$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SMARTPAY_OFFERING;
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.SMARTPAY_ACTIVATION_RESULT, str);
            }
        });
    }

    @Override // id.dana.cashier.tracker.CashierAnalyticTracker
    public final void PlaceComponentResult() {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.CashierMixpanelTracker$trackNpsSurveyShow$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.NPS_SURVEY_OPEN;
            }
        });
    }

    @Override // id.dana.cashier.tracker.CashierAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.CashierMixpanelTracker$trackNpsSurveySubmit$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.NPS_SURVEY_SUBMIT;
            }
        });
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/tracker/CashierMixpanelTracker$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.lang.String PlaceComponentResult(id.dana.cashier.model.PayResultModel r1) {
        /*
            java.lang.String r1 = r1.getValueOfTouchPositionAbsolute
            if (r1 == 0) goto L3f
            int r0 = r1.hashCode()
            switch(r0) {
                case -1867169789: goto L34;
                case -861234267: goto L2b;
                case -776144932: goto L20;
                case 3135262: goto L15;
                case 422194963: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L3f
        Lc:
            java.lang.String r0 = "processing"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L28
            goto L3f
        L15:
            java.lang.String r0 = "fail"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L3f
            java.lang.String r1 = "Fail"
            goto L41
        L20:
            java.lang.String r0 = "redirect"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L3f
        L28:
            java.lang.String r1 = "Pending"
            goto L41
        L2b:
            java.lang.String r0 = "inner_redirect"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L3f
            goto L3c
        L34:
            java.lang.String r0 = "success"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L3f
        L3c:
            java.lang.String r1 = "Success"
            goto L41
        L3f:
            java.lang.String r1 = "Unknown"
        L41:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.tracker.CashierMixpanelTracker.PlaceComponentResult(id.dana.cashier.model.PayResultModel):java.lang.String");
    }

    public static final /* synthetic */ void getAuthRequestContext(EventTrackerModel.Builder builder, FeatureTimeModel featureTimeModel) {
        if (featureTimeModel != null) {
            if (StringsKt.isBlank(featureTimeModel.getAuthRequestContext)) {
                featureTimeModel = null;
            }
            if (featureTimeModel != null) {
                builder.MyBillsEntityDataFactory("Feature Name", featureTimeModel.getAuthRequestContext);
                builder.BuiltInFictitiousFunctionClassFactory("Feature Time", featureTimeModel.MyBillsEntityDataFactory);
            }
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(EventTrackerModel.Builder builder, PaylaterCicilCheckoutModel paylaterCicilCheckoutModel) {
        if ((!StringsKt.isBlank(paylaterCicilCheckoutModel.PlaceComponentResult)) != false) {
            builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.PAYLATER_REPAYMENT_SOURCE, paylaterCicilCheckoutModel.PlaceComponentResult);
        }
        builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.PaylaterProperties.IS_PAYLATER_CICIL, paylaterCicilCheckoutModel.getBuiltInFictitiousFunctionClassFactory());
        Boolean bool = paylaterCicilCheckoutModel.KClassImpl$Data$declaredNonStaticMembers$2;
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2)) {
            builder.MyBillsEntityDataFactory(TrackerKey.PaylaterProperties.DANA_CICIL_IS_TRUE, Intrinsics.areEqual(paylaterCicilCheckoutModel.getAuthRequestContext, bool2) ? "Active registered user" : "Active unregister user");
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(EventTrackerModel.Builder builder, CashierPayMethodModel cashierPayMethodModel) {
        if (Intrinsics.areEqual(cashierPayMethodModel.initRecordTimeStamp(), "ONLINE_CREDIT") || Intrinsics.areEqual(cashierPayMethodModel.initRecordTimeStamp(), PayMethod.LOAN_CREDIT)) {
            if (cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterPayMethod) {
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.INDEX_CHANNEL, ((CashierPayMethodModel.PaylaterPayMethod) cashierPayMethodModel).BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7);
            } else if (cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterCicilPayMethod) {
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.INDEX_CHANNEL, "PAYLATER_CICIL");
            }
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PaylaterRepaymentType paylaterRepaymentType, EventTrackerModel.Builder builder) {
        if (WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[paylaterRepaymentType.ordinal()] != 1) {
            throw new NoWhenBranchMatchedException();
        }
        builder.MyBillsEntityDataFactory("First Transaction Type", "PAYLATER_REPAYMENT");
        builder.MyBillsEntityDataFactory("Partner", "PayLater Cicil");
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(EventTrackerModel.Builder builder, PayResultModel payResultModel) {
        String initRecordTimeStamp;
        CashierPayChannelModel moveToNextValue;
        if (payResultModel.getNetworkUserEntityData$$ExternalSyntheticLambda7()) {
            CashierPayMethodModel cashierPayMethodModel = payResultModel.I;
            builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.TOP_UP_PAYMENT_METHOD, cashierPayMethodModel != null ? cashierPayMethodModel.initRecordTimeStamp() : null);
            builder.MyBillsEntityDataFactory("Payment Method", "Top Up and Pay");
            return;
        }
        CashierPayMethodModel cashierPayMethodModel2 = payResultModel.I;
        if (Intrinsics.areEqual((cashierPayMethodModel2 == null || (moveToNextValue = CashierPayMethodModelKt.moveToNextValue(cashierPayMethodModel2)) == null) ? null : moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda7, PayMethod.BALANCE_FAMILY)) {
            builder.MyBillsEntityDataFactory("Payment Method", "Family Account");
            return;
        }
        CashierPayMethodModel cashierPayMethodModel3 = payResultModel.I;
        if (cashierPayMethodModel3 != null && (initRecordTimeStamp = cashierPayMethodModel3.initRecordTimeStamp()) != null) {
            TextUtil.PlaceComponentResult(initRecordTimeStamp);
            Unit unit = Unit.INSTANCE;
            r2 = initRecordTimeStamp;
        }
        builder.MyBillsEntityDataFactory("Payment Method", r2);
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(EventTrackerModel.Builder builder, PaymentResultTrackerParams paymentResultTrackerParams, long j, long j2) {
        FeatureTimeModel featureTimeModel = paymentResultTrackerParams.getAuthRequestContext;
        if (featureTimeModel != null) {
            if (StringsKt.isBlank(featureTimeModel.getAuthRequestContext)) {
                featureTimeModel = null;
            }
            if (featureTimeModel != null) {
                builder.MyBillsEntityDataFactory("Feature Name", featureTimeModel.getAuthRequestContext);
                if (featureTimeModel.MyBillsEntityDataFactory > 0) {
                    builder.BuiltInFictitiousFunctionClassFactory("Feature Time", featureTimeModel.MyBillsEntityDataFactory);
                    builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.FEATURE_EXECUTION_TIME, featureTimeModel.MyBillsEntityDataFactory + j);
                    if (j2 > 0) {
                        builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.FEATURE_PROCESSING_TIME, featureTimeModel.MyBillsEntityDataFactory + j2);
                    }
                }
            }
        }
    }

    public static final /* synthetic */ String getAuthRequestContext(CashierCheckoutModel cashierCheckoutModel) {
        CashierCheckoutModelExt cashierCheckoutModelExt = CashierCheckoutModelExt.INSTANCE;
        String authRequestContext = CashierCheckoutModelExt.getAuthRequestContext(cashierCheckoutModel);
        return Intrinsics.areEqual(authRequestContext, PayMethod.BALANCE_FAMILY) ? "Family Account" : authRequestContext;
    }

    public static final /* synthetic */ String MyBillsEntityDataFactory(CashierMixpanelTracker cashierMixpanelTracker, CashierPayMethodModel cashierPayMethodModel) {
        if (cashierPayMethodModel.getLookAheadTest()) {
            return "Top Up and Pay";
        }
        if (cashierPayMethodModel.getMyBillsEntityDataFactory()) {
            StringBuilder sb = new StringBuilder();
            sb.append("BALANCE, ");
            sb.append(TextUtil.PlaceComponentResult(cashierMixpanelTracker.PlaceComponentResult));
            return sb.toString();
        }
        CashierPayChannelModel moveToNextValue = CashierPayMethodModelKt.moveToNextValue(cashierPayMethodModel);
        return Intrinsics.areEqual(moveToNextValue != null ? moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda7 : null, PayMethod.BALANCE_FAMILY) ? "Family Account" : TextUtil.PlaceComponentResult(cashierMixpanelTracker.PlaceComponentResult);
    }

    public static final /* synthetic */ long PlaceComponentResult(PaymentResultTrackerParams paymentResultTrackerParams, long j) {
        Long l;
        PayResultModel payResultModel = paymentResultTrackerParams.BuiltInFictitiousFunctionClassFactory;
        if (payResultModel == null || (l = payResultModel.P) == null) {
            return j;
        }
        if (!(l.longValue() > 0)) {
            l = null;
        }
        return l != null ? j - l.longValue() : j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getAuthRequestContext(EventTrackerModel.Builder builder, AddOnTrackingModel addOnTrackingModel, boolean z, List<String> list) {
        builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.ADD_ON_NAME, BuiltInFictitiousFunctionClassFactory(addOnTrackingModel.BuiltInFictitiousFunctionClassFactory, list, z));
        builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.ADD_ON_CHOOSEN, addOnTrackingModel.getAuthRequestContext);
        builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.ADD_ON_DISPLAYABLE, addOnTrackingModel.PlaceComponentResult);
        builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.ADD_ON_CHOOSABLE, addOnTrackingModel.MyBillsEntityDataFactory);
        if (z) {
            if (addOnTrackingModel.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.ADD_ON_AVAILABLE, "Not Available");
                return;
            }
            builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.ADD_ON_AVAILABLE, "Available");
            builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.ADD_ON_GOODS, BuiltInFictitiousFunctionClassFactory(addOnTrackingModel.BuiltInFictitiousFunctionClassFactory));
            builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.ADD_ON_DEFAULT_STATE, MyBillsEntityDataFactory(addOnTrackingModel.BuiltInFictitiousFunctionClassFactory));
            return;
        }
        List<AddOnTrackingModel.AddOn> KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(addOnTrackingModel.BuiltInFictitiousFunctionClassFactory, list, false);
        if ((!KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) == false) {
            KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CashierProperties.ADD_ON_GOODS, BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }
}
