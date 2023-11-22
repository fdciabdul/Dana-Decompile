package id.dana.cashier.mapper;

import id.dana.cashier.domain.model.DailyLimitAmountConf;
import id.dana.cashier.domain.model.QueryCardPolicyInfo;
import id.dana.cashier.model.DailyLimitAmountConfModel;
import id.dana.cashier.model.QueryCardPolicyInfoModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/model/DailyLimitAmountConf;", "Lid/dana/cashier/model/DailyLimitAmountConfModel;", "PlaceComponentResult", "(Lid/dana/cashier/domain/model/DailyLimitAmountConf;)Lid/dana/cashier/model/DailyLimitAmountConfModel;", "Lid/dana/cashier/domain/model/QueryCardPolicyInfo;", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "(Lid/dana/cashier/domain/model/QueryCardPolicyInfo;)Lid/dana/cashier/model/QueryCardPolicyInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryCardPolicyInfoModelMapperKt {
    public static final QueryCardPolicyInfoModel PlaceComponentResult(QueryCardPolicyInfo queryCardPolicyInfo) {
        List<String> list;
        DailyLimitAmountConfModel dailyLimitAmountConfModel;
        Intrinsics.checkNotNullParameter(queryCardPolicyInfo, "");
        Map<String, String> actions = queryCardPolicyInfo.getActions();
        String cardBin = queryCardPolicyInfo.getCardBin();
        String cardScheme = queryCardPolicyInfo.getCardScheme();
        String cardType = queryCardPolicyInfo.getCardType();
        String channelIndex = queryCardPolicyInfo.getChannelIndex();
        String countryIssuer = queryCardPolicyInfo.getCountryIssuer();
        Boolean directDebit = queryCardPolicyInfo.getDirectDebit();
        String instId = queryCardPolicyInfo.getInstId();
        String instName = queryCardPolicyInfo.getInstName();
        Boolean normalPay = queryCardPolicyInfo.getNormalPay();
        String payOption = queryCardPolicyInfo.getPayOption();
        String payMethod = queryCardPolicyInfo.getPayMethod();
        List<String> verifyElements = queryCardPolicyInfo.getVerifyElements();
        DailyLimitAmountConf dailyLimitAmountConf = queryCardPolicyInfo.getDailyLimitAmountConf();
        if (dailyLimitAmountConf != null) {
            Intrinsics.checkNotNullParameter(dailyLimitAmountConf, "");
            list = verifyElements;
            dailyLimitAmountConfModel = new DailyLimitAmountConfModel(dailyLimitAmountConf.getDefaultValue(), dailyLimitAmountConf.getMaxValue(), dailyLimitAmountConf.getMinValue());
        } else {
            list = verifyElements;
            dailyLimitAmountConfModel = null;
        }
        return new QueryCardPolicyInfoModel(actions, cardBin, cardScheme, cardType, channelIndex, countryIssuer, directDebit, instId, instName, normalPay, payOption, payMethod, list, dailyLimitAmountConfModel, queryCardPolicyInfo.getWarnMessage());
    }

    public static final DailyLimitAmountConfModel PlaceComponentResult(DailyLimitAmountConf dailyLimitAmountConf) {
        Intrinsics.checkNotNullParameter(dailyLimitAmountConf, "");
        return new DailyLimitAmountConfModel(dailyLimitAmountConf.getDefaultValue(), dailyLimitAmountConf.getMaxValue(), dailyLimitAmountConf.getMinValue());
    }
}
