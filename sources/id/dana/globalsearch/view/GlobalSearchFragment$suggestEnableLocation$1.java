package id.dana.globalsearch.view;

import android.content.Context;
import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import id.dana.R;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.extension.ViewExtKt;
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.domain.util.StringUtil;
import id.dana.eventbus.models.TimerEventKey;
import id.dana.globalsearch.tracker.model.SearchResultOpenTrackerModel;
import id.dana.utils.LocationUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "shouldShow", "", BridgeDSL.INVOKE, "(Z)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSearchFragment$suggestEnableLocation$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ String $$category;
    final /* synthetic */ String $$keyword;
    final /* synthetic */ GlobalSearchFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSearchFragment$suggestEnableLocation$1(GlobalSearchFragment globalSearchFragment, String str, String str2) {
        super(1);
        this.this$0 = globalSearchFragment;
        this.$$keyword = str;
        this.$$category = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        SearchResultOpenTrackerModel searchResultOpenTrackerModel;
        if (z || !LocationUtil.getAuthRequestContext(this.this$0.getContext())) {
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            CustomDialog.Builder builder = new CustomDialog.Builder(requireContext);
            builder.SubSequence = this.this$0.getString(R.string.allow_location_access);
            builder.GetContactSyncConfig = this.this$0.getString(R.string.allow_location_for_experience);
            builder.DatabaseTableConfigUtil = R.drawable.ic_location_permission_icon;
            builder.moveToNextValue = 0L;
            builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
            String string = this.this$0.getString(R.string.allow_access);
            final GlobalSearchFragment globalSearchFragment = this.this$0;
            CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(string, new Function1<View, Unit>() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$suggestEnableLocation$1.2
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
                    fragmentPermissionRequest = GlobalSearchFragment.this.moveToNextValue;
                    fragmentPermissionRequest.check();
                }
            });
            String string2 = this.this$0.getString(17039360);
            final GlobalSearchFragment globalSearchFragment2 = this.this$0;
            final String str = this.$$keyword;
            final String str2 = this.$$category;
            CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(string2, new Function1<View, Unit>() { // from class: id.dana.globalsearch.view.GlobalSearchFragment$suggestEnableLocation$1.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    GlobalSearchContract.Presenter k_;
                    Intrinsics.checkNotNullParameter(view, "");
                    GlobalSearchFragment.this.BuiltInFictitiousFunctionClassFactory(TimerEventKey.EXPLORE_SEARCH);
                    k_ = GlobalSearchFragment.this.k_();
                    String filterKeyword = StringUtil.filterKeyword(str);
                    String str3 = str2;
                    List listOf = str3 != null ? CollectionsKt.listOf(str3) : null;
                    if (listOf == null) {
                        listOf = CollectionsKt.emptyList();
                    }
                    GlobalSearchContract.Presenter.CC.getAuthRequestContext(k_, filterKeyword, 0, 0, listOf, null, 22);
                }
            });
            ViewExtKt.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(), KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue);
            return;
        }
        GlobalSearchFragment globalSearchFragment3 = this.this$0;
        String filterKeyword = StringUtil.filterKeyword(this.$$keyword);
        String str3 = this.$$category;
        List listOf = str3 != null ? CollectionsKt.listOf(str3) : null;
        if (listOf == null) {
            listOf = CollectionsKt.emptyList();
        }
        GlobalSearchFragment.getAuthRequestContext(globalSearchFragment3, filterKeyword, listOf);
        searchResultOpenTrackerModel = this.this$0.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullParameter("Custom", "");
        searchResultOpenTrackerModel.BuiltInFictitiousFunctionClassFactory = "Custom";
    }
}
