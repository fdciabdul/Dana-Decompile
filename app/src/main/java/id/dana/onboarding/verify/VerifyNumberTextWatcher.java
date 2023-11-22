package id.dana.onboarding.verify;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.google.firebase.perf.metrics.Trace;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.tracker.performanceduration.DanaPerformanceDurationTracker;
import id.dana.tracker.EventTracker;
import id.dana.tracker.rds.RDSEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B-\u0012\u0006\u0010\u0003\u001a\u00020\u0016\u0012\u0006\u0010\t\u001a\u00020\u000f\u0012\b\b\u0002\u0010\n\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010#¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ1\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001a\u001a\u00020\u0019X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0010\u001a\u00060\u001cj\u0002`\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u001e\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u0014R\u0016\u0010!\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0016\u0010 \u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0014R\u0016\u0010\"\u001a\u0004\u0018\u00010#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010$"}, d2 = {"Lid/dana/onboarding/verify/VerifyNumberTextWatcher;", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "p0", "", "afterTextChanged", "(Landroid/text/Editable;)V", "", "", "p1", "p2", "p3", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "onTextChanged", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "MyBillsEntityDataFactory", "", "Z", "getAuthRequestContext", "Landroid/widget/EditText;", "BuiltInFictitiousFunctionClassFactory", "Landroid/widget/EditText;", "Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "PlaceComponentResult", "Lkotlin/Lazy;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "moveToNextValue", "Ljava/lang/StringBuilder;", "getErrorConfigVersion", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroid/widget/EditText;Landroid/content/Context;ZLandroidx/fragment/app/Fragment;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyNumberTextWatcher implements TextWatcher {
    private final EditText BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;
    private final Lazy PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    boolean scheduleImpl;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final StringBuilder KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Fragment NetworkUserEntityData$$ExternalSyntheticLambda0;

    public VerifyNumberTextWatcher(EditText editText, Context context, boolean z, Fragment fragment) {
        Intrinsics.checkNotNullParameter(editText, "");
        Intrinsics.checkNotNullParameter(context, "");
        this.BuiltInFictitiousFunctionClassFactory = editText;
        this.MyBillsEntityDataFactory = context;
        this.scheduleImpl = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = fragment;
        this.PlaceComponentResult = LazyKt.lazy(new Function0<FirebasePerformanceMonitor>() { // from class: id.dana.onboarding.verify.VerifyNumberTextWatcher$firebasePerformanceMonitor$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FirebasePerformanceMonitor invoke() {
                return FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
            }
        });
        this.moveToNextValue = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new StringBuilder();
    }

    public /* synthetic */ VerifyNumberTextWatcher(EditText editText, Context context, boolean z, Fragment fragment, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(editText, context, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : fragment);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getErrorConfigVersion = Intrinsics.areEqual("-", p0.subSequence(p1, p2 + p1).toString());
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
        this.getAuthRequestContext = p3 > 3;
        if ((this.NetworkUserEntityData$$ExternalSyntheticLambda0 instanceof VerifyNumberFragment) && this.moveToNextValue) {
            FirebasePerformanceMonitor firebasePerformanceMonitor = (FirebasePerformanceMonitor) this.PlaceComponentResult.getValue();
            Intrinsics.checkNotNullParameter(TrackerKey.Event.IDLE_INPUT_PHONE_NUMBER_SCREEN, "");
            Trace trace = firebasePerformanceMonitor.KClassImpl$Data$declaredNonStaticMembers$2.get(TrackerKey.Event.IDLE_INPUT_PHONE_NUMBER_SCREEN);
            if (trace != null) {
                trace.stop();
            }
            DanaPerformanceDurationTracker.INSTANCE.getAuthRequestContext(TrackerDataKey.ViewScreenName.PHONE_NUMBER_SCREEN, TrackerDataKey.Property.USER_IDLE_PHONE_NUMBER_SCREEN, System.currentTimeMillis());
            DanaPerformanceDurationTracker.INSTANCE.KClassImpl$Data$declaredNonStaticMembers$2(TrackerDataKey.ViewScreenName.PHONE_NUMBER_SCREEN, TrackerDataKey.Property.TYPING_PHONE_NUMBER_IN_MILLIS, System.currentTimeMillis());
            ((FirebasePerformanceMonitor) this.PlaceComponentResult.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.USER_INTERACTION_REGISTRATION_LOGIN_PHONE_NUMBER_INPUT);
            this.moveToNextValue = false;
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        VerifyNumberTextWatcher verifyNumberTextWatcher = this;
        this.BuiltInFictitiousFunctionClassFactory.removeTextChangedListener(verifyNumberTextWatcher);
        int selectionStart = this.BuiltInFictitiousFunctionClassFactory.getSelectionStart();
        String str = p0;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setLength(0);
        if (this.scheduleImpl) {
            int length = str.length();
            StringBuilder sb = this.KClassImpl$Data$declaredNonStaticMembers$2;
            sb.delete(0, sb.length());
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (i == 3 || i == 7) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.append(" ");
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2.append(str.charAt(i2));
                i++;
            }
            String obj = this.KClassImpl$Data$declaredNonStaticMembers$2.toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            this.scheduleImpl = obj.length() > 0;
        } else {
            if ((!StringsKt.isBlank(str)) == true && str.charAt(0) == '0') {
                str = str.subSequence(1, str.length());
            } else if ((!StringsKt.isBlank(str)) != false && str.length() > 3 && Intrinsics.areEqual(str.toString().subSequence(0, 1), "+62")) {
                str = StringsKt.drop(str.toString(), 3);
            }
            int length2 = str.length();
            StringBuilder sb2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            sb2.delete(0, sb2.length());
            int i3 = 0;
            for (int i4 = 0; i4 < length2; i4++) {
                if (Character.isDigit(str.charAt(i4))) {
                    if (i3 == 3 || i3 == 7) {
                        this.KClassImpl$Data$declaredNonStaticMembers$2.append("-");
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2.append(str.charAt(i4));
                    i3++;
                }
            }
        }
        String obj2 = this.KClassImpl$Data$declaredNonStaticMembers$2.toString();
        Intrinsics.checkNotNullExpressionValue(obj2, "");
        int length3 = obj2.length();
        int length4 = p0.length();
        Integer num = this.MyBillsEntityDataFactory.getResources() != null ? 15 : null;
        Intrinsics.checkNotNull(num);
        int max = Math.max(Math.min(selectionStart + (length3 - length4), num.intValue()), 0);
        if (this.scheduleImpl) {
            this.BuiltInFictitiousFunctionClassFactory.setText(obj2);
        } else {
            p0.replace(0, p0.length(), obj2);
        }
        this.BuiltInFictitiousFunctionClassFactory.setSelection(max);
        if (this.getErrorConfigVersion) {
            EditText editText = this.BuiltInFictitiousFunctionClassFactory;
            editText.setSelection(editText.getSelectionStart() - 1);
            this.getErrorConfigVersion = false;
        }
        if (this.getAuthRequestContext) {
            this.getAuthRequestContext = false;
            EditText editText2 = this.BuiltInFictitiousFunctionClassFactory;
            editText2.setSelection(editText2.getText().length());
        }
        this.BuiltInFictitiousFunctionClassFactory.addTextChangedListener(verifyNumberTextWatcher);
        EventTracker.BuiltInFictitiousFunctionClassFactory(new RDSEvent("Onboarding", "rds_on_key_down", "InputPhoneNumber", p0.toString()));
    }
}
