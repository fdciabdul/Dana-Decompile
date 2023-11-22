package id.dana.social.presenter;

import id.dana.base.BasePresenter;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.profilemenu.interactor.GetSettingByKey;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.domain.social.model.FeedConfig;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.feeds.domain.config.interactor.ApproveFriendRequest;
import id.dana.feeds.domain.config.interactor.DeclineFriendRequest;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.feeds.domain.friend.interactor.AddFriend;
import id.dana.feeds.domain.friend.interactor.CancelAddFriend;
import id.dana.feeds.domain.friend.interactor.FindFriends;
import id.dana.feeds.domain.friend.model.Friend;
import id.dana.feeds.domain.profile.interactor.GetFriendProfile;
import id.dana.feeds.domain.profile.interactor.GetProfileCta;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowerRelationshipWithPublishResult;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowingRelationshipWithPublishResult;
import id.dana.feeds.domain.relationship.interactor.ObserveProfileMuteUnmuteStatus;
import id.dana.feeds.domain.relationship.model.RelationshipItem;
import id.dana.feeds.domain.timeline.interactor.GetFriendTimeline;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.social.contract.SocialProfileContract;
import id.dana.social.mapper.RelationshipItemToRelationshipItemModelKt;
import id.dana.social.model.mapper.FeedMapper;
import id.dana.social.model.mapper.GroupedFeedMapper;
import id.dana.social.utils.FeedsContentAction;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 o2\u00020\u00012\u00020\u0002:\u0001oB\u0099\u0001\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020[\u0012\u0006\u0010\b\u001a\u00020N\u0012\u0006\u0010]\u001a\u000201\u0012\u0006\u0010^\u001a\u00020U\u0012\u0006\u0010_\u001a\u000204\u0012\u0006\u0010`\u001a\u00020\"\u0012\u0006\u0010a\u001a\u00020@\u0012\u0006\u0010b\u001a\u00020(\u0012\u0006\u0010c\u001a\u00020:\u0012\u0006\u0010d\u001a\u00020J\u0012\u0006\u0010e\u001a\u00020.\u0012\u0006\u0010f\u001a\u00020\u0019\u0012\u0006\u0010g\u001a\u00020+\u0012\u0006\u0010h\u001a\u00020\u001d\u0012\u0006\u0010i\u001a\u00020\u001b\u0012\u0006\u0010j\u001a\u00020 \u0012\u0006\u0010k\u001a\u000207\u0012\u0006\u0010l\u001a\u00020=¢\u0006\u0004\bm\u0010nJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\u001f\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u000f\u0010\u0012J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0010\u0010\u0013J\u000f\u0010\r\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\r\u0010\u0013J\u001f\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u000f\u0010\u0015J\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\r\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u000bJ\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0006\u0010\u0018R\u0014\u0010\u0010\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001aR\u0014\u0010\u000f\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u000e\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010!R\u0014\u0010\r\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u001e\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\f\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010\n\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010\u0017\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u0010#\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00102\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010,\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010&\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010/\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010)\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010>\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010;\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR \u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u00108\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR \u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010IR\u0014\u0010C\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u001c\u0010K\u001a\f\u0012\b\u0012\u0006*\u00020\u00110\u00110QX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010RR\u0018\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00110SX\u0080\"¢\u0006\u0006\n\u0004\b\u000e\u0010TR\u0014\u0010H\u001a\u00020U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0012\u0010E\u001a\u00020\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010FR\u0014\u0010Z\u001a\u0004\u0018\u00010XX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010YR\u0011\u0010O\u001a\u00020[X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\\"}, d2 = {"Lid/dana/social/presenter/SocialProfilePresenter;", "Lid/dana/base/BasePresenter;", "Lid/dana/social/contract/SocialProfileContract$Presenter;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "p1", "(Ljava/lang/String;Ljava/lang/String;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()V", "getErrorConfigVersion", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "getAuthRequestContext", "", "(Ljava/lang/String;Z)V", "()Z", "Lid/dana/domain/social/ModifyRelationOperationType;", "(Ljava/lang/String;Lid/dana/domain/social/ModifyRelationOperationType;)V", "onDestroy", "moveToNextValue", "(Z)V", "Lid/dana/feeds/domain/friend/interactor/AddFriend;", "Lid/dana/feeds/domain/friend/interactor/AddFriend;", "Lid/dana/feeds/domain/config/interactor/ApproveFriendRequest;", "Lid/dana/feeds/domain/config/interactor/ApproveFriendRequest;", "Lid/dana/feeds/domain/friend/interactor/CancelAddFriend;", "lookAheadTest", "Lid/dana/feeds/domain/friend/interactor/CancelAddFriend;", "Lid/dana/feeds/domain/config/interactor/DeclineFriendRequest;", "Lid/dana/feeds/domain/config/interactor/DeclineFriendRequest;", "Lid/dana/social/model/mapper/FeedMapper;", "scheduleImpl", "Lid/dana/social/model/mapper/FeedMapper;", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "I", "Lid/dana/social/utils/FeedsContentAction;", "DatabaseTableConfigUtil", "Lid/dana/social/utils/FeedsContentAction;", "Lid/dana/feeds/domain/friend/interactor/FindFriends;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/feeds/domain/friend/interactor/FindFriends;", "Lid/dana/feeds/domain/config/interactor/GetFeedConfig;", "GetContactSyncConfig", "Lid/dana/feeds/domain/config/interactor/GetFeedConfig;", "Lid/dana/feeds/domain/profile/interactor/GetFriendProfile;", "initRecordTimeStamp", "Lid/dana/feeds/domain/profile/interactor/GetFriendProfile;", "Lid/dana/feeds/domain/timeline/interactor/GetFriendTimeline;", "PrepareContext", "Lid/dana/feeds/domain/timeline/interactor/GetFriendTimeline;", "Lid/dana/feeds/domain/profile/interactor/GetProfileCta;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/feeds/domain/profile/interactor/GetProfileCta;", "Lid/dana/domain/profilemenu/interactor/GetSettingByKey;", "newProxyInstance", "Lid/dana/domain/profilemenu/interactor/GetSettingByKey;", "Lid/dana/domain/user/interactor/GetUserInfo;", "isLayoutRequested", "Lid/dana/domain/user/interactor/GetUserInfo;", "Lid/dana/social/model/mapper/GroupedFeedMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/social/model/mapper/GroupedFeedMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Z", "FragmentBottomSheetPaymentSettingBinding", "Ljava/lang/String;", "", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Ljava/util/Map;", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowerRelationshipWithPublishResult;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowerRelationshipWithPublishResult;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowingRelationshipWithPublishResult;", "getCallingPid", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowingRelationshipWithPublishResult;", "Lio/reactivex/subjects/PublishSubject;", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/domain/DefaultObserver;", "Lid/dana/domain/DefaultObserver;", "Lid/dana/feeds/domain/relationship/interactor/ObserveProfileMuteUnmuteStatus;", "whenAvailable", "Lid/dana/feeds/domain/relationship/interactor/ObserveProfileMuteUnmuteStatus;", "Lid/dana/domain/user/UserInfoResponse;", "Lid/dana/domain/user/UserInfoResponse;", "readMicros", "Lid/dana/social/contract/SocialProfileContract$View;", "Lid/dana/social/contract/SocialProfileContract$View;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "<init>", "(Lid/dana/social/contract/SocialProfileContract$View;Lid/dana/feeds/domain/relationship/interactor/ModifyFollowingRelationshipWithPublishResult;Lid/dana/feeds/domain/profile/interactor/GetFriendProfile;Lid/dana/feeds/domain/relationship/interactor/ObserveProfileMuteUnmuteStatus;Lid/dana/feeds/domain/timeline/interactor/GetFriendTimeline;Lid/dana/social/model/mapper/FeedMapper;Lid/dana/social/model/mapper/GroupedFeedMapper;Lid/dana/social/utils/FeedsContentAction;Lid/dana/domain/profilemenu/interactor/GetSettingByKey;Lid/dana/feeds/domain/relationship/interactor/ModifyFollowerRelationshipWithPublishResult;Lid/dana/feeds/domain/config/interactor/GetFeedConfig;Lid/dana/feeds/domain/friend/interactor/AddFriend;Lid/dana/feeds/domain/friend/interactor/FindFriends;Lid/dana/feeds/domain/friend/interactor/CancelAddFriend;Lid/dana/feeds/domain/config/interactor/ApproveFriendRequest;Lid/dana/feeds/domain/config/interactor/DeclineFriendRequest;Lid/dana/feeds/domain/profile/interactor/GetProfileCta;Lid/dana/domain/user/interactor/GetUserInfo;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialProfilePresenter extends BasePresenter implements SocialProfileContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public DefaultObserver<Boolean> NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final FeedsContentAction getErrorConfigVersion;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private String newProxyInstance;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final GetFeedConfig moveToNextValue;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    String FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    UserInfoResponse readMicros;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final AddFriend getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final FindFriends NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private int lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final ModifyFollowerRelationshipWithPublishResult NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private final Map<String, ModifyRelationOperationType> PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private boolean isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final Map<String, ModifyRelationOperationType> NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final GetProfileCta NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final GroupedFeedMapper DatabaseTableConfigUtil;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public PublishSubject<Boolean> NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final GetFriendTimeline initRecordTimeStamp;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final SocialProfileContract.View getCallingPid;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private final ModifyFollowingRelationshipWithPublishResult NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final ApproveFriendRequest PlaceComponentResult;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final GetFriendProfile scheduleImpl;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final GetUserInfo GetContactSyncConfig;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final CancelAddFriend KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final DeclineFriendRequest BuiltInFictitiousFunctionClassFactory;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private final GetSettingByKey NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final FeedMapper MyBillsEntityDataFactory;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private final ObserveProfileMuteUnmuteStatus NetworkUserEntityData$$ExternalSyntheticLambda6;

    @Inject
    public SocialProfilePresenter(SocialProfileContract.View view, ModifyFollowingRelationshipWithPublishResult modifyFollowingRelationshipWithPublishResult, GetFriendProfile getFriendProfile, ObserveProfileMuteUnmuteStatus observeProfileMuteUnmuteStatus, GetFriendTimeline getFriendTimeline, FeedMapper feedMapper, GroupedFeedMapper groupedFeedMapper, FeedsContentAction feedsContentAction, GetSettingByKey getSettingByKey, ModifyFollowerRelationshipWithPublishResult modifyFollowerRelationshipWithPublishResult, GetFeedConfig getFeedConfig, AddFriend addFriend, FindFriends findFriends, CancelAddFriend cancelAddFriend, ApproveFriendRequest approveFriendRequest, DeclineFriendRequest declineFriendRequest, GetProfileCta getProfileCta, GetUserInfo getUserInfo) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(modifyFollowingRelationshipWithPublishResult, "");
        Intrinsics.checkNotNullParameter(getFriendProfile, "");
        Intrinsics.checkNotNullParameter(observeProfileMuteUnmuteStatus, "");
        Intrinsics.checkNotNullParameter(getFriendTimeline, "");
        Intrinsics.checkNotNullParameter(feedMapper, "");
        Intrinsics.checkNotNullParameter(groupedFeedMapper, "");
        Intrinsics.checkNotNullParameter(feedsContentAction, "");
        Intrinsics.checkNotNullParameter(getSettingByKey, "");
        Intrinsics.checkNotNullParameter(modifyFollowerRelationshipWithPublishResult, "");
        Intrinsics.checkNotNullParameter(getFeedConfig, "");
        Intrinsics.checkNotNullParameter(addFriend, "");
        Intrinsics.checkNotNullParameter(findFriends, "");
        Intrinsics.checkNotNullParameter(cancelAddFriend, "");
        Intrinsics.checkNotNullParameter(approveFriendRequest, "");
        Intrinsics.checkNotNullParameter(declineFriendRequest, "");
        Intrinsics.checkNotNullParameter(getProfileCta, "");
        Intrinsics.checkNotNullParameter(getUserInfo, "");
        this.getCallingPid = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = modifyFollowingRelationshipWithPublishResult;
        this.scheduleImpl = getFriendProfile;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = observeProfileMuteUnmuteStatus;
        this.initRecordTimeStamp = getFriendTimeline;
        this.MyBillsEntityDataFactory = feedMapper;
        this.DatabaseTableConfigUtil = groupedFeedMapper;
        this.getErrorConfigVersion = feedsContentAction;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = getSettingByKey;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = modifyFollowerRelationshipWithPublishResult;
        this.moveToNextValue = getFeedConfig;
        this.getAuthRequestContext = addFriend;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = findFriends;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cancelAddFriend;
        this.PlaceComponentResult = approveFriendRequest;
        this.BuiltInFictitiousFunctionClassFactory = declineFriendRequest;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = getProfileCta;
        this.GetContactSyncConfig = getUserInfo;
        this.FragmentBottomSheetPaymentSettingBinding = "ACTIVE";
        PublishSubject<Boolean> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = PlaceComponentResult;
        this.PrepareContext = new LinkedHashMap();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new LinkedHashMap();
        this.isLayoutRequested = true;
        this.lookAheadTest = 4;
        Observable<Boolean> debounce = this.NetworkUserEntityData$$ExternalSyntheticLambda3.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).debounce(800L, TimeUnit.MILLISECONDS);
        DefaultObserver<Boolean> defaultObserver = new DefaultObserver<Boolean>() { // from class: id.dana.social.presenter.SocialProfilePresenter$getModifyRelationshipObserver$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onComplete() {
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    SocialProfilePresenter.this.getErrorConfigVersion();
                } else {
                    SocialProfilePresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(p0.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory("SocialProfilePresenter", sb.toString());
            }
        };
        Intrinsics.checkNotNullParameter(defaultObserver, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = defaultObserver;
        if (defaultObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            defaultObserver = null;
        }
        debounce.subscribe(defaultObserver);
        this.GetContactSyncConfig.execute(new GetUserInfo.Param(false), new Function1<UserInfoResponse, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$getUserInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserInfoResponse userInfoResponse) {
                invoke2(userInfoResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserInfoResponse userInfoResponse) {
                Intrinsics.checkNotNullParameter(userInfoResponse, "");
                SocialProfilePresenter.this.readMicros = userInfoResponse;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$getUserInfo$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.GET_USER_INFO_EXCEPTION, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, ModifyRelationOperationType p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.PrepareContext.put(p0, p1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda3.onNext(Boolean.TRUE);
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void PlaceComponentResult(String p0, ModifyRelationOperationType p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.put(p0, p1);
        this.NetworkUserEntityData$$ExternalSyntheticLambda3.onNext(Boolean.FALSE);
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void PlaceComponentResult(final String p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.scheduleImpl.execute(new GetFriendProfile.Params(p0, p1), new Function1<RelationshipItem, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$getUserProfileHeaderById$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RelationshipItem relationshipItem) {
                invoke2(relationshipItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RelationshipItem relationshipItem) {
                Intrinsics.checkNotNullParameter(relationshipItem, "");
                r1.NetworkUserEntityData$$ExternalSyntheticLambda6.execute(p0, new Function1<RelationshipItem, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$observeProfileChanges$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(RelationshipItem relationshipItem2) {
                        invoke2(relationshipItem2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(RelationshipItem relationshipItem2) {
                        Intrinsics.checkNotNullParameter(relationshipItem2, "");
                        SocialProfilePresenter.this.getCallingPid.PlaceComponentResult(relationshipItem2.getStatus());
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$observeProfileChanges$2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                        StringBuilder sb = new StringBuilder();
                        sb.append("onError: ");
                        sb.append(th.getMessage());
                        DanaLog.BuiltInFictitiousFunctionClassFactory("SocialProfilePresenter", sb.toString());
                    }
                });
                SocialProfilePresenter socialProfilePresenter = SocialProfilePresenter.this;
                String status = relationshipItem.getStatus();
                Intrinsics.checkNotNullParameter(status, "");
                socialProfilePresenter.FragmentBottomSheetPaymentSettingBinding = status;
                SocialProfilePresenter.this.getCallingPid.BuiltInFictitiousFunctionClassFactory(RelationshipItemToRelationshipItemModelKt.KClassImpl$Data$declaredNonStaticMembers$2(relationshipItem));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$getUserProfileHeaderById$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                SocialProfilePresenter.this.getCallingPid.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
        });
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.executeJava1(new CancelAddFriend.Params(p0), new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$cancelFriendRequest$1
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
                SocialProfilePresenter.this.getCallingPid.scheduleImpl();
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.SocialProfilePresenter$cancelFriendRequest$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                SocialProfilePresenter.this.getCallingPid.MyBillsEntityDataFactory();
                return SocialProfilePresenter.this.getCallingPid.PlaceComponentResult();
            }
        }, this.getCallingPid.BuiltInFictitiousFunctionClassFactory());
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.executeJava1(new FindFriends.Params(p0, true), new Function1<List<? extends Friend>, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$getFriendStatus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends Friend> list) {
                invoke2((List<Friend>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<Friend> list) {
                Intrinsics.checkNotNullParameter(list, "");
                if (list.isEmpty()) {
                    SocialProfilePresenter.this.getCallingPid.lookAheadTest();
                    return;
                }
                SocialProfileContract.View view = SocialProfilePresenter.this.getCallingPid;
                FriendModel.Companion companion = FriendModel.INSTANCE;
                view.BuiltInFictitiousFunctionClassFactory(FriendModel.Companion.BuiltInFictitiousFunctionClassFactory((Friend) CollectionsKt.first((List) list)));
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.SocialProfilePresenter$getFriendStatus$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                SocialProfilePresenter.this.getCallingPid.lookAheadTest();
                return SocialProfilePresenter.this.getCallingPid.PlaceComponentResult();
            }
        }, this.getCallingPid.BuiltInFictitiousFunctionClassFactory());
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.executeJava1(p0, new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$addFriend$1
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
                SocialProfilePresenter.this.getCallingPid.getAuthRequestContext();
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.SocialProfilePresenter$addFriend$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                SocialProfilePresenter.this.getCallingPid.KClassImpl$Data$declaredNonStaticMembers$2();
                return SocialProfilePresenter.this.getCallingPid.PlaceComponentResult();
            }
        }, this.getCallingPid.BuiltInFictitiousFunctionClassFactory());
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getErrorConfigVersion.getAuthRequestContext(p0);
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void getAuthRequestContext(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getIsLayoutRequested() {
        return this.isLayoutRequested;
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void PlaceComponentResult() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.execute(new DefaultObserver<SettingModel>() { // from class: id.dana.social.presenter.SocialProfilePresenter$getProfileSettingModel$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                SettingModel settingModel = (SettingModel) obj;
                Intrinsics.checkNotNullParameter(settingModel, "");
                SocialProfilePresenter.this.getCallingPid.MyBillsEntityDataFactory(settingModel);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory("RelationshipBottomSheetPresenter", p0.getMessage(), p0);
                SocialProfilePresenter.this.getCallingPid.moveToNextValue();
            }
        }, GetSettingByKey.Params.forSettingKey("setting_more"));
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void moveToNextValue(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.newProxyInstance = "";
        this.isLayoutRequested = true;
        this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory = "";
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = "";
        BaseUseCaseWithAnalytics.executeJava1$default(this.initRecordTimeStamp, new GetFriendTimeline.Params(this.newProxyInstance, "", p0, CollectionsKt.emptyList()), new Function1<SocialFeed, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$refreshTimeline$1
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
                FeedMapper feedMapper;
                FeedMapper feedMapper2;
                GroupedFeedMapper groupedFeedMapper;
                int i;
                GroupedFeedMapper groupedFeedMapper2;
                Intrinsics.checkNotNullParameter(socialFeed, "");
                SocialProfilePresenter.this.newProxyInstance = socialFeed.getMaxId();
                SocialProfilePresenter.this.isLayoutRequested = socialFeed.getHasMore();
                if (socialFeed.isFeedNotVersionTwo()) {
                    groupedFeedMapper = SocialProfilePresenter.this.DatabaseTableConfigUtil;
                    i = SocialProfilePresenter.this.lookAheadTest;
                    groupedFeedMapper.KClassImpl$Data$declaredNonStaticMembers$2 = i >= 5;
                    SocialProfileContract.View view = SocialProfilePresenter.this.getCallingPid;
                    groupedFeedMapper2 = SocialProfilePresenter.this.DatabaseTableConfigUtil;
                    view.PlaceComponentResult(GroupedFeedMapper.BuiltInFictitiousFunctionClassFactory(groupedFeedMapper2, new Date(), socialFeed.getGroupedActivities(), false, null, 12));
                    return;
                }
                feedMapper = SocialProfilePresenter.this.MyBillsEntityDataFactory;
                feedMapper.PlaceComponentResult = false;
                SocialProfileContract.View view2 = SocialProfilePresenter.this.getCallingPid;
                feedMapper2 = SocialProfilePresenter.this.MyBillsEntityDataFactory;
                Collection apply = feedMapper2.apply(socialFeed.getActivities());
                Intrinsics.checkNotNullExpressionValue(apply, "");
                view2.PlaceComponentResult((List) apply);
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.SocialProfilePresenter$refreshTimeline$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                SocialProfilePresenter.this.getCallingPid.getErrorConfigVersion();
                return SocialProfilePresenter.this.getCallingPid.PlaceComponentResult();
            }
        }, null, 8, null);
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        BaseUseCaseWithAnalytics.executeJava1$default(this.initRecordTimeStamp, new GetFriendTimeline.Params(this.newProxyInstance, "", p0, CollectionsKt.emptyList()), new Function1<SocialFeed, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$getUserTimelineFeedByUserId$1
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
                FeedMapper feedMapper;
                FeedMapper feedMapper2;
                GroupedFeedMapper groupedFeedMapper;
                int i;
                GroupedFeedMapper groupedFeedMapper2;
                Intrinsics.checkNotNullParameter(socialFeed, "");
                SocialProfilePresenter.this.newProxyInstance = socialFeed.getMaxId();
                SocialProfilePresenter.this.isLayoutRequested = socialFeed.getHasMore();
                if (socialFeed.isFeedNotVersionTwo()) {
                    groupedFeedMapper = SocialProfilePresenter.this.DatabaseTableConfigUtil;
                    i = SocialProfilePresenter.this.lookAheadTest;
                    groupedFeedMapper.KClassImpl$Data$declaredNonStaticMembers$2 = i >= 5;
                    SocialProfileContract.View view = SocialProfilePresenter.this.getCallingPid;
                    groupedFeedMapper2 = SocialProfilePresenter.this.DatabaseTableConfigUtil;
                    view.getAuthRequestContext(GroupedFeedMapper.BuiltInFictitiousFunctionClassFactory(groupedFeedMapper2, new Date(), socialFeed.getGroupedActivities(), false, null, 12));
                    return;
                }
                feedMapper = SocialProfilePresenter.this.MyBillsEntityDataFactory;
                feedMapper.PlaceComponentResult = false;
                SocialProfileContract.View view2 = SocialProfilePresenter.this.getCallingPid;
                feedMapper2 = SocialProfilePresenter.this.MyBillsEntityDataFactory;
                Collection apply = feedMapper2.apply(socialFeed.getActivities());
                Intrinsics.checkNotNullExpressionValue(apply, "");
                view2.getAuthRequestContext((List) apply);
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.SocialProfilePresenter$getUserTimelineFeedByUserId$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                SocialProfilePresenter.this.getCallingPid.getErrorConfigVersion();
                return SocialProfilePresenter.this.getCallingPid.PlaceComponentResult();
            }
        }, null, 8, null);
    }

    public final void getErrorConfigVersion() {
        final Map map = MapsKt.toMap(this.PrepareContext);
        this.PrepareContext.clear();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.execute(map, new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$callModifyFollowingRelationship$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if ((!map.isEmpty()) == true) {
                    this.getCallingPid.PlaceComponentResult((ModifyRelationOperationType) CollectionsKt.first(map.values()));
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$callModifyFollowingRelationship$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                if ((!map.isEmpty()) != false) {
                    this.getCallingPid.DatabaseTableConfigUtil();
                }
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, String.valueOf(th.getCause()));
            }
        });
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        final Map map = MapsKt.toMap(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.clear();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.execute(map, new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$callModifyFollowerRelationship$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if ((!map.isEmpty()) == true) {
                    this.getCallingPid.PlaceComponentResult((ModifyRelationOperationType) CollectionsKt.first(map.values()));
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$callModifyFollowerRelationship$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                if ((!map.isEmpty()) != false) {
                    this.getCallingPid.DatabaseTableConfigUtil();
                }
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, String.valueOf(th.getCause()));
            }
        });
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.moveToNextValue.execute(NoParams.INSTANCE, new Function1<FeedConfig, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$getFeedConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(FeedConfig feedConfig) {
                invoke2(feedConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FeedConfig feedConfig) {
                Intrinsics.checkNotNullParameter(feedConfig, "");
                SocialProfilePresenter.this.lookAheadTest = feedConfig.getFeedVersion();
                SocialProfilePresenter.this.getCallingPid.MyBillsEntityDataFactory(feedConfig);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$getFeedConfig$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_FEED_CONFIG, th.getLocalizedMessage(), th);
            }
        });
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        this.DatabaseTableConfigUtil.PlaceComponentResult = p0;
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Completable BuiltInFictitiousFunctionClassFactory = Completable.BuiltInFictitiousFunctionClassFactory(3000L, TimeUnit.MILLISECONDS);
        Action action = new Action() { // from class: id.dana.social.presenter.SocialProfilePresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() {
                SocialProfilePresenter.KClassImpl$Data$declaredNonStaticMembers$2(SocialProfilePresenter.this, p0);
            }
        };
        Consumer<? super Disposable> PlaceComponentResult = Functions.PlaceComponentResult();
        Consumer<? super Throwable> PlaceComponentResult2 = Functions.PlaceComponentResult();
        Action action2 = Functions.KClassImpl$Data$declaredNonStaticMembers$2;
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, PlaceComponentResult2, action, action2, action2, Functions.KClassImpl$Data$declaredNonStaticMembers$2);
        Scheduler PlaceComponentResult3 = AndroidSchedulers.PlaceComponentResult();
        ObjectHelper.PlaceComponentResult(PlaceComponentResult3, "scheduler is null");
        RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult3)).q_();
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.PlaceComponentResult.execute(new ApproveFriendRequest.Params(p0), new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$approveFriendRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    SocialProfilePresenter.this.getCallingPid.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
                } else {
                    SocialProfilePresenter.this.getCallingPid.BuiltInFictitiousFunctionClassFactory(p1);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$approveFriendRequest$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                SocialProfilePresenter.this.getCallingPid.BuiltInFictitiousFunctionClassFactory(p1);
            }
        });
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.BuiltInFictitiousFunctionClassFactory.execute(new DeclineFriendRequest.Params(p0), new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$declineFriendRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    SocialProfilePresenter.this.getCallingPid.MyBillsEntityDataFactory(p1);
                } else {
                    SocialProfilePresenter.this.getCallingPid.getAuthRequestContext(p1);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$declineFriendRequest$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                SocialProfilePresenter.this.getCallingPid.getAuthRequestContext(p1);
            }
        });
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.execute(NoParams.INSTANCE, new Function1<List<? extends ProfileCtaConfig>, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$getProfileCta$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ProfileCtaConfig> list) {
                invoke2((List<ProfileCtaConfig>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<ProfileCtaConfig> list) {
                Intrinsics.checkNotNullParameter(list, "");
                SocialProfilePresenter.this.getCallingPid.KClassImpl$Data$declaredNonStaticMembers$2(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.SocialProfilePresenter$getProfileCta$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_PROFILE_CTA, th.getLocalizedMessage(), th);
            }
        });
    }

    @Override // id.dana.social.contract.SocialProfileContract.Presenter
    public final boolean getAuthRequestContext() {
        UserInfoResponse userInfoResponse = this.readMicros;
        if (userInfoResponse != null) {
            return userInfoResponse.isPremiumUser();
        }
        return false;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        getErrorConfigVersion();
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        this.scheduleImpl.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.dispose();
        this.initRecordTimeStamp.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.dispose();
        DefaultObserver<Boolean> defaultObserver = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (defaultObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            defaultObserver = null;
        }
        defaultObserver.dispose();
        this.moveToNextValue.dispose();
        this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory = "";
        this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.getAuthRequestContext.dispose();
        this.PlaceComponentResult.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.dispose();
        this.GetContactSyncConfig.dispose();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SocialProfilePresenter socialProfilePresenter, String str) {
        Intrinsics.checkNotNullParameter(socialProfilePresenter, "");
        Intrinsics.checkNotNullParameter(str, "");
        socialProfilePresenter.moveToNextValue(str);
    }
}
