package id.dana.data.recentrecipient.source.mock;

import id.dana.data.recentrecipient.model.BankCardConversionResult;
import id.dana.data.recentrecipient.source.BankCardConversionEntityData;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/recentrecipient/source/mock/MockBankCardConversionEntityData;", "Lid/dana/data/recentrecipient/source/BankCardConversionEntityData;", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "recentRecipient", "", "publicKey", "", "encryptCardEnabled", "Lio/reactivex/Observable;", "Lid/dana/data/recentrecipient/model/BankCardConversionResult;", "convertCardIndexNo", "(Lid/dana/domain/recentrecipient/model/RecentRecipient;Ljava/lang/String;Z)Lio/reactivex/Observable;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MockBankCardConversionEntityData implements BankCardConversionEntityData {
    @Override // id.dana.data.recentrecipient.source.BankCardConversionEntityData
    public final Observable<BankCardConversionResult> convertCardIndexNo(RecentRecipient recentRecipient, String publicKey, boolean encryptCardEnabled) {
        Intrinsics.checkNotNullParameter(recentRecipient, "");
        Intrinsics.checkNotNullParameter(publicKey, "");
        Observable<BankCardConversionResult> just = Observable.just(new BankCardConversionResult("74278yhjyhdjsfsjbjkbhj8-457972b2u502.9327952", "14150*****2489"));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
