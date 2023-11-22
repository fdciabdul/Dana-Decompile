package id.dana.globalsearch.tracker;

import android.content.Context;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.util.StringUtil;
import id.dana.explore.model.TrackerExploreDanaOpen;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.globalsearch.model.TrackerGlobalSearchOpen;
import id.dana.globalsearch.tracker.model.SearchResultOpenTrackerModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J*\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\rH\u0016¢\u0006\u0004\b\f\u0010\u000eJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\f\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012"}, d2 = {"Lid/dana/globalsearch/tracker/GlobalSearchMixpanelTracker;", "Lid/dana/globalsearch/tracker/GlobalSearchAnalyticTracker;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "p0", "MyBillsEntityDataFactory", "(Lkotlin/jvm/functions/Function1;)V", "PlaceComponentResult", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "(Lid/dana/globalsearch/model/PaySearchInfoModel;)V", "Lid/dana/globalsearch/tracker/model/SearchResultOpenTrackerModel;", "(Lid/dana/globalsearch/tracker/model/SearchResultOpenTrackerModel;)V", "Landroid/content/Context;", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSearchMixpanelTracker implements GlobalSearchAnalyticTracker {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Context BuiltInFictitiousFunctionClassFactory;

    @Inject
    public GlobalSearchMixpanelTracker(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
    }

    @Override // id.dana.globalsearch.tracker.GlobalSearchAnalyticTracker
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.globalsearch.tracker.GlobalSearchMixpanelTracker$trackGlobalSearchOpen$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.GLOBAL_SEARCH_OPEN;
                TrackerGlobalSearchOpen trackerGlobalSearchOpen = TrackerGlobalSearchOpen.INSTANCE;
                builder.MyBillsEntityDataFactory("Source", TrackerGlobalSearchOpen.BuiltInFictitiousFunctionClassFactory());
            }
        });
    }

    @Override // id.dana.globalsearch.tracker.GlobalSearchAnalyticTracker
    public final void getAuthRequestContext() {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.globalsearch.tracker.GlobalSearchMixpanelTracker$trackPopUpEnableLocationOpen$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.POP_UP_ENABLE_LOCATION_OPEN;
            }
        });
    }

    @Override // id.dana.globalsearch.tracker.GlobalSearchAnalyticTracker
    public final void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.globalsearch.tracker.GlobalSearchMixpanelTracker$trackSearchResultBottomSheetDetailOpen$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SEARCH_RESULT_BOTTOM_SHEET_DETAIL_OPEN;
            }
        });
    }

    @Override // id.dana.globalsearch.tracker.GlobalSearchAnalyticTracker
    public final void getAuthRequestContext(final PaySearchInfoModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.globalsearch.tracker.GlobalSearchMixpanelTracker$trackSearchResultPageActionButton$1
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

            /* JADX WARN: Code restructure failed: missing block: B:24:0x008a, code lost:
            
                if (r1.equals("OFFLINE_MERCHANT") != false) goto L29;
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x0091, code lost:
            
                if (r1.equals("DF") == false) goto L28;
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x0095, code lost:
            
                r1 = r0.GetContactSyncConfig;
             */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(id.dana.tracker.EventTrackerModel.Builder r15) {
                /*
                    r14 = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
                    java.lang.String r0 = "Search Result Page Action Button"
                    r15.MyBillsEntityDataFactory = r0
                    id.dana.globalsearch.model.PaySearchInfoModel r0 = r2
                    java.lang.String r0 = id.dana.globalsearch.tracker.GlobalSearchMixpanelTracker.PlaceComponentResult(r0)
                    java.lang.String r1 = "Section"
                    r15.MyBillsEntityDataFactory(r1, r0)
                    id.dana.globalsearch.model.PaySearchInfoModel r0 = r2
                    java.lang.String r0 = r0.PlaceComponentResult()
                    java.lang.String r1 = "Merchant Name"
                    r15.MyBillsEntityDataFactory(r1, r0)
                    id.dana.globalsearch.model.PaySearchInfoModel r0 = r2
                    java.lang.String r1 = r0.getAuthRequestContext
                    java.lang.String r2 = "OFFLINE_MERCHANT"
                    boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
                    java.lang.String r4 = "DF"
                    if (r3 == 0) goto L2f
                    r1 = 1
                    goto L33
                L2f:
                    boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
                L33:
                    r3 = 0
                    if (r1 == 0) goto L4d
                    java.util.List<java.lang.String> r0 = r0.DatabaseTableConfigUtil
                    r5 = r0
                    java.lang.Iterable r5 = (java.lang.Iterable) r5
                    java.lang.String r0 = ","
                    r6 = r0
                    java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                    r7 = 0
                    r8 = 0
                    r9 = 0
                    r10 = 0
                    r11 = 0
                    r12 = 62
                    r13 = 0
                    java.lang.String r0 = kotlin.collections.CollectionsKt.joinToString$default(r5, r6, r7, r8, r9, r10, r11, r12, r13)
                    goto L4e
                L4d:
                    r0 = r3
                L4e:
                    if (r0 == 0) goto L55
                    java.lang.String r1 = "Merchant Category"
                    r15.MyBillsEntityDataFactory(r1, r0)
                L55:
                    id.dana.globalsearch.model.PaySearchInfoModel r0 = r2
                    java.lang.String r1 = r0.getAuthRequestContext
                    int r5 = r1.hashCode()
                    r6 = 2178(0x882, float:3.052E-42)
                    java.lang.String r7 = "DF_SKU"
                    if (r5 == r6) goto L8d
                    r4 = 1016896708(0x3c9c9cc4, float:0.01911772)
                    if (r5 == r4) goto L86
                    r2 = 2014341056(0x781067c0, float:1.1715548E34)
                    if (r5 != r2) goto L93
                    boolean r1 = r1.equals(r7)
                    if (r1 == 0) goto L93
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r0.getErrorConfigVersion
                    id.dana.globalsearch.dfrestaurant.model.RestaurantInfoModel r1 = id.dana.globalsearch.mapper.ConvertMapToPojoKt.getAuthRequestContext(r1)
                    java.lang.String r1 = r1.BuiltInFictitiousFunctionClassFactory
                    if (r1 != 0) goto L97
                    java.util.Map<java.lang.String, java.lang.Object> r0 = r0.getErrorConfigVersion
                    id.dana.globalsearch.dfrestaurant.model.RestaurantInfoModel r0 = id.dana.globalsearch.mapper.ConvertMapToPojoKt.getAuthRequestContext(r0)
                    java.lang.String r1 = r0.PlaceComponentResult
                    goto L97
                L86:
                    boolean r1 = r1.equals(r2)
                    if (r1 == 0) goto L93
                    goto L95
                L8d:
                    boolean r1 = r1.equals(r4)
                    if (r1 != 0) goto L95
                L93:
                    r1 = r3
                    goto L97
                L95:
                    java.lang.String r1 = r0.GetContactSyncConfig
                L97:
                    if (r1 == 0) goto L9e
                    java.lang.String r0 = "Shop Name"
                    r15.MyBillsEntityDataFactory(r0, r1)
                L9e:
                    id.dana.globalsearch.model.PaySearchInfoModel r0 = r2
                    java.lang.String r1 = r0.getAuthRequestContext
                    boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r7)
                    if (r1 == 0) goto Laa
                    java.lang.String r3 = r0.GetContactSyncConfig
                Laa:
                    if (r3 == 0) goto Lb1
                    java.lang.String r0 = "Dishes Name"
                    r15.MyBillsEntityDataFactory(r0, r3)
                Lb1:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.globalsearch.tracker.GlobalSearchMixpanelTracker$trackSearchResultPageActionButton$1.invoke2(id.dana.tracker.EventTrackerModel$Builder):void");
            }
        });
    }

    @Override // id.dana.globalsearch.tracker.GlobalSearchAnalyticTracker
    public final void PlaceComponentResult() {
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.globalsearch.tracker.GlobalSearchMixpanelTracker$trackExploreDanaOpen$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                invoke2(builder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(EventTrackerModel.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "");
                builder.MyBillsEntityDataFactory = TrackerKey.Event.EXPLORE_PAGE_OPEN;
                TrackerExploreDanaOpen trackerExploreDanaOpen = TrackerExploreDanaOpen.INSTANCE;
                builder.MyBillsEntityDataFactory("Source", TrackerExploreDanaOpen.getAuthRequestContext());
            }
        });
    }

    private final void MyBillsEntityDataFactory(Function1<? super EventTrackerModel.Builder, Unit> p0) {
        EventTrackerModel.Builder PlaceComponentResult = EventTrackerModel.Builder.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        p0.invoke(PlaceComponentResult);
        PlaceComponentResult.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(PlaceComponentResult, (byte) 0));
    }

    public static final /* synthetic */ String PlaceComponentResult(PaySearchInfoModel paySearchInfoModel) {
        String str = paySearchInfoModel.getAuthRequestContext;
        int hashCode = str.hashCode();
        if (hashCode != -1592831339) {
            if (hashCode != 2178) {
                if (hashCode != 1016896708) {
                    if (hashCode == 2014341056 && str.equals("DF_SKU")) {
                        return TrackerKey.Property.DISHES;
                    }
                } else if (str.equals("OFFLINE_MERCHANT")) {
                    return "Nearby";
                }
            } else if (str.equals("DF")) {
                return TrackerKey.Property.RESTSAURANT;
            }
        } else if (str.equals("SERVICE")) {
            return TrackerKey.Property.SERVICE;
        }
        return TrackerKey.Property.ONLINE;
    }

    @Override // id.dana.globalsearch.tracker.GlobalSearchAnalyticTracker
    public final void getAuthRequestContext(final SearchResultOpenTrackerModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (Intrinsics.areEqual(p0.BuiltInFictitiousFunctionClassFactory, "Custom")) {
            String capitalizeWords = StringUtil.INSTANCE.capitalizeWords(p0.PlaceComponentResult);
            Intrinsics.checkNotNullParameter(capitalizeWords, "");
            p0.PlaceComponentResult = capitalizeWords;
        }
        MyBillsEntityDataFactory(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.globalsearch.tracker.GlobalSearchMixpanelTracker$trackSearchResultPageOpen$1
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
                builder.MyBillsEntityDataFactory = TrackerKey.Event.SEARCH_RESULT_PAGE_OPEN;
                builder.MyBillsEntityDataFactory("Result Status", SearchResultOpenTrackerModel.this.MyBillsEntityDataFactory);
                builder.MyBillsEntityDataFactory(TrackerKey.GlobalSearchOpenProperties.KEYWORD_USAGE, SearchResultOpenTrackerModel.this.BuiltInFictitiousFunctionClassFactory);
                builder.MyBillsEntityDataFactory(TrackerKey.GlobalSearchOpenProperties.KEYWORD_RESULT, SearchResultOpenTrackerModel.this.PlaceComponentResult);
                builder.MyBillsEntityDataFactory(TrackerKey.GlobalSearchOpenProperties.SUGGESTION_ORDER, SearchResultOpenTrackerModel.this.getAuthRequestContext);
            }
        });
    }
}
