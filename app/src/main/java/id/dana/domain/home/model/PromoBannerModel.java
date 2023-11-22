package id.dana.domain.home.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001B\u0013\b\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\t\n"}, d2 = {"Lid/dana/domain/home/model/PromoBannerModel;", "", "", "contentType", "Ljava/lang/String;", "getContentType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Lid/dana/domain/home/model/PromoBannerAnnouncementModel;", "Lid/dana/domain/home/model/PromoBannerContentModel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class PromoBannerModel {
    private final String contentType;

    public /* synthetic */ PromoBannerModel(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private PromoBannerModel(String str) {
        this.contentType = str;
    }

    @JvmName(name = "getContentType")
    public String getContentType() {
        return this.contentType;
    }
}
