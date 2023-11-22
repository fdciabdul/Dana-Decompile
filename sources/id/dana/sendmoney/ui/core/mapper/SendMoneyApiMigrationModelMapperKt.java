package id.dana.sendmoney.ui.core.mapper;

import id.dana.sendmoney.domain.core.model.config.SendMoneyApiMigrationConfig;
import id.dana.sendmoney.ui.core.model.SendMoneyApiMigrationConfigModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/domain/core/model/config/SendMoneyApiMigrationConfig;", "Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;", "PlaceComponentResult", "(Lid/dana/sendmoney/domain/core/model/config/SendMoneyApiMigrationConfig;)Lid/dana/sendmoney/ui/core/model/SendMoneyApiMigrationConfigModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyApiMigrationModelMapperKt {
    public static final SendMoneyApiMigrationConfigModel PlaceComponentResult(SendMoneyApiMigrationConfig sendMoneyApiMigrationConfig) {
        Intrinsics.checkNotNullParameter(sendMoneyApiMigrationConfig, "");
        return new SendMoneyApiMigrationConfigModel(sendMoneyApiMigrationConfig.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
