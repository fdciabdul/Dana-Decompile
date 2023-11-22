package id.dana.rum.quake;

import com.alipay.imobile.network.quake.Request;
import io.opentelemetry.context.propagation.TextMapSetter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/rum/quake/RequestHeaderSetter;", "Lio/opentelemetry/context/propagation/TextMapSetter;", "Lcom/alipay/imobile/network/quake/Request;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RequestHeaderSetter implements TextMapSetter<Request> {
    public static final RequestHeaderSetter INSTANCE = new RequestHeaderSetter();

    private RequestHeaderSetter() {
    }

    @Override // io.opentelemetry.context.propagation.TextMapSetter
    public final /* synthetic */ void set(Request request, String str, String str2) {
        Request request2 = request;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        if (request2 != null) {
            request2.addExternalInfo(str, str2);
        }
    }
}
