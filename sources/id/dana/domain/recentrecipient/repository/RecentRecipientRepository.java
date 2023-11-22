package id.dana.domain.recentrecipient.repository;

import id.dana.domain.recentbank.model.RecentBank;
import id.dana.domain.recentrecipient.model.RecentBankRecipient;
import id.dana.domain.recentrecipient.model.RecentContactRecipient;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface RecentRecipientRepository {
    Observable<RecentRecipient> convertCardIndexNo(RecentRecipient recentRecipient);

    Observable<Integer> getFavoriteAccountCount();

    Observable<Boolean> getGroupFavoriteValue(String str);

    Observable<Boolean> getIsRecentRecipientMigratedToRoom();

    Observable<RecentRecipient> getLeastTransactionFavoriteAccount();

    Observable<Integer> getMaxFavoriteAccount();

    Observable<Integer> getMaxRecentRecipient();

    Observable<Integer> getMaxSavedBank();

    Observable<List<RecentBank>> getRecentBank(String str);

    Observable<List<RecentRecipient>> getRecentContact();

    Observable<List<RecentRecipient>> getRecentGroup(String str);

    Observable<List<RecentRecipient>> getRecentRecipient(int i, int i2, int i3);

    Observable<List<RecentRecipient>> getRecentRecipientAll();

    Observable<List<RecentRecipient>> getRecentTransaction(String str);

    Observable<List<RecentRecipient>> getSecureRecentRecipient(int i, int i2, int i3);

    Observable<Boolean> migrateRecentRecipientConfigToRoom();

    Observable<Boolean> removeRecentBank(RecentBankRecipient recentBankRecipient);

    Observable<Boolean> removeRecentContact(RecentContactRecipient recentContactRecipient);

    Observable<Boolean> removeRecentRecipient(RecentRecipient recentRecipient);

    Observable<Boolean> saveRecentBank(RecentBankRecipient recentBankRecipient, boolean z);

    Observable<Boolean> saveRecentContact(RecentContactRecipient recentContactRecipient, boolean z);

    Observable<Boolean> saveRecentGroup(RecentRecipient recentRecipient, boolean z);

    Observable<Boolean> storeLocalSecureUserConfig(List<RecentRecipient> list);

    Observable<Boolean> storeSecureUserConfig(List<RecentRecipient> list);

    Observable<Boolean> storeUserConfig(List<RecentRecipient> list);
}
