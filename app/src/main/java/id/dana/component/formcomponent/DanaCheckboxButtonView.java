package id.dana.component.formcomponent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.res.ResourcesCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.component.R;
import id.dana.component.utils.SizeUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0007\u0010\u000bB#\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0007\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/component/formcomponent/DanaCheckboxButtonView;", "Landroidx/appcompat/widget/AppCompatCheckBox;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class DanaCheckboxButtonView extends AppCompatCheckBox {
    private HashMap PlaceComponentResult;

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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaCheckboxButtonView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaCheckboxButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaCheckboxButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        BuiltInFictitiousFunctionClassFactory();
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        setTypeface(ResourcesCompat.PlaceComponentResult(getContext(), R.font.MyBillsEntityDataFactory));
        setTextColor(getResources().getColor(R.color.KClassImpl$Data$declaredNonStaticMembers$2));
        setButtonDrawable(R.drawable.selector_button_check);
        setPadding(SizeUtil.PlaceComponentResult(8), 0, 0, SizeUtil.PlaceComponentResult(0));
    }
}
