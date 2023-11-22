package id.dana.wallet_v3.mapper;

import id.dana.domain.investment.model.MultiCurrencyMoneyView;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.wallet_v3.model.CardAssetType;
import id.dana.domain.wallet_v3.model.UserAssetInfosModel;
import id.dana.domain.wallet_v3.model.UserAssetInfosModelKt;
import id.dana.domain.wallet_v3.model.UserAssetsModel;
import id.dana.pay.PayCardViewItem;
import id.dana.wallet_v3.factory.WalletCardViewItemFactory;
import id.dana.wallet_v3.model.InvestmentCardModel;
import id.dana.wallet_v3.model.PaymentCardModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00050\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0007\u0010\u0004\u001a/\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005*\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0015\u001a\u00020\u0014*\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"", "Lid/dana/wallet_v3/model/PaymentCardModel;", "data", "reorderAssetBalanceToFirst", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/wallet_v3/model/InvestmentCardModel;", "reorderAssetDanaPlusToFirst", "reorderAssetEmptyPlaceholderToFirst", "T", "", "index1", "index2", "", "swap", "(Ljava/util/List;II)V", "Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;", "toFinancialCardModel", "(Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;)Lid/dana/wallet_v3/model/InvestmentCardModel;", "toPaymentCardModel", "(Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;)Lid/dana/wallet_v3/model/PaymentCardModel;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "toPaymentOrFinancialModel", "(Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;)Lid/dana/wallet_v3/model/WalletV3CardModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserPaymentAssetsMapperKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardAssetType.values().length];
            iArr[CardAssetType.DANA_PLUS.ordinal()] = 1;
            iArr[CardAssetType.EMAS.ordinal()] = 2;
            iArr[CardAssetType.GOALS.ordinal()] = 3;
            iArr[CardAssetType.DEBIT_CARD.ordinal()] = 4;
            iArr[CardAssetType.CREDIT_CARD.ordinal()] = 5;
            iArr[CardAssetType.BALANCE.ordinal()] = 6;
            iArr[CardAssetType.PAYLATER.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final WalletV3CardModel toPaymentOrFinancialModel(UserAssetInfosModel userAssetInfosModel) {
        Intrinsics.checkNotNullParameter(userAssetInfosModel, "");
        CardAssetType.Companion companion = CardAssetType.INSTANCE;
        String assetType = userAssetInfosModel.getAssetType();
        CardAssetType value = companion.getValue(assetType != null ? assetType : "");
        int i = value == null ? -1 : WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            InvestmentCardModel financialCardModel = toFinancialCardModel(userAssetInfosModel);
            if (financialCardModel != null) {
                return financialCardModel;
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.wallet_v3.model.WalletV3CardModel");
        }
        PaymentCardModel paymentCardModel = toPaymentCardModel(userAssetInfosModel);
        if (paymentCardModel != null) {
            return paymentCardModel;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.wallet_v3.model.WalletV3CardModel");
    }

    public static final PaymentCardModel toPaymentCardModel(UserAssetInfosModel userAssetInfosModel) {
        Boolean verified;
        Boolean enableStatus;
        Boolean directDebit;
        Boolean directDebit2;
        Intrinsics.checkNotNullParameter(userAssetInfosModel, "");
        WalletCardViewItemFactory walletCardViewItemFactory = WalletCardViewItemFactory.INSTANCE;
        UserAssetsModel info = userAssetInfosModel.getInfo();
        String instId = info != null ? info.getInstId() : null;
        if (instId == null) {
            instId = "";
        }
        String assetType = userAssetInfosModel.getAssetType();
        if (assetType == null) {
            assetType = "";
        }
        UserAssetsModel info2 = userAssetInfosModel.getInfo();
        PayCardViewItem create = walletCardViewItemFactory.create(instId, assetType, (info2 == null || (directDebit2 = info2.getDirectDebit()) == null) ? false : directDebit2.booleanValue());
        CardAssetType.Companion companion = CardAssetType.INSTANCE;
        String assetType2 = userAssetInfosModel.getAssetType();
        if (assetType2 == null) {
            assetType2 = "";
        }
        CardAssetType value = companion.getValue(assetType2);
        int i = value == null ? -1 : WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
        if (i != 4 && i != 5) {
            if (i != 6) {
                if (i != 7) {
                    return null;
                }
                UserAssetsModel info3 = userAssetInfosModel.getInfo();
                String uniqueId = info3 != null ? info3.getUniqueId() : null;
                String str = uniqueId == null ? "" : uniqueId;
                String assetType3 = userAssetInfosModel.getAssetType();
                String str2 = assetType3 == null ? "" : assetType3;
                String section = userAssetInfosModel.getSection();
                String str3 = section == null ? "" : section;
                UserAssetsModel info4 = userAssetInfosModel.getInfo();
                MoneyView balance = info4 != null ? info4.getBalance() : null;
                String titleCard = UserAssetInfosModelKt.getTitleCard(userAssetInfosModel);
                UserAssetsModel info5 = userAssetInfosModel.getInfo();
                String cardBackground = info5 != null ? info5.getCardBackground() : null;
                return new PaymentCardModel.PaylaterCard(create, str2, str3, str, titleCard, cardBackground == null ? "" : cardBackground, balance);
            }
            UserAssetsModel info6 = userAssetInfosModel.getInfo();
            String uniqueId2 = info6 != null ? info6.getUniqueId() : null;
            String str4 = uniqueId2 == null ? "" : uniqueId2;
            String assetType4 = userAssetInfosModel.getAssetType();
            String str5 = assetType4 == null ? "" : assetType4;
            String section2 = userAssetInfosModel.getSection();
            String str6 = section2 == null ? "" : section2;
            UserAssetsModel info7 = userAssetInfosModel.getInfo();
            String currency = info7 != null ? info7.getCurrency() : null;
            String str7 = currency == null ? "" : currency;
            UserAssetsModel info8 = userAssetInfosModel.getInfo();
            String amount = info8 != null ? info8.getAmount() : null;
            String str8 = amount == null ? "" : amount;
            UserAssetsModel info9 = userAssetInfosModel.getInfo();
            String phoneNumber = info9 != null ? info9.getPhoneNumber() : null;
            String str9 = phoneNumber == null ? "" : phoneNumber;
            String titleCard2 = UserAssetInfosModelKt.getTitleCard(userAssetInfosModel);
            UserAssetsModel info10 = userAssetInfosModel.getInfo();
            String cardBackground2 = info10 != null ? info10.getCardBackground() : null;
            String str10 = cardBackground2 == null ? "" : cardBackground2;
            UserAssetsModel info11 = userAssetInfosModel.getInfo();
            String nickname = info11 != null ? info11.getNickname() : null;
            String str11 = nickname == null ? "" : nickname;
            UserAssetsModel info12 = userAssetInfosModel.getInfo();
            String kycLevel = info12 != null ? info12.getKycLevel() : null;
            return new PaymentCardModel.DanaCard(create, str5, str6, str4, titleCard2, str10, str7, str8, str9, str11, kycLevel == null ? "" : kycLevel);
        }
        UserAssetsModel info13 = userAssetInfosModel.getInfo();
        String uniqueId3 = info13 != null ? info13.getUniqueId() : null;
        String str12 = uniqueId3 == null ? "" : uniqueId3;
        String assetType5 = userAssetInfosModel.getAssetType();
        String str13 = assetType5 == null ? "" : assetType5;
        String section3 = userAssetInfosModel.getSection();
        String str14 = section3 == null ? "" : section3;
        UserAssetsModel info14 = userAssetInfosModel.getInfo();
        String cardScheme = info14 != null ? info14.getCardScheme() : null;
        String str15 = cardScheme == null ? "" : cardScheme;
        UserAssetsModel info15 = userAssetInfosModel.getInfo();
        String instId2 = info15 != null ? info15.getInstId() : null;
        String str16 = instId2 == null ? "" : instId2;
        UserAssetsModel info16 = userAssetInfosModel.getInfo();
        String instOfficialName = info16 != null ? info16.getInstOfficialName() : null;
        String str17 = instOfficialName == null ? "" : instOfficialName;
        UserAssetsModel info17 = userAssetInfosModel.getInfo();
        String expiryYear = info17 != null ? info17.getExpiryYear() : null;
        String str18 = expiryYear == null ? "" : expiryYear;
        UserAssetsModel info18 = userAssetInfosModel.getInfo();
        String expiryMonth = info18 != null ? info18.getExpiryMonth() : null;
        String str19 = expiryMonth == null ? "" : expiryMonth;
        UserAssetsModel info19 = userAssetInfosModel.getInfo();
        MoneyView personalDailyLimit = info19 != null ? info19.getPersonalDailyLimit() : null;
        UserAssetsModel info20 = userAssetInfosModel.getInfo();
        String maskedCardNo = info20 != null ? info20.getMaskedCardNo() : null;
        String str20 = maskedCardNo == null ? "" : maskedCardNo;
        UserAssetsModel info21 = userAssetInfosModel.getInfo();
        String cardIndexNo = info21 != null ? info21.getCardIndexNo() : null;
        String str21 = cardIndexNo == null ? "" : cardIndexNo;
        UserAssetsModel info22 = userAssetInfosModel.getInfo();
        boolean booleanValue = (info22 == null || (directDebit = info22.getDirectDebit()) == null) ? false : directDebit.booleanValue();
        String titleCard3 = UserAssetInfosModelKt.getTitleCard(userAssetInfosModel);
        UserAssetsModel info23 = userAssetInfosModel.getInfo();
        String bindingId = info23 != null ? info23.getBindingId() : null;
        String str22 = bindingId == null ? "" : bindingId;
        UserAssetsModel info24 = userAssetInfosModel.getInfo();
        String assetType6 = info24 != null ? info24.getAssetType() : null;
        String str23 = assetType6 == null ? "" : assetType6;
        UserAssetsModel info25 = userAssetInfosModel.getInfo();
        String cardNoLength = info25 != null ? info25.getCardNoLength() : null;
        String str24 = cardNoLength == null ? "" : cardNoLength;
        UserAssetsModel info26 = userAssetInfosModel.getInfo();
        String contactBizType = info26 != null ? info26.getContactBizType() : null;
        String str25 = contactBizType == null ? "" : contactBizType;
        UserAssetsModel info27 = userAssetInfosModel.getInfo();
        String defaultAsset = info27 != null ? info27.getDefaultAsset() : null;
        String str26 = defaultAsset == null ? "" : defaultAsset;
        UserAssetsModel info28 = userAssetInfosModel.getInfo();
        boolean booleanValue2 = (info28 == null || (enableStatus = info28.getEnableStatus()) == null) ? false : enableStatus.booleanValue();
        UserAssetsModel info29 = userAssetInfosModel.getInfo();
        Map<String, String> extInfo = info29 != null ? info29.getExtInfo() : null;
        UserAssetsModel info30 = userAssetInfosModel.getInfo();
        boolean booleanValue3 = (info30 == null || (verified = info30.getVerified()) == null) ? false : verified.booleanValue();
        UserAssetsModel info31 = userAssetInfosModel.getInfo();
        String cardBackground3 = info31 != null ? info31.getCardBackground() : null;
        String str27 = cardBackground3 == null ? "" : cardBackground3;
        UserAssetsModel info32 = userAssetInfosModel.getInfo();
        return new PaymentCardModel.BankCard(create, str13, str14, str12, titleCard3, str27, str15, str16, str17, str18, str19, str25, personalDailyLimit, str20, str21, booleanValue, booleanValue3, str23, extInfo, str26, str22, str24, booleanValue2, info32 != null ? info32.getUrlTimestamp() : null);
    }

    public static final InvestmentCardModel toFinancialCardModel(UserAssetInfosModel userAssetInfosModel) {
        Boolean directDebit;
        Intrinsics.checkNotNullParameter(userAssetInfosModel, "");
        WalletCardViewItemFactory walletCardViewItemFactory = WalletCardViewItemFactory.INSTANCE;
        UserAssetsModel info = userAssetInfosModel.getInfo();
        String instId = info != null ? info.getInstId() : null;
        if (instId == null) {
            instId = "";
        }
        String assetType = userAssetInfosModel.getAssetType();
        if (assetType == null) {
            assetType = "";
        }
        UserAssetsModel info2 = userAssetInfosModel.getInfo();
        PayCardViewItem create = walletCardViewItemFactory.create(instId, assetType, (info2 == null || (directDebit = info2.getDirectDebit()) == null) ? false : directDebit.booleanValue());
        CardAssetType.Companion companion = CardAssetType.INSTANCE;
        String assetType2 = userAssetInfosModel.getAssetType();
        if (assetType2 == null) {
            assetType2 = "";
        }
        CardAssetType value = companion.getValue(assetType2);
        int i = value == null ? -1 : WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
        if (i == 1) {
            UserAssetsModel info3 = userAssetInfosModel.getInfo();
            String uniqueId = info3 != null ? info3.getUniqueId() : null;
            String str = uniqueId == null ? "" : uniqueId;
            String assetType3 = userAssetInfosModel.getAssetType();
            String str2 = assetType3 == null ? "" : assetType3;
            String section = userAssetInfosModel.getSection();
            String str3 = section == null ? "" : section;
            UserAssetsModel info4 = userAssetInfosModel.getInfo();
            MultiCurrencyMoneyView totalGainLossAmount = info4 != null ? info4.getTotalGainLossAmount() : null;
            UserAssetsModel info5 = userAssetInfosModel.getInfo();
            String totalGainLossPercentage = info5 != null ? info5.getTotalGainLossPercentage() : null;
            UserAssetsModel info6 = userAssetInfosModel.getInfo();
            MultiCurrencyMoneyView availableBalance = info6 != null ? info6.getAvailableBalance() : null;
            String titleCard = UserAssetInfosModelKt.getTitleCard(userAssetInfosModel);
            UserAssetsModel info7 = userAssetInfosModel.getInfo();
            String cardBackground = info7 != null ? info7.getCardBackground() : null;
            String str4 = cardBackground == null ? "" : cardBackground;
            UserAssetsModel info8 = userAssetInfosModel.getInfo();
            return new InvestmentCardModel.DanaPlusCard(create, str2, str3, str, titleCard, str4, totalGainLossAmount, totalGainLossPercentage, info8 != null ? info8.getDailyGainLossAmount() : null, availableBalance);
        } else if (i == 2) {
            UserAssetsModel info9 = userAssetInfosModel.getInfo();
            String uniqueId2 = info9 != null ? info9.getUniqueId() : null;
            String str5 = uniqueId2 == null ? "" : uniqueId2;
            String assetType4 = userAssetInfosModel.getAssetType();
            String str6 = assetType4 == null ? "" : assetType4;
            String section2 = userAssetInfosModel.getSection();
            String str7 = section2 == null ? "" : section2;
            UserAssetsModel info10 = userAssetInfosModel.getInfo();
            String totalGainLossPercentage2 = info10 != null ? info10.getTotalGainLossPercentage() : null;
            UserAssetsModel info11 = userAssetInfosModel.getInfo();
            MultiCurrencyMoneyView totalGainLossAmount2 = info11 != null ? info11.getTotalGainLossAmount() : null;
            UserAssetsModel info12 = userAssetInfosModel.getInfo();
            MultiCurrencyMoneyView availableBalance2 = info12 != null ? info12.getAvailableBalance() : null;
            String titleCard2 = UserAssetInfosModelKt.getTitleCard(userAssetInfosModel);
            UserAssetsModel info13 = userAssetInfosModel.getInfo();
            String cardBackground2 = info13 != null ? info13.getCardBackground() : null;
            return new InvestmentCardModel.EmasCard(create, str6, str7, str5, titleCard2, cardBackground2 == null ? "" : cardBackground2, totalGainLossAmount2, totalGainLossPercentage2, availableBalance2);
        } else if (i != 3) {
            return null;
        } else {
            UserAssetsModel info14 = userAssetInfosModel.getInfo();
            String uniqueId3 = info14 != null ? info14.getUniqueId() : null;
            String str8 = uniqueId3 == null ? "" : uniqueId3;
            String assetType5 = userAssetInfosModel.getAssetType();
            String str9 = assetType5 == null ? "" : assetType5;
            String section3 = userAssetInfosModel.getSection();
            String str10 = section3 == null ? "" : section3;
            UserAssetsModel info15 = userAssetInfosModel.getInfo();
            String title = info15 != null ? info15.getTitle() : null;
            String str11 = title == null ? "" : title;
            UserAssetsModel info16 = userAssetInfosModel.getInfo();
            String currency = info16 != null ? info16.getCurrency() : null;
            String str12 = currency == null ? "" : currency;
            UserAssetsModel info17 = userAssetInfosModel.getInfo();
            String amount = info17 != null ? info17.getAmount() : null;
            String str13 = amount == null ? "" : amount;
            String titleCard3 = UserAssetInfosModelKt.getTitleCard(userAssetInfosModel);
            UserAssetsModel info18 = userAssetInfosModel.getInfo();
            String cardBackground3 = info18 != null ? info18.getCardBackground() : null;
            return new InvestmentCardModel.DanaGoalsCard(create, str9, str10, str8, titleCard3, cardBackground3 == null ? "" : cardBackground3, str11, str12, str13);
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public static final List<PaymentCardModel> reorderAssetEmptyPlaceholderToFirst(List<PaymentCardModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        ?? r2 = 0;
        list.add(new PaymentCardModel.EmptyCard(r2, 1, r2));
        swap(list, 0, 1);
        return list;
    }

    public static final List<PaymentCardModel> reorderAssetBalanceToFirst(List<PaymentCardModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        for (PaymentCardModel paymentCardModel : list) {
            if (Intrinsics.areEqual(paymentCardModel.getAssetType(), CardAssetType.BALANCE.getAsset())) {
                list.remove(list.indexOf(paymentCardModel));
                list.add(0, paymentCardModel);
                return list;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public static final List<InvestmentCardModel> reorderAssetDanaPlusToFirst(List<InvestmentCardModel> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((InvestmentCardModel) obj).getAssetType(), CardAssetType.DANA_PLUS.getAsset())) {
                break;
            }
        }
        InvestmentCardModel investmentCardModel = (InvestmentCardModel) obj;
        if (investmentCardModel == null) {
            return list;
        }
        list.remove(list.indexOf(investmentCardModel));
        list.add(0, investmentCardModel);
        return list;
    }

    private static final <T> void swap(List<T> list, int i, int i2) {
        T t = list.get(i);
        list.set(i, list.get(i2));
        list.set(i2, t);
    }
}
