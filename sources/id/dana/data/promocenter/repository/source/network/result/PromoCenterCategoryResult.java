package id.dana.data.promocenter.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.promocenter.repository.source.network.model.DisplayCategory;
import java.util.List;

/* loaded from: classes4.dex */
public class PromoCenterCategoryResult extends BaseRpcResult {
    private List<DisplayCategory> listOfCategory;
    private long totalCount;

    public List<DisplayCategory> getListOfCategory() {
        return this.listOfCategory;
    }

    public void setListOfCategory(List<DisplayCategory> list) {
        this.listOfCategory = list;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long j) {
        this.totalCount = j;
    }
}
