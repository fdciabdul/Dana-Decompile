package id.dana.social.presenter;

import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.domain.social.core.SingleUseCase;
import id.dana.feeds.domain.relationship.interactor.GetActiveFollower;
import id.dana.feeds.domain.relationship.interactor.GetActiveFollowing;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowerRelationship;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowerRelationshipWithPublishResult;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowingRelationship;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowingRelationshipWithPublishResult;
import id.dana.feeds.domain.relationship.interactor.StartFollowerFullSync;
import id.dana.feeds.domain.relationship.interactor.StartFollowingFullSync;
import id.dana.feeds.domain.relationship.model.Follower;
import id.dana.feeds.domain.relationship.model.Following;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.contract.FriendshipContract;
import id.dana.social.mapper.RelationshipItemListToRelationshipItemModelListKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
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
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ?2\u00020\u0001:\u0001?BQ\b\u0007\u0012\u0006\u0010\u0004\u001a\u000204\u0012\u0006\u0010\f\u001a\u00020/\u0012\u0006\u00106\u001a\u000202\u0012\u0006\u00107\u001a\u00020\u0011\u0012\u0006\u00108\u001a\u00020\u0013\u0012\u0006\u00109\u001a\u00020\u0015\u0012\u0006\u0010:\u001a\u00020\u001b\u0012\u0006\u0010;\u001a\u00020 \u0012\u0006\u0010<\u001a\u00020\u0019¢\u0006\u0004\b=\u0010>J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0014\u0010\u000f\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0014\u0010\r\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0016R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018R\u0014\u0010\b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010$\u001a\f\u0012\b\u0012\u0006*\u00020#0#0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010(R*\u0010*\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020'*\b\u0012\u0004\u0012\u00020'0&0&0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010%R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00101\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u00100R\u0014\u0010)\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u00103R\u0014\u0010,\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00105"}, d2 = {"Lid/dana/social/presenter/FriendshipPresenter;", "Lid/dana/social/contract/FriendshipContract$Presenter;", "Lio/reactivex/subjects/PublishSubject;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lio/reactivex/subjects/PublishSubject;)V", "PlaceComponentResult", "()V", "onDestroy", "Lid/dana/domain/social/ModifyRelationOperationType;", "p1", "getAuthRequestContext", "(Ljava/lang/String;Lid/dana/domain/social/ModifyRelationOperationType;)V", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/relationship/interactor/GetActiveFollower;", "Lid/dana/feeds/domain/relationship/interactor/GetActiveFollower;", "Lid/dana/feeds/domain/relationship/interactor/GetActiveFollowing;", "Lid/dana/feeds/domain/relationship/interactor/GetActiveFollowing;", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowerRelationship;", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowerRelationship;", "", "Ljava/util/Map;", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowerRelationshipWithPublishResult;", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowerRelationshipWithPublishResult;", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowingRelationship;", "moveToNextValue", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowingRelationship;", "scheduleImpl", "getErrorConfigVersion", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowingRelationshipWithPublishResult;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowingRelationshipWithPublishResult;", "", "lookAheadTest", "Lio/reactivex/subjects/PublishSubject;", "", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "Lio/reactivex/disposables/Disposable;", "DatabaseTableConfigUtil", "Lio/reactivex/disposables/Disposable;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/feeds/domain/relationship/interactor/StartFollowerFullSync;", "Lid/dana/feeds/domain/relationship/interactor/StartFollowerFullSync;", "initRecordTimeStamp", "Lid/dana/feeds/domain/relationship/interactor/StartFollowingFullSync;", "Lid/dana/feeds/domain/relationship/interactor/StartFollowingFullSync;", "Lid/dana/social/contract/FriendshipContract$View;", "Lid/dana/social/contract/FriendshipContract$View;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Lid/dana/social/contract/FriendshipContract$View;Lid/dana/feeds/domain/relationship/interactor/StartFollowerFullSync;Lid/dana/feeds/domain/relationship/interactor/StartFollowingFullSync;Lid/dana/feeds/domain/relationship/interactor/GetActiveFollower;Lid/dana/feeds/domain/relationship/interactor/GetActiveFollowing;Lid/dana/feeds/domain/relationship/interactor/ModifyFollowerRelationship;Lid/dana/feeds/domain/relationship/interactor/ModifyFollowingRelationship;Lid/dana/feeds/domain/relationship/interactor/ModifyFollowingRelationshipWithPublishResult;Lid/dana/feeds/domain/relationship/interactor/ModifyFollowerRelationshipWithPublishResult;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendshipPresenter implements FriendshipContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ModifyFollowerRelationshipWithPublishResult PlaceComponentResult;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private Disposable NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final StartFollowingFullSync NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetActiveFollowing MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetActiveFollower BuiltInFictitiousFunctionClassFactory;
    private final ModifyFollowingRelationshipWithPublishResult NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final StartFollowerFullSync initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final PublishSubject<List<RelationshipItemModel>> GetContactSyncConfig;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Map<String, ModifyRelationOperationType> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ModifyFollowerRelationship getAuthRequestContext;
    private final Map<String, ModifyRelationOperationType> getErrorConfigVersion;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final FriendshipContract.View DatabaseTableConfigUtil;
    private final PublishSubject<Boolean> lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final ModifyFollowingRelationship scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private List<RelationshipItemModel> moveToNextValue;

    @Inject
    public FriendshipPresenter(FriendshipContract.View view, StartFollowerFullSync startFollowerFullSync, StartFollowingFullSync startFollowingFullSync, GetActiveFollower getActiveFollower, GetActiveFollowing getActiveFollowing, ModifyFollowerRelationship modifyFollowerRelationship, ModifyFollowingRelationship modifyFollowingRelationship, ModifyFollowingRelationshipWithPublishResult modifyFollowingRelationshipWithPublishResult, ModifyFollowerRelationshipWithPublishResult modifyFollowerRelationshipWithPublishResult) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(startFollowerFullSync, "");
        Intrinsics.checkNotNullParameter(startFollowingFullSync, "");
        Intrinsics.checkNotNullParameter(getActiveFollower, "");
        Intrinsics.checkNotNullParameter(getActiveFollowing, "");
        Intrinsics.checkNotNullParameter(modifyFollowerRelationship, "");
        Intrinsics.checkNotNullParameter(modifyFollowingRelationship, "");
        Intrinsics.checkNotNullParameter(modifyFollowingRelationshipWithPublishResult, "");
        Intrinsics.checkNotNullParameter(modifyFollowerRelationshipWithPublishResult, "");
        this.DatabaseTableConfigUtil = view;
        this.initRecordTimeStamp = startFollowerFullSync;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = startFollowingFullSync;
        this.BuiltInFictitiousFunctionClassFactory = getActiveFollower;
        this.MyBillsEntityDataFactory = getActiveFollowing;
        this.getAuthRequestContext = modifyFollowerRelationship;
        this.scheduleImpl = modifyFollowingRelationship;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = modifyFollowingRelationshipWithPublishResult;
        this.PlaceComponentResult = modifyFollowerRelationshipWithPublishResult;
        this.moveToNextValue = CollectionsKt.emptyList();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.getErrorConfigVersion = new LinkedHashMap();
        PublishSubject<List<RelationshipItemModel>> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.GetContactSyncConfig = PlaceComponentResult;
        PublishSubject<Boolean> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.lookAheadTest = PlaceComponentResult2;
        PlaceComponentResult2.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).debounce(800L, TimeUnit.MILLISECONDS).subscribe(new DefaultObserver<Boolean>() { // from class: id.dana.social.presenter.FriendshipPresenter$observeModifyRelationship$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                FriendshipPresenter.PlaceComponentResult(FriendshipPresenter.this);
            }
        });
        this.GetContactSyncConfig.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(AndroidSchedulers.PlaceComponentResult()).throttleLatest(1000L, TimeUnit.MILLISECONDS).subscribe(new DefaultObserver<List<? extends RelationshipItemModel>>() { // from class: id.dana.social.presenter.FriendshipPresenter$getRelationshipListObserver$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                FriendshipContract.View view2;
                List<RelationshipItemModel> list = (List) obj;
                Intrinsics.checkNotNullParameter(list, "");
                if ((!list.isEmpty()) == true) {
                    view2 = FriendshipPresenter.this.DatabaseTableConfigUtil;
                    view2.MyBillsEntityDataFactory(list);
                }
            }
        });
    }

    @Override // id.dana.social.contract.FriendshipContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<Following, Unit>() { // from class: id.dana.social.presenter.FriendshipPresenter$getActiveFollowing$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Following following) {
                invoke2(following);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Following following) {
                PublishSubject publishSubject;
                List list;
                Intrinsics.checkNotNullParameter(following, "");
                FriendshipPresenter.this.moveToNextValue = RelationshipItemListToRelationshipItemModelListKt.KClassImpl$Data$declaredNonStaticMembers$2(following.getFollowingItemList());
                publishSubject = FriendshipPresenter.this.GetContactSyncConfig;
                list = FriendshipPresenter.this.moveToNextValue;
                publishSubject.onNext(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.FriendshipPresenter$getActiveFollowing$2
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
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, sb.toString());
            }
        });
    }

    @Override // id.dana.social.contract.FriendshipContract.Presenter
    public final void getAuthRequestContext() {
        SingleUseCase.execute$default(this.NetworkUserEntityData$$ExternalSyntheticLambda2, Unit.INSTANCE, null, new Function1<Exception, Unit>() { // from class: id.dana.social.presenter.FriendshipPresenter$startFetchingFollowing$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(exc.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, sb.toString());
            }
        }, 2, null);
    }

    @Override // id.dana.social.contract.FriendshipContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(PublishSubject<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Disposable subscribe = p0.debounce(800L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.social.presenter.FriendshipPresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FriendshipPresenter.MyBillsEntityDataFactory(FriendshipPresenter.this, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = subscribe;
    }

    @Override // id.dana.social.contract.FriendshipContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.initRecordTimeStamp.execute(Unit.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.FriendshipPresenter$startFetchingFollower$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.social.presenter.FriendshipPresenter$startFetchingFollower$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, exc.getMessage(), exc);
            }
        });
    }

    @Override // id.dana.social.contract.FriendshipContract.Presenter
    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<Follower, Unit>() { // from class: id.dana.social.presenter.FriendshipPresenter$getActiveFollower$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Follower follower) {
                invoke2(follower);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Follower follower) {
                PublishSubject publishSubject;
                List list;
                Intrinsics.checkNotNullParameter(follower, "");
                FriendshipPresenter.this.moveToNextValue = RelationshipItemListToRelationshipItemModelListKt.KClassImpl$Data$declaredNonStaticMembers$2(follower.getFollowerItemList());
                publishSubject = FriendshipPresenter.this.GetContactSyncConfig;
                list = FriendshipPresenter.this.moveToNextValue;
                publishSubject.onNext(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.FriendshipPresenter$getActiveFollower$2
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
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, sb.toString());
            }
        });
    }

    @Override // id.dana.social.contract.FriendshipContract.Presenter
    public final void getAuthRequestContext(String p0, ModifyRelationOperationType p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.put(p0, p1);
        this.lookAheadTest.onNext(Boolean.TRUE);
    }

    @Override // id.dana.social.contract.FriendshipContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, ModifyRelationOperationType p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getErrorConfigVersion.put(p0, p1);
        this.lookAheadTest.onNext(Boolean.TRUE);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(FriendshipPresenter friendshipPresenter, String str) {
        Intrinsics.checkNotNullParameter(friendshipPresenter, "");
        if ((!friendshipPresenter.moveToNextValue.isEmpty()) == true) {
            Intrinsics.checkNotNullExpressionValue(str, "");
            String str2 = str;
            if (StringsKt.contains$default((CharSequence) StringsKt.trim((CharSequence) str2).toString(), (CharSequence) "*", false, 2, (Object) null)) {
                return;
            }
            if (Intrinsics.areEqual(StringsKt.trim((CharSequence) str2).toString(), "")) {
                friendshipPresenter.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(friendshipPresenter.moveToNextValue);
                return;
            }
            FriendshipContract.View view = friendshipPresenter.DatabaseTableConfigUtil;
            List<RelationshipItemModel> list = friendshipPresenter.moveToNextValue;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (StringsKt.contains((CharSequence) ((RelationshipItemModel) obj).scheduleImpl, (CharSequence) str2, true)) {
                    arrayList.add(obj);
                }
            }
            view.KClassImpl$Data$declaredNonStaticMembers$2(arrayList);
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(FriendshipPresenter friendshipPresenter) {
        if (!friendshipPresenter.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            Map<String, ModifyRelationOperationType> map = friendshipPresenter.KClassImpl$Data$declaredNonStaticMembers$2;
            ModifyFollowerRelationship modifyFollowerRelationship = friendshipPresenter.getAuthRequestContext;
            Map map2 = MapsKt.toMap(map);
            map.clear();
            modifyFollowerRelationship.execute(map2, FriendshipPresenter$modifyRelationship$1.INSTANCE, FriendshipPresenter$modifyRelationship$2.INSTANCE);
        }
        if (friendshipPresenter.getErrorConfigVersion.isEmpty()) {
            return;
        }
        Map<String, ModifyRelationOperationType> map3 = friendshipPresenter.getErrorConfigVersion;
        ModifyFollowingRelationship modifyFollowingRelationship = friendshipPresenter.scheduleImpl;
        Map map4 = MapsKt.toMap(map3);
        map3.clear();
        modifyFollowingRelationship.execute(map4, FriendshipPresenter$modifyRelationship$1.INSTANCE, FriendshipPresenter$modifyRelationship$2.INSTANCE);
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        Disposable disposable = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (disposable != null) {
            if (disposable == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                disposable = null;
            }
            disposable.dispose();
        }
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            Map<String, ModifyRelationOperationType> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
            ModifyFollowerRelationshipWithPublishResult modifyFollowerRelationshipWithPublishResult = this.PlaceComponentResult;
            Map map2 = MapsKt.toMap(map);
            map.clear();
            modifyFollowerRelationshipWithPublishResult.execute(map2, FriendshipPresenter$modifyRelationship$1.INSTANCE, FriendshipPresenter$modifyRelationship$2.INSTANCE);
        }
        if (this.getErrorConfigVersion.isEmpty()) {
            return;
        }
        Map<String, ModifyRelationOperationType> map3 = this.getErrorConfigVersion;
        ModifyFollowingRelationshipWithPublishResult modifyFollowingRelationshipWithPublishResult = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Map map4 = MapsKt.toMap(map3);
        map3.clear();
        modifyFollowingRelationshipWithPublishResult.execute(map4, FriendshipPresenter$modifyRelationship$1.INSTANCE, FriendshipPresenter$modifyRelationship$2.INSTANCE);
    }
}
