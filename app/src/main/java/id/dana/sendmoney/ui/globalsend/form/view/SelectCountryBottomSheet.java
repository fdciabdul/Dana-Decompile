package id.dana.sendmoney.ui.globalsend.form.view;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ViewModelProvider;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.util.ShimmeringUtil;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.BottomSheetSelectDestinationBinding;
import id.dana.sendmoney.di.component.GlobalSendComponent;
import id.dana.sendmoney.ui.common.DefaultSearchHelper;
import id.dana.sendmoney.ui.common.EmptyStateView;
import id.dana.sendmoney.ui.globalsend.form.adapter.SelectCountryAdapter;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CountryModel;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.SelectCountryDestinationViewModel;
import id.dana.sendmoney.util.GlobalSendTrackerHelper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012BC\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0018\u0010.\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\t0\u0018\u0012\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u0018¢\u0006\u0004\b0\u00101J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\u000bR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0011\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0012\u0010\u0016\u001a\u00020\u0015X\u0087\"¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R&\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\t0\u00188\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0019R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u00188\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u0007\u001a\u00020\u001b8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0012\u0010'\u001a\u00020&X\u0087\"¢\u0006\u0006\n\u0004\b'\u0010(R\u0013\u0010,\u001a\u00020)X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b*\u0010+"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/view/SelectCountryBottomSheet;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/sendmoney/databinding/BottomSheetSelectDestinationBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "onStart", "scheduleImpl", "", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;", "PlaceComponentResult", "Ljava/util/List;", "Lid/dana/sendmoney/di/component/GlobalSendComponent;", "Lid/dana/sendmoney/di/component/GlobalSendComponent;", "Lid/dana/sendmoney/util/GlobalSendTrackerHelper;", "globalSendTrackerHelper", "Lid/dana/sendmoney/util/GlobalSendTrackerHelper;", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "GetContactSyncConfig", "Lid/dana/sendmoney/ui/globalsend/form/adapter/SelectCountryAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/sendmoney/ui/globalsend/form/adapter/SelectCountryAdapter;", "Lid/dana/sendmoney/ui/common/DefaultSearchHelper;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/sendmoney/ui/common/DefaultSearchHelper;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lcom/ethanhua/skeleton/SkeletonScreen;", "initRecordTimeStamp", "Lcom/ethanhua/skeleton/SkeletonScreen;", "moveToNextValue", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationViewModel;", "DatabaseTableConfigUtil", "Lkotlin/Lazy;", "getErrorConfigVersion", "p0", "p1", "p2", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectCountryBottomSheet extends BaseViewBindingBottomSheetDialogFragment<BottomSheetSelectDestinationBinding> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Function1<CountryModel, Unit> getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private GlobalSendComponent PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function1<List<CountryModel>, Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private DefaultSearchHelper NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private SelectCountryAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private List<CountryModel> MyBillsEntityDataFactory;
    @Inject
    public GlobalSendTrackerHelper globalSendTrackerHelper;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private SkeletonScreen moveToNextValue;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.4f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetSelectDestinationBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetSelectDestinationBinding PlaceComponentResult = BottomSheetSelectDestinationBinding.PlaceComponentResult(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectCountryBottomSheet(List<CountryModel> list, Function1<? super List<CountryModel>, Unit> function1, Function1<? super CountryModel, Unit> function12) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function12, "");
        this.MyBillsEntityDataFactory = list;
        this.BuiltInFictitiousFunctionClassFactory = function1;
        this.getAuthRequestContext = function12;
        this.getErrorConfigVersion = LazyKt.lazy(new Function0<SelectCountryDestinationViewModel>() { // from class: id.dana.sendmoney.ui.globalsend.form.view.SelectCountryBottomSheet$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SelectCountryDestinationViewModel invoke() {
                SelectCountryBottomSheet selectCountryBottomSheet = SelectCountryBottomSheet.this;
                SelectCountryBottomSheet selectCountryBottomSheet2 = selectCountryBottomSheet;
                ViewModelFactory viewModelFactory = selectCountryBottomSheet.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return (SelectCountryDestinationViewModel) new ViewModelProvider(selectCountryBottomSheet2, viewModelFactory).MyBillsEntityDataFactory(SelectCountryDestinationViewModel.class);
            }
        });
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            a_(PlaceComponentResult(dialog));
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            View view = getView();
            if (view != null) {
                view.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(view, this));
            }
            MyBillsEntityDataFactory(dialog);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x017a  */
    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext() {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.globalsend.form.view.SelectCountryBottomSheet.getAuthRequestContext():void");
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SelectCountryBottomSheet selectCountryBottomSheet) {
        Intrinsics.checkNotNullParameter(selectCountryBottomSheet, "");
        selectCountryBottomSheet.dismiss();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SelectCountryBottomSheet selectCountryBottomSheet) {
        Intrinsics.checkNotNullParameter(selectCountryBottomSheet, "");
        selectCountryBottomSheet.dismiss();
    }

    public static final /* synthetic */ SelectCountryDestinationViewModel NetworkUserEntityData$$ExternalSyntheticLambda0(SelectCountryBottomSheet selectCountryBottomSheet) {
        return (SelectCountryDestinationViewModel) selectCountryBottomSheet.getErrorConfigVersion.getValue();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(SelectCountryBottomSheet selectCountryBottomSheet, boolean z) {
        if (z) {
            SkeletonScreen skeletonScreen = selectCountryBottomSheet.moveToNextValue;
            if (skeletonScreen != null) {
                if (skeletonScreen != null) {
                    skeletonScreen.MyBillsEntityDataFactory();
                    return;
                }
                return;
            }
            VB vb = selectCountryBottomSheet.MyBillsEntityDataFactory;
            if (vb != 0) {
                ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(((BottomSheetSelectDestinationBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2);
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_bottomsheet_country_skeleton;
                BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
                BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), ShimmeringUtil.BuiltInFictitiousFunctionClassFactory());
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
                ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
                viewSkeletonScreen.MyBillsEntityDataFactory();
                selectCountryBottomSheet.moveToNextValue = viewSkeletonScreen;
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        SkeletonScreen skeletonScreen2 = selectCountryBottomSheet.moveToNextValue;
        if (skeletonScreen2 != null) {
            skeletonScreen2.PlaceComponentResult();
        }
        selectCountryBottomSheet.moveToNextValue = null;
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SelectCountryBottomSheet selectCountryBottomSheet, String str) {
        String str2 = str;
        SelectCountryAdapter selectCountryAdapter = null;
        if (str2.length() == 0) {
            SelectCountryAdapter selectCountryAdapter2 = selectCountryBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2;
            if (selectCountryAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                selectCountryAdapter = selectCountryAdapter2;
            }
            selectCountryAdapter.MyBillsEntityDataFactory(selectCountryBottomSheet.MyBillsEntityDataFactory);
            selectCountryBottomSheet.scheduleImpl();
            return;
        }
        List<CountryModel> list = selectCountryBottomSheet.MyBillsEntityDataFactory;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (StringsKt.contains((CharSequence) ((CountryModel) obj).getAuthRequestContext(), (CharSequence) str2, true)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            SelectCountryAdapter selectCountryAdapter3 = selectCountryBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2;
            if (selectCountryAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                selectCountryAdapter = selectCountryAdapter3;
            }
            selectCountryAdapter.MyBillsEntityDataFactory(new ArrayList());
            VB vb = selectCountryBottomSheet.MyBillsEntityDataFactory;
            if (vb != 0) {
                RecyclerView recyclerView = ((BottomSheetSelectDestinationBinding) vb).PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "");
                recyclerView.setVisibility(8);
                VB vb2 = selectCountryBottomSheet.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    EmptyStateView emptyStateView = ((BottomSheetSelectDestinationBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkNotNullExpressionValue(emptyStateView, "");
                    emptyStateView.setVisibility(0);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        SelectCountryAdapter selectCountryAdapter4 = selectCountryBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2;
        if (selectCountryAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            selectCountryAdapter = selectCountryAdapter4;
        }
        selectCountryAdapter.MyBillsEntityDataFactory(arrayList2);
        selectCountryBottomSheet.scheduleImpl();
    }

    private final void scheduleImpl() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            RecyclerView recyclerView = ((BottomSheetSelectDestinationBinding) vb).PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(0);
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                EmptyStateView emptyStateView = ((BottomSheetSelectDestinationBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(emptyStateView, "");
                emptyStateView.setVisibility(8);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BottomSheetSelectDestinationBinding) vb).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
