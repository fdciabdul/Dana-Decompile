package id.dana.danapoly.domain.config.model;

import id.dana.data.account.repository.AccountEntityRepository;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b"}, d2 = {"Lid/dana/danapoly/domain/config/model/PlayerInfo;", "", "", AccountEntityRepository.UpdateType.AVATAR, "Ljava/lang/String;", "getAvatarUrl", "()Ljava/lang/String;", "", "currencyValue", "I", "getCurrencyValue", "()I", "danaPoint", "getDanaPoint", "position", "getPosition", "<init>", "(IIILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayerInfo {
    private final String avatarUrl;
    private final int currencyValue;
    private final int danaPoint;
    private final int position;

    public PlayerInfo(int i, int i2, int i3, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.danaPoint = i;
        this.position = i2;
        this.currencyValue = i3;
        this.avatarUrl = str;
    }

    @JvmName(name = "getDanaPoint")
    public final int getDanaPoint() {
        return this.danaPoint;
    }

    @JvmName(name = "getPosition")
    public final int getPosition() {
        return this.position;
    }

    @JvmName(name = "getCurrencyValue")
    public final int getCurrencyValue() {
        return this.currencyValue;
    }

    @JvmName(name = "getAvatarUrl")
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }
}
