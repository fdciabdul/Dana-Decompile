package id.dana.sendmoney.ui.globalsend.form.mapper;

import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.sendmoney.domain.globalsend.model.init.CurrencyRate;
import id.dana.sendmoney.domain.globalsend.model.init.GlobalTransferInitResult;
import id.dana.sendmoney.domain.globalsend.model.init.SubTransferMethodInfo;
import id.dana.sendmoney.domain.globalsend.model.init.TransferUserInfo;
import id.dana.sendmoney.ui.globalsend.form.model.CurrencyRateModel;
import id.dana.sendmoney.ui.globalsend.form.model.GlobalTransferInitModel;
import id.dana.sendmoney.ui.globalsend.form.model.SubTransferMethodInfoModel;
import id.dana.sendmoney.ui.globalsend.form.model.TransferUserInfoModel;
import id.dana.sendmoney.ui.groupsend.summary.mapper.GroupSendSummaryModelMapperKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitResult;", "Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;", "getAuthRequestContext", "(Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitResult;)Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;", "Lid/dana/sendmoney/domain/globalsend/model/init/TransferUserInfo;", "Lid/dana/sendmoney/ui/globalsend/form/model/TransferUserInfoModel;", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/domain/globalsend/model/init/TransferUserInfo;)Lid/dana/sendmoney/ui/globalsend/form/model/TransferUserInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalTransferInitModelMapperKt {
    public static final GlobalTransferInitModel getAuthRequestContext(GlobalTransferInitResult globalTransferInitResult) {
        Intrinsics.checkNotNullParameter(globalTransferInitResult, "");
        CurrencyAmountModel MyBillsEntityDataFactory = GroupSendSummaryModelMapperKt.MyBillsEntityDataFactory(globalTransferInitResult.PlaceComponentResult);
        CurrencyAmountModel MyBillsEntityDataFactory2 = GroupSendSummaryModelMapperKt.MyBillsEntityDataFactory(globalTransferInitResult.getAuthRequestContext);
        CurrencyAmountModel MyBillsEntityDataFactory3 = GroupSendSummaryModelMapperKt.MyBillsEntityDataFactory(globalTransferInitResult.BuiltInFictitiousFunctionClassFactory);
        List<SubTransferMethodInfo> list = globalTransferInitResult.lookAheadTest;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (SubTransferMethodInfo subTransferMethodInfo : list) {
            CurrencyRate currencyRate = subTransferMethodInfo.moveToNextValue;
            arrayList.add(new SubTransferMethodInfoModel(new CurrencyRateModel(GroupSendSummaryModelMapperKt.MyBillsEntityDataFactory(currencyRate.getAuthRequestContext), GroupSendSummaryModelMapperKt.MyBillsEntityDataFactory(currencyRate.MyBillsEntityDataFactory), currencyRate.KClassImpl$Data$declaredNonStaticMembers$2, currencyRate.PlaceComponentResult), subTransferMethodInfo.NetworkUserEntityData$$ExternalSyntheticLambda0, subTransferMethodInfo.PlaceComponentResult, subTransferMethodInfo.MyBillsEntityDataFactory, subTransferMethodInfo.getAuthRequestContext, subTransferMethodInfo.BuiltInFictitiousFunctionClassFactory, subTransferMethodInfo.lookAheadTest, GroupSendSummaryModelMapperKt.MyBillsEntityDataFactory(subTransferMethodInfo.scheduleImpl), GroupSendSummaryModelMapperKt.MyBillsEntityDataFactory(subTransferMethodInfo.getErrorConfigVersion), subTransferMethodInfo.getKClassImpl$Data$declaredNonStaticMembers$2()));
        }
        return new GlobalTransferInitModel(MyBillsEntityDataFactory, MyBillsEntityDataFactory2, MyBillsEntityDataFactory3, arrayList, MyBillsEntityDataFactory(globalTransferInitResult.KClassImpl$Data$declaredNonStaticMembers$2), MyBillsEntityDataFactory(globalTransferInitResult.MyBillsEntityDataFactory));
    }

    private static final TransferUserInfoModel MyBillsEntityDataFactory(TransferUserInfo transferUserInfo) {
        return new TransferUserInfoModel(transferUserInfo.NetworkUserEntityData$$ExternalSyntheticLambda8, transferUserInfo.moveToNextValue, transferUserInfo.NetworkUserEntityData$$ExternalSyntheticLambda1, transferUserInfo.NetworkUserEntityData$$ExternalSyntheticLambda7, transferUserInfo.NetworkUserEntityData$$ExternalSyntheticLambda0, transferUserInfo.lookAheadTest, transferUserInfo.getMyBillsEntityDataFactory(), GroupSendSummaryModelMapperKt.MyBillsEntityDataFactory(transferUserInfo.BuiltInFictitiousFunctionClassFactory), GroupSendSummaryModelMapperKt.MyBillsEntityDataFactory(transferUserInfo.initRecordTimeStamp), GroupSendSummaryModelMapperKt.MyBillsEntityDataFactory(transferUserInfo.GetContactSyncConfig), GroupSendSummaryModelMapperKt.MyBillsEntityDataFactory(transferUserInfo.NetworkUserEntityData$$ExternalSyntheticLambda2), transferUserInfo.PlaceComponentResult, transferUserInfo.DatabaseTableConfigUtil, transferUserInfo.PrepareContext, transferUserInfo.getAuthRequestContext, transferUserInfo.scheduleImpl, transferUserInfo.getErrorConfigVersion, transferUserInfo.getNewProxyInstance(), transferUserInfo.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
