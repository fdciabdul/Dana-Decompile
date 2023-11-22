package com.google.cloud.audit;

import com.google.cloud.audit.AuthenticationInfo;
import com.google.cloud.audit.AuthorizationInfo;
import com.google.cloud.audit.RequestMetadata;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public final class AuditLog extends GeneratedMessageLite<AuditLog, Builder> implements AuditLogOrBuilder {
    public static final int AUTHENTICATION_INFO_FIELD_NUMBER = 3;
    public static final int AUTHORIZATION_INFO_FIELD_NUMBER = 9;
    private static final AuditLog DEFAULT_INSTANCE;
    public static final int METHOD_NAME_FIELD_NUMBER = 8;
    public static final int NUM_RESPONSE_ITEMS_FIELD_NUMBER = 12;
    private static volatile Parser<AuditLog> PARSER = null;
    public static final int REQUEST_FIELD_NUMBER = 16;
    public static final int REQUEST_METADATA_FIELD_NUMBER = 4;
    public static final int RESOURCE_NAME_FIELD_NUMBER = 11;
    public static final int RESPONSE_FIELD_NUMBER = 17;
    public static final int SERVICE_DATA_FIELD_NUMBER = 15;
    public static final int SERVICE_NAME_FIELD_NUMBER = 7;
    public static final int STATUS_FIELD_NUMBER = 2;
    private AuthenticationInfo authenticationInfo_;
    private long numResponseItems_;
    private RequestMetadata requestMetadata_;
    private Struct request_;
    private Struct response_;
    private Any serviceData_;
    private Status status_;
    private String serviceName_ = "";
    private String methodName_ = "";
    private String resourceName_ = "";
    private Internal.ProtobufList<AuthorizationInfo> authorizationInfo_ = emptyProtobufList();

    private AuditLog() {
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final String getServiceName() {
        return this.serviceName_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final ByteString getServiceNameBytes() {
        return ByteString.copyFromUtf8(this.serviceName_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceName(String str) {
        this.serviceName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServiceName() {
        this.serviceName_ = getDefaultInstance().getServiceName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceNameBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.serviceName_ = byteString.toStringUtf8();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final String getMethodName() {
        return this.methodName_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final ByteString getMethodNameBytes() {
        return ByteString.copyFromUtf8(this.methodName_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMethodName(String str) {
        this.methodName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMethodName() {
        this.methodName_ = getDefaultInstance().getMethodName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMethodNameBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.methodName_ = byteString.toStringUtf8();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final String getResourceName() {
        return this.resourceName_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final ByteString getResourceNameBytes() {
        return ByteString.copyFromUtf8(this.resourceName_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResourceName(String str) {
        this.resourceName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResourceName() {
        this.resourceName_ = getDefaultInstance().getResourceName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResourceNameBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.resourceName_ = byteString.toStringUtf8();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final long getNumResponseItems() {
        return this.numResponseItems_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumResponseItems(long j) {
        this.numResponseItems_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumResponseItems() {
        this.numResponseItems_ = 0L;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final boolean hasStatus() {
        return this.status_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final Status getStatus() {
        Status status = this.status_;
        return status == null ? Status.getDefaultInstance() : status;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStatus(Status status) {
        this.status_ = status;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStatus(Status status) {
        Status status2 = this.status_;
        if (status2 != null && status2 != Status.getDefaultInstance()) {
            this.status_ = Status.newBuilder(this.status_).mergeFrom((Status.Builder) status).buildPartial();
        } else {
            this.status_ = status;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStatus() {
        this.status_ = null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final boolean hasAuthenticationInfo() {
        return this.authenticationInfo_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final AuthenticationInfo getAuthenticationInfo() {
        AuthenticationInfo authenticationInfo = this.authenticationInfo_;
        return authenticationInfo == null ? AuthenticationInfo.getDefaultInstance() : authenticationInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthenticationInfo(AuthenticationInfo authenticationInfo) {
        this.authenticationInfo_ = authenticationInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeAuthenticationInfo(AuthenticationInfo authenticationInfo) {
        AuthenticationInfo authenticationInfo2 = this.authenticationInfo_;
        if (authenticationInfo2 != null && authenticationInfo2 != AuthenticationInfo.getDefaultInstance()) {
            this.authenticationInfo_ = AuthenticationInfo.newBuilder(this.authenticationInfo_).mergeFrom((AuthenticationInfo.Builder) authenticationInfo).buildPartial();
        } else {
            this.authenticationInfo_ = authenticationInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthenticationInfo() {
        this.authenticationInfo_ = null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final List<AuthorizationInfo> getAuthorizationInfoList() {
        return this.authorizationInfo_;
    }

    public final List<? extends AuthorizationInfoOrBuilder> getAuthorizationInfoOrBuilderList() {
        return this.authorizationInfo_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final int getAuthorizationInfoCount() {
        return this.authorizationInfo_.size();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final AuthorizationInfo getAuthorizationInfo(int i) {
        return this.authorizationInfo_.get(i);
    }

    public final AuthorizationInfoOrBuilder getAuthorizationInfoOrBuilder(int i) {
        return this.authorizationInfo_.get(i);
    }

    private void ensureAuthorizationInfoIsMutable() {
        Internal.ProtobufList<AuthorizationInfo> protobufList = this.authorizationInfo_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.authorizationInfo_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthorizationInfo(int i, AuthorizationInfo authorizationInfo) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.set(i, authorizationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAuthorizationInfo(AuthorizationInfo authorizationInfo) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.add(authorizationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAuthorizationInfo(int i, AuthorizationInfo authorizationInfo) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.add(i, authorizationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAuthorizationInfo(Iterable<? extends AuthorizationInfo> iterable) {
        ensureAuthorizationInfoIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.authorizationInfo_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthorizationInfo() {
        this.authorizationInfo_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAuthorizationInfo(int i) {
        ensureAuthorizationInfoIsMutable();
        this.authorizationInfo_.remove(i);
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final boolean hasRequestMetadata() {
        return this.requestMetadata_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final RequestMetadata getRequestMetadata() {
        RequestMetadata requestMetadata = this.requestMetadata_;
        return requestMetadata == null ? RequestMetadata.getDefaultInstance() : requestMetadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestMetadata(RequestMetadata requestMetadata) {
        this.requestMetadata_ = requestMetadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRequestMetadata(RequestMetadata requestMetadata) {
        RequestMetadata requestMetadata2 = this.requestMetadata_;
        if (requestMetadata2 != null && requestMetadata2 != RequestMetadata.getDefaultInstance()) {
            this.requestMetadata_ = RequestMetadata.newBuilder(this.requestMetadata_).mergeFrom((RequestMetadata.Builder) requestMetadata).buildPartial();
        } else {
            this.requestMetadata_ = requestMetadata;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestMetadata() {
        this.requestMetadata_ = null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final boolean hasRequest() {
        return this.request_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final Struct getRequest() {
        Struct struct = this.request_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequest(Struct struct) {
        this.request_ = struct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRequest(Struct struct) {
        Struct struct2 = this.request_;
        if (struct2 != null && struct2 != Struct.getDefaultInstance()) {
            this.request_ = Struct.newBuilder(this.request_).mergeFrom((Struct.Builder) struct).buildPartial();
        } else {
            this.request_ = struct;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequest() {
        this.request_ = null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final boolean hasResponse() {
        return this.response_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final Struct getResponse() {
        Struct struct = this.response_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponse(Struct struct) {
        this.response_ = struct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeResponse(Struct struct) {
        Struct struct2 = this.response_;
        if (struct2 != null && struct2 != Struct.getDefaultInstance()) {
            this.response_ = Struct.newBuilder(this.response_).mergeFrom((Struct.Builder) struct).buildPartial();
        } else {
            this.response_ = struct;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponse() {
        this.response_ = null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final boolean hasServiceData() {
        return this.serviceData_ != null;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public final Any getServiceData() {
        Any any = this.serviceData_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServiceData(Any any) {
        this.serviceData_ = any;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeServiceData(Any any) {
        Any any2 = this.serviceData_;
        if (any2 != null && any2 != Any.getDefaultInstance()) {
            this.serviceData_ = Any.newBuilder(this.serviceData_).mergeFrom((Any.Builder) any).buildPartial();
        } else {
            this.serviceData_ = any;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServiceData() {
        this.serviceData_ = null;
    }

    public static AuditLog parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AuditLog parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AuditLog parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AuditLog parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuditLog parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuditLog parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AuditLog parseFrom(InputStream inputStream) throws IOException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuditLog parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuditLog parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuditLog) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuditLog parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuditLog) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuditLog parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuditLog parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuditLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AuditLog auditLog) {
        return DEFAULT_INSTANCE.createBuilder(auditLog);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<AuditLog, Builder> implements AuditLogOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(AuditLog.DEFAULT_INSTANCE);
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final String getServiceName() {
            return ((AuditLog) this.instance).getServiceName();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final ByteString getServiceNameBytes() {
            return ((AuditLog) this.instance).getServiceNameBytes();
        }

        public final Builder setServiceName(String str) {
            copyOnWrite();
            ((AuditLog) this.instance).setServiceName(str);
            return this;
        }

        public final Builder clearServiceName() {
            copyOnWrite();
            ((AuditLog) this.instance).clearServiceName();
            return this;
        }

        public final Builder setServiceNameBytes(ByteString byteString) {
            copyOnWrite();
            ((AuditLog) this.instance).setServiceNameBytes(byteString);
            return this;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final String getMethodName() {
            return ((AuditLog) this.instance).getMethodName();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final ByteString getMethodNameBytes() {
            return ((AuditLog) this.instance).getMethodNameBytes();
        }

        public final Builder setMethodName(String str) {
            copyOnWrite();
            ((AuditLog) this.instance).setMethodName(str);
            return this;
        }

        public final Builder clearMethodName() {
            copyOnWrite();
            ((AuditLog) this.instance).clearMethodName();
            return this;
        }

        public final Builder setMethodNameBytes(ByteString byteString) {
            copyOnWrite();
            ((AuditLog) this.instance).setMethodNameBytes(byteString);
            return this;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final String getResourceName() {
            return ((AuditLog) this.instance).getResourceName();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final ByteString getResourceNameBytes() {
            return ((AuditLog) this.instance).getResourceNameBytes();
        }

        public final Builder setResourceName(String str) {
            copyOnWrite();
            ((AuditLog) this.instance).setResourceName(str);
            return this;
        }

        public final Builder clearResourceName() {
            copyOnWrite();
            ((AuditLog) this.instance).clearResourceName();
            return this;
        }

        public final Builder setResourceNameBytes(ByteString byteString) {
            copyOnWrite();
            ((AuditLog) this.instance).setResourceNameBytes(byteString);
            return this;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final long getNumResponseItems() {
            return ((AuditLog) this.instance).getNumResponseItems();
        }

        public final Builder setNumResponseItems(long j) {
            copyOnWrite();
            ((AuditLog) this.instance).setNumResponseItems(j);
            return this;
        }

        public final Builder clearNumResponseItems() {
            copyOnWrite();
            ((AuditLog) this.instance).clearNumResponseItems();
            return this;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final boolean hasStatus() {
            return ((AuditLog) this.instance).hasStatus();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final Status getStatus() {
            return ((AuditLog) this.instance).getStatus();
        }

        public final Builder setStatus(Status status) {
            copyOnWrite();
            ((AuditLog) this.instance).setStatus(status);
            return this;
        }

        public final Builder setStatus(Status.Builder builder) {
            copyOnWrite();
            ((AuditLog) this.instance).setStatus(builder.build());
            return this;
        }

        public final Builder mergeStatus(Status status) {
            copyOnWrite();
            ((AuditLog) this.instance).mergeStatus(status);
            return this;
        }

        public final Builder clearStatus() {
            copyOnWrite();
            ((AuditLog) this.instance).clearStatus();
            return this;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final boolean hasAuthenticationInfo() {
            return ((AuditLog) this.instance).hasAuthenticationInfo();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final AuthenticationInfo getAuthenticationInfo() {
            return ((AuditLog) this.instance).getAuthenticationInfo();
        }

        public final Builder setAuthenticationInfo(AuthenticationInfo authenticationInfo) {
            copyOnWrite();
            ((AuditLog) this.instance).setAuthenticationInfo(authenticationInfo);
            return this;
        }

        public final Builder setAuthenticationInfo(AuthenticationInfo.Builder builder) {
            copyOnWrite();
            ((AuditLog) this.instance).setAuthenticationInfo(builder.build());
            return this;
        }

        public final Builder mergeAuthenticationInfo(AuthenticationInfo authenticationInfo) {
            copyOnWrite();
            ((AuditLog) this.instance).mergeAuthenticationInfo(authenticationInfo);
            return this;
        }

        public final Builder clearAuthenticationInfo() {
            copyOnWrite();
            ((AuditLog) this.instance).clearAuthenticationInfo();
            return this;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final List<AuthorizationInfo> getAuthorizationInfoList() {
            return Collections.unmodifiableList(((AuditLog) this.instance).getAuthorizationInfoList());
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final int getAuthorizationInfoCount() {
            return ((AuditLog) this.instance).getAuthorizationInfoCount();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final AuthorizationInfo getAuthorizationInfo(int i) {
            return ((AuditLog) this.instance).getAuthorizationInfo(i);
        }

        public final Builder setAuthorizationInfo(int i, AuthorizationInfo authorizationInfo) {
            copyOnWrite();
            ((AuditLog) this.instance).setAuthorizationInfo(i, authorizationInfo);
            return this;
        }

        public final Builder setAuthorizationInfo(int i, AuthorizationInfo.Builder builder) {
            copyOnWrite();
            ((AuditLog) this.instance).setAuthorizationInfo(i, builder.build());
            return this;
        }

        public final Builder addAuthorizationInfo(AuthorizationInfo authorizationInfo) {
            copyOnWrite();
            ((AuditLog) this.instance).addAuthorizationInfo(authorizationInfo);
            return this;
        }

        public final Builder addAuthorizationInfo(int i, AuthorizationInfo authorizationInfo) {
            copyOnWrite();
            ((AuditLog) this.instance).addAuthorizationInfo(i, authorizationInfo);
            return this;
        }

        public final Builder addAuthorizationInfo(AuthorizationInfo.Builder builder) {
            copyOnWrite();
            ((AuditLog) this.instance).addAuthorizationInfo(builder.build());
            return this;
        }

        public final Builder addAuthorizationInfo(int i, AuthorizationInfo.Builder builder) {
            copyOnWrite();
            ((AuditLog) this.instance).addAuthorizationInfo(i, builder.build());
            return this;
        }

        public final Builder addAllAuthorizationInfo(Iterable<? extends AuthorizationInfo> iterable) {
            copyOnWrite();
            ((AuditLog) this.instance).addAllAuthorizationInfo(iterable);
            return this;
        }

        public final Builder clearAuthorizationInfo() {
            copyOnWrite();
            ((AuditLog) this.instance).clearAuthorizationInfo();
            return this;
        }

        public final Builder removeAuthorizationInfo(int i) {
            copyOnWrite();
            ((AuditLog) this.instance).removeAuthorizationInfo(i);
            return this;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final boolean hasRequestMetadata() {
            return ((AuditLog) this.instance).hasRequestMetadata();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final RequestMetadata getRequestMetadata() {
            return ((AuditLog) this.instance).getRequestMetadata();
        }

        public final Builder setRequestMetadata(RequestMetadata requestMetadata) {
            copyOnWrite();
            ((AuditLog) this.instance).setRequestMetadata(requestMetadata);
            return this;
        }

        public final Builder setRequestMetadata(RequestMetadata.Builder builder) {
            copyOnWrite();
            ((AuditLog) this.instance).setRequestMetadata(builder.build());
            return this;
        }

        public final Builder mergeRequestMetadata(RequestMetadata requestMetadata) {
            copyOnWrite();
            ((AuditLog) this.instance).mergeRequestMetadata(requestMetadata);
            return this;
        }

        public final Builder clearRequestMetadata() {
            copyOnWrite();
            ((AuditLog) this.instance).clearRequestMetadata();
            return this;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final boolean hasRequest() {
            return ((AuditLog) this.instance).hasRequest();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final Struct getRequest() {
            return ((AuditLog) this.instance).getRequest();
        }

        public final Builder setRequest(Struct struct) {
            copyOnWrite();
            ((AuditLog) this.instance).setRequest(struct);
            return this;
        }

        public final Builder setRequest(Struct.Builder builder) {
            copyOnWrite();
            ((AuditLog) this.instance).setRequest(builder.build());
            return this;
        }

        public final Builder mergeRequest(Struct struct) {
            copyOnWrite();
            ((AuditLog) this.instance).mergeRequest(struct);
            return this;
        }

        public final Builder clearRequest() {
            copyOnWrite();
            ((AuditLog) this.instance).clearRequest();
            return this;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final boolean hasResponse() {
            return ((AuditLog) this.instance).hasResponse();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final Struct getResponse() {
            return ((AuditLog) this.instance).getResponse();
        }

        public final Builder setResponse(Struct struct) {
            copyOnWrite();
            ((AuditLog) this.instance).setResponse(struct);
            return this;
        }

        public final Builder setResponse(Struct.Builder builder) {
            copyOnWrite();
            ((AuditLog) this.instance).setResponse(builder.build());
            return this;
        }

        public final Builder mergeResponse(Struct struct) {
            copyOnWrite();
            ((AuditLog) this.instance).mergeResponse(struct);
            return this;
        }

        public final Builder clearResponse() {
            copyOnWrite();
            ((AuditLog) this.instance).clearResponse();
            return this;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final boolean hasServiceData() {
            return ((AuditLog) this.instance).hasServiceData();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public final Any getServiceData() {
            return ((AuditLog) this.instance).getServiceData();
        }

        public final Builder setServiceData(Any any) {
            copyOnWrite();
            ((AuditLog) this.instance).setServiceData(any);
            return this;
        }

        public final Builder setServiceData(Any.Builder builder) {
            copyOnWrite();
            ((AuditLog) this.instance).setServiceData(builder.build());
            return this;
        }

        public final Builder mergeServiceData(Any any) {
            copyOnWrite();
            ((AuditLog) this.instance).mergeServiceData(any);
            return this;
        }

        public final Builder clearServiceData() {
            copyOnWrite();
            ((AuditLog) this.instance).clearServiceData();
            return this;
        }
    }

    /* renamed from: com.google.cloud.audit.AuditLog$1  reason: invalid class name */
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
                return new AuditLog();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0000\u0002\u0011\u000b\u0000\u0001\u0000\u0002\t\u0003\t\u0004\t\u0007Ȉ\bȈ\t\u001b\u000bȈ\f\u0002\u000f\t\u0010\t\u0011\t", new Object[]{"status_", "authenticationInfo_", "requestMetadata_", "serviceName_", "methodName_", "authorizationInfo_", AuthorizationInfo.class, "resourceName_", "numResponseItems_", "serviceData_", "request_", "response_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AuditLog> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (AuditLog.class) {
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
        AuditLog auditLog = new AuditLog();
        DEFAULT_INSTANCE = auditLog;
        GeneratedMessageLite.registerDefaultInstance(AuditLog.class, auditLog);
    }

    public static AuditLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuditLog> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
