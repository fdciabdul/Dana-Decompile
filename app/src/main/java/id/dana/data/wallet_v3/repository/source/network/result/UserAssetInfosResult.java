package id.dana.data.wallet_v3.repository.source.network.result;

import id.dana.animation.HomeTabActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetInfosResult;", "", "", "assetType", "Ljava/lang/String;", "getAssetType", "()Ljava/lang/String;", "Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetResult;", "info", "Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetResult;", "getInfo", "()Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetResult;", HomeTabActivity.WALLET_SECTION, "getSection", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/data/wallet_v3/repository/source/network/result/UserAssetResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserAssetInfosResult {
    private final String assetType;
    private final UserAssetResult info;
    private final String section;

    public UserAssetInfosResult() {
        this(null, null, null, 7, null);
    }

    public UserAssetInfosResult(String str, String str2, UserAssetResult userAssetResult) {
        this.section = str;
        this.assetType = str2;
        this.info = userAssetResult;
    }

    public /* synthetic */ UserAssetInfosResult(String str, String str2, UserAssetResult userAssetResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : userAssetResult);
    }

    @JvmName(name = "getSection")
    public final String getSection() {
        return this.section;
    }

    @JvmName(name = "getAssetType")
    public final String getAssetType() {
        return this.assetType;
    }

    @JvmName(name = "getInfo")
    public final UserAssetResult getInfo() {
        return this.info;
    }
}
