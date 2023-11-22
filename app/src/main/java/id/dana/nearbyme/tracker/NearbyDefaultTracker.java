package id.dana.nearbyme.tracker;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.util.StringUtil;
import id.dana.nearbyme.model.ShopModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0007\u0010\u0013J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0013J/\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u0015J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u000bJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u001aX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u001b"}, d2 = {"Lid/dana/nearbyme/tracker/NearbyDefaultTracker;", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "PlaceComponentResult", "(Lkotlin/jvm/functions/Function1;)V", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "Lid/dana/nearbyme/model/ShopModel;", "p1", "MyBillsEntityDataFactory", "(Lid/dana/nearbyme/model/ShopModel;Ljava/lang/String;)V", "p2", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/text/Regex;", "Lkotlin/text/Regex;", "Landroid/content/Context;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbyDefaultTracker implements NearbyAnalyticTracker {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Regex KClassImpl$Data$declaredNonStaticMembers$2;
    public final Context MyBillsEntityDataFactory;

    @Inject
    public NearbyDefaultTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Regex("[a-zA-Z0-9]+");
    }

    @Override // id.dana.nearbyme.tracker.NearbyAnalyticTracker
    public final void getAuthRequestContext(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String str = p0;
        if ((str.length() > 0) && p0.length() > 3 && this.KClassImpl$Data$declaredNonStaticMembers$2.containsMatchIn(str)) {
            PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.nearbyme.tracker.NearbyDefaultTracker$trackNearbyOpenSearchKeyword$1
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
                    builder.MyBillsEntityDataFactory = TrackerKey.Event.NEARBY_ME_SEARCH_KEYWORD;
                    builder.MyBillsEntityDataFactory(TrackerKey.Property.SEARCH_KEYWORD, StringUtil.INSTANCE.capitalizeWords(p0));
                    builder.MyBillsEntityDataFactory(TrackerKey.Property.SEARCH_TYPE, p1);
                }
            });
        }
    }

    @Override // id.dana.nearbyme.tracker.NearbyAnalyticTracker
    public final void BuiltInFictitiousFunctionClassFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.nearbyme.tracker.NearbyDefaultTracker$trackNearbyFilterSearch$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.NEARBY_ME_SEARCH_FILTER;
                builder.MyBillsEntityDataFactory(TrackerKey.Property.SEARCH_FILTER, p0);
            }
        });
    }

    @Override // id.dana.nearbyme.tracker.NearbyAnalyticTracker
    public final void PlaceComponentResult(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.nearbyme.tracker.NearbyDefaultTracker$trackNearbyOpenAllShop$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.NEARBY_SHOP_LIST_OPEN;
                builder.MyBillsEntityDataFactory("Source", p0);
                builder.MyBillsEntityDataFactory("Merchant Name", p1);
            }
        });
    }

    @Override // id.dana.nearbyme.tracker.NearbyAnalyticTracker
    public final void MyBillsEntityDataFactory(final ShopModel p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.nearbyme.tracker.NearbyDefaultTracker$trackNearbyHomeShoppingOpen$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.NEARBY_HOME_SHOPPING_OPEN;
                builder.MyBillsEntityDataFactory("Merchant Name", ShopModel.this.NetworkUserEntityData$$ExternalSyntheticLambda6);
                builder.MyBillsEntityDataFactory("Shop Name", ShopModel.this.newProxyInstance);
                builder.MyBillsEntityDataFactory("Source", p1);
            }
        });
    }

    @Override // id.dana.nearbyme.tracker.NearbyAnalyticTracker
    public final void getAuthRequestContext(final String p0, final String p1, final String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.nearbyme.tracker.NearbyDefaultTracker$trackNearbyHomeShoppingOrder$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.NEARBY_HOME_SHOPPING_ORDER;
                builder.MyBillsEntityDataFactory("Merchant Name", p0);
                builder.MyBillsEntityDataFactory("Shop Name", p1);
                builder.MyBillsEntityDataFactory("Source", p2);
            }
        });
    }

    @Override // id.dana.nearbyme.tracker.NearbyAnalyticTracker
    public final void MyBillsEntityDataFactory() {
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.nearbyme.tracker.NearbyDefaultTracker$trackNearbySearchOpen$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.NEARBY_SEARCH_PAGE_OPEN;
            }
        });
    }

    @Override // id.dana.nearbyme.tracker.NearbyAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.nearbyme.tracker.NearbyDefaultTracker$trackOpenMapResult$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.NEARBY_SEARCH_MAP_RESULT;
            }
        });
    }

    @Override // id.dana.nearbyme.tracker.NearbyAnalyticTracker
    public final void getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.nearbyme.tracker.NearbyDefaultTracker$trackNearbyReviewListOpen$1
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
                builder.MyBillsEntityDataFactory = "Nearby Review List Open";
                builder.MyBillsEntityDataFactory("Source", p0);
            }
        });
    }

    @Override // id.dana.nearbyme.tracker.NearbyAnalyticTracker
    public final void MyBillsEntityDataFactory(final String p0, final String p1, final String p2, final String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.nearbyme.tracker.NearbyDefaultTracker$trackNearbyReviewListEdit$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.NEARBY_REVIEW_LIST_EDIT;
                builder.MyBillsEntityDataFactory("Source", p0);
                builder.MyBillsEntityDataFactory("Merchant Name", p1);
                builder.MyBillsEntityDataFactory("Merchant ID", p2);
                builder.MyBillsEntityDataFactory("Shop Name", p3);
            }
        });
    }

    @Override // id.dana.nearbyme.tracker.NearbyAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.nearbyme.tracker.NearbyDefaultTracker$trackNearbyUnreviewedListOpenAll$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.NEARBY_UNREVIEWED_LIST_OPEN_ALL;
                builder.MyBillsEntityDataFactory("Source", p0);
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
