package id.dana.sendmoney_v2.model;

import id.dana.data.constant.DanaUrl;
import id.dana.data.constant.UrlParam;
import id.dana.domain.sendmoney.model.BillerX2B;
import id.dana.utils.TagFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\u0007\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a!\u0010\t\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\b"}, d2 = {"Lid/dana/domain/sendmoney/model/BillerX2B;", "", "p0", "Lid/dana/sendmoney_v2/model/BillerX2BModel;", "MyBillsEntityDataFactory", "(Lid/dana/domain/sendmoney/model/BillerX2B;Ljava/lang/String;)Lid/dana/sendmoney_v2/model/BillerX2BModel;", "p1", "PlaceComponentResult", "(Lid/dana/sendmoney_v2/model/BillerX2BModel;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillerX2BModelKt {
    public static final String KClassImpl$Data$declaredNonStaticMembers$2(BillerX2BModel billerX2BModel, String str, String str2) {
        Intrinsics.checkNotNullParameter(billerX2BModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        String MyBillsEntityDataFactory = TagFormat.MyBillsEntityDataFactory(DanaUrl.BILLER_X2B_URL_PARAM_RECENTS).MyBillsEntityDataFactory("redirectUrl", billerX2BModel.NetworkUserEntityData$$ExternalSyntheticLambda0).MyBillsEntityDataFactory("authCode", str).MyBillsEntityDataFactory(UrlParam.REQUEST_ID, str2).MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public static final String PlaceComponentResult(BillerX2BModel billerX2BModel, String str, String str2) {
        Intrinsics.checkNotNullParameter(billerX2BModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        String MyBillsEntityDataFactory = TagFormat.MyBillsEntityDataFactory(DanaUrl.BILLER_X2B_URL_PARAM_NEW_BANK).MyBillsEntityDataFactory("redirectUrl", billerX2BModel.NetworkUserEntityData$$ExternalSyntheticLambda0).MyBillsEntityDataFactory("authCode", str).MyBillsEntityDataFactory(UrlParam.REQUEST_ID, str2).MyBillsEntityDataFactory("prefix", billerX2BModel.moveToNextValue).MyBillsEntityDataFactory("customerNumber", StringsKt.removePrefix(billerX2BModel.PlaceComponentResult, (CharSequence) billerX2BModel.moveToNextValue)).MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public static final BillerX2BModel MyBillsEntityDataFactory(BillerX2B billerX2B, String str) {
        Intrinsics.checkNotNullParameter(billerX2B, "");
        Intrinsics.checkNotNullParameter(str, "");
        return new BillerX2BModel(billerX2B.getBillerName(), billerX2B.getInstId(), billerX2B.getPrefix(), billerX2B.getClientId(), billerX2B.getRedirectUrl(), billerX2B.getScopes(), billerX2B.getAgreed(), str, false, 256, null);
    }
}
