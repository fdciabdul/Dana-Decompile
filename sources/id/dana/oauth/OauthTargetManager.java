package id.dana.oauth;

import id.dana.data.constant.DanaUrl;
import id.dana.oauth.OauthConstant;
import id.dana.oauth.model.OauthParamsModel;
import id.dana.utils.TagFormat;

/* loaded from: classes2.dex */
public class OauthTargetManager {
    public final String BuiltInFictitiousFunctionClassFactory;

    public OauthTargetManager(String str) {
        this.BuiltInFictitiousFunctionClassFactory = str;
    }

    public final String MyBillsEntityDataFactory(OauthParamsModel oauthParamsModel, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(oauthParamsModel.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory));
        sb.append(TagFormat.MyBillsEntityDataFactory(DanaUrl.OAUTH_ERROR).PlaceComponentResult("errorCode", str).PlaceComponentResult(OauthConstant.PathParams.ERROR_DESCRIPTION, str2).PlaceComponentResult(OauthConstant.PathParams.STATE_CODE, oauthParamsModel.newProxyInstance).MyBillsEntityDataFactory());
        return sb.toString();
    }
}
