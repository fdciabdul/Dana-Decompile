package id.dana.data.promocenter.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.promocenter.repository.source.network.model.DisplayPromoResponse;
import java.util.List;

/* loaded from: classes4.dex */
public class PromoCenterFetchResult extends BaseRpcResult {
    private boolean hasMore;
    private List<DisplayPromoResponse> listOfPromo;

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    public List<DisplayPromoResponse> getListOfPromo() {
        return this.listOfPromo;
    }

    public void setListOfPromo(List<DisplayPromoResponse> list) {
        this.listOfPromo = list;
    }
}
