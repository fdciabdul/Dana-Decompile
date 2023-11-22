package id.dana.data.familyaccount.repository.source.network;

import id.dana.data.familyaccount.model.result.ApproveSendMoneyResultEntity;
import id.dana.network.base.ExceptionParser;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/familyaccount/repository/source/network/FamilyAccountExceptionParser;", "Lid/dana/network/base/ExceptionParser;", "Lid/dana/data/familyaccount/model/result/ApproveSendMoneyResultEntity;", "baseResult", "Lio/reactivex/Observable;", "apply", "(Lid/dana/data/familyaccount/model/result/ApproveSendMoneyResultEntity;)Lio/reactivex/Observable;", "result", "", "isRiskRejectFamilyAccountApproval", "(Lid/dana/data/familyaccount/model/result/ApproveSendMoneyResultEntity;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FamilyAccountExceptionParser extends ExceptionParser<ApproveSendMoneyResultEntity> {
    @Override // id.dana.network.base.ExceptionParser, io.reactivex.functions.Function
    public final Observable<ApproveSendMoneyResultEntity> apply(ApproveSendMoneyResultEntity baseResult) {
        Intrinsics.checkNotNullParameter(baseResult, "");
        if (isRiskRejectFamilyAccountApproval(baseResult)) {
            Observable<ApproveSendMoneyResultEntity> just = Observable.just(baseResult);
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<ApproveSendMoneyResultEntity> apply = super.apply((FamilyAccountExceptionParser) baseResult);
        Intrinsics.checkNotNullExpressionValue(apply, "");
        return apply;
    }

    private final boolean isRiskRejectFamilyAccountApproval(ApproveSendMoneyResultEntity result) {
        return Intrinsics.areEqual(result.errorCode, "AE15112168003027");
    }
}
