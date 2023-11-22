package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.featureconfig.model.ExpiryInfo;
import id.dana.sendmoney.model.ExpiryInfoModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ExpiryInfoMapper extends BaseMapper<List<ExpiryInfo>, List<ExpiryInfoModel>> {
    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ List<ExpiryInfoModel> map(List<ExpiryInfo> list) {
        ExpiryInfoModel expiryInfoModel;
        ArrayList arrayList = new ArrayList();
        for (ExpiryInfo expiryInfo : list) {
            if (expiryInfo != null) {
                expiryInfoModel = new ExpiryInfoModel();
                expiryInfoModel.MyBillsEntityDataFactory(expiryInfo.getExpiryNumber());
                expiryInfoModel.BuiltInFictitiousFunctionClassFactory(expiryInfo.getExpiryUnit());
                expiryInfoModel.BuiltInFictitiousFunctionClassFactory(expiryInfo.isExpiryDefault());
            } else {
                expiryInfoModel = null;
            }
            arrayList.add(expiryInfoModel);
        }
        return arrayList;
    }

    @Inject
    public ExpiryInfoMapper() {
    }
}
