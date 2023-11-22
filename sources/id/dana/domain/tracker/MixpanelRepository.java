package id.dana.domain.tracker;

import org.json.JSONObject;

/* loaded from: classes.dex */
public interface MixpanelRepository {
    String getDistinctId();

    String getMixpanelSource();

    boolean isAliasExist();

    void optInTracking();

    void optOutTracking();

    void registerSuperProperties(JSONObject jSONObject);

    void reset();

    void saveAliasExist(boolean z);

    void setAlias(String str, boolean z);

    void setIdentify(String str, boolean z);

    void setPeople(JSONObject jSONObject);

    void setPeopleOnce(JSONObject jSONObject);

    void startTimer(String str);

    void track(String str, JSONObject jSONObject);
}
