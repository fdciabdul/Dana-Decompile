package id.dana.explore.utils;

import android.net.Uri;
import id.dana.data.ProductFlavor;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.DanaUrl;
import id.dana.data.here.HereOauthManager;
import id.dana.domain.globalsearch.model.ProductBizId;
import id.dana.mybills.ui.constant.MyBillsServiceKey;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.UrlUtil;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0005\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0007J9\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/explore/utils/ExploreUtils;", "", "", "", "p0", "getAuthRequestContext", "(Ljava/util/Map;)Ljava/lang/String;", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/domain/globalsearch/model/ProductBizId;", "p1", "p2", "p3", "p4", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Lid/dana/domain/globalsearch/model/ProductBizId;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExploreUtils {
    public static final ExploreUtils INSTANCE = new ExploreUtils();

    private ExploreUtils() {
    }

    public static String getAuthRequestContext(String p0) {
        String str;
        Intrinsics.checkNotNullParameter(p0, "");
        if (Intrinsics.areEqual("production", ProductFlavor.PUBSIT)) {
            str = "ATVQIimLTY";
        } else {
            str = Intrinsics.areEqual("production", ProductFlavor.PREPROD) ? "7YA9YD9K45" : "ZmoMgmWWTY";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(DanaUrl.DEEPLINK_URL);
        sb.append(str);
        sb.append("?params=[service=");
        sb.append(p0);
        sb.append(']');
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String BuiltInFictitiousFunctionClassFactory(String p0, ProductBizId p1, String p2, String p3, String p4) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p4, "");
        if (Intrinsics.areEqual(p0, "service_telkom")) {
            Pair[] pairArr = new Pair[2];
            StringBuilder sb = new StringBuilder();
            sb.append("[appId=");
            sb.append(p4);
            sb.append(']');
            pairArr[0] = new Pair("params", sb.toString());
            String bizId = p1 != null ? p1.getBizId() : null;
            if (bizId == null) {
                bizId = "";
            }
            pairArr[1] = new Pair(BranchLinkConstant.PayloadKey.EXTENDED_INFO, getAuthRequestContext(MapsKt.mapOf(new Pair("source", "Global Search"), new Pair("autoInquiry", SummaryActivity.CHECKED), new Pair("bizParam", bizId))));
            String authRequestContext = UrlUtil.getAuthRequestContext("https://link.dana.id/miniprogram", MapsKt.mapOf(pairArr));
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            return authRequestContext;
        }
        Uri parse = Uri.parse(p2);
        Intrinsics.checkNotNullExpressionValue(parse, "");
        Uri.Builder buildUpon = parse.buildUpon();
        if (p1 != null) {
            switch (p0.hashCode()) {
                case -1720298739:
                    if (p0.equals(MyBillsServiceKey.WATER)) {
                        buildUpon.appendQueryParameter("autoInquiry", SummaryActivity.CHECKED).appendQueryParameter("goodsId", p1.getGoodsId()).appendQueryParameter("bizParam", p1.getBizId());
                        break;
                    }
                    Unit unit = Unit.INSTANCE;
                    break;
                case 359536993:
                    if (p0.equals(MyBillsServiceKey.BPJS)) {
                        buildUpon.appendQueryParameter("autoInquiry", SummaryActivity.CHECKED).appendQueryParameter("bizParam", p1.getBizId());
                        break;
                    }
                    Unit unit2 = Unit.INSTANCE;
                    break;
                case 795109888:
                    if (p0.equals("service_credit_card_repayment")) {
                        buildUpon.appendQueryParameter("autoInquiry", SummaryActivity.CHECKED).appendQueryParameter("goodsId", p1.getGoodsId()).appendQueryParameter("bizParam", p1.getBizId()).appendQueryParameter("paymentAmount", p3).appendQueryParameter("providerName", p1.getProviderName());
                        break;
                    }
                    Unit unit22 = Unit.INSTANCE;
                    break;
                case 2086865566:
                    if (p0.equals("service_education")) {
                        buildUpon.appendQueryParameter("autoInquiry", SummaryActivity.CHECKED).appendQueryParameter("goodsId", p1.getGoodsId()).appendQueryParameter("bizParam", p1.getBizId()).appendQueryParameter("providerName", p1.getProviderName()).appendQueryParameter("provider", p1.getProvider());
                        break;
                    }
                    Unit unit222 = Unit.INSTANCE;
                    break;
                default:
                    Unit unit2222 = Unit.INSTANCE;
                    break;
            }
        }
        String obj = buildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    private static String getAuthRequestContext(Map<String, String> p0) {
        String str = "";
        if ((!p0.isEmpty()) != false) {
            for (Map.Entry<String, String> entry : p0.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Typography.quote);
                sb2.append(key);
                sb2.append(Typography.quote);
                sb.append(URLEncoder.encode(sb2.toString(), HereOauthManager.ENC));
                sb.append(':');
                StringBuilder sb3 = new StringBuilder();
                sb3.append(Typography.quote);
                sb3.append(value);
                sb3.append(Typography.quote);
                sb.append(URLEncoder.encode(sb3.toString(), HereOauthManager.ENC));
                String obj = sb.toString();
                if (StringsKt.isBlank(str)) {
                    str = obj;
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append(',');
                    sb4.append(obj);
                    str = sb4.toString();
                }
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append('{');
        sb5.append(str);
        sb5.append('}');
        return sb5.toString();
    }
}
