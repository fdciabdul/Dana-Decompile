package androidx.fragment.app;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.view.Lifecycle;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import id.dana.familyaccount.constants.FamilyAccountInvitationStatusType;
import java.io.PrintWriter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator {
    public static final byte[] getAuthRequestContext = {105, Ascii.NAK, -43, 101, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int moveToNextValue = SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE;
    int BuiltInFictitiousFunctionClassFactory;
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    boolean MyBillsEntityDataFactory;
    final FragmentManager PlaceComponentResult;

    /* JADX WARN: Removed duplicated region for block: B:32:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0026 -> B:35:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = androidx.fragment.app.BackStackRecord.getAuthRequestContext
            int r7 = 106 - r7
            int r9 = r9 + 4
            int r8 = r8 * 4
            int r8 = r8 + 16
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L31
        L16:
            r3 = 0
        L17:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            int r9 = r9 + 1
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L31:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + 2
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.BackStackRecord.a(short, int, short, java.lang.Object[]):void");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        try {
            Object[] objArr = {this};
            byte b = (byte) (getAuthRequestContext[5] - 1);
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, (byte) (b2 | 14), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = getAuthRequestContext[5];
            Object[] objArr3 = new Object[1];
            a(b3, (byte) (b3 - 1), (byte) (-getAuthRequestContext[5]), objArr3);
            sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
            if (this.BuiltInFictitiousFunctionClassFactory >= 0) {
                sb.append(" #");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 != null) {
                sb.append(" ");
                sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            }
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

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
            printWriter.print(" mIndex=");
            printWriter.print(this.BuiltInFictitiousFunctionClassFactory);
            printWriter.print(" mCommitted=");
            printWriter.println(this.KClassImpl$Data$declaredNonStaticMembers$2);
            if (this.FragmentBottomSheetPaymentSettingBinding != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.FragmentBottomSheetPaymentSettingBinding));
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 != 0 || this.GetContactSyncConfig != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.NetworkUserEntityData$$ExternalSyntheticLambda2));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.GetContactSyncConfig));
            }
            if (this.newProxyInstance != 0 || this.PrepareContext != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.newProxyInstance));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.PrepareContext));
            }
            if (this.initRecordTimeStamp != 0 || this.DatabaseTableConfigUtil != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.initRecordTimeStamp));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.DatabaseTableConfigUtil);
            }
            if (this.getErrorConfigVersion != 0 || this.lookAheadTest != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.getErrorConfigVersion));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.lookAheadTest);
            }
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.NetworkUserEntityData$$ExternalSyntheticLambda7.size();
        for (int i = 0; i < size; i++) {
            FragmentTransaction.Op op = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get(i);
            switch (op.PlaceComponentResult) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = FamilyAccountInvitationStatusType.REMOVE;
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    StringBuilder sb = new StringBuilder();
                    sb.append("cmd=");
                    sb.append(op.PlaceComponentResult);
                    str2 = sb.toString();
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(op.BuiltInFictitiousFunctionClassFactory);
            if (z) {
                if (op.getAuthRequestContext != 0 || op.MyBillsEntityDataFactory != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(op.getAuthRequestContext));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(op.MyBillsEntityDataFactory));
                }
                if (op.scheduleImpl != 0 || op.moveToNextValue != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(op.scheduleImpl));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(op.moveToNextValue));
                }
            }
        }
    }

    public BackStackRecord(FragmentManager fragmentManager) {
        super(fragmentManager.getFragmentFactory(), fragmentManager.getHost() != null ? fragmentManager.getHost().MyBillsEntityDataFactory.getClassLoader() : null);
        this.BuiltInFictitiousFunctionClassFactory = -1;
        this.MyBillsEntityDataFactory = false;
        this.PlaceComponentResult = fragmentManager;
    }

    public BackStackRecord(BackStackRecord backStackRecord) {
        super(backStackRecord.PlaceComponentResult.getFragmentFactory(), backStackRecord.PlaceComponentResult.getHost() != null ? backStackRecord.PlaceComponentResult.getHost().MyBillsEntityDataFactory.getClassLoader() : null, backStackRecord);
        this.BuiltInFictitiousFunctionClassFactory = -1;
        this.MyBillsEntityDataFactory = false;
        this.PlaceComponentResult = backStackRecord.PlaceComponentResult;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = backStackRecord.KClassImpl$Data$declaredNonStaticMembers$2;
        this.BuiltInFictitiousFunctionClassFactory = backStackRecord.BuiltInFictitiousFunctionClassFactory;
        this.MyBillsEntityDataFactory = backStackRecord.MyBillsEntityDataFactory;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public final int PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, Fragment fragment, String str, int i2) {
        super.KClassImpl$Data$declaredNonStaticMembers$2(i, fragment, str, i2);
        fragment.mFragmentManager = this.PlaceComponentResult;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final FragmentTransaction KClassImpl$Data$declaredNonStaticMembers$2(Fragment fragment) {
        if (fragment.mFragmentManager != null && fragment.mFragmentManager != this.PlaceComponentResult) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
            sb.append(fragment.toString());
            sb.append(" is already attached to a FragmentManager.");
            throw new IllegalStateException(sb.toString());
        }
        return super.KClassImpl$Data$declaredNonStaticMembers$2(fragment);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final FragmentTransaction PlaceComponentResult(Fragment fragment) {
        if (fragment.mFragmentManager != null && fragment.mFragmentManager != this.PlaceComponentResult) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot hide Fragment attached to a different FragmentManager. Fragment ");
            sb.append(fragment.toString());
            sb.append(" is already attached to a FragmentManager.");
            throw new IllegalStateException(sb.toString());
        }
        return super.PlaceComponentResult(fragment);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final FragmentTransaction BuiltInFictitiousFunctionClassFactory(Fragment fragment) {
        if (fragment.mFragmentManager != null && fragment.mFragmentManager != this.PlaceComponentResult) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot show Fragment attached to a different FragmentManager. Fragment ");
            sb.append(fragment.toString());
            sb.append(" is already attached to a FragmentManager.");
            throw new IllegalStateException(sb.toString());
        }
        return super.BuiltInFictitiousFunctionClassFactory(fragment);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final FragmentTransaction getAuthRequestContext(Fragment fragment) {
        if (fragment.mFragmentManager != null && fragment.mFragmentManager != this.PlaceComponentResult) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot detach Fragment attached to a different FragmentManager. Fragment ");
            sb.append(fragment.toString());
            sb.append(" is already attached to a FragmentManager.");
            throw new IllegalStateException(sb.toString());
        }
        return super.getAuthRequestContext(fragment);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final FragmentTransaction MyBillsEntityDataFactory(Fragment fragment) {
        if (fragment != null && fragment.mFragmentManager != null && fragment.mFragmentManager != this.PlaceComponentResult) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
            sb.append(fragment.toString());
            sb.append(" is already attached to a FragmentManager.");
            throw new IllegalStateException(sb.toString());
        }
        return super.MyBillsEntityDataFactory(fragment);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final FragmentTransaction PlaceComponentResult(Fragment fragment, Lifecycle.State state) {
        if (fragment.mFragmentManager != this.PlaceComponentResult) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
            sb.append(this.PlaceComponentResult);
            throw new IllegalArgumentException(sb.toString());
        } else if (state == Lifecycle.State.INITIALIZED && fragment.mState >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot set maximum Lifecycle to ");
            sb2.append(state);
            sb2.append(" after the Fragment has been created");
            throw new IllegalArgumentException(sb2.toString());
        } else if (state == Lifecycle.State.DESTROYED) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Cannot set maximum Lifecycle to ");
            sb3.append(state);
            sb3.append(". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
            throw new IllegalArgumentException(sb3.toString());
        } else {
            return super.PlaceComponentResult(fragment, state);
        }
    }

    public final void MyBillsEntityDataFactory(int i) {
        if (this.scheduleImpl) {
            if (FragmentManager.isLoggingEnabled(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Bump nesting in ");
                sb.append(this);
                sb.append(" by ");
                sb.append(i);
                InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
            }
            int size = this.NetworkUserEntityData$$ExternalSyntheticLambda7.size();
            for (int i2 = 0; i2 < size; i2++) {
                FragmentTransaction.Op op = this.NetworkUserEntityData$$ExternalSyntheticLambda7.get(i2);
                if (op.BuiltInFictitiousFunctionClassFactory != null) {
                    op.BuiltInFictitiousFunctionClassFactory.mBackStackNesting += i;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Bump nesting of ");
                        sb2.append(op.BuiltInFictitiousFunctionClassFactory);
                        sb2.append(" to ");
                        sb2.append(op.BuiltInFictitiousFunctionClassFactory.mBackStackNesting);
                        InstrumentInjector.log_v(FragmentManager.TAG, sb2.toString());
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final int getAuthRequestContext() {
        return BuiltInFictitiousFunctionClassFactory(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return BuiltInFictitiousFunctionClassFactory(true);
    }

    private int BuiltInFictitiousFunctionClassFactory(boolean z) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Commit: ");
            sb.append(this);
            InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
            PrintWriter printWriter = new PrintWriter(new LogWriter(FragmentManager.TAG));
            KClassImpl$Data$declaredNonStaticMembers$2("  ", printWriter, true);
            printWriter.close();
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        if (this.scheduleImpl) {
            this.BuiltInFictitiousFunctionClassFactory = this.PlaceComponentResult.allocBackStackIndex();
        } else {
            this.BuiltInFictitiousFunctionClassFactory = -1;
        }
        this.PlaceComponentResult.enqueueAction(this, z);
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.fragment.app.FragmentManager.OpGenerator
    public final boolean MyBillsEntityDataFactory(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Run: ");
            sb.append(this);
            InstrumentInjector.log_v(FragmentManager.TAG, sb.toString());
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.scheduleImpl) {
            this.PlaceComponentResult.addBackStackState(this);
            return true;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7.isEmpty();
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final void BuiltInFictitiousFunctionClassFactory() {
        if (this.scheduleImpl) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.PlaceComponentResult.execSingleAction(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public final void MyBillsEntityDataFactory() {
        if (this.scheduleImpl) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.PlaceComponentResult.execSingleAction(this, true);
    }
}
