package id.dana.cardbinding.tracker;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.cashier.model.QueryCardPolicyInfoModel;
import id.dana.domain.payasset.model.CardScheme;
import id.dana.model.PayMethodModel;
import id.dana.tracker.EventPropertiesModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.TextUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015"}, d2 = {"Lid/dana/cardbinding/tracker/CardBindingMixpanelTracker;", "Lid/dana/cardbinding/tracker/CardBindingAnalyticTracker;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function1;)V", "Lid/dana/cardbinding/tracker/AddCardExecutionProperties;", "(Lid/dana/cardbinding/tracker/AddCardExecutionProperties;)V", "Lid/dana/cardbinding/tracker/AddCardOpenProperties;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cardbinding/tracker/AddCardOpenProperties;)V", "Lid/dana/cardbinding/tracker/AddCardResultProperties;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cardbinding/tracker/AddCardResultProperties;)V", "Lid/dana/cardbinding/tracker/ThirdPartyRiskChallengeProperties;", "getAuthRequestContext", "(Lid/dana/cardbinding/tracker/ThirdPartyRiskChallengeProperties;)V", "Landroid/content/Context;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CardBindingMixpanelTracker implements CardBindingAnalyticTracker {
    private final Context PlaceComponentResult;

    @Inject
    public CardBindingMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
    }

    @Override // id.dana.cardbinding.tracker.CardBindingAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory(final AddCardOpenProperties p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cardbinding.tracker.CardBindingMixpanelTracker$trackAddCardOpen$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.ADD_CARD_OPEN;
                builder.MyBillsEntityDataFactory("App Name", TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
                builder.MyBillsEntityDataFactory("Source", TextUtil.KClassImpl$Data$declaredNonStaticMembers$2(AddCardOpenProperties.this.BuiltInFictitiousFunctionClassFactory));
                Long l = AddCardOpenProperties.this.getAuthRequestContext;
                if (l != null) {
                    builder.BuiltInFictitiousFunctionClassFactory("Render Time", l.longValue());
                }
                Long l2 = AddCardOpenProperties.this.MyBillsEntityDataFactory;
                if (l2 != null) {
                    builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.CardBindingProperties.API_TIME, l2.longValue());
                }
            }
        });
    }

    @Override // id.dana.cardbinding.tracker.CardBindingAnalyticTracker
    public final void PlaceComponentResult(final AddCardExecutionProperties p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cardbinding.tracker.CardBindingMixpanelTracker$trackAddCardExecution$1$1
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
                String str;
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.ADD_CARD_EXECUTION;
                builder.MyBillsEntityDataFactory("App Name", TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
                QueryCardPolicyInfoModel queryCardPolicyInfoModel = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                if (queryCardPolicyInfoModel == null || (str = queryCardPolicyInfoModel.initRecordTimeStamp) == null) {
                    QueryCardPolicyInfoModel queryCardPolicyInfoModel2 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    str = queryCardPolicyInfoModel2 != null ? queryCardPolicyInfoModel2.getAuthRequestContext : null;
                }
                QueryCardPolicyInfoModel queryCardPolicyInfoModel3 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                builder.MyBillsEntityDataFactory("Payment Method", CardBindingMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(str, queryCardPolicyInfoModel3 != null ? queryCardPolicyInfoModel3.scheduleImpl : null));
                QueryCardPolicyInfoModel queryCardPolicyInfoModel4 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_ACQUIRER, CardBindingMixpanelTracker.MyBillsEntityDataFactory(queryCardPolicyInfoModel4 != null ? queryCardPolicyInfoModel4.BuiltInFictitiousFunctionClassFactory : null));
                QueryCardPolicyInfoModel queryCardPolicyInfoModel5 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.INST_ID, queryCardPolicyInfoModel5 != null ? queryCardPolicyInfoModel5.moveToNextValue : null);
                QueryCardPolicyInfoModel queryCardPolicyInfoModel6 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                builder.MyBillsEntityDataFactory("Institution Name", queryCardPolicyInfoModel6 != null ? queryCardPolicyInfoModel6.getErrorConfigVersion : null);
                QueryCardPolicyInfoModel queryCardPolicyInfoModel7 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_BIN, queryCardPolicyInfoModel7 != null ? queryCardPolicyInfoModel7.PlaceComponentResult : null);
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_ORDER_ID, p0.getAuthRequestContext);
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_NUMBER_INPUT_TYPE, p0.MyBillsEntityDataFactory);
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_EXPIRY_INPUT_TYPE, p0.BuiltInFictitiousFunctionClassFactory);
            }
        });
    }

    @Override // id.dana.cardbinding.tracker.CardBindingAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final AddCardResultProperties p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cardbinding.tracker.CardBindingMixpanelTracker$trackAddCardResult$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.ADD_CARD_RESULT;
                builder.MyBillsEntityDataFactory("App Name", TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
                builder.BuiltInFictitiousFunctionClassFactory("Success", AddCardResultProperties.this.getNetworkUserEntityData$$ExternalSyntheticLambda0());
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_ORDER_ID, AddCardResultProperties.this.PlaceComponentResult);
                QueryCardPolicyInfoModel queryCardPolicyInfoModel = AddCardResultProperties.this.lookAheadTest;
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_ACQUIRER, CardBindingMixpanelTracker.MyBillsEntityDataFactory(queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.BuiltInFictitiousFunctionClassFactory : null));
                builder.MyBillsEntityDataFactory("Payment Method", AddCardResultProperties.this.getErrorConfigVersion);
                QueryCardPolicyInfoModel queryCardPolicyInfoModel2 = AddCardResultProperties.this.lookAheadTest;
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.INST_ID, queryCardPolicyInfoModel2 != null ? queryCardPolicyInfoModel2.moveToNextValue : null);
                QueryCardPolicyInfoModel queryCardPolicyInfoModel3 = AddCardResultProperties.this.lookAheadTest;
                builder.MyBillsEntityDataFactory("Institution Name", queryCardPolicyInfoModel3 != null ? queryCardPolicyInfoModel3.getErrorConfigVersion : null);
                QueryCardPolicyInfoModel queryCardPolicyInfoModel4 = AddCardResultProperties.this.lookAheadTest;
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_BIN, queryCardPolicyInfoModel4 != null ? queryCardPolicyInfoModel4.PlaceComponentResult : null);
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_EXPIRY_INPUT_TYPE, AddCardResultProperties.this.BuiltInFictitiousFunctionClassFactory);
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_NUMBER_INPUT_TYPE, AddCardResultProperties.this.KClassImpl$Data$declaredNonStaticMembers$2);
                builder.MyBillsEntityDataFactory("Failed Reason", AddCardResultProperties.this.getAuthRequestContext);
                Long l = AddCardResultProperties.this.MyBillsEntityDataFactory;
                if (l != null) {
                    builder.BuiltInFictitiousFunctionClassFactory("Execution Time", l.longValue());
                }
                Long l2 = AddCardResultProperties.this.moveToNextValue;
                if (l2 != null) {
                    builder.BuiltInFictitiousFunctionClassFactory("Processing Time", l2.longValue());
                }
            }
        });
    }

    @Override // id.dana.cardbinding.tracker.CardBindingAnalyticTracker
    public final void getAuthRequestContext(final ThirdPartyRiskChallengeProperties p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cardbinding.tracker.CardBindingMixpanelTracker$trackThirdPartyRiskChallenge$1
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
                String str;
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.ADD_CARD_THIRD_PARTY_RISK_CHALLENGE;
                builder.MyBillsEntityDataFactory("App Name", TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
                QueryCardPolicyInfoModel queryCardPolicyInfoModel = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                if (queryCardPolicyInfoModel == null || (str = queryCardPolicyInfoModel.initRecordTimeStamp) == null) {
                    QueryCardPolicyInfoModel queryCardPolicyInfoModel2 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    str = queryCardPolicyInfoModel2 != null ? queryCardPolicyInfoModel2.getAuthRequestContext : null;
                }
                QueryCardPolicyInfoModel queryCardPolicyInfoModel3 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                builder.MyBillsEntityDataFactory("Payment Method", CardBindingMixpanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(str, queryCardPolicyInfoModel3 != null ? queryCardPolicyInfoModel3.scheduleImpl : null));
                QueryCardPolicyInfoModel queryCardPolicyInfoModel4 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_ACQUIRER, CardBindingMixpanelTracker.MyBillsEntityDataFactory(queryCardPolicyInfoModel4 != null ? queryCardPolicyInfoModel4.BuiltInFictitiousFunctionClassFactory : null));
                QueryCardPolicyInfoModel queryCardPolicyInfoModel5 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.INST_ID, queryCardPolicyInfoModel5 != null ? queryCardPolicyInfoModel5.moveToNextValue : null);
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_ORDER_ID, p0.getAuthRequestContext);
                QueryCardPolicyInfoModel queryCardPolicyInfoModel6 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.INST_ID, queryCardPolicyInfoModel6 != null ? queryCardPolicyInfoModel6.moveToNextValue : null);
                QueryCardPolicyInfoModel queryCardPolicyInfoModel7 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                builder.MyBillsEntityDataFactory("Institution Name", queryCardPolicyInfoModel7 != null ? queryCardPolicyInfoModel7.getErrorConfigVersion : null);
                QueryCardPolicyInfoModel queryCardPolicyInfoModel8 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_BIN, queryCardPolicyInfoModel8 != null ? queryCardPolicyInfoModel8.PlaceComponentResult : null);
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_EXPIRY_INPUT_TYPE, p0.PlaceComponentResult);
                builder.MyBillsEntityDataFactory(TrackerKey.CardBindingProperties.CARD_NUMBER_INPUT_TYPE, p0.BuiltInFictitiousFunctionClassFactory);
            }
        });
    }

    private final void PlaceComponentResult(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        String str;
        EventPropertiesModel eventPropertiesModel;
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.PlaceComponentResult);
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
        DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.MIXPANEL_CARD_BINDING, sb.toString());
    }

    public static final /* synthetic */ String MyBillsEntityDataFactory(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1934979172:
                    if (str.equals(CardScheme.VISA)) {
                        return "Visa";
                    }
                    break;
                case -1062451836:
                    if (str.equals(CardScheme.JCB)) {
                        return "JCB";
                    }
                    break;
                case -1003810246:
                    if (str.equals(CardScheme.AMERICAN_EXPRESS)) {
                        return "AMEX";
                    }
                    break;
                case 70789:
                    if (str.equals(CardScheme.GPN)) {
                        return CardScheme.GPN;
                    }
                    break;
                case 425933967:
                    if (str.equals(CardScheme.BCA)) {
                        return "BCA";
                    }
                    break;
                case 1067049040:
                    if (str.equals(CardScheme.MASTERCARD)) {
                        return "Master Card";
                    }
                    break;
            }
        }
        return "Unknown acquirer";
    }

    public static final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(String str, Boolean bool) {
        boolean areEqual = Intrinsics.areEqual(str, "DEBIT_CARD");
        Boolean bool2 = Boolean.TRUE;
        if (!areEqual || !Intrinsics.areEqual(bool, bool2)) {
            if (!Intrinsics.areEqual(str, "CREDIT_CARD") || !Intrinsics.areEqual(bool, bool2)) {
                if (!Intrinsics.areEqual(str, "DIRECT_DEBIT_DEBIT_CARD")) {
                    if (!Intrinsics.areEqual(str, "DIRECT_DEBIT_CREDIT_CARD")) {
                        return Intrinsics.areEqual(str, "DEBIT_CARD") ? PayMethodModel.CashierSectionTitle.DEBIT_CARD : Intrinsics.areEqual(str, "CREDIT_CARD") ? PayMethodModel.CashierSectionTitle.CREDIT_CARD : Intrinsics.areEqual(str, "NET_BANKING") ? "Net Banking" : "Unknown method";
                    }
                }
            }
            return "Direct Debit Credit Card";
        }
        return "Direct Debit Debit Card";
    }
}
