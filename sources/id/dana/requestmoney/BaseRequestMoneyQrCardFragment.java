package id.dana.requestmoney;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.databinding.CardQrRequestMoneyBinding;
import id.dana.requestmoney.NoteAmountCalculatorActivity;
import id.dana.requestmoney.RequestMoneyQrContract;
import id.dana.requestmoney.model.RequestMoneyInfoModel;
import id.dana.richview.QRView;
import id.dana.richview.socialshare.SocialShareView;
import id.dana.sendmoney.Amount;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.utils.BarcodeUtil;
import id.dana.utils.LocaleUtil;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\bC\u0010\u000bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0004¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\fH\u0004¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0005H$¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\u0005H&¢\u0006\u0004\b\u0016\u0010\u000bJ\r\u0010\u0017\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0013J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\u0005H&¢\u0006\u0004\b\u001a\u0010\u000bJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u001b\u0010\u000bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\u001c\u0010\u000bJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0011H\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0011H\u0004¢\u0006\u0004\b\b\u0010\u001eJ/\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0011H\u0004¢\u0006\u0004\b\t\u0010\"R*\u0010'\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020#8\u0017@WX\u0096\u000e¢\u0006\u0012\n\u0004\b\t\u0010$\u001a\u0004\b\u0006\u0010%\"\u0004\b\t\u0010&R\"\u0010\t\u001a\u00020\f8\u0005@\u0005X\u0085\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010(\u001a\u0004\b\t\u0010\u000e\"\u0004\b\u001d\u0010)R*\u0010\b\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00118\u0005@EX\u0085\u000e¢\u0006\u0012\n\u0004\b\n\u0010*\u001a\u0004\b\b\u0010\u0013\"\u0004\b'\u0010\u001eR\u0016\u0010\u0006\u001a\u00020+8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001e\u0010\u001d\u001a\f\u0012\b\u0012\u0006*\u00020/0/0.8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u00100R\"\u0010,\u001a\u00020\u00118\u0005@\u0005X\u0085\u000e¢\u0006\u0012\n\u0004\b1\u0010*\u001a\u0004\b,\u0010\u0013\"\u0004\b\u0006\u0010\u001eR\u0012\u00103\u001a\u000202X\u0087\"¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u0010\u0018\u001a\u00020\f@\u0005X\u0085\n¢\u0006\f\n\u0004\b\u0018\u0010(\"\u0004\b\t\u0010)R\u001a\u00101\u001a\u00020\u0003@\u0005X\u0085\n¢\u0006\f\n\u0004\b\u001a\u00105\"\u0004\b\u001d\u0010\u0007R*\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038\u0005@EX\u0085\u000e¢\u0006\u0012\n\u0004\b\u0010\u00105\u001a\u0004\b1\u00106\"\u0004\b'\u0010\u0007R&\u0010\n\u001a\u0004\u0018\u0001072\b\u0010\u0004\u001a\u0004\u0018\u000107@UX\u0095\n¢\u0006\f\n\u0004\b\u0015\u00108\"\u0004\b\u0006\u00109R\u0012\u0010;\u001a\u00020:X\u0087\"¢\u0006\u0006\n\u0004\b;\u0010<R\u0012\u0010>\u001a\u00020=X\u0087\"¢\u0006\u0006\n\u0004\b>\u0010?R\u001a\u0010\u0015\u001a\u00020\f@\u0005X\u0085\n¢\u0006\f\n\u0004\b\u000f\u0010(\"\u0004\b\b\u0010)R\u0012\u0010A\u001a\u00020@X\u0087\"¢\u0006\u0006\n\u0004\bA\u0010B"}, d2 = {"Lid/dana/requestmoney/BaseRequestMoneyQrCardFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/databinding/CardQrRequestMoneyBinding;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "getErrorConfigVersion", "()V", "", "scheduleImpl", "()J", "GetContactSyncConfig", "DatabaseTableConfigUtil", "", "NetworkUserEntityData$$ExternalSyntheticLambda8", "()Z", "FragmentBottomSheetPaymentSettingBinding", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda1", "PrepareContext", "lookAheadTest", "onDestroy", "NetworkUserEntityData$$ExternalSyntheticLambda2", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda7", "getAuthRequestContext", "(Z)V", "p1", "p2", "p3", "(ZJZZ)V", "Lid/dana/sendmoney/Amount;", "Lid/dana/sendmoney/Amount;", "()Lid/dana/sendmoney/Amount;", "(Lid/dana/sendmoney/Amount;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "J", "(J)V", "Z", "Lio/reactivex/disposables/CompositeDisposable;", "moveToNextValue", "Lio/reactivex/disposables/CompositeDisposable;", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResultLauncher;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/contract/deeplink/generation/GenerateDeepLinkContract$ProfilePresenter;", "profileDeeplinkPresenter", "Lid/dana/contract/deeplink/generation/GenerateDeepLinkContract$ProfilePresenter;", "Ljava/lang/String;", "()Ljava/lang/String;", "Lid/dana/requestmoney/model/RequestMoneyInfoModel;", "Lid/dana/requestmoney/model/RequestMoneyInfoModel;", "(Lid/dana/requestmoney/model/RequestMoneyInfoModel;)V", "Lid/dana/requestmoney/RequestMoneyQrContract$Presenter;", "requestMoneyQrPresenter", "Lid/dana/requestmoney/RequestMoneyQrContract$Presenter;", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "sendMoneyAnalyticalTracker", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "Lid/dana/contract/deeplink/generation/GenerateDeepLinkContract$TransferPresenter;", "transferDeepLinkPresenter", "Lid/dana/contract/deeplink/generation/GenerateDeepLinkContract$TransferPresenter;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseRequestMoneyQrCardFragment extends BaseViewBindingFragment<CardQrRequestMoneyBinding> {

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private long initRecordTimeStamp;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private long MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private RequestMoneyInfoModel getErrorConfigVersion;
    private long lookAheadTest;
    @Inject
    public GenerateDeepLinkContract.ProfilePresenter profileDeeplinkPresenter;
    @Inject
    public RequestMoneyQrContract.Presenter requestMoneyQrPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final ActivityResultLauncher<Intent> getAuthRequestContext;
    @Inject
    public SendMoneyAnalyticTracker sendMoneyAnalyticalTracker;
    @Inject
    public GenerateDeepLinkContract.TransferPresenter transferDeepLinkPresenter;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private CompositeDisposable PlaceComponentResult = new CompositeDisposable();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0 = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean moveToNextValue = true;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Amount KClassImpl$Data$declaredNonStaticMembers$2 = new Amount((byte) 0);

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String scheduleImpl = "";

    public abstract void NetworkUserEntityData$$ExternalSyntheticLambda1();

    public abstract void NetworkUserEntityData$$ExternalSyntheticLambda2();

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public View getAuthRequestContext(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    protected abstract void initRecordTimeStamp();

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        getAuthRequestContext();
    }

    public BaseRequestMoneyQrCardFragment() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.requestmoney.BaseRequestMoneyQrCardFragment$$ExternalSyntheticLambda3
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                BaseRequestMoneyQrCardFragment.getAuthRequestContext(BaseRequestMoneyQrCardFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.getAuthRequestContext = registerForActivityResult;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ CardQrRequestMoneyBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        CardQrRequestMoneyBinding KClassImpl$Data$declaredNonStaticMembers$2 = CardQrRequestMoneyBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "getAuthRequestContext")
    public final void getAuthRequestContext(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public final void MyBillsEntityDataFactory(long j) {
        this.lookAheadTest = j;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final long getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @JvmName(name = "getAuthRequestContext")
    public final void getAuthRequestContext(long j) {
        this.MyBillsEntityDataFactory = j;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final void BuiltInFictitiousFunctionClassFactory(long j) {
        this.initRecordTimeStamp = j;
    }

    @JvmName(name = "PlaceComponentResult")
    public final void PlaceComponentResult(boolean z) {
        this.moveToNextValue = z;
    }

    @JvmName(name = "moveToNextValue")
    /* renamed from: moveToNextValue  reason: from getter */
    public final boolean getMoveToNextValue() {
        return this.moveToNextValue;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public void lookAheadTest() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.BuiltInFictitiousFunctionClassFactory = z;
        BuiltInFictitiousFunctionClassFactory(z);
    }

    @JvmName(name = "PlaceComponentResult")
    public final void PlaceComponentResult(RequestMoneyInfoModel requestMoneyInfoModel) {
        this.getErrorConfigVersion = requestMoneyInfoModel;
        boolean z = requestMoneyInfoModel != null;
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((CardQrRequestMoneyBinding) vb).BuiltInFictitiousFunctionClassFactory.setEnabled(z);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final Amount getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @JvmName(name = "MyBillsEntityDataFactory")
    public final void MyBillsEntityDataFactory(Amount amount) {
        String format;
        Intrinsics.checkNotNullParameter(amount, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = amount;
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            TextView textView = ((CardQrRequestMoneyBinding) vb).DatabaseTableConfigUtil;
            StringBuilder sb = new StringBuilder();
            FragmentActivity activity = getActivity();
            sb.append(activity != null ? activity.getString(R.string.rupiah_short) : null);
            format = NumberFormat.getNumberInstance(LocaleUtil.getAuthRequestContext()).format(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext);
            sb.append(format);
            textView.setText(sb.toString());
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from getter */
    public final String getScheduleImpl() {
        return this.scheduleImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.scheduleImpl = str;
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            TextView textView = ((CardQrRequestMoneyBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda8;
            textView.setText(this.scheduleImpl);
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(StringsKt.isBlank(this.scheduleImpl) ^ true ? 0 : 8);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public void FragmentBottomSheetPaymentSettingBinding() {
        initRecordTimeStamp();
        NetworkUserEntityData$$ExternalSyntheticLambda1();
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((CardQrRequestMoneyBinding) vb).initRecordTimeStamp.setEnabled(false);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((CardQrRequestMoneyBinding) vb2).BuiltInFictitiousFunctionClassFactory.setEnabled(false);
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    ((CardQrRequestMoneyBinding) vb3).GetContactSyncConfig.setEnableShareButton(false);
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        SocialShareView socialShareView = ((CardQrRequestMoneyBinding) vb4).GetContactSyncConfig;
                        socialShareView.setSocialShareViewTitle("");
                        socialShareView.setSocialButtonText("");
                        FragmentActivity activity = getActivity();
                        RequestMoneyQrContract.Presenter presenter = null;
                        socialShareView.setOthersButtonText(activity != null ? activity.getString(R.string.social_share_others_button_text) : null);
                        if (this.getErrorConfigVersion == null) {
                            RequestMoneyQrContract.Presenter presenter2 = this.requestMoneyQrPresenter;
                            if (presenter2 != null) {
                                presenter = presenter2;
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                            }
                            presenter.getAuthRequestContext();
                        }
                        MyBillsEntityDataFactory(new Amount((byte) 0));
                        KClassImpl$Data$declaredNonStaticMembers$2("");
                        getAuthRequestContext(false);
                        VB vb5 = this.PlaceComponentResult;
                        if (vb5 != 0) {
                            CardQrRequestMoneyBinding cardQrRequestMoneyBinding = (CardQrRequestMoneyBinding) vb5;
                            cardQrRequestMoneyBinding.scheduleImpl.setOnClickListener(new View.OnClickListener() { // from class: id.dana.requestmoney.BaseRequestMoneyQrCardFragment$$ExternalSyntheticLambda4
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    BaseRequestMoneyQrCardFragment.BuiltInFictitiousFunctionClassFactory(BaseRequestMoneyQrCardFragment.this);
                                }
                            });
                            cardQrRequestMoneyBinding.initRecordTimeStamp.setOnClickListener(new View.OnClickListener() { // from class: id.dana.requestmoney.BaseRequestMoneyQrCardFragment$$ExternalSyntheticLambda5
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    BaseRequestMoneyQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2(BaseRequestMoneyQrCardFragment.this);
                                }
                            });
                            VB vb6 = this.PlaceComponentResult;
                            if (vb6 != 0) {
                                ((CardQrRequestMoneyBinding) vb6).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.requestmoney.BaseRequestMoneyQrCardFragment$$ExternalSyntheticLambda2
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        BaseRequestMoneyQrCardFragment.PlaceComponentResult(BaseRequestMoneyQrCardFragment.this);
                                    }
                                });
                                return;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.getAuthRequestContext(BarcodeUtil.BuiltInFictitiousFunctionClassFactory(p0).subscribe(new Consumer() { // from class: id.dana.requestmoney.BaseRequestMoneyQrCardFragment$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BaseRequestMoneyQrCardFragment.getAuthRequestContext(BaseRequestMoneyQrCardFragment.this, (Bitmap) obj);
            }
        }, new Consumer() { // from class: id.dana.requestmoney.BaseRequestMoneyQrCardFragment$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Throwable th = (Throwable) obj;
                BaseRequestMoneyQrCardFragment.MyBillsEntityDataFactory(BaseRequestMoneyQrCardFragment.this);
            }
        }));
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((CardQrRequestMoneyBinding) vb).initRecordTimeStamp.setEnabled(false);
            boolean z = this.BuiltInFictitiousFunctionClassFactory;
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((CardQrRequestMoneyBinding) vb2).GetContactSyncConfig.setEnableShareButton(z);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private boolean PrepareContext() {
        return NetworkUserEntityData$$ExternalSyntheticLambda8() || (StringsKt.isBlank(this.scheduleImpl) ^ true);
    }

    public final long DatabaseTableConfigUtil() {
        long j = this.MyBillsEntityDataFactory;
        if (j != 0) {
            long j2 = this.lookAheadTest;
            if (j2 != 0) {
                return j + j2;
            }
            return 0L;
        }
        return 0L;
    }

    public final long scheduleImpl() {
        long j = this.MyBillsEntityDataFactory;
        if (j != 0) {
            long j2 = this.lookAheadTest;
            if (j2 != 0) {
                long j3 = this.initRecordTimeStamp;
                if (j3 != 0) {
                    return j + j2 + j3;
                }
                return 0L;
            }
            return 0L;
        }
        return 0L;
    }

    public final long GetContactSyncConfig() {
        long j = this.MyBillsEntityDataFactory;
        if (j != 0) {
            long j2 = this.initRecordTimeStamp;
            if (j2 != 0) {
                return j + j2;
            }
            return 0L;
        }
        return 0L;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.PlaceComponentResult.dispose();
        RequestMoneyQrContract.Presenter presenter = this.requestMoneyQrPresenter;
        GenerateDeepLinkContract.TransferPresenter transferPresenter = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.onDestroy();
        GenerateDeepLinkContract.ProfilePresenter profilePresenter = this.profileDeeplinkPresenter;
        if (profilePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            profilePresenter = null;
        }
        profilePresenter.onDestroy();
        GenerateDeepLinkContract.TransferPresenter transferPresenter2 = this.transferDeepLinkPresenter;
        if (transferPresenter2 != null) {
            transferPresenter = transferPresenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        transferPresenter.onDestroy();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BaseRequestMoneyQrCardFragment baseRequestMoneyQrCardFragment) {
        Intrinsics.checkNotNullParameter(baseRequestMoneyQrCardFragment, "");
        baseRequestMoneyQrCardFragment.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BaseRequestMoneyQrCardFragment baseRequestMoneyQrCardFragment) {
        Intrinsics.checkNotNullParameter(baseRequestMoneyQrCardFragment, "");
        baseRequestMoneyQrCardFragment.MyBillsEntityDataFactory(new Amount((byte) 0));
        baseRequestMoneyQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2("");
        baseRequestMoneyQrCardFragment.getAuthRequestContext(false);
        baseRequestMoneyQrCardFragment.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public static /* synthetic */ void getAuthRequestContext(BaseRequestMoneyQrCardFragment baseRequestMoneyQrCardFragment, ActivityResult activityResult) {
        Intent intent;
        Intrinsics.checkNotNullParameter(baseRequestMoneyQrCardFragment, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory != -1 || (intent = activityResult.MyBillsEntityDataFactory) == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("amount");
        if (stringExtra != null) {
            baseRequestMoneyQrCardFragment.MyBillsEntityDataFactory(new Amount(stringExtra));
        }
        String stringExtra2 = intent.getStringExtra("remarks");
        if (stringExtra2 != null) {
            baseRequestMoneyQrCardFragment.KClassImpl$Data$declaredNonStaticMembers$2(stringExtra2);
        }
        baseRequestMoneyQrCardFragment.getAuthRequestContext(false);
        baseRequestMoneyQrCardFragment.NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public static /* synthetic */ void PlaceComponentResult(BaseRequestMoneyQrCardFragment baseRequestMoneyQrCardFragment) {
        Unit unit;
        Intrinsics.checkNotNullParameter(baseRequestMoneyQrCardFragment, "");
        RequestMoneyInfoModel requestMoneyInfoModel = baseRequestMoneyQrCardFragment.getErrorConfigVersion;
        RequestMoneyQrContract.Presenter presenter = null;
        if (requestMoneyInfoModel != null) {
            NoteAmountCalculatorActivity.Companion companion = NoteAmountCalculatorActivity.INSTANCE;
            FragmentActivity requireActivity = baseRequestMoneyQrCardFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "");
            int i = requestMoneyInfoModel.BuiltInFictitiousFunctionClassFactory;
            int i2 = requestMoneyInfoModel.MyBillsEntityDataFactory;
            String string = baseRequestMoneyQrCardFragment.getString(R.string.request_money_amount_calculator_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            baseRequestMoneyQrCardFragment.getAuthRequestContext.MyBillsEntityDataFactory(NoteAmountCalculatorActivity.Companion.PlaceComponentResult(requireActivity, String.valueOf(i), String.valueOf(i2), string), null);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null && baseRequestMoneyQrCardFragment.getErrorConfigVersion == null) {
            RequestMoneyQrContract.Presenter presenter2 = baseRequestMoneyQrCardFragment.requestMoneyQrPresenter;
            if (presenter2 != null) {
                presenter = presenter2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            presenter.getAuthRequestContext();
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(BaseRequestMoneyQrCardFragment baseRequestMoneyQrCardFragment) {
        Intrinsics.checkNotNullParameter(baseRequestMoneyQrCardFragment, "");
        VB vb = baseRequestMoneyQrCardFragment.PlaceComponentResult;
        if (vb != 0) {
            QRView qRView = ((CardQrRequestMoneyBinding) vb).initRecordTimeStamp;
            Intrinsics.checkNotNullExpressionValue(qRView, "");
            qRView.hideSkeleton();
            qRView.getQrImageView().setImageBitmap(null);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void getAuthRequestContext(BaseRequestMoneyQrCardFragment baseRequestMoneyQrCardFragment, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(baseRequestMoneyQrCardFragment, "");
        VB vb = baseRequestMoneyQrCardFragment.PlaceComponentResult;
        if (vb != 0) {
            QRView qRView = ((CardQrRequestMoneyBinding) vb).initRecordTimeStamp;
            Intrinsics.checkNotNullExpressionValue(qRView, "");
            qRView.hideSkeleton();
            qRView.getQrImageView().setImageBitmap(bitmap);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory = false;
        BuiltInFictitiousFunctionClassFactory(false);
        RequestMoneyQrContract.Presenter presenter = this.requestMoneyQrPresenter;
        GenerateDeepLinkContract.ProfilePresenter profilePresenter = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.PlaceComponentResult();
        GenerateDeepLinkContract.ProfilePresenter profilePresenter2 = this.profileDeeplinkPresenter;
        if (profilePresenter2 != null) {
            profilePresenter = profilePresenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        profilePresenter.KClassImpl$Data$declaredNonStaticMembers$2(p0, getString(R.string.deeplink_title_request_money), getString(R.string.deeplink_description_request_money), false);
    }

    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory = false;
        BuiltInFictitiousFunctionClassFactory(false);
        RequestMoneyQrContract.Presenter presenter = this.requestMoneyQrPresenter;
        GenerateDeepLinkContract.TransferPresenter transferPresenter = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.PlaceComponentResult();
        GenerateDeepLinkContract.TransferPresenter transferPresenter2 = this.transferDeepLinkPresenter;
        if (transferPresenter2 != null) {
            transferPresenter = transferPresenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        transferPresenter.KClassImpl$Data$declaredNonStaticMembers$2(p0, requireContext().getString(R.string.deeplink_title_request_money), requireContext().getString(R.string.deeplink_description_request_money));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getErrorConfigVersion() {
        if (this.getErrorConfigVersion == null) {
            RequestMoneyQrContract.Presenter presenter = this.requestMoneyQrPresenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            presenter.getAuthRequestContext();
        }
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext > 0;
    }

    public final void isLayoutRequested() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((CardQrRequestMoneyBinding) vb).initRecordTimeStamp.showSkeleton();
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((CardQrRequestMoneyBinding) vb2).GetContactSyncConfig.setEnableShareButton(false);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((CardQrRequestMoneyBinding) vb).initRecordTimeStamp.showEmptyQr();
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                ((CardQrRequestMoneyBinding) vb2).initRecordTimeStamp.setEnabled(true);
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    ((CardQrRequestMoneyBinding) vb3).initRecordTimeStamp.hideSkeleton();
                    VB vb4 = this.PlaceComponentResult;
                    if (vb4 != 0) {
                        ((CardQrRequestMoneyBinding) vb4).GetContactSyncConfig.setEnableShareButton(true);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void getAuthRequestContext(boolean p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            CardQrRequestMoneyBinding cardQrRequestMoneyBinding = (CardQrRequestMoneyBinding) vb;
            DanaButtonSecondaryView danaButtonSecondaryView = cardQrRequestMoneyBinding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
            danaButtonSecondaryView.setVisibility(!PrepareContext() && !p0 ? 0 : 8);
            Group group = cardQrRequestMoneyBinding.PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(group, "");
            group.setVisibility(!PrepareContext() || p0 ? 4 : 0);
            TextView textView = cardQrRequestMoneyBinding.NetworkUserEntityData$$ExternalSyntheticLambda8;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility((StringsKt.isBlank(this.scheduleImpl) ^ true) && !p0 ? 0 : 8);
            DanaButtonPrimaryView danaButtonPrimaryView = cardQrRequestMoneyBinding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
            danaButtonPrimaryView.setVisibility(p0 ? 0 : 8);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            SocialShareView socialShareView = ((CardQrRequestMoneyBinding) vb).GetContactSyncConfig;
            Intrinsics.checkNotNullExpressionValue(socialShareView, "");
            boolean z = !p0;
            socialShareView.setVisibility(z ? 4 : 0);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                AppCompatTextView appCompatTextView = ((CardQrRequestMoneyBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda7;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                appCompatTextView.setVisibility(z ? 4 : 0);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void MyBillsEntityDataFactory(boolean p0, long p1, boolean p2, boolean p3) {
        SendMoneyAnalyticTracker sendMoneyAnalyticTracker = this.sendMoneyAnalyticalTracker;
        if (sendMoneyAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            sendMoneyAnalyticTracker = null;
        }
        sendMoneyAnalyticTracker.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda0, p0, p1, p3, p2);
        this.MyBillsEntityDataFactory = 0L;
        this.lookAheadTest = 0L;
    }
}
