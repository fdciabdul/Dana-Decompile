package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import id.dana.base.BaseActivity;
import id.dana.challenge.ChallengeControl;
import id.dana.data.account.repository.source.SecuredAccountPreferences;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.sendmoney.SendMoneyScenarioDirector;
import id.dana.sendmoney.model.QrTransferModel;
import id.dana.sendmoney_v2.landing.SendMoneyActivity;
import java.util.Map;

/* loaded from: classes4.dex */
public class FeatureSendMoney extends BaseDeeplinkFeature {
    public FeatureSendMoney(Activity activity, Map<String, String> map, String str) {
        if (activity instanceof SendMoneyActivity) {
            BaseActivity baseActivity = (BaseActivity) activity;
            Bundle bundle = new Bundle();
            bundle.putString("recipientType", str);
            bundle.putParcelable("scanner_data", PlaceComponentResult(map, str));
            bundle.putString("source", PlaceComponentResult(map, baseActivity));
            new SendMoneyScenarioDirector(baseActivity).getAuthRequestContext(bundle);
            return;
        }
        Intent BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(activity, map, SendMoneyActivity.class);
        BuiltInFictitiousFunctionClassFactory.putExtra("recipientType", str);
        if (!map.isEmpty()) {
            BuiltInFictitiousFunctionClassFactory.putExtra("scanner_data", PlaceComponentResult(map, str));
        }
        activity.startActivity(BuiltInFictitiousFunctionClassFactory);
    }

    private static QrTransferModel PlaceComponentResult(Map<String, String> map, String str) {
        QrTransferModel qrTransferModel = new QrTransferModel();
        qrTransferModel.MyBillsEntityDataFactory(map.get("amount"));
        str.hashCode();
        if (str.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_PHONE)) {
            if (map.get(ChallengeControl.Key.PHONE_NUMBER) != null) {
                qrTransferModel.BuiltInFictitiousFunctionClassFactory(map.get(ChallengeControl.Key.PHONE_NUMBER).contains("*") ? "" : map.get(ChallengeControl.Key.PHONE_NUMBER));
            }
            if (map.get(SecuredAccountPreferences.Key.USER_ID) != null) {
                qrTransferModel.getAuthRequestContext(map.get(SecuredAccountPreferences.Key.USER_ID));
            }
        } else if (str.equals(BranchLinkConstant.ActionTarget.SEND_MONEY_BANK)) {
            qrTransferModel.BuiltInFictitiousFunctionClassFactory(map.get(FeatureParams.ACCOUNT_NUMBER));
            qrTransferModel.getAuthRequestContext(map.get(FeatureParams.BANK_ID));
        } else {
            qrTransferModel.BuiltInFictitiousFunctionClassFactory(map.get(FeatureParams.MOBILE_NUMBER));
        }
        return qrTransferModel;
    }
}
