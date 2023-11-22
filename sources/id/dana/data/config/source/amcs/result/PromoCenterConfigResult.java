package id.dana.data.config.source.amcs.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006"}, d2 = {"Lid/dana/data/config/source/amcs/result/PromoCenterConfigResult;", "", "", "toString", "()Ljava/lang/String;", "buttonIconUrl", "Ljava/lang/String;", "buttonTitle", "description", "", "isEnable", "Z", "isRedirectNative", "redirectUrl", "title", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PromoCenterConfigResult {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    @SerializedName("buttonIconUrl")
    @JSONField(name = "buttonIconUrl")
    public String buttonIconUrl;
    @SerializedName("buttonTitle")
    @JSONField(name = "buttonTitle")
    public String buttonTitle;
    @SerializedName("description")
    @JSONField(name = "description")
    public String description;
    @SerializedName("enable")
    @JSONField(name = "enable")
    public boolean isEnable;
    @SerializedName("redirect_native")
    @JSONField(name = "redirect_native")
    public boolean isRedirectNative;
    @SerializedName("redirect_url")
    @JSONField(name = "redirect_url")
    public String redirectUrl;
    @SerializedName("title")
    @JSONField(name = "title")
    public String title;

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[enable=");
        sb.append(this.isEnable);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", redirect_native=");
        sb.append(this.isRedirectNative);
        sb.append(", redirect_url=");
        sb.append(this.redirectUrl);
        sb.append(']');
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/config/source/amcs/result/PromoCenterConfigResult$Companion;", "", "Lid/dana/data/config/source/amcs/result/PromoCenterConfigResult;", "createDefaultConfig", "()Lid/dana/data/config/source/amcs/result/PromoCenterConfigResult;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PromoCenterConfigResult createDefaultConfig() {
            PromoCenterConfigResult promoCenterConfigResult = new PromoCenterConfigResult();
            promoCenterConfigResult.title = "What's New";
            promoCenterConfigResult.description = "The best news of the week";
            promoCenterConfigResult.isEnable = false;
            promoCenterConfigResult.buttonIconUrl = "";
            promoCenterConfigResult.buttonTitle = "";
            promoCenterConfigResult.isRedirectNative = true;
            promoCenterConfigResult.redirectUrl = "";
            return promoCenterConfigResult;
        }
    }
}
