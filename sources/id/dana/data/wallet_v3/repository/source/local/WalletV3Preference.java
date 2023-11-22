package id.dana.data.wallet_v3.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.gson.Gson;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.data.wallet_v3.model.RecommendationConfigKey;
import id.dana.domain.wallet_v3.model.WalletV3RecommendationConfig;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 =2\u00020\u0001:\u0001=B!\b\u0007\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u00100\u001a\u00020/¢\u0006\u0004\b;\u0010<J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0013J\r\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u0004J\r\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u0004J\r\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\r\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u0004J\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000b¢\u0006\u0004\b!\u0010\"J\u001b\u0010$\u001a\u00020\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0011¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0011¢\u0006\u0004\b)\u0010(J\u0015\u0010*\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0011¢\u0006\u0004\b*\u0010(J\u0015\u0010+\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0011¢\u0006\u0004\b+\u0010(J\u001d\u0010-\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005¢\u0006\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00058\u0002X\u0082D¢\u0006\u0006\n\u0004\b5\u00106"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/local/WalletV3Preference;", "", "", "clearAll", "()V", "", "instId", "", "getLastVersionBgUrlTimestamp", "(Ljava/lang/String;)Ljava/lang/Long;", "key", "Lid/dana/domain/wallet_v3/model/WalletV3RecommendationConfig;", "getRecommendationConfig", "(Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/WalletV3RecommendationConfig;", "", "getRecommendationConfigKey", "()Ljava/util/List;", "", "getTotalIdentityQuery", "()I", "getTotalInvestmentQuery", "getTotalLoyaltyQuery", "getTotalVoucherQuery", "phoneNumber", "getVoucherAndTicketOrder", "(Ljava/lang/String;)Ljava/lang/String;", "resetTotalIdentityQuery", "resetTotalInvestmentQuery", "resetTotalLoyaltyQuery", "resetTotalVoucherQuery", "saveLastVersionBgUrlTimestamp", "(Ljava/lang/String;)J", "data", "saveRecommendationConfig", "(Ljava/lang/String;Lid/dana/domain/wallet_v3/model/WalletV3RecommendationConfig;)V", UserMetadata.KEYDATA_FILENAME, "saveRecommendationConfigKey", "(Ljava/util/List;)V", "totalQuery", "saveTotalIdentityQuery", "(I)V", "saveTotalInvestmentQuery", "saveTotalLoyaltyQuery", "saveTotalVoucherQuery", "order", "saveVoucherAndTicketOrder", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "walletV3Preference", "Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/data/storage/Serializer;", "serializer", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;Lcom/google/gson/Gson;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WalletV3Preference {
    private static final String BANK_CARD_URL_VERSION = "BANK_CARD_URL_VERSION";
    private static final String IDENTITY_ASSETS_QUERY = "IDENTITY_ASSETS_QUERY";
    private static final String INVESTMENT_ASSETS_QUERY = "INVESTMENT_ASSETS_QUERY";
    private static final String LOYALTY_ASSETS_QUERY = "LOYALTY_ASSETS_QUERY";
    private static final String RECOMMENDATION_CONFIG_KEY = "RECOMMENDATION_CONFIG_KEY";
    private static final String VOUCHER_ASSETS_QUERY = "VOUCHER_ASSETS_QUERY";
    private static final String VOUCHER_TICKET_ORDER = "VOUCHER_TICKET_ORDER";
    private final Gson gson;
    private final PreferenceFacade preferenceFacade;
    private final String walletV3Preference;

    @Inject
    public WalletV3Preference(Context context, Serializer serializer, Gson gson) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        Intrinsics.checkNotNullParameter(gson, "");
        this.gson = gson;
        this.walletV3Preference = "WalletV3Preferenceproduction";
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("WalletV3Preferenceproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.preferenceFacade = new SimpleSecureKeyPreference(createData2);
    }

    public final Long getLastVersionBgUrlTimestamp(String instId) {
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(BANK_CARD_URL_VERSION);
        sb.append(instId);
        return preferenceFacade.getLong(sb.toString());
    }

    public final long saveLastVersionBgUrlTimestamp(String instId) {
        Intrinsics.checkNotNullParameter(instId, "");
        long currentTimeMillis = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30L);
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(BANK_CARD_URL_VERSION);
        sb.append(instId);
        preferenceFacade.saveData(sb.toString(), Long.valueOf(currentTimeMillis));
        return currentTimeMillis;
    }

    public final String getVoucherAndTicketOrder(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(VOUCHER_TICKET_ORDER);
        sb.append(phoneNumber);
        return preferenceFacade.getString(sb.toString());
    }

    public final void saveVoucherAndTicketOrder(String phoneNumber, String order) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(order, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(VOUCHER_TICKET_ORDER);
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), order);
    }

    public final int getTotalInvestmentQuery() {
        Integer integer = this.preferenceFacade.getInteger(INVESTMENT_ASSETS_QUERY);
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    public final void saveTotalInvestmentQuery(int totalQuery) {
        this.preferenceFacade.saveData(INVESTMENT_ASSETS_QUERY, Integer.valueOf(totalQuery));
    }

    public final void resetTotalInvestmentQuery() {
        this.preferenceFacade.clearData(INVESTMENT_ASSETS_QUERY);
    }

    public final int getTotalVoucherQuery() {
        Integer integer = this.preferenceFacade.getInteger(VOUCHER_ASSETS_QUERY);
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    public final void saveTotalVoucherQuery(int totalQuery) {
        this.preferenceFacade.saveData(VOUCHER_ASSETS_QUERY, Integer.valueOf(totalQuery));
    }

    public final void resetTotalVoucherQuery() {
        this.preferenceFacade.clearData(VOUCHER_ASSETS_QUERY);
    }

    public final int getTotalLoyaltyQuery() {
        Integer integer = this.preferenceFacade.getInteger(LOYALTY_ASSETS_QUERY);
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    public final void saveTotalLoyaltyQuery(int totalQuery) {
        this.preferenceFacade.saveData(LOYALTY_ASSETS_QUERY, Integer.valueOf(totalQuery));
    }

    public final void resetTotalLoyaltyQuery() {
        this.preferenceFacade.clearData(LOYALTY_ASSETS_QUERY);
    }

    public final int getTotalIdentityQuery() {
        Integer integer = this.preferenceFacade.getInteger(IDENTITY_ASSETS_QUERY);
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    public final void saveTotalIdentityQuery(int totalQuery) {
        this.preferenceFacade.saveData(IDENTITY_ASSETS_QUERY, Integer.valueOf(totalQuery));
    }

    public final void resetTotalIdentityQuery() {
        this.preferenceFacade.clearData(IDENTITY_ASSETS_QUERY);
    }

    public final void saveRecommendationConfigKey(List<String> keys) {
        Intrinsics.checkNotNullParameter(keys, "");
        this.preferenceFacade.saveData(RECOMMENDATION_CONFIG_KEY, this.gson.toJson(new RecommendationConfigKey(keys)));
    }

    public final List<String> getRecommendationConfigKey() {
        RecommendationConfigKey recommendationConfigKey = (RecommendationConfigKey) this.gson.fromJson(this.preferenceFacade.getString(RECOMMENDATION_CONFIG_KEY), RecommendationConfigKey.class);
        if (recommendationConfigKey != null) {
            return recommendationConfigKey.getKeys();
        }
        return null;
    }

    public final void saveRecommendationConfig(String key, WalletV3RecommendationConfig data) {
        Intrinsics.checkNotNullParameter(key, "");
        Intrinsics.checkNotNullParameter(data, "");
        this.preferenceFacade.saveData(key, this.gson.toJson(data));
    }

    public final WalletV3RecommendationConfig getRecommendationConfig(String key) {
        Intrinsics.checkNotNullParameter(key, "");
        return (WalletV3RecommendationConfig) this.gson.fromJson(this.preferenceFacade.getString(key), WalletV3RecommendationConfig.class);
    }

    public final void clearAll() {
        this.preferenceFacade.clearAllData();
    }
}
