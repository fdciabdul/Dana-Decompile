package id.dana.data.login.source;

import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/login/source/HoldLoginErrorCodePreferencesEntityData;", "", "", "", "getHoldLoginErrorCode", "()Ljava/util/List;", "errorCodes", "Lio/reactivex/Observable;", "", "saveHoldLoginErrorCode", "(Ljava/util/List;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface HoldLoginErrorCodePreferencesEntityData {
    List<String> getHoldLoginErrorCode();

    Observable<Boolean> saveHoldLoginErrorCode(List<String> errorCodes);
}
