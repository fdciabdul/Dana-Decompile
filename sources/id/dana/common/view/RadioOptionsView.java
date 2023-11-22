package id.dana.common.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.common.model.OptionModel;
import id.dana.util.ContentDescriptorUtil;
import id.dana.utils.OSUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J/\u0010\r\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/common/view/RadioOptionsView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "getSelectedOption", "", "Lid/dana/common/model/OptionModel;", SecurityConstants.KEY_OPTIONS, "Lkotlin/Function1;", "Landroid/view/View;", "", "onOptionClicked", "setItems", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "setup", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RadioOptionsView extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RadioOptionsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RadioOptionsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
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

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_radio_options;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadioOptionsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ RadioOptionsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getSelectedOption() {
        RadioGroup radioGroup = (RadioGroup) _$_findCachedViewById(R.id.res_0x7f0a1071_descriptorvisibilities_1);
        Intrinsics.checkNotNullExpressionValue(radioGroup, "");
        int i = -1;
        int i2 = 0;
        for (View view : ViewGroupKt.BuiltInFictitiousFunctionClassFactory(radioGroup)) {
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view2 = view;
            if ((view2 instanceof RadioButton) && ((RadioButton) view2).isChecked()) {
                i = i2;
            }
            i2++;
        }
        return i;
    }

    public final void setItems(List<OptionModel> r10, final Function1<? super View, Unit> onOptionClicked) {
        Intrinsics.checkNotNullParameter(r10, "");
        Intrinsics.checkNotNullParameter(onOptionClicked, "");
        RadioGroup radioGroup = (RadioGroup) _$_findCachedViewById(R.id.res_0x7f0a1071_descriptorvisibilities_1);
        if (radioGroup != null) {
            for (OptionModel optionModel : r10) {
                AppCompatRadioButton appCompatRadioButton = new AppCompatRadioButton(getContext());
                appCompatRadioButton.setText(optionModel.PlaceComponentResult);
                ContentDescriptorUtil contentDescriptorUtil = ContentDescriptorUtil.INSTANCE;
                String string = appCompatRadioButton.getContext().getString(R.string.cd_promo_center_sort_item_prefix);
                Intrinsics.checkNotNullExpressionValue(string, "");
                appCompatRadioButton.setContentDescription(ContentDescriptorUtil.KClassImpl$Data$declaredNonStaticMembers$2(string, optionModel.PlaceComponentResult));
                appCompatRadioButton.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23992131099996));
                if (OSUtil.scheduleImpl()) {
                    appCompatRadioButton.setSupportButtonTintList(new ColorStateList(new int[][]{new int[]{-16842912}, new int[]{16842912}}, new int[]{R.color.f24012131099998, Color.rgb(16, 142, 233)}));
                    appCompatRadioButton.invalidate();
                }
                appCompatRadioButton.setOnClickListener(new View.OnClickListener() { // from class: id.dana.common.view.RadioOptionsView$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RadioOptionsView.$r8$lambda$j8T97IaXfJoJdqvWhHfX3hIEHpw(Function1.this, view);
                    }
                });
                radioGroup.addView(appCompatRadioButton);
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$j8T97IaXfJoJdqvWhHfX3hIEHpw(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullExpressionValue(view, "");
        function1.invoke(view);
    }
}
