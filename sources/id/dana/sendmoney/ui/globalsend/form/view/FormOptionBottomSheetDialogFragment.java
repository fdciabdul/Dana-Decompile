package id.dana.sendmoney.ui.globalsend.form.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LifecycleOwnerKt;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.BottomSheetGlobalSendFormOptionBinding;
import id.dana.sendmoney.ui.common.DefaultSearchHelper;
import id.dana.sendmoney.ui.common.EmptyStateView;
import id.dana.sendmoney.ui.globalsend.form.adapter.GlobalSendFormOptionAdapter;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import id.dana.sendmoney.ui.groupsend.recipient.view.SearchView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B`\u0012\u0006\u0010\u0010\u001a\u00020)\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0019\u0010.\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u001a¢\u0006\u0002\b\u001d\u0012\u0004\u0012\u00020\f0\u001f\u0012&\u0010/\u001a\"\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u001d\u0012\u000b\u0012\t\u0018\u00010\u0016¢\u0006\u0002\b\u001d\u0012\u0004\u0012\u00020\f0\u001c¢\u0006\u0004\b0\u00101J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001bR4\u0010\u0014\u001a\"\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u001d\u0012\u000b\u0012\t\u0018\u00010\u0016¢\u0006\u0002\b\u001d\u0012\u0004\u0012\u00020\f0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u001eR'\u0010\n\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u001a¢\u0006\u0002\b\u001d\u0012\u0004\u0012\u00020\f0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\u0017\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/view/FormOptionBottomSheetDialogFragment;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/sendmoney/databinding/BottomSheetGlobalSendFormOptionBinding;", "", "moveToNextValue", "()Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "Landroid/content/DialogInterface;", "p0", "onCancel", "(Landroid/content/DialogInterface;)V", "p_", "MyBillsEntityDataFactory", "onStart", "", "PlaceComponentResult", "Z", "", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;", "Ljava/util/List;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Lkotlin/jvm/functions/Function2;", "Lkotlin/Function1;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlin/jvm/functions/Function1;", "Lid/dana/sendmoney/ui/globalsend/form/adapter/GlobalSendFormOptionAdapter;", "DatabaseTableConfigUtil", "Lid/dana/sendmoney/ui/globalsend/form/adapter/GlobalSendFormOptionAdapter;", "Lid/dana/sendmoney/ui/common/DefaultSearchHelper;", "initRecordTimeStamp", "Lid/dana/sendmoney/ui/common/DefaultSearchHelper;", "getErrorConfigVersion", "", "GetContactSyncConfig", "I", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p1", "p2", "p3", "<init>", "(ILjava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FormOptionBottomSheetDialogFragment extends BaseViewBindingBottomSheetDialogFragment<BottomSheetGlobalSendFormOptionBinding> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private GlobalSendFormOptionAdapter PlaceComponentResult;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final int NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final List<GlobalSendFormOptionModel> getAuthRequestContext;
    private final Function2<String, Boolean, Unit> MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Function1<GlobalSendFormOptionModel, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private DefaultSearchHelper getErrorConfigVersion;

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.4f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetGlobalSendFormOptionBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetGlobalSendFormOptionBinding authRequestContext = BottomSheetGlobalSendFormOptionBinding.getAuthRequestContext(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FormOptionBottomSheetDialogFragment(int i, List<GlobalSendFormOptionModel> list, Function1<? super GlobalSendFormOptionModel, Unit> function1, Function2<? super String, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function2, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        this.getAuthRequestContext = list;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
        this.MyBillsEntityDataFactory = function2;
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

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        CharSequence text;
        String obj;
        String string;
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            AppCompatTextView appCompatTextView = ((BottomSheetGlobalSendFormOptionBinding) vb).getErrorConfigVersion;
            int i = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (i == 1) {
                text = requireContext().getText(R.string.transaction_purpose_title);
            } else if (i == 9) {
                text = requireContext().getText(R.string.title_bank_search);
            } else if (i == 16) {
                text = requireContext().getText(R.string.res_0x7f1316e8_emergencynotifactivity_getemergencynotifmodule_1);
            } else if (i == 17) {
                text = requireContext().getText(R.string.res_0x7f1316cc_r8_lambda_z7cckimop_rjsrtg6ix8npycd_m);
            }
            appCompatTextView.setText(text);
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                EmptyStateView emptyStateView = ((BottomSheetGlobalSendFormOptionBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2;
                int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (i2 == 16) {
                    obj = requireContext().getText(R.string.res_0x7f130611_summaryvoucherview_externalsyntheticlambda1).toString();
                } else {
                    obj = i2 != 17 ? "" : requireContext().getText(R.string.desc_empty_city_search).toString();
                }
                emptyStateView.setDesc(obj);
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    SearchView searchView = ((BottomSheetGlobalSendFormOptionBinding) vb3).NetworkUserEntityData$$ExternalSyntheticLambda0;
                    Intrinsics.checkNotNullExpressionValue(searchView, "");
                    SearchView searchView2 = searchView;
                    int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    searchView2.setVisibility(i3 == 9 || i3 == 16 || i3 == 17 ? 0 : 8);
                    if (searchView2.getVisibility() == 0) {
                        VB vb4 = this.MyBillsEntityDataFactory;
                        if (vb4 != 0) {
                            SearchView searchView3 = ((BottomSheetGlobalSendFormOptionBinding) vb4).NetworkUserEntityData$$ExternalSyntheticLambda0;
                            int i4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            if (i4 == 9) {
                                string = requireContext().getString(R.string.bank_search_hint);
                            } else if (i4 == 16) {
                                string = requireContext().getString(R.string.province_search_hint);
                            } else {
                                string = i4 != 17 ? "" : requireContext().getString(R.string.city_search_hint);
                            }
                            Intrinsics.checkNotNullExpressionValue(string, "");
                            searchView3.setEditTextHint(string);
                            FragmentActivity requireActivity = requireActivity();
                            Intrinsics.checkNotNullExpressionValue(requireActivity, "");
                            DefaultSearchHelper defaultSearchHelper = new DefaultSearchHelper(requireActivity, searchView, new Function1<String, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.view.FormOptionBottomSheetDialogFragment$setupSearchView$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(String str) {
                                    GlobalSendFormOptionAdapter globalSendFormOptionAdapter;
                                    ArrayList arrayList;
                                    Intrinsics.checkNotNullParameter(str, "");
                                    globalSendFormOptionAdapter = FormOptionBottomSheetDialogFragment.this.PlaceComponentResult;
                                    if (globalSendFormOptionAdapter == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                        globalSendFormOptionAdapter = null;
                                    }
                                    final FormOptionBottomSheetDialogFragment formOptionBottomSheetDialogFragment = FormOptionBottomSheetDialogFragment.this;
                                    Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.view.FormOptionBottomSheetDialogFragment$setupSearchView$1$1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* synthetic */ Unit invoke(Boolean bool) {
                                            invoke(bool.booleanValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(boolean z) {
                                            VB vb5 = FormOptionBottomSheetDialogFragment.this.MyBillsEntityDataFactory;
                                            if (vb5 != 0) {
                                                RecyclerView recyclerView = ((BottomSheetGlobalSendFormOptionBinding) vb5).lookAheadTest;
                                                Intrinsics.checkNotNullExpressionValue(recyclerView, "");
                                                recyclerView.setVisibility(z ? 0 : 8);
                                                VB vb6 = FormOptionBottomSheetDialogFragment.this.MyBillsEntityDataFactory;
                                                if (vb6 != 0) {
                                                    EmptyStateView emptyStateView2 = ((BottomSheetGlobalSendFormOptionBinding) vb6).KClassImpl$Data$declaredNonStaticMembers$2;
                                                    Intrinsics.checkNotNullExpressionValue(emptyStateView2, "");
                                                    emptyStateView2.setVisibility(z ^ true ? 0 : 8);
                                                    return;
                                                }
                                                throw new IllegalArgumentException("Required value was null.".toString());
                                            }
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                    };
                                    Intrinsics.checkNotNullParameter(str, "");
                                    Intrinsics.checkNotNullParameter(function1, "");
                                    String str2 = str;
                                    if (str2.length() == 0) {
                                        arrayList = globalSendFormOptionAdapter.PlaceComponentResult;
                                    } else {
                                        List<GlobalSendFormOptionModel> list = globalSendFormOptionAdapter.PlaceComponentResult;
                                        ArrayList arrayList2 = new ArrayList();
                                        for (Object obj2 : list) {
                                            if (StringsKt.contains((CharSequence) ((GlobalSendFormOptionModel) obj2).BuiltInFictitiousFunctionClassFactory, (CharSequence) str2, true)) {
                                                arrayList2.add(obj2);
                                            }
                                        }
                                        arrayList = arrayList2;
                                    }
                                    globalSendFormOptionAdapter.BuiltInFictitiousFunctionClassFactory = arrayList;
                                    function1.invoke(Boolean.valueOf(!arrayList.isEmpty()));
                                    globalSendFormOptionAdapter.notifyDataSetChanged();
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                                    invoke2(str);
                                    return Unit.INSTANCE;
                                }
                            }, null, 8, null);
                            defaultSearchHelper.PlaceComponentResult(LifecycleOwnerKt.PlaceComponentResult(this));
                            this.getErrorConfigVersion = defaultSearchHelper;
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                    this.PlaceComponentResult = new GlobalSendFormOptionAdapter(this.getAuthRequestContext, new Function1<GlobalSendFormOptionModel, Unit>() { // from class: id.dana.sendmoney.ui.globalsend.form.view.FormOptionBottomSheetDialogFragment$initViews$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(GlobalSendFormOptionModel globalSendFormOptionModel) {
                            invoke2(globalSendFormOptionModel);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(GlobalSendFormOptionModel globalSendFormOptionModel) {
                            Function1 function1;
                            Intrinsics.checkNotNullParameter(globalSendFormOptionModel, "");
                            function1 = FormOptionBottomSheetDialogFragment.this.KClassImpl$Data$declaredNonStaticMembers$2;
                            function1.invoke(globalSendFormOptionModel);
                            FormOptionBottomSheetDialogFragment.this.BuiltInFictitiousFunctionClassFactory = true;
                            Dialog dialog = FormOptionBottomSheetDialogFragment.this.getDialog();
                            if (dialog != null) {
                                dialog.cancel();
                            }
                        }
                    });
                    VB vb5 = this.MyBillsEntityDataFactory;
                    if (vb5 != 0) {
                        ((BottomSheetGlobalSendFormOptionBinding) vb5).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.view.FormOptionBottomSheetDialogFragment$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                FormOptionBottomSheetDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(FormOptionBottomSheetDialogFragment.this);
                            }
                        });
                        VB vb6 = this.MyBillsEntityDataFactory;
                        if (vb6 != 0) {
                            RecyclerView recyclerView = ((BottomSheetGlobalSendFormOptionBinding) vb6).lookAheadTest;
                            GlobalSendFormOptionAdapter globalSendFormOptionAdapter = this.PlaceComponentResult;
                            if (globalSendFormOptionAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                globalSendFormOptionAdapter = null;
                            }
                            recyclerView.setAdapter(globalSendFormOptionAdapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
                            VB vb7 = this.MyBillsEntityDataFactory;
                            if (vb7 != 0) {
                                ViewGroup.LayoutParams layoutParams = ((BottomSheetGlobalSendFormOptionBinding) vb7).PlaceComponentResult.getLayoutParams();
                                double d = Resources.getSystem().getDisplayMetrics().heightPixels;
                                Double.isNaN(d);
                                layoutParams.height = (int) (d * 0.6d);
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

    private final String moveToNextValue() {
        Object obj;
        String str;
        Iterator<T> it = this.getAuthRequestContext.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((GlobalSendFormOptionModel) obj).getKClassImpl$Data$declaredNonStaticMembers$2()) {
                break;
            }
        }
        GlobalSendFormOptionModel globalSendFormOptionModel = (GlobalSendFormOptionModel) obj;
        return (globalSendFormOptionModel == null || (str = globalSendFormOptionModel.BuiltInFictitiousFunctionClassFactory) == null) ? "" : str;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FormOptionBottomSheetDialogFragment formOptionBottomSheetDialogFragment) {
        Intrinsics.checkNotNullParameter(formOptionBottomSheetDialogFragment, "");
        Dialog dialog = formOptionBottomSheetDialogFragment.getDialog();
        if (dialog != null) {
            dialog.cancel();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BottomSheetGlobalSendFormOptionBinding) vb).getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((BottomSheetGlobalSendFormOptionBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0.clearEditText();
            this.MyBillsEntityDataFactory.invoke(moveToNextValue(), Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory));
            super.onCancel(p0);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void p_() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((BottomSheetGlobalSendFormOptionBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda0.clearEditText();
            this.MyBillsEntityDataFactory.invoke(moveToNextValue(), Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory));
            super.p_();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
