package com.google.firebase.crashlytics.internal.persistence;

import android.view.KeyEvent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

/* loaded from: classes.dex */
public class CrashlyticsReportPersistence {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final String EVENT_COUNTER_FORMAT = "%010d";
    private static final int EVENT_COUNTER_WIDTH = 10;
    private static final FilenameFilter EVENT_FILE_FILTER;
    private static final String EVENT_FILE_NAME_PREFIX = "event";
    private static final int EVENT_NAME_LENGTH;
    private static final Comparator<? super File> LATEST_SESSION_ID_FIRST_COMPARATOR;
    private static final int MAX_OPEN_SESSIONS = 8;
    private static long MyBillsEntityDataFactory = 0;
    private static final String NORMAL_EVENT_SUFFIX = "";
    private static final String PRIORITY_EVENT_SUFFIX = "_";
    private static final String REPORT_FILE_NAME = "report";
    private static final String SESSION_START_TIMESTAMP_FILE_NAME = "start-time";
    private static final CrashlyticsReportJsonTransform TRANSFORM;
    private static final Charset UTF_8;
    private static int getAuthRequestContext = 1;
    private final AtomicInteger eventCounter;
    private final FileStore fileStore;
    private final SettingsProvider settingsProvider;

    public static /* synthetic */ boolean $r8$lambda$JFU0vij0Pn952vNT34mb4Hr_UXo(File file, String str) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 101;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            boolean isNormalPriorityEventFile = isNormalPriorityEventFile(file, str);
            int i3 = getAuthRequestContext + 83;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return isNormalPriorityEventFile;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$n3pLmsPsV-a9XZY5T7lAH7PN0HQ  reason: not valid java name */
    public static /* synthetic */ int m160$r8$lambda$n3pLmsPsVa9XZY5T7lAH7PN0HQ(File file, File file2) {
        try {
            int i = getAuthRequestContext + 73;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            char c = i % 2 != 0 ? 'U' : '^';
            Object[] objArr = null;
            int oldestEventFileFirst = oldestEventFileFirst(file, file2);
            if (c == 'U') {
                objArr.hashCode();
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 3;
            getAuthRequestContext = i2 % 128;
            if (i2 % 2 != 0) {
                return oldestEventFileFirst;
            }
            int length = objArr.length;
            return oldestEventFileFirst;
        } catch (Exception e) {
            throw e;
        }
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        MyBillsEntityDataFactory = -428184981521238671L;
    }

    private static long convertTimestampFromSecondsToMs(long j) {
        int i = BuiltInFictitiousFunctionClassFactory + 23;
        getAuthRequestContext = i % 128;
        long j2 = i % 2 == 0 ? j + 1000 : j * 1000;
        int i2 = BuiltInFictitiousFunctionClassFactory + 59;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        return j2;
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        Object[] objArr = new Object[1];
        a(7193 - KeyEvent.keyCodeFromString(""), new char[]{9319, 14463, 7238, 28756, 21614}, objArr);
        UTF_8 = Charset.forName(((String) objArr[0]).intern());
        EVENT_NAME_LENGTH = 15;
        TRANSFORM = new CrashlyticsReportJsonTransform();
        LATEST_SESSION_ID_FIRST_COMPARATOR = new Comparator() { // from class: com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence$$ExternalSyntheticLambda2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return CrashlyticsReportPersistence.lambda$static$0((File) obj, (File) obj2);
            }
        };
        EVENT_FILE_FILTER = new FilenameFilter() { // from class: com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence$$ExternalSyntheticLambda3
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return CrashlyticsReportPersistence.lambda$static$1(file, str);
            }
        };
        int i = BuiltInFictitiousFunctionClassFactory + 89;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$static$0(File file, File file2) {
        int compareTo;
        int i = getAuthRequestContext + 85;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        Object[] objArr = null;
        if (!(i % 2 == 0)) {
            compareTo = file2.getName().compareTo(file.getName());
            int length = objArr.length;
        } else {
            compareTo = file2.getName().compareTo(file.getName());
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 79;
        getAuthRequestContext = i2 % 128;
        if ((i2 % 2 == 0 ? '/' : '5') != '/') {
            return compareTo;
        }
        objArr.hashCode();
        return compareTo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$static$1(File file, String str) {
        int i = getAuthRequestContext + 13;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        boolean startsWith = str.startsWith("event");
        int i3 = BuiltInFictitiousFunctionClassFactory + 65;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return startsWith;
    }

    public CrashlyticsReportPersistence(FileStore fileStore, SettingsProvider settingsProvider) {
        try {
            this.eventCounter = new AtomicInteger(0);
            this.fileStore = fileStore;
            this.settingsProvider = settingsProvider;
        } catch (Exception e) {
            throw e;
        }
    }

    public void persistReport(CrashlyticsReport crashlyticsReport) {
        CrashlyticsReport.Session session = crashlyticsReport.getSession();
        if ((session == null ? '0' : 'Z') == '0') {
            try {
                int i = getAuthRequestContext + 35;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                Logger.getLogger().d("Could not get session for report");
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        String identifier = session.getIdentifier();
        try {
            writeTextFile(this.fileStore.getSessionFile(identifier, REPORT_FILE_NAME), TRANSFORM.reportToJson(crashlyticsReport));
            writeTextFile(this.fileStore.getSessionFile(identifier, SESSION_START_TIMESTAMP_FILE_NAME), "", session.getStartedAt());
            int i3 = getAuthRequestContext + 101;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if ((i3 % 2 != 0 ? '=' : 'T') != '=') {
                return;
            }
            int i4 = 3 / 0;
        } catch (IOException e2) {
            Logger logger = Logger.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Could not persist report for session ");
            sb.append(identifier);
            logger.d(sb.toString(), e2);
        }
    }

    public void persistEvent(CrashlyticsReport.Session.Event event, String str) {
        int i = getAuthRequestContext + 61;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            persistEvent(event, str, false);
            int i3 = BuiltInFictitiousFunctionClassFactory + 37;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public void persistEvent(CrashlyticsReport.Session.Event event, String str, boolean z) {
        int i = BuiltInFictitiousFunctionClassFactory + 71;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            try {
                int i3 = this.settingsProvider.getSettingsSync().sessionData.maxCustomExceptionEvents;
                try {
                    writeTextFile(this.fileStore.getSessionFile(str, generateEventFilename(this.eventCounter.getAndIncrement(), z)), TRANSFORM.eventToJson(event));
                } catch (IOException e) {
                    Logger logger = Logger.getLogger();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not persist event for session ");
                    sb.append(str);
                    logger.w(sb.toString(), e);
                }
                trimEvents(str, i3);
                int i4 = BuiltInFictitiousFunctionClassFactory + 61;
                getAuthRequestContext = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    public SortedSet<String> getOpenSessionIds() {
        NavigableSet descendingSet = new TreeSet(this.fileStore.getAllOpenSessionIds()).descendingSet();
        try {
            int i = getAuthRequestContext + 111;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if ((i % 2 != 0 ? 'H' : 'O') != 'H') {
                    return descendingSet;
                }
                int i2 = 38 / 0;
                return descendingSet;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public long getStartTimestampMillis(String str) {
        int i = getAuthRequestContext + 65;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        try {
            if (!(i % 2 == 0)) {
                long lastModified = this.fileStore.getSessionFile(str, SESSION_START_TIMESTAMP_FILE_NAME).lastModified();
                Object[] objArr = null;
                int length = objArr.length;
                return lastModified;
            }
            return this.fileStore.getSessionFile(str, SESSION_START_TIMESTAMP_FILE_NAME).lastModified();
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean hasFinalizedReports() {
        boolean z = true;
        if ((this.fileStore.getReports().isEmpty() ? 'V' : '0') == 'V') {
            try {
                if (this.fileStore.getPriorityReports().isEmpty()) {
                    int i = BuiltInFictitiousFunctionClassFactory + 73;
                    getAuthRequestContext = i % 128;
                    int i2 = i % 2;
                    if ((this.fileStore.getNativeReports().isEmpty() ? Typography.greater : ')') == '>') {
                        int i3 = getAuthRequestContext + 3;
                        BuiltInFictitiousFunctionClassFactory = i3 % 128;
                        if (i3 % 2 == 0) {
                            z = false;
                        }
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        }
        int i4 = BuiltInFictitiousFunctionClassFactory + 43;
        getAuthRequestContext = i4 % 128;
        int i5 = i4 % 2;
        return z;
    }

    public void deleteAllReports() {
        try {
            int i = getAuthRequestContext + 13;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if (i % 2 == 0) {
                    deleteFiles(this.fileStore.getReports());
                    deleteFiles(this.fileStore.getPriorityReports());
                    deleteFiles(this.fileStore.getNativeReports());
                    return;
                }
                deleteFiles(this.fileStore.getReports());
                deleteFiles(this.fileStore.getPriorityReports());
                deleteFiles(this.fileStore.getNativeReports());
                int i2 = 34 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void deleteFiles(List<File> list) {
        try {
            Iterator<File> it = list.iterator();
            while (true) {
                if ((it.hasNext() ? '\\' : '!') != '\\') {
                    int i = BuiltInFictitiousFunctionClassFactory + 13;
                    try {
                        getAuthRequestContext = i % 128;
                        int i2 = i % 2;
                        return;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                it.next().delete();
                int i3 = getAuthRequestContext + 105;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void finalizeReports(String str, long j) {
        Iterator<String> it;
        int i = BuiltInFictitiousFunctionClassFactory + 17;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? '\'' : '3') != '3') {
            try {
                it = capAndGetOpenSessions(str).iterator();
                int i2 = 46 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            it = capAndGetOpenSessions(str).iterator();
        }
        int i3 = getAuthRequestContext + 101;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        while (it.hasNext()) {
            try {
                String next = it.next();
                Logger logger = Logger.getLogger();
                StringBuilder sb = new StringBuilder();
                sb.append("Finalizing report for session ");
                sb.append(next);
                logger.v(sb.toString());
                synthesizeReport(next, j);
                this.fileStore.deleteSessionFiles(next);
            } catch (Exception e2) {
                throw e2;
            }
        }
        capFinalizedReports();
    }

    public void finalizeSessionWithNativeEvent(String str, CrashlyticsReport.FilesPayload filesPayload) {
        File sessionFile = this.fileStore.getSessionFile(str, REPORT_FILE_NAME);
        Logger logger = Logger.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append("Writing native session report for ");
        sb.append(str);
        sb.append(" to file: ");
        sb.append(sessionFile);
        logger.d(sb.toString());
        synthesizeNativeReportFile(sessionFile, filesPayload, str);
        int i = BuiltInFictitiousFunctionClassFactory + 87;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? '_' : (char) 2) != '_') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public List<CrashlyticsReportWithSessionId> loadFinalizedReports() {
        List<File> allFinalizedReportFiles = getAllFinalizedReportFiles();
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = allFinalizedReportFiles.iterator();
        int i = getAuthRequestContext + 1;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        while (true) {
            int i2 = i % 2;
            while (true) {
                if ((it.hasNext() ? 'O' : ']') == ']') {
                    return arrayList;
                }
                try {
                    int i3 = getAuthRequestContext + 25;
                    BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    int i4 = i3 % 2;
                    File next = it.next();
                    try {
                        arrayList.add(CrashlyticsReportWithSessionId.create(TRANSFORM.reportFromJson(readTextFile(next)), next.getName(), next));
                        break;
                    } catch (IOException e) {
                        Logger logger = Logger.getLogger();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Could not load report file ");
                        sb.append(next);
                        sb.append("; deleting");
                        logger.w(sb.toString(), e);
                        next.delete();
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            i = getAuthRequestContext + 17;
            BuiltInFictitiousFunctionClassFactory = i % 128;
        }
    }

    private SortedSet<String> capAndGetOpenSessions(String str) {
        this.fileStore.cleanupPreviousFileSystems();
        SortedSet<String> openSessionIds = getOpenSessionIds();
        if (str != null) {
            openSessionIds.remove(str);
        }
        if ((openSessionIds.size() <= 8 ? 'B' : '3') != '3') {
            int i = BuiltInFictitiousFunctionClassFactory + 13;
            getAuthRequestContext = i % 128;
            if (!(i % 2 == 0)) {
                return openSessionIds;
            }
            int i2 = 78 / 0;
            return openSessionIds;
        }
        while (openSessionIds.size() > 8) {
            String last = openSessionIds.last();
            Logger logger = Logger.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Removing session over cap: ");
            sb.append(last);
            logger.d(sb.toString());
            this.fileStore.deleteSessionFiles(last);
            openSessionIds.remove(last);
            int i3 = getAuthRequestContext + 17;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
        }
        int i5 = BuiltInFictitiousFunctionClassFactory + 47;
        getAuthRequestContext = i5 % 128;
        int i6 = i5 % 2;
        return openSessionIds;
    }

    private void capFinalizedReports() {
        int i = BuiltInFictitiousFunctionClassFactory + 65;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        int i3 = this.settingsProvider.getSettingsSync().sessionData.maxCompleteSessionsCount;
        List<File> allFinalizedReportFiles = getAllFinalizedReportFiles();
        int size = allFinalizedReportFiles.size();
        if (size <= i3) {
            return;
        }
        Iterator<File> it = allFinalizedReportFiles.subList(i3, size).iterator();
        while (true) {
            if (!(it.hasNext())) {
                return;
            }
            try {
                int i4 = getAuthRequestContext + 69;
                BuiltInFictitiousFunctionClassFactory = i4 % 128;
                if (!(i4 % 2 == 0)) {
                    it.next().delete();
                    int i5 = 21 / 0;
                } else {
                    it.next().delete();
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private List<File> getAllFinalizedReportFiles() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.fileStore.getPriorityReports());
        arrayList.addAll(this.fileStore.getNativeReports());
        Comparator<? super File> comparator = LATEST_SESSION_ID_FIRST_COMPARATOR;
        Collections.sort(arrayList, comparator);
        List<File> reports = this.fileStore.getReports();
        Collections.sort(reports, comparator);
        arrayList.addAll(reports);
        try {
            int i = getAuthRequestContext + 51;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (!(i % 2 == 0)) {
                Object[] objArr = null;
                int length = objArr.length;
                return arrayList;
            }
            return arrayList;
        } catch (Exception e) {
            throw e;
        }
    }

    private void synthesizeReport(String str, long j) {
        boolean z;
        List<File> sessionFiles = this.fileStore.getSessionFiles(str, EVENT_FILE_FILTER);
        if (sessionFiles.isEmpty()) {
            Logger logger = Logger.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Session ");
            sb.append(str);
            sb.append(" has no events.");
            logger.v(sb.toString());
            int i = getAuthRequestContext + 45;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (i % 2 != 0) {
                int i2 = 45 / 0;
                return;
            }
            return;
        }
        Collections.sort(sessionFiles);
        ArrayList arrayList = new ArrayList();
        loop0: while (true) {
            z = false;
            for (File file : sessionFiles) {
                try {
                    try {
                        int i3 = getAuthRequestContext + 75;
                        BuiltInFictitiousFunctionClassFactory = i3 % 128;
                        int i4 = i3 % 2;
                        try {
                            arrayList.add(TRANSFORM.eventFromJson(readTextFile(file)));
                            if ((!z ? Typography.greater : '#') != '#') {
                                if (!isHighPriorityEventFile(file.getName())) {
                                    break;
                                }
                            }
                            z = true;
                        } catch (IOException e) {
                            Logger logger2 = Logger.getLogger();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Could not add event to report for ");
                            sb2.append(file);
                            logger2.w(sb2.toString(), e);
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                } catch (Exception e3) {
                    throw e3;
                }
            }
        }
        if (arrayList.isEmpty()) {
            Logger logger3 = Logger.getLogger();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Could not parse event files for session ");
            sb3.append(str);
            logger3.w(sb3.toString());
            return;
        }
        synthesizeReportFile(this.fileStore.getSessionFile(str, REPORT_FILE_NAME), arrayList, j, z, UserMetadata.readUserId(str, this.fileStore));
    }

    private void synthesizeNativeReportFile(File file, CrashlyticsReport.FilesPayload filesPayload, String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 99;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = TRANSFORM;
            writeTextFile(this.fileStore.getNativeReport(str), crashlyticsReportJsonTransform.reportToJson(crashlyticsReportJsonTransform.reportFromJson(readTextFile(file)).withNdkPayload(filesPayload)));
            int i3 = BuiltInFictitiousFunctionClassFactory + 101;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
        } catch (IOException e) {
            Logger logger = Logger.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Could not synthesize final native report file for ");
            sb.append(file);
            logger.w(sb.toString(), e);
        }
    }

    private void synthesizeReportFile(File file, List<CrashlyticsReport.Session.Event> list, long j, boolean z, String str) {
        File report;
        int i = getAuthRequestContext + 47;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = TRANSFORM;
            CrashlyticsReport withEvents = crashlyticsReportJsonTransform.reportFromJson(readTextFile(file)).withSessionEndFields(j, z, str).withEvents(ImmutableList.from(list));
            CrashlyticsReport.Session session = withEvents.getSession();
            if (session == null) {
                return;
            }
            if ((z ? '*' : 'C') != 'C') {
                report = this.fileStore.getPriorityReport(session.getIdentifier());
            } else {
                report = this.fileStore.getReport(session.getIdentifier());
                int i3 = BuiltInFictitiousFunctionClassFactory + 57;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
            }
            writeTextFile(report, crashlyticsReportJsonTransform.reportToJson(withEvents));
        } catch (IOException e) {
            Logger logger = Logger.getLogger();
            StringBuilder sb = new StringBuilder();
            sb.append("Could not synthesize final report file for ");
            sb.append(file);
            logger.w(sb.toString(), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isHighPriorityEventFile(java.lang.String r4) {
        /*
            int r0 = com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence.getAuthRequestContext
            int r0 = r0 + 15
            int r1 = r0 % 128
            com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            java.lang.String r0 = "event"
            boolean r0 = r4.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L30
            java.lang.String r0 = "_"
            boolean r4 = r4.endsWith(r0)
            r0 = 90
            if (r4 == 0) goto L20
            r4 = 82
            goto L22
        L20:
            r4 = 90
        L22:
            if (r4 == r0) goto L30
            r4 = 1
            int r0 = com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 93
            int r2 = r0 % 128
            com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence.getAuthRequestContext = r2
            int r0 = r0 % 2
            goto L31
        L30:
            r4 = 0
        L31:
            int r0 = com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence.BuiltInFictitiousFunctionClassFactory
            r2 = 53
            int r0 = r0 + r2
            int r3 = r0 % 128
            com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence.getAuthRequestContext = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L41
            r0 = 53
            goto L43
        L41:
            r0 = 83
        L43:
            if (r0 == r2) goto L46
            return r4
        L46:
            r0 = 67
            int r0 = r0 / r1
            return r4
        L4a:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence.isHighPriorityEventFile(java.lang.String):boolean");
    }

    private static boolean isNormalPriorityEventFile(File file, String str) {
        try {
            boolean z = false;
            if (!(!str.startsWith("event"))) {
                int i = BuiltInFictitiousFunctionClassFactory + 125;
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                if ((!str.endsWith("_") ? '3' : (char) 17) == '3') {
                    z = true;
                }
            }
            try {
                int i3 = getAuthRequestContext + 95;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                return z;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String generateEventFilename(int i, boolean z) {
        try {
            Locale locale = Locale.US;
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(i);
            String format = String.format(locale, EVENT_COUNTER_FORMAT, objArr);
            String str = "_";
            if (z) {
                int i2 = getAuthRequestContext + 19;
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                if ((i2 % 2 != 0 ? '\t' : 'R') == '\t') {
                    int i3 = 27 / 0;
                }
            } else {
                int i4 = getAuthRequestContext + 61;
                BuiltInFictitiousFunctionClassFactory = i4 % 128;
                int i5 = i4 % 2;
                str = "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("event");
            sb.append(format);
            sb.append(str);
            return sb.toString();
        } catch (Exception e) {
            throw e;
        }
    }

    private int trimEvents(String str, int i) {
        List<File> sessionFiles = this.fileStore.getSessionFiles(str, new FilenameFilter() { // from class: com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence$$ExternalSyntheticLambda0
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str2) {
                return CrashlyticsReportPersistence.$r8$lambda$JFU0vij0Pn952vNT34mb4Hr_UXo(file, str2);
            }
        });
        Collections.sort(sessionFiles, new Comparator() { // from class: com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return CrashlyticsReportPersistence.m160$r8$lambda$n3pLmsPsVa9XZY5T7lAH7PN0HQ((File) obj, (File) obj2);
            }
        });
        int capFilesCount = capFilesCount(sessionFiles, i);
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 89;
            getAuthRequestContext = i2 % 128;
            if ((i2 % 2 == 0 ? (char) 23 : '8') != '8') {
                Object obj = null;
                obj.hashCode();
                return capFilesCount;
            }
            return capFilesCount;
        } catch (Exception e) {
            throw e;
        }
    }

    private static String getEventNameWithoutPriority(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 57;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        String substring = str.substring(0, EVENT_NAME_LENGTH);
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 47;
            try {
                getAuthRequestContext = i3 % 128;
                if ((i3 % 2 == 0 ? '6' : 'P') != 'P') {
                    int i4 = 18 / 0;
                    return substring;
                }
                return substring;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static int oldestEventFileFirst(File file, File file2) {
        try {
            int i = getAuthRequestContext + 39;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            try {
                int compareTo = getEventNameWithoutPriority(file.getName()).compareTo(getEventNameWithoutPriority(file2.getName()));
                int i3 = getAuthRequestContext + 33;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if ((i3 % 2 != 0 ? (char) 5 : '[') != 5) {
                    return compareTo;
                }
                int i4 = 98 / 0;
                return compareTo;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void writeTextFile(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), UTF_8);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
            int i = BuiltInFictitiousFunctionClassFactory + 43;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void writeTextFile(File file, String str, long j) throws IOException {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), UTF_8);
            try {
                outputStreamWriter.write(str);
                file.setLastModified(convertTimestampFromSecondsToMs(j));
                outputStreamWriter.close();
                int i = BuiltInFictitiousFunctionClassFactory + 67;
                try {
                    getAuthRequestContext = i % 128;
                    int i2 = i % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Throwable th) {
                try {
                    outputStreamWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static String readTextFile(File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            int i = getAuthRequestContext + 121;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (!(read <= 0)) {
                        int i3 = BuiltInFictitiousFunctionClassFactory + 25;
                        getAuthRequestContext = i3 % 128;
                        int i4 = i3 % 2;
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        String str = new String(byteArrayOutputStream.toByteArray(), UTF_8);
                        fileInputStream.close();
                        return str;
                    }
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static int capFilesCount(List<File> list, int i) {
        int size;
        Iterator<File> it;
        int i2 = getAuthRequestContext + 37;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if (i2 % 2 != 0) {
            size = list.size();
            it = list.iterator();
            int i3 = 6 / 0;
        } else {
            try {
                size = list.size();
                it = list.iterator();
            } catch (Exception e) {
                throw e;
            }
        }
        while (true) {
            if (!(it.hasNext())) {
                return size;
            }
            int i4 = BuiltInFictitiousFunctionClassFactory + 19;
            getAuthRequestContext = i4 % 128;
            int i5 = i4 % 2;
            try {
                File next = it.next();
                if ((size <= i ? 'V' : '`') == 'V') {
                    return size;
                }
                FileStore.recursiveDelete(next);
                size--;
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        int i2;
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            int i3 = $10 + 69;
            $11 = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 7 : 'X') != 7) {
                jArr[getonboardingscenario.getAuthRequestContext] = (4796183387843776835L ^ MyBillsEntityDataFactory) ^ (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory));
                i2 = getonboardingscenario.getAuthRequestContext + 1;
            } else {
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] | (getonboardingscenario.getAuthRequestContext % getonboardingscenario.MyBillsEntityDataFactory)) * (4796183387843776835L | MyBillsEntityDataFactory);
                i2 = getonboardingscenario.getAuthRequestContext << 0;
            }
            getonboardingscenario.getAuthRequestContext = i2;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? '6' : 'Q') == 'Q') {
                objArr[0] = new String(cArr2);
                return;
            }
            int i4 = $10 + 23;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            try {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
