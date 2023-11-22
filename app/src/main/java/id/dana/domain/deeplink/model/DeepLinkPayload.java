package id.dana.domain.deeplink.model;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.domain.deeplink.ParamConstantsKt;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class DeepLinkPayload {
    private String action;
    private String codeValue;
    private String destinationPath;
    private JSONObject extendedInfo;
    private String fullUrl;
    private String innerUrl;
    private String invitationId;
    private OauthParams oauthParams;
    private String orderId;
    private String organizerName;
    private Map<String, String> params;
    private String path;
    private String promoCode;
    private String referralCode;
    private String shortCode;
    private boolean skipHomePage;

    public JSONObject getExtendedInfo() {
        return this.extendedInfo;
    }

    public void setExtendedInfo(JSONObject jSONObject) {
        this.extendedInfo = jSONObject;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public String getInnerUrl() {
        return this.innerUrl;
    }

    public String getDestinationPath() {
        return this.destinationPath;
    }

    public void setDestinationPath(String str) {
        this.destinationPath = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setInnerUrl(String str) {
        this.innerUrl = str;
    }

    public String getShortCode() {
        return this.shortCode;
    }

    public void setShortCode(String str) {
        this.shortCode = str;
    }

    public String getReferralCode() {
        return this.referralCode;
    }

    public void setReferralCode(String str) {
        this.referralCode = str;
    }

    public String getFullUrl() {
        return this.fullUrl;
    }

    public void setFullUrl(String str) {
        this.fullUrl = str;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public boolean isSkipHomePage() {
        return this.skipHomePage;
    }

    public void setSkipHomePage(boolean z) {
        this.skipHomePage = z;
    }

    public OauthParams getOauthParams() {
        return this.oauthParams;
    }

    public void setOauthParams(OauthParams oauthParams) {
        this.oauthParams = oauthParams;
    }

    public String getPromoCode() {
        return this.promoCode;
    }

    public void setPromoCode(String str) {
        this.promoCode = str;
    }

    public String getCodeValue() {
        return this.codeValue;
    }

    public void setCodeValue(String str) {
        this.codeValue = str;
    }

    public String getReferringLink() {
        return getParams().get("referring_link");
    }

    public String getConstructCashierUrl() {
        String obj;
        int lastIndexOf;
        String str = getParams().get("android_url");
        String str2 = getParams().get("referring_link");
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (lastIndexOf = (obj = modifyUriParameter(Uri.parse(str2.replace("&amp%3B", ContainerUtils.FIELD_DELIMITER).replace("&amp%3b", ContainerUtils.FIELD_DELIMITER).replace("&amp;", ContainerUtils.FIELD_DELIMITER))).toString()).lastIndexOf(ParamConstantsKt.PAY_INDEX)) == -1) {
            return null;
        }
        String substring = obj.substring(lastIndexOf + 4);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(substring);
        return sb.toString();
    }

    private Uri modifyUriParameter(Uri uri) {
        Uri.Builder clearQuery = uri.buildUpon().clearQuery();
        for (String str : uri.getQueryParameterNames()) {
            if (!str.equals("ott")) {
                clearQuery.appendQueryParameter(str, uri.getQueryParameter(str));
            }
        }
        clearQuery.appendQueryParameter(ParamConstantsKt.IS_DEEPLINK_PAYMENT, Boolean.TRUE.toString());
        return clearQuery.build();
    }

    public String getInvitationId() {
        return this.invitationId;
    }

    public void setInvitationId(String str) {
        this.invitationId = str;
    }

    public String getOrganizerName() {
        return this.organizerName;
    }

    public void setOrganizerName(String str) {
        this.organizerName = str;
    }
}
