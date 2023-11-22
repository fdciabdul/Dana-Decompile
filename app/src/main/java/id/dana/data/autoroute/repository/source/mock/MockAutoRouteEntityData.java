package id.dana.data.autoroute.repository.source.mock;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.R;
import id.dana.data.autoroute.model.AutoRouteInitResult;
import id.dana.data.autoroute.model.UserAutoRouteConfigStoreRequest;
import id.dana.data.autoroute.repository.AutoRouteEntityData;
import id.dana.data.storage.Serializer;
import id.dana.data.util.RawUtils;
import id.dana.network.response.autoroute.UserAutoRouteConfigSwitchResult;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/data/autoroute/repository/source/mock/MockAutoRouteEntityData;", "Lid/dana/data/autoroute/repository/AutoRouteEntityData;", "", "needAssetCheck", "Lio/reactivex/Observable;", "Lid/dana/data/autoroute/model/AutoRouteInitResult;", "getInitialSetting", "(Z)Lio/reactivex/Observable;", "Lid/dana/data/autoroute/model/UserAutoRouteConfigStoreRequest;", "userAutoRouteConfigStoreRequest", "isFromCashierFlow", "Lid/dana/network/response/autoroute/UserAutoRouteConfigSwitchResult;", "switchConfig", "(Lid/dana/data/autoroute/model/UserAutoRouteConfigStoreRequest;Ljava/lang/Boolean;)Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "getSerializer", "()Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MockAutoRouteEntityData implements AutoRouteEntityData {
    private final Context context;
    private final Serializer serializer;

    @Inject
    public MockAutoRouteEntityData(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.context = context;
        this.serializer = serializer;
    }

    @JvmName(name = "getContext")
    public final Context getContext() {
        return this.context;
    }

    @JvmName(name = "getSerializer")
    public final Serializer getSerializer() {
        return this.serializer;
    }

    @Override // id.dana.data.autoroute.repository.AutoRouteEntityData
    public final Observable<AutoRouteInitResult> getInitialSetting(boolean needAssetCheck) {
        Observable<AutoRouteInitResult> just = Observable.just(this.serializer.deserialize(RawUtils.jsonRawToString(this.context, R.raw.getAuthRequestContext_res_0x7f12001c), AutoRouteInitResult.class));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.autoroute.repository.AutoRouteEntityData
    public final Observable<UserAutoRouteConfigSwitchResult> switchConfig(UserAutoRouteConfigStoreRequest userAutoRouteConfigStoreRequest, Boolean isFromCashierFlow) {
        Intrinsics.checkNotNullParameter(userAutoRouteConfigStoreRequest, "");
        StringBuilder sb = new StringBuilder();
        sb.append("An operation is not implemented: ");
        sb.append("Not yet implemented");
        throw new NotImplementedError(sb.toString());
    }
}
