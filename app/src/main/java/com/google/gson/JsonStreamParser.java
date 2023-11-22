package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes7.dex */
public final class JsonStreamParser implements Iterator<JsonElement>, j$.util.Iterator {
    private final Object lock;
    private final JsonReader parser;

    @Override // j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.getAuthRequestContext(this, consumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(java.util.function.Consumer<? super JsonElement> consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new Object();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final JsonElement next() throws JsonParseException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return Streams.parse(this.parser);
        } catch (JsonParseException e) {
            if (e.getCause() instanceof EOFException) {
                throw new NoSuchElementException();
            }
            throw e;
        } catch (OutOfMemoryError e2) {
            throw new JsonParseException("Failed parsing JSON source to Json", e2);
        } catch (StackOverflowError e3) {
            throw new JsonParseException("Failed parsing JSON source to Json", e3);
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        boolean z;
        synchronized (this.lock) {
            try {
                try {
                    z = this.parser.peek() != JsonToken.END_DOCUMENT;
                } catch (MalformedJsonException e) {
                    throw new JsonSyntaxException(e);
                }
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        }
        return z;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
