package id.dana.data.requestmoney.repository.source.local;

import id.dana.data.requestmoney.repository.RequestMoneyPreferenceEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/data/requestmoney/repository/source/local/PreferenceRequestMoneyEntityData;", "Lid/dana/data/requestmoney/repository/RequestMoneyPreferenceEntityData;", "", "getLastNameCheckTimestamp", "()J", "", "getNameCheckCount", "()I", "getNameCheckExpiredTime", "timestamp", "", "setLastNameCheckTimestamp", "(J)Z", "count", "setNameCheckCount", "(I)Z", "setNameCheckExpiredTime", "Lid/dana/data/requestmoney/repository/source/local/RequestMoneyPreference;", "requestMoneyPreference", "Lid/dana/data/requestmoney/repository/source/local/RequestMoneyPreference;", "<init>", "(Lid/dana/data/requestmoney/repository/source/local/RequestMoneyPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PreferenceRequestMoneyEntityData implements RequestMoneyPreferenceEntityData {
    private final RequestMoneyPreference requestMoneyPreference;

    @Inject
    public PreferenceRequestMoneyEntityData(RequestMoneyPreference requestMoneyPreference) {
        Intrinsics.checkNotNullParameter(requestMoneyPreference, "");
        this.requestMoneyPreference = requestMoneyPreference;
    }

    @Override // id.dana.data.requestmoney.repository.RequestMoneyPreferenceEntityData
    public final boolean setNameCheckCount(int count) {
        return this.requestMoneyPreference.setNameCheckCount(count);
    }

    @Override // id.dana.data.requestmoney.repository.RequestMoneyPreferenceEntityData
    public final int getNameCheckCount() {
        Integer nameCheckCount = this.requestMoneyPreference.getNameCheckCount();
        Intrinsics.checkNotNullExpressionValue(nameCheckCount, "");
        return nameCheckCount.intValue();
    }

    @Override // id.dana.data.requestmoney.repository.RequestMoneyPreferenceEntityData
    public final boolean setNameCheckExpiredTime(long timestamp) {
        return this.requestMoneyPreference.setNameCheckExpiredTime(timestamp);
    }

    @Override // id.dana.data.requestmoney.repository.RequestMoneyPreferenceEntityData
    public final long getNameCheckExpiredTime() {
        Long nameCheckExpiredTime = this.requestMoneyPreference.getNameCheckExpiredTime();
        Intrinsics.checkNotNullExpressionValue(nameCheckExpiredTime, "");
        return nameCheckExpiredTime.longValue();
    }

    @Override // id.dana.data.requestmoney.repository.RequestMoneyPreferenceEntityData
    public final boolean setLastNameCheckTimestamp(long timestamp) {
        return this.requestMoneyPreference.setLastNameCheckTimestamp(timestamp);
    }

    @Override // id.dana.data.requestmoney.repository.RequestMoneyPreferenceEntityData
    public final long getLastNameCheckTimestamp() {
        Long lastNameCheckTimestamp = this.requestMoneyPreference.getLastNameCheckTimestamp();
        Intrinsics.checkNotNullExpressionValue(lastNameCheckTimestamp, "");
        return lastNameCheckTimestamp.longValue();
    }
}
