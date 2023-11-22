package id.dana.sendmoney.data.repository.core.source.split;

import id.dana.data.toggle.SplitFacade;
import id.dana.sendmoney.data.config.core.model.SendMoneyApiMigrationConfigEntity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/sendmoney/data/repository/core/source/split/SplitSendMoneyCoreEntityDataImpl;", "Lid/dana/sendmoney/data/repository/core/source/split/SplitSendMoneyCoreEntityData;", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/data/config/core/model/SendMoneyApiMigrationConfigEntity;", "PlaceComponentResult", "()Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/toggle/SplitFacade;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/toggle/SplitFacade;", "p0", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitSendMoneyCoreEntityDataImpl implements SplitSendMoneyCoreEntityData {
    private final SplitFacade BuiltInFictitiousFunctionClassFactory;

    @Inject
    public SplitSendMoneyCoreEntityDataImpl(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.BuiltInFictitiousFunctionClassFactory = splitFacade;
    }

    @Override // id.dana.sendmoney.data.repository.core.source.split.SplitSendMoneyCoreEntityData
    public final Flow<SendMoneyApiMigrationConfigEntity> PlaceComponentResult() {
        return FlowKt.flow(new SplitSendMoneyCoreEntityDataImpl$getSendMoneyApiMigrationConfig$1(this, null));
    }
}
