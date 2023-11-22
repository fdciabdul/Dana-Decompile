package id.dana.domain.featureconfig.model;

import com.alibaba.griver.core.GriverParams;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004"}, d2 = {"Lid/dana/domain/featureconfig/model/ShowAlipayConnectBrandConfig;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", ContainerUIProvider.KEY_SHOW, GriverParams.ShareParams.IMAGE_URL, "copy", "(ZLjava/lang/String;)Lid/dana/domain/featureconfig/model/ShowAlipayConnectBrandConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getImageUrl", "Z", "getShow", "<init>", "(ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ShowAlipayConnectBrandConfig {
    private final String imageUrl;
    private final boolean show;

    public static /* synthetic */ ShowAlipayConnectBrandConfig copy$default(ShowAlipayConnectBrandConfig showAlipayConnectBrandConfig, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = showAlipayConnectBrandConfig.show;
        }
        if ((i & 2) != 0) {
            str = showAlipayConnectBrandConfig.imageUrl;
        }
        return showAlipayConnectBrandConfig.copy(z, str);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    /* renamed from: component2  reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final ShowAlipayConnectBrandConfig copy(boolean show, String imageUrl) {
        return new ShowAlipayConnectBrandConfig(show, imageUrl);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ShowAlipayConnectBrandConfig) {
            ShowAlipayConnectBrandConfig showAlipayConnectBrandConfig = (ShowAlipayConnectBrandConfig) other;
            return this.show == showAlipayConnectBrandConfig.show && Intrinsics.areEqual(this.imageUrl, showAlipayConnectBrandConfig.imageUrl);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.show;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        String str = this.imageUrl;
        return (r0 * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShowAlipayConnectBrandConfig(show=");
        sb.append(this.show);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append(')');
        return sb.toString();
    }

    public ShowAlipayConnectBrandConfig(boolean z, String str) {
        this.show = z;
        this.imageUrl = str;
    }

    @JvmName(name = "getShow")
    public final boolean getShow() {
        return this.show;
    }

    @JvmName(name = "getImageUrl")
    public final String getImageUrl() {
        return this.imageUrl;
    }
}
