package id.dana.showcase;

import android.animation.TimeInterpolator;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u000e\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b&\u0010'R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0017\u0010\u0011\u001a\u00020\u000e8\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/showcase/TwoButtonWithImageShowcaseParams;", "Lid/dana/showcase/Params;", "", "getErrorConfigVersion", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "moveToNextValue", "MyBillsEntityDataFactory", "Landroid/view/View$OnClickListener;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/view/View$OnClickListener;", "BuiltInFictitiousFunctionClassFactory", "lookAheadTest", "getAuthRequestContext", "", "initRecordTimeStamp", "Z", "PlaceComponentResult", "()Z", "DatabaseTableConfigUtil", "scheduleImpl", "", "p0", "Landroid/animation/TimeInterpolator;", "p1", "", "p2", "p3", "p4", "p5", "", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "<init>", "(JLandroid/animation/TimeInterpolator;IZIIFLjava/lang/String;Landroid/view/View$OnClickListener;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TwoButtonWithImageShowcaseParams extends Params {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    final String scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    final View.OnClickListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final boolean PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    final String getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    final String MyBillsEntityDataFactory;

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    public TwoButtonWithImageShowcaseParams(long j, TimeInterpolator timeInterpolator, int i, boolean z, int i2, int i3, float f, String str, View.OnClickListener onClickListener, String str2, boolean z2, String str3, String str4) {
        super(j, timeInterpolator, i, z, i2, i3, f);
        this.scheduleImpl = str;
        this.BuiltInFictitiousFunctionClassFactory = onClickListener;
        this.getAuthRequestContext = str2;
        this.PlaceComponentResult = z2;
        this.MyBillsEntityDataFactory = str3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str4;
    }
}
