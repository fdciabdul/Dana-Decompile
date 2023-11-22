package id.dana.bottomsheet;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import id.dana.R;
import id.dana.base.BaseBottomSheetFullDialogFragment;
import id.dana.common.model.OptionModel;
import id.dana.common.view.RadioOptionsView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0015\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/bottomsheet/BaseBottomSheetRadioButton;", "Lid/dana/base/BaseBottomSheetFullDialogFragment;", "", "getLayout", "()I", "Landroid/view/View;", "p0", "", "PlaceComponentResult", "(Landroid/view/View;)V", "onShow", "()V", "Lkotlin/Function1;", "scheduleImpl", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/common/model/OptionModel;", "getErrorConfigVersion", "Ljava/util/List;", "MyBillsEntityDataFactory", "Landroidx/fragment/app/FragmentManager;", "moveToNextValue", "Landroidx/fragment/app/FragmentManager;", "getAuthRequestContext", "p1", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class BaseBottomSheetRadioButton extends BaseBottomSheetFullDialogFragment {
    public Map<Integer, View> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final List<OptionModel> MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final FragmentManager getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public Function1<? super Integer, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseBottomSheetFullDialogFragment
    public void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
    }

    public void PlaceComponentResult(View p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.base.BaseBottomSheetFullDialogFragment
    public View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
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

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public int getLayout() {
        return R.layout.bottomsheet_radio_button;
    }

    @Override // id.dana.base.BaseBottomSheetFullDialogFragment, id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public BaseBottomSheetRadioButton(FragmentManager fragmentManager, List<OptionModel> list) {
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new LinkedHashMap();
        this.getAuthRequestContext = fragmentManager;
        this.MyBillsEntityDataFactory = list;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Function1<Integer, Unit>() { // from class: id.dana.bottomsheet.BaseBottomSheetRadioButton$onSubmitClicked$1
            public final void invoke(int i) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        };
    }

    @Override // id.dana.base.BaseBottomSheetFullDialogFragment, id.dana.base.BaseBottomSheetDialogFragment
    public void onShow() {
        super.onShow();
        ((RadioOptionsView) getAuthRequestContext(R.id.res_0x7f0a10d3_access_setfieldstateactive)).setItems(this.MyBillsEntityDataFactory, new BaseBottomSheetRadioButton$onShow$1(this));
        ((DanaButtonPrimaryView) getAuthRequestContext(R.id.c)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.bottomsheet.BaseBottomSheetRadioButton$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseBottomSheetRadioButton.KClassImpl$Data$declaredNonStaticMembers$2(BaseBottomSheetRadioButton.this);
            }
        });
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BaseBottomSheetRadioButton baseBottomSheetRadioButton) {
        Intrinsics.checkNotNullParameter(baseBottomSheetRadioButton, "");
        baseBottomSheetRadioButton.KClassImpl$Data$declaredNonStaticMembers$2.invoke(Integer.valueOf(((RadioOptionsView) baseBottomSheetRadioButton.getAuthRequestContext(R.id.res_0x7f0a10d3_access_setfieldstateactive)).getSelectedOption()));
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public /* synthetic */ View getPlaceComponentResult() {
        FrameLayout frameLayout = (FrameLayout) getAuthRequestContext(R.id.fl_bottom_sheet_radio_button);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }
}
