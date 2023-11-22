package androidx.work.impl.model;

import android.net.Uri;
import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.ContentUriTriggers;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* loaded from: classes6.dex */
public class WorkTypeConverters {

    /* loaded from: classes6.dex */
    public interface BackoffPolicyIds {
    }

    /* loaded from: classes6.dex */
    public interface NetworkTypeIds {
    }

    /* loaded from: classes6.dex */
    public interface OutOfPolicyIds {
    }

    /* loaded from: classes6.dex */
    public interface StateIds {
    }

    public static int getAuthRequestContext(WorkInfo.State state) {
        switch (AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[state.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Could not convert ");
                sb.append(state);
                sb.append(" to int");
                throw new IllegalArgumentException(sb.toString());
        }
    }

    public static WorkInfo.State PlaceComponentResult(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 5) {
                                return WorkInfo.State.CANCELLED;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("Could not convert ");
                            sb.append(i);
                            sb.append(" to State");
                            throw new IllegalArgumentException(sb.toString());
                        }
                        return WorkInfo.State.BLOCKED;
                    }
                    return WorkInfo.State.FAILED;
                }
                return WorkInfo.State.SUCCEEDED;
            }
            return WorkInfo.State.RUNNING;
        }
        return WorkInfo.State.ENQUEUED;
    }

    public static int BuiltInFictitiousFunctionClassFactory(BackoffPolicy backoffPolicy) {
        int i = AnonymousClass1.MyBillsEntityDataFactory[backoffPolicy.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Could not convert ");
            sb.append(backoffPolicy);
            sb.append(" to int");
            throw new IllegalArgumentException(sb.toString());
        }
        return 0;
    }

    public static BackoffPolicy getAuthRequestContext(int i) {
        if (i != 0) {
            if (i == 1) {
                return BackoffPolicy.LINEAR;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Could not convert ");
            sb.append(i);
            sb.append(" to BackoffPolicy");
            throw new IllegalArgumentException(sb.toString());
        }
        return BackoffPolicy.EXPONENTIAL;
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(NetworkType networkType) {
        int i = AnonymousClass1.BuiltInFictitiousFunctionClassFactory[networkType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            if (Build.VERSION.SDK_INT < 30 || networkType != NetworkType.TEMPORARILY_UNMETERED) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Could not convert ");
                                sb.append(networkType);
                                sb.append(" to int");
                                throw new IllegalArgumentException(sb.toString());
                            }
                            return 5;
                        }
                        return 4;
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static NetworkType MyBillsEntityDataFactory(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            return NetworkType.METERED;
                        }
                        if (Build.VERSION.SDK_INT >= 30 && i == 5) {
                            return NetworkType.TEMPORARILY_UNMETERED;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Could not convert ");
                        sb.append(i);
                        sb.append(" to NetworkType");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    return NetworkType.NOT_ROAMING;
                }
                return NetworkType.UNMETERED;
            }
            return NetworkType.CONNECTED;
        }
        return NetworkType.NOT_REQUIRED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.work.impl.model.WorkTypeConverters$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;
        static final /* synthetic */ int[] MyBillsEntityDataFactory;
        static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[OutOfQuotaPolicy.values().length];
            PlaceComponentResult = iArr;
            try {
                iArr[OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                PlaceComponentResult[OutOfQuotaPolicy.DROP_WORK_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[NetworkType.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr2;
            try {
                iArr2[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[BackoffPolicy.values().length];
            MyBillsEntityDataFactory = iArr3;
            try {
                iArr3[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                MyBillsEntityDataFactory[BackoffPolicy.LINEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[WorkInfo.State.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr4;
            try {
                iArr4[WorkInfo.State.ENQUEUED.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[WorkInfo.State.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[WorkInfo.State.SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[WorkInfo.State.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[WorkInfo.State.BLOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[WorkInfo.State.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public static int BuiltInFictitiousFunctionClassFactory(OutOfQuotaPolicy outOfQuotaPolicy) {
        int i = AnonymousClass1.PlaceComponentResult[outOfQuotaPolicy.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Could not convert ");
            sb.append(outOfQuotaPolicy);
            sb.append(" to int");
            throw new IllegalArgumentException(sb.toString());
        }
        return 0;
    }

    public static OutOfQuotaPolicy BuiltInFictitiousFunctionClassFactory(int i) {
        if (i != 0) {
            if (i == 1) {
                return OutOfQuotaPolicy.DROP_WORK_REQUEST;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Could not convert ");
            sb.append(i);
            sb.append(" to OutOfQuotaPolicy");
            throw new IllegalArgumentException(sb.toString());
        }
        return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
    }

    public static ContentUriTriggers MyBillsEntityDataFactory(byte[] bArr) {
        ContentUriTriggers contentUriTriggers = new ContentUriTriggers();
        if (bArr == null) {
            return contentUriTriggers;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream = null;
        try {
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(byteArrayInputStream);
                try {
                    for (int readInt = objectInputStream2.readInt(); readInt > 0; readInt--) {
                        contentUriTriggers.PlaceComponentResult.add(new ContentUriTriggers.Trigger(Uri.parse(objectInputStream2.readUTF()), objectInputStream2.readBoolean()));
                    }
                    objectInputStream2.close();
                } catch (IOException unused) {
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    byteArrayInputStream.close();
                } catch (Throwable th) {
                    th = th;
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                        throw th;
                    } catch (IOException unused3) {
                        throw th;
                    }
                }
            } catch (IOException unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused5) {
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException unused6) {
            return contentUriTriggers;
        }
    }

    private WorkTypeConverters() {
    }

    public static byte[] MyBillsEntityDataFactory(ContentUriTriggers contentUriTriggers) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        if (contentUriTriggers.PlaceComponentResult.size() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                objectOutputStream.writeInt(contentUriTriggers.PlaceComponentResult.size());
                for (ContentUriTriggers.Trigger trigger : contentUriTriggers.PlaceComponentResult) {
                    objectOutputStream.writeUTF(trigger.KClassImpl$Data$declaredNonStaticMembers$2.toString());
                    objectOutputStream.writeBoolean(trigger.KClassImpl$Data$declaredNonStaticMembers$2());
                }
                objectOutputStream.close();
            } catch (IOException unused2) {
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    objectOutputStream2.close();
                }
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException unused3) {
                    }
                }
                try {
                    byteArrayOutputStream.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (IOException unused5) {
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused6) {
            return byteArrayOutputStream.toByteArray();
        }
    }
}
