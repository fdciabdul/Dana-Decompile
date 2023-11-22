package id.dana.rum.okhttp;

import android.webkit.CookieManager;
import id.dana.rum.hash.HashUtils;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/rum/okhttp/OkHttpRumResponseAttributesExtractor;", "Lio/opentelemetry/instrumentation/api/instrumenter/AttributesExtractor;", "Lokhttp3/Request;", "Lokhttp3/Response;", "Lid/dana/rum/okhttp/ServerTimingHeaderParser;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/rum/okhttp/ServerTimingHeaderParser;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OkHttpRumResponseAttributesExtractor implements AttributesExtractor<Request, Response> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ServerTimingHeaderParser KClassImpl$Data$declaredNonStaticMembers$2 = new ServerTimingHeaderParser();

    /* JADX WARN: Removed duplicated region for block: B:114:0x00ff A[Catch: all -> 0x011c, LOOP:1: B:112:0x00f9->B:114:0x00ff, LOOP_END, TryCatch #0 {all -> 0x011c, blocks: (B:83:0x004c, B:85:0x0059, B:93:0x006c, B:95:0x0075, B:98:0x008a, B:103:0x0099, B:104:0x009f, B:106:0x00a5, B:108:0x00c2, B:110:0x00da, B:111:0x00e2, B:112:0x00f9, B:114:0x00ff, B:115:0x0115), top: B:125:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x006c A[Catch: all -> 0x011c, TryCatch #0 {all -> 0x011c, blocks: (B:83:0x004c, B:85:0x0059, B:93:0x006c, B:95:0x0075, B:98:0x008a, B:103:0x0099, B:104:0x009f, B:106:0x00a5, B:108:0x00c2, B:110:0x00da, B:111:0x00e2, B:112:0x00f9, B:114:0x00ff, B:115:0x0115), top: B:125:0x004c }] */
    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void onEnd(io.opentelemetry.api.common.AttributesBuilder r10, io.opentelemetry.context.Context r11, okhttp3.Request r12, okhttp3.Response r13, java.lang.Throwable r14) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.rum.okhttp.OkHttpRumResponseAttributesExtractor.onEnd(io.opentelemetry.api.common.AttributesBuilder, io.opentelemetry.context.Context, java.lang.Object, java.lang.Object, java.lang.Throwable):void");
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public final /* synthetic */ void onStart(AttributesBuilder attributesBuilder, Context context, Request request) {
        Object m3179constructorimpl;
        List list;
        Request request2 = request;
        Intrinsics.checkNotNullParameter(attributesBuilder, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(request2, "");
        attributesBuilder.put((AttributeKey<AttributeKey<String>>) AttributeKey.CC.stringKey("component"), (AttributeKey<String>) SemanticAttributes.FaasTriggerValues.HTTP);
        try {
            Result.Companion companion = Result.INSTANCE;
            OkHttpRumResponseAttributesExtractor okHttpRumResponseAttributesExtractor = this;
            String obj = request2.url().url().toString();
            if (obj == null) {
                list = CollectionsKt.emptyList();
            } else {
                ArrayList arrayList = new ArrayList();
                String cookie = CookieManager.getInstance().getCookie(obj);
                String str = cookie;
                if (!(str == null || str.length() == 0)) {
                    List split$default = StringsKt.split$default((CharSequence) cookie.toString(), new String[]{";"}, false, 0, 6, (Object) null);
                    if ((!split$default.isEmpty()) != false) {
                        Iterator it = split$default.iterator();
                        while (it.hasNext()) {
                            List split$default2 = StringsKt.split$default((CharSequence) ((String) it.next()), new String[]{"="}, false, 0, 6, (Object) null);
                            if (split$default2.size() == 2 && StringsKt.equals(StringsKt.trim((CharSequence) ((String) split$default2.get(0))).toString(), "ALIPAYJSESSIONID", true)) {
                                arrayList.add(split$default2.get(1));
                            }
                        }
                    }
                }
                list = arrayList;
            }
            List<String> list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (String str2 : list2) {
                HashUtils hashUtils = HashUtils.INSTANCE;
                arrayList2.add(StringsKt.take(HashUtils.PlaceComponentResult(str2), 20));
            }
            m3179constructorimpl = Result.m3179constructorimpl(arrayList2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m3179constructorimpl = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m3186isSuccessimpl(m3179constructorimpl)) {
            List list3 = (List) m3179constructorimpl;
            if (true ^ list3.isEmpty()) {
                attributesBuilder.put("dana.sessionIdBefore", CollectionsKt.joinToString$default(list3, ", ", null, null, 0, null, null, 62, null));
            }
        }
    }
}
