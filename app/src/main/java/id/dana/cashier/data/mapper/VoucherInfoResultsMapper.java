package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.result.CouponAbilityInfoResult;
import id.dana.cashier.data.repository.source.network.result.VoucherInfoResult;
import id.dana.cashier.domain.model.CouponInfo;
import id.dana.cashier.domain.model.VoucherCashierInfo;
import id.dana.data.base.BaseMapper;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.data.sendmoney.mapper.CouponPayMethodInfoResultMapper;
import id.dana.data.sendmoney.model.CouponPayMethodInfoResult;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.sendmoney.model.CouponPayMethodInfo;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u000f\u001a\u001a\u0012\b\u0012\u0006*\u00020\u000e0\u000e*\f\u0012\b\u0012\u0006*\u00020\u000e0\u000e0\u00020\r*\b\u0012\u0004\u0012\u00020\f0\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0007J\u0013\u0010\u0010\u001a\u00020\u0004*\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/cashier/data/mapper/VoucherInfoResultsMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/cashier/data/repository/source/network/result/VoucherInfoResult;", "Lid/dana/cashier/domain/model/VoucherCashierInfo;", "oldItem", "map", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/cashier/data/repository/source/network/result/CouponAbilityInfoResult;", "Lid/dana/cashier/domain/model/CouponInfo;", "toCouponInfo", "(Lid/dana/cashier/data/repository/source/network/result/CouponAbilityInfoResult;)Lid/dana/cashier/domain/model/CouponInfo;", "Lid/dana/data/sendmoney/model/CouponPayMethodInfoResult;", "", "Lid/dana/domain/sendmoney/model/CouponPayMethodInfo;", "toListCouponPayMethodInfos", "toVoucherCashierInfo", "(Lid/dana/cashier/data/repository/source/network/result/VoucherInfoResult;)Lid/dana/cashier/domain/model/VoucherCashierInfo;", "Lid/dana/data/sendmoney/mapper/CouponPayMethodInfoResultMapper;", "couponPayMethodInfoResultMapper", "Lid/dana/data/sendmoney/mapper/CouponPayMethodInfoResultMapper;", "<init>", "(Lid/dana/data/sendmoney/mapper/CouponPayMethodInfoResultMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VoucherInfoResultsMapper extends BaseMapper<List<? extends VoucherInfoResult>, List<? extends VoucherCashierInfo>> {
    private final CouponPayMethodInfoResultMapper couponPayMethodInfoResultMapper;

    @Override // id.dana.data.base.BaseMapper
    public final /* bridge */ /* synthetic */ List<? extends VoucherCashierInfo> map(List<? extends VoucherInfoResult> list) {
        return map2((List<VoucherInfoResult>) list);
    }

    @Inject
    public VoucherInfoResultsMapper(CouponPayMethodInfoResultMapper couponPayMethodInfoResultMapper) {
        Intrinsics.checkNotNullParameter(couponPayMethodInfoResultMapper, "");
        this.couponPayMethodInfoResultMapper = couponPayMethodInfoResultMapper;
    }

    /* renamed from: map  reason: avoid collision after fix types in other method */
    protected final List<VoucherCashierInfo> map2(List<VoucherInfoResult> oldItem) {
        if (oldItem == null) {
            return CollectionsKt.emptyList();
        }
        List<VoucherInfoResult> list = oldItem;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toVoucherCashierInfo((VoucherInfoResult) it.next()));
        }
        return arrayList;
    }

    private final VoucherCashierInfo toVoucherCashierInfo(VoucherInfoResult voucherInfoResult) {
        Long activeTime = voucherInfoResult.getActiveTime();
        MoneyViewEntity availableAmount = voucherInfoResult.getAvailableAmount();
        MoneyView moneyView = availableAmount != null ? MoneyViewEntityMapperKt.toMoneyView(availableAmount) : null;
        CouponAbilityInfoResult couponAbility = voucherInfoResult.getCouponAbility();
        CouponInfo couponInfo = couponAbility != null ? toCouponInfo(couponAbility) : null;
        String couponId = voucherInfoResult.getCouponId();
        String couponName = voucherInfoResult.getCouponName();
        List<CouponPayMethodInfoResult> couponPayMethodInfos = voucherInfoResult.getCouponPayMethodInfos();
        List<CouponPayMethodInfo> listCouponPayMethodInfos = couponPayMethodInfos != null ? toListCouponPayMethodInfos(couponPayMethodInfos) : null;
        Long createdTime = voucherInfoResult.getCreatedTime();
        Boolean directDiscountType = voucherInfoResult.getDirectDiscountType();
        Long expiryTime = voucherInfoResult.getExpiryTime();
        Long extendTime = voucherInfoResult.getExtendTime();
        String iconUrl = voucherInfoResult.getIconUrl();
        Long modifiedTime = voucherInfoResult.getModifiedTime();
        MoneyViewEntity totalAmount = voucherInfoResult.getTotalAmount();
        return new VoucherCashierInfo(activeTime, moneyView, couponInfo, couponId, couponName, listCouponPayMethodInfos, createdTime, directDiscountType, expiryTime, extendTime, iconUrl, modifiedTime, totalAmount != null ? MoneyViewEntityMapperKt.toMoneyView(totalAmount) : null, voucherInfoResult.getDescription(), voucherInfoResult.getTnc());
    }

    private final CouponInfo toCouponInfo(CouponAbilityInfoResult couponAbilityInfoResult) {
        return new CouponInfo(couponAbilityInfoResult.getCanFundbackBack(), couponAbilityInfoResult.getCanLuckMoneyPayment(), couponAbilityInfoResult.getCanPartUse(), couponAbilityInfoResult.getCanRefundBack(), couponAbilityInfoResult.getCanRegularPayment(), couponAbilityInfoResult.getCanSuperpose(), couponAbilityInfoResult.getCanTransfer(), couponAbilityInfoResult.getCanWithDraw());
    }

    private final List<CouponPayMethodInfo> toListCouponPayMethodInfos(List<? extends CouponPayMethodInfoResult> list) {
        return this.couponPayMethodInfoResultMapper.apply(list);
    }
}
