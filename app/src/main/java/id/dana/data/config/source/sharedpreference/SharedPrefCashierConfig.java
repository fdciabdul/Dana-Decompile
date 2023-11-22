package id.dana.data.config.source.sharedpreference;

import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.google.gson.Gson;
import id.dana.data.storage.PreferenceFacade;
import id.dana.domain.featureconfig.CashierConfigEntityData;
import id.dana.domain.featureconfig.model.CashierMerchantWhitelistConfig;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0002,-B\u001b\b\u0007\u0012\b\b\u0001\u0010(\u001a\u00020'\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0012J\u001d\u0010\u0017\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001f\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lid/dana/data/config/source/sharedpreference/SharedPrefCashierConfig;", "Lid/dana/domain/featureconfig/CashierConfigEntityData;", "", "key", "", "checkTimeisExpired", "(Ljava/lang/String;)Z", "", "clearAll", "()V", "Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;", "getCashierMerchantWhitelistConfigs", "()Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;", "", "getCashierNativeEntryPoints", "()Ljava/util/List;", "getCustomLoading3dsUrls", "getFeatureCashierEnable", "()Z", "isCashierMerchantWhitelistConfigTimeExpired", "isCashierNativeEntryPointsTimeExpired", "isFeatureCashierTimeExpired", GriverConfigConstants.KEY_CCDN_H5_CONFIG_URLS, "saveCustomLoading3dsUrls", "(Ljava/util/List;)V", "merchantWhitelists", "", "createdTime", "setCashierMerchantWhitelistConfigs", "(Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;J)V", "entryPoints", "setCashierNativeEntryPoints", "(Ljava/util/List;J)V", "enable", "setFeatureCashierEnable", "(ZJ)V", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "<init>", "(Lid/dana/data/storage/PreferenceFacade;Lcom/google/gson/Gson;)V", "Companion", "Keys"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SharedPrefCashierConfig implements CashierConfigEntityData {
    public static final String CASHIER_CONFIG_PREF = "cashierconfigprefkey";
    private final Gson gson;
    private final PreferenceFacade preferenceFacade;

    @Inject
    public SharedPrefCashierConfig(@Named("cashierconfigpref") PreferenceFacade preferenceFacade, Gson gson) {
        Intrinsics.checkNotNullParameter(preferenceFacade, "");
        Intrinsics.checkNotNullParameter(gson, "");
        this.preferenceFacade = preferenceFacade;
        this.gson = gson;
    }

    @Override // id.dana.domain.featureconfig.CashierConfigEntityData
    public final boolean getFeatureCashierEnable() {
        Boolean bool = this.preferenceFacade.getBoolean("featurecashier", true);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    @Override // id.dana.domain.featureconfig.CashierConfigEntityData
    public final void setFeatureCashierEnable(boolean enable, long createdTime) {
        this.preferenceFacade.saveData("featurecashiertimesaved", Long.valueOf(createdTime));
        this.preferenceFacade.saveData("featurecashier", Boolean.valueOf(enable));
    }

    @Override // id.dana.domain.featureconfig.CashierConfigEntityData
    public final boolean isFeatureCashierTimeExpired() {
        return checkTimeisExpired("featurecashiertimesaved");
    }

    @Override // id.dana.domain.featureconfig.CashierConfigEntityData
    public final CashierMerchantWhitelistConfig getCashierMerchantWhitelistConfigs() {
        CashierMerchantWhitelistConfig cashierMerchantWhitelistConfig;
        String string = this.preferenceFacade.getString("cashiermerchantwhitelistconfig");
        if (string != null) {
            try {
                cashierMerchantWhitelistConfig = (CashierMerchantWhitelistConfig) this.gson.fromJson(string, CashierMerchantWhitelistConfig.class);
            } catch (Exception unused) {
                cashierMerchantWhitelistConfig = new CashierMerchantWhitelistConfig("", CollectionsKt.emptyList());
            }
        } else {
            cashierMerchantWhitelistConfig = null;
        }
        return cashierMerchantWhitelistConfig == null ? new CashierMerchantWhitelistConfig("", CollectionsKt.emptyList()) : cashierMerchantWhitelistConfig;
    }

    @Override // id.dana.domain.featureconfig.CashierConfigEntityData
    public final void setCashierMerchantWhitelistConfigs(CashierMerchantWhitelistConfig merchantWhitelists, long createdTime) {
        Intrinsics.checkNotNullParameter(merchantWhitelists, "");
        this.preferenceFacade.saveData("cashiermerchantwhitelistconfigtimesaved", Long.valueOf(createdTime));
        this.preferenceFacade.saveData("cashiermerchantwhitelistconfig", this.gson.toJson(merchantWhitelists));
    }

    @Override // id.dana.domain.featureconfig.CashierConfigEntityData
    public final boolean isCashierMerchantWhitelistConfigTimeExpired() {
        return checkTimeisExpired("cashiermerchantwhitelistconfigtimesaved");
    }

    @Override // id.dana.domain.featureconfig.CashierConfigEntityData
    public final List<String> getCashierNativeEntryPoints() {
        List<String> emptyList;
        String string = this.preferenceFacade.getString("cashiernativeentrypoints");
        if (string != null) {
            try {
                Object fromJson = this.gson.fromJson(string, (Class<Object>) List.class);
                emptyList = fromJson instanceof List ? (List) fromJson : null;
            } catch (Exception unused) {
                emptyList = CollectionsKt.emptyList();
            }
            if (emptyList != null) {
                return emptyList;
            }
        }
        return CollectionsKt.emptyList();
    }

    @Override // id.dana.domain.featureconfig.CashierConfigEntityData
    public final void setCashierNativeEntryPoints(List<String> entryPoints, long createdTime) {
        Intrinsics.checkNotNullParameter(entryPoints, "");
        this.preferenceFacade.saveData("cashiernativeentrypointstimesaved", Long.valueOf(createdTime));
        this.preferenceFacade.saveData("cashiernativeentrypoints", this.gson.toJson(entryPoints));
    }

    @Override // id.dana.domain.featureconfig.CashierConfigEntityData
    public final boolean isCashierNativeEntryPointsTimeExpired() {
        return checkTimeisExpired("cashiernativeentrypointstimesaved");
    }

    @Override // id.dana.domain.featureconfig.CashierConfigEntityData
    public final List<String> getCustomLoading3dsUrls() {
        try {
            Object object = this.preferenceFacade.getObject("customloading3dsurls", List.class);
            List<String> list = object instanceof List ? (List) object : null;
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            return list;
        } finally {
            CollectionsKt.emptyList();
        }
    }

    @Override // id.dana.domain.featureconfig.CashierConfigEntityData
    public final void saveCustomLoading3dsUrls(List<String> urls) {
        Intrinsics.checkNotNullParameter(urls, "");
        this.preferenceFacade.saveData("customloading3dsurls", (String) urls);
    }

    private final boolean checkTimeisExpired(String key) {
        Long l;
        try {
            l = this.preferenceFacade.getLong(key);
            Intrinsics.checkNotNullExpressionValue(l, "");
        } catch (Exception unused) {
        }
        return Calendar.getInstance().getTimeInMillis() - l.longValue() > TimeUnit.MINUTES.toMillis(30L);
    }

    @Override // id.dana.domain.featureconfig.CashierConfigEntityData
    public final void clearAll() {
        this.preferenceFacade.clearAllData();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/config/source/sharedpreference/SharedPrefCashierConfig$Keys;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    static final class Keys {
        public static final Keys INSTANCE = new Keys();

        private Keys() {
        }
    }
}
