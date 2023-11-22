package id.dana.wallet_v3.model;

import com.google.firebase.perf.util.Constants;
import id.dana.contract.payasset.SceneType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001BW\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b/\u00100R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\n8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\f\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010R\"\u0010)\u001a\u00020(8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010."}, d2 = {"Lid/dana/wallet_v3/model/WalletSectionModel;", "", "", "Lid/dana/wallet_v3/model/WalletV3CardModel;", SceneType.ASSETS, "Ljava/util/List;", "getAssets", "()Ljava/util/List;", "setAssets", "(Ljava/util/List;)V", "", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "", "intervalTime", "J", "getIntervalTime", "()J", "setIntervalTime", "(J)V", "", Constants.ENABLE_DISABLE, "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "Lid/dana/wallet_v3/model/SectionStatus;", "status", "Lid/dana/wallet_v3/model/SectionStatus;", "getStatus", "()Lid/dana/wallet_v3/model/SectionStatus;", "setStatus", "(Lid/dana/wallet_v3/model/SectionStatus;)V", "totalAssets", "getTotalAssets", "setTotalAssets", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "<init>", "(Ljava/util/List;IJLjava/lang/Boolean;Lid/dana/wallet_v3/model/SectionStatus;ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WalletSectionModel {
    private List<? extends WalletV3CardModel> assets;
    private int index;
    private long intervalTime;
    private Boolean isEnabled;
    private SectionStatus status;
    private int totalAssets;
    private String type;

    public WalletSectionModel() {
        this(null, 0, 0L, null, null, 0, null, 127, null);
    }

    public WalletSectionModel(List<? extends WalletV3CardModel> list, int i, long j, Boolean bool, SectionStatus sectionStatus, int i2, String str) {
        Intrinsics.checkNotNullParameter(sectionStatus, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.assets = list;
        this.index = i;
        this.intervalTime = j;
        this.isEnabled = bool;
        this.status = sectionStatus;
        this.totalAssets = i2;
        this.type = str;
    }

    @JvmName(name = "getAssets")
    public final List<WalletV3CardModel> getAssets() {
        return this.assets;
    }

    @JvmName(name = "setAssets")
    public final void setAssets(List<? extends WalletV3CardModel> list) {
        this.assets = list;
    }

    @JvmName(name = "getIndex")
    public final int getIndex() {
        return this.index;
    }

    @JvmName(name = "setIndex")
    public final void setIndex(int i) {
        this.index = i;
    }

    @JvmName(name = "getIntervalTime")
    public final long getIntervalTime() {
        return this.intervalTime;
    }

    @JvmName(name = "setIntervalTime")
    public final void setIntervalTime(long j) {
        this.intervalTime = j;
    }

    @JvmName(name = Constants.ENABLE_DISABLE)
    /* renamed from: isEnabled  reason: from getter */
    public final Boolean getIsEnabled() {
        return this.isEnabled;
    }

    @JvmName(name = "setEnabled")
    public final void setEnabled(Boolean bool) {
        this.isEnabled = bool;
    }

    public /* synthetic */ WalletSectionModel(List list, int i, long j, Boolean bool, SectionStatus sectionStatus, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : list, (i3 & 2) != 0 ? -1 : i, (i3 & 4) != 0 ? 0L : j, (i3 & 8) == 0 ? bool : null, (i3 & 16) != 0 ? SectionStatus.INIT : sectionStatus, (i3 & 32) != 0 ? 0 : i2, (i3 & 64) != 0 ? "" : str);
    }

    @JvmName(name = "getStatus")
    public final SectionStatus getStatus() {
        return this.status;
    }

    @JvmName(name = "setStatus")
    public final void setStatus(SectionStatus sectionStatus) {
        Intrinsics.checkNotNullParameter(sectionStatus, "");
        this.status = sectionStatus;
    }

    @JvmName(name = "getTotalAssets")
    public final int getTotalAssets() {
        return this.totalAssets;
    }

    @JvmName(name = "setTotalAssets")
    public final void setTotalAssets(int i) {
        this.totalAssets = i;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "setType")
    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.type = str;
    }
}
