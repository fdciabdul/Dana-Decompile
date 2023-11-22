package id.dana.component.cellcomponent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import com.alibaba.griver.core.GriverParams;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.component.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0011\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\rJ\u000f\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010 R\u0016\u0010\u0004\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010\u001c\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0004\u0010 "}, d2 = {"Lid/dana/component/cellcomponent/DanaCellCustomView;", "Lid/dana/component/cellcomponent/BaseDanaCell;", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "getLayout", "()I", "", "descriptionText", "descriptionTextColor", "", "setDescriptionText", "(Ljava/lang/String;Ljava/lang/Integer;)V", "iconRes", GriverParams.ShareParams.IMAGE_URL, "imagePlaceHolder", "setIcon", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "labelText", "setLabelText", "(Ljava/lang/String;)V", "valueText", "valueTextColor", "setValueText", "setup", "()V", "Lde/hdodenhof/circleimageview/CircleImageView;", "MyBillsEntityDataFactory", "Lde/hdodenhof/circleimageview/CircleImageView;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "PlaceComponentResult", "getAuthRequestContext", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class DanaCellCustomView extends BaseDanaCell {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private AppCompatTextView PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private AppCompatTextView MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private CircleImageView BuiltInFictitiousFunctionClassFactory;
    private HashMap PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;

    public DanaCellCustomView(Context context) {
        this(context, null, 0, 6, null);
    }

    public DanaCellCustomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.PlaceComponentResult;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i) {
        if (this.PlaceComponentResult == null) {
            this.PlaceComponentResult = new HashMap();
        }
        View view = (View) this.PlaceComponentResult.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.PlaceComponentResult.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public /* synthetic */ DanaCellCustomView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaCellCustomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.component.BaseRichView
    public final int getLayout() {
        return R.layout.view_dana_cell_custom_layout;
    }

    public static /* synthetic */ void setIcon$default(DanaCellCustomView danaCellCustomView, Integer num, String str, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        danaCellCustomView.setIcon(num, str, num2);
    }

    public final void setIcon(Integer iconRes, String imageUrl, Integer imagePlaceHolder) {
        CircleImageView circleImageView = this.BuiltInFictitiousFunctionClassFactory;
        if (circleImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        circleImageView.setVisibility(0);
        Drawable drawable = null;
        Drawable BuiltInFictitiousFunctionClassFactory = (iconRes == null || iconRes.intValue() == 0) ? null : ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), iconRes.intValue());
        if (BuiltInFictitiousFunctionClassFactory != null) {
            circleImageView.setImageDrawable(BuiltInFictitiousFunctionClassFactory);
            return;
        }
        String str = imageUrl;
        if (str == null || str.length() == 0) {
            return;
        }
        CircleImageView circleImageView2 = circleImageView;
        if (imagePlaceHolder != null && imagePlaceHolder.intValue() != 0) {
            drawable = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), imagePlaceHolder.intValue());
        }
        Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext(imageUrl).KClassImpl$Data$declaredNonStaticMembers$2(drawable).MyBillsEntityDataFactory((ImageView) circleImageView2);
    }

    public final void setLabelText(String labelText) {
        Intrinsics.checkNotNullParameter(labelText, "");
        AppCompatTextView appCompatTextView = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (appCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        appCompatTextView.setVisibility(0);
        appCompatTextView.setText(labelText);
    }

    public static /* synthetic */ void setDescriptionText$default(DanaCellCustomView danaCellCustomView, String str, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        danaCellCustomView.setDescriptionText(str, num);
    }

    public final void setDescriptionText(String descriptionText, Integer descriptionTextColor) {
        Intrinsics.checkNotNullParameter(descriptionText, "");
        AppCompatTextView appCompatTextView = this.PlaceComponentResult;
        if (appCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        appCompatTextView.setVisibility(0);
        appCompatTextView.setText(descriptionText);
        Integer KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(descriptionTextColor);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            appCompatTextView.setTextColor(KClassImpl$Data$declaredNonStaticMembers$2.intValue());
        }
    }

    public static /* synthetic */ void setValueText$default(DanaCellCustomView danaCellCustomView, String str, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        danaCellCustomView.setValueText(str, num);
    }

    public final void setValueText(String valueText, Integer valueTextColor) {
        Intrinsics.checkNotNullParameter(valueText, "");
        AppCompatTextView appCompatTextView = this.MyBillsEntityDataFactory;
        if (appCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        appCompatTextView.setVisibility(0);
        appCompatTextView.setText(valueText);
        Integer KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(valueTextColor);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            appCompatTextView.setTextColor(KClassImpl$Data$declaredNonStaticMembers$2.intValue());
        }
    }

    private final Integer KClassImpl$Data$declaredNonStaticMembers$2(Integer p0) {
        if (p0 == null || p0.intValue() == 0) {
            return null;
        }
        return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), p0.intValue()));
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
        View findViewById = findViewById(R.id.getSupportButtonTintMode);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        this.BuiltInFictitiousFunctionClassFactory = (CircleImageView) findViewById;
        View findViewById2 = findViewById(R.id.J);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (AppCompatTextView) findViewById2;
        View findViewById3 = findViewById(R.id.M);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "");
        this.PlaceComponentResult = (AppCompatTextView) findViewById3;
        View findViewById4 = findViewById(R.id.SummaryVoucherView$$ExternalSyntheticLambda2);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "");
        this.MyBillsEntityDataFactory = (AppCompatTextView) findViewById4;
    }
}
