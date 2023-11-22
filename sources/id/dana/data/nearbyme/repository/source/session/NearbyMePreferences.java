package id.dana.data.nearbyme.repository.source.session;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.promocenter.repository.source.local.model.UserCoordinateEntityData;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NearbyMePreferences {
    private static final String KEY_NEARBYME_TOOLTIP = "nearbyme_tooltip";
    private static final String KEY_NEARBY_SHOPS_WITH_PAGINATION = "nearby_shops_with_pagination";
    private static final String KEY_NEARBY_WIDGET_LAST_LOC = "nearby_widget_last_location";
    private static final String SESSION_PREFERENCES = "NearbyPreferencesproduction";
    private final PreferenceFacade preferenceFacade;
    private final SecurityGuardFacade securityGuardFacade;

    @Inject
    public NearbyMePreferences(Context context, Serializer serializer) {
        this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(SESSION_PREFERENCES).setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        this.securityGuardFacade = new SecurityGuardFacade(context);
    }

    public String getNearbyShopsWithPagination() {
        if (!this.preferenceFacade.getBoolean(LocalStorageFactory.KEY_SECURED, false).booleanValue()) {
            String string = this.preferenceFacade.getString(KEY_NEARBY_SHOPS_WITH_PAGINATION);
            setNearbyShopsWithPagination(string);
            return string;
        }
        try {
            SecurityGuardFacade securityGuardFacade = this.securityGuardFacade;
            return securityGuardFacade.PlaceComponentResult().getDynamicDataEncryptComp().dynamicDecryptDDp(this.preferenceFacade.getString(KEY_NEARBY_SHOPS_WITH_PAGINATION));
        } catch (SecException unused) {
            return null;
        }
    }

    public void setNearbyShopsWithPagination(String str) {
        try {
            this.preferenceFacade.saveData(KEY_NEARBY_SHOPS_WITH_PAGINATION, this.securityGuardFacade.PlaceComponentResult().getDynamicDataEncryptComp().dynamicEncryptDDp(str));
            this.preferenceFacade.saveData(LocalStorageFactory.KEY_SECURED, Boolean.TRUE);
        } catch (SecException unused) {
            this.preferenceFacade.saveData(KEY_NEARBY_SHOPS_WITH_PAGINATION, str);
        }
    }

    public void setNearbyWidgetLastLocation(UserCoordinateEntityData userCoordinateEntityData) {
        this.preferenceFacade.saveData(KEY_NEARBY_WIDGET_LAST_LOC, (String) userCoordinateEntityData);
    }

    public UserCoordinateEntityData getNearbyWidgetLastLocation() {
        return (UserCoordinateEntityData) this.preferenceFacade.getObject(KEY_NEARBY_WIDGET_LAST_LOC, UserCoordinateEntityData.class);
    }

    public void clearAll() {
        this.preferenceFacade.clearAllData();
    }

    public boolean getToolTipShow(String str) {
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(KEY_NEARBYME_TOOLTIP);
        sb.append(str);
        return preferenceFacade.getBoolean(sb.toString(), false).booleanValue();
    }

    public boolean saveToolTipShow(String str) {
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(KEY_NEARBYME_TOOLTIP);
        sb.append(str);
        preferenceFacade.saveData(sb.toString(), Boolean.TRUE);
        return true;
    }
}
