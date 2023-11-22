package id.dana.social.presenter;

import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.feeds.domain.relationship.interactor.GetBlockedFollower;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowerRelationship;
import id.dana.feeds.domain.relationship.interactor.StartFollowerFullSync;
import id.dana.feeds.domain.relationship.model.Follower;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.contract.BlockedFragmentContract;
import id.dana.social.mapper.RelationshipItemListToRelationshipItemModelListKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB)\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR*\u0010\r\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\f0\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\t\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0016X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017"}, d2 = {"Lid/dana/social/presenter/BlockedFragmentPresenter;", "Lid/dana/social/contract/BlockedFragmentContract$Presenter;", "", "getAuthRequestContext", "()V", "onDestroy", "PlaceComponentResult", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "p0", "MyBillsEntityDataFactory", "(Lid/dana/feeds/ui/model/RelationshipItemModel;)V", "Lio/reactivex/subjects/PublishSubject;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/feeds/domain/relationship/interactor/GetBlockedFollower;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/domain/relationship/interactor/GetBlockedFollower;", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowerRelationship;", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowerRelationship;", "Lid/dana/feeds/domain/relationship/interactor/StartFollowerFullSync;", "Lid/dana/feeds/domain/relationship/interactor/StartFollowerFullSync;", "Lid/dana/social/contract/BlockedFragmentContract$View;", "Lid/dana/social/contract/BlockedFragmentContract$View;", "p1", "p2", "p3", "<init>", "(Lid/dana/social/contract/BlockedFragmentContract$View;Lid/dana/feeds/domain/relationship/interactor/GetBlockedFollower;Lid/dana/feeds/domain/relationship/interactor/ModifyFollowerRelationship;Lid/dana/feeds/domain/relationship/interactor/StartFollowerFullSync;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BlockedFragmentPresenter implements BlockedFragmentContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GetBlockedFollower MyBillsEntityDataFactory;
    private final PublishSubject<List<RelationshipItemModel>> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final StartFollowerFullSync PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ModifyFollowerRelationship getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final BlockedFragmentContract.View BuiltInFictitiousFunctionClassFactory;

    @Inject
    public BlockedFragmentPresenter(BlockedFragmentContract.View view, GetBlockedFollower getBlockedFollower, ModifyFollowerRelationship modifyFollowerRelationship, StartFollowerFullSync startFollowerFullSync) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getBlockedFollower, "");
        Intrinsics.checkNotNullParameter(modifyFollowerRelationship, "");
        Intrinsics.checkNotNullParameter(startFollowerFullSync, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.MyBillsEntityDataFactory = getBlockedFollower;
        this.getAuthRequestContext = modifyFollowerRelationship;
        this.PlaceComponentResult = startFollowerFullSync;
        PublishSubject<List<RelationshipItemModel>> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
        PlaceComponentResult.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(AndroidSchedulers.PlaceComponentResult()).throttleLatest(1000L, TimeUnit.MILLISECONDS).subscribe(new DefaultObserver<List<? extends RelationshipItemModel>>() { // from class: id.dana.social.presenter.BlockedFragmentPresenter$getBlockedFollowingObserver$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                List<RelationshipItemModel> list = (List) obj;
                Intrinsics.checkNotNullParameter(list, "");
                BlockedFragmentPresenter.this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(list);
            }
        });
    }

    public final void getAuthRequestContext() {
        this.MyBillsEntityDataFactory.execute(NoParams.INSTANCE, new Function1<Follower, Unit>() { // from class: id.dana.social.presenter.BlockedFragmentPresenter$getBlockedFollowerList$1
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
                Intrinsics.checkNotNullParameter(follower, "");
                publishSubject = BlockedFragmentPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                publishSubject.onNext(RelationshipItemListToRelationshipItemModelListKt.KClassImpl$Data$declaredNonStaticMembers$2(follower.getFollowerItemList()));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.BlockedFragmentPresenter$getBlockedFollowerList$2
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
                BlockedFragmentPresenter.this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.social.contract.BlockedFragmentContract.Presenter
    public final void MyBillsEntityDataFactory(final RelationshipItemModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.executeJava1(MapsKt.mapOf(new Pair(p0.GetContactSyncConfig, ModifyRelationOperationType.UNBLOCK)), new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.BlockedFragmentPresenter$unblockFollower$1
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
                BlockedFragmentPresenter.this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.BlockedFragmentPresenter$unblockFollower$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return BlockedFragmentPresenter.this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            }
        }, this.BuiltInFictitiousFunctionClassFactory.getErrorSource());
    }

    @Override // id.dana.social.contract.BlockedFragmentContract.Presenter
    public final void PlaceComponentResult() {
        this.PlaceComponentResult.execute(Unit.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.BlockedFragmentPresenter$startFetchingFollower$1
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
                BlockedFragmentPresenter.this.getAuthRequestContext();
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.social.presenter.BlockedFragmentPresenter$startFetchingFollower$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                BlockedFragmentPresenter.this.getAuthRequestContext();
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, exc.getMessage(), exc);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.getAuthRequestContext.dispose();
        this.PlaceComponentResult.dispose();
    }
}
