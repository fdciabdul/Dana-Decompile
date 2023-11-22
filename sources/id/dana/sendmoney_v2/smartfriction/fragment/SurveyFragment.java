package id.dana.sendmoney_v2.smartfriction.fragment;

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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0016\u0010\u000bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0016\u0010\f\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/sendmoney_v2/smartfriction/fragment/SurveyFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/sendmoney/databinding/FragmentSurveyBinding;", "Landroid/view/View;", "p0", "Landroid/os/Bundle;", "p1", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "BuiltInFictitiousFunctionClassFactory", "()V", "PlaceComponentResult", "Lid/dana/sendmoney_v2/smartfriction/adapter/SuspiciousAccountAdapter$OnStoryClickedListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney_v2/smartfriction/adapter/SuspiciousAccountAdapter$OnStoryClickedListener;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney_v2/smartfriction/fragment/SurveyFragment$Companion$OnSubmitClickListener;", "Lid/dana/sendmoney_v2/smartfriction/fragment/SurveyFragment$Companion$OnSubmitClickListener;", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SurveyFragment extends BaseViewBindingFragment<FragmentSurveyBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private SuspiciousAccountAdapter.OnStoryClickedListener MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Companion.OnSubmitClickListener BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String PlaceComponentResult = "";

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
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

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void getAuthRequestContext() {
        this.PlaceComponentResult.clear();
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
            fragmentSurveyBinding.newProxyInstance.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.MyBillsEntityDataFactory(SurveyFragment.this);
                }
            });
            fragmentSurveyBinding.PrepareContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.getAuthRequestContext(SurveyFragment.this);
                }
            });
            fragmentSurveyBinding.NetworkUserEntityData$$ExternalSyntheticLambda0.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.getAuthRequestContext(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.moveToNextValue.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.getErrorConfigVersion(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.GetContactSyncConfig.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.scheduleImpl(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.NetworkUserEntityData$$ExternalSyntheticLambda2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.BuiltInFictitiousFunctionClassFactory(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.NetworkUserEntityData$$ExternalSyntheticLambda1.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.lookAheadTest(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.KClassImpl$Data$declaredNonStaticMembers$2(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.moveToNextValue(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.lookAheadTest.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.MyBillsEntityDataFactory(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            fragmentSurveyBinding.getErrorConfigVersion.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.PlaceComponentResult(SurveyFragment.this, fragmentSurveyBinding);
                }
            });
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((FragmentSurveyBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SurveyFragment.BuiltInFictitiousFunctionClassFactory(SurveyFragment.this);
                    }
                });
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    ((FragmentSurveyBinding) vb3).scheduleImpl.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.SurveyFragment$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnFocusChangeListener
                        public final void onFocusChange(View view, boolean z) {
                            SurveyFragment.MyBillsEntityDataFactory(SurveyFragment.this, z);
                        }
                    });
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
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

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/sendmoney_v2/smartfriction/fragment/SurveyFragment$Companion;", "", "Lid/dana/sendmoney_v2/smartfriction/adapter/SuspiciousAccountAdapter$OnStoryClickedListener;", "p0", "Lid/dana/sendmoney_v2/smartfriction/fragment/SurveyFragment$Companion$OnSubmitClickListener;", "p1", "Lid/dana/sendmoney_v2/smartfriction/fragment/SurveyFragment;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney_v2/smartfriction/adapter/SuspiciousAccountAdapter$OnStoryClickedListener;Lid/dana/sendmoney_v2/smartfriction/fragment/SurveyFragment$Companion$OnSubmitClickListener;)Lid/dana/sendmoney_v2/smartfriction/fragment/SurveyFragment;", "<init>", "()V", "OnSubmitClickListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney_v2/smartfriction/fragment/SurveyFragment$Companion$OnSubmitClickListener;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public interface OnSubmitClickListener {
            void KClassImpl$Data$declaredNonStaticMembers$2(String p0);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static SurveyFragment BuiltInFictitiousFunctionClassFactory(SuspiciousAccountAdapter.OnStoryClickedListener p0, OnSubmitClickListener p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            SurveyFragment surveyFragment = new SurveyFragment();
            surveyFragment.MyBillsEntityDataFactory = p0;
            surveyFragment.BuiltInFictitiousFunctionClassFactory = p1;
            return surveyFragment;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.PlaceComponentResult = fragmentSurveyBinding.lookAheadTest.getText().toString();
        surveyFragment.BuiltInFictitiousFunctionClassFactory();
        fragmentSurveyBinding.MyBillsEntityDataFactory.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.PlaceComponentResult = fragmentSurveyBinding.lookAheadTest.getText().toString();
        surveyFragment.BuiltInFictitiousFunctionClassFactory();
        fragmentSurveyBinding.MyBillsEntityDataFactory.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SurveyFragment surveyFragment) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        VB vb = surveyFragment.PlaceComponentResult;
        if (vb != 0) {
            if (((FragmentSurveyBinding) vb).getErrorConfigVersion.isChecked()) {
                VB vb2 = surveyFragment.PlaceComponentResult;
                if (vb2 != 0) {
                    surveyFragment.PlaceComponentResult = String.valueOf(((FragmentSurveyBinding) vb2).scheduleImpl.getText());
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            Companion.OnSubmitClickListener onSubmitClickListener = surveyFragment.BuiltInFictitiousFunctionClassFactory;
            if (onSubmitClickListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                onSubmitClickListener = null;
            }
            onSubmitClickListener.KClassImpl$Data$declaredNonStaticMembers$2(surveyFragment.PlaceComponentResult);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void PlaceComponentResult(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.BuiltInFictitiousFunctionClassFactory();
        fragmentSurveyBinding.getErrorConfigVersion.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.requestFocus();
        surveyFragment.PlaceComponentResult();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.PlaceComponentResult = fragmentSurveyBinding.lookAheadTest.getText().toString();
        surveyFragment.BuiltInFictitiousFunctionClassFactory();
        fragmentSurveyBinding.lookAheadTest.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.PlaceComponentResult = fragmentSurveyBinding.lookAheadTest.getText().toString();
        surveyFragment.BuiltInFictitiousFunctionClassFactory();
        fragmentSurveyBinding.lookAheadTest.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SurveyFragment surveyFragment, boolean z) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        if (z) {
            surveyFragment.BuiltInFictitiousFunctionClassFactory();
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

    public static /* synthetic */ void lookAheadTest(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.BuiltInFictitiousFunctionClassFactory();
        fragmentSurveyBinding.getErrorConfigVersion.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.requestFocus();
        surveyFragment.PlaceComponentResult();
    }

    public static /* synthetic */ void scheduleImpl(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.PlaceComponentResult = fragmentSurveyBinding.lookAheadTest.getText().toString();
        surveyFragment.BuiltInFictitiousFunctionClassFactory();
        fragmentSurveyBinding.PlaceComponentResult.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SurveyFragment surveyFragment) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        SuspiciousAccountAdapter.OnStoryClickedListener onStoryClickedListener = surveyFragment.MyBillsEntityDataFactory;
        if (onStoryClickedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onStoryClickedListener = null;
        }
        onStoryClickedListener.PlaceComponentResult();
    }

    public static /* synthetic */ void getAuthRequestContext(SurveyFragment surveyFragment) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        SuspiciousAccountAdapter.OnStoryClickedListener onStoryClickedListener = surveyFragment.MyBillsEntityDataFactory;
        if (onStoryClickedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onStoryClickedListener = null;
        }
        onStoryClickedListener.BuiltInFictitiousFunctionClassFactory();
    }

    public static /* synthetic */ void getErrorConfigVersion(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.PlaceComponentResult = fragmentSurveyBinding.lookAheadTest.getText().toString();
        surveyFragment.BuiltInFictitiousFunctionClassFactory();
        fragmentSurveyBinding.getAuthRequestContext.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    public static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.PlaceComponentResult = fragmentSurveyBinding.lookAheadTest.getText().toString();
        surveyFragment.BuiltInFictitiousFunctionClassFactory();
        fragmentSurveyBinding.PlaceComponentResult.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    public static /* synthetic */ void moveToNextValue(SurveyFragment surveyFragment, FragmentSurveyBinding fragmentSurveyBinding) {
        Intrinsics.checkNotNullParameter(surveyFragment, "");
        Intrinsics.checkNotNullParameter(fragmentSurveyBinding, "");
        surveyFragment.PlaceComponentResult = fragmentSurveyBinding.lookAheadTest.getText().toString();
        surveyFragment.BuiltInFictitiousFunctionClassFactory();
        fragmentSurveyBinding.getAuthRequestContext.setChecked(true);
        fragmentSurveyBinding.scheduleImpl.clearFocus();
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
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
        this.PlaceComponentResult.clear();
    }
}
