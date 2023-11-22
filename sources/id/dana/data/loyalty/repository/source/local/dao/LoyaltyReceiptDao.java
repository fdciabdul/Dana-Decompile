package id.dana.data.loyalty.repository.source.local.dao;

import id.dana.data.loyalty.repository.source.local.entity.LoyaltyReceiptEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/loyalty/repository/source/local/dao/LoyaltyReceiptDao;", "", "", "userLoyaltyId", "", "deleteReceipt", "(Ljava/lang/String;)I", "Lid/dana/data/loyalty/repository/source/local/entity/LoyaltyReceiptEntity;", "getReceiptByUserLoyaltyId", "(Ljava/lang/String;)Lid/dana/data/loyalty/repository/source/local/entity/LoyaltyReceiptEntity;", "loyaltyReceiptEntity", "", "insertReceipt", "(Lid/dana/data/loyalty/repository/source/local/entity/LoyaltyReceiptEntity;)J"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface LoyaltyReceiptDao {
    int deleteReceipt(String userLoyaltyId);

    LoyaltyReceiptEntity getReceiptByUserLoyaltyId(String userLoyaltyId);

    long insertReceipt(LoyaltyReceiptEntity loyaltyReceiptEntity);
}
