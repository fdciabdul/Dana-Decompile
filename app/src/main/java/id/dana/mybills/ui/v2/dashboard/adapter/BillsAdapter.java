package id.dana.mybills.ui.v2.dashboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.core.ui.extension.StringExtKt;
import id.dana.core.ui.extension.TextViewExtKt;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import id.dana.data.util.DateTimeUtil;
import id.dana.mybills.R;
import id.dana.mybills.databinding.ItemBillPaymentBinding;
import id.dana.mybills.databinding.ItemBillPaymentConfirmationBinding;
import id.dana.mybills.databinding.ItemManageBillsBinding;
import id.dana.mybills.databinding.ViewholderBillShimmerBinding;
import id.dana.mybills.ui.constant.RecurringType;
import id.dana.mybills.ui.model.BillPaymentStatusModel;
import id.dana.mybills.ui.model.MoneyViewModel;
import id.dana.mybills.ui.model.PaidStatus;
import id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001f2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0006 !\"#$\u001fBq\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0012\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0012\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012\u0012\u0014\b\u0002\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R#\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R#\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0012X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0016R\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0019X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u001a"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/adapter/BillsAdapter;", "Lid/dana/core/ui/recyclerview/BaseRecyclerViewDiffUtilAdapter;", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Landroid/view/LayoutInflater;", "p0", "Landroid/view/ViewGroup;", "p1", "", "p2", "PlaceComponentResult", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "getItemViewType", "(I)I", "", "scheduleImpl", "J", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function2;", "", "", "getAuthRequestContext", "Lkotlin/jvm/functions/Function2;", "MyBillsEntityDataFactory", "Landroid/view/View;", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "p3", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "Companion", "BillsHomeShimmerViewHolder", "BillsManageShimmerViewHolder", "BillsManageViewHolder", "BillsPaymentConfirmViewHolder", "BillsViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BillsAdapter extends BaseRecyclerViewDiffUtilAdapter<BillPaymentStatusModel, BaseViewBindingViewHolder<BillPaymentStatusModel>> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final Function2<View, BillPaymentStatusModel, Unit> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Function1<BillPaymentStatusModel, Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Function2<View, BillPaymentStatusModel, Unit> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final Function2<BillPaymentStatusModel, Boolean, Unit> MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private long KClassImpl$Data$declaredNonStaticMembers$2;

    public BillsAdapter() {
        this(null, null, null, null, 15, null);
    }

    public /* synthetic */ BillsAdapter(AnonymousClass1 anonymousClass1, AnonymousClass2 anonymousClass2, AnonymousClass3 anonymousClass3, AnonymousClass4 anonymousClass4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function2<View, BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter.1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view, BillPaymentStatusModel billPaymentStatusModel) {
                Intrinsics.checkNotNullParameter(view, "");
                Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(View view, BillPaymentStatusModel billPaymentStatusModel) {
                invoke2(view, billPaymentStatusModel);
                return Unit.INSTANCE;
            }
        } : anonymousClass1, (i & 2) != 0 ? new Function2<View, BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter.2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view, BillPaymentStatusModel billPaymentStatusModel) {
                Intrinsics.checkNotNullParameter(view, "");
                Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(View view, BillPaymentStatusModel billPaymentStatusModel) {
                invoke2(view, billPaymentStatusModel);
                return Unit.INSTANCE;
            }
        } : anonymousClass2, (i & 4) != 0 ? new Function2<BillPaymentStatusModel, Boolean, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter.3
            public final void invoke(BillPaymentStatusModel billPaymentStatusModel, boolean z) {
                Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(BillPaymentStatusModel billPaymentStatusModel, Boolean bool) {
                invoke(billPaymentStatusModel, bool.booleanValue());
                return Unit.INSTANCE;
            }
        } : anonymousClass3, (i & 8) != 0 ? new Function1<BillPaymentStatusModel, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter.4
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BillPaymentStatusModel billPaymentStatusModel) {
                Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BillPaymentStatusModel billPaymentStatusModel) {
                invoke2(billPaymentStatusModel);
                return Unit.INSTANCE;
            }
        } : anonymousClass4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BillsAdapter(Function2<? super View, ? super BillPaymentStatusModel, Unit> function2, Function2<? super View, ? super BillPaymentStatusModel, Unit> function22, Function2<? super BillPaymentStatusModel, ? super Boolean, Unit> function23, Function1<? super BillPaymentStatusModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function2, "");
        Intrinsics.checkNotNullParameter(function22, "");
        Intrinsics.checkNotNullParameter(function23, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.PlaceComponentResult = function2;
        this.getAuthRequestContext = function22;
        this.MyBillsEntityDataFactory = function23;
        this.BuiltInFictitiousFunctionClassFactory = function1;
    }

    @Override // id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter
    public final BaseViewBindingViewHolder<BillPaymentStatusModel> PlaceComponentResult(LayoutInflater p0, ViewGroup p1, int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (p2 == 1) {
            ItemManageBillsBinding BuiltInFictitiousFunctionClassFactory = ItemManageBillsBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(p1.getContext()), p1);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            return new BillsManageViewHolder(this, BuiltInFictitiousFunctionClassFactory);
        } else if (p2 == 2) {
            ItemBillPaymentConfirmationBinding PlaceComponentResult = ItemBillPaymentConfirmationBinding.PlaceComponentResult(LayoutInflater.from(p1.getContext()), p1);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            return new BillsPaymentConfirmViewHolder(this, PlaceComponentResult);
        } else if (p2 == 3) {
            ViewholderBillShimmerBinding MyBillsEntityDataFactory = ViewholderBillShimmerBinding.MyBillsEntityDataFactory(LayoutInflater.from(p1.getContext()), p1);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            return new BillsManageShimmerViewHolder(this, MyBillsEntityDataFactory);
        } else if (p2 == 4) {
            ViewholderBillShimmerBinding MyBillsEntityDataFactory2 = ViewholderBillShimmerBinding.MyBillsEntityDataFactory(LayoutInflater.from(p1.getContext()), p1);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
            return new BillsHomeShimmerViewHolder(this, MyBillsEntityDataFactory2);
        } else {
            ItemBillPaymentBinding authRequestContext = ItemBillPaymentBinding.getAuthRequestContext(LayoutInflater.from(p1.getContext()), p1);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            return new BillsViewHolder(this, authRequestContext);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        BillPaymentStatusModel authRequestContext = getAuthRequestContext(p0);
        if (authRequestContext != null) {
            return authRequestContext.getViewType();
        }
        return 0;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/adapter/BillsAdapter$BillsViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "Lid/dana/mybills/databinding/ItemBillPaymentBinding;", "getAuthRequestContext", "Lid/dana/mybills/databinding/ItemBillPaymentBinding;", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "I", "p0", "<init>", "(Lid/dana/mybills/ui/v2/dashboard/adapter/BillsAdapter;Lid/dana/mybills/databinding/ItemBillPaymentBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class BillsViewHolder extends BaseViewBindingViewHolder<BillPaymentStatusModel> {
        final /* synthetic */ BillsAdapter KClassImpl$Data$declaredNonStaticMembers$2;
        private int PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final ItemBillPaymentBinding MyBillsEntityDataFactory;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public BillsViewHolder(id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter r3, id.dana.mybills.databinding.ItemBillPaymentBinding r4) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r2.KClassImpl$Data$declaredNonStaticMembers$2 = r3
                r3 = r4
                androidx.viewbinding.ViewBinding r3 = (androidx.viewbinding.ViewBinding) r3
                r0 = 0
                r1 = 2
                r2.<init>(r3, r0, r1, r0)
                r2.MyBillsEntityDataFactory = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter.BillsViewHolder.<init>(id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter, id.dana.mybills.databinding.ItemBillPaymentBinding):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:67:0x01b1, code lost:
        
            if ((r14 != null && r14.isInquirySuccess()) == false) goto L68;
         */
        @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.mybills.ui.model.BillPaymentStatusModel r14, int r15) {
            /*
                Method dump skipped, instructions count: 473
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter.BillsViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.Object, int):void");
        }

        public static /* synthetic */ void PlaceComponentResult(BillsAdapter billsAdapter, BillPaymentStatusModel billPaymentStatusModel, boolean z) {
            Intrinsics.checkNotNullParameter(billsAdapter, "");
            Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
            billsAdapter.MyBillsEntityDataFactory.invoke(billPaymentStatusModel, Boolean.valueOf(z));
        }

        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BillsAdapter billsAdapter, BillPaymentStatusModel billPaymentStatusModel, View view) {
            Intrinsics.checkNotNullParameter(billsAdapter, "");
            Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
            Function2<View, BillPaymentStatusModel, Unit> function2 = billsAdapter.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(view, "");
            function2.invoke(view, billPaymentStatusModel);
        }

        public static /* synthetic */ void getAuthRequestContext(BillsAdapter billsAdapter, BillPaymentStatusModel billPaymentStatusModel, View view) {
            Intrinsics.checkNotNullParameter(billsAdapter, "");
            Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
            Function2<View, BillPaymentStatusModel, Unit> function2 = billsAdapter.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(view, "");
            function2.invoke(view, billPaymentStatusModel);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/adapter/BillsAdapter$BillsHomeShimmerViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "Lid/dana/mybills/databinding/ViewholderBillShimmerBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/databinding/ViewholderBillShimmerBinding;", "p0", "<init>", "(Lid/dana/mybills/ui/v2/dashboard/adapter/BillsAdapter;Lid/dana/mybills/databinding/ViewholderBillShimmerBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class BillsHomeShimmerViewHolder extends BaseViewBindingViewHolder<BillPaymentStatusModel> {
        final /* synthetic */ BillsAdapter BuiltInFictitiousFunctionClassFactory;
        private final ViewholderBillShimmerBinding KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public BillsHomeShimmerViewHolder(id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter r3, id.dana.mybills.databinding.ViewholderBillShimmerBinding r4) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r2.BuiltInFictitiousFunctionClassFactory = r3
                r3 = r4
                androidx.viewbinding.ViewBinding r3 = (androidx.viewbinding.ViewBinding) r3
                r0 = 0
                r1 = 2
                r2.<init>(r3, r0, r1, r0)
                r2.KClassImpl$Data$declaredNonStaticMembers$2 = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter.BillsHomeShimmerViewHolder.<init>(id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter, id.dana.mybills.databinding.ViewholderBillShimmerBinding):void");
        }

        @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BillPaymentStatusModel billPaymentStatusModel, int i) {
            Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory);
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.viewholder_bill_home_skeleton;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.PrepareContext);
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0).MyBillsEntityDataFactory();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/adapter/BillsAdapter$BillsManageShimmerViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "Lid/dana/mybills/databinding/ViewholderBillShimmerBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/databinding/ViewholderBillShimmerBinding;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/mybills/ui/v2/dashboard/adapter/BillsAdapter;Lid/dana/mybills/databinding/ViewholderBillShimmerBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class BillsManageShimmerViewHolder extends BaseViewBindingViewHolder<BillPaymentStatusModel> {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final ViewholderBillShimmerBinding BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ BillsAdapter PlaceComponentResult;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public BillsManageShimmerViewHolder(id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter r3, id.dana.mybills.databinding.ViewholderBillShimmerBinding r4) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r2.PlaceComponentResult = r3
                r3 = r4
                androidx.viewbinding.ViewBinding r3 = (androidx.viewbinding.ViewBinding) r3
                r0 = 0
                r1 = 2
                r2.<init>(r3, r0, r1, r0)
                r2.BuiltInFictitiousFunctionClassFactory = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter.BillsManageShimmerViewHolder.<init>(id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter, id.dana.mybills.databinding.ViewholderBillShimmerBinding):void");
        }

        @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BillPaymentStatusModel billPaymentStatusModel, int i) {
            Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
            ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.viewholder_manage_bill_skeleton;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.PrepareContext);
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0).MyBillsEntityDataFactory();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/adapter/BillsAdapter$BillsManageViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "Lid/dana/mybills/databinding/ItemManageBillsBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/databinding/ItemManageBillsBinding;", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/mybills/ui/v2/dashboard/adapter/BillsAdapter;Lid/dana/mybills/databinding/ItemManageBillsBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class BillsManageViewHolder extends BaseViewBindingViewHolder<BillPaymentStatusModel> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final ItemManageBillsBinding MyBillsEntityDataFactory;
        final /* synthetic */ BillsAdapter MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private int KClassImpl$Data$declaredNonStaticMembers$2;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public BillsManageViewHolder(id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter r3, id.dana.mybills.databinding.ItemManageBillsBinding r4) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r2.MyBillsEntityDataFactory = r3
                r3 = r4
                androidx.viewbinding.ViewBinding r3 = (androidx.viewbinding.ViewBinding) r3
                r0 = 0
                r1 = 2
                r2.<init>(r3, r0, r1, r0)
                r2.MyBillsEntityDataFactory = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter.BillsManageViewHolder.<init>(id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter, id.dana.mybills.databinding.ItemManageBillsBinding):void");
        }

        @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BillPaymentStatusModel billPaymentStatusModel, int i) {
            String amount;
            final BillPaymentStatusModel billPaymentStatusModel2 = billPaymentStatusModel;
            Intrinsics.checkNotNullParameter(billPaymentStatusModel2, "");
            ItemManageBillsBinding itemManageBillsBinding = this.MyBillsEntityDataFactory;
            final BillsAdapter billsAdapter = this.MyBillsEntityDataFactory;
            CircleImageView circleImageView = itemManageBillsBinding.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(circleImageView, "");
            BillsAdapter.BuiltInFictitiousFunctionClassFactory(circleImageView, billPaymentStatusModel2.getIconUrl());
            CircleImageView circleImageView2 = itemManageBillsBinding.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(circleImageView2, "");
            CircleImageView circleImageView3 = circleImageView2;
            String recurringType = billPaymentStatusModel2.getRecurringType();
            if (recurringType == null) {
                recurringType = "";
            }
            BillsAdapter.PlaceComponentResult(circleImageView3, recurringType);
            if (Intrinsics.areEqual(billPaymentStatusModel2.getRecurringType(), RecurringType.REMINDER)) {
                itemManageBillsBinding.BuiltInFictitiousFunctionClassFactory.setCardBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(itemManageBillsBinding.scheduleImpl.getContext(), R.color.isLayoutRequested));
                itemManageBillsBinding.getErrorConfigVersion.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(itemManageBillsBinding.scheduleImpl.getContext(), R.color.newProxyInstance));
                itemManageBillsBinding.getErrorConfigVersion.setText(itemManageBillsBinding.scheduleImpl.getContext().getString(R.string.mybills_manage_bills_manual_payment));
            } else {
                itemManageBillsBinding.BuiltInFictitiousFunctionClassFactory.setCardBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(itemManageBillsBinding.scheduleImpl.getContext(), R.color.MyBillsEntityDataFactory));
                itemManageBillsBinding.getErrorConfigVersion.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(itemManageBillsBinding.scheduleImpl.getContext(), R.color.getAuthRequestContext));
                itemManageBillsBinding.getErrorConfigVersion.setText(itemManageBillsBinding.scheduleImpl.getContext().getString(R.string.mybills_manage_bills_automatic_payment));
            }
            itemManageBillsBinding.initRecordTimeStamp.setText(billPaymentStatusModel2.getSubscriptionTitle());
            itemManageBillsBinding.lookAheadTest.setText(billPaymentStatusModel2.isDigitalVoucher() ? billPaymentStatusModel2.getExtInfo().getBillerDenomText() : billPaymentStatusModel2.getBillId());
            TextView textView = itemManageBillsBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
            MoneyViewModel totalAmount = billPaymentStatusModel2.getTotalAmount();
            textView.setText((totalAmount == null || (amount = totalAmount.getAmount()) == null) ? null : StringExtKt.PlaceComponentResult(amount, "Rp", "0"));
            itemManageBillsBinding.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter$BillsManageViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BillsAdapter.BillsManageViewHolder.getAuthRequestContext(BillsAdapter.this, billPaymentStatusModel2, view);
                }
            });
            DateTimeUtil dateTimeUtil = DateTimeUtil.INSTANCE;
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "");
            Long gmtDueDate = billPaymentStatusModel2.getGmtDueDate();
            String dateTimeString = dateTimeUtil.getDateTimeString("d MMM", locale, gmtDueDate != null ? gmtDueDate.longValue() : -1L);
            Context context = itemManageBillsBinding.scheduleImpl.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            String KClassImpl$Data$declaredNonStaticMembers$2 = BillsAdapter.KClassImpl$Data$declaredNonStaticMembers$2(context, billPaymentStatusModel2, new Function1<Integer, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter$BillsManageViewHolder$bindData$1$paymentDateDescription$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    BillsAdapter.BillsManageViewHolder.this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
                }
            });
            if (KClassImpl$Data$declaredNonStaticMembers$2.length() > 0) {
                TextView textView2 = itemManageBillsBinding.moveToNextValue;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s • %s", Arrays.copyOf(new Object[]{dateTimeString, KClassImpl$Data$declaredNonStaticMembers$2}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "");
                textView2.setText(format);
                TextView textView3 = itemManageBillsBinding.moveToNextValue;
                Intrinsics.checkNotNullExpressionValue(textView3, "");
                TextViewExtKt.PlaceComponentResult(textView3, this.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2, false, new Function0<Unit>
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x014e: INVOKE 
                      (r2v26 'textView3' android.widget.TextView)
                      (wrap: int : 0x014c: IGET (r11v0 'this' id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter$BillsManageViewHolder A[IMMUTABLE_TYPE, THIS]) A[WRAPPED] (LINE:2320) id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter.BillsManageViewHolder.PlaceComponentResult int)
                      (r4v24 'KClassImpl$Data$declaredNonStaticMembers$2' java.lang.String)
                      false
                      (wrap: id.dana.core.ui.extension.TextViewExtKt$createColoredSpan$1 : 0x0000: SGET  A[WRAPPED] (LINE:61) id.dana.core.ui.extension.TextViewExtKt$createColoredSpan$1.INSTANCE id.dana.core.ui.extension.TextViewExtKt$createColoredSpan$1)
                     type: STATIC call: id.dana.core.ui.extension.TextViewExtKt.PlaceComponentResult(android.widget.TextView, int, java.lang.String, boolean, kotlin.jvm.functions.Function0):void A[MD:(android.widget.TextView, int, java.lang.String, boolean, kotlin.jvm.functions.Function0<kotlin.Unit>):void (m)] (LINE:57) in method: id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter.BillsManageViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.mybills.ui.model.BillPaymentStatusModel, int):void, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                    	at java.base/java.util.ArrayList.forEach(Unknown Source)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.core.ui.extension.TextViewExtKt$createColoredSpan$1.<init>():void, class status: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:791)
                    	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                    	... 21 more
                    */
                /*
                    Method dump skipped, instructions count: 420
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter.BillsManageViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.Object, int):void");
            }

            public static /* synthetic */ void getAuthRequestContext(BillsAdapter billsAdapter, BillPaymentStatusModel billPaymentStatusModel, View view) {
                Intrinsics.checkNotNullParameter(billsAdapter, "");
                Intrinsics.checkNotNullParameter(billPaymentStatusModel, "");
                Function2<View, BillPaymentStatusModel, Unit> function2 = billsAdapter.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(view, "");
                function2.invoke(view, billPaymentStatusModel);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/adapter/BillsAdapter$BillsPaymentConfirmViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "Lid/dana/mybills/databinding/ItemBillPaymentConfirmationBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/databinding/ItemBillPaymentConfirmationBinding;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/mybills/ui/v2/dashboard/adapter/BillsAdapter;Lid/dana/mybills/databinding/ItemBillPaymentConfirmationBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public final class BillsPaymentConfirmViewHolder extends BaseViewBindingViewHolder<BillPaymentStatusModel> {

            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
            private final ItemBillPaymentConfirmationBinding MyBillsEntityDataFactory;
            final /* synthetic */ BillsAdapter getAuthRequestContext;

            /* JADX WARN: Illegal instructions before constructor call */
            /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public BillsPaymentConfirmViewHolder(id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter r3, id.dana.mybills.databinding.ItemBillPaymentConfirmationBinding r4) {
                /*
                    r2 = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                    r2.getAuthRequestContext = r3
                    r3 = r4
                    androidx.viewbinding.ViewBinding r3 = (androidx.viewbinding.ViewBinding) r3
                    r0 = 0
                    r1 = 2
                    r2.<init>(r3, r0, r1, r0)
                    r2.MyBillsEntityDataFactory = r4
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter.BillsPaymentConfirmViewHolder.<init>(id.dana.mybills.ui.v2.dashboard.adapter.BillsAdapter, id.dana.mybills.databinding.ItemBillPaymentConfirmationBinding):void");
            }

            @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BillPaymentStatusModel billPaymentStatusModel, int i) {
                BillPaymentStatusModel billPaymentStatusModel2 = billPaymentStatusModel;
                Intrinsics.checkNotNullParameter(billPaymentStatusModel2, "");
                ItemBillPaymentConfirmationBinding itemBillPaymentConfirmationBinding = this.MyBillsEntityDataFactory;
                itemBillPaymentConfirmationBinding.lookAheadTest.setText(billPaymentStatusModel2.getSubscriptionTitle());
                TextView textView = itemBillPaymentConfirmationBinding.getErrorConfigVersion;
                MoneyViewModel totalAmount = billPaymentStatusModel2.getTotalAmount();
                textView.setText(totalAmount != null ? totalAmount.getDisplayAmount() : null);
                CircleImageView circleImageView = itemBillPaymentConfirmationBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(circleImageView, "");
                BillsAdapter.BuiltInFictitiousFunctionClassFactory(circleImageView, billPaymentStatusModel2.getIconUrl());
                CircleImageView circleImageView2 = itemBillPaymentConfirmationBinding.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(circleImageView2, "");
                CircleImageView circleImageView3 = circleImageView2;
                String recurringType = billPaymentStatusModel2.getRecurringType();
                if (recurringType == null) {
                    recurringType = "";
                }
                BillsAdapter.PlaceComponentResult(circleImageView3, recurringType);
                itemBillPaymentConfirmationBinding.getErrorConfigVersion.setVisibility(Intrinsics.areEqual(billPaymentStatusModel2.getPaidStatus(), PaidStatus.Confirm.INSTANCE) ? 0 : 8);
                TextView textView2 = itemBillPaymentConfirmationBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
                PaidStatus paidStatus = billPaymentStatusModel2.getPaidStatus();
                if (Intrinsics.areEqual(paidStatus, PaidStatus.Failed.INSTANCE)) {
                    textView2.setText(itemBillPaymentConfirmationBinding.moveToNextValue.getContext().getString(R.string.mybills_payment_status_failed));
                    textView2.setVisibility(0);
                    textView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(itemBillPaymentConfirmationBinding.moveToNextValue.getContext(), R.color.BuiltInFictitiousFunctionClassFactory_res_0x7f060124));
                } else if (Intrinsics.areEqual(paidStatus, PaidStatus.MarkAsPaid.INSTANCE)) {
                    textView2.setText(itemBillPaymentConfirmationBinding.moveToNextValue.getContext().getString(R.string.mybills_payment_status_marked_paid));
                    textView2.setVisibility(0);
                    textView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(itemBillPaymentConfirmationBinding.moveToNextValue.getContext(), R.color.KClassImpl$Data$declaredNonStaticMembers$2));
                } else if (Intrinsics.areEqual(paidStatus, PaidStatus.Success.INSTANCE)) {
                    textView2.setText(itemBillPaymentConfirmationBinding.moveToNextValue.getContext().getString(R.string.my_bills_label_paid));
                    textView2.setVisibility(0);
                    textView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(itemBillPaymentConfirmationBinding.moveToNextValue.getContext(), R.color.PlaceComponentResult_res_0x7f060020));
                } else if (Intrinsics.areEqual(paidStatus, PaidStatus.Confirm.INSTANCE)) {
                    textView2.setText("");
                    textView2.setVisibility(8);
                }
                itemBillPaymentConfirmationBinding.getAuthRequestContext.setVisibility(Intrinsics.areEqual(billPaymentStatusModel2.getPaidStatus(), PaidStatus.Failed.INSTANCE) ? 0 : 8);
            }
        }

        public static final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2(Context context, BillPaymentStatusModel billPaymentStatusModel, Function1 function1) {
            String string;
            if (billPaymentStatusModel.getRecurringType() == null) {
                return "";
            }
            if (billPaymentStatusModel.getNextScheduleDaysCount() != null && billPaymentStatusModel.getNextScheduleDaysCount().longValue() > 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string2 = context.getString(R.string.my_bills_next_schedule_payment_late);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                string = String.format(string2, Arrays.copyOf(new Object[]{billPaymentStatusModel.getNextScheduleDaysCount()}, 1));
                Intrinsics.checkNotNullExpressionValue(string, "");
                function1.invoke(Integer.valueOf(R.color.NetworkUserEntityData$$ExternalSyntheticLambda2));
            } else {
                Long nextScheduleDaysCount = billPaymentStatusModel.getNextScheduleDaysCount();
                if (nextScheduleDaysCount == null || nextScheduleDaysCount.longValue() != 0) {
                    return "";
                }
                string = context.getString(R.string.my_bills_next_schedule_payment_today);
                Intrinsics.checkNotNullExpressionValue(string, "");
                function1.invoke(Integer.valueOf(R.color.newProxyInstance));
            }
            return string;
        }

        public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ImageView imageView, String str) {
            GlideApp.getAuthRequestContext(imageView.getContext()).PlaceComponentResult(str).SubSequence().MyBillsEntityDataFactory(imageView);
        }

        public static final /* synthetic */ void PlaceComponentResult(ImageView imageView, String str) {
            GlideApp.getAuthRequestContext(imageView.getContext()).PlaceComponentResult(Integer.valueOf(Intrinsics.areEqual(str, RecurringType.REMINDER) ? R.drawable.ic_mybills_reminder : R.drawable.ic_mybills_auto_deduction)).SubSequence().MyBillsEntityDataFactory(imageView);
        }
    }
