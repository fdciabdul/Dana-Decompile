package id.dana.data.userconfig.repository.source.local;

import id.dana.data.userconfig.repository.source.EtagEntityData;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PersistenceEtagEntityData implements EtagEntityData {
    private final UserConfigPreference userConfigPreference;

    @Inject
    public PersistenceEtagEntityData(UserConfigPreference userConfigPreference) {
        this.userConfigPreference = userConfigPreference;
    }

    @Override // id.dana.data.userconfig.repository.source.EtagEntityData
    public Observable<String> getEtag(String str) {
        return Observable.just(this.userConfigPreference.getEtag(str));
    }

    @Override // id.dana.data.userconfig.repository.source.EtagEntityData
    public Observable<Boolean> saveEtag(String str, String str2) {
        return Observable.just(Boolean.valueOf(this.userConfigPreference.saveEtag(str, str2)));
    }
}
