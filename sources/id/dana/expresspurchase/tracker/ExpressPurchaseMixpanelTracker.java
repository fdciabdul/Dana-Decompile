package id.dana.expresspurchase.tracker;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.expresspurchase.view.ExpressPurchaseActivity;
import id.dana.tracker.EventPropertiesModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ)\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\t\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0007\u0010\u0013JE\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u001aJC\u0010\u0007\u001a\u00020\u0004*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0007\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001cX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u001d"}, d2 = {"Lid/dana/expresspurchase/tracker/ExpressPurchaseMixpanelTracker;", "Lid/dana/expresspurchase/tracker/ExpressPurchaseAnalyticTracker;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function1;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "p1", "p2", "(ZZLjava/lang/Boolean;)V", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "getAuthRequestContext", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel;)V", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$Paylater;", "(Lid/dana/expresspurchase/model/ExpressPurchaseModel$Paylater;)V", "", "p3", "p4", "p5", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/expresspurchase/model/ExpressPurchaseModel;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "(Lid/dana/tracker/EventTrackerModel$Builder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpressPurchaseMixpanelTracker implements ExpressPurchaseAnalyticTracker {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Context BuiltInFictitiousFunctionClassFactory;

    public static final /* synthetic */ String PlaceComponentResult(int i) {
        return i != 1 ? i != 2 ? "" : "Adakami" : DanaLogConstants.TAG.AKULAKU_TAG;
    }

    @Inject
    public ExpressPurchaseMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    @Override // id.dana.expresspurchase.tracker.ExpressPurchaseAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        MixPanelTracker.getAuthRequestContext(TrackerKey.Event.EXPRESS_PURCHASE_RESULT);
    }

    @Override // id.dana.expresspurchase.tracker.ExpressPurchaseAnalyticTracker
    public final void getAuthRequestContext(final ExpressPurchaseModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.expresspurchase.tracker.ExpressPurchaseMixpanelTracker$trackExpressPurchaseOpen$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.EXPRESS_PURCHASE_OPEN;
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.CASHIER_ORDER_ID, ExpressPurchaseModel.this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
                builder.MyBillsEntityDataFactory("Merchant ID", ExpressPurchaseModel.this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory);
                ExpressPurchaseModel expressPurchaseModel = ExpressPurchaseModel.this;
                if (expressPurchaseModel instanceof ExpressPurchaseModel.Deals) {
                    builder.MyBillsEntityDataFactory("Merchant Name", ((ExpressPurchaseModel.Deals) expressPurchaseModel).DatabaseTableConfigUtil);
                } else {
                    builder.MyBillsEntityDataFactory("Merchant Name", expressPurchaseModel.getAuthRequestContext.MyBillsEntityDataFactory);
                }
                builder.MyBillsEntityDataFactory(TrackerKey.CashierProperties.BUSINESS_TYPE_ID, ExpressPurchaseModel.this.getAuthRequestContext.PlaceComponentResult);
                builder.MyBillsEntityDataFactory("Action", ExpressPurchaseActivity.EP_ACTION_PURCHASE);
                ExpressPurchaseMixpanelTracker.MyBillsEntityDataFactory(ExpressPurchaseModel.this, builder);
            }
        });
    }

    private static void PlaceComponentResult(EventTrackerModel.Builder builder, String str, String str2, String str3, String str4, String str5, String str6) {
        builder.MyBillsEntityDataFactory(TrackerKey.ExpressPurchaseProperties.GOODS_MERCHANT_ID, str);
        builder.MyBillsEntityDataFactory(TrackerKey.ExpressPurchaseProperties.GOODS_MERCHANT_NAME, str2);
        builder.MyBillsEntityDataFactory(TrackerKey.ExpressPurchaseProperties.GOODS_BUSINESS_TYPE_ID, str3);
        builder.MyBillsEntityDataFactory(TrackerKey.ExpressPurchaseProperties.GOODS_ID, str4);
        builder.MyBillsEntityDataFactory(TrackerKey.ExpressPurchaseProperties.GOODS_NAME, str5);
        builder.MyBillsEntityDataFactory(TrackerKey.ExpressPurchaseProperties.AGGREGATOR, str6);
    }

    @Override // id.dana.expresspurchase.tracker.ExpressPurchaseAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final boolean p0, final boolean p1, final Boolean p2) {
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.expresspurchase.tracker.ExpressPurchaseMixpanelTracker$trackExpressPurchaseConfirmation$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.EXPRESS_PURCHASE_CONFIRMATION;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.ExpressPurchaseProperties.IS_DISMISS, p0);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.ExpressPurchaseProperties.PRICE_CHANGE, p1);
                Boolean bool = p2;
                if (bool != null) {
                    builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.ExpressPurchaseProperties.EP_CONFIRMATION_POP_UP, bool.booleanValue());
                }
            }
        });
    }

    @Override // id.dana.expresspurchase.tracker.ExpressPurchaseAnalyticTracker
    public final void MyBillsEntityDataFactory(final String p0, final String p1, final String p2, final ExpressPurchaseModel p3, final String p4, final String p5) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p4, "");
        Intrinsics.checkNotNullParameter(p5, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.expresspurchase.tracker.ExpressPurchaseMixpanelTracker$trackExpressPurchaseResult$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.EXPRESS_PURCHASE_RESULT;
                builder.MyBillsEntityDataFactory("Source", p5);
                builder.MyBillsEntityDataFactory("Status", p0);
                if (p4.length() > 0) {
                    builder.MyBillsEntityDataFactory(TrackerKey.ExpressPurchaseProperties.PRODUCT_CODE, p4);
                }
                String str = p1;
                if (str == null) {
                    str = "";
                }
                builder.MyBillsEntityDataFactory(TrackerKey.ExpressPurchaseProperties.PENDING_REASON, str);
                String str2 = p2;
                builder.MyBillsEntityDataFactory("Fail Reason", str2 != null ? str2 : "");
                ExpressPurchaseModel expressPurchaseModel = p3;
                if (expressPurchaseModel != null) {
                    ExpressPurchaseMixpanelTracker.MyBillsEntityDataFactory(expressPurchaseModel, builder);
                }
            }
        });
    }

    @Override // id.dana.expresspurchase.tracker.ExpressPurchaseAnalyticTracker
    public final void PlaceComponentResult(final ExpressPurchaseModel.Paylater p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.expresspurchase.tracker.ExpressPurchaseMixpanelTracker$trackExpressPurchasePaylaterActivation$1
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
                builder.MyBillsEntityDataFactory = "Partner";
                builder.MyBillsEntityDataFactory("Partner", ExpressPurchaseMixpanelTracker.PlaceComponentResult(p0.getAuthRequestContext));
                builder.MyBillsEntityDataFactory("Source", "Express Activation");
            }
        });
    }

    @Override // id.dana.expresspurchase.tracker.ExpressPurchaseAnalyticTracker
    public final void MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.expresspurchase.tracker.ExpressPurchaseMixpanelTracker$trackUserBuyDeals$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.EP_DEALS_BUY;
                builder.MyBillsEntityDataFactory("Merchant Name", p0);
            }
        });
    }

    private final void PlaceComponentResult(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        String str;
        EventPropertiesModel eventPropertiesModel;
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        p0.invoke(PlaceComponentResult);
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
        DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.MIXPANEL_EXPRESS_PURCHASE, sb.toString());
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(ExpressPurchaseModel expressPurchaseModel, EventTrackerModel.Builder builder) {
        if (expressPurchaseModel instanceof ExpressPurchaseModel.Gold) {
            ExpressPurchaseModel.Gold gold = (ExpressPurchaseModel.Gold) expressPurchaseModel;
            PlaceComponentResult(builder, gold.moveToNextValue.scheduleImpl, gold.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda1, gold.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2, gold.MyBillsEntityDataFactory, gold.moveToNextValue.GetContactSyncConfig, gold.BuiltInFictitiousFunctionClassFactory);
        } else if (expressPurchaseModel instanceof ExpressPurchaseModel.Insurance) {
            ExpressPurchaseModel.Insurance insurance = (ExpressPurchaseModel.Insurance) expressPurchaseModel;
            PlaceComponentResult(builder, insurance.MyBillsEntityDataFactory.scheduleImpl, insurance.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1, insurance.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, insurance.getAuthRequestContext, insurance.MyBillsEntityDataFactory.GetContactSyncConfig, "");
        } else if ((expressPurchaseModel instanceof ExpressPurchaseModel.Paylater) || !(expressPurchaseModel instanceof ExpressPurchaseModel.Deals)) {
        } else {
            ExpressPurchaseModel.Deals deals = (ExpressPurchaseModel.Deals) expressPurchaseModel;
            String str = deals.FragmentBottomSheetPaymentSettingBinding;
            String str2 = str == null ? "" : str;
            String str3 = deals.DatabaseTableConfigUtil;
            String str4 = deals.whenAvailable;
            PlaceComponentResult(builder, str2, str3, str4 == null ? "" : str4, deals.getErrorConfigVersion, deals.lookAheadTest, "");
            builder.MyBillsEntityDataFactory("Merchant Name", deals.DatabaseTableConfigUtil);
        }
    }
}
