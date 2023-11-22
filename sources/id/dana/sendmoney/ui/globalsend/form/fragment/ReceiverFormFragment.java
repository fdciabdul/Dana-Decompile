package id.dana.sendmoney.ui.globalsend.form.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.view.LifecycleOwnerKt;
import androidx.view.OnBackPressedCallback;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelProvider;
import com.afollestad.materialdialogs.MaterialDialog;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.core.ui.util.OSUtil;
import id.dana.core.ui.util.ShimmeringUtil;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.myprofile.SubtitleType;
import id.dana.network.exception.NetworkException;
import id.dana.sendmoney.R;
import id.dana.sendmoney.constants.GlobalSendTransferDestinationType;
import id.dana.sendmoney.databinding.FragmentReceiverFormBinding;
import id.dana.sendmoney.di.component.GlobalSendComponent;
import id.dana.sendmoney.di.provider.GlobalSendComponentProvider;
import id.dana.sendmoney.domain.common.interactor.ValidateFormUseCase;
import id.dana.sendmoney.domain.globalsend.interactor.ValidateNewTransaction;
import id.dana.sendmoney.domain.globalsend.model.validate.TransferValidateResult;
import id.dana.sendmoney.ui.common.EmptyStateView;
import id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity;
import id.dana.sendmoney.ui.globalsend.form.mapper.BeneficiaryModelMapperKt;
import id.dana.sendmoney.ui.globalsend.form.mapper.TransferValidateModelMapperKt;
import id.dana.sendmoney.ui.globalsend.form.model.BeneficiaryInfoModel;
import id.dana.sendmoney.ui.globalsend.form.model.CurrencyRateModel;
import id.dana.sendmoney.ui.globalsend.form.model.GlobalTransferInitModel;
import id.dana.sendmoney.ui.globalsend.form.model.SubTransferMethodInfoModel;
import id.dana.sendmoney.ui.globalsend.form.model.common.FormValidatorModel;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CityFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CityModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CountryFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.CountryModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.DefaultFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.DisabledTransferDestinationFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.EnabledTransferToDebitModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.ProvinceFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.receiver.ProvinceModel;
import id.dana.sendmoney.ui.globalsend.form.view.GlobalSendDynamicFormView;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormUiState;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel;
import id.dana.sendmoney.util.FormValidationUtil;
import id.dana.sendmoney.util.GlobalSendErrorHelper;
import id.dana.sendmoney.util.GlobalSendTrackerHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001>B<\u00123\u0010\u000e\u001a/\u0012\u000b\u0012\t\u0018\u00010)¢\u0006\u0002\b*\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b*\u0012\u000b\u0012\t\u0018\u00010\u001f¢\u0006\u0002\b*\u0012\u0004\u0012\u00020\u00030(¢\u0006\u0004\b<\u0010=J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u000b\u001a \u0012\u0004\u0012\u00020\u0007\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t0\b0\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\r\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0013\u0010\u0015\u001a\u00020\u0013X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u0016X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001d\u001a\u00020\u001cX\u0087\"¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\u001f8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020$8WX\u0096\u0006¢\u0006\u0006\u001a\u0004\b%\u0010&R>\u0010 \u001a/\u0012\u000b\u0012\t\u0018\u00010)¢\u0006\u0002\b*\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b*\u0012\u000b\u0012\t\u0018\u00010\u001f¢\u0006\u0002\b*\u0012\u0004\u0012\u00020\u00030(X\u0007¢\u0006\u0006\n\u0004\b\u001b\u0010+R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b'\u0010,R\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070-8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b1\u00102R\u0012\u00104\u001a\u000203X\u0087\"¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u00107\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b:\u00108R\u0013\u0010.\u001a\u00020;X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b9\u0010\u0014"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/fragment/ReceiverFormFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/sendmoney/databinding/FragmentReceiverFormBinding;", "", "MyBillsEntityDataFactory", "()V", "", "", "", "Lkotlin/Function1;", "", "BuiltInFictitiousFunctionClassFactory", "()Ljava/util/Map;", "FragmentBottomSheetPaymentSettingBinding", "p0", "PlaceComponentResult", "(Z)V", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;", "Lid/dana/core/ui/dialog/DanaLogoLoadingDialog;", "Lkotlin/Lazy;", "getAuthRequestContext", "Lcom/afollestad/materialdialogs/MaterialDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/sendmoney/di/component/GlobalSendComponent;", "moveToNextValue", "Lid/dana/sendmoney/di/component/GlobalSendComponent;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/util/GlobalSendTrackerHelper;", "globalSendTrackerHelper", "Lid/dana/sendmoney/util/GlobalSendTrackerHelper;", "Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;", "scheduleImpl", "Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;", "getErrorConfigVersion", "Z", "Landroidx/activity/OnBackPressedCallback;", "E", "()Landroidx/activity/OnBackPressedCallback;", "lookAheadTest", "Lkotlin/Function3;", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "Lkotlin/ParameterName;", "Lkotlin/jvm/functions/Function3;", "Ljava/lang/String;", "", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/util/Map;", "Lid/dana/sendmoney/ui/globalsend/form/model/SubTransferMethodInfoModel;", "initRecordTimeStamp", "Lid/dana/sendmoney/ui/globalsend/form/model/SubTransferMethodInfoModel;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "DatabaseTableConfigUtil", "Lcom/ethanhua/skeleton/SkeletonScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormViewModel;", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReceiverFormFragment extends BaseViewBindingFragment<FragmentReceiverFormBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private SkeletonScreen NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private SkeletonScreen DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Function3<BeneficiaryInfoModel, String, GlobalTransferInitModel, Unit> scheduleImpl;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Map<String, String> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private CountryModel MyBillsEntityDataFactory;
    private boolean getErrorConfigVersion;
    @Inject
    public GlobalSendTrackerHelper globalSendTrackerHelper;
    private SubTransferMethodInfoModel initRecordTimeStamp;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private GlobalSendComponent KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private GlobalTransferInitModel PlaceComponentResult;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentReceiverFormBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentReceiverFormBinding MyBillsEntityDataFactory = FragmentReceiverFormBinding.MyBillsEntityDataFactory(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReceiverFormFragment(Function3<? super BeneficiaryInfoModel, ? super String, ? super GlobalTransferInitModel, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "");
        this.scheduleImpl = function3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = LazyKt.lazy(new Function0<ReceiverFormViewModel>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ReceiverFormViewModel invoke() {
                ReceiverFormFragment receiverFormFragment = ReceiverFormFragment.this;
                ReceiverFormFragment receiverFormFragment2 = receiverFormFragment;
                ViewModelFactory viewModelFactory = receiverFormFragment.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return (ReceiverFormViewModel) new ViewModelProvider(receiverFormFragment2, viewModelFactory).MyBillsEntityDataFactory(ReceiverFormViewModel.class);
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new LinkedHashMap();
        this.getAuthRequestContext = LazyKt.lazy(new Function0<DanaLogoLoadingDialog>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$danaLogoLoadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaLogoLoadingDialog invoke() {
                Context requireContext = ReceiverFormFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                return new DanaLogoLoadingDialog(requireContext);
            }
        });
        this.getErrorConfigVersion = true;
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$discardChangesUnfilledDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialDialog invoke() {
                FragmentActivity activity = ReceiverFormFragment.this.getActivity();
                if (activity == null) {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity");
                }
                CustomDialog.Builder builder = new CustomDialog.Builder((GlobalSendFormActivity) activity);
                builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_warning_red;
                builder.SubSequence = ReceiverFormFragment.this.getString(R.string.discard_changes_dialog_unfilled_title);
                builder.GetContactSyncConfig = ReceiverFormFragment.this.getString(R.string.discard_changes_dialog_unfilled_message);
                String string = ReceiverFormFragment.this.getString(R.string.dialog_discard_positive_button_text);
                final ReceiverFormFragment receiverFormFragment = ReceiverFormFragment.this;
                CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(string, new Function1<View, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$discardChangesUnfilledDialog$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                        ReceiverFormFragment.this.requireActivity().finish();
                    }
                });
                BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = ReceiverFormFragment.this.getString(R.string.btn_quit);
                CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(ReceiverFormFragment.this.getString(R.string.cancel_text), new Function1<View, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$discardChangesUnfilledDialog$2.2
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }
                });
                KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance = ReceiverFormFragment.this.getString(R.string.DatabaseTableConfigUtil_res_0x7f1302c7);
                return KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    @JvmName(name = "E")
    /* renamed from: E */
    public final OnBackPressedCallback getBuiltInFictitiousFunctionClassFactory() {
        return new ReceiverFormFragment$onBackPressedCallback$1(this);
    }

    public final void PlaceComponentResult(final boolean p0) {
        GlobalSendErrorHelper globalSendErrorHelper = GlobalSendErrorHelper.getAuthRequestContext;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
        GlobalSendErrorHelper.getAuthRequestContext(requireActivity, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$showMaintenanceDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (p0) {
                    return;
                }
                new ReceiverFormFragment$onBackPressedCallback$1(this).handleOnBackPressed();
            }
        });
    }

    private static Map<String, List<Function1<String, Boolean>>> BuiltInFictitiousFunctionClassFactory() {
        return MapsKt.mapOf(TuplesKt.to("FIRST_NAME", CollectionsKt.listOf((Object[]) new Function1[]{new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckIsFormValid$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return Boolean.valueOf(str.length() > 0);
            }
        }, new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckIsFormValid$2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                FormValidationUtil formValidationUtil = FormValidationUtil.INSTANCE;
                return Boolean.valueOf(FormValidationUtil.getAuthRequestContext(str));
            }
        }})), TuplesKt.to("LAST_NAME", CollectionsKt.listOf((Object[]) new Function1[]{new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckIsFormValid$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return Boolean.valueOf(str.length() > 0);
            }
        }, new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckIsFormValid$4
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                FormValidationUtil formValidationUtil = FormValidationUtil.INSTANCE;
                return Boolean.valueOf(FormValidationUtil.getAuthRequestContext(str));
            }
        }})), TuplesKt.to(SubtitleType.EMAIL, CollectionsKt.listOf((Object[]) new Function1[]{new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckIsFormValid$5
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return Boolean.valueOf(str.length() > 0);
            }
        }, new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckIsFormValid$6
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                FormValidationUtil formValidationUtil = FormValidationUtil.INSTANCE;
                return Boolean.valueOf(FormValidationUtil.KClassImpl$Data$declaredNonStaticMembers$2((CharSequence) str));
            }
        }})), TuplesKt.to("ADDRESS", CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckIsFormValid$7
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return Boolean.valueOf(str.length() > 0);
            }
        })), TuplesKt.to("PROVINCE", CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckIsFormValid$8
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return Boolean.valueOf(str.length() > 0);
            }
        })), TuplesKt.to("CITY", CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckIsFormValid$9
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return Boolean.valueOf(str.length() > 0);
            }
        })), TuplesKt.to("RECEIVER_CARD_NUMBER", CollectionsKt.listOf((Object[]) new Function1[]{new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckIsFormValid$10
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                FormValidationUtil formValidationUtil = FormValidationUtil.INSTANCE;
                return Boolean.valueOf(FormValidationUtil.KClassImpl$Data$declaredNonStaticMembers$2(str));
            }
        }, new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckIsFormValid$11
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                FormValidationUtil formValidationUtil = FormValidationUtil.INSTANCE;
                return Boolean.valueOf(FormValidationUtil.BuiltInFictitiousFunctionClassFactory(str));
            }
        }, new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckIsFormValid$12
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                FormValidationUtil formValidationUtil = FormValidationUtil.INSTANCE;
                return Boolean.valueOf(FormValidationUtil.MyBillsEntityDataFactory(str));
            }
        }})));
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JR\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000223\u0010\n\u001a/\u0012\u000b\u0012\t\u0018\u00010\u0005¢\u0006\u0002\b\u0006\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b\u0006\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\u0006\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/fragment/ReceiverFormFragment$Companion;", "", "Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;", "p0", "Lkotlin/Function3;", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "Lkotlin/ParameterName;", "", "Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;", "", "p1", "p2", "Lid/dana/sendmoney/ui/globalsend/form/fragment/ReceiverFormFragment;", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/ui/globalsend/form/model/form/receiver/CountryModel;Lkotlin/jvm/functions/Function3;Ljava/lang/String;)Lid/dana/sendmoney/ui/globalsend/form/fragment/ReceiverFormFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ReceiverFormFragment MyBillsEntityDataFactory(CountryModel p0, Function3<? super BeneficiaryInfoModel, ? super String, ? super GlobalTransferInitModel, Unit> p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            ReceiverFormFragment receiverFormFragment = new ReceiverFormFragment(p1);
            Bundle bundle = new Bundle();
            bundle.putParcelable("COUNTRY_MODEL", p0);
            bundle.putString(GlobalSendFormActivity.PAGE_SOURCE, p2);
            receiverFormFragment.setArguments(bundle);
            return receiverFormFragment;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(ReceiverFormFragment receiverFormFragment) {
        Intrinsics.checkNotNullParameter(receiverFormFragment, "");
        final ReceiverFormViewModel receiverFormViewModel = (ReceiverFormViewModel) receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue();
        SubTransferMethodInfoModel subTransferMethodInfoModel = receiverFormFragment.initRecordTimeStamp;
        if (subTransferMethodInfoModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            subTransferMethodInfoModel = null;
        }
        String str = subTransferMethodInfoModel.getAuthRequestContext;
        String str2 = receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.get("FIRST_NAME");
        String str3 = str2 == null ? "" : str2;
        String str4 = receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.get("LAST_NAME");
        String str5 = str4 == null ? "" : str4;
        String str6 = receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.get(SubtitleType.EMAIL);
        String str7 = str6 == null ? "" : str6;
        String str8 = receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.get("ADDRESS");
        String str9 = str8 == null ? "" : str8;
        CountryModel countryModel = receiverFormFragment.MyBillsEntityDataFactory;
        if (countryModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            countryModel = null;
        }
        String str10 = countryModel.getAuthRequestContext;
        String str11 = receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.get("PROVINCE");
        String str12 = str11 == null ? "" : str11;
        String str13 = receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.get("CITY");
        String str14 = str13 == null ? "" : str13;
        SubTransferMethodInfoModel subTransferMethodInfoModel2 = receiverFormFragment.initRecordTimeStamp;
        if (subTransferMethodInfoModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            subTransferMethodInfoModel2 = null;
        }
        String str15 = subTransferMethodInfoModel2.MyBillsEntityDataFactory;
        SubTransferMethodInfoModel subTransferMethodInfoModel3 = receiverFormFragment.initRecordTimeStamp;
        if (subTransferMethodInfoModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            subTransferMethodInfoModel3 = null;
        }
        String str16 = subTransferMethodInfoModel3.getErrorConfigVersion;
        SubTransferMethodInfoModel subTransferMethodInfoModel4 = receiverFormFragment.initRecordTimeStamp;
        if (subTransferMethodInfoModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            subTransferMethodInfoModel4 = null;
        }
        String str17 = subTransferMethodInfoModel4.PlaceComponentResult;
        SubTransferMethodInfoModel subTransferMethodInfoModel5 = receiverFormFragment.initRecordTimeStamp;
        if (subTransferMethodInfoModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            subTransferMethodInfoModel5 = null;
        }
        String str18 = subTransferMethodInfoModel5.getAuthRequestContext;
        CountryModel countryModel2 = receiverFormFragment.MyBillsEntityDataFactory;
        if (countryModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            countryModel2 = null;
        }
        String str19 = countryModel2.KClassImpl$Data$declaredNonStaticMembers$2;
        SubTransferMethodInfoModel subTransferMethodInfoModel6 = receiverFormFragment.initRecordTimeStamp;
        if (subTransferMethodInfoModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            subTransferMethodInfoModel6 = null;
        }
        BeneficiaryInfoModel beneficiaryInfoModel = new BeneficiaryInfoModel("", str3, str5, str7, str9, str10, str12, str14, "", "", "", "", "", "", "", "", "", "", str15, str16, str17, str18, str19, 0L, 0L, "", subTransferMethodInfoModel6.moveToNextValue);
        final String str20 = receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.get("RECEIVER_CARD_NUMBER");
        if (str20 == null) {
            str20 = "";
        }
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(beneficiaryInfoModel, "");
        Intrinsics.checkNotNullParameter(str20, "");
        receiverFormViewModel.moveToNextValue.execute(new ValidateNewTransaction.Param(str, BeneficiaryModelMapperKt.BuiltInFictitiousFunctionClassFactory(beneficiaryInfoModel), str20), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel$validateNewTransaction$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = ReceiverFormViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    ReceiverFormUiState receiverFormUiState = (ReceiverFormUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new ReceiverFormUiState.DanaLoading(true)));
            }
        }, new Function1<TransferValidateResult, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel$validateNewTransaction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(TransferValidateResult transferValidateResult) {
                invoke2(transferValidateResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(TransferValidateResult transferValidateResult) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(transferValidateResult, "");
                mutableStateFlow = ReceiverFormViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                String str21 = str20;
                do {
                    value = mutableStateFlow.getValue();
                    ReceiverFormUiState receiverFormUiState = (ReceiverFormUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new ReceiverFormUiState.OnSuccessValidate(TransferValidateModelMapperKt.BuiltInFictitiousFunctionClassFactory(transferValidateResult), str21)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel$validateNewTransaction$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableStateFlow mutableStateFlow;
                Object value;
                ReceiverFormUiState error;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = ReceiverFormViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    ReceiverFormUiState receiverFormUiState = (ReceiverFormUiState) value;
                    if (th instanceof NetworkException) {
                        NetworkException networkException = (NetworkException) th;
                        String errorCode = networkException.getErrorCode();
                        if (errorCode == null) {
                            errorCode = "";
                        }
                        String localizedMessage = networkException.getLocalizedMessage();
                        if (localizedMessage == null) {
                            localizedMessage = "";
                        }
                        error = new ReceiverFormUiState.OnErrorCodeValidate(errorCode, localizedMessage);
                    } else {
                        error = new ReceiverFormUiState.Error(th.getMessage());
                    }
                } while (!mutableStateFlow.compareAndSet(value, error));
            }
        }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel$validateNewTransaction$4
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = ReceiverFormViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    ReceiverFormUiState receiverFormUiState = (ReceiverFormUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new ReceiverFormUiState.DanaLoading(false)));
            }
        }, ViewModelKt.PlaceComponentResult(receiverFormViewModel));
        if (receiverFormFragment.initRecordTimeStamp == null || receiverFormFragment.moveToNextValue == null || receiverFormFragment.MyBillsEntityDataFactory == null) {
            return;
        }
        GlobalSendTrackerHelper globalSendTrackerHelper = receiverFormFragment.globalSendTrackerHelper;
        if (globalSendTrackerHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalSendTrackerHelper = null;
        }
        String str21 = receiverFormFragment.moveToNextValue;
        if (str21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str21 = null;
        }
        CountryModel countryModel3 = receiverFormFragment.MyBillsEntityDataFactory;
        if (countryModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            countryModel3 = null;
        }
        String str22 = countryModel3.PlaceComponentResult;
        SubTransferMethodInfoModel subTransferMethodInfoModel7 = receiverFormFragment.initRecordTimeStamp;
        if (subTransferMethodInfoModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            subTransferMethodInfoModel7 = null;
        }
        globalSendTrackerHelper.PlaceComponentResult(str21, str22, subTransferMethodInfoModel7.moveToNextValue);
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ReceiverFormFragment receiverFormFragment) {
        VB vb = receiverFormFragment.PlaceComponentResult;
        if (vb != 0) {
            if (((FragmentReceiverFormBinding) vb).getAuthRequestContext.isEnabled()) {
                VB vb2 = receiverFormFragment.PlaceComponentResult;
                if (vb2 != 0) {
                    DanaButtonPrimaryView danaButtonPrimaryView = ((FragmentReceiverFormBinding) vb2).getAuthRequestContext;
                    danaButtonPrimaryView.setDisabled(receiverFormFragment.getString(R.string.button_continue));
                    danaButtonPrimaryView.setEnabled(false);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(ReceiverFormFragment receiverFormFragment) {
        VB vb = receiverFormFragment.PlaceComponentResult;
        if (vb != 0) {
            if (((FragmentReceiverFormBinding) vb).getAuthRequestContext.isEnabled()) {
                return;
            }
            VB vb2 = receiverFormFragment.PlaceComponentResult;
            if (vb2 != 0) {
                DanaButtonPrimaryView danaButtonPrimaryView = ((FragmentReceiverFormBinding) vb2).getAuthRequestContext;
                danaButtonPrimaryView.setActiveButton(receiverFormFragment.getString(R.string.button_continue), null);
                danaButtonPrimaryView.setEnabled(true);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ MaterialDialog moveToNextValue(ReceiverFormFragment receiverFormFragment) {
        return (MaterialDialog) receiverFormFragment.BuiltInFictitiousFunctionClassFactory.getValue();
    }

    public static final /* synthetic */ ReceiverFormViewModel scheduleImpl(ReceiverFormFragment receiverFormFragment) {
        return (ReceiverFormViewModel) receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x009d, code lost:
    
        if (r4.equals("DE15112088999103") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00ac, code lost:
    
        r4 = id.dana.core.ui.util.DANAToast.BuiltInFictitiousFunctionClassFactory;
        r3 = r3.requireActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "");
        id.dana.core.ui.util.DANAToast.MyBillsEntityDataFactory(r3, r5, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00ba, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x001e, code lost:
    
        if (r4.equals("DE15012088999102") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0028, code lost:
    
        if (r4.equals("DE15012088999101") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0032, code lost:
    
        if (r4.equals("DE15012088999100") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0047, code lost:
    
        if (r4.equals("DE13112088999203") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0050, code lost:
    
        if (r4.equals("DE13112088999202") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0059, code lost:
    
        if (r4.equals("DE13112088999201") == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0062, code lost:
    
        if (r4.equals("DE13112088999200") != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0064, code lost:
    
        r4 = r3.getActivity();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0068, code lost:
    
        if (r4 == null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x006a, code lost:
    
        r4 = r4.getCurrentFocus();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x006e, code lost:
    
        if (r4 == null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0070, code lost:
    
        r4.clearFocus();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0073, code lost:
    
        r3 = r3.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0075, code lost:
    
        if (r3 == 0) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0077, code lost:
    
        ((id.dana.sendmoney.databinding.FragmentReceiverFormBinding) r3).scheduleImpl.setErrorForTransferToDebit(15, true, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0081, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x008d, code lost:
    
        throw new java.lang.IllegalArgumentException("Required value was null.".toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0094, code lost:
    
        if (r4.equals("DE13112088999113") == false) goto L102;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void getAuthRequestContext(id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            int r0 = r4.hashCode()
            java.lang.String r1 = ""
            r2 = -343200130(0xffffffffeb8b2e7e, float:-3.365205E26)
            if (r0 == r2) goto L97
            r2 = 243605915(0xe85219b, float:3.2819392E-30)
            if (r0 == r2) goto L8e
            switch(r0) {
                case -472282852: goto L2c;
                case -472282851: goto L22;
                case -472282850: goto L18;
                default: goto L13;
            }
        L13:
            switch(r0) {
                case 243606842: goto L5c;
                case 243606843: goto L53;
                case 243606844: goto L4a;
                case 243606845: goto L41;
                case 243606846: goto L35;
                default: goto L16;
            }
        L16:
            goto L9f
        L18:
            java.lang.String r6 = "DE15012088999102"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto Lac
            goto L9f
        L22:
            java.lang.String r6 = "DE15012088999101"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto Lac
            goto L9f
        L2c:
            java.lang.String r6 = "DE15012088999100"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto Lac
            goto L9f
        L35:
            java.lang.String r5 = "DE13112088999204"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L9f
            r3.PlaceComponentResult(r6)
            return
        L41:
            java.lang.String r6 = "DE13112088999203"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L64
            goto L9f
        L4a:
            java.lang.String r6 = "DE13112088999202"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L64
            goto L9f
        L53:
            java.lang.String r6 = "DE13112088999201"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L64
            goto L9f
        L5c:
            java.lang.String r6 = "DE13112088999200"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L9f
        L64:
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            if (r4 == 0) goto L73
            android.view.View r4 = r4.getCurrentFocus()
            if (r4 == 0) goto L73
            r4.clearFocus()
        L73:
            VB extends androidx.viewbinding.ViewBinding r3 = r3.PlaceComponentResult
            if (r3 == 0) goto L82
            id.dana.sendmoney.databinding.FragmentReceiverFormBinding r3 = (id.dana.sendmoney.databinding.FragmentReceiverFormBinding) r3
            id.dana.sendmoney.ui.globalsend.form.view.GlobalSendDynamicFormView r3 = r3.scheduleImpl
            r4 = 15
            r6 = 1
            r3.setErrorForTransferToDebit(r4, r6, r5)
            return
        L82:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Required value was null."
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L8e:
            java.lang.String r6 = "DE13112088999113"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto Lac
            goto L9f
        L97:
            java.lang.String r6 = "DE15112088999103"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto Lac
        L9f:
            id.dana.sendmoney.util.GlobalSendErrorHelper r4 = id.dana.sendmoney.util.GlobalSendErrorHelper.getAuthRequestContext
            android.content.Context r3 = r3.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            id.dana.sendmoney.util.GlobalSendErrorHelper.PlaceComponentResult(r3)
            return
        Lac:
            id.dana.core.ui.util.DANAToast r4 = id.dana.core.ui.util.DANAToast.BuiltInFictitiousFunctionClassFactory
            androidx.fragment.app.FragmentActivity r3 = r3.requireActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            android.app.Activity r3 = (android.app.Activity) r3
            id.dana.core.ui.util.DANAToast.BuiltInFictitiousFunctionClassFactory(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment.getAuthRequestContext(id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment, java.lang.String, java.lang.String, boolean):void");
    }

    public static final /* synthetic */ void getErrorConfigVersion(ReceiverFormFragment receiverFormFragment) {
        SkeletonScreen skeletonScreen = receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
        SkeletonScreen skeletonScreen2 = receiverFormFragment.DatabaseTableConfigUtil;
        if (skeletonScreen2 != null) {
            skeletonScreen2.PlaceComponentResult();
        }
        receiverFormFragment.DatabaseTableConfigUtil = null;
    }

    public static final /* synthetic */ void getAuthRequestContext(ReceiverFormFragment receiverFormFragment, boolean z) {
        if (!z) {
            ((DanaLogoLoadingDialog) receiverFormFragment.getAuthRequestContext.getValue()).PlaceComponentResult();
            return;
        }
        DanaLogoLoadingDialog danaLogoLoadingDialog = (DanaLogoLoadingDialog) receiverFormFragment.getAuthRequestContext.getValue();
        if (danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.isShowing()) {
            return;
        }
        danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.show();
        danaLogoLoadingDialog.MyBillsEntityDataFactory.startRefresh();
    }

    public static final /* synthetic */ void getAuthRequestContext(ReceiverFormFragment receiverFormFragment, String str, String str2) {
        receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0.put(str, str2);
        final ReceiverFormViewModel receiverFormViewModel = (ReceiverFormViewModel) receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue();
        FormValidatorModel formValidatorModel = new FormValidatorModel(receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0, MapsKt.mapOf(TuplesKt.to("FIRST_NAME", CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckFormsIsNotFilled$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str3) {
                Intrinsics.checkNotNullParameter(str3, "");
                return Boolean.valueOf(str3.length() == 0);
            }
        })), TuplesKt.to("LAST_NAME", CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckFormsIsNotFilled$2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str3) {
                Intrinsics.checkNotNullParameter(str3, "");
                return Boolean.valueOf(str3.length() == 0);
            }
        })), TuplesKt.to(SubtitleType.EMAIL, CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckFormsIsNotFilled$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str3) {
                Intrinsics.checkNotNullParameter(str3, "");
                return Boolean.valueOf(str3.length() == 0);
            }
        })), TuplesKt.to("ADDRESS", CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckFormsIsNotFilled$4
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str3) {
                Intrinsics.checkNotNullParameter(str3, "");
                return Boolean.valueOf(str3.length() == 0);
            }
        })), TuplesKt.to("PROVINCE", CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckFormsIsNotFilled$5
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str3) {
                Intrinsics.checkNotNullParameter(str3, "");
                return Boolean.valueOf(str3.length() == 0);
            }
        })), TuplesKt.to("CITY", CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckFormsIsNotFilled$6
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str3) {
                Intrinsics.checkNotNullParameter(str3, "");
                return Boolean.valueOf(str3.length() == 0);
            }
        })), TuplesKt.to("RECEIVER_CARD_NUMBER", CollectionsKt.listOf(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$getRuleToCheckFormsIsNotFilled$7
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str3) {
                Intrinsics.checkNotNullParameter(str3, "");
                return Boolean.valueOf(str3.length() == 0);
            }
        }))));
        Intrinsics.checkNotNullParameter(formValidatorModel, "");
        BaseFlowUseCase.execute$default(receiverFormViewModel.BuiltInFictitiousFunctionClassFactory, new ValidateFormUseCase.Params(formValidatorModel), null, new Function1<Map<String, ? extends String>, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel$validateIsOneOfTheFormAlreadyFilled$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends String> map) {
                invoke2((Map<String, String>) map);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Map<String, String> map) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(map, "");
                boolean isEmpty = map.isEmpty();
                mutableStateFlow = ReceiverFormViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                do {
                    value = mutableStateFlow.getValue();
                    ReceiverFormUiState receiverFormUiState = (ReceiverFormUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new ReceiverFormUiState.OnValidationIsFormNotFilled(isEmpty)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel$validateIsOneOfTheFormAlreadyFilled$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        }, null, ViewModelKt.PlaceComponentResult(receiverFormViewModel), 18, null);
        ((ReceiverFormViewModel) receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue()).getAuthRequestContext(new FormValidatorModel(receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0, BuiltInFictitiousFunctionClassFactory()));
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final ReceiverFormFragment receiverFormFragment, final List list, final List list2) {
        VB vb = receiverFormFragment.PlaceComponentResult;
        if (vb == 0) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        GlobalSendDynamicFormView globalSendDynamicFormView = ((FragmentReceiverFormBinding) vb).getErrorConfigVersion;
        CurrencyRateModel currencyRateModel = ((SubTransferMethodInfoModel) list.get(0)).lookAheadTest;
        GlobalSendFormModel[] globalSendFormModelArr = new GlobalSendFormModel[7];
        int i = R.string.header_form_country_destination;
        CountryModel countryModel = receiverFormFragment.MyBillsEntityDataFactory;
        if (countryModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            countryModel = null;
        }
        globalSendFormModelArr[0] = new CountryFormModel(i, countryModel, currencyRateModel);
        String str = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 35;
        boolean z2 = true;
        int i4 = 76;
        DefaultConstructorMarker defaultConstructorMarker = null;
        globalSendFormModelArr[1] = new DefaultFormModel(R.string.header_form_first_name, R.string.hint_form_first_name, str, i2, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                ReceiverFormFragment.getAuthRequestContext(ReceiverFormFragment.this, "FIRST_NAME", str2);
            }
        }, R.string.txt_first_name, z, MapsKt.mapOf(TuplesKt.to(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                return Boolean.valueOf(str2.length() > 0);
            }
        }, Integer.valueOf(R.string.error_empty_first_name)), TuplesKt.to(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                FormValidationUtil formValidationUtil = FormValidationUtil.INSTANCE;
                return Boolean.valueOf(FormValidationUtil.getAuthRequestContext(str2));
            }
        }, Integer.valueOf(R.string.error_message_form_first_name))), i3, z2, i4, defaultConstructorMarker);
        globalSendFormModelArr[2] = new DefaultFormModel(R.string.header_form_last_name, R.string.hint_form_last_name, str, i2, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                ReceiverFormFragment.getAuthRequestContext(ReceiverFormFragment.this, "LAST_NAME", str2);
            }
        }, R.string.txt_last_name, z, MapsKt.mapOf(TuplesKt.to(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$4
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                return Boolean.valueOf(str2.length() > 0);
            }
        }, Integer.valueOf(R.string.error_empty_last_name)), TuplesKt.to(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$5
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                FormValidationUtil formValidationUtil = FormValidationUtil.INSTANCE;
                return Boolean.valueOf(FormValidationUtil.getAuthRequestContext(str2));
            }
        }, Integer.valueOf(R.string.res_0x7f1306f6_flowviewutil_textchanges_1))), i3, z2, i4, defaultConstructorMarker);
        globalSendFormModelArr[3] = new DefaultFormModel(R.string.header_form_email, R.string.hint_form_email, str, 7, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$9
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                ReceiverFormFragment.getAuthRequestContext(ReceiverFormFragment.this, SubtitleType.EMAIL, str2);
            }
        }, R.string.txt_email, z, MapsKt.mapOf(TuplesKt.to(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$7
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                return Boolean.valueOf(str2.length() > 0);
            }
        }, Integer.valueOf(R.string.error_empty_email)), TuplesKt.to(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$8
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                FormValidationUtil formValidationUtil = FormValidationUtil.INSTANCE;
                return Boolean.valueOf(FormValidationUtil.KClassImpl$Data$declaredNonStaticMembers$2((CharSequence) str2));
            }
        }, Integer.valueOf(R.string.error_message_form_email))), 0, false, 836, defaultConstructorMarker);
        globalSendFormModelArr[4] = new DefaultFormModel(R.string.header_form_address, R.string.hint_form_address, str, 18, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$11
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                ReceiverFormFragment.getAuthRequestContext(ReceiverFormFragment.this, "ADDRESS", str2);
            }
        }, R.string.txt_email, z, MapsKt.mapOf(TuplesKt.to(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$10
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                return Boolean.valueOf(str2.length() > 0);
            }
        }, Integer.valueOf(R.string.error_empty_address))), 84, true, 68, defaultConstructorMarker);
        int i5 = R.string.txt_email;
        int i6 = R.string.header_form_country_province;
        int i7 = R.string.hint_form_country_province;
        String string = receiverFormFragment.getString(R.string.error_message_form_province);
        List list3 = list2;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(new GlobalSendFormOptionModel(((ProvinceModel) it.next()).PlaceComponentResult, null, false, 6, null));
        }
        Intrinsics.checkNotNullExpressionValue(string, "");
        globalSendFormModelArr[5] = new ProvinceFormModel(i6, i7, string, new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$13
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                return Boolean.valueOf(str2.length() > 0);
            }
        }, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$14
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                Object obj;
                List<CityModel> emptyList;
                Intrinsics.checkNotNullParameter(str2, "");
                ReceiverFormFragment.getAuthRequestContext(ReceiverFormFragment.this, "PROVINCE", str2);
                ReceiverFormFragment.getAuthRequestContext(ReceiverFormFragment.this, "CITY", "");
                VB vb2 = ReceiverFormFragment.this.PlaceComponentResult;
                if (vb2 != 0) {
                    GlobalSendDynamicFormView globalSendDynamicFormView2 = ((FragmentReceiverFormBinding) vb2).getErrorConfigVersion;
                    Iterator<T> it2 = list2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        if (Intrinsics.areEqual(((ProvinceModel) obj).PlaceComponentResult, str2)) {
                            break;
                        }
                    }
                    ProvinceModel provinceModel = (ProvinceModel) obj;
                    if (provinceModel == null || (emptyList = provinceModel.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                        emptyList = CollectionsKt.emptyList();
                    }
                    globalSendDynamicFormView2.setCityViewTypeOptionsList(emptyList);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }, i5, false, arrayList, 64, null);
        int i8 = R.string.txt_email;
        int i9 = R.string.header_form_city;
        int i10 = R.string.hint_form_city;
        String string2 = receiverFormFragment.getString(R.string.error_message_form_city);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        globalSendFormModelArr[6] = new CityFormModel(i9, i10, string2, new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$15
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                return Boolean.valueOf(str2.length() > 0);
            }
        }, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideReceiverForms$formList$16
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                ReceiverFormFragment.getAuthRequestContext(ReceiverFormFragment.this, "CITY", str2);
            }
        }, i8, false, null, 192, null);
        globalSendDynamicFormView.setupForm(CollectionsKt.mutableListOf(globalSendFormModelArr), receiverFormFragment.getChildFragmentManager());
        VB vb2 = receiverFormFragment.PlaceComponentResult;
        if (vb2 == 0) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        GlobalSendDynamicFormView globalSendDynamicFormView2 = ((FragmentReceiverFormBinding) vb2).scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(globalSendDynamicFormView2, "");
        ArrayList arrayList2 = new ArrayList();
        List list4 = list;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        Iterator it2 = list4.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((SubTransferMethodInfoModel) it2.next()).moveToNextValue);
        }
        ArrayList arrayList4 = arrayList3;
        if (arrayList4.contains(GlobalSendTransferDestinationType.DEBIT_CARD)) {
            arrayList2.add(new EnabledTransferToDebitModel(R.string.res_0x7f1316d2_r8_lambda_gxtix1gdajl8esng4zkannb4tb0, R.string.res_0x7f13060c_summaryvoucherview_externalsyntheticlambda2, R.drawable.res_0x7f0808d7_networkuserentitydata_externalsyntheticlambda6, new DefaultFormModel(R.string.header_form_debit_card_no, R.string.hint_form_debit_card_no, null, 13, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideTransferDestinationForms$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str2) {
                    Intrinsics.checkNotNullParameter(str2, "");
                    ReceiverFormFragment.getAuthRequestContext(ReceiverFormFragment.this, "RECEIVER_CARD_NUMBER", str2);
                }
            }, R.string.res_0x7f131818_r8_lambda_zxhmsujxtx99vyz6bmhxqp1wkc8, false, MapsKt.mapOf(TuplesKt.to(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideTransferDestinationForms$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String str2) {
                    Intrinsics.checkNotNullParameter(str2, "");
                    FormValidationUtil formValidationUtil = FormValidationUtil.INSTANCE;
                    return Boolean.valueOf(FormValidationUtil.MyBillsEntityDataFactory(str2));
                }
            }, Integer.valueOf(R.string.error_16_digit)), TuplesKt.to(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideTransferDestinationForms$2
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String str2) {
                    Intrinsics.checkNotNullParameter(str2, "");
                    FormValidationUtil formValidationUtil = FormValidationUtil.INSTANCE;
                    return Boolean.valueOf(FormValidationUtil.KClassImpl$Data$declaredNonStaticMembers$2(str2));
                }
            }, Integer.valueOf(R.string.debit_card_error_message)), TuplesKt.to(new Function1<String, Boolean>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$provideTransferDestinationForms$3
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String str2) {
                    Intrinsics.checkNotNullParameter(str2, "");
                    FormValidationUtil formValidationUtil = FormValidationUtil.INSTANCE;
                    return Boolean.valueOf(FormValidationUtil.BuiltInFictitiousFunctionClassFactory(str2));
                }
            }, Integer.valueOf(R.string.error_visa_card_only))), 0, false, 836, null)));
        } else {
            arrayList2.add(new DisabledTransferDestinationFormModel(R.string.res_0x7f1316d2_r8_lambda_gxtix1gdajl8esng4zkannb4tb0, R.drawable.res_0x7f0808d7_networkuserentitydata_externalsyntheticlambda6));
        }
        if (arrayList4.contains("BANK")) {
            arrayList2.add(new EnabledTransferToDebitModel(R.string.res_0x7f1316d0_daggeremergencynotifcomponent_emergencynotifcomponentimpl, R.string.desc_dest_bank_account, R.drawable.ic_dest_bank_account, new DefaultFormModel(R.string.header_form_debit_card_no, R.string.hint_form_debit_card_no, null, 0, null, R.string.res_0x7f131818_r8_lambda_zxhmsujxtx99vyz6bmhxqp1wkc8, false, null, 0, false, 988, null)));
        } else {
            arrayList2.add(new DisabledTransferDestinationFormModel(R.string.res_0x7f1316d0_daggeremergencynotifcomponent_emergencynotifcomponentimpl, R.drawable.ic_dest_bank_account));
        }
        if (arrayList4.contains(GlobalSendTransferDestinationType.E_WALLET)) {
            arrayList2.add(new EnabledTransferToDebitModel(R.string.getGnBenefitEntityDanaProtection, R.string.desc_dest_ewallet, R.drawable.FragmentBottomSheetPaymentSettingBinding, new DefaultFormModel(R.string.header_form_debit_card_no, R.string.hint_form_debit_card_no, null, 0, null, R.string.res_0x7f131818_r8_lambda_zxhmsujxtx99vyz6bmhxqp1wkc8, false, null, 0, false, 988, null)));
        } else {
            arrayList2.add(new DisabledTransferDestinationFormModel(R.string.getGnBenefitEntityDanaProtection, R.drawable.FragmentBottomSheetPaymentSettingBinding));
        }
        if (arrayList4.contains("CASH")) {
            arrayList2.add(new EnabledTransferToDebitModel(R.string.res_0x7f1316d1_submitreceiptresultmodel_creator, R.string.res_0x7f13060b_summaryvoucherview_externalsyntheticlambda0, R.drawable.res_0x7f0808d6_networkuserentitydata_externalsyntheticlambda3, new DefaultFormModel(R.string.header_form_debit_card_no, R.string.hint_form_debit_card_no, null, 0, null, R.string.res_0x7f131818_r8_lambda_zxhmsujxtx99vyz6bmhxqp1wkc8, false, null, 0, false, 988, null)));
        } else {
            arrayList2.add(new DisabledTransferDestinationFormModel(R.string.res_0x7f1316d1_submitreceiptresultmodel_creator, R.drawable.res_0x7f0808d6_networkuserentitydata_externalsyntheticlambda3));
        }
        GlobalSendDynamicFormView.setupForm$default(globalSendDynamicFormView2, arrayList2, null, 2, null);
        if ((!list.isEmpty()) != false) {
            receiverFormFragment.initRecordTimeStamp = (SubTransferMethodInfoModel) list.get(0);
        }
        globalSendDynamicFormView2.setOnTransferDestinationItemSelected(new Function1<Integer, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$setupReceiverForm$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i11) {
                CountryModel countryModel2;
                CurrencyRateModel currencyRateModel2 = list.get(i11).lookAheadTest;
                int i12 = R.string.header_form_country_destination;
                countryModel2 = receiverFormFragment.MyBillsEntityDataFactory;
                if (countryModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    countryModel2 = null;
                }
                CountryFormModel countryFormModel = new CountryFormModel(i12, countryModel2, currencyRateModel2);
                VB vb3 = receiverFormFragment.PlaceComponentResult;
                if (vb3 != 0) {
                    ((FragmentReceiverFormBinding) vb3).getErrorConfigVersion.changeExchangeRate(countryFormModel);
                    receiverFormFragment.initRecordTimeStamp = list.get(i11);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        });
    }

    public static final /* synthetic */ void GetContactSyncConfig(ReceiverFormFragment receiverFormFragment) {
        VB vb = receiverFormFragment.PlaceComponentResult;
        if (vb != 0) {
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(((FragmentReceiverFormBinding) vb).getErrorConfigVersion);
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_section_recipient_form_skeleton;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), ShimmeringUtil.BuiltInFictitiousFunctionClassFactory());
            byte b = 0;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
            ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, b);
            viewSkeletonScreen.MyBillsEntityDataFactory();
            receiverFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = viewSkeletonScreen;
            VB vb2 = receiverFormFragment.PlaceComponentResult;
            if (vb2 != 0) {
                ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory2 = Skeleton.BuiltInFictitiousFunctionClassFactory(((FragmentReceiverFormBinding) vb2).scheduleImpl);
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext = R.layout.view_transfer_destination_form_skeleton;
                BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult = 1500;
                BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                ShimmeringUtil shimmeringUtil2 = ShimmeringUtil.INSTANCE;
                BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2.lookAheadTest.getContext(), ShimmeringUtil.BuiltInFictitiousFunctionClassFactory());
                BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = 0;
                ViewSkeletonScreen viewSkeletonScreen2 = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory2, b);
                viewSkeletonScreen2.MyBillsEntityDataFactory();
                receiverFormFragment.DatabaseTableConfigUtil = viewSkeletonScreen2;
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ReceiverFormFragment receiverFormFragment, boolean z) {
        VB vb = receiverFormFragment.PlaceComponentResult;
        if (vb != 0) {
            NestedScrollView nestedScrollView = ((FragmentReceiverFormBinding) vb).moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
            nestedScrollView.setVisibility(z ^ true ? 0 : 8);
            VB vb2 = receiverFormFragment.PlaceComponentResult;
            if (vb2 != 0) {
                EmptyStateView emptyStateView = ((FragmentReceiverFormBinding) vb2).MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(emptyStateView, "");
                emptyStateView.setVisibility(z ? 0 : 8);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void MyBillsEntityDataFactory() {
        ReceiverFormViewModel receiverFormViewModel = (ReceiverFormViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue();
        CountryModel countryModel = this.MyBillsEntityDataFactory;
        CountryModel countryModel2 = null;
        if (countryModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            countryModel = null;
        }
        String str = countryModel.getAuthRequestContext;
        CountryModel countryModel3 = this.MyBillsEntityDataFactory;
        if (countryModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            countryModel2 = countryModel3;
        }
        receiverFormViewModel.PlaceComponentResult(str, countryModel2.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void FragmentBottomSheetPaymentSettingBinding() {
        CountryModel countryModel;
        CountryModel countryModel2;
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.di.provider.GlobalSendComponentProvider");
        }
        GlobalSendComponent authRequestContext = ((GlobalSendComponentProvider) applicationContext).provideGlobalSendComponent().getAuthRequestContext();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
        authRequestContext.MyBillsEntityDataFactory(this);
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (OSUtil.PlaceComponentResult()) {
            Bundle arguments = getArguments();
            if (arguments != null && (countryModel2 = (CountryModel) arguments.getParcelable("COUNTRY_MODEL", CountryModel.class)) != null) {
                this.MyBillsEntityDataFactory = countryModel2;
            }
        } else {
            Bundle arguments2 = getArguments();
            if (arguments2 != null && (countryModel = (CountryModel) arguments2.getParcelable("COUNTRY_MODEL")) != null) {
                this.MyBillsEntityDataFactory = countryModel;
            }
        }
        Bundle arguments3 = getArguments();
        GlobalSendTrackerHelper globalSendTrackerHelper = null;
        String string = arguments3 != null ? arguments3.getString(GlobalSendFormActivity.PAGE_SOURCE) : null;
        if (string == null) {
            string = "";
        }
        this.moveToNextValue = string;
        Map<String, String> map = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        map.put("FIRST_NAME", "");
        map.put("LAST_NAME", "");
        map.put(SubtitleType.EMAIL, "");
        map.put("ADDRESS", "");
        map.put("PROVINCE", "");
        map.put("CITY", "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.put("RECEIVER_CARD_NUMBER", "");
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentReceiverFormBinding) vb).getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReceiverFormFragment.getAuthRequestContext(ReceiverFormFragment.this);
                }
            });
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentReceiverFormBinding) vb2).MyBillsEntityDataFactory.setOnBottomActionClickListener(new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment$initViews$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ReceiverFormFragment.this.MyBillsEntityDataFactory();
                    }
                });
                ((ReceiverFormViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda1.getValue()).getAuthRequestContext(new FormValidatorModel(this.NetworkUserEntityData$$ExternalSyntheticLambda0, BuiltInFictitiousFunctionClassFactory()));
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(this), null, null, new ReceiverFormFragment$initLifecycleFragment$1(this, null), 3, null);
                MyBillsEntityDataFactory();
                GlobalSendTrackerHelper globalSendTrackerHelper2 = this.globalSendTrackerHelper;
                if (globalSendTrackerHelper2 != null) {
                    globalSendTrackerHelper = globalSendTrackerHelper2;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                globalSendTrackerHelper.PlaceComponentResult();
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
