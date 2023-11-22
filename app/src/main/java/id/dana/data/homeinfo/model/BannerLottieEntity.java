package id.dana.data.homeinfo.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u0016R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\u0016"}, d2 = {"Lid/dana/data/homeinfo/model/BannerLottieEntity;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "en", "id", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/homeinfo/model/BannerLottieEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getEn", "setEn", "(Ljava/lang/String;)V", "getId", "setId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BannerLottieEntity implements Serializable {
    public String en;
    public String id;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BannerLottieEntity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.homeinfo.model.BannerLottieEntity.<init>():void");
    }

    public static /* synthetic */ BannerLottieEntity copy$default(BannerLottieEntity bannerLottieEntity, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bannerLottieEntity.en;
        }
        if ((i & 2) != 0) {
            str2 = bannerLottieEntity.id;
        }
        return bannerLottieEntity.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getEn() {
        return this.en;
    }

    /* renamed from: component2  reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final BannerLottieEntity copy(String en, String id2) {
        return new BannerLottieEntity(en, id2);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BannerLottieEntity) {
            BannerLottieEntity bannerLottieEntity = (BannerLottieEntity) other;
            return Intrinsics.areEqual(this.en, bannerLottieEntity.en) && Intrinsics.areEqual(this.id, bannerLottieEntity.id);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.en;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.id;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BannerLottieEntity(en=");
        sb.append(this.en);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(')');
        return sb.toString();
    }

    public BannerLottieEntity(String str, String str2) {
        this.en = str;
        this.id = str2;
    }

    public /* synthetic */ BannerLottieEntity(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    @JvmName(name = "getEn")
    public final String getEn() {
        return this.en;
    }

    @JvmName(name = "setEn")
    public final void setEn(String str) {
        this.en = str;
    }

    @JvmName(name = "getId")
    public final String getId() {
        return this.id;
    }

    @JvmName(name = "setId")
    public final void setId(String str) {
        this.id = str;
    }
}
