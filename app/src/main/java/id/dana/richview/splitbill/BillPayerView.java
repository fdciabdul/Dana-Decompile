package id.dana.richview.splitbill;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.data.util.NumberUtils;
import id.dana.richview.SearchView;
import id.dana.richview.contactselector.ContactSelectorView;
import id.dana.richview.splitbill.SelectedPayerView;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.view.BaseRecipientListener;
import id.dana.utils.KeyboardHelper;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class BillPayerView extends BaseRichView {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private final long KClassImpl$Data$declaredNonStaticMembers$2;
    private BottomSheetBehavior MyBillsEntityDataFactory;
    private List<RecipientModel> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Listener PlaceComponentResult;
    @BindView(R.id.view_contact_selector)
    ContactSelectorView contactSelectorView;
    @BindView(R.id.cv_payer_selection)
    CardView cvPayerSelection;
    private int getAuthRequestContext;
    private String getErrorConfigVersion;
    @BindView(R.id.ll_btn_container)
    LinearLayout llBtnContainer;
    private List<String> lookAheadTest;
    private PublishSubject<List<String>> moveToNextValue;
    private List<RecipientModel> scheduleImpl;
    @BindView(R.id.f4595res_0x7f0a1b79_com_alibaba_ariver_engine_api_extopt_6)
    SearchView searchView;
    @BindView(R.id.view_selected_payer)
    SelectedPayerView selectedPayerView;

    /* loaded from: classes5.dex */
    public interface Listener {
        void onUpdatedSelectedPayers(List<RecipientModel> list);

        void onViewHidden();
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_bill_payer;
    }

    public BillPayerView(Context context) {
        super(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 500L;
    }

    public BillPayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 500L;
    }

    public BillPayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 500L;
    }

    public BillPayerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 500L;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.BuiltInFictitiousFunctionClassFactory && !this.searchView.isClearImageViewRect((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            if (motionEvent.getAction() == 0) {
                View findFocus = findFocus();
                if (findFocus instanceof EditText) {
                    Rect rect = new Rect();
                    findFocus.getGlobalVisibleRect(rect);
                    if (rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        return false;
                    }
                    findFocus.clearFocus();
                    KeyboardHelper.BuiltInFictitiousFunctionClassFactory(this);
                    return false;
                }
                return false;
            }
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: lambda$initContactSelector$0$id-dana-richview-splitbill-BillPayerView */
    public /* synthetic */ void m2860x8fa18d8c(String str) throws Exception {
        this.contactSelectorView.observeContactPagedList(str);
    }

    /* renamed from: lambda$initSearchView$1$id-dana-richview-splitbill-BillPayerView */
    public /* synthetic */ void m2861lambda$initSearchView$1$iddanarichviewsplitbillBillPayerView(Boolean bool) throws Exception {
        if (!bool.booleanValue() || this.BuiltInFictitiousFunctionClassFactory) {
            return;
        }
        this.llBtnContainer.setVisibility(8);
    }

    public void NetworkUserEntityData$$ExternalSyntheticLambda0(RecipientModel recipientModel) {
        if (getAuthRequestContext(recipientModel)) {
            if (this.selectedPayerView.isRecentPayer(recipientModel)) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(recipientModel);
                this.selectedPayerView.setRecentPayerDisplay(recipientModel, true);
                this.selectedPayerView.updatePayerFromSelectedToRecent(recipientModel);
                lookAheadTest(recipientModel);
                BuiltInFictitiousFunctionClassFactory();
            } else {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(recipientModel);
                this.selectedPayerView.removeSelectedPayer(recipientModel);
                lookAheadTest(recipientModel);
                BuiltInFictitiousFunctionClassFactory();
            }
        }
        this.selectedPayerView.setPayersCount(this.lookAheadTest.size());
    }

    public void MyBillsEntityDataFactory(RecipientModel recipientModel) {
        if (PlaceComponentResult(recipientModel)) {
            showWarningDialog(getContext().getString(R.string.error_select_non_indo_number));
        } else if (BuiltInFictitiousFunctionClassFactory(recipientModel.getErrorConfigVersion)) {
            showWarningDialog(getContext().getString(R.string.error_select_own_number));
        } else {
            scheduleImpl(recipientModel);
        }
    }

    private boolean getAuthRequestContext(RecipientModel recipientModel) {
        for (RecipientModel recipientModel2 : this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            if (BuiltInFictitiousFunctionClassFactory(recipientModel2, recipientModel) && recipientModel2.equals(recipientModel)) {
                return true;
            }
        }
        return false;
    }

    private boolean BuiltInFictitiousFunctionClassFactory(String str) {
        return !TextUtils.isEmpty(this.getErrorConfigVersion) && TextUtils.equals(NumberUtils.getIndoPhoneNumber(this.getErrorConfigVersion), NumberUtils.getIndoPhoneNumber(str));
    }

    public void BuiltInFictitiousFunctionClassFactory() {
        if (!this.scheduleImpl.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
            this.llBtnContainer.setVisibility(0);
        } else {
            this.llBtnContainer.setVisibility(8);
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(RecipientModel recipientModel) {
        if (this.selectedPayerView.getPayersList().size() >= this.getAuthRequestContext) {
            showWarningDialog(getContext().getString(R.string.max_split_bill_payers_error_msg));
            return;
        }
        if (recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda2()) {
            recipientModel.getSupportButtonTintMode = "splitBillPayer";
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(recipientModel);
        this.selectedPayerView.addSelectedPayer(0, recipientModel);
        BuiltInFictitiousFunctionClassFactory(recipientModel);
        BuiltInFictitiousFunctionClassFactory();
    }

    private void scheduleImpl(RecipientModel recipientModel) {
        if (!this.selectedPayerView.isRecentPayer(recipientModel)) {
            if (!getAuthRequestContext(recipientModel)) {
                KClassImpl$Data$declaredNonStaticMembers$2(recipientModel);
            } else {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(recipientModel);
                this.selectedPayerView.removeSelectedPayer(recipientModel);
                lookAheadTest(recipientModel);
                BuiltInFictitiousFunctionClassFactory();
            }
        } else if (getAuthRequestContext(recipientModel)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.remove(recipientModel);
            this.selectedPayerView.setRecentPayerDisplay(recipientModel, true);
            this.selectedPayerView.updatePayerFromSelectedToRecent(recipientModel);
            lookAheadTest(recipientModel);
            BuiltInFictitiousFunctionClassFactory();
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(recipientModel);
            this.selectedPayerView.setRecentPayerDisplay(recipientModel, false);
            this.selectedPayerView.updatePayerFromRecentToSelected(0, recipientModel);
            BuiltInFictitiousFunctionClassFactory(recipientModel);
            BuiltInFictitiousFunctionClassFactory();
        }
        this.selectedPayerView.setPayersCount(this.lookAheadTest.size());
    }

    private void BuiltInFictitiousFunctionClassFactory(RecipientModel recipientModel) {
        this.lookAheadTest.add(NumberUtils.getIndoPhoneNumber(recipientModel.getErrorConfigVersion));
        this.moveToNextValue.onNext(this.lookAheadTest);
        this.contactSelectorView.setSelectedNumbers(this.lookAheadTest);
    }

    private void lookAheadTest(RecipientModel recipientModel) {
        this.lookAheadTest.remove(NumberUtils.getIndoPhoneNumber(recipientModel.getErrorConfigVersion));
        this.moveToNextValue.onNext(this.lookAheadTest);
        this.contactSelectorView.setSelectedNumbers(this.lookAheadTest);
    }

    public void show() {
        this.MyBillsEntityDataFactory.setState(3);
    }

    public void hide() {
        this.searchView.clearKeyword();
        this.MyBillsEntityDataFactory.setState(5);
    }

    public boolean isShow() {
        return 5 != this.MyBillsEntityDataFactory.getState();
    }

    public void configPeekHeight(final BaseActivity baseActivity) {
        post(new Runnable() { // from class: id.dana.richview.splitbill.BillPayerView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                BillPayerView.this.m2859xd6af767b(baseActivity);
            }
        });
    }

    /* renamed from: lambda$configPeekHeight$2$id-dana-richview-splitbill-BillPayerView */
    public /* synthetic */ void m2859xd6af767b(BaseActivity baseActivity) {
        Display defaultDisplay = baseActivity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        BottomSheetBehavior bottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setPeekHeight(point.y);
        }
    }

    public void setListener(Listener listener) {
        this.PlaceComponentResult = listener;
    }

    @OnClick({R.id.btn_cancel})
    public void onCancel() {
        hide();
        for (RecipientModel recipientModel : this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            if (!this.scheduleImpl.contains(recipientModel)) {
                if (!this.selectedPayerView.isRecentPayer(recipientModel)) {
                    this.selectedPayerView.removeSelectedPayer(recipientModel);
                } else {
                    this.selectedPayerView.setRecentPayerDisplay(recipientModel, true);
                    this.selectedPayerView.updatePayerFromSelectedToRecent(recipientModel);
                }
                lookAheadTest(recipientModel);
            }
        }
        for (int size = this.scheduleImpl.size() - 1; size >= 0; size--) {
            RecipientModel recipientModel2 = this.scheduleImpl.get(size);
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0.contains(recipientModel2)) {
                if (!this.selectedPayerView.isRecentPayer(recipientModel2)) {
                    this.selectedPayerView.addSelectedPayer(0, recipientModel2);
                } else {
                    this.selectedPayerView.setRecentPayerDisplay(recipientModel2, false);
                    this.selectedPayerView.updatePayerFromRecentToSelected(0, recipientModel2);
                }
                BuiltInFictitiousFunctionClassFactory(recipientModel2);
            }
        }
        this.selectedPayerView.setPayersCount(this.lookAheadTest.size());
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.addAll(this.scheduleImpl);
        this.llBtnContainer.setVisibility(8);
    }

    @OnClick({R.id.btn_done})
    public void onFinished() {
        Listener listener;
        hide();
        if (KClassImpl$Data$declaredNonStaticMembers$2() && (listener = this.PlaceComponentResult) != null) {
            listener.onUpdatedSelectedPayers(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        this.scheduleImpl.clear();
        this.scheduleImpl.addAll(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        this.llBtnContainer.setVisibility(8);
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return !this.scheduleImpl.equals(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    public void setMaxBillPayer(int i) {
        this.getAuthRequestContext = i - 1;
    }

    public void addPayerFromScanner(RecipientModel recipientModel) {
        if (recipientModel == null) {
            return;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.contains(recipientModel)) {
            Toast.makeText(getBaseActivity(), getContext().getString(R.string.participant_already_added), 0).show();
            return;
        }
        scheduleImpl(recipientModel);
    }

    public void removeSelectedPayer(RecipientModel recipientModel) {
        this.scheduleImpl.remove(recipientModel);
        NetworkUserEntityData$$ExternalSyntheticLambda0(recipientModel);
    }

    public void setOwnPhoneNumber(String str) {
        this.getErrorConfigVersion = str;
    }

    private static boolean PlaceComponentResult(RecipientModel recipientModel) {
        if (TextUtils.isEmpty(recipientModel.NetworkUserEntityData$$ExternalSyntheticLambda3)) {
            return !NumberUtils.isValidIndoPhoneNumber(recipientModel.getErrorConfigVersion);
        }
        return false;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(RecipientModel recipientModel, RecipientModel recipientModel2) {
        return (TextUtils.isEmpty(recipientModel.readMicros) || TextUtils.isEmpty(recipientModel2.readMicros) || !recipientModel.readMicros.equals(recipientModel2.readMicros)) ? false : true;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        BottomSheetBehavior from = BottomSheetBehavior.from(this.cvPayerSelection);
        this.MyBillsEntityDataFactory = from;
        from.setHideable(true);
        this.MyBillsEntityDataFactory.setState(5);
        this.MyBillsEntityDataFactory.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.richview.splitbill.BillPayerView.1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View view, float f) {
            }

            {
                BillPayerView.this = this;
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View view, int i) {
                if (BillPayerView.this.PlaceComponentResult == null || 5 != i) {
                    return;
                }
                BillPayerView.this.onFinished();
                BillPayerView.this.PlaceComponentResult.onViewHidden();
            }
        });
        ContactSelectorView contactSelectorView = this.contactSelectorView;
        getResources();
        contactSelectorView.setContactHeaderColor(-1);
        this.contactSelectorView.enableArrow();
        this.contactSelectorView.setListener(new ContactSelectorView.Listener() { // from class: id.dana.richview.splitbill.BillPayerView.2
            @Override // id.dana.richview.contactselector.ContactSelectorView.Listener
            public final void PlaceComponentResult(boolean z) {
            }

            {
                BillPayerView.this = this;
            }

            @Override // id.dana.richview.contactselector.ContactSelectorView.Listener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                if (BillPayerView.this.searchView != null) {
                    BillPayerView.this.searchView.focusEtSearchContact();
                }
            }
        });
        this.contactSelectorView.setRecipientListener(new BaseRecipientListener() { // from class: id.dana.richview.splitbill.BillPayerView$$ExternalSyntheticLambda1
            @Override // id.dana.sendmoney.view.BaseRecipientListener
            public final void onRecipientSelected(RecipientModel recipientModel) {
                BillPayerView.this.MyBillsEntityDataFactory(recipientModel);
            }
        });
        if (this.moveToNextValue == null) {
            this.moveToNextValue = PublishSubject.PlaceComponentResult();
        }
        this.contactSelectorView.initContactList();
        this.contactSelectorView.setSelectedNumbers(this.lookAheadTest);
        this.contactSelectorView.setSelectedNumbersPublisher(this.moveToNextValue);
        addDisposable(this.searchView.getKeyword().debounce(500L, TimeUnit.MILLISECONDS).subscribe(new Consumer() { // from class: id.dana.richview.splitbill.BillPayerView$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BillPayerView.this.m2860x8fa18d8c((String) obj);
            }
        }));
        this.selectedPayerView.setListener(new SelectedPayerView.Listener() { // from class: id.dana.richview.splitbill.BillPayerView.3
            {
                BillPayerView.this = this;
            }

            @Override // id.dana.richview.splitbill.SelectedPayerView.Listener
            public final void PlaceComponentResult(RecipientModel recipientModel) {
                BillPayerView.this.NetworkUserEntityData$$ExternalSyntheticLambda0(recipientModel);
            }

            @Override // id.dana.richview.splitbill.SelectedPayerView.Listener
            public final void MyBillsEntityDataFactory(RecipientModel recipientModel) {
                BillPayerView.this.MyBillsEntityDataFactory(recipientModel);
            }
        });
        this.contactSelectorView.checkPermission();
        addDisposable(this.searchView.getOnSearchClickedEvent().subscribe(new Consumer() { // from class: id.dana.richview.splitbill.BillPayerView$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BillPayerView.this.m2861lambda$initSearchView$1$iddanarichviewsplitbillBillPayerView((Boolean) obj);
            }
        }));
        KeyboardHelper.PlaceComponentResult(this, new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.richview.splitbill.BillPayerView.4
            {
                BillPayerView.this = this;
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                BillPayerView.this.BuiltInFictitiousFunctionClassFactory = true;
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                BillPayerView.this.BuiltInFictitiousFunctionClassFactory = false;
                BillPayerView.this.BuiltInFictitiousFunctionClassFactory();
            }
        });
        this.scheduleImpl = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList();
        this.lookAheadTest = new ArrayList();
    }
}
