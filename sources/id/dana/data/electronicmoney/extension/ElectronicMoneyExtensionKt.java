package id.dana.data.electronicmoney.extension;

import id.dana.data.electronicmoney.network.response.ElectronicMoneyGetBizIdResponse;
import id.dana.data.electronicmoney.network.response.EmoneyCardInfoResponse;
import id.dana.data.electronicmoney.network.response.EmoneyDataEntity;
import id.dana.data.electronicmoney.network.response.EmoneyReversalResponse;
import id.dana.domain.electronicmoney.model.response.EmoneyCardInfo;
import id.dana.domain.electronicmoney.model.response.EmoneyGenerateTransId;
import id.dana.domain.electronicmoney.model.response.EmoneyReversal;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/electronicmoney/network/response/EmoneyCardInfoResponse;", "Lid/dana/domain/electronicmoney/model/response/EmoneyCardInfo;", "getAuthRequestContext", "(Lid/dana/data/electronicmoney/network/response/EmoneyCardInfoResponse;)Lid/dana/domain/electronicmoney/model/response/EmoneyCardInfo;", "Lid/dana/data/electronicmoney/network/response/ElectronicMoneyGetBizIdResponse;", "Lid/dana/domain/electronicmoney/model/response/EmoneyGenerateTransId;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/electronicmoney/network/response/ElectronicMoneyGetBizIdResponse;)Lid/dana/domain/electronicmoney/model/response/EmoneyGenerateTransId;", "Lid/dana/data/electronicmoney/network/response/EmoneyReversalResponse;", "Lid/dana/domain/electronicmoney/model/response/EmoneyReversal;", "PlaceComponentResult", "(Lid/dana/data/electronicmoney/network/response/EmoneyReversalResponse;)Lid/dana/domain/electronicmoney/model/response/EmoneyReversal;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ElectronicMoneyExtensionKt {
    public static final EmoneyGenerateTransId KClassImpl$Data$declaredNonStaticMembers$2(ElectronicMoneyGetBizIdResponse electronicMoneyGetBizIdResponse) {
        Intrinsics.checkNotNullParameter(electronicMoneyGetBizIdResponse, "");
        return new EmoneyGenerateTransId(electronicMoneyGetBizIdResponse.getBizId());
    }

    public static final EmoneyCardInfo getAuthRequestContext(EmoneyCardInfoResponse emoneyCardInfoResponse) {
        Intrinsics.checkNotNullParameter(emoneyCardInfoResponse, "");
        boolean z = emoneyCardInfoResponse.success;
        String str = emoneyCardInfoResponse.errorCode;
        EmoneyDataEntity data = emoneyCardInfoResponse.getData();
        String apiVersion = data != null ? data.getApiVersion() : null;
        String str2 = apiVersion == null ? "" : apiVersion;
        EmoneyDataEntity data2 = emoneyCardInfoResponse.getData();
        String approvalCode = data2 != null ? data2.getApprovalCode() : null;
        String str3 = approvalCode == null ? "" : approvalCode;
        EmoneyDataEntity data3 = emoneyCardInfoResponse.getData();
        String message = data3 != null ? data3.getMessage() : null;
        String str4 = message == null ? "" : message;
        EmoneyDataEntity data4 = emoneyCardInfoResponse.getData();
        String status = data4 != null ? data4.getStatus() : null;
        String str5 = status == null ? "" : status;
        EmoneyDataEntity data5 = emoneyCardInfoResponse.getData();
        String pendingTopup = data5 != null ? data5.getPendingTopup() : null;
        String str6 = pendingTopup == null ? "" : pendingTopup;
        EmoneyDataEntity data6 = emoneyCardInfoResponse.getData();
        String session = data6 != null ? data6.getSession() : null;
        String str7 = session == null ? "" : session;
        Pair[] pairArr = new Pair[9];
        EmoneyDataEntity data7 = emoneyCardInfoResponse.getData();
        String apiVersion2 = data7 != null ? data7.getApiVersion() : null;
        if (apiVersion2 == null) {
            apiVersion2 = "";
        }
        pairArr[0] = TuplesKt.to("apiVersion", apiVersion2);
        EmoneyDataEntity data8 = emoneyCardInfoResponse.getData();
        String approvalCode2 = data8 != null ? data8.getApprovalCode() : null;
        if (approvalCode2 == null) {
            approvalCode2 = "";
        }
        pairArr[1] = TuplesKt.to("approvalCode", approvalCode2);
        EmoneyDataEntity data9 = emoneyCardInfoResponse.getData();
        String message2 = data9 != null ? data9.getMessage() : null;
        if (message2 == null) {
            message2 = "";
        }
        pairArr[2] = TuplesKt.to("message", message2);
        EmoneyDataEntity data10 = emoneyCardInfoResponse.getData();
        String status2 = data10 != null ? data10.getStatus() : null;
        if (status2 == null) {
            status2 = "";
        }
        pairArr[3] = TuplesKt.to("status", status2);
        EmoneyDataEntity data11 = emoneyCardInfoResponse.getData();
        String pendingTopup2 = data11 != null ? data11.getPendingTopup() : null;
        if (pendingTopup2 == null) {
            pendingTopup2 = "";
        }
        pairArr[4] = TuplesKt.to("pendingTopup", pendingTopup2);
        EmoneyDataEntity data12 = emoneyCardInfoResponse.getData();
        String session2 = data12 != null ? data12.getSession() : null;
        if (session2 == null) {
            session2 = "";
        }
        pairArr[5] = TuplesKt.to("session", session2);
        EmoneyDataEntity data13 = emoneyCardInfoResponse.getData();
        String lastBalance = data13 != null ? data13.getLastBalance() : null;
        if (lastBalance == null) {
            lastBalance = "";
        }
        pairArr[6] = TuplesKt.to("lastBalance", lastBalance);
        EmoneyDataEntity data14 = emoneyCardInfoResponse.getData();
        String responseFromSam = data14 != null ? data14.getResponseFromSam() : null;
        if (responseFromSam == null) {
            responseFromSam = "";
        }
        pairArr[7] = TuplesKt.to("responseFromSam", responseFromSam);
        EmoneyDataEntity data15 = emoneyCardInfoResponse.getData();
        String cardNumber = data15 != null ? data15.getCardNumber() : null;
        pairArr[8] = TuplesKt.to("cardNumber", cardNumber != null ? cardNumber : "");
        return new EmoneyCardInfo(z, str, str2, str3, str4, str5, str6, str7, MapsKt.mutableMapOf(pairArr));
    }

    public static final EmoneyReversal PlaceComponentResult(EmoneyReversalResponse emoneyReversalResponse) {
        Intrinsics.checkNotNullParameter(emoneyReversalResponse, "");
        boolean z = emoneyReversalResponse.success;
        String str = emoneyReversalResponse.errorCode;
        Intrinsics.checkNotNullExpressionValue(str, "");
        String str2 = emoneyReversalResponse.getData().get("approvalCode");
        String str3 = str2 == null ? "" : str2;
        String str4 = emoneyReversalResponse.getData().get("message");
        return new EmoneyReversal(z, str, str3, str4 == null ? "" : str4, emoneyReversalResponse.getData());
    }
}
