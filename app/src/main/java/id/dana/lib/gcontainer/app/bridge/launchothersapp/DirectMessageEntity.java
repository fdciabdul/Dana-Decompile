package id.dana.lib.gcontainer.app.bridge.launchothersapp;

import com.alibaba.fastjson.annotation.JSONCreator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B-\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/launchothersapp/DirectMessageEntity;", "", "", "application", "Ljava/lang/String;", "getApplication", "()Ljava/lang/String;", "setApplication", "(Ljava/lang/String;)V", "id", "getId", "setId", "text", "getText", "setText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class DirectMessageEntity {
    private String application;
    private String id;
    private String text;

    @JSONCreator
    public DirectMessageEntity() {
        this(null, null, null, 7, null);
    }

    @JSONCreator
    public DirectMessageEntity(String str, String str2, String str3) {
        this.application = str;
        this.id = str2;
        this.text = str3;
    }

    public /* synthetic */ DirectMessageEntity(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @JvmName(name = "getApplication")
    public final String getApplication() {
        return this.application;
    }

    @JvmName(name = "setApplication")
    public final void setApplication(String str) {
        this.application = str;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "setId")
    public final void setId(String str) {
        this.id = str;
    }

    @JvmName(name = "getText")
    public final String getText() {
        return this.text;
    }

    @JvmName(name = "setText")
    public final void setText(String str) {
        this.text = str;
    }
}
