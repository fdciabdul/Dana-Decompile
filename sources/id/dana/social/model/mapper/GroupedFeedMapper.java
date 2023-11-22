package id.dana.social.model.mapper;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.GroupedActivity;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.GroupedFeedModel;
import id.dana.utils.DateTimeUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J2\u0010\u001e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0 0\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001f2\u0006\u0010#\u001a\u00020\bH\u0002J\u0018\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010'\u001a\u0004\u0018\u00010\r2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002JB\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u001f2\u0006\u0010\u001c\u001a\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001f2\b\b\u0002\u0010#\u001a\u00020\b2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\b0-J4\u0010.\u001a\b\u0012\u0004\u0012\u00020)0\u001f2\u0006\u0010\u001c\u001a\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001f2\u0006\u0010/\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020\bJ\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u0002012\u0006\u0010\u0014\u001a\u00020\bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lid/dana/social/model/mapper/GroupedFeedMapper;", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "feedModelMapper", "Lid/dana/social/model/mapper/FeedModelMapper;", "(Landroid/content/Context;Lid/dana/social/model/mapper/FeedModelMapper;)V", "isFeedRevamp", "", "()Z", "setFeedRevamp", "(Z)V", "lastDateSection", "", "getLastDateSection$annotations", "()V", "getLastDateSection", "()Ljava/lang/String;", "setLastDateSection", "(Ljava/lang/String;)V", "shouldAddDateSection", "checkIfFeedsIsPastYear", MaintenanceBroadcastResult.KEY_DATE, "Ljava/util/Date;", "composeDateAndYear", "calculatedDate", "getDayDiff", "", "dateNow", "dateTime", "getOrderedNonDuplicateActors", "", "Ljava/util/HashMap;", "mappedActivities", "Lid/dana/social/model/FeedModel;", "excludeOwnActivity", "getSectionFeed", "diffDay", "", "getSectionText", "map", "Lid/dana/social/model/FeedViewHolderModel;", "oldItem", "Lid/dana/feeds/domain/timeline/model/GroupedActivity;", "takeUntilFunction", "Lkotlin/Function1;", "mapLatestGroupedFeedByMinId", "minId", "resetLastDiffDay", "", "setShouldAddDateSection", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class GroupedFeedMapper {
    public String BuiltInFictitiousFunctionClassFactory;
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private final Context MyBillsEntityDataFactory;
    public boolean PlaceComponentResult;
    private final FeedModelMapper getAuthRequestContext;

    @Inject
    public GroupedFeedMapper(Context context, FeedModelMapper feedModelMapper) {
        Intrinsics.checkNotNullParameter(feedModelMapper, "");
        this.MyBillsEntityDataFactory = context;
        this.getAuthRequestContext = feedModelMapper;
        this.PlaceComponentResult = true;
        this.BuiltInFictitiousFunctionClassFactory = "";
    }

    public final List<FeedViewHolderModel> MyBillsEntityDataFactory(Date date, List<GroupedActivity> list, final String str) {
        Intrinsics.checkNotNullParameter(date, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        return KClassImpl$Data$declaredNonStaticMembers$2(date, list, true, new Function1<GroupedActivity, Boolean>() { // from class: id.dana.social.model.mapper.GroupedFeedMapper$mapLatestGroupedFeedByMinId$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(GroupedActivity groupedActivity) {
                Intrinsics.checkNotNullParameter(groupedActivity, "");
                return Boolean.valueOf(Intrinsics.areEqual(groupedActivity.getId(), str));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List BuiltInFictitiousFunctionClassFactory(GroupedFeedMapper groupedFeedMapper, Date date, List list, boolean z, Function1 function1, int i) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<GroupedActivity, Boolean>() { // from class: id.dana.social.model.mapper.GroupedFeedMapper$map$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(GroupedActivity groupedActivity) {
                    Intrinsics.checkNotNullParameter(groupedActivity, "");
                    return Boolean.FALSE;
                }
            };
        }
        return groupedFeedMapper.KClassImpl$Data$declaredNonStaticMembers$2(date, list, z, function1);
    }

    /* JADX WARN: Type inference failed for: r22v0, types: [id.dana.social.model.FeedModel, kotlin.jvm.internal.DefaultConstructorMarker] */
    private List<FeedViewHolderModel> KClassImpl$Data$declaredNonStaticMembers$2(Date date, List<GroupedActivity> list, boolean z, Function1<? super GroupedActivity, Boolean> function1) {
        FeedViewHolderModel feedViewHolderModel;
        Map emptyMap;
        Intrinsics.checkNotNullParameter(date, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function1, "");
        ArrayList arrayList = new ArrayList();
        for (GroupedActivity groupedActivity : list) {
            if (function1.invoke(groupedActivity).booleanValue()) {
                break;
            }
            if (this.PlaceComponentResult) {
                long createdTime = groupedActivity.getActivities().get(0).getCreatedTime();
                long MyBillsEntityDataFactory = DateTimeUtil.MyBillsEntityDataFactory(date, new Date(createdTime));
                if (MyBillsEntityDataFactory >= 0) {
                    FeedModel BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory((int) MyBillsEntityDataFactory, new Date(createdTime));
                    String str = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4;
                    if (!(str == null || str.length() == 0) && !Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4, this.BuiltInFictitiousFunctionClassFactory)) {
                        arrayList.add(new FeedViewHolderModel(1, BuiltInFictitiousFunctionClassFactory, null, null, null, false, 60, null));
                        String str2 = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4;
                        if (str2 == null) {
                            str2 = "";
                        }
                        this.BuiltInFictitiousFunctionClassFactory = str2;
                    }
                }
            }
            this.getAuthRequestContext.MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
            List<ActivityResponse> activities = groupedActivity.getActivities();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(activities, 10));
            Iterator<T> it = activities.iterator();
            while (it.hasNext()) {
                arrayList2.add(this.getAuthRequestContext.PlaceComponentResult(date, (ActivityResponse) it.next()));
            }
            ArrayList arrayList3 = arrayList2;
            List<HashMap<String, String>> BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(arrayList3, z);
            if (groupedActivity.getActivityCount() > 1) {
                String id2 = groupedActivity.getId();
                String group = groupedActivity.getGroup();
                int activityCount = groupedActivity.getActivityCount();
                int actorCount = groupedActivity.getActorCount();
                HashMap hashMap = (HashMap) CollectionsKt.firstOrNull((List) BuiltInFictitiousFunctionClassFactory2);
                if (hashMap == null || (emptyMap = MapsKt.toMap(hashMap)) == null) {
                    emptyMap = MapsKt.emptyMap();
                }
                ?? r22 = 0;
                feedViewHolderModel = new FeedViewHolderModel(11, r22, new GroupedFeedModel(id2, group, activityCount, actorCount, arrayList3, new HashMap(emptyMap), BuiltInFictitiousFunctionClassFactory2, false, 128, r22), null, null, false, 56, null);
            } else {
                feedViewHolderModel = new FeedViewHolderModel(9, (FeedModel) arrayList3.get(0), null, null, null, false, 56, null);
            }
            arrayList.add(feedViewHolderModel);
        }
        return arrayList;
    }

    private final FeedModel BuiltInFictitiousFunctionClassFactory(int i, Date date) {
        String string;
        FeedModel.Companion companion = FeedModel.INSTANCE;
        String str = null;
        if (i == 0) {
            Context context = this.MyBillsEntityDataFactory;
            if (context != null) {
                string = context.getString(R.string.feed_section_today);
            }
            string = null;
        } else if (i == 1) {
            Context context2 = this.MyBillsEntityDataFactory;
            if (context2 != null) {
                string = context2.getString(R.string.feed_section_yesterday);
            }
            string = null;
        } else {
            string = DateTimeUtil.getAuthRequestContext(date);
        }
        if (string != null) {
            if (PlaceComponentResult(date)) {
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append(InputCardNumberView.DIVIDER);
                sb.append(DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(date));
                string = sb.toString();
            }
            str = string;
        }
        return FeedModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(str);
    }

    private static boolean PlaceComponentResult(Date date) {
        return DateTimeUtil.lookAheadTest(date) < DateTimeUtil.moveToNextValue();
    }

    private static List<HashMap<String, String>> BuiltInFictitiousFunctionClassFactory(List<FeedModel> list, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (z) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (!((FeedModel) obj).getInitRecordTimeStamp()) {
                    arrayList.add(obj);
                }
            }
            list = arrayList;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            HashMap<String, String> hashMap = ((FeedModel) it.next()).lookAheadTest;
            if (hashMap != null) {
                linkedHashMap.put(ExtendInfoUtilKt.getUserId(hashMap), hashMap);
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        ArrayList arrayList2 = new ArrayList(linkedHashMap2.size());
        Iterator it2 = linkedHashMap2.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList2.add((HashMap) ((Map.Entry) it2.next()).getValue());
        }
        return arrayList2;
    }
}
