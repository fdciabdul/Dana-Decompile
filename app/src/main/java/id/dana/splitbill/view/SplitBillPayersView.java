package id.dana.splitbill.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseRichView;
import id.dana.domain.account.Account;
import id.dana.model.CurrencyAmountModel;
import id.dana.splitbill.adapter.PayerViewHolder;
import id.dana.splitbill.adapter.SplitBillPayerAdapter;
import id.dana.splitbill.model.SplitBillPayerModel;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocaleUtil;
import id.dana.utils.NumberFormatterUtil;
import j$.util.Collection;
import j$.util.function.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class SplitBillPayersView extends BaseRichView {
    private String BuiltInFictitiousFunctionClassFactory;
    private List<SplitBillPayerModel> KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private SplitBillPayerModel NetworkUserEntityData$$ExternalSyntheticLambda0;
    private long PlaceComponentResult;
    private Listener getAuthRequestContext;
    private List<SplitBillPayerModel> getErrorConfigVersion;
    private SplitBillPayerAdapter lookAheadTest;
    private long moveToNextValue;
    @BindView(R.id.rv_split_bill_participant)
    RecyclerView rvPayers;

    /* loaded from: classes5.dex */
    public interface Listener {
        void onClickAddNewPayer();

        void onModifyingAmount(boolean z);

        void onRemainingUpdated(boolean z, String str);

        void onRemovePayer(SplitBillPayerModel splitBillPayerModel);

        void onSplitBillButtonEnabled(boolean z);
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_split_bill_payers;
    }

    public SplitBillPayersView(Context context) {
        super(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    }

    public SplitBillPayersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    }

    public SplitBillPayersView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    }

    public void setMaxSplitBillAmount(long j) {
        this.moveToNextValue = j;
    }

    public void setListener(Listener listener) {
        this.getAuthRequestContext = listener;
    }

    public void setAmount(long j) {
        this.PlaceComponentResult = j;
    }

    public void saveLockedPayer() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        for (SplitBillPayerModel splitBillPayerModel : this.getErrorConfigVersion) {
            if (splitBillPayerModel.PlaceComponentResult()) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.add(splitBillPayerModel);
            }
        }
    }

    public void updateAmount(long j) {
        setAmount(j);
        calculateAmount();
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.getErrorConfigVersion = new ArrayList();
        KeyboardHelper.PlaceComponentResult(this, new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.splitbill.view.SplitBillPayersView.2
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                SplitBillPayersView.this.getAuthRequestContext.onModifyingAmount(true);
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                SplitBillPayersView.this.getAuthRequestContext.onModifyingAmount(false);
                SplitBillPayersView.this.clearCurrentFocus();
            }
        });
    }

    public void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        SplitBillPayerAdapter splitBillPayerAdapter = new SplitBillPayerAdapter(this.moveToNextValue);
        this.lookAheadTest = splitBillPayerAdapter;
        splitBillPayerAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.splitbill.view.SplitBillPayersView$$ExternalSyntheticLambda3
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                SplitBillPayersView.$r8$lambda$Y6xnIr6MFj6t2Xp1Nsx55_7LriY(SplitBillPayersView.this, i);
            }
        });
        this.lookAheadTest.MyBillsEntityDataFactory = new PayerViewHolder.OnModifyPayerListener() { // from class: id.dana.splitbill.view.SplitBillPayersView.1
            @Override // id.dana.splitbill.adapter.PayerViewHolder.OnModifyPayerListener
            public final void BuiltInFictitiousFunctionClassFactory(int i) {
                if (i == 0) {
                    SplitBillPayersView.this.clearCurrentFocus();
                    SplitBillPayersView.access$000(SplitBillPayersView.this);
                    SplitBillPayersView.this.calculateAmount();
                    return;
                }
                SplitBillPayersView.access$100(SplitBillPayersView.this, i);
            }

            @Override // id.dana.splitbill.adapter.PayerViewHolder.OnModifyPayerListener
            public final void getAuthRequestContext(long j, int i) {
                if (i != -1) {
                    SplitBillPayersView.access$200(SplitBillPayersView.this, j, i);
                }
            }

            @Override // id.dana.splitbill.adapter.PayerViewHolder.OnModifyPayerListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                KeyboardHelper.BuiltInFictitiousFunctionClassFactory(SplitBillPayersView.this.getRootView());
            }
        };
        this.rvPayers.setLayoutManager(linearLayoutManager);
        this.rvPayers.setNestedScrollingEnabled(false);
        this.rvPayers.setItemAnimator(null);
        this.rvPayers.setAdapter(this.lookAheadTest);
        this.rvPayers.clearFocus();
    }

    private void PlaceComponentResult(int i) {
        if (getAuthRequestContext(i) && getPayerModels().get(i).PlaceComponentResult()) {
            this.MyBillsEntityDataFactory--;
        }
        getPayerModels().get(i).PlaceComponentResult = false;
    }

    private boolean getAuthRequestContext(int i) {
        return getPayerModels().get(i) != null;
    }

    public void setInitialData(Account account, boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = account.getUserId();
        String valueOf = z ? String.valueOf(this.PlaceComponentResult) : "0";
        SplitBillPayerModel.Builder builder = new SplitBillPayerModel.Builder();
        builder.scheduleImpl = account.getNickname();
        builder.getErrorConfigVersion = account.getUserId();
        builder.BuiltInFictitiousFunctionClassFactory = account.getPhoneNumber();
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = new CurrencyAmountModel(valueOf, "Rp");
        builder.getAuthRequestContext = account.getAvatarUrl();
        builder.PlaceComponentResult = true;
        SplitBillPayerModel splitBillPayerModel = new SplitBillPayerModel();
        splitBillPayerModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = builder.scheduleImpl;
        splitBillPayerModel.MyBillsEntityDataFactory = builder.getAuthRequestContext;
        splitBillPayerModel.lookAheadTest = builder.getErrorConfigVersion;
        splitBillPayerModel.scheduleImpl = builder.BuiltInFictitiousFunctionClassFactory;
        splitBillPayerModel.getAuthRequestContext = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        splitBillPayerModel.GetContactSyncConfig = builder.GetContactSyncConfig;
        splitBillPayerModel.PlaceComponentResult = builder.MyBillsEntityDataFactory;
        splitBillPayerModel.KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult;
        splitBillPayerModel.moveToNextValue = builder.lookAheadTest;
        splitBillPayerModel.BuiltInFictitiousFunctionClassFactory = builder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        splitBillPayerModel.getErrorConfigVersion = builder.moveToNextValue;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = splitBillPayerModel;
        this.getErrorConfigVersion.add(splitBillPayerModel);
        SplitBillPayerAdapter splitBillPayerAdapter = this.lookAheadTest;
        SplitBillPayerModel splitBillPayerModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        ArrayList arrayList = new ArrayList();
        arrayList.add(splitBillPayerModel2);
        arrayList.add(splitBillPayerAdapter.BuiltInFictitiousFunctionClassFactory);
        splitBillPayerAdapter.setItems(arrayList);
    }

    public void calculateAmount() {
        long lockedAmountTotal = this.PlaceComponentResult - getLockedAmountTotal();
        if (PlaceComponentResult() > 0) {
            long PlaceComponentResult = lockedAmountTotal / PlaceComponentResult();
            boolean z = false;
            long j = 0;
            for (int i = 0; i <= getTotalPayersCount() - 1; i++) {
                if (KClassImpl$Data$declaredNonStaticMembers$2(i) && !getPayerModels().get(i).MyBillsEntityDataFactory()) {
                    SplitBillPayerModel splitBillPayerModel = getPayerModels().get(i);
                    if (j == this.PlaceComponentResult || lockedAmountTotal <= 0) {
                        MyBillsEntityDataFactory(splitBillPayerModel, 0L);
                    } else {
                        j += PlaceComponentResult;
                        MyBillsEntityDataFactory(splitBillPayerModel, PlaceComponentResult);
                    }
                }
            }
            long j2 = lockedAmountTotal - j;
            if (j2 > 0) {
                int totalPayersCount = getTotalPayersCount();
                while (true) {
                    totalPayersCount--;
                    if (totalPayersCount < 0) {
                        break;
                    } else if (KClassImpl$Data$declaredNonStaticMembers$2(totalPayersCount)) {
                        SplitBillPayerModel splitBillPayerModel2 = getPayerModels().get(totalPayersCount);
                        MyBillsEntityDataFactory(splitBillPayerModel2, Long.parseLong(SplitBillPayerModel.getAuthRequestContext(splitBillPayerModel2.getAuthRequestContext) ? splitBillPayerModel2.getAuthRequestContext.MyBillsEntityDataFactory : "0") + j2);
                        MyBillsEntityDataFactory();
                        z = true;
                    }
                }
                if (!z) {
                    BuiltInFictitiousFunctionClassFactory();
                }
            } else if (j2 == 0) {
                MyBillsEntityDataFactory();
            } else {
                BuiltInFictitiousFunctionClassFactory();
            }
        } else {
            BuiltInFictitiousFunctionClassFactory();
        }
        Listener listener = this.getAuthRequestContext;
        if (listener != null) {
            listener.onSplitBillButtonEnabled(KClassImpl$Data$declaredNonStaticMembers$2());
        }
    }

    private int PlaceComponentResult() {
        int totalPayersCount = getTotalPayersCount() - this.MyBillsEntityDataFactory;
        return (this.getErrorConfigVersion.isEmpty() || !this.getErrorConfigVersion.get(0).MyBillsEntityDataFactory()) ? totalPayersCount : totalPayersCount - 1;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        return getAuthRequestContext(i) && !getPayerModels().get(i).PlaceComponentResult();
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        if (getLockedAmountTotal() - this.PlaceComponentResult == 0) {
            MyBillsEntityDataFactory();
        } else if (getLockedAmountTotal() < this.PlaceComponentResult) {
            BuiltInFictitiousFunctionClassFactory(String.format(getContext().getString(R.string.split_bill_remaining_message), NumberFormatterUtil.BuiltInFictitiousFunctionClassFactory(LocaleUtil.getAuthRequestContext(), this.PlaceComponentResult - getLockedAmountTotal(), "Rp")));
        } else if (getLockedAmountTotal() > this.PlaceComponentResult) {
            BuiltInFictitiousFunctionClassFactory(String.format(getContext().getString(R.string.split_bill_exceed_limit_message), NumberFormatterUtil.BuiltInFictitiousFunctionClassFactory(LocaleUtil.getAuthRequestContext(), getLockedAmountTotal() - this.PlaceComponentResult, "Rp")));
        }
    }

    public long getLockedAmountTotal() {
        long j = 0;
        for (SplitBillPayerModel splitBillPayerModel : getPayerModels()) {
            if (splitBillPayerModel.PlaceComponentResult()) {
                j += Long.valueOf(SplitBillPayerModel.getAuthRequestContext(splitBillPayerModel.getAuthRequestContext) ? splitBillPayerModel.getAuthRequestContext.MyBillsEntityDataFactory : "0").longValue();
            }
        }
        return j;
    }

    public List<SplitBillPayerModel> getPayerModels() {
        return this.getErrorConfigVersion;
    }

    public int getTotalPayersCount() {
        return this.getErrorConfigVersion.size();
    }

    public int getPayersCountOnly() {
        return isIncludeSelf() ? getTotalPayersCount() : (int) Collection.EL.getAuthRequestContext(this.getErrorConfigVersion).getAuthRequestContext(new Predicate() { // from class: id.dana.splitbill.view.SplitBillPayersView$$ExternalSyntheticLambda0
            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate negate() {
                return Predicate.CC.PlaceComponentResult(this);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return SplitBillPayersView.lambda$getPayersCountOnly$0((SplitBillPayerModel) obj);
            }
        }).GetContactSyncConfig();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$getPayersCountOnly$0(SplitBillPayerModel splitBillPayerModel) {
        return !splitBillPayerModel.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private void MyBillsEntityDataFactory(final SplitBillPayerModel splitBillPayerModel, long j) {
        splitBillPayerModel.getAuthRequestContext = new CurrencyAmountModel(String.valueOf(j), "Rp");
        this.rvPayers.post(new Runnable() { // from class: id.dana.splitbill.view.SplitBillPayersView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SplitBillPayersView.this.m2974xe02e3582(splitBillPayerModel);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setPayerAmount$1$id-dana-splitbill-view-SplitBillPayersView  reason: not valid java name */
    public /* synthetic */ void m2974xe02e3582(SplitBillPayerModel splitBillPayerModel) {
        this.lookAheadTest.notifyItemChanged(getPayerModels().indexOf(splitBillPayerModel));
    }

    private boolean getAuthRequestContext() {
        Iterator<SplitBillPayerModel> it = getPayerModels().iterator();
        while (it.hasNext()) {
            if (getAuthRequestContext(it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return (getAuthRequestContext() || this.lookAheadTest.getItemCount() - 1 <= 1 || getErrorConfigVersion()) ? false : true;
    }

    private static boolean getAuthRequestContext(SplitBillPayerModel splitBillPayerModel) {
        return (splitBillPayerModel == null || splitBillPayerModel.KClassImpl$Data$declaredNonStaticMembers$2() || splitBillPayerModel.getAuthRequestContext == null || !"0".equals(splitBillPayerModel.getAuthRequestContext.MyBillsEntityDataFactory)) ? false : true;
    }

    private void MyBillsEntityDataFactory() {
        String string = getAuthRequestContext() ? getContext().getString(R.string.split_bill_zero_amount_message) : "";
        Listener listener = this.getAuthRequestContext;
        if (listener != null) {
            listener.onRemainingUpdated(!TextUtils.isEmpty(string), string);
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(String str) {
        if (getAuthRequestContext()) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(". ");
            sb.append(getContext().getString(R.string.split_bill_zero_amount_message));
            str = sb.toString();
        } else if (getErrorConfigVersion()) {
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append(". ");
            sb2.append(String.format(getContext().getString(R.string.split_bill_max_amount_message), NumberFormatterUtil.BuiltInFictitiousFunctionClassFactory(LocaleUtil.getAuthRequestContext(), this.moveToNextValue, "Rp")));
            str = sb2.toString();
        }
        Listener listener = this.getAuthRequestContext;
        if (listener != null) {
            listener.onRemainingUpdated(true, str);
        }
    }

    private boolean getErrorConfigVersion() {
        return getTotalPayersAmount() > this.moveToNextValue;
    }

    public long getTotalPayersAmount() {
        long j = 0;
        for (SplitBillPayerModel splitBillPayerModel : getPayerModels()) {
            j += Long.valueOf(SplitBillPayerModel.getAuthRequestContext(splitBillPayerModel.getAuthRequestContext) ? splitBillPayerModel.getAuthRequestContext.MyBillsEntityDataFactory : "0").longValue();
        }
        return j;
    }

    public boolean isIncludeSelf() {
        return Collection.EL.getAuthRequestContext(this.getErrorConfigVersion).MyBillsEntityDataFactory(new Predicate() { // from class: id.dana.splitbill.view.SplitBillPayersView$$ExternalSyntheticLambda1
            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate negate() {
                return Predicate.CC.PlaceComponentResult(this);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                return SplitBillPayersView.lambda$isIncludeSelf$2((SplitBillPayerModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$isIncludeSelf$2(SplitBillPayerModel splitBillPayerModel) {
        return splitBillPayerModel.KClassImpl$Data$declaredNonStaticMembers$2() && splitBillPayerModel.getAuthRequestContext.getAuthRequestContext(new CurrencyAmountModel("0", splitBillPayerModel.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory));
    }

    public boolean isSameWithTotal() {
        return this.PlaceComponentResult == getTotalPayersAmount() || this.PlaceComponentResult == getLockedAmountTotal();
    }

    public void clearCurrentFocus() {
        if (this.rvPayers.findFocus() != null) {
            this.rvPayers.findFocus().clearFocus();
        }
    }

    public static /* synthetic */ void $r8$lambda$Y6xnIr6MFj6t2Xp1Nsx55_7LriY(SplitBillPayersView splitBillPayersView, int i) {
        if (splitBillPayersView.lookAheadTest.getItemViewType(i) == 1) {
            splitBillPayersView.clearCurrentFocus();
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(splitBillPayersView);
            Listener listener = splitBillPayersView.getAuthRequestContext;
            if (listener != null) {
                listener.onClickAddNewPayer();
            }
        }
    }

    static /* synthetic */ void access$000(SplitBillPayersView splitBillPayersView) {
        splitBillPayersView.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory = !splitBillPayersView.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory();
        splitBillPayersView.PlaceComponentResult(0);
        if (splitBillPayersView.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory()) {
            splitBillPayersView.MyBillsEntityDataFactory(splitBillPayersView.NetworkUserEntityData$$ExternalSyntheticLambda0, 0L);
        }
    }

    static /* synthetic */ void access$100(SplitBillPayersView splitBillPayersView, int i) {
        splitBillPayersView.PlaceComponentResult(i);
        Listener listener = splitBillPayersView.getAuthRequestContext;
        if (listener != null) {
            listener.onRemovePayer(splitBillPayersView.lookAheadTest.getItem(i));
        }
        splitBillPayersView.lookAheadTest.removeItem(i);
        splitBillPayersView.getErrorConfigVersion.remove(i);
        splitBillPayersView.calculateAmount();
    }

    static /* synthetic */ void access$200(SplitBillPayersView splitBillPayersView, long j, int i) {
        SplitBillPayerModel splitBillPayerModel = splitBillPayersView.getPayerModels().get(i);
        if (!splitBillPayerModel.PlaceComponentResult()) {
            splitBillPayerModel.PlaceComponentResult = true;
            splitBillPayersView.MyBillsEntityDataFactory++;
        }
        splitBillPayersView.MyBillsEntityDataFactory(splitBillPayerModel, j);
        splitBillPayersView.calculateAmount();
    }

    public void addPayers(List<SplitBillPayerModel> list) {
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty() && !list.isEmpty()) {
            Iterator<SplitBillPayerModel> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
            while (it.hasNext()) {
                SplitBillPayerModel next = it.next();
                Iterator<SplitBillPayerModel> it2 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        SplitBillPayerModel next2 = it2.next();
                        if (next2.equals(next)) {
                            next2.PlaceComponentResult = next.PlaceComponentResult();
                            next2.getAuthRequestContext = next.getAuthRequestContext;
                            it.remove();
                            break;
                        }
                    }
                }
            }
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        this.MyBillsEntityDataFactory = 0;
        Iterator<SplitBillPayerModel> it3 = this.getErrorConfigVersion.iterator();
        while (it3.hasNext()) {
            if (it3.next().PlaceComponentResult()) {
                this.MyBillsEntityDataFactory++;
            }
        }
        this.lookAheadTest.BuiltInFictitiousFunctionClassFactory(list);
        this.getErrorConfigVersion.clear();
        this.getErrorConfigVersion.addAll(this.lookAheadTest.getItems());
        this.getErrorConfigVersion.remove(this.lookAheadTest.getItemCount() - 1);
        calculateAmount();
    }
}
