package id.dana.electronicmoney.tracker;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ/\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0010J/\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015"}, d2 = {"Lid/dana/electronicmoney/tracker/ElectronicMoneyMixpanelTracker;", "Lid/dana/electronicmoney/tracker/ElectronicMoneyAnalyticTracker;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function1;)V", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "p1", "p2", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthRequestContext", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "Ljava/lang/String;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ElectronicMoneyMixpanelTracker implements ElectronicMoneyAnalyticTracker {
    public final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    @Inject
    public ElectronicMoneyMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.MyBillsEntityDataFactory = "";
    }

    @Override // id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory = p0;
    }

    @Override // id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker
    public final void getAuthRequestContext(final String p0, final String p1, final String p2, final String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.electronicmoney.tracker.ElectronicMoneyMixpanelTracker$trackElectronicMoneyUpdateResult$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.ELECTRONIC_MONEY_UPDATE_RESULT;
                builder.MyBillsEntityDataFactory(TrackerKey.ElectronicMoneyProperties.EMONEY_TYPE, p0);
                builder.MyBillsEntityDataFactory("Result", p1);
                if (!(p2.length() > 0)) {
                    if (!(p3.length() > 0)) {
                        return;
                    }
                }
                builder.MyBillsEntityDataFactory("Error Code", p2);
                builder.MyBillsEntityDataFactory("Error Message", p3);
            }
        });
    }

    @Override // id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker
    public final void MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.electronicmoney.tracker.ElectronicMoneyMixpanelTracker$trackElectronicMoneyActivateBalance$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.ELECTRONIC_MONEY_ACTIVATE_BALANCE;
                builder.MyBillsEntityDataFactory("Provider Name", p0);
            }
        });
    }

    @Override // id.dana.electronicmoney.tracker.ElectronicMoneyAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory(final String p0, final String p1, final String p2, final String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.electronicmoney.tracker.ElectronicMoneyMixpanelTracker$trackElectronicMoneyUpdateBalance$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.ELECTRONIC_MONEY_UPDATE_BALANCE;
                builder.MyBillsEntityDataFactory("Provider Name", p0);
                builder.MyBillsEntityDataFactory(TrackerKey.ElectronicMoneyProperties.STATUS_RESULT, p1);
                builder.MyBillsEntityDataFactory("Error Code", p2);
                builder.MyBillsEntityDataFactory("Error Message", p3);
                str = this.MyBillsEntityDataFactory;
                builder.MyBillsEntityDataFactory(TrackerKey.ElectronicMoneyProperties.SOURCE_CLICK, str);
            }
        });
    }

    private final void PlaceComponentResult(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        p0.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }
}
