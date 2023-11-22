package androidx.credentials.provider.utils;

import android.app.slice.Slice;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.service.credentials.Action;
import android.service.credentials.BeginGetCredentialOption;
import android.service.credentials.BeginGetCredentialRequest;
import android.service.credentials.BeginGetCredentialResponse;
import androidx.credentials.provider.Action;
import androidx.credentials.provider.AuthenticationAction;
import androidx.credentials.provider.BeginGetCredentialOption;
import androidx.credentials.provider.BeginGetCredentialRequest;
import androidx.credentials.provider.CallingAppInfo;
import androidx.credentials.provider.CredentialEntry;
import androidx.credentials.provider.RemoteEntry;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import j$.util.Collection;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/credentials/provider/utils/BeginGetCredentialUtil;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BeginGetCredentialUtil {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b(\u0010)J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010 \u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00152\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0017H\u0002¢\u0006\u0004\b \u0010\u001cJ%\u0010#\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u0017H\u0002¢\u0006\u0004\b#\u0010\u001cJ!\u0010&\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b&\u0010'"}, d2 = {"Landroidx/credentials/provider/utils/BeginGetCredentialUtil$Companion;", "", "Landroidx/credentials/provider/BeginGetCredentialRequest;", "request", "Landroid/service/credentials/BeginGetCredentialRequest;", "convertToFrameworkRequest", "(Landroidx/credentials/provider/BeginGetCredentialRequest;)Landroid/service/credentials/BeginGetCredentialRequest;", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "response", "Landroid/service/credentials/BeginGetCredentialResponse;", "convertToFrameworkResponse", "(Landroidx/credentials/provider/BeginGetCredentialResponse;)Landroid/service/credentials/BeginGetCredentialResponse;", "Landroidx/credentials/provider/BeginGetCredentialOption;", "option", "Landroid/service/credentials/BeginGetCredentialOption;", "convertToJetpackBeginOption", "(Landroidx/credentials/provider/BeginGetCredentialOption;)Landroid/service/credentials/BeginGetCredentialOption;", "convertToJetpackRequest$credentials_release", "(Landroid/service/credentials/BeginGetCredentialRequest;)Landroidx/credentials/provider/BeginGetCredentialRequest;", "convertToJetpackResponse", "(Landroid/service/credentials/BeginGetCredentialResponse;)Landroidx/credentials/provider/BeginGetCredentialResponse;", "Landroid/service/credentials/BeginGetCredentialResponse$Builder;", "builder", "", "Landroidx/credentials/provider/Action;", "actionEntries", "", "populateActionEntries", "(Landroid/service/credentials/BeginGetCredentialResponse$Builder;Ljava/util/List;)V", "frameworkBuilder", "Landroidx/credentials/provider/AuthenticationAction;", "authenticationActions", "populateAuthenticationEntries", "Landroidx/credentials/provider/CredentialEntry;", "credentialEntries", "populateCredentialEntries", "Landroidx/credentials/provider/RemoteEntry;", "remoteEntry", "populateRemoteEntry", "(Landroid/service/credentials/BeginGetCredentialResponse$Builder;Landroidx/credentials/provider/RemoteEntry;)V", "<init>", "()V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BeginGetCredentialRequest convertToJetpackRequest$credentials_release(android.service.credentials.BeginGetCredentialRequest request) {
            CallingAppInfo callingAppInfo;
            Intrinsics.checkNotNullParameter(request, "");
            ArrayList arrayList = new ArrayList();
            List<BeginGetCredentialOption> beginGetCredentialOptions = request.getBeginGetCredentialOptions();
            Intrinsics.checkNotNullExpressionValue(beginGetCredentialOptions, "");
            for (BeginGetCredentialOption beginGetCredentialOption : beginGetCredentialOptions) {
                BeginGetCredentialOption.Companion companion = androidx.credentials.provider.BeginGetCredentialOption.INSTANCE;
                String id2 = beginGetCredentialOption.getId();
                Intrinsics.checkNotNullExpressionValue(id2, "");
                String type = beginGetCredentialOption.getType();
                Intrinsics.checkNotNullExpressionValue(type, "");
                Bundle candidateQueryData = beginGetCredentialOption.getCandidateQueryData();
                Intrinsics.checkNotNullExpressionValue(candidateQueryData, "");
                arrayList.add(companion.createFrom$credentials_release(id2, type, candidateQueryData));
            }
            android.service.credentials.CallingAppInfo callingAppInfo2 = request.getCallingAppInfo();
            if (callingAppInfo2 != null) {
                String packageName = callingAppInfo2.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "");
                SigningInfo signingInfo = callingAppInfo2.getSigningInfo();
                Intrinsics.checkNotNullExpressionValue(signingInfo, "");
                callingAppInfo = new CallingAppInfo(packageName, signingInfo, callingAppInfo2.getOrigin());
            } else {
                callingAppInfo = null;
            }
            return new BeginGetCredentialRequest(arrayList, callingAppInfo);
        }

        public final BeginGetCredentialResponse convertToFrameworkResponse(androidx.credentials.provider.BeginGetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(response, "");
            BeginGetCredentialResponse.Builder builder = new BeginGetCredentialResponse.Builder();
            populateCredentialEntries(builder, response.getCredentialEntries());
            populateActionEntries(builder, response.getActions());
            populateAuthenticationEntries(builder, response.getAuthenticationActions());
            populateRemoteEntry(builder, response.getRemoteEntry());
            BeginGetCredentialResponse build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "");
            return build;
        }

        private final void populateRemoteEntry(BeginGetCredentialResponse.Builder frameworkBuilder, RemoteEntry remoteEntry) {
            if (remoteEntry == null) {
                return;
            }
            frameworkBuilder.setRemoteCredentialEntry(new android.service.credentials.RemoteEntry(RemoteEntry.INSTANCE.toSlice(remoteEntry)));
        }

        private final void populateAuthenticationEntries(BeginGetCredentialResponse.Builder frameworkBuilder, List<AuthenticationAction> authenticationActions) {
            Iterator<T> it = authenticationActions.iterator();
            while (it.hasNext()) {
                frameworkBuilder.addAuthenticationAction(new Action(AuthenticationAction.INSTANCE.toSlice((AuthenticationAction) it.next())));
            }
        }

        private final void populateActionEntries(BeginGetCredentialResponse.Builder builder, List<androidx.credentials.provider.Action> actionEntries) {
            Iterator<T> it = actionEntries.iterator();
            while (it.hasNext()) {
                builder.addAction(new Action(androidx.credentials.provider.Action.INSTANCE.toSlice((androidx.credentials.provider.Action) it.next())));
            }
        }

        private final void populateCredentialEntries(BeginGetCredentialResponse.Builder builder, List<? extends CredentialEntry> credentialEntries) {
            for (CredentialEntry credentialEntry : credentialEntries) {
                Slice slice$credentials_release = CredentialEntry.INSTANCE.toSlice$credentials_release(credentialEntry);
                if (slice$credentials_release != null) {
                    builder.addCredentialEntry(new android.service.credentials.CredentialEntry(new android.service.credentials.BeginGetCredentialOption(credentialEntry.getBeginGetCredentialOption().getId(), credentialEntry.getType(), Bundle.EMPTY), slice$credentials_release));
                }
            }
        }

        public final android.service.credentials.BeginGetCredentialRequest convertToFrameworkRequest(BeginGetCredentialRequest request) {
            Intrinsics.checkNotNullParameter(request, "");
            BeginGetCredentialRequest.Builder builder = new BeginGetCredentialRequest.Builder();
            if (request.getCallingAppInfo() != null) {
                builder.setCallingAppInfo(new android.service.credentials.CallingAppInfo(request.getCallingAppInfo().getPackageName(), request.getCallingAppInfo().getSigningInfo(), request.getCallingAppInfo().getOrigin()));
            }
            Stream authRequestContext = Collection.EL.getAuthRequestContext(request.getBeginGetCredentialOptions());
            final BeginGetCredentialUtil$Companion$convertToFrameworkRequest$1 beginGetCredentialUtil$Companion$convertToFrameworkRequest$1 = new Function1<androidx.credentials.provider.BeginGetCredentialOption, android.service.credentials.BeginGetCredentialOption>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToFrameworkRequest$1
                @Override // kotlin.jvm.functions.Function1
                public final android.service.credentials.BeginGetCredentialOption invoke(androidx.credentials.provider.BeginGetCredentialOption beginGetCredentialOption) {
                    android.service.credentials.BeginGetCredentialOption convertToJetpackBeginOption;
                    BeginGetCredentialUtil.Companion companion = BeginGetCredentialUtil.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(beginGetCredentialOption, "");
                    convertToJetpackBeginOption = companion.convertToJetpackBeginOption(beginGetCredentialOption);
                    return convertToJetpackBeginOption;
                }
            };
            android.service.credentials.BeginGetCredentialRequest build = builder.setBeginGetCredentialOptions((List) authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda9
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    android.service.credentials.BeginGetCredentialOption convertToFrameworkRequest$lambda$5;
                    convertToFrameworkRequest$lambda$5 = BeginGetCredentialUtil.Companion.convertToFrameworkRequest$lambda$5(Function1.this, obj);
                    return convertToFrameworkRequest$lambda$5;
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            }).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory())).build();
            Intrinsics.checkNotNullExpressionValue(build, "");
            return build;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final android.service.credentials.BeginGetCredentialOption convertToFrameworkRequest$lambda$5(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "");
            return (android.service.credentials.BeginGetCredentialOption) function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final android.service.credentials.BeginGetCredentialOption convertToJetpackBeginOption(androidx.credentials.provider.BeginGetCredentialOption option) {
            return new android.service.credentials.BeginGetCredentialOption(option.getId(), option.getType(), option.getCandidateQueryData());
        }

        public final androidx.credentials.provider.BeginGetCredentialResponse convertToJetpackResponse(BeginGetCredentialResponse response) {
            RemoteEntry remoteEntry;
            Intrinsics.checkNotNullParameter(response, "");
            Stream authRequestContext = Collection.EL.getAuthRequestContext(response.getCredentialEntries());
            final BeginGetCredentialUtil$Companion$convertToJetpackResponse$1 beginGetCredentialUtil$Companion$convertToJetpackResponse$1 = new Function1<android.service.credentials.CredentialEntry, CredentialEntry>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$1
                @Override // kotlin.jvm.functions.Function1
                public final CredentialEntry invoke(android.service.credentials.CredentialEntry credentialEntry) {
                    CredentialEntry.Companion companion = CredentialEntry.INSTANCE;
                    Slice slice = credentialEntry.getSlice();
                    Intrinsics.checkNotNullExpressionValue(slice, "");
                    return companion.createFrom$credentials_release(slice);
                }
            };
            Stream KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda0
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    CredentialEntry convertToJetpackResponse$lambda$6;
                    convertToJetpackResponse$lambda$6 = BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$6(Function1.this, obj);
                    return convertToJetpackResponse$lambda$6;
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            });
            final BeginGetCredentialUtil$Companion$convertToJetpackResponse$2 beginGetCredentialUtil$Companion$convertToJetpackResponse$2 = new Function1<CredentialEntry, Boolean>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$2
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(CredentialEntry credentialEntry) {
                    return Boolean.valueOf(credentialEntry != null);
                }
            };
            Stream authRequestContext2 = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(new Predicate() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda1
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
                    boolean convertToJetpackResponse$lambda$7;
                    convertToJetpackResponse$lambda$7 = BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$7(Function1.this, obj);
                    return convertToJetpackResponse$lambda$7;
                }
            });
            final BeginGetCredentialUtil$Companion$convertToJetpackResponse$3 beginGetCredentialUtil$Companion$convertToJetpackResponse$3 = new Function1<CredentialEntry, CredentialEntry>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$3
                @Override // kotlin.jvm.functions.Function1
                public final CredentialEntry invoke(CredentialEntry credentialEntry) {
                    Intrinsics.checkNotNull(credentialEntry);
                    return credentialEntry;
                }
            };
            Object BuiltInFictitiousFunctionClassFactory = authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda2
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    CredentialEntry convertToJetpackResponse$lambda$8;
                    convertToJetpackResponse$lambda$8 = BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$8(Function1.this, obj);
                    return convertToJetpackResponse$lambda$8;
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            }).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory());
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            List list = (List) BuiltInFictitiousFunctionClassFactory;
            Stream authRequestContext3 = Collection.EL.getAuthRequestContext(response.getActions());
            final BeginGetCredentialUtil$Companion$convertToJetpackResponse$4 beginGetCredentialUtil$Companion$convertToJetpackResponse$4 = new Function1<Action, androidx.credentials.provider.Action>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$4
                @Override // kotlin.jvm.functions.Function1
                public final androidx.credentials.provider.Action invoke(Action action) {
                    Action.Companion companion = androidx.credentials.provider.Action.INSTANCE;
                    Slice slice = action.getSlice();
                    Intrinsics.checkNotNullExpressionValue(slice, "");
                    return companion.fromSlice(slice);
                }
            };
            Stream KClassImpl$Data$declaredNonStaticMembers$22 = authRequestContext3.KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda3
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    androidx.credentials.provider.Action convertToJetpackResponse$lambda$9;
                    convertToJetpackResponse$lambda$9 = BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$9(Function1.this, obj);
                    return convertToJetpackResponse$lambda$9;
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            });
            final BeginGetCredentialUtil$Companion$convertToJetpackResponse$5 beginGetCredentialUtil$Companion$convertToJetpackResponse$5 = new Function1<androidx.credentials.provider.Action, Boolean>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$5
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(androidx.credentials.provider.Action action) {
                    return Boolean.valueOf(action != null);
                }
            };
            Stream authRequestContext4 = KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext(new Predicate() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda4
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
                    boolean convertToJetpackResponse$lambda$10;
                    convertToJetpackResponse$lambda$10 = BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$10(Function1.this, obj);
                    return convertToJetpackResponse$lambda$10;
                }
            });
            final BeginGetCredentialUtil$Companion$convertToJetpackResponse$6 beginGetCredentialUtil$Companion$convertToJetpackResponse$6 = new Function1<androidx.credentials.provider.Action, androidx.credentials.provider.Action>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$6
                @Override // kotlin.jvm.functions.Function1
                public final androidx.credentials.provider.Action invoke(androidx.credentials.provider.Action action) {
                    Intrinsics.checkNotNull(action);
                    return action;
                }
            };
            Object BuiltInFictitiousFunctionClassFactory2 = authRequestContext4.KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda5
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    androidx.credentials.provider.Action convertToJetpackResponse$lambda$11;
                    convertToJetpackResponse$lambda$11 = BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$11(Function1.this, obj);
                    return convertToJetpackResponse$lambda$11;
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            }).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory());
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
            List list2 = (List) BuiltInFictitiousFunctionClassFactory2;
            Stream authRequestContext5 = Collection.EL.getAuthRequestContext(response.getAuthenticationActions());
            final BeginGetCredentialUtil$Companion$convertToJetpackResponse$7 beginGetCredentialUtil$Companion$convertToJetpackResponse$7 = new Function1<android.service.credentials.Action, AuthenticationAction>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$7
                @Override // kotlin.jvm.functions.Function1
                public final AuthenticationAction invoke(android.service.credentials.Action action) {
                    AuthenticationAction.Companion companion = AuthenticationAction.INSTANCE;
                    Slice slice = action.getSlice();
                    Intrinsics.checkNotNullExpressionValue(slice, "");
                    return companion.fromSlice(slice);
                }
            };
            Stream KClassImpl$Data$declaredNonStaticMembers$23 = authRequestContext5.KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda6
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    AuthenticationAction convertToJetpackResponse$lambda$12;
                    convertToJetpackResponse$lambda$12 = BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$12(Function1.this, obj);
                    return convertToJetpackResponse$lambda$12;
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            });
            final BeginGetCredentialUtil$Companion$convertToJetpackResponse$8 beginGetCredentialUtil$Companion$convertToJetpackResponse$8 = new Function1<AuthenticationAction, Boolean>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$8
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(AuthenticationAction authenticationAction) {
                    return Boolean.valueOf(authenticationAction != null);
                }
            };
            Stream authRequestContext6 = KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext(new Predicate() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda7
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
                    boolean convertToJetpackResponse$lambda$13;
                    convertToJetpackResponse$lambda$13 = BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$13(Function1.this, obj);
                    return convertToJetpackResponse$lambda$13;
                }
            });
            final BeginGetCredentialUtil$Companion$convertToJetpackResponse$9 beginGetCredentialUtil$Companion$convertToJetpackResponse$9 = new Function1<AuthenticationAction, AuthenticationAction>() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$convertToJetpackResponse$9
                @Override // kotlin.jvm.functions.Function1
                public final AuthenticationAction invoke(AuthenticationAction authenticationAction) {
                    Intrinsics.checkNotNull(authenticationAction);
                    return authenticationAction;
                }
            };
            Object BuiltInFictitiousFunctionClassFactory3 = authRequestContext6.KClassImpl$Data$declaredNonStaticMembers$2(new Function() { // from class: androidx.credentials.provider.utils.BeginGetCredentialUtil$Companion$$ExternalSyntheticLambda8
                @Override // j$.util.function.Function
                /* renamed from: andThen */
                public final /* synthetic */ Function mo3169andThen(Function function) {
                    return Function.CC.getAuthRequestContext(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    AuthenticationAction convertToJetpackResponse$lambda$14;
                    convertToJetpackResponse$lambda$14 = BeginGetCredentialUtil.Companion.convertToJetpackResponse$lambda$14(Function1.this, obj);
                    return convertToJetpackResponse$lambda$14;
                }

                @Override // j$.util.function.Function
                public final /* synthetic */ Function compose(Function function) {
                    return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
                }
            }).BuiltInFictitiousFunctionClassFactory(Collectors.MyBillsEntityDataFactory());
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory3, "");
            List list3 = (List) BuiltInFictitiousFunctionClassFactory3;
            android.service.credentials.RemoteEntry remoteCredentialEntry = response.getRemoteCredentialEntry();
            if (remoteCredentialEntry != null) {
                RemoteEntry.Companion companion = RemoteEntry.INSTANCE;
                Slice slice = remoteCredentialEntry.getSlice();
                Intrinsics.checkNotNullExpressionValue(slice, "");
                remoteEntry = companion.fromSlice(slice);
            } else {
                remoteEntry = null;
            }
            return new androidx.credentials.provider.BeginGetCredentialResponse(list, list2, list3, remoteEntry);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CredentialEntry convertToJetpackResponse$lambda$6(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "");
            return (CredentialEntry) function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$7(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "");
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CredentialEntry convertToJetpackResponse$lambda$8(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "");
            return (CredentialEntry) function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final androidx.credentials.provider.Action convertToJetpackResponse$lambda$9(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "");
            return (androidx.credentials.provider.Action) function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$10(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "");
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final androidx.credentials.provider.Action convertToJetpackResponse$lambda$11(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "");
            return (androidx.credentials.provider.Action) function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AuthenticationAction convertToJetpackResponse$lambda$12(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "");
            return (AuthenticationAction) function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$13(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "");
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AuthenticationAction convertToJetpackResponse$lambda$14(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "");
            return (AuthenticationAction) function1.invoke(obj);
        }
    }
}
