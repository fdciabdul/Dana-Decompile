package com.splunk.rum;

import java.nio.charset.StandardCharsets;
import zipkin2.Span;
import zipkin2.codec.BytesEncoder;
import zipkin2.codec.Encoding;
import zipkin2.internal.JsonCodec;
import zipkin2.internal.V2SpanWriter;
import zipkin2.internal.WriteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CustomZipkinEncoder implements BytesEncoder<Span> {
    private final WriteBuffer.Writer<Span> getAuthRequestContext = new V2SpanWriter();

    @Override // zipkin2.codec.BytesEncoder
    public Encoding encoding() {
        return Encoding.JSON;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // zipkin2.codec.BytesEncoder
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public byte[] encode(Span span) {
        String str = span.tags().get(SplunkSpanDataModifier.PlaceComponentResult.getKey());
        String str2 = new String(JsonCodec.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, span), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        sb.append("\"name\":\"");
        sb.append(span.name());
        sb.append("\"");
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\"name\":\"");
        sb2.append(str);
        sb2.append("\"");
        return str2.replace(obj, sb2.toString()).getBytes(StandardCharsets.UTF_8);
    }
}
