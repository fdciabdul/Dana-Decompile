package id.dana.sendmoney.data.repository.core.source.split;

import id.dana.sendmoney.data.config.core.model.SendMoneyApiMigrationConfigEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/data/repository/core/source/split/SendMoneyCoreDefaultConfigGenerator;", "", "Lid/dana/sendmoney/data/config/core/model/SendMoneyApiMigrationConfigEntity;", "MyBillsEntityDataFactory", "()Lid/dana/sendmoney/data/config/core/model/SendMoneyApiMigrationConfigEntity;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyCoreDefaultConfigGenerator {
    public static final SendMoneyCoreDefaultConfigGenerator INSTANCE = new SendMoneyCoreDefaultConfigGenerator();

    private SendMoneyCoreDefaultConfigGenerator() {
    }

    public static SendMoneyApiMigrationConfigEntity MyBillsEntityDataFactory() {
        return new SendMoneyApiMigrationConfigEntity(Boolean.FALSE);
    }
}
