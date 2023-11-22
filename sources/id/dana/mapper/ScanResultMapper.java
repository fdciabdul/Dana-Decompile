package id.dana.mapper;

import id.dana.base.BaseResponseMapper;
import id.dana.domain.qrbarcode.DecodeQrBizType;
import id.dana.domain.qrbarcode.DecodedScan;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import id.dana.model.BizInfoBankModel;
import id.dana.model.BizInfoModel;
import id.dana.model.ScanModel;
import java.util.Map;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class ScanResultMapper {
    private BaseResponseMapper PlaceComponentResult;

    @Inject
    public ScanResultMapper(BaseResponseMapper baseResponseMapper) {
        this.PlaceComponentResult = baseResponseMapper;
    }

    public final ScanModel getAuthRequestContext(DecodedScan decodedScan) {
        ScanModel scanModel = new ScanModel();
        if (decodedScan != null) {
            BaseResponseMapper.MyBillsEntityDataFactory(scanModel, decodedScan);
            scanModel.setMobileNumber(decodedScan.getMobileNumber());
            scanModel.setBizType(decodedScan.getBizType());
            scanModel.setBizNo(decodedScan.getBizNo());
            scanModel.setReceiverId(decodedScan.getReceiverId());
            scanModel.setNickname(decodedScan.getNickname());
            scanModel.setLoginId(decodedScan.getLoginId());
            scanModel.setBizInfo(KClassImpl$Data$declaredNonStaticMembers$2(decodedScan.getBizInfo(), decodedScan.getBizType()));
            scanModel.setAvatarUrl(decodedScan.getAvatarUrl());
            scanModel.setRedirectUrl(decodedScan.getRedirectUrl());
            scanModel.setAcDecodeConfig(decodedScan.getAcDecodeConfig());
        }
        return scanModel;
    }

    private static BizInfoModel KClassImpl$Data$declaredNonStaticMembers$2(Map<String, String> map, String str) {
        BizInfoBankModel PlaceComponentResult;
        BizInfoModel bizInfoModel = new BizInfoModel(str);
        if (map != null) {
            bizInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = map.get("merchantId");
            bizInfoModel.PrepareContext = map.get("merchantName");
            bizInfoModel.GetContactSyncConfig = map.get(DecodedScanBizInfoKey.BUSINESS_TYPE);
            bizInfoModel.DatabaseTableConfigUtil = map.get(DecodedScanBizInfoKey.LOGO_URL);
            bizInfoModel.scheduleImpl = map.get("amount");
            bizInfoModel.initRecordTimeStamp = map.get(DecodedScanBizInfoKey.COMMENT);
            bizInfoModel.isLayoutRequested = map.get("url");
            bizInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = map.get(DecodedScanBizInfoKey.PAYERS);
            bizInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = map.get(DecodedScanBizInfoKey.PAYEE_INDEX);
            bizInfoModel.newProxyInstance = map.get(DecodedScanBizInfoKey.PAYER_INDEX);
            bizInfoModel.FragmentBottomSheetPaymentSettingBinding = map.get(DecodedScanBizInfoKey.SPLIT_BILL_ID);
            bizInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda4 = map.get("status");
            if (MyBillsEntityDataFactory(str)) {
                PlaceComponentResult = BizInfoBankModel.Companion.PlaceComponentResult(bizInfoModel, map);
                return PlaceComponentResult;
            }
            return bizInfoModel;
        }
        return bizInfoModel;
    }

    private static boolean MyBillsEntityDataFactory(String str) {
        return DecodeQrBizType.USER_BANK_ACCOUNT_CODE.equals(str) || DecodeQrBizType.TRANSFER_BANK_ACCOUNT_CODE.equals(str);
    }
}
