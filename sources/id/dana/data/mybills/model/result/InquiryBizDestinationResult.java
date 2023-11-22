package id.dana.data.mybills.model.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b#\u0010$J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJX\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010\nR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b!\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\"\u0010\u0004"}, d2 = {"Lid/dana/data/mybills/model/result/InquiryBizDestinationResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "", "Lid/dana/data/mybills/model/result/SignalInquiryInfo;", "component4", "()Ljava/util/List;", "component5", "bizType", "aggregatorGoodsId", "displayProvider", "destinationInquiryDetails", "digitalDestinationInquiryInfos", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lid/dana/data/mybills/model/result/InquiryBizDestinationResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAggregatorGoodsId", "getBizType", "Ljava/util/List;", "getDestinationInquiryDetails", "getDigitalDestinationInquiryInfos", "getDisplayProvider", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class InquiryBizDestinationResult extends BaseRpcResult {
    private final String aggregatorGoodsId;
    private final String bizType;
    private final List<SignalInquiryInfo> destinationInquiryDetails;
    private final List<SignalInquiryInfo> digitalDestinationInquiryInfos;
    private final String displayProvider;

    public InquiryBizDestinationResult() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ InquiryBizDestinationResult copy$default(InquiryBizDestinationResult inquiryBizDestinationResult, String str, String str2, String str3, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inquiryBizDestinationResult.bizType;
        }
        if ((i & 2) != 0) {
            str2 = inquiryBizDestinationResult.aggregatorGoodsId;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            str3 = inquiryBizDestinationResult.displayProvider;
        }
        String str5 = str3;
        List<SignalInquiryInfo> list3 = list;
        if ((i & 8) != 0) {
            list3 = inquiryBizDestinationResult.destinationInquiryDetails;
        }
        List list4 = list3;
        List<SignalInquiryInfo> list5 = list2;
        if ((i & 16) != 0) {
            list5 = inquiryBizDestinationResult.digitalDestinationInquiryInfos;
        }
        return inquiryBizDestinationResult.copy(str, str4, str5, list4, list5);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getDisplayProvider() {
        return this.displayProvider;
    }

    public final List<SignalInquiryInfo> component4() {
        return this.destinationInquiryDetails;
    }

    public final List<SignalInquiryInfo> component5() {
        return this.digitalDestinationInquiryInfos;
    }

    public final InquiryBizDestinationResult copy(String bizType, String aggregatorGoodsId, String displayProvider, List<SignalInquiryInfo> destinationInquiryDetails, List<SignalInquiryInfo> digitalDestinationInquiryInfos) {
        return new InquiryBizDestinationResult(bizType, aggregatorGoodsId, displayProvider, destinationInquiryDetails, digitalDestinationInquiryInfos);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof InquiryBizDestinationResult) {
            InquiryBizDestinationResult inquiryBizDestinationResult = (InquiryBizDestinationResult) other;
            return Intrinsics.areEqual(this.bizType, inquiryBizDestinationResult.bizType) && Intrinsics.areEqual(this.aggregatorGoodsId, inquiryBizDestinationResult.aggregatorGoodsId) && Intrinsics.areEqual(this.displayProvider, inquiryBizDestinationResult.displayProvider) && Intrinsics.areEqual(this.destinationInquiryDetails, inquiryBizDestinationResult.destinationInquiryDetails) && Intrinsics.areEqual(this.digitalDestinationInquiryInfos, inquiryBizDestinationResult.digitalDestinationInquiryInfos);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.bizType;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.aggregatorGoodsId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.displayProvider;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        List<SignalInquiryInfo> list = this.destinationInquiryDetails;
        int hashCode4 = list == null ? 0 : list.hashCode();
        List<SignalInquiryInfo> list2 = this.digitalDestinationInquiryInfos;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (list2 != null ? list2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InquiryBizDestinationResult(bizType=");
        sb.append(this.bizType);
        sb.append(", aggregatorGoodsId=");
        sb.append(this.aggregatorGoodsId);
        sb.append(", displayProvider=");
        sb.append(this.displayProvider);
        sb.append(", destinationInquiryDetails=");
        sb.append(this.destinationInquiryDetails);
        sb.append(", digitalDestinationInquiryInfos=");
        sb.append(this.digitalDestinationInquiryInfos);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ InquiryBizDestinationResult(String str, String str2, String str3, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) == 0 ? str3 : "", (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : list2);
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getAggregatorGoodsId")
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    @JvmName(name = "getDisplayProvider")
    public final String getDisplayProvider() {
        return this.displayProvider;
    }

    @JvmName(name = "getDestinationInquiryDetails")
    public final List<SignalInquiryInfo> getDestinationInquiryDetails() {
        return this.destinationInquiryDetails;
    }

    @JvmName(name = "getDigitalDestinationInquiryInfos")
    public final List<SignalInquiryInfo> getDigitalDestinationInquiryInfos() {
        return this.digitalDestinationInquiryInfos;
    }

    public InquiryBizDestinationResult(String str, String str2, String str3, List<SignalInquiryInfo> list, List<SignalInquiryInfo> list2) {
        this.bizType = str;
        this.aggregatorGoodsId = str2;
        this.displayProvider = str3;
        this.destinationInquiryDetails = list;
        this.digitalDestinationInquiryInfos = list2;
    }
}
