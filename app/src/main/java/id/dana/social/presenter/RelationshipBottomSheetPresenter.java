package id.dana.social.presenter;

import dagger.Lazy;
import id.dana.base.AbstractContractKt;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckFeedInboxTabFeature;
import id.dana.domain.profilemenu.interactor.GetSettingByKey;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.domain.social.model.FeedConfig;
import id.dana.feeds.domain.config.interactor.GetFeedConfig;
import id.dana.feeds.domain.relationship.interactor.GetReciprocalFriend;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowerRelationship;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowingRelationship;
import id.dana.feeds.domain.relationship.interactor.StartFollowingFullSync;
import id.dana.feeds.domain.relationship.model.Following;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.contract.RelationshipBottomSheetContract;
import id.dana.social.mapper.RelationshipItemListToRelationshipItemModelListKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
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

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ;2\u00020\u0001:\u0001;By\b\u0007\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002010\u0019\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0019\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020/0\u0019\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020%0\u0019\u0012\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0019\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0003\u0010\bJC\u0010\u000e\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t2\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t0\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u001f\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0003\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0004R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001bR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001bR \u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020%0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001bR \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R \u0010'\u001a\f\u0012\b\u0012\u0006*\u00020\f0\f0\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0)8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0080\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010,R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010(R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020/0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\u001bR\u001a\u00102\u001a\b\u0012\u0004\u0012\u0002010\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010\u001b"}, d2 = {"Lid/dana/social/presenter/RelationshipBottomSheetPresenter;", "Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "", "PlaceComponentResult", "()V", "Lio/reactivex/subjects/PublishSubject;", "", "p0", "(Lio/reactivex/subjects/PublishSubject;)V", "", "Lid/dana/domain/social/ModifyRelationOperationType;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "", "p1", "MyBillsEntityDataFactory", "(Ljava/util/Map;Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;)V", "", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "getAuthRequestContext", "()Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "(Ljava/lang/String;Lid/dana/domain/social/ModifyRelationOperationType;)V", "onDestroy", "BuiltInFictitiousFunctionClassFactory", "Ldagger/Lazy;", "Lid/dana/domain/featureconfig/interactor/CheckFeedInboxTabFeature;", "Ldagger/Lazy;", "Lid/dana/feeds/domain/relationship/interactor/GetReciprocalFriend;", "Lid/dana/domain/profilemenu/interactor/GetSettingByKey;", "Lid/dana/feeds/domain/config/interactor/GetFeedConfig;", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowerRelationship;", "getErrorConfigVersion", "", "scheduleImpl", "Ljava/util/Map;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowingRelationship;", "moveToNextValue", "lookAheadTest", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/domain/DefaultObserver;", "GetContactSyncConfig", "Lid/dana/domain/DefaultObserver;", "Ljava/util/List;", "initRecordTimeStamp", "DatabaseTableConfigUtil", "Lid/dana/feeds/domain/relationship/interactor/StartFollowingFullSync;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/social/contract/RelationshipBottomSheetContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RelationshipBottomSheetPresenter implements RelationshipBottomSheetContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<CheckFeedInboxTabFeature> MyBillsEntityDataFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private PublishSubject<String> GetContactSyncConfig;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private DefaultObserver<Boolean> scheduleImpl;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Lazy<GetReciprocalFriend> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<GetSettingByKey> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Map<String, ModifyRelationOperationType> moveToNextValue;
    private final Lazy<RelationshipBottomSheetContract.View> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    List<RelationshipItemModel> initRecordTimeStamp;
    private final Lazy<GetFeedConfig> getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<ModifyFollowerRelationship> PlaceComponentResult;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy<StartFollowingFullSync> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private PublishSubject<Boolean> lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy<ModifyFollowingRelationship> getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Map<String, ModifyRelationOperationType> NetworkUserEntityData$$ExternalSyntheticLambda0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[ModifyRelationOperationType.values().length];
            iArr[ModifyRelationOperationType.MUTE.ordinal()] = 1;
            iArr[ModifyRelationOperationType.UNMUTE.ordinal()] = 2;
            MyBillsEntityDataFactory = iArr;
        }
    }

    @Inject
    public RelationshipBottomSheetPresenter(Lazy<RelationshipBottomSheetContract.View> lazy, Lazy<GetSettingByKey> lazy2, Lazy<StartFollowingFullSync> lazy3, Lazy<GetReciprocalFriend> lazy4, Lazy<ModifyFollowingRelationship> lazy5, Lazy<ModifyFollowerRelationship> lazy6, Lazy<CheckFeedInboxTabFeature> lazy7, Lazy<GetFeedConfig> lazy8) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lazy3;
        this.BuiltInFictitiousFunctionClassFactory = lazy4;
        this.getErrorConfigVersion = lazy5;
        this.PlaceComponentResult = lazy6;
        this.MyBillsEntityDataFactory = lazy7;
        this.getAuthRequestContext = lazy8;
        this.initRecordTimeStamp = CollectionsKt.emptyList();
        this.moveToNextValue = new LinkedHashMap();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new LinkedHashMap();
        PublishSubject<Boolean> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.lookAheadTest = PlaceComponentResult;
        Observable<Boolean> debounce = PlaceComponentResult.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).debounce(800L, TimeUnit.MILLISECONDS);
        DefaultObserver<Boolean> defaultObserver = new DefaultObserver<Boolean>() { // from class: id.dana.social.presenter.RelationshipBottomSheetPresenter$getModifyRelationshipObserver$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    RelationshipBottomSheetPresenter.MyBillsEntityDataFactory(RelationshipBottomSheetPresenter.this);
                } else {
                    RelationshipBottomSheetPresenter.BuiltInFictitiousFunctionClassFactory(RelationshipBottomSheetPresenter.this);
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(p0.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(sb.toString(), "");
            }
        };
        this.scheduleImpl = defaultObserver;
        debounce.subscribe(defaultObserver);
    }

    @Override // id.dana.social.contract.RelationshipBottomSheetContract.Presenter
    public final List<RelationshipItemModel> getAuthRequestContext() {
        return this.initRecordTimeStamp;
    }

    @Override // id.dana.social.contract.RelationshipBottomSheetContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(new DefaultObserver<SettingModel>() { // from class: id.dana.social.presenter.RelationshipBottomSheetPresenter$getProfileSettingModel$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                Lazy lazy;
                SettingModel settingModel = (SettingModel) obj;
                Intrinsics.checkNotNullParameter(settingModel, "");
                lazy = RelationshipBottomSheetPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                ((RelationshipBottomSheetContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(settingModel);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(p02, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory("RelationshipBottomSheetPresenter", p02.getMessage(), p02);
                lazy = RelationshipBottomSheetPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                ((RelationshipBottomSheetContract.View) lazy.get()).MyBillsEntityDataFactory();
            }
        }, GetSettingByKey.Params.forSettingKey(p0));
    }

    @Override // id.dana.social.contract.RelationshipBottomSheetContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().execute(Unit.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.RelationshipBottomSheetPresenter$refreshReciprocalList$1
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
                final RelationshipBottomSheetPresenter relationshipBottomSheetPresenter = RelationshipBottomSheetPresenter.this;
                relationshipBottomSheetPresenter.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function1<Following, Unit>() { // from class: id.dana.social.presenter.RelationshipBottomSheetPresenter$getActiveReciprocal$1
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
                        Lazy lazy;
                        Intrinsics.checkNotNullParameter(following, "");
                        RelationshipBottomSheetPresenter relationshipBottomSheetPresenter2 = RelationshipBottomSheetPresenter.this;
                        List<RelationshipItemModel> KClassImpl$Data$declaredNonStaticMembers$2 = RelationshipItemListToRelationshipItemModelListKt.KClassImpl$Data$declaredNonStaticMembers$2(following.getFollowingItemList());
                        Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
                        relationshipBottomSheetPresenter2.initRecordTimeStamp = KClassImpl$Data$declaredNonStaticMembers$2;
                        lazy = RelationshipBottomSheetPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                        ((RelationshipBottomSheetContract.View) lazy.get()).getAuthRequestContext(RelationshipBottomSheetPresenter.this.initRecordTimeStamp);
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.RelationshipBottomSheetPresenter$getActiveReciprocal$2
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
        }, new Function1<Exception, Unit>() { // from class: id.dana.social.presenter.RelationshipBottomSheetPresenter$refreshReciprocalList$2
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
        });
    }

    @Override // id.dana.social.contract.RelationshipBottomSheetContract.Presenter
    public final void PlaceComponentResult(PublishSubject<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.GetContactSyncConfig = p0;
        if (p0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            p0 = null;
        }
        p0.debounce(800L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new RelationshipBottomSheetPresenter$getSearchObserver$1(this));
    }

    @Override // id.dana.social.contract.RelationshipBottomSheetContract.Presenter
    public final void PlaceComponentResult(String p0, ModifyRelationOperationType p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        int i = WhenMappings.MyBillsEntityDataFactory[p1.ordinal()];
        DefaultObserver<Boolean> defaultObserver = null;
        if (i == 1 || i == 2) {
            this.moveToNextValue.put(p0, p1);
            DefaultObserver<Boolean> defaultObserver2 = this.scheduleImpl;
            if (defaultObserver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                defaultObserver = defaultObserver2;
            }
            defaultObserver.onNext(Boolean.TRUE);
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.put(p0, p1);
        DefaultObserver<Boolean> defaultObserver3 = this.scheduleImpl;
        if (defaultObserver3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            defaultObserver = defaultObserver3;
        }
        defaultObserver.onNext(Boolean.FALSE);
    }

    private final void MyBillsEntityDataFactory(final Map<String, ? extends ModifyRelationOperationType> p0, BaseUseCaseWithAnalytics<Boolean, Map<String, ModifyRelationOperationType>> p1) {
        p1.executeJava1(p0, new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.RelationshipBottomSheetPresenter$executeModifyRelationship$1
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
                Lazy lazy;
                ModifyRelationOperationType modifyRelationOperationType = (ModifyRelationOperationType) CollectionsKt.first(p0.values());
                lazy = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                ((RelationshipBottomSheetContract.View) lazy.get()).getAuthRequestContext(modifyRelationOperationType);
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.RelationshipBottomSheetPresenter$executeModifyRelationship$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, String.valueOf(th.getCause()));
                lazy = RelationshipBottomSheetPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                return ((RelationshipBottomSheetContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory();
            }
        }, this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().getErrorSource());
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        new RelationshipBottomSheetPresenter$getSearchObserver$1(this).dispose();
        DefaultObserver<Boolean> defaultObserver = this.scheduleImpl;
        if (defaultObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            defaultObserver = null;
        }
        defaultObserver.dispose();
        this.PlaceComponentResult.get().dispose();
        this.getErrorConfigVersion.get().dispose();
    }

    @Override // id.dana.social.contract.RelationshipBottomSheetContract.Presenter
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.RelationshipBottomSheetPresenter$checkFeedInboxTabEnable$1
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
                Lazy lazy;
                lazy = RelationshipBottomSheetPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                ((RelationshipBottomSheetContract.View) lazy.get()).MyBillsEntityDataFactory(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.RelationshipBottomSheetPresenter$checkFeedInboxTabEnable$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory("RelationshipBottomSheetPresenter", th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.social.contract.RelationshipBottomSheetContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.getAuthRequestContext.get().execute(NoParams.INSTANCE, new Function1<FeedConfig, Unit>() { // from class: id.dana.social.presenter.RelationshipBottomSheetPresenter$getSocialFeedConfig$1
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
                Lazy lazy;
                Intrinsics.checkNotNullParameter(feedConfig, "");
                lazy = RelationshipBottomSheetPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                ((RelationshipBottomSheetContract.View) lazy.get()).MyBillsEntityDataFactory(feedConfig);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.RelationshipBottomSheetPresenter$getSocialFeedConfig$2
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
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = RelationshipBottomSheetPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                ((RelationshipBottomSheetContract.View) lazy.get()).PlaceComponentResult();
            }
        });
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(RelationshipBottomSheetPresenter relationshipBottomSheetPresenter) {
        if (relationshipBottomSheetPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.isEmpty()) {
            return;
        }
        Map<String, ? extends ModifyRelationOperationType> map = MapsKt.toMap(relationshipBottomSheetPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0);
        relationshipBottomSheetPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
        ModifyFollowerRelationship modifyFollowerRelationship = relationshipBottomSheetPresenter.PlaceComponentResult.get();
        Intrinsics.checkNotNullExpressionValue(modifyFollowerRelationship, "");
        relationshipBottomSheetPresenter.MyBillsEntityDataFactory(map, modifyFollowerRelationship);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(RelationshipBottomSheetPresenter relationshipBottomSheetPresenter) {
        if (relationshipBottomSheetPresenter.moveToNextValue.isEmpty()) {
            return;
        }
        Map<String, ? extends ModifyRelationOperationType> map = MapsKt.toMap(relationshipBottomSheetPresenter.moveToNextValue);
        relationshipBottomSheetPresenter.moveToNextValue.clear();
        ModifyFollowingRelationship modifyFollowingRelationship = relationshipBottomSheetPresenter.getErrorConfigVersion.get();
        Intrinsics.checkNotNullExpressionValue(modifyFollowingRelationship, "");
        relationshipBottomSheetPresenter.MyBillsEntityDataFactory(map, modifyFollowingRelationship);
    }
}
