package id.dana.sendmoney_v2.recipient.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.paging.AsyncPagedListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BasePagedListAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.sendmoney.bank.all.CollapsibleSavedBankViewHolder;
import id.dana.sendmoney.bank.all.SendWithNewBankViewHolder;
import id.dana.sendmoney.contact.all.InviteDisableContactViewHolder;
import id.dana.sendmoney.contact.all.InviteEnableContactViewHolder;
import id.dana.sendmoney.contact.all.NoContactFoundViewHolder;
import id.dana.sendmoney.contact.all.SendWithPhoneNumberViewHolder;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.SectionViewHolder;
import id.dana.sendmoney.view.RecipientSelectedListener;
import id.dana.sendmoney_v2.contact.all.SendWithNewNumberSmartFrictionViewHolder;
import id.dana.sendmoney_v2.contact.all.SendWithNewNumberViewHolder;
import id.dana.sendmoney_v2.recipient.bank.viewholder.BankViewHolderV2;
import id.dana.sendmoney_v2.recipient.bank.viewholder.EmptySearchRecentBankViewHolder;
import id.dana.sendmoney_v2.recipient.bank.viewholder.EmptyStateViewHolder;
import id.dana.sendmoney_v2.recipient.bank.viewholder.SearchBankViewHolder;
import id.dana.sendmoney_v2.recipient.bank.viewholder.SendWithNewAccountNumberSmartFrictionViewHolder;
import id.dana.sendmoney_v2.recipient.bank.viewholder.SendWithNewAccountNumberViewHolder;
import id.dana.sendmoney_v2.recipient.groupsend.viewholder.GroupSendViewHolder;
import id.dana.sendmoney_v2.recipient.view.RecipientMoreActionListener;
import java.util.AbstractList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030%¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0010\u001a\u00020\f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0016\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0012\u0010\u0012\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u001c\u001a\u0004\u0018\u00010 X\u0086\u0002¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$"}, d2 = {"Lid/dana/sendmoney_v2/recipient/adapter/RecipientAdapter;", "Lid/dana/base/BasePagedListAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/sendmoney/model/RecipientViewModel;", "", "p0", "getItemViewType", "(I)I", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(I)Z", "Landroidx/recyclerview/widget/RecyclerView;", "", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "p1", "PlaceComponentResult", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "MyBillsEntityDataFactory", "(Lid/dana/base/BaseRecyclerViewHolder;)Z", "", "", "getAuthRequestContext", "Ljava/util/List;", "Z", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "Lid/dana/sendmoney_v2/recipient/view/RecipientMoreActionListener;", "lookAheadTest", "Lid/dana/sendmoney_v2/recipient/view/RecipientMoreActionListener;", "Lid/dana/sendmoney/view/RecipientSelectedListener;", "moveToNextValue", "Lid/dana/sendmoney/view/RecipientSelectedListener;", "getErrorConfigVersion", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecipientAdapter extends BasePagedListAdapter<BaseRecyclerViewHolder<RecipientViewModel>, RecipientViewModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public boolean getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public boolean MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public List<String> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private RecyclerView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public RecipientMoreActionListener lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public RecipientSelectedListener scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BasePagedListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((BaseRecyclerViewHolder) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        SectionViewHolder sectionViewHolder;
        InviteDisableContactViewHolder inviteDisableContactViewHolder;
        SendWithNewAccountNumberViewHolder sendWithNewAccountNumberViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        switch (i) {
            case 1:
            case 7:
            case 10:
            case 20:
            case 21:
            case 22:
            case 23:
            case 26:
                sectionViewHolder = new SectionViewHolder(viewGroup);
                break;
            case 2:
                sectionViewHolder = new BankViewHolderV2(viewGroup, this.scheduleImpl, this.lookAheadTest);
                break;
            case 3:
                if (this.getAuthRequestContext) {
                    inviteDisableContactViewHolder = new InviteEnableContactViewHolder(viewGroup, this.scheduleImpl, this.KClassImpl$Data$declaredNonStaticMembers$2);
                } else {
                    inviteDisableContactViewHolder = new InviteDisableContactViewHolder(viewGroup, this.scheduleImpl, this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                sectionViewHolder = (BaseRecyclerViewHolder) inviteDisableContactViewHolder;
                break;
            case 4:
            case 5:
            case 17:
            case 19:
                sectionViewHolder = new EmptyStateViewHolder(viewGroup);
                break;
            case 6:
            case 15:
            case 16:
            default:
                sectionViewHolder = new EmptyStateViewHolder(viewGroup);
                break;
            case 8:
                if (this.BuiltInFictitiousFunctionClassFactory) {
                    sectionViewHolder = new SendWithNewNumberSmartFrictionViewHolder(viewGroup, this.scheduleImpl);
                    break;
                } else {
                    sectionViewHolder = new SendWithNewNumberViewHolder(viewGroup, this.scheduleImpl);
                    break;
                }
            case 9:
                sectionViewHolder = new SendWithNewBankViewHolder(viewGroup);
                break;
            case 11:
                sectionViewHolder = new SendWithPhoneNumberViewHolder(viewGroup, "send_money");
                break;
            case 12:
                if (this.MyBillsEntityDataFactory) {
                    sendWithNewAccountNumberViewHolder = new SendWithNewAccountNumberSmartFrictionViewHolder(viewGroup, this.scheduleImpl);
                } else {
                    sendWithNewAccountNumberViewHolder = new SendWithNewAccountNumberViewHolder(viewGroup, this.scheduleImpl);
                }
                sectionViewHolder = (BaseRecyclerViewHolder) sendWithNewAccountNumberViewHolder;
                break;
            case 13:
            case 14:
                sectionViewHolder = new CollapsibleSavedBankViewHolder(viewGroup);
                break;
            case 18:
                sectionViewHolder = new EmptySearchRecentBankViewHolder(viewGroup);
                break;
            case 24:
                sectionViewHolder = new SearchBankViewHolder(viewGroup, this.scheduleImpl);
                break;
            case 25:
            case 27:
                sectionViewHolder = new GroupSendViewHolder(viewGroup);
                break;
        }
        return sectionViewHolder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecipientAdapter(DiffUtil.ItemCallback<RecipientViewModel> itemCallback) {
        super(itemCallback);
        Intrinsics.checkNotNullParameter(itemCallback, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttachedToRecyclerView(p0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0;
    }

    @Override // id.dana.base.BasePagedListAdapter
    /* renamed from: PlaceComponentResult */
    public final void onBindViewHolder(BaseRecyclerViewHolder<RecipientViewModel> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onBindViewHolder(p0, p1);
        if (KClassImpl$Data$declaredNonStaticMembers$2(p1) && MyBillsEntityDataFactory(p0)) {
            View view = p0.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "");
            if (!ViewCompat.getValueOfTouchPositionAbsolute(view) || view.isLayoutRequested()) {
                view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: id.dana.sendmoney_v2.recipient.adapter.RecipientAdapter$adjustViewHeight$$inlined$doOnLayout$1
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View p02, int p12, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
                        RecyclerView recyclerView;
                        Intrinsics.checkNotNullParameter(p02, "");
                        p02.removeOnLayoutChangeListener(this);
                        recyclerView = RecipientAdapter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (recyclerView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            recyclerView = null;
                        }
                        int height = recyclerView.getHeight() - p02.getBottom();
                        if (height > 0) {
                            p02.getLayoutParams().height = p02.getHeight() + height;
                            p02.requestLayout();
                            return;
                        }
                        p02.getLayoutParams().height = -1;
                        p02.requestLayout();
                    }
                });
                return;
            }
            RecyclerView recyclerView = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recyclerView = null;
            }
            int height = recyclerView.getHeight() - view.getBottom();
            if (height > 0) {
                view.getLayoutParams().height = view.getHeight() + height;
                view.requestLayout();
                return;
            }
            view.getLayoutParams().height = -1;
            view.requestLayout();
        }
    }

    private static boolean MyBillsEntityDataFactory(BaseRecyclerViewHolder<RecipientViewModel> baseRecyclerViewHolder) {
        return (baseRecyclerViewHolder instanceof EmptyStateViewHolder) || (baseRecyclerViewHolder instanceof EmptySearchRecentBankViewHolder) || (baseRecyclerViewHolder instanceof NoContactFoundViewHolder);
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        return getPlaceComponentResult() - 1 == p0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        if (getPlaceComponentResult() == 0) {
            return 5;
        }
        if (p0 < 0) {
            p0 = 0;
        }
        AsyncPagedListDiffer<T> asyncPagedListDiffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        AbstractList abstractList = asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (abstractList == null) {
            abstractList = asyncPagedListDiffer.moveToNextValue;
        }
        RecipientViewModel recipientViewModel = (RecipientViewModel) abstractList.get(p0);
        if (recipientViewModel != null) {
            return recipientViewModel.PrepareContext;
        }
        return 5;
    }
}
