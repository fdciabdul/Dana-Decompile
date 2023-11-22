package id.dana.data.qrbarcode.repository.source.network.result;

import id.dana.data.BaseMapper;
import id.dana.domain.qrbarcode.QrUserBankResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/data/qrbarcode/repository/source/network/result/UserBankQrResult;", "Lid/dana/data/qrbarcode/repository/source/network/result/GenerateQrResult;", "", "component1", "()Ljava/lang/Long;", "component2", "expireTimeInSecond", "expireDateTimestamp", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lid/dana/data/qrbarcode/repository/source/network/result/UserBankQrResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Long;", "getExpireDateTimestamp", "getExpireTimeInSecond", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserBankQrResult extends GenerateQrResult {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long expireDateTimestamp;
    private final Long expireTimeInSecond;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Long, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UserBankQrResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrbarcode.repository.source.network.result.UserBankQrResult.<init>():void");
    }

    public static /* synthetic */ UserBankQrResult copy$default(UserBankQrResult userBankQrResult, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = userBankQrResult.expireTimeInSecond;
        }
        if ((i & 2) != 0) {
            l2 = userBankQrResult.expireDateTimestamp;
        }
        return userBankQrResult.copy(l, l2);
    }

    @JvmStatic
    public static final QrUserBankResult toQrUserBankResult(UserBankQrResult userBankQrResult) {
        return INSTANCE.toQrUserBankResult(userBankQrResult);
    }

    /* renamed from: component1  reason: from getter */
    public final Long getExpireTimeInSecond() {
        return this.expireTimeInSecond;
    }

    /* renamed from: component2  reason: from getter */
    public final Long getExpireDateTimestamp() {
        return this.expireDateTimestamp;
    }

    public final UserBankQrResult copy(Long expireTimeInSecond, Long expireDateTimestamp) {
        return new UserBankQrResult(expireTimeInSecond, expireDateTimestamp);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserBankQrResult) {
            UserBankQrResult userBankQrResult = (UserBankQrResult) other;
            return Intrinsics.areEqual(this.expireTimeInSecond, userBankQrResult.expireTimeInSecond) && Intrinsics.areEqual(this.expireDateTimestamp, userBankQrResult.expireDateTimestamp);
        }
        return false;
    }

    public final int hashCode() {
        Long l = this.expireTimeInSecond;
        int hashCode = l == null ? 0 : l.hashCode();
        Long l2 = this.expireDateTimestamp;
        return (hashCode * 31) + (l2 != null ? l2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserBankQrResult(expireTimeInSecond=");
        sb.append(this.expireTimeInSecond);
        sb.append(", expireDateTimestamp=");
        sb.append(this.expireDateTimestamp);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ UserBankQrResult(Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : l, (i & 2) != 0 ? 0L : l2);
    }

    @JvmName(name = "getExpireTimeInSecond")
    public final Long getExpireTimeInSecond() {
        return this.expireTimeInSecond;
    }

    @JvmName(name = "getExpireDateTimestamp")
    public final Long getExpireDateTimestamp() {
        return this.expireDateTimestamp;
    }

    public UserBankQrResult(Long l, Long l2) {
        this.expireTimeInSecond = l;
        this.expireDateTimestamp = l2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/qrbarcode/repository/source/network/result/UserBankQrResult$Companion;", "", "Lid/dana/data/qrbarcode/repository/source/network/result/UserBankQrResult;", "Lid/dana/domain/qrbarcode/QrUserBankResult;", "toQrUserBankResult", "(Lid/dana/data/qrbarcode/repository/source/network/result/UserBankQrResult;)Lid/dana/domain/qrbarcode/QrUserBankResult;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final QrUserBankResult toQrUserBankResult(UserBankQrResult userBankQrResult) {
            Intrinsics.checkNotNullParameter(userBankQrResult, "");
            Long expireTimeInSecond = userBankQrResult.getExpireTimeInSecond();
            long longValue = expireTimeInSecond != null ? expireTimeInSecond.longValue() : 0L;
            Long expireDateTimestamp = userBankQrResult.getExpireDateTimestamp();
            QrUserBankResult qrUserBankResult = new QrUserBankResult(longValue, expireDateTimestamp != null ? expireDateTimestamp.longValue() : 0L);
            BaseMapper.transform(qrUserBankResult, userBankQrResult);
            String str = userBankQrResult.qrCode;
            qrUserBankResult.setQrCode(str != null ? str : "");
            return qrUserBankResult;
        }
    }
}
