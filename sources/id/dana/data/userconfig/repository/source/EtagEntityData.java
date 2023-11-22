package id.dana.data.userconfig.repository.source;

import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface EtagEntityData {
    Observable<String> getEtag(String str);

    Observable<Boolean> saveEtag(String str, String str2);
}
