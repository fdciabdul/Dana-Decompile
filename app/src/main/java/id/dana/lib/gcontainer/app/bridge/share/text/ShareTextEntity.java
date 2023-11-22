package id.dana.lib.gcontainer.app.bridge.share.text;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.griver.api.constants.GriverEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B-\b\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/share/text/ShareTextEntity;", "", "", "bizCode", "Ljava/lang/String;", "getBizCode", "()Ljava/lang/String;", "setBizCode", "(Ljava/lang/String;)V", "message", "getMessage", "setMessage", "title", "getTitle", GriverEvents.EVENT_SET_TITLE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ShareTextEntity {
    private String bizCode;
    private String message;
    private String title;

    @JSONCreator
    public ShareTextEntity() {
        this(null, null, null, 7, null);
    }

    @JSONCreator
    public ShareTextEntity(String str, String str2, String str3) {
        this.message = str;
        this.title = str2;
        this.bizCode = str3;
    }

    public /* synthetic */ ShareTextEntity(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @JvmName(name = "getMessage")
    public final String getMessage() {
        return this.message;
    }

    @JvmName(name = "setMessage")
    public final void setMessage(String str) {
        this.message = str;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = GriverEvents.EVENT_SET_TITLE)
    public final void setTitle(String str) {
        this.title = str;
    }

    @JvmName(name = "getBizCode")
    public final String getBizCode() {
        return this.bizCode;
    }

    @JvmName(name = "setBizCode")
    public final void setBizCode(String str) {
        this.bizCode = str;
    }
}
