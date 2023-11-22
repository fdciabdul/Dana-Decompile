package zipkin2.v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import zipkin2.Endpoint;
import zipkin2.internal.HexCodec;
import zipkin2.internal.Nullable;

@Deprecated
/* loaded from: classes6.dex */
public final class V1Span {
    static final Endpoint BuiltInFictitiousFunctionClassFactory = new Endpoint(Endpoint.newBuilder());
    public final long GetContactSyncConfig;
    public final long KClassImpl$Data$declaredNonStaticMembers$2;
    public final List<V1BinaryAnnotation> MyBillsEntityDataFactory;
    public final long NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final Boolean PlaceComponentResult;
    public final List<V1Annotation> getAuthRequestContext;
    public final long getErrorConfigVersion;
    public final String lookAheadTest;
    public final long moveToNextValue;
    public final long scheduleImpl;

    public V1Span(Builder builder) {
        List<V1Annotation> unmodifiableList;
        List<V1BinaryAnnotation> unmodifiableList2;
        if (builder.getErrorConfigVersion == 0) {
            throw new IllegalArgumentException("traceId == 0");
        }
        if (builder.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
            throw new IllegalArgumentException("id == 0");
        }
        this.scheduleImpl = builder.getErrorConfigVersion;
        this.GetContactSyncConfig = builder.lookAheadTest;
        this.lookAheadTest = builder.scheduleImpl;
        this.moveToNextValue = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        this.getErrorConfigVersion = builder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = builder.moveToNextValue;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.MyBillsEntityDataFactory;
        ArrayList<V1Annotation> arrayList = builder.BuiltInFictitiousFunctionClassFactory;
        if (arrayList == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            Collections.sort(arrayList);
            unmodifiableList = Collections.unmodifiableList(new ArrayList(arrayList));
        }
        this.getAuthRequestContext = unmodifiableList;
        ArrayList<V1BinaryAnnotation> arrayList2 = builder.getAuthRequestContext;
        if (arrayList2 == null) {
            unmodifiableList2 = Collections.emptyList();
        } else {
            Collections.sort(arrayList2);
            unmodifiableList2 = Collections.unmodifiableList(new ArrayList(arrayList2));
        }
        this.MyBillsEntityDataFactory = unmodifiableList2;
        this.PlaceComponentResult = builder.PlaceComponentResult;
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder();
    }

    /* loaded from: classes6.dex */
    public static final class Builder {
        ArrayList<V1Annotation> BuiltInFictitiousFunctionClassFactory;
        public long KClassImpl$Data$declaredNonStaticMembers$2;
        public long MyBillsEntityDataFactory;
        public long NetworkUserEntityData$$ExternalSyntheticLambda0;
        public Boolean PlaceComponentResult;
        ArrayList<V1BinaryAnnotation> getAuthRequestContext;
        public long getErrorConfigVersion;
        public long lookAheadTest;
        public long moveToNextValue;
        public String scheduleImpl;

        Builder() {
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2() {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0L;
            this.lookAheadTest = 0L;
            this.getErrorConfigVersion = 0L;
            this.scheduleImpl = null;
            this.MyBillsEntityDataFactory = 0L;
            this.moveToNextValue = 0L;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0L;
            ArrayList<V1Annotation> arrayList = this.BuiltInFictitiousFunctionClassFactory;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList<V1BinaryAnnotation> arrayList2 = this.getAuthRequestContext;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            this.PlaceComponentResult = null;
            return this;
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(String str) {
            if (str == null) {
                throw new NullPointerException("traceId == null");
            }
            if (str.length() == 32) {
                this.lookAheadTest = HexCodec.MyBillsEntityDataFactory(str, 0);
            }
            this.getErrorConfigVersion = HexCodec.BuiltInFictitiousFunctionClassFactory(str);
            return this;
        }

        public final Builder MyBillsEntityDataFactory(long j, String str, @Nullable Endpoint endpoint) {
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                this.BuiltInFictitiousFunctionClassFactory = new ArrayList<>(4);
            }
            if (V1Span.BuiltInFictitiousFunctionClassFactory.equals(endpoint)) {
                endpoint = null;
            }
            this.BuiltInFictitiousFunctionClassFactory.add(new V1Annotation(j, str, endpoint));
            return this;
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(String str, Endpoint endpoint) {
            if (endpoint != null && !V1Span.BuiltInFictitiousFunctionClassFactory.equals(endpoint)) {
                if (this.getAuthRequestContext == null) {
                    this.getAuthRequestContext = new ArrayList<>(4);
                }
                this.getAuthRequestContext.add(new V1BinaryAnnotation(str, null, endpoint));
            }
            return this;
        }

        public final Builder getAuthRequestContext(String str, String str2, Endpoint endpoint) {
            if (str2 == null) {
                throw new NullPointerException("value == null");
            }
            if (V1Span.BuiltInFictitiousFunctionClassFactory.equals(endpoint)) {
                endpoint = null;
            }
            if (this.getAuthRequestContext == null) {
                this.getAuthRequestContext = new ArrayList<>(4);
            }
            this.getAuthRequestContext.add(new V1BinaryAnnotation(str, str2, endpoint));
            return this;
        }
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof V1Span) {
            V1Span v1Span = (V1Span) obj;
            if (this.GetContactSyncConfig == v1Span.GetContactSyncConfig && this.scheduleImpl == v1Span.scheduleImpl && ((str = this.lookAheadTest) != null ? str.equals(v1Span.lookAheadTest) : v1Span.lookAheadTest == null) && this.moveToNextValue == v1Span.moveToNextValue && this.getErrorConfigVersion == v1Span.getErrorConfigVersion && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == v1Span.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.KClassImpl$Data$declaredNonStaticMembers$2 == v1Span.KClassImpl$Data$declaredNonStaticMembers$2 && this.getAuthRequestContext.equals(v1Span.getAuthRequestContext) && this.MyBillsEntityDataFactory.equals(v1Span.MyBillsEntityDataFactory)) {
                Boolean bool = this.PlaceComponentResult;
                Boolean bool2 = v1Span.PlaceComponentResult;
                if (bool == null) {
                    if (bool2 == null) {
                        return true;
                    }
                } else if (bool.equals(bool2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.GetContactSyncConfig;
        int i = (((int) ((j ^ (j >>> 32)) ^ 1000003)) ^ 1000003) * 1000003;
        long j2 = this.scheduleImpl;
        int i2 = (int) (i ^ (j2 ^ (j2 >>> 32)));
        String str = this.lookAheadTest;
        int hashCode = (((i ^ i2) * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j3 = this.moveToNextValue;
        int i3 = (hashCode ^ ((int) (hashCode ^ (j3 ^ (j3 >>> 32))))) * 1000003;
        long j4 = this.getErrorConfigVersion;
        int i4 = (i3 ^ ((int) (i3 ^ (j4 ^ (j4 >>> 32))))) * 1000003;
        long j5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i5 = (i4 ^ ((int) (i4 ^ (j5 ^ (j5 >>> 32))))) * 1000003;
        long j6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i6 = (int) (i5 ^ (j6 ^ (j6 >>> 32)));
        int hashCode2 = this.getAuthRequestContext.hashCode();
        int hashCode3 = this.MyBillsEntityDataFactory.hashCode();
        Boolean bool = this.PlaceComponentResult;
        return ((((((i5 ^ i6) * 1000003) ^ hashCode2) * 1000003) ^ hashCode3) * 1000003) ^ (bool != null ? bool.hashCode() : 0);
    }
}
