package id.dana.danapoly.domain.config.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/danapoly/domain/config/model/Board;", "", "", "cardType", "Ljava/lang/String;", "getCardType", "()Ljava/lang/String;", "iconUrl", "getIconUrl", "", "position", "I", "getPosition", "()I", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Board {
    private final String cardType;
    private final String iconUrl;
    private final int position;

    public Board(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.position = i;
        this.cardType = str;
        this.iconUrl = str2;
    }

    @JvmName(name = "getPosition")
    public final int getPosition() {
        return this.position;
    }

    @JvmName(name = "getCardType")
    public final String getCardType() {
        return this.cardType;
    }

    @JvmName(name = "getIconUrl")
    public final String getIconUrl() {
        return this.iconUrl;
    }
}
