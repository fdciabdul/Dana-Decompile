package id.dana.domain.deeplink.repository;

import android.app.Activity;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.domain.deeplink.model.DeepLinkPayload;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/deeplink/repository/DeepLinkRepository;", "", "", "fromRoot", "Lio/reactivex/Observable;", "Lid/dana/domain/deeplink/model/DeepLinkPayload;", "getDeepLinkPayload", "(Z)Lio/reactivex/Observable;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "initSession", "(Landroid/app/Activity;)Lio/reactivex/Observable;", "", "url", "readProperties", "(Ljava/lang/String;)Lio/reactivex/Observable;", "removeDeeplinkPayload", "()Z"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DeepLinkRepository {
    Observable<DeepLinkPayload> getDeepLinkPayload(boolean fromRoot);

    Observable<DeepLinkPayload> initSession(Activity activity);

    Observable<DeepLinkPayload> readProperties(String url);

    boolean removeDeeplinkPayload();
}
