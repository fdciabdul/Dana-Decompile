package id.dana.social.contract.notification;

import id.dana.feeds.domain.notification.interactor.GetFeedNotification;
import id.dana.feeds.domain.notification.interactor.MarkAsReadNotification;
import id.dana.feeds.domain.timeline.model.ActivityResponse;
import id.dana.feeds.domain.timeline.model.GroupedActivity;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import id.dana.social.contract.notification.FeedNotificationContract;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.GroupedFeedModel;
import id.dana.social.model.mapper.FeedNotificationMapper;
import id.dana.utils.DateTimeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B)\b\u0007\u0012\u0006\u0010\b\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020\u0014\u0012\u0006\u0010&\u001a\u00020\u001e\u0012\u0006\u0010'\u001a\u00020\u000e¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004R$\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000bj\b\u0012\u0004\u0012\u00020\u0007`\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0003\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0012\u0010\t\u001a\u00020\u0011X\u0096\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0012\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00118\u0017X\u0096\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0017\u0010\u0018R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0017X\u0097\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u0012\u0010\u001cR\u0014\u0010\u000f\u001a\u00020\u001e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001fR\u0014\u0010!\u001a\u0004\u0018\u00010\u0007X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010 R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010#\u001a\u00020\"8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b#\u0010$"}, d2 = {"Lid/dana/social/contract/notification/FeedNotificationPresenter;", "Lid/dana/social/contract/notification/FeedNotificationContract$Presenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "onDestroy", "getAuthRequestContext", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)V", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "Ljava/util/LinkedHashSet;", "Lid/dana/social/model/mapper/FeedNotificationMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/social/model/mapper/FeedNotificationMapper;", "", "MyBillsEntityDataFactory", "Z", "Lid/dana/feeds/domain/notification/interactor/GetFeedNotification;", "lookAheadTest", "Lid/dana/feeds/domain/notification/interactor/GetFeedNotification;", "BuiltInFictitiousFunctionClassFactory", "()Z", "", "Lid/dana/social/model/FeedViewHolderModel;", "Ljava/util/List;", "()Ljava/util/List;", "moveToNextValue", "Lid/dana/feeds/domain/notification/interactor/MarkAsReadNotification;", "Lid/dana/feeds/domain/notification/interactor/MarkAsReadNotification;", "Ljava/lang/String;", "getErrorConfigVersion", "Lid/dana/social/contract/notification/FeedNotificationContract$View;", "scheduleImpl", "Lid/dana/social/contract/notification/FeedNotificationContract$View;", "p1", "p2", "p3", "<init>", "(Lid/dana/social/contract/notification/FeedNotificationContract$View;Lid/dana/feeds/domain/notification/interactor/GetFeedNotification;Lid/dana/feeds/domain/notification/interactor/MarkAsReadNotification;Lid/dana/social/model/mapper/FeedNotificationMapper;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedNotificationPresenter implements FeedNotificationContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    String getErrorConfigVersion;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final LinkedHashSet<String> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final FeedNotificationMapper KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    List<FeedViewHolderModel> moveToNextValue;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetFeedNotification MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final MarkAsReadNotification NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final FeedNotificationContract.View scheduleImpl;

    @Inject
    public FeedNotificationPresenter(FeedNotificationContract.View view, GetFeedNotification getFeedNotification, MarkAsReadNotification markAsReadNotification, FeedNotificationMapper feedNotificationMapper) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getFeedNotification, "");
        Intrinsics.checkNotNullParameter(markAsReadNotification, "");
        Intrinsics.checkNotNullParameter(feedNotificationMapper, "");
        this.scheduleImpl = view;
        this.MyBillsEntityDataFactory = getFeedNotification;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = markAsReadNotification;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedNotificationMapper;
        this.moveToNextValue = CollectionsKt.emptyList();
        this.getAuthRequestContext = new LinkedHashSet<>();
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.PlaceComponentResult = true;
    }

    @Override // id.dana.social.contract.notification.FeedNotificationContract.Presenter
    @JvmName(name = "MyBillsEntityDataFactory")
    public final List<FeedViewHolderModel> MyBillsEntityDataFactory() {
        return this.moveToNextValue;
    }

    @Override // id.dana.social.contract.notification.FeedNotificationContract.Presenter
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.social.contract.notification.FeedNotificationContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.scheduleImpl.showProgress();
        this.MyBillsEntityDataFactory.executeJava1(new GetFeedNotification.Params(this.getErrorConfigVersion, this.lookAheadTest), new Function1<SocialFeed, Unit>() { // from class: id.dana.social.contract.notification.FeedNotificationPresenter$getFeedNotifications$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SocialFeed socialFeed) {
                invoke2(socialFeed);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SocialFeed socialFeed) {
                FeedNotificationContract.View view;
                FeedNotificationContract.View view2;
                Intrinsics.checkNotNullParameter(socialFeed, "");
                String str = FeedNotificationPresenter.this.getErrorConfigVersion;
                FeedNotificationPresenter.this.getErrorConfigVersion = socialFeed.getMaxId();
                FeedNotificationPresenter.this.BuiltInFictitiousFunctionClassFactory = socialFeed.getHasMore();
                List<FeedViewHolderModel> KClassImpl$Data$declaredNonStaticMembers$2 = FeedNotificationPresenter.KClassImpl$Data$declaredNonStaticMembers$2(FeedNotificationPresenter.this, socialFeed);
                String str2 = str;
                boolean z = true;
                if (!(str2 == null || str2.length() == 0)) {
                    view = FeedNotificationPresenter.this.scheduleImpl;
                    view.dismissProgress();
                } else {
                    FeedNotificationPresenter feedNotificationPresenter = FeedNotificationPresenter.this;
                    Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
                    feedNotificationPresenter.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2;
                }
                view2 = FeedNotificationPresenter.this.scheduleImpl;
                if (str2 != null && str2.length() != 0) {
                    z = false;
                }
                view2.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, z, socialFeed.getHasMore());
                FeedNotificationPresenter.getAuthRequestContext(FeedNotificationPresenter.this, KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.contract.notification.FeedNotificationPresenter$getFeedNotifications$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                FeedNotificationContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                FeedNotificationPresenter.MyBillsEntityDataFactory(FeedNotificationPresenter.this);
                view = FeedNotificationPresenter.this.scheduleImpl;
                return view.BuiltInFictitiousFunctionClassFactory();
            }
        }, this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // id.dana.social.contract.notification.FeedNotificationContract.Presenter
    public final void PlaceComponentResult() {
        this.getErrorConfigVersion = null;
        this.lookAheadTest = null;
        List<FeedViewHolderModel> emptyList = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(emptyList, "");
        this.moveToNextValue = emptyList;
        FeedNotificationMapper feedNotificationMapper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter("", "");
        feedNotificationMapper.PlaceComponentResult = "";
        this.scheduleImpl.showProgress();
        this.MyBillsEntityDataFactory.executeJava1(new GetFeedNotification.Params(this.getErrorConfigVersion, this.lookAheadTest), new Function1<SocialFeed, Unit>() { // from class: id.dana.social.contract.notification.FeedNotificationPresenter$refreshFeedNotifications$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SocialFeed socialFeed) {
                invoke2(socialFeed);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SocialFeed socialFeed) {
                FeedNotificationContract.View view;
                FeedNotificationContract.View view2;
                Intrinsics.checkNotNullParameter(socialFeed, "");
                List<FeedViewHolderModel> KClassImpl$Data$declaredNonStaticMembers$2 = FeedNotificationPresenter.KClassImpl$Data$declaredNonStaticMembers$2(FeedNotificationPresenter.this, socialFeed);
                if (FeedNotificationPresenter.this.getErrorConfigVersion != null) {
                    view = FeedNotificationPresenter.this.scheduleImpl;
                    view.dismissProgress();
                } else {
                    FeedNotificationPresenter feedNotificationPresenter = FeedNotificationPresenter.this;
                    Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
                    feedNotificationPresenter.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2;
                }
                view2 = FeedNotificationPresenter.this.scheduleImpl;
                view2.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, socialFeed.getHasMore());
                FeedNotificationPresenter.this.getErrorConfigVersion = socialFeed.getMaxId();
                FeedNotificationPresenter.this.BuiltInFictitiousFunctionClassFactory = socialFeed.getHasMore();
                FeedNotificationPresenter.getAuthRequestContext(FeedNotificationPresenter.this, KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.contract.notification.FeedNotificationPresenter$refreshFeedNotifications$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                FeedNotificationContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                FeedNotificationPresenter.MyBillsEntityDataFactory(FeedNotificationPresenter.this);
                view = FeedNotificationPresenter.this.scheduleImpl;
                return view.BuiltInFictitiousFunctionClassFactory();
            }
        }, this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // id.dana.social.contract.notification.FeedNotificationContract.Presenter
    public final void getAuthRequestContext() {
        if (this.getAuthRequestContext.isEmpty()) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.executeJava1(new MarkAsReadNotification.Params(CollectionsKt.emptyList()), new Function1<Boolean, Unit>() { // from class: id.dana.social.contract.notification.FeedNotificationPresenter$readAllVisibleNotification$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                FeedNotificationContract.View view;
                LinkedHashSet linkedHashSet;
                view = FeedNotificationPresenter.this.scheduleImpl;
                view.MyBillsEntityDataFactory();
                linkedHashSet = FeedNotificationPresenter.this.getAuthRequestContext;
                linkedHashSet.clear();
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.contract.notification.FeedNotificationPresenter$readAllVisibleNotification$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                FeedNotificationContract.View view;
                FeedNotificationContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = FeedNotificationPresenter.this.scheduleImpl;
                view.PlaceComponentResult();
                view2 = FeedNotificationPresenter.this.scheduleImpl;
                return view2.BuiltInFictitiousFunctionClassFactory();
            }
        }, this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // id.dana.social.contract.notification.FeedNotificationContract.Presenter
    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new MarkAsReadNotification.Params(CollectionsKt.listOf(p0)), new Function1<Boolean, Unit>() { // from class: id.dana.social.contract.notification.FeedNotificationPresenter$readFeedNotification$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.notification.FeedNotificationPresenter$readFeedNotification$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        FeedNotificationMapper feedNotificationMapper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter("", "");
        feedNotificationMapper.PlaceComponentResult = "";
        this.MyBillsEntityDataFactory.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
    }

    public static final /* synthetic */ void getAuthRequestContext(FeedNotificationPresenter feedNotificationPresenter, List list) {
        String str;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FeedViewHolderModel feedViewHolderModel = (FeedViewHolderModel) it.next();
            String str2 = "";
            if (feedViewHolderModel.MyBillsEntityDataFactory != null) {
                LinkedHashSet<String> linkedHashSet = feedNotificationPresenter.getAuthRequestContext;
                FeedModel feedModel = feedViewHolderModel.MyBillsEntityDataFactory;
                if (feedModel != null && (str = feedModel.BuiltInFictitiousFunctionClassFactory) != null) {
                    str2 = str;
                }
                linkedHashSet.add(str2);
            } else {
                GroupedFeedModel groupedFeedModel = feedViewHolderModel.BuiltInFictitiousFunctionClassFactory;
                List<FeedModel> list2 = groupedFeedModel != null ? groupedFeedModel.BuiltInFictitiousFunctionClassFactory : null;
                if (list2 == null) {
                    list2 = CollectionsKt.emptyList();
                }
                for (FeedModel feedModel2 : list2) {
                    LinkedHashSet<String> linkedHashSet2 = feedNotificationPresenter.getAuthRequestContext;
                    String str3 = feedModel2.BuiltInFictitiousFunctionClassFactory;
                    if (str3 == null) {
                        str3 = "";
                    }
                    linkedHashSet2.add(str3);
                }
            }
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(FeedNotificationPresenter feedNotificationPresenter) {
        if (feedNotificationPresenter.getErrorConfigVersion != null) {
            feedNotificationPresenter.scheduleImpl.dismissProgress();
        }
        feedNotificationPresenter.scheduleImpl.PlaceComponentResult(CollectionsKt.emptyList(), feedNotificationPresenter.getErrorConfigVersion == null, false);
    }

    public static final /* synthetic */ List KClassImpl$Data$declaredNonStaticMembers$2(FeedNotificationPresenter feedNotificationPresenter, SocialFeed socialFeed) {
        FeedViewHolderModel feedViewHolderModel;
        Map emptyMap;
        if (socialFeed.isFeedNotVersionTwo()) {
            FeedNotificationMapper feedNotificationMapper = feedNotificationPresenter.KClassImpl$Data$declaredNonStaticMembers$2;
            Date date = new Date();
            List<GroupedActivity> groupedActivities = socialFeed.getGroupedActivities();
            Intrinsics.checkNotNullParameter(date, "");
            Intrinsics.checkNotNullParameter(groupedActivities, "");
            ArrayList arrayList = new ArrayList();
            for (GroupedActivity groupedActivity : groupedActivities) {
                Date date2 = new Date(groupedActivity.getActivities().get(0).getCreatedTime());
                int MyBillsEntityDataFactory = (int) DateTimeUtil.MyBillsEntityDataFactory(date, date2);
                feedNotificationMapper.BuiltInFictitiousFunctionClassFactory(arrayList, MyBillsEntityDataFactory, date, date2);
                List<ActivityResponse> activities = groupedActivity.getActivities();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(activities, 10));
                Iterator<T> it = activities.iterator();
                while (it.hasNext()) {
                    FeedModel PlaceComponentResult = feedNotificationMapper.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(date, (ActivityResponse) it.next());
                    PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = groupedActivity.getId();
                    PlaceComponentResult.newProxyInstance = groupedActivity.getRead();
                    PlaceComponentResult.moveToNextValue = feedNotificationMapper.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, PlaceComponentResult.getErrorConfigVersion);
                    arrayList2.add(PlaceComponentResult);
                }
                ArrayList arrayList3 = arrayList2;
                List<HashMap<String, String>> KClassImpl$Data$declaredNonStaticMembers$2 = FeedNotificationMapper.KClassImpl$Data$declaredNonStaticMembers$2(arrayList3);
                if (groupedActivity.getActorCount() > 1) {
                    String id2 = groupedActivity.getId();
                    String group = groupedActivity.getGroup();
                    int activityCount = groupedActivity.getActivityCount();
                    int actorCount = groupedActivity.getActorCount();
                    HashMap hashMap = (HashMap) CollectionsKt.firstOrNull((List) KClassImpl$Data$declaredNonStaticMembers$2);
                    if (hashMap == null || (emptyMap = MapsKt.toMap(hashMap)) == null) {
                        emptyMap = MapsKt.emptyMap();
                    }
                    feedViewHolderModel = new FeedViewHolderModel(13, null, new GroupedFeedModel(id2, group, activityCount, actorCount, arrayList3, new HashMap(emptyMap), KClassImpl$Data$declaredNonStaticMembers$2, groupedActivity.getRead()), null, null, false, 56, null);
                } else {
                    feedViewHolderModel = new FeedViewHolderModel(15, (FeedModel) arrayList3.get(0), null, null, null, false, 56, null);
                }
                arrayList.add(feedViewHolderModel);
            }
            return CollectionsKt.toMutableList((Collection) arrayList);
        }
        FeedNotificationMapper feedNotificationMapper2 = feedNotificationPresenter.KClassImpl$Data$declaredNonStaticMembers$2;
        Date date3 = new Date();
        List<ActivityResponse> activities2 = socialFeed.getActivities();
        Intrinsics.checkNotNullParameter(date3, "");
        Intrinsics.checkNotNullParameter(activities2, "");
        ArrayList arrayList4 = new ArrayList();
        for (ActivityResponse activityResponse : activities2) {
            Date date4 = new Date(activityResponse.getCreatedTime());
            int MyBillsEntityDataFactory2 = (int) DateTimeUtil.MyBillsEntityDataFactory(date3, date4);
            feedNotificationMapper2.BuiltInFictitiousFunctionClassFactory(arrayList4, MyBillsEntityDataFactory2, date3, date4);
            FeedModel PlaceComponentResult2 = feedNotificationMapper2.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(date3, activityResponse);
            PlaceComponentResult2.moveToNextValue = feedNotificationMapper2.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2, PlaceComponentResult2.getErrorConfigVersion);
            Unit unit = Unit.INSTANCE;
            arrayList4.add(new FeedViewHolderModel(15, PlaceComponentResult2, null, null, null, false, 60, null));
        }
        return CollectionsKt.toMutableList((Collection) arrayList4);
    }
}
