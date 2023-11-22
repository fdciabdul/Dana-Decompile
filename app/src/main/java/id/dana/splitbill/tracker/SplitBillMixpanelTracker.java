package id.dana.splitbill.tracker;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0012J'\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001a"}, d2 = {"Lid/dana/splitbill/tracker/SplitBillMixpanelTracker;", "Lid/dana/splitbill/tracker/SplitBillAnalyticTracker;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function1;)V", "", "", "p1", "", "p2", "", "p3", "getAuthRequestContext", "(IZLjava/lang/String;J)V", "(Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(I)V", "(Ljava/lang/String;JJJ)V", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SplitBillMixpanelTracker implements SplitBillAnalyticTracker {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;

    @Inject
    public SplitBillMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    @Override // id.dana.splitbill.tracker.SplitBillAnalyticTracker
    public final void getAuthRequestContext(final String p0, final long p1, final long p2, final long p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.splitbill.tracker.SplitBillMixpanelTracker$trackSplitBillOpen$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SPLIT_BILL_OPEN;
                builder.MyBillsEntityDataFactory("Source", p0);
                builder.MyBillsEntityDataFactory(TrackerKey.SplitBillProperties.SPLIT_BILL_SUCCESS_COUNT, String.valueOf(p1));
                builder.MyBillsEntityDataFactory(TrackerKey.SplitBillProperties.SPLIT_BILL_ON_PROCESS_COUNT, String.valueOf(p2));
                builder.MyBillsEntityDataFactory(TrackerKey.SplitBillProperties.SPLIT_BILL_EXPIRED_COUNT, String.valueOf(p3));
            }
        });
    }

    @Override // id.dana.splitbill.tracker.SplitBillAnalyticTracker
    public final void getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.splitbill.tracker.SplitBillMixpanelTracker$trackSplitBillCreate$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SPLIT_BILL_CREATE;
                builder.MyBillsEntityDataFactory("Source", p0);
            }
        });
    }

    @Override // id.dana.splitbill.tracker.SplitBillAnalyticTracker
    public final void getAuthRequestContext(final int p0, final boolean p1, final String p2, final long p3) {
        Intrinsics.checkNotNullParameter(p2, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.splitbill.tracker.SplitBillMixpanelTracker$trackSplitBillConfirm$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SPLIT_BILL_CONFIRM;
                builder.PlaceComponentResult(TrackerKey.SplitBillProperties.TOTAL_PARTICIPANT, p0);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SplitBillProperties.INCLUDE_SELF, p1);
                builder.MyBillsEntityDataFactory(TrackerKey.SplitBillProperties.NOTES, p2);
                builder.BuiltInFictitiousFunctionClassFactory("Total Amount", p3);
            }
        });
    }

    @Override // id.dana.splitbill.tracker.SplitBillAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory(final String p0, final String p1, final boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.splitbill.tracker.SplitBillMixpanelTracker$trackSplitBillDetailOpen$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SPLIT_BILL_DETAIL_OPEN;
                builder.MyBillsEntityDataFactory("Source", p0);
                builder.MyBillsEntityDataFactory(TrackerKey.SplitBillProperties.SPLIT_BILL_STATUS, p1);
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.SplitBillProperties.IS_PAYER, p2);
            }
        });
    }

    @Override // id.dana.splitbill.tracker.SplitBillAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final int p0) {
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.splitbill.tracker.SplitBillMixpanelTracker$trackSplitBillMarkAsPaid$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SPLIT_BILL_MARK_AS_PAID;
                builder.MyBillsEntityDataFactory(TrackerKey.SplitBillProperties.MARK_AS_PAID_USER, String.valueOf(p0));
            }
        });
    }

    @Override // id.dana.splitbill.tracker.SplitBillAnalyticTracker
    public final void MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.splitbill.tracker.SplitBillMixpanelTracker$trackSplitBillShare$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SPLIT_BILL_SHARE;
                builder.MyBillsEntityDataFactory(TrackerKey.SplitBillProperties.SPLIT_BILL_SHARE_TO, p0);
            }
        });
    }

    private final void PlaceComponentResult(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        p0.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }
}
