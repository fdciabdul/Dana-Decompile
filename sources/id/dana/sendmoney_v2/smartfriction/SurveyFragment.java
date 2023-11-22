package id.dana.sendmoney_v2.smartfriction;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import id.dana.R;
import id.dana.component.edittextcomponent.DanaEditTextView;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.extension.ContextExtKt;
import id.dana.sendmoney.databinding.FragmentSurveyBinding;
import id.dana.sendmoney_v2.smartfriction.adapter.SuspiciousAccountAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0012\u0010\u000bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0016\u0010\f\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0011"}, d2 = {"Lid/dana/sendmoney_v2/smartfriction/SurveyFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/sendmoney/databinding/FragmentSurveyBinding;", "Landroid/view/View;", "p0", "Landroid/os/Bundle;", "p1", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "MyBillsEntityDataFactory", "()V", "PlaceComponentResult", "Lid/dana/sendmoney_v2/smartfriction/adapter/SuspiciousAccountAdapter$OnStoryClickedListener;", "Lid/dana/sendmoney_v2/smartfriction/adapter/SuspiciousAccountAdapter$OnStoryClickedListener;", "getAuthRequestContext", "", "Ljava/lang/String;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class SurveyFragment extends BaseViewBindingFragment<FragmentSurveyBinding> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private SuspiciousAccountAdapter.OnStoryClickedListener getAuthRequestContext;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
    private String PlaceComponentResult = "";

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
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

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentSurveyBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentSurveyBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentSurveyBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            final FragmentSurveyBinding fragmentSurveyBinding = (FragmentSurveyBinding) vb;
            fragmentSurveyBinding.newProxyInstance.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.SurveyFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.KClassImpl$Data$declaredNonStaticMembers$2(SurveyFragment.this);
                }
            });
            fragmentSurveyBinding.PrepareContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.SurveyFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.getAuthRequestContext(SurveyFragment.this);
                }
            });
            fragmentSurveyBinding.NetworkUserEntityData$$ExternalSyntheticLambda0.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.SurveyFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.BuiltInFictitiousFunctionClassFactory(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.moveToNextValue.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.SurveyFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.lookAheadTest(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.GetContactSyncConfig.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.SurveyFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.getAuthRequestContext(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.NetworkUserEntityData$$ExternalSyntheticLambda2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.SurveyFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.PlaceComponentResult(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.NetworkUserEntityData$$ExternalSyntheticLambda1.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.SurveyFragment$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.moveToNextValue(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.SurveyFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.KClassImpl$Data$declaredNonStaticMembers$2(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.SurveyFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.getErrorConfigVersion(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.SurveyFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.MyBillsEntityDataFactory(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.lookAheadTest.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.SurveyFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.getErrorConfigVersion.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.SurveyFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.scheduleImpl(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentSurveyBinding) vb2).scheduleImpl.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.sendmoney_v2.smartfriction.SurveyFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view, boolean z) {
                        SurveyFragment.PlaceComponentResult(SurveyFragment.this, z);
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final void PlaceComponentResult() {
        Object systemService = requireContext().getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            inputMethodManager.showSoftInput(((FragmentSurveyBinding) vb).scheduleImpl, 1);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.MyBillsEntityDataFactory();
        fragmentSurveyBinding.MyBillsEntityDataFactory.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    public static /* synthetic */ void PlaceComponentResult(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.MyBillsEntityDataFactory();
        fragmentSurveyBinding.lookAheadTest.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    public static /* synthetic */ void getAuthRequestContext(SurveyFragment surveyFragment) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        SuspiciousAccountAdapter.OnStoryClickedListener onStoryClickedListener = surveyFragment.getAuthRequestContext;
        if (onStoryClickedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onStoryClickedListener = null;
        }
        onStoryClickedListener.BuiltInFictitiousFunctionClassFactory();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.MyBillsEntityDataFactory();
        fragmentSurveyBinding.PlaceComponentResult.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    public static /* synthetic */ void getAuthRequestContext(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.MyBillsEntityDataFactory();
        fragmentSurveyBinding.PlaceComponentResult.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.MyBillsEntityDataFactory();
        fragmentSurveyBinding.MyBillsEntityDataFactory.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SurveyFragment surveyFragment) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        SuspiciousAccountAdapter.OnStoryClickedListener onStoryClickedListener = surveyFragment.getAuthRequestContext;
        if (onStoryClickedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onStoryClickedListener = null;
        }
        onStoryClickedListener.PlaceComponentResult();
    }

    public static /* synthetic */ void PlaceComponentResult(SurveyFragment surveyFragment, boolean z) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        if (z) {
            surveyFragment.MyBillsEntityDataFactory();
            VB vb = surveyFragment.PlaceComponentResult;
            if (vb != 0) {
                ((FragmentSurveyBinding) vb).getErrorConfigVersion.setChecked(true);
                VB vb2 = surveyFragment.PlaceComponentResult;
                if (vb2 != 0) {
                    DanaEditTextView danaEditTextView = ((FragmentSurveyBinding) vb2).scheduleImpl;
                    Context requireContext = surveyFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "");
                    danaEditTextView.setBackground(ContextExtKt.PlaceComponentResult(requireContext, (int) R.drawable.selector_et_yellow));
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        VB vb3 = surveyFragment.PlaceComponentResult;
        if (vb3 != 0) {
            DanaEditTextView danaEditTextView2 = ((FragmentSurveyBinding) vb3).scheduleImpl;
            Context requireContext2 = surveyFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "");
            danaEditTextView2.setBackground(ContextExtKt.PlaceComponentResult(requireContext2, (int) R.color.transparent));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void moveToNextValue(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.MyBillsEntityDataFactory();
        fragmentSurveyBinding.getErrorConfigVersion.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.requestFocus();
        surveyFragment.PlaceComponentResult();
    }

    public static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.MyBillsEntityDataFactory();
        fragmentSurveyBinding.lookAheadTest.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    public static /* synthetic */ void scheduleImpl(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.MyBillsEntityDataFactory();
        fragmentSurveyBinding.getErrorConfigVersion.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.requestFocus();
        surveyFragment.PlaceComponentResult();
    }

    public static /* synthetic */ void getErrorConfigVersion(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.MyBillsEntityDataFactory();
        fragmentSurveyBinding.getAuthRequestContext.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    public static /* synthetic */ void lookAheadTest(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.MyBillsEntityDataFactory();
        fragmentSurveyBinding.getAuthRequestContext.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    private final void MyBillsEntityDataFactory() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            FragmentSurveyBinding fragmentSurveyBinding = (FragmentSurveyBinding) vb;
            fragmentSurveyBinding.MyBillsEntityDataFactory.setChecked(false);
            fragmentSurveyBinding.getAuthRequestContext.setChecked(false);
            fragmentSurveyBinding.PlaceComponentResult.setChecked(false);
            fragmentSurveyBinding.lookAheadTest.setChecked(false);
            fragmentSurveyBinding.getErrorConfigVersion.setChecked(false);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
