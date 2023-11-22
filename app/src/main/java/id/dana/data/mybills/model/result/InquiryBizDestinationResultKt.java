package id.dana.data.mybills.model.result;

import id.dana.domain.mybills.model.BizProductDestination;
import id.dana.domain.nearbyme.model.MoneyView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/mybills/model/result/InquiryBizDestinationResult;", "Lid/dana/domain/mybills/model/BizProductDestination;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/mybills/model/result/InquiryBizDestinationResult;)Lid/dana/domain/mybills/model/BizProductDestination;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InquiryBizDestinationResultKt {
    public static final BizProductDestination KClassImpl$Data$declaredNonStaticMembers$2(InquiryBizDestinationResult inquiryBizDestinationResult) {
        String amount;
        SignalInquiryInfo signalInquiryInfo;
        MoneyView moneyView;
        SignalInquiryInfo signalInquiryInfo2;
        MoneyView moneyView2;
        Intrinsics.checkNotNullParameter(inquiryBizDestinationResult, "");
        List<SignalInquiryInfo> destinationInquiryDetails = inquiryBizDestinationResult.getDestinationInquiryDetails();
        if (destinationInquiryDetails == null || (signalInquiryInfo2 = (SignalInquiryInfo) CollectionsKt.firstOrNull((List) destinationInquiryDetails)) == null || (moneyView2 = signalInquiryInfo2.getAuthRequestContext) == null || (amount = moneyView2.getAmount()) == null) {
            List<SignalInquiryInfo> digitalDestinationInquiryInfos = inquiryBizDestinationResult.getDigitalDestinationInquiryInfos();
            amount = (digitalDestinationInquiryInfos == null || (signalInquiryInfo = (SignalInquiryInfo) CollectionsKt.firstOrNull((List) digitalDestinationInquiryInfos)) == null || (moneyView = signalInquiryInfo.getAuthRequestContext) == null) ? "" : moneyView.getAmount();
        }
        return new BizProductDestination("", amount);
    }
}
