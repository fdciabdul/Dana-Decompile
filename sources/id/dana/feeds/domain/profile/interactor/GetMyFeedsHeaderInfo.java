package id.dana.feeds.domain.profile.interactor;

import id.dana.domain.account.Account;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.repository.UserRepository;
import id.dana.feeds.domain.profile.model.MyFeedsHeaderInfo;
import id.dana.feeds.domain.share.FeedsShareRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function3;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\f"}, d2 = {"Lid/dana/feeds/domain/profile/interactor/GetMyFeedsHeaderInfo;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/feeds/domain/profile/model/MyFeedsHeaderInfo;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/domain/account/AccountRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/account/AccountRepository;", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "getAuthRequestContext", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "PlaceComponentResult", "Lid/dana/domain/user/repository/UserRepository;", "Lid/dana/domain/user/repository/UserRepository;", "MyBillsEntityDataFactory", "p0", "p1", "p2", "<init>", "(Lid/dana/domain/user/repository/UserRepository;Lid/dana/domain/account/AccountRepository;Lid/dana/feeds/domain/share/FeedsShareRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetMyFeedsHeaderInfo extends BaseUseCase<MyFeedsHeaderInfo, NoParams> {
    private final AccountRepository BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final UserRepository MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FeedsShareRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<MyFeedsHeaderInfo> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        Observable<MyFeedsHeaderInfo> zip = Observable.zip(this.BuiltInFictitiousFunctionClassFactory.getAccount(), this.MyBillsEntityDataFactory.getUserInfo(true), Observable.fromCallable(new Callable() { // from class: id.dana.feeds.domain.profile.interactor.GetMyFeedsHeaderInfo$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return GetMyFeedsHeaderInfo.BuiltInFictitiousFunctionClassFactory(GetMyFeedsHeaderInfo.this);
            }
        }), new Function3() { // from class: id.dana.feeds.domain.profile.interactor.GetMyFeedsHeaderInfo$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                return GetMyFeedsHeaderInfo.BuiltInFictitiousFunctionClassFactory(GetMyFeedsHeaderInfo.this, (Account) obj, (UserInfoResponse) obj2, (Boolean) obj3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    @Inject
    public GetMyFeedsHeaderInfo(UserRepository userRepository, AccountRepository accountRepository, FeedsShareRepository feedsShareRepository) {
        Intrinsics.checkNotNullParameter(userRepository, "");
        Intrinsics.checkNotNullParameter(accountRepository, "");
        Intrinsics.checkNotNullParameter(feedsShareRepository, "");
        this.MyBillsEntityDataFactory = userRepository;
        this.BuiltInFictitiousFunctionClassFactory = accountRepository;
        this.PlaceComponentResult = feedsShareRepository;
    }

    public static /* synthetic */ Boolean BuiltInFictitiousFunctionClassFactory(GetMyFeedsHeaderInfo getMyFeedsHeaderInfo) {
        Intrinsics.checkNotNullParameter(getMyFeedsHeaderInfo, "");
        return Boolean.valueOf(getMyFeedsHeaderInfo.PlaceComponentResult.PlaceComponentResult());
    }

    public static /* synthetic */ MyFeedsHeaderInfo BuiltInFictitiousFunctionClassFactory(GetMyFeedsHeaderInfo getMyFeedsHeaderInfo, Account account, UserInfoResponse userInfoResponse, Boolean bool) {
        Intrinsics.checkNotNullParameter(getMyFeedsHeaderInfo, "");
        Intrinsics.checkNotNullParameter(account, "");
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        Intrinsics.checkNotNullParameter(bool, "");
        boolean booleanValue = bool.booleanValue();
        String userId = account.getUserId();
        Intrinsics.checkNotNullExpressionValue(userId, "");
        return new MyFeedsHeaderInfo(userId, userInfoResponse.getNickname(), userInfoResponse.getKycInfo(), userInfoResponse.getAvatarUrl(), booleanValue, userInfoResponse.getUsername());
    }
}
