package id.dana.social.presenter;

import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.domain.social.core.SingleUseCase;
import id.dana.feeds.domain.relationship.interactor.GetMutedFollowing;
import id.dana.feeds.domain.relationship.interactor.ModifyFollowingRelationship;
import id.dana.feeds.domain.relationship.interactor.StartFollowingFullSync;
import id.dana.feeds.domain.relationship.model.Following;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.contract.MutedFragmentContract;
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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB)\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\u0006\u0010\u0019\u001a\u00020\r\u0012\u0006\u0010\u001a\u001a\u00020\u0013¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0006\u0010\tR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR*\u0010\u0003\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u00110\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u0015X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/social/presenter/MutedFragmentPresenter;", "Lid/dana/social/contract/MutedFragmentContract$Presenter;", "", "getAuthRequestContext", "()V", "onDestroy", "MyBillsEntityDataFactory", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "p0", "(Lid/dana/feeds/ui/model/RelationshipItemModel;)V", "Lid/dana/feeds/domain/relationship/interactor/GetMutedFollowing;", "Lid/dana/feeds/domain/relationship/interactor/GetMutedFollowing;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowingRelationship;", "PlaceComponentResult", "Lid/dana/feeds/domain/relationship/interactor/ModifyFollowingRelationship;", "Lio/reactivex/subjects/PublishSubject;", "", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/feeds/domain/relationship/interactor/StartFollowingFullSync;", "Lid/dana/feeds/domain/relationship/interactor/StartFollowingFullSync;", "Lid/dana/social/contract/MutedFragmentContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/contract/MutedFragmentContract$View;", "p1", "p2", "p3", "<init>", "(Lid/dana/social/contract/MutedFragmentContract$View;Lid/dana/feeds/domain/relationship/interactor/GetMutedFollowing;Lid/dana/feeds/domain/relationship/interactor/ModifyFollowingRelationship;Lid/dana/feeds/domain/relationship/interactor/StartFollowingFullSync;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MutedFragmentPresenter implements MutedFragmentContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final PublishSubject<List<RelationshipItemModel>> getAuthRequestContext;
    final MutedFragmentContract.View KClassImpl$Data$declaredNonStaticMembers$2;
    private final StartFollowingFullSync MyBillsEntityDataFactory;
    private final ModifyFollowingRelationship PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetMutedFollowing BuiltInFictitiousFunctionClassFactory;

    @Inject
    public MutedFragmentPresenter(MutedFragmentContract.View view, GetMutedFollowing getMutedFollowing, ModifyFollowingRelationship modifyFollowingRelationship, StartFollowingFullSync startFollowingFullSync) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getMutedFollowing, "");
        Intrinsics.checkNotNullParameter(modifyFollowingRelationship, "");
        Intrinsics.checkNotNullParameter(startFollowingFullSync, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.BuiltInFictitiousFunctionClassFactory = getMutedFollowing;
        this.PlaceComponentResult = modifyFollowingRelationship;
        this.MyBillsEntityDataFactory = startFollowingFullSync;
        PublishSubject<List<RelationshipItemModel>> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.getAuthRequestContext = PlaceComponentResult;
        PlaceComponentResult.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(AndroidSchedulers.PlaceComponentResult()).throttleLatest(1000L, TimeUnit.MILLISECONDS).subscribe(new DefaultObserver<List<? extends RelationshipItemModel>>() { // from class: id.dana.social.presenter.MutedFragmentPresenter$getMutedFollowingObserver$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                List<RelationshipItemModel> list = (List) obj;
                Intrinsics.checkNotNullParameter(list, "");
                MutedFragmentPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(list);
            }
        });
    }

    @Override // id.dana.social.contract.MutedFragmentContract.Presenter
    public final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1<Following, Unit>() { // from class: id.dana.social.presenter.MutedFragmentPresenter$getMutedFollowingList$1
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
                Intrinsics.checkNotNullParameter(following, "");
                publishSubject = MutedFragmentPresenter.this.getAuthRequestContext;
                publishSubject.onNext(RelationshipItemListToRelationshipItemModelListKt.KClassImpl$Data$declaredNonStaticMembers$2(following.getFollowingItemList()));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.MutedFragmentPresenter$getMutedFollowingList$2
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
                MutedFragmentPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.RELATIONSHIP, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.social.contract.MutedFragmentContract.Presenter
    public final void MyBillsEntityDataFactory(final RelationshipItemModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.executeJava1(MapsKt.mapOf(new Pair(p0.GetContactSyncConfig, ModifyRelationOperationType.UNMUTE)), new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.MutedFragmentPresenter$unmuteFollowing$1
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
                MutedFragmentPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(p0);
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.presenter.MutedFragmentPresenter$unmuteFollowing$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                return MutedFragmentPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }, this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorSource());
    }

    @Override // id.dana.social.contract.MutedFragmentContract.Presenter
    public final void MyBillsEntityDataFactory() {
        SingleUseCase.execute$default(this.MyBillsEntityDataFactory, Unit.INSTANCE, null, new Function1<Exception, Unit>() { // from class: id.dana.social.presenter.MutedFragmentPresenter$startFetchingFollowing$1
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
        }, 2, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.PlaceComponentResult.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }
}
