package androidx.window.embedding;

import android.graphics.Rect;
import android.os.Build;
import android.view.WindowMetrics;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB1\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0016\u001a\u00020\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Landroidx/window/embedding/SplitRule;", "Landroidx/window/embedding/EmbeddingRule;", "Landroid/view/WindowMetrics;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/view/WindowMetrics;)Z", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "scheduleImpl", "I", "getErrorConfigVersion", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda0", "KClassImpl$Data$declaredNonStaticMembers$2", "", "moveToNextValue", LogConstants.RESULT_FALSE, "MyBillsEntityDataFactory", "p1", "p2", "p3", "<init>", "(IIFI)V", "Api30Impl", "LayoutDir"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class SplitRule extends EmbeddingRule {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final int PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final float MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final int BuiltInFictitiousFunctionClassFactory;

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u001b\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000"}, d2 = {"Landroidx/window/embedding/SplitRule$LayoutDir;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    public @interface LayoutDir {
    }

    public SplitRule() {
        this(0, 0, 0.0f, 0, 15, null);
    }

    public /* synthetic */ SplitRule(int i, int i2, float f, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0.5f : f, (i4 & 8) != 0 ? 3 : i3);
    }

    private SplitRule(int i, int i2, float f, int i3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.PlaceComponentResult = i2;
        this.MyBillsEntityDataFactory = f;
        this.BuiltInFictitiousFunctionClassFactory = i3;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(WindowMetrics p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (Build.VERSION.SDK_INT <= 30) {
            return false;
        }
        Rect BuiltInFictitiousFunctionClassFactory = Api30Impl.INSTANCE.BuiltInFictitiousFunctionClassFactory(p0);
        return (this.KClassImpl$Data$declaredNonStaticMembers$2 == 0 || BuiltInFictitiousFunctionClassFactory.width() >= this.KClassImpl$Data$declaredNonStaticMembers$2) && (this.PlaceComponentResult == 0 || Math.min(BuiltInFictitiousFunctionClassFactory.width(), BuiltInFictitiousFunctionClassFactory.height()) >= this.PlaceComponentResult);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/window/embedding/SplitRule$Api30Impl;", "", "Landroid/view/WindowMetrics;", "p0", "Landroid/graphics/Rect;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/view/WindowMetrics;)Landroid/graphics/Rect;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = new Api30Impl();

        private Api30Impl() {
        }

        public final Rect BuiltInFictitiousFunctionClassFactory(WindowMetrics p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            Rect bounds = p0.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "");
            return bounds;
        }
    }

    public boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SplitRule) {
            SplitRule splitRule = (SplitRule) p0;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == splitRule.KClassImpl$Data$declaredNonStaticMembers$2 && this.PlaceComponentResult == splitRule.PlaceComponentResult) {
                return ((this.MyBillsEntityDataFactory > splitRule.MyBillsEntityDataFactory ? 1 : (this.MyBillsEntityDataFactory == splitRule.MyBillsEntityDataFactory ? 0 : -1)) == 0) && this.BuiltInFictitiousFunctionClassFactory == splitRule.BuiltInFictitiousFunctionClassFactory;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((((i * 31) + this.PlaceComponentResult) * 31) + Float.floatToIntBits(this.MyBillsEntityDataFactory)) * 31) + this.BuiltInFictitiousFunctionClassFactory;
    }
}
