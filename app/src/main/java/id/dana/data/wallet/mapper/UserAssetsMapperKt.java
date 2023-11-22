package id.dana.data.wallet.mapper;

import id.dana.data.investment.repository.source.network.response.InvestmentUnitResult;
import id.dana.data.investment.repository.source.network.response.InvestmentUnitResultKt;
import id.dana.data.investment.repository.source.network.response.MultiCurrencyMoneyResult;
import id.dana.data.investment.repository.source.network.response.MultiCurrencyMoneyResultKt;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetInfosResult;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetResult;
import id.dana.data.wallet_v3.repository.source.network.result.UserAssetsWrapperResult;
import id.dana.domain.investment.model.InvestmentUnitInfo;
import id.dana.domain.investment.model.MultiCurrencyMoneyView;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.wallet_v3.model.UserAssetInfosModel;
import id.dana.domain.wallet_v3.model.UserAssetsModel;
import id.dana.domain.wallet_v3.model.UserAssetsWrapperModel;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\u0002\u001a\u00020\t*\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005¢\u0006\u0004\b\u0002\u0010\n"}, d2 = {"Lid/dana/domain/nearbyme/model/MoneyView;", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getAuthRequestContext", "(Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetsWrapperResult;", "Lkotlin/Function1;", "", "", "p0", "Lid/dana/domain/wallet_v3/model/UserAssetsWrapperModel;", "(Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetsWrapperResult;Lkotlin/jvm/functions/Function1;)Lid/dana/domain/wallet_v3/model/UserAssetsWrapperModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserAssetsMapperKt {
    public static final UserAssetsWrapperModel getAuthRequestContext(UserAssetsWrapperResult userAssetsWrapperResult, Function1<? super String, Long> function1) {
        UserAssetsModel userAssetsModel;
        Intrinsics.checkNotNullParameter(userAssetsWrapperResult, "");
        Intrinsics.checkNotNullParameter(function1, "");
        String location = userAssetsWrapperResult.getLocation();
        Long requestTime = userAssetsWrapperResult.getRequestTime();
        Map<String, String> map = userAssetsWrapperResult.errorActions;
        List<UserAssetInfosResult> assetInfos = userAssetsWrapperResult.getAssetInfos();
        ArrayList arrayList = null;
        if (assetInfos != null) {
            Intrinsics.checkNotNullParameter(assetInfos, "");
            Intrinsics.checkNotNullParameter(function1, "");
            List<UserAssetInfosResult> list = assetInfos;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (UserAssetInfosResult userAssetInfosResult : list) {
                Intrinsics.checkNotNullParameter(userAssetInfosResult, "");
                Intrinsics.checkNotNullParameter(function1, "");
                String section = userAssetInfosResult.getSection();
                String assetType = userAssetInfosResult.getAssetType();
                UserAssetResult info = userAssetInfosResult.getInfo();
                if (info != null) {
                    Intrinsics.checkNotNullParameter(info, "");
                    Intrinsics.checkNotNullParameter(function1, "");
                    String uniqueId = info.getUniqueId();
                    String amount = info.getAmount();
                    String currency = info.getCurrency();
                    MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(info.getLimit());
                    MoneyView moneyView2 = MoneyViewEntityMapperKt.toMoneyView(info.getBalance());
                    MoneyView moneyView3 = MoneyViewEntityMapperKt.toMoneyView(info.getUnpaidAmount());
                    List<String> overdueTips = info.getOverdueTips();
                    Boolean overdueStatus = info.getOverdueStatus();
                    String accountId = info.getAccountId();
                    String gmtCreate = info.getGmtCreate();
                    String gmtModified = info.getGmtModified();
                    String assetBiztype = info.getAssetBiztype();
                    String cardTitle = info.getCardTitle();
                    String cardIndexNo = info.getCardIndexNo();
                    String cardNoLength = info.getCardNoLength();
                    String maskedCardNo = info.getMaskedCardNo();
                    String assetType2 = info.getAssetType();
                    String cardScheme = info.getCardScheme();
                    String holderName = info.getHolderName();
                    String instLogoUrl = info.getInstLogoUrl();
                    String instId = info.getInstId();
                    String instOfficialName = info.getInstOfficialName();
                    String instBranchId = info.getInstBranchId();
                    String instBranchOfficialName = info.getInstBranchOfficialName();
                    String expiryYear = info.getExpiryYear();
                    String expiryMonth = info.getExpiryMonth();
                    Boolean verified = info.getVerified();
                    String bindingId = info.getBindingId();
                    String accountNo = info.getAccountNo();
                    String defaultAsset = info.getDefaultAsset();
                    Map<String, String> extInfo = info.getExtInfo();
                    Boolean enableStatus = info.getEnableStatus();
                    String bankMobileNo = info.getBankMobileNo();
                    Boolean directDebit = info.getDirectDebit();
                    Boolean isDirectDebit = info.isDirectDebit();
                    MoneyView moneyView4 = MoneyViewEntityMapperKt.toMoneyView(info.getPersonalDailyLimit());
                    String userPhoneNo = info.getUserPhoneNo();
                    String contactBizType = info.getContactBizType();
                    String goodsId = info.getGoodsId();
                    String aggregator = info.getAggregator();
                    String userId = info.getUserId();
                    String accountStatus = info.getAccountStatus();
                    MultiCurrencyMoneyResult availableBalance = info.getAvailableBalance();
                    MultiCurrencyMoneyView KClassImpl$Data$declaredNonStaticMembers$2 = availableBalance != null ? MultiCurrencyMoneyResultKt.KClassImpl$Data$declaredNonStaticMembers$2(availableBalance) : null;
                    InvestmentUnitResult balanceUnit = info.getBalanceUnit();
                    InvestmentUnitInfo PlaceComponentResult = balanceUnit != null ? InvestmentUnitResultKt.PlaceComponentResult(balanceUnit) : null;
                    MultiCurrencyMoneyResult totalGainLossAmount = info.getTotalGainLossAmount();
                    MultiCurrencyMoneyView KClassImpl$Data$declaredNonStaticMembers$22 = totalGainLossAmount != null ? MultiCurrencyMoneyResultKt.KClassImpl$Data$declaredNonStaticMembers$2(totalGainLossAmount) : null;
                    String totalGainLossPercentage = info.getTotalGainLossPercentage();
                    MultiCurrencyMoneyResult dailyGainLossAmount = info.getDailyGainLossAmount();
                    MultiCurrencyMoneyView KClassImpl$Data$declaredNonStaticMembers$23 = dailyGainLossAmount != null ? MultiCurrencyMoneyResultKt.KClassImpl$Data$declaredNonStaticMembers$2(dailyGainLossAmount) : null;
                    String dailyGainLossPercentage = info.getDailyGainLossPercentage();
                    Long lastUpdated = info.getLastUpdated();
                    String savingId = info.getSavingId();
                    String title = info.getTitle();
                    String categoryCode = info.getCategoryCode();
                    MoneyView moneyView5 = MoneyViewEntityMapperKt.toMoneyView(info.getCurrentAmount());
                    MoneyView moneyView6 = MoneyViewEntityMapperKt.toMoneyView(info.getTargetAmount());
                    String orderStatus = info.getOrderStatus();
                    String orderSubStatus = info.getOrderSubStatus();
                    Long createdTime = info.getCreatedTime();
                    Long achievedTime = info.getAchievedTime();
                    Long completedTime = info.getCompletedTime();
                    Map<String, String> extendInfo = info.getExtendInfo();
                    String cardBackground = info.getCardBackground();
                    String instId2 = info.getInstId();
                    if (instId2 == null) {
                        instId2 = "";
                    }
                    userAssetsModel = new UserAssetsModel(uniqueId, amount, currency, moneyView, moneyView2, moneyView3, overdueTips, overdueStatus, accountId, gmtCreate, gmtModified, assetBiztype, cardTitle, cardIndexNo, cardNoLength, maskedCardNo, assetType2, cardScheme, holderName, instLogoUrl, instId, instOfficialName, instBranchId, instBranchOfficialName, expiryYear, expiryMonth, verified, bindingId, accountNo, defaultAsset, extInfo, enableStatus, bankMobileNo, directDebit, isDirectDebit, moneyView4, userPhoneNo, contactBizType, goodsId, aggregator, userId, accountStatus, KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$22, totalGainLossPercentage, KClassImpl$Data$declaredNonStaticMembers$23, dailyGainLossPercentage, lastUpdated, savingId, title, categoryCode, moneyView5, moneyView6, orderStatus, orderSubStatus, createdTime, achievedTime, completedTime, extendInfo, cardBackground, null, null, null, function1.invoke(instId2), info.getCacheTimestamp(), 0, -536870912, 0, null);
                } else {
                    userAssetsModel = null;
                }
                arrayList2.add(new UserAssetInfosModel(section, assetType, userAssetsModel));
            }
            arrayList = arrayList2;
        }
        return new UserAssetsWrapperModel(location, requestTime, map, arrayList);
    }

    public static final MoneyViewEntity getAuthRequestContext(MoneyView moneyView) {
        Intrinsics.checkNotNullParameter(moneyView, "");
        return new MoneyViewEntity(moneyView.getAmount(), moneyView.getCurrency(), moneyView.getCurrencyCode());
    }
}
