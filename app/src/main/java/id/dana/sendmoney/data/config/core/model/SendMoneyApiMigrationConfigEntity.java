package id.dana.sendmoney.data.config.core.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/data/config/core/model/SendMoneyApiMigrationConfigEntity;", "", "", "sendMoneyPhone", "Ljava/lang/Boolean;", "getSendMoneyPhone", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyApiMigrationConfigEntity {
    @SerializedName("send_money_phone")
    private final Boolean sendMoneyPhone;

    public SendMoneyApiMigrationConfigEntity(Boolean bool) {
        this.sendMoneyPhone = bool;
    }

    @JvmName(name = "getSendMoneyPhone")
    public final Boolean getSendMoneyPhone() {
        return this.sendMoneyPhone;
    }
}
