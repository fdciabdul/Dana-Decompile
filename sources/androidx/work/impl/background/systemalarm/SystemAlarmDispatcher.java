package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class SystemAlarmDispatcher implements ExecutionListener {
    final CommandHandler BuiltInFictitiousFunctionClassFactory;
    final WorkTimer DatabaseTableConfigUtil;
    Intent KClassImpl$Data$declaredNonStaticMembers$2;
    CommandsCompletedListener MyBillsEntityDataFactory;
    final Processor NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Context PlaceComponentResult;
    final List<Intent> getErrorConfigVersion;
    final Handler lookAheadTest;
    final TaskExecutor moveToNextValue;
    final WorkManagerImpl scheduleImpl;
    public static final byte[] initRecordTimeStamp = {121, 107, -47, -24, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int GetContactSyncConfig = 241;
    static final String getAuthRequestContext = Logger.MyBillsEntityDataFactory("SystemAlarmDispatcher");

    /* loaded from: classes3.dex */
    interface CommandsCompletedListener {
        void onAllCommandsCompleted();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 7
            int r7 = r7 + 99
            int r8 = r8 * 3
            int r8 = 16 - r8
            byte[] r0 = androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.initRecordTimeStamp
            int r9 = r9 * 12
            int r9 = 16 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r8
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L33
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r9]
            r6 = r10
            r10 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L33:
            int r8 = -r8
            int r9 = r9 + 1
            int r10 = r10 + r8
            int r8 = r10 + 2
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.a(byte, byte, byte, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemAlarmDispatcher(Context context) {
        this(context, (byte) 0);
    }

    private SystemAlarmDispatcher(Context context, byte b) {
        Context applicationContext = context.getApplicationContext();
        this.PlaceComponentResult = applicationContext;
        this.BuiltInFictitiousFunctionClassFactory = new CommandHandler(applicationContext);
        this.DatabaseTableConfigUtil = new WorkTimer();
        WorkManagerImpl PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
        this.scheduleImpl = PlaceComponentResult;
        Processor processor = PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = processor;
        this.moveToNextValue = PlaceComponentResult.getErrorConfigVersion;
        synchronized (processor.getAuthRequestContext) {
            processor.BuiltInFictitiousFunctionClassFactory.add(this);
        }
        this.getErrorConfigVersion = new ArrayList();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.lookAheadTest = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        Logger.getAuthRequestContext().PlaceComponentResult(getAuthRequestContext, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        Processor processor = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        synchronized (processor.getAuthRequestContext) {
            processor.BuiltInFictitiousFunctionClassFactory.remove(this);
        }
        WorkTimer workTimer = this.DatabaseTableConfigUtil;
        if (!workTimer.PlaceComponentResult.isShutdown()) {
            workTimer.PlaceComponentResult.shutdownNow();
        }
        this.MyBillsEntityDataFactory = null;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(String str, boolean z) {
        this.lookAheadTest.post(new AddRunnable(this, CommandHandler.MyBillsEntityDataFactory(this.PlaceComponentResult, str, z), 0));
    }

    public final boolean MyBillsEntityDataFactory(Intent intent, int i) {
        Logger authRequestContext = Logger.getAuthRequestContext();
        String str = getAuthRequestContext;
        authRequestContext.PlaceComponentResult(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i)), new Throwable[0]);
        MyBillsEntityDataFactory();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger.getAuthRequestContext().getAuthRequestContext(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && PlaceComponentResult("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra("KEY_START_ID", i);
            synchronized (this.getErrorConfigVersion) {
                boolean z = !this.getErrorConfigVersion.isEmpty();
                this.getErrorConfigVersion.add(intent);
                if (!z) {
                    getAuthRequestContext();
                }
            }
            return true;
        }
    }

    final void getAuthRequestContext() {
        MyBillsEntityDataFactory();
        PowerManager.WakeLock authRequestContext = WakeLocks.getAuthRequestContext(this.PlaceComponentResult, "ProcessCommand");
        try {
            authRequestContext.acquire();
            this.scheduleImpl.getErrorConfigVersion.getAuthRequestContext(new Runnable() { // from class: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    SystemAlarmDispatcher systemAlarmDispatcher;
                    DequeueAndCheckForCompletion dequeueAndCheckForCompletion;
                    synchronized (SystemAlarmDispatcher.this.getErrorConfigVersion) {
                        SystemAlarmDispatcher systemAlarmDispatcher2 = SystemAlarmDispatcher.this;
                        systemAlarmDispatcher2.KClassImpl$Data$declaredNonStaticMembers$2 = systemAlarmDispatcher2.getErrorConfigVersion.get(0);
                    }
                    if (SystemAlarmDispatcher.this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                        String action = SystemAlarmDispatcher.this.KClassImpl$Data$declaredNonStaticMembers$2.getAction();
                        int intExtra = SystemAlarmDispatcher.this.KClassImpl$Data$declaredNonStaticMembers$2.getIntExtra("KEY_START_ID", 0);
                        Logger.getAuthRequestContext().PlaceComponentResult(SystemAlarmDispatcher.getAuthRequestContext, String.format("Processing command %s, %s", SystemAlarmDispatcher.this.KClassImpl$Data$declaredNonStaticMembers$2, Integer.valueOf(intExtra)), new Throwable[0]);
                        PowerManager.WakeLock authRequestContext2 = WakeLocks.getAuthRequestContext(SystemAlarmDispatcher.this.PlaceComponentResult, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                        try {
                            Logger.getAuthRequestContext().PlaceComponentResult(SystemAlarmDispatcher.getAuthRequestContext, String.format("Acquiring operation wake lock (%s) %s", action, authRequestContext2), new Throwable[0]);
                            authRequestContext2.acquire();
                            CommandHandler commandHandler = SystemAlarmDispatcher.this.BuiltInFictitiousFunctionClassFactory;
                            Intent intent = SystemAlarmDispatcher.this.KClassImpl$Data$declaredNonStaticMembers$2;
                            SystemAlarmDispatcher systemAlarmDispatcher3 = SystemAlarmDispatcher.this;
                            String action2 = intent.getAction();
                            if ("ACTION_CONSTRAINTS_CHANGED".equals(action2)) {
                                Logger.getAuthRequestContext().PlaceComponentResult(CommandHandler.PlaceComponentResult, String.format("Handling constraints changed %s", intent), new Throwable[0]);
                                ConstraintsCommandHandler constraintsCommandHandler = new ConstraintsCommandHandler(commandHandler.BuiltInFictitiousFunctionClassFactory, intExtra, systemAlarmDispatcher3);
                                List<WorkSpec> BuiltInFictitiousFunctionClassFactory = constraintsCommandHandler.getAuthRequestContext.scheduleImpl.lookAheadTest.getErrorConfigVersion().BuiltInFictitiousFunctionClassFactory();
                                ConstraintProxy.updateAll(constraintsCommandHandler.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory);
                                constraintsCommandHandler.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
                                ArrayList arrayList = new ArrayList(BuiltInFictitiousFunctionClassFactory.size());
                                long currentTimeMillis = System.currentTimeMillis();
                                for (WorkSpec workSpec : BuiltInFictitiousFunctionClassFactory) {
                                    String str = workSpec.getErrorConfigVersion;
                                    if (currentTimeMillis >= workSpec.PlaceComponentResult() && (!workSpec.BuiltInFictitiousFunctionClassFactory() || constraintsCommandHandler.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(str))) {
                                        arrayList.add(workSpec);
                                    }
                                }
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    String str2 = ((WorkSpec) it.next()).getErrorConfigVersion;
                                    Intent intent2 = new Intent(constraintsCommandHandler.BuiltInFictitiousFunctionClassFactory, SystemAlarmService.class);
                                    intent2.setAction("ACTION_DELAY_MET");
                                    intent2.putExtra("KEY_WORKSPEC_ID", str2);
                                    Logger.getAuthRequestContext().PlaceComponentResult(ConstraintsCommandHandler.MyBillsEntityDataFactory, String.format("Creating a delay_met command for workSpec with id (%s)", str2), new Throwable[0]);
                                    SystemAlarmDispatcher systemAlarmDispatcher4 = constraintsCommandHandler.getAuthRequestContext;
                                    systemAlarmDispatcher4.lookAheadTest.post(new AddRunnable(systemAlarmDispatcher4, intent2, constraintsCommandHandler.PlaceComponentResult));
                                }
                                constraintsCommandHandler.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                            } else if ("ACTION_RESCHEDULE".equals(action2)) {
                                Logger.getAuthRequestContext().PlaceComponentResult(CommandHandler.PlaceComponentResult, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(intExtra)), new Throwable[0]);
                                systemAlarmDispatcher3.scheduleImpl.PlaceComponentResult();
                            } else if (!CommandHandler.KClassImpl$Data$declaredNonStaticMembers$2(intent.getExtras(), "KEY_WORKSPEC_ID")) {
                                Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(CommandHandler.PlaceComponentResult, String.format("Invalid request for %s, requires %s.", action2, "KEY_WORKSPEC_ID"), new Throwable[0]);
                            } else if ("ACTION_SCHEDULE_WORK".equals(action2)) {
                                String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
                                Logger authRequestContext3 = Logger.getAuthRequestContext();
                                String str3 = CommandHandler.PlaceComponentResult;
                                authRequestContext3.PlaceComponentResult(str3, String.format("Handling schedule work for %s", string), new Throwable[0]);
                                WorkDatabase workDatabase = systemAlarmDispatcher3.scheduleImpl.lookAheadTest;
                                workDatabase.beginTransaction();
                                try {
                                    WorkSpec moveToNextValue = workDatabase.getErrorConfigVersion().moveToNextValue(string);
                                    if (moveToNextValue == null) {
                                        Logger authRequestContext4 = Logger.getAuthRequestContext();
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Skipping scheduling ");
                                        sb.append(string);
                                        sb.append(" because it's no longer in the DB");
                                        authRequestContext4.getAuthRequestContext(str3, sb.toString(), new Throwable[0]);
                                    } else if (moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda7.isFinished()) {
                                        Logger authRequestContext5 = Logger.getAuthRequestContext();
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("Skipping scheduling ");
                                        sb2.append(string);
                                        sb2.append("because it is finished.");
                                        authRequestContext5.getAuthRequestContext(str3, sb2.toString(), new Throwable[0]);
                                    } else {
                                        long PlaceComponentResult = moveToNextValue.PlaceComponentResult();
                                        if (moveToNextValue.BuiltInFictitiousFunctionClassFactory()) {
                                            Logger.getAuthRequestContext().PlaceComponentResult(str3, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(PlaceComponentResult)), new Throwable[0]);
                                            Alarms.getAuthRequestContext(commandHandler.BuiltInFictitiousFunctionClassFactory, systemAlarmDispatcher3.scheduleImpl, string, PlaceComponentResult);
                                            Intent intent3 = new Intent(commandHandler.BuiltInFictitiousFunctionClassFactory, SystemAlarmService.class);
                                            intent3.setAction("ACTION_CONSTRAINTS_CHANGED");
                                            systemAlarmDispatcher3.lookAheadTest.post(new AddRunnable(systemAlarmDispatcher3, intent3, intExtra));
                                        } else {
                                            Logger.getAuthRequestContext().PlaceComponentResult(str3, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(PlaceComponentResult)), new Throwable[0]);
                                            Alarms.getAuthRequestContext(commandHandler.BuiltInFictitiousFunctionClassFactory, systemAlarmDispatcher3.scheduleImpl, string, PlaceComponentResult);
                                        }
                                        workDatabase.setTransactionSuccessful();
                                    }
                                } finally {
                                    workDatabase.endTransaction();
                                }
                            } else if ("ACTION_DELAY_MET".equals(action2)) {
                                Bundle extras = intent.getExtras();
                                synchronized (commandHandler.KClassImpl$Data$declaredNonStaticMembers$2) {
                                    String string2 = extras.getString("KEY_WORKSPEC_ID");
                                    Logger authRequestContext6 = Logger.getAuthRequestContext();
                                    String str4 = CommandHandler.PlaceComponentResult;
                                    authRequestContext6.PlaceComponentResult(str4, String.format("Handing delay met for %s", string2), new Throwable[0]);
                                    if (commandHandler.getAuthRequestContext.containsKey(string2)) {
                                        Logger.getAuthRequestContext().PlaceComponentResult(str4, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string2), new Throwable[0]);
                                    } else {
                                        DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(commandHandler.BuiltInFictitiousFunctionClassFactory, intExtra, string2, systemAlarmDispatcher3);
                                        commandHandler.getAuthRequestContext.put(string2, delayMetCommandHandler);
                                        delayMetCommandHandler.scheduleImpl = WakeLocks.getAuthRequestContext(delayMetCommandHandler.KClassImpl$Data$declaredNonStaticMembers$2, String.format("%s (%s)", delayMetCommandHandler.lookAheadTest, Integer.valueOf(delayMetCommandHandler.PlaceComponentResult)));
                                        Logger authRequestContext7 = Logger.getAuthRequestContext();
                                        String str5 = DelayMetCommandHandler.getAuthRequestContext;
                                        authRequestContext7.PlaceComponentResult(str5, String.format("Acquiring wakelock %s for WorkSpec %s", delayMetCommandHandler.scheduleImpl, delayMetCommandHandler.lookAheadTest), new Throwable[0]);
                                        delayMetCommandHandler.scheduleImpl.acquire();
                                        WorkSpec moveToNextValue2 = delayMetCommandHandler.BuiltInFictitiousFunctionClassFactory.scheduleImpl.lookAheadTest.getErrorConfigVersion().moveToNextValue(delayMetCommandHandler.lookAheadTest);
                                        if (moveToNextValue2 == null) {
                                            delayMetCommandHandler.getAuthRequestContext();
                                        } else {
                                            boolean BuiltInFictitiousFunctionClassFactory2 = moveToNextValue2.BuiltInFictitiousFunctionClassFactory();
                                            delayMetCommandHandler.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory2;
                                            if (BuiltInFictitiousFunctionClassFactory2) {
                                                delayMetCommandHandler.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory(Collections.singletonList(moveToNextValue2));
                                            } else {
                                                Logger.getAuthRequestContext().PlaceComponentResult(str5, String.format("No constraints for %s", delayMetCommandHandler.lookAheadTest), new Throwable[0]);
                                                delayMetCommandHandler.MyBillsEntityDataFactory(Collections.singletonList(delayMetCommandHandler.lookAheadTest));
                                            }
                                        }
                                    }
                                }
                            } else if ("ACTION_STOP_WORK".equals(action2)) {
                                String string3 = intent.getExtras().getString("KEY_WORKSPEC_ID");
                                Logger.getAuthRequestContext().PlaceComponentResult(CommandHandler.PlaceComponentResult, String.format("Handing stopWork work for %s", string3), new Throwable[0]);
                                WorkManagerImpl workManagerImpl = systemAlarmDispatcher3.scheduleImpl;
                                workManagerImpl.getErrorConfigVersion.getAuthRequestContext(new StopWorkRunnable(workManagerImpl, string3, false));
                                Alarms.KClassImpl$Data$declaredNonStaticMembers$2(commandHandler.BuiltInFictitiousFunctionClassFactory, systemAlarmDispatcher3.scheduleImpl, string3);
                                systemAlarmDispatcher3.onExecuted(string3, false);
                            } else if ("ACTION_EXECUTION_COMPLETED".equals(action2)) {
                                Bundle extras2 = intent.getExtras();
                                String string4 = extras2.getString("KEY_WORKSPEC_ID");
                                boolean z = extras2.getBoolean("KEY_NEEDS_RESCHEDULE");
                                Logger.getAuthRequestContext().PlaceComponentResult(CommandHandler.PlaceComponentResult, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(intExtra)), new Throwable[0]);
                                commandHandler.onExecuted(string4, z);
                            } else {
                                Logger.getAuthRequestContext().getAuthRequestContext(CommandHandler.PlaceComponentResult, String.format("Ignoring intent %s", intent), new Throwable[0]);
                            }
                            Logger.getAuthRequestContext().PlaceComponentResult(SystemAlarmDispatcher.getAuthRequestContext, String.format("Releasing operation wake lock (%s) %s", action, authRequestContext2), new Throwable[0]);
                            authRequestContext2.release();
                            systemAlarmDispatcher = SystemAlarmDispatcher.this;
                            dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(systemAlarmDispatcher);
                        } catch (Throwable th) {
                            try {
                                Logger.getAuthRequestContext().BuiltInFictitiousFunctionClassFactory(SystemAlarmDispatcher.getAuthRequestContext, "Unexpected error in onHandleIntent", th);
                                Logger.getAuthRequestContext().PlaceComponentResult(SystemAlarmDispatcher.getAuthRequestContext, String.format("Releasing operation wake lock (%s) %s", action, authRequestContext2), new Throwable[0]);
                                authRequestContext2.release();
                                systemAlarmDispatcher = SystemAlarmDispatcher.this;
                                dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(systemAlarmDispatcher);
                            } catch (Throwable th2) {
                                Logger.getAuthRequestContext().PlaceComponentResult(SystemAlarmDispatcher.getAuthRequestContext, String.format("Releasing operation wake lock (%s) %s", action, authRequestContext2), new Throwable[0]);
                                authRequestContext2.release();
                                SystemAlarmDispatcher systemAlarmDispatcher5 = SystemAlarmDispatcher.this;
                                systemAlarmDispatcher5.lookAheadTest.post(new DequeueAndCheckForCompletion(systemAlarmDispatcher5));
                                throw th2;
                            }
                        }
                        systemAlarmDispatcher.lookAheadTest.post(dequeueAndCheckForCompletion);
                    }
                }
            });
        } finally {
            authRequestContext.release();
        }
    }

    private boolean PlaceComponentResult(String str) {
        MyBillsEntityDataFactory();
        synchronized (this.getErrorConfigVersion) {
            Iterator<Intent> it = this.getErrorConfigVersion.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    final void MyBillsEntityDataFactory() {
        Thread thread = this.lookAheadTest.getLooper().getThread();
        try {
            byte b = (byte) (-initRecordTimeStamp[15]);
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (initRecordTimeStamp[15] + 1);
            byte b4 = (byte) (-initRecordTimeStamp[15]);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            if (thread != cls.getMethod((String) objArr2[0], null).invoke(null, null)) {
                throw new IllegalStateException("Needs to be invoked on the main thread.");
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* loaded from: classes3.dex */
    static class DequeueAndCheckForCompletion implements Runnable {
        private final SystemAlarmDispatcher KClassImpl$Data$declaredNonStaticMembers$2;

        DequeueAndCheckForCompletion(SystemAlarmDispatcher systemAlarmDispatcher) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = systemAlarmDispatcher;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemAlarmDispatcher systemAlarmDispatcher = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Logger authRequestContext = Logger.getAuthRequestContext();
            String str = SystemAlarmDispatcher.getAuthRequestContext;
            authRequestContext.PlaceComponentResult(str, "Checking if commands are complete.", new Throwable[0]);
            systemAlarmDispatcher.MyBillsEntityDataFactory();
            synchronized (systemAlarmDispatcher.getErrorConfigVersion) {
                if (systemAlarmDispatcher.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    Logger.getAuthRequestContext().PlaceComponentResult(str, String.format("Removing command %s", systemAlarmDispatcher.KClassImpl$Data$declaredNonStaticMembers$2), new Throwable[0]);
                    if (!systemAlarmDispatcher.getErrorConfigVersion.remove(0).equals(systemAlarmDispatcher.KClassImpl$Data$declaredNonStaticMembers$2)) {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                    systemAlarmDispatcher.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                }
                SerialExecutor MyBillsEntityDataFactory = systemAlarmDispatcher.moveToNextValue.MyBillsEntityDataFactory();
                if (!systemAlarmDispatcher.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory() && systemAlarmDispatcher.getErrorConfigVersion.isEmpty() && !MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory()) {
                    Logger.getAuthRequestContext().PlaceComponentResult(str, "No more commands & intents.", new Throwable[0]);
                    CommandsCompletedListener commandsCompletedListener = systemAlarmDispatcher.MyBillsEntityDataFactory;
                    if (commandsCompletedListener != null) {
                        commandsCompletedListener.onAllCommandsCompleted();
                    }
                } else if (!systemAlarmDispatcher.getErrorConfigVersion.isEmpty()) {
                    systemAlarmDispatcher.getAuthRequestContext();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class AddRunnable implements Runnable {
        private final Intent BuiltInFictitiousFunctionClassFactory;
        private final int MyBillsEntityDataFactory;
        private final SystemAlarmDispatcher getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AddRunnable(SystemAlarmDispatcher systemAlarmDispatcher, Intent intent, int i) {
            this.getAuthRequestContext = systemAlarmDispatcher;
            this.BuiltInFictitiousFunctionClassFactory = intent;
            this.MyBillsEntityDataFactory = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.getAuthRequestContext.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory);
        }
    }
}
