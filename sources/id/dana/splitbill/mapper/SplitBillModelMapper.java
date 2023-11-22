package id.dana.splitbill.mapper;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import id.dana.data.base.BaseMapper;
import id.dana.data.storage.Serializer;
import id.dana.model.BizInfoModel;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.ScanModel;
import id.dana.splitbill.model.PayerModel;
import id.dana.splitbill.model.QrSplitBillPayerModel;
import id.dana.splitbill.model.SplitBillModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class SplitBillModelMapper extends BaseMapper<ScanModel, SplitBillModel> {
    private Serializer MyBillsEntityDataFactory = new Serializer();

    @Override // id.dana.data.base.BaseMapper
    public /* synthetic */ SplitBillModel map(ScanModel scanModel) {
        ScanModel scanModel2 = scanModel;
        if (scanModel2 == null || scanModel2.getBizInfo() == null) {
            return null;
        }
        BizInfoModel bizInfo = scanModel2.getBizInfo();
        SplitBillModel splitBillModel = new SplitBillModel();
        splitBillModel.moveToNextValue = bizInfo.NetworkUserEntityData$$ExternalSyntheticLambda4;
        splitBillModel.scheduleImpl = bizInfo.FragmentBottomSheetPaymentSettingBinding;
        splitBillModel.BuiltInFictitiousFunctionClassFactory = bizInfo.initRecordTimeStamp;
        splitBillModel.lookAheadTest = new CurrencyAmountModel(bizInfo.scheduleImpl);
        JSONArray jSONArray = new JSONArray(JSON.parseArray(bizInfo.NetworkUserEntityData$$ExternalSyntheticLambda7));
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.size(); i++) {
            QrSplitBillPayerModel qrSplitBillPayerModel = (QrSplitBillPayerModel) this.MyBillsEntityDataFactory.deserialize(jSONArray.getString(i), QrSplitBillPayerModel.class);
            arrayList.add(new PayerModel(qrSplitBillPayerModel.getAvatarUrl(), new CurrencyAmountModel(qrSplitBillPayerModel.getFundAmount()), qrSplitBillPayerModel.getLoginId(), qrSplitBillPayerModel.getName(), qrSplitBillPayerModel.getUserId(), qrSplitBillPayerModel.getStatus()));
        }
        splitBillModel.PlaceComponentResult = arrayList;
        List<PayerModel> list = splitBillModel.PlaceComponentResult;
        if (!TextUtils.isEmpty(bizInfo.NetworkUserEntityData$$ExternalSyntheticLambda8)) {
            int parseInt = Integer.parseInt(bizInfo.NetworkUserEntityData$$ExternalSyntheticLambda8);
            if (list.size() > parseInt) {
                splitBillModel.getAuthRequestContext = parseInt;
                list.get(parseInt).getErrorConfigVersion = true;
                splitBillModel.getErrorConfigVersion = list.get(parseInt);
            }
        } else {
            splitBillModel.getErrorConfigVersion = MyBillsEntityDataFactory(scanModel2);
        }
        if (!TextUtils.isEmpty(bizInfo.newProxyInstance)) {
            int parseInt2 = Integer.parseInt(bizInfo.newProxyInstance);
            if (list.size() > parseInt2) {
                splitBillModel.MyBillsEntityDataFactory = parseInt2;
                list.get(parseInt2).getAuthRequestContext = true;
                splitBillModel.KClassImpl$Data$declaredNonStaticMembers$2 = list.get(parseInt2);
            }
        } else {
            splitBillModel.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory(scanModel2);
        }
        return splitBillModel;
    }

    private static PayerModel MyBillsEntityDataFactory(ScanModel scanModel) {
        return new PayerModel(scanModel.getAvatarUrl(), new CurrencyAmountModel("0"), scanModel.getMobileNumber(), scanModel.getNickname(), scanModel.getReceiverId());
    }
}
