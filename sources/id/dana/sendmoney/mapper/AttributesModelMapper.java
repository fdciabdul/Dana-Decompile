package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.model.cashier.Attributes;
import id.dana.sendmoney.model.AttributesModel;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class AttributesModelMapper extends BaseMapper<Attributes, AttributesModel> {
    private final PayMethodRiskMapper BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ AttributesModel map(Attributes attributes) {
        Attributes attributes2 = attributes;
        if (attributes2 != null) {
            AttributesModel attributesModel = new AttributesModel();
            attributesModel.MyBillsEntityDataFactory = attributes2.isLoginStatus();
            attributesModel.PlaceComponentResult = attributes2.getMaskedLoginId();
            attributesModel.BuiltInFictitiousFunctionClassFactory = PayMethodRiskMapper.KClassImpl$Data$declaredNonStaticMembers$2(attributes2.getPayMethodRiskResponse());
            return attributesModel;
        }
        return null;
    }

    @Inject
    public AttributesModelMapper(PayMethodRiskMapper payMethodRiskMapper) {
        this.BuiltInFictitiousFunctionClassFactory = payMethodRiskMapper;
    }
}
