package id.dana.animation.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0007\u001a\u0004\b\n\u0010\b"}, d2 = {"Lid/dana/home/model/EddConsultModel;", "", "Lid/dana/home/model/EddInfoModel;", "MyBillsEntityDataFactory", "Lid/dana/home/model/EddInfoModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "()Z", "PlaceComponentResult", "getAuthRequestContext", "p0", "p1", "p2", "<init>", "(ZLid/dana/home/model/EddInfoModel;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EddConsultModel {
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public final EddInfoModel MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;

    public EddConsultModel() {
        this(false, null, false, 7, null);
    }

    public EddConsultModel(boolean z, EddInfoModel eddInfoModel, boolean z2) {
        this.getAuthRequestContext = z;
        this.MyBillsEntityDataFactory = eddInfoModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z2;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ EddConsultModel(boolean r3, id.dana.animation.model.EddInfoModel r4, boolean r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r2 = this;
            r7 = r6 & 1
            r0 = 0
            if (r7 == 0) goto L6
            r3 = 0
        L6:
            r7 = r6 & 2
            if (r7 == 0) goto L11
            id.dana.home.model.EddInfoModel r4 = new id.dana.home.model.EddInfoModel
            r7 = 3
            r1 = 0
            r4.<init>(r1, r1, r7, r1)
        L11:
            r6 = r6 & 4
            if (r6 == 0) goto L16
            r5 = 0
        L16:
            r2.<init>(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.model.EddConsultModel.<init>(boolean, id.dana.home.model.EddInfoModel, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
