package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
public enum ToNumberPolicy implements ToNumberStrategy {
    DOUBLE { // from class: com.google.gson.ToNumberPolicy.1
        @Override // com.google.gson.ToNumberStrategy
        public final Double readNumber(JsonReader jsonReader) throws IOException {
            return Double.valueOf(jsonReader.nextDouble());
        }
    },
    LAZILY_PARSED_NUMBER { // from class: com.google.gson.ToNumberPolicy.2
        @Override // com.google.gson.ToNumberStrategy
        public final Number readNumber(JsonReader jsonReader) throws IOException {
            return new LazilyParsedNumber(jsonReader.nextString());
        }
    },
    LONG_OR_DOUBLE { // from class: com.google.gson.ToNumberPolicy.3
        @Override // com.google.gson.ToNumberStrategy
        public final Number readNumber(JsonReader jsonReader) throws IOException, JsonParseException {
            String nextString = jsonReader.nextString();
            try {
                try {
                    return Long.valueOf(Long.parseLong(nextString));
                } catch (NumberFormatException unused) {
                    Double valueOf = Double.valueOf(nextString);
                    if ((valueOf.isInfinite() || valueOf.isNaN()) && !jsonReader.isLenient()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("JSON forbids NaN and infinities: ");
                        sb.append(valueOf);
                        sb.append("; at path ");
                        sb.append(jsonReader.getPreviousPath());
                        throw new MalformedJsonException(sb.toString());
                    }
                    return valueOf;
                }
            } catch (NumberFormatException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot parse ");
                sb2.append(nextString);
                sb2.append("; at path ");
                sb2.append(jsonReader.getPreviousPath());
                throw new JsonParseException(sb2.toString(), e);
            }
        }
    },
    BIG_DECIMAL { // from class: com.google.gson.ToNumberPolicy.4
        @Override // com.google.gson.ToNumberStrategy
        public final BigDecimal readNumber(JsonReader jsonReader) throws IOException {
            String nextString = jsonReader.nextString();
            try {
                return new BigDecimal(nextString);
            } catch (NumberFormatException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot parse ");
                sb.append(nextString);
                sb.append("; at path ");
                sb.append(jsonReader.getPreviousPath());
                throw new JsonParseException(sb.toString(), e);
            }
        }
    }
}
