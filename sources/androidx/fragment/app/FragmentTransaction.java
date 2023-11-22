package androidx.fragment.app;

import android.os.Bundle;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.view.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class FragmentTransaction {
    private final ClassLoader BuiltInFictitiousFunctionClassFactory;
    CharSequence DatabaseTableConfigUtil;
    int FragmentBottomSheetPaymentSettingBinding;
    public int GetContactSyncConfig;
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    ArrayList<Runnable> NetworkUserEntityData$$ExternalSyntheticLambda1;
    public int NetworkUserEntityData$$ExternalSyntheticLambda2;
    public ArrayList<String> NetworkUserEntityData$$ExternalSyntheticLambda4;
    public ArrayList<String> NetworkUserEntityData$$ExternalSyntheticLambda5;
    ArrayList<Op> NetworkUserEntityData$$ExternalSyntheticLambda7;
    public String NetworkUserEntityData$$ExternalSyntheticLambda8;
    public int PrepareContext;
    private final FragmentFactory getAuthRequestContext;
    int getErrorConfigVersion;
    int initRecordTimeStamp;
    public boolean isLayoutRequested;
    CharSequence lookAheadTest;
    public int newProxyInstance;
    public boolean scheduleImpl;

    public abstract void BuiltInFictitiousFunctionClassFactory();

    public abstract int KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract void MyBillsEntityDataFactory();

    public abstract int getAuthRequestContext();

    /* loaded from: classes.dex */
    public static final class Op {
        Fragment BuiltInFictitiousFunctionClassFactory;
        Lifecycle.State KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        int PlaceComponentResult;
        int getAuthRequestContext;
        Lifecycle.State lookAheadTest;
        int moveToNextValue;
        int scheduleImpl;

        public Op() {
        }

        public Op(int i, Fragment fragment) {
            this.PlaceComponentResult = i;
            this.BuiltInFictitiousFunctionClassFactory = fragment;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            this.lookAheadTest = Lifecycle.State.RESUMED;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Lifecycle.State.RESUMED;
        }

        public Op(int i, Fragment fragment, byte b) {
            this.PlaceComponentResult = i;
            this.BuiltInFictitiousFunctionClassFactory = fragment;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            this.lookAheadTest = Lifecycle.State.RESUMED;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Lifecycle.State.RESUMED;
        }

        Op(Fragment fragment, Lifecycle.State state) {
            this.PlaceComponentResult = 10;
            this.BuiltInFictitiousFunctionClassFactory = fragment;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            this.lookAheadTest = fragment.mMaxState;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = state;
        }

        Op(Op op) {
            this.PlaceComponentResult = op.PlaceComponentResult;
            this.BuiltInFictitiousFunctionClassFactory = op.BuiltInFictitiousFunctionClassFactory;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = op.NetworkUserEntityData$$ExternalSyntheticLambda0;
            this.getAuthRequestContext = op.getAuthRequestContext;
            this.MyBillsEntityDataFactory = op.MyBillsEntityDataFactory;
            this.scheduleImpl = op.scheduleImpl;
            this.moveToNextValue = op.moveToNextValue;
            this.lookAheadTest = op.lookAheadTest;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = op.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    @Deprecated
    public FragmentTransaction() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ArrayList<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.isLayoutRequested = false;
        this.getAuthRequestContext = null;
        this.BuiltInFictitiousFunctionClassFactory = null;
    }

    public FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ArrayList<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        this.isLayoutRequested = false;
        this.getAuthRequestContext = fragmentFactory;
        this.BuiltInFictitiousFunctionClassFactory = classLoader;
    }

    public FragmentTransaction(FragmentFactory fragmentFactory, ClassLoader classLoader, FragmentTransaction fragmentTransaction) {
        this(fragmentFactory, classLoader);
        Iterator<Op> it = fragmentTransaction.NetworkUserEntityData$$ExternalSyntheticLambda7.iterator();
        while (it.hasNext()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7.add(new Op(it.next()));
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = fragmentTransaction.NetworkUserEntityData$$ExternalSyntheticLambda2;
        this.GetContactSyncConfig = fragmentTransaction.GetContactSyncConfig;
        this.newProxyInstance = fragmentTransaction.newProxyInstance;
        this.PrepareContext = fragmentTransaction.PrepareContext;
        this.FragmentBottomSheetPaymentSettingBinding = fragmentTransaction.FragmentBottomSheetPaymentSettingBinding;
        this.scheduleImpl = fragmentTransaction.scheduleImpl;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = fragmentTransaction.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = fragmentTransaction.NetworkUserEntityData$$ExternalSyntheticLambda8;
        this.getErrorConfigVersion = fragmentTransaction.getErrorConfigVersion;
        this.lookAheadTest = fragmentTransaction.lookAheadTest;
        this.initRecordTimeStamp = fragmentTransaction.initRecordTimeStamp;
        this.DatabaseTableConfigUtil = fragmentTransaction.DatabaseTableConfigUtil;
        if (fragmentTransaction.NetworkUserEntityData$$ExternalSyntheticLambda4 != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = arrayList;
            arrayList.addAll(fragmentTransaction.NetworkUserEntityData$$ExternalSyntheticLambda4);
        }
        if (fragmentTransaction.NetworkUserEntityData$$ExternalSyntheticLambda5 != null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = arrayList2;
            arrayList2.addAll(fragmentTransaction.NetworkUserEntityData$$ExternalSyntheticLambda5);
        }
        this.isLayoutRequested = fragmentTransaction.isLayoutRequested;
    }

    public final void BuiltInFictitiousFunctionClassFactory(Op op) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.add(op);
        op.getAuthRequestContext = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        op.MyBillsEntityDataFactory = this.GetContactSyncConfig;
        op.scheduleImpl = this.newProxyInstance;
        op.moveToNextValue = this.PrepareContext;
    }

    public final FragmentTransaction KClassImpl$Data$declaredNonStaticMembers$2(Fragment fragment, String str) {
        KClassImpl$Data$declaredNonStaticMembers$2(0, fragment, str, 1);
        return this;
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(int i, Fragment fragment, String str, int i2) {
        if (fragment.mPreviousWho != null) {
            FragmentStrictMode.BuiltInFictitiousFunctionClassFactory(fragment, fragment.mPreviousWho);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Fragment ");
            sb.append(cls.getCanonicalName());
            sb.append(" must be a public static class to be  properly recreated from instance state.");
            throw new IllegalStateException(sb.toString());
        }
        if (str != null) {
            if (fragment.mTag != null && !str.equals(fragment.mTag)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Can't change tag of fragment ");
                sb2.append(fragment);
                sb2.append(": was ");
                sb2.append(fragment.mTag);
                sb2.append(" now ");
                sb2.append(str);
                throw new IllegalStateException(sb2.toString());
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Can't add fragment ");
                sb3.append(fragment);
                sb3.append(" with tag ");
                sb3.append(str);
                sb3.append(" to container view with no id");
                throw new IllegalArgumentException(sb3.toString());
            } else if (fragment.mFragmentId != 0 && fragment.mFragmentId != i) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Can't change container ID of fragment ");
                sb4.append(fragment);
                sb4.append(": was ");
                sb4.append(fragment.mFragmentId);
                sb4.append(" now ");
                sb4.append(i);
                throw new IllegalStateException(sb4.toString());
            } else {
                fragment.mFragmentId = i;
                fragment.mContainerId = i;
            }
        }
        BuiltInFictitiousFunctionClassFactory(new Op(i2, fragment));
    }

    public FragmentTransaction KClassImpl$Data$declaredNonStaticMembers$2(Fragment fragment) {
        BuiltInFictitiousFunctionClassFactory(new Op(3, fragment));
        return this;
    }

    public FragmentTransaction PlaceComponentResult(Fragment fragment) {
        BuiltInFictitiousFunctionClassFactory(new Op(4, fragment));
        return this;
    }

    public FragmentTransaction BuiltInFictitiousFunctionClassFactory(Fragment fragment) {
        BuiltInFictitiousFunctionClassFactory(new Op(5, fragment));
        return this;
    }

    public FragmentTransaction getAuthRequestContext(Fragment fragment) {
        BuiltInFictitiousFunctionClassFactory(new Op(6, fragment));
        return this;
    }

    public FragmentTransaction MyBillsEntityDataFactory(Fragment fragment) {
        BuiltInFictitiousFunctionClassFactory(new Op(8, fragment));
        return this;
    }

    public FragmentTransaction PlaceComponentResult(Fragment fragment, Lifecycle.State state) {
        BuiltInFictitiousFunctionClassFactory(new Op(fragment, state));
        return this;
    }

    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7.isEmpty();
    }

    public final FragmentTransaction MyBillsEntityDataFactory(int i, Class<? extends Fragment> cls, Bundle bundle, String str) {
        FragmentFactory fragmentFactory = this.getAuthRequestContext;
        if (fragmentFactory == null) {
            throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
        }
        ClassLoader classLoader = this.BuiltInFictitiousFunctionClassFactory;
        if (classLoader == null) {
            throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
        }
        Fragment authRequestContext = fragmentFactory.getAuthRequestContext(classLoader, cls.getName());
        if (bundle != null) {
            authRequestContext.setArguments(bundle);
        }
        KClassImpl$Data$declaredNonStaticMembers$2(i, authRequestContext, str, 1);
        return this;
    }
}
