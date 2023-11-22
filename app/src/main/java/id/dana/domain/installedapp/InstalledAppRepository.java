package id.dana.domain.installedapp;

import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/installedapp/InstalledAppRepository;", "", "Lio/reactivex/Observable;", "", "isNeedToSendInstalledApp", "()Lio/reactivex/Observable;", "saveNeedToSendInstalledApp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface InstalledAppRepository {
    Observable<Boolean> isNeedToSendInstalledApp();

    Observable<Boolean> saveNeedToSendInstalledApp();
}
