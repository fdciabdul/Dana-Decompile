package id.dana.domain.paylater;

import id.dana.domain.paylater.model.LoanStatusWhitelist;
import id.dana.domain.paylater.model.LoanWhitelist;
import id.dana.domain.paylater.model.PaylaterCicilMethodConfig;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\n\u0010\u0005J\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0002H&¢\u0006\u0004\b\r\u0010\u0005J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002H&¢\u0006\u0004\b\u000f\u0010\u0005J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002H&¢\u0006\u0004\b\u0011\u0010\u0005J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0012\u0010\u0005J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0013\u001a\u00020\u0007H&¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0019\u001a\u00020\u0010H&¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH&¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010!\u001a\u00020\u001cH&¢\u0006\u0004\b\"\u0010#ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/paylater/PaylaterRepository;", "", "Lio/reactivex/Observable;", "", "clearCachePayLaterLoanWhitelist", "()Lio/reactivex/Observable;", "withBill", "Lid/dana/domain/paylater/model/LoanWhitelist;", "getLoanConsultWhitelist", "(Z)Lio/reactivex/Observable;", "getPayLaterCacheWhitelistValue", "", "Lid/dana/domain/paylater/model/LoanStatusWhitelist;", "getPayLaterLoanStatus", "Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "getPaylaterCicilConfig", "", "getPaylaterRotationDelayTime", "resetPayLaterCacheLoanWhitelist", "loanWhitelist", "savePayLaterCacheWhitelistValue", "(Lid/dana/domain/paylater/model/LoanWhitelist;)Lio/reactivex/Observable;", "loanStatus", "savePayLaterLoanStatus", "(Ljava/util/List;)Lio/reactivex/Observable;", "rotationDelayTime", "savePaylaterRotationDelayTime", "(J)Lio/reactivex/Observable;", "", "type", "state", "setLoanServicesState", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "paylaterChannel", "setPaylaterChannel", "(Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PaylaterRepository {
    Observable<Boolean> clearCachePayLaterLoanWhitelist();

    Observable<LoanWhitelist> getLoanConsultWhitelist(boolean withBill);

    Observable<LoanWhitelist> getPayLaterCacheWhitelistValue();

    Observable<List<LoanStatusWhitelist>> getPayLaterLoanStatus();

    Observable<PaylaterCicilMethodConfig> getPaylaterCicilConfig();

    Observable<Long> getPaylaterRotationDelayTime();

    Observable<Boolean> resetPayLaterCacheLoanWhitelist();

    Observable<Boolean> savePayLaterCacheWhitelistValue(LoanWhitelist loanWhitelist);

    Observable<Boolean> savePayLaterLoanStatus(List<LoanStatusWhitelist> loanStatus);

    Observable<Boolean> savePaylaterRotationDelayTime(long rotationDelayTime);

    Observable<Boolean> setLoanServicesState(String type, String state);

    Observable<Boolean> setPaylaterChannel(String paylaterChannel);
}
