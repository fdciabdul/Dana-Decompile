package id.dana.kyb.view.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.griver.api.constants.GriverEvents;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.component.BaseRichView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aB+\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u000e\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012"}, d2 = {"Lid/dana/kyb/view/richview/KybBenefitItemView;", "Lid/dana/component/BaseRichView;", "", "getLayout", "()I", "resId", "", "setDescription", "(I)V", "setIcon", GriverEvents.EVENT_SET_TITLE, "setup", "()V", "Lde/hdodenhof/circleimageview/CircleImageView;", "PlaceComponentResult", "Lde/hdodenhof/circleimageview/CircleImageView;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getAuthRequestContext", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybBenefitItemView extends BaseRichView {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private TextView PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private CircleImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;
    private TextView getAuthRequestContext;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KybBenefitItemView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KybBenefitItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_074055a5770ceee3ff60e06bca0881e0(CircleImageView circleImageView, int i) {
        if (circleImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(circleImageView, i);
        } else {
            circleImageView.setImageResource(i);
        }
    }

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

    @Override // id.dana.component.BaseRichView
    public final int getLayout() {
        return R.layout.item_kyb_benefit;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KybBenefitItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ KybBenefitItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KybBenefitItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void setIcon(int resId) {
        CircleImageView circleImageView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (circleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            circleImageView = null;
        }
        __fsTypeCheck_074055a5770ceee3ff60e06bca0881e0(circleImageView, resId);
    }

    public final void setTitle(int resId) {
        TextView textView = this.getAuthRequestContext;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView = null;
        }
        textView.setText(resId);
    }

    public final void setDescription(int resId) {
        TextView textView = this.PlaceComponentResult;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView = null;
        }
        textView.setText(resId);
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
        View findViewById = findViewById(R.id.iv_kyb_benefit);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (CircleImageView) findViewById;
        View findViewById2 = findViewById(R.id.tv_kyb_benefit_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "");
        this.getAuthRequestContext = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.tv_kyb_benefit_description);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "");
        this.PlaceComponentResult = (TextView) findViewById3;
    }
}
