package id.dana.data.content.source.mock;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.R;
import id.dana.data.content.source.ContentDeliveryEntityData;
import id.dana.data.content.source.network.result.SpaceRpcResult;
import id.dana.data.storage.Serializer;
import id.dana.data.util.RawUtils;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/content/source/mock/MockContentDeliveryEntityData;", "Lid/dana/data/content/source/ContentDeliveryEntityData;", "", "spaceCode", "Lio/reactivex/Observable;", "Lid/dana/data/content/source/network/result/SpaceRpcResult;", "get", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MockContentDeliveryEntityData implements ContentDeliveryEntityData {
    private final Context context;
    private final Serializer serializer;

    public MockContentDeliveryEntityData(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.context = context;
        this.serializer = serializer;
    }

    @Override // id.dana.data.content.source.ContentDeliveryEntityData
    public final Observable<SpaceRpcResult> get(String spaceCode) {
        Observable<SpaceRpcResult> just = Observable.just(this.serializer.deserialize(RawUtils.jsonRawToString(this.context, R.raw.getErrorConfigVersion), SpaceRpcResult.class));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
