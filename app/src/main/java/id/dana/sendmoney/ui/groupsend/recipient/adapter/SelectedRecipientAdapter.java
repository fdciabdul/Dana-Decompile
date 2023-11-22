package id.dana.sendmoney.ui.groupsend.recipient.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.core.ui.util.NumberUtil;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemSelectedContactBinding;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import id.dana.sendmoney.ui.groupsend.recipient.viewholder.SelectedRecipientViewHolder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/adapter/SelectedRecipientAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewholder/SelectedRecipientViewHolder;", "", "getAuthRequestContext", "()Ljava/util/List;", "Lkotlin/Function1;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelectedRecipientAdapter extends ListAdapter<RecipientViewModel, SelectedRecipientViewHolder> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Function1<? super RecipientViewModel, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        final SelectedRecipientViewHolder selectedRecipientViewHolder = (SelectedRecipientViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(selectedRecipientViewHolder, "");
        final RecipientViewModel recipientViewModel = (RecipientViewModel) this.BuiltInFictitiousFunctionClassFactory.moveToNextValue.get(i);
        if (recipientViewModel != null) {
            Intrinsics.checkNotNullParameter(recipientViewModel, "");
            ItemSelectedContactBinding itemSelectedContactBinding = selectedRecipientViewHolder.PlaceComponentResult;
            CircleImageView circleImageView = itemSelectedContactBinding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(circleImageView, "");
            SelectedRecipientViewHolder.PlaceComponentResult(circleImageView, recipientViewModel.scheduleImpl);
            TextView textView = itemSelectedContactBinding.KClassImpl$Data$declaredNonStaticMembers$2;
            String str = recipientViewModel.initRecordTimeStamp;
            Intrinsics.checkNotNullExpressionValue(str, "");
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "*", false, 2, (Object) null) || Intrinsics.areEqual(str, "-")) {
                str = selectedRecipientViewHolder.itemView.getContext().getString(R.string.res_0x7f1312c9_securitysettingsactivity_createpinlauncher_2_1);
            }
            Intrinsics.checkNotNullExpressionValue(str, "");
            textView.setText(str);
            TextView textView2 = itemSelectedContactBinding.moveToNextValue;
            NumberUtil numberUtil = NumberUtil.INSTANCE;
            String str2 = recipientViewModel.DatabaseTableConfigUtil;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            textView2.setText(NumberUtil.MyBillsEntityDataFactory(str2));
            AppCompatImageView appCompatImageView = itemSelectedContactBinding.getAuthRequestContext;
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.recipient.viewholder.SelectedRecipientViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectedRecipientViewHolder.BuiltInFictitiousFunctionClassFactory(SelectedRecipientViewHolder.this, recipientViewModel);
                }
            });
            appCompatImageView.setContentDescription(selectedRecipientViewHolder.itemView.getContext().getString(R.string.res_0x7f1302d1_networkuserentitydata_externalsyntheticlambda2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemSelectedContactBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemSelectedContactBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(viewGroup.getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return new SelectedRecipientViewHolder(KClassImpl$Data$declaredNonStaticMembers$2, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public SelectedRecipientAdapter() {
        super(RecipientViewModel.getCallingPid);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Function1<RecipientViewModel, Unit>() { // from class: id.dana.sendmoney.ui.groupsend.recipient.adapter.SelectedRecipientAdapter$onRemoveClickListener$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RecipientViewModel recipientViewModel) {
                Intrinsics.checkNotNullParameter(recipientViewModel, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RecipientViewModel recipientViewModel) {
                invoke2(recipientViewModel);
                return Unit.INSTANCE;
            }
        };
    }

    public final List<RecipientViewModel> getAuthRequestContext() {
        Iterable iterable = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(iterable, "");
        List<RecipientViewModel> sortedWith = CollectionsKt.sortedWith(iterable, new Comparator() { // from class: id.dana.sendmoney.ui.groupsend.recipient.adapter.SelectedRecipientAdapter$getSortedSelectedList$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((RecipientViewModel) t).initRecordTimeStamp, ((RecipientViewModel) t2).initRecordTimeStamp);
            }
        });
        ArrayList arrayList = new ArrayList();
        for (RecipientViewModel recipientViewModel : sortedWith) {
            NumberUtil numberUtil = NumberUtil.INSTANCE;
            String str = recipientViewModel.DatabaseTableConfigUtil;
            Intrinsics.checkNotNullExpressionValue(str, "");
            recipientViewModel.DatabaseTableConfigUtil = NumberUtil.NetworkUserEntityData$$ExternalSyntheticLambda1(str);
            arrayList.add(recipientViewModel);
        }
        return arrayList;
    }
}
