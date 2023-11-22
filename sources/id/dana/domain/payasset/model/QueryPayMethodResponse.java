package id.dana.domain.payasset.model;

import id.dana.utils.rpc.response.BaseRpcResponse;
import java.util.List;

/* loaded from: classes2.dex */
public class QueryPayMethodResponse extends BaseRpcResponse {
    private String countryCode;
    private String defaultOption;
    private List<PayMethodView> payMethodViews;
    private List<PayCardOptionView> standardCardOptionViews;

    public int hashCode() {
        int hashCode = getDefaultOption() != null ? getDefaultOption().hashCode() : 0;
        return (((hashCode * 31) + (getPayMethodViews() != null ? getPayMethodViews().hashCode() : 0)) * 31) + (getStandardCardOptionViews() != null ? getStandardCardOptionViews().hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QueryPayMethodResponse queryPayMethodResponse = (QueryPayMethodResponse) obj;
        if (getDefaultOption() == null ? queryPayMethodResponse.getDefaultOption() == null : getDefaultOption().equals(queryPayMethodResponse.getDefaultOption())) {
            if (getPayMethodViews() == null ? queryPayMethodResponse.getPayMethodViews() == null : getPayMethodViews().equals(queryPayMethodResponse.getPayMethodViews())) {
                if (getStandardCardOptionViews() != null) {
                    return getStandardCardOptionViews().equals(queryPayMethodResponse.getStandardCardOptionViews());
                }
                return queryPayMethodResponse.getStandardCardOptionViews() == null;
            }
            return false;
        }
        return false;
    }

    public String getDefaultOption() {
        return this.defaultOption;
    }

    public void setDefaultOption(String str) {
        this.defaultOption = str;
    }

    public List<PayMethodView> getPayMethodViews() {
        return this.payMethodViews;
    }

    public void setPayMethodViews(List<PayMethodView> list) {
        this.payMethodViews = list;
    }

    public List<PayCardOptionView> getStandardCardOptionViews() {
        return this.standardCardOptionViews;
    }

    public void setStandardCardOptionViews(List<PayCardOptionView> list) {
        this.standardCardOptionViews = list;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }
}
