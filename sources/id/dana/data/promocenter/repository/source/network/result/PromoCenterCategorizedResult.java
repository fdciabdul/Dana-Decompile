package id.dana.data.promocenter.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.promocenter.repository.source.network.model.CategorizedPromo;
import java.util.List;

/* loaded from: classes4.dex */
public class PromoCenterCategorizedResult extends BaseRpcResult {
    List<CategorizedPromo> listOfCategorizedPromo;

    public List<CategorizedPromo> getListOfCategorizedPromo() {
        return this.listOfCategorizedPromo;
    }

    public void setListOfCategorizedPromo(List<CategorizedPromo> list) {
        this.listOfCategorizedPromo = list;
    }
}
