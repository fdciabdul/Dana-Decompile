package id.dana.utils.tracker.mixpanel.mybills;

import android.content.Context;
import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;
import id.dana.mybills.tracker.MyBillsTrackerKey;
import id.dana.mybills.ui.model.BillPaymentStatusModel;
import id.dana.mybills.ui.model.BillPaymentStatusModelKt;
import id.dana.mybills.ui.v2.billdetail.util.BillDetailUtil;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0010!\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ-\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0016¢\u0006\u0004\b\n\u0010\u0011J'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u0013J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ-\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H\u0016¢\u0006\u0004\b\u0014\u0010\u0017J/\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0007\u0010\u001aJ=\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u0014\u0010\u001fJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u000bR\u0011\u0010\u0007\u001a\u00020 X\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010!"}, d2 = {"Lid/dana/utils/tracker/mixpanel/mybills/MyBillsMixpanelTracker;", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "MyBillsEntityDataFactory", "(Lkotlin/jvm/functions/Function1;)V", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "", "p1", "", "p2", "(ZLjava/lang/String;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getAuthRequestContext", "", "", "(IILjava/util/List;)V", "", "p3", "(Ljava/lang/String;Ljava/lang/String;JI)V", "p4", "PlaceComponentResult", "(IILjava/util/List;JI)V", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "(Lid/dana/mybills/ui/model/BillPaymentStatusModel;)V", "Landroid/content/Context;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MyBillsMixpanelTracker implements MyBillsAnalyticTracker {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Context MyBillsEntityDataFactory;

    @Inject
    public MyBillsMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
    }

    @Override // id.dana.mybills.tracker.MyBillsAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory(final boolean p0, final String p1, final List<String> p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.mybills.MyBillsMixpanelTracker$trackMyBillsConfirmationAction$1
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
                builder.MyBillsEntityDataFactory = MyBillsTrackerKey.MyBillsEvent.MY_BILLS_CONFIRMATION_ACTION;
                builder.BuiltInFictitiousFunctionClassFactory(MyBillsTrackerKey.MyBillsProperties.IS_PAYMENT, p0);
                builder.MyBillsEntityDataFactory(MyBillsTrackerKey.MyBillsProperties.TOTAL_BILL, p1);
                builder.MyBillsEntityDataFactory("Service Name", p2.toString());
            }
        });
    }

    @Override // id.dana.mybills.tracker.MyBillsAnalyticTracker
    public final void PlaceComponentResult(final int p0, final int p1, final List<String> p2, final long p3, final int p4) {
        Intrinsics.checkNotNullParameter(p2, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.mybills.MyBillsMixpanelTracker$trackMyBillsPaymentResult$1
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
                builder.MyBillsEntityDataFactory = MyBillsTrackerKey.MyBillsEvent.MY_BILLS_PAYMENT_RESULT;
                builder.PlaceComponentResult(MyBillsTrackerKey.MyBillsProperties.TOTAL_BILL, p4);
                builder.PlaceComponentResult(MyBillsTrackerKey.MyBillsProperties.BILL_SUCCESS, p0);
                builder.PlaceComponentResult(MyBillsTrackerKey.MyBillsProperties.BILL_FAILED, p1);
                builder.MyBillsEntityDataFactory("Service Name", p2.toString());
                builder.BuiltInFictitiousFunctionClassFactory(MyBillsTrackerKey.MyBillsProperties.TOTAL_EXECUTION_TIME, p3);
            }
        });
    }

    @Override // id.dana.mybills.tracker.MyBillsAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.mybills.MyBillsMixpanelTracker$trackMyBillsButtonAction$1
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
                builder.MyBillsEntityDataFactory = MyBillsTrackerKey.MyBillsEvent.MY_BILLS_BUTTON_ACTION;
                builder.MyBillsEntityDataFactory("Purpose", p0);
            }
        });
    }

    @Override // id.dana.mybills.tracker.MyBillsAnalyticTracker
    public final void getAuthRequestContext(final BillPaymentStatusModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.mybills.MyBillsMixpanelTracker$trackOpenMyBillsDetails$1
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
                builder.MyBillsEntityDataFactory = MyBillsTrackerKey.MyBillsEvent.MY_BILLS_SUBSCRIPTION_DETAIL_OPEN;
                BillDetailUtil billDetailUtil = BillDetailUtil.INSTANCE;
                builder.MyBillsEntityDataFactory("Merchant Name", BillDetailUtil.getAuthRequestContext(MyBillsMixpanelTracker.this.MyBillsEntityDataFactory, p0));
                builder.MyBillsEntityDataFactory(MyBillsTrackerKey.MyBillsProperties.SUBSCRIPTION_ID, p0.getSubscriptionId());
                builder.MyBillsEntityDataFactory(MyBillsTrackerKey.MyBillsProperties.GOODS_TYPE, p0.getGoodsType());
                builder.MyBillsEntityDataFactory(MyBillsTrackerKey.MyBillsProperties.SUBSCRIPTION_TYPE, p0.getRecurringType());
                builder.MyBillsEntityDataFactory("Payment Method", BillPaymentStatusModelKt.getPaymentMethodString(p0, MyBillsMixpanelTracker.this.MyBillsEntityDataFactory));
                BizProductDestination bizProductDestination = p0.getBizProductDestination();
                if (bizProductDestination != null) {
                    BillPaymentStatusModel billPaymentStatusModel = p0;
                    String type = bizProductDestination.getType();
                    if (!(type == null || type.length() == 0)) {
                        builder.MyBillsEntityDataFactory(MyBillsTrackerKey.MyBillsProperties.PRODUCT_NAME, bizProductDestination.getType());
                    }
                    String providerName = bizProductDestination.getProviderName();
                    if (!(providerName == null || providerName.length() == 0)) {
                        builder.MyBillsEntityDataFactory("Provider Name", bizProductDestination.getProviderName());
                    }
                    List<Long> period = bizProductDestination.getPeriod();
                    if (period != null) {
                        builder.PlaceComponentResult(MyBillsTrackerKey.MyBillsProperties.FREQUENCY, period.size());
                    }
                    builder.MyBillsEntityDataFactory("Status", billPaymentStatusModel.getStatus());
                }
            }
        });
    }

    @Override // id.dana.mybills.tracker.MyBillsAnalyticTracker
    public final void MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.mybills.MyBillsMixpanelTracker$trackMyBillsDetailButtonAction$1
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
                builder.MyBillsEntityDataFactory = MyBillsTrackerKey.MyBillsEvent.MY_BILLS_SUBSCRIPTION_BUTTON_ACTION;
                builder.MyBillsEntityDataFactory("Purpose", p0);
            }
        });
    }

    @Override // id.dana.mybills.tracker.MyBillsAnalyticTracker
    public final void getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.mybills.MyBillsMixpanelTracker$trackMyBillsDetailsEditAction$1
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
                builder.MyBillsEntityDataFactory = MyBillsTrackerKey.MyBillsEvent.MY_BILLS_EDIT_ACTION;
                builder.MyBillsEntityDataFactory("Purpose", p0);
            }
        });
    }

    @Override // id.dana.mybills.tracker.MyBillsAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.mybills.MyBillsMixpanelTracker$trackAddMyBillsServiceSelection$1
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
                builder.MyBillsEntityDataFactory = MyBillsTrackerKey.MyBillsEvent.MY_BILLS_SERVICE_SELECTION;
                builder.MyBillsEntityDataFactory("Service Name", p0);
            }
        });
    }

    @Override // id.dana.mybills.tracker.MyBillsAnalyticTracker
    public final void MyBillsEntityDataFactory(final String p0, final String p1, final String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.mybills.MyBillsMixpanelTracker$trackMyBillsCreateDetailOpen$1
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
                builder.MyBillsEntityDataFactory = MyBillsTrackerKey.MyBillsEvent.MY_BILLS_CREATE_DETAIL_OPEN;
                builder.MyBillsEntityDataFactory("Service Name", p0);
                builder.MyBillsEntityDataFactory("Source", p1);
                builder.MyBillsEntityDataFactory("Action", p2);
            }
        });
    }

    @Override // id.dana.mybills.tracker.MyBillsAnalyticTracker
    public final void MyBillsEntityDataFactory(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.mybills.MyBillsMixpanelTracker$trackMyBillsCreateSuccess$1
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
                builder.MyBillsEntityDataFactory = MyBillsTrackerKey.MyBillsEvent.MY_BILLS_CREATE_SUCCESS;
                builder.MyBillsEntityDataFactory("Service Name", p0);
                builder.MyBillsEntityDataFactory("Type", p1);
            }
        });
    }

    @Override // id.dana.mybills.tracker.MyBillsAnalyticTracker
    public final void getAuthRequestContext(final int p0, final int p1, final List<String> p2) {
        Intrinsics.checkNotNullParameter(p2, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.mybills.MyBillsMixpanelTracker$trackMyBillsListOpen$1
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
                builder.MyBillsEntityDataFactory = MyBillsTrackerKey.MyBillsEvent.MY_BILLS_LIST_OPEN;
                builder.PlaceComponentResult(MyBillsTrackerKey.MyBillsProperties.REMINDER_BILL, p0);
                builder.PlaceComponentResult(MyBillsTrackerKey.MyBillsProperties.SUBSCRIPTION_BILL, p1);
                builder.MyBillsEntityDataFactory(MyBillsTrackerKey.MyBillsProperties.SERVICES_NAME, p2.toString());
            }
        });
    }

    @Override // id.dana.mybills.tracker.MyBillsAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.mybills.MyBillsMixpanelTracker$trackProductIdResult$1
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
                builder.MyBillsEntityDataFactory = MyBillsTrackerKey.MyBillsEvent.MY_BILLS_PRODUCT_RESULT;
                builder.MyBillsEntityDataFactory(MyBillsTrackerKey.MyBillsProperties.CHECK_STATUS, p0);
                builder.MyBillsEntityDataFactory("Service Name", p1);
            }
        });
    }

    @Override // id.dana.mybills.tracker.MyBillsAnalyticTracker
    public final void PlaceComponentResult(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.mybills.MyBillsMixpanelTracker$trackRecentBillButtonAction$1
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
                builder.MyBillsEntityDataFactory = MyBillsTrackerKey.MyBillsEvent.MY_BILLS_RECENT_BILL_BUTTON_ACTION;
                builder.MyBillsEntityDataFactory("Service Name", p0);
            }
        });
    }

    @Override // id.dana.mybills.tracker.MyBillsAnalyticTracker
    public final void MyBillsEntityDataFactory(final String p0, final String p1, final long p2, final int p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.mybills.MyBillsMixpanelTracker$trackMyBillsOpenAvailability$1
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
                builder.MyBillsEntityDataFactory = MyBillsTrackerKey.MyBillsEvent.MY_BILLS_SUBSCRIPTION_LIST_OPEN;
                builder.MyBillsEntityDataFactory("Source", p0);
                builder.MyBillsEntityDataFactory(MyBillsTrackerKey.MyBillsProperties.RESULT_OPEN, p1);
                builder.BuiltInFictitiousFunctionClassFactory(MyBillsTrackerKey.MyBillsProperties.TOTAL_EXECUTION_TIME, p2);
                builder.PlaceComponentResult(MyBillsTrackerKey.MyBillsProperties.TOTAL_BILL, p3);
            }
        });
    }

    private final void MyBillsEntityDataFactory(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.MyBillsEntityDataFactory);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        p0.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }
}
