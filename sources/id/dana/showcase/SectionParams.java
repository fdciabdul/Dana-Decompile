package id.dana.showcase;

import android.animation.TimeInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0007¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/showcase/SectionParams;", "Lid/dana/showcase/Params;", "", "lookAheadTest", "Z", "PlaceComponentResult", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "", "moveToNextValue", "I", "BuiltInFictitiousFunctionClassFactory", "Landroidx/recyclerview/widget/RecyclerView;", "getErrorConfigVersion", "Landroidx/recyclerview/widget/RecyclerView;", "MyBillsEntityDataFactory", "", "p0", "Landroid/animation/TimeInterpolator;", "p1", "p2", "p3", "p4", "p5", "", "p6", "p7", "p8", "p9", "<init>", "(JLandroid/animation/TimeInterpolator;IZIIFLandroidx/recyclerview/widget/RecyclerView;IZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SectionParams extends Params {

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    final RecyclerView MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    final int BuiltInFictitiousFunctionClassFactory;

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public SectionParams(long j, TimeInterpolator timeInterpolator, int i, boolean z, int i2, int i3, float f, RecyclerView recyclerView, int i4, boolean z2) {
        super(j, timeInterpolator, i, z, i2, i3, f);
        this.MyBillsEntityDataFactory = recyclerView;
        this.BuiltInFictitiousFunctionClassFactory = i4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z2;
    }
}
