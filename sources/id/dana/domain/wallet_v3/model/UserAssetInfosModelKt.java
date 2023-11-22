package id.dana.domain.wallet_v3.model;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.sendmoney.util.GlobalSendMethodTransferProperty;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a/\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;", "", "phoneNumber", "nickname", WalletConstant.KYC_LEVEL, "addAccountDataIntoDanaAsset", "(Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;", "getTitleCard", "(Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;)Ljava/lang/String;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserAssetInfosModelKt {
    public static final UserAssetInfosModel addAccountDataIntoDanaAsset(UserAssetInfosModel userAssetInfosModel, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(userAssetInfosModel, "");
        if (Intrinsics.areEqual(userAssetInfosModel.getAssetType(), CardAssetType.BALANCE.getAsset())) {
            UserAssetsModel info = userAssetInfosModel.getInfo();
            return UserAssetInfosModel.copy$default(userAssetInfosModel, null, null, info != null ? info.copy((r91 & 1) != 0 ? info.uniqueId : null, (r91 & 2) != 0 ? info.amount : null, (r91 & 4) != 0 ? info.currency : null, (r91 & 8) != 0 ? info.limit : null, (r91 & 16) != 0 ? info.balance : null, (r91 & 32) != 0 ? info.unpaidAmount : null, (r91 & 64) != 0 ? info.overdueTips : null, (r91 & 128) != 0 ? info.overdueStatus : null, (r91 & 256) != 0 ? info.accountId : null, (r91 & 512) != 0 ? info.gmtCreate : null, (r91 & 1024) != 0 ? info.gmtModified : null, (r91 & 2048) != 0 ? info.assetBiztype : null, (r91 & 4096) != 0 ? info.cardTitle : null, (r91 & 8192) != 0 ? info.cardIndexNo : null, (r91 & 16384) != 0 ? info.cardNoLength : null, (r91 & 32768) != 0 ? info.maskedCardNo : null, (r91 & 65536) != 0 ? info.assetType : null, (r91 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? info.cardScheme : null, (r91 & 262144) != 0 ? info.holderName : null, (r91 & 524288) != 0 ? info.instLogoUrl : null, (r91 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? info.instId : null, (r91 & 2097152) != 0 ? info.instOfficialName : null, (r91 & 4194304) != 0 ? info.instBranchId : null, (r91 & 8388608) != 0 ? info.instBranchOfficialName : null, (r91 & 16777216) != 0 ? info.expiryYear : null, (r91 & 33554432) != 0 ? info.expiryMonth : null, (r91 & 67108864) != 0 ? info.verified : null, (r91 & 134217728) != 0 ? info.bindingId : null, (r91 & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? info.accountNo : null, (r91 & 536870912) != 0 ? info.defaultAsset : null, (r91 & 1073741824) != 0 ? info.extInfo : null, (r91 & Integer.MIN_VALUE) != 0 ? info.enableStatus : null, (r92 & 1) != 0 ? info.bankMobileNo : null, (r92 & 2) != 0 ? info.directDebit : null, (r92 & 4) != 0 ? info.isDirectDebit : null, (r92 & 8) != 0 ? info.personalDailyLimit : null, (r92 & 16) != 0 ? info.userPhoneNo : null, (r92 & 32) != 0 ? info.contactBizType : null, (r92 & 64) != 0 ? info.goodsId : null, (r92 & 128) != 0 ? info.aggregator : null, (r92 & 256) != 0 ? info.userId : null, (r92 & 512) != 0 ? info.accountStatus : null, (r92 & 1024) != 0 ? info.availableBalance : null, (r92 & 2048) != 0 ? info.balanceUnit : null, (r92 & 4096) != 0 ? info.totalGainLossAmount : null, (r92 & 8192) != 0 ? info.totalGainLossPercentage : null, (r92 & 16384) != 0 ? info.dailyGainLossAmount : null, (r92 & 32768) != 0 ? info.dailyGainLossPercentage : null, (r92 & 65536) != 0 ? info.lastUpdated : null, (r92 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? info.savingId : null, (r92 & 262144) != 0 ? info.title : null, (r92 & 524288) != 0 ? info.categoryCode : null, (r92 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? info.currentAmount : null, (r92 & 2097152) != 0 ? info.targetAmount : null, (r92 & 4194304) != 0 ? info.orderStatus : null, (r92 & 8388608) != 0 ? info.orderSubStatus : null, (r92 & 16777216) != 0 ? info.createdTime : null, (r92 & 33554432) != 0 ? info.achievedTime : null, (r92 & 67108864) != 0 ? info.completedTime : null, (r92 & 134217728) != 0 ? info.extendInfo : null, (r92 & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? info.cardBackground : null, (r92 & 536870912) != 0 ? info.phoneNumber : str, (r92 & 1073741824) != 0 ? info.kycLevel : str3, (r92 & Integer.MIN_VALUE) != 0 ? info.nickname : str2, (r93 & 1) != 0 ? info.urlTimestamp : null, (r93 & 2) != 0 ? info.cacheTimestamp : null) : null, 3, null);
        }
        return userAssetInfosModel;
    }

    public static final String getTitleCard(UserAssetInfosModel userAssetInfosModel) {
        String valueOf;
        Intrinsics.checkNotNullParameter(userAssetInfosModel, "");
        String assetType = userAssetInfosModel.getAssetType();
        if (Intrinsics.areEqual(assetType, CardAssetType.EMAS.getAsset())) {
            String upperCase = userAssetInfosModel.getAssetType().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            if (upperCase.length() > 0) {
                char lowerCase = Character.toLowerCase(upperCase.charAt(0));
                String substring = upperCase.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "");
                StringBuilder sb = new StringBuilder();
                sb.append(lowerCase);
                sb.append(substring);
                return sb.toString();
            }
            return upperCase;
        }
        if (Intrinsics.areEqual(assetType, CardAssetType.DANA_PLUS.getAsset())) {
            StringBuilder sb2 = new StringBuilder();
            String str = (String) CollectionsKt.firstOrNull(StringsKt.split$default((CharSequence) userAssetInfosModel.getAssetType(), new String[]{"_"}, false, 0, 6, (Object) null));
            if (str != null) {
                r5 = str.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(r5, "");
            }
            sb2.append(r5);
            sb2.append('+');
            return sb2.toString();
        } else if (Intrinsics.areEqual(assetType, CardAssetType.DEBIT_CARD.getAsset())) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[2];
            UserAssetsModel info = userAssetInfosModel.getInfo();
            r5 = info != null ? info.getInstOfficialName() : null;
            if (r5 == null) {
                r5 = "";
            }
            objArr[0] = r5;
            objArr[1] = GlobalSendMethodTransferProperty.DEBIT;
            String format = String.format("%s %s", Arrays.copyOf(objArr, 2));
            Intrinsics.checkNotNullExpressionValue(format, "");
            return format;
        } else if (Intrinsics.areEqual(assetType, CardAssetType.CREDIT_CARD.getAsset())) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            Object[] objArr2 = new Object[2];
            UserAssetsModel info2 = userAssetInfosModel.getInfo();
            r5 = info2 != null ? info2.getInstOfficialName() : null;
            if (r5 == null) {
                r5 = "";
            }
            objArr2[0] = r5;
            objArr2[1] = "Credit";
            String format2 = String.format("%s %s", Arrays.copyOf(objArr2, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "");
            return format2;
        } else {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            Object[] objArr3 = new Object[2];
            objArr3[0] = TrackerKey.DanaBalanceRecipientTypeProperty.DANA;
            String assetType2 = userAssetInfosModel.getAssetType();
            if (assetType2 != null) {
                String lowerCase2 = assetType2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "");
                if (lowerCase2 != null) {
                    if (lowerCase2.length() > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        char charAt = lowerCase2.charAt(0);
                        if (Character.isLowerCase(charAt)) {
                            Locale locale = Locale.getDefault();
                            Intrinsics.checkNotNullExpressionValue(locale, "");
                            valueOf = CharsKt.titlecase(charAt, locale);
                        } else {
                            valueOf = String.valueOf(charAt);
                        }
                        sb3.append((Object) valueOf);
                        String substring2 = lowerCase2.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring2, "");
                        sb3.append(substring2);
                        r5 = sb3.toString();
                    } else {
                        r5 = lowerCase2;
                    }
                }
            }
            objArr3[1] = r5;
            String format3 = String.format("%s %s", Arrays.copyOf(objArr3, 2));
            Intrinsics.checkNotNullExpressionValue(format3, "");
            return format3;
        }
    }
}
