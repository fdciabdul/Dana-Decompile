package id.dana.data.config.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.config.source.amcs.result.ExpiryInfoResult;
import id.dana.domain.featureconfig.model.ExpiryInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ExpiryInfoResultMapper extends BaseMapper<List<ExpiryInfoResult>, List<ExpiryInfo>> {
    @Inject
    public ExpiryInfoResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public List<ExpiryInfo> map(List<ExpiryInfoResult> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<ExpiryInfoResult> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(transfrom(it.next()));
        }
        return arrayList;
    }

    private ExpiryInfo transfrom(ExpiryInfoResult expiryInfoResult) {
        if (expiryInfoResult != null) {
            ExpiryInfo expiryInfo = new ExpiryInfo();
            expiryInfo.setExpiryNumber(expiryInfoResult.getExpiryNumber());
            expiryInfo.setExpiryUnit(expiryInfoResult.getExpiryUnit());
            expiryInfo.setExpiryDefault(expiryInfoResult.isExpiryDefault());
            return expiryInfo;
        }
        return null;
    }
}
