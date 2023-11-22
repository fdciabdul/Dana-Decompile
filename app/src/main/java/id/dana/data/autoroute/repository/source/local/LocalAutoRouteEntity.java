package id.dana.data.autoroute.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/autoroute/repository/source/local/LocalAutoRouteEntity;", "", "Lio/reactivex/Observable;", "", "isHavingAutoRouteAsset", "()Lio/reactivex/Observable;", "isNeed", "saveAutoRouteAssetState", "(Z)Lio/reactivex/Observable;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalAutoRouteEntity {
    private static final String AUTO_ROUTE_NEED_ASSET_STATE = "AUTO_ROUTE_NEED_ASSET_STATE";
    private static final String AUTO_ROUTE_PREFERENCE;
    private final PreferenceFacade preferenceFacade;

    @Inject
    public LocalAutoRouteEntity(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(AUTO_ROUTE_PREFERENCE).setUseDrutherPreference(true).setSerializerFacade(null)).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.preferenceFacade = createData;
    }

    public final Observable<Boolean> saveAutoRouteAssetState(boolean isNeed) {
        this.preferenceFacade.saveData(AUTO_ROUTE_NEED_ASSET_STATE, Boolean.valueOf(isNeed));
        Observable<Boolean> just = Observable.just(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    public final Observable<Boolean> isHavingAutoRouteAsset() {
        Observable<Boolean> just = Observable.just(this.preferenceFacade.getBoolean(AUTO_ROUTE_NEED_ASSET_STATE));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        StringBuilder sb = new StringBuilder();
        sb.append(Reflection.getOrCreateKotlinClass(companion.getClass()).getSimpleName());
        sb.append("production");
        AUTO_ROUTE_PREFERENCE = sb.toString();
    }
}
