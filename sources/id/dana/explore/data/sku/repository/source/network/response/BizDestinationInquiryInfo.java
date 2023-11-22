package id.dana.explore.data.sku.repository.source.network.response;

import com.google.gson.annotations.SerializedName;
import id.dana.domain.nearbyme.model.MoneyView;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b+\b\u0086\b\u0018\u00002\u00020\u0001Bõ\u0002\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b\u0012\b\u00101\u001a\u0004\u0018\u00010&\u0012\b\u00102\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\by\u0010zJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0004J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0004J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0004J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0004J\u0018\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b%\u0010\u000eJ\u0012\u0010'\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0004\b'\u0010(J\u0012\u0010)\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0004\b)\u0010(J\u0012\u0010*\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0004\b*\u0010(J\u0012\u0010+\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010\u0004J\u0012\u0010,\u001a\u0004\u0018\u00010&HÆ\u0003¢\u0006\u0004\b,\u0010(J\u0084\u0003\u0010K\u001a\u00020\u00002\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b2\n\b\u0002\u00101\u001a\u0004\u0018\u00010&2\n\b\u0002\u00102\u001a\u0004\u0018\u00010&2\n\b\u0002\u00103\u001a\u0004\u0018\u00010&2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00105\u001a\u0004\u0018\u00010&2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\bK\u0010LJ\u001a\u0010P\u001a\u00020O2\b\u0010N\u001a\u0004\u0018\u00010MHÖ\u0003¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\bR\u0010SJ\u0010\u0010T\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bT\u0010\u0004R\u001c\u0010<\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010U\u001a\u0004\bV\u0010\u0004R\u001c\u00103\u001a\u0004\u0018\u00010&8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010W\u001a\u0004\bX\u0010(R\u001c\u0010A\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010U\u001a\u0004\bY\u0010\u0004R\u001c\u00102\u001a\u0004\u0018\u00010&8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010W\u001a\u0004\bZ\u0010(R\u001c\u0010G\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010U\u001a\u0004\b[\u0010\u0004R\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010U\u001a\u0004\b\\\u0010\u0004R\"\u0010:\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010]\u001a\u0004\b^\u0010\u000eR\u001c\u00106\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010U\u001a\u0004\b_\u0010\u0004R\u001c\u0010J\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bJ\u0010U\u001a\u0004\b`\u0010\u0004R\u001c\u00109\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010a\u001a\u0004\bb\u0010\bR\u001c\u00108\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010U\u001a\u0004\bc\u0010\u0004R\u001c\u0010C\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010U\u001a\u0004\bd\u0010\u0004R\u001c\u00105\u001a\u0004\u0018\u00010&8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010W\u001a\u0004\be\u0010(R\u001c\u0010-\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010U\u001a\u0004\bf\u0010\u0004R\u001c\u0010.\u001a\u0004\u0018\u00010\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010g\u001a\u0004\bh\u0010\u0018R\u001c\u0010@\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010U\u001a\u0004\bi\u0010\u0004R\u001c\u0010B\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010U\u001a\u0004\bj\u0010\u0004R\u001c\u00107\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010a\u001a\u0004\bk\u0010\bR\"\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010]\u001a\u0004\bl\u0010\u000eR\u001c\u0010H\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010U\u001a\u0004\bm\u0010\u0004R\u001c\u0010;\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010U\u001a\u0004\bn\u0010\u0004R\u001c\u00104\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010U\u001a\u0004\bo\u0010\u0004R\u001c\u0010E\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010U\u001a\u0004\bp\u0010\u0004R\u001c\u0010=\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010U\u001a\u0004\bq\u0010\u0004R\u001c\u0010I\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010U\u001a\u0004\br\u0010\u0004R\u001c\u0010?\u001a\u0004\u0018\u00010\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010s\u001a\u0004\bt\u0010\u0015R\u001c\u00101\u001a\u0004\u0018\u00010&8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010W\u001a\u0004\bu\u0010(R\u001c\u0010D\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010U\u001a\u0004\bv\u0010\u0004R\u001c\u0010F\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010U\u001a\u0004\bw\u0010\u0004R\u001c\u0010>\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010U\u001a\u0004\bx\u0010\u0004"}, d2 = {"Lid/dana/explore/data/sku/repository/source/network/response/BizDestinationInquiryInfo;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component10", "", "component11", "()Ljava/lang/Integer;", "component12", "component13", "", "Lid/dana/explore/data/sku/repository/source/network/response/BillAmountDetail;", "component14", "()Ljava/util/List;", "component15", "component16", "component17", "component18", "Lid/dana/domain/nearbyme/model/MoneyView;", "component19", "()Lid/dana/domain/nearbyme/model/MoneyView;", "Lid/dana/explore/data/sku/repository/source/network/response/InquiryStatus;", "component2", "()Lid/dana/explore/data/sku/repository/source/network/response/InquiryStatus;", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "component5", "()Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "component6", "component7", "component8", "component9", "inquiryId", "inquiryStatus", "customerName", "period", "totalAmount", "baseAmount", "adminFee", "providerName", "fineAmount", "dueDate", "paymentCount", "familyNumber", "familyCount", "detailAmount", "policeNumber", "address", "standMeter", "usage", "tagNonAir", "load", "amount", "meterNumber", "fare", "totalEnergy", "refNumber", "type", "certificateNumber", "phoneNumber", "startDate", "endDate", "copy", "(Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/response/InquiryStatus;Ljava/lang/String;Ljava/util/List;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/explore/data/sku/repository/source/network/response/BizDestinationInquiryInfo;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAddress", "Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;", "getAdminFee", "getAmount", "getBaseAmount", "getCertificateNumber", "getCustomerName", "Ljava/util/List;", "getDetailAmount", "getDueDate", "getEndDate", "Ljava/lang/Integer;", "getFamilyCount", "getFamilyNumber", "getFare", "getFineAmount", "getInquiryId", "Lid/dana/explore/data/sku/repository/source/network/response/InquiryStatus;", "getInquiryStatus", "getLoad", "getMeterNumber", "getPaymentCount", "getPeriod", "getPhoneNumber", "getPoliceNumber", "getProviderName", "getRefNumber", "getStandMeter", "getStartDate", "Lid/dana/domain/nearbyme/model/MoneyView;", "getTagNonAir", "getTotalAmount", "getTotalEnergy", "getType", "getUsage", "<init>", "(Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/response/InquiryStatus;Ljava/lang/String;Ljava/util/List;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Ljava/lang/String;Lid/dana/explore/data/sku/repository/source/network/response/MultiCurrencyMoney;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizDestinationInquiryInfo implements Serializable {
    @SerializedName("address")
    private final String address;
    @SerializedName("adminFee")
    private final MultiCurrencyMoney adminFee;
    @SerializedName("amount")
    private final String amount;
    @SerializedName("baseAmount")
    private final MultiCurrencyMoney baseAmount;
    @SerializedName("certificateNumber")
    private final String certificateNumber;
    @SerializedName("customerName")
    private final String customerName;
    @SerializedName("detailAmount")
    private final List<BillAmountDetail> detailAmount;
    @SerializedName("dueDate")
    private final String dueDate;
    @SerializedName("endDate")
    private final String endDate;
    @SerializedName("familyCount")
    private final Integer familyCount;
    @SerializedName("familyNumber")
    private final String familyNumber;
    @SerializedName("fare")
    private final String fare;
    @SerializedName("fineAmount")
    private final MultiCurrencyMoney fineAmount;
    @SerializedName("inquiryId")
    private final String inquiryId;
    @SerializedName("inquiryStatus")
    private final InquiryStatus inquiryStatus;
    @SerializedName("load")
    private final String load;
    @SerializedName("meterNumber")
    private final String meterNumber;
    @SerializedName("paymentCount")
    private final Integer paymentCount;
    @SerializedName("period")
    private final List<String> period;
    @SerializedName("phoneNumber")
    private final String phoneNumber;
    @SerializedName("policeNumber")
    private final String policeNumber;
    @SerializedName("providerName")
    private final String providerName;
    @SerializedName("refNumber")
    private final String refNumber;
    @SerializedName("standMeter")
    private final String standMeter;
    @SerializedName("startDate")
    private final String startDate;
    @SerializedName("tagNonAir")
    private final MoneyView tagNonAir;
    @SerializedName("totalAmount")
    private final MultiCurrencyMoney totalAmount;
    @SerializedName("totalEnergy")
    private final String totalEnergy;
    @SerializedName("type")
    private final String type;
    @SerializedName("usage")
    private final String usage;

    /* renamed from: component1  reason: from getter */
    public final String getInquiryId() {
        return this.inquiryId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getDueDate() {
        return this.dueDate;
    }

    /* renamed from: component11  reason: from getter */
    public final Integer getPaymentCount() {
        return this.paymentCount;
    }

    /* renamed from: component12  reason: from getter */
    public final String getFamilyNumber() {
        return this.familyNumber;
    }

    /* renamed from: component13  reason: from getter */
    public final Integer getFamilyCount() {
        return this.familyCount;
    }

    public final List<BillAmountDetail> component14() {
        return this.detailAmount;
    }

    /* renamed from: component15  reason: from getter */
    public final String getPoliceNumber() {
        return this.policeNumber;
    }

    /* renamed from: component16  reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component17  reason: from getter */
    public final String getStandMeter() {
        return this.standMeter;
    }

    /* renamed from: component18  reason: from getter */
    public final String getUsage() {
        return this.usage;
    }

    /* renamed from: component19  reason: from getter */
    public final MoneyView getTagNonAir() {
        return this.tagNonAir;
    }

    /* renamed from: component2  reason: from getter */
    public final InquiryStatus getInquiryStatus() {
        return this.inquiryStatus;
    }

    /* renamed from: component20  reason: from getter */
    public final String getLoad() {
        return this.load;
    }

    /* renamed from: component21  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component22  reason: from getter */
    public final String getMeterNumber() {
        return this.meterNumber;
    }

    /* renamed from: component23  reason: from getter */
    public final String getFare() {
        return this.fare;
    }

    /* renamed from: component24  reason: from getter */
    public final String getTotalEnergy() {
        return this.totalEnergy;
    }

    /* renamed from: component25  reason: from getter */
    public final String getRefNumber() {
        return this.refNumber;
    }

    /* renamed from: component26  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component27  reason: from getter */
    public final String getCertificateNumber() {
        return this.certificateNumber;
    }

    /* renamed from: component28  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component29  reason: from getter */
    public final String getStartDate() {
        return this.startDate;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    /* renamed from: component30  reason: from getter */
    public final String getEndDate() {
        return this.endDate;
    }

    public final List<String> component4() {
        return this.period;
    }

    /* renamed from: component5  reason: from getter */
    public final MultiCurrencyMoney getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component6  reason: from getter */
    public final MultiCurrencyMoney getBaseAmount() {
        return this.baseAmount;
    }

    /* renamed from: component7  reason: from getter */
    public final MultiCurrencyMoney getAdminFee() {
        return this.adminFee;
    }

    /* renamed from: component8  reason: from getter */
    public final String getProviderName() {
        return this.providerName;
    }

    /* renamed from: component9  reason: from getter */
    public final MultiCurrencyMoney getFineAmount() {
        return this.fineAmount;
    }

    public final BizDestinationInquiryInfo copy(String inquiryId, InquiryStatus inquiryStatus, String customerName, List<String> period, MultiCurrencyMoney totalAmount, MultiCurrencyMoney baseAmount, MultiCurrencyMoney adminFee, String providerName, MultiCurrencyMoney fineAmount, String dueDate, Integer paymentCount, String familyNumber, Integer familyCount, List<BillAmountDetail> detailAmount, String policeNumber, String address, String standMeter, String usage, MoneyView tagNonAir, String load, String amount, String meterNumber, String fare, String totalEnergy, String refNumber, String type, String certificateNumber, String phoneNumber, String startDate, String endDate) {
        return new BizDestinationInquiryInfo(inquiryId, inquiryStatus, customerName, period, totalAmount, baseAmount, adminFee, providerName, fineAmount, dueDate, paymentCount, familyNumber, familyCount, detailAmount, policeNumber, address, standMeter, usage, tagNonAir, load, amount, meterNumber, fare, totalEnergy, refNumber, type, certificateNumber, phoneNumber, startDate, endDate);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizDestinationInquiryInfo) {
            BizDestinationInquiryInfo bizDestinationInquiryInfo = (BizDestinationInquiryInfo) other;
            return Intrinsics.areEqual(this.inquiryId, bizDestinationInquiryInfo.inquiryId) && Intrinsics.areEqual(this.inquiryStatus, bizDestinationInquiryInfo.inquiryStatus) && Intrinsics.areEqual(this.customerName, bizDestinationInquiryInfo.customerName) && Intrinsics.areEqual(this.period, bizDestinationInquiryInfo.period) && Intrinsics.areEqual(this.totalAmount, bizDestinationInquiryInfo.totalAmount) && Intrinsics.areEqual(this.baseAmount, bizDestinationInquiryInfo.baseAmount) && Intrinsics.areEqual(this.adminFee, bizDestinationInquiryInfo.adminFee) && Intrinsics.areEqual(this.providerName, bizDestinationInquiryInfo.providerName) && Intrinsics.areEqual(this.fineAmount, bizDestinationInquiryInfo.fineAmount) && Intrinsics.areEqual(this.dueDate, bizDestinationInquiryInfo.dueDate) && Intrinsics.areEqual(this.paymentCount, bizDestinationInquiryInfo.paymentCount) && Intrinsics.areEqual(this.familyNumber, bizDestinationInquiryInfo.familyNumber) && Intrinsics.areEqual(this.familyCount, bizDestinationInquiryInfo.familyCount) && Intrinsics.areEqual(this.detailAmount, bizDestinationInquiryInfo.detailAmount) && Intrinsics.areEqual(this.policeNumber, bizDestinationInquiryInfo.policeNumber) && Intrinsics.areEqual(this.address, bizDestinationInquiryInfo.address) && Intrinsics.areEqual(this.standMeter, bizDestinationInquiryInfo.standMeter) && Intrinsics.areEqual(this.usage, bizDestinationInquiryInfo.usage) && Intrinsics.areEqual(this.tagNonAir, bizDestinationInquiryInfo.tagNonAir) && Intrinsics.areEqual(this.load, bizDestinationInquiryInfo.load) && Intrinsics.areEqual(this.amount, bizDestinationInquiryInfo.amount) && Intrinsics.areEqual(this.meterNumber, bizDestinationInquiryInfo.meterNumber) && Intrinsics.areEqual(this.fare, bizDestinationInquiryInfo.fare) && Intrinsics.areEqual(this.totalEnergy, bizDestinationInquiryInfo.totalEnergy) && Intrinsics.areEqual(this.refNumber, bizDestinationInquiryInfo.refNumber) && Intrinsics.areEqual(this.type, bizDestinationInquiryInfo.type) && Intrinsics.areEqual(this.certificateNumber, bizDestinationInquiryInfo.certificateNumber) && Intrinsics.areEqual(this.phoneNumber, bizDestinationInquiryInfo.phoneNumber) && Intrinsics.areEqual(this.startDate, bizDestinationInquiryInfo.startDate) && Intrinsics.areEqual(this.endDate, bizDestinationInquiryInfo.endDate);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.inquiryId;
        int hashCode = str == null ? 0 : str.hashCode();
        InquiryStatus inquiryStatus = this.inquiryStatus;
        int hashCode2 = inquiryStatus == null ? 0 : inquiryStatus.hashCode();
        String str2 = this.customerName;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        List<String> list = this.period;
        int hashCode4 = list == null ? 0 : list.hashCode();
        MultiCurrencyMoney multiCurrencyMoney = this.totalAmount;
        int hashCode5 = multiCurrencyMoney == null ? 0 : multiCurrencyMoney.hashCode();
        MultiCurrencyMoney multiCurrencyMoney2 = this.baseAmount;
        int hashCode6 = multiCurrencyMoney2 == null ? 0 : multiCurrencyMoney2.hashCode();
        MultiCurrencyMoney multiCurrencyMoney3 = this.adminFee;
        int hashCode7 = multiCurrencyMoney3 == null ? 0 : multiCurrencyMoney3.hashCode();
        String str3 = this.providerName;
        int hashCode8 = str3 == null ? 0 : str3.hashCode();
        MultiCurrencyMoney multiCurrencyMoney4 = this.fineAmount;
        int hashCode9 = multiCurrencyMoney4 == null ? 0 : multiCurrencyMoney4.hashCode();
        String str4 = this.dueDate;
        int hashCode10 = str4 == null ? 0 : str4.hashCode();
        Integer num = this.paymentCount;
        int hashCode11 = num == null ? 0 : num.hashCode();
        String str5 = this.familyNumber;
        int hashCode12 = str5 == null ? 0 : str5.hashCode();
        Integer num2 = this.familyCount;
        int hashCode13 = num2 == null ? 0 : num2.hashCode();
        List<BillAmountDetail> list2 = this.detailAmount;
        int hashCode14 = list2 == null ? 0 : list2.hashCode();
        String str6 = this.policeNumber;
        int hashCode15 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.address;
        int hashCode16 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.standMeter;
        int hashCode17 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.usage;
        int hashCode18 = str9 == null ? 0 : str9.hashCode();
        MoneyView moneyView = this.tagNonAir;
        int hashCode19 = moneyView == null ? 0 : moneyView.hashCode();
        String str10 = this.load;
        int hashCode20 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.amount;
        int hashCode21 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.meterNumber;
        int hashCode22 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.fare;
        int hashCode23 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.totalEnergy;
        int hashCode24 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.refNumber;
        int hashCode25 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.type;
        int hashCode26 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.certificateNumber;
        int hashCode27 = str17 == null ? 0 : str17.hashCode();
        String str18 = this.phoneNumber;
        int hashCode28 = str18 == null ? 0 : str18.hashCode();
        String str19 = this.startDate;
        int hashCode29 = str19 == null ? 0 : str19.hashCode();
        String str20 = this.endDate;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + hashCode26) * 31) + hashCode27) * 31) + hashCode28) * 31) + hashCode29) * 31) + (str20 != null ? str20.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizDestinationInquiryInfo(inquiryId=");
        sb.append(this.inquiryId);
        sb.append(", inquiryStatus=");
        sb.append(this.inquiryStatus);
        sb.append(", customerName=");
        sb.append(this.customerName);
        sb.append(", period=");
        sb.append(this.period);
        sb.append(", totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", baseAmount=");
        sb.append(this.baseAmount);
        sb.append(", adminFee=");
        sb.append(this.adminFee);
        sb.append(", providerName=");
        sb.append(this.providerName);
        sb.append(", fineAmount=");
        sb.append(this.fineAmount);
        sb.append(", dueDate=");
        sb.append(this.dueDate);
        sb.append(", paymentCount=");
        sb.append(this.paymentCount);
        sb.append(", familyNumber=");
        sb.append(this.familyNumber);
        sb.append(", familyCount=");
        sb.append(this.familyCount);
        sb.append(", detailAmount=");
        sb.append(this.detailAmount);
        sb.append(", policeNumber=");
        sb.append(this.policeNumber);
        sb.append(", address=");
        sb.append(this.address);
        sb.append(", standMeter=");
        sb.append(this.standMeter);
        sb.append(", usage=");
        sb.append(this.usage);
        sb.append(", tagNonAir=");
        sb.append(this.tagNonAir);
        sb.append(", load=");
        sb.append(this.load);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", meterNumber=");
        sb.append(this.meterNumber);
        sb.append(", fare=");
        sb.append(this.fare);
        sb.append(", totalEnergy=");
        sb.append(this.totalEnergy);
        sb.append(", refNumber=");
        sb.append(this.refNumber);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", certificateNumber=");
        sb.append(this.certificateNumber);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", startDate=");
        sb.append(this.startDate);
        sb.append(", endDate=");
        sb.append(this.endDate);
        sb.append(')');
        return sb.toString();
    }

    public BizDestinationInquiryInfo(String str, InquiryStatus inquiryStatus, String str2, List<String> list, MultiCurrencyMoney multiCurrencyMoney, MultiCurrencyMoney multiCurrencyMoney2, MultiCurrencyMoney multiCurrencyMoney3, String str3, MultiCurrencyMoney multiCurrencyMoney4, String str4, Integer num, String str5, Integer num2, List<BillAmountDetail> list2, String str6, String str7, String str8, String str9, MoneyView moneyView, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20) {
        this.inquiryId = str;
        this.inquiryStatus = inquiryStatus;
        this.customerName = str2;
        this.period = list;
        this.totalAmount = multiCurrencyMoney;
        this.baseAmount = multiCurrencyMoney2;
        this.adminFee = multiCurrencyMoney3;
        this.providerName = str3;
        this.fineAmount = multiCurrencyMoney4;
        this.dueDate = str4;
        this.paymentCount = num;
        this.familyNumber = str5;
        this.familyCount = num2;
        this.detailAmount = list2;
        this.policeNumber = str6;
        this.address = str7;
        this.standMeter = str8;
        this.usage = str9;
        this.tagNonAir = moneyView;
        this.load = str10;
        this.amount = str11;
        this.meterNumber = str12;
        this.fare = str13;
        this.totalEnergy = str14;
        this.refNumber = str15;
        this.type = str16;
        this.certificateNumber = str17;
        this.phoneNumber = str18;
        this.startDate = str19;
        this.endDate = str20;
    }

    public /* synthetic */ BizDestinationInquiryInfo(String str, InquiryStatus inquiryStatus, String str2, List list, MultiCurrencyMoney multiCurrencyMoney, MultiCurrencyMoney multiCurrencyMoney2, MultiCurrencyMoney multiCurrencyMoney3, String str3, MultiCurrencyMoney multiCurrencyMoney4, String str4, Integer num, String str5, Integer num2, List list2, String str6, String str7, String str8, String str9, MoneyView moneyView, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, inquiryStatus, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? null : list, multiCurrencyMoney, multiCurrencyMoney2, (i & 64) != 0 ? null : multiCurrencyMoney3, (i & 128) != 0 ? "" : str3, (i & 256) != 0 ? null : multiCurrencyMoney4, (i & 512) != 0 ? "" : str4, (i & 1024) != 0 ? null : num, (i & 2048) != 0 ? "" : str5, (i & 4096) != 0 ? null : num2, (i & 8192) != 0 ? null : list2, (i & 16384) != 0 ? "" : str6, (32768 & i) != 0 ? "" : str7, (65536 & i) != 0 ? "" : str8, (131072 & i) != 0 ? "" : str9, (262144 & i) != 0 ? null : moneyView, (524288 & i) != 0 ? "" : str10, (1048576 & i) != 0 ? "" : str11, (2097152 & i) != 0 ? "" : str12, (4194304 & i) != 0 ? "" : str13, (8388608 & i) != 0 ? "" : str14, (16777216 & i) != 0 ? "" : str15, (33554432 & i) != 0 ? "" : str16, (67108864 & i) != 0 ? "" : str17, (134217728 & i) != 0 ? "" : str18, (268435456 & i) != 0 ? "" : str19, (i & 536870912) != 0 ? "" : str20);
    }

    @JvmName(name = "getInquiryId")
    public final String getInquiryId() {
        return this.inquiryId;
    }

    @JvmName(name = "getInquiryStatus")
    public final InquiryStatus getInquiryStatus() {
        return this.inquiryStatus;
    }

    @JvmName(name = "getCustomerName")
    public final String getCustomerName() {
        return this.customerName;
    }

    @JvmName(name = "getPeriod")
    public final List<String> getPeriod() {
        return this.period;
    }

    @JvmName(name = "getTotalAmount")
    public final MultiCurrencyMoney getTotalAmount() {
        return this.totalAmount;
    }

    @JvmName(name = "getBaseAmount")
    public final MultiCurrencyMoney getBaseAmount() {
        return this.baseAmount;
    }

    @JvmName(name = "getAdminFee")
    public final MultiCurrencyMoney getAdminFee() {
        return this.adminFee;
    }

    @JvmName(name = "getProviderName")
    public final String getProviderName() {
        return this.providerName;
    }

    @JvmName(name = "getFineAmount")
    public final MultiCurrencyMoney getFineAmount() {
        return this.fineAmount;
    }

    @JvmName(name = "getDueDate")
    public final String getDueDate() {
        return this.dueDate;
    }

    @JvmName(name = "getPaymentCount")
    public final Integer getPaymentCount() {
        return this.paymentCount;
    }

    @JvmName(name = "getFamilyNumber")
    public final String getFamilyNumber() {
        return this.familyNumber;
    }

    @JvmName(name = "getFamilyCount")
    public final Integer getFamilyCount() {
        return this.familyCount;
    }

    @JvmName(name = "getDetailAmount")
    public final List<BillAmountDetail> getDetailAmount() {
        return this.detailAmount;
    }

    @JvmName(name = "getPoliceNumber")
    public final String getPoliceNumber() {
        return this.policeNumber;
    }

    @JvmName(name = "getAddress")
    public final String getAddress() {
        return this.address;
    }

    @JvmName(name = "getStandMeter")
    public final String getStandMeter() {
        return this.standMeter;
    }

    @JvmName(name = "getUsage")
    public final String getUsage() {
        return this.usage;
    }

    @JvmName(name = "getTagNonAir")
    public final MoneyView getTagNonAir() {
        return this.tagNonAir;
    }

    @JvmName(name = "getLoad")
    public final String getLoad() {
        return this.load;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getMeterNumber")
    public final String getMeterNumber() {
        return this.meterNumber;
    }

    @JvmName(name = "getFare")
    public final String getFare() {
        return this.fare;
    }

    @JvmName(name = "getTotalEnergy")
    public final String getTotalEnergy() {
        return this.totalEnergy;
    }

    @JvmName(name = "getRefNumber")
    public final String getRefNumber() {
        return this.refNumber;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getCertificateNumber")
    public final String getCertificateNumber() {
        return this.certificateNumber;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "getStartDate")
    public final String getStartDate() {
        return this.startDate;
    }

    @JvmName(name = "getEndDate")
    public final String getEndDate() {
        return this.endDate;
    }
}
