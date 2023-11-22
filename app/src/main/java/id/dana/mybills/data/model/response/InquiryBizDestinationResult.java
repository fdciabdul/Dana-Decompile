package id.dana.mybills.data.model.response;

import com.google.gson.annotations.SerializedName;
import id.dana.network.base.BaseRpcResultAphome;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0005Jd\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b \u0010\u0005R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\u0005R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010#\u001a\u0004\b$\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010!\u001a\u0004\b%\u0010\u0005R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\rR\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b(\u0010\rR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010!\u001a\u0004\b)\u0010\u0005"}, d2 = {"Lid/dana/mybills/data/model/response/InquiryBizDestinationResult;", "Ljava/io/Serializable;", "Lid/dana/network/base/BaseRpcResultAphome;", "", "component1", "()Ljava/lang/String;", "component2", "Lid/dana/mybills/data/model/response/BizCenterResultInfo;", "component3", "()Lid/dana/mybills/data/model/response/BizCenterResultInfo;", "", "Lid/dana/mybills/data/model/response/DigitalDestinationInquiryInfo;", "component4", "()Ljava/util/List;", "component5", "component6", "bizType", "aggregatorGoodsId", "bizCenterResultInfo", "destinationInquiryDetails", "digitalDestinationInquiryInfos", "displayProvider", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/data/model/response/BizCenterResultInfo;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lid/dana/mybills/data/model/response/InquiryBizDestinationResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAggregatorGoodsId", "Lid/dana/mybills/data/model/response/BizCenterResultInfo;", "getBizCenterResultInfo", "getBizType", "Ljava/util/List;", "getDestinationInquiryDetails", "getDigitalDestinationInquiryInfos", "getDisplayProvider", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/data/model/response/BizCenterResultInfo;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class InquiryBizDestinationResult extends BaseRpcResultAphome implements Serializable {
    @SerializedName("aggregatorGoodsId")
    private final String aggregatorGoodsId;
    @SerializedName("bizCenterResultInfo")
    private final BizCenterResultInfo bizCenterResultInfo;
    @SerializedName("bizType")
    private final String bizType;
    @SerializedName("destinationInquiryDetails")
    private final List<DigitalDestinationInquiryInfo> destinationInquiryDetails;
    @SerializedName("digitalDestinationInquiryInfos")
    private final List<DigitalDestinationInquiryInfo> digitalDestinationInquiryInfos;
    @SerializedName("displayProvider")
    private final String displayProvider;

    public static /* synthetic */ InquiryBizDestinationResult copy$default(InquiryBizDestinationResult inquiryBizDestinationResult, String str, String str2, BizCenterResultInfo bizCenterResultInfo, List list, List list2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inquiryBizDestinationResult.bizType;
        }
        if ((i & 2) != 0) {
            str2 = inquiryBizDestinationResult.aggregatorGoodsId;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            bizCenterResultInfo = inquiryBizDestinationResult.bizCenterResultInfo;
        }
        BizCenterResultInfo bizCenterResultInfo2 = bizCenterResultInfo;
        List<DigitalDestinationInquiryInfo> list3 = list;
        if ((i & 8) != 0) {
            list3 = inquiryBizDestinationResult.destinationInquiryDetails;
        }
        List list4 = list3;
        List<DigitalDestinationInquiryInfo> list5 = list2;
        if ((i & 16) != 0) {
            list5 = inquiryBizDestinationResult.digitalDestinationInquiryInfos;
        }
        List list6 = list5;
        if ((i & 32) != 0) {
            str3 = inquiryBizDestinationResult.displayProvider;
        }
        return inquiryBizDestinationResult.copy(str, str4, bizCenterResultInfo2, list4, list6, str3);
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
    public final BizCenterResultInfo getBizCenterResultInfo() {
        return this.bizCenterResultInfo;
    }

    public final List<DigitalDestinationInquiryInfo> component4() {
        return this.destinationInquiryDetails;
    }

    public final List<DigitalDestinationInquiryInfo> component5() {
        return this.digitalDestinationInquiryInfos;
    }

    /* renamed from: component6  reason: from getter */
    public final String getDisplayProvider() {
        return this.displayProvider;
    }

    public final InquiryBizDestinationResult copy(String bizType, String aggregatorGoodsId, BizCenterResultInfo bizCenterResultInfo, List<DigitalDestinationInquiryInfo> destinationInquiryDetails, List<DigitalDestinationInquiryInfo> digitalDestinationInquiryInfos, String displayProvider) {
        return new InquiryBizDestinationResult(bizType, aggregatorGoodsId, bizCenterResultInfo, destinationInquiryDetails, digitalDestinationInquiryInfos, displayProvider);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof InquiryBizDestinationResult) {
            InquiryBizDestinationResult inquiryBizDestinationResult = (InquiryBizDestinationResult) other;
            return Intrinsics.areEqual(this.bizType, inquiryBizDestinationResult.bizType) && Intrinsics.areEqual(this.aggregatorGoodsId, inquiryBizDestinationResult.aggregatorGoodsId) && Intrinsics.areEqual(this.bizCenterResultInfo, inquiryBizDestinationResult.bizCenterResultInfo) && Intrinsics.areEqual(this.destinationInquiryDetails, inquiryBizDestinationResult.destinationInquiryDetails) && Intrinsics.areEqual(this.digitalDestinationInquiryInfos, inquiryBizDestinationResult.digitalDestinationInquiryInfos) && Intrinsics.areEqual(this.displayProvider, inquiryBizDestinationResult.displayProvider);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.bizType;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.aggregatorGoodsId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        BizCenterResultInfo bizCenterResultInfo = this.bizCenterResultInfo;
        int hashCode3 = bizCenterResultInfo == null ? 0 : bizCenterResultInfo.hashCode();
        List<DigitalDestinationInquiryInfo> list = this.destinationInquiryDetails;
        int hashCode4 = list == null ? 0 : list.hashCode();
        List<DigitalDestinationInquiryInfo> list2 = this.digitalDestinationInquiryInfos;
        int hashCode5 = list2 == null ? 0 : list2.hashCode();
        String str3 = this.displayProvider;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InquiryBizDestinationResult(bizType=");
        sb.append(this.bizType);
        sb.append(", aggregatorGoodsId=");
        sb.append(this.aggregatorGoodsId);
        sb.append(", bizCenterResultInfo=");
        sb.append(this.bizCenterResultInfo);
        sb.append(", destinationInquiryDetails=");
        sb.append(this.destinationInquiryDetails);
        sb.append(", digitalDestinationInquiryInfos=");
        sb.append(this.digitalDestinationInquiryInfos);
        sb.append(", displayProvider=");
        sb.append(this.displayProvider);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getAggregatorGoodsId")
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    @JvmName(name = "getBizCenterResultInfo")
    public final BizCenterResultInfo getBizCenterResultInfo() {
        return this.bizCenterResultInfo;
    }

    @JvmName(name = "getDestinationInquiryDetails")
    public final List<DigitalDestinationInquiryInfo> getDestinationInquiryDetails() {
        return this.destinationInquiryDetails;
    }

    @JvmName(name = "getDigitalDestinationInquiryInfos")
    public final List<DigitalDestinationInquiryInfo> getDigitalDestinationInquiryInfos() {
        return this.digitalDestinationInquiryInfos;
    }

    @JvmName(name = "getDisplayProvider")
    public final String getDisplayProvider() {
        return this.displayProvider;
    }

    public InquiryBizDestinationResult(String str, String str2, BizCenterResultInfo bizCenterResultInfo, List<DigitalDestinationInquiryInfo> list, List<DigitalDestinationInquiryInfo> list2, String str3) {
        this.bizType = str;
        this.aggregatorGoodsId = str2;
        this.bizCenterResultInfo = bizCenterResultInfo;
        this.destinationInquiryDetails = list;
        this.digitalDestinationInquiryInfos = list2;
        this.displayProvider = str3;
    }
}
