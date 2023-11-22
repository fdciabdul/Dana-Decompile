package id.dana.data.payasset.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;

/* loaded from: classes4.dex */
public class QueryPayMethodResult extends BaseRpcResult {
    public String countryCode;
    public String defaultOption;
    public Long lastUpdate;
    public List<PayMethodViewDTO> payMethodViewDTOS;
    public List<PayCardOptionViewDTO> standardCardOptionViews;
}
