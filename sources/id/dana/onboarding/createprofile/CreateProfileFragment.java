package id.dana.onboarding.createprofile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zhuinden.simplestack.History;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.base.KeyBaseActivity;
import id.dana.base.KeyBaseFragment;
import id.dana.base.MenuItemButtonListener;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.FragmentCreateProfileBinding;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.OnboardingNavigationManagerWithMenu;
import id.dana.onboarding.createpin.CreatePinKey;
import id.dana.onboarding.verify.VerifyNumberKey;
import id.dana.textbehavior.InvalidReason;
import id.dana.textbehavior.OnValidatedListener;
import id.dana.textbehavior.TextBehavior;
import id.dana.textbehavior.validate.Validator;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.RegistrationEvent;
import id.dana.utils.OSUtil;
import id.dana.utils.handpick.HandPicked;
import id.dana.utils.handpick.HandPickedResultHandler;
import id.dana.utils.permission.PermissionHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes9.dex */
public class CreateProfileFragment extends KeyBaseFragment<OnboardingActivity, CreateProfileKey, FragmentCreateProfileBinding> {
    final HandPicked MyBillsEntityDataFactory;
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;
    FragmentPermissionRequest PlaceComponentResult;
    private String getErrorConfigVersion;
    FragmentPermissionRequest lookAheadTest;
    OnboardingNavigationManagerWithMenu moveToNextValue;
    private String scheduleImpl;

    @Override // id.dana.base.BaseFragment
    public int getLayout() {
        return R.layout.fragment_create_profile;
    }

    public CreateProfileFragment() {
        HandPicked.Builder builder = new HandPicked.Builder(this);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = GriverEnv.getApplicationContext().getString(R.string.pick_profile_photo_title);
        builder.PlaceComponentResult = new HandPickedResultHandler() { // from class: id.dana.onboarding.createprofile.CreateProfileFragment.1
            @Override // id.dana.utils.handpick.HandPickedResultHandler
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Exception exc) {
            }

            @Override // id.dana.utils.handpick.HandPickedResultHandler
            public final void MyBillsEntityDataFactory(Uri uri, String str) {
                CreateProfileFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = uri.toString();
                CreateProfileFragment.this.getErrorConfigVersion = str;
                CreateProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2(CreateProfileFragment.this);
            }
        };
        builder.getAuthRequestContext = PermissionHelper.MyBillsEntityDataFactory(GriverEnv.getApplicationContext(), "android.permission.CAMERA");
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = PermissionHelper.getAuthRequestContext(GriverEnv.getApplicationContext());
        this.MyBillsEntityDataFactory = new HandPicked(builder, (byte) 0);
    }

    public static CreateProfileFragment getAuthRequestContext(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("phoneNumber", str);
        bundle.putString("referralCode", str2);
        CreateProfileFragment createProfileFragment = new CreateProfileFragment();
        createProfileFragment.setArguments(bundle);
        return createProfileFragment;
    }

    @Override // id.dana.base.BaseFragment
    public boolean onBackPressed() {
        PlaceComponentResult();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(int i) {
        Integer.valueOf(i);
        if (i == 6) {
            if (((FragmentCreateProfileBinding) getBinding()).getAuthRequestContext.getText().toString().length() >= 3) {
                KClassImpl$Data$declaredNonStaticMembers$2();
                return true;
            }
            showToast(getString(R.string.msg_empty_nickname_error));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KClassImpl$Data$declaredNonStaticMembers$2() {
        getAuthRequestContext();
        if (getBinding() != 0) {
            String obj = ((FragmentCreateProfileBinding) getBinding()).getAuthRequestContext.getText().toString();
            OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = this.moveToNextValue;
            String str = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            String str2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            String str3 = this.scheduleImpl;
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(obj, "");
            CreatePinKey.Companion companion = CreatePinKey.INSTANCE;
            CreatePinKey BuiltInFictitiousFunctionClassFactory = CreatePinKey.Companion.BuiltInFictitiousFunctionClassFactory(str, obj, str2, str3);
            Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
            onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(BuiltInFictitiousFunctionClassFactory);
        }
    }

    private void getAuthRequestContext() {
        if (getContext() == null) {
            return;
        }
        if (TextUtils.isEmpty(this.getErrorConfigVersion)) {
            this.getErrorConfigVersion = RegistrationEvent.ProfilePhotoSource.NO_ANSWER;
        }
        if (getBinding() != 0) {
            String obj = ((FragmentCreateProfileBinding) getBinding()).getAuthRequestContext.getText().toString();
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext().getApplicationContext());
            builder.MyBillsEntityDataFactory = TrackerKey.Event.REGISTRATION_PROFILE_CREATE;
            EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(RegistrationEvent.Property.NICKNAME, obj).MyBillsEntityDataFactory(RegistrationEvent.Property.PROFILE_PHOTO_SOURCE, this.getErrorConfigVersion);
            MyBillsEntityDataFactory.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PlaceComponentResult() {
        new AlertDialog.Builder(getContext()).setTitle(R.string.cancel_process_question).setPositiveButton(R.string.option_register, new DialogInterface.OnClickListener() { // from class: id.dana.onboarding.createprofile.CreateProfileFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CreateProfileFragment.this.dispose();
            }
        }).setNegativeButton(R.string.option_cancel, new DialogInterface.OnClickListener() { // from class: id.dana.onboarding.createprofile.CreateProfileFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = CreateProfileFragment.this.moveToNextValue;
                VerifyNumberKey.Companion companion = VerifyNumberKey.INSTANCE;
                VerifyNumberKey PlaceComponentResult = VerifyNumberKey.Companion.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult();
                Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
                onboardingNavigationManagerWithMenu.getAuthRequestContext.setHistory(History.single(PlaceComponentResult), 0);
            }
        }).create().show();
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CreateProfileFragment createProfileFragment) {
        if (createProfileFragment.getBinding() != 0) {
            GlideApp.KClassImpl$Data$declaredNonStaticMembers$2(createProfileFragment).PlaceComponentResult(createProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda2).getErrorConfigVersion((int) R.drawable.ic_empty_profile).MyBillsEntityDataFactory(DiskCacheStrategy.MyBillsEntityDataFactory).getSupportButtonTintMode().PlaceComponentResult((int) R.drawable.ic_empty_profile).SubSequence().MyBillsEntityDataFactory((ImageView) ((FragmentCreateProfileBinding) createProfileFragment.getBinding()).BuiltInFictitiousFunctionClassFactory);
        }
    }

    @Override // id.dana.base.BaseFragment
    public void init() {
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.CAMERA"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.onboarding.createprofile.CreateProfileFragment$$ExternalSyntheticLambda0
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult permissionResult, boolean z) {
                CreateProfileFragment createProfileFragment = CreateProfileFragment.this;
                if (permissionResult.MyBillsEntityDataFactory()) {
                    createProfileFragment.MyBillsEntityDataFactory.getAuthRequestContext();
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.PlaceComponentResult = builder.PlaceComponentResult();
        FragmentPermissionRequest.Builder builder2 = new FragmentPermissionRequest.Builder(this);
        String[] strArr2 = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        Intrinsics.checkNotNullParameter(strArr2, "");
        builder2.getAuthRequestContext = ArraysKt.toSet(strArr2);
        PermissionCallback permissionCallback2 = new PermissionCallback() { // from class: id.dana.onboarding.createprofile.CreateProfileFragment$$ExternalSyntheticLambda1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult permissionResult, boolean z) {
                CreateProfileFragment createProfileFragment = CreateProfileFragment.this;
                if (permissionResult.MyBillsEntityDataFactory()) {
                    createProfileFragment.PlaceComponentResult.check();
                }
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback2, "");
        builder2.BuiltInFictitiousFunctionClassFactory = permissionCallback2;
        this.lookAheadTest = builder2.PlaceComponentResult();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = arguments.getString("phoneNumber");
            this.scheduleImpl = arguments.getString("referralCode");
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            OnboardingNavigationManagerWithMenu navigationManager = ((OnboardingActivity) ((KeyBaseActivity) baseActivity)).getNavigationManager();
            this.moveToNextValue = navigationManager;
            navigationManager.KClassImpl$Data$declaredNonStaticMembers$2.setMenuLeftButton(getString(R.string.option_cancel));
            this.moveToNextValue.PlaceComponentResult = new MenuItemButtonListener() { // from class: id.dana.onboarding.createprofile.CreateProfileFragment$$ExternalSyntheticLambda4
                @Override // id.dana.base.MenuItemButtonListener
                public final void PlaceComponentResult() {
                    CreateProfileFragment.this.PlaceComponentResult();
                }
            };
            OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = this.moveToNextValue;
            onboardingNavigationManagerWithMenu.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButton(getString(R.string.create_profile_right_menu));
            this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButtonEnabled(false);
            this.moveToNextValue.getAuthRequestContext = new MenuItemButtonListener() { // from class: id.dana.onboarding.createprofile.CreateProfileFragment$$ExternalSyntheticLambda5
                @Override // id.dana.base.MenuItemButtonListener
                public final void PlaceComponentResult() {
                    CreateProfileFragment.this.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            };
            if (getBinding() != 0) {
                TextBehavior.EditTextBehaviorBuilder PlaceComponentResult = TextBehavior.Builder.PlaceComponentResult(((FragmentCreateProfileBinding) getBinding()).getAuthRequestContext);
                Validator validator = new Validator() { // from class: id.dana.onboarding.createprofile.CreateProfileFragment.3
                    @Override // id.dana.textbehavior.validate.Validator
                    public final boolean MyBillsEntityDataFactory(String str) {
                        return str.length() >= 3;
                    }

                    @Override // id.dana.textbehavior.validate.Validator
                    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
                        return CreateProfileFragment.this.getString(R.string.msg_empty_nickname_error);
                    }
                };
                if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == null) {
                    PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = new ArrayList();
                }
                PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.add(validator);
                PlaceComponentResult.MyBillsEntityDataFactory = new OnValidatedListener() { // from class: id.dana.onboarding.createprofile.CreateProfileFragment.2
                    @Override // id.dana.textbehavior.OnValidatedListener
                    public final void getAuthRequestContext(String str) {
                        CreateProfileFragment.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButtonEnabled(true);
                    }

                    @Override // id.dana.textbehavior.OnValidatedListener
                    public final void MyBillsEntityDataFactory(String str, List<InvalidReason> list) {
                        CreateProfileFragment.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButtonEnabled(false);
                    }
                };
                PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
                ((FragmentCreateProfileBinding) getBinding()).getAuthRequestContext.requestFocus();
                ((FragmentCreateProfileBinding) getBinding()).getAuthRequestContext.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: id.dana.onboarding.createprofile.CreateProfileFragment$$ExternalSyntheticLambda6
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        return CreateProfileFragment.this.BuiltInFictitiousFunctionClassFactory(i);
                    }
                });
                ((FragmentCreateProfileBinding) getBinding()).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.createprofile.CreateProfileFragment$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CreateProfileFragment createProfileFragment = CreateProfileFragment.this;
                        if (OSUtil.MyBillsEntityDataFactory()) {
                            createProfileFragment.PlaceComponentResult.check();
                        } else {
                            createProfileFragment.lookAheadTest.check();
                        }
                    }
                });
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of id.dana.base.KeyBaseFragment");
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public /* synthetic */ ViewBinding initViewBinding(View view) {
        return FragmentCreateProfileBinding.getAuthRequestContext(view);
    }
}
