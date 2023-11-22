package id.dana.data.announcement.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/announcement/repository/source/network/request/AnnouncementRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "announcementType", "Ljava/lang/String;", "getAnnouncementType", "()Ljava/lang/String;", "setAnnouncementType", "(Ljava/lang/String;)V", "", "extendInfo", "Ljava/util/Map;", "getExtendInfo", "()Ljava/util/Map;", "setExtendInfo", "(Ljava/util/Map;)V", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnnouncementRequest extends BaseRpcRequest {
    private String announcementType;
    private Map<String, String> extendInfo;

    @JvmName(name = "getAnnouncementType")
    public final String getAnnouncementType() {
        return this.announcementType;
    }

    @JvmName(name = "setAnnouncementType")
    public final void setAnnouncementType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.announcementType = str;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "setExtendInfo")
    public final void setExtendInfo(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.extendInfo = map;
    }

    public AnnouncementRequest(String str, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.announcementType = str;
        this.extendInfo = map;
    }
}
