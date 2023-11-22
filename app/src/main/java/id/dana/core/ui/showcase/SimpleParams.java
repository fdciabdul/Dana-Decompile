package id.dana.core.ui.showcase;

import android.animation.TimeInterpolator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0017\u0010\u000b\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/core/ui/showcase/SimpleParams;", "Lid/dana/core/ui/showcase/Params;", "", "lookAheadTest", "Ljava/lang/String;", "getAuthRequestContext", "getErrorConfigVersion", "KClassImpl$Data$declaredNonStaticMembers$2", "", "moveToNextValue", "Z", "PlaceComponentResult", "()Z", "", "p0", "Landroid/animation/TimeInterpolator;", "p1", "", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "", "p9", "<init>", "(JLandroid/animation/TimeInterpolator;IZLjava/lang/String;Ljava/lang/String;ZIIF)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SimpleParams extends Params {

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    final String getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    public SimpleParams(long j, TimeInterpolator timeInterpolator, int i, boolean z, String str, String str2, boolean z2, int i2, int i3, float f) {
        super(j, timeInterpolator, i, z, i2, i3, f);
        this.getAuthRequestContext = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.PlaceComponentResult = z2;
    }
}
