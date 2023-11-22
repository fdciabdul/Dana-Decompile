package id.dana.permissionprompt.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.databinding.BottomSheetPermissionPromptBinding;
import id.dana.permissionprompt.mapper.PermissionPromptContentMapper;
import id.dana.permissionprompt.model.PermissionPromptContentModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\t\b\u0016¢\u0006\u0004\b\u0017\u0010\u000bB3\u0012\u0006\u0010\u000f\u001a\u00020\u0014\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011¢\u0006\u0004\b\u0017\u0010\u001aJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u0004\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0004\u0010\u0010R\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0014\u0010\n\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/permissionprompt/view/PermissionPromptBottomSheetDialog;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/databinding/BottomSheetPermissionPromptBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "MyBillsEntityDataFactory", "onStart", "Landroidx/fragment/app/FragmentManager;", "p0", "(Landroidx/fragment/app/FragmentManager;)V", "Lkotlin/Function0;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "", "GetContactSyncConfig", "Ljava/lang/String;", "<init>", "p1", "p2", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PermissionPromptBottomSheetDialog extends BaseViewBindingBottomSheetDialogFragment<BottomSheetPermissionPromptBinding> {

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final String getAuthRequestContext;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function0<Unit> BuiltInFictitiousFunctionClassFactory;
    private Function0<Unit> PlaceComponentResult;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.5f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    public PermissionPromptBottomSheetDialog(String str, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(str, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.getAuthRequestContext = str;
        this.BuiltInFictitiousFunctionClassFactory = function0;
        this.PlaceComponentResult = function02;
    }

    public /* synthetic */ PermissionPromptBottomSheetDialog(String str, Function0 function0, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : function0, (i & 4) != 0 ? null : function02);
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetPermissionPromptBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetPermissionPromptBinding KClassImpl$Data$declaredNonStaticMembers$2 = BottomSheetPermissionPromptBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public PermissionPromptBottomSheetDialog() {
        this("", null, null, 6, null);
        try {
            dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        Context context = getContext();
        if (context != null) {
            PermissionPromptContentMapper permissionPromptContentMapper = PermissionPromptContentMapper.INSTANCE;
            PermissionPromptContentModel PlaceComponentResult = PermissionPromptContentMapper.PlaceComponentResult(context, this.getAuthRequestContext);
            VB vb = this.MyBillsEntityDataFactory;
            if (vb != 0) {
                ((BottomSheetPermissionPromptBinding) vb).MyBillsEntityDataFactory.setImageDrawable(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                VB vb2 = this.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    ((BottomSheetPermissionPromptBinding) vb2).getErrorConfigVersion.setText(PlaceComponentResult.getErrorConfigVersion);
                    VB vb3 = this.MyBillsEntityDataFactory;
                    if (vb3 != 0) {
                        ((BottomSheetPermissionPromptBinding) vb3).NetworkUserEntityData$$ExternalSyntheticLambda0.setText(PlaceComponentResult.MyBillsEntityDataFactory);
                        VB vb4 = this.MyBillsEntityDataFactory;
                        if (vb4 != 0) {
                            ((BottomSheetPermissionPromptBinding) vb4).getErrorConfigVersion.setContentDescription(PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0);
                            VB vb5 = this.MyBillsEntityDataFactory;
                            if (vb5 != 0) {
                                ((BottomSheetPermissionPromptBinding) vb5).NetworkUserEntityData$$ExternalSyntheticLambda0.setContentDescription(PlaceComponentResult.getAuthRequestContext);
                                VB vb6 = this.MyBillsEntityDataFactory;
                                if (vb6 != 0) {
                                    ((BottomSheetPermissionPromptBinding) vb6).BuiltInFictitiousFunctionClassFactory.setContentDescription(PlaceComponentResult.scheduleImpl);
                                    VB vb7 = this.MyBillsEntityDataFactory;
                                    if (vb7 != 0) {
                                        ((BottomSheetPermissionPromptBinding) vb7).getAuthRequestContext.setContentDescription(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2);
                                        VB vb8 = this.MyBillsEntityDataFactory;
                                        if (vb8 != 0) {
                                            ((BottomSheetPermissionPromptBinding) vb8).KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(PlaceComponentResult.PlaceComponentResult);
                                        } else {
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        VB vb9 = this.MyBillsEntityDataFactory;
        if (vb9 != 0) {
            ((BottomSheetPermissionPromptBinding) vb9).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.permissionprompt.view.PermissionPromptBottomSheetDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PermissionPromptBottomSheetDialog.PlaceComponentResult(PermissionPromptBottomSheetDialog.this);
                }
            });
            VB vb10 = this.MyBillsEntityDataFactory;
            if (vb10 != 0) {
                ((BottomSheetPermissionPromptBinding) vb10).getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.permissionprompt.view.PermissionPromptBottomSheetDialog$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PermissionPromptBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(PermissionPromptBottomSheetDialog.this);
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
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
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext != null) {
                getAuthRequestContext.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(getAuthRequestContext, this));
            }
            MyBillsEntityDataFactory(dialog);
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(FragmentManager p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.show(p0, "PermissionPromptBottomSheetDialog");
    }

    public static /* synthetic */ void PlaceComponentResult(PermissionPromptBottomSheetDialog permissionPromptBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(permissionPromptBottomSheetDialog, "");
        Function0<Unit> function0 = permissionPromptBottomSheetDialog.BuiltInFictitiousFunctionClassFactory;
        if (function0 != null) {
            function0.invoke();
        }
        permissionPromptBottomSheetDialog.dismiss();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PermissionPromptBottomSheetDialog permissionPromptBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(permissionPromptBottomSheetDialog, "");
        Function0<Unit> function0 = permissionPromptBottomSheetDialog.PlaceComponentResult;
        if (function0 != null) {
            function0.invoke();
        }
        permissionPromptBottomSheetDialog.dismiss();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BottomSheetPermissionPromptBinding) vb).PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
