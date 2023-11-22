package id.dana.social.presenter;

import id.dana.domain.DefaultObserver;
import id.dana.feeds.domain.config.interactor.ApproveFriendRequest;
import id.dana.feeds.domain.config.interactor.DeclineFriendRequest;
import id.dana.feeds.domain.friend.interactor.FetchFriendRequestList;
import id.dana.feeds.domain.friend.model.Friend;
import id.dana.feeds.domain.friend.model.FriendRequestList;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.social.contract.FriendRequestContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020\u0013\u0012\u0006\u0010+\u001a\u00020\r\u0012\u0006\u0010,\u001a\u00020\u000f¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0007\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0005\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nR\u0014\u0010\f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001b\u001a\f\u0012\b\u0012\u0006*\u00020\b0\b0\u0019X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u001aR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0017X\u0096\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u0007\u0010\u001eR\"\u0010\u0017\u001a\u00020 8\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010!\u001a\u0004\b\u001b\u0010\"\"\u0004\b\u0007\u0010#R\"\u0010\u0010\u001a\u00020$8\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010%\u001a\u0004\b\u0012\u0010&\"\u0004\b\u0005\u0010'R\u0014\u0010\u0014\u001a\u00020(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010)"}, d2 = {"Lid/dana/social/presenter/FriendRequestPresenter;", "Lid/dana/social/contract/FriendRequestContract$Presenter;", "Lid/dana/feeds/ui/model/FriendModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/ui/model/FriendModel;)V", "getAuthRequestContext", "", "(I)V", "()V", "onDestroy", "PlaceComponentResult", "Lid/dana/feeds/domain/config/interactor/ApproveFriendRequest;", "Lid/dana/feeds/domain/config/interactor/ApproveFriendRequest;", "Lid/dana/feeds/domain/config/interactor/DeclineFriendRequest;", "lookAheadTest", "Lid/dana/feeds/domain/config/interactor/DeclineFriendRequest;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/friend/interactor/FetchFriendRequestList;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/feeds/domain/friend/interactor/FetchFriendRequestList;", "Lid/dana/domain/DefaultObserver;", "scheduleImpl", "Lid/dana/domain/DefaultObserver;", "Lio/reactivex/subjects/PublishSubject;", "Lio/reactivex/subjects/PublishSubject;", "MyBillsEntityDataFactory", "", "Ljava/util/List;", "()Ljava/util/List;", "getErrorConfigVersion", "", "Z", "()Z", "(Z)V", "", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "Lid/dana/social/contract/FriendRequestContract$View;", "Lid/dana/social/contract/FriendRequestContract$View;", "p1", "p2", "p3", "<init>", "(Lid/dana/social/contract/FriendRequestContract$View;Lid/dana/feeds/domain/friend/interactor/FetchFriendRequestList;Lid/dana/feeds/domain/config/interactor/ApproveFriendRequest;Lid/dana/feeds/domain/config/interactor/DeclineFriendRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendRequestPresenter implements FriendRequestContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    List<FriendModel> getErrorConfigVersion;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    String lookAheadTest;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    boolean scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final FetchFriendRequestList BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public PublishSubject<Integer> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ApproveFriendRequest PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final FriendRequestContract.View NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final DeclineFriendRequest KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private DefaultObserver<Integer> getAuthRequestContext;

    @Inject
    public FriendRequestPresenter(FriendRequestContract.View view, FetchFriendRequestList fetchFriendRequestList, ApproveFriendRequest approveFriendRequest, DeclineFriendRequest declineFriendRequest) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(fetchFriendRequestList, "");
        Intrinsics.checkNotNullParameter(approveFriendRequest, "");
        Intrinsics.checkNotNullParameter(declineFriendRequest, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        this.BuiltInFictitiousFunctionClassFactory = fetchFriendRequestList;
        this.PlaceComponentResult = approveFriendRequest;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = declineFriendRequest;
        this.getErrorConfigVersion = CollectionsKt.emptyList();
        PublishSubject<Integer> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.MyBillsEntityDataFactory = PlaceComponentResult;
        this.scheduleImpl = true;
        this.lookAheadTest = "";
        Observable<Integer> observeOn = PlaceComponentResult.debounce(500L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult());
        DefaultObserver<Integer> defaultObserver = new DefaultObserver<Integer>() { // from class: id.dana.social.presenter.FriendRequestPresenter$getFetchIncomingRequestObserver$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                int intValue = ((Number) obj).intValue();
                FriendRequestPresenter.this.PlaceComponentResult();
                FriendRequestPresenter.this.getAuthRequestContext(intValue);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory("Feeds Friend Request", p0.getMessage());
            }
        };
        this.getAuthRequestContext = defaultObserver;
        observeOn.subscribe(defaultObserver);
    }

    @Override // id.dana.social.contract.FriendRequestContract.Presenter
    @JvmName(name = "getAuthRequestContext")
    public final List<FriendModel> getAuthRequestContext() {
        return this.getErrorConfigVersion;
    }

    @Override // id.dana.social.contract.FriendRequestContract.Presenter
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getScheduleImpl() {
        return this.scheduleImpl;
    }

    @Override // id.dana.social.contract.FriendRequestContract.Presenter
    @JvmName(name = "getAuthRequestContext")
    public final void getAuthRequestContext(boolean z) {
        this.scheduleImpl = z;
    }

    @Override // id.dana.social.contract.FriendRequestContract.Presenter
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.lookAheadTest = str;
    }

    @Override // id.dana.social.contract.FriendRequestContract.Presenter
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final String getLookAheadTest() {
        return this.lookAheadTest;
    }

    @Override // id.dana.social.contract.FriendRequestContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.MyBillsEntityDataFactory.onNext(10);
    }

    @Override // id.dana.social.contract.FriendRequestContract.Presenter
    public final void getAuthRequestContext(int p0) {
        if (getScheduleImpl()) {
            this.BuiltInFictitiousFunctionClassFactory.execute(new FetchFriendRequestList.Params(p0, this.lookAheadTest), new Function1<FriendRequestList, Unit>() { // from class: id.dana.social.presenter.FriendRequestPresenter$fetchFriendRequest$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(FriendRequestList friendRequestList) {
                    invoke2(friendRequestList);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(FriendRequestList friendRequestList) {
                    FriendRequestContract.View view;
                    Intrinsics.checkNotNullParameter(friendRequestList, "");
                    String str = FriendRequestPresenter.this.lookAheadTest;
                    FriendRequestPresenter.this.scheduleImpl = friendRequestList.getHasMore();
                    FriendRequestPresenter friendRequestPresenter = FriendRequestPresenter.this;
                    String minId = friendRequestList.getMinId();
                    Intrinsics.checkNotNullParameter(minId, "");
                    friendRequestPresenter.lookAheadTest = minId;
                    List<Friend> friendList = friendRequestList.getFriendList();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(friendList, 10));
                    for (Friend friend : friendList) {
                        FriendModel.Companion companion = FriendModel.INSTANCE;
                        arrayList.add(FriendModel.Companion.BuiltInFictitiousFunctionClassFactory(friend));
                    }
                    ArrayList arrayList2 = arrayList;
                    String str2 = str;
                    if (str2.length() == 0) {
                        FriendRequestPresenter friendRequestPresenter2 = FriendRequestPresenter.this;
                        Intrinsics.checkNotNullParameter(arrayList2, "");
                        friendRequestPresenter2.getErrorConfigVersion = arrayList2;
                    }
                    view = FriendRequestPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view.PlaceComponentResult(arrayList2, str2.length() == 0);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.FriendRequestPresenter$fetchFriendRequest$2
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
                    FriendRequestContract.View view;
                    FriendRequestContract.View view2;
                    FriendRequestContract.View view3;
                    Intrinsics.checkNotNullParameter(th, "");
                    view = FriendRequestPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view.getAuthRequestContext();
                    view2 = FriendRequestPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view3 = FriendRequestPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view2.MyBillsEntityDataFactory(th, "id.dana.feedengine.friendship.incomingRequestList", view3.getErrorSource());
                    FriendRequestPresenter friendRequestPresenter = FriendRequestPresenter.this;
                    List<FriendModel> emptyList = CollectionsKt.emptyList();
                    Intrinsics.checkNotNullParameter(emptyList, "");
                    friendRequestPresenter.getErrorConfigVersion = emptyList;
                }
            });
        }
    }

    @Override // id.dana.social.contract.FriendRequestContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final FriendModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.execute(new ApproveFriendRequest.Params(p0.NetworkUserEntityData$$ExternalSyntheticLambda0), new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.FriendRequestPresenter$approveFriendRequest$1
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
                FriendRequestContract.View view;
                FriendRequestContract.View view2;
                if (z) {
                    view2 = FriendRequestPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view2.MyBillsEntityDataFactory(p0);
                    return;
                }
                view = FriendRequestPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.getAuthRequestContext(p0);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.FriendRequestPresenter$approveFriendRequest$2
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
                FriendRequestContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = FriendRequestPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.getAuthRequestContext(p0);
            }
        });
    }

    @Override // id.dana.social.contract.FriendRequestContract.Presenter
    public final void getAuthRequestContext(final FriendModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DeclineFriendRequest.Params(p0.NetworkUserEntityData$$ExternalSyntheticLambda0), new Function1<Boolean, Unit>() { // from class: id.dana.social.presenter.FriendRequestPresenter$declineFriendRequest$1
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
                FriendRequestContract.View view;
                FriendRequestContract.View view2;
                if (z) {
                    view2 = FriendRequestPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    view2.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                    return;
                }
                view = FriendRequestPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.PlaceComponentResult(p0);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.FriendRequestPresenter$declineFriendRequest$2
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
                FriendRequestContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = FriendRequestPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                view.PlaceComponentResult(p0);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.PlaceComponentResult.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        DefaultObserver<Integer> defaultObserver = this.getAuthRequestContext;
        if (defaultObserver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            defaultObserver = null;
        }
        defaultObserver.dispose();
    }

    @Override // id.dana.social.contract.FriendRequestContract.Presenter
    public final void PlaceComponentResult() {
        this.scheduleImpl = true;
        Intrinsics.checkNotNullParameter("", "");
        this.lookAheadTest = "";
        List<FriendModel> emptyList = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(emptyList, "");
        this.getErrorConfigVersion = emptyList;
    }
}
