package id.dana.domain.account;

import android.content.Context;
import id.dana.domain.account.model.Transaction;
import io.reactivex.Observable;
import java.io.File;

/* loaded from: classes2.dex */
public interface AccountRepository {
    Observable<Boolean> finishFirstTime();

    Observable<Account> getAccount();

    Observable<String> getAvatarUrl();

    Observable<Boolean> getBalanceVisibility();

    Observable<Account> getDrutherDataForUpdate(Context context);

    Observable<Boolean> getEmasBalanceVisibility();

    Observable<Boolean> getGoalsBalanceVisibility();

    Observable<Boolean> getInvestmentBalanceVisibility();

    Observable<String> getKycLevel();

    Observable<Transaction> getLastTransaction();

    Observable<String> getNickname();

    Observable<String> getPhoneNumber();

    Observable<String> getUUID();

    Observable<String> getUserId();

    Observable<Boolean> hasAccount();

    Observable<Boolean> isFirstTime();

    Observable<Boolean> saveLastTransaction(Transaction transaction);

    Observable<String> saveNickname(String str);

    Observable<Boolean> setBalanceVisibility(Boolean bool, String str);

    Observable<String> uploadAvatar(File file);
}
