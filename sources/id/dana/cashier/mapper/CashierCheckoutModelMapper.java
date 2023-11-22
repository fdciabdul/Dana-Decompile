package id.dana.cashier.mapper;

import id.dana.cashier.domain.model.CashierPay;
import id.dana.cashier.domain.model.ConfigCashierInfo;
import id.dana.cashier.model.AttributeModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.ConfigCheckoutModelKt;
import id.dana.cashier.model.PaylaterCicilCheckoutModel;
import id.dana.data.base.BaseMapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/mapper/CashierCheckoutModelMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/cashier/domain/model/CashierPay;", "Lid/dana/cashier/model/CashierCheckoutModel;", "Lid/dana/cashier/mapper/AttributeModelMapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/mapper/AttributeModelMapper;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/cashier/mapper/AttributeModelMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierCheckoutModelMapper extends BaseMapper<CashierPay, CashierCheckoutModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final AttributeModelMapper BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ CashierCheckoutModel map(CashierPay cashierPay) {
        CashierPay cashierPay2 = cashierPay;
        if (cashierPay2 != null) {
            AttributeModel apply = this.BuiltInFictitiousFunctionClassFactory.apply(cashierPay2.getAttributes());
            String cashierOrderId = cashierPay2.getCashierOrderId();
            ConfigCashierInfo config = cashierPay2.getConfig();
            CashierCheckoutModel cashierCheckoutModel = new CashierCheckoutModel(apply, cashierOrderId, config != null ? ConfigCheckoutModelKt.MyBillsEntityDataFactory(config) : null, null, cashierPay2.getDanaPlusMethodConfig(), 8, null);
            PaylaterCicilCheckoutModel paylaterCicilCheckoutModel = cashierCheckoutModel.MyBillsEntityDataFactory;
            String paylaterCicilMid = cashierPay2.getPaylaterCicilMid();
            Intrinsics.checkNotNullParameter(paylaterCicilMid, "");
            paylaterCicilCheckoutModel.MyBillsEntityDataFactory = paylaterCicilMid;
            return cashierCheckoutModel;
        }
        return null;
    }

    @Inject
    public CashierCheckoutModelMapper(AttributeModelMapper attributeModelMapper) {
        Intrinsics.checkNotNullParameter(attributeModelMapper, "");
        this.BuiltInFictitiousFunctionClassFactory = attributeModelMapper;
    }
}
