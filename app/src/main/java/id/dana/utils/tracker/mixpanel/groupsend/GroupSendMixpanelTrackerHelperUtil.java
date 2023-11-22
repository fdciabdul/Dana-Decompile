package id.dana.utils.tracker.mixpanel.groupsend;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.network.exception.NetworkException;
import id.dana.sendmoney.util.GroupSendTrackerHelper;
import id.dana.sendmoney.util.RecipientDestinationTypeProperty;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0007\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0010J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0007\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u0018X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019"}, d2 = {"Lid/dana/utils/tracker/mixpanel/groupsend/GroupSendMixpanelTrackerHelperUtil;", "Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "MyBillsEntityDataFactory", "(Lkotlin/jvm/functions/Function1;)V", "", "", "p1", "p2", "p3", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)V", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;II)V", "PlaceComponentResult", "()V", "Landroid/content/Context;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GroupSendMixpanelTrackerHelperUtil implements GroupSendTrackerHelper {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Context PlaceComponentResult;

    @Inject
    public GroupSendMixpanelTrackerHelperUtil(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
    }

    @Override // id.dana.sendmoney.util.GroupSendTrackerHelper
    public final void PlaceComponentResult() {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.groupsend.GroupSendMixpanelTrackerHelperUtil$trackGroupSendOpen$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.GROUP_SEND_OPEN;
            }
        });
    }

    @Override // id.dana.sendmoney.util.GroupSendTrackerHelper
    public final void MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.groupsend.GroupSendMixpanelTrackerHelperUtil$trackGroupSendSelect$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.GROUP_SEND_SELECT;
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_DESTINATION_TYPE, p0);
            }
        });
    }

    @Override // id.dana.sendmoney.util.GroupSendTrackerHelper
    public final void PlaceComponentResult(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.groupsend.GroupSendMixpanelTrackerHelperUtil$trackGroupSendSearchContactOpen$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.GROUP_SEND_SEARCH_CONTACT_OPEN;
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_DESTINATION_TYPE, p0);
            }
        });
    }

    @Override // id.dana.sendmoney.util.GroupSendTrackerHelper
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.groupsend.GroupSendMixpanelTrackerHelperUtil$trackGroupSendChooseContact$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.GROUP_SEND_CHOOSE_CONTACT;
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_DESTINATION_TYPE, p0);
            }
        });
    }

    @Override // id.dana.sendmoney.util.GroupSendTrackerHelper
    public final void getAuthRequestContext(final String p0, @RecipientDestinationTypeProperty final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.groupsend.GroupSendMixpanelTrackerHelperUtil$trackGroupSendCreateOpen$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.GROUP_SEND_CREATE_OPEN;
                builder.MyBillsEntityDataFactory("Source", p0);
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_DESTINATION_TYPE, p1);
            }
        });
    }

    @Override // id.dana.sendmoney.util.GroupSendTrackerHelper
    public final void BuiltInFictitiousFunctionClassFactory(final String p0, final int p1, final int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.groupsend.GroupSendMixpanelTrackerHelperUtil$trackGroupSendCreateSubmit$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.GROUP_SEND_CREATE_SUBMIT;
                builder.MyBillsEntityDataFactory(TrackerKey.SendMoneyProperties.RECIPIENT_DESTINATION_TYPE, p0);
                builder.PlaceComponentResult(TrackerKey.Property.TOTAL_MAX_AMOUNT, p1);
                builder.PlaceComponentResult(TrackerKey.Property.NUMBER_OF_RECIPIENT, p2);
            }
        });
    }

    @Override // id.dana.sendmoney.util.GroupSendTrackerHelper
    public final void MyBillsEntityDataFactory(final Throwable p0, final String p1, final String p2, final String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.utils.tracker.mixpanel.groupsend.GroupSendMixpanelTrackerHelperUtil$trackDisplayedError$1
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

    private final void MyBillsEntityDataFactory(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.PlaceComponentResult);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        p0.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }
}
