package id.dana.pushverify.view.verificationlist.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.R;
import id.dana.extension.view.ViewExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u001c¢\u0006\u0004\b#\u0010$J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0013\u001a\u00020\u0016X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010!R\u0014\u0010\u001d\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0010"}, d2 = {"Lid/dana/pushverify/view/verificationlist/adapter/VerificationItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", "p0", "Landroidx/recyclerview/widget/RecyclerView;", "p1", "Landroidx/recyclerview/widget/RecyclerView$State;", "p2", "", "onDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "BuiltInFictitiousFunctionClassFactory", "I", "", "KClassImpl$Data$declaredNonStaticMembers$2", "[F", "getAuthRequestContext", "Landroid/graphics/Rect;", "PlaceComponentResult", "Landroid/graphics/Rect;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Landroid/content/Context;", "Landroid/graphics/Paint;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/graphics/Paint;", "lookAheadTest", "", "moveToNextValue", LogConstants.RESULT_FALSE, "getErrorConfigVersion", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "scheduleImpl", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationItemDecoration extends RecyclerView.ItemDecoration {
    private final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final float[] getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final int KClassImpl$Data$declaredNonStaticMembers$2;
    private final Paint NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Rect MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Context PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private RectF scheduleImpl;
    private final Paint lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final float getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final float[] moveToNextValue;

    public VerificationItemDecoration(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
        this.getErrorConfigVersion = 12.0f;
        int BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.f27072131100488);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        int BuiltInFictitiousFunctionClassFactory2 = ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.MyBillsEntityDataFactory_res_0x7f060157);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory2;
        this.MyBillsEntityDataFactory = new Rect();
        this.scheduleImpl = new RectF();
        Paint paint = new Paint(1);
        paint.setColor(BuiltInFictitiousFunctionClassFactory);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(BuiltInFictitiousFunctionClassFactory2);
        this.lookAheadTest = paint2;
        this.moveToNextValue = new float[]{12.0f, 12.0f, 12.0f, 12.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        this.getAuthRequestContext = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 12.0f, 12.0f, 12.0f, 12.0f};
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas p0, RecyclerView p1, RecyclerView.State p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        p0.save();
        Path path = new Path();
        Path path2 = new Path();
        int childCount = p1.getChildCount();
        for (int i = 0; i < childCount; i++) {
            p1.getDecoratedBoundsWithMargins(p1.getChildAt(i), this.MyBillsEntityDataFactory);
            this.scheduleImpl = new RectF(this.MyBillsEntityDataFactory);
            RectF rectF = new RectF(this.scheduleImpl);
            rectF.top = rectF.bottom;
            rectF.bottom += ViewExtKt.PlaceComponentResult(0.5f);
            if (i == 0 && p1.getChildCount() == 1) {
                RectF rectF2 = this.scheduleImpl;
                float f = this.getErrorConfigVersion;
                path.addRoundRect(rectF2, f, f, Path.Direction.CW);
            } else if (i == 0) {
                path.addRoundRect(this.scheduleImpl, this.moveToNextValue, Path.Direction.CW);
                path2.addRect(rectF, Path.Direction.CW);
            } else if (i == p1.getChildCount() - 1) {
                path.addRoundRect(this.scheduleImpl, this.getAuthRequestContext, Path.Direction.CW);
            } else {
                path.addRect(this.scheduleImpl, Path.Direction.CW);
                path2.addRect(rectF, Path.Direction.CW);
            }
        }
        p0.drawPath(path, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.drawPath(path2, this.lookAheadTest);
        p0.restore();
    }
}
