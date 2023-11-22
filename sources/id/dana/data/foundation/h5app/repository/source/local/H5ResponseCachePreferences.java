package id.dana.data.foundation.h5app.repository.source.local;

import android.content.Context;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.SecurityGuardPreference;
import id.dana.data.storage.Serializer;
import id.dana.domain.foundation.h5app.model.H5CacheHttpResponse;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class H5ResponseCachePreferences {
    public SecurityGuardPreference KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public H5ResponseCachePreferences(Context context, Serializer serializer) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LocalStorageFactory.Builder(context).setPreferenceGroup("h5ResponseCache").setSerializerFacade(serializer).setPassword(UserInfoManager.instance().getUserId()).buildSecurityGuardPreference();
    }

    public final Boolean MyBillsEntityDataFactory(String str, H5CacheHttpResponse h5CacheHttpResponse) {
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2.saveData(str, (String) h5CacheHttpResponse);
            return Boolean.TRUE;
        } catch (Exception e) {
            DanaLog.scheduleImpl("H5ResponseCachePreferences", e.getMessage());
            return Boolean.FALSE;
        }
    }

    public final H5CacheHttpResponse PlaceComponentResult(String str) {
        try {
            return (H5CacheHttpResponse) this.KClassImpl$Data$declaredNonStaticMembers$2.getObject(str, H5CacheHttpResponse.class);
        } catch (Exception e) {
            DanaLog.scheduleImpl("H5ResponseCachePreferences", e.getMessage());
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.clearAllData();
                return null;
            } catch (Exception e2) {
                DanaLog.scheduleImpl("H5ResponseCachePreferences", e2.getMessage());
                return null;
            }
        }
    }
}
