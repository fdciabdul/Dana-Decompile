package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R;
import androidx.core.os.BuildCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class AccessibilityNodeInfoCompat {
    private static int BuiltInFictitiousFunctionClassFactory;
    private final AccessibilityNodeInfo MyBillsEntityDataFactory;
    public int getAuthRequestContext = -1;
    private int PlaceComponentResult = -1;

    /* loaded from: classes6.dex */
    public static final class TouchDelegateInfoCompat {
    }

    private static String PlaceComponentResult(int i) {
        if (i != 1) {
            if (i != 2) {
                switch (i) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case 512:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case 8192:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case AntDetector.SCENE_ID_LOGIN_REGIST /* 131072 */:
                        return "ACTION_SET_SELECTION";
                    case 262144:
                        return "ACTION_EXPAND";
                    case 524288:
                        return "ACTION_COLLAPSE";
                    case 2097152:
                        return "ACTION_SET_TEXT";
                    case 16908354:
                        return "ACTION_MOVE_WINDOW";
                    default:
                        switch (i) {
                            case 16908342:
                                return "ACTION_SHOW_ON_SCREEN";
                            case 16908343:
                                return "ACTION_SCROLL_TO_POSITION";
                            case 16908344:
                                return "ACTION_SCROLL_UP";
                            case 16908345:
                                return "ACTION_SCROLL_LEFT";
                            case 16908346:
                                return "ACTION_SCROLL_DOWN";
                            case 16908347:
                                return "ACTION_SCROLL_RIGHT";
                            case 16908348:
                                return "ACTION_CONTEXT_CLICK";
                            case 16908349:
                                return "ACTION_SET_PROGRESS";
                            default:
                                switch (i) {
                                    case 16908356:
                                        return "ACTION_SHOW_TOOLTIP";
                                    case 16908357:
                                        return "ACTION_HIDE_TOOLTIP";
                                    case 16908358:
                                        return "ACTION_PAGE_UP";
                                    case 16908359:
                                        return "ACTION_PAGE_DOWN";
                                    case 16908360:
                                        return "ACTION_PAGE_LEFT";
                                    case 16908361:
                                        return "ACTION_PAGE_RIGHT";
                                    case 16908362:
                                        return "ACTION_PRESS_AND_HOLD";
                                    default:
                                        switch (i) {
                                            case 16908372:
                                                return "ACTION_IME_ENTER";
                                            case 16908373:
                                                return "ACTION_DRAG_START";
                                            case 16908374:
                                                return "ACTION_DRAG_DROP";
                                            case 16908375:
                                                return "ACTION_DRAG_CANCEL";
                                            default:
                                                return "ACTION_UNKNOWN";
                                        }
                                }
                        }
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    /* loaded from: classes.dex */
    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat A;
        public static final AccessibilityActionCompat AppCompatEmojiTextHelper;
        public static final AccessibilityActionCompat B;
        public static final AccessibilityActionCompat BottomSheetCardBindingView$watcherCardNumberView$1;
        public static final AccessibilityActionCompat D;
        public static final AccessibilityActionCompat F;
        public static final AccessibilityActionCompat G;
        public static final AccessibilityActionCompat GetContactSyncConfig;
        public static final AccessibilityActionCompat NetworkUserEntityData$$ExternalSyntheticLambda2;
        public static final AccessibilityActionCompat NetworkUserEntityData$$ExternalSyntheticLambda3;
        public static final AccessibilityActionCompat NetworkUserEntityData$$ExternalSyntheticLambda4;
        public static final AccessibilityActionCompat NetworkUserEntityData$$ExternalSyntheticLambda5;
        public static final AccessibilityActionCompat NetworkUserEntityData$$ExternalSyntheticLambda6;
        public static final AccessibilityActionCompat NetworkUserEntityData$$ExternalSyntheticLambda8;
        public static final AccessibilityActionCompat PrepareContext;
        public static final AccessibilityActionCompat VerifyPinStateManager$executeRiskChallenge$2$1;
        public static final AccessibilityActionCompat getSupportButtonTintMode;
        public static final AccessibilityActionCompat getValueOfTouchPositionAbsolute;
        public static final AccessibilityActionCompat initRecordTimeStamp;
        public static final AccessibilityActionCompat isLayoutRequested;
        public static final AccessibilityActionCompat lookAheadTest;
        final Object H;
        protected final AccessibilityViewCommand I;
        private final int L;
        private final Class<? extends AccessibilityViewCommand.CommandArguments> M;
        public static final AccessibilityActionCompat NetworkUserEntityData$$ExternalSyntheticLambda1 = new AccessibilityActionCompat(1, null);
        public static final AccessibilityActionCompat getAuthRequestContext = new AccessibilityActionCompat(2, null);
        public static final AccessibilityActionCompat VerifyPinStateManager$executeRiskChallenge$2$2 = new AccessibilityActionCompat(4, null);
        public static final AccessibilityActionCompat PlaceComponentResult = new AccessibilityActionCompat(8, null);
        public static final AccessibilityActionCompat BuiltInFictitiousFunctionClassFactory = new AccessibilityActionCompat(16, null);
        public static final AccessibilityActionCompat NetworkUserEntityData$$ExternalSyntheticLambda7 = new AccessibilityActionCompat(32, null);
        public static final AccessibilityActionCompat MyBillsEntityDataFactory = new AccessibilityActionCompat(64, null);
        public static final AccessibilityActionCompat KClassImpl$Data$declaredNonStaticMembers$2 = new AccessibilityActionCompat(128, null);
        public static final AccessibilityActionCompat newProxyInstance = new AccessibilityActionCompat(256, (CharSequence) null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
        public static final AccessibilityActionCompat whenAvailable = new AccessibilityActionCompat(512, (CharSequence) null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
        public static final AccessibilityActionCompat FragmentBottomSheetPaymentSettingBinding = new AccessibilityActionCompat(1024, (CharSequence) null, AccessibilityViewCommand.MoveHtmlArguments.class);
        public static final AccessibilityActionCompat readMicros = new AccessibilityActionCompat(2048, (CharSequence) null, AccessibilityViewCommand.MoveHtmlArguments.class);
        public static final AccessibilityActionCompat C = new AccessibilityActionCompat(4096, null);
        public static final AccessibilityActionCompat getCallingPid = new AccessibilityActionCompat(8192, null);
        public static final AccessibilityActionCompat moveToNextValue = new AccessibilityActionCompat(16384, null);
        public static final AccessibilityActionCompat SubSequence = new AccessibilityActionCompat(32768, null);
        public static final AccessibilityActionCompat scheduleImpl = new AccessibilityActionCompat(65536, null);
        public static final AccessibilityActionCompat getOnBoardingScenario = new AccessibilityActionCompat((int) AntDetector.SCENE_ID_LOGIN_REGIST, (CharSequence) null, AccessibilityViewCommand.SetSelectionArguments.class);
        public static final AccessibilityActionCompat DatabaseTableConfigUtil = new AccessibilityActionCompat(262144, null);
        public static final AccessibilityActionCompat NetworkUserEntityData$$ExternalSyntheticLambda0 = new AccessibilityActionCompat(524288, null);
        public static final AccessibilityActionCompat getErrorConfigVersion = new AccessibilityActionCompat(CrashCombineUtils.DEFAULT_MAX_INFO_LEN, null);
        public static final AccessibilityActionCompat E = new AccessibilityActionCompat(2097152, (CharSequence) null, AccessibilityViewCommand.SetTextArguments.class);

        static {
            G = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, null, null, null);
            BottomSheetCardBindingView$watcherCardNumberView$1 = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            getValueOfTouchPositionAbsolute = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, null, null, null);
            B = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, null, null, null);
            VerifyPinStateManager$executeRiskChallenge$2$1 = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, null, null, null);
            A = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, null, null, null);
            NetworkUserEntityData$$ExternalSyntheticLambda5 = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, null, null, null);
            NetworkUserEntityData$$ExternalSyntheticLambda3 = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, null, null, null);
            NetworkUserEntityData$$ExternalSyntheticLambda6 = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, null, null, null);
            NetworkUserEntityData$$ExternalSyntheticLambda4 = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, null, null, null);
            lookAheadTest = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, null, null, null);
            D = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            NetworkUserEntityData$$ExternalSyntheticLambda8 = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            AppCompatEmojiTextHelper = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, null, null, null);
            isLayoutRequested = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, null, null, null);
            getSupportButtonTintMode = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, null, null, null);
            PrepareContext = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, 16908372, null, null, null);
            initRecordTimeStamp = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, 16908373, null, null, null);
            GetContactSyncConfig = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, 16908374, null, null, null);
            NetworkUserEntityData$$ExternalSyntheticLambda2 = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, 16908375, null, null, null);
            F = new AccessibilityActionCompat(Build.VERSION.SDK_INT >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, 16908376, null, null, null);
        }

        public AccessibilityActionCompat(int i, CharSequence charSequence) {
            this(null, i, charSequence, null, null);
        }

        public AccessibilityActionCompat(int i, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            this(null, i, charSequence, accessibilityViewCommand, null);
        }

        AccessibilityActionCompat(Object obj) {
            this(obj, 0, null, null, null);
        }

        private AccessibilityActionCompat(int i, CharSequence charSequence, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this(null, i, charSequence, null, cls);
        }

        AccessibilityActionCompat(Object obj, int i, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this.L = i;
            this.I = accessibilityViewCommand;
            if (Build.VERSION.SDK_INT >= 21 && obj == null) {
                this.H = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            } else {
                this.H = obj;
            }
            this.M = cls;
        }

        public int MyBillsEntityDataFactory() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.H).getId();
            }
            return 0;
        }

        public CharSequence PlaceComponentResult() {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityNodeInfo.AccessibilityAction) this.H).getLabel();
            }
            return null;
        }

        public boolean PlaceComponentResult(View view, Bundle bundle) {
            if (this.I != null) {
                Class<? extends AccessibilityViewCommand.CommandArguments> cls = this.M;
                AccessibilityViewCommand.CommandArguments commandArguments = null;
                if (cls != null) {
                    try {
                        AccessibilityViewCommand.CommandArguments newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        try {
                            newInstance.KClassImpl$Data$declaredNonStaticMembers$2 = bundle;
                            commandArguments = newInstance;
                        } catch (Exception e) {
                            e = e;
                            commandArguments = newInstance;
                            Class<? extends AccessibilityViewCommand.CommandArguments> cls2 = this.M;
                            String name = cls2 == null ? "null" : cls2.getName();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Failed to execute command with argument class ViewCommandArgument: ");
                            sb.append(name);
                            InstrumentInjector.log_e("A11yActionCompat", sb.toString(), e);
                            return this.I.perform(view, commandArguments);
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
                return this.I.perform(view, commandArguments);
            }
            return false;
        }

        public AccessibilityActionCompat MyBillsEntityDataFactory(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            return new AccessibilityActionCompat(null, this.L, charSequence, accessibilityViewCommand, this.M);
        }

        public int hashCode() {
            Object obj = this.H;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof AccessibilityActionCompat)) {
                AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) obj;
                Object obj2 = this.H;
                return obj2 == null ? accessibilityActionCompat.H == null : obj2.equals(accessibilityActionCompat.H);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class CollectionInfoCompat {
        final Object BuiltInFictitiousFunctionClassFactory;

        public static CollectionInfoCompat KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, boolean z, int i3) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new CollectionInfoCompat(null);
        }

        public static CollectionInfoCompat getAuthRequestContext(int i, int i2, boolean z) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z));
            }
            return new CollectionInfoCompat(null);
        }

        CollectionInfoCompat(Object obj) {
            this.BuiltInFictitiousFunctionClassFactory = obj;
        }
    }

    /* loaded from: classes3.dex */
    public static class CollectionItemInfoCompat {
        final Object PlaceComponentResult;

        public static CollectionItemInfoCompat PlaceComponentResult(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            if (Build.VERSION.SDK_INT >= 21) {
                return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z));
            }
            return new CollectionItemInfoCompat(null);
        }

        CollectionItemInfoCompat(Object obj) {
            this.PlaceComponentResult = obj;
        }
    }

    /* loaded from: classes3.dex */
    public static class RangeInfoCompat {
        final Object BuiltInFictitiousFunctionClassFactory;

        public static RangeInfoCompat PlaceComponentResult(int i, float f, float f2, float f3) {
            if (Build.VERSION.SDK_INT >= 19) {
                return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(i, f, f2, f3));
            }
            return new RangeInfoCompat(null);
        }

        RangeInfoCompat(Object obj) {
            this.BuiltInFictitiousFunctionClassFactory = obj;
        }
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object obj) {
        this.MyBillsEntityDataFactory = (AccessibilityNodeInfo) obj;
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.MyBillsEntityDataFactory = accessibilityNodeInfo;
    }

    public static AccessibilityNodeInfoCompat MyBillsEntityDataFactory(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    public AccessibilityNodeInfo getSupportButtonTintMode() {
        return this.MyBillsEntityDataFactory;
    }

    public static AccessibilityNodeInfoCompat getAuthRequestContext(View view) {
        return MyBillsEntityDataFactory(AccessibilityNodeInfo.obtain(view));
    }

    public void BuiltInFictitiousFunctionClassFactory(View view) {
        this.PlaceComponentResult = -1;
        this.MyBillsEntityDataFactory.setSource(view);
    }

    public void getAuthRequestContext(View view, int i) {
        this.PlaceComponentResult = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.MyBillsEntityDataFactory.setSource(view, i);
        }
    }

    public int MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory.getChildCount();
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        this.MyBillsEntityDataFactory.addChild(view);
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.MyBillsEntityDataFactory.addChild(view, i);
        }
    }

    @Deprecated
    public int PlaceComponentResult() {
        return this.MyBillsEntityDataFactory.getActions();
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        this.MyBillsEntityDataFactory.addAction(i);
    }

    private List<Integer> KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (Build.VERSION.SDK_INT < 19) {
            return new ArrayList();
        }
        ArrayList<Integer> integerArrayList = this.MyBillsEntityDataFactory.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            this.MyBillsEntityDataFactory.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    public void PlaceComponentResult(AccessibilityActionCompat accessibilityActionCompat) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.MyBillsEntityDataFactory.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.H);
        }
    }

    public boolean getAuthRequestContext(AccessibilityActionCompat accessibilityActionCompat) {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.MyBillsEntityDataFactory.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.H);
        }
        return false;
    }

    public boolean getAuthRequestContext(int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.MyBillsEntityDataFactory.performAction(i, bundle);
        }
        return false;
    }

    public void BuiltInFictitiousFunctionClassFactory(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.MyBillsEntityDataFactory.setMovementGranularities(i);
        }
    }

    public int NetworkUserEntityData$$ExternalSyntheticLambda0() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.MyBillsEntityDataFactory.getMovementGranularities();
        }
        return 0;
    }

    public void PlaceComponentResult(View view) {
        this.getAuthRequestContext = -1;
        this.MyBillsEntityDataFactory.setParent(view);
    }

    public void PlaceComponentResult(View view, int i) {
        this.getAuthRequestContext = i;
        if (Build.VERSION.SDK_INT >= 16) {
            this.MyBillsEntityDataFactory.setParent(view, i);
        }
    }

    @Deprecated
    public void getAuthRequestContext(Rect rect) {
        this.MyBillsEntityDataFactory.getBoundsInParent(rect);
    }

    @Deprecated
    public void KClassImpl$Data$declaredNonStaticMembers$2(Rect rect) {
        this.MyBillsEntityDataFactory.setBoundsInParent(rect);
    }

    public void BuiltInFictitiousFunctionClassFactory(Rect rect) {
        this.MyBillsEntityDataFactory.getBoundsInScreen(rect);
    }

    public void MyBillsEntityDataFactory(Rect rect) {
        this.MyBillsEntityDataFactory.setBoundsInScreen(rect);
    }

    public boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        return this.MyBillsEntityDataFactory.isCheckable();
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
        this.MyBillsEntityDataFactory.setCheckable(z);
    }

    public boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.MyBillsEntityDataFactory.isChecked();
    }

    public void MyBillsEntityDataFactory(boolean z) {
        this.MyBillsEntityDataFactory.setChecked(z);
    }

    public boolean newProxyInstance() {
        return this.MyBillsEntityDataFactory.isFocusable();
    }

    public void NetworkUserEntityData$$ExternalSyntheticLambda0(boolean z) {
        this.MyBillsEntityDataFactory.setFocusable(z);
    }

    public boolean PrepareContext() {
        return this.MyBillsEntityDataFactory.isFocused();
    }

    public void scheduleImpl(boolean z) {
        this.MyBillsEntityDataFactory.setFocused(z);
    }

    public boolean NetworkUserEntityData$$ExternalSyntheticLambda4() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.MyBillsEntityDataFactory.isVisibleToUser();
        }
        return false;
    }

    public void PrepareContext(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.MyBillsEntityDataFactory.setVisibleToUser(z);
        }
    }

    public boolean GetContactSyncConfig() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.MyBillsEntityDataFactory.isAccessibilityFocused();
        }
        return false;
    }

    public void BuiltInFictitiousFunctionClassFactory(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            this.MyBillsEntityDataFactory.setAccessibilityFocused(z);
        }
    }

    public boolean NetworkUserEntityData$$ExternalSyntheticLambda5() {
        return this.MyBillsEntityDataFactory.isSelected();
    }

    public void GetContactSyncConfig(boolean z) {
        this.MyBillsEntityDataFactory.setSelected(z);
    }

    public boolean NetworkUserEntityData$$ExternalSyntheticLambda7() {
        return this.MyBillsEntityDataFactory.isClickable();
    }

    public void PlaceComponentResult(boolean z) {
        this.MyBillsEntityDataFactory.setClickable(z);
    }

    public boolean isLayoutRequested() {
        return this.MyBillsEntityDataFactory.isLongClickable();
    }

    public void NetworkUserEntityData$$ExternalSyntheticLambda2(boolean z) {
        this.MyBillsEntityDataFactory.setLongClickable(z);
    }

    public boolean NetworkUserEntityData$$ExternalSyntheticLambda8() {
        return this.MyBillsEntityDataFactory.isEnabled();
    }

    public void moveToNextValue(boolean z) {
        this.MyBillsEntityDataFactory.setEnabled(z);
    }

    public boolean FragmentBottomSheetPaymentSettingBinding() {
        return this.MyBillsEntityDataFactory.isPassword();
    }

    public boolean NetworkUserEntityData$$ExternalSyntheticLambda3() {
        return this.MyBillsEntityDataFactory.isScrollable();
    }

    public void NetworkUserEntityData$$ExternalSyntheticLambda1(boolean z) {
        this.MyBillsEntityDataFactory.setScrollable(z);
    }

    public CharSequence moveToNextValue() {
        return this.MyBillsEntityDataFactory.getPackageName();
    }

    public void scheduleImpl(CharSequence charSequence) {
        this.MyBillsEntityDataFactory.setPackageName(charSequence);
    }

    public CharSequence getAuthRequestContext() {
        return this.MyBillsEntityDataFactory.getClassName();
    }

    public void BuiltInFictitiousFunctionClassFactory(CharSequence charSequence) {
        this.MyBillsEntityDataFactory.setClassName(charSequence);
    }

    public CharSequence lookAheadTest() {
        if (readMicros()) {
            List<Integer> KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> KClassImpl$Data$declaredNonStaticMembers$23 = KClassImpl$Data$declaredNonStaticMembers$2("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> KClassImpl$Data$declaredNonStaticMembers$24 = KClassImpl$Data$declaredNonStaticMembers$2("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.MyBillsEntityDataFactory.getText(), 0, this.MyBillsEntityDataFactory.getText().length()));
            for (int i = 0; i < KClassImpl$Data$declaredNonStaticMembers$2.size(); i++) {
                spannableString.setSpan(new AccessibilityClickableSpanCompat(KClassImpl$Data$declaredNonStaticMembers$24.get(i).intValue(), this, getErrorConfigVersion().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), KClassImpl$Data$declaredNonStaticMembers$2.get(i).intValue(), KClassImpl$Data$declaredNonStaticMembers$22.get(i).intValue(), KClassImpl$Data$declaredNonStaticMembers$23.get(i).intValue());
            }
            return spannableString;
        }
        return this.MyBillsEntityDataFactory.getText();
    }

    public void getErrorConfigVersion(CharSequence charSequence) {
        this.MyBillsEntityDataFactory.setText(charSequence);
    }

    public void BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 26) {
            return;
        }
        SubSequence();
        scheduleImpl(view);
        ClickableSpan[] KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(charSequence);
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null || KClassImpl$Data$declaredNonStaticMembers$2.length <= 0) {
            return;
        }
        getErrorConfigVersion().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.PlaceComponentResult);
        SparseArray<WeakReference<ClickableSpan>> errorConfigVersion = getErrorConfigVersion(view);
        for (int i = 0; KClassImpl$Data$declaredNonStaticMembers$2 != null && i < KClassImpl$Data$declaredNonStaticMembers$2.length; i++) {
            int authRequestContext = getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2[i], errorConfigVersion);
            errorConfigVersion.put(authRequestContext, new WeakReference<>(KClassImpl$Data$declaredNonStaticMembers$2[i]));
            PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2[i], (Spanned) charSequence, authRequestContext);
        }
    }

    private SparseArray<WeakReference<ClickableSpan>> getErrorConfigVersion(View view) {
        SparseArray<WeakReference<ClickableSpan>> lookAheadTest = lookAheadTest(view);
        if (lookAheadTest == null) {
            SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
            view.setTag(R.id.L, sparseArray);
            return sparseArray;
        }
        return lookAheadTest;
    }

    private SparseArray<WeakReference<ClickableSpan>> lookAheadTest(View view) {
        return (SparseArray) view.getTag(R.id.L);
    }

    public static ClickableSpan[] KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private int getAuthRequestContext(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (clickableSpan.equals(sparseArray.valueAt(i).get())) {
                    return sparseArray.keyAt(i);
                }
            }
        }
        int i2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory = i2 + 1;
        return i2;
    }

    private boolean readMicros() {
        return !KClassImpl$Data$declaredNonStaticMembers$2("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private void SubSequence() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.MyBillsEntityDataFactory.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            this.MyBillsEntityDataFactory.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            this.MyBillsEntityDataFactory.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            this.MyBillsEntityDataFactory.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        }
    }

    private void PlaceComponentResult(ClickableSpan clickableSpan, Spanned spanned, int i) {
        KClassImpl$Data$declaredNonStaticMembers$2("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        KClassImpl$Data$declaredNonStaticMembers$2("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        KClassImpl$Data$declaredNonStaticMembers$2("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        KClassImpl$Data$declaredNonStaticMembers$2("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
    }

    private void scheduleImpl(View view) {
        SparseArray<WeakReference<ClickableSpan>> lookAheadTest = lookAheadTest(view);
        if (lookAheadTest != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < lookAheadTest.size(); i++) {
                if (lookAheadTest.valueAt(i).get() == null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                lookAheadTest.remove(((Integer) arrayList.get(i2)).intValue());
            }
        }
    }

    public CharSequence scheduleImpl() {
        return this.MyBillsEntityDataFactory.getContentDescription();
    }

    public void PlaceComponentResult(CharSequence charSequence) {
        this.MyBillsEntityDataFactory.setContentDescription(charSequence);
    }

    public void moveToNextValue(CharSequence charSequence) {
        if (BuildCompat.getAuthRequestContext()) {
            this.MyBillsEntityDataFactory.setStateDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.MyBillsEntityDataFactory.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public String DatabaseTableConfigUtil() {
        if (BuildCompat.PlaceComponentResult()) {
            return this.MyBillsEntityDataFactory.getUniqueId();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return this.MyBillsEntityDataFactory.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
        }
        return null;
    }

    public void whenAvailable() {
        this.MyBillsEntityDataFactory.recycle();
    }

    public String initRecordTimeStamp() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.MyBillsEntityDataFactory.getViewIdResourceName();
        }
        return null;
    }

    public void PlaceComponentResult(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.MyBillsEntityDataFactory.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) obj).BuiltInFictitiousFunctionClassFactory);
        }
    }

    public void MyBillsEntityDataFactory(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.MyBillsEntityDataFactory.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) obj).PlaceComponentResult);
        }
    }

    public void PlaceComponentResult(RangeInfoCompat rangeInfoCompat) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.MyBillsEntityDataFactory.setRangeInfo((AccessibilityNodeInfo.RangeInfo) rangeInfoCompat.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public List<AccessibilityActionCompat> BuiltInFictitiousFunctionClassFactory() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = Build.VERSION.SDK_INT >= 21 ? this.MyBillsEntityDataFactory.getActionList() : null;
        if (actionList != null) {
            ArrayList arrayList = new ArrayList();
            int size = actionList.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(new AccessibilityActionCompat(actionList.get(i)));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public void MyBillsEntityDataFactory(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.MyBillsEntityDataFactory.setHintText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.MyBillsEntityDataFactory.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void getAuthRequestContext(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.MyBillsEntityDataFactory.setError(charSequence);
        }
    }

    public void getAuthRequestContext(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.MyBillsEntityDataFactory.setCanOpenPopup(z);
        }
    }

    public Bundle getErrorConfigVersion() {
        if (Build.VERSION.SDK_INT >= 19) {
            return this.MyBillsEntityDataFactory.getExtras();
        }
        return new Bundle();
    }

    public void getAuthRequestContext(int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.MyBillsEntityDataFactory.setMaxTextLength(i);
        }
    }

    public void MyBillsEntityDataFactory(View view) {
        if (Build.VERSION.SDK_INT >= 22) {
            this.MyBillsEntityDataFactory.setTraversalAfter(view);
        }
    }

    public void getErrorConfigVersion(boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.MyBillsEntityDataFactory.setDismissable(z);
        }
    }

    public void NetworkUserEntityData$$ExternalSyntheticLambda0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.MyBillsEntityDataFactory.setPaneTitle(charSequence);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.MyBillsEntityDataFactory.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void initRecordTimeStamp(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.MyBillsEntityDataFactory.setScreenReaderFocusable(z);
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2(1, z);
        }
    }

    public boolean NetworkUserEntityData$$ExternalSyntheticLambda6() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.MyBillsEntityDataFactory.isShowingHintText();
        }
        return MyBillsEntityDataFactory(4);
    }

    public void DatabaseTableConfigUtil(boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.MyBillsEntityDataFactory.setShowingHintText(z);
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2(4, z);
        }
    }

    public void lookAheadTest(boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.MyBillsEntityDataFactory.setHeading(z);
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2(2, z);
        }
    }

    public void lookAheadTest(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.MyBillsEntityDataFactory.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.MyBillsEntityDataFactory;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof AccessibilityNodeInfoCompat)) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.MyBillsEntityDataFactory;
            if (accessibilityNodeInfo == null) {
                if (accessibilityNodeInfoCompat.MyBillsEntityDataFactory != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.MyBillsEntityDataFactory)) {
                return false;
            }
            return this.PlaceComponentResult == accessibilityNodeInfoCompat.PlaceComponentResult && this.getAuthRequestContext == accessibilityNodeInfoCompat.getAuthRequestContext;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        getAuthRequestContext(rect);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("; boundsInParent: ");
        sb2.append(rect);
        sb.append(sb2.toString());
        BuiltInFictitiousFunctionClassFactory(rect);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("; boundsInScreen: ");
        sb3.append(rect);
        sb.append(sb3.toString());
        sb.append("; packageName: ");
        sb.append(moveToNextValue());
        sb.append("; className: ");
        sb.append(getAuthRequestContext());
        sb.append("; text: ");
        sb.append(lookAheadTest());
        sb.append("; contentDescription: ");
        sb.append(scheduleImpl());
        sb.append("; viewId: ");
        sb.append(initRecordTimeStamp());
        sb.append("; uniqueId: ");
        sb.append(DatabaseTableConfigUtil());
        sb.append("; checkable: ");
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda2());
        sb.append("; checked: ");
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda1());
        sb.append("; focusable: ");
        sb.append(newProxyInstance());
        sb.append("; focused: ");
        sb.append(PrepareContext());
        sb.append("; selected: ");
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda5());
        sb.append("; clickable: ");
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda7());
        sb.append("; longClickable: ");
        sb.append(isLayoutRequested());
        sb.append("; enabled: ");
        sb.append(NetworkUserEntityData$$ExternalSyntheticLambda8());
        sb.append("; password: ");
        sb.append(FragmentBottomSheetPaymentSettingBinding());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("; scrollable: ");
        sb4.append(NetworkUserEntityData$$ExternalSyntheticLambda3());
        sb.append(sb4.toString());
        sb.append("; [");
        if (Build.VERSION.SDK_INT >= 21) {
            List<AccessibilityActionCompat> BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory();
            for (int i = 0; i < BuiltInFictitiousFunctionClassFactory2.size(); i++) {
                AccessibilityActionCompat accessibilityActionCompat = BuiltInFictitiousFunctionClassFactory2.get(i);
                String PlaceComponentResult = PlaceComponentResult(accessibilityActionCompat.MyBillsEntityDataFactory());
                if (PlaceComponentResult.equals("ACTION_UNKNOWN") && accessibilityActionCompat.PlaceComponentResult() != null) {
                    PlaceComponentResult = accessibilityActionCompat.PlaceComponentResult().toString();
                }
                sb.append(PlaceComponentResult);
                if (i != BuiltInFictitiousFunctionClassFactory2.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            int PlaceComponentResult2 = PlaceComponentResult();
            while (PlaceComponentResult2 != 0) {
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(PlaceComponentResult2);
                PlaceComponentResult2 &= numberOfTrailingZeros ^ (-1);
                sb.append(PlaceComponentResult(numberOfTrailingZeros));
                if (PlaceComponentResult2 != 0) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(int i, boolean z) {
        Bundle errorConfigVersion = getErrorConfigVersion();
        if (errorConfigVersion != null) {
            errorConfigVersion.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", ((i ^ (-1)) & errorConfigVersion.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0)) | (z ? i : 0));
        }
    }

    private boolean MyBillsEntityDataFactory(int i) {
        Bundle errorConfigVersion = getErrorConfigVersion();
        return errorConfigVersion != null && (errorConfigVersion.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i) == i;
    }

    /* loaded from: classes6.dex */
    static class Api33Impl {
        private Api33Impl() {
        }
    }
}
