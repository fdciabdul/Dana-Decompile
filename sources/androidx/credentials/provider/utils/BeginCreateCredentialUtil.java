package androidx.credentials.provider.utils;

import android.app.slice.Slice;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.service.credentials.BeginCreateCredentialResponse;
import androidx.credentials.PasswordCredential;
import androidx.credentials.PublicKeyCredential;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.provider.BeginCreateCredentialRequest;
import androidx.credentials.provider.BeginCreateCustomCredentialRequest;
import androidx.credentials.provider.BeginCreatePasswordCredentialRequest;
import androidx.credentials.provider.BeginCreatePublicKeyCredentialRequest;
import androidx.credentials.provider.CallingAppInfo;
import androidx.credentials.provider.CreateEntry;
import androidx.credentials.provider.RemoteEntry;
import androidx.credentials.provider.utils.BeginCreateCredentialUtil;
import j$.util.Collection;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/credentials/provider/utils/BeginCreateCredentialUtil;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BeginCreateCredentialUtil {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001c"}, d2 = {"Landroidx/credentials/provider/utils/BeginCreateCredentialUtil$Companion;", "", "Landroidx/credentials/provider/BeginCreateCredentialRequest;", "request", "Landroid/service/credentials/BeginCreateCredentialRequest;", "convertToFrameworkRequest", "(Landroidx/credentials/provider/BeginCreateCredentialRequest;)Landroid/service/credentials/BeginCreateCredentialRequest;", "Landroidx/credentials/provider/BeginCreateCredentialResponse;", "response", "Landroid/service/credentials/BeginCreateCredentialResponse;", "convertToFrameworkResponse", "(Landroidx/credentials/provider/BeginCreateCredentialResponse;)Landroid/service/credentials/BeginCreateCredentialResponse;", "convertToJetpackRequest$credentials_release", "(Landroid/service/credentials/BeginCreateCredentialRequest;)Landroidx/credentials/provider/BeginCreateCredentialRequest;", "frameworkResponse", "convertToJetpackResponse", "(Landroid/service/credentials/BeginCreateCredentialResponse;)Landroidx/credentials/provider/BeginCreateCredentialResponse;", "Landroid/service/credentials/BeginCreateCredentialResponse$Builder;", "frameworkBuilder", "", "Landroidx/credentials/provider/CreateEntry;", "createEntries", "", "populateCreateEntries", "(Landroid/service/credentials/BeginCreateCredentialResponse$Builder;Ljava/util/List;)V", "Landroidx/credentials/provider/RemoteEntry;", "remoteEntry", "populateRemoteEntry", "(Landroid/service/credentials/BeginCreateCredentialResponse$Builder;Landroidx/credentials/provider/RemoteEntry;)V", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BeginCreateCredentialRequest convertToJetpackRequest$credentials_release(android.service.credentials.BeginCreateCredentialRequest request) {
            CallingAppInfo callingAppInfo;
            CallingAppInfo callingAppInfo2;
            CallingAppInfo callingAppInfo3;
            Intrinsics.checkNotNullParameter(request, "");
            CallingAppInfo callingAppInfo4 = null;
            try {
                String type = request.getType();
                int hashCode = type.hashCode();
                if (hashCode != -543568185) {
                    if (hashCode == -95037569 && type.equals(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL)) {
                        BeginCreatePublicKeyCredentialRequest.Companion companion = BeginCreatePublicKeyCredentialRequest.INSTANCE;
                        Bundle data = request.getData();
                        Intrinsics.checkNotNullExpressionValue(data, "");
                        android.service.credentials.CallingAppInfo callingAppInfo5 = request.getCallingAppInfo();
                        if (callingAppInfo5 != null) {
                            String packageName = callingAppInfo5.getPackageName();
                            Intrinsics.checkNotNullExpressionValue(packageName, "");
                            SigningInfo signingInfo = callingAppInfo5.getSigningInfo();
                            Intrinsics.checkNotNullExpressionValue(signingInfo, "");
                            callingAppInfo3 = new CallingAppInfo(packageName, signingInfo, callingAppInfo5.getOrigin());
                        } else {
                            callingAppInfo3 = null;
                        }
                        return companion.createFrom$credentials_release(data, callingAppInfo3);
                    }
                } else if (type.equals(PasswordCredential.TYPE_PASSWORD_CREDENTIAL)) {
                    BeginCreatePasswordCredentialRequest.Companion companion2 = BeginCreatePasswordCredentialRequest.INSTANCE;
                    Bundle data2 = request.getData();
                    Intrinsics.checkNotNullExpressionValue(data2, "");
                    android.service.credentials.CallingAppInfo callingAppInfo6 = request.getCallingAppInfo();
                    if (callingAppInfo6 != null) {
                        String packageName2 = callingAppInfo6.getPackageName();
                        Intrinsics.checkNotNullExpressionValue(packageName2, "");
                        SigningInfo signingInfo2 = callingAppInfo6.getSigningInfo();
                        Intrinsics.checkNotNullExpressionValue(signingInfo2, "");
                        callingAppInfo = new CallingAppInfo(packageName2, signingInfo2, callingAppInfo6.getOrigin());
                    } else {
                        callingAppInfo = null;
                    }
                    return companion2.createFrom$credentials_release(data2, callingAppInfo);
                }
                String type2 = request.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "");
                Bundle data3 = request.getData();
                Intrinsics.checkNotNullExpressionValue(data3, "");
                android.service.credentials.CallingAppInfo callingAppInfo7 = request.getCallingAppInfo();
                if (callingAppInfo7 != null) {
                    String packageName3 = callingAppInfo7.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName3, "");
                    SigningInfo signingInfo3 = callingAppInfo7.getSigningInfo();
                    Intrinsics.checkNotNullExpressionValue(signingInfo3, "");
                    callingAppInfo2 = new CallingAppInfo(packageName3, signingInfo3, callingAppInfo7.getOrigin());
                } else {
                    callingAppInfo2 = null;
                }
                return new BeginCreateCustomCredentialRequest(type2, data3, callingAppInfo2);
            } catch (FrameworkClassParsingException unused) {
                String type3 = request.getType();
                Intrinsics.checkNotNullExpressionValue(type3, "");
                Bundle data4 = request.getData();
                Intrinsics.checkNotNullExpressionValue(data4, "");
                android.service.credentials.CallingAppInfo callingAppInfo8 = request.getCallingAppInfo();
                if (callingAppInfo8 != null) {
                    String packageName4 = callingAppInfo8.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName4, "");
                    SigningInfo signingInfo4 = callingAppInfo8.getSigningInfo();
                    Intrinsics.checkNotNullExpressionValue(signingInfo4, "");
                    callingAppInfo4 = new CallingAppInfo(packageName4, signingInfo4, callingAppInfo8.getOrigin());
                }
                return new BeginCreateCustomCredentialRequest(type3, data4, callingAppInfo4);
            }
        }

        public final BeginCreateCredentialResponse convertToFrameworkResponse(androidx.credentials.provider.BeginCreateCredentialResponse response) {
            Intrinsics.checkNotNullParameter(response, "");
            BeginCreateCredentialResponse.Builder builder = new BeginCreateCredentialResponse.Builder();
            populateCreateEntries(builder, response.getCreateEntries());
            populateRemoteEntry(builder, response.getRemoteEntry());
            BeginCreateCredentialResponse build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "");
            return build;
        }

        private final void populateRemoteEntry(BeginCreateCredentialResponse.Builder frameworkBuilder, RemoteEntry remoteEntry) {
            if (remoteEntry == null) {
                return;
            }
            frameworkBuilder.setRemoteCreateEntry(new android.service.credentials.RemoteEntry(RemoteEntry.INSTANCE.toSlice(remoteEntry)));
        }

        private final void populateCreateEntries(BeginCreateCredentialResponse.Builder frameworkBuilder, List<CreateEntry> createEntries) {
            Iterator<T> it = createEntries.iterator();
            while (it.hasNext()) {
                Slice slice = CreateEntry.INSTANCE.toSlice((CreateEntry) it.next());
                if (slice != null) {
                    frameworkBuilder.addCreateEntry(new android.service.credentials.CreateEntry(slice));
                }
            }
        }

        public final android.service.credentials.BeginCreateCredentialRequest convertToFrameworkRequest(BeginCreateCredentialRequest request) {
            Intrinsics.checkNotNullParameter(request, "");
            return new android.service.credentials.BeginCreateCredentialRequest(request.getType(), request.getCandidateQueryData(), request.getCallingAppInfo() != null ? new android.service.credentials.CallingAppInfo(request.getCallingAppInfo().getPackageName(), request.getCallingAppInfo().getSigningInfo(), request.getCallingAppInfo().getOrigin()) : null);
        }

        public final androidx.credentials.provider.BeginCreateCredentialResponse convertToJetpackResponse(BeginCreateCredentialResponse frameworkResponse) {
            RemoteEntry remoteEntry;
            Intrinsics.checkNotNullParameter(frameworkResponse, "");
            Stream authRequestContext = Collection.EL.getAuthRequestContext(frameworkResponse.getCreateEntries());
            final BeginCreateCredentialUtil$Companion$convertToJetpackResponse$1 beginCreateCredentialUtil$Companion$convertToJetpackResponse$1 = new Function1<android.service.credentials.CreateEntry, CreateEntry>() { // from class: androidx.credentials.provider.utils.BeginCreateCredentialUtil$Companion$convertToJetpackResponse$1
                @Override // kotlin.jvm.functions.Function1
                public final CreateEntry invoke(android.service.credentials.CreateEntry createEntry) {
                    CreateEntry.Companion companion = CreateEntry.INSTANCE;
                    Slice slice = createEntry.getSlice();
                    Intrinsics.checkNotNullExpressionValue(slice, "");
                    return companion.fromSlice(slice);
                }
            };
            Stream KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: androidx.credentials.provider.utils.BeginCreateCredentialUtil$Companion$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    CreateEntry convertToJetpackResponse$lambda$5;
                    convertToJetpackResponse$lambda$5 = BeginCreateCredentialUtil.Companion.convertToJetpackResponse$lambda$5(Function1.this, obj);
                    return convertToJetpackResponse$lambda$5;
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            });
            final BeginCreateCredentialUtil$Companion$convertToJetpackResponse$2 beginCreateCredentialUtil$Companion$convertToJetpackResponse$2 = new Function1<CreateEntry, Boolean>() { // from class: androidx.credentials.provider.utils.BeginCreateCredentialUtil$Companion$convertToJetpackResponse$2
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(CreateEntry createEntry) {
                    return Boolean.valueOf(createEntry != null);
                }
            };
            Stream authRequestContext2 = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(new Predicate() { // from class: androidx.credentials.provider.utils.BeginCreateCredentialUtil$Companion$$ExternalSyntheticLambda1
                @Override // j$.util.function.Predicate
                public final /* synthetic */ Predicate and(Predicate predicate) {
                    return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
                }

                @Override // j$.util.function.Predicate
                public final /* synthetic */ Predicate negate() {
                    return Predicate.CC.PlaceComponentResult(this);
                }

                @Override // j$.util.function.Predicate
                public final /* synthetic */ Predicate or(Predicate predicate) {
                    return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
                }

                @Override // j$.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean convertToJetpackResponse$lambda$6;
                    convertToJetpackResponse$lambda$6 = BeginCreateCredentialUtil.Companion.convertToJetpackResponse$lambda$6(Function1.this, obj);
                    return convertToJetpackResponse$lambda$6;
                }
            });
            final BeginCreateCredentialUtil$Companion$convertToJetpackResponse$3 beginCreateCredentialUtil$Companion$convertToJetpackResponse$3 = new Function1<CreateEntry, CreateEntry>() { // from class: androidx.credentials.provider.utils.BeginCreateCredentialUtil$Companion$convertToJetpackResponse$3
                @Override // kotlin.jvm.functions.Function1
                public final CreateEntry invoke(CreateEntry createEntry) {
                    Intrinsics.checkNotNull(createEntry);
                    return createEntry;
                }
            };
            Object BuiltInFictitiousFunctionClassFactory = authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: androidx.credentials.provider.utils.BeginCreateCredentialUtil$Companion$$ExternalSyntheticLambda2
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    CreateEntry convertToJetpackResponse$lambda$7;
                    convertToJetpackResponse$lambda$7 = BeginCreateCredentialUtil.Companion.convertToJetpackResponse$lambda$7(Function1.this, obj);
                    return convertToJetpackResponse$lambda$7;
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            }).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory());
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            List list = (List) BuiltInFictitiousFunctionClassFactory;
            android.service.credentials.RemoteEntry remoteCreateEntry = frameworkResponse.getRemoteCreateEntry();
            if (remoteCreateEntry != null) {
                RemoteEntry.Companion companion = RemoteEntry.INSTANCE;
                Slice slice = remoteCreateEntry.getSlice();
                Intrinsics.checkNotNullExpressionValue(slice, "");
                remoteEntry = companion.fromSlice(slice);
            } else {
                remoteEntry = null;
            }
            return new androidx.credentials.provider.BeginCreateCredentialResponse(list, remoteEntry);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CreateEntry convertToJetpackResponse$lambda$5(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "");
            return (CreateEntry) function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$6(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "");
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CreateEntry convertToJetpackResponse$lambda$7(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "");
            return (CreateEntry) function1.invoke(obj);
        }
    }
}
