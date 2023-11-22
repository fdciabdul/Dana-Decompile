package zipkin2;

import android.graphics.drawable.Drawable;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.text.Typography;
import zipkin2.codec.SpanBytesDecoder;
import zipkin2.codec.SpanBytesEncoder;
import zipkin2.internal.HexCodec;
import zipkin2.internal.Nullable;
import zipkin2.internal.RecyclableBuffers;

/* loaded from: classes6.dex */
public final class Span implements Serializable {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    public static final Endpoint EMPTY_ENDPOINT;
    static final int FLAG_DEBUG = 2;
    static final int FLAG_DEBUG_SET = 4;
    static final int FLAG_SHARED = 8;
    static final int FLAG_SHARED_SET = 16;
    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static int MyBillsEntityDataFactory = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static int PlaceComponentResult;
    static final String THIRTY_TWO_ZEROS;
    static final Charset UTF_8;
    private static short[] getAuthRequestContext;
    private static int getErrorConfigVersion;
    private static final long serialVersionUID = 0;
    final List<Annotation> annotations;
    final long duration;
    final int flags;

    /* renamed from: id  reason: collision with root package name */
    final String f8270id;
    final Kind kind;
    final Endpoint localEndpoint;
    final String name;
    final String parentId;
    final Endpoint remoteEndpoint;
    final Map<String, String> tags;
    final long timestamp;
    final String traceId;

    /* loaded from: classes6.dex */
    public enum Kind {
        CLIENT,
        SERVER,
        PRODUCER,
        CONSUMER
    }

    static void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = 1257195750;
        PlaceComponentResult = -1654223022;
        KClassImpl$Data$declaredNonStaticMembers$2 = new byte[]{19, Ascii.GS, -63, -10, -23};
        BuiltInFictitiousFunctionClassFactory = -301738768;
    }

    static {
        MyBillsEntityDataFactory();
        Object[] objArr = new Object[1];
        a(1527997329 - Drawable.resolveOpacity(0, 0), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 123, (short) (TextUtils.indexOf("", "") - 119), 678836360 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (byte) (ViewConfiguration.getScrollBarSize() >> 8), objArr);
        UTF_8 = Charset.forName(((String) objArr[0]).intern());
        EMPTY_ENDPOINT = new Endpoint(Endpoint.newBuilder());
        char[] cArr = new char[32];
        Arrays.fill(cArr, '0');
        THIRTY_TWO_ZEROS = new String(cArr);
        int i = getErrorConfigVersion + 59;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? ',' : '[') != '[') {
            Object[] objArr2 = null;
            int length = objArr2.length;
        }
    }

    public final String traceId() {
        int i = getErrorConfigVersion + 63;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        String str = this.traceId;
        try {
            int i3 = getErrorConfigVersion + 37;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            if ((i3 % 2 == 0 ? Typography.amp : 'C') != '&') {
                return str;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    @Nullable
    public final String parentId() {
        String str;
        try {
            int i = getErrorConfigVersion + 99;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                if (!(i % 2 == 0)) {
                    str = this.parentId;
                } else {
                    str = this.parentId;
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i2 = getErrorConfigVersion + 109;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
                int i3 = i2 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final String id() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 107;
            try {
                getErrorConfigVersion = i % 128;
                if ((i % 2 != 0 ? '[' : (char) 7) != 7) {
                    String str = this.f8270id;
                    Object[] objArr = null;
                    int length = objArr.length;
                    return str;
                }
                return this.f8270id;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Nullable
    public final Kind kind() {
        int i = getErrorConfigVersion + 75;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Kind kind = this.kind;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 55;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
        return kind;
    }

    @Nullable
    public final String name() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 63;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        String str = this.name;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 59;
        getErrorConfigVersion = i3 % 128;
        if ((i3 % 2 != 0 ? 'Y' : (char) 29) != 'Y') {
            return str;
        }
        int i4 = 70 / 0;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        if ((r3 > 0) != true) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
    
        r0 = java.lang.Long.valueOf(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        r1 = zipkin2.Span.getErrorConfigVersion + 61;
        zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if ((r3 > 0 ? 'Q' : '9') != 'Q') goto L18;
     */
    @zipkin2.internal.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Long timestamp() {
        /*
            r6 = this;
            int r0 = zipkin2.Span.getErrorConfigVersion
            int r0 = r0 + 117
            int r1 = r0 % 128
            zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L20
            long r3 = r6.timestamp     // Catch: java.lang.Exception -> L1e
            r0 = 81
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 <= 0) goto L19
            r1 = 81
            goto L1b
        L19:
            r1 = 57
        L1b:
            if (r1 == r0) goto L2e
            goto L2c
        L1e:
            r0 = move-exception
            goto L3d
        L20:
            long r3 = r6.timestamp
            r0 = 1
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 <= 0) goto L29
            r1 = 1
            goto L2a
        L29:
            r1 = 0
        L2a:
            if (r1 == r0) goto L2e
        L2c:
            r0 = 0
            goto L3c
        L2e:
            java.lang.Long r0 = java.lang.Long.valueOf(r3)
            int r1 = zipkin2.Span.getErrorConfigVersion     // Catch: java.lang.Exception -> L1e
            int r1 = r1 + 61
            int r2 = r1 % 128
            zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2     // Catch: java.lang.Exception -> L1e
            int r1 = r1 % 2
        L3c:
            return r0
        L3d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.Span.timestamp():java.lang.Long");
    }

    public final long timestampAsLong() {
        long j;
        int i = getErrorConfigVersion + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if (i % 2 == 0) {
            j = this.timestamp;
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            j = this.timestamp;
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 83;
        getErrorConfigVersion = i2 % 128;
        if (!(i2 % 2 == 0)) {
            int i3 = 12 / 0;
            return j;
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        if ((r0 > 0 ? 18 : 22) != 18) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        if (r0 > 1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        r2 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 + 93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        zipkin2.Span.getErrorConfigVersion = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        r2 = r2 % 2;
        r0 = java.lang.Long.valueOf(r0);
        r1 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 + 37;
        zipkin2.Span.getErrorConfigVersion = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return r0;
     */
    @zipkin2.internal.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Long duration() {
        /*
            r6 = this;
            int r0 = zipkin2.Span.getErrorConfigVersion
            int r0 = r0 + 1
            int r1 = r0 % 128
            zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            int r0 = r0 % 2
            r1 = 31
            if (r0 != 0) goto L11
            r0 = 31
            goto L13
        L11:
            r0 = 29
        L13:
            if (r0 == r1) goto L27
            long r0 = r6.duration
            r2 = 0
            r4 = 18
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L22
            r2 = 18
            goto L24
        L22:
            r2 = 22
        L24:
            if (r2 == r4) goto L2f
            goto L4a
        L27:
            long r0 = r6.duration
            r2 = 1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L4a
        L2f:
            int r2 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L48
            int r2 = r2 + 93
            int r3 = r2 % 128
            zipkin2.Span.getErrorConfigVersion = r3     // Catch: java.lang.Exception -> L48
            int r2 = r2 % 2
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            int r1 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r1 = r1 + 37
            int r2 = r1 % 128
            zipkin2.Span.getErrorConfigVersion = r2
            int r1 = r1 % 2
            goto L4b
        L48:
            r0 = move-exception
            throw r0
        L4a:
            r0 = 0
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.Span.duration():java.lang.Long");
    }

    public final long durationAsLong() {
        int i = getErrorConfigVersion + 109;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? (char) 28 : 'M') != 'M') {
            long j = this.duration;
            Object obj = null;
            obj.hashCode();
            return j;
        }
        return this.duration;
    }

    @Nullable
    public final Endpoint localEndpoint() {
        Endpoint endpoint;
        int i = getErrorConfigVersion + 31;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? JSONLexer.EOI : (char) 11) != 26) {
            try {
                endpoint = this.localEndpoint;
            } catch (Exception e) {
                throw e;
            }
        } else {
            endpoint = this.localEndpoint;
            Object obj = null;
            obj.hashCode();
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 31;
        getErrorConfigVersion = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 1 / 0;
            return endpoint;
        }
        return endpoint;
    }

    @Nullable
    public final Endpoint remoteEndpoint() {
        int i = getErrorConfigVersion + 77;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Endpoint endpoint = this.remoteEndpoint;
        int i3 = getErrorConfigVersion + 73;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
        return endpoint;
    }

    public final List<Annotation> annotations() {
        try {
            int i = getErrorConfigVersion + 1;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if (!(i % 2 == 0)) {
                return this.annotations;
            }
            List<Annotation> list = this.annotations;
            Object[] objArr = null;
            int length = objArr.length;
            return list;
        } catch (Exception e) {
            throw e;
        }
    }

    public final Map<String, String> tags() {
        Map<String, String> map;
        int i = getErrorConfigVersion + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? (char) 20 : ':') != ':') {
            map = this.tags;
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            try {
                map = this.tags;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = getErrorConfigVersion + 51;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        return map;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        if (((r0 & 2) == 2 ? 'S' : '\b') != 'S') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0032, code lost:
    
        if ((r0 | 4) == 3) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0034, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
    
        r0 = java.lang.Boolean.valueOf(r4);
     */
    @zipkin2.internal.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean debug() {
        /*
            r6 = this;
            int r0 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L47
            int r0 = r0 + 21
            int r1 = r0 % 128
            zipkin2.Span.getErrorConfigVersion = r1     // Catch: java.lang.Exception -> L47
            r1 = 2
            int r0 = r0 % r1
            int r0 = r6.flags     // Catch: java.lang.Exception -> L45
            r2 = r0 & 4
            r3 = 4
            if (r2 != r3) goto L3a
            int r2 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r2 = r2 + 47
            int r4 = r2 % 128
            zipkin2.Span.getErrorConfigVersion = r4
            int r2 = r2 % r1
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L20
            r2 = 0
            goto L21
        L20:
            r2 = 1
        L21:
            if (r2 == 0) goto L30
            r0 = r0 & r1
            r2 = 83
            if (r0 != r1) goto L2b
            r0 = 83
            goto L2d
        L2b:
            r0 = 8
        L2d:
            if (r0 == r2) goto L34
            goto L35
        L30:
            r0 = r0 | r3
            r2 = 3
            if (r0 != r2) goto L35
        L34:
            r4 = 1
        L35:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            goto L3b
        L3a:
            r0 = 0
        L3b:
            int r2 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r2 = r2 + 121
            int r3 = r2 % 128
            zipkin2.Span.getErrorConfigVersion = r3
            int r2 = r2 % r1
            return r0
        L45:
            r0 = move-exception
            throw r0
        L47:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.Span.debug():java.lang.Boolean");
    }

    @Nullable
    public final Boolean shared() {
        boolean z;
        int i = this.flags;
        if ((i & 16) == 16) {
            try {
                int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 107;
                try {
                    getErrorConfigVersion = i2 % 128;
                    int i3 = i2 % 2;
                    if (((i & 8) == 8 ? '5' : '*') != '*') {
                        int i4 = getErrorConfigVersion + 105;
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
                        if (i4 % 2 == 0) {
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return null;
    }

    @Nullable
    public final String localServiceName() {
        Endpoint localEndpoint = localEndpoint();
        if ((localEndpoint != null ? 'Y' : (char) 5) != 5) {
            int i = getErrorConfigVersion + 13;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            try {
                String serviceName = localEndpoint.serviceName();
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 5;
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
                return serviceName;
            } catch (Exception e) {
                throw e;
            }
        }
        return null;
    }

    @Nullable
    public final String remoteServiceName() {
        int i = getErrorConfigVersion + 53;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Endpoint remoteEndpoint = remoteEndpoint();
        if (!(remoteEndpoint != null)) {
            try {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 117;
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
                return null;
            } catch (Exception e) {
                throw e;
            }
        }
        return remoteEndpoint.serviceName();
    }

    public static Builder newBuilder() {
        Builder builder = new Builder();
        int i = getErrorConfigVersion + 73;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        return builder;
    }

    public final Builder toBuilder() {
        Builder builder = new Builder(this);
        int i = getErrorConfigVersion + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? (char) 11 : 'T') != 11) {
            return builder;
        }
        Object obj = null;
        obj.hashCode();
        return builder;
    }

    /* loaded from: classes6.dex */
    public static final class Builder {
        public int BuiltInFictitiousFunctionClassFactory;
        public Kind KClassImpl$Data$declaredNonStaticMembers$2;
        ArrayList<Annotation> MyBillsEntityDataFactory;
        public Endpoint NetworkUserEntityData$$ExternalSyntheticLambda0;
        public long NetworkUserEntityData$$ExternalSyntheticLambda1;
        public String NetworkUserEntityData$$ExternalSyntheticLambda2;
        public String PlaceComponentResult;
        public long getAuthRequestContext;
        public Endpoint getErrorConfigVersion;
        TreeMap<String, String> lookAheadTest;
        public String moveToNextValue;
        public String scheduleImpl;

        public final Builder PlaceComponentResult() {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
            this.moveToNextValue = null;
            this.PlaceComponentResult = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.scheduleImpl = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0L;
            this.getAuthRequestContext = 0L;
            this.getErrorConfigVersion = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
            ArrayList<Annotation> arrayList = this.MyBillsEntityDataFactory;
            if (arrayList != null) {
                arrayList.clear();
            }
            TreeMap<String, String> treeMap = this.lookAheadTest;
            if (treeMap != null) {
                treeMap.clear();
            }
            this.BuiltInFictitiousFunctionClassFactory = 0;
            return this;
        }

        Builder(Span span) {
            this.BuiltInFictitiousFunctionClassFactory = 0;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = span.traceId;
            this.moveToNextValue = span.parentId;
            this.PlaceComponentResult = span.f8270id;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = span.kind;
            this.scheduleImpl = span.name;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = span.timestamp;
            this.getAuthRequestContext = span.duration;
            this.getErrorConfigVersion = span.localEndpoint;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = span.remoteEndpoint;
            if (!span.annotations.isEmpty()) {
                ArrayList<Annotation> arrayList = new ArrayList<>(span.annotations.size());
                this.MyBillsEntityDataFactory = arrayList;
                arrayList.addAll(span.annotations);
            }
            if (!span.tags.isEmpty()) {
                TreeMap<String, String> treeMap = new TreeMap<>();
                this.lookAheadTest = treeMap;
                treeMap.putAll(span.tags);
            }
            this.BuiltInFictitiousFunctionClassFactory = span.flags;
        }

        public final Builder PlaceComponentResult(@Nullable String str) {
            if (str == null) {
                this.moveToNextValue = null;
                return this;
            }
            int length = str.length();
            if (length != 0) {
                if (length > 16) {
                    throw new IllegalArgumentException("parentId.length > 16");
                }
                if (Span.validateHexAndReturnZeroPrefix(str) == length) {
                    this.moveToNextValue = null;
                } else {
                    if (length < 16) {
                        str = Span.padLeft(str, 16);
                    }
                    this.moveToNextValue = str;
                }
                return this;
            }
            throw new IllegalArgumentException("parentId is empty");
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(String str) {
            if (str == null) {
                throw new NullPointerException("id == null");
            }
            int length = str.length();
            if (length != 0) {
                if (length > 16) {
                    throw new IllegalArgumentException("id.length > 16");
                }
                if (Span.validateHexAndReturnZeroPrefix(str) != 16) {
                    if (length < 16) {
                        str = Span.padLeft(str, 16);
                    }
                    this.PlaceComponentResult = str;
                    return this;
                }
                throw new IllegalArgumentException("id is all zeros");
            }
            throw new IllegalArgumentException("id is empty");
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(long j, String str) {
            if (this.MyBillsEntityDataFactory == null) {
                this.MyBillsEntityDataFactory = new ArrayList<>(2);
            }
            this.MyBillsEntityDataFactory.add(Annotation.create(j, str));
            return this;
        }

        public final Builder PlaceComponentResult(String str, String str2) {
            if (this.lookAheadTest == null) {
                this.lookAheadTest = new TreeMap<>();
            }
            if (str != null) {
                if (str2 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("value of ");
                    sb.append(str);
                    sb.append(" == null");
                    throw new NullPointerException(sb.toString());
                }
                this.lookAheadTest.put(str, str2);
                return this;
            }
            throw new NullPointerException("key == null");
        }

        public final Builder getAuthRequestContext(boolean z) {
            int i = this.BuiltInFictitiousFunctionClassFactory | 4;
            this.BuiltInFictitiousFunctionClassFactory = i;
            if (z) {
                this.BuiltInFictitiousFunctionClassFactory = i | 2;
            } else {
                this.BuiltInFictitiousFunctionClassFactory = i & (-3);
            }
            return this;
        }

        public final Span getAuthRequestContext() {
            String str;
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" traceId");
                str = sb.toString();
            } else {
                str = "";
            }
            if (this.PlaceComponentResult == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" id");
                str = sb2.toString();
            }
            if (!"".equals(str)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Missing :");
                sb3.append(str);
                throw new IllegalStateException(sb3.toString());
            }
            if (this.PlaceComponentResult.equals(this.moveToNextValue)) {
                Logger logger = Logger.getLogger(Span.class.getName());
                if (logger.isLoggable(Level.FINEST)) {
                    logger.fine(String.format("undoing circular dependency: traceId=%s, spanId=%s", this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.PlaceComponentResult));
                }
                this.moveToNextValue = null;
            }
            if ((this.BuiltInFictitiousFunctionClassFactory & 8) == 8 && this.KClassImpl$Data$declaredNonStaticMembers$2 == Kind.CLIENT) {
                Logger logger2 = Logger.getLogger(Span.class.getName());
                if (logger2.isLoggable(Level.FINEST)) {
                    logger2.fine(String.format("removing shared flag on client: traceId=%s, spanId=%s", this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.PlaceComponentResult));
                }
                this.BuiltInFictitiousFunctionClassFactory &= -25;
            }
            return new Span(this);
        }

        Builder() {
            this.BuiltInFictitiousFunctionClassFactory = 0;
        }

        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            Builder builder = new Builder();
            builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            builder.moveToNextValue = this.moveToNextValue;
            builder.PlaceComponentResult = this.PlaceComponentResult;
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            builder.scheduleImpl = this.scheduleImpl;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            builder.getAuthRequestContext = this.getAuthRequestContext;
            builder.getErrorConfigVersion = this.getErrorConfigVersion;
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            ArrayList<Annotation> arrayList = this.MyBillsEntityDataFactory;
            if (arrayList != null) {
                builder.MyBillsEntityDataFactory = (ArrayList) arrayList.clone();
            }
            TreeMap<String, String> treeMap = this.lookAheadTest;
            if (treeMap != null) {
                builder.lookAheadTest = (TreeMap) treeMap.clone();
            }
            builder.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory;
            return builder;
        }
    }

    public final String toString() {
        String str = new String(SpanBytesEncoder.JSON_V2.encode(this), UTF_8);
        int i = getErrorConfigVersion + 41;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        if (r0 != 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0024, code lost:
    
        r3 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 + 61;
        zipkin2.Span.getErrorConfigVersion = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r0 > 32) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        r4 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 + 79;
        zipkin2.Span.getErrorConfigVersion = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        r4 = validateHexAndReturnZeroPrefix(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        if (r4 == r0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        r5 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 + 71;
        zipkin2.Span.getErrorConfigVersion = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0050, code lost:
    
        if (r0 == 15) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
    
        r5 = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
    
        r5 = kotlin.text.Typography.less;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
    
        if (r5 != 17) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
    
        r5 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 + 107;
        zipkin2.Span.getErrorConfigVersion = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if ((r5 % 2) == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
    
        if (r0 == 72) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
    
        if (r5 == true) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:
    
        if (r0 == 32) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0073, code lost:
    
        if (r0 == 16) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0075, code lost:
    
        r4 = zipkin2.Span.getErrorConfigVersion + 83;
        zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007f, code lost:
    
        if ((r4 % 2) != 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0082, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
    
        if (r1 == true) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0087, code lost:
    
        if (r0 >= 38) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0089, code lost:
    
        r0 = 'X';
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008c, code lost:
    
        r0 = 'H';
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008e, code lost:
    
        if (r0 == 'H') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0091, code lost:
    
        if (r0 >= 16) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0093, code lost:
    
        r8 = padLeft(r8, 16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0097, code lost:
    
        r0 = zipkin2.Span.getErrorConfigVersion + 3;
        zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a1, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a6, code lost:
    
        return padLeft(r8, 32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a7, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a8, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a9, code lost:
    
        if (r0 != 32) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ab, code lost:
    
        if (r4 < 16) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b1, code lost:
    
        return r8.substring(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b9, code lost:
    
        throw new java.lang.RuntimeException("WTF");
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00c2, code lost:
    
        throw new java.lang.IllegalArgumentException("traceId is all zeros");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c3, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c4, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00cd, code lost:
    
        throw new java.lang.IllegalArgumentException("traceId.length > 32");
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d6, code lost:
    
        throw new java.lang.IllegalArgumentException("traceId is empty");
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
    
        if (r0 != 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String normalizeTraceId(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.Span.normalizeTraceId(java.lang.String):java.lang.String");
    }

    static String padLeft(String str, int i) {
        int length = str.length();
        int i2 = i - length;
        char[] BuiltInFictitiousFunctionClassFactory2 = RecyclableBuffers.BuiltInFictitiousFunctionClassFactory();
        THIRTY_TWO_ZEROS.getChars(0, i2, BuiltInFictitiousFunctionClassFactory2, 0);
        str.getChars(0, length, BuiltInFictitiousFunctionClassFactory2, i2);
        String str2 = new String(BuiltInFictitiousFunctionClassFactory2, 0, i);
        try {
            int i3 = getErrorConfigVersion + 7;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
            return str2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String toLowerHex(long j) {
        try {
            char[] BuiltInFictitiousFunctionClassFactory2 = RecyclableBuffers.BuiltInFictitiousFunctionClassFactory();
            writeHexLong(BuiltInFictitiousFunctionClassFactory2, 0, j);
            String str = new String(BuiltInFictitiousFunctionClassFactory2, 0, 16);
            int i = getErrorConfigVersion + 95;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if ((i % 2 == 0 ? (char) 24 : ',') != 24) {
                return str;
            }
            int i2 = 35 / 0;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void writeHexLong(char[] cArr, int i, long j) {
        int i2 = getErrorConfigVersion + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        writeHexByte(cArr, i + 0, (byte) ((j >>> 56) & 255));
        writeHexByte(cArr, i + 2, (byte) ((j >>> 48) & 255));
        writeHexByte(cArr, i + 4, (byte) ((j >>> 40) & 255));
        writeHexByte(cArr, i + 6, (byte) ((j >>> 32) & 255));
        writeHexByte(cArr, i + 8, (byte) ((j >>> 24) & 255));
        writeHexByte(cArr, i + 10, (byte) ((j >>> 16) & 255));
        writeHexByte(cArr, i + 12, (byte) ((j >>> 8) & 255));
        writeHexByte(cArr, i + 14, (byte) (j & 255));
        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 75;
        getErrorConfigVersion = i4 % 128;
        if ((i4 % 2 != 0 ? 'O' : '\f') != 'O') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    static void writeHexByte(char[] cArr, int i, byte b) {
        int i2 = getErrorConfigVersion + 11;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        if (!(i2 % 2 != 0)) {
            cArr[i + 0] = HexCodec.BuiltInFictitiousFunctionClassFactory[(b / 5) | 34];
            cArr[i + 0] = HexCodec.BuiltInFictitiousFunctionClassFactory[b ^ 43];
        } else {
            cArr[i + 0] = HexCodec.BuiltInFictitiousFunctionClassFactory[(b >> 4) & 15];
            cArr[i + 1] = HexCodec.BuiltInFictitiousFunctionClassFactory[b & 15];
        }
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 119;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x005b, code lost:
    
        if (r7 > '9') goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int validateHexAndReturnZeroPrefix(java.lang.String r10) {
        /*
            int r0 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 9
            int r1 = r0 % 128
            zipkin2.Span.getErrorConfigVersion = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 48
            if (r0 == 0) goto L1e
            char r0 = r10.charAt(r1)
            r4 = 101(0x65, float:1.42E-43)
            if (r0 != r4) goto L35
            goto L24
        L1e:
            char r0 = r10.charAt(r2)
            if (r0 != r3) goto L35
        L24:
            int r0 = zipkin2.Span.getErrorConfigVersion     // Catch: java.lang.Exception -> L32
            int r0 = r0 + 119
            int r4 = r0 % 128
            zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4     // Catch: java.lang.Exception -> L30
            int r0 = r0 % 2
            r0 = 1
            goto L36
        L30:
            r10 = move-exception
            goto L81
        L32:
            r10 = move-exception
            goto La0
        L35:
            r0 = 0
        L36:
            int r4 = r10.length()
            r5 = 0
            r6 = 0
        L3c:
            if (r5 >= r4) goto L40
            r7 = 1
            goto L41
        L40:
            r7 = 0
        L41:
            if (r7 == r1) goto L44
            return r6
        L44:
            char r7 = r10.charAt(r5)     // Catch: java.lang.Exception -> L32
            if (r7 < r3) goto L4c
            r8 = 0
            goto L4d
        L4c:
            r8 = 1
        L4d:
            if (r8 == r1) goto L5d
            int r8 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r8 = r8 + 59
            int r9 = r8 % 128
            zipkin2.Span.getErrorConfigVersion = r9
            int r8 = r8 % 2
            r8 = 57
            if (r7 <= r8) goto L6e
        L5d:
            r8 = 97
            r9 = 33
            if (r7 < r8) goto L66
            r8 = 33
            goto L68
        L66:
            r8 = 25
        L68:
            if (r8 != r9) goto L89
            r8 = 102(0x66, float:1.43E-43)
            if (r7 > r8) goto L89
        L6e:
            if (r7 == r3) goto L72
            r7 = 1
            goto L73
        L72:
            r7 = 0
        L73:
            if (r7 == 0) goto L82
            int r0 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L30
            int r0 = r0 + 115
            int r7 = r0 % 128
            zipkin2.Span.getErrorConfigVersion = r7     // Catch: java.lang.Exception -> L32
            int r0 = r0 % 2
            r0 = 0
            goto L86
        L81:
            throw r10
        L82:
            if (r0 == 0) goto L86
            int r6 = r6 + 1
        L86:
            int r5 = r5 + 1
            goto L3c
        L89:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            java.lang.String r10 = " should be lower-hex encoded with no prefix"
            r0.append(r10)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        La0:
            goto La2
        La1:
            throw r10
        La2:
            goto La1
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.Span.validateHexAndReturnZeroPrefix(java.lang.String):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        if ((r6 != null ? '6' : 25) != 25) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002b, code lost:
    
        if ((r6 != null) != true) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0032, code lost:
    
        if (r6.isEmpty() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0034, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0036, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0037, code lost:
    
        if (r0 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x003d, code lost:
    
        return java.util.Collections.emptyList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003e, code lost:
    
        r0 = zipkin2.Span.getErrorConfigVersion + 85;
        zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004c, code lost:
    
        if (r6.size() != 1) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004e, code lost:
    
        r0 = zipkin2.Span.getErrorConfigVersion + 83;
        zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0060, code lost:
    
        return java.util.Collections.singletonList(r6.get(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0061, code lost:
    
        r6 = r6.toArray();
        java.util.Arrays.sort(r6);
        r0 = 1;
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
    
        if (r0 >= r6.length) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006f, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0070, code lost:
    
        if (r4 == true) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0072, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0073, code lost:
    
        if (r0 == r1) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0075, code lost:
    
        r6 = java.util.Arrays.copyOf(r6, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
    
        return java.util.Collections.unmodifiableList(java.util.Arrays.asList(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008a, code lost:
    
        if (r6[r0].equals(r6[r1]) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008c, code lost:
    
        r4 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 + 17;
        zipkin2.Span.getErrorConfigVersion = r4 % 128;
        r4 = r4 % 2;
        r1 = r1 + 1;
        r6[r1] = r6[r0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009c, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static <T extends java.lang.Comparable<? super T>> java.util.List<T> sortedList(@zipkin2.internal.Nullable java.util.List<T> r6) {
        /*
            int r0 = zipkin2.Span.getErrorConfigVersion     // Catch: java.lang.Exception -> La3
            int r0 = r0 + 61
            int r1 = r0 % 128
            zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1     // Catch: java.lang.Exception -> La1
            int r0 = r0 % 2
            r1 = 35
            if (r0 != 0) goto L11
            r0 = 35
            goto L13
        L11:
            r0 = 18
        L13:
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L23
            r0 = 25
            if (r6 == 0) goto L1e
            r1 = 54
            goto L20
        L1e:
            r1 = 25
        L20:
            if (r1 == r0) goto L39
            goto L2e
        L23:
            r0 = 69
            int r0 = r0 / r2
            if (r6 == 0) goto L2a
            r0 = 1
            goto L2b
        L2a:
            r0 = 0
        L2b:
            if (r0 == r3) goto L2e
            goto L39
        L2e:
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L36
            r0 = 0
            goto L37
        L36:
            r0 = 1
        L37:
            if (r0 == 0) goto L3e
        L39:
            java.util.List r6 = java.util.Collections.emptyList()
            return r6
        L3e:
            int r0 = zipkin2.Span.getErrorConfigVersion
            int r0 = r0 + 85
            int r1 = r0 % 128
            zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            int r0 = r0 % 2
            int r0 = r6.size()
            if (r0 != r3) goto L61
            int r0 = zipkin2.Span.getErrorConfigVersion     // Catch: java.lang.Exception -> La3
            int r0 = r0 + 83
            int r1 = r0 % 128
            zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1     // Catch: java.lang.Exception -> La3
            int r0 = r0 % 2
            java.lang.Object r6 = r6.get(r2)
            java.util.List r6 = java.util.Collections.singletonList(r6)
            return r6
        L61:
            java.lang.Object[] r6 = r6.toArray()
            java.util.Arrays.sort(r6)
            r0 = 1
            r1 = 0
        L6a:
            int r4 = r6.length
            if (r0 >= r4) goto L6f
            r4 = 1
            goto L70
        L6f:
            r4 = 0
        L70:
            if (r4 == r3) goto L82
            int r1 = r1 + r3
            if (r0 == r1) goto L79
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r1)
        L79:
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch: java.lang.Exception -> La1
            java.util.List r6 = java.util.Collections.unmodifiableList(r6)     // Catch: java.lang.Exception -> La1
            return r6
        L82:
            r4 = r6[r0]
            r5 = r6[r1]
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L9c
            int r4 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r4 = r4 + 17
            int r5 = r4 % 128
            zipkin2.Span.getErrorConfigVersion = r5
            int r4 = r4 % 2
            int r1 = r1 + 1
            r4 = r6[r0]
            r6[r1] = r4
        L9c:
            int r0 = r0 + 1
            goto L6a
        L9f:
            r6 = move-exception
            throw r6
        La1:
            r6 = move-exception
            throw r6
        La3:
            r6 = move-exception
            goto La6
        La5:
            throw r6
        La6:
            goto La5
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.Span.sortedList(java.util.List):java.util.List");
    }

    Span(Builder builder) {
        String str;
        Map<String, String> emptyMap;
        this.traceId = builder.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Object obj = null;
        if (!builder.PlaceComponentResult.equals(builder.moveToNextValue)) {
            try {
                str = builder.moveToNextValue;
            } catch (Exception e) {
                throw e;
            }
        } else {
            int i = getErrorConfigVersion + 53;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            str = null;
        }
        this.parentId = str;
        this.f8270id = builder.PlaceComponentResult;
        this.kind = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        this.name = builder.scheduleImpl;
        this.timestamp = builder.NetworkUserEntityData$$ExternalSyntheticLambda1;
        this.duration = builder.getAuthRequestContext;
        this.localEndpoint = builder.getErrorConfigVersion;
        this.remoteEndpoint = builder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.annotations = sortedList(builder.MyBillsEntityDataFactory);
        if ((builder.lookAheadTest == null ? 'L' : (char) 2) != 2) {
            try {
                int i3 = getErrorConfigVersion + 87;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                if (i3 % 2 != 0) {
                    emptyMap = Collections.emptyMap();
                } else {
                    emptyMap = Collections.emptyMap();
                    obj.hashCode();
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            emptyMap = new LinkedHashMap<>(builder.lookAheadTest);
        }
        this.tags = emptyMap;
        this.flags = builder.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x00fc, code lost:
    
        r5.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x00ff, code lost:
    
        if (r1 != null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0106, code lost:
    
        if (r11.localEndpoint != null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x010f, code lost:
    
        if (r1.equals(r11.localEndpoint) == false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0111, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0113, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0114, code lost:
    
        if (r1 == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0116, code lost:
    
        r1 = r10.remoteEndpoint;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0118, code lost:
    
        if (r1 != null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x011c, code lost:
    
        if (r11.remoteEndpoint != null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0125, code lost:
    
        if (r1.equals(r11.remoteEndpoint) == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x012f, code lost:
    
        if (r10.annotations.equals(r11.annotations) == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0139, code lost:
    
        if (r10.tags.equals(r11.tags) == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0141, code lost:
    
        if (r10.flags == r11.flags) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0143, code lost:
    
        r11 = '^';
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0146, code lost:
    
        r11 = 'X';
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0148, code lost:
    
        if (r11 == '^') goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x014b, code lost:
    
        throw r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        if (r11.parentId == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        if ((r1.equals(r11.parentId)) != true) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0049, code lost:
    
        if (r10.f8270id.equals(r11.f8270id) == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
    
        r1 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
        zipkin2.Span.getErrorConfigVersion = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
    
        if ((r1 % 2) == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0056, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0059, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005c, code lost:
    
        if (r1 == true) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
    
        r1 = r10.kind;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0060, code lost:
    
        r6 = r5.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0061, code lost:
    
        if (r1 != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0063, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0065, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0066, code lost:
    
        if (r6 == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006b, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006e, code lost:
    
        r1 = r10.kind;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0070, code lost:
    
        if (r1 != null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0072, code lost:
    
        r6 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0075, code lost:
    
        r6 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0076, code lost:
    
        if (r6 == 2) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x007a, code lost:
    
        if (r11.kind != null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0083, code lost:
    
        if (r1.equals(r11.kind) == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0085, code lost:
    
        r1 = r10.name;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0087, code lost:
    
        if (r1 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x008b, code lost:
    
        r1 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 + 33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x008f, code lost:
    
        zipkin2.Span.getErrorConfigVersion = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0092, code lost:
    
        if ((r1 % 2) == 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0094, code lost:
    
        r1 = r11.name;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0096, code lost:
    
        r5.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0099, code lost:
    
        if (r1 != null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a0, code lost:
    
        if (r11.name != null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00a2, code lost:
    
        r1 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 + 5;
        zipkin2.Span.getErrorConfigVersion = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ac, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ad, code lost:
    
        throw r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00b4, code lost:
    
        if (r1.equals(r11.name) == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00bc, code lost:
    
        if (r10.timestamp != r11.timestamp) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00be, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00c0, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00c1, code lost:
    
        if (r1 == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00c3, code lost:
    
        r1 = zipkin2.Span.getErrorConfigVersion + 41;
        zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00cc, code lost:
    
        if ((r1 % 2) != 0) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00d4, code lost:
    
        r4 = 20 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00d7, code lost:
    
        if (r10.duration != r11.duration) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00d9, code lost:
    
        r1 = 'P';
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00dc, code lost:
    
        r1 = 'D';
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x00de, code lost:
    
        if (r1 == 'D') goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00e9, code lost:
    
        if (r10.duration != r11.duration) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x00eb, code lost:
    
        r1 = r10.localEndpoint;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00ed, code lost:
    
        if (r1 != null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00ef, code lost:
    
        r1 = zipkin2.Span.NetworkUserEntityData$$ExternalSyntheticLambda0 + 41;
        zipkin2.Span.getErrorConfigVersion = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00f8, code lost:
    
        if ((r1 % 2) == 0) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00fa, code lost:
    
        r1 = r11.localEndpoint;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.Span.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int hashCode;
        int i;
        int hashCode2 = this.traceId.hashCode();
        String str = this.parentId;
        int i2 = 0;
        if ((str == null ? '%' : JSONLexer.EOI) != 26) {
            int i3 = getErrorConfigVersion + 17;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 55;
            getErrorConfigVersion = i5 % 128;
            int i6 = i5 % 2;
        }
        int hashCode3 = this.f8270id.hashCode();
        Kind kind = this.kind;
        int hashCode4 = (kind == null ? 'U' : '\\') != '\\' ? 0 : kind.hashCode();
        String str2 = this.name;
        if (str2 != null) {
            i = str2.hashCode();
        } else {
            int i7 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 99;
            getErrorConfigVersion = i7 % 128;
            int i8 = i7 % 2;
            i = 0;
        }
        int i9 = (((((((((hashCode2 ^ 1000003) * 1000003) ^ hashCode) * 1000003) ^ hashCode3) * 1000003) ^ hashCode4) * 1000003) ^ i) * 1000003;
        long j = this.timestamp;
        int i10 = (i9 ^ ((int) (i9 ^ (j ^ (j >>> 32))))) * 1000003;
        long j2 = this.duration;
        int i11 = (int) (i10 ^ (j2 ^ (j2 >>> 32)));
        Endpoint endpoint = this.localEndpoint;
        int hashCode5 = endpoint == null ? 0 : endpoint.hashCode();
        Endpoint endpoint2 = this.remoteEndpoint;
        if (endpoint2 != null) {
            i2 = endpoint2.hashCode();
        } else {
            int i12 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 39;
            getErrorConfigVersion = i12 % 128;
            int i13 = i12 % 2;
        }
        return ((((((((((i10 ^ i11) * 1000003) ^ hashCode5) * 1000003) ^ i2) * 1000003) ^ this.annotations.hashCode()) * 1000003) ^ this.tags.hashCode()) * 1000003) ^ this.flags;
    }

    final Object writeReplace() throws ObjectStreamException {
        SerializedForm serializedForm = new SerializedForm(SpanBytesEncoder.PROTO3.encode(this));
        int i = getErrorConfigVersion + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 78 / 0;
            return serializedForm;
        }
        return serializedForm;
    }

    /* loaded from: classes9.dex */
    static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final byte[] bytes;

        SerializedForm(byte[] bArr) {
            this.bytes = bArr;
        }

        final Object readResolve() throws ObjectStreamException {
            try {
                return SpanBytesDecoder.PROTO3.decodeOne(this.bytes);
            } catch (IllegalArgumentException e) {
                throw new StreamCorruptedException(e.getMessage());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        if (r2 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        if ((r2 != null ? 'X' : 'c') != 'X') goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        r8 = r2.length;
        r9 = new byte[r8];
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
    
        if (r10 >= r8) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
    
        r11 = zipkin2.Span.$10 + 119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
    
        zipkin2.Span.$11 = r11 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
    
        r11 = r11 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        r9[r10] = (byte) (r2[r10] ^ 3097486228508854431L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0066, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0069, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
    
        if (r2 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006e, code lost:
    
        r2 = kotlin.text.Typography.amp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0071, code lost:
    
        r2 = 'B';
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0073, code lost:
    
        if (r2 == 'B') goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
    
        r2 = (byte) (((byte) (zipkin2.Span.KClassImpl$Data$declaredNonStaticMembers$2[r13 + ((int) (zipkin2.Span.BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (zipkin2.Span.MyBillsEntityDataFactory ^ 3097486228508854431L)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        r2 = (short) (((short) (zipkin2.Span.getAuthRequestContext[r13 + ((int) (zipkin2.Span.BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (zipkin2.Span.MyBillsEntityDataFactory ^ 3097486228508854431L)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r13, int r14, short r15, int r16, byte r17, java.lang.Object[] r18) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: zipkin2.Span.a(int, int, short, int, byte, java.lang.Object[]):void");
    }
}
