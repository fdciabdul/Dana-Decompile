package id.dana.statement.marker;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.utils.MPPointF;
import id.dana.R;
import id.dana.richview.statement.model.PointModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u0013¢\u0006\u0004\b\u001c\u0010\u001dB\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001eJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0016\u0010\u000f\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0017"}, d2 = {"Lid/dana/statement/marker/PointMarker;", "Lcom/github/mikephil/charting/components/MarkerView;", "Lcom/github/mikephil/charting/utils/MPPointF;", "getOffset", "()Lcom/github/mikephil/charting/utils/MPPointF;", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "Lid/dana/richview/statement/model/PointModel;", "pointModel", "update", "(Lid/dana/richview/statement/model/PointModel;)V", "", "PlaceComponentResult", "I", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "", "getAuthRequestContext", "Z", "", "Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "resId", "isOverlap", "<init>", "(Landroid/content/Context;IZ)V", "(Landroid/content/Context;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PointMarker extends MarkerView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String getAuthRequestContext;
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PointMarker(Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = "";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PointMarker(Context context, int i, boolean z) {
        this(context, i);
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = z;
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "");
        if (((ImageView) _$_findCachedViewById(R.id.iv_marker_label_icon)) == null || this.BuiltInFictitiousFunctionClassFactory <= 0) {
            return;
        }
        ((ImageView) _$_findCachedViewById(R.id.iv_marker_label_icon)).setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), this.BuiltInFictitiousFunctionClassFactory));
        ((ImageView) _$_findCachedViewById(R.id.iv_marker_label_icon)).setBackgroundResource(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // com.github.mikephil.charting.components.MarkerView
    public final MPPointF getOffset() {
        double d = this.PlaceComponentResult ? -0.2d : 1.2d;
        float f = (-getWidth()) / 2;
        double d2 = -getHeight();
        Double.isNaN(d2);
        return new MPPointF(f, (float) (d2 * d));
    }

    public final void update(PointModel pointModel) {
        Intrinsics.checkNotNullParameter(pointModel, "");
        this.BuiltInFictitiousFunctionClassFactory = pointModel.MyBillsEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pointModel.PlaceComponentResult;
        this.getAuthRequestContext = pointModel.BuiltInFictitiousFunctionClassFactory;
        if (((TextView) _$_findCachedViewById(R.id.tv_marker_label)) != null) {
            ((TextView) _$_findCachedViewById(R.id.tv_marker_label)).setText(this.getAuthRequestContext);
        }
        if (this.PlaceComponentResult) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.getAuthRequestContext((ConstraintLayout) _$_findCachedViewById(R.id.setValuePrefixBytes_res_0x7f0a0361));
            constraintSet.MyBillsEntityDataFactory(((LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d0f_splitmerchantconfigentity_getmerchantdetailpromoconfigentity_1)).getId(), 3);
            constraintSet.KClassImpl$Data$declaredNonStaticMembers$2((ConstraintLayout) _$_findCachedViewById(R.id.setValuePrefixBytes_res_0x7f0a0361));
            constraintSet.getAuthRequestContext((ConstraintLayout) _$_findCachedViewById(R.id.setValuePrefixBytes_res_0x7f0a0361));
            constraintSet.BuiltInFictitiousFunctionClassFactory(((LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d0f_splitmerchantconfigentity_getmerchantdetailpromoconfigentity_1)).getId(), 4, ((ImageView) _$_findCachedViewById(R.id.Base64$Encoder)).getId(), 4);
            constraintSet.KClassImpl$Data$declaredNonStaticMembers$2((ConstraintLayout) _$_findCachedViewById(R.id.setValuePrefixBytes_res_0x7f0a0361));
            return;
        }
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.getAuthRequestContext((ConstraintLayout) _$_findCachedViewById(R.id.setValuePrefixBytes_res_0x7f0a0361));
        constraintSet2.MyBillsEntityDataFactory(((LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d0f_splitmerchantconfigentity_getmerchantdetailpromoconfigentity_1)).getId(), 4);
        constraintSet2.KClassImpl$Data$declaredNonStaticMembers$2((ConstraintLayout) _$_findCachedViewById(R.id.setValuePrefixBytes_res_0x7f0a0361));
        constraintSet2.getAuthRequestContext((ConstraintLayout) _$_findCachedViewById(R.id.setValuePrefixBytes_res_0x7f0a0361));
        constraintSet2.BuiltInFictitiousFunctionClassFactory(((LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d0f_splitmerchantconfigentity_getmerchantdetailpromoconfigentity_1)).getId(), 3, ((ImageView) _$_findCachedViewById(R.id.Base64$Encoder)).getId(), 3);
        constraintSet2.KClassImpl$Data$declaredNonStaticMembers$2((ConstraintLayout) _$_findCachedViewById(R.id.setValuePrefixBytes_res_0x7f0a0361));
    }
}
