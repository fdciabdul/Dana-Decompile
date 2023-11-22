package id.dana.requestmoney.model;

import id.dana.domain.recentrecipient.model.RecentRecipient;
import id.dana.domain.requestmoney.model.BankSelectorConfig;
import id.dana.sendmoney.mapper.BankModelMapper;
import id.dana.sendmoney.model.BankModel;
import id.dana.sendmoney.model.BankModelExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0002\u001a\u001e\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\r"}, d2 = {"defaultSelectedBank", "Lid/dana/sendmoney/model/BankModel;", "bankModels", "", "recentBank", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "topBanks", "", "toBankSelectorConfigModel", "Lid/dana/requestmoney/model/BankSelectorConfigModel;", "Lid/dana/domain/requestmoney/model/BankSelectorConfig;", "bankModelMapper", "Lid/dana/sendmoney/mapper/BankModelMapper;", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankSelectorConfigModelKt {
    public static final BankSelectorConfigModel getAuthRequestContext(BankSelectorConfig bankSelectorConfig, BankModelMapper bankModelMapper, RecentRecipient recentRecipient) {
        Object obj;
        Intrinsics.checkNotNullParameter(bankSelectorConfig, "");
        Intrinsics.checkNotNullParameter(bankModelMapper, "");
        List<BankModel> apply = bankModelMapper.apply(bankSelectorConfig.getTransferInit());
        if (apply == null) {
            apply = CollectionsKt.emptyList();
        }
        List<BankModel> list = apply;
        boolean isNeedSenderName = bankSelectorConfig.getTransferInit().isNeedSenderName();
        int retryLimit = bankSelectorConfig.getNameCheckConfig().getRetryLimit();
        int freezeTime = bankSelectorConfig.getNameCheckConfig().getFreezeTime();
        int resetTime = bankSelectorConfig.getNameCheckConfig().getResetTime();
        List<String> topFeaturedBanks = bankSelectorConfig.getTopFeaturedBanks();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(recentRecipient != null ? recentRecipient.getId() : null, ((BankModel) next).lookAheadTest)) {
                obj = next;
                break;
            }
        }
        BankModel bankModel = (BankModel) obj;
        if (bankModel == null) {
            bankModel = (BankModel) CollectionsKt.firstOrNull((List) BankModelExtKt.getAuthRequestContext(list, topFeaturedBanks));
        }
        return new BankSelectorConfigModel(isNeedSenderName, "", retryLimit, freezeTime, resetTime, list, bankModel, false, false, bankSelectorConfig.getTransferInit(), 384, null);
    }
}
