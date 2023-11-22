package id.dana.data.deeplink.repository.source;

import android.app.Activity;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface DeepLinkEntityData {
    Observable<Boolean> completeRegistration(String str, String str2);

    Observable<DeepLinkPayloadEntity> getDeepLinkPayload();

    Observable<DeepLinkPayloadEntity> initSession(Activity activity);

    Observable<DeepLinkPayloadEntity> login(String str);

    Observable<Boolean> logout();
}
