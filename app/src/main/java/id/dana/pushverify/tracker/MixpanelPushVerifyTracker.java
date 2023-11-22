package id.dana.pushverify.tracker;

import android.content.Context;
import id.dana.R;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.contract.deeplink.DeeplinkLoadTimeTracker;
import id.dana.model.DisplayedErrorModel;
import id.dana.pushverify.constant.PushVerifyTab;
import id.dana.pushverify.model.PushVerifyChallengeModel;
import id.dana.tracker.BaseEventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.ChallengeEvent;
import id.dana.tracker.mixpanel.MixPanelTracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0006\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0006\u0010\nJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0006\u0010\u0010J)\u0010\u000e\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u0013J)\u0010\u0014\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0017\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0019J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\rJ\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\rJ\u0017\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0006\u0010\rR\u0014\u0010\u000e\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001b"}, d2 = {"Lid/dana/pushverify/tracker/MixpanelPushVerifyTracker;", "Lid/dana/tracker/BaseEventTracker;", "Lid/dana/pushverify/tracker/PushVerifyTracker;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Z", "Lid/dana/pushverify/model/PushVerifyChallengeModel;", "", "(Lid/dana/pushverify/model/PushVerifyChallengeModel;)V", "", "PlaceComponentResult", "(Ljava/lang/Throwable;)V", "getAuthRequestContext", "Lid/dana/pushverify/constant/PushVerifyTab;", "(Lid/dana/pushverify/constant/PushVerifyTab;)V", "p1", "p2", "(Lid/dana/pushverify/model/PushVerifyChallengeModel;Ljava/lang/String;Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/pushverify/model/PushVerifyChallengeModel;Ljava/lang/String;Ljava/lang/String;)V", "p3", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/pushverify/model/PushVerifyChallengeModel;Ljava/lang/String;ZLjava/lang/String;)V", "(Ljava/lang/String;)V", "Landroid/content/Context;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MixpanelPushVerifyTracker extends BaseEventTracker implements PushVerifyTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context getAuthRequestContext;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[PushVerifyTab.values().length];
            iArr[PushVerifyTab.ACTIVE.ordinal()] = 1;
            iArr[PushVerifyTab.HISTORY.ordinal()] = 2;
            getAuthRequestContext = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public MixpanelPushVerifyTracker(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this.getAuthRequestContext = context;
    }

    @Override // id.dana.pushverify.tracker.PushVerifyTracker
    public final void MyBillsEntityDataFactory(PushVerifyTab p0) {
        final String str;
        Intrinsics.checkNotNullParameter(p0, "");
        int i = WhenMappings.getAuthRequestContext[p0.ordinal()];
        if (i == 1) {
            str = TrackerKey.Event.VERIFICATION_LIST_ACTIVE_TAB_OPEN;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            str = TrackerKey.Event.VERIFICATION_LIST_HISTORY_TAB_OPEN;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.pushverify.tracker.MixpanelPushVerifyTracker$trackListOpen$1
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
                builder.MyBillsEntityDataFactory = str;
            }
        });
    }

    @Override // id.dana.pushverify.tracker.PushVerifyTracker
    public final void getAuthRequestContext(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String string = this.getAuthRequestContext.getString(R.string.pushverify_list_error_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        DisplayedErrorModel.Companion companion = DisplayedErrorModel.INSTANCE;
        MixPanelTracker.getAuthRequestContext(this.getAuthRequestContext, string, "Push Verify", DisplayedErrorModel.Companion.BuiltInFictitiousFunctionClassFactory(p0, TrackerDataKey.NetworkErrorOperationTypeProperty.QUERY_LIST_PUSH_CHALLENGE));
    }

    @Override // id.dana.pushverify.tracker.PushVerifyTracker
    public final void BuiltInFictitiousFunctionClassFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        KClassImpl$Data$declaredNonStaticMembers$2(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.pushverify.tracker.MixpanelPushVerifyTracker$trackPushVerifyEntryPointOpen$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PUSH_VERIFY_ENTRY_POINT_OPEN;
                builder.MyBillsEntityDataFactory(TrackerKey.PushVerifyProperty.PUSH_VERIFY_ENTRY_POINT, p0);
            }
        });
    }

    @Override // id.dana.pushverify.tracker.PushVerifyTracker
    public final void MyBillsEntityDataFactory(final PushVerifyChallengeModel p0) {
        final long authRequestContext = PushVerifyTimer.getAuthRequestContext();
        KClassImpl$Data$declaredNonStaticMembers$2(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.pushverify.tracker.MixpanelPushVerifyTracker$trackDetailOpen$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PUSH_VERIFY_DETAIL_OPEN;
                PushVerifyChallengeModel pushVerifyChallengeModel = PushVerifyChallengeModel.this;
                builder.MyBillsEntityDataFactory(TrackerKey.PushVerifyProperty.OS_MERCHANT_PLATFORM, pushVerifyChallengeModel != null ? pushVerifyChallengeModel.getAuthRequestContext : null);
                PushVerifyChallengeModel pushVerifyChallengeModel2 = PushVerifyChallengeModel.this;
                builder.MyBillsEntityDataFactory(TrackerKey.PushVerifyProperty.REQUEST_TYPE, pushVerifyChallengeModel2 != null ? pushVerifyChallengeModel2.moveToNextValue : null);
                PushVerifyChallengeModel pushVerifyChallengeModel3 = PushVerifyChallengeModel.this;
                builder.MyBillsEntityDataFactory("Merchant ID", pushVerifyChallengeModel3 != null ? pushVerifyChallengeModel3.PlaceComponentResult : null);
                PushVerifyChallengeModel pushVerifyChallengeModel4 = PushVerifyChallengeModel.this;
                builder.MyBillsEntityDataFactory("Merchant Name", pushVerifyChallengeModel4 != null ? pushVerifyChallengeModel4.BuiltInFictitiousFunctionClassFactory : null);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.Property.LOAD_DURATION, authRequestContext);
            }
        });
    }

    @Override // id.dana.pushverify.tracker.PushVerifyTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String string = this.getAuthRequestContext.getString(R.string.pushverify_general_error_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        DisplayedErrorModel.Companion companion = DisplayedErrorModel.INSTANCE;
        MixPanelTracker.getAuthRequestContext(this.getAuthRequestContext, string, "Push Verify", DisplayedErrorModel.Companion.BuiltInFictitiousFunctionClassFactory(p0, TrackerDataKey.NetworkErrorOperationTypeProperty.QUERY_DETAIL_PUSH_CHALLENGE));
    }

    @Override // id.dana.pushverify.tracker.PushVerifyTracker
    public final void PlaceComponentResult(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String string = this.getAuthRequestContext.getString(R.string.pushverify_expired_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        DisplayedErrorModel.Companion companion = DisplayedErrorModel.INSTANCE;
        final DisplayedErrorModel BuiltInFictitiousFunctionClassFactory = DisplayedErrorModel.Companion.BuiltInFictitiousFunctionClassFactory(p0, TrackerDataKey.NetworkErrorOperationTypeProperty.QUERY_DETAIL_PUSH_CHALLENGE);
        KClassImpl$Data$declaredNonStaticMembers$2(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.pushverify.tracker.MixpanelPushVerifyTracker$trackExpiry$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PUSH_VERIFY_EXPIRY;
                builder.MyBillsEntityDataFactory(TrackerKey.PushVerifyProperty.ERROR_CODE, DisplayedErrorModel.this.PlaceComponentResult);
                builder.MyBillsEntityDataFactory(TrackerKey.PushVerifyProperty.ERROR_MESSAGE, DisplayedErrorModel.this.BuiltInFictitiousFunctionClassFactory);
            }
        });
        DisplayedErrorModel.Companion companion2 = DisplayedErrorModel.INSTANCE;
        MixPanelTracker.getAuthRequestContext(this.getAuthRequestContext, string, "Push Verify", DisplayedErrorModel.Companion.BuiltInFictitiousFunctionClassFactory(p0, TrackerDataKey.NetworkErrorOperationTypeProperty.QUERY_DETAIL_PUSH_CHALLENGE));
    }

    @Override // id.dana.pushverify.tracker.PushVerifyTracker
    public final void BuiltInFictitiousFunctionClassFactory(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String string = this.getAuthRequestContext.getString(R.string.pushverify_invalid_session_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        DisplayedErrorModel.Companion companion = DisplayedErrorModel.INSTANCE;
        MixPanelTracker.getAuthRequestContext(this.getAuthRequestContext, string, "Push Verify", DisplayedErrorModel.Companion.BuiltInFictitiousFunctionClassFactory(p0, TrackerDataKey.NetworkErrorOperationTypeProperty.QUERY_DETAIL_PUSH_CHALLENGE));
    }

    @Override // id.dana.pushverify.tracker.PushVerifyTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final PushVerifyChallengeModel p0, final String p1, final String p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        KClassImpl$Data$declaredNonStaticMembers$2(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.pushverify.tracker.MixpanelPushVerifyTracker$trackOtpInput$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.OTP_INPUT;
                builder.MyBillsEntityDataFactory(TrackerKey.PushVerifyProperty.VERIFICATION_USER_INPUT, p1);
                PushVerifyChallengeModel pushVerifyChallengeModel = p0;
                builder.MyBillsEntityDataFactory("Source", pushVerifyChallengeModel != null ? pushVerifyChallengeModel.moveToNextValue : null);
                builder.MyBillsEntityDataFactory(ChallengeEvent.Property.OTP_CHANNEL, "Push Verify");
                PushVerifyChallengeModel pushVerifyChallengeModel2 = p0;
                builder.MyBillsEntityDataFactory("Merchant ID", pushVerifyChallengeModel2 != null ? pushVerifyChallengeModel2.PlaceComponentResult : null);
                PushVerifyChallengeModel pushVerifyChallengeModel3 = p0;
                builder.MyBillsEntityDataFactory("Merchant Name", pushVerifyChallengeModel3 != null ? pushVerifyChallengeModel3.BuiltInFictitiousFunctionClassFactory : null);
                builder.MyBillsEntityDataFactory(ChallengeEvent.Property.OTP_PURPOSE, "Push Verify");
                builder.MyBillsEntityDataFactory(TrackerKey.PushVerifyProperty.PUSH_VERIFY_ENTRY_POINT, p2);
            }
        });
    }

    @Override // id.dana.pushverify.tracker.PushVerifyTracker
    public final void getAuthRequestContext(final PushVerifyChallengeModel p0, final String p1, final boolean p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        KClassImpl$Data$declaredNonStaticMembers$2(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.pushverify.tracker.MixpanelPushVerifyTracker$trackOtpCompleted$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.OTP_COMPLETED;
                builder.MyBillsEntityDataFactory(TrackerKey.PushVerifyProperty.VERIFICATION_USER_INPUT, p1);
                builder.BuiltInFictitiousFunctionClassFactory("Success", p2);
                PushVerifyChallengeModel pushVerifyChallengeModel = p0;
                builder.MyBillsEntityDataFactory("Source", pushVerifyChallengeModel != null ? pushVerifyChallengeModel.moveToNextValue : null);
                builder.MyBillsEntityDataFactory(ChallengeEvent.Property.OTP_CHANNEL, "Push Verify");
                PushVerifyChallengeModel pushVerifyChallengeModel2 = p0;
                builder.MyBillsEntityDataFactory("Merchant ID", pushVerifyChallengeModel2 != null ? pushVerifyChallengeModel2.PlaceComponentResult : null);
                PushVerifyChallengeModel pushVerifyChallengeModel3 = p0;
                builder.MyBillsEntityDataFactory("Merchant Name", pushVerifyChallengeModel3 != null ? pushVerifyChallengeModel3.BuiltInFictitiousFunctionClassFactory : null);
                builder.MyBillsEntityDataFactory(ChallengeEvent.Property.OTP_PURPOSE, "Push Verify");
                builder.PlaceComponentResult(ChallengeEvent.Property.OTP_NUMBER_OF_ATTEMPTS, 1);
                builder.PlaceComponentResult(ChallengeEvent.Property.OTP_NUMBER_OF_REQUESTS, -1);
            }
        });
    }

    @Override // id.dana.pushverify.tracker.PushVerifyTracker
    public final void MyBillsEntityDataFactory(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String string = this.getAuthRequestContext.getString(R.string.pushverify_general_error_message);
        Intrinsics.checkNotNullExpressionValue(string, "");
        DisplayedErrorModel.Companion companion = DisplayedErrorModel.INSTANCE;
        MixPanelTracker.getAuthRequestContext(this.getAuthRequestContext, string, "Push Verify", DisplayedErrorModel.Companion.BuiltInFictitiousFunctionClassFactory(p0, TrackerDataKey.NetworkErrorOperationTypeProperty.VERIFY_PUSH_CHALLENGE));
    }

    private static boolean MyBillsEntityDataFactory(String p0) {
        return Intrinsics.areEqual(p0, "Push Notification") || Intrinsics.areEqual(p0, "Inbox");
    }

    @Override // id.dana.pushverify.tracker.PushVerifyTracker
    public final void BuiltInFictitiousFunctionClassFactory(final PushVerifyChallengeModel p0, final String p1, final boolean p2, final String p3) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p3, "");
        final long MyBillsEntityDataFactory = (MyBillsEntityDataFactory(p3) ? DeeplinkLoadTimeTracker.MyBillsEntityDataFactory() : 0L) + PushVerifyTimer.getAuthRequestContext() + PushVerifyTimer.MyBillsEntityDataFactory();
        KClassImpl$Data$declaredNonStaticMembers$2(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.pushverify.tracker.MixpanelPushVerifyTracker$trackPushVerifyCompleted$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.PUSH_VERIFY_COMPLETED;
                builder.BuiltInFictitiousFunctionClassFactory("Duration", MyBillsEntityDataFactory);
                builder.MyBillsEntityDataFactory("Source", p3);
                PushVerifyChallengeModel pushVerifyChallengeModel = p0;
                builder.MyBillsEntityDataFactory(TrackerKey.PushVerifyProperty.REQUEST_TYPE, pushVerifyChallengeModel != null ? pushVerifyChallengeModel.moveToNextValue : null);
                PushVerifyChallengeModel pushVerifyChallengeModel2 = p0;
                builder.MyBillsEntityDataFactory("Merchant ID", pushVerifyChallengeModel2 != null ? pushVerifyChallengeModel2.PlaceComponentResult : null);
                PushVerifyChallengeModel pushVerifyChallengeModel3 = p0;
                builder.MyBillsEntityDataFactory("Merchant Name", pushVerifyChallengeModel3 != null ? pushVerifyChallengeModel3.BuiltInFictitiousFunctionClassFactory : null);
                builder.BuiltInFictitiousFunctionClassFactory("Success", p2);
                builder.MyBillsEntityDataFactory(TrackerKey.PushVerifyProperty.VERIFY_OPTION, p1);
            }
        });
        DeeplinkLoadTimeTracker.lookAheadTest = 0L;
    }
}
