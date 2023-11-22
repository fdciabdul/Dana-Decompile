package id.dana.sendmoney.ui.groupsend.summary.view;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelProvider;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.core.ui.util.DANAToast;
import id.dana.core.ui.util.ImagePickerUtil;
import id.dana.core.ui.util.PermissionHelper;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.FragmentImageChooserDialogBinding;
import id.dana.sendmoney.di.component.GroupSendComponent;
import id.dana.sendmoney.di.provider.GroupSendComponentProvider;
import id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendImagePickerViewModel;
import id.dana.sendmoney.util.GroupSendTrackerHelper;
import id.dana.sendmoney.util.SourceTypeProperty;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110(¢\u0006\u0004\b2\u00103J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0006\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0006\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\f\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000f\u001a\f\u0012\b\u0012\u0006*\u00020\u00030\u00030\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0013\u0010\u0012\u001a\u00020\u001dX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010\f\u001a\f\u0012\b\u0012\u0006*\u00020 0 0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001aR\u0016\u0010\t\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R\u0012\u0010&\u001a\u00020%X\u0087\"¢\u0006\u0006\n\u0004\b&\u0010'R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00110(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0012\u0010-\u001a\u00020,X\u0087\"¢\u0006\u0006\n\u0004\b-\u0010.R\u0013\u00101\u001a\u00020/X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b0\u0010\u001f"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/summary/view/BottomSheetImagePickerDialogFragment;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/sendmoney/databinding/FragmentImageChooserDialogBinding;", "Landroid/net/Uri;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/net/Uri;)I", "", "scheduleImpl", "()Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "onStart", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(Landroid/net/Uri;)V", "PlaceComponentResult", "Landroid/net/Uri;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "Lid/dana/core/ui/dialog/DanaLogoLoadingDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlin/Lazy;", "Landroid/content/Intent;", "initRecordTimeStamp", "Lid/dana/sendmoney/di/component/GroupSendComponent;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/sendmoney/di/component/GroupSendComponent;", "Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "groupSendTrackerHelper", "Lid/dana/sendmoney/util/GroupSendTrackerHelper;", "Lkotlin/Function1;", "GetContactSyncConfig", "Lkotlin/jvm/functions/Function1;", "lookAheadTest", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerViewModel;", "DatabaseTableConfigUtil", "moveToNextValue", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BottomSheetImagePickerDialogFragment extends BaseViewBindingBottomSheetDialogFragment<FragmentImageChooserDialogBinding> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy moveToNextValue;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Function1<String, Unit> lookAheadTest;
    private final ActivityResultLauncher<Uri> KClassImpl$Data$declaredNonStaticMembers$2;
    private final FragmentPermissionRequest MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private GroupSendComponent scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;
    private Uri PlaceComponentResult;
    @Inject
    public GroupSendTrackerHelper groupSendTrackerHelper;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> BuiltInFictitiousFunctionClassFactory;
    @Inject
    public ViewModelFactory viewModelFactory;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.48f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ FragmentImageChooserDialogBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentImageChooserDialogBinding BuiltInFictitiousFunctionClassFactory = FragmentImageChooserDialogBinding.BuiltInFictitiousFunctionClassFactory(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BottomSheetImagePickerDialogFragment(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.lookAheadTest = function1;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<DanaLogoLoadingDialog>() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment$danaLogoLoadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaLogoLoadingDialog invoke() {
                Context requireContext = BottomSheetImagePickerDialogFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                return new DanaLogoLoadingDialog(requireContext);
            }
        });
        this.moveToNextValue = LazyKt.lazy(new Function0<GroupSendImagePickerViewModel>() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GroupSendImagePickerViewModel invoke() {
                BottomSheetImagePickerDialogFragment bottomSheetImagePickerDialogFragment = BottomSheetImagePickerDialogFragment.this;
                BottomSheetImagePickerDialogFragment bottomSheetImagePickerDialogFragment2 = bottomSheetImagePickerDialogFragment;
                ViewModelFactory viewModelFactory = bottomSheetImagePickerDialogFragment.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return (GroupSendImagePickerViewModel) new ViewModelProvider(bottomSheetImagePickerDialogFragment2, viewModelFactory).MyBillsEntityDataFactory(GroupSendImagePickerViewModel.class);
            }
        });
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.CAMERA"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment$cameraPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    BottomSheetImagePickerDialogFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                Context requireContext = BottomSheetImagePickerDialogFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                PermissionHelper.BuiltInFictitiousFunctionClassFactory(requireContext);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.MyBillsEntityDataFactory = builder.PlaceComponentResult();
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment$$ExternalSyntheticLambda3
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BottomSheetImagePickerDialogFragment.getAuthRequestContext(BottomSheetImagePickerDialogFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.BuiltInFictitiousFunctionClassFactory = registerForActivityResult;
        ActivityResultLauncher<Uri> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.TakePicture(), new ActivityResultCallback() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment$$ExternalSyntheticLambda4
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BottomSheetImagePickerDialogFragment.getAuthRequestContext(BottomSheetImagePickerDialogFragment.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = registerForActivityResult2;
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

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            a_(PlaceComponentResult(dialog));
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney.di.provider.GroupSendComponentProvider");
        }
        GroupSendComponent authRequestContext = ((GroupSendComponentProvider) applicationContext).provideGroupSendComponent().getAuthRequestContext();
        this.scheduleImpl = authRequestContext;
        authRequestContext.MyBillsEntityDataFactory(this);
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((FragmentImageChooserDialogBinding) vb).getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BottomSheetImagePickerDialogFragment.MyBillsEntityDataFactory(BottomSheetImagePickerDialogFragment.this);
                }
            });
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                ((FragmentImageChooserDialogBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BottomSheetImagePickerDialogFragment.PlaceComponentResult(BottomSheetImagePickerDialogFragment.this);
                    }
                });
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    ((FragmentImageChooserDialogBinding) vb3).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BottomSheetImagePickerDialogFragment.BuiltInFictitiousFunctionClassFactory(BottomSheetImagePickerDialogFragment.this);
                        }
                    });
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(this), null, null, new BottomSheetImagePickerDialogFragment$initLifecycleFragment$1(this, null), 3, null);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        ImagePickerUtil imagePickerUtil = ImagePickerUtil.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        Uri KClassImpl$Data$declaredNonStaticMembers$2 = ImagePickerUtil.KClassImpl$Data$declaredNonStaticMembers$2(requireContext);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2;
            ActivityResultLauncher<Uri> activityResultLauncher = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }
            activityResultLauncher.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2, null);
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(Uri p0) {
        ContentResolver contentResolver;
        InputStream openInputStream;
        GroupSendTrackerHelper groupSendTrackerHelper = null;
        try {
            Context context = getContext();
            if (context == null || (contentResolver = context.getContentResolver()) == null || (openInputStream = contentResolver.openInputStream(p0)) == null) {
                return;
            }
            InputStream inputStream = openInputStream;
            try {
                ((GroupSendImagePickerViewModel) this.moveToNextValue.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(ByteStreamsKt.readBytes(inputStream), scheduleImpl(), MyBillsEntityDataFactory(p0));
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(inputStream, null);
            } finally {
            }
        } catch (IOException e) {
            String string = getString(R.string.SchedulerPoolFactory);
            Intrinsics.checkNotNullExpressionValue(string, "");
            DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "");
            DANAToast.MyBillsEntityDataFactory(requireActivity, string, "");
            GroupSendTrackerHelper groupSendTrackerHelper2 = this.groupSendTrackerHelper;
            if (groupSendTrackerHelper2 != null) {
                groupSendTrackerHelper = groupSendTrackerHelper2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            groupSendTrackerHelper.MyBillsEntityDataFactory(e, "", string, SourceTypeProperty.GROUP_SEND_UPLOAD_IMAGE);
        }
    }

    private static String scheduleImpl() {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append("IMG_");
        sb.append(format);
        sb.append(".jpg");
        return sb.toString();
    }

    private final int MyBillsEntityDataFactory(Uri p0) {
        ContentResolver contentResolver;
        Cursor query;
        Context context = getContext();
        if (context == null || (contentResolver = context.getContentResolver()) == null || (query = contentResolver.query(p0, null, null, null, null)) == null) {
            return 0;
        }
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            int columnIndex = cursor2.getColumnIndex("_size");
            cursor2.moveToFirst();
            int i = cursor2.getInt(columnIndex);
            CloseableKt.closeFinally(cursor, null);
            return i;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void PlaceComponentResult(final BottomSheetImagePickerDialogFragment bottomSheetImagePickerDialogFragment) {
        Intrinsics.checkNotNullParameter(bottomSheetImagePickerDialogFragment, "");
        Context requireContext = bottomSheetImagePickerDialogFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        if (PermissionHelper.MyBillsEntityDataFactory(requireContext, "android.permission.CAMERA")) {
            bottomSheetImagePickerDialogFragment.NetworkUserEntityData$$ExternalSyntheticLambda0();
            return;
        }
        Context requireContext2 = bottomSheetImagePickerDialogFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(requireContext2);
        builder.SubSequence = bottomSheetImagePickerDialogFragment.getString(R.string.dialog_camera_permission_title);
        builder.GetContactSyncConfig = bottomSheetImagePickerDialogFragment.getString(R.string.dialog_camera_permission_desc);
        builder.DatabaseTableConfigUtil = R.drawable.res_0x7f0807f8_networkuserentitydata_externalsyntheticlambda2;
        CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.BuiltInFictitiousFunctionClassFactory(bottomSheetImagePickerDialogFragment.getString(R.string.PlaceComponentResult), new Function1<View, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment$showCameraPermissionDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                FragmentPermissionRequest fragmentPermissionRequest;
                Intrinsics.checkNotNullParameter(view, "");
                fragmentPermissionRequest = BottomSheetImagePickerDialogFragment.this.MyBillsEntityDataFactory;
                fragmentPermissionRequest.check();
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(bottomSheetImagePickerDialogFragment.getString(R.string.cancel_text), new Function1<View, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment$showCameraPermissionDialog$2
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
        Context context = bottomSheetImagePickerDialogFragment.getContext();
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4 = context != null ? context.getString(R.string.btn_allow_camera) : null;
        Context context2 = bottomSheetImagePickerDialogFragment.getContext();
        KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance = context2 != null ? context2.getString(R.string.btn_cancel_camera) : null;
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory().show();
    }

    public static /* synthetic */ void getAuthRequestContext(BottomSheetImagePickerDialogFragment bottomSheetImagePickerDialogFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(bottomSheetImagePickerDialogFragment, "");
        Intrinsics.checkNotNullParameter(activityResult, "");
        Intent intent = activityResult.MyBillsEntityDataFactory;
        if (intent != null) {
            Uri data = intent.getData();
            if (data == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.Uri");
            }
            bottomSheetImagePickerDialogFragment.BuiltInFictitiousFunctionClassFactory(data);
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(BottomSheetImagePickerDialogFragment bottomSheetImagePickerDialogFragment) {
        Intrinsics.checkNotNullParameter(bottomSheetImagePickerDialogFragment, "");
        ActivityResultLauncher<Intent> activityResultLauncher = bottomSheetImagePickerDialogFragment.BuiltInFictitiousFunctionClassFactory;
        ImagePickerUtil imagePickerUtil = ImagePickerUtil.INSTANCE;
        activityResultLauncher.MyBillsEntityDataFactory(ImagePickerUtil.MyBillsEntityDataFactory(), null);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BottomSheetImagePickerDialogFragment bottomSheetImagePickerDialogFragment) {
        Intrinsics.checkNotNullParameter(bottomSheetImagePickerDialogFragment, "");
        bottomSheetImagePickerDialogFragment.dismiss();
    }

    public static /* synthetic */ void getAuthRequestContext(BottomSheetImagePickerDialogFragment bottomSheetImagePickerDialogFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(bottomSheetImagePickerDialogFragment, "");
        Intrinsics.checkNotNullExpressionValue(bool, "");
        if (bool.booleanValue()) {
            Uri uri = bottomSheetImagePickerDialogFragment.PlaceComponentResult;
            if (uri == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                uri = null;
            }
            bottomSheetImagePickerDialogFragment.BuiltInFictitiousFunctionClassFactory(uri);
        }
    }

    public static final /* synthetic */ DanaLogoLoadingDialog getAuthRequestContext(BottomSheetImagePickerDialogFragment bottomSheetImagePickerDialogFragment) {
        return (DanaLogoLoadingDialog) bottomSheetImagePickerDialogFragment.getAuthRequestContext.getValue();
    }

    public static final /* synthetic */ GroupSendImagePickerViewModel NetworkUserEntityData$$ExternalSyntheticLambda0(BottomSheetImagePickerDialogFragment bottomSheetImagePickerDialogFragment) {
        return (GroupSendImagePickerViewModel) bottomSheetImagePickerDialogFragment.moveToNextValue.getValue();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((FragmentImageChooserDialogBinding) vb).MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
