package id.dana.domain.log;

import com.alibaba.griver.base.common.env.GriverEnv;
import com.anggrayudi.storage.file.FileUtils;
import id.dana.cashier.view.InputCardNumberView;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0013R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\u0006*\u00020\u001e0\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Lid/dana/domain/log/Wood;", "", "", "clearLog", "()V", "", "message", "tag", "log", "(Ljava/lang/String;Ljava/lang/Object;)V", "fileName", "", "appendToPreviousLog", "", "maxFileSize", "setup", "(Ljava/lang/String;ZJ)V", "writeLog", "DEFAULT_MAX_FILE_SIZE", "J", "alreadySetup", "Z", "Ljava/io/File;", "file", "Ljava/io/File;", "fileLock", "Ljava/lang/Object;", "Ljava/util/Queue;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Ljava/util/Queue;", "Ljava/util/concurrent/ExecutorService;", "writeExecutor", "Ljava/util/concurrent/ExecutorService;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Wood {
    private static final long DEFAULT_MAX_FILE_SIZE = 2097152;
    private static boolean alreadySetup;
    private static File file;
    public static final Wood INSTANCE = new Wood();
    private static final Object fileLock = new Object();
    private static final Queue<String> queue = new LinkedList();
    private static long maxFileSize = 2097152;
    private static final ExecutorService writeExecutor = Executors.newSingleThreadExecutor();

    @JvmStatic
    public static final void log(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        log$default(str, null, 2, null);
    }

    @JvmStatic
    public static final void setup() {
        setup$default(null, false, 0L, 7, null);
    }

    @JvmStatic
    public static final void setup(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        setup$default(str, false, 0L, 6, null);
    }

    @JvmStatic
    public static final void setup(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        setup$default(str, z, 0L, 4, null);
    }

    private Wood() {
    }

    public static /* synthetic */ void setup$default(String str, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "wood";
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            j = 2097152;
        }
        setup(str, z, j);
    }

    @JvmStatic
    public static final void setup(String fileName, boolean appendToPreviousLog, long maxFileSize2) {
        Intrinsics.checkNotNullParameter(fileName, "");
        if (alreadySetup) {
            return;
        }
        synchronized (fileLock) {
            File file2 = null;
            File externalFilesDir = GriverEnv.getApplicationContext().getExternalFilesDir(null);
            if (externalFilesDir != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(fileName);
                sb.append(".txt");
                File MyBillsEntityDataFactory = FileUtils.MyBillsEntityDataFactory(externalFilesDir, sb.toString());
                file = MyBillsEntityDataFactory;
                if (!appendToPreviousLog && MyBillsEntityDataFactory.exists()) {
                    File file3 = file;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        file2 = file3;
                    }
                    file2.delete();
                }
                maxFileSize = maxFileSize2;
                alreadySetup = true;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final void clearLog() {
        synchronized (fileLock) {
            File file2 = file;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                file2 = null;
            }
            file2.delete();
        }
    }

    public static /* synthetic */ void log$default(String str, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        log(str, obj);
    }

    @JvmStatic
    public static final void log(String message, Object tag) {
        String name;
        Class<?> cls;
        Intrinsics.checkNotNullParameter(message, "");
        if (!alreadySetup) {
            throw new IllegalStateException("Please run Wood.setup() first");
        }
        if (tag instanceof CharSequence) {
            name = tag.toString();
        } else {
            name = (tag == null || (cls = tag.getClass()) == null) ? null : cls.getName();
            if (name == null) {
                name = "???";
            }
        }
        String localeString = new Date().toLocaleString();
        Queue<String> queue2 = queue;
        synchronized (queue2) {
            StringBuilder sb = new StringBuilder();
            sb.append(localeString);
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(name);
            sb.append(": ");
            sb.append(message);
            queue2.add(sb.toString());
            INSTANCE.writeLog();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void writeLog() {
        writeExecutor.execute(new Runnable() { // from class: id.dana.domain.log.Wood$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Wood.m2360writeLog$lambda7();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: writeLog$lambda-7  reason: not valid java name */
    public static final void m2360writeLog$lambda7() {
        String poll;
        Queue<String> queue2 = queue;
        synchronized (queue2) {
            poll = queue2.poll();
        }
        if (poll == null) {
            return;
        }
        synchronized (fileLock) {
            File file2 = file;
            File file3 = null;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                file2 = null;
            }
            if (file2.length() >= maxFileSize) {
                synchronized (queue2) {
                    queue2.clear();
                    Unit unit = Unit.INSTANCE;
                }
                Unit unit2 = Unit.INSTANCE;
            } else {
                try {
                    File file4 = file;
                    if (file4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        file4 = null;
                    }
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file4, true));
                    try {
                        BufferedWriter bufferedWriter2 = bufferedWriter;
                        bufferedWriter2.write(poll);
                        bufferedWriter2.newLine();
                        Unit unit3 = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedWriter, null);
                    } finally {
                    }
                } catch (Exception unused) {
                    File file5 = file;
                    if (file5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        file3 = file5;
                    }
                    file3.getAbsolutePath();
                }
                Unit unit22 = Unit.INSTANCE;
            }
        }
    }
}
