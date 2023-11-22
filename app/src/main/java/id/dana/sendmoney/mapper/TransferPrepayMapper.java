package id.dana.sendmoney.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.sendmoney.model.CouponChannelInfo;
import id.dana.domain.sendmoney.model.TransferPrepay;
import id.dana.sendmoney.model.VoucherModel;
import java.util.ArrayList;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class TransferPrepayMapper extends BaseMapper<TransferPrepay, ArrayList<VoucherModel>> {
    private final CurrencyAmountModelMapper BuiltInFictitiousFunctionClassFactory;
    private final CouponPayMethodInfoListModelMapper PlaceComponentResult;

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ ArrayList<VoucherModel> map(TransferPrepay transferPrepay) {
        TransferPrepay transferPrepay2 = transferPrepay;
        if (transferPrepay2 != null && transferPrepay2.getCouponChannelInfo() != null) {
            ArrayList<VoucherModel> arrayList = new ArrayList<>();
            for (CouponChannelInfo couponChannelInfo : transferPrepay2.getCouponChannelInfo()) {
                VoucherModel voucherModel = new VoucherModel();
                voucherModel.MyBillsEntityDataFactory = couponChannelInfo.getCouponId();
                voucherModel.lookAheadTest = couponChannelInfo.getCouponName();
                voucherModel.KClassImpl$Data$declaredNonStaticMembers$2 = CurrencyAmountModelMapper.getAuthRequestContext(couponChannelInfo.getAvailableAmount());
                voucherModel.DatabaseTableConfigUtil = CurrencyAmountModelMapper.getAuthRequestContext(couponChannelInfo.getTotalAmount());
                voucherModel.moveToNextValue = couponChannelInfo.getDescription();
                voucherModel.getAuthRequestContext = couponChannelInfo.getActiveTime();
                voucherModel.getErrorConfigVersion = couponChannelInfo.getExpiryTime();
                voucherModel.GetContactSyncConfig = couponChannelInfo.getExtendTime();
                voucherModel.scheduleImpl = couponChannelInfo.getCreatedTime();
                voucherModel.NetworkUserEntityData$$ExternalSyntheticLambda2 = couponChannelInfo.getModifiedTime();
                voucherModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.PlaceComponentResult.apply(couponChannelInfo.getCouponPayMethodInfos());
                arrayList.add(voucherModel);
            }
            return arrayList;
        }
        return new ArrayList<>();
    }

    @Inject
    public TransferPrepayMapper(CurrencyAmountModelMapper currencyAmountModelMapper, CouponPayMethodInfoListModelMapper couponPayMethodInfoListModelMapper) {
        this.BuiltInFictitiousFunctionClassFactory = currencyAmountModelMapper;
        this.PlaceComponentResult = couponPayMethodInfoListModelMapper;
    }
}
