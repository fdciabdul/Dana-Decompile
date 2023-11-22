package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.otaliastudios.cameraview.CameraView;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes8.dex */
public final class ActivityImageCaptureBinding implements ViewBinding {
    public final FrameLayout BuiltInFictitiousFunctionClassFactory;
    public final LayoutToolbarBinding DatabaseTableConfigUtil;
    public final AppCompatTextView GetContactSyncConfig;
    public final View KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonSecondaryView MyBillsEntityDataFactory;
    public final AppCompatImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final CameraView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda8;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final Group getErrorConfigVersion;
    public final AppCompatTextView initRecordTimeStamp;
    public final AppCompatImageView lookAheadTest;
    public final AppCompatImageView moveToNextValue;
    public final AppCompatImageView scheduleImpl;

    private ActivityImageCaptureBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout2, View view, FrameLayout frameLayout, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, LayoutToolbarBinding layoutToolbarBinding, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, CameraView cameraView) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = constraintLayout;
        this.MyBillsEntityDataFactory = danaButtonSecondaryView;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.getAuthRequestContext = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
        this.BuiltInFictitiousFunctionClassFactory = frameLayout;
        this.getErrorConfigVersion = group;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatImageView;
        this.lookAheadTest = appCompatImageView2;
        this.scheduleImpl = appCompatImageView3;
        this.moveToNextValue = appCompatImageView4;
        this.DatabaseTableConfigUtil = layoutToolbarBinding;
        this.GetContactSyncConfig = appCompatTextView;
        this.initRecordTimeStamp = appCompatTextView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = appCompatTextView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = cameraView;
    }

    public static ActivityImageCaptureBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_image_capture, (ViewGroup) null, false);
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_retake_picture);
        int i = R.id.btn_upload;
        if (danaButtonSecondaryView != null) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_upload);
            if (danaButtonPrimaryView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cl_frame);
                if (constraintLayout != null) {
                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.divider);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.fl_image_preview);
                        if (frameLayout != null) {
                            Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.groupPicturePreview);
                            if (group != null) {
                                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_capture);
                                if (appCompatImageView != null) {
                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_gallery);
                                    if (appCompatImageView2 != null) {
                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_image_preview);
                                        if (appCompatImageView3 != null) {
                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_light);
                                            if (appCompatImageView4 != null) {
                                                View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.toolbar);
                                                if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                                    LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
                                                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_check_tip);
                                                    if (appCompatTextView != null) {
                                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_guidelines);
                                                        if (appCompatTextView2 != null) {
                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_tip_info);
                                                            if (appCompatTextView3 != null) {
                                                                CameraView cameraView = (CameraView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vDanaCamera);
                                                                if (cameraView != null) {
                                                                    return new ActivityImageCaptureBinding((ConstraintLayout) inflate, danaButtonSecondaryView, danaButtonPrimaryView, constraintLayout, BuiltInFictitiousFunctionClassFactory, frameLayout, group, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, MyBillsEntityDataFactory, appCompatTextView, appCompatTextView2, appCompatTextView3, cameraView);
                                                                }
                                                                i = R.id.vDanaCamera;
                                                            } else {
                                                                i = R.id.tv_tip_info;
                                                            }
                                                        } else {
                                                            i = R.id.tv_guidelines;
                                                        }
                                                    } else {
                                                        i = R.id.tv_check_tip;
                                                    }
                                                } else {
                                                    i = R.id.toolbar;
                                                }
                                            } else {
                                                i = R.id.iv_light;
                                            }
                                        } else {
                                            i = R.id.iv_image_preview;
                                        }
                                    } else {
                                        i = R.id.iv_gallery;
                                    }
                                } else {
                                    i = R.id.iv_capture;
                                }
                            } else {
                                i = R.id.groupPicturePreview;
                            }
                        } else {
                            i = R.id.fl_image_preview;
                        }
                    } else {
                        i = R.id.divider;
                    }
                } else {
                    i = R.id.cl_frame;
                }
            }
        } else {
            i = R.id.btn_retake_picture;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8;
    }
}
