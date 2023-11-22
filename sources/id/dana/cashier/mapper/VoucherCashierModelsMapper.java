package id.dana.cashier.mapper;

import id.dana.cashier.domain.model.CouponInfo;
import id.dana.cashier.domain.model.VoucherCashierInfo;
import id.dana.cashier.model.CouponCashierModel;
import id.dana.cashier.model.VoucherCashierModel;
import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.sendmoney.model.CouponPayMethodInfo;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.sendmoney.mapper.CouponPayMethodInfoListModelMapper;
import id.dana.sendmoney.model.CouponPayMethodInfoModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/mapper/VoucherCashierModelsMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/cashier/domain/model/VoucherCashierInfo;", "Lid/dana/cashier/model/VoucherCashierModel;", "Lid/dana/sendmoney/mapper/CouponPayMethodInfoListModelMapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/mapper/CouponPayMethodInfoListModelMapper;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/sendmoney/mapper/CouponPayMethodInfoListModelMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VoucherCashierModelsMapper extends BaseMapper<List<? extends VoucherCashierInfo>, List<? extends VoucherCashierModel>> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CouponPayMethodInfoListModelMapper KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends VoucherCashierModel> map(List<? extends VoucherCashierInfo> list) {
        MoneyViewModel moneyViewModel;
        MoneyViewModel moneyViewModel2;
        List<? extends VoucherCashierInfo> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "");
        List<? extends VoucherCashierInfo> list3 = list2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        for (VoucherCashierInfo voucherCashierInfo : list3) {
            Long activeTime = voucherCashierInfo.getActiveTime();
            MoneyView availableAmount = voucherCashierInfo.getAvailableAmount();
            if (availableAmount != null) {
                MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
                moneyViewModel = MoneyViewModel.Companion.PlaceComponentResult(availableAmount);
            } else {
                moneyViewModel = null;
            }
            CouponInfo couponAbility = voucherCashierInfo.getCouponAbility();
            CouponCashierModel couponCashierModel = couponAbility != null ? new CouponCashierModel(couponAbility.getCanFundbackBack(), couponAbility.getCanLuckMoneyPayment(), couponAbility.getCanPartUse(), couponAbility.getCanRefundBack(), couponAbility.getCanRegularPayment(), couponAbility.getCanSuperpose(), couponAbility.getCanTransfer(), couponAbility.getCanWithDraw()) : null;
            String couponId = voucherCashierInfo.getCouponId();
            String couponName = voucherCashierInfo.getCouponName();
            List<CouponPayMethodInfo> couponPayMethodInfos = voucherCashierInfo.getCouponPayMethodInfos();
            List<CouponPayMethodInfoModel> apply = couponPayMethodInfos != null ? this.KClassImpl$Data$declaredNonStaticMembers$2.apply(couponPayMethodInfos) : null;
            Long createdTime = voucherCashierInfo.getCreatedTime();
            Boolean directDiscountType = voucherCashierInfo.getDirectDiscountType();
            Long expiryTime = voucherCashierInfo.getExpiryTime();
            Long extendTime = voucherCashierInfo.getExtendTime();
            String iconUrl = voucherCashierInfo.getIconUrl();
            Long modifiedTime = voucherCashierInfo.getModifiedTime();
            MoneyView totalAmount = voucherCashierInfo.getTotalAmount();
            if (totalAmount != null) {
                MoneyViewModel.Companion companion2 = MoneyViewModel.INSTANCE;
                moneyViewModel2 = MoneyViewModel.Companion.PlaceComponentResult(totalAmount);
            } else {
                moneyViewModel2 = null;
            }
            arrayList.add(new VoucherCashierModel(activeTime, moneyViewModel, couponCashierModel, couponId, couponName, apply, createdTime, directDiscountType, expiryTime, extendTime, iconUrl, modifiedTime, moneyViewModel2, voucherCashierInfo.getDescription(), false, false, voucherCashierInfo.getTnc(), null, 180224, null));
        }
        return arrayList;
    }

    @Inject
    public VoucherCashierModelsMapper(CouponPayMethodInfoListModelMapper couponPayMethodInfoListModelMapper) {
        Intrinsics.checkNotNullParameter(couponPayMethodInfoListModelMapper, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = couponPayMethodInfoListModelMapper;
    }
}
