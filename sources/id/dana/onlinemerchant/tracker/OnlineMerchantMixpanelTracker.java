package id.dana.onlinemerchant.tracker;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/onlinemerchant/tracker/OnlineMerchantMixpanelTracker;", "Lid/dana/onlinemerchant/tracker/OnlineMerchantAnalyticTracker;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "getAuthRequestContext", "(Lkotlin/jvm/functions/Function1;)V", "", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "p1", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Lid/dana/globalsearch/model/PaySearchInfoModel;)V", "MyBillsEntityDataFactory", "()V", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnlineMerchantMixpanelTracker implements OnlineMerchantAnalyticTracker {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Context getAuthRequestContext;

    @Inject
    public OnlineMerchantMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.getAuthRequestContext = context;
    }

    @Override // id.dana.onlinemerchant.tracker.OnlineMerchantAnalyticTracker
    public final void MyBillsEntityDataFactory() {
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.onlinemerchant.tracker.OnlineMerchantMixpanelTracker$trackOnlineMerchantPageOpen$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.EXPLORE_ONLINE_MERCHANT_OPEN;
            }
        });
    }

    @Override // id.dana.onlinemerchant.tracker.OnlineMerchantAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory(final String p0, final PaySearchInfoModel p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        getAuthRequestContext(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.onlinemerchant.tracker.OnlineMerchantMixpanelTracker$trackOnlineMerchantItemClick$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.EXPLORE_ONLINE_MERCHANT_CLICK;
                builder.MyBillsEntityDataFactory("Source", p0);
                builder.MyBillsEntityDataFactory("Merchant Name", p1.PlaceComponentResult());
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.OnlineMerchantProperties.IS_TRENDING, p1.getPrepareContext());
                builder.BuiltInFictitiousFunctionClassFactory(TrackerKey.OnlineMerchantProperties.IS_NEW, p1.getNetworkUserEntityData$$ExternalSyntheticLambda1());
                builder.MyBillsEntityDataFactory(TrackerKey.OnlineMerchantProperties.REDIRECT_URL, p1.NetworkUserEntityData$$ExternalSyntheticLambda7.get("REDIRECT_URL"));
            }
        });
    }

    private final void getAuthRequestContext(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.getAuthRequestContext);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        p0.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }
}
