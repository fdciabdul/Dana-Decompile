package id.dana.sendmoney.data.config.core.mapper;

import id.dana.sendmoney.data.config.core.model.SendMoneyApiMigrationConfigEntity;
import id.dana.sendmoney.domain.core.model.config.SendMoneyApiMigrationConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/data/config/core/model/SendMoneyApiMigrationConfigEntity;", "Lid/dana/sendmoney/domain/core/model/config/SendMoneyApiMigrationConfig;", "toSendMoneyApiMigrationConfig", "(Lid/dana/sendmoney/data/config/core/model/SendMoneyApiMigrationConfigEntity;)Lid/dana/sendmoney/domain/core/model/config/SendMoneyApiMigrationConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyApiMigrationEntityMapperKt {
    public static final SendMoneyApiMigrationConfig toSendMoneyApiMigrationConfig(SendMoneyApiMigrationConfigEntity sendMoneyApiMigrationConfigEntity) {
        Intrinsics.checkNotNullParameter(sendMoneyApiMigrationConfigEntity, "");
        Boolean sendMoneyPhone = sendMoneyApiMigrationConfigEntity.getSendMoneyPhone();
        return new SendMoneyApiMigrationConfig(sendMoneyPhone != null ? sendMoneyPhone.booleanValue() : false);
    }
}
