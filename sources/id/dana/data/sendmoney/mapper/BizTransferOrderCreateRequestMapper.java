package id.dana.data.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.sendmoney.repository.source.network.request.BizTransferOrderCreateRequest;
import id.dana.data.sendmoney.repository.source.network.request.TransferParticipantDTO;
import id.dana.domain.sendmoney.model.SendMoneyConfirmParam;
import id.dana.domain.sendmoney.model.TransferParticipant;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/sendmoney/mapper/BizTransferOrderCreateRequestMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/sendmoney/model/SendMoneyConfirmParam;", "Lid/dana/data/sendmoney/repository/source/network/request/BizTransferOrderCreateRequest;", "Lid/dana/domain/sendmoney/model/TransferParticipant;", "payeeInfo", "Lid/dana/data/sendmoney/repository/source/network/request/TransferParticipantDTO;", "getPayeeInfo", "(Lid/dana/domain/sendmoney/model/TransferParticipant;)Lid/dana/data/sendmoney/repository/source/network/request/TransferParticipantDTO;", "oldItem", "map", "(Lid/dana/domain/sendmoney/model/SendMoneyConfirmParam;)Lid/dana/data/sendmoney/repository/source/network/request/BizTransferOrderCreateRequest;", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "<init>", "(Lid/dana/data/config/DeviceInformationProvider;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BizTransferOrderCreateRequestMapper extends BaseMapper<SendMoneyConfirmParam, BizTransferOrderCreateRequest> {
    private final DeviceInformationProvider deviceInformationProvider;

    @Inject
    public BizTransferOrderCreateRequestMapper(DeviceInformationProvider deviceInformationProvider) {
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        this.deviceInformationProvider = deviceInformationProvider;
    }

    @Override // id.dana.data.base.BaseMapper
    public final BizTransferOrderCreateRequest map(SendMoneyConfirmParam oldItem) {
        List list = null;
        String amount = oldItem != null ? oldItem.getAmount() : null;
        String fundType = oldItem != null ? oldItem.getFundType() : null;
        String transferMethod = oldItem != null ? oldItem.getTransferMethod() : null;
        TransferParticipantDTO payeeInfo = getPayeeInfo(oldItem != null ? oldItem.getPayeeInfo() : null);
        String deviceUUID = this.deviceInformationProvider.getDeviceUUID();
        String remarks = oldItem != null ? oldItem.getRemarks() : null;
        String remarks2 = oldItem != null ? oldItem.getRemarks() : null;
        String remarks3 = oldItem != null ? oldItem.getRemarks() : null;
        String originInstId = oldItem != null ? oldItem.getOriginInstId() : null;
        String transferScenario = oldItem != null ? oldItem.getTransferScenario() : null;
        if ((oldItem != null ? oldItem.getCouponId() : null) != null) {
            String couponId = oldItem.getCouponId();
            if (couponId == null) {
                couponId = "";
            }
            list = CollectionsKt.listOf(couponId);
        }
        return new BizTransferOrderCreateRequest(amount, fundType, transferMethod, payeeInfo, deviceUUID, remarks, remarks3, remarks2, originInstId, transferScenario, list, oldItem != null ? oldItem.isShareActivity() : false);
    }

    private final TransferParticipantDTO getPayeeInfo(TransferParticipant payeeInfo) {
        if (payeeInfo != null) {
            TransferParticipantDTO transferParticipantDTO = new TransferParticipantDTO();
            String bankAccountIndexNo = payeeInfo.getBankAccountIndexNo();
            if (bankAccountIndexNo != null) {
                Intrinsics.checkNotNullExpressionValue(bankAccountIndexNo, "");
                transferParticipantDTO.bankAccountIndexNo = bankAccountIndexNo;
            }
            String contactName = payeeInfo.getContactName();
            if (contactName != null) {
                Intrinsics.checkNotNullExpressionValue(contactName, "");
                transferParticipantDTO.contactName = contactName;
            }
            String dateOfBirth = payeeInfo.getDateOfBirth();
            if (dateOfBirth != null) {
                Intrinsics.checkNotNullExpressionValue(dateOfBirth, "");
                transferParticipantDTO.dateOfBirth = dateOfBirth;
            }
            String loginId = payeeInfo.getLoginId();
            if (loginId != null) {
                Intrinsics.checkNotNullExpressionValue(loginId, "");
                transferParticipantDTO.loginId = loginId;
            }
            String nickname = payeeInfo.getNickname();
            if (nickname != null) {
                Intrinsics.checkNotNullExpressionValue(nickname, "");
                transferParticipantDTO.nickname = nickname;
            }
            String regId = payeeInfo.getRegId();
            if (regId != null) {
                Intrinsics.checkNotNullExpressionValue(regId, "");
                transferParticipantDTO.regId = regId;
            }
            String userId = payeeInfo.getUserId();
            if (userId != null) {
                Intrinsics.checkNotNullExpressionValue(userId, "");
                transferParticipantDTO.userId = userId;
                return transferParticipantDTO;
            }
            return transferParticipantDTO;
        }
        return null;
    }
}
