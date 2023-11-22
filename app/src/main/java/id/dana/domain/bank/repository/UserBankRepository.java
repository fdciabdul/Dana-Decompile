package id.dana.domain.bank.repository;

import id.dana.domain.bank.model.RequestMoneyInit;
import id.dana.domain.bank.model.UserBank;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0007J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H&¢\u0006\u0004\b\u000e\u0010\u000bJ#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/bank/repository/UserBankRepository;", "", "Lid/dana/domain/bank/model/UserBank;", "userBank", "Lio/reactivex/Observable;", "", "addUserBank", "(Lid/dana/domain/bank/model/UserBank;)Lio/reactivex/Observable;", "deleteUserBank", "", "getUserBanks", "()Lio/reactivex/Observable;", "hasUserBank", "Lid/dana/domain/bank/model/RequestMoneyInit;", "initRequestMoney", "userBanks", "saveUserBanks", "(Ljava/util/List;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface UserBankRepository {
    Observable<Boolean> addUserBank(UserBank userBank);

    Observable<Boolean> deleteUserBank(UserBank userBank);

    Observable<List<UserBank>> getUserBanks();

    Observable<Boolean> hasUserBank(UserBank userBank);

    Observable<RequestMoneyInit> initRequestMoney();

    Observable<Boolean> saveUserBanks(List<UserBank> userBanks);
}
