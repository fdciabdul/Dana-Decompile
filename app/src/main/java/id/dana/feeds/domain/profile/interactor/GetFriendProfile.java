package id.dana.feeds.domain.profile.interactor;

import id.dana.domain.account.Account;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import id.dana.feeds.domain.relationship.model.RelationshipItem;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0019\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/feeds/domain/profile/interactor/GetFriendProfile;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/feeds/domain/relationship/model/RelationshipItem;", "Lid/dana/feeds/domain/profile/interactor/GetFriendProfile$Params;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Z", "Lid/dana/domain/account/AccountRepository;", "getAuthRequestContext", "Lid/dana/domain/account/AccountRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "p1", "<init>", "(Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;Lid/dana/domain/account/AccountRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetFriendProfile extends BaseUseCase<RelationshipItem, Params> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FeedsRelationshipRepository BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final AccountRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<RelationshipItem> buildUseCase(Params params) {
        Observable observable;
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        int i = 0;
        if (BuiltInFictitiousFunctionClassFactory(params2.MyBillsEntityDataFactory)) {
            if (params2.getPlaceComponentResult()) {
                observable = this.BuiltInFictitiousFunctionClassFactory.lookAheadTest().onErrorReturnItem(0).flatMap(new Function() { // from class: id.dana.feeds.domain.profile.interactor.GetFriendProfile$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return GetFriendProfile.getAuthRequestContext(GetFriendProfile.this, (Integer) obj);
                    }
                });
            } else {
                observable = this.KClassImpl$Data$declaredNonStaticMembers$2.getAccount().switchMap(new GetFriendProfile$$ExternalSyntheticLambda0(this, i));
            }
            Intrinsics.checkNotNullExpressionValue(observable, "");
            return observable;
        }
        Observable<RelationshipItem> onErrorResumeNext = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(params2.MyBillsEntityDataFactory, false).take(1L).onErrorResumeNext(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(params2.MyBillsEntityDataFactory).take(1L).map(new Function() { // from class: id.dana.feeds.domain.profile.interactor.GetFriendProfile$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetFriendProfile.BuiltInFictitiousFunctionClassFactory((RelationshipItem) obj);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    @Inject
    public GetFriendProfile(FeedsRelationshipRepository feedsRelationshipRepository, AccountRepository accountRepository) {
        Intrinsics.checkNotNullParameter(feedsRelationshipRepository, "");
        Intrinsics.checkNotNullParameter(accountRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = feedsRelationshipRepository;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = accountRepository;
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        return Intrinsics.areEqual(p0, this.KClassImpl$Data$declaredNonStaticMembers$2.getUserId().blockingFirst());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\n\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\t"}, d2 = {"Lid/dana/feeds/domain/profile/interactor/GetFriendProfile$Params;", "", "", "BuiltInFictitiousFunctionClassFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "PlaceComponentResult", "", "Ljava/lang/String;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final boolean PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        public Params(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            this.MyBillsEntityDataFactory = str;
            this.PlaceComponentResult = z;
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }

    public static /* synthetic */ RelationshipItem BuiltInFictitiousFunctionClassFactory(RelationshipItem relationshipItem) {
        Intrinsics.checkNotNullParameter(relationshipItem, "");
        relationshipItem.setNonReciprocal(true);
        return relationshipItem;
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(GetFriendProfile getFriendProfile, Integer num) {
        Intrinsics.checkNotNullParameter(getFriendProfile, "");
        Intrinsics.checkNotNullParameter(num, "");
        return getFriendProfile.KClassImpl$Data$declaredNonStaticMembers$2.getAccount().switchMap(new GetFriendProfile$$ExternalSyntheticLambda0(getFriendProfile, num.intValue()));
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(GetFriendProfile getFriendProfile, int i, Account account) {
        Intrinsics.checkNotNullParameter(getFriendProfile, "");
        Intrinsics.checkNotNullParameter(account, "");
        String nickname = account.getNickname();
        Intrinsics.checkNotNullExpressionValue(nickname, "");
        String userId = account.getUserId();
        Intrinsics.checkNotNullExpressionValue(userId, "");
        String avatarUrl = account.getAvatarUrl();
        String username = account.getUsername();
        Intrinsics.checkNotNullExpressionValue(username, "");
        Observable just = Observable.just(new RelationshipItem(null, nickname, "SELF", userId, avatarUrl, username, false, i, 65, null));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
