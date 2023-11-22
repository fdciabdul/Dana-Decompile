package id.dana.domain.requestmoney;

import id.dana.domain.requestmoney.model.NameCheckConfig;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\tH&¢\u0006\u0004\b\u000f\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/requestmoney/RequestMoneyRepository;", "", "", "getLastNameCheckTimestamp", "()J", "", "getNameCheckCount", "()I", "getNameCheckExpiredTime", "Lio/reactivex/Observable;", "Lid/dana/domain/requestmoney/model/NameCheckConfig;", "getNamecheckConfig", "()Lio/reactivex/Observable;", "", "", "getTopFeaturedBanks", "timestamp", "", "setLastNameCheckTimestamp", "(J)Z", "count", "setNameCheckCount", "(I)Z", "setNameCheckExpiredTime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface RequestMoneyRepository {
    long getLastNameCheckTimestamp();

    int getNameCheckCount();

    long getNameCheckExpiredTime();

    Observable<NameCheckConfig> getNamecheckConfig();

    Observable<List<String>> getTopFeaturedBanks();

    boolean setLastNameCheckTimestamp(long timestamp);

    boolean setNameCheckCount(int count);

    boolean setNameCheckExpiredTime(long timestamp);
}
