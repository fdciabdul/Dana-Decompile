package id.dana.rum.quake;

import com.alipay.imobile.network.quake.NetworkResponse;
import com.alipay.imobile.network.quake.Request;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesExtractor;
import io.opentelemetry.instrumentation.api.instrumenter.http.HttpClientAttributesExtractorBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016R&\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0014\u0010\t\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013"}, d2 = {"Lid/dana/rum/quake/QuakeTracingBuilder;", "", "", "Lio/opentelemetry/instrumentation/api/instrumenter/AttributesExtractor;", "Lcom/alipay/imobile/network/quake/Request;", "Lcom/alipay/imobile/network/quake/NetworkResponse;", "PlaceComponentResult", "Ljava/util/List;", "Lid/dana/rum/quake/QuakeHttpAttributesGetter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/rum/quake/QuakeHttpAttributesGetter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/opentelemetry/instrumentation/api/instrumenter/http/HttpClientAttributesExtractorBuilder;", "Lio/opentelemetry/instrumentation/api/instrumenter/http/HttpClientAttributesExtractorBuilder;", "getAuthRequestContext", "Lid/dana/rum/quake/QuakeNetAttributesGetter;", "Lid/dana/rum/quake/QuakeNetAttributesGetter;", "MyBillsEntityDataFactory", "Lio/opentelemetry/api/OpenTelemetry;", "Lio/opentelemetry/api/OpenTelemetry;", "p0", "<init>", "(Lio/opentelemetry/api/OpenTelemetry;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class QuakeTracingBuilder {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final QuakeHttpAttributesGetter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final HttpClientAttributesExtractorBuilder<Request, NetworkResponse> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final OpenTelemetry BuiltInFictitiousFunctionClassFactory;
    public final List<AttributesExtractor<Request, NetworkResponse>> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final QuakeNetAttributesGetter MyBillsEntityDataFactory;

    public QuakeTracingBuilder(OpenTelemetry openTelemetry) {
        Intrinsics.checkNotNullParameter(openTelemetry, "");
        this.BuiltInFictitiousFunctionClassFactory = openTelemetry;
        this.PlaceComponentResult = new ArrayList();
        QuakeHttpAttributesGetter quakeHttpAttributesGetter = new QuakeHttpAttributesGetter();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = quakeHttpAttributesGetter;
        this.MyBillsEntityDataFactory = new QuakeNetAttributesGetter();
        HttpClientAttributesExtractorBuilder<Request, NetworkResponse> builder = HttpClientAttributesExtractor.builder(quakeHttpAttributesGetter);
        Intrinsics.checkNotNullExpressionValue(builder, "");
        this.getAuthRequestContext = builder;
    }
}
