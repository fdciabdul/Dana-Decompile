package id.dana.sendmoney.ui.globalsend.form.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.view.LifecycleOwnerKt;
import androidx.view.OnBackPressedCallback;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelProvider;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.utils.SizeUtil;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.core.ui.richview.NumpadView;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.core.ui.util.MaskedTextUtil;
import id.dana.core.ui.util.NumberFormatterUtil;
import id.dana.core.ui.util.NumberUtil;
import id.dana.core.ui.util.ShimmeringUtil;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.network.util.DanaH5Helper;
import id.dana.sendmoney.R;
import id.dana.sendmoney.constants.GlobalSendTransferDestinationType;
import id.dana.sendmoney.databinding.FragmentAmountFormBinding;
import id.dana.sendmoney.di.component.GlobalSendComponent;
import id.dana.sendmoney.di.provider.GlobalSendComponentProvider;
import id.dana.sendmoney.domain.globalsend.interactor.TransferSubmit;
import id.dana.sendmoney.domain.globalsend.model.transfersubmit.response.TransferSubmitResult;
import id.dana.sendmoney.ui.common.EmptyStateView;
import id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity;
import id.dana.sendmoney.ui.globalsend.form.model.BeneficiaryInfoModel;
import id.dana.sendmoney.ui.globalsend.form.model.CurrencyRateModel;
import id.dana.sendmoney.ui.globalsend.form.model.GlobalTransferInitModel;
import id.dana.sendmoney.ui.globalsend.form.model.SubTransferMethodInfoModel;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.amount.FundSourceFormModel;
import id.dana.sendmoney.ui.globalsend.form.model.form.amount.TransactionPurposeFormModel;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.AmountFormUiState;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.AmountFormViewModel;
import id.dana.sendmoney.util.GlobalSendTrackerHelper;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 Q2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\bP\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0006\u0010\u000eJ7\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0006\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0013\u0010\u0005J-\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0004\u0010\u0019J\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u001f\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0006\u0010\u001bJ\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0004\u0010\u001cJ\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u001d2\u0006\u0010\b\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0004\u0010\u001eR\u0016\u0010\u001a\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u001fR\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\"R\u0016\u0010\u0004\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010#R\u0016\u0010\u0006\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010#R\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010'\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010#R\u0016\u0010$\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010#R\u0013\u0010%\u001a\u00020)X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b*\u0010+R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020-0,X\u0006¢\u0006\u0006\n\u0004\b'\u0010.R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020/0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104R\u0012\u00106\u001a\u000205X\u0087\"¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00100\u001a\u00020\u00158\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u00108\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010(\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b1\u0010;R\u0016\u0010*\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010;R\u0014\u0010<\u001a\u00020=8WX\u0096\u0006¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0013\u0010A\u001a\u00020\tX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b@\u0010+R\u0016\u0010:\u001a\u00020B8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bC\u0010DR\u0013\u0010G\u001a\u00020EX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bF\u0010+R\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020/0,8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010.R\u0012\u0010J\u001a\u00020IX\u0087\"¢\u0006\u0006\n\u0004\bJ\u0010KR\u001e\u0010M\u001a\n\u0012\u0004\u0012\u00020L\u0018\u00010,8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bM\u0010.R\u0013\u0010@\u001a\u00020NX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bO\u0010+"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/fragment/AmountFormFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/sendmoney/databinding/FragmentAmountFormBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "MyBillsEntityDataFactory", "", "p0", "", "PlaceComponentResult", "(D)Ljava/lang/String;", "", "p1", "(ZLjava/lang/String;)V", "p2", "p3", "p4", "(DDDLjava/lang/String;Ljava/lang/String;)V", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;", "(Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;Ljava/lang/String;Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;D)V", "(Z)V", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "Lid/dana/core/ui/richview/CurrencyEditText;", "(Lid/dana/core/ui/richview/CurrencyEditText;Ljava/lang/String;)V", "Lid/dana/sendmoney/ui/globalsend/form/model/BeneficiaryInfoModel;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/view/View;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Ljava/lang/String;", "getErrorConfigVersion", "moveToNextValue", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "initRecordTimeStamp", "Lid/dana/core/ui/dialog/DanaLogoLoadingDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lkotlin/Lazy;", "", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "Ljava/util/List;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;", "GetContactSyncConfig", "lookAheadTest", "Lid/dana/sendmoney/di/component/GlobalSendComponent;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/sendmoney/di/component/GlobalSendComponent;", "Lid/dana/sendmoney/util/GlobalSendTrackerHelper;", "globalSendTrackerHelper", "Lid/dana/sendmoney/util/GlobalSendTrackerHelper;", "DatabaseTableConfigUtil", "Lid/dana/sendmoney/ui/globalsend/form/model/GlobalTransferInitModel;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Z", "isLayoutRequested", "Landroidx/activity/OnBackPressedCallback;", "E", "()Landroidx/activity/OnBackPressedCallback;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "PrepareContext", "Lid/dana/sendmoney/ui/globalsend/form/model/CurrencyRateModel;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/sendmoney/ui/globalsend/form/model/CurrencyRateModel;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda8", "newProxyInstance", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormViewModel;", "whenAvailable", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AmountFormFragment extends BaseViewBindingFragment<FragmentAmountFormBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private GlobalTransferInitModel GetContactSyncConfig;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private final List<GlobalSendFormOptionModel> newProxyInstance;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final List<GlobalSendFormOptionModel> lookAheadTest;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public BeneficiaryInfoModel getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    BottomSheetBehavior<View> PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final List<GlobalSendFormModel> scheduleImpl;
    private GlobalSendComponent NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda8;
    private List<? extends SkeletonScreen> NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private CurrencyRateModel NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private boolean DatabaseTableConfigUtil;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;
    @Inject
    public GlobalSendTrackerHelper globalSendTrackerHelper;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String getErrorConfigVersion;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public boolean initRecordTimeStamp;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public ViewModelFactory viewModelFactory;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda6 = LazyKt.lazy(new Function0<AmountFormViewModel>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$vm$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AmountFormViewModel invoke() {
            AmountFormFragment amountFormFragment = AmountFormFragment.this;
            AmountFormFragment amountFormFragment2 = amountFormFragment;
            ViewModelFactory viewModelFactory = amountFormFragment.viewModelFactory;
            if (viewModelFactory == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                viewModelFactory = null;
            }
            return (AmountFormViewModel) new ViewModelProvider(amountFormFragment2, viewModelFactory).MyBillsEntityDataFactory(AmountFormViewModel.class);
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final Lazy PrepareContext = LazyKt.lazy(new Function0<String>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$pageSource$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Bundle arguments = AmountFormFragment.this.getArguments();
            String string = arguments != null ? arguments.getString(GlobalSendFormActivity.PAGE_SOURCE) : null;
            return string == null ? "" : string;
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy moveToNextValue = LazyKt.lazy(new Function0<DanaLogoLoadingDialog>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$danaLogoLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLogoLoadingDialog invoke() {
            Context requireContext = AmountFormFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            return new DanaLogoLoadingDialog(requireContext);
        }
    });

    public AmountFormFragment() {
        List<GlobalSendFormOptionModel> listOf = CollectionsKt.listOf((Object[]) new GlobalSendFormOptionModel[]{new GlobalSendFormOptionModel("Salary", Integer.valueOf(R.drawable.ic_fund_source_salary), true), new GlobalSendFormOptionModel("Savings", Integer.valueOf(R.drawable.ic_fund_source_savings), false, 4, null), new GlobalSendFormOptionModel("Loan", Integer.valueOf(R.drawable.ic_fund_source_loan), false, 4, null), new GlobalSendFormOptionModel("Gift", Integer.valueOf(R.drawable.ic_fund_source_gift), false, 4, null), new GlobalSendFormOptionModel("Retirement", Integer.valueOf(R.drawable.res_0x7f08092c_bottomsheetcardbindingview_watchercardnumberview_1), false, 4, null), new GlobalSendFormOptionModel("Inheritance", Integer.valueOf(R.drawable.ic_fund_source_inheritance), false, 4, null), new GlobalSendFormOptionModel("Donation", Integer.valueOf(R.drawable.ic_fund_source_donation), false, 4, null)});
        this.lookAheadTest = listOf;
        Integer num = null;
        boolean z = false;
        int i = 6;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Integer num2 = null;
        boolean z2 = false;
        int i2 = 6;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        List<GlobalSendFormOptionModel> listOf2 = CollectionsKt.listOf((Object[]) new GlobalSendFormOptionModel[]{new GlobalSendFormOptionModel("Family Needs", null, false, 6, null), new GlobalSendFormOptionModel("Health", num, z, i, defaultConstructorMarker), new GlobalSendFormOptionModel("Gift", num2, z2, i2, defaultConstructorMarker2), new GlobalSendFormOptionModel("Loan", num, z, i, defaultConstructorMarker), new GlobalSendFormOptionModel("Personal", num2, z2, i2, defaultConstructorMarker2)});
        this.newProxyInstance = listOf2;
        this.scheduleImpl = CollectionsKt.listOf((Object[]) new GlobalSendFormModel[]{new FundSourceFormModel(listOf), new TransactionPurposeFormModel(listOf2)});
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = GlobalNetworkConstants.IDR_CURRENCY;
        this.MyBillsEntityDataFactory = "USD";
        this.getErrorConfigVersion = "Rp";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "$";
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$transactionFeeDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialDialog invoke() {
                FragmentActivity activity = AmountFormFragment.this.getActivity();
                if (activity == null) {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity");
                }
                CustomDialog.Builder builder = new CustomDialog.Builder((GlobalSendFormActivity) activity);
                builder.SubSequence = AmountFormFragment.this.getString(R.string.transaction_fee_information_title);
                builder.GetContactSyncConfig = AmountFormFragment.this.getString(R.string.transaction_fee_information_description);
                CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(AmountFormFragment.this.getString(R.string.res_0x7f13165f_trackerkey_globalsearchopenproperties), new Function1<View, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$transactionFeeDialog$2.1
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
                BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = AmountFormFragment.this.getString(R.string.res_0x7f13030b_networkuserentitydata_externalsyntheticlambda6);
                return BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentAmountFormBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentAmountFormBinding MyBillsEntityDataFactory = FragmentAmountFormBinding.MyBillsEntityDataFactory(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    @JvmName(name = "E")
    /* renamed from: E */
    public final OnBackPressedCallback getBuiltInFictitiousFunctionClassFactory() {
        return new AmountFormFragment$onBackPressedCallback$1(this);
    }

    public static void BuiltInFictitiousFunctionClassFactory(CurrencyEditText currencyEditText, String str) {
        currencyEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, (!(str.length() > 0) || str.contentEquals("0")) ? 0 : R.drawable.res_0x7f08084c_networkuserentitydata_externalsyntheticlambda7, 0);
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(CurrencyEditText currencyEditText, AmountFormFragment amountFormFragment, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(currencyEditText, "");
        Intrinsics.checkNotNullParameter(amountFormFragment, "");
        Intrinsics.checkNotNullParameter(motionEvent, "");
        if (currencyEditText.getCompoundDrawables()[2] == null || motionEvent.getRawX() < currencyEditText.getRight() - currencyEditText.getCompoundDrawables()[2].getBounds().width() || currencyEditText.getText() == null) {
            currencyEditText.performClick();
            return false;
        }
        VB vb = amountFormFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentAmountFormBinding) vb).B.setText("");
            VB vb2 = amountFormFragment.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentAmountFormBinding) vb2).A.setText("");
                VB vb3 = amountFormFragment.PlaceComponentResult;
                if (vb3 != 0) {
                    AppCompatTextView appCompatTextView = ((FragmentAmountFormBinding) vb3).BottomSheetCardBindingView$watcherCardNumberView$1;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                    appCompatTextView.setVisibility(8);
                    VB vb4 = amountFormFragment.PlaceComponentResult;
                    if (vb4 != 0) {
                        ((FragmentAmountFormBinding) vb4).J.clearAmount();
                        amountFormFragment.BuiltInFictitiousFunctionClassFactory(true);
                        amountFormFragment.PlaceComponentResult();
                        VB vb5 = amountFormFragment.PlaceComponentResult;
                        if (vb5 != 0) {
                            DanaButtonPrimaryView danaButtonPrimaryView = ((FragmentAmountFormBinding) vb5).getAuthRequestContext;
                            danaButtonPrimaryView.setDisabled(amountFormFragment.getString(R.string.button_done));
                            danaButtonPrimaryView.setEnabled(false);
                            amountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
                            amountFormFragment.MyBillsEntityDataFactory();
                            return true;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        CurrencyRateModel currencyRateModel = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        GlobalTransferInitModel globalTransferInitModel = null;
        if (currencyRateModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            currencyRateModel = null;
        }
        double parseDouble = Double.parseDouble(currencyRateModel.BuiltInFictitiousFunctionClassFactory) / 100.0d;
        GlobalTransferInitModel globalTransferInitModel2 = this.GetContactSyncConfig;
        if (globalTransferInitModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalTransferInitModel2 = null;
        }
        String unformatedAmount = globalTransferInitModel2.getAuthRequestContext.getUnformatedAmount();
        if (unformatedAmount == null) {
            unformatedAmount = "0";
        }
        GlobalTransferInitModel globalTransferInitModel3 = this.GetContactSyncConfig;
        if (globalTransferInitModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalTransferInitModel3 = null;
        }
        String unformatedAmount2 = globalTransferInitModel3.KClassImpl$Data$declaredNonStaticMembers$2.getUnformatedAmount();
        String str = unformatedAmount2 != null ? unformatedAmount2 : "0";
        if (Intrinsics.areEqual(this.MyBillsEntityDataFactory, GlobalNetworkConstants.IDR_CURRENCY)) {
            KClassImpl$Data$declaredNonStaticMembers$2(p0, Math.ceil(parseDouble));
            double ceil = Math.ceil(Double.parseDouble(unformatedAmount) / parseDouble);
            double floor = Math.floor(Double.parseDouble(str) / parseDouble);
            double parseDouble2 = Double.parseDouble(p0);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.min_send_amount_error_message);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{this.getErrorConfigVersion, PlaceComponentResult(ceil)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "");
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = getString(R.string.max_send_amount_error_message);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{this.getErrorConfigVersion, PlaceComponentResult(floor)}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "");
            MyBillsEntityDataFactory(parseDouble2, ceil, floor, format, format2);
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(p0, 1.0d / Math.ceil(parseDouble));
        double parseDouble3 = Double.parseDouble(p0);
        double parseDouble4 = Double.parseDouble(unformatedAmount);
        double parseDouble5 = Double.parseDouble(str);
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String string3 = getString(R.string.min_send_amount_error_message_idr);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        Object[] objArr = new Object[1];
        GlobalTransferInitModel globalTransferInitModel4 = this.GetContactSyncConfig;
        if (globalTransferInitModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalTransferInitModel4 = null;
        }
        objArr[0] = globalTransferInitModel4.getAuthRequestContext.getCurrencyAndAmountValue();
        String format3 = String.format(string3, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "");
        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
        String string4 = getString(R.string.max_send_amount_error_message_idr);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        Object[] objArr2 = new Object[1];
        GlobalTransferInitModel globalTransferInitModel5 = this.GetContactSyncConfig;
        if (globalTransferInitModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            globalTransferInitModel = globalTransferInitModel5;
        }
        objArr2[0] = globalTransferInitModel.KClassImpl$Data$declaredNonStaticMembers$2.getCurrencyAndAmountValue();
        String format4 = String.format(string4, Arrays.copyOf(objArr2, 1));
        Intrinsics.checkNotNullExpressionValue(format4, "");
        MyBillsEntityDataFactory(parseDouble3, parseDouble4, parseDouble5, format3, format4);
    }

    private final void MyBillsEntityDataFactory(double p0, double p1, double p2, String p3, String p4) {
        boolean z = false;
        if (p0 < p1) {
            MyBillsEntityDataFactory(true, p3);
        } else if (p0 > p2) {
            MyBillsEntityDataFactory(true, p4);
        } else {
            MyBillsEntityDataFactory(false, "");
            z = true;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = z;
        MyBillsEntityDataFactory();
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        int BuiltInFictitiousFunctionClassFactory;
        int i;
        if (p0) {
            BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), R.color.initRecordTimeStamp);
        } else {
            BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), R.color.getErrorConfigVersion);
        }
        if (p0) {
            i = R.drawable.bg_card_rounded_stroke_yellow40_4dp;
        } else {
            i = R.drawable.bg_card_rounded_stroke_grey30_4dp;
        }
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentAmountFormBinding) vb).VerifyPinStateManager$executeRiskChallenge$2$1.setTextColor(BuiltInFictitiousFunctionClassFactory);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentAmountFormBinding) vb2).getErrorConfigVersion.setBackgroundResource(i);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, double p1) {
        String PlaceComponentResult;
        String format;
        double parseDouble = Double.parseDouble(p0) * p1;
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            TextView textView = ((FragmentAmountFormBinding) vb).A;
            if (Intrinsics.areEqual(this.MyBillsEntityDataFactory, GlobalNetworkConstants.IDR_CURRENCY)) {
                format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(parseDouble);
                PlaceComponentResult = format != null ? StringsKt.replace$default(format, ",", ".", false, 4, (Object) null) : null;
            } else {
                PlaceComponentResult = PlaceComponentResult(parseDouble);
            }
            textView.setText(PlaceComponentResult);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private static String PlaceComponentResult(double p0) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(new Locale("de", "DE"));
        if (numberInstance != null) {
            DecimalFormat decimalFormat = (DecimalFormat) numberInstance;
            decimalFormat.applyPattern("###,###.##");
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
            String format = decimalFormat.format(p0);
            Intrinsics.checkNotNullExpressionValue(format, "");
            return format;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.text.DecimalFormat");
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        GlobalTransferInitModel globalTransferInitModel = this.GetContactSyncConfig;
        CurrencyRateModel currencyRateModel = null;
        if (globalTransferInitModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalTransferInitModel = null;
        }
        Object obj = null;
        boolean z = false;
        for (Object obj2 : globalTransferInitModel.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            if (Intrinsics.areEqual(((SubTransferMethodInfoModel) obj2).moveToNextValue, GlobalSendTransferDestinationType.DEBIT_CARD)) {
                if (z) {
                    throw new IllegalArgumentException("Collection contains more than one matching element.");
                }
                z = true;
                obj = obj2;
            }
        }
        if (z) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = ((SubTransferMethodInfoModel) obj).lookAheadTest;
            BeneficiaryInfoModel beneficiaryInfoModel = this.getAuthRequestContext;
            if (beneficiaryInfoModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                beneficiaryInfoModel = null;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = beneficiaryInfoModel.moveToNextValue;
            this.MyBillsEntityDataFactory = GlobalNetworkConstants.IDR_CURRENCY;
            CurrencyRateModel currencyRateModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (currencyRateModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                currencyRateModel2 = null;
            }
            this.getErrorConfigVersion = currencyRateModel2.KClassImpl$Data$declaredNonStaticMembers$2.getCurrency();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = "Rp";
            MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.MyBillsEntityDataFactory);
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                DanaButtonPrimaryView danaButtonPrimaryView = ((FragmentAmountFormBinding) vb).MyBillsEntityDataFactory;
                danaButtonPrimaryView.setDisabled(getString(R.string.button_continue));
                danaButtonPrimaryView.setEnabled(false);
                VB vb2 = this.PlaceComponentResult;
                if (vb2 != 0) {
                    TextView textView = ((FragmentAmountFormBinding) vb2).AppCompatEmojiTextHelper;
                    GlobalTransferInitModel globalTransferInitModel2 = this.GetContactSyncConfig;
                    if (globalTransferInitModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        globalTransferInitModel2 = null;
                    }
                    textView.setText(globalTransferInitModel2.PlaceComponentResult.getCurrencyAndAmountValue());
                    VB vb3 = this.PlaceComponentResult;
                    if (vb3 != 0) {
                        TextView textView2 = ((FragmentAmountFormBinding) vb3).E;
                        Locale BuiltInFictitiousFunctionClassFactory = LocaleUtil.BuiltInFictitiousFunctionClassFactory();
                        CurrencyRateModel currencyRateModel3 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                        if (currencyRateModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            currencyRateModel3 = null;
                        }
                        int ceil = (int) Math.ceil(Double.parseDouble(currencyRateModel3.getAuthRequestContext) / 100.0d);
                        CurrencyRateModel currencyRateModel4 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                        if (currencyRateModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            currencyRateModel4 = null;
                        }
                        textView2.setText(NumberFormatterUtil.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory, ceil, currencyRateModel4.KClassImpl$Data$declaredNonStaticMembers$2.getCurrency()));
                        VB vb4 = this.PlaceComponentResult;
                        if (vb4 != 0) {
                            TextView textView3 = ((FragmentAmountFormBinding) vb4).G;
                            Locale BuiltInFictitiousFunctionClassFactory2 = LocaleUtil.BuiltInFictitiousFunctionClassFactory();
                            CurrencyRateModel currencyRateModel5 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                            if (currencyRateModel5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                currencyRateModel5 = null;
                            }
                            int ceil2 = (int) Math.ceil(Double.parseDouble(currencyRateModel5.BuiltInFictitiousFunctionClassFactory) / 100.0d);
                            CurrencyRateModel currencyRateModel6 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                            if (currencyRateModel6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                            } else {
                                currencyRateModel = currencyRateModel6;
                            }
                            textView3.setText(NumberFormatterUtil.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2, ceil2, currencyRateModel.PlaceComponentResult.getCurrency()));
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final void PlaceComponentResult(BeneficiaryInfoModel p0, String p1, GlobalTransferInitModel p2, boolean p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.getAuthRequestContext = p0;
        this.BuiltInFictitiousFunctionClassFactory = p1;
        this.GetContactSyncConfig = p2;
        this.initRecordTimeStamp = p3;
    }

    public final void PlaceComponentResult(boolean p0) {
        BottomSheetBehavior<View> bottomSheetBehavior = this.PlaceComponentResult;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setDraggable(!p0);
        }
        BottomSheetBehavior<View> bottomSheetBehavior2 = this.PlaceComponentResult;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.setHideable(!p0);
        }
        if (p0) {
            KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2(getActivity());
            BottomSheetBehavior<View> bottomSheetBehavior3 = this.PlaceComponentResult;
            if (bottomSheetBehavior3 != null) {
                bottomSheetBehavior3.setState(3);
                return;
            }
            return;
        }
        BottomSheetBehavior<View> bottomSheetBehavior4 = this.PlaceComponentResult;
        if (bottomSheetBehavior4 != null) {
            bottomSheetBehavior4.setState(5);
        }
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentAmountFormBinding) vb).B.clearFocus();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/fragment/AmountFormFragment$Companion;", "", "", "p0", "Lid/dana/sendmoney/ui/globalsend/form/fragment/AmountFormFragment;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lid/dana/sendmoney/ui/globalsend/form/fragment/AmountFormFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static AmountFormFragment BuiltInFictitiousFunctionClassFactory(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            AmountFormFragment amountFormFragment = new AmountFormFragment();
            amountFormFragment.setArguments(BundleKt.PlaceComponentResult(TuplesKt.to(GlobalSendFormActivity.PAGE_SOURCE, p0)));
            return amountFormFragment;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(AmountFormFragment amountFormFragment) {
        Intrinsics.checkNotNullParameter(amountFormFragment, "");
        VB vb = amountFormFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentAmountFormBinding) vb).B.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            VB vb2 = amountFormFragment.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentAmountFormBinding) vb2).B.clearFocus();
                amountFormFragment.PlaceComponentResult(false);
                VB vb3 = amountFormFragment.PlaceComponentResult;
                if (vb3 != 0) {
                    AppCompatTextView appCompatTextView = ((FragmentAmountFormBinding) vb3).BottomSheetCardBindingView$watcherCardNumberView$1;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                    if (appCompatTextView.getVisibility() == 0) {
                        return;
                    }
                    VB vb4 = amountFormFragment.PlaceComponentResult;
                    if (vb4 != 0) {
                        ((FragmentAmountFormBinding) vb4).VerifyPinStateManager$executeRiskChallenge$2$1.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(amountFormFragment.requireContext(), R.color.getErrorConfigVersion));
                        VB vb5 = amountFormFragment.PlaceComponentResult;
                        if (vb5 != 0) {
                            ((FragmentAmountFormBinding) vb5).getErrorConfigVersion.setBackgroundResource(R.drawable.bg_card_rounded_stroke_grey30_4dp);
                            amountFormFragment.PlaceComponentResult();
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(AmountFormFragment amountFormFragment) {
        Intrinsics.checkNotNullParameter(amountFormFragment, "");
        String str = amountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
        String str2 = amountFormFragment.getErrorConfigVersion;
        VB vb = amountFormFragment.PlaceComponentResult;
        if (vb != 0) {
            String valueOf = String.valueOf(((FragmentAmountFormBinding) vb).B.getText());
            VB vb2 = amountFormFragment.PlaceComponentResult;
            if (vb2 != 0) {
                String obj = ((FragmentAmountFormBinding) vb2).A.getText().toString();
                String str3 = amountFormFragment.MyBillsEntityDataFactory;
                String str4 = amountFormFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                amountFormFragment.MyBillsEntityDataFactory = str;
                amountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = str3;
                amountFormFragment.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
                amountFormFragment.getErrorConfigVersion = str4;
                amountFormFragment.MyBillsEntityDataFactory(str3, str);
                if (obj.length() == 0) {
                    return;
                }
                if (valueOf.length() == 0) {
                    return;
                }
                String valueOf2 = String.valueOf((long) Math.floor(Double.parseDouble(StringsKt.replace$default(StringsKt.replace$default(obj, ".", "", false, 4, (Object) null), ",", ".", false, 4, (Object) null))));
                if (valueOf2.length() == 0) {
                    valueOf2 = "0";
                }
                String str5 = valueOf2;
                NumberUtil numberUtil = NumberUtil.INSTANCE;
                String BuiltInFictitiousFunctionClassFactory = NumberUtil.BuiltInFictitiousFunctionClassFactory(valueOf);
                amountFormFragment.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory : "0");
                VB vb3 = amountFormFragment.PlaceComponentResult;
                if (vb3 != 0) {
                    ((FragmentAmountFormBinding) vb3).B.setPrefixedAmount(Long.parseLong(str5));
                    VB vb4 = amountFormFragment.PlaceComponentResult;
                    if (vb4 != 0) {
                        ((FragmentAmountFormBinding) vb4).J.setAmount(str5);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void PlaceComponentResult(AmountFormFragment amountFormFragment) {
        Intrinsics.checkNotNullParameter(amountFormFragment, "");
        ((MaterialDialog) amountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda8.getValue()).show();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final AmountFormFragment amountFormFragment, CurrencyEditText currencyEditText, boolean z) {
        Intrinsics.checkNotNullParameter(amountFormFragment, "");
        Intrinsics.checkNotNullParameter(currencyEditText, "");
        if (z) {
            amountFormFragment.PlaceComponentResult(true);
            VB vb = amountFormFragment.PlaceComponentResult;
            if (vb != 0) {
                AppCompatTextView appCompatTextView = ((FragmentAmountFormBinding) vb).BottomSheetCardBindingView$watcherCardNumberView$1;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                if (!(appCompatTextView.getVisibility() == 0)) {
                    amountFormFragment.BuiltInFictitiousFunctionClassFactory(true);
                    amountFormFragment.PlaceComponentResult();
                }
                BuiltInFictitiousFunctionClassFactory(currencyEditText, String.valueOf(currencyEditText.getText()));
                VB vb2 = amountFormFragment.PlaceComponentResult;
                if (vb2 != 0) {
                    ((FragmentAmountFormBinding) vb2).J.setListener(new NumpadView.NumpadClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$addAmountSourceFormFocusListener$1$1
                        @Override // id.dana.core.ui.richview.NumpadView.NumpadClickListener
                        public final void MyBillsEntityDataFactory(String p0) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            String str = p0;
                            if (!(str.length() == 0) && !Intrinsics.areEqual(p0, "0")) {
                                AmountFormFragment.PlaceComponentResult(AmountFormFragment.this, p0);
                                AmountFormFragment.this.BuiltInFictitiousFunctionClassFactory(p0);
                                AmountFormFragment.lookAheadTest(AmountFormFragment.this);
                                return;
                            }
                            VB vb3 = AmountFormFragment.this.PlaceComponentResult;
                            if (vb3 != 0) {
                                ((FragmentAmountFormBinding) vb3).B.setText(str);
                                VB vb4 = AmountFormFragment.this.PlaceComponentResult;
                                if (vb4 != 0) {
                                    ((FragmentAmountFormBinding) vb4).A.setText(str);
                                    VB vb5 = AmountFormFragment.this.PlaceComponentResult;
                                    if (vb5 != 0) {
                                        AppCompatTextView appCompatTextView2 = ((FragmentAmountFormBinding) vb5).BottomSheetCardBindingView$watcherCardNumberView$1;
                                        Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
                                        appCompatTextView2.setVisibility(8);
                                        AmountFormFragment.this.BuiltInFictitiousFunctionClassFactory(true);
                                        AmountFormFragment.this.PlaceComponentResult();
                                        AmountFormFragment.getErrorConfigVersion(AmountFormFragment.this);
                                        return;
                                    }
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    });
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        VB vb3 = amountFormFragment.PlaceComponentResult;
        if (vb3 != 0) {
            AppCompatTextView appCompatTextView2 = ((FragmentAmountFormBinding) vb3).BottomSheetCardBindingView$watcherCardNumberView$1;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
            if (appCompatTextView2.getVisibility() == 0) {
                return;
            }
            amountFormFragment.BuiltInFictitiousFunctionClassFactory(false);
            amountFormFragment.PlaceComponentResult();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(AmountFormFragment amountFormFragment) {
        Intrinsics.checkNotNullParameter(amountFormFragment, "");
        amountFormFragment.MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(AmountFormFragment amountFormFragment) {
        Editable text;
        Editable text2;
        Intrinsics.checkNotNullParameter(amountFormFragment, "");
        if (Intrinsics.areEqual(amountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0, GlobalNetworkConstants.IDR_CURRENCY)) {
            VB vb = amountFormFragment.PlaceComponentResult;
            if (vb != 0) {
                text = ((FragmentAmountFormBinding) vb).B.getText();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            VB vb2 = amountFormFragment.PlaceComponentResult;
            if (vb2 != 0) {
                text = ((FragmentAmountFormBinding) vb2).A.getText();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        if (Intrinsics.areEqual(amountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0, GlobalNetworkConstants.IDR_CURRENCY)) {
            VB vb3 = amountFormFragment.PlaceComponentResult;
            if (vb3 != 0) {
                text2 = ((FragmentAmountFormBinding) vb3).A.getText();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            VB vb4 = amountFormFragment.PlaceComponentResult;
            if (vb4 != 0) {
                text2 = ((FragmentAmountFormBinding) vb4).B.getText();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        final AmountFormViewModel amountFormViewModel = (AmountFormViewModel) amountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda6.getValue();
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        String KClassImpl$Data$declaredNonStaticMembers$2 = NumberUtil.KClassImpl$Data$declaredNonStaticMembers$2(String.valueOf(text));
        NumberUtil numberUtil2 = NumberUtil.INSTANCE;
        String replace$default = StringsKt.replace$default(NumberUtil.KClassImpl$Data$declaredNonStaticMembers$2(String.valueOf(text2)), ",", ".", false, 4, (Object) null);
        BeneficiaryInfoModel beneficiaryInfoModel = amountFormFragment.getAuthRequestContext;
        if (beneficiaryInfoModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            beneficiaryInfoModel = null;
        }
        String str = beneficiaryInfoModel.MyBillsEntityDataFactory;
        VB vb5 = amountFormFragment.PlaceComponentResult;
        if (vb5 != 0) {
            String valueOf = String.valueOf(((FragmentAmountFormBinding) vb5).NetworkUserEntityData$$ExternalSyntheticLambda8.getText());
            Intrinsics.checkNotNullParameter("GLOBAL_TRANSFER", "");
            Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
            Intrinsics.checkNotNullParameter(replace$default, "");
            Intrinsics.checkNotNullParameter(str, "");
            amountFormViewModel.BuiltInFictitiousFunctionClassFactory.execute(new TransferSubmit.Param(KClassImpl$Data$declaredNonStaticMembers$2, replace$default, "GLOBAL_TRANSFER", str, valueOf), new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.AmountFormViewModel$initTransferSubmit$1
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
                    mutableStateFlow = AmountFormViewModel.this.getAuthRequestContext;
                    do {
                        value = mutableStateFlow.getValue();
                        AmountFormUiState amountFormUiState = (AmountFormUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new AmountFormUiState.DanaLoading(true)));
                }
            }, new Function1<TransferSubmitResult, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.AmountFormViewModel$initTransferSubmit$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(TransferSubmitResult transferSubmitResult) {
                    invoke2(transferSubmitResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(TransferSubmitResult transferSubmitResult) {
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    Intrinsics.checkNotNullParameter(transferSubmitResult, "");
                    if (transferSubmitResult.MyBillsEntityDataFactory != null) {
                        mutableStateFlow = AmountFormViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            AmountFormUiState amountFormUiState = (AmountFormUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new AmountFormUiState.OnSuccessTransferSubmit(transferSubmitResult.MyBillsEntityDataFactory)));
                    }
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.AmountFormViewModel$initTransferSubmit$3
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
                    Intrinsics.checkNotNullParameter(th, "");
                    String message = th.getMessage();
                    if (message != null) {
                        mutableStateFlow = AmountFormViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            AmountFormUiState amountFormUiState = (AmountFormUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new AmountFormUiState.OnErrorTransferSubmit(message)));
                    }
                }
            }, new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.viewmodel.AmountFormViewModel$initTransferSubmit$4
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
                    mutableStateFlow = AmountFormViewModel.this.getAuthRequestContext;
                    do {
                        value = mutableStateFlow.getValue();
                        AmountFormUiState amountFormUiState = (AmountFormUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new AmountFormUiState.DanaLoading(false)));
                }
            }, ViewModelKt.PlaceComponentResult(amountFormViewModel));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void getErrorConfigVersion(AmountFormFragment amountFormFragment) {
        VB vb = amountFormFragment.PlaceComponentResult;
        if (vb != 0) {
            DanaButtonPrimaryView danaButtonPrimaryView = ((FragmentAmountFormBinding) vb).getAuthRequestContext;
            danaButtonPrimaryView.setDisabled(amountFormFragment.getString(R.string.button_done));
            danaButtonPrimaryView.setEnabled(false);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void moveToNextValue(AmountFormFragment amountFormFragment) {
        ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
        ShimmeringUtil.BuiltInFictitiousFunctionClassFactory(amountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda4);
        VB vb = amountFormFragment.PlaceComponentResult;
        if (vb != 0) {
            CircleImageView circleImageView = ((FragmentAmountFormBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda6;
            Intrinsics.checkNotNullExpressionValue(circleImageView, "");
            circleImageView.setVisibility(0);
            VB vb2 = amountFormFragment.PlaceComponentResult;
            if (vb2 != 0) {
                TextView textView = ((FragmentAmountFormBinding) vb2).getOnBoardingScenario;
                Intrinsics.checkNotNullExpressionValue(textView, "");
                textView.setVisibility(0);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void lookAheadTest(final AmountFormFragment amountFormFragment) {
        VB vb = amountFormFragment.PlaceComponentResult;
        if (vb != 0) {
            DanaButtonPrimaryView danaButtonPrimaryView = ((FragmentAmountFormBinding) vb).getAuthRequestContext;
            danaButtonPrimaryView.setActiveButton(amountFormFragment.getString(R.string.button_done), null);
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AmountFormFragment.getAuthRequestContext(AmountFormFragment.this);
                }
            });
            danaButtonPrimaryView.setEnabled(true);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ AmountFormViewModel NetworkUserEntityData$$ExternalSyntheticLambda1(AmountFormFragment amountFormFragment) {
        return (AmountFormViewModel) amountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda6.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x001e, code lost:
    
        if (r4.equals("DE15012088999102") == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0027, code lost:
    
        if (r4.equals("DE15012088999101") == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0030, code lost:
    
        if (r4.equals("DE15012088999100") == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0055, code lost:
    
        if (r4.equals("DE13112088999203") == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x005e, code lost:
    
        if (r4.equals("DE13112088999202") == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0067, code lost:
    
        if (r4.equals("DE13112088999201") == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0070, code lost:
    
        if (r4.equals("DE13112088999200") == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0079, code lost:
    
        if (r4.equals("DE13112088999113") == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0082, code lost:
    
        if (r4.equals("DE15112088999103") == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0091, code lost:
    
        r4 = id.dana.core.ui.util.DANAToast.BuiltInFictitiousFunctionClassFactory;
        r3 = r3.requireActivity();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "");
        id.dana.core.ui.util.DANAToast.MyBillsEntityDataFactory(r3, r5, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x009f, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void MyBillsEntityDataFactory(final id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment r3, java.lang.String r4, java.lang.String r5) {
        /*
            int r0 = r4.hashCode()
            java.lang.String r1 = ""
            r2 = -343200130(0xffffffffeb8b2e7e, float:-3.365205E26)
            if (r0 == r2) goto L7c
            r2 = 243605915(0xe85219b, float:3.2819392E-30)
            if (r0 == r2) goto L73
            switch(r0) {
                case -472282852: goto L2a;
                case -472282851: goto L21;
                case -472282850: goto L18;
                default: goto L13;
            }
        L13:
            switch(r0) {
                case 243606842: goto L6a;
                case 243606843: goto L61;
                case 243606844: goto L58;
                case 243606845: goto L4f;
                case 243606846: goto L33;
                default: goto L16;
            }
        L16:
            goto L84
        L18:
            java.lang.String r0 = "DE15012088999102"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L91
            goto L84
        L21:
            java.lang.String r0 = "DE15012088999101"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L91
            goto L84
        L2a:
            java.lang.String r0 = "DE15012088999100"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L91
            goto L84
        L33:
            java.lang.String r5 = "DE13112088999204"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L84
            id.dana.sendmoney.util.GlobalSendErrorHelper r4 = id.dana.sendmoney.util.GlobalSendErrorHelper.getAuthRequestContext
            android.content.Context r4 = r3.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$handleOnErrorWithCode$1 r5 = new id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$handleOnErrorWithCode$1
            r5.<init>()
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            id.dana.sendmoney.util.GlobalSendErrorHelper.getAuthRequestContext(r4, r5)
            return
        L4f:
            java.lang.String r0 = "DE13112088999203"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L91
            goto L84
        L58:
            java.lang.String r0 = "DE13112088999202"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L91
            goto L84
        L61:
            java.lang.String r0 = "DE13112088999201"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L91
            goto L84
        L6a:
            java.lang.String r0 = "DE13112088999200"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L91
            goto L84
        L73:
            java.lang.String r0 = "DE13112088999113"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L91
            goto L84
        L7c:
            java.lang.String r0 = "DE15112088999103"
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L91
        L84:
            id.dana.sendmoney.util.GlobalSendErrorHelper r4 = id.dana.sendmoney.util.GlobalSendErrorHelper.getAuthRequestContext
            android.content.Context r3 = r3.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            id.dana.sendmoney.util.GlobalSendErrorHelper.PlaceComponentResult(r3)
            return
        L91:
            id.dana.core.ui.util.DANAToast r4 = id.dana.core.ui.util.DANAToast.BuiltInFictitiousFunctionClassFactory
            androidx.fragment.app.FragmentActivity r3 = r3.requireActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            android.app.Activity r3 = (android.app.Activity) r3
            id.dana.core.ui.util.DANAToast.BuiltInFictitiousFunctionClassFactory(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment.MyBillsEntityDataFactory(id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment, java.lang.String, java.lang.String):void");
    }

    public static final /* synthetic */ void PlaceComponentResult(AmountFormFragment amountFormFragment, String str) {
        VB vb = amountFormFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentAmountFormBinding) vb).B.setPrefixedAmount(Long.parseLong(str));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void DatabaseTableConfigUtil(final AmountFormFragment amountFormFragment) {
        VB vb = amountFormFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentAmountFormBinding) vb).PrepareContext.setOnBottomActionClickListener(new Function0<Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$setErrorButtonGetInit$1
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
                    BeneficiaryInfoModel beneficiaryInfoModel;
                    BeneficiaryInfoModel beneficiaryInfoModel2;
                    AmountFormFragment.this.getAuthRequestContext(false);
                    AmountFormViewModel NetworkUserEntityData$$ExternalSyntheticLambda1 = AmountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(AmountFormFragment.this);
                    beneficiaryInfoModel = AmountFormFragment.this.getAuthRequestContext;
                    BeneficiaryInfoModel beneficiaryInfoModel3 = null;
                    if (beneficiaryInfoModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        beneficiaryInfoModel = null;
                    }
                    String str = beneficiaryInfoModel.lookAheadTest;
                    beneficiaryInfoModel2 = AmountFormFragment.this.getAuthRequestContext;
                    if (beneficiaryInfoModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        beneficiaryInfoModel3 = beneficiaryInfoModel2;
                    }
                    NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext(str, beneficiaryInfoModel3.moveToNextValue);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda8(AmountFormFragment amountFormFragment) {
        GlobalSendTrackerHelper globalSendTrackerHelper;
        double doubleValue;
        GlobalSendTrackerHelper globalSendTrackerHelper2 = amountFormFragment.globalSendTrackerHelper;
        BeneficiaryInfoModel beneficiaryInfoModel = null;
        if (globalSendTrackerHelper2 != null) {
            globalSendTrackerHelper = globalSendTrackerHelper2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
            globalSendTrackerHelper = null;
        }
        String str = (String) amountFormFragment.PrepareContext.getValue();
        if (!Intrinsics.areEqual(amountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda0, GlobalNetworkConstants.IDR_CURRENCY)) {
            if (Intrinsics.areEqual(amountFormFragment.MyBillsEntityDataFactory, GlobalNetworkConstants.IDR_CURRENCY)) {
                VB vb = amountFormFragment.PlaceComponentResult;
                if (vb != 0) {
                    Double doubleOrNull = StringsKt.toDoubleOrNull(((FragmentAmountFormBinding) vb).A.getText().toString());
                    if (doubleOrNull != null) {
                        doubleValue = doubleOrNull.doubleValue();
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            doubleValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            VB vb2 = amountFormFragment.PlaceComponentResult;
            if (vb2 != 0) {
                Double doubleOrNull2 = StringsKt.toDoubleOrNull(String.valueOf(((FragmentAmountFormBinding) vb2).B.getText()));
                if (doubleOrNull2 != null) {
                    doubleValue = doubleOrNull2.doubleValue();
                }
                doubleValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        BeneficiaryInfoModel beneficiaryInfoModel2 = amountFormFragment.getAuthRequestContext;
        if (beneficiaryInfoModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            beneficiaryInfoModel2 = null;
        }
        String str2 = beneficiaryInfoModel2.lookAheadTest;
        BeneficiaryInfoModel beneficiaryInfoModel3 = amountFormFragment.getAuthRequestContext;
        if (beneficiaryInfoModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            beneficiaryInfoModel = beneficiaryInfoModel3;
        }
        globalSendTrackerHelper.getAuthRequestContext(str, doubleValue, str2, beneficiaryInfoModel.MyBillsEntityDataFactory(), amountFormFragment.DatabaseTableConfigUtil);
    }

    public static final /* synthetic */ void newProxyInstance(AmountFormFragment amountFormFragment) {
        Pair[] pairArr = new Pair[4];
        VB vb = amountFormFragment.PlaceComponentResult;
        if (vb != 0) {
            pairArr[0] = new Pair(((FragmentAmountFormBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda4, Integer.valueOf(R.layout.view_skeleton_icon_bank));
            VB vb2 = amountFormFragment.PlaceComponentResult;
            if (vb2 != 0) {
                pairArr[1] = new Pair(((FragmentAmountFormBinding) vb2).getSupportButtonTintMode, Integer.valueOf(R.layout.view_account_name_skeleton));
                VB vb3 = amountFormFragment.PlaceComponentResult;
                if (vb3 != 0) {
                    pairArr[2] = new Pair(((FragmentAmountFormBinding) vb3).whenAvailable, Integer.valueOf(R.layout.view_number_account_skeleton));
                    VB vb4 = amountFormFragment.PlaceComponentResult;
                    if (vb4 != 0) {
                        pairArr[3] = new Pair(((FragmentAmountFormBinding) vb4).NetworkUserEntityData$$ExternalSyntheticLambda1, Integer.valueOf(R.layout.view_content_amount_form_skeleton));
                        HashMap hashMapOf = MapsKt.hashMapOf(pairArr);
                        VB vb5 = amountFormFragment.PlaceComponentResult;
                        if (vb5 != 0) {
                            CircleImageView circleImageView = ((FragmentAmountFormBinding) vb5).NetworkUserEntityData$$ExternalSyntheticLambda6;
                            Intrinsics.checkNotNullExpressionValue(circleImageView, "");
                            circleImageView.setVisibility(8);
                            VB vb6 = amountFormFragment.PlaceComponentResult;
                            if (vb6 != 0) {
                                TextView textView = ((FragmentAmountFormBinding) vb6).getOnBoardingScenario;
                                Intrinsics.checkNotNullExpressionValue(textView, "");
                                textView.setVisibility(8);
                                VB vb7 = amountFormFragment.PlaceComponentResult;
                                if (vb7 != 0) {
                                    DanaButtonPrimaryView danaButtonPrimaryView = ((FragmentAmountFormBinding) vb7).MyBillsEntityDataFactory;
                                    danaButtonPrimaryView.setDisabled(amountFormFragment.getString(R.string.button_continue));
                                    danaButtonPrimaryView.setEnabled(false);
                                    ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
                                    amountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda4 = ShimmeringUtil.MyBillsEntityDataFactory(hashMapOf, R.color.GetContactSyncConfig);
                                    ShimmeringUtil shimmeringUtil2 = ShimmeringUtil.INSTANCE;
                                    ShimmeringUtil.MyBillsEntityDataFactory(amountFormFragment.NetworkUserEntityData$$ExternalSyntheticLambda4);
                                    return;
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void PlaceComponentResult(AmountFormFragment amountFormFragment, boolean z) {
        if (!z) {
            ((DanaLogoLoadingDialog) amountFormFragment.moveToNextValue.getValue()).PlaceComponentResult();
            return;
        }
        DanaLogoLoadingDialog danaLogoLoadingDialog = (DanaLogoLoadingDialog) amountFormFragment.moveToNextValue.getValue();
        if (danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.isShowing()) {
            return;
        }
        danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.show();
        danaLogoLoadingDialog.MyBillsEntityDataFactory.startRefresh();
    }

    public final void MyBillsEntityDataFactory() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            if (((FragmentAmountFormBinding) vb).BuiltInFictitiousFunctionClassFactory.isChecked() && this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                VB vb2 = this.PlaceComponentResult;
                if (vb2 != 0) {
                    DanaButtonPrimaryView danaButtonPrimaryView = ((FragmentAmountFormBinding) vb2).MyBillsEntityDataFactory;
                    danaButtonPrimaryView.setActiveButton(getString(R.string.button_continue), null);
                    danaButtonPrimaryView.setEnabled(true);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            VB vb3 = this.PlaceComponentResult;
            if (vb3 != 0) {
                DanaButtonPrimaryView danaButtonPrimaryView2 = ((FragmentAmountFormBinding) vb3).MyBillsEntityDataFactory;
                danaButtonPrimaryView2.setDisabled(getString(R.string.button_continue));
                danaButtonPrimaryView2.setEnabled(false);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void MyBillsEntityDataFactory(boolean p0, String p1) {
        if (p0) {
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                ((FragmentAmountFormBinding) vb).BottomSheetCardBindingView$watcherCardNumberView$1.setVisibility(0);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentAmountFormBinding) vb2).BottomSheetCardBindingView$watcherCardNumberView$1.setVisibility(4);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        VB vb3 = this.PlaceComponentResult;
        if (vb3 != 0) {
            ((FragmentAmountFormBinding) vb3).BottomSheetCardBindingView$watcherCardNumberView$1.setText(p1);
            if (!p0) {
                BuiltInFictitiousFunctionClassFactory(true);
            } else {
                VB vb4 = this.PlaceComponentResult;
                if (vb4 != 0) {
                    ((FragmentAmountFormBinding) vb4).VerifyPinStateManager$executeRiskChallenge$2$1.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), R.color.NetworkUserEntityData$$ExternalSyntheticLambda0));
                    VB vb5 = this.PlaceComponentResult;
                    if (vb5 != 0) {
                        ((FragmentAmountFormBinding) vb5).getErrorConfigVersion.setBackgroundResource(R.drawable.bg_card_rounded_stroke_red_4dp);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            PlaceComponentResult();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void PlaceComponentResult() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentAmountFormBinding) vb).getErrorConfigVersion.setPadding(SizeUtil.PlaceComponentResult(16), SizeUtil.PlaceComponentResult(10), SizeUtil.PlaceComponentResult(16), SizeUtil.PlaceComponentResult(10));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void MyBillsEntityDataFactory(String p0, String p1) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            TextView textView = ((FragmentAmountFormBinding) vb).VerifyPinStateManager$executeRiskChallenge$2$1;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.nominal_currency_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[]{p0}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView.setText(format);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                TextView textView2 = ((FragmentAmountFormBinding) vb2).C;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String string2 = getString(R.string.nominal_currency_title);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{p1}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "");
                textView2.setText(format2);
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    TextView textView3 = ((FragmentAmountFormBinding) vb3).D;
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    String string3 = getString(R.string.currency_type);
                    Intrinsics.checkNotNullExpressionValue(string3, "");
                    String format3 = String.format(string3, Arrays.copyOf(new Object[]{p0}, 1));
                    Intrinsics.checkNotNullExpressionValue(format3, "");
                    textView3.setText(format3);
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        TextView textView4 = ((FragmentAmountFormBinding) vb4).VerifyPinStateManager$executeRiskChallenge$2$2;
                        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                        String string4 = getString(R.string.currency_type);
                        Intrinsics.checkNotNullExpressionValue(string4, "");
                        String format4 = String.format(string4, Arrays.copyOf(new Object[]{p1}, 1));
                        Intrinsics.checkNotNullExpressionValue(format4, "");
                        textView4.setText(format4);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void FragmentBottomSheetPaymentSettingBinding() {
        String KClassImpl$Data$declaredNonStaticMembers$2;
        Window window;
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            this.PlaceComponentResult = BottomSheetBehavior.from(((FragmentAmountFormBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda7);
            PlaceComponentResult(false);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentAmountFormBinding) vb2).MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AmountFormFragment.KClassImpl$Data$declaredNonStaticMembers$2(AmountFormFragment.this);
                    }
                });
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    ((FragmentAmountFormBinding) vb3).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            AmountFormFragment.MyBillsEntityDataFactory(AmountFormFragment.this);
                        }
                    });
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        TextView textView = ((FragmentAmountFormBinding) vb4).H;
                        textView.setMovementMethod(LinkMovementMethod.getInstance());
                        String string = getString(R.string.PrefetchDownloadStatus);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        String string2 = getString(R.string.text_terms_and_condition);
                        Intrinsics.checkNotNullExpressionValue(string2, "");
                        String str = string;
                        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, string2, 0, false, 6, (Object) null);
                        int length = string2.length() + indexOf$default;
                        SpannableString spannableString = new SpannableString(str);
                        spannableString.setSpan(new ClickableSpan() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$getClickableSpan$1
                            @Override // android.text.style.ClickableSpan
                            public final void onClick(View p0) {
                                Intrinsics.checkNotNullParameter(p0, "");
                                DanaH5Helper danaH5Helper = DanaH5Helper.INSTANCE;
                                FragmentActivity requireActivity = AmountFormFragment.this.requireActivity();
                                Intrinsics.checkNotNullExpressionValue(requireActivity, "");
                                danaH5Helper.openUrl(requireActivity, "https://a.m.dana.id/resource/htmls/tnc/directdebit_en_US.html");
                            }

                            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                            public final void updateDrawState(TextPaint p0) {
                                Intrinsics.checkNotNullParameter(p0, "");
                                p0.setUnderlineText(false);
                                p0.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(AmountFormFragment.this.requireContext(), R.color.getAuthRequestContext));
                            }
                        }, indexOf$default, length, 33);
                        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), R.color.getAuthRequestContext)), indexOf$default, length, 33);
                        textView.setText(spannableString);
                        VB vb5 = this.PlaceComponentResult;
                        if (vb5 != 0) {
                            ((FragmentAmountFormBinding) vb5).SubSequence.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$$ExternalSyntheticLambda3
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    AmountFormFragment.PlaceComponentResult(AmountFormFragment.this);
                                }
                            });
                            VB vb6 = this.PlaceComponentResult;
                            if (vb6 != 0) {
                                ((FragmentAmountFormBinding) vb6).BuiltInFictitiousFunctionClassFactory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$$ExternalSyntheticLambda4
                                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                        AmountFormFragment.BuiltInFictitiousFunctionClassFactory(AmountFormFragment.this);
                                    }
                                });
                                VB vb7 = this.PlaceComponentResult;
                                if (vb7 != 0) {
                                    final CurrencyEditText currencyEditText = ((FragmentAmountFormBinding) vb7).B;
                                    TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(currencyEditText, R.style.lookAheadTest);
                                    currencyEditText.disableSoftKeyboard();
                                    currencyEditText.setTextHint("0");
                                    currencyEditText.setUsePrefix(false);
                                    currencyEditText.setAllowEmpty(true);
                                    Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
                                    currencyEditText.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$$ExternalSyntheticLambda6
                                        @Override // android.view.View.OnTouchListener
                                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                                            boolean KClassImpl$Data$declaredNonStaticMembers$22;
                                            KClassImpl$Data$declaredNonStaticMembers$22 = AmountFormFragment.KClassImpl$Data$declaredNonStaticMembers$2(CurrencyEditText.this, this, motionEvent);
                                            return KClassImpl$Data$declaredNonStaticMembers$22;
                                        }
                                    });
                                    currencyEditText.addTextChangedListener(new TextWatcher() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$addAmountSourceFormTextChangedListener$1
                                        @Override // android.text.TextWatcher
                                        public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                                        }

                                        @Override // android.text.TextWatcher
                                        public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                                            boolean z = false;
                                            if (p0 != null) {
                                                if (p0.length() == 0) {
                                                    z = true;
                                                }
                                            }
                                            if (z) {
                                                VB vb8 = AmountFormFragment.this.PlaceComponentResult;
                                                if (vb8 != 0) {
                                                    ((FragmentAmountFormBinding) vb8).J.clearAmount();
                                                } else {
                                                    throw new IllegalArgumentException("Required value was null.".toString());
                                                }
                                            }
                                            AmountFormFragment.BuiltInFictitiousFunctionClassFactory(currencyEditText, String.valueOf(p0));
                                        }

                                        @Override // android.text.TextWatcher
                                        public final void afterTextChanged(Editable p0) {
                                            Editable editable = p0;
                                            if (editable == null || editable.length() == 0) {
                                                AmountFormFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
                                                AmountFormFragment.this.MyBillsEntityDataFactory();
                                                return;
                                            }
                                            NumberUtil numberUtil = NumberUtil.INSTANCE;
                                            String valueOf = String.valueOf(NumberUtil.BuiltInFictitiousFunctionClassFactory(p0.toString()));
                                            VB vb8 = AmountFormFragment.this.PlaceComponentResult;
                                            if (vb8 != 0) {
                                                ((FragmentAmountFormBinding) vb8).J.setAmount(valueOf);
                                                AmountFormFragment.this.BuiltInFictitiousFunctionClassFactory(valueOf);
                                                AmountFormFragment.lookAheadTest(AmountFormFragment.this);
                                                return;
                                            }
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                    });
                                    currencyEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$$ExternalSyntheticLambda0
                                        @Override // android.view.View.OnFocusChangeListener
                                        public final void onFocusChange(View view, boolean z) {
                                            AmountFormFragment.KClassImpl$Data$declaredNonStaticMembers$2(AmountFormFragment.this, currencyEditText, z);
                                        }
                                    });
                                    FragmentActivity activity = getActivity();
                                    BeneficiaryInfoModel beneficiaryInfoModel = null;
                                    KeyboardHelper.BuiltInFictitiousFunctionClassFactory((activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment$setupKeyboardListener$1
                                        @Override // id.dana.core.ui.util.KeyboardHelper.KeyboardVisibilityListener
                                        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                                        }

                                        @Override // id.dana.core.ui.util.KeyboardHelper.KeyboardVisibilityListener
                                        public final void MyBillsEntityDataFactory() {
                                            AmountFormFragment.this.PlaceComponentResult(false);
                                        }
                                    });
                                    Context applicationContext = requireActivity().getApplicationContext();
                                    if (applicationContext == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.di.provider.GlobalSendComponentProvider");
                                    }
                                    GlobalSendComponent authRequestContext = ((GlobalSendComponentProvider) applicationContext).provideGlobalSendComponent().getAuthRequestContext();
                                    this.NetworkUserEntityData$$ExternalSyntheticLambda2 = authRequestContext;
                                    authRequestContext.MyBillsEntityDataFactory(this);
                                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(this), null, null, new AmountFormFragment$initLifecycleFragment$1(this, null), 3, null);
                                    if (!this.initRecordTimeStamp) {
                                        BuiltInFictitiousFunctionClassFactory();
                                    } else {
                                        AmountFormViewModel amountFormViewModel = (AmountFormViewModel) this.NetworkUserEntityData$$ExternalSyntheticLambda6.getValue();
                                        BeneficiaryInfoModel beneficiaryInfoModel2 = this.getAuthRequestContext;
                                        if (beneficiaryInfoModel2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("");
                                            beneficiaryInfoModel2 = null;
                                        }
                                        String str2 = beneficiaryInfoModel2.lookAheadTest;
                                        BeneficiaryInfoModel beneficiaryInfoModel3 = this.getAuthRequestContext;
                                        if (beneficiaryInfoModel3 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("");
                                            beneficiaryInfoModel3 = null;
                                        }
                                        amountFormViewModel.getAuthRequestContext(str2, beneficiaryInfoModel3.moveToNextValue);
                                    }
                                    FragmentActivity activity2 = getActivity();
                                    GlobalSendFormActivity globalSendFormActivity = activity2 instanceof GlobalSendFormActivity ? (GlobalSendFormActivity) activity2 : null;
                                    if (globalSendFormActivity != null && globalSendFormActivity.getIsNewTransaction()) {
                                        VB vb8 = this.PlaceComponentResult;
                                        if (vb8 != 0) {
                                            TextView textView2 = ((FragmentAmountFormBinding) vb8).getSupportButtonTintMode;
                                            String str3 = this.BuiltInFictitiousFunctionClassFactory;
                                            if (str3 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("");
                                                str3 = null;
                                            }
                                            int length2 = str3.length();
                                            String str4 = "";
                                            for (int i = 0; i < length2; i++) {
                                                if (i % 4 == 0 && i != 0) {
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append(str4);
                                                    sb.append('-');
                                                    str4 = sb.toString();
                                                }
                                                StringBuilder sb2 = new StringBuilder();
                                                sb2.append(str4);
                                                String str5 = this.BuiltInFictitiousFunctionClassFactory;
                                                if (str5 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                                    str5 = null;
                                                }
                                                sb2.append(str5.charAt(i));
                                                str4 = sb2.toString();
                                            }
                                            textView2.setText(str4);
                                            VB vb9 = this.PlaceComponentResult;
                                            if (vb9 != 0) {
                                                TextView textView3 = ((FragmentAmountFormBinding) vb9).whenAvailable;
                                                BeneficiaryInfoModel beneficiaryInfoModel4 = this.getAuthRequestContext;
                                                if (beneficiaryInfoModel4 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                                    beneficiaryInfoModel4 = null;
                                                }
                                                if (beneficiaryInfoModel4.KClassImpl$Data$declaredNonStaticMembers$2().length() > 21) {
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append(StringsKt.take(beneficiaryInfoModel4.KClassImpl$Data$declaredNonStaticMembers$2(), 21));
                                                    sb3.append("...");
                                                    KClassImpl$Data$declaredNonStaticMembers$2 = sb3.toString();
                                                } else {
                                                    KClassImpl$Data$declaredNonStaticMembers$2 = beneficiaryInfoModel4.KClassImpl$Data$declaredNonStaticMembers$2();
                                                }
                                                StringBuilder sb4 = new StringBuilder();
                                                sb4.append(KClassImpl$Data$declaredNonStaticMembers$2);
                                                sb4.append(" | ");
                                                sb4.append(beneficiaryInfoModel4.MyBillsEntityDataFactory());
                                                textView3.setText(sb4.toString());
                                            } else {
                                                throw new IllegalArgumentException("Required value was null.".toString());
                                            }
                                        } else {
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                    } else {
                                        VB vb10 = this.PlaceComponentResult;
                                        if (vb10 != 0) {
                                            TextView textView4 = ((FragmentAmountFormBinding) vb10).getSupportButtonTintMode;
                                            BeneficiaryInfoModel beneficiaryInfoModel5 = this.getAuthRequestContext;
                                            if (beneficiaryInfoModel5 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("");
                                                beneficiaryInfoModel5 = null;
                                            }
                                            textView4.setText(beneficiaryInfoModel5.KClassImpl$Data$declaredNonStaticMembers$2());
                                            VB vb11 = this.PlaceComponentResult;
                                            if (vb11 != 0) {
                                                TextView textView5 = ((FragmentAmountFormBinding) vb11).whenAvailable;
                                                BeneficiaryInfoModel beneficiaryInfoModel6 = this.getAuthRequestContext;
                                                if (beneficiaryInfoModel6 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                                    beneficiaryInfoModel6 = null;
                                                }
                                                StringBuilder sb5 = new StringBuilder();
                                                MaskedTextUtil maskedTextUtil = MaskedTextUtil.INSTANCE;
                                                MaskedTextUtil maskedTextUtil2 = MaskedTextUtil.INSTANCE;
                                                sb5.append(MaskedTextUtil.getAuthRequestContext(MaskedTextUtil.MyBillsEntityDataFactory(beneficiaryInfoModel6.NetworkUserEntityData$$ExternalSyntheticLambda7)));
                                                sb5.append(" | ");
                                                sb5.append(beneficiaryInfoModel6.MyBillsEntityDataFactory());
                                                textView5.setText(sb5.toString());
                                            } else {
                                                throw new IllegalArgumentException("Required value was null.".toString());
                                            }
                                        } else {
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                    }
                                    VB vb12 = this.PlaceComponentResult;
                                    if (vb12 != 0) {
                                        ConstraintLayout constraintLayout = ((FragmentAmountFormBinding) vb12).NetworkUserEntityData$$ExternalSyntheticLambda0;
                                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                        String string3 = getString(R.string.icn_country_name_card_type);
                                        Intrinsics.checkNotNullExpressionValue(string3, "");
                                        Object[] objArr = new Object[2];
                                        BeneficiaryInfoModel beneficiaryInfoModel7 = this.getAuthRequestContext;
                                        if (beneficiaryInfoModel7 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("");
                                            beneficiaryInfoModel7 = null;
                                        }
                                        objArr[0] = beneficiaryInfoModel7.lookAheadTest;
                                        BeneficiaryInfoModel beneficiaryInfoModel8 = this.getAuthRequestContext;
                                        if (beneficiaryInfoModel8 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("");
                                            beneficiaryInfoModel8 = null;
                                        }
                                        objArr[1] = beneficiaryInfoModel8.getAuthRequestContext;
                                        String format = String.format(string3, Arrays.copyOf(objArr, 2));
                                        Intrinsics.checkNotNullExpressionValue(format, "");
                                        constraintLayout.setContentDescription(format);
                                        VB vb13 = this.PlaceComponentResult;
                                        if (vb13 != 0) {
                                            CircleImageView circleImageView = ((FragmentAmountFormBinding) vb13).NetworkUserEntityData$$ExternalSyntheticLambda6;
                                            Intrinsics.checkNotNullExpressionValue(circleImageView, "");
                                            CircleImageView circleImageView2 = circleImageView;
                                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                                            Object[] objArr2 = new Object[1];
                                            BeneficiaryInfoModel beneficiaryInfoModel9 = this.getAuthRequestContext;
                                            if (beneficiaryInfoModel9 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("");
                                            } else {
                                                beneficiaryInfoModel = beneficiaryInfoModel9;
                                            }
                                            objArr2[0] = beneficiaryInfoModel.lookAheadTest;
                                            String format2 = String.format("https://a.m.dana.id/resource/global-transfer/icons/country/%s-rounded.png", Arrays.copyOf(objArr2, 1));
                                            Intrinsics.checkNotNullExpressionValue(format2, "");
                                            GlideApp.getAuthRequestContext(circleImageView2.getContext()).PlaceComponentResult(format2).getErrorConfigVersion(R.drawable.ic_bank_placeholder).BuiltInFictitiousFunctionClassFactory((Transformation<Bitmap>) new CircleCrop()).PlaceComponentResult(R.drawable.ic_bank_placeholder).MyBillsEntityDataFactory((ImageView) circleImageView2);
                                            return;
                                        }
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void getAuthRequestContext(boolean p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            EmptyStateView emptyStateView = ((FragmentAmountFormBinding) vb).PrepareContext;
            Intrinsics.checkNotNullExpressionValue(emptyStateView, "");
            emptyStateView.setVisibility(p0 ? 0 : 8);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ConstraintLayout constraintLayout = ((FragmentAmountFormBinding) vb2).initRecordTimeStamp;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                boolean z = !p0;
                constraintLayout.setVisibility(z ? 0 : 8);
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    View view = ((FragmentAmountFormBinding) vb3).L;
                    Intrinsics.checkNotNullExpressionValue(view, "");
                    view.setVisibility(z ? 0 : 8);
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        NestedScrollView nestedScrollView = ((FragmentAmountFormBinding) vb4).getCallingPid;
                        Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
                        nestedScrollView.setVisibility(z ? 0 : 8);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
