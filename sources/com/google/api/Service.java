package com.google.api;

import com.google.api.Authentication;
import com.google.api.Backend;
import com.google.api.Billing;
import com.google.api.Context;
import com.google.api.Control;
import com.google.api.Documentation;
import com.google.api.Endpoint;
import com.google.api.Http;
import com.google.api.LogDescriptor;
import com.google.api.Logging;
import com.google.api.MetricDescriptor;
import com.google.api.MonitoredResourceDescriptor;
import com.google.api.Monitoring;
import com.google.api.Quota;
import com.google.api.SourceInfo;
import com.google.api.SystemParameters;
import com.google.api.Usage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Api;
import com.google.protobuf.ApiOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Enum;
import com.google.protobuf.EnumOrBuilder;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Type;
import com.google.protobuf.TypeOrBuilder;
import com.google.protobuf.UInt32Value;
import com.iap.ac.android.acs.plugin.utils.AuthCodeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public final class Service extends GeneratedMessageLite<Service, Builder> implements ServiceOrBuilder {
    public static final int APIS_FIELD_NUMBER = 3;
    public static final int AUTHENTICATION_FIELD_NUMBER = 11;
    public static final int BACKEND_FIELD_NUMBER = 8;
    public static final int BILLING_FIELD_NUMBER = 26;
    public static final int CONFIG_VERSION_FIELD_NUMBER = 20;
    public static final int CONTEXT_FIELD_NUMBER = 12;
    public static final int CONTROL_FIELD_NUMBER = 21;
    private static final Service DEFAULT_INSTANCE;
    public static final int DOCUMENTATION_FIELD_NUMBER = 6;
    public static final int ENDPOINTS_FIELD_NUMBER = 18;
    public static final int ENUMS_FIELD_NUMBER = 5;
    public static final int HTTP_FIELD_NUMBER = 9;
    public static final int ID_FIELD_NUMBER = 33;
    public static final int LOGGING_FIELD_NUMBER = 27;
    public static final int LOGS_FIELD_NUMBER = 23;
    public static final int METRICS_FIELD_NUMBER = 24;
    public static final int MONITORED_RESOURCES_FIELD_NUMBER = 25;
    public static final int MONITORING_FIELD_NUMBER = 28;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Service> PARSER = null;
    public static final int PRODUCER_PROJECT_ID_FIELD_NUMBER = 22;
    public static final int QUOTA_FIELD_NUMBER = 10;
    public static final int SOURCE_INFO_FIELD_NUMBER = 37;
    public static final int SYSTEM_PARAMETERS_FIELD_NUMBER = 29;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int TYPES_FIELD_NUMBER = 4;
    public static final int USAGE_FIELD_NUMBER = 15;
    private Authentication authentication_;
    private Backend backend_;
    private Billing billing_;
    private UInt32Value configVersion_;
    private Context context_;
    private Control control_;
    private Documentation documentation_;
    private Http http_;
    private Logging logging_;
    private Monitoring monitoring_;
    private Quota quota_;
    private SourceInfo sourceInfo_;
    private SystemParameters systemParameters_;
    private Usage usage_;
    private String name_ = "";
    private String id_ = "";
    private String title_ = "";
    private String producerProjectId_ = "";
    private Internal.ProtobufList<Api> apis_ = emptyProtobufList();
    private Internal.ProtobufList<Type> types_ = emptyProtobufList();
    private Internal.ProtobufList<Enum> enums_ = emptyProtobufList();
    private Internal.ProtobufList<Endpoint> endpoints_ = emptyProtobufList();
    private Internal.ProtobufList<LogDescriptor> logs_ = emptyProtobufList();
    private Internal.ProtobufList<MetricDescriptor> metrics_ = emptyProtobufList();
    private Internal.ProtobufList<MonitoredResourceDescriptor> monitoredResources_ = emptyProtobufList();

    private Service() {
    }

    @Override // com.google.api.ServiceOrBuilder
    public final boolean hasConfigVersion() {
        return this.configVersion_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final UInt32Value getConfigVersion() {
        UInt32Value uInt32Value = this.configVersion_;
        return uInt32Value == null ? UInt32Value.getDefaultInstance() : uInt32Value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConfigVersion(UInt32Value uInt32Value) {
        this.configVersion_ = uInt32Value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeConfigVersion(UInt32Value uInt32Value) {
        UInt32Value uInt32Value2 = this.configVersion_;
        if (uInt32Value2 != null && uInt32Value2 != UInt32Value.getDefaultInstance()) {
            this.configVersion_ = UInt32Value.newBuilder(this.configVersion_).mergeFrom((UInt32Value.Builder) uInt32Value).buildPartial();
        } else {
            this.configVersion_ = uInt32Value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConfigVersion() {
        this.configVersion_ = null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.ServiceOrBuilder
    public final String getId() {
        return this.id_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.id_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.ServiceOrBuilder
    public final String getTitle() {
        return this.title_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final ByteString getTitleBytes() {
        return ByteString.copyFromUtf8(this.title_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitle(String str) {
        this.title_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTitle() {
        this.title_ = getDefaultInstance().getTitle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTitleBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.title_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.ServiceOrBuilder
    public final String getProducerProjectId() {
        return this.producerProjectId_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final ByteString getProducerProjectIdBytes() {
        return ByteString.copyFromUtf8(this.producerProjectId_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProducerProjectId(String str) {
        this.producerProjectId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProducerProjectId() {
        this.producerProjectId_ = getDefaultInstance().getProducerProjectId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProducerProjectIdBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.producerProjectId_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.ServiceOrBuilder
    public final List<Api> getApisList() {
        return this.apis_;
    }

    public final List<? extends ApiOrBuilder> getApisOrBuilderList() {
        return this.apis_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final int getApisCount() {
        return this.apis_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Api getApis(int i) {
        return this.apis_.get(i);
    }

    public final ApiOrBuilder getApisOrBuilder(int i) {
        return this.apis_.get(i);
    }

    private void ensureApisIsMutable() {
        Internal.ProtobufList<Api> protobufList = this.apis_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.apis_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setApis(int i, Api api) {
        ensureApisIsMutable();
        this.apis_.set(i, api);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addApis(Api api) {
        ensureApisIsMutable();
        this.apis_.add(api);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addApis(int i, Api api) {
        ensureApisIsMutable();
        this.apis_.add(i, api);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllApis(Iterable<? extends Api> iterable) {
        ensureApisIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.apis_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearApis() {
        this.apis_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeApis(int i) {
        ensureApisIsMutable();
        this.apis_.remove(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public final List<Type> getTypesList() {
        return this.types_;
    }

    public final List<? extends TypeOrBuilder> getTypesOrBuilderList() {
        return this.types_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final int getTypesCount() {
        return this.types_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Type getTypes(int i) {
        return this.types_.get(i);
    }

    public final TypeOrBuilder getTypesOrBuilder(int i) {
        return this.types_.get(i);
    }

    private void ensureTypesIsMutable() {
        Internal.ProtobufList<Type> protobufList = this.types_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.types_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypes(int i, Type type) {
        ensureTypesIsMutable();
        this.types_.set(i, type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTypes(Type type) {
        ensureTypesIsMutable();
        this.types_.add(type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTypes(int i, Type type) {
        ensureTypesIsMutable();
        this.types_.add(i, type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllTypes(Iterable<? extends Type> iterable) {
        ensureTypesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.types_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTypes() {
        this.types_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTypes(int i) {
        ensureTypesIsMutable();
        this.types_.remove(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public final List<Enum> getEnumsList() {
        return this.enums_;
    }

    public final List<? extends EnumOrBuilder> getEnumsOrBuilderList() {
        return this.enums_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final int getEnumsCount() {
        return this.enums_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Enum getEnums(int i) {
        return this.enums_.get(i);
    }

    public final EnumOrBuilder getEnumsOrBuilder(int i) {
        return this.enums_.get(i);
    }

    private void ensureEnumsIsMutable() {
        Internal.ProtobufList<Enum> protobufList = this.enums_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.enums_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnums(int i, Enum r3) {
        ensureEnumsIsMutable();
        this.enums_.set(i, r3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnums(Enum r2) {
        ensureEnumsIsMutable();
        this.enums_.add(r2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnums(int i, Enum r3) {
        ensureEnumsIsMutable();
        this.enums_.add(i, r3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEnums(Iterable<? extends Enum> iterable) {
        ensureEnumsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.enums_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEnums() {
        this.enums_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeEnums(int i) {
        ensureEnumsIsMutable();
        this.enums_.remove(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public final boolean hasDocumentation() {
        return this.documentation_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Documentation getDocumentation() {
        Documentation documentation = this.documentation_;
        return documentation == null ? Documentation.getDefaultInstance() : documentation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentation(Documentation documentation) {
        this.documentation_ = documentation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDocumentation(Documentation documentation) {
        Documentation documentation2 = this.documentation_;
        if (documentation2 != null && documentation2 != Documentation.getDefaultInstance()) {
            this.documentation_ = Documentation.newBuilder(this.documentation_).mergeFrom((Documentation.Builder) documentation).buildPartial();
        } else {
            this.documentation_ = documentation;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocumentation() {
        this.documentation_ = null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final boolean hasBackend() {
        return this.backend_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Backend getBackend() {
        Backend backend = this.backend_;
        return backend == null ? Backend.getDefaultInstance() : backend;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackend(Backend backend) {
        this.backend_ = backend;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeBackend(Backend backend) {
        Backend backend2 = this.backend_;
        if (backend2 != null && backend2 != Backend.getDefaultInstance()) {
            this.backend_ = Backend.newBuilder(this.backend_).mergeFrom((Backend.Builder) backend).buildPartial();
        } else {
            this.backend_ = backend;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBackend() {
        this.backend_ = null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final boolean hasHttp() {
        return this.http_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Http getHttp() {
        Http http = this.http_;
        return http == null ? Http.getDefaultInstance() : http;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHttp(Http http) {
        this.http_ = http;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeHttp(Http http) {
        Http http2 = this.http_;
        if (http2 != null && http2 != Http.getDefaultInstance()) {
            this.http_ = Http.newBuilder(this.http_).mergeFrom((Http.Builder) http).buildPartial();
        } else {
            this.http_ = http;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHttp() {
        this.http_ = null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final boolean hasQuota() {
        return this.quota_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Quota getQuota() {
        Quota quota = this.quota_;
        return quota == null ? Quota.getDefaultInstance() : quota;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuota(Quota quota) {
        this.quota_ = quota;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeQuota(Quota quota) {
        Quota quota2 = this.quota_;
        if (quota2 != null && quota2 != Quota.getDefaultInstance()) {
            this.quota_ = Quota.newBuilder(this.quota_).mergeFrom((Quota.Builder) quota).buildPartial();
        } else {
            this.quota_ = quota;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQuota() {
        this.quota_ = null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final boolean hasAuthentication() {
        return this.authentication_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Authentication getAuthentication() {
        Authentication authentication = this.authentication_;
        return authentication == null ? Authentication.getDefaultInstance() : authentication;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthentication(Authentication authentication) {
        this.authentication_ = authentication;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAuthentication(Authentication authentication) {
        Authentication authentication2 = this.authentication_;
        if (authentication2 != null && authentication2 != Authentication.getDefaultInstance()) {
            this.authentication_ = Authentication.newBuilder(this.authentication_).mergeFrom((Authentication.Builder) authentication).buildPartial();
        } else {
            this.authentication_ = authentication;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthentication() {
        this.authentication_ = null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final boolean hasContext() {
        return this.context_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Context getContext() {
        Context context = this.context_;
        return context == null ? Context.getDefaultInstance() : context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContext(Context context) {
        this.context_ = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeContext(Context context) {
        Context context2 = this.context_;
        if (context2 != null && context2 != Context.getDefaultInstance()) {
            this.context_ = Context.newBuilder(this.context_).mergeFrom((Context.Builder) context).buildPartial();
        } else {
            this.context_ = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContext() {
        this.context_ = null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final boolean hasUsage() {
        return this.usage_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Usage getUsage() {
        Usage usage = this.usage_;
        return usage == null ? Usage.getDefaultInstance() : usage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUsage(Usage usage) {
        this.usage_ = usage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeUsage(Usage usage) {
        Usage usage2 = this.usage_;
        if (usage2 != null && usage2 != Usage.getDefaultInstance()) {
            this.usage_ = Usage.newBuilder(this.usage_).mergeFrom((Usage.Builder) usage).buildPartial();
        } else {
            this.usage_ = usage;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUsage() {
        this.usage_ = null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final List<Endpoint> getEndpointsList() {
        return this.endpoints_;
    }

    public final List<? extends EndpointOrBuilder> getEndpointsOrBuilderList() {
        return this.endpoints_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final int getEndpointsCount() {
        return this.endpoints_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Endpoint getEndpoints(int i) {
        return this.endpoints_.get(i);
    }

    public final EndpointOrBuilder getEndpointsOrBuilder(int i) {
        return this.endpoints_.get(i);
    }

    private void ensureEndpointsIsMutable() {
        Internal.ProtobufList<Endpoint> protobufList = this.endpoints_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.endpoints_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEndpoints(int i, Endpoint endpoint) {
        ensureEndpointsIsMutable();
        this.endpoints_.set(i, endpoint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEndpoints(Endpoint endpoint) {
        ensureEndpointsIsMutable();
        this.endpoints_.add(endpoint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEndpoints(int i, Endpoint endpoint) {
        ensureEndpointsIsMutable();
        this.endpoints_.add(i, endpoint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEndpoints(Iterable<? extends Endpoint> iterable) {
        ensureEndpointsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.endpoints_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEndpoints() {
        this.endpoints_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeEndpoints(int i) {
        ensureEndpointsIsMutable();
        this.endpoints_.remove(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public final boolean hasControl() {
        return this.control_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Control getControl() {
        Control control = this.control_;
        return control == null ? Control.getDefaultInstance() : control;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setControl(Control control) {
        this.control_ = control;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeControl(Control control) {
        Control control2 = this.control_;
        if (control2 != null && control2 != Control.getDefaultInstance()) {
            this.control_ = Control.newBuilder(this.control_).mergeFrom((Control.Builder) control).buildPartial();
        } else {
            this.control_ = control;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearControl() {
        this.control_ = null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final List<LogDescriptor> getLogsList() {
        return this.logs_;
    }

    public final List<? extends LogDescriptorOrBuilder> getLogsOrBuilderList() {
        return this.logs_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final int getLogsCount() {
        return this.logs_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public final LogDescriptor getLogs(int i) {
        return this.logs_.get(i);
    }

    public final LogDescriptorOrBuilder getLogsOrBuilder(int i) {
        return this.logs_.get(i);
    }

    private void ensureLogsIsMutable() {
        Internal.ProtobufList<LogDescriptor> protobufList = this.logs_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.logs_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLogs(int i, LogDescriptor logDescriptor) {
        ensureLogsIsMutable();
        this.logs_.set(i, logDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLogs(LogDescriptor logDescriptor) {
        ensureLogsIsMutable();
        this.logs_.add(logDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLogs(int i, LogDescriptor logDescriptor) {
        ensureLogsIsMutable();
        this.logs_.add(i, logDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLogs(Iterable<? extends LogDescriptor> iterable) {
        ensureLogsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.logs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLogs() {
        this.logs_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLogs(int i) {
        ensureLogsIsMutable();
        this.logs_.remove(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public final List<MetricDescriptor> getMetricsList() {
        return this.metrics_;
    }

    public final List<? extends MetricDescriptorOrBuilder> getMetricsOrBuilderList() {
        return this.metrics_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final int getMetricsCount() {
        return this.metrics_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public final MetricDescriptor getMetrics(int i) {
        return this.metrics_.get(i);
    }

    public final MetricDescriptorOrBuilder getMetricsOrBuilder(int i) {
        return this.metrics_.get(i);
    }

    private void ensureMetricsIsMutable() {
        Internal.ProtobufList<MetricDescriptor> protobufList = this.metrics_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.metrics_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetrics(int i, MetricDescriptor metricDescriptor) {
        ensureMetricsIsMutable();
        this.metrics_.set(i, metricDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMetrics(MetricDescriptor metricDescriptor) {
        ensureMetricsIsMutable();
        this.metrics_.add(metricDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMetrics(int i, MetricDescriptor metricDescriptor) {
        ensureMetricsIsMutable();
        this.metrics_.add(i, metricDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMetrics(Iterable<? extends MetricDescriptor> iterable) {
        ensureMetricsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.metrics_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetrics() {
        this.metrics_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMetrics(int i) {
        ensureMetricsIsMutable();
        this.metrics_.remove(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public final List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
        return this.monitoredResources_;
    }

    public final List<? extends MonitoredResourceDescriptorOrBuilder> getMonitoredResourcesOrBuilderList() {
        return this.monitoredResources_;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final int getMonitoredResourcesCount() {
        return this.monitoredResources_.size();
    }

    @Override // com.google.api.ServiceOrBuilder
    public final MonitoredResourceDescriptor getMonitoredResources(int i) {
        return this.monitoredResources_.get(i);
    }

    public final MonitoredResourceDescriptorOrBuilder getMonitoredResourcesOrBuilder(int i) {
        return this.monitoredResources_.get(i);
    }

    private void ensureMonitoredResourcesIsMutable() {
        Internal.ProtobufList<MonitoredResourceDescriptor> protobufList = this.monitoredResources_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.monitoredResources_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMonitoredResources(int i, MonitoredResourceDescriptor monitoredResourceDescriptor) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.set(i, monitoredResourceDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMonitoredResources(MonitoredResourceDescriptor monitoredResourceDescriptor) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.add(monitoredResourceDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMonitoredResources(int i, MonitoredResourceDescriptor monitoredResourceDescriptor) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.add(i, monitoredResourceDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMonitoredResources(Iterable<? extends MonitoredResourceDescriptor> iterable) {
        ensureMonitoredResourcesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.monitoredResources_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMonitoredResources() {
        this.monitoredResources_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMonitoredResources(int i) {
        ensureMonitoredResourcesIsMutable();
        this.monitoredResources_.remove(i);
    }

    @Override // com.google.api.ServiceOrBuilder
    public final boolean hasBilling() {
        return this.billing_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Billing getBilling() {
        Billing billing = this.billing_;
        return billing == null ? Billing.getDefaultInstance() : billing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBilling(Billing billing) {
        this.billing_ = billing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeBilling(Billing billing) {
        Billing billing2 = this.billing_;
        if (billing2 != null && billing2 != Billing.getDefaultInstance()) {
            this.billing_ = Billing.newBuilder(this.billing_).mergeFrom((Billing.Builder) billing).buildPartial();
        } else {
            this.billing_ = billing;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBilling() {
        this.billing_ = null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final boolean hasLogging() {
        return this.logging_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Logging getLogging() {
        Logging logging = this.logging_;
        return logging == null ? Logging.getDefaultInstance() : logging;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLogging(Logging logging) {
        this.logging_ = logging;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeLogging(Logging logging) {
        Logging logging2 = this.logging_;
        if (logging2 != null && logging2 != Logging.getDefaultInstance()) {
            this.logging_ = Logging.newBuilder(this.logging_).mergeFrom((Logging.Builder) logging).buildPartial();
        } else {
            this.logging_ = logging;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLogging() {
        this.logging_ = null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final boolean hasMonitoring() {
        return this.monitoring_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final Monitoring getMonitoring() {
        Monitoring monitoring = this.monitoring_;
        return monitoring == null ? Monitoring.getDefaultInstance() : monitoring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMonitoring(Monitoring monitoring) {
        this.monitoring_ = monitoring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMonitoring(Monitoring monitoring) {
        Monitoring monitoring2 = this.monitoring_;
        if (monitoring2 != null && monitoring2 != Monitoring.getDefaultInstance()) {
            this.monitoring_ = Monitoring.newBuilder(this.monitoring_).mergeFrom((Monitoring.Builder) monitoring).buildPartial();
        } else {
            this.monitoring_ = monitoring;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMonitoring() {
        this.monitoring_ = null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final boolean hasSystemParameters() {
        return this.systemParameters_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final SystemParameters getSystemParameters() {
        SystemParameters systemParameters = this.systemParameters_;
        return systemParameters == null ? SystemParameters.getDefaultInstance() : systemParameters;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemParameters(SystemParameters systemParameters) {
        this.systemParameters_ = systemParameters;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSystemParameters(SystemParameters systemParameters) {
        SystemParameters systemParameters2 = this.systemParameters_;
        if (systemParameters2 != null && systemParameters2 != SystemParameters.getDefaultInstance()) {
            this.systemParameters_ = SystemParameters.newBuilder(this.systemParameters_).mergeFrom((SystemParameters.Builder) systemParameters).buildPartial();
        } else {
            this.systemParameters_ = systemParameters;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSystemParameters() {
        this.systemParameters_ = null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final boolean hasSourceInfo() {
        return this.sourceInfo_ != null;
    }

    @Override // com.google.api.ServiceOrBuilder
    public final SourceInfo getSourceInfo() {
        SourceInfo sourceInfo = this.sourceInfo_;
        return sourceInfo == null ? SourceInfo.getDefaultInstance() : sourceInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceInfo(SourceInfo sourceInfo) {
        this.sourceInfo_ = sourceInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSourceInfo(SourceInfo sourceInfo) {
        SourceInfo sourceInfo2 = this.sourceInfo_;
        if (sourceInfo2 != null && sourceInfo2 != SourceInfo.getDefaultInstance()) {
            this.sourceInfo_ = SourceInfo.newBuilder(this.sourceInfo_).mergeFrom((SourceInfo.Builder) sourceInfo).buildPartial();
        } else {
            this.sourceInfo_ = sourceInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSourceInfo() {
        this.sourceInfo_ = null;
    }

    public static Service parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Service parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Service parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Service parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Service parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Service parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Service parseFrom(InputStream inputStream) throws IOException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Service parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Service parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Service) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Service parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Service) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Service parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Service parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Service) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Service service) {
        return DEFAULT_INSTANCE.createBuilder(service);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Service, Builder> implements ServiceOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(Service.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.ServiceOrBuilder
        public final boolean hasConfigVersion() {
            return ((Service) this.instance).hasConfigVersion();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final UInt32Value getConfigVersion() {
            return ((Service) this.instance).getConfigVersion();
        }

        public final Builder setConfigVersion(UInt32Value uInt32Value) {
            copyOnWrite();
            ((Service) this.instance).setConfigVersion(uInt32Value);
            return this;
        }

        public final Builder setConfigVersion(UInt32Value.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setConfigVersion(builder.build());
            return this;
        }

        public final Builder mergeConfigVersion(UInt32Value uInt32Value) {
            copyOnWrite();
            ((Service) this.instance).mergeConfigVersion(uInt32Value);
            return this;
        }

        public final Builder clearConfigVersion() {
            copyOnWrite();
            ((Service) this.instance).clearConfigVersion();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final String getName() {
            return ((Service) this.instance).getName();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final ByteString getNameBytes() {
            return ((Service) this.instance).getNameBytes();
        }

        public final Builder setName(String str) {
            copyOnWrite();
            ((Service) this.instance).setName(str);
            return this;
        }

        public final Builder clearName() {
            copyOnWrite();
            ((Service) this.instance).clearName();
            return this;
        }

        public final Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Service) this.instance).setNameBytes(byteString);
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final String getId() {
            return ((Service) this.instance).getId();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final ByteString getIdBytes() {
            return ((Service) this.instance).getIdBytes();
        }

        public final Builder setId(String str) {
            copyOnWrite();
            ((Service) this.instance).setId(str);
            return this;
        }

        public final Builder clearId() {
            copyOnWrite();
            ((Service) this.instance).clearId();
            return this;
        }

        public final Builder setIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Service) this.instance).setIdBytes(byteString);
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final String getTitle() {
            return ((Service) this.instance).getTitle();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final ByteString getTitleBytes() {
            return ((Service) this.instance).getTitleBytes();
        }

        public final Builder setTitle(String str) {
            copyOnWrite();
            ((Service) this.instance).setTitle(str);
            return this;
        }

        public final Builder clearTitle() {
            copyOnWrite();
            ((Service) this.instance).clearTitle();
            return this;
        }

        public final Builder setTitleBytes(ByteString byteString) {
            copyOnWrite();
            ((Service) this.instance).setTitleBytes(byteString);
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final String getProducerProjectId() {
            return ((Service) this.instance).getProducerProjectId();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final ByteString getProducerProjectIdBytes() {
            return ((Service) this.instance).getProducerProjectIdBytes();
        }

        public final Builder setProducerProjectId(String str) {
            copyOnWrite();
            ((Service) this.instance).setProducerProjectId(str);
            return this;
        }

        public final Builder clearProducerProjectId() {
            copyOnWrite();
            ((Service) this.instance).clearProducerProjectId();
            return this;
        }

        public final Builder setProducerProjectIdBytes(ByteString byteString) {
            copyOnWrite();
            ((Service) this.instance).setProducerProjectIdBytes(byteString);
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final List<Api> getApisList() {
            return Collections.unmodifiableList(((Service) this.instance).getApisList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public final int getApisCount() {
            return ((Service) this.instance).getApisCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Api getApis(int i) {
            return ((Service) this.instance).getApis(i);
        }

        public final Builder setApis(int i, Api api) {
            copyOnWrite();
            ((Service) this.instance).setApis(i, api);
            return this;
        }

        public final Builder setApis(int i, Api.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setApis(i, builder.build());
            return this;
        }

        public final Builder addApis(Api api) {
            copyOnWrite();
            ((Service) this.instance).addApis(api);
            return this;
        }

        public final Builder addApis(int i, Api api) {
            copyOnWrite();
            ((Service) this.instance).addApis(i, api);
            return this;
        }

        public final Builder addApis(Api.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).addApis(builder.build());
            return this;
        }

        public final Builder addApis(int i, Api.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).addApis(i, builder.build());
            return this;
        }

        public final Builder addAllApis(Iterable<? extends Api> iterable) {
            copyOnWrite();
            ((Service) this.instance).addAllApis(iterable);
            return this;
        }

        public final Builder clearApis() {
            copyOnWrite();
            ((Service) this.instance).clearApis();
            return this;
        }

        public final Builder removeApis(int i) {
            copyOnWrite();
            ((Service) this.instance).removeApis(i);
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final List<Type> getTypesList() {
            return Collections.unmodifiableList(((Service) this.instance).getTypesList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public final int getTypesCount() {
            return ((Service) this.instance).getTypesCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Type getTypes(int i) {
            return ((Service) this.instance).getTypes(i);
        }

        public final Builder setTypes(int i, Type type) {
            copyOnWrite();
            ((Service) this.instance).setTypes(i, type);
            return this;
        }

        public final Builder setTypes(int i, Type.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setTypes(i, builder.build());
            return this;
        }

        public final Builder addTypes(Type type) {
            copyOnWrite();
            ((Service) this.instance).addTypes(type);
            return this;
        }

        public final Builder addTypes(int i, Type type) {
            copyOnWrite();
            ((Service) this.instance).addTypes(i, type);
            return this;
        }

        public final Builder addTypes(Type.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).addTypes(builder.build());
            return this;
        }

        public final Builder addTypes(int i, Type.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).addTypes(i, builder.build());
            return this;
        }

        public final Builder addAllTypes(Iterable<? extends Type> iterable) {
            copyOnWrite();
            ((Service) this.instance).addAllTypes(iterable);
            return this;
        }

        public final Builder clearTypes() {
            copyOnWrite();
            ((Service) this.instance).clearTypes();
            return this;
        }

        public final Builder removeTypes(int i) {
            copyOnWrite();
            ((Service) this.instance).removeTypes(i);
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final List<Enum> getEnumsList() {
            return Collections.unmodifiableList(((Service) this.instance).getEnumsList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public final int getEnumsCount() {
            return ((Service) this.instance).getEnumsCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Enum getEnums(int i) {
            return ((Service) this.instance).getEnums(i);
        }

        public final Builder setEnums(int i, Enum r3) {
            copyOnWrite();
            ((Service) this.instance).setEnums(i, r3);
            return this;
        }

        public final Builder setEnums(int i, Enum.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setEnums(i, builder.build());
            return this;
        }

        public final Builder addEnums(Enum r2) {
            copyOnWrite();
            ((Service) this.instance).addEnums(r2);
            return this;
        }

        public final Builder addEnums(int i, Enum r3) {
            copyOnWrite();
            ((Service) this.instance).addEnums(i, r3);
            return this;
        }

        public final Builder addEnums(Enum.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).addEnums(builder.build());
            return this;
        }

        public final Builder addEnums(int i, Enum.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).addEnums(i, builder.build());
            return this;
        }

        public final Builder addAllEnums(Iterable<? extends Enum> iterable) {
            copyOnWrite();
            ((Service) this.instance).addAllEnums(iterable);
            return this;
        }

        public final Builder clearEnums() {
            copyOnWrite();
            ((Service) this.instance).clearEnums();
            return this;
        }

        public final Builder removeEnums(int i) {
            copyOnWrite();
            ((Service) this.instance).removeEnums(i);
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final boolean hasDocumentation() {
            return ((Service) this.instance).hasDocumentation();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Documentation getDocumentation() {
            return ((Service) this.instance).getDocumentation();
        }

        public final Builder setDocumentation(Documentation documentation) {
            copyOnWrite();
            ((Service) this.instance).setDocumentation(documentation);
            return this;
        }

        public final Builder setDocumentation(Documentation.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setDocumentation(builder.build());
            return this;
        }

        public final Builder mergeDocumentation(Documentation documentation) {
            copyOnWrite();
            ((Service) this.instance).mergeDocumentation(documentation);
            return this;
        }

        public final Builder clearDocumentation() {
            copyOnWrite();
            ((Service) this.instance).clearDocumentation();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final boolean hasBackend() {
            return ((Service) this.instance).hasBackend();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Backend getBackend() {
            return ((Service) this.instance).getBackend();
        }

        public final Builder setBackend(Backend backend) {
            copyOnWrite();
            ((Service) this.instance).setBackend(backend);
            return this;
        }

        public final Builder setBackend(Backend.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setBackend(builder.build());
            return this;
        }

        public final Builder mergeBackend(Backend backend) {
            copyOnWrite();
            ((Service) this.instance).mergeBackend(backend);
            return this;
        }

        public final Builder clearBackend() {
            copyOnWrite();
            ((Service) this.instance).clearBackend();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final boolean hasHttp() {
            return ((Service) this.instance).hasHttp();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Http getHttp() {
            return ((Service) this.instance).getHttp();
        }

        public final Builder setHttp(Http http) {
            copyOnWrite();
            ((Service) this.instance).setHttp(http);
            return this;
        }

        public final Builder setHttp(Http.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setHttp(builder.build());
            return this;
        }

        public final Builder mergeHttp(Http http) {
            copyOnWrite();
            ((Service) this.instance).mergeHttp(http);
            return this;
        }

        public final Builder clearHttp() {
            copyOnWrite();
            ((Service) this.instance).clearHttp();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final boolean hasQuota() {
            return ((Service) this.instance).hasQuota();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Quota getQuota() {
            return ((Service) this.instance).getQuota();
        }

        public final Builder setQuota(Quota quota) {
            copyOnWrite();
            ((Service) this.instance).setQuota(quota);
            return this;
        }

        public final Builder setQuota(Quota.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setQuota(builder.build());
            return this;
        }

        public final Builder mergeQuota(Quota quota) {
            copyOnWrite();
            ((Service) this.instance).mergeQuota(quota);
            return this;
        }

        public final Builder clearQuota() {
            copyOnWrite();
            ((Service) this.instance).clearQuota();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final boolean hasAuthentication() {
            return ((Service) this.instance).hasAuthentication();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Authentication getAuthentication() {
            return ((Service) this.instance).getAuthentication();
        }

        public final Builder setAuthentication(Authentication authentication) {
            copyOnWrite();
            ((Service) this.instance).setAuthentication(authentication);
            return this;
        }

        public final Builder setAuthentication(Authentication.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setAuthentication(builder.build());
            return this;
        }

        public final Builder mergeAuthentication(Authentication authentication) {
            copyOnWrite();
            ((Service) this.instance).mergeAuthentication(authentication);
            return this;
        }

        public final Builder clearAuthentication() {
            copyOnWrite();
            ((Service) this.instance).clearAuthentication();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final boolean hasContext() {
            return ((Service) this.instance).hasContext();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Context getContext() {
            return ((Service) this.instance).getContext();
        }

        public final Builder setContext(Context context) {
            copyOnWrite();
            ((Service) this.instance).setContext(context);
            return this;
        }

        public final Builder setContext(Context.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setContext(builder.build());
            return this;
        }

        public final Builder mergeContext(Context context) {
            copyOnWrite();
            ((Service) this.instance).mergeContext(context);
            return this;
        }

        public final Builder clearContext() {
            copyOnWrite();
            ((Service) this.instance).clearContext();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final boolean hasUsage() {
            return ((Service) this.instance).hasUsage();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Usage getUsage() {
            return ((Service) this.instance).getUsage();
        }

        public final Builder setUsage(Usage usage) {
            copyOnWrite();
            ((Service) this.instance).setUsage(usage);
            return this;
        }

        public final Builder setUsage(Usage.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setUsage(builder.build());
            return this;
        }

        public final Builder mergeUsage(Usage usage) {
            copyOnWrite();
            ((Service) this.instance).mergeUsage(usage);
            return this;
        }

        public final Builder clearUsage() {
            copyOnWrite();
            ((Service) this.instance).clearUsage();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final List<Endpoint> getEndpointsList() {
            return Collections.unmodifiableList(((Service) this.instance).getEndpointsList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public final int getEndpointsCount() {
            return ((Service) this.instance).getEndpointsCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Endpoint getEndpoints(int i) {
            return ((Service) this.instance).getEndpoints(i);
        }

        public final Builder setEndpoints(int i, Endpoint endpoint) {
            copyOnWrite();
            ((Service) this.instance).setEndpoints(i, endpoint);
            return this;
        }

        public final Builder setEndpoints(int i, Endpoint.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setEndpoints(i, builder.build());
            return this;
        }

        public final Builder addEndpoints(Endpoint endpoint) {
            copyOnWrite();
            ((Service) this.instance).addEndpoints(endpoint);
            return this;
        }

        public final Builder addEndpoints(int i, Endpoint endpoint) {
            copyOnWrite();
            ((Service) this.instance).addEndpoints(i, endpoint);
            return this;
        }

        public final Builder addEndpoints(Endpoint.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).addEndpoints(builder.build());
            return this;
        }

        public final Builder addEndpoints(int i, Endpoint.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).addEndpoints(i, builder.build());
            return this;
        }

        public final Builder addAllEndpoints(Iterable<? extends Endpoint> iterable) {
            copyOnWrite();
            ((Service) this.instance).addAllEndpoints(iterable);
            return this;
        }

        public final Builder clearEndpoints() {
            copyOnWrite();
            ((Service) this.instance).clearEndpoints();
            return this;
        }

        public final Builder removeEndpoints(int i) {
            copyOnWrite();
            ((Service) this.instance).removeEndpoints(i);
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final boolean hasControl() {
            return ((Service) this.instance).hasControl();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Control getControl() {
            return ((Service) this.instance).getControl();
        }

        public final Builder setControl(Control control) {
            copyOnWrite();
            ((Service) this.instance).setControl(control);
            return this;
        }

        public final Builder setControl(Control.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setControl(builder.build());
            return this;
        }

        public final Builder mergeControl(Control control) {
            copyOnWrite();
            ((Service) this.instance).mergeControl(control);
            return this;
        }

        public final Builder clearControl() {
            copyOnWrite();
            ((Service) this.instance).clearControl();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final List<LogDescriptor> getLogsList() {
            return Collections.unmodifiableList(((Service) this.instance).getLogsList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public final int getLogsCount() {
            return ((Service) this.instance).getLogsCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final LogDescriptor getLogs(int i) {
            return ((Service) this.instance).getLogs(i);
        }

        public final Builder setLogs(int i, LogDescriptor logDescriptor) {
            copyOnWrite();
            ((Service) this.instance).setLogs(i, logDescriptor);
            return this;
        }

        public final Builder setLogs(int i, LogDescriptor.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setLogs(i, builder.build());
            return this;
        }

        public final Builder addLogs(LogDescriptor logDescriptor) {
            copyOnWrite();
            ((Service) this.instance).addLogs(logDescriptor);
            return this;
        }

        public final Builder addLogs(int i, LogDescriptor logDescriptor) {
            copyOnWrite();
            ((Service) this.instance).addLogs(i, logDescriptor);
            return this;
        }

        public final Builder addLogs(LogDescriptor.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).addLogs(builder.build());
            return this;
        }

        public final Builder addLogs(int i, LogDescriptor.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).addLogs(i, builder.build());
            return this;
        }

        public final Builder addAllLogs(Iterable<? extends LogDescriptor> iterable) {
            copyOnWrite();
            ((Service) this.instance).addAllLogs(iterable);
            return this;
        }

        public final Builder clearLogs() {
            copyOnWrite();
            ((Service) this.instance).clearLogs();
            return this;
        }

        public final Builder removeLogs(int i) {
            copyOnWrite();
            ((Service) this.instance).removeLogs(i);
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final List<MetricDescriptor> getMetricsList() {
            return Collections.unmodifiableList(((Service) this.instance).getMetricsList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public final int getMetricsCount() {
            return ((Service) this.instance).getMetricsCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final MetricDescriptor getMetrics(int i) {
            return ((Service) this.instance).getMetrics(i);
        }

        public final Builder setMetrics(int i, MetricDescriptor metricDescriptor) {
            copyOnWrite();
            ((Service) this.instance).setMetrics(i, metricDescriptor);
            return this;
        }

        public final Builder setMetrics(int i, MetricDescriptor.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setMetrics(i, builder.build());
            return this;
        }

        public final Builder addMetrics(MetricDescriptor metricDescriptor) {
            copyOnWrite();
            ((Service) this.instance).addMetrics(metricDescriptor);
            return this;
        }

        public final Builder addMetrics(int i, MetricDescriptor metricDescriptor) {
            copyOnWrite();
            ((Service) this.instance).addMetrics(i, metricDescriptor);
            return this;
        }

        public final Builder addMetrics(MetricDescriptor.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).addMetrics(builder.build());
            return this;
        }

        public final Builder addMetrics(int i, MetricDescriptor.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).addMetrics(i, builder.build());
            return this;
        }

        public final Builder addAllMetrics(Iterable<? extends MetricDescriptor> iterable) {
            copyOnWrite();
            ((Service) this.instance).addAllMetrics(iterable);
            return this;
        }

        public final Builder clearMetrics() {
            copyOnWrite();
            ((Service) this.instance).clearMetrics();
            return this;
        }

        public final Builder removeMetrics(int i) {
            copyOnWrite();
            ((Service) this.instance).removeMetrics(i);
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final List<MonitoredResourceDescriptor> getMonitoredResourcesList() {
            return Collections.unmodifiableList(((Service) this.instance).getMonitoredResourcesList());
        }

        @Override // com.google.api.ServiceOrBuilder
        public final int getMonitoredResourcesCount() {
            return ((Service) this.instance).getMonitoredResourcesCount();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final MonitoredResourceDescriptor getMonitoredResources(int i) {
            return ((Service) this.instance).getMonitoredResources(i);
        }

        public final Builder setMonitoredResources(int i, MonitoredResourceDescriptor monitoredResourceDescriptor) {
            copyOnWrite();
            ((Service) this.instance).setMonitoredResources(i, monitoredResourceDescriptor);
            return this;
        }

        public final Builder setMonitoredResources(int i, MonitoredResourceDescriptor.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setMonitoredResources(i, builder.build());
            return this;
        }

        public final Builder addMonitoredResources(MonitoredResourceDescriptor monitoredResourceDescriptor) {
            copyOnWrite();
            ((Service) this.instance).addMonitoredResources(monitoredResourceDescriptor);
            return this;
        }

        public final Builder addMonitoredResources(int i, MonitoredResourceDescriptor monitoredResourceDescriptor) {
            copyOnWrite();
            ((Service) this.instance).addMonitoredResources(i, monitoredResourceDescriptor);
            return this;
        }

        public final Builder addMonitoredResources(MonitoredResourceDescriptor.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).addMonitoredResources(builder.build());
            return this;
        }

        public final Builder addMonitoredResources(int i, MonitoredResourceDescriptor.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).addMonitoredResources(i, builder.build());
            return this;
        }

        public final Builder addAllMonitoredResources(Iterable<? extends MonitoredResourceDescriptor> iterable) {
            copyOnWrite();
            ((Service) this.instance).addAllMonitoredResources(iterable);
            return this;
        }

        public final Builder clearMonitoredResources() {
            copyOnWrite();
            ((Service) this.instance).clearMonitoredResources();
            return this;
        }

        public final Builder removeMonitoredResources(int i) {
            copyOnWrite();
            ((Service) this.instance).removeMonitoredResources(i);
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final boolean hasBilling() {
            return ((Service) this.instance).hasBilling();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Billing getBilling() {
            return ((Service) this.instance).getBilling();
        }

        public final Builder setBilling(Billing billing) {
            copyOnWrite();
            ((Service) this.instance).setBilling(billing);
            return this;
        }

        public final Builder setBilling(Billing.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setBilling(builder.build());
            return this;
        }

        public final Builder mergeBilling(Billing billing) {
            copyOnWrite();
            ((Service) this.instance).mergeBilling(billing);
            return this;
        }

        public final Builder clearBilling() {
            copyOnWrite();
            ((Service) this.instance).clearBilling();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final boolean hasLogging() {
            return ((Service) this.instance).hasLogging();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Logging getLogging() {
            return ((Service) this.instance).getLogging();
        }

        public final Builder setLogging(Logging logging) {
            copyOnWrite();
            ((Service) this.instance).setLogging(logging);
            return this;
        }

        public final Builder setLogging(Logging.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setLogging(builder.build());
            return this;
        }

        public final Builder mergeLogging(Logging logging) {
            copyOnWrite();
            ((Service) this.instance).mergeLogging(logging);
            return this;
        }

        public final Builder clearLogging() {
            copyOnWrite();
            ((Service) this.instance).clearLogging();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final boolean hasMonitoring() {
            return ((Service) this.instance).hasMonitoring();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final Monitoring getMonitoring() {
            return ((Service) this.instance).getMonitoring();
        }

        public final Builder setMonitoring(Monitoring monitoring) {
            copyOnWrite();
            ((Service) this.instance).setMonitoring(monitoring);
            return this;
        }

        public final Builder setMonitoring(Monitoring.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setMonitoring(builder.build());
            return this;
        }

        public final Builder mergeMonitoring(Monitoring monitoring) {
            copyOnWrite();
            ((Service) this.instance).mergeMonitoring(monitoring);
            return this;
        }

        public final Builder clearMonitoring() {
            copyOnWrite();
            ((Service) this.instance).clearMonitoring();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final boolean hasSystemParameters() {
            return ((Service) this.instance).hasSystemParameters();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final SystemParameters getSystemParameters() {
            return ((Service) this.instance).getSystemParameters();
        }

        public final Builder setSystemParameters(SystemParameters systemParameters) {
            copyOnWrite();
            ((Service) this.instance).setSystemParameters(systemParameters);
            return this;
        }

        public final Builder setSystemParameters(SystemParameters.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setSystemParameters(builder.build());
            return this;
        }

        public final Builder mergeSystemParameters(SystemParameters systemParameters) {
            copyOnWrite();
            ((Service) this.instance).mergeSystemParameters(systemParameters);
            return this;
        }

        public final Builder clearSystemParameters() {
            copyOnWrite();
            ((Service) this.instance).clearSystemParameters();
            return this;
        }

        @Override // com.google.api.ServiceOrBuilder
        public final boolean hasSourceInfo() {
            return ((Service) this.instance).hasSourceInfo();
        }

        @Override // com.google.api.ServiceOrBuilder
        public final SourceInfo getSourceInfo() {
            return ((Service) this.instance).getSourceInfo();
        }

        public final Builder setSourceInfo(SourceInfo sourceInfo) {
            copyOnWrite();
            ((Service) this.instance).setSourceInfo(sourceInfo);
            return this;
        }

        public final Builder setSourceInfo(SourceInfo.Builder builder) {
            copyOnWrite();
            ((Service) this.instance).setSourceInfo(builder.build());
            return this;
        }

        public final Builder mergeSourceInfo(SourceInfo sourceInfo) {
            copyOnWrite();
            ((Service) this.instance).mergeSourceInfo(sourceInfo);
            return this;
        }

        public final Builder clearSourceInfo() {
            copyOnWrite();
            ((Service) this.instance).clearSourceInfo();
            return this;
        }
    }

    /* renamed from: com.google.api.Service$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser parser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Service();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0019\u0000\u0000\u0001%\u0019\u0000\u0007\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004\u001b\u0005\u001b\u0006\t\b\t\t\t\n\t\u000b\t\f\t\u000f\t\u0012\u001b\u0014\t\u0015\t\u0016Ȉ\u0017\u001b\u0018\u001b\u0019\u001b\u001a\t\u001b\t\u001c\t\u001d\t!Ȉ%\t", new Object[]{"name_", "title_", "apis_", Api.class, "types_", Type.class, "enums_", Enum.class, "documentation_", "backend_", "http_", "quota_", AuthCodeUtil.SP_KEY_PREF, "context_", "usage_", "endpoints_", Endpoint.class, "configVersion_", "control_", "producerProjectId_", "logs_", LogDescriptor.class, "metrics_", MetricDescriptor.class, "monitoredResources_", MonitoredResourceDescriptor.class, "billing_", "logging_", "monitoring_", "systemParameters_", "id_", "sourceInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Service> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (Service.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                }
                return parser2;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        Service service = new Service();
        DEFAULT_INSTANCE = service;
        GeneratedMessageLite.registerDefaultInstance(Service.class, service);
    }

    public static Service getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Service> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
