package id.dana.data.recentrecipient.source;

import id.dana.data.recentbank.repository.source.persistance.entity.SecureRecentBankEntity;
import id.dana.data.recentrecipient.source.persistence.entity.RecentRecipientEntity;
import id.dana.wallet_v3.constant.WalletConstant;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\t\u001a\u00020\nH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005H&J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0005H&J&\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00052\b\b\u0002\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0006H&J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0015\u001a\u00020\nH&J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00100\u0005H&J\u001e\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00100\u00052\b\b\u0002\u0010\u0012\u001a\u00020\nH&J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00100\u0005H&J\u001e\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00100\u00052\b\b\u0002\u0010\u0012\u001a\u00020\nH&J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\nH&J&\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0011H&J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001a\u001a\u00020\u0011H&J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001d\u001a\u00020\u000eH&J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u001f\u001a\u00020\u000eH&J\"\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0 0\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006!À\u0006\u0001"}, d2 = {"Lid/dana/data/recentrecipient/source/RecentRecipientEntityData;", "", "clearAll", "", "getFavoriteAccountCount", "Lio/reactivex/Observable;", "", "getGroupFavoriteValue", "", "id", "", "getLastUpdatedTime", "", "getLeastTransactionFavoriteAccount", "Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;", "getRecentBank", "", "Lid/dana/data/recentbank/repository/source/persistance/entity/SecureRecentBankEntity;", "filter", "maxItem", "getRecentBankTransactionCount", WalletConstant.CARD_INDEX_NO, "getRecentGroup", "getRecentRecipient", "getRecentRecipientTransactionCount", "removeAllRecentBank", "bankEntity", "removeRecentBank", "removeRecentRecipient", "recentRecipient", "saveRecentRecipient", "recentRecipientEntity", "", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface RecentRecipientEntityData {
    void clearAll();

    Observable<Integer> getFavoriteAccountCount();

    Observable<Boolean> getGroupFavoriteValue(String id2);

    Observable<Long> getLastUpdatedTime(String id2);

    Observable<RecentRecipientEntity> getLeastTransactionFavoriteAccount();

    Observable<List<SecureRecentBankEntity>> getRecentBank();

    Observable<List<SecureRecentBankEntity>> getRecentBank(String filter, int maxItem);

    Observable<Integer> getRecentBankTransactionCount(String cardIndexNo);

    Observable<List<RecentRecipientEntity>> getRecentGroup();

    Observable<List<RecentRecipientEntity>> getRecentGroup(String filter);

    Observable<List<RecentRecipientEntity>> getRecentRecipient();

    Observable<List<RecentRecipientEntity>> getRecentRecipient(String filter);

    Observable<Integer> getRecentRecipientTransactionCount(String id2);

    Observable<Integer> removeAllRecentBank(String filter, int maxItem, SecureRecentBankEntity bankEntity);

    Observable<Integer> removeRecentBank(SecureRecentBankEntity bankEntity);

    Observable<Integer> removeRecentRecipient(RecentRecipientEntity recentRecipient);

    Observable<Long> saveRecentRecipient(RecentRecipientEntity recentRecipientEntity);

    Observable<Long[]> saveRecentRecipient(List<RecentRecipientEntity> recentRecipientEntity);

    /* renamed from: id.dana.data.recentrecipient.source.RecentRecipientEntityData$-CC  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable getRecentRecipient$default(RecentRecipientEntityData recentRecipientEntityData, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = "";
                }
                return recentRecipientEntityData.getRecentRecipient(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRecentRecipient");
        }

        public static /* synthetic */ Observable getRecentBank$default(RecentRecipientEntityData recentRecipientEntityData, String str, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = "";
                }
                return recentRecipientEntityData.getRecentBank(str, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRecentBank");
        }

        public static /* synthetic */ Observable getRecentGroup$default(RecentRecipientEntityData recentRecipientEntityData, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = "";
                }
                return recentRecipientEntityData.getRecentGroup(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRecentGroup");
        }
    }
}
