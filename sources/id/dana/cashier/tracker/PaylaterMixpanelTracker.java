package id.dana.cashier.tracker;

import android.content.Context;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.network.exception.NetworkException;
import id.dana.tracker.EventPropertiesModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u0014J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0016J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0014J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0007\u0010\u0016R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019"}, d2 = {"Lid/dana/cashier/tracker/PaylaterMixpanelTracker;", "Lid/dana/cashier/tracker/PaylaterAnalyticTracker;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "BuiltInFictitiousFunctionClassFactory", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/content/Context;", "", "p1", "PlaceComponentResult", "(Landroid/content/Context;Ljava/lang/String;)V", "", "p2", "p3", "getAuthRequestContext", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "MyBillsEntityDataFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "scheduleImpl", "lookAheadTest", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterMixpanelTracker implements PaylaterAnalyticTracker {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public PaylaterMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }

    @Override // id.dana.cashier.tracker.PaylaterAnalyticTracker
    public final void MyBillsEntityDataFactory() {
        BuiltInFictitiousFunctionClassFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.PaylaterMixpanelTracker$trackLoanAgreementOpen$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYLATER_LOAN_AGREEMENT_OPEN;
                builder.MyBillsEntityDataFactory(TrackerKey.PaylaterProperties.PAYLATER_NAME, "PayLater Cicil");
            }
        });
    }

    @Override // id.dana.cashier.tracker.PaylaterAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BuiltInFictitiousFunctionClassFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.PaylaterMixpanelTracker$trackTncOpen$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYLATER_TNC_OPEN;
                builder.MyBillsEntityDataFactory("Partner", p0);
            }
        });
    }

    @Override // id.dana.cashier.tracker.PaylaterAnalyticTracker
    public final void PlaceComponentResult() {
        BuiltInFictitiousFunctionClassFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.PaylaterMixpanelTracker$trackPaylaterCicilRegistrationActivation$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYLATER_SUBMIT_REGISTRATION;
                builder.MyBillsEntityDataFactory(TrackerKey.PaylaterProperties.PAGE_NAME, "cashier page");
                builder.MyBillsEntityDataFactory(TrackerKey.PaylaterProperties.PAYLATER_NAME, "PayLater Cicil");
            }
        });
    }

    @Override // id.dana.cashier.tracker.PaylaterAnalyticTracker
    public final void MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BuiltInFictitiousFunctionClassFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.PaylaterMixpanelTracker$trackPaylaterCicilRegistrationPopUpOpen$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYLATER_POP_UP_REGISTRATION_OPEN;
                builder.MyBillsEntityDataFactory(TrackerKey.PaylaterProperties.PAGE_NAME, "cashier page");
                builder.MyBillsEntityDataFactory(TrackerKey.PaylaterProperties.AGREEMENT_KEY, p0);
            }
        });
    }

    @Override // id.dana.cashier.tracker.PaylaterAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        BuiltInFictitiousFunctionClassFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.PaylaterMixpanelTracker$trackPaylaterCicilRegistrationPopUpClose$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYLATER_POP_UP_REGISTRATION_CLOSE;
            }
        });
    }

    @Override // id.dana.cashier.tracker.PaylaterAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory() {
        BuiltInFictitiousFunctionClassFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.PaylaterMixpanelTracker$trackPaylaterCicilRegistrationApproved$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYLATER_REGISTRATION_APPROVED;
            }
        });
    }

    @Override // id.dana.cashier.tracker.PaylaterAnalyticTracker
    public final void getAuthRequestContext(final Throwable p0, final String p1, final String p2, final String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        BuiltInFictitiousFunctionClassFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.PaylaterMixpanelTracker$trackDisplayedError$1
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
                builder.MyBillsEntityDataFactory = "Displayed Error";
                builder.MyBillsEntityDataFactory("Source", p3);
                builder.MyBillsEntityDataFactory("Displayed Message", p2);
                Throwable th = p0;
                if (th instanceof NetworkException) {
                    String errorCode = ((NetworkException) th).getErrorCode();
                    if (errorCode == null) {
                        errorCode = "";
                    }
                    builder.MyBillsEntityDataFactory("Error Code", errorCode);
                    String traceId = ((NetworkException) p0).getTraceId();
                    if (traceId == null) {
                        traceId = "";
                    }
                    builder.MyBillsEntityDataFactory("Trace ID", traceId);
                }
                builder.MyBillsEntityDataFactory("Operation Type", p1);
                String message = p0.getMessage();
                builder.MyBillsEntityDataFactory("Error Message", message != null ? message : "");
            }
        });
    }

    @Override // id.dana.cashier.tracker.PaylaterAnalyticTracker
    public final void getAuthRequestContext() {
        BuiltInFictitiousFunctionClassFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.PaylaterMixpanelTracker$trackPaylaterCicilRepaymentConfirmationOpen$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYLATER_REPAYMENT_CONFIRMATION_OPEN;
                builder.MyBillsEntityDataFactory(TrackerKey.PaylaterProperties.PAYLATER_NAME, "PayLater Cicil");
            }
        });
    }

    @Override // id.dana.cashier.tracker.PaylaterAnalyticTracker
    public final void lookAheadTest() {
        BuiltInFictitiousFunctionClassFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.PaylaterMixpanelTracker$trackPaylaterCicilTooltipShow$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.DANA_CICIL_TOOLTIP_SHOWN;
            }
        });
    }

    @Override // id.dana.cashier.tracker.PaylaterAnalyticTracker
    public final void scheduleImpl() {
        BuiltInFictitiousFunctionClassFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.PaylaterMixpanelTracker$trackPaylaterCicilTooltipClick$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.DANA_CICIL_TOOLTIP_CLICK;
            }
        });
    }

    @Override // id.dana.cashier.tracker.PaylaterAnalyticTracker
    public final void getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BuiltInFictitiousFunctionClassFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.cashier.tracker.PaylaterMixpanelTracker$trackPaylaterCicilTncReload$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.DANA_CICIL_TNC_RELOAD;
                builder.MyBillsEntityDataFactory(TrackerKey.PaylaterProperties.RELOAD_TNC_ACTION, p0);
            }
        });
    }

    @Override // id.dana.cashier.tracker.PaylaterAnalyticTracker
    public final void PlaceComponentResult(Context p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(TrackerKey.PaylaterProperties.DANA_CICIL_STATUS, p1);
        MixPanelDataTracker.BuiltInFictitiousFunctionClassFactory(p0, jSONObject);
        MixPanelDataTracker.getAuthRequestContext(p0, jSONObject);
    }

    private final void BuiltInFictitiousFunctionClassFactory(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        String str;
        EventPropertiesModel eventPropertiesModel;
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
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
        DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.PAYLATER_CASHIER_NATIVE, sb.toString());
    }
}
