package id.dana.richview.splitbill;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSelectedPayerComponent;
import id.dana.model.SelectedPayerModule;
import id.dana.richview.splitbill.SelectedPayerContract;
import id.dana.richview.splitbill.adapter.SelectedPayerAdapter;
import id.dana.scanner.ScannerActivity;
import id.dana.scanner.handler.ScannerActionFactory;
import id.dana.scanner.handler.nativepages.ScannerSceneType;
import id.dana.sendmoney.RecentDetailView;
import id.dana.sendmoney.model.RecipientModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SelectedPayerView extends BaseRichView {
    private List<RecipientModel> KClassImpl$Data$declaredNonStaticMembers$2;
    private List<RecipientModel> MyBillsEntityDataFactory;
    private Listener PlaceComponentResult;
    @Inject
    SelectedPayerContract.Presenter presenter;
    @BindView(R.id.rdv_scanner)
    RecentDetailView rdvScanner;
    @BindView(R.id.rv_selected_payers)
    RecyclerView rvSelectedPayers;
    SelectedPayerAdapter selectedPayerAdapter;
    @BindView(R.id.tv_count_payers)
    TextView tvCountPayers;

    /* loaded from: classes5.dex */
    public interface Listener {
        void MyBillsEntityDataFactory(RecipientModel recipientModel);

        void PlaceComponentResult(RecipientModel recipientModel);
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_selected_payer;
    }

    public SelectedPayerView(Context context) {
        super(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    }

    public SelectedPayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    }

    public SelectedPayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    }

    public SelectedPayerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        super.injectComponent(applicationComponent);
        DaggerSelectedPayerComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerSelectedPayerComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (SelectedPayerModule) Preconditions.getAuthRequestContext(new SelectedPayerModule(new SelectedPayerContract.View() { // from class: id.dana.richview.splitbill.SelectedPayerView$$ExternalSyntheticLambda0
            @Override // id.dana.richview.splitbill.SelectedPayerContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List list) {
                SelectedPayerView.this.m2862xe3065d5d(list);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, SelectedPayerModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, ApplicationComponent.class);
        new DaggerSelectedPayerComponent.SelectedPayerComponentImpl(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(this.presenter);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        this.rdvScanner.setView(getContext().getString(R.string.scan_qr_send_money_title), getContext().getString(R.string.scan_code), (String) null, "scanner");
        this.rdvScanner.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.splitbill.SelectedPayerView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectedPayerView.this.m2863x2c5573d8(view);
            }
        });
        this.rdvScanner.setContentDescription(getResources().getString(R.string.btnScanQr));
        this.rvSelectedPayers.setLayoutManager(linearLayoutManager);
        this.rvSelectedPayers.setNestedScrollingEnabled(false);
        SelectedPayerAdapter selectedPayerAdapter = new SelectedPayerAdapter();
        this.selectedPayerAdapter = selectedPayerAdapter;
        selectedPayerAdapter.MyBillsEntityDataFactory = new SelectedPayerAdapter.Listener() { // from class: id.dana.richview.splitbill.SelectedPayerView.1
            @Override // id.dana.richview.splitbill.adapter.SelectedPayerAdapter.Listener
            public final void BuiltInFictitiousFunctionClassFactory(RecipientModel recipientModel) {
                if (SelectedPayerView.this.PlaceComponentResult != null) {
                    SelectedPayerView.this.PlaceComponentResult.PlaceComponentResult(recipientModel);
                }
            }

            @Override // id.dana.richview.splitbill.adapter.SelectedPayerAdapter.Listener
            public final void PlaceComponentResult(RecipientModel recipientModel) {
                if (SelectedPayerView.this.PlaceComponentResult != null) {
                    SelectedPayerView.this.PlaceComponentResult.MyBillsEntityDataFactory(recipientModel);
                }
            }
        };
        this.rvSelectedPayers.setAdapter(this.selectedPayerAdapter);
        ArrayList arrayList = new ArrayList();
        this.MyBillsEntityDataFactory = arrayList;
        this.selectedPayerAdapter.setItems(arrayList);
        this.presenter.BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSelectedPayerModule$0$id-dana-richview-splitbill-SelectedPayerView  reason: not valid java name */
    public /* synthetic */ void m2862xe3065d5d(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                RecipientModel recipientModel = (RecipientModel) it.next();
                if (recipientModel != null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.add(recipientModel);
                }
            }
            addRecentPayers(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    public void setSelectedPayers(List<RecipientModel> list) {
        this.MyBillsEntityDataFactory.clear();
        this.MyBillsEntityDataFactory.addAll(list);
        this.selectedPayerAdapter.setItems(this.MyBillsEntityDataFactory);
    }

    public void addSelectedPayer(int i, RecipientModel recipientModel) {
        if (this.MyBillsEntityDataFactory.isEmpty()) {
            this.MyBillsEntityDataFactory.add(recipientModel);
            this.selectedPayerAdapter.notifyDataSetChanged();
            return;
        }
        this.MyBillsEntityDataFactory.add(i, recipientModel);
        this.selectedPayerAdapter.notifyDataSetChanged();
    }

    public void removeSelectedPayer(RecipientModel recipientModel) {
        if (this.MyBillsEntityDataFactory.indexOf(recipientModel) != -1) {
            this.selectedPayerAdapter.removeItem(this.MyBillsEntityDataFactory.indexOf(recipientModel));
        }
    }

    public void updatePayerFromSelectedToRecent(RecipientModel recipientModel) {
        if (this.MyBillsEntityDataFactory.indexOf(recipientModel) != -1) {
            this.selectedPayerAdapter.removeItem(this.MyBillsEntityDataFactory.indexOf(recipientModel));
            for (RecipientModel recipientModel2 : this.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (recipientModel2.initRecordTimeStamp()) {
                    this.MyBillsEntityDataFactory.remove(recipientModel2);
                }
            }
            for (RecipientModel recipientModel3 : this.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (recipientModel3.initRecordTimeStamp()) {
                    this.MyBillsEntityDataFactory.add(recipientModel3);
                }
            }
            this.selectedPayerAdapter.notifyDataSetChanged();
        }
    }

    public void updatePayerFromRecentToSelected(int i, RecipientModel recipientModel) {
        if (this.MyBillsEntityDataFactory.indexOf(recipientModel) != -1) {
            this.selectedPayerAdapter.removeItem(this.MyBillsEntityDataFactory.indexOf(recipientModel));
            this.MyBillsEntityDataFactory.add(i, recipientModel);
            this.selectedPayerAdapter.notifyDataSetChanged();
        }
    }

    public void addRecentPayers(List<RecipientModel> list) {
        if (list.isEmpty()) {
            return;
        }
        this.MyBillsEntityDataFactory.addAll(list);
        this.selectedPayerAdapter.notifyDataSetChanged();
    }

    public List<RecipientModel> getPayersList() {
        return this.MyBillsEntityDataFactory;
    }

    public void setPayersCount(int i) {
        if (i > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(getContext().getString(R.string.split_bill_with_people));
            sb.append(" ");
            sb.append(getContext().getResources().getQuantityString(R.plurals.f46712131820557, i, Integer.valueOf(i)));
            String obj = sb.toString();
            this.tvCountPayers.setVisibility(0);
            this.tvCountPayers.setText(obj);
            return;
        }
        this.tvCountPayers.setVisibility(8);
    }

    public void setListener(Listener listener) {
        this.PlaceComponentResult = listener;
    }

    public boolean isRecentPayer(RecipientModel recipientModel) {
        if (TextUtils.isEmpty(recipientModel.getErrorConfigVersion)) {
            return false;
        }
        Iterator<RecipientModel> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it.hasNext()) {
            if (recipientModel.getErrorConfigVersion.equals(it.next().getErrorConfigVersion)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initScanner$1$id-dana-richview-splitbill-SelectedPayerView  reason: not valid java name */
    public /* synthetic */ void m2863x2c5573d8(View view) {
        Activity activity = (Activity) getContext();
        Intent intent = new Intent(activity, ScannerActivity.class);
        intent.putExtra("source", "Split Bill");
        intent.putExtra(ScannerActivity.FROM_VIEW_TYPE, "split_bill");
        intent.putExtra("scene", ScannerSceneType.SCENE_SPLIT_BILL);
        activity.startActivityForResult(intent, ScannerActionFactory.BuiltInFictitiousFunctionClassFactory);
    }

    public void setRecentPayerDisplay(RecipientModel recipientModel, boolean z) {
        if (TextUtils.isEmpty(recipientModel.getErrorConfigVersion)) {
            return;
        }
        for (RecipientModel recipientModel2 : this.KClassImpl$Data$declaredNonStaticMembers$2) {
            if (recipientModel.getErrorConfigVersion.equals(recipientModel2.getErrorConfigVersion)) {
                recipientModel2.readMicros = z ? "recentContacts" : "contact";
                recipientModel2.isLayoutRequested = z;
                return;
            }
        }
    }
}
