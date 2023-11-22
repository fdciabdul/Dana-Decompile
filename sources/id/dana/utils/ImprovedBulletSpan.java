package id.dana.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"Jq\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0019\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010 "}, d2 = {"Lid/dana/utils/ImprovedBulletSpan;", "Landroid/text/style/LeadingMarginSpan;", "Landroid/graphics/Canvas;", "p0", "Landroid/graphics/Paint;", "p1", "", "p2", "p3", "p4", "p5", "p6", "", "p7", "p8", "p9", "", "p10", "Landroid/text/Layout;", "p11", "", "drawLeadingMargin", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;IIIIILjava/lang/CharSequence;IIZLandroid/text/Layout;)V", "getLeadingMargin", "(Z)I", "PlaceComponentResult", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "getAuthRequestContext", "Landroid/graphics/Path;", "Landroid/graphics/Path;", "<init>", "(III)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImprovedBulletSpan implements LeadingMarginSpan {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final int PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final int getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Path BuiltInFictitiousFunctionClassFactory;

    public ImprovedBulletSpan() {
        this(0, 0, 0, 7, null);
    }

    public ImprovedBulletSpan(int i, int i2, int i3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.getAuthRequestContext = i2;
        this.PlaceComponentResult = i3;
    }

    public /* synthetic */ ImprovedBulletSpan(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 4 : i, (i4 & 2) != 0 ? 2 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean p0) {
        return (this.KClassImpl$Data$declaredNonStaticMembers$2 * 2) + this.getAuthRequestContext;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas p0, Paint p1, int p2, int p3, int p4, int p5, int p6, CharSequence p7, int p8, int p9, boolean p10, Layout p11) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p7, "");
        if (((Spanned) p7).getSpanStart(this) == p8) {
            Paint.Style style = p1.getStyle();
            p1.setStyle(Paint.Style.FILL);
            float lineBaseline = p11 != null ? p11.getLineBaseline(p11.getLineForOffset(p8)) - (this.KClassImpl$Data$declaredNonStaticMembers$2 * 2.0f) : (p4 + p6) / 2.0f;
            float f = p2 + (p3 * this.KClassImpl$Data$declaredNonStaticMembers$2);
            if (p0.isHardwareAccelerated()) {
                if (this.BuiltInFictitiousFunctionClassFactory == null) {
                    Path path = new Path();
                    this.BuiltInFictitiousFunctionClassFactory = path;
                    Intrinsics.checkNotNull(path);
                    path.addCircle(0.0f, 0.0f, this.KClassImpl$Data$declaredNonStaticMembers$2, Path.Direction.CW);
                }
                p0.save();
                p0.translate(f, lineBaseline);
                Path path2 = this.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNull(path2);
                p0.drawPath(path2, p1);
                p0.restore();
            } else {
                p0.drawCircle(f, lineBaseline, this.KClassImpl$Data$declaredNonStaticMembers$2, p1);
            }
            p1.setStyle(style);
        }
    }
}
