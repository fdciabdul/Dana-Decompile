package id.dana.utils.tracker.mixpanel.globalsend;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.sendmoney.util.GlobalSendTrackerHelper;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u0016J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0016J'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0016R\u0014\u0010\n\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001a"}, d2 = {"Lid/dana/utils/tracker/mixpanel/globalsend/GlobalSendMixpanelTrackerHelperUtil;", "Lid/dana/sendmoney/util/GlobalSendTrackerHelper;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function1;)V", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "", "p1", "p2", "p3", "p4", "getAuthRequestContext", "(Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Z)V", "()V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GlobalSendMixpanelTrackerHelperUtil implements GlobalSendTrackerHelper {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    @Inject
    public GlobalSendMixpanelTrackerHelperUtil(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
    }

    @Override // id.dana.sendmoney.util.GlobalSendTrackerHelper
    public final void BuiltInFictitiousFunctionClassFactory() {
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.globalsend.GlobalSendMixpanelTrackerHelperUtil$trackOverseasOpen$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.OVERSEAS_OPEN;
            }
        });
    }

    @Override // id.dana.sendmoney.util.GlobalSendTrackerHelper
    public final void BuiltInFictitiousFunctionClassFactory(final boolean p0) {
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.globalsend.GlobalSendMixpanelTrackerHelperUtil$trackOverseasChooseUser$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.OVERSEAS_CHOOSE_USER;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.NEW_USER, p0);
            }
        });
    }

    @Override // id.dana.sendmoney.util.GlobalSendTrackerHelper
    public final void MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.globalsend.GlobalSendMixpanelTrackerHelperUtil$trackOverseasChooseCountry$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.OVERSEAS_CHOOSE_COUNTRY;
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.COUNTRY_NAME, p0);
            }
        });
    }

    @Override // id.dana.sendmoney.util.GlobalSendTrackerHelper
    public final void PlaceComponentResult() {
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.globalsend.GlobalSendMixpanelTrackerHelperUtil$trackOverseasReceiverOpen$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.OVERSEAS_RECEIVER_OPEN;
            }
        });
    }

    @Override // id.dana.sendmoney.util.GlobalSendTrackerHelper
    public final void PlaceComponentResult(final String p0, final String p1, final String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.globalsend.GlobalSendMixpanelTrackerHelperUtil$trackOverseasReceiverSubmit$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.OVERSEAS_RECEIVER_SUBMIT;
                builder.MyBillsEntityDataFactory("Source", p0);
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.COUNTRY_NAME, p1);
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.METHOD_TRANSFER, p2);
            }
        });
    }

    @Override // id.dana.sendmoney.util.GlobalSendTrackerHelper
    public final void getAuthRequestContext(final String p0, final double p1, final String p2, final String p3, final boolean p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.globalsend.GlobalSendMixpanelTrackerHelperUtil$trackOverseasCreateConfirm$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.OVERSEAS_CREATE_CONFIRM;
                builder.MyBillsEntityDataFactory("Source", p0);
                builder.MyBillsEntityDataFactory("Total Amount", p1);
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.COUNTRY_ISO, p2);
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.ISSUER_BANK_NAME, p3);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.TNC, p4);
            }
        });
    }

    @Override // id.dana.sendmoney.util.GlobalSendTrackerHelper
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        final boolean z = true;
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.globalsend.GlobalSendMixpanelTrackerHelperUtil$trackOverseasSenderDetail$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.OVERSEAS_SENDER_DETAIL;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SendMoneyProperties.CONTINUE_OVERSEAS, z);
            }
        });
    }

    private final void PlaceComponentResult(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.MyBillsEntityDataFactory);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        p0.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }
}
