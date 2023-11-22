package id.dana.cashier.mapper;

import id.dana.cashier.domain.model.TopUpPay;
import id.dana.cashier.model.TopUpPayModel;
import id.dana.data.base.BaseMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/mapper/TopUpPayModelMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/cashier/domain/model/TopUpPay;", "Lid/dana/cashier/model/TopUpPayModel;", "Lid/dana/cashier/mapper/AttributeModelMapper;", "MyBillsEntityDataFactory", "Lid/dana/cashier/mapper/AttributeModelMapper;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/cashier/mapper/AttributeModelMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopUpPayModelMapper extends BaseMapper<TopUpPay, TopUpPayModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final AttributeModelMapper BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ TopUpPayModel map(TopUpPay topUpPay) {
        TopUpPay topUpPay2 = topUpPay;
        if (topUpPay2 != null) {
            return new TopUpPayModel(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(topUpPay2.getAttributes()), topUpPay2.getCashierOrderId(), topUpPay2.getCashierRequestId(), topUpPay2.getSecurityId(), topUpPay2.getInnerCardIndexNo(), topUpPay2.getTopUpOrderId(), topUpPay2.getErrorCode(), topUpPay2.getErrorMessage(), topUpPay2.getSuccess());
        }
        return null;
    }

    @Inject
    public TopUpPayModelMapper(AttributeModelMapper attributeModelMapper) {
        Intrinsics.checkNotNullParameter(attributeModelMapper, "");
        this.BuiltInFictitiousFunctionClassFactory = attributeModelMapper;
    }
}
