package ru.noties.markwon.html.impl.jsoup;

import java.io.IOException;

/* loaded from: classes6.dex */
public class UncheckedIOException extends RuntimeException {
    public UncheckedIOException(IOException iOException) {
        super(iOException);
    }

    public IOException ioException() {
        return (IOException) getCause();
    }
}
