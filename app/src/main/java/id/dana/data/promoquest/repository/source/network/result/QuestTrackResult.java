package id.dana.data.promoquest.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;

/* loaded from: classes4.dex */
public class QuestTrackResult extends BaseRpcResult {
    private String questRedirectType;
    private String questRedirectValue;
    private boolean redeemResult;
    private boolean trackResult;

    public String getQuestRedirectType() {
        return this.questRedirectType;
    }

    public void setQuestRedirectType(String str) {
        this.questRedirectType = str;
    }

    public String getQuestRedirectValue() {
        return this.questRedirectValue;
    }

    public void setQuestRedirectValue(String str) {
        this.questRedirectValue = str;
    }

    public boolean isRedeemResult() {
        return this.redeemResult;
    }

    public void setRedeemResult(boolean z) {
        this.redeemResult = z;
    }

    public boolean isTrackResult() {
        return this.trackResult;
    }

    public void setTrackResult(boolean z) {
        this.trackResult = z;
    }
}
