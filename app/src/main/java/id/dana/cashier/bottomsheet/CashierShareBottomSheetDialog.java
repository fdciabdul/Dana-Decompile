package id.dana.cashier.bottomsheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.dialogcomponent.CustomDialog$sam$android_view_View_OnClickListener$0;
import id.dana.richview.socialshare.SocialImageShareView;
import id.dana.richview.socialshare.model.SocialShareModel;
import id.dana.utils.OSUtil;
import id.dana.utils.permission.PermissionHelper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0018\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000f\u0010\nR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/cashier/bottomsheet/CashierShareBottomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/content/Context;", "p0", "onAttach", "(Landroid/content/Context;)V", "onShow", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "getErrorConfigVersion", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "getAuthRequestContext", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierShareBottomSheetDialog extends BaseBottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private FragmentPermissionRequest getAuthRequestContext;

    public final View MyBillsEntityDataFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.fragment_cashier_share_bottom_sheet_dialog;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("arg_image_filepath", "");
            Intrinsics.checkNotNullExpressionValue(string, "");
            this.MyBillsEntityDataFactory = string;
        }
        SocialImageShareView socialImageShareView = (SocialImageShareView) MyBillsEntityDataFactory(R.id.getUUIDFromString);
        if (socialImageShareView != null) {
            String str = this.MyBillsEntityDataFactory;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            }
            socialImageShareView.setImageFilePath(str);
            socialImageShareView.setSaveImageListener(new SocialImageShareView.SaveImageListener() { // from class: id.dana.cashier.bottomsheet.CashierShareBottomSheetDialog$initViews$1$1
                @Override // id.dana.richview.socialshare.SocialShareView.Listener
                public final void MyBillsEntityDataFactory(SocialShareModel p0) {
                }

                @Override // id.dana.richview.socialshare.SocialImageShareView.SaveImageListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                    CashierShareBottomSheetDialog.MyBillsEntityDataFactory(CashierShareBottomSheetDialog.this, p0);
                }

                @Override // id.dana.richview.socialshare.SocialImageShareView.SaveImageListener
                public final void MyBillsEntityDataFactory() {
                    FragmentPermissionRequest fragmentPermissionRequest;
                    if (OSUtil.MyBillsEntityDataFactory()) {
                        ((SocialImageShareView) CashierShareBottomSheetDialog.this.MyBillsEntityDataFactory(R.id.getUUIDFromString)).saveImage();
                        return;
                    }
                    fragmentPermissionRequest = CashierShareBottomSheetDialog.this.getAuthRequestContext;
                    if (fragmentPermissionRequest == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        fragmentPermissionRequest = null;
                    }
                    fragmentPermissionRequest.check();
                }
            });
            socialImageShareView.setEnableSaveButton(true);
            socialImageShareView.setEnableShareButton(true);
            socialImageShareView.setSocialShareViewTitle("");
            socialImageShareView.setSocialButtonText("");
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttach(p0);
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.cashier.bottomsheet.CashierShareBottomSheetDialog$initPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p02, boolean p1) {
                Intrinsics.checkNotNullParameter(p02, "");
                if (p02.MyBillsEntityDataFactory()) {
                    ((SocialImageShareView) CashierShareBottomSheetDialog.this.MyBillsEntityDataFactory(R.id.getUUIDFromString)).saveImage();
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                BaseActivity baseActivity = CashierShareBottomSheetDialog.this.getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                PermissionHelper.MyBillsEntityDataFactory(baseActivity);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                CashierShareBottomSheetDialog.PlaceComponentResult(CashierShareBottomSheetDialog.this, p02);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.getAuthRequestContext = builder.PlaceComponentResult();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/bottomsheet/CashierShareBottomSheetDialog$Companion;", "", "Landroid/os/Bundle;", "p0", "Lid/dana/cashier/bottomsheet/CashierShareBottomSheetDialog;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/os/Bundle;)Lid/dana/cashier/bottomsheet/CashierShareBottomSheetDialog;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static CashierShareBottomSheetDialog KClassImpl$Data$declaredNonStaticMembers$2(Bundle p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            CashierShareBottomSheetDialog cashierShareBottomSheetDialog = new CashierShareBottomSheetDialog();
            cashierShareBottomSheetDialog.setArguments(p0);
            return cashierShareBottomSheetDialog;
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CashierShareBottomSheetDialog cashierShareBottomSheetDialog, boolean z) {
        if (z) {
            CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
            BaseActivity baseActivity = cashierShareBottomSheetDialog.getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            String string = cashierShareBottomSheetDialog.getResources().getString(R.string.image_saved_to_gallery_success, cashierShareBottomSheetDialog.getString(R.string.invoice));
            Intrinsics.checkNotNullExpressionValue(string, "");
            CustomToast.MyBillsEntityDataFactory(baseActivity, R.drawable.ic_success, R.drawable.bg_rounded_border_green_50, string);
            return;
        }
        CustomToast customToast2 = CustomToast.MyBillsEntityDataFactory;
        BaseActivity baseActivity2 = cashierShareBottomSheetDialog.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity2, "");
        String string2 = cashierShareBottomSheetDialog.getResources().getString(R.string.image_saved_to_gallery_failed);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        CustomToast.MyBillsEntityDataFactory(baseActivity2, R.drawable.ic_warning_yellow, R.drawable.bg_rounded_border_yellow_50, string2);
    }

    public static final /* synthetic */ void PlaceComponentResult(CashierShareBottomSheetDialog cashierShareBottomSheetDialog, final PermissionRequest permissionRequest) {
        String str;
        String str2;
        BaseActivity baseActivity = cashierShareBottomSheetDialog.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(baseActivity);
        Context context = cashierShareBottomSheetDialog.getContext();
        if (context != null) {
            Object[] objArr = new Object[1];
            Context context2 = cashierShareBottomSheetDialog.getContext();
            objArr[0] = context2 != null ? context2.getString(R.string.invoice) : null;
            str = context.getString(R.string.allow_gallery_access_dialog_title, objArr);
        } else {
            str = null;
        }
        builder.SubSequence = str;
        Context context3 = cashierShareBottomSheetDialog.getContext();
        if (context3 != null) {
            Object[] objArr2 = new Object[1];
            Context context4 = cashierShareBottomSheetDialog.getContext();
            objArr2[0] = context4 != null ? context4.getString(R.string.invoice) : null;
            str2 = context3.getString(R.string.allow_gallery_access_dialog_message, objArr2);
        } else {
            str2 = null;
        }
        builder.GetContactSyncConfig = str2;
        builder.DatabaseTableConfigUtil = R.drawable.ic_illustration_general_gallery;
        builder.moveToNextValue = 0L;
        CustomDialog.Builder PlaceComponentResult = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
        Context context5 = cashierShareBottomSheetDialog.getContext();
        String string = context5 != null ? context5.getString(R.string.PlaceComponentResult) : null;
        Function1<View, Unit> function1 = new Function1<View, Unit>() { // from class: id.dana.cashier.bottomsheet.CashierShareBottomSheetDialog$showPermissionConsentDialog$1
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
                Intrinsics.checkNotNullParameter(view, "");
                PermissionRequest.this.continueToPermissionRequest();
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(function1);
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
        PlaceComponentResult.getSupportButtonTintMode = customDialog$sam$android_view_View_OnClickListener$0;
        Context context6 = cashierShareBottomSheetDialog.getContext();
        String string2 = context6 != null ? context6.getString(R.string.cancel_action) : null;
        CashierShareBottomSheetDialog$showPermissionConsentDialog$2 cashierShareBottomSheetDialog$showPermissionConsentDialog$2 = new Function1<View, Unit>() { // from class: id.dana.cashier.bottomsheet.CashierShareBottomSheetDialog$showPermissionConsentDialog$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        };
        Intrinsics.checkNotNullParameter(cashierShareBottomSheetDialog$showPermissionConsentDialog$2, "");
        CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$02 = new CustomDialog$sam$android_view_View_OnClickListener$0(cashierShareBottomSheetDialog$showPermissionConsentDialog$2);
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda7 = string2;
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8 = customDialog$sam$android_view_View_OnClickListener$02;
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory().show();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        FrameLayout frameLayout = (FrameLayout) MyBillsEntityDataFactory(R.id.phoneNumber);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
