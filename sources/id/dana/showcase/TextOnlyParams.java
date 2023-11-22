package id.dana.showcase;

import android.animation.TimeInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/showcase/TextOnlyParams;", "Lid/dana/showcase/Params;", "", "lookAheadTest", "Ljava/lang/String;", "PlaceComponentResult", "", "p0", "Landroid/animation/TimeInterpolator;", "p1", "", "p2", "", "p3", "p4", "p5", "p6", "", "p7", "<init>", "(JLandroid/animation/TimeInterpolator;IZLjava/lang/String;IIF)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TextOnlyParams extends Params {

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    final String PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextOnlyParams(long j, TimeInterpolator timeInterpolator, int i, boolean z, String str, int i2, int i3, float f) {
        super(j, timeInterpolator, i, z, i2, i3, f);
        Intrinsics.checkNotNullParameter(str, "");
        this.PlaceComponentResult = str;
    }
}
