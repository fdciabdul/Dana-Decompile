package id.dana.sendmoney.bank;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.loader.content.CursorLoader;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import butterknife.BindView;
import butterknife.OnClick;
import com.jakewharton.rxbinding2.widget.RxTextView;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.data.util.NumberUtils;
import id.dana.domain.promotion.CdpContent;
import id.dana.richview.CustomEditText;
import id.dana.richview.LogoListView;
import id.dana.sendmoney.TransactionType;
import id.dana.sendmoney.contact.provider.ContactProvider;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientSource;
import id.dana.sendmoney.recipient.RecipientType;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocaleUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import java.util.List;

/* loaded from: classes5.dex */
public class AddReceiverDialogFragment extends BaseBottomSheetDialogFragment {
    @BindView(R.id.btn_add_receiver_info)
    Button btnAddReceiverInfo;
    @BindView(R.id.cet_receiver_phone_number)
    CustomEditText cetReceivePhoneNumber;
    @BindView(R.id.cet_receiver_date_of_birth)
    CustomEditText cetReceiverDateOfBirth;
    @BindView(R.id.cet_receiver_name)
    CustomEditText cetReceiverName;
    @BindView(R.id.cl_receiver_input_field)
    ConstraintLayout clReceiverInputField;
    @BindView(R.id.f3981layout_coordinator)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.llv_transfer_agents)
    LogoListView llvTransferAgents;
    private List<CdpContent> lookAheadTest;
    @BindView(R.id.ns_content)
    NestedScrollView nsContent;
    public OnAddReceiverInformation scheduleImpl;
    private final CompositeDisposable NetworkUserEntityData$$ExternalSyntheticLambda0 = new CompositeDisposable();
    final ActivityResultLauncher<Void> KClassImpl$Data$declaredNonStaticMembers$2 = registerForActivityResult(new ActivityResultContracts.PickContact(), new ActivityResultCallback() { // from class: id.dana.sendmoney.bank.AddReceiverDialogFragment$$ExternalSyntheticLambda0
        @Override // androidx.view.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            AddReceiverDialogFragment.getAuthRequestContext(AddReceiverDialogFragment.this, (Uri) obj);
        }
    });

    /* loaded from: classes5.dex */
    public interface OnAddReceiverInformation {
        void KClassImpl$Data$declaredNonStaticMembers$2(RecipientModel recipientModel);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public float getDimAmount() {
        return 0.48f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public int getLayout() {
        return R.layout.view_coordinator_transfer_agent_receiver_information;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public int getResizeHeight() {
        return 80;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory();
        super.onDestroyView();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public KeyboardHelper.KeyboardVisibilityListener getKeyboardVisibilityListener() {
        return new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.sendmoney.bank.AddReceiverDialogFragment.1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                if (AddReceiverDialogFragment.this.getView() != null) {
                    AddReceiverDialogFragment addReceiverDialogFragment = AddReceiverDialogFragment.this;
                    AddReceiverDialogFragment.BuiltInFictitiousFunctionClassFactory(addReceiverDialogFragment, KeyboardHelper.getAuthRequestContext(addReceiverDialogFragment.getView()));
                }
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                AddReceiverDialogFragment.BuiltInFictitiousFunctionClassFactory(AddReceiverDialogFragment.this, 0);
            }
        };
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public void init() {
        super.init();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(PlaceComponentResult());
        final DatePickerDialog authRequestContext = DateTimeUtil.getAuthRequestContext(getContext(), new DatePickerDialog.OnDateSetListener() { // from class: id.dana.sendmoney.bank.AddReceiverDialogFragment$$ExternalSyntheticLambda8
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                CustomEditText customEditText = AddReceiverDialogFragment.this.cetReceiverDateOfBirth;
                StringBuilder sb = new StringBuilder();
                sb.append(i3);
                sb.append("-");
                sb.append(i2 + 1);
                sb.append("-");
                sb.append(i);
                customEditText.setText(sb.toString());
            }
        });
        this.cetReceiverDateOfBirth.setOnEtCustomEditTextClicked(new View.OnClickListener() { // from class: id.dana.sendmoney.bank.AddReceiverDialogFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddReceiverDialogFragment addReceiverDialogFragment = AddReceiverDialogFragment.this;
                DatePickerDialog datePickerDialog = authRequestContext;
                KeyboardHelper.BuiltInFictitiousFunctionClassFactory(addReceiverDialogFragment.cetReceiverDateOfBirth);
                datePickerDialog.show();
            }
        });
        this.cetReceivePhoneNumber.setOnIconClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.bank.AddReceiverDialogFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddReceiverDialogFragment.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(null, null);
            }
        });
        List<CdpContent> list = this.lookAheadTest;
        if (list != null) {
            this.llvTransferAgents.setLogo(list);
        }
        KeyboardHelper.MyBillsEntityDataFactory(getBaseActivity());
        List<CdpContent> list2 = this.lookAheadTest;
        if (list2 != null) {
            this.llvTransferAgents.setLogo(list2);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext(PlaceComponentResult());
        this.cetReceiverName.post(new Runnable() { // from class: id.dana.sendmoney.bank.AddReceiverDialogFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                AddReceiverDialogFragment.this.cetReceiverName.clearText();
            }
        });
        this.cetReceivePhoneNumber.post(new Runnable() { // from class: id.dana.sendmoney.bank.AddReceiverDialogFragment$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                AddReceiverDialogFragment.this.cetReceivePhoneNumber.clearText();
            }
        });
        this.cetReceiverDateOfBirth.post(new Runnable() { // from class: id.dana.sendmoney.bank.AddReceiverDialogFragment$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                AddReceiverDialogFragment.this.cetReceiverDateOfBirth.clearText();
            }
        });
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        initMatchParentDialog(dialog);
        initTransparentDialogDim(dialog);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.btn_add_receiver_info})
    public void onAddreceiverInfoClicked() {
        OnAddReceiverInformation onAddReceiverInformation = this.scheduleImpl;
        if (onAddReceiverInformation != null) {
            RecipientModel.Builder builder = new RecipientModel.Builder(RecipientType.OTC);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = TransactionType.SEND_MONEY_TO_CASHIER;
            builder.initRecordTimeStamp = this.cetReceiverName.getText();
            builder.GetContactSyncConfig = this.cetReceivePhoneNumber.getText();
            builder.MyBillsEntityDataFactory = DateTimeUtil.MyBillsEntityDataFactory("dd-MM-yyyy", "yyyy-MM-dd", LocaleUtil.getAuthRequestContext(), this.cetReceiverDateOfBirth.getText());
            builder.NetworkUserEntityData$$ExternalSyntheticLambda6 = getBaseActivity().getSource();
            builder.newProxyInstance = this.cetReceivePhoneNumber.isManualInput() ? "Manual Input" : RecipientSource.ALL_CONTACTS;
            onAddReceiverInformation.KClassImpl$Data$declaredNonStaticMembers$2(builder.KClassImpl$Data$declaredNonStaticMembers$2());
        }
    }

    public static /* synthetic */ void getAuthRequestContext(AddReceiverDialogFragment addReceiverDialogFragment, Uri uri) {
        if (uri != null) {
            try {
                Cursor loadInBackground = new CursorLoader(addReceiverDialogFragment.requireContext(), uri).loadInBackground();
                if (loadInBackground != null) {
                    try {
                        if (loadInBackground.moveToFirst()) {
                            addReceiverDialogFragment.cetReceivePhoneNumber.setText(NumberUtils.getIndoPhoneNumber(loadInBackground.getString(loadInBackground.getColumnIndex(ContactProvider.Column.PHONENUMBER))));
                        }
                    } finally {
                    }
                }
                if (loadInBackground != null) {
                    loadInBackground.close();
                }
            } catch (Exception unused) {
            }
        }
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(AddReceiverDialogFragment addReceiverDialogFragment, int i) {
        NestedScrollView nestedScrollView = addReceiverDialogFragment.nsContent;
        nestedScrollView.setPadding(nestedScrollView.getPaddingLeft(), addReceiverDialogFragment.nsContent.getPaddingTop(), addReceiverDialogFragment.nsContent.getPaddingRight(), i);
    }

    private Disposable PlaceComponentResult() {
        return Observable.combineLatest(RxTextView.textChanges(this.cetReceivePhoneNumber.getEtCustomEditText()).map(new Function() { // from class: id.dana.sendmoney.bank.AddReceiverDialogFragment$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean valueOf;
                CharSequence charSequence = (CharSequence) obj;
                valueOf = Boolean.valueOf((boolean) (!TextUtils.isEmpty(charSequence)));
                return valueOf;
            }
        }), RxTextView.textChanges(this.cetReceiverName.getEtCustomEditText()).map(new Function() { // from class: id.dana.sendmoney.bank.AddReceiverDialogFragment$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean valueOf;
                CharSequence charSequence = (CharSequence) obj;
                valueOf = Boolean.valueOf((boolean) (!TextUtils.isEmpty(charSequence)));
                return valueOf;
            }
        }), RxTextView.textChanges(this.cetReceiverDateOfBirth.getEtCustomEditText()).map(new Function() { // from class: id.dana.sendmoney.bank.AddReceiverDialogFragment$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean valueOf;
                CharSequence charSequence = (CharSequence) obj;
                valueOf = Boolean.valueOf((boolean) (!TextUtils.isEmpty(charSequence)));
                return valueOf;
            }
        }), new Function3() { // from class: id.dana.sendmoney.bank.AddReceiverDialogFragment$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                Boolean valueOf;
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                Boolean bool3 = (Boolean) obj3;
                valueOf = Boolean.valueOf(r0.booleanValue() && r1.booleanValue() && r2.booleanValue());
                return valueOf;
            }
        }).subscribe(new Consumer() { // from class: id.dana.sendmoney.bank.AddReceiverDialogFragment$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddReceiverDialogFragment.this.btnAddReceiverInfo.setEnabled(((Boolean) obj).booleanValue());
            }
        });
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public /* synthetic */ View getPlaceComponentResult() {
        return (FrameLayout) this.coordinatorLayout.findViewById(R.id.bs_add_receiver);
    }
}
