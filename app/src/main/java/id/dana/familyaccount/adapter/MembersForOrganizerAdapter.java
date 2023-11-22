package id.dana.familyaccount.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.google.android.material.card.MaterialCardView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.databinding.ItemGridAddMemberFamilyAccountBinding;
import id.dana.databinding.ItemGridMemberFamilyAccountBinding;
import id.dana.domain.familyaccount.model.AvailableServicesConfig;
import id.dana.familyaccount.adapter.MembersForOrganizerAdapter;
import id.dana.familyaccount.constants.FamilyAccountInvitationStatusType;
import id.dana.familyaccount.model.FamilyMemberInfoModel;
import id.dana.familyaccount.model.LimitInfoModel;
import id.dana.familyaccount.model.MemberInfoModel;
import id.dana.familyaccount.util.MemberServiceItemDecorator;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.richview.CircleImageSelectionView;
import id.dana.utils.SafeClickListenerExtensionKt;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0004\u001f\u001e !B+\u0012\u0006\u0010\u0005\u001a\u00020\u0019\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR&\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R&\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001a"}, d2 = {"Lid/dana/familyaccount/adapter/MembersForOrganizerAdapter;", "Lid/dana/core/ui/recyclerview/BaseRecyclerViewDiffUtilAdapter;", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Landroid/view/LayoutInflater;", "p0", "Landroid/view/ViewGroup;", "p1", "", "p2", "PlaceComponentResult", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "getItemViewType", "(I)I", "getAuthRequestContext", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "Ljava/util/ArrayList;", "Lid/dana/domain/familyaccount/model/AvailableServicesConfig;", "Lkotlin/collections/ArrayList;", "MyBillsEntityDataFactory", "Ljava/util/ArrayList;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function2;", "", "Lkotlin/jvm/functions/Function2;", "Lid/dana/familyaccount/adapter/MembersForOrganizerAdapter$OrganizerClickListener;", "Lid/dana/familyaccount/adapter/MembersForOrganizerAdapter$OrganizerClickListener;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/familyaccount/adapter/MembersForOrganizerAdapter$OrganizerClickListener;Lkotlin/jvm/functions/Function2;)V", "Companion", "AddMemberForOrganizerViewHolder", "MembersForOrganizerViewHolder", "OrganizerClickListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MembersForOrganizerAdapter extends BaseRecyclerViewDiffUtilAdapter<FamilyMemberInfoModel, BaseViewBindingViewHolder<FamilyMemberInfoModel>> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final OrganizerClickListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public ArrayList<AvailableServicesConfig> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function2<FamilyMemberInfoModel, Integer, Unit> MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public FamilyMemberInfoModel PlaceComponentResult;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/familyaccount/adapter/MembersForOrganizerAdapter$OrganizerClickListener;", "", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/familyaccount/model/FamilyMemberInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OrganizerClickListener {
        void KClassImpl$Data$declaredNonStaticMembers$2(FamilyMemberInfoModel p0);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", BridgeDSL.INVOKE, "(Lid/dana/familyaccount/model/FamilyMemberInfoModel;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.familyaccount.adapter.MembersForOrganizerAdapter$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static final class AnonymousClass1 extends Lambda implements Function2<FamilyMemberInfoModel, Integer, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(2);
        }

        public final void invoke(FamilyMemberInfoModel familyMemberInfoModel, int i) {
            Intrinsics.checkNotNullParameter(familyMemberInfoModel, "");
        }

        @Override // kotlin.jvm.functions.Function2
        public final /* synthetic */ Unit invoke(FamilyMemberInfoModel familyMemberInfoModel, Integer num) {
            invoke(familyMemberInfoModel, num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MembersForOrganizerAdapter(OrganizerClickListener organizerClickListener, Function2<? super FamilyMemberInfoModel, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(organizerClickListener, "");
        Intrinsics.checkNotNullParameter(function2, "");
        this.BuiltInFictitiousFunctionClassFactory = organizerClickListener;
        this.MyBillsEntityDataFactory = function2;
        this.PlaceComponentResult = new FamilyMemberInfoModel("", new MemberInfoModel("", "", "", "", "", "", ""), FamilyAccountInvitationStatusType.ADD_MEMBER, "", new LimitInfoModel(CollectionsKt.emptyList(), new MoneyViewModel(null, null, null, 7, null)));
    }

    @Override // id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter
    public final BaseViewBindingViewHolder<FamilyMemberInfoModel> PlaceComponentResult(LayoutInflater p0, ViewGroup p1, int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (p2 == 1) {
            ItemGridAddMemberFamilyAccountBinding authRequestContext = ItemGridAddMemberFamilyAccountBinding.getAuthRequestContext(LayoutInflater.from(p1.getContext()), p1);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            return new AddMemberForOrganizerViewHolder(this, authRequestContext, this.MyBillsEntityDataFactory);
        }
        ItemGridMemberFamilyAccountBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemGridMemberFamilyAccountBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(p1.getContext()), p1);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return new MembersForOrganizerViewHolder(this, KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        String str;
        FamilyMemberInfoModel authRequestContext = getAuthRequestContext(p0);
        if (authRequestContext == null || (str = authRequestContext.PlaceComponentResult) == null) {
            return 0;
        }
        return str.length() == 0 ? 1 : 0;
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B3\u0012\u0006\u0010\u0004\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u001a\b\u0002\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/familyaccount/adapter/MembersForOrganizerAdapter$MembersForOrganizerViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "", "p0", "", "PlaceComponentResult", "(Z)I", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Z", "Lid/dana/familyaccount/model/LimitInfoModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/familyaccount/model/LimitInfoModel;)Z", "Lid/dana/databinding/ItemGridMemberFamilyAccountBinding;", "Lid/dana/databinding/ItemGridMemberFamilyAccountBinding;", "Lid/dana/familyaccount/adapter/MembersForOrganizerAdapter$OrganizerClickListener;", "MyBillsEntityDataFactory", "Lid/dana/familyaccount/adapter/MembersForOrganizerAdapter$OrganizerClickListener;", "getAuthRequestContext", "p1", "Lkotlin/Function2;", "", "p2", "<init>", "(Lid/dana/familyaccount/adapter/MembersForOrganizerAdapter;Lid/dana/databinding/ItemGridMemberFamilyAccountBinding;Lid/dana/familyaccount/adapter/MembersForOrganizerAdapter$OrganizerClickListener;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class MembersForOrganizerViewHolder extends BaseViewBindingViewHolder<FamilyMemberInfoModel> {
        final /* synthetic */ MembersForOrganizerAdapter KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        private final OrganizerClickListener getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final ItemGridMemberFamilyAccountBinding KClassImpl$Data$declaredNonStaticMembers$2;

        public static /* synthetic */ int BuiltInFictitiousFunctionClassFactory(int i, int i2) {
            return (i - i2) - 1;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MembersForOrganizerViewHolder(MembersForOrganizerAdapter membersForOrganizerAdapter, ItemGridMemberFamilyAccountBinding itemGridMemberFamilyAccountBinding, OrganizerClickListener organizerClickListener, Function2<? super FamilyMemberInfoModel, ? super Integer, Unit> function2) {
            super(itemGridMemberFamilyAccountBinding, function2);
            Intrinsics.checkNotNullParameter(itemGridMemberFamilyAccountBinding, "");
            Intrinsics.checkNotNullParameter(organizerClickListener, "");
            Intrinsics.checkNotNullParameter(function2, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = membersForOrganizerAdapter;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = itemGridMemberFamilyAccountBinding;
            this.getAuthRequestContext = organizerClickListener;
        }

        @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FamilyMemberInfoModel familyMemberInfoModel, int i) {
            LimitInfoModel limitInfoModel;
            String format;
            String format2;
            String format3;
            TextView textView;
            final FamilyMemberInfoModel familyMemberInfoModel2 = familyMemberInfoModel;
            String str = "";
            Intrinsics.checkNotNullParameter(familyMemberInfoModel2, "");
            super.KClassImpl$Data$declaredNonStaticMembers$2((MembersForOrganizerViewHolder) familyMemberInfoModel2, i);
            ItemGridMemberFamilyAccountBinding itemGridMemberFamilyAccountBinding = this.KClassImpl$Data$declaredNonStaticMembers$2;
            MembersForOrganizerAdapter membersForOrganizerAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
            CircleImageSelectionView circleImageSelectionView = itemGridMemberFamilyAccountBinding.MyBillsEntityDataFactory;
            circleImageSelectionView.loadImage(familyMemberInfoModel2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, R.drawable.ic_avatar_grey_default);
            circleImageSelectionView.setBorderColor(R.drawable.bg_grey_circle);
            itemGridMemberFamilyAccountBinding.getErrorConfigVersion.setText(familyMemberInfoModel2.PlaceComponentResult());
            CircleImageView circleImageView = itemGridMemberFamilyAccountBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(circleImageView, "");
            circleImageView.setVisibility(BuiltInFictitiousFunctionClassFactory(familyMemberInfoModel2.MyBillsEntityDataFactory) ? 0 : 8);
            TextView textView2 = itemGridMemberFamilyAccountBinding.scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(textView2, "");
            String str2 = familyMemberInfoModel2.MyBillsEntityDataFactory;
            LimitInfoModel limitInfoModel2 = familyMemberInfoModel2.KClassImpl$Data$declaredNonStaticMembers$2;
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "");
            String upperCase = str2.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            int hashCode = upperCase.hashCode();
            if (hashCode == -2024440166) {
                if (upperCase.equals("MEMBER")) {
                    boolean KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(limitInfoModel2);
                    MoneyViewModel moneyViewModel = limitInfoModel2.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (KClassImpl$Data$declaredNonStaticMembers$2) {
                        format2 = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getContext().getString(R.string.family_account_text_set_transaction_limit);
                        Intrinsics.checkNotNullExpressionValue(format2, "");
                        limitInfoModel = limitInfoModel2;
                    } else {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String string = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getContext().getString(R.string.dashboard_member_limit);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        Object[] objArr = new Object[1];
                        StringBuilder sb = new StringBuilder();
                        sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                        limitInfoModel = limitInfoModel2;
                        format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
                        if (format == null) {
                            format = "";
                        }
                        sb.append(format);
                        objArr[0] = sb.toString();
                        format2 = String.format(string, Arrays.copyOf(objArr, 1));
                        Intrinsics.checkNotNullExpressionValue(format2, "");
                    }
                    textView2.setText(format2);
                    textView2.setTextColor(PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2(limitInfoModel)));
                }
                textView2.setText("");
            } else if (hashCode == 35394935) {
                if (upperCase.equals("PENDING")) {
                    textView2.setText(textView2.getContext().getString(R.string.dashboard_member_status_pending_waiting));
                    textView2.setTextColor(PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2(limitInfoModel2)));
                }
                textView2.setText("");
            } else {
                if (hashCode == 1698997952 && upperCase.equals(FamilyAccountInvitationStatusType.ACCOUNT_OWNER)) {
                    textView2.setText(textView2.getContext().getString(R.string.dashboard_member_status_owner));
                }
                textView2.setText("");
            }
            TextView textView3 = itemGridMemberFamilyAccountBinding.getAuthRequestContext;
            String str3 = familyMemberInfoModel2.MyBillsEntityDataFactory;
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "");
            String upperCase2 = str3.toUpperCase(locale2);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "");
            textView3.setVisibility(Intrinsics.areEqual(upperCase2, "PENDING") ? 0 : 4);
            Intrinsics.checkNotNullExpressionValue(textView3, "");
            SafeClickListenerExtensionKt.MyBillsEntityDataFactory(textView3, new Function1<View, Unit>() { // from class: id.dana.familyaccount.adapter.MembersForOrganizerAdapter$MembersForOrganizerViewHolder$bindData$1$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    MembersForOrganizerAdapter.OrganizerClickListener organizerClickListener;
                    Intrinsics.checkNotNullParameter(view, "");
                    organizerClickListener = MembersForOrganizerAdapter.MembersForOrganizerViewHolder.this.getAuthRequestContext;
                    organizerClickListener.KClassImpl$Data$declaredNonStaticMembers$2(familyMemberInfoModel2);
                }
            });
            TextView textView4 = itemGridMemberFamilyAccountBinding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(textView4, "");
            if ((textView4.getVisibility() == 0) && (textView = itemGridMemberFamilyAccountBinding.getErrorConfigVersion) != null) {
                textView.setMaxLines(1);
            }
            RecyclerView recyclerView = itemGridMemberFamilyAccountBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            String str4 = familyMemberInfoModel2.MyBillsEntityDataFactory;
            Locale locale3 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale3, "");
            String upperCase3 = str4.toUpperCase(locale3);
            Intrinsics.checkNotNullExpressionValue(upperCase3, "");
            recyclerView.setVisibility(Intrinsics.areEqual(upperCase3, "MEMBER") ? 0 : 8);
            recyclerView.addItemDecoration(new MemberServiceItemDecorator());
            recyclerView.setChildDrawingOrderCallback(new RecyclerView.ChildDrawingOrderCallback() { // from class: id.dana.familyaccount.adapter.MembersForOrganizerAdapter$MembersForOrganizerViewHolder$$ExternalSyntheticLambda0
                @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
                public final int BuiltInFictitiousFunctionClassFactory(int i2, int i3) {
                    return MembersForOrganizerAdapter.MembersForOrganizerViewHolder.BuiltInFictitiousFunctionClassFactory(i2, i3);
                }
            });
            MemberAvailableServiceAdapter memberAvailableServiceAdapter = new MemberAvailableServiceAdapter(familyMemberInfoModel2.KClassImpl$Data$declaredNonStaticMembers$2);
            ArrayList arrayList = new ArrayList();
            ArrayList<AvailableServicesConfig> arrayList2 = membersForOrganizerAdapter.KClassImpl$Data$declaredNonStaticMembers$2;
            if (arrayList2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                arrayList2 = null;
            }
            for (AvailableServicesConfig availableServicesConfig : arrayList2) {
                if (familyMemberInfoModel2.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.contains(availableServicesConfig.getUseCase())) {
                    arrayList.add(availableServicesConfig);
                }
            }
            BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(memberAvailableServiceAdapter, arrayList);
            recyclerView.setAdapter(memberAvailableServiceAdapter);
            MaterialCardView materialCardView = itemGridMemberFamilyAccountBinding.PlaceComponentResult;
            String str5 = familyMemberInfoModel2.MyBillsEntityDataFactory;
            Locale locale4 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale4, "");
            String upperCase4 = str5.toUpperCase(locale4);
            Intrinsics.checkNotNullExpressionValue(upperCase4, "");
            if (Intrinsics.areEqual(upperCase4, FamilyAccountInvitationStatusType.ACCOUNT_OWNER)) {
                format3 = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getContext().getString(R.string.btn_account_owner);
                Intrinsics.checkNotNullExpressionValue(format3, "");
            } else {
                if (Intrinsics.areEqual(upperCase4, "MEMBER")) {
                    String string2 = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getContext().getString(R.string.dashboard_member_status_member);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    format3 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(getBindingAdapterPosition())}, 1));
                    Intrinsics.checkNotNullExpressionValue(format3, "");
                }
                materialCardView.setContentDescription(str);
            }
            str = format3;
            materialCardView.setContentDescription(str);
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", BridgeDSL.INVOKE, "(Lid/dana/familyaccount/model/FamilyMemberInfoModel;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: id.dana.familyaccount.adapter.MembersForOrganizerAdapter$MembersForOrganizerViewHolder$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        static final class AnonymousClass1 extends Lambda implements Function2<FamilyMemberInfoModel, Integer, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(2);
            }

            public final void invoke(FamilyMemberInfoModel familyMemberInfoModel, int i) {
                Intrinsics.checkNotNullParameter(familyMemberInfoModel, "");
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(FamilyMemberInfoModel familyMemberInfoModel, Integer num) {
                invoke(familyMemberInfoModel, num.intValue());
                return Unit.INSTANCE;
            }
        }

        private final int PlaceComponentResult(boolean p0) {
            if (p0) {
                return ContextCompat.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getContext(), R.color.f25442131100151);
            }
            return ContextCompat.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.getContext(), R.color.f23982131099995);
        }

        private static boolean BuiltInFictitiousFunctionClassFactory(String p0) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "");
            String upperCase = p0.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            return Intrinsics.areEqual(upperCase, FamilyAccountInvitationStatusType.ACCOUNT_OWNER);
        }

        private static boolean KClassImpl$Data$declaredNonStaticMembers$2(LimitInfoModel p0) {
            if (p0.BuiltInFictitiousFunctionClassFactory.isEmpty()) {
                return p0.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.length() == 0;
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R&\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/familyaccount/adapter/MembersForOrganizerAdapter$AddMemberForOrganizerViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "Lid/dana/databinding/ItemGridAddMemberFamilyAccountBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/databinding/ItemGridAddMemberFamilyAccountBinding;", "Lkotlin/Function2;", "", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function2;", "getAuthRequestContext", "p0", "p1", "<init>", "(Lid/dana/familyaccount/adapter/MembersForOrganizerAdapter;Lid/dana/databinding/ItemGridAddMemberFamilyAccountBinding;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class AddMemberForOrganizerViewHolder extends BaseViewBindingViewHolder<FamilyMemberInfoModel> {
        private final ItemGridAddMemberFamilyAccountBinding BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ MembersForOrganizerAdapter MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final Function2<FamilyMemberInfoModel, Integer, Unit> getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AddMemberForOrganizerViewHolder(MembersForOrganizerAdapter membersForOrganizerAdapter, ItemGridAddMemberFamilyAccountBinding itemGridAddMemberFamilyAccountBinding, Function2<? super FamilyMemberInfoModel, ? super Integer, Unit> function2) {
            super(itemGridAddMemberFamilyAccountBinding, function2);
            Intrinsics.checkNotNullParameter(itemGridAddMemberFamilyAccountBinding, "");
            Intrinsics.checkNotNullParameter(function2, "");
            this.MyBillsEntityDataFactory = membersForOrganizerAdapter;
            this.BuiltInFictitiousFunctionClassFactory = itemGridAddMemberFamilyAccountBinding;
            this.getAuthRequestContext = function2;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", BridgeDSL.INVOKE, "(Lid/dana/familyaccount/model/FamilyMemberInfoModel;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: id.dana.familyaccount.adapter.MembersForOrganizerAdapter$AddMemberForOrganizerViewHolder$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        static final class AnonymousClass1 extends Lambda implements Function2<FamilyMemberInfoModel, Integer, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(2);
            }

            public final void invoke(FamilyMemberInfoModel familyMemberInfoModel, int i) {
                Intrinsics.checkNotNullParameter(familyMemberInfoModel, "");
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(FamilyMemberInfoModel familyMemberInfoModel, Integer num) {
                invoke(familyMemberInfoModel, num.intValue());
                return Unit.INSTANCE;
            }
        }
    }
}
