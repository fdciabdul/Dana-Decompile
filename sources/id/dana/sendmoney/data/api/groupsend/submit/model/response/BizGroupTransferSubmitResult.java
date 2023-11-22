package id.dana.sendmoney.data.api.groupsend.submit.model.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.config.source.sharedpreference.CurrencyAmountModelEntityData;
import id.dana.data.constant.UrlParam;
import id.dana.sendmoney.data.api.groupsend.submit.model.CreatorGroupIdentifier;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/submit/model/response/BizGroupTransferSubmitResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "activityType", "Ljava/lang/String;", "getActivityType", "()Ljava/lang/String;", "batchNo", "getBatchNo", "createdTime", "getCreatedTime", "Lid/dana/sendmoney/data/api/groupsend/submit/model/CreatorGroupIdentifier;", "creatorGroupIdentifier", "Lid/dana/sendmoney/data/api/groupsend/submit/model/CreatorGroupIdentifier;", "getCreatorGroupIdentifier", "()Lid/dana/sendmoney/data/api/groupsend/submit/model/CreatorGroupIdentifier;", "Lid/dana/data/config/source/sharedpreference/CurrencyAmountModelEntityData;", "originalAmount", "Lid/dana/data/config/source/sharedpreference/CurrencyAmountModelEntityData;", "getOriginalAmount", "()Lid/dana/data/config/source/sharedpreference/CurrencyAmountModelEntityData;", "payTransferNo", "getPayTransferNo", UrlParam.REQUEST_ID, "getRequestId", "state", "getState", "subState", "getSubState", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/config/source/sharedpreference/CurrencyAmountModelEntityData;Ljava/lang/String;Lid/dana/sendmoney/data/api/groupsend/submit/model/CreatorGroupIdentifier;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BizGroupTransferSubmitResult extends BaseRpcResult {
    private final String activityType;
    private final String batchNo;
    private final String createdTime;
    private final CreatorGroupIdentifier creatorGroupIdentifier;
    private final CurrencyAmountModelEntityData originalAmount;
    private final String payTransferNo;
    private final String requestId;
    private final String state;
    private final String subState;

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    @JvmName(name = "getBatchNo")
    public final String getBatchNo() {
        return this.batchNo;
    }

    @JvmName(name = "getPayTransferNo")
    public final String getPayTransferNo() {
        return this.payTransferNo;
    }

    @JvmName(name = "getActivityType")
    public final String getActivityType() {
        return this.activityType;
    }

    @JvmName(name = "getState")
    public final String getState() {
        return this.state;
    }

    @JvmName(name = "getSubState")
    public final String getSubState() {
        return this.subState;
    }

    @JvmName(name = "getOriginalAmount")
    public final CurrencyAmountModelEntityData getOriginalAmount() {
        return this.originalAmount;
    }

    @JvmName(name = "getCreatedTime")
    public final String getCreatedTime() {
        return this.createdTime;
    }

    @JvmName(name = "getCreatorGroupIdentifier")
    public final CreatorGroupIdentifier getCreatorGroupIdentifier() {
        return this.creatorGroupIdentifier;
    }

    public BizGroupTransferSubmitResult(String str, String str2, String str3, String str4, String str5, String str6, CurrencyAmountModelEntityData currencyAmountModelEntityData, String str7, CreatorGroupIdentifier creatorGroupIdentifier) {
        this.requestId = str;
        this.batchNo = str2;
        this.payTransferNo = str3;
        this.activityType = str4;
        this.state = str5;
        this.subState = str6;
        this.originalAmount = currencyAmountModelEntityData;
        this.createdTime = str7;
        this.creatorGroupIdentifier = creatorGroupIdentifier;
    }
}
