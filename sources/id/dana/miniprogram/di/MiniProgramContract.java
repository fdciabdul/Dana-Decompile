package id.dana.miniprogram.di;

import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.domain.miniprogram.model.MiniProgram;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/miniprogram/di/MiniProgramContract;", "", "<init>", "()V", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MiniProgramContract {

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/miniprogram/di/MiniProgramContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Lid/dana/miniprogram/di/MiniProgramContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "onFavoriteLimitExceeded", "", "appId", "", "onGetMiniPrograms", "miniPrograms", "", "Lid/dana/domain/miniprogram/model/MiniProgram;", "onLoadFavoriteMiniPrograms", "favoriteMiniPrograms", "onLoadRecentMiniPrograms", "recentMiniPrograms", "onSetFavoriteMiniPrograms", TrackerKey.SendMoneyProperties.IS_FAVORITE, "", "onSetRecentMiniProgram", "lastOpen", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void onFavoriteLimitExceeded(String appId);

        void onGetMiniPrograms(List<MiniProgram> miniPrograms);

        void onLoadFavoriteMiniPrograms(List<MiniProgram> favoriteMiniPrograms);

        void onLoadRecentMiniPrograms(List<MiniProgram> recentMiniPrograms);

        void onSetFavoriteMiniPrograms(String appId, boolean isFavorite);

        void onSetRecentMiniProgram(String appId, long lastOpen);
    }
}
