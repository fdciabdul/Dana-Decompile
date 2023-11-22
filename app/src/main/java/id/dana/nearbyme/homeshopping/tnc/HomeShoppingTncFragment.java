package id.dana.nearbyme.homeshopping.tnc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.fullstory.instrumentation.InstrumentInjector;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.di.component.ApplicationComponent;
import id.dana.nearbyme.di.component.DaggerHomeShoppingTncComponent;
import id.dana.nearbyme.di.module.HomeShoppingTncModule;
import id.dana.nearbyme.homeshopping.tnc.HomeShoppingTncContract;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0015\u0010\u0011J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0013\u001a\u00020\u0012X\u0087\"¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/nearbyme/homeshopping/tnc/HomeShoppingTncFragment;", "Landroidx/fragment/app/Fragment;", "", "PlaceComponentResult", "()Lkotlin/Unit;", "Landroid/os/Bundle;", "p0", "onActivityCreated", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "p1", "p2", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onDestroyView", "()V", "Lid/dana/nearbyme/homeshopping/tnc/HomeShoppingTncPresenter;", "presenter", "Lid/dana/nearbyme/homeshopping/tnc/HomeShoppingTncPresenter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HomeShoppingTncFragment extends Fragment {
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();
    @Inject
    public HomeShoppingTncPresenter presenter;

    public final View MyBillsEntityDataFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
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

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0.inflate(R.layout.fragment_home_shopping_tnc, p1, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle p0) {
        String string;
        ApplicationComponent applicationComponent;
        super.onActivityCreated(p0);
        FragmentActivity activity = getActivity();
        HomeShoppingTncPresenter homeShoppingTncPresenter = null;
        BaseActivity baseActivity = activity instanceof BaseActivity ? (BaseActivity) activity : null;
        if (baseActivity != null && (applicationComponent = baseActivity.getApplicationComponent()) != null) {
            DaggerHomeShoppingTncComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerHomeShoppingTncComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (HomeShoppingTncModule) Preconditions.getAuthRequestContext(new HomeShoppingTncModule(new HomeShoppingTncContract.View() { // from class: id.dana.nearbyme.homeshopping.tnc.HomeShoppingTncFragment$setupComponent$1$1
                private static int $10 = 0;
                private static int $11 = 1;
                private static int BuiltInFictitiousFunctionClassFactory = 1;
                private static int MyBillsEntityDataFactory;
                private static char[] getAuthRequestContext = {35458, 35544, 35530, 35539, 35495};

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    try {
                        int i = MyBillsEntityDataFactory + 47;
                        try {
                            BuiltInFictitiousFunctionClassFactory = i % 128;
                            int i2 = i % 2;
                            AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                            int i3 = MyBillsEntityDataFactory + 125;
                            BuiltInFictitiousFunctionClassFactory = i3 % 128;
                            int i4 = i3 % 2;
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    try {
                        int i = MyBillsEntityDataFactory + 65;
                        BuiltInFictitiousFunctionClassFactory = i % 128;
                        int i2 = i % 2;
                        String authRequestContext = AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                        int i3 = BuiltInFictitiousFunctionClassFactory + 21;
                        MyBillsEntityDataFactory = i3 % 128;
                        if ((i3 % 2 != 0 ? 'W' : '+') != '+') {
                            int i4 = 88 / 0;
                            return authRequestContext;
                        }
                        return authRequestContext;
                    } catch (Exception e) {
                        throw e;
                    }
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str) {
                    int i = MyBillsEntityDataFactory + 5;
                    BuiltInFictitiousFunctionClassFactory = i % 128;
                    int i2 = i % 2;
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                    int i3 = BuiltInFictitiousFunctionClassFactory + 39;
                    MyBillsEntityDataFactory = i3 % 128;
                    if (!(i3 % 2 != 0)) {
                        return;
                    }
                    Object[] objArr = null;
                    int length = objArr.length;
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    int i = MyBillsEntityDataFactory + 21;
                    BuiltInFictitiousFunctionClassFactory = i % 128;
                    char c = i % 2 == 0 ? '9' : 'A';
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                    if (c != 'A') {
                        Object[] objArr = null;
                        int length = objArr.length;
                    }
                    int i2 = MyBillsEntityDataFactory + 7;
                    BuiltInFictitiousFunctionClassFactory = i2 % 128;
                    int i3 = i2 % 2;
                }

                @Override // id.dana.nearbyme.homeshopping.tnc.HomeShoppingTncContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(String p02) {
                    Intrinsics.checkNotNullParameter(p02, "");
                    WebView webView = (WebView) HomeShoppingTncFragment.this.MyBillsEntityDataFactory(R.id.res_0x7f0a1bfb_getstacktrace_annotations);
                    if ((webView != null ? ':' : Typography.less) == ':') {
                        int i = MyBillsEntityDataFactory + 55;
                        BuiltInFictitiousFunctionClassFactory = i % 128;
                        int i2 = i % 2;
                        InstrumentInjector.trackWebView(webView);
                        Object[] objArr = new Object[1];
                        a(new int[]{0, 5, 0, 1}, false, new byte[]{0, 1, 1, 0, 1}, objArr);
                        webView.loadData(p02, "text/html; charset=utf-8", ((String) objArr[0]).intern());
                    }
                    int i3 = MyBillsEntityDataFactory + 1;
                    BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    if ((i3 % 2 == 0 ? '_' : 'R') != 'R') {
                        int i4 = 55 / 0;
                    }
                }

                @Override // id.dana.nearbyme.homeshopping.tnc.HomeShoppingTncContract.View
                public final void PlaceComponentResult() {
                    int i = BuiltInFictitiousFunctionClassFactory + 89;
                    MyBillsEntityDataFactory = i % 128;
                    if ((i % 2 == 0 ? (char) 21 : 'Y') != 21) {
                        try {
                            HomeShoppingTncFragment.this.PlaceComponentResult();
                            Object[] objArr = null;
                            int length = objArr.length;
                        } catch (Exception e) {
                            throw e;
                        }
                    } else {
                        HomeShoppingTncFragment.this.PlaceComponentResult();
                    }
                    int i2 = MyBillsEntityDataFactory + 13;
                    BuiltInFictitiousFunctionClassFactory = i2 % 128;
                    int i3 = i2 % 2;
                }

                private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
                    int i;
                    int i2;
                    VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
                    int i3 = iArr[0];
                    int i4 = iArr[1];
                    int i5 = 2;
                    int i6 = iArr[2];
                    int i7 = iArr[3];
                    char[] cArr = getAuthRequestContext;
                    if (cArr != null) {
                        int length = cArr.length;
                        char[] cArr2 = new char[length];
                        int i8 = 0;
                        while (true) {
                            if (!(i8 < length)) {
                                break;
                            }
                            int i9 = $10 + 31;
                            $11 = i9 % 128;
                            if (i9 % i5 == 0) {
                                i2 = i6;
                                cArr2[i8] = (char) (cArr[i8] / 5097613533456403102L);
                            } else {
                                i2 = i6;
                                try {
                                    cArr2[i8] = (char) (cArr[i8] ^ 5097613533456403102L);
                                } catch (Exception e) {
                                    throw e;
                                }
                            }
                            i8++;
                            i6 = i2;
                            i5 = 2;
                        }
                        i = i6;
                        cArr = cArr2;
                    } else {
                        i = i6;
                    }
                    char[] cArr3 = new char[i4];
                    System.arraycopy(cArr, i3, cArr3, 0, i4);
                    if ((bArr != null ? '\'' : ')') == '\'') {
                        char[] cArr4 = new char[i4];
                        try {
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                            char c = 0;
                            while (true) {
                                if (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory >= i4) {
                                    break;
                                }
                                if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                                } else {
                                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                                }
                                c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                                int i10 = $10 + 83;
                                $11 = i10 % 128;
                                int i11 = i10 % 2;
                            }
                            cArr3 = cArr4;
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                    if (i7 > 0) {
                        char[] cArr5 = new char[i4];
                        System.arraycopy(cArr3, 0, cArr5, 0, i4);
                        int i12 = i4 - i7;
                        System.arraycopy(cArr5, 0, cArr3, i12, i7);
                        System.arraycopy(cArr5, i7, cArr3, 0, i12);
                    }
                    if (z) {
                        char[] cArr6 = new char[i4];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        while (true) {
                            if ((verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4 ? Typography.less : (char) 23) == 23) {
                                break;
                            }
                            cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i4 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                        }
                        cArr3 = cArr6;
                    }
                    if ((i > 0 ? (char) 1 : 'E') != 'E') {
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        while (true) {
                            if (!(verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4)) {
                                break;
                            }
                            cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                        }
                    }
                    objArr[0] = new String(cArr3);
                }
            }));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, HomeShoppingTncModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
            new DaggerHomeShoppingTncComponent.HomeShoppingTncComponentImpl(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
            Unit unit = Unit.INSTANCE;
        }
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("HOME_SHOPPING_TNC_DATA_KEY")) == null) {
            PlaceComponentResult();
            return;
        }
        HomeShoppingTncPresenter homeShoppingTncPresenter2 = this.presenter;
        if (homeShoppingTncPresenter2 != null) {
            homeShoppingTncPresenter = homeShoppingTncPresenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        Intrinsics.checkNotNullParameter(string, "");
        homeShoppingTncPresenter.PlaceComponentResult.execute(string, new HomeShoppingTncPresenter$getTnc$1(homeShoppingTncPresenter.MyBillsEntityDataFactory), new HomeShoppingTncPresenter$getTnc$2(homeShoppingTncPresenter));
        Unit unit2 = Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Unit PlaceComponentResult() {
        WebView webView = (WebView) MyBillsEntityDataFactory(R.id.res_0x7f0a1bfb_getstacktrace_annotations);
        if (webView != null) {
            InstrumentInjector.trackWebView(webView);
            webView.loadUrl("file:///android_asset/nearby/home_shopping_tnc.html");
            return Unit.INSTANCE;
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        HomeShoppingTncPresenter homeShoppingTncPresenter = this.presenter;
        if (homeShoppingTncPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            homeShoppingTncPresenter = null;
        }
        homeShoppingTncPresenter.onDestroy();
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }
}
