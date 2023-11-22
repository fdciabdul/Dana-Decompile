package com.google.firebase.crashlytics.internal.model;

import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_CustomAttribute;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application_Organization;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Log;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_OperatingSystem;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_User;
import com.google.firebase.encoders.annotations.Encodable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;
import kotlin.text.Typography;
import o.A;

@Encodable
/* loaded from: classes.dex */
public abstract class CrashlyticsReport {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int PlaceComponentResult = 1;
    private static final Charset UTF_8;
    private static int getAuthRequestContext;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Architecture {
        public static final int ARM64 = 9;
        public static final int ARMV6 = 5;
        public static final int ARMV7 = 6;
        public static final int UNKNOWN = 7;
        public static final int X86_32 = 0;
        public static final int X86_64 = 1;
    }

    /* loaded from: classes.dex */
    public static abstract class Builder {
        public abstract CrashlyticsReport build();

        public abstract Builder setBuildVersion(String str);

        public abstract Builder setDisplayVersion(String str);

        public abstract Builder setGmpAppId(String str);

        public abstract Builder setInstallationUuid(String str);

        public abstract Builder setNdkPayload(FilesPayload filesPayload);

        public abstract Builder setPlatform(int i);

        public abstract Builder setSdkVersion(String str);

        public abstract Builder setSession(Session session);
    }

    /* loaded from: classes.dex */
    public enum Type {
        INCOMPLETE,
        JAVA,
        NATIVE
    }

    static void PlaceComponentResult() {
        getAuthRequestContext = 269894733;
    }

    public abstract String getBuildVersion();

    public abstract String getDisplayVersion();

    public abstract String getGmpAppId();

    public abstract String getInstallationUuid();

    public abstract FilesPayload getNdkPayload();

    public abstract int getPlatform();

    public abstract String getSdkVersion();

    public abstract Session getSession();

    protected abstract Builder toBuilder();

    static /* synthetic */ Charset access$000() {
        int i = PlaceComponentResult + 109;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? '\r' : 'X') != '\r') {
            return UTF_8;
        }
        int i2 = 79 / 0;
        return UTF_8;
    }

    static {
        PlaceComponentResult();
        Object[] objArr = new Object[1];
        a(new char[]{2, 65513, 65524, 17, 16}, 172 - ExpandableListView.getPackedPositionType(0L), ExpandableListView.getPackedPositionGroup(0L) + 5, false, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 3, objArr);
        UTF_8 = Charset.forName(((String) objArr[0]).intern());
        int i = PlaceComponentResult + 31;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? (char) 23 : '1') != '1') {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static Builder builder() {
        AutoValue_CrashlyticsReport.Builder builder = new AutoValue_CrashlyticsReport.Builder();
        int i = BuiltInFictitiousFunctionClassFactory + 21;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            int i2 = 19 / 0;
            return builder;
        }
        return builder;
    }

    @Encodable.Ignore
    public Type getType() {
        try {
            if (getSession() == null) {
                if (!(getNdkPayload() != null)) {
                    Type type = Type.INCOMPLETE;
                    int i = PlaceComponentResult + 101;
                    BuiltInFictitiousFunctionClassFactory = i % 128;
                    int i2 = i % 2;
                    return type;
                }
                int i3 = BuiltInFictitiousFunctionClassFactory + 107;
                PlaceComponentResult = i3 % 128;
                boolean z = i3 % 2 != 0;
                Type type2 = Type.NATIVE;
                if (z) {
                    return type2;
                }
                Object obj = null;
                obj.hashCode();
                return type2;
            }
            int i4 = BuiltInFictitiousFunctionClassFactory + 53;
            PlaceComponentResult = i4 % 128;
            if (i4 % 2 == 0) {
                int i5 = 44 / 0;
                return Type.JAVA;
            }
            return Type.JAVA;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if ((r0 != null ? 17 : kotlin.text.Typography.less) == 17) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        if ((getSession() != null) == true) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        r0 = com.google.firebase.crashlytics.internal.model.CrashlyticsReport.PlaceComponentResult + 53;
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.BuiltInFictitiousFunctionClassFactory = r0 % 128;
        r0 = r0 % 2;
        r4 = toBuilder().setSession(getSession().withEvents(r4)).build();
        r0 = com.google.firebase.crashlytics.internal.model.CrashlyticsReport.PlaceComponentResult + 49;
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.BuiltInFictitiousFunctionClassFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        if ((r0 % 2) == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        r0 = 35 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
    
        throw new java.lang.IllegalStateException("Reports without sessions cannot have events added to them.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport withEvents(com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event> r4) {
        /*
            r3 = this;
            int r0 = com.google.firebase.crashlytics.internal.model.CrashlyticsReport.PlaceComponentResult
            int r0 = r0 + 31
            int r1 = r0 % 128
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L23
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session r0 = r3.getSession()
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L21
            r2 = 17
            if (r0 == 0) goto L1c
            r0 = 17
            goto L1e
        L1c:
            r0 = 60
        L1e:
            if (r0 != r2) goto L60
            goto L2f
        L21:
            r4 = move-exception
            throw r4
        L23:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session r0 = r3.getSession()
            r2 = 1
            if (r0 == 0) goto L2c
            r0 = 1
            goto L2d
        L2c:
            r0 = 0
        L2d:
            if (r0 != r2) goto L60
        L2f:
            int r0 = com.google.firebase.crashlytics.internal.model.CrashlyticsReport.PlaceComponentResult
            int r0 = r0 + 53
            int r2 = r0 % 128
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport.BuiltInFictitiousFunctionClassFactory = r2
            int r0 = r0 % 2
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder r0 = r3.toBuilder()
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session r2 = r3.getSession()
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session r4 = r2.withEvents(r4)
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder r4 = r0.setSession(r4)
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport r4 = r4.build()
            int r0 = com.google.firebase.crashlytics.internal.model.CrashlyticsReport.PlaceComponentResult
            int r0 = r0 + 49
            int r2 = r0 % 128
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport.BuiltInFictitiousFunctionClassFactory = r2
            int r0 = r0 % 2
            if (r0 == 0) goto L5f
            r0 = 35
            int r0 = r0 / r1
            return r4
        L5d:
            r4 = move-exception
            throw r4
        L5f:
            return r4
        L60:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Reports without sessions cannot have events added to them."
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.CrashlyticsReport.withEvents(com.google.firebase.crashlytics.internal.model.ImmutableList):com.google.firebase.crashlytics.internal.model.CrashlyticsReport");
    }

    public CrashlyticsReport withOrganizationId(String str) {
        try {
            Builder builder = toBuilder();
            FilesPayload ndkPayload = getNdkPayload();
            if (ndkPayload != null) {
                int i = PlaceComponentResult + 37;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if (i % 2 != 0) {
                    try {
                        builder.setNdkPayload(ndkPayload.toBuilder().setOrgId(str).build());
                        Object obj = null;
                        obj.hashCode();
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    builder.setNdkPayload(ndkPayload.toBuilder().setOrgId(str).build());
                }
            }
            Session session = getSession();
            if ((session != null ? (char) 15 : '0') == 15) {
                int i2 = PlaceComponentResult + 15;
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                boolean z = i2 % 2 != 0;
                builder.setSession(session.withOrganizationId(str));
                if (z) {
                    int i3 = 14 / 0;
                }
            }
            CrashlyticsReport build = builder.build();
            int i4 = BuiltInFictitiousFunctionClassFactory + 113;
            PlaceComponentResult = i4 % 128;
            if (i4 % 2 == 0) {
                int i5 = 11 / 0;
                return build;
            }
            return build;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public CrashlyticsReport withNdkPayload(FilesPayload filesPayload) {
        try {
            int i = PlaceComponentResult + 85;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            try {
                CrashlyticsReport build = toBuilder().setSession(null).setNdkPayload(filesPayload).build();
                int i3 = BuiltInFictitiousFunctionClassFactory + 107;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return build;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public CrashlyticsReport withSessionEndFields(long j, boolean z, String str) {
        int i = PlaceComponentResult + 11;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        Builder builder = toBuilder();
        if ((getSession() != null ? '5' : (char) 0) != 0) {
            try {
                int i3 = BuiltInFictitiousFunctionClassFactory + 3;
                PlaceComponentResult = i3 % 128;
                if ((i3 % 2 == 0 ? '%' : Typography.amp) != '&') {
                    builder.setSession(getSession().withSessionEndFields(j, z, str));
                    Object obj = null;
                    obj.hashCode();
                } else {
                    try {
                        builder.setSession(getSession().withSessionEndFields(j, z, str));
                    } catch (Exception e) {
                        throw e;
                    }
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return builder.build();
    }

    /* loaded from: classes.dex */
    public static abstract class FilesPayload {

        /* loaded from: classes.dex */
        public static abstract class Builder {
            public abstract FilesPayload build();

            public abstract Builder setFiles(ImmutableList<File> immutableList);

            public abstract Builder setOrgId(String str);
        }

        public abstract ImmutableList<File> getFiles();

        public abstract String getOrgId();

        abstract Builder toBuilder();

        public static Builder builder() {
            return new AutoValue_CrashlyticsReport_FilesPayload.Builder();
        }

        /* loaded from: classes.dex */
        public static abstract class File {

            /* loaded from: classes.dex */
            public static abstract class Builder {
                public abstract File build();

                public abstract Builder setContents(byte[] bArr);

                public abstract Builder setFilename(String str);
            }

            public abstract byte[] getContents();

            public abstract String getFilename();

            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_FilesPayload_File.Builder();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class CustomAttribute {

        /* loaded from: classes.dex */
        public static abstract class Builder {
            public abstract CustomAttribute build();

            public abstract Builder setKey(String str);

            public abstract Builder setValue(String str);
        }

        public abstract String getKey();

        public abstract String getValue();

        public static Builder builder() {
            return new AutoValue_CrashlyticsReport_CustomAttribute.Builder();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Session {
        public abstract Application getApp();

        public abstract Device getDevice();

        public abstract Long getEndedAt();

        public abstract ImmutableList<Event> getEvents();

        public abstract String getGenerator();

        public abstract int getGeneratorType();

        @Encodable.Ignore
        public abstract String getIdentifier();

        public abstract OperatingSystem getOs();

        public abstract long getStartedAt();

        public abstract User getUser();

        public abstract boolean isCrashed();

        public abstract Builder toBuilder();

        public static Builder builder() {
            return new AutoValue_CrashlyticsReport_Session.Builder().setCrashed(false);
        }

        @Encodable.Field(name = "identifier")
        public byte[] getIdentifierUtf8Bytes() {
            return getIdentifier().getBytes(CrashlyticsReport.access$000());
        }

        Session withEvents(ImmutableList<Event> immutableList) {
            return toBuilder().setEvents(immutableList).build();
        }

        Session withOrganizationId(String str) {
            return toBuilder().setApp(getApp().withOrganizationId(str)).build();
        }

        Session withSessionEndFields(long j, boolean z, String str) {
            Builder builder = toBuilder();
            builder.setEndedAt(Long.valueOf(j));
            builder.setCrashed(z);
            if (str != null) {
                builder.setUser(User.builder().setIdentifier(str).build());
            }
            return builder.build();
        }

        /* loaded from: classes.dex */
        public static abstract class Builder {
            public abstract Session build();

            public abstract Builder setApp(Application application);

            public abstract Builder setCrashed(boolean z);

            public abstract Builder setDevice(Device device);

            public abstract Builder setEndedAt(Long l);

            public abstract Builder setEvents(ImmutableList<Event> immutableList);

            public abstract Builder setGenerator(String str);

            public abstract Builder setGeneratorType(int i);

            public abstract Builder setIdentifier(String str);

            public abstract Builder setOs(OperatingSystem operatingSystem);

            public abstract Builder setStartedAt(long j);

            public abstract Builder setUser(User user);

            public Builder setIdentifierFromUtf8Bytes(byte[] bArr) {
                return setIdentifier(new String(bArr, CrashlyticsReport.access$000()));
            }
        }

        /* loaded from: classes.dex */
        public static abstract class User {

            /* loaded from: classes.dex */
            public static abstract class Builder {
                public abstract User build();

                public abstract Builder setIdentifier(String str);
            }

            public abstract String getIdentifier();

            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_User.Builder();
            }
        }

        /* loaded from: classes.dex */
        public static abstract class Application {

            /* loaded from: classes.dex */
            public static abstract class Builder {
                public abstract Application build();

                public abstract Builder setDevelopmentPlatform(String str);

                public abstract Builder setDevelopmentPlatformVersion(String str);

                public abstract Builder setDisplayVersion(String str);

                public abstract Builder setIdentifier(String str);

                public abstract Builder setInstallationUuid(String str);

                public abstract Builder setOrganization(Organization organization);

                public abstract Builder setVersion(String str);
            }

            public abstract String getDevelopmentPlatform();

            public abstract String getDevelopmentPlatformVersion();

            public abstract String getDisplayVersion();

            public abstract String getIdentifier();

            public abstract String getInstallationUuid();

            public abstract Organization getOrganization();

            public abstract String getVersion();

            protected abstract Builder toBuilder();

            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_Application.Builder();
            }

            Application withOrganizationId(String str) {
                Organization organization = getOrganization();
                return toBuilder().setOrganization((organization != null ? organization.toBuilder() : Organization.builder()).setClsId(str).build()).build();
            }

            /* loaded from: classes.dex */
            public static abstract class Organization {

                /* loaded from: classes.dex */
                public static abstract class Builder {
                    public abstract Organization build();

                    public abstract Builder setClsId(String str);
                }

                public abstract String getClsId();

                protected abstract Builder toBuilder();

                public static Builder builder() {
                    return new AutoValue_CrashlyticsReport_Session_Application_Organization.Builder();
                }
            }
        }

        /* loaded from: classes.dex */
        public static abstract class OperatingSystem {

            /* loaded from: classes.dex */
            public static abstract class Builder {
                public abstract OperatingSystem build();

                public abstract Builder setBuildVersion(String str);

                public abstract Builder setJailbroken(boolean z);

                public abstract Builder setPlatform(int i);

                public abstract Builder setVersion(String str);
            }

            public abstract String getBuildVersion();

            public abstract int getPlatform();

            public abstract String getVersion();

            public abstract boolean isJailbroken();

            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem.Builder();
            }
        }

        /* loaded from: classes.dex */
        public static abstract class Device {

            /* loaded from: classes.dex */
            public static abstract class Builder {
                public abstract Device build();

                public abstract Builder setArch(int i);

                public abstract Builder setCores(int i);

                public abstract Builder setDiskSpace(long j);

                public abstract Builder setManufacturer(String str);

                public abstract Builder setModel(String str);

                public abstract Builder setModelClass(String str);

                public abstract Builder setRam(long j);

                public abstract Builder setSimulator(boolean z);

                public abstract Builder setState(int i);
            }

            public abstract int getArch();

            public abstract int getCores();

            public abstract long getDiskSpace();

            public abstract String getManufacturer();

            public abstract String getModel();

            public abstract String getModelClass();

            public abstract long getRam();

            public abstract int getState();

            public abstract boolean isSimulator();

            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_Device.Builder();
            }
        }

        /* loaded from: classes.dex */
        public static abstract class Event {

            /* loaded from: classes.dex */
            public static abstract class Builder {
                public abstract Event build();

                public abstract Builder setApp(Application application);

                public abstract Builder setDevice(Device device);

                public abstract Builder setLog(Log log);

                public abstract Builder setTimestamp(long j);

                public abstract Builder setType(String str);
            }

            public abstract Application getApp();

            public abstract Device getDevice();

            public abstract Log getLog();

            public abstract long getTimestamp();

            public abstract String getType();

            public abstract Builder toBuilder();

            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_Event.Builder();
            }

            /* loaded from: classes.dex */
            public static abstract class Application {

                /* loaded from: classes.dex */
                public static abstract class Builder {
                    public abstract Application build();

                    public abstract Builder setBackground(Boolean bool);

                    public abstract Builder setCustomAttributes(ImmutableList<CustomAttribute> immutableList);

                    public abstract Builder setExecution(Execution execution);

                    public abstract Builder setInternalKeys(ImmutableList<CustomAttribute> immutableList);

                    public abstract Builder setUiOrientation(int i);
                }

                public abstract Boolean getBackground();

                public abstract ImmutableList<CustomAttribute> getCustomAttributes();

                public abstract Execution getExecution();

                public abstract ImmutableList<CustomAttribute> getInternalKeys();

                public abstract int getUiOrientation();

                public abstract Builder toBuilder();

                public static Builder builder() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Application.Builder();
                }

                /* loaded from: classes.dex */
                public static abstract class Execution {

                    /* loaded from: classes.dex */
                    public static abstract class Builder {
                        public abstract Execution build();

                        public abstract Builder setAppExitInfo(ApplicationExitInfo applicationExitInfo);

                        public abstract Builder setBinaries(ImmutableList<BinaryImage> immutableList);

                        public abstract Builder setException(Exception exception);

                        public abstract Builder setSignal(Signal signal);

                        public abstract Builder setThreads(ImmutableList<Thread> immutableList);
                    }

                    public abstract ApplicationExitInfo getAppExitInfo();

                    public abstract ImmutableList<BinaryImage> getBinaries();

                    public abstract Exception getException();

                    public abstract Signal getSignal();

                    public abstract ImmutableList<Thread> getThreads();

                    public static Builder builder() {
                        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution.Builder();
                    }

                    /* loaded from: classes.dex */
                    public static abstract class Thread {

                        /* loaded from: classes.dex */
                        public static abstract class Builder {
                            public abstract Thread build();

                            public abstract Builder setFrames(ImmutableList<Frame> immutableList);

                            public abstract Builder setImportance(int i);

                            public abstract Builder setName(String str);
                        }

                        public abstract ImmutableList<Frame> getFrames();

                        public abstract int getImportance();

                        public abstract String getName();

                        public static Builder builder() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.Builder();
                        }

                        /* loaded from: classes.dex */
                        public static abstract class Frame {

                            /* loaded from: classes.dex */
                            public static abstract class Builder {
                                public abstract Frame build();

                                public abstract Builder setFile(String str);

                                public abstract Builder setImportance(int i);

                                public abstract Builder setOffset(long j);

                                public abstract Builder setPc(long j);

                                public abstract Builder setSymbol(String str);
                            }

                            public abstract String getFile();

                            public abstract int getImportance();

                            public abstract long getOffset();

                            public abstract long getPc();

                            public abstract String getSymbol();

                            public static Builder builder() {
                                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.Builder();
                            }
                        }
                    }

                    /* loaded from: classes.dex */
                    public static abstract class Exception {

                        /* loaded from: classes.dex */
                        public static abstract class Builder {
                            public abstract Exception build();

                            public abstract Builder setCausedBy(Exception exception);

                            public abstract Builder setFrames(ImmutableList<Thread.Frame> immutableList);

                            public abstract Builder setOverflowCount(int i);

                            public abstract Builder setReason(String str);

                            public abstract Builder setType(String str);
                        }

                        public abstract Exception getCausedBy();

                        public abstract ImmutableList<Thread.Frame> getFrames();

                        public abstract int getOverflowCount();

                        public abstract String getReason();

                        public abstract String getType();

                        public static Builder builder() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.Builder();
                        }
                    }

                    /* loaded from: classes.dex */
                    public static abstract class Signal {

                        /* loaded from: classes.dex */
                        public static abstract class Builder {
                            public abstract Signal build();

                            public abstract Builder setAddress(long j);

                            public abstract Builder setCode(String str);

                            public abstract Builder setName(String str);
                        }

                        public abstract long getAddress();

                        public abstract String getCode();

                        public abstract String getName();

                        public static Builder builder() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.Builder();
                        }
                    }

                    /* loaded from: classes.dex */
                    public static abstract class BinaryImage {
                        public abstract long getBaseAddress();

                        public abstract String getName();

                        public abstract long getSize();

                        @Encodable.Ignore
                        public abstract String getUuid();

                        public static Builder builder() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.Builder();
                        }

                        @Encodable.Field(name = "uuid")
                        public byte[] getUuidUtf8Bytes() {
                            String uuid = getUuid();
                            if (uuid != null) {
                                return uuid.getBytes(CrashlyticsReport.access$000());
                            }
                            return null;
                        }

                        /* loaded from: classes.dex */
                        public static abstract class Builder {
                            public abstract BinaryImage build();

                            public abstract Builder setBaseAddress(long j);

                            public abstract Builder setName(String str);

                            public abstract Builder setSize(long j);

                            public abstract Builder setUuid(String str);

                            public Builder setUuidFromUtf8Bytes(byte[] bArr) {
                                return setUuid(new String(bArr, CrashlyticsReport.access$000()));
                            }
                        }
                    }
                }
            }

            /* loaded from: classes.dex */
            public static abstract class Device {

                /* loaded from: classes.dex */
                public static abstract class Builder {
                    public abstract Device build();

                    public abstract Builder setBatteryLevel(Double d);

                    public abstract Builder setBatteryVelocity(int i);

                    public abstract Builder setDiskUsed(long j);

                    public abstract Builder setOrientation(int i);

                    public abstract Builder setProximityOn(boolean z);

                    public abstract Builder setRamUsed(long j);
                }

                public abstract Double getBatteryLevel();

                public abstract int getBatteryVelocity();

                public abstract long getDiskUsed();

                public abstract int getOrientation();

                public abstract long getRamUsed();

                public abstract boolean isProximityOn();

                public static Builder builder() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Device.Builder();
                }
            }

            /* loaded from: classes.dex */
            public static abstract class Log {

                /* loaded from: classes.dex */
                public static abstract class Builder {
                    public abstract Log build();

                    public abstract Builder setContent(String str);
                }

                public abstract String getContent();

                public static Builder builder() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Log.Builder();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ApplicationExitInfo {

        /* loaded from: classes.dex */
        public static abstract class Builder {
            public abstract ApplicationExitInfo build();

            public abstract Builder setImportance(int i);

            public abstract Builder setPid(int i);

            public abstract Builder setProcessName(String str);

            public abstract Builder setPss(long j);

            public abstract Builder setReasonCode(int i);

            public abstract Builder setRss(long j);

            public abstract Builder setTimestamp(long j);

            public abstract Builder setTraceFile(String str);
        }

        public abstract int getImportance();

        public abstract int getPid();

        public abstract String getProcessName();

        public abstract long getPss();

        public abstract int getReasonCode();

        public abstract long getRss();

        public abstract long getTimestamp();

        public abstract String getTraceFile();

        public static Builder builder() {
            return new AutoValue_CrashlyticsReport_ApplicationExitInfo.Builder();
        }
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (true) {
            if ((a2.MyBillsEntityDataFactory < i2 ? '+' : 'O') != '+') {
                break;
            }
            try {
                int i4 = $11 + 101;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                int i6 = a2.MyBillsEntityDataFactory;
                cArr2[i6] = (char) (cArr2[i6] - ((int) (getAuthRequestContext ^ (-5694784870793460699L))));
                a2.MyBillsEntityDataFactory++;
            } catch (Exception e) {
                throw e;
            }
            throw e;
        }
        if (i3 > 0) {
            a2.BuiltInFictitiousFunctionClassFactory = i3;
            char[] cArr3 = new char[i2];
            System.arraycopy(cArr2, 0, cArr3, 0, i2);
            System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
            int i7 = $10 + 109;
            $11 = i7 % 128;
            int i8 = i7 % 2;
        }
        if (z) {
            try {
                int i9 = $11 + 69;
                $10 = i9 % 128;
                int i10 = i9 % 2;
                char[] cArr4 = new char[i2];
                a2.MyBillsEntityDataFactory = 0;
                while (a2.MyBillsEntityDataFactory < i2) {
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                }
                cArr2 = cArr4;
            } catch (Exception e2) {
                throw e2;
            }
        }
        String str = new String(cArr2);
        int i11 = $11 + 23;
        $10 = i11 % 128;
        int i12 = i11 % 2;
        objArr[0] = str;
    }
}
