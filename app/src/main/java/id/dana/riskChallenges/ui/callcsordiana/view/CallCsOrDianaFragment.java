package id.dana.riskChallenges.ui.callcsordiana.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.DanaLogoLoadingDialog;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.model.HelpButtonChatBot;
import id.dana.domain.featureconfig.model.HelpButtonConfig;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentCallCsOrDianaBinding;
import id.dana.riskChallenges.di.provider.RiskChallengesProvider;
import id.dana.riskChallenges.ui.callcsordiana.viewmodel.CallCsOrDianaUiState;
import id.dana.riskChallenges.ui.callcsordiana.viewmodel.CallCsOrDianaViewModel;
import id.dana.riskChallenges.ui.util.model.TrackerModel;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import id.dana.utils.PhoneCall;
import id.dana.utils.danah5.DanaH5Facade;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.storage.UTDidInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u000fX\u0087\"¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001d8G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u0016\u0010!\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b \u0010\u0018R\u0012\u0010#\u001a\u00020\"X\u0087\"¢\u0006\u0006\n\u0004\b#\u0010$R\u0012\u0010&\u001a\u00020%X\u0087\"¢\u0006\u0006\n\u0004\b&\u0010'R\u0013\u0010\u0004\u001a\u00020(X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b!\u0010\u0014"}, d2 = {"Lid/dana/riskChallenges/ui/callcsordiana/view/CallCsOrDianaFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/riskChallenges/databinding/FragmentCallCsOrDianaBinding;", "", "lookAheadTest", "()V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "p1", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/utils/danah5/DanaH5Facade;", "danaH5Facade", "Lid/dana/utils/danah5/DanaH5Facade;", "Lid/dana/core/ui/dialog/DanaLogoLoadingDialog;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "", "moveToNextValue", "Ljava/lang/String;", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "scheduleImpl", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "PlaceComponentResult", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "()Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "getAuthRequestContext", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/utils/storage/UTDidInfo;", "utDidInfo", "Lid/dana/utils/storage/UTDidInfo;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "Lid/dana/riskChallenges/ui/callcsordiana/viewmodel/CallCsOrDianaViewModel;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CallCsOrDianaFragment extends BaseViewBindingFragment<FragmentCallCsOrDianaBinding> {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy lookAheadTest;
    @Inject
    public DanaH5Facade danaH5Facade;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private FragmentPermissionRequest PlaceComponentResult;
    @Inject
    public UTDidInfo utDidInfo;
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$a = {44, -51, -23, -10, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 219;
    public static final byte[] PlaceComponentResult = {Ascii.US, -80, -88, -103, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int MyBillsEntityDataFactory = 16;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<DanaLogoLoadingDialog>() { // from class: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment$danaLoadingDialog$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DanaLogoLoadingDialog invoke() {
            Context context = CallCsOrDianaFragment.this.getContext();
            if (context != null) {
                return new DanaLogoLoadingDialog(context);
            }
            return null;
        }
    });

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory = "";

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0 = "";

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 4
            byte[] r0 = id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment.PlaceComponentResult
            int r6 = 106 - r6
            int r7 = r7 * 3
            int r7 = 16 - r7
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r8 = r8 + 1
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r6 = r6 + r8
            int r6 = r6 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment.a(short, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = 75 - r6
            byte[] r0 = id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment.$$a
            int r8 = r8 * 3
            int r8 = r8 + 42
            int r7 = r7 * 2
            int r7 = r7 + 4
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r8 = r8 + r6
            int r6 = r8 + (-7)
            int r7 = r7 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment.b(short, byte, int, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentCallCsOrDianaBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentCallCsOrDianaBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentCallCsOrDianaBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "PlaceComponentResult")
    private UiComponent PlaceComponentResult() {
        Object obj;
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                obj = (Parcelable) arguments.getParcelable("KEY_UI_COMPONENT", UiComponent.class);
            } else {
                Object parcelable = arguments.getParcelable("KEY_UI_COMPONENT");
                obj = (Parcelable) ((UiComponent) (parcelable instanceof UiComponent ? parcelable : null));
            }
            return (UiComponent) obj;
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (PlaceComponentResult[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 | 14), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-PlaceComponentResult[5]);
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 - 1), PlaceComponentResult[5], objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 494, MotionEvent.axisFromString("") + 5, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
                    byte b4 = (byte) ($$a[35] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    b(b4, b5, b5, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (ViewConfiguration.getJumpTapTimeout() >> 16) + 35, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-882948074, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                super.onCreate(p0);
                Bundle arguments = getArguments();
                String string = arguments != null ? arguments.getString("KEY_PHONE_NUMBER") : null;
                if (string == null) {
                    string = "";
                }
                this.BuiltInFictitiousFunctionClassFactory = string;
                Bundle arguments2 = getArguments();
                String string2 = arguments2 != null ? arguments2.getString("KEY_USE_CASE_STRATEGY") : null;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = string2 != null ? string2 : "";
                UiComponent PlaceComponentResult2 = PlaceComponentResult();
                this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult2 != null ? getString(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory) : null;
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 == null) {
                throw th4;
            }
            throw cause4;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.riskChallenges.di.provider.RiskChallengesProvider");
        }
        ((RiskChallengesProvider) applicationContext).provideRiskChallengesComponent().BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(this);
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCallCsOrDianaBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.setText(this.KClassImpl$Data$declaredNonStaticMembers$2);
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                AppCompatImageView appCompatImageView = ((FragmentCallCsOrDianaBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
                int i = R.drawable.getAuthRequestContext;
                if (appCompatImageView instanceof ImageView) {
                    InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
                } else {
                    appCompatImageView.setImageResource(i);
                }
                VB vb3 = this.PlaceComponentResult;
                if (vb3 != 0) {
                    ((FragmentCallCsOrDianaBinding) vb3).KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CallCsOrDianaFragment.PlaceComponentResult(CallCsOrDianaFragment.this);
                        }
                    });
                    UTDidInfo uTDidInfo = null;
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(this), null, null, new CallCsOrDianaFragment$initLifecycleFragment$1(this, null), 3, null);
                    FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
                    String[] strArr = {"android.permission.CALL_PHONE"};
                    Intrinsics.checkNotNullParameter(strArr, "");
                    builder.getAuthRequestContext = ArraysKt.toSet(strArr);
                    PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment$initPhonePermission$1
                        @Override // com.anggrayudi.storage.permission.PermissionCallback
                        public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                            PermissionCallback.CC.getAuthRequestContext(permissionRequest);
                        }

                        @Override // com.anggrayudi.storage.permission.PermissionCallback
                        public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                            PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
                        }

                        @Override // com.anggrayudi.storage.permission.PermissionCallback
                        public final void onPermissionsChecked(PermissionResult p02, boolean p12) {
                            Intrinsics.checkNotNullParameter(p02, "");
                            if (p02.MyBillsEntityDataFactory()) {
                                PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(CallCsOrDianaFragment.this.requireActivity(), "1500445", true);
                            }
                        }
                    };
                    Intrinsics.checkNotNullParameter(permissionCallback, "");
                    builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
                    this.PlaceComponentResult = builder.PlaceComponentResult();
                    UiComponent PlaceComponentResult2 = PlaceComponentResult();
                    if (PlaceComponentResult2 != null) {
                        VB vb4 = this.PlaceComponentResult;
                        if (vb4 != 0) {
                            ((FragmentCallCsOrDianaBinding) vb4).getAuthRequestContext.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), PlaceComponentResult2.MyBillsEntityDataFactory));
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                    final CallCsOrDianaViewModel callCsOrDianaViewModel = (CallCsOrDianaViewModel) this.lookAheadTest.getValue();
                    final String str = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    final String str2 = this.BuiltInFictitiousFunctionClassFactory;
                    UTDidInfo uTDidInfo2 = this.utDidInfo;
                    if (uTDidInfo2 != null) {
                        uTDidInfo = uTDidInfo2;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    final String utdid = uTDidInfo.getUtdid();
                    Intrinsics.checkNotNullParameter(str, "");
                    Intrinsics.checkNotNullParameter(str2, "");
                    Intrinsics.checkNotNullParameter(utdid, "");
                    callCsOrDianaViewModel.getAuthRequestContext.execute(NoParams.INSTANCE, new Function1<HelpButtonChatBot, Unit>() { // from class: id.dana.riskChallenges.ui.callcsordiana.viewmodel.CallCsOrDianaViewModel$getHelpButtonChatBotFeature$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(HelpButtonChatBot helpButtonChatBot) {
                            invoke2(helpButtonChatBot);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(HelpButtonChatBot helpButtonChatBot) {
                            MutableStateFlow mutableStateFlow;
                            Object value;
                            MutableStateFlow mutableStateFlow2;
                            Object value2;
                            Intrinsics.checkNotNullParameter(helpButtonChatBot, "");
                            HelpButtonConfig helpButtonConfigByType = helpButtonChatBot.getHelpButtonConfigByType(str);
                            if (helpButtonConfigByType == null) {
                                mutableStateFlow2 = callCsOrDianaViewModel.PlaceComponentResult;
                                do {
                                    value2 = mutableStateFlow2.getValue();
                                    CallCsOrDianaUiState callCsOrDianaUiState = (CallCsOrDianaUiState) value2;
                                } while (!mutableStateFlow2.compareAndSet(value2, CallCsOrDianaUiState.OnErrorGetHelpButtonChatBotFeature.INSTANCE));
                                return;
                            }
                            HelpButtonConfig helpButtonConfig = new HelpButtonConfig(helpButtonConfigByType.getEnable(), helpButtonConfigByType.getType(), CallCsOrDianaViewModel.BuiltInFictitiousFunctionClassFactory(helpButtonConfigByType.getUrl(), str2, utdid));
                            mutableStateFlow = callCsOrDianaViewModel.PlaceComponentResult;
                            do {
                                value = mutableStateFlow.getValue();
                                CallCsOrDianaUiState callCsOrDianaUiState2 = (CallCsOrDianaUiState) value;
                            } while (!mutableStateFlow.compareAndSet(value, new CallCsOrDianaUiState.OnGetHelpButtonChatBotFeature(helpButtonConfig)));
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.callcsordiana.viewmodel.CallCsOrDianaViewModel$getHelpButtonChatBotFeature$2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            MutableStateFlow mutableStateFlow;
                            Object value;
                            Intrinsics.checkNotNullParameter(th, "");
                            mutableStateFlow = CallCsOrDianaViewModel.this.PlaceComponentResult;
                            do {
                                value = mutableStateFlow.getValue();
                                CallCsOrDianaUiState callCsOrDianaUiState = (CallCsOrDianaUiState) value;
                            } while (!mutableStateFlow.compareAndSet(value, CallCsOrDianaUiState.OnErrorGetHelpButtonChatBotFeature.INSTANCE));
                        }
                    });
                    DanaLogoLoadingDialog danaLogoLoadingDialog = (DanaLogoLoadingDialog) this.MyBillsEntityDataFactory.getValue();
                    if (danaLogoLoadingDialog == null || danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.isShowing()) {
                        return;
                    }
                    danaLogoLoadingDialog.KClassImpl$Data$declaredNonStaticMembers$2.show();
                    danaLogoLoadingDialog.MyBillsEntityDataFactory.startRefresh();
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        KeyboardHelper.getAuthRequestContext(getGetAuthRequestContext());
        BuiltInFictitiousFunctionClassFactory();
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        if (FragmentExtKt.PlaceComponentResult(this)) {
            getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0)));
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/riskChallenges/ui/callcsordiana/view/CallCsOrDianaFragment$Companion;", "", "", "p0", "p1", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "p2", "Lid/dana/riskChallenges/ui/util/model/TrackerModel;", "p3", "Lid/dana/riskChallenges/ui/callcsordiana/view/CallCsOrDianaFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Lid/dana/riskChallenges/ui/util/model/TrackerModel;)Lid/dana/riskChallenges/ui/callcsordiana/view/CallCsOrDianaFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static CallCsOrDianaFragment KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, UiComponent p2, TrackerModel p3) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p3, "");
            DanaLog.BuiltInFictitiousFunctionClassFactory("test title newInstance", String.valueOf(p2));
            CallCsOrDianaFragment callCsOrDianaFragment = new CallCsOrDianaFragment();
            callCsOrDianaFragment.setArguments(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_PHONE_NUMBER", p0), TuplesKt.to("KEY_USE_CASE_STRATEGY", p1), TuplesKt.to("KEY_UI_COMPONENT", p2), TuplesKt.to("KEY_TRACKER_MODEL", p3)));
            return callCsOrDianaFragment;
        }
    }

    public CallCsOrDianaFragment() {
        final CallCsOrDianaFragment callCsOrDianaFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = CallCsOrDianaFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) Function0.this.invoke();
            }
        });
        final Function0 function03 = null;
        this.lookAheadTest = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(callCsOrDianaFragment, Reflection.getOrCreateKotlinClass(CallCsOrDianaViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.PlaceComponentResult(Lazy.this).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = Function0.this;
                if (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) {
                    ViewModelStoreOwner PlaceComponentResult2 = FragmentViewModelLazyKt.PlaceComponentResult(lazy);
                    HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = PlaceComponentResult2 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) PlaceComponentResult2 : null;
                    CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                    return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, function0);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final CallCsOrDianaFragment callCsOrDianaFragment, String str) {
        Intrinsics.checkNotNullParameter(callCsOrDianaFragment, "");
        Intrinsics.checkNotNullParameter(str, "");
        DanaH5Facade danaH5Facade = callCsOrDianaFragment.danaH5Facade;
        if (danaH5Facade == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaH5Facade = null;
        }
        danaH5Facade.startContainerFullUrlWithoutTimeout(str, new DanaH5Listener() { // from class: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment$setViewAsChatBot$2$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                CallCsOrDianaFragment.getAuthRequestContext(CallCsOrDianaFragment.this);
            }
        });
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CallCsOrDianaFragment callCsOrDianaFragment) {
        Intrinsics.checkNotNullParameter(callCsOrDianaFragment, "");
        FragmentPermissionRequest fragmentPermissionRequest = callCsOrDianaFragment.PlaceComponentResult;
        if (fragmentPermissionRequest != null) {
            fragmentPermissionRequest.check();
        }
    }

    public static /* synthetic */ void PlaceComponentResult(CallCsOrDianaFragment callCsOrDianaFragment) {
        Intrinsics.checkNotNullParameter(callCsOrDianaFragment, "");
        callCsOrDianaFragment.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ DanaLogoLoadingDialog MyBillsEntityDataFactory(CallCsOrDianaFragment callCsOrDianaFragment) {
        return (DanaLogoLoadingDialog) callCsOrDianaFragment.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ CallCsOrDianaViewModel BuiltInFictitiousFunctionClassFactory(CallCsOrDianaFragment callCsOrDianaFragment) {
        return (CallCsOrDianaViewModel) callCsOrDianaFragment.lookAheadTest.getValue();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final CallCsOrDianaFragment callCsOrDianaFragment, HelpButtonConfig helpButtonConfig) {
        VB vb = callCsOrDianaFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentCallCsOrDianaBinding) vb).moveToNextValue.setText(callCsOrDianaFragment.getString(R.string.call_diana_and_cs_title));
            if (helpButtonConfig.getEnable()) {
                final String url = helpButtonConfig.getUrl();
                Context context = callCsOrDianaFragment.getContext();
                if (context != null) {
                    VB vb2 = callCsOrDianaFragment.PlaceComponentResult;
                    if (vb2 != 0) {
                        ((FragmentCallCsOrDianaBinding) vb2).PlaceComponentResult.setImageDrawable(ContextCompat.PlaceComponentResult(context, R.drawable.res_0x7f0808da_kclassimpl_data_declarednonstaticmembers_2));
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                VB vb3 = callCsOrDianaFragment.PlaceComponentResult;
                if (vb3 != 0) {
                    ((FragmentCallCsOrDianaBinding) vb3).getErrorConfigVersion.setText(callCsOrDianaFragment.getString(R.string.call_diana_description));
                    VB vb4 = callCsOrDianaFragment.PlaceComponentResult;
                    if (vb4 != 0) {
                        ((FragmentCallCsOrDianaBinding) vb4).BuiltInFictitiousFunctionClassFactory.setActiveButton(callCsOrDianaFragment.getString(R.string.MyBillsEntityDataFactory_res_0x7f1303a6), null);
                        VB vb5 = callCsOrDianaFragment.PlaceComponentResult;
                        if (vb5 != 0) {
                            ((FragmentCallCsOrDianaBinding) vb5).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment$$ExternalSyntheticLambda2
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    CallCsOrDianaFragment.BuiltInFictitiousFunctionClassFactory(CallCsOrDianaFragment.this, url);
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
            Context context2 = callCsOrDianaFragment.getContext();
            if (context2 != null) {
                VB vb6 = callCsOrDianaFragment.PlaceComponentResult;
                if (vb6 != 0) {
                    ((FragmentCallCsOrDianaBinding) vb6).PlaceComponentResult.setImageDrawable(ContextCompat.PlaceComponentResult(context2, R.drawable.BuiltInFictitiousFunctionClassFactory_res_0x7f0807f3));
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            VB vb7 = callCsOrDianaFragment.PlaceComponentResult;
            if (vb7 != 0) {
                ((FragmentCallCsOrDianaBinding) vb7).getErrorConfigVersion.setText(callCsOrDianaFragment.getString(R.string.contact_cs_description));
                VB vb8 = callCsOrDianaFragment.PlaceComponentResult;
                if (vb8 != 0) {
                    ((FragmentCallCsOrDianaBinding) vb8).BuiltInFictitiousFunctionClassFactory.setActiveButton(callCsOrDianaFragment.getString(R.string.getAuthRequestContext_res_0x7f13050a), null);
                    VB vb9 = callCsOrDianaFragment.PlaceComponentResult;
                    if (vb9 != 0) {
                        ((FragmentCallCsOrDianaBinding) vb9).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.callcsordiana.view.CallCsOrDianaFragment$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                CallCsOrDianaFragment.KClassImpl$Data$declaredNonStaticMembers$2(CallCsOrDianaFragment.this);
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

    public static final /* synthetic */ void getAuthRequestContext(CallCsOrDianaFragment callCsOrDianaFragment) {
        if (callCsOrDianaFragment.isAdded()) {
            callCsOrDianaFragment.getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0), TuplesKt.to("KEY_IS_ERROR", Boolean.TRUE)));
        }
    }
}
