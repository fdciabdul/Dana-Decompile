package id.dana.sendmoney.domain.core;

import id.dana.sendmoney.domain.core.model.config.SendMoneyApiMigrationConfig;
import id.dana.sendmoney.domain.core.model.init.TransferInitRequest;
import id.dana.sendmoney.domain.core.model.init.TransferInitResult;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/domain/core/SendMoneyCoreRepository;", "", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/core/model/config/SendMoneyApiMigrationConfig;", "PlaceComponentResult", "()Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/core/model/init/TransferInitRequest;", "p0", "Lid/dana/sendmoney/domain/core/model/init/TransferInitResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/domain/core/model/init/TransferInitRequest;)Lkotlinx/coroutines/flow/Flow;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface SendMoneyCoreRepository {
    Flow<TransferInitResult> BuiltInFictitiousFunctionClassFactory(TransferInitRequest p0);

    Flow<SendMoneyApiMigrationConfig> PlaceComponentResult();
}
