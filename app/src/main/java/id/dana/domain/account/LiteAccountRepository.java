package id.dana.domain.account;

import io.reactivex.Observable;
import j$.util.Optional;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\t\u0010\u0006J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0002H&¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H&¢\u0006\u0004\b\f\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/account/LiteAccountRepository;", "", "Lio/reactivex/Observable;", "Lj$/util/Optional;", "", "initSecurePreferenceAccount", "()Lio/reactivex/Observable;", "phoneNumber", "", "hasAccount", "getUserId", "Lid/dana/domain/account/Account;", "getAccount"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public interface LiteAccountRepository {
    Observable<Account> getAccount();

    Observable<String> getUserId();

    Observable<Boolean> hasAccount();

    Observable<Optional<String>> initSecurePreferenceAccount();

    Observable<String> phoneNumber();
}
