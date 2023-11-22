package id.dana.mybills.ui.model;

import com.alibaba.ariver.kernel.RVParams;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b"}, d2 = {"Lid/dana/mybills/ui/model/MyBillsOnboardingContent;", "", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "", "imageRes", "I", "getImageRes", "()I", "setImageRes", "(I)V", RVParams.LONG_SUB_TITLE, "getSubTitle", "setSubTitle", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class MyBillsOnboardingContent {
    private String description;
    private int imageRes;
    private String subTitle;

    public MyBillsOnboardingContent() {
        this(0, null, null, 7, null);
    }

    public MyBillsOnboardingContent(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.imageRes = i;
        this.subTitle = str;
        this.description = str2;
    }

    public /* synthetic */ MyBillsOnboardingContent(int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2);
    }

    @JvmName(name = "getImageRes")
    public final int getImageRes() {
        return this.imageRes;
    }

    @JvmName(name = "setImageRes")
    public final void setImageRes(int i) {
        this.imageRes = i;
    }

    @JvmName(name = "getSubTitle")
    public final String getSubTitle() {
        return this.subTitle;
    }

    @JvmName(name = "setSubTitle")
    public final void setSubTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.subTitle = str;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "setDescription")
    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.description = str;
    }
}
