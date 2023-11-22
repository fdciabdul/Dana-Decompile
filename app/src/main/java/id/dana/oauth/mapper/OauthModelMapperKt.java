package id.dana.oauth.mapper;

import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.util.DeepLinkUtilKt;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.oauth.model.AuthCodeModel;
import id.dana.oauth.model.OauthParamsModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0007\u001a\u00020\u0006*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/domain/authcode/AuthCodeResult;", "Lid/dana/oauth/model/AuthCodeModel;", "PlaceComponentResult", "(Lid/dana/domain/authcode/AuthCodeResult;)Lid/dana/oauth/model/AuthCodeModel;", "", "", "Lid/dana/oauth/model/OauthParamsModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/Map;)Lid/dana/oauth/model/OauthParamsModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OauthModelMapperKt {
    public static final OauthParamsModel BuiltInFictitiousFunctionClassFactory(Map<String, String> map) {
        List<String> emptyList;
        Intrinsics.checkNotNullParameter(map, "");
        String str = map.get("clientId");
        String str2 = str == null ? "" : str;
        String str3 = map.get("scopes");
        if (str3 == null || (emptyList = DeepLinkUtilKt.toScopes(str3)) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        List<String> list = emptyList;
        String str4 = map.get("state");
        String str5 = str4 == null ? "" : str4;
        String str6 = map.get("redirectUrl");
        String str7 = str6 == null ? "" : str6;
        String str8 = map.get(BranchLinkConstant.OauthParams.BIND_DANA_TYPE);
        String str9 = str8 == null ? "" : str8;
        String str10 = map.get(BranchLinkConstant.OauthParams.ACQ_SITE_ID);
        String str11 = str10 == null ? "" : str10;
        String str12 = map.get("merchantId");
        String str13 = str12 == null ? "" : str12;
        String str14 = map.get("merchantName");
        String str15 = str14 == null ? "" : str14;
        String str16 = map.get(BranchLinkConstant.OauthParams.NET_AUTH_ID);
        String str17 = str16 == null ? "" : str16;
        String str18 = map.get(BranchLinkConstant.OauthParams.PAY_SITE_ID);
        String str19 = str18 == null ? "" : str18;
        String str20 = map.get("terminalType");
        String str21 = str20 == null ? "" : str20;
        String str22 = map.get(BranchLinkConstant.OauthParams.SIGNATURE);
        String str23 = str22 == null ? "" : str22;
        String str24 = map.get(BranchLinkConstant.OauthParams.MCC);
        String str25 = str24 == null ? "" : str24;
        String str26 = map.get("referring_link");
        String str27 = str26 == null ? "" : str26;
        String str28 = map.get("phoneNumber");
        return new OauthParamsModel(null, str2, str28 == null ? "" : str28, list, str5, null, str7, null, str9, str11, str13, str15, str17, str19, str21, str23, str25, str27, null, Boolean.valueOf(Boolean.parseBoolean(map.get(BranchLinkConstant.OauthParams.IS_IPG_BINDING))), 262305, null);
    }

    public static final AuthCodeModel PlaceComponentResult(AuthCodeResult authCodeResult) {
        Intrinsics.checkNotNullParameter(authCodeResult, "");
        return new AuthCodeModel(authCodeResult.getAuthCode(), authCodeResult.getState(), authCodeResult.getMerchantRedirectUrl());
    }
}
