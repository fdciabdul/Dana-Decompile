package id.dana.danapoly.ui.model;

import id.dana.data.account.repository.AccountEntityRepository;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f"}, d2 = {"Lid/dana/danapoly/ui/model/PlayerInfoModel;", "", "", "calculateDiceCount", "()Ljava/lang/String;", AccountEntityRepository.UpdateType.AVATAR, "Ljava/lang/String;", "getAvatarUrl", "", "currencyValue", "I", "getCurrencyValue", "()I", "danaPoint", "getDanaPoint", "setDanaPoint", "(I)V", "position", "getPosition", "<init>", "(IIILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayerInfoModel {
    private final String avatarUrl;
    private final int currencyValue;
    private int danaPoint;
    private final int position;

    public PlayerInfoModel(int i, int i2, int i3, String str) {
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

    @JvmName(name = "setDanaPoint")
    public final void setDanaPoint(int i) {
        this.danaPoint = i;
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

    public final String calculateDiceCount() {
        return String.valueOf(this.danaPoint / this.currencyValue);
    }
}
