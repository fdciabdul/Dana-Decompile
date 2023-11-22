package id.dana.kyb.view.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.common.DividerItemDecoration;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.data.constant.DanaUrl;
import id.dana.databinding.ViewKybTransactionHistoryBinding;
import id.dana.kyb.adapter.KybTransactionHistoryAdapter;
import id.dana.kyb.helper.KybUrlsDataManager;
import id.dana.kyb.model.KybTransactionModel;
import id.dana.kyb.model.TransactionListQueryModel;
import id.dana.kyb.view.MyBusinessFragment;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B/\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010)\u001a\u00020'¢\u0006\u0004\b*\u0010+J4\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u001d\u0010\n\u001a\u0019\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b0\u0005j\u0002`\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0012J\r\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0012J\r\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR1\u0010 \u001a\u001d\u0012\u000b\u0012\t\u0018\u00010\u0006¢\u0006\u0002\b\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005j\u0004\u0018\u0001`\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001fR\u0013\u0010\u0019\u001a\u00020!X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b \u0010\""}, d2 = {"Lid/dana/kyb/view/richview/KybTransactionHistoryView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewKybTransactionHistoryBinding;", "Lid/dana/kyb/view/MyBusinessFragment$KybOpenH5Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "", "Lid/dana/kyb/view/richview/OnClickButtonViewAllListener;", "onClickButtonViewAllListener", "addListener", "(Lid/dana/kyb/view/MyBusinessFragment$KybOpenH5Listener;Lkotlin/jvm/functions/Function1;)V", "Lid/dana/kyb/model/TransactionListQueryModel;", "transactionListQueryModel", "bindTransactionHistory", "(Lid/dana/kyb/model/TransactionListQueryModel;)V", "hideSkeleton", "()V", "inflateViewBinding", "()Lid/dana/databinding/ViewKybTransactionHistoryBinding;", "setup", "showEmptyState", "showSkeleton", "Lid/dana/kyb/adapter/KybTransactionHistoryAdapter;", "PlaceComponentResult", "Lid/dana/kyb/adapter/KybTransactionHistoryAdapter;", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/kyb/view/MyBusinessFragment$KybOpenH5Listener;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lkotlin/Lazy;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybTransactionHistoryView extends BaseViewBindingRichView<ViewKybTransactionHistoryBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private MyBusinessFragment.KybOpenH5Listener getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Function1<? super String, Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private KybTransactionHistoryAdapter MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KybTransactionHistoryView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KybTransactionHistoryView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KybTransactionHistoryView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KybTransactionHistoryView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = LazyKt.lazy(new Function0<RecyclerViewSkeletonScreen>() { // from class: id.dana.kyb.view.richview.KybTransactionHistoryView$skeletonScreen$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerViewSkeletonScreen invoke() {
                ViewKybTransactionHistoryBinding binding;
                KybTransactionHistoryAdapter kybTransactionHistoryAdapter;
                binding = KybTransactionHistoryView.this.getBinding();
                RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(binding.PlaceComponentResult);
                kybTransactionHistoryAdapter = KybTransactionHistoryView.this.MyBillsEntityDataFactory;
                if (kybTransactionHistoryAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    kybTransactionHistoryAdapter = null;
                }
                BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = kybTransactionHistoryAdapter;
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.item_kyb_transaction_history_shimmer;
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 2;
                BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
                BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
                BuiltInFictitiousFunctionClassFactory.lookAheadTest = 0;
                BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
                RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
                recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
                return recyclerViewSkeletonScreen;
            }
        });
    }

    public /* synthetic */ KybTransactionHistoryView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewKybTransactionHistoryBinding inflateViewBinding() {
        ViewKybTransactionHistoryBinding authRequestContext = ViewKybTransactionHistoryBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public final void bindTransactionHistory(TransactionListQueryModel transactionListQueryModel) {
        String string;
        String valueOf;
        Intrinsics.checkNotNullParameter(transactionListQueryModel, "");
        hideSkeleton();
        if ((!transactionListQueryModel.MyBillsEntityDataFactory.isEmpty()) != false) {
            ViewKybTransactionHistoryBinding binding = getBinding();
            RecyclerView recyclerView = binding.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(0);
            TextView textView = binding.scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
            TextView textView2 = binding.scheduleImpl;
            if (transactionListQueryModel.PlaceComponentResult > 0) {
                Context context = getContext();
                Object[] objArr = new Object[1];
                if (transactionListQueryModel.getBuiltInFictitiousFunctionClassFactory()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(transactionListQueryModel.PlaceComponentResult);
                    sb.append('+');
                    valueOf = sb.toString();
                } else {
                    valueOf = String.valueOf(transactionListQueryModel.PlaceComponentResult);
                }
                objArr[0] = valueOf;
                string = context.getString(R.string.transaction_history_count, objArr);
                Intrinsics.checkNotNullExpressionValue(string, "");
            } else {
                string = getContext().getString(R.string.kyb_transaction_history_empty);
                Intrinsics.checkNotNullExpressionValue(string, "");
            }
            textView2.setText(string);
            DanaButtonSecondaryView danaButtonSecondaryView = binding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
            danaButtonSecondaryView.setVisibility(0);
            KybTransactionHistoryAdapter kybTransactionHistoryAdapter = this.MyBillsEntityDataFactory;
            KybTransactionHistoryAdapter kybTransactionHistoryAdapter2 = null;
            if (kybTransactionHistoryAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                kybTransactionHistoryAdapter = null;
            }
            kybTransactionHistoryAdapter.PlaceComponentResult = this.getAuthRequestContext;
            KybTransactionHistoryAdapter kybTransactionHistoryAdapter3 = this.MyBillsEntityDataFactory;
            if (kybTransactionHistoryAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                kybTransactionHistoryAdapter2 = kybTransactionHistoryAdapter3;
            }
            kybTransactionHistoryAdapter2.setItems(transactionListQueryModel.MyBillsEntityDataFactory);
            ImageView imageView = binding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(imageView, "");
            imageView.setVisibility(transactionListQueryModel.PlaceComponentResult > 0 ? 0 : 8);
            AppCompatImageView appCompatImageView = binding.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(8);
            TextView textView3 = binding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(textView3, "");
            textView3.setVisibility(8);
            return;
        }
        showEmptyState();
    }

    public final void showSkeleton() {
        ViewKybTransactionHistoryBinding binding = getBinding();
        TextView textView = binding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(8);
        TextView textView2 = binding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(8);
        DanaButtonSecondaryView danaButtonSecondaryView = binding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
        danaButtonSecondaryView.setVisibility(8);
        ImageView imageView = binding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
        TextView textView3 = binding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(textView3, "");
        textView3.setVisibility(8);
        AppCompatImageView appCompatImageView = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(8);
        TextView textView4 = binding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(textView4, "");
        textView4.setVisibility(8);
        RecyclerView recyclerView = binding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        recyclerView.setVisibility(0);
        Object value = this.PlaceComponentResult.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        ((SkeletonScreen) value).MyBillsEntityDataFactory();
    }

    public final void hideSkeleton() {
        ViewKybTransactionHistoryBinding binding = getBinding();
        TextView textView = binding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        ImageView imageView = binding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(0);
        TextView textView2 = binding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(0);
        Object value = this.PlaceComponentResult.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        ((SkeletonScreen) value).PlaceComponentResult();
    }

    public final void addListener(MyBusinessFragment.KybOpenH5Listener r2, Function1<? super String, Unit> onClickButtonViewAllListener) {
        Intrinsics.checkNotNullParameter(r2, "");
        Intrinsics.checkNotNullParameter(onClickButtonViewAllListener, "");
        this.getAuthRequestContext = r2;
        this.BuiltInFictitiousFunctionClassFactory = onClickButtonViewAllListener;
    }

    public final void showEmptyState() {
        ViewKybTransactionHistoryBinding binding = getBinding();
        binding.MyBillsEntityDataFactory.setVisibility(0);
        binding.getAuthRequestContext.setVisibility(0);
        binding.scheduleImpl.setVisibility(0);
        binding.KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
        binding.moveToNextValue.setVisibility(0);
        binding.scheduleImpl.setText(getContext().getString(R.string.kyb_transaction_history_empty));
        binding.PlaceComponentResult.setVisibility(8);
        ImageView imageView = binding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(8);
    }

    /* renamed from: $r8$lambda$hYrlrDKjZkw57LTiqE-qDbxsmJI */
    public static /* synthetic */ void m2637$r8$lambda$hYrlrDKjZkw57LTiqEqDbxsmJI(KybTransactionHistoryView kybTransactionHistoryView, View view) {
        Function1<? super String, Unit> function1;
        Intrinsics.checkNotNullParameter(kybTransactionHistoryView, "");
        MyBusinessFragment.KybOpenH5Listener kybOpenH5Listener = kybTransactionHistoryView.getAuthRequestContext;
        if (kybOpenH5Listener != null) {
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(kybTransactionHistoryView.getContext());
            builder.MyBillsEntityDataFactory = TrackerKey.Event.KYB_TRANSACTION_LIST_CLICK;
            builder.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
            kybOpenH5Listener.BuiltInFictitiousFunctionClassFactory(KybUrlsDataManager.KClassImpl$Data$declaredNonStaticMembers$2(DanaUrl.KYB_ALL_TRANSACTION_HISTORY));
        }
        KybTransactionHistoryAdapter kybTransactionHistoryAdapter = kybTransactionHistoryView.MyBillsEntityDataFactory;
        if (kybTransactionHistoryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            kybTransactionHistoryAdapter = null;
        }
        List<KybTransactionModel> items = kybTransactionHistoryAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        KybTransactionModel kybTransactionModel = (KybTransactionModel) CollectionsKt.firstOrNull((List) items);
        if (kybTransactionModel == null || (function1 = kybTransactionHistoryView.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        function1.invoke(kybTransactionModel.MyBillsEntityDataFactory);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.kyb.view.MyBusinessFragment$KybOpenH5Listener] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        ?? r1 = 0;
        this.MyBillsEntityDataFactory = new KybTransactionHistoryAdapter(r1, 1, r1);
        RecyclerView recyclerView = getBinding().PlaceComponentResult;
        KybTransactionHistoryAdapter kybTransactionHistoryAdapter = this.MyBillsEntityDataFactory;
        if (kybTransactionHistoryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            r1 = kybTransactionHistoryAdapter;
        }
        recyclerView.setAdapter((RecyclerView.Adapter) r1);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()) { // from class: id.dana.kyb.view.richview.KybTransactionHistoryView$setupAdapter$1$1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public final boolean canScrollVertically() {
                return false;
            }
        });
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), ContextCompat.BuiltInFictitiousFunctionClassFactory(recyclerView.getContext(), R.color.MyBillsEntityDataFactory_res_0x7f060157), 0.0f, (char) 0));
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.richview.KybTransactionHistoryView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KybTransactionHistoryView.m2637$r8$lambda$hYrlrDKjZkw57LTiqEqDbxsmJI(KybTransactionHistoryView.this, view);
            }
        });
    }
}
