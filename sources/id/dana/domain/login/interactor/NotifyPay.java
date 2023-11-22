package id.dana.domain.login.interactor;

import com.alipay.iap.android.common.product.delegate.IAPLoginUserInfo;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import id.dana.domain.account.Account;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import io.reactivex.Completable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/login/interactor/NotifyPay;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Completable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Completable;", "Lid/dana/domain/account/LiteAccountRepository;", "liteAccountRepository", "Lid/dana/domain/account/LiteAccountRepository;", "<init>", "(Lid/dana/domain/account/LiteAccountRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NotifyPay extends CompletableUseCase<NoParams> {
    private final LiteAccountRepository liteAccountRepository;

    @Inject
    public NotifyPay(LiteAccountRepository liteAccountRepository) {
        Intrinsics.checkNotNullParameter(liteAccountRepository, "");
        this.liteAccountRepository = liteAccountRepository;
    }

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final Completable buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Completable ignoreElements = this.liteAccountRepository.getAccount().map(new Function() { // from class: id.dana.domain.login.interactor.NotifyPay$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Unit m2363buildUseCase$lambda1;
                m2363buildUseCase$lambda1 = NotifyPay.m2363buildUseCase$lambda1((Account) obj);
                return m2363buildUseCase$lambda1;
            }
        }).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final Unit m2363buildUseCase$lambda1(Account account) {
        Intrinsics.checkNotNullParameter(account, "");
        String userId = account.getUserId();
        if (!(userId == null || userId.length() == 0)) {
            String sessionId = account.getSessionId();
            if (!(sessionId == null || sessionId.length() == 0)) {
                IAPLoginUserInfo iAPLoginUserInfo = new IAPLoginUserInfo();
                iAPLoginUserInfo.userID = account.getUserId();
                iAPLoginUserInfo.sessionID = account.getSessionId();
                UserInfoManager.instance().loginNotify(iAPLoginUserInfo);
            }
        }
        return Unit.INSTANCE;
    }
}
