package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003!\"#B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\n\u0010\u000fJ!\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0013J\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\f\u0010\u0013J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0013J'\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0014\u0010\u0017J\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\f\u0010\u0019J\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0014\u0010\u0012J\u001f\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\f\u0010\u001bJ7\u0010\u0014\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u001c2\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u001cH\u0002¢\u0006\u0004\b\u0014\u0010\u001dR\u0012\u0010\n\u001a\u00020\u0004X\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u001e"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode;", "", "Landroidx/fragment/app/Fragment;", "p0", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "MyBillsEntityDataFactory", "(Landroidx/fragment/app/Fragment;)Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "Landroidx/fragment/app/strictmode/Violation;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;Landroidx/fragment/app/strictmode/Violation;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/fragment/app/strictmode/Violation;)V", "", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "Landroid/view/ViewGroup;", "getAuthRequestContext", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;)V", "(Landroidx/fragment/app/Fragment;)V", "PlaceComponentResult", "", "p2", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;I)V", "", "(Landroidx/fragment/app/Fragment;Z)V", "Ljava/lang/Runnable;", "(Landroidx/fragment/app/Fragment;Ljava/lang/Runnable;)V", "Ljava/lang/Class;", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;Ljava/lang/Class;Ljava/lang/Class;)Z", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "<init>", "()V", "Flag", "OnViolationListener", "Policy"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FragmentStrictMode {
    public static final FragmentStrictMode INSTANCE = new FragmentStrictMode();
    public static Policy BuiltInFictitiousFunctionClassFactory = Policy.PlaceComponentResult;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "<init>", "(Ljava/lang/String;I)V", "PENALTY_LOG", "PENALTY_DEATH", "DETECT_FRAGMENT_REUSE", "DETECT_FRAGMENT_TAG_USAGE", "DETECT_RETAIN_INSTANCE_USAGE", "DETECT_SET_USER_VISIBLE_HINT", "DETECT_TARGET_FRAGMENT_USAGE", "DETECT_WRONG_FRAGMENT_CONTAINER"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface OnViolationListener {
    }

    private FragmentStrictMode() {
    }

    private static Policy MyBillsEntityDataFactory(Fragment p0) {
        while (p0 != null) {
            if (p0.isAdded()) {
                FragmentManager parentFragmentManager = p0.getParentFragmentManager();
                Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
                if (parentFragmentManager.getStrictModePolicy() != null) {
                    Policy strictModePolicy = parentFragmentManager.getStrictModePolicy();
                    Intrinsics.checkNotNull(strictModePolicy);
                    return strictModePolicy;
                }
            }
            p0 = p0.getParentFragment();
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Fragment p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(p0, p1);
        KClassImpl$Data$declaredNonStaticMembers$2(fragmentReuseViolation);
        Policy MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0);
        if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.contains(Flag.DETECT_FRAGMENT_REUSE) && PlaceComponentResult(MyBillsEntityDataFactory, (Class<? extends Fragment>) p0.getClass(), (Class<? extends Violation>) fragmentReuseViolation.getClass())) {
            BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, fragmentReuseViolation);
        }
    }

    @JvmStatic
    public static final void getAuthRequestContext(Fragment p0, ViewGroup p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(p0, p1);
        KClassImpl$Data$declaredNonStaticMembers$2(fragmentTagUsageViolation);
        Policy MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0);
        if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && PlaceComponentResult(MyBillsEntityDataFactory, (Class<? extends Fragment>) p0.getClass(), (Class<? extends Violation>) fragmentTagUsageViolation.getClass())) {
            BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, fragmentTagUsageViolation);
        }
    }

    @JvmStatic
    public static final void PlaceComponentResult(Fragment p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(p0);
        KClassImpl$Data$declaredNonStaticMembers$2(setRetainInstanceUsageViolation);
        Policy MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0);
        if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && PlaceComponentResult(MyBillsEntityDataFactory, (Class<? extends Fragment>) p0.getClass(), (Class<? extends Violation>) setRetainInstanceUsageViolation.getClass())) {
            BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, setRetainInstanceUsageViolation);
        }
    }

    @JvmStatic
    public static final void getAuthRequestContext(Fragment p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(p0);
        KClassImpl$Data$declaredNonStaticMembers$2(getRetainInstanceUsageViolation);
        Policy MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0);
        if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && PlaceComponentResult(MyBillsEntityDataFactory, (Class<? extends Fragment>) p0.getClass(), (Class<? extends Violation>) getRetainInstanceUsageViolation.getClass())) {
            BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, getRetainInstanceUsageViolation);
        }
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Fragment p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(p0, p1);
        KClassImpl$Data$declaredNonStaticMembers$2(setUserVisibleHintViolation);
        Policy MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0);
        if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && PlaceComponentResult(MyBillsEntityDataFactory, (Class<? extends Fragment>) p0.getClass(), (Class<? extends Violation>) setUserVisibleHintViolation.getClass())) {
            BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, setUserVisibleHintViolation);
        }
    }

    @JvmStatic
    public static final void PlaceComponentResult(Fragment p0, Fragment p1, int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(p0, p1, p2);
        KClassImpl$Data$declaredNonStaticMembers$2(setTargetFragmentUsageViolation);
        Policy MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0);
        if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && PlaceComponentResult(MyBillsEntityDataFactory, (Class<? extends Fragment>) p0.getClass(), (Class<? extends Violation>) setTargetFragmentUsageViolation.getClass())) {
            BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, setTargetFragmentUsageViolation);
        }
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Fragment p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(p0);
        KClassImpl$Data$declaredNonStaticMembers$2(getTargetFragmentUsageViolation);
        Policy MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0);
        if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && PlaceComponentResult(MyBillsEntityDataFactory, (Class<? extends Fragment>) p0.getClass(), (Class<? extends Violation>) getTargetFragmentUsageViolation.getClass())) {
            BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, getTargetFragmentUsageViolation);
        }
    }

    @JvmStatic
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Fragment p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(p0);
        KClassImpl$Data$declaredNonStaticMembers$2(getTargetFragmentRequestCodeUsageViolation);
        Policy MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0);
        if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && PlaceComponentResult(MyBillsEntityDataFactory, (Class<? extends Fragment>) p0.getClass(), (Class<? extends Violation>) getTargetFragmentRequestCodeUsageViolation.getClass())) {
            BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    @JvmStatic
    public static final void PlaceComponentResult(Fragment p0, ViewGroup p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(p0, p1);
        KClassImpl$Data$declaredNonStaticMembers$2(wrongFragmentContainerViolation);
        Policy MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0);
        if (MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && PlaceComponentResult(MyBillsEntityDataFactory, (Class<? extends Fragment>) p0.getClass(), (Class<? extends Violation>) wrongFragmentContainerViolation.getClass())) {
            BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, wrongFragmentContainerViolation);
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(Violation p0) {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("StrictMode violation in ");
            sb.append(p0.getFragment().getClass().getName());
            InstrumentInjector.log_d(FragmentManager.TAG, sb.toString(), p0);
        }
    }

    private static boolean PlaceComponentResult(Policy p0, Class<? extends Fragment> p1, Class<? extends Violation> p2) {
        Set<Class<? extends Violation>> set = p0.BuiltInFictitiousFunctionClassFactory.get(p1.getName());
        if (set == null) {
            return true;
        }
        if (Intrinsics.areEqual(p2.getSuperclass(), Violation.class) || !CollectionsKt.contains(set, p2.getSuperclass())) {
            return !set.contains(p2);
        }
        return false;
    }

    private static void BuiltInFictitiousFunctionClassFactory(final Policy p0, final Violation p1) {
        Fragment fragment = p1.getFragment();
        final String name = fragment.getClass().getName();
        if (p0.KClassImpl$Data$declaredNonStaticMembers$2.contains(Flag.PENALTY_LOG)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Policy violation in ");
            sb.append(name);
            InstrumentInjector.log_d("FragmentStrictMode", sb.toString(), p1);
        }
        if (p0.PlaceComponentResult != null) {
            KClassImpl$Data$declaredNonStaticMembers$2(fragment, new Runnable() { // from class: androidx.fragment.app.strictmode.FragmentStrictMode$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentStrictMode.getAuthRequestContext(FragmentStrictMode.Policy.this, p1);
                }
            });
        }
        if (p0.KClassImpl$Data$declaredNonStaticMembers$2.contains(Flag.PENALTY_DEATH)) {
            KClassImpl$Data$declaredNonStaticMembers$2(fragment, new Runnable() { // from class: androidx.fragment.app.strictmode.FragmentStrictMode$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentStrictMode.PlaceComponentResult(name, p1);
                }
            });
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(Fragment p0, Runnable p1) {
        if (p0.isAdded()) {
            Handler handler = p0.getParentFragmentManager().getHost().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(handler, "");
            if (!Intrinsics.areEqual(handler.getLooper(), Looper.myLooper())) {
                handler.post(p1);
                return;
            }
        }
        p1.run();
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0002\u0018\u0017BC\b\u0000\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012 \u0010\u0014\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\u00130\n¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0000¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0000¢\u0006\u0006\n\u0004\b\u0006\u0010\bR+\u0010\u0010\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\u00020\nX\u0000¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "getAuthRequestContext", "Ljava/util/Set;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "PlaceComponentResult", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "MyBillsEntityDataFactory", "Ljava/util/Map;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "", "p2", "<init>", "(Ljava/util/Set;Ljava/util/Map;)V", "Companion", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Policy {
        public static final Policy PlaceComponentResult = new Policy(SetsKt.emptySet(), MapsKt.emptyMap());

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final OnViolationListener PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final Map<String, Set<Class<? extends Violation>>> BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final Set<Flag> KClassImpl$Data$declaredNonStaticMembers$2;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R.\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t0\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "PlaceComponentResult", "Ljava/util/Set;", "MyBillsEntityDataFactory", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/Map;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
            private final Set<Flag> MyBillsEntityDataFactory = new LinkedHashSet();

            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
            private final Map<String, Set<Class<? extends Violation>>> PlaceComponentResult = new LinkedHashMap();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Policy(Set<? extends Flag> set, Map<String, ? extends Set<Class<? extends Violation>>> map) {
            Intrinsics.checkNotNullParameter(set, "");
            Intrinsics.checkNotNullParameter(map, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = set;
            this.PlaceComponentResult = null;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<Class<? extends Violation>>> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            this.BuiltInFictitiousFunctionClassFactory = linkedHashMap;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(Policy policy, Violation violation) {
        Intrinsics.checkNotNullParameter(policy, "");
        Intrinsics.checkNotNullParameter(violation, "");
        OnViolationListener onViolationListener = policy.PlaceComponentResult;
    }

    public static /* synthetic */ void PlaceComponentResult(String str, Violation violation) {
        Intrinsics.checkNotNullParameter(violation, "");
        StringBuilder sb = new StringBuilder();
        sb.append("Policy violation with PENALTY_DEATH in ");
        sb.append(str);
        InstrumentInjector.log_e("FragmentStrictMode", sb.toString(), violation);
        throw violation;
    }
}
