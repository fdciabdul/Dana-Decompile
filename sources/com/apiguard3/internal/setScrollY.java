package com.apiguard3.internal;

import java.math.BigInteger;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class setScrollY extends setHovered {
    private static int APIGuard = 1;
    private static int getSharedInstance;
    private final Object valueOf;

    public setScrollY(Boolean bool) {
        this.valueOf = setBottom.getSharedInstance(bool);
    }

    public setScrollY(Number number) {
        this.valueOf = setBottom.getSharedInstance(number);
    }

    public setScrollY(String str) {
        this.valueOf = setBottom.getSharedInstance(str);
    }

    public final boolean getState() {
        int i = (APIGuard + 3) % 128;
        getSharedInstance = i;
        boolean z = this.valueOf instanceof Boolean;
        int i2 = i + 67;
        APIGuard = i2 % 128;
        if (i2 % 2 == 0) {
            throw new NullPointerException();
        }
        return z;
    }

    @Override // com.apiguard3.internal.setHovered
    public final boolean valueOf() {
        if ((!getState()) != true) {
            getSharedInstance = (APIGuard + 53) % 128;
            return ((Boolean) this.valueOf).booleanValue();
        }
        boolean parseBoolean = Boolean.parseBoolean(getSharedInstance());
        int i = getSharedInstance + 61;
        APIGuard = i % 128;
        if (!(i % 2 == 0)) {
            return parseBoolean;
        }
        throw new ArithmeticException();
    }

    public final boolean updateKernel() {
        int i = (getSharedInstance + 65) % 128;
        APIGuard = i;
        boolean z = this.valueOf instanceof Number;
        int i2 = i + 55;
        getSharedInstance = i2 % 128;
        if ((i2 % 2 != 0 ? (char) 28 : (char) 27) != 28) {
            return z;
        }
        throw new ArithmeticException();
    }

    @Override // com.apiguard3.internal.setHovered
    public final Number AGState() {
        Number number;
        int i;
        Object obj = this.valueOf;
        if (obj instanceof String) {
            number = new setY((String) this.valueOf);
            i = getSharedInstance + 15;
        } else {
            number = (Number) obj;
            i = getSharedInstance + 117;
        }
        APIGuard = i % 128;
        return number;
    }

    public final boolean APIGuard$Callback() {
        int i = getSharedInstance + 101;
        APIGuard = i % 128;
        if (i % 2 == 0) {
            throw null;
        }
        return this.valueOf instanceof String;
    }

    @Override // com.apiguard3.internal.setHovered
    public final String getSharedInstance() {
        if ((updateKernel() ? (char) 3 : '`') == 3) {
            APIGuard = (getSharedInstance + 63) % 128;
            return AGState().toString();
        } else if (getState()) {
            String obj = ((Boolean) this.valueOf).toString();
            getSharedInstance = (APIGuard + 35) % 128;
            return obj;
        } else {
            return (String) this.valueOf;
        }
    }

    public final int hashCode() {
        long doubleToLongBits;
        if (this.valueOf != null) {
            if ((getSharedInstance(this) ? 'G' : (char) 25) != 25) {
                doubleToLongBits = AGState().longValue();
            } else {
                Object obj = this.valueOf;
                if (obj instanceof Number) {
                    APIGuard = (getSharedInstance + 45) % 128;
                    doubleToLongBits = Double.doubleToLongBits(AGState().doubleValue());
                } else {
                    return obj.hashCode();
                }
            }
            return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        }
        int i = APIGuard + 3;
        getSharedInstance = i % 128;
        if ((i % 2 != 0 ? Typography.greater : '#') != '>') {
            return 31;
        }
        throw new ArithmeticException();
    }

    public final boolean equals(Object obj) {
        if ((this == obj ? '.' : 'W') == '.') {
            APIGuard = (getSharedInstance + 77) % 128;
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            setScrollY setscrolly = (setScrollY) obj;
            if (this.valueOf == null) {
                return (setscrolly.valueOf == null ? '^' : 'I') == '^';
            }
            if (getSharedInstance(this)) {
                int i = getSharedInstance + 65;
                APIGuard = i % 128;
                if (i % 2 == 0) {
                    getSharedInstance(setscrolly);
                    throw new NullPointerException();
                } else if (getSharedInstance(setscrolly)) {
                    int i2 = APIGuard + 45;
                    getSharedInstance = i2 % 128;
                    if (i2 % 2 != 0) {
                        AGState();
                        setscrolly.AGState();
                        throw new NullPointerException();
                    } else if (AGState().longValue() == setscrolly.AGState().longValue()) {
                        return true;
                    } else {
                        getSharedInstance = (APIGuard + 43) % 128;
                        return false;
                    }
                }
            }
            Object obj2 = this.valueOf;
            if ((obj2 instanceof Number ? '-' : 'U') == 'U' || !(setscrolly.valueOf instanceof Number)) {
                return obj2.equals(setscrolly.valueOf);
            }
            double doubleValue = AGState().doubleValue();
            double doubleValue2 = setscrolly.AGState().doubleValue();
            if (doubleValue != doubleValue2) {
                if ((Double.isNaN(doubleValue) ? Typography.less : 'b') == 'b' || !Double.isNaN(doubleValue2)) {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean getSharedInstance(setScrollY setscrolly) {
        int i = APIGuard;
        int i2 = i + 123;
        getSharedInstance = i2 % 128;
        if (i2 % 2 == 0) {
            Object obj = setscrolly.valueOf;
            if ((!(obj instanceof Number)) == true) {
                return false;
            }
            Number number = (Number) obj;
            if (!(number instanceof BigInteger) && !(number instanceof Long) && (!(number instanceof Integer)) == true && !(number instanceof Short)) {
                if ((number instanceof Byte ? 'G' : 'a') != 'G') {
                    return false;
                }
            }
            int i3 = i + 47;
            getSharedInstance = i3 % 128;
            if ((i3 % 2 != 0 ? 'X' : (char) 15) == 15) {
                return true;
            }
            throw new NullPointerException();
        }
        Object obj2 = setscrolly.valueOf;
        throw null;
    }
}
