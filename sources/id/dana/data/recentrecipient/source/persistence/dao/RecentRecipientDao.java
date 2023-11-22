package id.dana.data.recentrecipient.source.persistence.dao;

import id.dana.data.recentrecipient.source.persistence.entity.RecentRecipientEntity;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0010\u001a\u00020\u0007H&¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H&¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0005H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H&¢\u0006\u0004\b\u001d\u0010\u0016J%\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0002H&¢\u0006\u0004\b\u001d\u0010\u0019J\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H&¢\u0006\u0004\b\u001e\u0010\u0016J\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0017\u001a\u00020\u0005H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u0011H&¢\u0006\u0004\b \u0010\u0016J\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u0017\u001a\u00020\u0005H&¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010!\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b!\u0010\u001cJ\u0017\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\rH&¢\u0006\u0004\b#\u0010$J#\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0%2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H&¢\u0006\u0004\b#\u0010&J\u000f\u0010(\u001a\u00020'H&¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0002H&¢\u0006\u0004\b*\u0010\u0004J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0005H&¢\u0006\u0004\b+\u0010\u001cJ\u0017\u0010,\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b,\u0010\u001cø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/recentrecipient/source/persistence/dao/RecentRecipientDao;", "", "", "getFavoriteAccountCount", "()I", "", "id", "", "getGroupFavoriteValue", "(Ljava/lang/String;)Z", "", "getLastUpdatedTime", "(Ljava/lang/String;)J", "Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;", "getLeastTransactionFavoriteAccount", "()Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;", "isAsc", "", "getListRecentBankByLastUpdate", "(Z)Ljava/util/List;", "getListRecentBankByTransactionCount", "getRecentBankList", "()Ljava/util/List;", "filter", "maxRecentRecipient", "(Ljava/lang/String;I)Ljava/util/List;", WalletConstant.CARD_INDEX_NO, "getRecentBankTransactionCount", "(Ljava/lang/String;)I", "getRecentContactList", "getRecentGroupList", "(Ljava/lang/String;)Ljava/util/List;", "getRecentRecipientList", "getRecentTransactionTransactionCount", "recentRecipientEntity", "insertOrUpdate", "(Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;)J", "", "(Ljava/util/List;)[Ljava/lang/Long;", "", "removeAll", "()V", "removeAllRecentBank", "removeRecentBank", "removeRecentRecipient"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface RecentRecipientDao {
    int getFavoriteAccountCount();

    boolean getGroupFavoriteValue(String id2);

    long getLastUpdatedTime(String id2);

    RecentRecipientEntity getLeastTransactionFavoriteAccount();

    List<RecentRecipientEntity> getListRecentBankByLastUpdate(boolean isAsc);

    List<RecentRecipientEntity> getListRecentBankByTransactionCount(boolean isAsc);

    List<RecentRecipientEntity> getRecentBankList();

    List<RecentRecipientEntity> getRecentBankList(String filter, int maxRecentRecipient);

    int getRecentBankTransactionCount(String cardIndexNo);

    List<RecentRecipientEntity> getRecentContactList();

    List<RecentRecipientEntity> getRecentContactList(String filter, int maxRecentRecipient);

    List<RecentRecipientEntity> getRecentGroupList();

    List<RecentRecipientEntity> getRecentGroupList(String filter);

    List<RecentRecipientEntity> getRecentRecipientList();

    List<RecentRecipientEntity> getRecentRecipientList(String filter);

    int getRecentTransactionTransactionCount(String id2);

    long insertOrUpdate(RecentRecipientEntity recentRecipientEntity);

    Long[] insertOrUpdate(List<RecentRecipientEntity> recentRecipientEntity);

    void removeAll();

    int removeAllRecentBank();

    int removeRecentBank(String cardIndexNo);

    int removeRecentRecipient(String id2);
}
