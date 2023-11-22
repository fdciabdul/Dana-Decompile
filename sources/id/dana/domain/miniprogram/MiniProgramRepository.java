package id.dana.domain.miniprogram;

import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.miniprogram.model.MiniProgram;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H&¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/miniprogram/MiniProgramRepository;", "", "Lio/reactivex/Observable;", "", "Lid/dana/domain/miniprogram/model/MiniProgram;", "getMiniPrograms", "()Lio/reactivex/Observable;", "", "appId", "", TrackerKey.SendMoneyProperties.IS_FAVORITE, "allMiniProgramAppIds", "", "setFavoriteMiniPrograms", "(Ljava/lang/String;ZLjava/util/List;)Lio/reactivex/Observable;", "", "lastOpen", "setRecentMiniProgram", "(Ljava/lang/String;J)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MiniProgramRepository {
    Observable<List<MiniProgram>> getMiniPrograms();

    Observable<Unit> setFavoriteMiniPrograms(String appId, boolean isFavorite, List<String> allMiniProgramAppIds);

    Observable<Unit> setRecentMiniProgram(String appId, long lastOpen);
}
