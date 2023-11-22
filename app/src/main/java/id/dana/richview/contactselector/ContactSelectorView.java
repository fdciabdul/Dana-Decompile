package id.dana.richview.contactselector;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.paging.AsyncPagedListDiffer;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import androidx.paging.RxPagedListBuilder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ComponentActivity;
import butterknife.BindView;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseRichView;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.common.RecyclerViewSectionDecorator;
import id.dana.contract.contact.DanaContactContract;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.ContactSelectorComponent;
import id.dana.di.component.DaggerContactSelectorComponent;
import id.dana.di.modules.DanaContactModule;
import id.dana.richview.LogoProgressView;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.view.BaseRecipientListener;
import id.dana.sync_engine.domain.model.UserContact;
import id.dana.utils.KeyboardHelper;
import io.reactivex.BackpressureStrategy;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.subjects.PublishSubject;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public class ContactSelectorView extends BaseRichView implements DanaContactContract.View {
    private ContactDataSourceFactory BuiltInFictitiousFunctionClassFactory;
    private NewContactDataSourceFactory DatabaseTableConfigUtil;
    private Listener GetContactSyncConfig;
    private ContactSelectorAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    private List<String> MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda1;
    private Disposable NetworkUserEntityData$$ExternalSyntheticLambda2;
    private ActivityPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda7;
    private int PlaceComponentResult;
    @Inject
    DanaContactContract.Presenter danaContactPresenter;
    private ContactSelectorComponent getAuthRequestContext;
    private boolean getErrorConfigVersion;
    private boolean initRecordTimeStamp;
    private BaseRecipientListener isLayoutRequested;
    @BindView(R.id.ll_loading_contact)
    LinearLayout llLoadingContact;
    private boolean lookAheadTest;
    @BindView(R.id.lpv_contact)
    LogoProgressView lpvContact;
    private List<RecipientViewModel> moveToNextValue;
    @BindView(R.id.rv_contact_list)
    RecyclerView rvContactList;
    private boolean scheduleImpl;

    /* loaded from: classes5.dex */
    public interface Listener {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void PlaceComponentResult(boolean z);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseRichView
    public int getLayout() {
        return R.layout.view_contact_selector;
    }

    @Override // id.dana.contract.contact.DanaContactContract.View
    public void onEnableContactSyncFeature() {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }

    static /* synthetic */ char access$200(ContactSelectorView contactSelectorView, String str) {
        return MyBillsEntityDataFactory(str);
    }

    public ContactSelectorView(Context context) {
        super(context);
    }

    public ContactSelectorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContactSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ContactSelectorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        byte b = 0;
        if (this.getAuthRequestContext == null) {
            DaggerContactSelectorComponent.Builder PlaceComponentResult = DaggerContactSelectorComponent.PlaceComponentResult();
            PlaceComponentResult.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (DanaContactModule) Preconditions.getAuthRequestContext(new DanaContactModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, DanaContactModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.MyBillsEntityDataFactory, ApplicationComponent.class);
            this.getAuthRequestContext = new DaggerContactSelectorComponent.ContactSelectorComponentImpl(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult.MyBillsEntityDataFactory, b);
        }
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(this.danaContactPresenter);
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.U);
            try {
                this.lookAheadTest = obtainStyledAttributes.getBoolean(2, false);
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = obtainStyledAttributes.getBoolean(1, false);
                TypedValue typedValue = new TypedValue();
                obtainStyledAttributes.getValue(0, typedValue);
                this.PlaceComponentResult = typedValue.data;
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @Override // id.dana.contract.contact.DanaContactContract.View
    public void onGetDanaUserContactSuccess(List<String> list) {
        this.MyBillsEntityDataFactory.clear();
        this.MyBillsEntityDataFactory.addAll(list);
        getAuthRequestContext();
        BuiltInFictitiousFunctionClassFactory(list);
    }

    @Override // id.dana.contract.contact.DanaContactContract.View
    public void onGetContactSyncState(boolean z) {
        this.GetContactSyncConfig.PlaceComponentResult(z);
    }

    @Override // id.dana.contract.contact.DanaContactContract.View
    public void onGetSyncContacts(List<UserContact> list) {
        new UserContactMapper();
        this.moveToNextValue = UserContactMapper.getAuthRequestContext(list);
        getAuthRequestContext();
    }

    @Override // id.dana.contract.contact.DanaContactContract.View
    public void onGetRecipientSyncContacts(List<RecipientViewModel> list) {
        this.moveToNextValue = list;
        BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
        getAuthRequestContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
        BuiltInFictitiousFunctionClassFactory(Collections.emptyList());
    }

    public void checkPermission() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.check();
    }

    public void initContactList() {
        RecyclerView recyclerView = this.rvContactList;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView2 = this.rvContactList;
        recyclerView2.addItemDecoration(new RecyclerViewSectionDecorator(recyclerView2, getContext().getResources().getDimensionPixelSize(R.dimen.res_0x7f07034d_kclassimpl_data_declarednonstaticmembers_2), new RecyclerViewSectionDecorator.SectionCallback() { // from class: id.dana.richview.contactselector.ContactSelectorView.1
            @Override // id.dana.common.RecyclerViewSectionDecorator.SectionCallback
            public final boolean PlaceComponentResult(int i) {
                if (ContactSelectorView.this.MyBillsEntityDataFactory(i)) {
                    ContactSelectorView contactSelectorView = ContactSelectorView.this;
                    char access$200 = ContactSelectorView.access$200(contactSelectorView, ContactSelectorView.access$100(contactSelectorView, i));
                    ContactSelectorView contactSelectorView2 = ContactSelectorView.this;
                    if (access$200 != ContactSelectorView.access$200(contactSelectorView2, ContactSelectorView.access$100(contactSelectorView2, i - 1))) {
                        return true;
                    }
                }
                return false;
            }

            @Override // id.dana.common.RecyclerViewSectionDecorator.SectionCallback
            public final CharSequence BuiltInFictitiousFunctionClassFactory(int i) {
                if (ContactSelectorView.this.MyBillsEntityDataFactory(i)) {
                    ContactSelectorView contactSelectorView = ContactSelectorView.this;
                    return String.valueOf(ContactSelectorView.access$200(contactSelectorView, ContactSelectorView.access$100(contactSelectorView, i)));
                }
                return null;
            }
        }, this.NetworkUserEntityData$$ExternalSyntheticLambda0));
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ContactSelectorAdapter(RecipientViewModel.newProxyInstance);
        ViewCompat.BuiltInFictitiousFunctionClassFactory((View) this.rvContactList, true);
        this.rvContactList.setAdapter(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public void setContactHeaderColor(int i) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MyBillsEntityDataFactory(int i) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getItemViewType(i) == 3;
    }

    private static char MyBillsEntityDataFactory(String str) {
        return TextUtils.isEmpty(str) ? InputCardNumberView.DIVIDER : str.charAt(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initPermission$0$id-dana-richview-contactselector-ContactSelectorView  reason: not valid java name */
    public /* synthetic */ void m2835x294225d1(PermissionResult permissionResult, boolean z) {
        if (permissionResult.MyBillsEntityDataFactory()) {
            this.scheduleImpl = true;
            LinearLayout linearLayout = this.llLoadingContact;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            LogoProgressView logoProgressView = this.lpvContact;
            if (logoProgressView != null) {
                logoProgressView.startRefresh();
            }
            RecyclerView recyclerView = this.rvContactList;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            this.danaContactPresenter.BuiltInFictitiousFunctionClassFactory();
            if (this.initRecordTimeStamp) {
                this.danaContactPresenter.getErrorConfigVersion();
            } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
                this.danaContactPresenter.PlaceComponentResult();
            } else {
                this.danaContactPresenter.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            this.danaContactPresenter.MyBillsEntityDataFactory();
            this.GetContactSyncConfig.PlaceComponentResult(false);
            return;
        }
        this.scheduleImpl = false;
        BuiltInFictitiousFunctionClassFactory((List<String>) null);
    }

    public void observeContactPagedList() {
        observeContactPagedList("");
    }

    public void observeContactPagedList(String str) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            if (this.DatabaseTableConfigUtil == null) {
                this.DatabaseTableConfigUtil = new NewContactDataSourceFactory();
            }
            this.DatabaseTableConfigUtil.getAuthRequestContext = this.moveToNextValue;
            NewContactDataSourceFactory newContactDataSourceFactory = this.DatabaseTableConfigUtil;
            String trim = str.toLowerCase(Locale.ROOT).trim();
            Intrinsics.checkNotNullParameter(trim, "");
            newContactDataSourceFactory.KClassImpl$Data$declaredNonStaticMembers$2 = trim;
            this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory = this.scheduleImpl;
            if (!this.initRecordTimeStamp) {
                this.DatabaseTableConfigUtil.MyBillsEntityDataFactory = true;
            }
            BuiltInFictitiousFunctionClassFactory(this.DatabaseTableConfigUtil);
            return;
        }
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new ContactDataSourceFactory(getContext());
        }
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = str;
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = this.lookAheadTest;
        this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = this.PlaceComponentResult;
        this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = this.scheduleImpl;
        BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
    }

    private void BuiltInFictitiousFunctionClassFactory(DataSource.Factory<Integer, RecipientViewModel> factory) {
        Disposable disposable = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (disposable != null) {
            disposable.dispose();
        }
        PagedList.Config.Builder builder = new PagedList.Config.Builder();
        builder.getAuthRequestContext = 20;
        builder.MyBillsEntityDataFactory = 10;
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        Disposable BuiltInFictitiousFunctionClassFactory = new RxPagedListBuilder(factory, builder.PlaceComponentResult()).BuiltInFictitiousFunctionClassFactory(BackpressureStrategy.LATEST).BuiltInFictitiousFunctionClassFactory(new Consumer() { // from class: id.dana.richview.contactselector.ContactSelectorView$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ContactSelectorView.this.m2836x1b83c641((PagedList) obj);
            }
        }, Functions.DatabaseTableConfigUtil, Functions.KClassImpl$Data$declaredNonStaticMembers$2, FlowableInternalHelper.RequestMax.INSTANCE);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = BuiltInFictitiousFunctionClassFactory;
        addDisposable(BuiltInFictitiousFunctionClassFactory);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$subscribeToPagedList$1$id-dana-richview-contactselector-ContactSelectorView  reason: not valid java name */
    public /* synthetic */ void m2836x1b83c641(PagedList pagedList) throws Exception {
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(pagedList);
    }

    public void setRecipientListener(BaseRecipientListener baseRecipientListener) {
        this.isLayoutRequested = baseRecipientListener;
    }

    public void setListener(Listener listener) {
        this.GetContactSyncConfig = listener;
    }

    public void setSelectedNumbersPublisher(PublishSubject<List<String>> publishSubject) {
        if (publishSubject != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl = publishSubject;
        }
    }

    public void setSelectedNumbers(List<String> list) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = list;
    }

    public void enableArrow() {
        this.getErrorConfigVersion = true;
    }

    public boolean getHasPermission() {
        return this.scheduleImpl;
    }

    public boolean getIsReferralPage() {
        return this.initRecordTimeStamp;
    }

    public void setIsReferralPage(boolean z) {
        this.initRecordTimeStamp = z;
    }

    public List<String> getDanaContacts() {
        return this.MyBillsEntityDataFactory;
    }

    public AppCompatActivity getActivity() {
        if (getContext() instanceof BaseActivity) {
            return (BaseActivity) getContext();
        }
        if (getContext() instanceof BaseViewBindingActivity) {
            return (BaseViewBindingActivity) getContext();
        }
        return null;
    }

    /* renamed from: $r8$lambda$e5-f1wGi5TExPOpu7t0WOvYgjpI  reason: not valid java name */
    public static /* synthetic */ void m2834$r8$lambda$e5f1wGi5TExPOpu7t0WOvYgjpI(ContactSelectorView contactSelectorView, int i) {
        Listener listener;
        int itemViewType = contactSelectorView.KClassImpl$Data$declaredNonStaticMembers$2.getItemViewType(i);
        if (itemViewType == 5) {
            contactSelectorView.checkPermission();
        } else if (itemViewType != 11 || (listener = contactSelectorView.GetContactSyncConfig) == null) {
        } else {
            listener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static /* synthetic */ void $r8$lambda$sfKKSKNQ5F3JQLxmvbaednPSr_U(ContactSelectorView contactSelectorView, RecipientModel recipientModel) {
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(contactSelectorView);
        BaseRecipientListener baseRecipientListener = contactSelectorView.isLayoutRequested;
        if (baseRecipientListener != null) {
            baseRecipientListener.onRecipientSelected(recipientModel);
        }
    }

    static /* synthetic */ String access$100(ContactSelectorView contactSelectorView, int i) {
        ContactSelectorAdapter contactSelectorAdapter = contactSelectorView.KClassImpl$Data$declaredNonStaticMembers$2;
        int i2 = i < 0 ? 0 : i;
        AsyncPagedListDiffer<T> asyncPagedListDiffer = contactSelectorAdapter.KClassImpl$Data$declaredNonStaticMembers$2;
        AbstractList abstractList = asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (abstractList == null) {
            abstractList = asyncPagedListDiffer.moveToNextValue;
        }
        if (((RecipientViewModel) abstractList.get(i2)).PlaceComponentResult() != null) {
            ContactSelectorAdapter contactSelectorAdapter2 = contactSelectorView.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i < 0) {
                i = 0;
            }
            AsyncPagedListDiffer<T> asyncPagedListDiffer2 = contactSelectorAdapter2.KClassImpl$Data$declaredNonStaticMembers$2;
            AbstractList abstractList2 = asyncPagedListDiffer2.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (abstractList2 == null) {
                abstractList2 = asyncPagedListDiffer2.moveToNextValue;
            }
            return ((RecipientViewModel) abstractList2.get(i)).PlaceComponentResult().toUpperCase();
        }
        ContactSelectorAdapter contactSelectorAdapter3 = contactSelectorView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i < 0) {
            i = 0;
        }
        AsyncPagedListDiffer<T> asyncPagedListDiffer3 = contactSelectorAdapter3.KClassImpl$Data$declaredNonStaticMembers$2;
        AbstractList abstractList3 = asyncPagedListDiffer3.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (abstractList3 == null) {
            abstractList3 = asyncPagedListDiffer3.moveToNextValue;
        }
        return ((RecipientViewModel) abstractList3.get(i)).PlaceComponentResult();
    }

    private void getAuthRequestContext() {
        LinearLayout linearLayout = this.llLoadingContact;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LogoProgressView logoProgressView = this.lpvContact;
        if (logoProgressView != null) {
            logoProgressView.stopRefresh();
        }
        RecyclerView recyclerView = this.rvContactList;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(List<String> list) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = new BaseRecipientListener() { // from class: id.dana.richview.contactselector.ContactSelectorView$$ExternalSyntheticLambda2
            @Override // id.dana.sendmoney.view.BaseRecipientListener
            public final void onRecipientSelected(RecipientModel recipientModel) {
                ContactSelectorView.$r8$lambda$sfKKSKNQ5F3JQLxmvbaednPSr_U(ContactSelectorView.this, recipientModel);
            }
        };
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.richview.contactselector.ContactSelectorView$$ExternalSyntheticLambda3
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                ContactSelectorView.m2834$r8$lambda$e5f1wGi5TExPOpu7t0WOvYgjpI(ContactSelectorView.this, i);
            }
        };
        this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = this.getErrorConfigVersion;
        if (list != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory;
        }
        observeContactPagedList();
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
            ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) getActivity());
            String[] strArr = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"};
            Intrinsics.checkNotNullParameter(strArr, "");
            builder.PlaceComponentResult = ArraysKt.toSet(strArr);
            PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.richview.contactselector.ContactSelectorView$$ExternalSyntheticLambda0
                @Override // com.anggrayudi.storage.permission.PermissionCallback
                public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                    PermissionCallback.CC.getAuthRequestContext(permissionRequest);
                }

                @Override // com.anggrayudi.storage.permission.PermissionCallback
                public final void onPermissionsChecked(PermissionResult permissionResult, boolean z) {
                    ContactSelectorView.this.m2835x294225d1(permissionResult, z);
                }

                @Override // com.anggrayudi.storage.permission.PermissionCallback
                public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                    PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
                }
            };
            Intrinsics.checkNotNullParameter(permissionCallback, "");
            builder.getAuthRequestContext = permissionCallback;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = builder.PlaceComponentResult();
        }
        this.MyBillsEntityDataFactory = new ArrayList();
    }
}
