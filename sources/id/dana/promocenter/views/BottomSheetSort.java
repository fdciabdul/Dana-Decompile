package id.dana.promocenter.views;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import id.dana.R;
import id.dana.bottomsheet.BaseBottomSheetRadioButton;
import id.dana.common.model.OptionModel;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\f\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u0012\u0010\u0005\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/promocenter/views/BottomSheetSort;", "Lid/dana/bottomsheet/BaseBottomSheetRadioButton;", "Landroid/view/View;", "p0", "", "PlaceComponentResult", "(Landroid/view/View;)V", "onShow", "()V", "", "getErrorConfigVersion", "I", "Landroidx/fragment/app/FragmentManager;", "", "Lid/dana/common/model/OptionModel;", "p1", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetSort extends BaseBottomSheetRadioButton {

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    int PlaceComponentResult;
    public Map<Integer, View> lookAheadTest;

    @Override // id.dana.bottomsheet.BaseBottomSheetRadioButton, id.dana.base.BaseBottomSheetFullDialogFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.lookAheadTest.clear();
    }

    @Override // id.dana.bottomsheet.BaseBottomSheetRadioButton, id.dana.base.BaseBottomSheetFullDialogFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.lookAheadTest;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetSort(FragmentManager fragmentManager, List<OptionModel> list) {
        super(fragmentManager, list);
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.lookAheadTest = new LinkedHashMap();
        this.PlaceComponentResult = -1;
    }

    @Override // id.dana.bottomsheet.BaseBottomSheetRadioButton, id.dana.base.BaseBottomSheetFullDialogFragment, id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        ((TextView) getAuthRequestContext(R.id.getLogSourceName)).setText(getString(R.string.sort_label));
        ((DanaButtonPrimaryView) getAuthRequestContext(R.id.c)).setActiveButton(getString(R.string.sort_button_title), null);
        if (this.PlaceComponentResult < 0) {
            ((DanaButtonPrimaryView) getAuthRequestContext(R.id.c)).setDisabled(getString(R.string.sort_button_title));
            return;
        }
        RadioGroup radioGroup = (RadioGroup) getAuthRequestContext(R.id.res_0x7f0a1071_descriptorvisibilities_1);
        int childCount = radioGroup.getChildCount();
        int i = this.PlaceComponentResult;
        if (!(childCount > i)) {
            radioGroup = null;
        }
        if (radioGroup != null) {
            View childAt = radioGroup.getChildAt(i);
            if (!(childAt instanceof RadioButton)) {
                childAt = null;
            }
            if (childAt != null) {
                ((RadioButton) childAt).setChecked(true);
            }
        }
        ((DanaButtonPrimaryView) getAuthRequestContext(R.id.c)).setActiveButton(getString(R.string.sort_button_title), null);
    }

    @Override // id.dana.bottomsheet.BaseBottomSheetRadioButton, id.dana.base.BaseBottomSheetFullDialogFragment, id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.lookAheadTest.clear();
    }

    @Override // id.dana.bottomsheet.BaseBottomSheetRadioButton
    public final void PlaceComponentResult(View p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ((DanaButtonPrimaryView) getAuthRequestContext(R.id.c)).setActiveButton(getString(R.string.sort_button_title), null);
    }
}
