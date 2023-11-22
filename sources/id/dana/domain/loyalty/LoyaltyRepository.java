package id.dana.domain.loyalty;

import id.dana.domain.loyalty.model.Base64ReceiptLoyalty;
import id.dana.domain.loyalty.model.FileOcrReceiptLoyalty;
import id.dana.domain.loyalty.model.SubmitReceiptResult;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0007J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\n\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/loyalty/LoyaltyRepository;", "", "", "userLoyaltyId", "Lio/reactivex/Observable;", "Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;", "getReceiptData", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "removeReceiptData", "fileOcrReceiptLoyalty", "saveReceiptData", "(Lid/dana/domain/loyalty/model/FileOcrReceiptLoyalty;)Lio/reactivex/Observable;", "Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;", "base64ReceiptLoyalty", "token", "Lid/dana/domain/loyalty/model/SubmitReceiptResult;", "submitReceipt", "(Lid/dana/domain/loyalty/model/Base64ReceiptLoyalty;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface LoyaltyRepository {
    Observable<FileOcrReceiptLoyalty> getReceiptData(String userLoyaltyId);

    Observable<Boolean> removeReceiptData(String userLoyaltyId);

    Observable<Boolean> saveReceiptData(FileOcrReceiptLoyalty fileOcrReceiptLoyalty);

    Observable<SubmitReceiptResult> submitReceipt(Base64ReceiptLoyalty base64ReceiptLoyalty, String token);
}
