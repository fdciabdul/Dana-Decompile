package id.dana.sendmoney_v2.smartfriction.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.sendmoney.databinding.FragmentStoryBinding;
import id.dana.sendmoney_v2.smartfriction.adapter.SuspiciousAccountAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0016\u0010\u000b\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/sendmoney_v2/smartfriction/fragment/StoryFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/sendmoney/databinding/FragmentStoryBinding;", "Landroid/view/View;", "p0", "Landroid/os/Bundle;", "p1", "", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "I", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/sendmoney_v2/smartfriction/adapter/SuspiciousAccountAdapter$OnStoryClickedListener;", "moveToNextValue", "Lid/dana/sendmoney_v2/smartfriction/adapter/SuspiciousAccountAdapter$OnStoryClickedListener;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StoryFragment extends BaseViewBindingFragment<FragmentStoryBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private SuspiciousAccountAdapter.OnStoryClickedListener KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String PlaceComponentResult = "";

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory = "";

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.MyBillsEntityDataFactory;
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
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentStoryBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentStoryBinding MyBillsEntityDataFactory = FragmentStoryBinding.MyBillsEntityDataFactory(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            FragmentStoryBinding fragmentStoryBinding = (FragmentStoryBinding) vb;
            InstrumentInjector.Resources_setImageResource(fragmentStoryBinding.MyBillsEntityDataFactory, this.getAuthRequestContext);
            fragmentStoryBinding.PlaceComponentResult.setText(this.PlaceComponentResult);
            fragmentStoryBinding.getAuthRequestContext.setText(this.MyBillsEntityDataFactory);
            fragmentStoryBinding.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.StoryFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StoryFragment.PlaceComponentResult(StoryFragment.this);
                }
            });
            fragmentStoryBinding.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.smartfriction.fragment.StoryFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StoryFragment.KClassImpl$Data$declaredNonStaticMembers$2(StoryFragment.this);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney_v2/smartfriction/fragment/StoryFragment$Companion;", "", "", "p0", "", "p1", "p2", "Lid/dana/sendmoney_v2/smartfriction/adapter/SuspiciousAccountAdapter$OnStoryClickedListener;", "p3", "Lid/dana/sendmoney_v2/smartfriction/fragment/StoryFragment;", "PlaceComponentResult", "(ILjava/lang/String;Ljava/lang/String;Lid/dana/sendmoney_v2/smartfriction/adapter/SuspiciousAccountAdapter$OnStoryClickedListener;)Lid/dana/sendmoney_v2/smartfriction/fragment/StoryFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static StoryFragment PlaceComponentResult(int p0, String p1, String p2, SuspiciousAccountAdapter.OnStoryClickedListener p3) {
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            StoryFragment storyFragment = new StoryFragment();
            storyFragment.getAuthRequestContext = p0;
            storyFragment.PlaceComponentResult = p1;
            storyFragment.MyBillsEntityDataFactory = p2;
            storyFragment.KClassImpl$Data$declaredNonStaticMembers$2 = p3;
            return storyFragment;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(StoryFragment storyFragment) {
        Intrinsics.checkNotNullParameter(storyFragment, "");
        SuspiciousAccountAdapter.OnStoryClickedListener onStoryClickedListener = storyFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onStoryClickedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onStoryClickedListener = null;
        }
        onStoryClickedListener.BuiltInFictitiousFunctionClassFactory();
    }

    public static /* synthetic */ void PlaceComponentResult(StoryFragment storyFragment) {
        Intrinsics.checkNotNullParameter(storyFragment, "");
        SuspiciousAccountAdapter.OnStoryClickedListener onStoryClickedListener = storyFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onStoryClickedListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onStoryClickedListener = null;
        }
        onStoryClickedListener.PlaceComponentResult();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }
}
