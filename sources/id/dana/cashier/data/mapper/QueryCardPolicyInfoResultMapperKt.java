package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.result.DailyLimitAmountConfResult;
import id.dana.cashier.data.repository.source.network.result.QueryCardPolicyInfoResult;
import id.dana.cashier.domain.model.DailyLimitAmountConf;
import id.dana.cashier.domain.model.QueryCardPolicyInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/DailyLimitAmountConfResult;", "Lid/dana/cashier/domain/model/DailyLimitAmountConf;", "toDailyLimitAmountInfo", "(Lid/dana/cashier/data/repository/source/network/result/DailyLimitAmountConfResult;)Lid/dana/cashier/domain/model/DailyLimitAmountConf;", "Lid/dana/cashier/data/repository/source/network/result/QueryCardPolicyInfoResult;", "Lid/dana/cashier/domain/model/QueryCardPolicyInfo;", "toQueryCardPolicyInfo", "(Lid/dana/cashier/data/repository/source/network/result/QueryCardPolicyInfoResult;)Lid/dana/cashier/domain/model/QueryCardPolicyInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryCardPolicyInfoResultMapperKt {
    public static final QueryCardPolicyInfo toQueryCardPolicyInfo(QueryCardPolicyInfoResult queryCardPolicyInfoResult) {
        Intrinsics.checkNotNullParameter(queryCardPolicyInfoResult, "");
        Map<String, String> actions = queryCardPolicyInfoResult.getActions();
        String cardBin = queryCardPolicyInfoResult.getCardBin();
        String cardScheme = queryCardPolicyInfoResult.getCardScheme();
        String cardType = queryCardPolicyInfoResult.getCardType();
        String channelIndex = queryCardPolicyInfoResult.getChannelIndex();
        String countryIssuer = queryCardPolicyInfoResult.getCountryIssuer();
        Boolean directDebit = queryCardPolicyInfoResult.getDirectDebit();
        String instId = queryCardPolicyInfoResult.getInstId();
        String instName = queryCardPolicyInfoResult.getInstName();
        Boolean normalPay = queryCardPolicyInfoResult.getNormalPay();
        String payOption = queryCardPolicyInfoResult.getPayOption();
        String payMethod = queryCardPolicyInfoResult.getPayMethod();
        List<String> verifyElements = queryCardPolicyInfoResult.getVerifyElements();
        DailyLimitAmountConfResult dailyLimitAmountConf = queryCardPolicyInfoResult.getDailyLimitAmountConf();
        return new QueryCardPolicyInfo(actions, cardBin, cardScheme, cardType, channelIndex, countryIssuer, directDebit, instId, instName, normalPay, payOption, payMethod, verifyElements, dailyLimitAmountConf != null ? toDailyLimitAmountInfo(dailyLimitAmountConf) : null, queryCardPolicyInfoResult.getWarnMessage());
    }

    private static final DailyLimitAmountConf toDailyLimitAmountInfo(DailyLimitAmountConfResult dailyLimitAmountConfResult) {
        return new DailyLimitAmountConf(dailyLimitAmountConfResult.getDefaultValue(), dailyLimitAmountConfResult.getMaxValue(), dailyLimitAmountConfResult.getMinValue());
    }
}
