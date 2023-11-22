package id.dana.data.banner.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0013\u0010\u0014R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e"}, d2 = {"Lid/dana/data/banner/model/BannerListEntity;", "", "", "Lid/dana/data/banner/model/BannerEntity;", "contents", "Ljava/util/List;", "getContents", "()Ljava/util/List;", "setContents", "(Ljava/util/List;)V", "", "spaceCode", "Ljava/lang/String;", "getSpaceCode", "()Ljava/lang/String;", "spaceName", "getSpaceName", "spaceType", "getSpaceType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BannerListEntity {
    private List<BannerEntity> contents;
    private final String spaceCode;
    private final String spaceName;
    private final String spaceType;

    public BannerListEntity() {
        this(null, null, null, null, 15, null);
    }

    public BannerListEntity(String str, String str2, String str3, List<BannerEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.spaceCode = str;
        this.spaceName = str2;
        this.spaceType = str3;
        this.contents = list;
    }

    @JvmName(name = "getSpaceCode")
    public final String getSpaceCode() {
        return this.spaceCode;
    }

    @JvmName(name = "getSpaceName")
    public final String getSpaceName() {
        return this.spaceName;
    }

    @JvmName(name = "getSpaceType")
    public final String getSpaceType() {
        return this.spaceType;
    }

    public /* synthetic */ BannerListEntity(String str, String str2, String str3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getContents")
    public final List<BannerEntity> getContents() {
        return this.contents;
    }

    @JvmName(name = "setContents")
    public final void setContents(List<BannerEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.contents = list;
    }
}
