package id.dana.familyaccount.tracker;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\fJ'\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0014J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0015J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0007\u0010\u0015J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0007\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0010\u0010\u0017J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\nJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0007\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0018X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0019"}, d2 = {"Lid/dana/familyaccount/tracker/FamilyAccountMixpanelTracker;", "Lid/dana/familyaccount/tracker/FamilyAccountAnalyticalTracker;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "MyBillsEntityDataFactory", "(Lkotlin/jvm/functions/Function1;)V", "getAuthRequestContext", "()V", "", "(Ljava/lang/String;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "p1", "p2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "", "(Ljava/util/List;)V", "Landroid/content/Context;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyAccountMixpanelTracker implements FamilyAccountAnalyticalTracker {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Context getAuthRequestContext;

    @Inject
    public FamilyAccountMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.getAuthRequestContext = context;
    }

    @Override // id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker
    public final void getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker$trackFamilyAccountDelete$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.FAMILY_ACCOUNT_DELETE;
                builder.MyBillsEntityDataFactory("Result", p0);
            }
        });
    }

    @Override // id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker
    public final void MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker$trackFamilyAccountMemberDelete$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.FAMILY_ACCOUNT_MEMBER_DELETE;
                builder.MyBillsEntityDataFactory("Result", p0);
            }
        });
    }

    private void PlaceComponentResult(final String p0, final String p1, final String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker$trackFamilyAccountInviteMember$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.FAMILY_ACCOUNT_INVITE_MEMBER;
                builder.MyBillsEntityDataFactory(TrackerKey.FamilyAccountProperties.INVITATION_MEMBER_STATUS, p0);
                builder.MyBillsEntityDataFactory(TrackerKey.FamilyAccountProperties.RELATION, p1);
                builder.MyBillsEntityDataFactory(TrackerKey.FamilyAccountProperties.ADDRESS_POSITION, p2);
            }
        });
    }

    @Override // id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker
    public final void MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PlaceComponentResult("Success", p0, p1);
    }

    @Override // id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker
    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PlaceComponentResult("Failed", p0, p1);
    }

    @Override // id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker$trackFamilyAccountResult$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.FAMILY_ACCOUNT_RESULT;
                builder.MyBillsEntityDataFactory(TrackerKey.FamilyAccountProperties.FAMILY_ACCOUNT_STATUS, p0);
            }
        });
    }

    @Override // id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker
    public final void PlaceComponentResult(final List<String> p0) {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker$trackFamilyAccountMemberManage$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.FAMILY_ACCOUNT_MEMBER_MANAGE;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.FamilyAccountProperties.SERVICE_ACCESS, p0);
            }
        });
    }

    @Override // id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker
    public final void PlaceComponentResult(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker$trackFamilyAccountInvitationResend$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.FAMILY_ACCOUNT_INVITATION_RESEND;
                builder.MyBillsEntityDataFactory(TrackerKey.FamilyAccountProperties.IS_RESEND, p0);
            }
        });
    }

    @Override // id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker
    public final void getAuthRequestContext() {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker$trackFamilyAccountCreate$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.FAMILY_ACCOUNT_CREATE;
            }
        });
    }

    @Override // id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final boolean p0) {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker$trackFamilyAccountInvitationAccept$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.FAMILY_ACCOUNT_INVITATION_ACCEPT;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.FamilyAccountProperties.IS_JOIN, p0);
            }
        });
    }

    @Override // id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker
    public final void BuiltInFictitiousFunctionClassFactory(final boolean p0) {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker$trackFamilyAccountInvitationDecline$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.FAMILY_ACCOUNT_INVITATION_DECLINE;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.FamilyAccountProperties.IS_DECLINE, p0);
            }
        });
    }

    @Override // id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker
    public final void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker$trackFamilyAccountTopUpCreation$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.FAMILY_ACCOUNT_TOP_UP_CREATION;
            }
        });
    }

    @Override // id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker
    public final void MyBillsEntityDataFactory(final boolean p0) {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker$trackFamilyAccountTransactionApprove$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.FAMILY_ACCOUNT_TRANSACTION_APPROVE;
                builder.MyBillsEntityDataFactory(TrackerKey.FamilyAccountProperties.USE_CASE, "Send Money");
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.FamilyAccountProperties.IS_APPROVE, p0);
            }
        });
    }

    @Override // id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker
    public final void PlaceComponentResult(final boolean p0) {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.familyaccount.tracker.FamilyAccountMixpanelTracker$trackFamilyAccountInvitationCancel$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.FAMILY_ACCOUNT_INVITATION_CANCEL;
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.FamilyAccountProperties.IS_CANCEL, p0);
            }
        });
    }

    private final void MyBillsEntityDataFactory(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.getAuthRequestContext);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        p0.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }
}
