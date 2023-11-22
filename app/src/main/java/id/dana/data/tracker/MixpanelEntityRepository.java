package id.dana.data.tracker;

import android.content.Context;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.tracker.repository.source.local.MixpanelPreferences;
import id.dana.domain.tracker.MixpanelRepository;
import java.util.HashMap;
import javax.inject.Inject;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MixpanelEntityRepository implements MixpanelRepository {
    private final Context context;
    private final MixpanelPreferences mixpanelPreferences;

    @Override // id.dana.domain.tracker.MixpanelRepository
    public String getMixpanelSource() {
        return TrackerDataKey.MixpanelSourceType.MIXPANEL_DATA_TRACKER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public MixpanelEntityRepository(Context context, MixpanelPreferences mixpanelPreferences) {
        this.context = context;
        this.mixpanelPreferences = mixpanelPreferences;
    }

    public void initMixpanelEntityData() {
        registerSuperProperties(getMixpanelSourceProperty());
    }

    @Override // id.dana.domain.tracker.MixpanelRepository
    public boolean isAliasExist() {
        return this.mixpanelPreferences.getAliasExist();
    }

    @Override // id.dana.domain.tracker.MixpanelRepository
    public void saveAliasExist(boolean z) {
        this.mixpanelPreferences.saveMixpanelAliasExist(z);
    }

    @Override // id.dana.domain.tracker.MixpanelRepository
    public void track(String str, JSONObject jSONObject) {
        MixPanelDataTracker.PlaceComponentResult(this.context, str, jSONObject);
    }

    @Override // id.dana.domain.tracker.MixpanelRepository
    public void registerSuperProperties(JSONObject jSONObject) {
        MixPanelDataTracker.BuiltInFictitiousFunctionClassFactory(this.context, jSONObject);
    }

    @Override // id.dana.domain.tracker.MixpanelRepository
    public void optOutTracking() {
        MixPanelDataTracker.BuiltInFictitiousFunctionClassFactory(this.context);
    }

    @Override // id.dana.domain.tracker.MixpanelRepository
    public void optInTracking() {
        MixPanelDataTracker.PlaceComponentResult(this.context);
    }

    @Override // id.dana.domain.tracker.MixpanelRepository
    public void reset() {
        MixPanelDataTracker.KClassImpl$Data$declaredNonStaticMembers$2(this.context);
    }

    @Override // id.dana.domain.tracker.MixpanelRepository
    public void setAlias(String str, boolean z) {
        MixPanelDataTracker.KClassImpl$Data$declaredNonStaticMembers$2(this.context, str, z);
    }

    @Override // id.dana.domain.tracker.MixpanelRepository
    public void setIdentify(String str, boolean z) {
        MixPanelDataTracker.PlaceComponentResult(this.context, str, z);
    }

    @Override // id.dana.domain.tracker.MixpanelRepository
    public void setPeople(JSONObject jSONObject) {
        MixPanelDataTracker.getAuthRequestContext(this.context, jSONObject);
    }

    @Override // id.dana.domain.tracker.MixpanelRepository
    public void setPeopleOnce(JSONObject jSONObject) {
        MixPanelDataTracker.MyBillsEntityDataFactory(this.context, jSONObject);
    }

    @Override // id.dana.domain.tracker.MixpanelRepository
    public String getDistinctId() {
        return MixPanelDataTracker.MyBillsEntityDataFactory(this.context);
    }

    @Override // id.dana.domain.tracker.MixpanelRepository
    public void startTimer(String str) {
        MixPanelDataTracker.BuiltInFictitiousFunctionClassFactory(this.context, str);
    }

    JSONObject getMixpanelSourceProperty() {
        HashMap hashMap = new HashMap();
        hashMap.put(TrackerDataKey.SuperProperties.MIXPANEL_SOURCE, getMixpanelSource());
        return new JSONObject(hashMap);
    }
}
