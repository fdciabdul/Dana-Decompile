package id.dana.data.requestmoney.repository;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/requestmoney/repository/RequestMoneyPreferenceEntityData;", "", "", "getLastNameCheckTimestamp", "()J", "", "getNameCheckCount", "()I", "getNameCheckExpiredTime", "timestamp", "", "setLastNameCheckTimestamp", "(J)Z", "count", "setNameCheckCount", "(I)Z", "setNameCheckExpiredTime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface RequestMoneyPreferenceEntityData {
    long getLastNameCheckTimestamp();

    int getNameCheckCount();

    long getNameCheckExpiredTime();

    boolean setLastNameCheckTimestamp(long timestamp);

    boolean setNameCheckCount(int count);

    boolean setNameCheckExpiredTime(long timestamp);
}
