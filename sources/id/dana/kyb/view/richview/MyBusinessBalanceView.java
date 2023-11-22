package id.dana.kyb.view.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.databinding.ViewMyBusinessBalanceBinding;
import id.dana.kyb.adapter.KybTopServiceAdapter;
import id.dana.kyb.model.KybServiceModel;
import id.dana.kyb.view.MyBusinessFragment;
import id.dana.kyb.view.bottomsheetdialog.PendingBalanceInformationBottomSheet;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u0012\b\b\u0002\u0010:\u001a\u000209\u0012\b\b\u0002\u0010;\u001a\u000209¢\u0006\u0004\b<\u0010=J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001d\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\"\u001a\u00020\u00072\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u001fj\u0002` ¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010.R\u0016\u0010+\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0013\u00103\u001a\u000202X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b3\u00104"}, d2 = {"Lid/dana/kyb/view/richview/MyBusinessBalanceView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewMyBusinessBalanceBinding;", "", "balance", "readyToWithdraw", "inProcess", "", "bindBalanceInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "Lid/dana/kyb/model/KybServiceModel;", "topServices", "bindTopService", "(Ljava/util/List;)V", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "usedAmount", "limitAmount", "urgencyLevel", "bindTransactionLimit", "(Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;)V", "inflateViewBinding", "()Lid/dana/databinding/ViewMyBusinessBalanceBinding;", "", "isBalanceWithdrawClickable", "setBalanceWithdrawClickable", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setBalanceWithdrawListener", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lid/dana/kyb/helper/service/listener/KybServiceClickListener;", "kybServiceClickListener", "setKybServiceClickListener", "(Lkotlin/jvm/functions/Function1;)V", "Lid/dana/kyb/view/MyBusinessFragment$KybTieringListener;", "setKybTieringListener", "(Lid/dana/kyb/view/MyBusinessFragment$KybTieringListener;)V", "setup", "()V", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/kyb/adapter/KybTopServiceAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/kyb/adapter/KybTopServiceAdapter;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "Z", "getAuthRequestContext", "Lid/dana/kyb/view/MyBusinessFragment$KybTieringListener;", "Lid/dana/kyb/view/bottomsheetdialog/PendingBalanceInformationBottomSheet;", "MyBillsEntityDataFactory", "Lkotlin/Lazy;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBusinessBalanceView extends BaseViewBindingRichView<ViewMyBusinessBalanceBinding> {
    private Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private KybTopServiceAdapter PlaceComponentResult;
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;
    private MyBusinessFragment.KybTieringListener getAuthRequestContext;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyBusinessBalanceView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyBusinessBalanceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyBusinessBalanceView(Context context, AttributeSet attributeSet, int i) {
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
    public MyBusinessBalanceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<PendingBalanceInformationBottomSheet>() { // from class: id.dana.kyb.view.richview.MyBusinessBalanceView$pendingBalanceInformationBottomSheet$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PendingBalanceInformationBottomSheet invoke() {
                return new PendingBalanceInformationBottomSheet();
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = new Function0<Unit>() { // from class: id.dana.kyb.view.richview.MyBusinessBalanceView$balanceWithdrawListener$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
    }

    public /* synthetic */ MyBusinessBalanceView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewMyBusinessBalanceBinding inflateViewBinding() {
        ViewMyBusinessBalanceBinding BuiltInFictitiousFunctionClassFactory = ViewMyBusinessBalanceBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void bindBalanceInfo(String balance, String readyToWithdraw, String inProcess) {
        Intrinsics.checkNotNullParameter(balance, "");
        Intrinsics.checkNotNullParameter(readyToWithdraw, "");
        Intrinsics.checkNotNullParameter(inProcess, "");
        ViewMyBusinessBalanceBinding binding = getBinding();
        binding.NetworkUserEntityData$$ExternalSyntheticLambda1.setText(balance);
        binding.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(readyToWithdraw);
        binding.initRecordTimeStamp.setText(inProcess);
    }

    public final void bindTransactionLimit(MoneyViewModel usedAmount, MoneyViewModel limitAmount, String urgencyLevel) {
        Intrinsics.checkNotNullParameter(usedAmount, "");
        Intrinsics.checkNotNullParameter(limitAmount, "");
        Intrinsics.checkNotNullParameter(urgencyLevel, "");
        ViewMyBusinessBalanceBinding binding = getBinding();
        binding.moveToNextValue.show(usedAmount, limitAmount, urgencyLevel);
        binding.lookAheadTest.show(urgencyLevel);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 || Intrinsics.areEqual(urgencyLevel, "NONE")) {
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory();
    }

    public final void bindTopService(List<KybServiceModel> topServices) {
        Intrinsics.checkNotNullParameter(topServices, "");
        KybTopServiceAdapter kybTopServiceAdapter = this.PlaceComponentResult;
        if (kybTopServiceAdapter != null) {
            BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(kybTopServiceAdapter, topServices);
        }
    }

    public final void setKybServiceClickListener(Function1<? super KybServiceModel, Unit> kybServiceClickListener) {
        Intrinsics.checkNotNullParameter(kybServiceClickListener, "");
        KybTopServiceAdapter kybTopServiceAdapter = this.PlaceComponentResult;
        if (kybTopServiceAdapter != null) {
            kybTopServiceAdapter.BuiltInFictitiousFunctionClassFactory = kybServiceClickListener;
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        ViewMyBusinessBalanceBinding binding = getBinding();
        Group group = binding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(group, "");
        group.setVisibility(this.KClassImpl$Data$declaredNonStaticMembers$2 ? 0 : 8);
        binding.BuiltInFictitiousFunctionClassFactory.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), this.KClassImpl$Data$declaredNonStaticMembers$2 ? R.drawable.ic_icon_group_chevron_up : R.drawable.ic_icon_group_chevron_down));
    }

    public final void setBalanceWithdrawListener(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "");
        this.BuiltInFictitiousFunctionClassFactory = r2;
    }

    public final void setBalanceWithdrawClickable(boolean isBalanceWithdrawClickable) {
        getBinding().PlaceComponentResult.setClickable(isBalanceWithdrawClickable);
    }

    public final void setKybTieringListener(MyBusinessFragment.KybTieringListener r2) {
        Intrinsics.checkNotNullParameter(r2, "");
        this.getAuthRequestContext = r2;
    }

    public static /* synthetic */ void $r8$lambda$YvkHVbxnTehvd3U2AMV8N7goIQM(MyBusinessBalanceView myBusinessBalanceView, View view) {
        Intrinsics.checkNotNullParameter(myBusinessBalanceView, "");
        PendingBalanceInformationBottomSheet pendingBalanceInformationBottomSheet = (PendingBalanceInformationBottomSheet) myBusinessBalanceView.MyBillsEntityDataFactory.getValue();
        Context context = myBusinessBalanceView.getContext();
        if (context != null) {
            pendingBalanceInformationBottomSheet.show(((FragmentActivity) context).getSupportFragmentManager(), "PendingBalanceInformationBottomSheet");
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public static /* synthetic */ void $r8$lambda$aKI5yQdRRWPeBjZY07BbpTpL7kM(MyBusinessBalanceView myBusinessBalanceView, View view) {
        Intrinsics.checkNotNullParameter(myBusinessBalanceView, "");
        myBusinessBalanceView.BuiltInFictitiousFunctionClassFactory.invoke();
    }

    /* renamed from: $r8$lambda$u1yVaDDCwSUSsN4sRniX-Ex1inE */
    public static /* synthetic */ void m2638$r8$lambda$u1yVaDDCwSUSsN4sRniXEx1inE(MyBusinessBalanceView myBusinessBalanceView, View view) {
        Intrinsics.checkNotNullParameter(myBusinessBalanceView, "");
        MyBusinessFragment.KybTieringListener kybTieringListener = myBusinessBalanceView.getAuthRequestContext;
        if (kybTieringListener != null) {
            kybTieringListener.PlaceComponentResult();
        }
    }

    public static /* synthetic */ void $r8$lambda$yNodT31L2WZeClTP30gYjU2Sr8s(MyBusinessBalanceView myBusinessBalanceView, View view) {
        Intrinsics.checkNotNullParameter(myBusinessBalanceView, "");
        if (!myBusinessBalanceView.KClassImpl$Data$declaredNonStaticMembers$2) {
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(myBusinessBalanceView.getContext());
            builder.MyBillsEntityDataFactory = TrackerKey.Event.KYB_BALANCE_BREAKDOWN_CLICK;
            builder.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
        }
        myBusinessBalanceView.KClassImpl$Data$declaredNonStaticMembers$2 = !myBusinessBalanceView.KClassImpl$Data$declaredNonStaticMembers$2;
        myBusinessBalanceView.BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function1] */
    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        ?? r1 = 0;
        this.PlaceComponentResult = new KybTopServiceAdapter(r1, 1, r1);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setJustifyContent(5);
        flexboxLayoutManager.setAlignItems(0);
        flexboxLayoutManager.setFlexDirection(0);
        flexboxLayoutManager.setFlexWrap(0);
        RecyclerView recyclerView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        recyclerView.setLayoutManager(flexboxLayoutManager);
        recyclerView.setAdapter(this.PlaceComponentResult);
        ViewMyBusinessBalanceBinding binding = getBinding();
        binding.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.richview.MyBusinessBalanceView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessBalanceView.$r8$lambda$yNodT31L2WZeClTP30gYjU2Sr8s(MyBusinessBalanceView.this, view);
            }
        });
        binding.scheduleImpl.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.richview.MyBusinessBalanceView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessBalanceView.$r8$lambda$YvkHVbxnTehvd3U2AMV8N7goIQM(MyBusinessBalanceView.this, view);
            }
        });
        binding.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.richview.MyBusinessBalanceView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessBalanceView.$r8$lambda$aKI5yQdRRWPeBjZY07BbpTpL7kM(MyBusinessBalanceView.this, view);
            }
        });
        binding.lookAheadTest.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.richview.MyBusinessBalanceView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessBalanceView.m2638$r8$lambda$u1yVaDDCwSUSsN4sRniXEx1inE(MyBusinessBalanceView.this, view);
            }
        });
        BuiltInFictitiousFunctionClassFactory();
    }
}
