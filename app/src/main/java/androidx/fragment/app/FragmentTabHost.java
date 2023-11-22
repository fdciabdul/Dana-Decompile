package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes6.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    private FragmentManager BuiltInFictitiousFunctionClassFactory;
    private Context KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private final ArrayList<TabInfo> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    private TabInfo getAuthRequestContext;
    private TabHost.OnTabChangeListener moveToNextValue;
    private FrameLayout scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class TabInfo {
        Fragment BuiltInFictitiousFunctionClassFactory;
        final String MyBillsEntityDataFactory;
        final Class<?> PlaceComponentResult;
        final Bundle getAuthRequestContext;

        TabInfo(String str, Class<?> cls, Bundle bundle) {
            this.MyBillsEntityDataFactory = str;
            this.PlaceComponentResult = cls;
            this.getAuthRequestContext = bundle;
        }
    }

    /* loaded from: classes6.dex */
    static class DummyTabFactory implements TabHost.TabContentFactory {
        private final Context KClassImpl$Data$declaredNonStaticMembers$2;

        public DummyTabFactory(Context context) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View view = new View(this.KClassImpl$Data$declaredNonStaticMembers$2);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    /* loaded from: classes6.dex */
    static class SavedState extends View.BaseSavedState {
        String MyBillsEntityDataFactory;
        public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {82, -89, -124, -60, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
        public static final int getAuthRequestContext = 127;
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.fragment.app.FragmentTabHost.SavedState.1
            @Override // android.os.Parcelable.Creator
            public /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0032). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(short r6, int r7, short r8, java.lang.Object[] r9) {
            /*
                int r7 = 106 - r7
                int r6 = r6 * 15
                int r6 = 19 - r6
                byte[] r0 = androidx.fragment.app.FragmentTabHost.SavedState.KClassImpl$Data$declaredNonStaticMembers$2
                int r8 = r8 * 2
                int r8 = r8 + 16
                byte[] r1 = new byte[r8]
                int r8 = r8 + (-1)
                r2 = 0
                if (r0 != 0) goto L1a
                r7 = r6
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                goto L32
            L1a:
                r3 = 0
            L1b:
                byte r4 = (byte) r7
                r1[r3] = r4
                int r4 = r3 + 1
                if (r3 != r8) goto L2a
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2a:
                r3 = r0[r6]
                r5 = r9
                r9 = r8
                r8 = r3
                r3 = r1
                r1 = r0
                r0 = r5
            L32:
                int r6 = r6 + 1
                int r8 = -r8
                int r7 = r7 + r8
                int r7 = r7 + 2
                r8 = r9
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentTabHost.SavedState.a(short, int, short, java.lang.Object[]):void");
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.MyBillsEntityDataFactory = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.MyBillsEntityDataFactory);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("FragmentTabHost.SavedState{");
            try {
                Object[] objArr = {this};
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[5];
                byte b4 = b3;
                Object[] objArr3 = new Object[1];
                a(b3, b4, (byte) (b4 - 1), objArr3);
                sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
                sb.append(" curTab=");
                sb.append(this.MyBillsEntityDataFactory);
                sb.append("}");
                return sb.toString();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
    }

    @Deprecated
    public FragmentTabHost(Context context) {
        super(context, null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList<>();
        BuiltInFictitiousFunctionClassFactory(context, null);
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList<>();
        BuiltInFictitiousFunctionClassFactory(context, attributeSet);
    }

    private void BuiltInFictitiousFunctionClassFactory(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.PlaceComponentResult = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    private void MyBillsEntityDataFactory(Context context) {
        if (findViewById(16908307) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(16908305);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.scheduleImpl = frameLayout2;
            frameLayout2.setId(this.PlaceComponentResult);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(Context context, FragmentManager fragmentManager) {
        MyBillsEntityDataFactory(context);
        super.setup();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.BuiltInFictitiousFunctionClassFactory = fragmentManager;
        PlaceComponentResult();
    }

    @Deprecated
    public void setup(Context context, FragmentManager fragmentManager, int i) {
        MyBillsEntityDataFactory(context);
        super.setup();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.BuiltInFictitiousFunctionClassFactory = fragmentManager;
        this.PlaceComponentResult = i;
        PlaceComponentResult();
        this.scheduleImpl.setId(i);
        if (getId() == -1) {
            setId(16908306);
        }
    }

    private void PlaceComponentResult() {
        if (this.scheduleImpl == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.PlaceComponentResult);
            this.scheduleImpl = frameLayout;
            if (frameLayout != null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("No tab content FrameLayout found for id ");
            sb.append(this.PlaceComponentResult);
            throw new IllegalStateException(sb.toString());
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.moveToNextValue = onTabChangeListener;
    }

    @Deprecated
    public void addTab(TabHost.TabSpec tabSpec, Class<?> cls, Bundle bundle) {
        tabSpec.setContent(new DummyTabFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
        String tag = tabSpec.getTag();
        TabInfo tabInfo = new TabInfo(tag, cls, bundle);
        if (this.MyBillsEntityDataFactory) {
            tabInfo.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.findFragmentByTag(tag);
            if (tabInfo.BuiltInFictitiousFunctionClassFactory != null && !tabInfo.BuiltInFictitiousFunctionClassFactory.isDetached()) {
                FragmentTransaction beginTransaction = this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
                beginTransaction.getAuthRequestContext(tabInfo.BuiltInFictitiousFunctionClassFactory);
                beginTransaction.getAuthRequestContext();
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(tabInfo);
        addTab(tabSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.NetworkUserEntityData$$ExternalSyntheticLambda0.size();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < size; i++) {
            TabInfo tabInfo = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(i);
            tabInfo.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.findFragmentByTag(tabInfo.MyBillsEntityDataFactory);
            if (tabInfo.BuiltInFictitiousFunctionClassFactory != null && !tabInfo.BuiltInFictitiousFunctionClassFactory.isDetached()) {
                if (tabInfo.MyBillsEntityDataFactory.equals(currentTabTag)) {
                    this.getAuthRequestContext = tabInfo;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
                    }
                    fragmentTransaction.getAuthRequestContext(tabInfo.BuiltInFictitiousFunctionClassFactory);
                }
            }
        }
        this.MyBillsEntityDataFactory = true;
        FragmentTransaction KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(currentTabTag, fragmentTransaction);
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            this.BuiltInFictitiousFunctionClassFactory.executePendingTransactions();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.MyBillsEntityDataFactory = false;
    }

    @Override // android.view.View
    @Deprecated
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.MyBillsEntityDataFactory = getCurrentTabTag();
        return savedState;
    }

    @Override // android.view.View
    @Deprecated
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.MyBillsEntityDataFactory);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(String str) {
        FragmentTransaction KClassImpl$Data$declaredNonStaticMembers$2;
        if (this.MyBillsEntityDataFactory && (KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str, null)) != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.moveToNextValue;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    private FragmentTransaction KClassImpl$Data$declaredNonStaticMembers$2(String str, FragmentTransaction fragmentTransaction) {
        TabInfo tabInfo;
        int size = this.NetworkUserEntityData$$ExternalSyntheticLambda0.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                tabInfo = null;
                break;
            }
            tabInfo = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(i);
            if (tabInfo.MyBillsEntityDataFactory.equals(str)) {
                break;
            }
            i++;
        }
        if (this.getAuthRequestContext != tabInfo) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.BuiltInFictitiousFunctionClassFactory.beginTransaction();
            }
            TabInfo tabInfo2 = this.getAuthRequestContext;
            if (tabInfo2 != null && tabInfo2.BuiltInFictitiousFunctionClassFactory != null) {
                fragmentTransaction.getAuthRequestContext(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory);
            }
            if (tabInfo != null) {
                if (tabInfo.BuiltInFictitiousFunctionClassFactory == null) {
                    tabInfo.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.getFragmentFactory().getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.getClassLoader(), tabInfo.PlaceComponentResult.getName());
                    tabInfo.BuiltInFictitiousFunctionClassFactory.setArguments(tabInfo.getAuthRequestContext);
                    fragmentTransaction.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, tabInfo.BuiltInFictitiousFunctionClassFactory, tabInfo.MyBillsEntityDataFactory, 1);
                } else {
                    fragmentTransaction.BuiltInFictitiousFunctionClassFactory(new FragmentTransaction.Op(7, tabInfo.BuiltInFictitiousFunctionClassFactory));
                }
            }
            this.getAuthRequestContext = tabInfo;
        }
        return fragmentTransaction;
    }
}
