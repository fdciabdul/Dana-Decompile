package id.dana.domain.featureconfig;

import com.alibaba.griver.api.common.config.GriverConfigConstants;
import id.dana.domain.featureconfig.model.CashierMerchantWhitelistConfig;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH&¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\rH&¢\u0006\u0004\b\u0012\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ%\u0010\u001c\u001a\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u001f\u0010 ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/featureconfig/CashierConfigEntityData;", "", "", "clearAll", "()V", "Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;", "getCashierMerchantWhitelistConfigs", "()Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;", "", "", "getCashierNativeEntryPoints", "()Ljava/util/List;", "getCustomLoading3dsUrls", "", "getFeatureCashierEnable", "()Z", "isCashierMerchantWhitelistConfigTimeExpired", "isCashierNativeEntryPointsTimeExpired", "isFeatureCashierTimeExpired", GriverConfigConstants.KEY_CCDN_H5_CONFIG_URLS, "saveCustomLoading3dsUrls", "(Ljava/util/List;)V", "merchantWhitelists", "", "createdTime", "setCashierMerchantWhitelistConfigs", "(Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;J)V", "entryPoints", "setCashierNativeEntryPoints", "(Ljava/util/List;J)V", "enable", "setFeatureCashierEnable", "(ZJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CashierConfigEntityData {
    void clearAll();

    CashierMerchantWhitelistConfig getCashierMerchantWhitelistConfigs();

    List<String> getCashierNativeEntryPoints();

    List<String> getCustomLoading3dsUrls();

    boolean getFeatureCashierEnable();

    boolean isCashierMerchantWhitelistConfigTimeExpired();

    boolean isCashierNativeEntryPointsTimeExpired();

    boolean isFeatureCashierTimeExpired();

    void saveCustomLoading3dsUrls(List<String> urls);

    void setCashierMerchantWhitelistConfigs(CashierMerchantWhitelistConfig merchantWhitelists, long createdTime);

    void setCashierNativeEntryPoints(List<String> entryPoints, long createdTime);

    void setFeatureCashierEnable(boolean enable, long createdTime);
}
