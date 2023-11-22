package id.dana.lib.gcontainer.app.bridge.imagepicker;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alipay.mobile.zebra.data.ZebraData;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B3\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/imagepicker/ImagePickerEntity;", "", "", "dialogTitle", "Ljava/lang/String;", "getDialogTitle", "()Ljava/lang/String;", "setDialogTitle", "(Ljava/lang/String;)V", "", ZebraData.ATTR_HEIGHT, "I", "getHeight", "()I", "setHeight", "(I)V", "qualityLevel", "getQualityLevel", "setQualityLevel", ZebraData.ATTR_WIDTH, "getWidth", "setWidth", "<init>", "(Ljava/lang/String;III)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ImagePickerEntity {
    private String dialogTitle;
    private int height;
    private int qualityLevel;
    private int width;

    @JSONCreator
    public ImagePickerEntity() {
        this(null, 0, 0, 0, 15, null);
    }

    @JSONCreator
    public ImagePickerEntity(String str, int i, int i2, int i3) {
        this.dialogTitle = str;
        this.qualityLevel = i;
        this.height = i2;
        this.width = i3;
    }

    public /* synthetic */ ImagePickerEntity(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : str, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }

    @JvmName(name = "getDialogTitle")
    public final String getDialogTitle() {
        return this.dialogTitle;
    }

    @JvmName(name = "setDialogTitle")
    public final void setDialogTitle(String str) {
        this.dialogTitle = str;
    }

    @JvmName(name = "getQualityLevel")
    public final int getQualityLevel() {
        return this.qualityLevel;
    }

    @JvmName(name = "setQualityLevel")
    public final void setQualityLevel(int i) {
        this.qualityLevel = i;
    }

    @JvmName(name = "getHeight")
    public final int getHeight() {
        return this.height;
    }

    @JvmName(name = "setHeight")
    public final void setHeight(int i) {
        this.height = i;
    }

    @JvmName(name = "getWidth")
    public final int getWidth() {
        return this.width;
    }

    @JvmName(name = "setWidth")
    public final void setWidth(int i) {
        this.width = i;
    }
}
