package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class AdapterHelper implements OpReorderer.Callback {
    final Callback BuiltInFictitiousFunctionClassFactory;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    Runnable MyBillsEntityDataFactory;
    final ArrayList<UpdateOp> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final boolean PlaceComponentResult;
    final OpReorderer getAuthRequestContext;
    private Pools.Pool<UpdateOp> getErrorConfigVersion;
    final ArrayList<UpdateOp> scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface Callback {
        void BuiltInFictitiousFunctionClassFactory(int i, int i2);

        void BuiltInFictitiousFunctionClassFactory(int i, int i2, Object obj);

        void BuiltInFictitiousFunctionClassFactory(UpdateOp updateOp);

        void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2);

        void KClassImpl$Data$declaredNonStaticMembers$2(UpdateOp updateOp);

        RecyclerView.ViewHolder MyBillsEntityDataFactory(int i);

        void MyBillsEntityDataFactory(int i, int i2);

        void PlaceComponentResult(int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdapterHelper(Callback callback) {
        this(callback, (byte) 0);
    }

    private AdapterHelper(Callback callback, byte b) {
        this.getErrorConfigVersion = new Pools.SimplePool(30);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList<>();
        this.scheduleImpl = new ArrayList<>();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        this.BuiltInFictitiousFunctionClassFactory = callback;
        this.PlaceComponentResult = false;
        this.getAuthRequestContext = new OpReorderer(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01d8, code lost:
    
        if (r6 == 8) goto L158;
     */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0096 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0131 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0124 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult() {
        /*
            Method dump skipped, instructions count: 692
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.AdapterHelper.PlaceComponentResult():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext() {
        int size = this.scheduleImpl.size();
        for (int i = 0; i < size; i++) {
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.scheduleImpl.get(i));
        }
        BuiltInFictitiousFunctionClassFactory(this.scheduleImpl);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(UpdateOp updateOp) {
        int i;
        if (updateOp.KClassImpl$Data$declaredNonStaticMembers$2 == 1 || updateOp.KClassImpl$Data$declaredNonStaticMembers$2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int authRequestContext = getAuthRequestContext(updateOp.MyBillsEntityDataFactory, updateOp.KClassImpl$Data$declaredNonStaticMembers$2);
        int i2 = updateOp.MyBillsEntityDataFactory;
        int i3 = updateOp.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i3 == 2) {
            i = 0;
        } else if (i3 != 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("op should be remove or update.");
            sb.append(updateOp);
            throw new IllegalArgumentException(sb.toString());
        } else {
            i = 1;
        }
        int i4 = 1;
        for (int i5 = 1; i5 < updateOp.getAuthRequestContext; i5++) {
            int authRequestContext2 = getAuthRequestContext(updateOp.MyBillsEntityDataFactory + (i * i5), updateOp.KClassImpl$Data$declaredNonStaticMembers$2);
            int i6 = updateOp.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i6 == 2 ? authRequestContext2 == authRequestContext : i6 == 4 && authRequestContext2 == authRequestContext + 1) {
                i4++;
            } else {
                UpdateOp PlaceComponentResult = PlaceComponentResult(updateOp.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext, i4, updateOp.BuiltInFictitiousFunctionClassFactory);
                BuiltInFictitiousFunctionClassFactory(PlaceComponentResult, i2);
                if (!this.PlaceComponentResult) {
                    PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = null;
                    this.getErrorConfigVersion.MyBillsEntityDataFactory(PlaceComponentResult);
                }
                if (updateOp.KClassImpl$Data$declaredNonStaticMembers$2 == 4) {
                    i2 += i4;
                }
                authRequestContext = authRequestContext2;
                i4 = 1;
            }
        }
        Object obj = updateOp.BuiltInFictitiousFunctionClassFactory;
        if (!this.PlaceComponentResult) {
            updateOp.BuiltInFictitiousFunctionClassFactory = null;
            this.getErrorConfigVersion.MyBillsEntityDataFactory(updateOp);
        }
        if (i4 > 0) {
            UpdateOp PlaceComponentResult2 = PlaceComponentResult(updateOp.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext, i4, obj);
            BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2, i2);
            if (this.PlaceComponentResult) {
                return;
            }
            PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = null;
            this.getErrorConfigVersion.MyBillsEntityDataFactory(PlaceComponentResult2);
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(UpdateOp updateOp, int i) {
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(updateOp);
        int i2 = updateOp.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i2 == 2) {
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(i, updateOp.getAuthRequestContext);
        } else if (i2 == 4) {
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(i, updateOp.getAuthRequestContext, updateOp.BuiltInFictitiousFunctionClassFactory);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int getAuthRequestContext(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.scheduleImpl.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.scheduleImpl.get(size);
            if (updateOp.KClassImpl$Data$declaredNonStaticMembers$2 == 8) {
                if (updateOp.MyBillsEntityDataFactory < updateOp.getAuthRequestContext) {
                    i3 = updateOp.MyBillsEntityDataFactory;
                    i4 = updateOp.getAuthRequestContext;
                } else {
                    i3 = updateOp.getAuthRequestContext;
                    i4 = updateOp.MyBillsEntityDataFactory;
                }
                if (i >= i3 && i <= i4) {
                    if (i3 == updateOp.MyBillsEntityDataFactory) {
                        if (i2 == 1) {
                            updateOp.getAuthRequestContext++;
                        } else if (i2 == 2) {
                            updateOp.getAuthRequestContext--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            updateOp.MyBillsEntityDataFactory++;
                        } else if (i2 == 2) {
                            updateOp.MyBillsEntityDataFactory--;
                        }
                        i--;
                    }
                } else if (i < updateOp.MyBillsEntityDataFactory) {
                    if (i2 == 1) {
                        updateOp.MyBillsEntityDataFactory++;
                        updateOp.getAuthRequestContext++;
                    } else if (i2 == 2) {
                        updateOp.MyBillsEntityDataFactory--;
                        updateOp.getAuthRequestContext--;
                    }
                }
            } else if (updateOp.MyBillsEntityDataFactory <= i) {
                if (updateOp.KClassImpl$Data$declaredNonStaticMembers$2 == 1) {
                    i -= updateOp.getAuthRequestContext;
                } else if (updateOp.KClassImpl$Data$declaredNonStaticMembers$2 == 2) {
                    i += updateOp.getAuthRequestContext;
                }
            } else if (i2 == 1) {
                updateOp.MyBillsEntityDataFactory++;
            } else if (i2 == 2) {
                updateOp.MyBillsEntityDataFactory--;
            }
        }
        for (int size2 = this.scheduleImpl.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.scheduleImpl.get(size2);
            if (updateOp2.KClassImpl$Data$declaredNonStaticMembers$2 == 8) {
                if (updateOp2.getAuthRequestContext == updateOp2.MyBillsEntityDataFactory || updateOp2.getAuthRequestContext < 0) {
                    this.scheduleImpl.remove(size2);
                    if (!this.PlaceComponentResult) {
                        updateOp2.BuiltInFictitiousFunctionClassFactory = null;
                        this.getErrorConfigVersion.MyBillsEntityDataFactory(updateOp2);
                    }
                }
            } else if (updateOp2.getAuthRequestContext <= 0) {
                this.scheduleImpl.remove(size2);
                if (!this.PlaceComponentResult) {
                    updateOp2.BuiltInFictitiousFunctionClassFactory = null;
                    this.getErrorConfigVersion.MyBillsEntityDataFactory(updateOp2);
                }
            }
        }
        return i;
    }

    private boolean PlaceComponentResult(int i) {
        int size = this.scheduleImpl.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.scheduleImpl.get(i2);
            if (updateOp.KClassImpl$Data$declaredNonStaticMembers$2 == 8) {
                if (KClassImpl$Data$declaredNonStaticMembers$2(updateOp.getAuthRequestContext, i2 + 1) == i) {
                    return true;
                }
            } else if (updateOp.KClassImpl$Data$declaredNonStaticMembers$2 == 1) {
                int i3 = updateOp.MyBillsEntityDataFactory;
                int i4 = updateOp.getAuthRequestContext;
                for (int i5 = updateOp.MyBillsEntityDataFactory; i5 < i3 + i4; i5++) {
                    if (KClassImpl$Data$declaredNonStaticMembers$2(i5, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void BuiltInFictitiousFunctionClassFactory(UpdateOp updateOp) {
        this.scheduleImpl.add(updateOp);
        int i = updateOp.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i == 1) {
            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(updateOp.MyBillsEntityDataFactory, updateOp.getAuthRequestContext);
        } else if (i == 2) {
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(updateOp.MyBillsEntityDataFactory, updateOp.getAuthRequestContext);
        } else if (i == 4) {
            this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(updateOp.MyBillsEntityDataFactory, updateOp.getAuthRequestContext, updateOp.BuiltInFictitiousFunctionClassFactory);
        } else if (i == 8) {
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(updateOp.MyBillsEntityDataFactory, updateOp.getAuthRequestContext);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown update op type for ");
            sb.append(updateOp);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getAuthRequestContext(int i) {
        return (i & this.KClassImpl$Data$declaredNonStaticMembers$2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        int size = this.scheduleImpl.size();
        while (i2 < size) {
            UpdateOp updateOp = this.scheduleImpl.get(i2);
            if (updateOp.KClassImpl$Data$declaredNonStaticMembers$2 == 8) {
                if (updateOp.MyBillsEntityDataFactory == i) {
                    i = updateOp.getAuthRequestContext;
                } else {
                    if (updateOp.MyBillsEntityDataFactory < i) {
                        i--;
                    }
                    if (updateOp.getAuthRequestContext <= i) {
                        i++;
                    }
                }
            } else if (updateOp.MyBillsEntityDataFactory > i) {
                continue;
            } else if (updateOp.KClassImpl$Data$declaredNonStaticMembers$2 == 2) {
                if (i < updateOp.MyBillsEntityDataFactory + updateOp.getAuthRequestContext) {
                    return -1;
                }
                i -= updateOp.getAuthRequestContext;
            } else if (updateOp.KClassImpl$Data$declaredNonStaticMembers$2 == 1) {
                i += updateOp.getAuthRequestContext;
            }
            i2++;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory(int i, int i2, Object obj) {
        if (i2 <= 0) {
            return false;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(PlaceComponentResult(4, i, i2, obj));
        this.KClassImpl$Data$declaredNonStaticMembers$2 |= 4;
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult(int i, int i2) {
        if (i2 <= 0) {
            return false;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(PlaceComponentResult(1, i, i2, null));
        this.KClassImpl$Data$declaredNonStaticMembers$2 |= 1;
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        if (i2 <= 0) {
            return false;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(PlaceComponentResult(2, i, i2, null));
        this.KClassImpl$Data$declaredNonStaticMembers$2 |= 2;
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(PlaceComponentResult(8, i, i2, null));
        this.KClassImpl$Data$declaredNonStaticMembers$2 |= 8;
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory() {
        getAuthRequestContext();
        int size = this.NetworkUserEntityData$$ExternalSyntheticLambda0.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(i);
            int i2 = updateOp.KClassImpl$Data$declaredNonStaticMembers$2;
            if (i2 == 1) {
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(updateOp);
                this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(updateOp.MyBillsEntityDataFactory, updateOp.getAuthRequestContext);
            } else if (i2 == 2) {
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(updateOp);
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(updateOp.MyBillsEntityDataFactory, updateOp.getAuthRequestContext);
            } else if (i2 == 4) {
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(updateOp);
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(updateOp.MyBillsEntityDataFactory, updateOp.getAuthRequestContext, updateOp.BuiltInFictitiousFunctionClassFactory);
            } else if (i2 == 8) {
                this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(updateOp);
                this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(updateOp.MyBillsEntityDataFactory, updateOp.getAuthRequestContext);
            }
            Runnable runnable = this.MyBillsEntityDataFactory;
            if (runnable != null) {
                runnable.run();
            }
        }
        BuiltInFictitiousFunctionClassFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return (this.scheduleImpl.isEmpty() || this.NetworkUserEntityData$$ExternalSyntheticLambda0.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class UpdateOp {
        Object BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int MyBillsEntityDataFactory;
        int getAuthRequestContext;
        public static final byte[] PlaceComponentResult = {113, -101, 105, Ascii.SUB, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 41;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0033). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(int r7, int r8, short r9, java.lang.Object[] r10) {
            /*
                byte[] r0 = androidx.recyclerview.widget.AdapterHelper.UpdateOp.PlaceComponentResult
                int r7 = r7 * 3
                int r7 = r7 + 16
                int r9 = r9 * 15
                int r9 = 19 - r9
                int r8 = 106 - r8
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L19
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r8
                r8 = r7
                goto L33
            L19:
                r3 = 0
            L1a:
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                if (r4 != r7) goto L29
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L29:
                r3 = r0[r9]
                r6 = r8
                r8 = r7
                r7 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r6
            L33:
                int r9 = r9 + r7
                int r7 = r9 + 2
                int r9 = r10 + 1
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r6 = r8
                r8 = r7
                r7 = r6
                goto L1a
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.AdapterHelper.UpdateOp.a(int, int, short, java.lang.Object[]):void");
        }

        UpdateOp(int i, int i2, int i3, Object obj) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.MyBillsEntityDataFactory = i2;
            this.getAuthRequestContext = i3;
            this.BuiltInFictitiousFunctionClassFactory = obj;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            try {
                Object[] objArr = {this};
                byte b = (byte) (PlaceComponentResult[5] + 1);
                byte b2 = b;
                Object[] objArr2 = new Object[1];
                a(b, b2, b2, objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b3 = (byte) (PlaceComponentResult[5] + 1);
                byte b4 = (byte) (-PlaceComponentResult[5]);
                Object[] objArr3 = new Object[1];
                a(b3, b4, b4, objArr3);
                sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
                sb.append("[");
                int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
                sb.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : ZolozEkycH5Handler.HUMMER_FOUNDATION_ADD);
                sb.append(",s:");
                sb.append(this.MyBillsEntityDataFactory);
                sb.append("c:");
                sb.append(this.getAuthRequestContext);
                sb.append(",p:");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                sb.append("]");
                return sb.toString();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UpdateOp) {
                UpdateOp updateOp = (UpdateOp) obj;
                int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (i != updateOp.KClassImpl$Data$declaredNonStaticMembers$2) {
                    return false;
                }
                if (i == 8 && Math.abs(this.getAuthRequestContext - this.MyBillsEntityDataFactory) == 1 && this.getAuthRequestContext == updateOp.MyBillsEntityDataFactory && this.MyBillsEntityDataFactory == updateOp.getAuthRequestContext) {
                    return true;
                }
                if (this.getAuthRequestContext == updateOp.getAuthRequestContext && this.MyBillsEntityDataFactory == updateOp.MyBillsEntityDataFactory) {
                    Object obj2 = this.BuiltInFictitiousFunctionClassFactory;
                    if (obj2 != null) {
                        if (!obj2.equals(updateOp.BuiltInFictitiousFunctionClassFactory)) {
                            return false;
                        }
                    } else if (updateOp.BuiltInFictitiousFunctionClassFactory != null) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        public final int hashCode() {
            return (((this.KClassImpl$Data$declaredNonStaticMembers$2 * 31) + this.MyBillsEntityDataFactory) * 31) + this.getAuthRequestContext;
        }
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public final UpdateOp PlaceComponentResult(int i, int i2, int i3, Object obj) {
        UpdateOp BuiltInFictitiousFunctionClassFactory = this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return new UpdateOp(i, i2, i3, obj);
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = i2;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = i3;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = obj;
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public final void getAuthRequestContext(UpdateOp updateOp) {
        if (this.PlaceComponentResult) {
            return;
        }
        updateOp.BuiltInFictitiousFunctionClassFactory = null;
        this.getErrorConfigVersion.MyBillsEntityDataFactory(updateOp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(List<UpdateOp> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            UpdateOp updateOp = list.get(i);
            if (!this.PlaceComponentResult) {
                updateOp.BuiltInFictitiousFunctionClassFactory = null;
                this.getErrorConfigVersion.MyBillsEntityDataFactory(updateOp);
            }
        }
        list.clear();
    }
}
