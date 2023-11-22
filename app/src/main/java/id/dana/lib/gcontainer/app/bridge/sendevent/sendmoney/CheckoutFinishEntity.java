package id.dana.lib.gcontainer.app.bridge.sendevent.sendmoney;

import com.alibaba.fastjson.annotation.JSONCreator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/sendevent/sendmoney/CheckoutFinishEntity;", "", "", "isApiSuccess", "Z", "()Z", "setApiSuccess", "(Z)V", "", "processingStatus", "Ljava/lang/String;", "getProcessingStatus", "()Ljava/lang/String;", "setProcessingStatus", "(Ljava/lang/String;)V", "transType", "getTransType", "setTransType", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class CheckoutFinishEntity {
    private boolean isApiSuccess;
    private String processingStatus;
    private String transType;

    @JSONCreator
    public CheckoutFinishEntity() {
        this(false, null, null, 7, null);
    }

    @JSONCreator
    public CheckoutFinishEntity(boolean z, String str, String str2) {
        this.isApiSuccess = z;
        this.processingStatus = str;
        this.transType = str2;
    }

    public /* synthetic */ CheckoutFinishEntity(boolean z, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    @JvmName(name = "isApiSuccess")
    /* renamed from: isApiSuccess  reason: from getter */
    public final boolean getIsApiSuccess() {
        return this.isApiSuccess;
    }

    @JvmName(name = "setApiSuccess")
    public final void setApiSuccess(boolean z) {
        this.isApiSuccess = z;
    }

    @JvmName(name = "getProcessingStatus")
    public final String getProcessingStatus() {
        return this.processingStatus;
    }

    @JvmName(name = "setProcessingStatus")
    public final void setProcessingStatus(String str) {
        this.processingStatus = str;
    }

    @JvmName(name = "getTransType")
    public final String getTransType() {
        return this.transType;
    }

    @JvmName(name = "setTransType")
    public final void setTransType(String str) {
        this.transType = str;
    }
}
