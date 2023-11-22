package id.dana.feeds.domain.reactions.interactor;

import id.dana.domain.account.AccountRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import id.dana.feeds.domain.reactions.model.MyActivityReactionInfo;
import io.reactivex.Observable;
import io.reactivex.functions.Function3;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/feeds/domain/reactions/interactor/GetMyActivityReactionInfo;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/feeds/domain/reactions/model/MyActivityReactionInfo;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/domain/account/AccountRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/account/AccountRepository;", "MyBillsEntityDataFactory", "Lid/dana/domain/user/repository/UserRepository;", "PlaceComponentResult", "Lid/dana/domain/user/repository/UserRepository;", "getAuthRequestContext", "p0", "p1", "<init>", "(Lid/dana/domain/user/repository/UserRepository;Lid/dana/domain/account/AccountRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetMyActivityReactionInfo extends BaseUseCase<MyActivityReactionInfo, NoParams> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final AccountRepository MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final UserRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<MyActivityReactionInfo> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        Observable<MyActivityReactionInfo> zip = Observable.zip(this.getAuthRequestContext.getUserInfo(false), this.MyBillsEntityDataFactory.getAvatarUrl(), this.MyBillsEntityDataFactory.getUserId(), new Function3() { // from class: id.dana.feeds.domain.reactions.interactor.GetMyActivityReactionInfo$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                return GetMyActivityReactionInfo.MyBillsEntityDataFactory(GetMyActivityReactionInfo.this, (UserInfoResponse) obj, (String) obj2, (String) obj3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    @Inject
    public GetMyActivityReactionInfo(UserRepository userRepository, AccountRepository accountRepository) {
        Intrinsics.checkNotNullParameter(userRepository, "");
        Intrinsics.checkNotNullParameter(accountRepository, "");
        this.getAuthRequestContext = userRepository;
        this.MyBillsEntityDataFactory = accountRepository;
    }

    public static /* synthetic */ MyActivityReactionInfo MyBillsEntityDataFactory(GetMyActivityReactionInfo getMyActivityReactionInfo, UserInfoResponse userInfoResponse, String str, String str2) {
        Intrinsics.checkNotNullParameter(getMyActivityReactionInfo, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return new MyActivityReactionInfo(userInfoResponse.getNickname(), str, str2);
    }
}
