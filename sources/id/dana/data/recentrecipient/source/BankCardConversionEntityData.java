package id.dana.data.recentrecipient.source;

import id.dana.data.recentrecipient.model.BankCardConversionResult;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/recentrecipient/source/BankCardConversionEntityData;", "", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "recentRecipient", "", "publicKey", "", "encryptCardEnabled", "Lio/reactivex/Observable;", "Lid/dana/data/recentrecipient/model/BankCardConversionResult;", "convertCardIndexNo", "(Lid/dana/domain/recentrecipient/model/RecentRecipient;Ljava/lang/String;Z)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface BankCardConversionEntityData {
    Observable<BankCardConversionResult> convertCardIndexNo(RecentRecipient recentRecipient, String publicKey, boolean encryptCardEnabled);
}
