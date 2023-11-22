package com.google.type;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public final class PostalAddress extends GeneratedMessageLite<PostalAddress, Builder> implements PostalAddressOrBuilder {
    public static final int ADDRESS_LINES_FIELD_NUMBER = 9;
    public static final int ADMINISTRATIVE_AREA_FIELD_NUMBER = 6;
    private static final PostalAddress DEFAULT_INSTANCE;
    public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
    public static final int LOCALITY_FIELD_NUMBER = 7;
    public static final int ORGANIZATION_FIELD_NUMBER = 11;
    private static volatile Parser<PostalAddress> PARSER = null;
    public static final int POSTAL_CODE_FIELD_NUMBER = 4;
    public static final int RECIPIENTS_FIELD_NUMBER = 10;
    public static final int REGION_CODE_FIELD_NUMBER = 2;
    public static final int REVISION_FIELD_NUMBER = 1;
    public static final int SORTING_CODE_FIELD_NUMBER = 5;
    public static final int SUBLOCALITY_FIELD_NUMBER = 8;
    private int revision_;
    private String regionCode_ = "";
    private String languageCode_ = "";
    private String postalCode_ = "";
    private String sortingCode_ = "";
    private String administrativeArea_ = "";
    private String locality_ = "";
    private String sublocality_ = "";
    private Internal.ProtobufList<String> addressLines_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<String> recipients_ = GeneratedMessageLite.emptyProtobufList();
    private String organization_ = "";

    private PostalAddress() {
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final int getRevision() {
        return this.revision_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRevision(int i) {
        this.revision_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRevision() {
        this.revision_ = 0;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final String getRegionCode() {
        return this.regionCode_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final ByteString getRegionCodeBytes() {
        return ByteString.copyFromUtf8(this.regionCode_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegionCode(String str) {
        this.regionCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRegionCode() {
        this.regionCode_ = getDefaultInstance().getRegionCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRegionCodeBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.regionCode_ = byteString.toStringUtf8();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final String getLanguageCode() {
        return this.languageCode_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final ByteString getLanguageCodeBytes() {
        return ByteString.copyFromUtf8(this.languageCode_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLanguageCode(String str) {
        this.languageCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLanguageCode() {
        this.languageCode_ = getDefaultInstance().getLanguageCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLanguageCodeBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.languageCode_ = byteString.toStringUtf8();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final String getPostalCode() {
        return this.postalCode_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final ByteString getPostalCodeBytes() {
        return ByteString.copyFromUtf8(this.postalCode_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPostalCode(String str) {
        this.postalCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPostalCode() {
        this.postalCode_ = getDefaultInstance().getPostalCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPostalCodeBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.postalCode_ = byteString.toStringUtf8();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final String getSortingCode() {
        return this.sortingCode_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final ByteString getSortingCodeBytes() {
        return ByteString.copyFromUtf8(this.sortingCode_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSortingCode(String str) {
        this.sortingCode_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSortingCode() {
        this.sortingCode_ = getDefaultInstance().getSortingCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSortingCodeBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.sortingCode_ = byteString.toStringUtf8();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final String getAdministrativeArea() {
        return this.administrativeArea_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final ByteString getAdministrativeAreaBytes() {
        return ByteString.copyFromUtf8(this.administrativeArea_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdministrativeArea(String str) {
        this.administrativeArea_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdministrativeArea() {
        this.administrativeArea_ = getDefaultInstance().getAdministrativeArea();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdministrativeAreaBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.administrativeArea_ = byteString.toStringUtf8();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final String getLocality() {
        return this.locality_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final ByteString getLocalityBytes() {
        return ByteString.copyFromUtf8(this.locality_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocality(String str) {
        this.locality_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLocality() {
        this.locality_ = getDefaultInstance().getLocality();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocalityBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.locality_ = byteString.toStringUtf8();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final String getSublocality() {
        return this.sublocality_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final ByteString getSublocalityBytes() {
        return ByteString.copyFromUtf8(this.sublocality_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSublocality(String str) {
        this.sublocality_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSublocality() {
        this.sublocality_ = getDefaultInstance().getSublocality();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSublocalityBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.sublocality_ = byteString.toStringUtf8();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final List<String> getAddressLinesList() {
        return this.addressLines_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final int getAddressLinesCount() {
        return this.addressLines_.size();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final String getAddressLines(int i) {
        return this.addressLines_.get(i);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final ByteString getAddressLinesBytes(int i) {
        return ByteString.copyFromUtf8(this.addressLines_.get(i));
    }

    private void ensureAddressLinesIsMutable() {
        Internal.ProtobufList<String> protobufList = this.addressLines_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.addressLines_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddressLines(int i, String str) {
        ensureAddressLinesIsMutable();
        this.addressLines_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAddressLines(String str) {
        ensureAddressLinesIsMutable();
        this.addressLines_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAddressLines(Iterable<String> iterable) {
        ensureAddressLinesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.addressLines_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAddressLines() {
        this.addressLines_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAddressLinesBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureAddressLinesIsMutable();
        this.addressLines_.add(byteString.toStringUtf8());
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final List<String> getRecipientsList() {
        return this.recipients_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final int getRecipientsCount() {
        return this.recipients_.size();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final String getRecipients(int i) {
        return this.recipients_.get(i);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final ByteString getRecipientsBytes(int i) {
        return ByteString.copyFromUtf8(this.recipients_.get(i));
    }

    private void ensureRecipientsIsMutable() {
        Internal.ProtobufList<String> protobufList = this.recipients_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.recipients_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecipients(int i, String str) {
        ensureRecipientsIsMutable();
        this.recipients_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRecipients(String str) {
        ensureRecipientsIsMutable();
        this.recipients_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRecipients(Iterable<String> iterable) {
        ensureRecipientsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.recipients_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRecipients() {
        this.recipients_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRecipientsBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureRecipientsIsMutable();
        this.recipients_.add(byteString.toStringUtf8());
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final String getOrganization() {
        return this.organization_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public final ByteString getOrganizationBytes() {
        return ByteString.copyFromUtf8(this.organization_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrganization(String str) {
        this.organization_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOrganization() {
        this.organization_ = getDefaultInstance().getOrganization();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrganizationBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.organization_ = byteString.toStringUtf8();
    }

    public static PostalAddress parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static PostalAddress parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static PostalAddress parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static PostalAddress parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(InputStream inputStream) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PostalAddress parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PostalAddress parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PostalAddress) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static PostalAddress parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static PostalAddress parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(PostalAddress postalAddress) {
        return DEFAULT_INSTANCE.createBuilder(postalAddress);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<PostalAddress, Builder> implements PostalAddressOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(PostalAddress.DEFAULT_INSTANCE);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final int getRevision() {
            return ((PostalAddress) this.instance).getRevision();
        }

        public final Builder setRevision(int i) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRevision(i);
            return this;
        }

        public final Builder clearRevision() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearRevision();
            return this;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final String getRegionCode() {
            return ((PostalAddress) this.instance).getRegionCode();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final ByteString getRegionCodeBytes() {
            return ((PostalAddress) this.instance).getRegionCodeBytes();
        }

        public final Builder setRegionCode(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRegionCode(str);
            return this;
        }

        public final Builder clearRegionCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearRegionCode();
            return this;
        }

        public final Builder setRegionCodeBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRegionCodeBytes(byteString);
            return this;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final String getLanguageCode() {
            return ((PostalAddress) this.instance).getLanguageCode();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final ByteString getLanguageCodeBytes() {
            return ((PostalAddress) this.instance).getLanguageCodeBytes();
        }

        public final Builder setLanguageCode(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLanguageCode(str);
            return this;
        }

        public final Builder clearLanguageCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearLanguageCode();
            return this;
        }

        public final Builder setLanguageCodeBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLanguageCodeBytes(byteString);
            return this;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final String getPostalCode() {
            return ((PostalAddress) this.instance).getPostalCode();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final ByteString getPostalCodeBytes() {
            return ((PostalAddress) this.instance).getPostalCodeBytes();
        }

        public final Builder setPostalCode(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setPostalCode(str);
            return this;
        }

        public final Builder clearPostalCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearPostalCode();
            return this;
        }

        public final Builder setPostalCodeBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setPostalCodeBytes(byteString);
            return this;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final String getSortingCode() {
            return ((PostalAddress) this.instance).getSortingCode();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final ByteString getSortingCodeBytes() {
            return ((PostalAddress) this.instance).getSortingCodeBytes();
        }

        public final Builder setSortingCode(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSortingCode(str);
            return this;
        }

        public final Builder clearSortingCode() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearSortingCode();
            return this;
        }

        public final Builder setSortingCodeBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSortingCodeBytes(byteString);
            return this;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final String getAdministrativeArea() {
            return ((PostalAddress) this.instance).getAdministrativeArea();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final ByteString getAdministrativeAreaBytes() {
            return ((PostalAddress) this.instance).getAdministrativeAreaBytes();
        }

        public final Builder setAdministrativeArea(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setAdministrativeArea(str);
            return this;
        }

        public final Builder clearAdministrativeArea() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearAdministrativeArea();
            return this;
        }

        public final Builder setAdministrativeAreaBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setAdministrativeAreaBytes(byteString);
            return this;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final String getLocality() {
            return ((PostalAddress) this.instance).getLocality();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final ByteString getLocalityBytes() {
            return ((PostalAddress) this.instance).getLocalityBytes();
        }

        public final Builder setLocality(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLocality(str);
            return this;
        }

        public final Builder clearLocality() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearLocality();
            return this;
        }

        public final Builder setLocalityBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setLocalityBytes(byteString);
            return this;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final String getSublocality() {
            return ((PostalAddress) this.instance).getSublocality();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final ByteString getSublocalityBytes() {
            return ((PostalAddress) this.instance).getSublocalityBytes();
        }

        public final Builder setSublocality(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSublocality(str);
            return this;
        }

        public final Builder clearSublocality() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearSublocality();
            return this;
        }

        public final Builder setSublocalityBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setSublocalityBytes(byteString);
            return this;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final List<String> getAddressLinesList() {
            return Collections.unmodifiableList(((PostalAddress) this.instance).getAddressLinesList());
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final int getAddressLinesCount() {
            return ((PostalAddress) this.instance).getAddressLinesCount();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final String getAddressLines(int i) {
            return ((PostalAddress) this.instance).getAddressLines(i);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final ByteString getAddressLinesBytes(int i) {
            return ((PostalAddress) this.instance).getAddressLinesBytes(i);
        }

        public final Builder setAddressLines(int i, String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setAddressLines(i, str);
            return this;
        }

        public final Builder addAddressLines(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAddressLines(str);
            return this;
        }

        public final Builder addAllAddressLines(Iterable<String> iterable) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAllAddressLines(iterable);
            return this;
        }

        public final Builder clearAddressLines() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearAddressLines();
            return this;
        }

        public final Builder addAddressLinesBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAddressLinesBytes(byteString);
            return this;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final List<String> getRecipientsList() {
            return Collections.unmodifiableList(((PostalAddress) this.instance).getRecipientsList());
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final int getRecipientsCount() {
            return ((PostalAddress) this.instance).getRecipientsCount();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final String getRecipients(int i) {
            return ((PostalAddress) this.instance).getRecipients(i);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final ByteString getRecipientsBytes(int i) {
            return ((PostalAddress) this.instance).getRecipientsBytes(i);
        }

        public final Builder setRecipients(int i, String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setRecipients(i, str);
            return this;
        }

        public final Builder addRecipients(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).addRecipients(str);
            return this;
        }

        public final Builder addAllRecipients(Iterable<String> iterable) {
            copyOnWrite();
            ((PostalAddress) this.instance).addAllRecipients(iterable);
            return this;
        }

        public final Builder clearRecipients() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearRecipients();
            return this;
        }

        public final Builder addRecipientsBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).addRecipientsBytes(byteString);
            return this;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final String getOrganization() {
            return ((PostalAddress) this.instance).getOrganization();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public final ByteString getOrganizationBytes() {
            return ((PostalAddress) this.instance).getOrganizationBytes();
        }

        public final Builder setOrganization(String str) {
            copyOnWrite();
            ((PostalAddress) this.instance).setOrganization(str);
            return this;
        }

        public final Builder clearOrganization() {
            copyOnWrite();
            ((PostalAddress) this.instance).clearOrganization();
            return this;
        }

        public final Builder setOrganizationBytes(ByteString byteString) {
            copyOnWrite();
            ((PostalAddress) this.instance).setOrganizationBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.type.PostalAddress$1  reason: invalid class name */
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
                return new PostalAddress();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0000\u0001\u000b\u000b\u0000\u0002\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\tȚ\nȚ\u000bȈ", new Object[]{"revision_", "regionCode_", "languageCode_", "postalCode_", "sortingCode_", "administrativeArea_", "locality_", "sublocality_", "addressLines_", "recipients_", "organization_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<PostalAddress> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (PostalAddress.class) {
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
        PostalAddress postalAddress = new PostalAddress();
        DEFAULT_INSTANCE = postalAddress;
        GeneratedMessageLite.registerDefaultInstance(PostalAddress.class, postalAddress);
    }

    public static PostalAddress getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<PostalAddress> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
