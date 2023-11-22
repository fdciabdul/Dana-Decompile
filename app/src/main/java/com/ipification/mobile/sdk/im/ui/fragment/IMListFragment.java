package com.ipification.mobile.sdk.im.ui.fragment;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.ipification.mobile.sdk.android.R;
import com.ipification.mobile.sdk.android.databinding.ImListFragmentBinding;
import com.ipification.mobile.sdk.android.utils.IPConstant;
import com.ipification.mobile.sdk.im.IMLocale;
import com.ipification.mobile.sdk.im.IMService;
import com.ipification.mobile.sdk.im.adapter.IMListAdapter;
import com.ipification.mobile.sdk.im.base.BaseFragment;
import com.ipification.mobile.sdk.im.data.IMInfo;
import com.ipification.mobile.sdk.im.listener.OnIMItemClickListener;
import com.ipification.mobile.sdk.im.listener.RedirectDataCallback;
import com.ipification.mobile.sdk.im.ui.IMVerificationActivity;
import com.ipification.mobile.sdk.im.util.IMAPI;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u000e\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lcom/ipification/mobile/sdk/im/ui/fragment/IMListFragment;", "Lcom/ipification/mobile/sdk/im/base/BaseFragment;", "Lcom/ipification/mobile/sdk/im/listener/OnIMItemClickListener;", "Landroid/view/LayoutInflater;", "p0", "Landroid/view/ViewGroup;", "p1", "Landroid/os/Bundle;", "p2", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lcom/ipification/mobile/sdk/im/data/IMInfo;", "", "getAuthRequestContext", "(Lcom/ipification/mobile/sdk/im/data/IMInfo;)V", "", "PlaceComponentResult", "Ljava/lang/String;", "Lcom/ipification/mobile/sdk/android/databinding/ImListFragmentBinding;", "MyBillsEntityDataFactory", "Lcom/ipification/mobile/sdk/android/databinding/ImListFragmentBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "<init>", "()V", "Factory"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class IMListFragment extends BaseFragment implements OnIMItemClickListener {

    /* renamed from: Factory  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private List<IMInfo> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private ImListFragmentBinding getAuthRequestContext;
    private final String PlaceComponentResult = "IMListFragment";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/ipification/mobile/sdk/im/ui/fragment/IMListFragment$Factory;", "", "", "Lcom/ipification/mobile/sdk/im/data/IMInfo;", "p0", "Lcom/ipification/mobile/sdk/im/base/BaseFragment;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Lcom/ipification/mobile/sdk/im/base/BaseFragment;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.ipification.mobile.sdk.im.ui.fragment.IMListFragment$Factory  reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static BaseFragment MyBillsEntityDataFactory(List<IMInfo> p0) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            IMListFragment iMListFragment = new IMListFragment();
            iMListFragment.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
            return iMListFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        View inflate = getLayoutInflater().inflate(R.layout.im_list_fragment, p1, false);
        int i = R.id.getAuthRequestContext_res_0x7f0a1119;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(i);
        if (recyclerView != null) {
            i = R.id.getErrorConfigVersion;
            TextView textView = (TextView) inflate.findViewById(i);
            if (textView != null) {
                i = R.id.scheduleImpl_res_0x7f0a159b;
                if (((TextView) inflate.findViewById(i)) != null) {
                    i = R.id.lookAheadTest;
                    TextView textView2 = (TextView) inflate.findViewById(i);
                    if (textView2 != null) {
                        ImListFragmentBinding imListFragmentBinding = new ImListFragmentBinding((ConstraintLayout) inflate, recyclerView, textView, textView2);
                        Intrinsics.checkExpressionValueIsNotNull(imListFragmentBinding, "");
                        this.getAuthRequestContext = imListFragmentBinding;
                        RecyclerView recyclerView2 = imListFragmentBinding.PlaceComponentResult;
                        List<IMInfo> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
                        if (list == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            throw null;
                        }
                        recyclerView2.setAdapter(new IMListAdapter(list, this));
                        IMService.Companion companion = IMService.INSTANCE;
                        IMLocale BuiltInFictitiousFunctionClassFactory = IMService.Companion.BuiltInFictitiousFunctionClassFactory();
                        ImListFragmentBinding imListFragmentBinding2 = this.getAuthRequestContext;
                        if (imListFragmentBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            throw null;
                        }
                        imListFragmentBinding2.MyBillsEntityDataFactory.setText(BuiltInFictitiousFunctionClassFactory.scheduleImpl);
                        ImListFragmentBinding imListFragmentBinding3 = this.getAuthRequestContext;
                        if (imListFragmentBinding3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            throw null;
                        }
                        imListFragmentBinding3.KClassImpl$Data$declaredNonStaticMembers$2.setText(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
                        IPConstant.Companion companion2 = IPConstant.INSTANCE;
                        IPConstant PlaceComponentResult = IPConstant.Companion.PlaceComponentResult();
                        String stringPlus = Intrinsics.stringPlus(PlaceComponentResult.DatabaseTableConfigUtil, "show IM Screen \n");
                        Intrinsics.checkParameterIsNotNull(stringPlus, "");
                        PlaceComponentResult.DatabaseTableConfigUtil = stringPlus;
                        ImListFragmentBinding imListFragmentBinding4 = this.getAuthRequestContext;
                        if (imListFragmentBinding4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            throw null;
                        }
                        ConstraintLayout constraintLayout = imListFragmentBinding4.BuiltInFictitiousFunctionClassFactory;
                        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "");
                        return constraintLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // com.ipification.mobile.sdk.im.listener.OnIMItemClickListener
    public final void getAuthRequestContext(IMInfo p0) {
        FragmentActivity activity;
        Intrinsics.checkParameterIsNotNull(p0, "");
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.ipification.mobile.sdk.im.ui.IMVerificationActivity");
        }
        ((IMVerificationActivity) activity2).showLoading();
        try {
            IMAPI.Companion companion = IMAPI.INSTANCE;
            String str = p0.MyBillsEntityDataFactory;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkExpressionValueIsNotNull(requireActivity, "");
            IMAPI.Companion.BuiltInFictitiousFunctionClassFactory(str, requireActivity, new RedirectDataCallback() { // from class: com.ipification.mobile.sdk.im.ui.fragment.IMListFragment$onItemClick$1
                @Override // com.ipification.mobile.sdk.im.listener.RedirectDataCallback
                public final void PlaceComponentResult(String p02) {
                    Intrinsics.checkParameterIsNotNull(p02, "");
                    IMAPI.Companion companion2 = IMAPI.INSTANCE;
                    FragmentActivity requireActivity2 = IMListFragment.this.requireActivity();
                    Intrinsics.checkExpressionValueIsNotNull(requireActivity2, "");
                    IMAPI.Companion.PlaceComponentResult(requireActivity2, p02);
                    FragmentActivity activity3 = IMListFragment.this.getActivity();
                    if (activity3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.ipification.mobile.sdk.im.ui.IMVerificationActivity");
                    }
                    ((IMVerificationActivity) activity3).hideLoading();
                }
            });
        } catch (PackageManager.NameNotFoundException unused) {
            activity = getActivity();
            if (activity == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.ipification.mobile.sdk.im.ui.IMVerificationActivity");
            }
            ((IMVerificationActivity) activity).hideLoading();
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), 1).show();
            activity = getActivity();
            if (activity == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.ipification.mobile.sdk.im.ui.IMVerificationActivity");
            }
            ((IMVerificationActivity) activity).hideLoading();
        }
    }
}
