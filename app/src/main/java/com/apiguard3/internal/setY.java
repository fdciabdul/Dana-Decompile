package com.apiguard3.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.math.BigDecimal;

/* loaded from: classes7.dex */
public final class setY extends Number {
    private static int getSharedInstance = 1;
    private static int values;
    private final String value;

    public setY(String str) {
        this.value = str;
    }

    @Override // java.lang.Number
    public final int intValue() {
        int i = values + 65;
        getSharedInstance = i % 128;
        try {
            try {
                if ((i % 2 == 0 ? '_' : '.') != '_') {
                    return Integer.parseInt(this.value);
                }
                Integer.parseInt(this.value);
                throw new ArithmeticException();
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.value);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.value).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        int i = values + 49;
        getSharedInstance = i % 128;
        try {
            if (i % 2 == 0) {
                Long.parseLong(this.value);
                throw new ArithmeticException();
            }
            return Long.parseLong(this.value);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.value).longValue();
        }
    }

    @Override // java.lang.Number
    public final float floatValue() {
        getSharedInstance = (values + 23) % 128;
        float parseFloat = Float.parseFloat(this.value);
        getSharedInstance = (values + 105) % 128;
        return parseFloat;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        getSharedInstance = (values + 97) % 128;
        double parseDouble = Double.parseDouble(this.value);
        getSharedInstance = (values + 53) % 128;
        return parseDouble;
    }

    public final String toString() {
        int i = getSharedInstance + 9;
        values = i % 128;
        if ((i % 2 != 0 ? '\r' : '/') != '\r') {
            return this.value;
        }
        throw new NullPointerException();
    }

    private Object writeReplace() throws ObjectStreamException {
        BigDecimal bigDecimal = new BigDecimal(this.value);
        int i = getSharedInstance + 17;
        values = i % 128;
        if ((i % 2 != 0 ? ':' : '8') != ':') {
            return bigDecimal;
        }
        throw new NullPointerException();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    public final int hashCode() {
        values = (getSharedInstance + 61) % 128;
        int hashCode = this.value.hashCode();
        getSharedInstance = (values + 43) % 128;
        return hashCode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof setY ? 'Q' : (char) 20) != 20) {
            getSharedInstance = (values + 75) % 128;
            String str = this.value;
            String str2 = ((setY) obj).value;
            if (str != str2) {
                if ((str.equals(str2) ? (char) 29 : '?') != 29) {
                    values = (getSharedInstance + 123) % 128;
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
