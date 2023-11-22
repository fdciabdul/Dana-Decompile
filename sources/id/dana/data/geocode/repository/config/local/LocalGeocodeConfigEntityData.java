package id.dana.data.geocode.repository.config.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.geocode.model.GeocodeReverseConfigResult;
import id.dana.data.geocode.repository.config.GeocodeConfigEntityData;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/geocode/repository/config/local/LocalGeocodeConfigEntityData;", "Lid/dana/data/geocode/repository/config/GeocodeConfigEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/geocode/model/GeocodeReverseConfigResult;", "getGeocodeReverseConfig", "()Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalGeocodeConfigEntityData implements GeocodeConfigEntityData {
    @Inject
    public LocalGeocodeConfigEntityData(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.geocode.repository.config.GeocodeConfigEntityData
    public final Observable<GeocodeReverseConfigResult> getGeocodeReverseConfig() {
        Observable<GeocodeReverseConfigResult> just = Observable.just(new GeocodeReverseConfigResult(null, 0L, false, 7, null));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
