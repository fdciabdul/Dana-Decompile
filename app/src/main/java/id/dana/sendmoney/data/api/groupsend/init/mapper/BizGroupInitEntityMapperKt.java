package id.dana.sendmoney.data.api.groupsend.init.mapper;

import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.sendmoney.data.api.groupsend.init.model.PayeeUserInfoEntity;
import id.dana.sendmoney.data.api.groupsend.init.model.request.BizGroupTransferInitRequest;
import id.dana.sendmoney.data.api.groupsend.init.model.response.BizGroupTransferInitResult;
import id.dana.sendmoney.domain.groupsend.interactor.InitSendMoneyGroup;
import id.dana.sendmoney.domain.groupsend.model.init.PayeeUserInfo;
import id.dana.sendmoney.domain.groupsend.model.init.SendMoneyGroupInit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0001\u001a\u00020\u0000*\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0003*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/core/ui/model/CurrencyAmountModel;", "getGroupLimit", "(Lid/dana/core/ui/model/CurrencyAmountModel;)Lid/dana/core/ui/model/CurrencyAmountModel;", "", "Lid/dana/sendmoney/data/api/groupsend/init/model/PayeeUserInfoEntity;", "Lid/dana/sendmoney/domain/groupsend/model/init/PayeeUserInfo;", "getPayeeUserInfo", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/sendmoney/domain/groupsend/interactor/InitSendMoneyGroup$Param;", "Lid/dana/sendmoney/data/api/groupsend/init/model/request/BizGroupTransferInitRequest;", "toBizGroupTransferInitRequest", "(Lid/dana/sendmoney/domain/groupsend/interactor/InitSendMoneyGroup$Param;)Lid/dana/sendmoney/data/api/groupsend/init/model/request/BizGroupTransferInitRequest;", "Lid/dana/sendmoney/data/api/groupsend/init/model/response/BizGroupTransferInitResult;", "Lid/dana/sendmoney/domain/groupsend/model/init/SendMoneyGroupInit;", "toSendMoneyGroupInit", "(Lid/dana/sendmoney/data/api/groupsend/init/model/response/BizGroupTransferInitResult;)Lid/dana/sendmoney/domain/groupsend/model/init/SendMoneyGroupInit;", "toTransferUserInfoInit", "(Lid/dana/sendmoney/data/api/groupsend/init/model/PayeeUserInfoEntity;)Lid/dana/sendmoney/domain/groupsend/model/init/PayeeUserInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BizGroupInitEntityMapperKt {
    public static final SendMoneyGroupInit toSendMoneyGroupInit(BizGroupTransferInitResult bizGroupTransferInitResult) {
        Intrinsics.checkNotNullParameter(bizGroupTransferInitResult, "");
        return new SendMoneyGroupInit(getPayeeUserInfo(bizGroupTransferInitResult.getPayeeUserInfos()), bizGroupTransferInitResult.success, getGroupLimit(bizGroupTransferInitResult.getPayeeMinLimit()), getGroupLimit(bizGroupTransferInitResult.getPayeeMaxLimit()), getGroupLimit(bizGroupTransferInitResult.getTotalLimit()));
    }

    public static final PayeeUserInfo toTransferUserInfoInit(PayeeUserInfoEntity payeeUserInfoEntity) {
        Intrinsics.checkNotNullParameter(payeeUserInfoEntity, "");
        return new PayeeUserInfo(payeeUserInfoEntity.getUserId(), payeeUserInfoEntity.getMaskedLoginId(), payeeUserInfoEntity.getLoginId(), payeeUserInfoEntity.getKycLevel(), payeeUserInfoEntity.getInternalKycLevel(), payeeUserInfoEntity.getNickname(), payeeUserInfoEntity.getMaskedNickname(), payeeUserInfoEntity.getCertified(), payeeUserInfoEntity.getAvatar());
    }

    private static final List<PayeeUserInfo> getPayeeUserInfo(List<PayeeUserInfoEntity> list) {
        if (list != null) {
            List<PayeeUserInfoEntity> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(toTransferUserInfoInit((PayeeUserInfoEntity) it.next()));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private static final CurrencyAmountModel getGroupLimit(CurrencyAmountModel currencyAmountModel) {
        if (currencyAmountModel == null) {
            return new CurrencyAmountModel("", "", false, 4, null);
        }
        return currencyAmountModel;
    }

    public static final BizGroupTransferInitRequest toBizGroupTransferInitRequest(InitSendMoneyGroup.Param param) {
        Intrinsics.checkNotNullParameter(param, "");
        return new BizGroupTransferInitRequest(param.MyBillsEntityDataFactory, param.PlaceComponentResult, param.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
