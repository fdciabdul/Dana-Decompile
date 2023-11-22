package id.dana.data.expresspurchase.source.network.pojo.request;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/request/DealsQueryShopRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "goodsId", "Ljava/lang/String;", "getGoodsId", "()Ljava/lang/String;", "latitude", "getLatitude", "longitude", "getLongitude", "", "page", "I", "getPage", "()I", GriverMonitorConstants.KEY_SIZE, "getSize", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DealsQueryShopRequest extends BaseRpcRequest {
    private final String goodsId;
    private final String latitude;
    private final String longitude;
    private final int page;
    private final int size;

    public DealsQueryShopRequest() {
        this(null, null, null, 0, 0, 31, null);
    }

    public /* synthetic */ DealsQueryShopRequest(String str, String str2, String str3, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) == 0 ? str3 : null, (i3 & 8) != 0 ? 1 : i, (i3 & 16) != 0 ? 1 : i2);
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getLatitude")
    public final String getLatitude() {
        return this.latitude;
    }

    @JvmName(name = "getLongitude")
    public final String getLongitude() {
        return this.longitude;
    }

    @JvmName(name = "getPage")
    public final int getPage() {
        return this.page;
    }

    @JvmName(name = "getSize")
    public final int getSize() {
        return this.size;
    }

    public DealsQueryShopRequest(String str, String str2, String str3, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        this.goodsId = str;
        this.latitude = str2;
        this.longitude = str3;
        this.page = i;
        this.size = i2;
    }
}
