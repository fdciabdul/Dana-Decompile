package id.dana.data.wallet_v3.repository.source.persistence.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.animation.HomeTabActivity;
import id.dana.danah5.constant.BaseKey;
import id.dana.data.base.MapConverter;
import id.dana.data.base.StringConverter;
import id.dana.data.wallet_v3.repository.source.persistence.entity.UserPaymentAssetsDaoEntity;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public final class UserPaymentAssetsDao_Impl implements UserPaymentAssetsDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<UserPaymentAssetsDaoEntity> __insertionAdapterOfUserPaymentAssetsDaoEntity;
    private final SharedSQLiteStatement __preparedStmtOfClearUserPaymentAssets;
    private final StringConverter __stringConverter = new StringConverter();
    private final MapConverter __mapConverter = new MapConverter();

    public UserPaymentAssetsDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfUserPaymentAssetsDaoEntity = new EntityInsertionAdapter<UserPaymentAssetsDaoEntity>(roomDatabase) { // from class: id.dana.data.wallet_v3.repository.source.persistence.dao.UserPaymentAssetsDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `UserPaymentAssetsDaoEntity` (`uniqueId`,`section`,`amount`,`currency`,`limitAmount`,`limitCurrency`,`limitCurrencyCode`,`balanceAmount`,`balanceCurrency`,`balanceCurrencyCode`,`unpaidAmountAmount`,`unpaidAmountCurrency`,`unpaidAmountCurrencyCode`,`overdueTips`,`overdueStatus`,`accountId`,`gmtCreate`,`gmtModified`,`assetBiztype`,`cardTitle`,`cardIndexNo`,`cardNoLength`,`maskedCardNo`,`assetType`,`cardScheme`,`holderName`,`instLogoUrl`,`instId`,`instOfficialName`,`instBranchId`,`instBranchOfficialName`,`expiryYear`,`expiryMonth`,`verified`,`bindingId`,`accountNo`,`defaultAsset`,`extInfo`,`enableStatus`,`bankMobileNo`,`directDebit`,`personalDailyLimitAmount`,`personalDailyLimitCurrency`,`personalDailyLimitCurrencyCode`,`userPhoneNo`,`contactBizType`,`goodsId`,`aggregator`,`userId`,`accountStatus`,`availableBalanceAmount`,`availableBalanceCent`,`availableBalanceCentFactor`,`availableBalanceCurrency`,`availableBalanceCurrencyCode`,`availableBalanceCurrencyValue`,`balanceUnitType`,`balanceUnitUnit`,`balanceUnitUnitValue`,`totalGainLossAmountAmount`,`totalGainLossAmountCent`,`totalGainLossAmountCentFactor`,`totalGainLossAmountCurrency`,`totalGainLossAmountCurrencyCode`,`totalGainLossAmountCurrencyValue`,`totalGainLossPercentage`,`dailyGainLossAmountAmount`,`dailyGainLossAmountCent`,`dailyGainLossAmountCentFactor`,`dailyGainLossAmountCurrency`,`dailyGainLossAmountCurrencyCode`,`dailyGainLossAmountCurrencyValue`,`dailyGainLossPercentage`,`lastUpdated`,`savingId`,`title`,`categoryCode`,`currentAmountAmount`,`currentAmountCurrency`,`currentAmountCurrencyCode`,`targetAmountAmount`,`targetAmountCurrency`,`targetAmountCurrencyCode`,`orderStatus`,`orderSubStatus`,`createdTime`,`achievedTime`,`completedTime`,`extendInfo`,`cardBackground`,`cacheTimestamp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, UserPaymentAssetsDaoEntity userPaymentAssetsDaoEntity) {
                UserPaymentAssetsDaoEntity userPaymentAssetsDaoEntity2 = userPaymentAssetsDaoEntity;
                if (userPaymentAssetsDaoEntity2.getUniqueId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, userPaymentAssetsDaoEntity2.getUniqueId());
                }
                if (userPaymentAssetsDaoEntity2.getSection() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, userPaymentAssetsDaoEntity2.getSection());
                }
                if (userPaymentAssetsDaoEntity2.getAmount() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, userPaymentAssetsDaoEntity2.getAmount());
                }
                if (userPaymentAssetsDaoEntity2.getCurrency() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, userPaymentAssetsDaoEntity2.getCurrency());
                }
                if (userPaymentAssetsDaoEntity2.getLimitAmount() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, userPaymentAssetsDaoEntity2.getLimitAmount());
                }
                if (userPaymentAssetsDaoEntity2.getLimitCurrency() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, userPaymentAssetsDaoEntity2.getLimitCurrency());
                }
                if (userPaymentAssetsDaoEntity2.getLimitCurrencyCode() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, userPaymentAssetsDaoEntity2.getLimitCurrencyCode());
                }
                if (userPaymentAssetsDaoEntity2.getBalanceAmount() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, userPaymentAssetsDaoEntity2.getBalanceAmount());
                }
                if (userPaymentAssetsDaoEntity2.getBalanceCurrency() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, userPaymentAssetsDaoEntity2.getBalanceCurrency());
                }
                if (userPaymentAssetsDaoEntity2.getBalanceCurrencyCode() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, userPaymentAssetsDaoEntity2.getBalanceCurrencyCode());
                }
                if (userPaymentAssetsDaoEntity2.getUnpaidAmountAmount() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, userPaymentAssetsDaoEntity2.getUnpaidAmountAmount());
                }
                if (userPaymentAssetsDaoEntity2.getUnpaidAmountCurrency() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, userPaymentAssetsDaoEntity2.getUnpaidAmountCurrency());
                }
                if (userPaymentAssetsDaoEntity2.getUnpaidAmountCurrencyCode() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, userPaymentAssetsDaoEntity2.getUnpaidAmountCurrencyCode());
                }
                String fromList = UserPaymentAssetsDao_Impl.this.__stringConverter.fromList(userPaymentAssetsDaoEntity2.getOverdueTips());
                if (fromList == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, fromList);
                }
                if ((userPaymentAssetsDaoEntity2.getOverdueStatus() == null ? null : Integer.valueOf(userPaymentAssetsDaoEntity2.getOverdueStatus().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindLong(15, r0.intValue());
                }
                if (userPaymentAssetsDaoEntity2.getAccountId() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, userPaymentAssetsDaoEntity2.getAccountId());
                }
                if (userPaymentAssetsDaoEntity2.getGmtCreate() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, userPaymentAssetsDaoEntity2.getGmtCreate());
                }
                if (userPaymentAssetsDaoEntity2.getGmtModified() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, userPaymentAssetsDaoEntity2.getGmtModified());
                }
                if (userPaymentAssetsDaoEntity2.getAssetBiztype() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, userPaymentAssetsDaoEntity2.getAssetBiztype());
                }
                if (userPaymentAssetsDaoEntity2.getCardTitle() == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, userPaymentAssetsDaoEntity2.getCardTitle());
                }
                if (userPaymentAssetsDaoEntity2.getCardIndexNo() == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, userPaymentAssetsDaoEntity2.getCardIndexNo());
                }
                if (userPaymentAssetsDaoEntity2.getCardNoLength() == null) {
                    supportSQLiteStatement.bindNull(22);
                } else {
                    supportSQLiteStatement.bindString(22, userPaymentAssetsDaoEntity2.getCardNoLength());
                }
                if (userPaymentAssetsDaoEntity2.getMaskedCardNo() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, userPaymentAssetsDaoEntity2.getMaskedCardNo());
                }
                if (userPaymentAssetsDaoEntity2.getAssetType() == null) {
                    supportSQLiteStatement.bindNull(24);
                } else {
                    supportSQLiteStatement.bindString(24, userPaymentAssetsDaoEntity2.getAssetType());
                }
                if (userPaymentAssetsDaoEntity2.getCardScheme() == null) {
                    supportSQLiteStatement.bindNull(25);
                } else {
                    supportSQLiteStatement.bindString(25, userPaymentAssetsDaoEntity2.getCardScheme());
                }
                if (userPaymentAssetsDaoEntity2.getHolderName() == null) {
                    supportSQLiteStatement.bindNull(26);
                } else {
                    supportSQLiteStatement.bindString(26, userPaymentAssetsDaoEntity2.getHolderName());
                }
                if (userPaymentAssetsDaoEntity2.getInstLogoUrl() == null) {
                    supportSQLiteStatement.bindNull(27);
                } else {
                    supportSQLiteStatement.bindString(27, userPaymentAssetsDaoEntity2.getInstLogoUrl());
                }
                if (userPaymentAssetsDaoEntity2.getInstId() == null) {
                    supportSQLiteStatement.bindNull(28);
                } else {
                    supportSQLiteStatement.bindString(28, userPaymentAssetsDaoEntity2.getInstId());
                }
                if (userPaymentAssetsDaoEntity2.getInstOfficialName() == null) {
                    supportSQLiteStatement.bindNull(29);
                } else {
                    supportSQLiteStatement.bindString(29, userPaymentAssetsDaoEntity2.getInstOfficialName());
                }
                if (userPaymentAssetsDaoEntity2.getInstBranchId() == null) {
                    supportSQLiteStatement.bindNull(30);
                } else {
                    supportSQLiteStatement.bindString(30, userPaymentAssetsDaoEntity2.getInstBranchId());
                }
                if (userPaymentAssetsDaoEntity2.getInstBranchOfficialName() == null) {
                    supportSQLiteStatement.bindNull(31);
                } else {
                    supportSQLiteStatement.bindString(31, userPaymentAssetsDaoEntity2.getInstBranchOfficialName());
                }
                if (userPaymentAssetsDaoEntity2.getExpiryYear() == null) {
                    supportSQLiteStatement.bindNull(32);
                } else {
                    supportSQLiteStatement.bindString(32, userPaymentAssetsDaoEntity2.getExpiryYear());
                }
                if (userPaymentAssetsDaoEntity2.getExpiryMonth() == null) {
                    supportSQLiteStatement.bindNull(33);
                } else {
                    supportSQLiteStatement.bindString(33, userPaymentAssetsDaoEntity2.getExpiryMonth());
                }
                if ((userPaymentAssetsDaoEntity2.getVerified() == null ? null : Integer.valueOf(userPaymentAssetsDaoEntity2.getVerified().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(34);
                } else {
                    supportSQLiteStatement.bindLong(34, r0.intValue());
                }
                if (userPaymentAssetsDaoEntity2.getBindingId() == null) {
                    supportSQLiteStatement.bindNull(35);
                } else {
                    supportSQLiteStatement.bindString(35, userPaymentAssetsDaoEntity2.getBindingId());
                }
                if (userPaymentAssetsDaoEntity2.getAccountNo() == null) {
                    supportSQLiteStatement.bindNull(36);
                } else {
                    supportSQLiteStatement.bindString(36, userPaymentAssetsDaoEntity2.getAccountNo());
                }
                if (userPaymentAssetsDaoEntity2.getDefaultAsset() == null) {
                    supportSQLiteStatement.bindNull(37);
                } else {
                    supportSQLiteStatement.bindString(37, userPaymentAssetsDaoEntity2.getDefaultAsset());
                }
                String fromStringMap = UserPaymentAssetsDao_Impl.this.__mapConverter.fromStringMap(userPaymentAssetsDaoEntity2.getExtInfo());
                if (fromStringMap == null) {
                    supportSQLiteStatement.bindNull(38);
                } else {
                    supportSQLiteStatement.bindString(38, fromStringMap);
                }
                if ((userPaymentAssetsDaoEntity2.getEnableStatus() == null ? null : Integer.valueOf(userPaymentAssetsDaoEntity2.getEnableStatus().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(39);
                } else {
                    supportSQLiteStatement.bindLong(39, r0.intValue());
                }
                if (userPaymentAssetsDaoEntity2.getBankMobileNo() == null) {
                    supportSQLiteStatement.bindNull(40);
                } else {
                    supportSQLiteStatement.bindString(40, userPaymentAssetsDaoEntity2.getBankMobileNo());
                }
                if ((userPaymentAssetsDaoEntity2.getDirectDebit() != null ? Integer.valueOf(userPaymentAssetsDaoEntity2.getDirectDebit().booleanValue() ? 1 : 0) : null) == null) {
                    supportSQLiteStatement.bindNull(41);
                } else {
                    supportSQLiteStatement.bindLong(41, r1.intValue());
                }
                if (userPaymentAssetsDaoEntity2.getPersonalDailyLimitAmount() == null) {
                    supportSQLiteStatement.bindNull(42);
                } else {
                    supportSQLiteStatement.bindString(42, userPaymentAssetsDaoEntity2.getPersonalDailyLimitAmount());
                }
                if (userPaymentAssetsDaoEntity2.getPersonalDailyLimitCurrency() == null) {
                    supportSQLiteStatement.bindNull(43);
                } else {
                    supportSQLiteStatement.bindString(43, userPaymentAssetsDaoEntity2.getPersonalDailyLimitCurrency());
                }
                if (userPaymentAssetsDaoEntity2.getPersonalDailyLimitCurrencyCode() == null) {
                    supportSQLiteStatement.bindNull(44);
                } else {
                    supportSQLiteStatement.bindString(44, userPaymentAssetsDaoEntity2.getPersonalDailyLimitCurrencyCode());
                }
                if (userPaymentAssetsDaoEntity2.getUserPhoneNo() == null) {
                    supportSQLiteStatement.bindNull(45);
                } else {
                    supportSQLiteStatement.bindString(45, userPaymentAssetsDaoEntity2.getUserPhoneNo());
                }
                if (userPaymentAssetsDaoEntity2.getContactBizType() == null) {
                    supportSQLiteStatement.bindNull(46);
                } else {
                    supportSQLiteStatement.bindString(46, userPaymentAssetsDaoEntity2.getContactBizType());
                }
                if (userPaymentAssetsDaoEntity2.getGoodsId() == null) {
                    supportSQLiteStatement.bindNull(47);
                } else {
                    supportSQLiteStatement.bindString(47, userPaymentAssetsDaoEntity2.getGoodsId());
                }
                if (userPaymentAssetsDaoEntity2.getAggregator() == null) {
                    supportSQLiteStatement.bindNull(48);
                } else {
                    supportSQLiteStatement.bindString(48, userPaymentAssetsDaoEntity2.getAggregator());
                }
                if (userPaymentAssetsDaoEntity2.getUserId() == null) {
                    supportSQLiteStatement.bindNull(49);
                } else {
                    supportSQLiteStatement.bindString(49, userPaymentAssetsDaoEntity2.getUserId());
                }
                if (userPaymentAssetsDaoEntity2.getAccountStatus() == null) {
                    supportSQLiteStatement.bindNull(50);
                } else {
                    supportSQLiteStatement.bindString(50, userPaymentAssetsDaoEntity2.getAccountStatus());
                }
                if (userPaymentAssetsDaoEntity2.getAvailableBalanceAmount() == null) {
                    supportSQLiteStatement.bindNull(51);
                } else {
                    supportSQLiteStatement.bindLong(51, userPaymentAssetsDaoEntity2.getAvailableBalanceAmount().longValue());
                }
                if (userPaymentAssetsDaoEntity2.getAvailableBalanceCent() == null) {
                    supportSQLiteStatement.bindNull(52);
                } else {
                    supportSQLiteStatement.bindLong(52, userPaymentAssetsDaoEntity2.getAvailableBalanceCent().longValue());
                }
                if (userPaymentAssetsDaoEntity2.getAvailableBalanceCentFactor() == null) {
                    supportSQLiteStatement.bindNull(53);
                } else {
                    supportSQLiteStatement.bindLong(53, userPaymentAssetsDaoEntity2.getAvailableBalanceCentFactor().longValue());
                }
                if (userPaymentAssetsDaoEntity2.getAvailableBalanceCurrency() == null) {
                    supportSQLiteStatement.bindNull(54);
                } else {
                    supportSQLiteStatement.bindString(54, userPaymentAssetsDaoEntity2.getAvailableBalanceCurrency());
                }
                if (userPaymentAssetsDaoEntity2.getAvailableBalanceCurrencyCode() == null) {
                    supportSQLiteStatement.bindNull(55);
                } else {
                    supportSQLiteStatement.bindString(55, userPaymentAssetsDaoEntity2.getAvailableBalanceCurrencyCode());
                }
                if (userPaymentAssetsDaoEntity2.getAvailableBalanceCurrencyValue() == null) {
                    supportSQLiteStatement.bindNull(56);
                } else {
                    supportSQLiteStatement.bindString(56, userPaymentAssetsDaoEntity2.getAvailableBalanceCurrencyValue());
                }
                if (userPaymentAssetsDaoEntity2.getBalanceUnitType() == null) {
                    supportSQLiteStatement.bindNull(57);
                } else {
                    supportSQLiteStatement.bindString(57, userPaymentAssetsDaoEntity2.getBalanceUnitType());
                }
                if (userPaymentAssetsDaoEntity2.getBalanceUnitUnit() == null) {
                    supportSQLiteStatement.bindNull(58);
                } else {
                    supportSQLiteStatement.bindLong(58, userPaymentAssetsDaoEntity2.getBalanceUnitUnit().longValue());
                }
                if (userPaymentAssetsDaoEntity2.getBalanceUnitUnitValue() == null) {
                    supportSQLiteStatement.bindNull(59);
                } else {
                    supportSQLiteStatement.bindString(59, userPaymentAssetsDaoEntity2.getBalanceUnitUnitValue());
                }
                if (userPaymentAssetsDaoEntity2.getTotalGainLossAmountAmount() == null) {
                    supportSQLiteStatement.bindNull(60);
                } else {
                    supportSQLiteStatement.bindLong(60, userPaymentAssetsDaoEntity2.getTotalGainLossAmountAmount().longValue());
                }
                if (userPaymentAssetsDaoEntity2.getTotalGainLossAmountCent() == null) {
                    supportSQLiteStatement.bindNull(61);
                } else {
                    supportSQLiteStatement.bindLong(61, userPaymentAssetsDaoEntity2.getTotalGainLossAmountCent().longValue());
                }
                if (userPaymentAssetsDaoEntity2.getTotalGainLossAmountCentFactor() == null) {
                    supportSQLiteStatement.bindNull(62);
                } else {
                    supportSQLiteStatement.bindLong(62, userPaymentAssetsDaoEntity2.getTotalGainLossAmountCentFactor().longValue());
                }
                if (userPaymentAssetsDaoEntity2.getTotalGainLossAmountCurrency() == null) {
                    supportSQLiteStatement.bindNull(63);
                } else {
                    supportSQLiteStatement.bindString(63, userPaymentAssetsDaoEntity2.getTotalGainLossAmountCurrency());
                }
                if (userPaymentAssetsDaoEntity2.getTotalGainLossAmountCurrencyCode() == null) {
                    supportSQLiteStatement.bindNull(64);
                } else {
                    supportSQLiteStatement.bindString(64, userPaymentAssetsDaoEntity2.getTotalGainLossAmountCurrencyCode());
                }
                if (userPaymentAssetsDaoEntity2.getTotalGainLossAmountCurrencyValue() == null) {
                    supportSQLiteStatement.bindNull(65);
                } else {
                    supportSQLiteStatement.bindString(65, userPaymentAssetsDaoEntity2.getTotalGainLossAmountCurrencyValue());
                }
                if (userPaymentAssetsDaoEntity2.getTotalGainLossPercentage() == null) {
                    supportSQLiteStatement.bindNull(66);
                } else {
                    supportSQLiteStatement.bindString(66, userPaymentAssetsDaoEntity2.getTotalGainLossPercentage());
                }
                if (userPaymentAssetsDaoEntity2.getDailyGainLossAmountAmount() == null) {
                    supportSQLiteStatement.bindNull(67);
                } else {
                    supportSQLiteStatement.bindLong(67, userPaymentAssetsDaoEntity2.getDailyGainLossAmountAmount().longValue());
                }
                if (userPaymentAssetsDaoEntity2.getDailyGainLossAmountCent() == null) {
                    supportSQLiteStatement.bindNull(68);
                } else {
                    supportSQLiteStatement.bindLong(68, userPaymentAssetsDaoEntity2.getDailyGainLossAmountCent().longValue());
                }
                if (userPaymentAssetsDaoEntity2.getDailyGainLossAmountCentFactor() == null) {
                    supportSQLiteStatement.bindNull(69);
                } else {
                    supportSQLiteStatement.bindLong(69, userPaymentAssetsDaoEntity2.getDailyGainLossAmountCentFactor().longValue());
                }
                if (userPaymentAssetsDaoEntity2.getDailyGainLossAmountCurrency() == null) {
                    supportSQLiteStatement.bindNull(70);
                } else {
                    supportSQLiteStatement.bindString(70, userPaymentAssetsDaoEntity2.getDailyGainLossAmountCurrency());
                }
                if (userPaymentAssetsDaoEntity2.getDailyGainLossAmountCurrencyCode() == null) {
                    supportSQLiteStatement.bindNull(71);
                } else {
                    supportSQLiteStatement.bindString(71, userPaymentAssetsDaoEntity2.getDailyGainLossAmountCurrencyCode());
                }
                if (userPaymentAssetsDaoEntity2.getDailyGainLossAmountCurrencyValue() == null) {
                    supportSQLiteStatement.bindNull(72);
                } else {
                    supportSQLiteStatement.bindString(72, userPaymentAssetsDaoEntity2.getDailyGainLossAmountCurrencyValue());
                }
                if (userPaymentAssetsDaoEntity2.getDailyGainLossPercentage() == null) {
                    supportSQLiteStatement.bindNull(73);
                } else {
                    supportSQLiteStatement.bindString(73, userPaymentAssetsDaoEntity2.getDailyGainLossPercentage());
                }
                if (userPaymentAssetsDaoEntity2.getLastUpdated() == null) {
                    supportSQLiteStatement.bindNull(74);
                } else {
                    supportSQLiteStatement.bindLong(74, userPaymentAssetsDaoEntity2.getLastUpdated().longValue());
                }
                if (userPaymentAssetsDaoEntity2.getSavingId() == null) {
                    supportSQLiteStatement.bindNull(75);
                } else {
                    supportSQLiteStatement.bindString(75, userPaymentAssetsDaoEntity2.getSavingId());
                }
                if (userPaymentAssetsDaoEntity2.getTitle() == null) {
                    supportSQLiteStatement.bindNull(76);
                } else {
                    supportSQLiteStatement.bindString(76, userPaymentAssetsDaoEntity2.getTitle());
                }
                if (userPaymentAssetsDaoEntity2.getCategoryCode() == null) {
                    supportSQLiteStatement.bindNull(77);
                } else {
                    supportSQLiteStatement.bindString(77, userPaymentAssetsDaoEntity2.getCategoryCode());
                }
                if (userPaymentAssetsDaoEntity2.getCurrentAmountAmount() == null) {
                    supportSQLiteStatement.bindNull(78);
                } else {
                    supportSQLiteStatement.bindString(78, userPaymentAssetsDaoEntity2.getCurrentAmountAmount());
                }
                if (userPaymentAssetsDaoEntity2.getCurrentAmountCurrency() == null) {
                    supportSQLiteStatement.bindNull(79);
                } else {
                    supportSQLiteStatement.bindString(79, userPaymentAssetsDaoEntity2.getCurrentAmountCurrency());
                }
                if (userPaymentAssetsDaoEntity2.getCurrentAmountCurrencyCode() == null) {
                    supportSQLiteStatement.bindNull(80);
                } else {
                    supportSQLiteStatement.bindString(80, userPaymentAssetsDaoEntity2.getCurrentAmountCurrencyCode());
                }
                if (userPaymentAssetsDaoEntity2.getTargetAmountAmount() == null) {
                    supportSQLiteStatement.bindNull(81);
                } else {
                    supportSQLiteStatement.bindString(81, userPaymentAssetsDaoEntity2.getTargetAmountAmount());
                }
                if (userPaymentAssetsDaoEntity2.getTargetAmountCurrency() == null) {
                    supportSQLiteStatement.bindNull(82);
                } else {
                    supportSQLiteStatement.bindString(82, userPaymentAssetsDaoEntity2.getTargetAmountCurrency());
                }
                if (userPaymentAssetsDaoEntity2.getTargetAmountCurrencyCode() == null) {
                    supportSQLiteStatement.bindNull(83);
                } else {
                    supportSQLiteStatement.bindString(83, userPaymentAssetsDaoEntity2.getTargetAmountCurrencyCode());
                }
                if (userPaymentAssetsDaoEntity2.getOrderStatus() == null) {
                    supportSQLiteStatement.bindNull(84);
                } else {
                    supportSQLiteStatement.bindString(84, userPaymentAssetsDaoEntity2.getOrderStatus());
                }
                if (userPaymentAssetsDaoEntity2.getOrderSubStatus() == null) {
                    supportSQLiteStatement.bindNull(85);
                } else {
                    supportSQLiteStatement.bindString(85, userPaymentAssetsDaoEntity2.getOrderSubStatus());
                }
                if (userPaymentAssetsDaoEntity2.getCreatedTime() == null) {
                    supportSQLiteStatement.bindNull(86);
                } else {
                    supportSQLiteStatement.bindLong(86, userPaymentAssetsDaoEntity2.getCreatedTime().longValue());
                }
                if (userPaymentAssetsDaoEntity2.getAchievedTime() == null) {
                    supportSQLiteStatement.bindNull(87);
                } else {
                    supportSQLiteStatement.bindLong(87, userPaymentAssetsDaoEntity2.getAchievedTime().longValue());
                }
                if (userPaymentAssetsDaoEntity2.getCompletedTime() == null) {
                    supportSQLiteStatement.bindNull(88);
                } else {
                    supportSQLiteStatement.bindLong(88, userPaymentAssetsDaoEntity2.getCompletedTime().longValue());
                }
                String fromStringMap2 = UserPaymentAssetsDao_Impl.this.__mapConverter.fromStringMap(userPaymentAssetsDaoEntity2.getExtendInfo());
                if (fromStringMap2 == null) {
                    supportSQLiteStatement.bindNull(89);
                } else {
                    supportSQLiteStatement.bindString(89, fromStringMap2);
                }
                if (userPaymentAssetsDaoEntity2.getCardBackground() == null) {
                    supportSQLiteStatement.bindNull(90);
                } else {
                    supportSQLiteStatement.bindString(90, userPaymentAssetsDaoEntity2.getCardBackground());
                }
                if (userPaymentAssetsDaoEntity2.getCacheTimestamp() == null) {
                    supportSQLiteStatement.bindNull(91);
                } else {
                    supportSQLiteStatement.bindLong(91, userPaymentAssetsDaoEntity2.getCacheTimestamp().longValue());
                }
            }
        };
        this.__preparedStmtOfClearUserPaymentAssets = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.wallet_v3.repository.source.persistence.dao.UserPaymentAssetsDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM UserPaymentAssetsDaoEntity";
            }
        };
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPaymentAssetsDao
    public final long[] saveUserPaymentAssets(UserPaymentAssetsDaoEntity... userPaymentAssetsDaoEntityArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long[] insertAndReturnIdsArray = this.__insertionAdapterOfUserPaymentAssetsDaoEntity.insertAndReturnIdsArray(userPaymentAssetsDaoEntityArr);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArray;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPaymentAssetsDao
    public final void clearUserPaymentAssets() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClearUserPaymentAssets.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfClearUserPaymentAssets.release(acquire);
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPaymentAssetsDao
    public final List<UserPaymentAssetsDaoEntity> getAllUserPaymentAssets(List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        String string;
        int i;
        int i2;
        int i3;
        String string2;
        Boolean valueOf;
        int i4;
        String string3;
        int i5;
        String string4;
        int i6;
        String string5;
        int i7;
        String string6;
        int i8;
        String string7;
        int i9;
        String string8;
        int i10;
        String string9;
        int i11;
        String string10;
        int i12;
        String string11;
        int i13;
        String string12;
        int i14;
        String string13;
        int i15;
        String string14;
        int i16;
        String string15;
        int i17;
        String string16;
        int i18;
        String string17;
        int i19;
        String string18;
        int i20;
        String string19;
        int i21;
        String string20;
        int i22;
        Boolean valueOf2;
        int i23;
        String string21;
        int i24;
        String string22;
        int i25;
        String string23;
        int i26;
        String string24;
        Boolean valueOf3;
        int i27;
        String string25;
        int i28;
        Boolean valueOf4;
        int i29;
        String string26;
        int i30;
        String string27;
        int i31;
        String string28;
        int i32;
        String string29;
        int i33;
        String string30;
        int i34;
        String string31;
        int i35;
        String string32;
        int i36;
        String string33;
        int i37;
        String string34;
        int i38;
        Long valueOf5;
        int i39;
        Long valueOf6;
        int i40;
        Long valueOf7;
        int i41;
        String string35;
        int i42;
        String string36;
        int i43;
        String string37;
        int i44;
        String string38;
        int i45;
        Long valueOf8;
        int i46;
        String string39;
        int i47;
        Long valueOf9;
        int i48;
        Long valueOf10;
        int i49;
        Long valueOf11;
        int i50;
        String string40;
        int i51;
        String string41;
        int i52;
        String string42;
        int i53;
        String string43;
        int i54;
        Long valueOf12;
        int i55;
        Long valueOf13;
        int i56;
        Long valueOf14;
        int i57;
        String string44;
        int i58;
        String string45;
        int i59;
        String string46;
        int i60;
        String string47;
        int i61;
        Long valueOf15;
        int i62;
        String string48;
        int i63;
        String string49;
        int i64;
        String string50;
        int i65;
        String string51;
        int i66;
        String string52;
        int i67;
        String string53;
        int i68;
        String string54;
        int i69;
        String string55;
        int i70;
        String string56;
        int i71;
        String string57;
        int i72;
        String string58;
        int i73;
        Long valueOf16;
        int i74;
        Long valueOf17;
        int i75;
        Long valueOf18;
        int i76;
        String string59;
        String string60;
        int i77;
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("SELECT * FROM UserPaymentAssetsDaoEntity WHERE assetType IN (");
        int size = list.size();
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, size);
        KClassImpl$Data$declaredNonStaticMembers$2.append(")");
        RoomSQLiteQuery authRequestContext14 = RoomSQLiteQuery.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.toString(), size + 0);
        int i78 = 1;
        for (String str : list) {
            if (str == null) {
                authRequestContext14.bindNull(i78);
            } else {
                authRequestContext14.bindString(i78, str);
            }
            i78++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext14, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "uniqueId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, HomeTabActivity.WALLET_SECTION);
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "amount");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, FirebaseAnalytics.Param.CURRENCY);
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "limitAmount");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "limitCurrency");
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "limitCurrencyCode");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "balanceAmount");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "balanceCurrency");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "balanceCurrencyCode");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "unpaidAmountAmount");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "unpaidAmountCurrency");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "unpaidAmountCurrencyCode");
            roomSQLiteQuery = authRequestContext14;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext14;
        }
        try {
            int authRequestContext15 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "overdueTips");
            try {
                int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "overdueStatus");
                int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "accountId");
                int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "gmtCreate");
                int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "gmtModified");
                int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "assetBiztype");
                int authRequestContext21 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "cardTitle");
                int authRequestContext22 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, WalletConstant.CARD_INDEX_NO);
                int authRequestContext23 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "cardNoLength");
                int authRequestContext24 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "maskedCardNo");
                int authRequestContext25 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "assetType");
                int authRequestContext26 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "cardScheme");
                int authRequestContext27 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "holderName");
                int authRequestContext28 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "instLogoUrl");
                int authRequestContext29 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "instId");
                int authRequestContext30 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "instOfficialName");
                int authRequestContext31 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "instBranchId");
                int authRequestContext32 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "instBranchOfficialName");
                int authRequestContext33 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "expiryYear");
                int authRequestContext34 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "expiryMonth");
                int authRequestContext35 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "verified");
                int authRequestContext36 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "bindingId");
                int authRequestContext37 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "accountNo");
                int authRequestContext38 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "defaultAsset");
                int authRequestContext39 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "extInfo");
                int authRequestContext40 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "enableStatus");
                int authRequestContext41 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "bankMobileNo");
                int authRequestContext42 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "directDebit");
                int authRequestContext43 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "personalDailyLimitAmount");
                int authRequestContext44 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "personalDailyLimitCurrency");
                int authRequestContext45 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "personalDailyLimitCurrencyCode");
                int authRequestContext46 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "userPhoneNo");
                int authRequestContext47 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "contactBizType");
                int authRequestContext48 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "goodsId");
                int authRequestContext49 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "aggregator");
                int authRequestContext50 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "userId");
                int authRequestContext51 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "accountStatus");
                int authRequestContext52 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "availableBalanceAmount");
                int authRequestContext53 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "availableBalanceCent");
                int authRequestContext54 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "availableBalanceCentFactor");
                int authRequestContext55 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "availableBalanceCurrency");
                int authRequestContext56 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "availableBalanceCurrencyCode");
                int authRequestContext57 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "availableBalanceCurrencyValue");
                int authRequestContext58 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "balanceUnitType");
                int authRequestContext59 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "balanceUnitUnit");
                int authRequestContext60 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "balanceUnitUnitValue");
                int authRequestContext61 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "totalGainLossAmountAmount");
                int authRequestContext62 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "totalGainLossAmountCent");
                int authRequestContext63 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "totalGainLossAmountCentFactor");
                int authRequestContext64 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "totalGainLossAmountCurrency");
                int authRequestContext65 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "totalGainLossAmountCurrencyCode");
                int authRequestContext66 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "totalGainLossAmountCurrencyValue");
                int authRequestContext67 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "totalGainLossPercentage");
                int authRequestContext68 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "dailyGainLossAmountAmount");
                int authRequestContext69 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "dailyGainLossAmountCent");
                int authRequestContext70 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "dailyGainLossAmountCentFactor");
                int authRequestContext71 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "dailyGainLossAmountCurrency");
                int authRequestContext72 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "dailyGainLossAmountCurrencyCode");
                int authRequestContext73 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "dailyGainLossAmountCurrencyValue");
                int authRequestContext74 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "dailyGainLossPercentage");
                int authRequestContext75 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, BaseKey.LAST_UPDATED);
                int authRequestContext76 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "savingId");
                int authRequestContext77 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "title");
                int authRequestContext78 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "categoryCode");
                int authRequestContext79 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "currentAmountAmount");
                int authRequestContext80 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "currentAmountCurrency");
                int authRequestContext81 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "currentAmountCurrencyCode");
                int authRequestContext82 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "targetAmountAmount");
                int authRequestContext83 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "targetAmountCurrency");
                int authRequestContext84 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "targetAmountCurrencyCode");
                int authRequestContext85 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "orderStatus");
                int authRequestContext86 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "orderSubStatus");
                int authRequestContext87 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "createdTime");
                int authRequestContext88 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "achievedTime");
                int authRequestContext89 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "completedTime");
                int authRequestContext90 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "extendInfo");
                int authRequestContext91 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "cardBackground");
                int authRequestContext92 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "cacheTimestamp");
                int i79 = authRequestContext15;
                ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$22.getCount());
                while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                    String string61 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext);
                    String string62 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext2);
                    String string63 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext3);
                    String string64 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext4);
                    String string65 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext5);
                    String string66 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext6);
                    String string67 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext7) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext7);
                    String string68 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext8);
                    String string69 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext9);
                    String string70 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext10);
                    String string71 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext11);
                    String string72 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext12);
                    if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext13)) {
                        i = i79;
                        string = null;
                    } else {
                        string = KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext13);
                        i = i79;
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i)) {
                        i2 = authRequestContext;
                        i79 = i;
                        i3 = authRequestContext12;
                        string2 = null;
                    } else {
                        i2 = authRequestContext;
                        i3 = authRequestContext12;
                        string2 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i);
                        i79 = i;
                    }
                    try {
                        List<String> fromString = this.__stringConverter.fromString(string2);
                        int i80 = authRequestContext16;
                        Integer valueOf19 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i80) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(i80));
                        if (valueOf19 == null) {
                            i4 = authRequestContext17;
                            valueOf = null;
                        } else {
                            valueOf = Boolean.valueOf(valueOf19.intValue() != 0);
                            i4 = authRequestContext17;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i4)) {
                            authRequestContext16 = i80;
                            i5 = authRequestContext18;
                            string3 = null;
                        } else {
                            string3 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i4);
                            authRequestContext16 = i80;
                            i5 = authRequestContext18;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i5)) {
                            authRequestContext18 = i5;
                            i6 = authRequestContext19;
                            string4 = null;
                        } else {
                            authRequestContext18 = i5;
                            string4 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i5);
                            i6 = authRequestContext19;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i6)) {
                            authRequestContext19 = i6;
                            i7 = authRequestContext20;
                            string5 = null;
                        } else {
                            authRequestContext19 = i6;
                            string5 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i6);
                            i7 = authRequestContext20;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i7)) {
                            authRequestContext20 = i7;
                            i8 = authRequestContext21;
                            string6 = null;
                        } else {
                            authRequestContext20 = i7;
                            string6 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i7);
                            i8 = authRequestContext21;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i8)) {
                            authRequestContext21 = i8;
                            i9 = authRequestContext22;
                            string7 = null;
                        } else {
                            authRequestContext21 = i8;
                            string7 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i8);
                            i9 = authRequestContext22;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i9)) {
                            authRequestContext22 = i9;
                            i10 = authRequestContext23;
                            string8 = null;
                        } else {
                            authRequestContext22 = i9;
                            string8 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i9);
                            i10 = authRequestContext23;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i10)) {
                            authRequestContext23 = i10;
                            i11 = authRequestContext24;
                            string9 = null;
                        } else {
                            authRequestContext23 = i10;
                            string9 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i10);
                            i11 = authRequestContext24;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i11)) {
                            authRequestContext24 = i11;
                            i12 = authRequestContext25;
                            string10 = null;
                        } else {
                            authRequestContext24 = i11;
                            string10 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i11);
                            i12 = authRequestContext25;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i12)) {
                            authRequestContext25 = i12;
                            i13 = authRequestContext26;
                            string11 = null;
                        } else {
                            authRequestContext25 = i12;
                            string11 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i12);
                            i13 = authRequestContext26;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i13)) {
                            authRequestContext26 = i13;
                            i14 = authRequestContext27;
                            string12 = null;
                        } else {
                            authRequestContext26 = i13;
                            string12 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i13);
                            i14 = authRequestContext27;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i14)) {
                            authRequestContext27 = i14;
                            i15 = authRequestContext28;
                            string13 = null;
                        } else {
                            authRequestContext27 = i14;
                            string13 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i14);
                            i15 = authRequestContext28;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i15)) {
                            authRequestContext28 = i15;
                            i16 = authRequestContext29;
                            string14 = null;
                        } else {
                            authRequestContext28 = i15;
                            string14 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i15);
                            i16 = authRequestContext29;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i16)) {
                            authRequestContext29 = i16;
                            i17 = authRequestContext30;
                            string15 = null;
                        } else {
                            authRequestContext29 = i16;
                            string15 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i16);
                            i17 = authRequestContext30;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i17)) {
                            authRequestContext30 = i17;
                            i18 = authRequestContext31;
                            string16 = null;
                        } else {
                            authRequestContext30 = i17;
                            string16 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i17);
                            i18 = authRequestContext31;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i18)) {
                            authRequestContext31 = i18;
                            i19 = authRequestContext32;
                            string17 = null;
                        } else {
                            authRequestContext31 = i18;
                            string17 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i18);
                            i19 = authRequestContext32;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i19)) {
                            authRequestContext32 = i19;
                            i20 = authRequestContext33;
                            string18 = null;
                        } else {
                            authRequestContext32 = i19;
                            string18 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i19);
                            i20 = authRequestContext33;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i20)) {
                            authRequestContext33 = i20;
                            i21 = authRequestContext34;
                            string19 = null;
                        } else {
                            authRequestContext33 = i20;
                            string19 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i20);
                            i21 = authRequestContext34;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i21)) {
                            authRequestContext34 = i21;
                            i22 = authRequestContext35;
                            string20 = null;
                        } else {
                            authRequestContext34 = i21;
                            string20 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i21);
                            i22 = authRequestContext35;
                        }
                        Integer valueOf20 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i22) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(i22));
                        if (valueOf20 == null) {
                            authRequestContext35 = i22;
                            i23 = authRequestContext36;
                            valueOf2 = null;
                        } else {
                            authRequestContext35 = i22;
                            valueOf2 = Boolean.valueOf(valueOf20.intValue() != 0);
                            i23 = authRequestContext36;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i23)) {
                            authRequestContext36 = i23;
                            i24 = authRequestContext37;
                            string21 = null;
                        } else {
                            authRequestContext36 = i23;
                            string21 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i23);
                            i24 = authRequestContext37;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i24)) {
                            authRequestContext37 = i24;
                            i25 = authRequestContext38;
                            string22 = null;
                        } else {
                            authRequestContext37 = i24;
                            string22 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i24);
                            i25 = authRequestContext38;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i25)) {
                            authRequestContext38 = i25;
                            i26 = authRequestContext39;
                            string23 = null;
                        } else {
                            authRequestContext38 = i25;
                            string23 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i25);
                            i26 = authRequestContext39;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i26)) {
                            authRequestContext39 = i26;
                            authRequestContext17 = i4;
                            string24 = null;
                        } else {
                            authRequestContext39 = i26;
                            string24 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i26);
                            authRequestContext17 = i4;
                        }
                        Map<String, String> fromString2 = this.__mapConverter.fromString(string24);
                        int i81 = authRequestContext40;
                        Integer valueOf21 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i81) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(i81));
                        if (valueOf21 == null) {
                            i27 = authRequestContext41;
                            valueOf3 = null;
                        } else {
                            valueOf3 = Boolean.valueOf(valueOf21.intValue() != 0);
                            i27 = authRequestContext41;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i27)) {
                            authRequestContext40 = i81;
                            i28 = authRequestContext42;
                            string25 = null;
                        } else {
                            string25 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i27);
                            authRequestContext40 = i81;
                            i28 = authRequestContext42;
                        }
                        Integer valueOf22 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i28) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(i28));
                        if (valueOf22 == null) {
                            authRequestContext42 = i28;
                            i29 = authRequestContext43;
                            valueOf4 = null;
                        } else {
                            authRequestContext42 = i28;
                            valueOf4 = Boolean.valueOf(valueOf22.intValue() != 0);
                            i29 = authRequestContext43;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i29)) {
                            authRequestContext43 = i29;
                            i30 = authRequestContext44;
                            string26 = null;
                        } else {
                            authRequestContext43 = i29;
                            string26 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i29);
                            i30 = authRequestContext44;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i30)) {
                            authRequestContext44 = i30;
                            i31 = authRequestContext45;
                            string27 = null;
                        } else {
                            authRequestContext44 = i30;
                            string27 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i30);
                            i31 = authRequestContext45;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i31)) {
                            authRequestContext45 = i31;
                            i32 = authRequestContext46;
                            string28 = null;
                        } else {
                            authRequestContext45 = i31;
                            string28 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i31);
                            i32 = authRequestContext46;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i32)) {
                            authRequestContext46 = i32;
                            i33 = authRequestContext47;
                            string29 = null;
                        } else {
                            authRequestContext46 = i32;
                            string29 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i32);
                            i33 = authRequestContext47;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i33)) {
                            authRequestContext47 = i33;
                            i34 = authRequestContext48;
                            string30 = null;
                        } else {
                            authRequestContext47 = i33;
                            string30 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i33);
                            i34 = authRequestContext48;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i34)) {
                            authRequestContext48 = i34;
                            i35 = authRequestContext49;
                            string31 = null;
                        } else {
                            authRequestContext48 = i34;
                            string31 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i34);
                            i35 = authRequestContext49;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i35)) {
                            authRequestContext49 = i35;
                            i36 = authRequestContext50;
                            string32 = null;
                        } else {
                            authRequestContext49 = i35;
                            string32 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i35);
                            i36 = authRequestContext50;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i36)) {
                            authRequestContext50 = i36;
                            i37 = authRequestContext51;
                            string33 = null;
                        } else {
                            authRequestContext50 = i36;
                            string33 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i36);
                            i37 = authRequestContext51;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i37)) {
                            authRequestContext51 = i37;
                            i38 = authRequestContext52;
                            string34 = null;
                        } else {
                            authRequestContext51 = i37;
                            string34 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i37);
                            i38 = authRequestContext52;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i38)) {
                            authRequestContext52 = i38;
                            i39 = authRequestContext53;
                            valueOf5 = null;
                        } else {
                            authRequestContext52 = i38;
                            valueOf5 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i38));
                            i39 = authRequestContext53;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i39)) {
                            authRequestContext53 = i39;
                            i40 = authRequestContext54;
                            valueOf6 = null;
                        } else {
                            authRequestContext53 = i39;
                            valueOf6 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i39));
                            i40 = authRequestContext54;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i40)) {
                            authRequestContext54 = i40;
                            i41 = authRequestContext55;
                            valueOf7 = null;
                        } else {
                            authRequestContext54 = i40;
                            valueOf7 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i40));
                            i41 = authRequestContext55;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i41)) {
                            authRequestContext55 = i41;
                            i42 = authRequestContext56;
                            string35 = null;
                        } else {
                            authRequestContext55 = i41;
                            string35 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i41);
                            i42 = authRequestContext56;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i42)) {
                            authRequestContext56 = i42;
                            i43 = authRequestContext57;
                            string36 = null;
                        } else {
                            authRequestContext56 = i42;
                            string36 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i42);
                            i43 = authRequestContext57;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i43)) {
                            authRequestContext57 = i43;
                            i44 = authRequestContext58;
                            string37 = null;
                        } else {
                            authRequestContext57 = i43;
                            string37 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i43);
                            i44 = authRequestContext58;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i44)) {
                            authRequestContext58 = i44;
                            i45 = authRequestContext59;
                            string38 = null;
                        } else {
                            authRequestContext58 = i44;
                            string38 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i44);
                            i45 = authRequestContext59;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i45)) {
                            authRequestContext59 = i45;
                            i46 = authRequestContext60;
                            valueOf8 = null;
                        } else {
                            authRequestContext59 = i45;
                            valueOf8 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i45));
                            i46 = authRequestContext60;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i46)) {
                            authRequestContext60 = i46;
                            i47 = authRequestContext61;
                            string39 = null;
                        } else {
                            authRequestContext60 = i46;
                            string39 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i46);
                            i47 = authRequestContext61;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i47)) {
                            authRequestContext61 = i47;
                            i48 = authRequestContext62;
                            valueOf9 = null;
                        } else {
                            authRequestContext61 = i47;
                            valueOf9 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i47));
                            i48 = authRequestContext62;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i48)) {
                            authRequestContext62 = i48;
                            i49 = authRequestContext63;
                            valueOf10 = null;
                        } else {
                            authRequestContext62 = i48;
                            valueOf10 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i48));
                            i49 = authRequestContext63;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i49)) {
                            authRequestContext63 = i49;
                            i50 = authRequestContext64;
                            valueOf11 = null;
                        } else {
                            authRequestContext63 = i49;
                            valueOf11 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i49));
                            i50 = authRequestContext64;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i50)) {
                            authRequestContext64 = i50;
                            i51 = authRequestContext65;
                            string40 = null;
                        } else {
                            authRequestContext64 = i50;
                            string40 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i50);
                            i51 = authRequestContext65;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i51)) {
                            authRequestContext65 = i51;
                            i52 = authRequestContext66;
                            string41 = null;
                        } else {
                            authRequestContext65 = i51;
                            string41 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i51);
                            i52 = authRequestContext66;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i52)) {
                            authRequestContext66 = i52;
                            i53 = authRequestContext67;
                            string42 = null;
                        } else {
                            authRequestContext66 = i52;
                            string42 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i52);
                            i53 = authRequestContext67;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i53)) {
                            authRequestContext67 = i53;
                            i54 = authRequestContext68;
                            string43 = null;
                        } else {
                            authRequestContext67 = i53;
                            string43 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i53);
                            i54 = authRequestContext68;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i54)) {
                            authRequestContext68 = i54;
                            i55 = authRequestContext69;
                            valueOf12 = null;
                        } else {
                            authRequestContext68 = i54;
                            valueOf12 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i54));
                            i55 = authRequestContext69;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i55)) {
                            authRequestContext69 = i55;
                            i56 = authRequestContext70;
                            valueOf13 = null;
                        } else {
                            authRequestContext69 = i55;
                            valueOf13 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i55));
                            i56 = authRequestContext70;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i56)) {
                            authRequestContext70 = i56;
                            i57 = authRequestContext71;
                            valueOf14 = null;
                        } else {
                            authRequestContext70 = i56;
                            valueOf14 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i56));
                            i57 = authRequestContext71;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i57)) {
                            authRequestContext71 = i57;
                            i58 = authRequestContext72;
                            string44 = null;
                        } else {
                            authRequestContext71 = i57;
                            string44 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i57);
                            i58 = authRequestContext72;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i58)) {
                            authRequestContext72 = i58;
                            i59 = authRequestContext73;
                            string45 = null;
                        } else {
                            authRequestContext72 = i58;
                            string45 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i58);
                            i59 = authRequestContext73;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i59)) {
                            authRequestContext73 = i59;
                            i60 = authRequestContext74;
                            string46 = null;
                        } else {
                            authRequestContext73 = i59;
                            string46 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i59);
                            i60 = authRequestContext74;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i60)) {
                            authRequestContext74 = i60;
                            i61 = authRequestContext75;
                            string47 = null;
                        } else {
                            authRequestContext74 = i60;
                            string47 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i60);
                            i61 = authRequestContext75;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i61)) {
                            authRequestContext75 = i61;
                            i62 = authRequestContext76;
                            valueOf15 = null;
                        } else {
                            authRequestContext75 = i61;
                            valueOf15 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i61));
                            i62 = authRequestContext76;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i62)) {
                            authRequestContext76 = i62;
                            i63 = authRequestContext77;
                            string48 = null;
                        } else {
                            authRequestContext76 = i62;
                            string48 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i62);
                            i63 = authRequestContext77;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i63)) {
                            authRequestContext77 = i63;
                            i64 = authRequestContext78;
                            string49 = null;
                        } else {
                            authRequestContext77 = i63;
                            string49 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i63);
                            i64 = authRequestContext78;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i64)) {
                            authRequestContext78 = i64;
                            i65 = authRequestContext79;
                            string50 = null;
                        } else {
                            authRequestContext78 = i64;
                            string50 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i64);
                            i65 = authRequestContext79;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i65)) {
                            authRequestContext79 = i65;
                            i66 = authRequestContext80;
                            string51 = null;
                        } else {
                            authRequestContext79 = i65;
                            string51 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i65);
                            i66 = authRequestContext80;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i66)) {
                            authRequestContext80 = i66;
                            i67 = authRequestContext81;
                            string52 = null;
                        } else {
                            authRequestContext80 = i66;
                            string52 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i66);
                            i67 = authRequestContext81;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i67)) {
                            authRequestContext81 = i67;
                            i68 = authRequestContext82;
                            string53 = null;
                        } else {
                            authRequestContext81 = i67;
                            string53 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i67);
                            i68 = authRequestContext82;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i68)) {
                            authRequestContext82 = i68;
                            i69 = authRequestContext83;
                            string54 = null;
                        } else {
                            authRequestContext82 = i68;
                            string54 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i68);
                            i69 = authRequestContext83;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i69)) {
                            authRequestContext83 = i69;
                            i70 = authRequestContext84;
                            string55 = null;
                        } else {
                            authRequestContext83 = i69;
                            string55 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i69);
                            i70 = authRequestContext84;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i70)) {
                            authRequestContext84 = i70;
                            i71 = authRequestContext85;
                            string56 = null;
                        } else {
                            authRequestContext84 = i70;
                            string56 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i70);
                            i71 = authRequestContext85;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i71)) {
                            authRequestContext85 = i71;
                            i72 = authRequestContext86;
                            string57 = null;
                        } else {
                            authRequestContext85 = i71;
                            string57 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i71);
                            i72 = authRequestContext86;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i72)) {
                            authRequestContext86 = i72;
                            i73 = authRequestContext87;
                            string58 = null;
                        } else {
                            authRequestContext86 = i72;
                            string58 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i72);
                            i73 = authRequestContext87;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i73)) {
                            authRequestContext87 = i73;
                            i74 = authRequestContext88;
                            valueOf16 = null;
                        } else {
                            authRequestContext87 = i73;
                            valueOf16 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i73));
                            i74 = authRequestContext88;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i74)) {
                            authRequestContext88 = i74;
                            i75 = authRequestContext89;
                            valueOf17 = null;
                        } else {
                            authRequestContext88 = i74;
                            valueOf17 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i74));
                            i75 = authRequestContext89;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i75)) {
                            authRequestContext89 = i75;
                            i76 = authRequestContext90;
                            valueOf18 = null;
                        } else {
                            authRequestContext89 = i75;
                            valueOf18 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i75));
                            i76 = authRequestContext90;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i76)) {
                            authRequestContext90 = i76;
                            authRequestContext41 = i27;
                            string59 = null;
                        } else {
                            authRequestContext90 = i76;
                            string59 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i76);
                            authRequestContext41 = i27;
                        }
                        Map<String, String> fromString3 = this.__mapConverter.fromString(string59);
                        int i82 = authRequestContext91;
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i82)) {
                            i77 = authRequestContext92;
                            string60 = null;
                        } else {
                            string60 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i82);
                            i77 = authRequestContext92;
                        }
                        authRequestContext91 = i82;
                        arrayList.add(new UserPaymentAssetsDaoEntity(string61, string62, string63, string64, string65, string66, string67, string68, string69, string70, string71, string72, string, fromString, valueOf, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, valueOf2, string21, string22, string23, fromString2, valueOf3, string25, valueOf4, string26, string27, string28, string29, string30, string31, string32, string33, string34, valueOf5, valueOf6, valueOf7, string35, string36, string37, string38, valueOf8, string39, valueOf9, valueOf10, valueOf11, string40, string41, string42, string43, valueOf12, valueOf13, valueOf14, string44, string45, string46, string47, valueOf15, string48, string49, string50, string51, string52, string53, string54, string55, string56, string57, string58, valueOf16, valueOf17, valueOf18, fromString3, string60, KClassImpl$Data$declaredNonStaticMembers$22.isNull(i77) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i77))));
                        authRequestContext92 = i77;
                        authRequestContext = i2;
                        authRequestContext12 = i3;
                    } catch (Throwable th2) {
                        th = th2;
                        KClassImpl$Data$declaredNonStaticMembers$22.close();
                        roomSQLiteQuery.MyBillsEntityDataFactory();
                        throw th;
                    }
                }
                KClassImpl$Data$declaredNonStaticMembers$22.close();
                roomSQLiteQuery.MyBillsEntityDataFactory();
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            KClassImpl$Data$declaredNonStaticMembers$22.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPaymentAssetsDao
    public final List<UserPaymentAssetsDaoEntity> getFilteredUserPaymentAssets(List<String> list, String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        int i2;
        int i3;
        String string2;
        int i4;
        Boolean valueOf;
        int i5;
        String string3;
        int i6;
        String string4;
        int i7;
        String string5;
        int i8;
        String string6;
        int i9;
        String string7;
        int i10;
        String string8;
        int i11;
        String string9;
        int i12;
        String string10;
        int i13;
        String string11;
        int i14;
        String string12;
        int i15;
        String string13;
        int i16;
        String string14;
        int i17;
        String string15;
        int i18;
        String string16;
        int i19;
        String string17;
        int i20;
        String string18;
        int i21;
        String string19;
        int i22;
        String string20;
        int i23;
        Boolean valueOf2;
        int i24;
        String string21;
        int i25;
        String string22;
        int i26;
        String string23;
        int i27;
        String string24;
        Boolean valueOf3;
        int i28;
        String string25;
        int i29;
        Boolean valueOf4;
        int i30;
        String string26;
        int i31;
        String string27;
        int i32;
        String string28;
        int i33;
        String string29;
        int i34;
        String string30;
        int i35;
        String string31;
        int i36;
        String string32;
        int i37;
        String string33;
        int i38;
        String string34;
        int i39;
        Long valueOf5;
        int i40;
        Long valueOf6;
        int i41;
        Long valueOf7;
        int i42;
        String string35;
        int i43;
        String string36;
        int i44;
        String string37;
        int i45;
        String string38;
        int i46;
        Long valueOf8;
        int i47;
        String string39;
        int i48;
        Long valueOf9;
        int i49;
        Long valueOf10;
        int i50;
        Long valueOf11;
        int i51;
        String string40;
        int i52;
        String string41;
        int i53;
        String string42;
        int i54;
        String string43;
        int i55;
        Long valueOf12;
        int i56;
        Long valueOf13;
        int i57;
        Long valueOf14;
        int i58;
        String string44;
        int i59;
        String string45;
        int i60;
        String string46;
        int i61;
        String string47;
        int i62;
        Long valueOf15;
        int i63;
        String string48;
        int i64;
        String string49;
        int i65;
        String string50;
        int i66;
        String string51;
        int i67;
        String string52;
        int i68;
        String string53;
        int i69;
        String string54;
        int i70;
        String string55;
        int i71;
        String string56;
        int i72;
        String string57;
        int i73;
        String string58;
        int i74;
        Long valueOf16;
        int i75;
        Long valueOf17;
        int i76;
        Long valueOf18;
        int i77;
        String string59;
        String string60;
        int i78;
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM UserPaymentAssetsDaoEntity WHERE assetType LIKE '%' || ? || '%'OR cardTitle LIKE '%' || ? || '%'", 2);
        String fromList = this.__stringConverter.fromList(list);
        if (fromList == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, fromList);
        }
        if (str == null) {
            authRequestContext.bindNull(2);
        } else {
            authRequestContext.bindString(2, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "uniqueId");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, HomeTabActivity.WALLET_SECTION);
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "amount");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, FirebaseAnalytics.Param.CURRENCY);
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "limitAmount");
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "limitCurrency");
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "limitCurrencyCode");
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "balanceAmount");
            int authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "balanceCurrency");
            int authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "balanceCurrencyCode");
            int authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "unpaidAmountAmount");
            int authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "unpaidAmountCurrency");
            int authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "unpaidAmountCurrencyCode");
            roomSQLiteQuery = authRequestContext;
            try {
                int authRequestContext15 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "overdueTips");
                try {
                    int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "overdueStatus");
                    int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "accountId");
                    int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "gmtCreate");
                    int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "gmtModified");
                    int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "assetBiztype");
                    int authRequestContext21 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "cardTitle");
                    int authRequestContext22 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, WalletConstant.CARD_INDEX_NO);
                    int authRequestContext23 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "cardNoLength");
                    int authRequestContext24 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "maskedCardNo");
                    int authRequestContext25 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "assetType");
                    int authRequestContext26 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "cardScheme");
                    int authRequestContext27 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "holderName");
                    int authRequestContext28 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instLogoUrl");
                    int authRequestContext29 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instId");
                    int authRequestContext30 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instOfficialName");
                    int authRequestContext31 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instBranchId");
                    int authRequestContext32 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "instBranchOfficialName");
                    int authRequestContext33 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "expiryYear");
                    int authRequestContext34 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "expiryMonth");
                    int authRequestContext35 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "verified");
                    int authRequestContext36 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "bindingId");
                    int authRequestContext37 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "accountNo");
                    int authRequestContext38 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "defaultAsset");
                    int authRequestContext39 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "extInfo");
                    int authRequestContext40 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "enableStatus");
                    int authRequestContext41 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "bankMobileNo");
                    int authRequestContext42 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "directDebit");
                    int authRequestContext43 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "personalDailyLimitAmount");
                    int authRequestContext44 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "personalDailyLimitCurrency");
                    int authRequestContext45 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "personalDailyLimitCurrencyCode");
                    int authRequestContext46 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userPhoneNo");
                    int authRequestContext47 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "contactBizType");
                    int authRequestContext48 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "goodsId");
                    int authRequestContext49 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "aggregator");
                    int authRequestContext50 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userId");
                    int authRequestContext51 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "accountStatus");
                    int authRequestContext52 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "availableBalanceAmount");
                    int authRequestContext53 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "availableBalanceCent");
                    int authRequestContext54 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "availableBalanceCentFactor");
                    int authRequestContext55 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "availableBalanceCurrency");
                    int authRequestContext56 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "availableBalanceCurrencyCode");
                    int authRequestContext57 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "availableBalanceCurrencyValue");
                    int authRequestContext58 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "balanceUnitType");
                    int authRequestContext59 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "balanceUnitUnit");
                    int authRequestContext60 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "balanceUnitUnitValue");
                    int authRequestContext61 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "totalGainLossAmountAmount");
                    int authRequestContext62 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "totalGainLossAmountCent");
                    int authRequestContext63 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "totalGainLossAmountCentFactor");
                    int authRequestContext64 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "totalGainLossAmountCurrency");
                    int authRequestContext65 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "totalGainLossAmountCurrencyCode");
                    int authRequestContext66 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "totalGainLossAmountCurrencyValue");
                    int authRequestContext67 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "totalGainLossPercentage");
                    int authRequestContext68 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dailyGainLossAmountAmount");
                    int authRequestContext69 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dailyGainLossAmountCent");
                    int authRequestContext70 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dailyGainLossAmountCentFactor");
                    int authRequestContext71 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dailyGainLossAmountCurrency");
                    int authRequestContext72 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dailyGainLossAmountCurrencyCode");
                    int authRequestContext73 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dailyGainLossAmountCurrencyValue");
                    int authRequestContext74 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "dailyGainLossPercentage");
                    int authRequestContext75 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BaseKey.LAST_UPDATED);
                    int authRequestContext76 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "savingId");
                    int authRequestContext77 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "title");
                    int authRequestContext78 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "categoryCode");
                    int authRequestContext79 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "currentAmountAmount");
                    int authRequestContext80 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "currentAmountCurrency");
                    int authRequestContext81 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "currentAmountCurrencyCode");
                    int authRequestContext82 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "targetAmountAmount");
                    int authRequestContext83 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "targetAmountCurrency");
                    int authRequestContext84 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "targetAmountCurrencyCode");
                    int authRequestContext85 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "orderStatus");
                    int authRequestContext86 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "orderSubStatus");
                    int authRequestContext87 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "createdTime");
                    int authRequestContext88 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "achievedTime");
                    int authRequestContext89 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "completedTime");
                    int authRequestContext90 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "extendInfo");
                    int authRequestContext91 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "cardBackground");
                    int authRequestContext92 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "cacheTimestamp");
                    int i79 = authRequestContext15;
                    ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
                    while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                        String string61 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                        String string62 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3);
                        String string63 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                        String string64 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                        String string65 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext6);
                        String string66 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext7) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext7);
                        String string67 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8);
                        String string68 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                        String string69 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10);
                        String string70 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext11);
                        String string71 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext12);
                        String string72 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext13) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext13);
                        if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext14)) {
                            i = i79;
                            string = null;
                        } else {
                            string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext14);
                            i = i79;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i)) {
                            i2 = authRequestContext2;
                            i4 = authRequestContext13;
                            i3 = i;
                            string2 = null;
                        } else {
                            i2 = authRequestContext2;
                            i3 = i;
                            string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i);
                            i4 = authRequestContext13;
                        }
                        try {
                            List<String> fromString = this.__stringConverter.fromString(string2);
                            int i80 = authRequestContext16;
                            Integer valueOf19 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i80) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i80));
                            if (valueOf19 == null) {
                                i5 = authRequestContext17;
                                valueOf = null;
                            } else {
                                valueOf = Boolean.valueOf(valueOf19.intValue() != 0);
                                i5 = authRequestContext17;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i5)) {
                                authRequestContext16 = i80;
                                i6 = authRequestContext18;
                                string3 = null;
                            } else {
                                authRequestContext16 = i80;
                                string3 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i5);
                                i6 = authRequestContext18;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i6)) {
                                authRequestContext18 = i6;
                                i7 = authRequestContext19;
                                string4 = null;
                            } else {
                                authRequestContext18 = i6;
                                string4 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i6);
                                i7 = authRequestContext19;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i7)) {
                                authRequestContext19 = i7;
                                i8 = authRequestContext20;
                                string5 = null;
                            } else {
                                authRequestContext19 = i7;
                                string5 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i7);
                                i8 = authRequestContext20;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i8)) {
                                authRequestContext20 = i8;
                                i9 = authRequestContext21;
                                string6 = null;
                            } else {
                                authRequestContext20 = i8;
                                string6 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i8);
                                i9 = authRequestContext21;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i9)) {
                                authRequestContext21 = i9;
                                i10 = authRequestContext22;
                                string7 = null;
                            } else {
                                authRequestContext21 = i9;
                                string7 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i9);
                                i10 = authRequestContext22;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i10)) {
                                authRequestContext22 = i10;
                                i11 = authRequestContext23;
                                string8 = null;
                            } else {
                                authRequestContext22 = i10;
                                string8 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i10);
                                i11 = authRequestContext23;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i11)) {
                                authRequestContext23 = i11;
                                i12 = authRequestContext24;
                                string9 = null;
                            } else {
                                authRequestContext23 = i11;
                                string9 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i11);
                                i12 = authRequestContext24;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i12)) {
                                authRequestContext24 = i12;
                                i13 = authRequestContext25;
                                string10 = null;
                            } else {
                                authRequestContext24 = i12;
                                string10 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i12);
                                i13 = authRequestContext25;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i13)) {
                                authRequestContext25 = i13;
                                i14 = authRequestContext26;
                                string11 = null;
                            } else {
                                authRequestContext25 = i13;
                                string11 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i13);
                                i14 = authRequestContext26;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i14)) {
                                authRequestContext26 = i14;
                                i15 = authRequestContext27;
                                string12 = null;
                            } else {
                                authRequestContext26 = i14;
                                string12 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i14);
                                i15 = authRequestContext27;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i15)) {
                                authRequestContext27 = i15;
                                i16 = authRequestContext28;
                                string13 = null;
                            } else {
                                authRequestContext27 = i15;
                                string13 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i15);
                                i16 = authRequestContext28;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i16)) {
                                authRequestContext28 = i16;
                                i17 = authRequestContext29;
                                string14 = null;
                            } else {
                                authRequestContext28 = i16;
                                string14 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i16);
                                i17 = authRequestContext29;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i17)) {
                                authRequestContext29 = i17;
                                i18 = authRequestContext30;
                                string15 = null;
                            } else {
                                authRequestContext29 = i17;
                                string15 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i17);
                                i18 = authRequestContext30;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i18)) {
                                authRequestContext30 = i18;
                                i19 = authRequestContext31;
                                string16 = null;
                            } else {
                                authRequestContext30 = i18;
                                string16 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i18);
                                i19 = authRequestContext31;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i19)) {
                                authRequestContext31 = i19;
                                i20 = authRequestContext32;
                                string17 = null;
                            } else {
                                authRequestContext31 = i19;
                                string17 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i19);
                                i20 = authRequestContext32;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i20)) {
                                authRequestContext32 = i20;
                                i21 = authRequestContext33;
                                string18 = null;
                            } else {
                                authRequestContext32 = i20;
                                string18 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i20);
                                i21 = authRequestContext33;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i21)) {
                                authRequestContext33 = i21;
                                i22 = authRequestContext34;
                                string19 = null;
                            } else {
                                authRequestContext33 = i21;
                                string19 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i21);
                                i22 = authRequestContext34;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i22)) {
                                authRequestContext34 = i22;
                                i23 = authRequestContext35;
                                string20 = null;
                            } else {
                                authRequestContext34 = i22;
                                string20 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i22);
                                i23 = authRequestContext35;
                            }
                            Integer valueOf20 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i23) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i23));
                            if (valueOf20 == null) {
                                authRequestContext35 = i23;
                                i24 = authRequestContext36;
                                valueOf2 = null;
                            } else {
                                authRequestContext35 = i23;
                                valueOf2 = Boolean.valueOf(valueOf20.intValue() != 0);
                                i24 = authRequestContext36;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i24)) {
                                authRequestContext36 = i24;
                                i25 = authRequestContext37;
                                string21 = null;
                            } else {
                                authRequestContext36 = i24;
                                string21 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i24);
                                i25 = authRequestContext37;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i25)) {
                                authRequestContext37 = i25;
                                i26 = authRequestContext38;
                                string22 = null;
                            } else {
                                authRequestContext37 = i25;
                                string22 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i25);
                                i26 = authRequestContext38;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i26)) {
                                authRequestContext38 = i26;
                                i27 = authRequestContext39;
                                string23 = null;
                            } else {
                                authRequestContext38 = i26;
                                string23 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i26);
                                i27 = authRequestContext39;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i27)) {
                                authRequestContext39 = i27;
                                authRequestContext17 = i5;
                                string24 = null;
                            } else {
                                authRequestContext39 = i27;
                                string24 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i27);
                                authRequestContext17 = i5;
                            }
                            Map<String, String> fromString2 = this.__mapConverter.fromString(string24);
                            int i81 = authRequestContext40;
                            Integer valueOf21 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i81) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i81));
                            if (valueOf21 == null) {
                                i28 = authRequestContext41;
                                valueOf3 = null;
                            } else {
                                valueOf3 = Boolean.valueOf(valueOf21.intValue() != 0);
                                i28 = authRequestContext41;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i28)) {
                                authRequestContext40 = i81;
                                i29 = authRequestContext42;
                                string25 = null;
                            } else {
                                string25 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i28);
                                authRequestContext40 = i81;
                                i29 = authRequestContext42;
                            }
                            Integer valueOf22 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i29) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i29));
                            if (valueOf22 == null) {
                                authRequestContext42 = i29;
                                i30 = authRequestContext43;
                                valueOf4 = null;
                            } else {
                                authRequestContext42 = i29;
                                valueOf4 = Boolean.valueOf(valueOf22.intValue() != 0);
                                i30 = authRequestContext43;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i30)) {
                                authRequestContext43 = i30;
                                i31 = authRequestContext44;
                                string26 = null;
                            } else {
                                authRequestContext43 = i30;
                                string26 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i30);
                                i31 = authRequestContext44;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i31)) {
                                authRequestContext44 = i31;
                                i32 = authRequestContext45;
                                string27 = null;
                            } else {
                                authRequestContext44 = i31;
                                string27 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i31);
                                i32 = authRequestContext45;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i32)) {
                                authRequestContext45 = i32;
                                i33 = authRequestContext46;
                                string28 = null;
                            } else {
                                authRequestContext45 = i32;
                                string28 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i32);
                                i33 = authRequestContext46;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i33)) {
                                authRequestContext46 = i33;
                                i34 = authRequestContext47;
                                string29 = null;
                            } else {
                                authRequestContext46 = i33;
                                string29 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i33);
                                i34 = authRequestContext47;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i34)) {
                                authRequestContext47 = i34;
                                i35 = authRequestContext48;
                                string30 = null;
                            } else {
                                authRequestContext47 = i34;
                                string30 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i34);
                                i35 = authRequestContext48;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i35)) {
                                authRequestContext48 = i35;
                                i36 = authRequestContext49;
                                string31 = null;
                            } else {
                                authRequestContext48 = i35;
                                string31 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i35);
                                i36 = authRequestContext49;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i36)) {
                                authRequestContext49 = i36;
                                i37 = authRequestContext50;
                                string32 = null;
                            } else {
                                authRequestContext49 = i36;
                                string32 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i36);
                                i37 = authRequestContext50;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i37)) {
                                authRequestContext50 = i37;
                                i38 = authRequestContext51;
                                string33 = null;
                            } else {
                                authRequestContext50 = i37;
                                string33 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i37);
                                i38 = authRequestContext51;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i38)) {
                                authRequestContext51 = i38;
                                i39 = authRequestContext52;
                                string34 = null;
                            } else {
                                authRequestContext51 = i38;
                                string34 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i38);
                                i39 = authRequestContext52;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i39)) {
                                authRequestContext52 = i39;
                                i40 = authRequestContext53;
                                valueOf5 = null;
                            } else {
                                authRequestContext52 = i39;
                                valueOf5 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i39));
                                i40 = authRequestContext53;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i40)) {
                                authRequestContext53 = i40;
                                i41 = authRequestContext54;
                                valueOf6 = null;
                            } else {
                                authRequestContext53 = i40;
                                valueOf6 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i40));
                                i41 = authRequestContext54;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i41)) {
                                authRequestContext54 = i41;
                                i42 = authRequestContext55;
                                valueOf7 = null;
                            } else {
                                authRequestContext54 = i41;
                                valueOf7 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i41));
                                i42 = authRequestContext55;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i42)) {
                                authRequestContext55 = i42;
                                i43 = authRequestContext56;
                                string35 = null;
                            } else {
                                authRequestContext55 = i42;
                                string35 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i42);
                                i43 = authRequestContext56;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i43)) {
                                authRequestContext56 = i43;
                                i44 = authRequestContext57;
                                string36 = null;
                            } else {
                                authRequestContext56 = i43;
                                string36 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i43);
                                i44 = authRequestContext57;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i44)) {
                                authRequestContext57 = i44;
                                i45 = authRequestContext58;
                                string37 = null;
                            } else {
                                authRequestContext57 = i44;
                                string37 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i44);
                                i45 = authRequestContext58;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i45)) {
                                authRequestContext58 = i45;
                                i46 = authRequestContext59;
                                string38 = null;
                            } else {
                                authRequestContext58 = i45;
                                string38 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i45);
                                i46 = authRequestContext59;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i46)) {
                                authRequestContext59 = i46;
                                i47 = authRequestContext60;
                                valueOf8 = null;
                            } else {
                                authRequestContext59 = i46;
                                valueOf8 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i46));
                                i47 = authRequestContext60;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i47)) {
                                authRequestContext60 = i47;
                                i48 = authRequestContext61;
                                string39 = null;
                            } else {
                                authRequestContext60 = i47;
                                string39 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i47);
                                i48 = authRequestContext61;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i48)) {
                                authRequestContext61 = i48;
                                i49 = authRequestContext62;
                                valueOf9 = null;
                            } else {
                                authRequestContext61 = i48;
                                valueOf9 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i48));
                                i49 = authRequestContext62;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i49)) {
                                authRequestContext62 = i49;
                                i50 = authRequestContext63;
                                valueOf10 = null;
                            } else {
                                authRequestContext62 = i49;
                                valueOf10 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i49));
                                i50 = authRequestContext63;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i50)) {
                                authRequestContext63 = i50;
                                i51 = authRequestContext64;
                                valueOf11 = null;
                            } else {
                                authRequestContext63 = i50;
                                valueOf11 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i50));
                                i51 = authRequestContext64;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i51)) {
                                authRequestContext64 = i51;
                                i52 = authRequestContext65;
                                string40 = null;
                            } else {
                                authRequestContext64 = i51;
                                string40 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i51);
                                i52 = authRequestContext65;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i52)) {
                                authRequestContext65 = i52;
                                i53 = authRequestContext66;
                                string41 = null;
                            } else {
                                authRequestContext65 = i52;
                                string41 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i52);
                                i53 = authRequestContext66;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i53)) {
                                authRequestContext66 = i53;
                                i54 = authRequestContext67;
                                string42 = null;
                            } else {
                                authRequestContext66 = i53;
                                string42 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i53);
                                i54 = authRequestContext67;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i54)) {
                                authRequestContext67 = i54;
                                i55 = authRequestContext68;
                                string43 = null;
                            } else {
                                authRequestContext67 = i54;
                                string43 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i54);
                                i55 = authRequestContext68;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i55)) {
                                authRequestContext68 = i55;
                                i56 = authRequestContext69;
                                valueOf12 = null;
                            } else {
                                authRequestContext68 = i55;
                                valueOf12 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i55));
                                i56 = authRequestContext69;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i56)) {
                                authRequestContext69 = i56;
                                i57 = authRequestContext70;
                                valueOf13 = null;
                            } else {
                                authRequestContext69 = i56;
                                valueOf13 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i56));
                                i57 = authRequestContext70;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i57)) {
                                authRequestContext70 = i57;
                                i58 = authRequestContext71;
                                valueOf14 = null;
                            } else {
                                authRequestContext70 = i57;
                                valueOf14 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i57));
                                i58 = authRequestContext71;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i58)) {
                                authRequestContext71 = i58;
                                i59 = authRequestContext72;
                                string44 = null;
                            } else {
                                authRequestContext71 = i58;
                                string44 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i58);
                                i59 = authRequestContext72;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i59)) {
                                authRequestContext72 = i59;
                                i60 = authRequestContext73;
                                string45 = null;
                            } else {
                                authRequestContext72 = i59;
                                string45 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i59);
                                i60 = authRequestContext73;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i60)) {
                                authRequestContext73 = i60;
                                i61 = authRequestContext74;
                                string46 = null;
                            } else {
                                authRequestContext73 = i60;
                                string46 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i60);
                                i61 = authRequestContext74;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i61)) {
                                authRequestContext74 = i61;
                                i62 = authRequestContext75;
                                string47 = null;
                            } else {
                                authRequestContext74 = i61;
                                string47 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i61);
                                i62 = authRequestContext75;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i62)) {
                                authRequestContext75 = i62;
                                i63 = authRequestContext76;
                                valueOf15 = null;
                            } else {
                                authRequestContext75 = i62;
                                valueOf15 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i62));
                                i63 = authRequestContext76;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i63)) {
                                authRequestContext76 = i63;
                                i64 = authRequestContext77;
                                string48 = null;
                            } else {
                                authRequestContext76 = i63;
                                string48 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i63);
                                i64 = authRequestContext77;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i64)) {
                                authRequestContext77 = i64;
                                i65 = authRequestContext78;
                                string49 = null;
                            } else {
                                authRequestContext77 = i64;
                                string49 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i64);
                                i65 = authRequestContext78;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i65)) {
                                authRequestContext78 = i65;
                                i66 = authRequestContext79;
                                string50 = null;
                            } else {
                                authRequestContext78 = i65;
                                string50 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i65);
                                i66 = authRequestContext79;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i66)) {
                                authRequestContext79 = i66;
                                i67 = authRequestContext80;
                                string51 = null;
                            } else {
                                authRequestContext79 = i66;
                                string51 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i66);
                                i67 = authRequestContext80;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i67)) {
                                authRequestContext80 = i67;
                                i68 = authRequestContext81;
                                string52 = null;
                            } else {
                                authRequestContext80 = i67;
                                string52 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i67);
                                i68 = authRequestContext81;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i68)) {
                                authRequestContext81 = i68;
                                i69 = authRequestContext82;
                                string53 = null;
                            } else {
                                authRequestContext81 = i68;
                                string53 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i68);
                                i69 = authRequestContext82;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i69)) {
                                authRequestContext82 = i69;
                                i70 = authRequestContext83;
                                string54 = null;
                            } else {
                                authRequestContext82 = i69;
                                string54 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i69);
                                i70 = authRequestContext83;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i70)) {
                                authRequestContext83 = i70;
                                i71 = authRequestContext84;
                                string55 = null;
                            } else {
                                authRequestContext83 = i70;
                                string55 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i70);
                                i71 = authRequestContext84;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i71)) {
                                authRequestContext84 = i71;
                                i72 = authRequestContext85;
                                string56 = null;
                            } else {
                                authRequestContext84 = i71;
                                string56 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i71);
                                i72 = authRequestContext85;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i72)) {
                                authRequestContext85 = i72;
                                i73 = authRequestContext86;
                                string57 = null;
                            } else {
                                authRequestContext85 = i72;
                                string57 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i72);
                                i73 = authRequestContext86;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i73)) {
                                authRequestContext86 = i73;
                                i74 = authRequestContext87;
                                string58 = null;
                            } else {
                                authRequestContext86 = i73;
                                string58 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i73);
                                i74 = authRequestContext87;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i74)) {
                                authRequestContext87 = i74;
                                i75 = authRequestContext88;
                                valueOf16 = null;
                            } else {
                                authRequestContext87 = i74;
                                valueOf16 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i74));
                                i75 = authRequestContext88;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i75)) {
                                authRequestContext88 = i75;
                                i76 = authRequestContext89;
                                valueOf17 = null;
                            } else {
                                authRequestContext88 = i75;
                                valueOf17 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i75));
                                i76 = authRequestContext89;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i76)) {
                                authRequestContext89 = i76;
                                i77 = authRequestContext90;
                                valueOf18 = null;
                            } else {
                                authRequestContext89 = i76;
                                valueOf18 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i76));
                                i77 = authRequestContext90;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i77)) {
                                authRequestContext90 = i77;
                                authRequestContext41 = i28;
                                string59 = null;
                            } else {
                                authRequestContext90 = i77;
                                string59 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i77);
                                authRequestContext41 = i28;
                            }
                            Map<String, String> fromString3 = this.__mapConverter.fromString(string59);
                            int i82 = authRequestContext91;
                            if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i82)) {
                                i78 = authRequestContext92;
                                string60 = null;
                            } else {
                                string60 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i82);
                                i78 = authRequestContext92;
                            }
                            authRequestContext91 = i82;
                            arrayList.add(new UserPaymentAssetsDaoEntity(string61, string62, string63, string64, string65, string66, string67, string68, string69, string70, string71, string72, string, fromString, valueOf, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, valueOf2, string21, string22, string23, fromString2, valueOf3, string25, valueOf4, string26, string27, string28, string29, string30, string31, string32, string33, string34, valueOf5, valueOf6, valueOf7, string35, string36, string37, string38, valueOf8, string39, valueOf9, valueOf10, valueOf11, string40, string41, string42, string43, valueOf12, valueOf13, valueOf14, string44, string45, string46, string47, valueOf15, string48, string49, string50, string51, string52, string53, string54, string55, string56, string57, string58, valueOf16, valueOf17, valueOf18, fromString3, string60, KClassImpl$Data$declaredNonStaticMembers$2.isNull(i78) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(i78))));
                            authRequestContext92 = i78;
                            authRequestContext13 = i4;
                            authRequestContext2 = i2;
                            i79 = i3;
                        } catch (Throwable th) {
                            th = th;
                            KClassImpl$Data$declaredNonStaticMembers$2.close();
                            roomSQLiteQuery.MyBillsEntityDataFactory();
                            throw th;
                        }
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2.close();
                    roomSQLiteQuery.MyBillsEntityDataFactory();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = authRequestContext;
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPaymentAssetsDao
    public final List<UserPaymentAssetsDaoEntity> searchUserPaymentAssets(String str, List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        String string;
        int i;
        int i2;
        int i3;
        String string2;
        Boolean valueOf;
        int i4;
        String string3;
        int i5;
        String string4;
        int i6;
        String string5;
        int i7;
        String string6;
        int i8;
        String string7;
        int i9;
        String string8;
        int i10;
        String string9;
        int i11;
        String string10;
        int i12;
        String string11;
        int i13;
        String string12;
        int i14;
        String string13;
        int i15;
        String string14;
        int i16;
        String string15;
        int i17;
        String string16;
        int i18;
        String string17;
        int i19;
        String string18;
        int i20;
        String string19;
        int i21;
        String string20;
        int i22;
        Boolean valueOf2;
        int i23;
        String string21;
        int i24;
        String string22;
        int i25;
        String string23;
        int i26;
        String string24;
        Boolean valueOf3;
        int i27;
        String string25;
        int i28;
        Boolean valueOf4;
        int i29;
        String string26;
        int i30;
        String string27;
        int i31;
        String string28;
        int i32;
        String string29;
        int i33;
        String string30;
        int i34;
        String string31;
        int i35;
        String string32;
        int i36;
        String string33;
        int i37;
        String string34;
        int i38;
        Long valueOf5;
        int i39;
        Long valueOf6;
        int i40;
        Long valueOf7;
        int i41;
        String string35;
        int i42;
        String string36;
        int i43;
        String string37;
        int i44;
        String string38;
        int i45;
        Long valueOf8;
        int i46;
        String string39;
        int i47;
        Long valueOf9;
        int i48;
        Long valueOf10;
        int i49;
        Long valueOf11;
        int i50;
        String string40;
        int i51;
        String string41;
        int i52;
        String string42;
        int i53;
        String string43;
        int i54;
        Long valueOf12;
        int i55;
        Long valueOf13;
        int i56;
        Long valueOf14;
        int i57;
        String string44;
        int i58;
        String string45;
        int i59;
        String string46;
        int i60;
        String string47;
        int i61;
        Long valueOf15;
        int i62;
        String string48;
        int i63;
        String string49;
        int i64;
        String string50;
        int i65;
        String string51;
        int i66;
        String string52;
        int i67;
        String string53;
        int i68;
        String string54;
        int i69;
        String string55;
        int i70;
        String string56;
        int i71;
        String string57;
        int i72;
        String string58;
        int i73;
        Long valueOf16;
        int i74;
        Long valueOf17;
        int i75;
        Long valueOf18;
        int i76;
        String string59;
        String string60;
        int i77;
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("SELECT * FROM UserPaymentAssetsDaoEntity WHERE assetType IN (");
        int size = list.size();
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, size);
        KClassImpl$Data$declaredNonStaticMembers$2.append(")AND cardTitle LIKE '%' || ");
        KClassImpl$Data$declaredNonStaticMembers$2.append("?");
        KClassImpl$Data$declaredNonStaticMembers$2.append(" || '%'");
        int i78 = size + 1;
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.toString(), i78);
        int i79 = 1;
        for (String str2 : list) {
            if (str2 == null) {
                authRequestContext.bindNull(i79);
            } else {
                authRequestContext.bindString(i79, str2);
            }
            i79++;
        }
        if (str == null) {
            authRequestContext.bindNull(i78);
        } else {
            authRequestContext.bindString(i78, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "uniqueId");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, HomeTabActivity.WALLET_SECTION);
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "amount");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, FirebaseAnalytics.Param.CURRENCY);
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "limitAmount");
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "limitCurrency");
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "limitCurrencyCode");
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "balanceAmount");
            int authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "balanceCurrency");
            int authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "balanceCurrencyCode");
            int authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "unpaidAmountAmount");
            int authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "unpaidAmountCurrency");
            int authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "unpaidAmountCurrencyCode");
            roomSQLiteQuery = authRequestContext;
            try {
                int authRequestContext15 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "overdueTips");
                try {
                    int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "overdueStatus");
                    int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "accountId");
                    int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "gmtCreate");
                    int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "gmtModified");
                    int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "assetBiztype");
                    int authRequestContext21 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "cardTitle");
                    int authRequestContext22 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, WalletConstant.CARD_INDEX_NO);
                    int authRequestContext23 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "cardNoLength");
                    int authRequestContext24 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "maskedCardNo");
                    int authRequestContext25 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "assetType");
                    int authRequestContext26 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "cardScheme");
                    int authRequestContext27 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "holderName");
                    int authRequestContext28 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "instLogoUrl");
                    int authRequestContext29 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "instId");
                    int authRequestContext30 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "instOfficialName");
                    int authRequestContext31 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "instBranchId");
                    int authRequestContext32 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "instBranchOfficialName");
                    int authRequestContext33 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "expiryYear");
                    int authRequestContext34 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "expiryMonth");
                    int authRequestContext35 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "verified");
                    int authRequestContext36 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "bindingId");
                    int authRequestContext37 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "accountNo");
                    int authRequestContext38 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "defaultAsset");
                    int authRequestContext39 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "extInfo");
                    int authRequestContext40 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "enableStatus");
                    int authRequestContext41 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "bankMobileNo");
                    int authRequestContext42 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "directDebit");
                    int authRequestContext43 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "personalDailyLimitAmount");
                    int authRequestContext44 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "personalDailyLimitCurrency");
                    int authRequestContext45 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "personalDailyLimitCurrencyCode");
                    int authRequestContext46 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "userPhoneNo");
                    int authRequestContext47 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "contactBizType");
                    int authRequestContext48 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "goodsId");
                    int authRequestContext49 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "aggregator");
                    int authRequestContext50 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "userId");
                    int authRequestContext51 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "accountStatus");
                    int authRequestContext52 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "availableBalanceAmount");
                    int authRequestContext53 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "availableBalanceCent");
                    int authRequestContext54 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "availableBalanceCentFactor");
                    int authRequestContext55 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "availableBalanceCurrency");
                    int authRequestContext56 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "availableBalanceCurrencyCode");
                    int authRequestContext57 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "availableBalanceCurrencyValue");
                    int authRequestContext58 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "balanceUnitType");
                    int authRequestContext59 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "balanceUnitUnit");
                    int authRequestContext60 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "balanceUnitUnitValue");
                    int authRequestContext61 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "totalGainLossAmountAmount");
                    int authRequestContext62 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "totalGainLossAmountCent");
                    int authRequestContext63 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "totalGainLossAmountCentFactor");
                    int authRequestContext64 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "totalGainLossAmountCurrency");
                    int authRequestContext65 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "totalGainLossAmountCurrencyCode");
                    int authRequestContext66 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "totalGainLossAmountCurrencyValue");
                    int authRequestContext67 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "totalGainLossPercentage");
                    int authRequestContext68 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "dailyGainLossAmountAmount");
                    int authRequestContext69 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "dailyGainLossAmountCent");
                    int authRequestContext70 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "dailyGainLossAmountCentFactor");
                    int authRequestContext71 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "dailyGainLossAmountCurrency");
                    int authRequestContext72 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "dailyGainLossAmountCurrencyCode");
                    int authRequestContext73 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "dailyGainLossAmountCurrencyValue");
                    int authRequestContext74 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "dailyGainLossPercentage");
                    int authRequestContext75 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, BaseKey.LAST_UPDATED);
                    int authRequestContext76 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "savingId");
                    int authRequestContext77 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "title");
                    int authRequestContext78 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "categoryCode");
                    int authRequestContext79 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "currentAmountAmount");
                    int authRequestContext80 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "currentAmountCurrency");
                    int authRequestContext81 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "currentAmountCurrencyCode");
                    int authRequestContext82 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "targetAmountAmount");
                    int authRequestContext83 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "targetAmountCurrency");
                    int authRequestContext84 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "targetAmountCurrencyCode");
                    int authRequestContext85 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "orderStatus");
                    int authRequestContext86 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "orderSubStatus");
                    int authRequestContext87 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "createdTime");
                    int authRequestContext88 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "achievedTime");
                    int authRequestContext89 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "completedTime");
                    int authRequestContext90 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "extendInfo");
                    int authRequestContext91 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "cardBackground");
                    int authRequestContext92 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "cacheTimestamp");
                    int i80 = authRequestContext15;
                    ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$22.getCount());
                    while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                        String string61 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext2);
                        String string62 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext3);
                        String string63 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext4);
                        String string64 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext5);
                        String string65 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext6) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext6);
                        String string66 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext7) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext7);
                        String string67 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext8);
                        String string68 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext9);
                        String string69 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext10);
                        String string70 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext11) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext11);
                        String string71 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext12) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext12);
                        String string72 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext13) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext13);
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext14)) {
                            i = i80;
                            string = null;
                        } else {
                            string = KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext14);
                            i = i80;
                        }
                        if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i)) {
                            i2 = authRequestContext2;
                            i80 = i;
                            i3 = authRequestContext13;
                            string2 = null;
                        } else {
                            i2 = authRequestContext2;
                            i3 = authRequestContext13;
                            string2 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i);
                            i80 = i;
                        }
                        try {
                            List<String> fromString = this.__stringConverter.fromString(string2);
                            int i81 = authRequestContext16;
                            Integer valueOf19 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i81) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(i81));
                            if (valueOf19 == null) {
                                i4 = authRequestContext17;
                                valueOf = null;
                            } else {
                                valueOf = Boolean.valueOf(valueOf19.intValue() != 0);
                                i4 = authRequestContext17;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i4)) {
                                authRequestContext16 = i81;
                                i5 = authRequestContext18;
                                string3 = null;
                            } else {
                                authRequestContext16 = i81;
                                string3 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i4);
                                i5 = authRequestContext18;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i5)) {
                                authRequestContext18 = i5;
                                i6 = authRequestContext19;
                                string4 = null;
                            } else {
                                authRequestContext18 = i5;
                                string4 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i5);
                                i6 = authRequestContext19;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i6)) {
                                authRequestContext19 = i6;
                                i7 = authRequestContext20;
                                string5 = null;
                            } else {
                                authRequestContext19 = i6;
                                string5 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i6);
                                i7 = authRequestContext20;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i7)) {
                                authRequestContext20 = i7;
                                i8 = authRequestContext21;
                                string6 = null;
                            } else {
                                authRequestContext20 = i7;
                                string6 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i7);
                                i8 = authRequestContext21;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i8)) {
                                authRequestContext21 = i8;
                                i9 = authRequestContext22;
                                string7 = null;
                            } else {
                                authRequestContext21 = i8;
                                string7 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i8);
                                i9 = authRequestContext22;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i9)) {
                                authRequestContext22 = i9;
                                i10 = authRequestContext23;
                                string8 = null;
                            } else {
                                authRequestContext22 = i9;
                                string8 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i9);
                                i10 = authRequestContext23;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i10)) {
                                authRequestContext23 = i10;
                                i11 = authRequestContext24;
                                string9 = null;
                            } else {
                                authRequestContext23 = i10;
                                string9 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i10);
                                i11 = authRequestContext24;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i11)) {
                                authRequestContext24 = i11;
                                i12 = authRequestContext25;
                                string10 = null;
                            } else {
                                authRequestContext24 = i11;
                                string10 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i11);
                                i12 = authRequestContext25;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i12)) {
                                authRequestContext25 = i12;
                                i13 = authRequestContext26;
                                string11 = null;
                            } else {
                                authRequestContext25 = i12;
                                string11 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i12);
                                i13 = authRequestContext26;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i13)) {
                                authRequestContext26 = i13;
                                i14 = authRequestContext27;
                                string12 = null;
                            } else {
                                authRequestContext26 = i13;
                                string12 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i13);
                                i14 = authRequestContext27;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i14)) {
                                authRequestContext27 = i14;
                                i15 = authRequestContext28;
                                string13 = null;
                            } else {
                                authRequestContext27 = i14;
                                string13 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i14);
                                i15 = authRequestContext28;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i15)) {
                                authRequestContext28 = i15;
                                i16 = authRequestContext29;
                                string14 = null;
                            } else {
                                authRequestContext28 = i15;
                                string14 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i15);
                                i16 = authRequestContext29;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i16)) {
                                authRequestContext29 = i16;
                                i17 = authRequestContext30;
                                string15 = null;
                            } else {
                                authRequestContext29 = i16;
                                string15 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i16);
                                i17 = authRequestContext30;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i17)) {
                                authRequestContext30 = i17;
                                i18 = authRequestContext31;
                                string16 = null;
                            } else {
                                authRequestContext30 = i17;
                                string16 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i17);
                                i18 = authRequestContext31;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i18)) {
                                authRequestContext31 = i18;
                                i19 = authRequestContext32;
                                string17 = null;
                            } else {
                                authRequestContext31 = i18;
                                string17 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i18);
                                i19 = authRequestContext32;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i19)) {
                                authRequestContext32 = i19;
                                i20 = authRequestContext33;
                                string18 = null;
                            } else {
                                authRequestContext32 = i19;
                                string18 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i19);
                                i20 = authRequestContext33;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i20)) {
                                authRequestContext33 = i20;
                                i21 = authRequestContext34;
                                string19 = null;
                            } else {
                                authRequestContext33 = i20;
                                string19 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i20);
                                i21 = authRequestContext34;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i21)) {
                                authRequestContext34 = i21;
                                i22 = authRequestContext35;
                                string20 = null;
                            } else {
                                authRequestContext34 = i21;
                                string20 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i21);
                                i22 = authRequestContext35;
                            }
                            Integer valueOf20 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i22) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(i22));
                            if (valueOf20 == null) {
                                authRequestContext35 = i22;
                                i23 = authRequestContext36;
                                valueOf2 = null;
                            } else {
                                authRequestContext35 = i22;
                                valueOf2 = Boolean.valueOf(valueOf20.intValue() != 0);
                                i23 = authRequestContext36;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i23)) {
                                authRequestContext36 = i23;
                                i24 = authRequestContext37;
                                string21 = null;
                            } else {
                                authRequestContext36 = i23;
                                string21 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i23);
                                i24 = authRequestContext37;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i24)) {
                                authRequestContext37 = i24;
                                i25 = authRequestContext38;
                                string22 = null;
                            } else {
                                authRequestContext37 = i24;
                                string22 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i24);
                                i25 = authRequestContext38;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i25)) {
                                authRequestContext38 = i25;
                                i26 = authRequestContext39;
                                string23 = null;
                            } else {
                                authRequestContext38 = i25;
                                string23 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i25);
                                i26 = authRequestContext39;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i26)) {
                                authRequestContext39 = i26;
                                authRequestContext17 = i4;
                                string24 = null;
                            } else {
                                authRequestContext39 = i26;
                                string24 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i26);
                                authRequestContext17 = i4;
                            }
                            Map<String, String> fromString2 = this.__mapConverter.fromString(string24);
                            int i82 = authRequestContext40;
                            Integer valueOf21 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i82) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(i82));
                            if (valueOf21 == null) {
                                i27 = authRequestContext41;
                                valueOf3 = null;
                            } else {
                                valueOf3 = Boolean.valueOf(valueOf21.intValue() != 0);
                                i27 = authRequestContext41;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i27)) {
                                authRequestContext40 = i82;
                                i28 = authRequestContext42;
                                string25 = null;
                            } else {
                                string25 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i27);
                                authRequestContext40 = i82;
                                i28 = authRequestContext42;
                            }
                            Integer valueOf22 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i28) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(i28));
                            if (valueOf22 == null) {
                                authRequestContext42 = i28;
                                i29 = authRequestContext43;
                                valueOf4 = null;
                            } else {
                                authRequestContext42 = i28;
                                valueOf4 = Boolean.valueOf(valueOf22.intValue() != 0);
                                i29 = authRequestContext43;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i29)) {
                                authRequestContext43 = i29;
                                i30 = authRequestContext44;
                                string26 = null;
                            } else {
                                authRequestContext43 = i29;
                                string26 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i29);
                                i30 = authRequestContext44;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i30)) {
                                authRequestContext44 = i30;
                                i31 = authRequestContext45;
                                string27 = null;
                            } else {
                                authRequestContext44 = i30;
                                string27 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i30);
                                i31 = authRequestContext45;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i31)) {
                                authRequestContext45 = i31;
                                i32 = authRequestContext46;
                                string28 = null;
                            } else {
                                authRequestContext45 = i31;
                                string28 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i31);
                                i32 = authRequestContext46;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i32)) {
                                authRequestContext46 = i32;
                                i33 = authRequestContext47;
                                string29 = null;
                            } else {
                                authRequestContext46 = i32;
                                string29 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i32);
                                i33 = authRequestContext47;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i33)) {
                                authRequestContext47 = i33;
                                i34 = authRequestContext48;
                                string30 = null;
                            } else {
                                authRequestContext47 = i33;
                                string30 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i33);
                                i34 = authRequestContext48;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i34)) {
                                authRequestContext48 = i34;
                                i35 = authRequestContext49;
                                string31 = null;
                            } else {
                                authRequestContext48 = i34;
                                string31 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i34);
                                i35 = authRequestContext49;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i35)) {
                                authRequestContext49 = i35;
                                i36 = authRequestContext50;
                                string32 = null;
                            } else {
                                authRequestContext49 = i35;
                                string32 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i35);
                                i36 = authRequestContext50;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i36)) {
                                authRequestContext50 = i36;
                                i37 = authRequestContext51;
                                string33 = null;
                            } else {
                                authRequestContext50 = i36;
                                string33 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i36);
                                i37 = authRequestContext51;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i37)) {
                                authRequestContext51 = i37;
                                i38 = authRequestContext52;
                                string34 = null;
                            } else {
                                authRequestContext51 = i37;
                                string34 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i37);
                                i38 = authRequestContext52;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i38)) {
                                authRequestContext52 = i38;
                                i39 = authRequestContext53;
                                valueOf5 = null;
                            } else {
                                authRequestContext52 = i38;
                                valueOf5 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i38));
                                i39 = authRequestContext53;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i39)) {
                                authRequestContext53 = i39;
                                i40 = authRequestContext54;
                                valueOf6 = null;
                            } else {
                                authRequestContext53 = i39;
                                valueOf6 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i39));
                                i40 = authRequestContext54;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i40)) {
                                authRequestContext54 = i40;
                                i41 = authRequestContext55;
                                valueOf7 = null;
                            } else {
                                authRequestContext54 = i40;
                                valueOf7 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i40));
                                i41 = authRequestContext55;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i41)) {
                                authRequestContext55 = i41;
                                i42 = authRequestContext56;
                                string35 = null;
                            } else {
                                authRequestContext55 = i41;
                                string35 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i41);
                                i42 = authRequestContext56;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i42)) {
                                authRequestContext56 = i42;
                                i43 = authRequestContext57;
                                string36 = null;
                            } else {
                                authRequestContext56 = i42;
                                string36 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i42);
                                i43 = authRequestContext57;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i43)) {
                                authRequestContext57 = i43;
                                i44 = authRequestContext58;
                                string37 = null;
                            } else {
                                authRequestContext57 = i43;
                                string37 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i43);
                                i44 = authRequestContext58;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i44)) {
                                authRequestContext58 = i44;
                                i45 = authRequestContext59;
                                string38 = null;
                            } else {
                                authRequestContext58 = i44;
                                string38 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i44);
                                i45 = authRequestContext59;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i45)) {
                                authRequestContext59 = i45;
                                i46 = authRequestContext60;
                                valueOf8 = null;
                            } else {
                                authRequestContext59 = i45;
                                valueOf8 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i45));
                                i46 = authRequestContext60;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i46)) {
                                authRequestContext60 = i46;
                                i47 = authRequestContext61;
                                string39 = null;
                            } else {
                                authRequestContext60 = i46;
                                string39 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i46);
                                i47 = authRequestContext61;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i47)) {
                                authRequestContext61 = i47;
                                i48 = authRequestContext62;
                                valueOf9 = null;
                            } else {
                                authRequestContext61 = i47;
                                valueOf9 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i47));
                                i48 = authRequestContext62;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i48)) {
                                authRequestContext62 = i48;
                                i49 = authRequestContext63;
                                valueOf10 = null;
                            } else {
                                authRequestContext62 = i48;
                                valueOf10 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i48));
                                i49 = authRequestContext63;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i49)) {
                                authRequestContext63 = i49;
                                i50 = authRequestContext64;
                                valueOf11 = null;
                            } else {
                                authRequestContext63 = i49;
                                valueOf11 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i49));
                                i50 = authRequestContext64;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i50)) {
                                authRequestContext64 = i50;
                                i51 = authRequestContext65;
                                string40 = null;
                            } else {
                                authRequestContext64 = i50;
                                string40 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i50);
                                i51 = authRequestContext65;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i51)) {
                                authRequestContext65 = i51;
                                i52 = authRequestContext66;
                                string41 = null;
                            } else {
                                authRequestContext65 = i51;
                                string41 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i51);
                                i52 = authRequestContext66;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i52)) {
                                authRequestContext66 = i52;
                                i53 = authRequestContext67;
                                string42 = null;
                            } else {
                                authRequestContext66 = i52;
                                string42 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i52);
                                i53 = authRequestContext67;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i53)) {
                                authRequestContext67 = i53;
                                i54 = authRequestContext68;
                                string43 = null;
                            } else {
                                authRequestContext67 = i53;
                                string43 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i53);
                                i54 = authRequestContext68;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i54)) {
                                authRequestContext68 = i54;
                                i55 = authRequestContext69;
                                valueOf12 = null;
                            } else {
                                authRequestContext68 = i54;
                                valueOf12 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i54));
                                i55 = authRequestContext69;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i55)) {
                                authRequestContext69 = i55;
                                i56 = authRequestContext70;
                                valueOf13 = null;
                            } else {
                                authRequestContext69 = i55;
                                valueOf13 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i55));
                                i56 = authRequestContext70;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i56)) {
                                authRequestContext70 = i56;
                                i57 = authRequestContext71;
                                valueOf14 = null;
                            } else {
                                authRequestContext70 = i56;
                                valueOf14 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i56));
                                i57 = authRequestContext71;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i57)) {
                                authRequestContext71 = i57;
                                i58 = authRequestContext72;
                                string44 = null;
                            } else {
                                authRequestContext71 = i57;
                                string44 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i57);
                                i58 = authRequestContext72;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i58)) {
                                authRequestContext72 = i58;
                                i59 = authRequestContext73;
                                string45 = null;
                            } else {
                                authRequestContext72 = i58;
                                string45 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i58);
                                i59 = authRequestContext73;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i59)) {
                                authRequestContext73 = i59;
                                i60 = authRequestContext74;
                                string46 = null;
                            } else {
                                authRequestContext73 = i59;
                                string46 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i59);
                                i60 = authRequestContext74;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i60)) {
                                authRequestContext74 = i60;
                                i61 = authRequestContext75;
                                string47 = null;
                            } else {
                                authRequestContext74 = i60;
                                string47 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i60);
                                i61 = authRequestContext75;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i61)) {
                                authRequestContext75 = i61;
                                i62 = authRequestContext76;
                                valueOf15 = null;
                            } else {
                                authRequestContext75 = i61;
                                valueOf15 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i61));
                                i62 = authRequestContext76;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i62)) {
                                authRequestContext76 = i62;
                                i63 = authRequestContext77;
                                string48 = null;
                            } else {
                                authRequestContext76 = i62;
                                string48 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i62);
                                i63 = authRequestContext77;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i63)) {
                                authRequestContext77 = i63;
                                i64 = authRequestContext78;
                                string49 = null;
                            } else {
                                authRequestContext77 = i63;
                                string49 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i63);
                                i64 = authRequestContext78;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i64)) {
                                authRequestContext78 = i64;
                                i65 = authRequestContext79;
                                string50 = null;
                            } else {
                                authRequestContext78 = i64;
                                string50 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i64);
                                i65 = authRequestContext79;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i65)) {
                                authRequestContext79 = i65;
                                i66 = authRequestContext80;
                                string51 = null;
                            } else {
                                authRequestContext79 = i65;
                                string51 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i65);
                                i66 = authRequestContext80;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i66)) {
                                authRequestContext80 = i66;
                                i67 = authRequestContext81;
                                string52 = null;
                            } else {
                                authRequestContext80 = i66;
                                string52 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i66);
                                i67 = authRequestContext81;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i67)) {
                                authRequestContext81 = i67;
                                i68 = authRequestContext82;
                                string53 = null;
                            } else {
                                authRequestContext81 = i67;
                                string53 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i67);
                                i68 = authRequestContext82;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i68)) {
                                authRequestContext82 = i68;
                                i69 = authRequestContext83;
                                string54 = null;
                            } else {
                                authRequestContext82 = i68;
                                string54 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i68);
                                i69 = authRequestContext83;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i69)) {
                                authRequestContext83 = i69;
                                i70 = authRequestContext84;
                                string55 = null;
                            } else {
                                authRequestContext83 = i69;
                                string55 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i69);
                                i70 = authRequestContext84;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i70)) {
                                authRequestContext84 = i70;
                                i71 = authRequestContext85;
                                string56 = null;
                            } else {
                                authRequestContext84 = i70;
                                string56 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i70);
                                i71 = authRequestContext85;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i71)) {
                                authRequestContext85 = i71;
                                i72 = authRequestContext86;
                                string57 = null;
                            } else {
                                authRequestContext85 = i71;
                                string57 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i71);
                                i72 = authRequestContext86;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i72)) {
                                authRequestContext86 = i72;
                                i73 = authRequestContext87;
                                string58 = null;
                            } else {
                                authRequestContext86 = i72;
                                string58 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i72);
                                i73 = authRequestContext87;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i73)) {
                                authRequestContext87 = i73;
                                i74 = authRequestContext88;
                                valueOf16 = null;
                            } else {
                                authRequestContext87 = i73;
                                valueOf16 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i73));
                                i74 = authRequestContext88;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i74)) {
                                authRequestContext88 = i74;
                                i75 = authRequestContext89;
                                valueOf17 = null;
                            } else {
                                authRequestContext88 = i74;
                                valueOf17 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i74));
                                i75 = authRequestContext89;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i75)) {
                                authRequestContext89 = i75;
                                i76 = authRequestContext90;
                                valueOf18 = null;
                            } else {
                                authRequestContext89 = i75;
                                valueOf18 = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i75));
                                i76 = authRequestContext90;
                            }
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i76)) {
                                authRequestContext90 = i76;
                                authRequestContext41 = i27;
                                string59 = null;
                            } else {
                                authRequestContext90 = i76;
                                string59 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i76);
                                authRequestContext41 = i27;
                            }
                            Map<String, String> fromString3 = this.__mapConverter.fromString(string59);
                            int i83 = authRequestContext91;
                            if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i83)) {
                                i77 = authRequestContext92;
                                string60 = null;
                            } else {
                                string60 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i83);
                                i77 = authRequestContext92;
                            }
                            authRequestContext91 = i83;
                            arrayList.add(new UserPaymentAssetsDaoEntity(string61, string62, string63, string64, string65, string66, string67, string68, string69, string70, string71, string72, string, fromString, valueOf, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, valueOf2, string21, string22, string23, fromString2, valueOf3, string25, valueOf4, string26, string27, string28, string29, string30, string31, string32, string33, string34, valueOf5, valueOf6, valueOf7, string35, string36, string37, string38, valueOf8, string39, valueOf9, valueOf10, valueOf11, string40, string41, string42, string43, valueOf12, valueOf13, valueOf14, string44, string45, string46, string47, valueOf15, string48, string49, string50, string51, string52, string53, string54, string55, string56, string57, string58, valueOf16, valueOf17, valueOf18, fromString3, string60, KClassImpl$Data$declaredNonStaticMembers$22.isNull(i77) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getLong(i77))));
                            authRequestContext92 = i77;
                            authRequestContext2 = i2;
                            authRequestContext13 = i3;
                        } catch (Throwable th) {
                            th = th;
                            KClassImpl$Data$declaredNonStaticMembers$22.close();
                            roomSQLiteQuery.MyBillsEntityDataFactory();
                            throw th;
                        }
                    }
                    KClassImpl$Data$declaredNonStaticMembers$22.close();
                    roomSQLiteQuery.MyBillsEntityDataFactory();
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                KClassImpl$Data$declaredNonStaticMembers$22.close();
                roomSQLiteQuery.MyBillsEntityDataFactory();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            roomSQLiteQuery = authRequestContext;
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPaymentAssetsDao
    public final List<String> getSavedAssetTypes() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT DISTINCT assetType FROM UserPaymentAssetsDaoEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2.isNull(0) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(0));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPaymentAssetsDao
    public final void deleteUserPaymentAssets(List<String> list) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder KClassImpl$Data$declaredNonStaticMembers$2 = StringUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.append("DELETE FROM UserPaymentAssetsDaoEntity where uniqueId IN (");
        StringUtil.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, list.size());
        KClassImpl$Data$declaredNonStaticMembers$2.append(")");
        SupportSQLiteStatement compileStatement = this.__db.compileStatement(KClassImpl$Data$declaredNonStaticMembers$2.toString());
        int i = 1;
        for (String str : list) {
            if (str == null) {
                compileStatement.bindNull(i);
            } else {
                compileStatement.bindString(i, str);
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            compileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // id.dana.data.wallet_v3.repository.source.persistence.dao.UserPaymentAssetsDao
    public final List<String> getUserPaymentViaQuery(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, supportSQLiteQuery, false);
        try {
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2.isNull(0) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(0));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
