package id.dana.promocenter.views;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import id.dana.R;
import id.dana.base.BaseBottomSheetFullDialogFragment;
import id.dana.common.model.OptionModel;
import id.dana.common.view.CheckboxView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u001f\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/promocenter/views/BottomSheetFilter;", "Lid/dana/base/BaseBottomSheetFullDialogFragment;", "", "getLayout", "()I", "", "onShow", "()V", "Lkotlin/Function2;", "", "scheduleImpl", "Lkotlin/jvm/functions/Function2;", "getAuthRequestContext", "Lkotlin/Function0;", "getErrorConfigVersion", "Lkotlin/jvm/functions/Function0;", "MyBillsEntityDataFactory", "lookAheadTest", "BuiltInFictitiousFunctionClassFactory", "", "Lid/dana/common/model/OptionModel;", "initRecordTimeStamp", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/fragment/app/FragmentManager;", "moveToNextValue", "Landroidx/fragment/app/FragmentManager;", "PlaceComponentResult", "p0", "p1", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomSheetFilter extends BaseBottomSheetFullDialogFragment {
    public Map<Integer, View> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    Function0<Unit> MyBillsEntityDataFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final List<OptionModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    final FragmentManager PlaceComponentResult;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    Function2<? super Integer, ? super Boolean, Unit> getAuthRequestContext;

    @Override // id.dana.base.BaseBottomSheetFullDialogFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
    }

    @Override // id.dana.base.BaseBottomSheetFullDialogFragment
    public final View getAuthRequestContext(int i) {
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
    public final int getLayout() {
        return R.layout.bottomsheet_filter;
    }

    public BottomSheetFilter(FragmentManager fragmentManager, List<OptionModel> list) {
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new LinkedHashMap();
        this.PlaceComponentResult = fragmentManager;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.BuiltInFictitiousFunctionClassFactory = new Function0<Unit>() { // from class: id.dana.promocenter.views.BottomSheetFilter$onSubmitClicked$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.MyBillsEntityDataFactory = new Function0<Unit>() { // from class: id.dana.promocenter.views.BottomSheetFilter$onResetButtonClicked$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.getAuthRequestContext = new Function2<Integer, Boolean, Unit>() { // from class: id.dana.promocenter.views.BottomSheetFilter$onCheckBoxClickedListener$1
            public final void invoke(int i, boolean z) {
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(Integer num, Boolean bool) {
                invoke(num.intValue(), bool.booleanValue());
                return Unit.INSTANCE;
            }
        };
    }

    @Override // id.dana.base.BaseBottomSheetFullDialogFragment, id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        ((CheckboxView) getAuthRequestContext(R.id.onSuccessLoadMoreReview_res_0x7f0a0566)).setOnCheckBoxClicked(this.getAuthRequestContext);
        ((CheckboxView) getAuthRequestContext(R.id.onSuccessLoadMoreReview_res_0x7f0a0566)).setItems(this.KClassImpl$Data$declaredNonStaticMembers$2);
        ((DanaButtonPrimaryView) getAuthRequestContext(R.id.c)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.promocenter.views.BottomSheetFilter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetFilter.PlaceComponentResult(BottomSheetFilter.this);
            }
        });
        ((DanaButtonSecondaryView) getAuthRequestContext(R.id.btnReset)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.promocenter.views.BottomSheetFilter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetFilter.getAuthRequestContext(BottomSheetFilter.this);
            }
        });
    }

    public static /* synthetic */ void getAuthRequestContext(BottomSheetFilter bottomSheetFilter) {
        Intrinsics.checkNotNullParameter(bottomSheetFilter, "");
        bottomSheetFilter.MyBillsEntityDataFactory.invoke();
    }

    public static /* synthetic */ void PlaceComponentResult(BottomSheetFilter bottomSheetFilter) {
        Intrinsics.checkNotNullParameter(bottomSheetFilter, "");
        bottomSheetFilter.BuiltInFictitiousFunctionClassFactory.invoke();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        FrameLayout frameLayout = (FrameLayout) getAuthRequestContext(R.id.res_0x7f0a0742_flowablesequenceequal_equalcoordinator);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // id.dana.base.BaseBottomSheetFullDialogFragment, id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
    }
}
