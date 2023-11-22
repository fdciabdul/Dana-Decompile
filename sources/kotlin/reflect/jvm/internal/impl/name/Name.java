package kotlin.reflect.jvm.internal.impl.name;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: classes.dex */
public final class Name implements Comparable<Name> {
    private final String name;
    private final boolean special;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4) ? 2 : 3];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i == 1) {
            objArr[1] = "asString";
        } else if (i == 2) {
            objArr[1] = "getIdentifier";
        } else if (i == 3 || i == 4) {
            objArr[1] = "asStringStripSpecialMarkers";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "identifier";
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "special";
                break;
            case 8:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    private Name(String str, boolean z) {
        if (str == null) {
            $$$reportNull$$$0(0);
        }
        this.name = str;
        this.special = z;
    }

    public final String asString() {
        String str = this.name;
        if (str == null) {
            $$$reportNull$$$0(1);
        }
        return str;
    }

    public final String getIdentifier() {
        if (this.special) {
            StringBuilder sb = new StringBuilder();
            sb.append("not identifier: ");
            sb.append(this);
            throw new IllegalStateException(sb.toString());
        }
        String asString = asString();
        if (asString == null) {
            $$$reportNull$$$0(2);
        }
        return asString;
    }

    public final boolean isSpecial() {
        return this.special;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Name name) {
        return this.name.compareTo(name.name);
    }

    public static Name identifier(String str) {
        if (str == null) {
            $$$reportNull$$$0(5);
        }
        return new Name(str, false);
    }

    public static boolean isValidIdentifier(String str) {
        if (str == null) {
            $$$reportNull$$$0(6);
        }
        if (str.isEmpty() || str.startsWith(SimpleComparison.LESS_THAN_OPERATION)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static Name special(String str) {
        if (str == null) {
            $$$reportNull$$$0(7);
        }
        if (!str.startsWith(SimpleComparison.LESS_THAN_OPERATION)) {
            StringBuilder sb = new StringBuilder();
            sb.append("special name must start with '<': ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
        return new Name(str, true);
    }

    public static Name guessByFirstCharacter(String str) {
        if (str == null) {
            $$$reportNull$$$0(8);
        }
        if (str.startsWith(SimpleComparison.LESS_THAN_OPERATION)) {
            return special(str);
        }
        return identifier(str);
    }

    public final String toString() {
        return this.name;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Name) {
            Name name = (Name) obj;
            return this.special == name.special && this.name.equals(name.name);
        }
        return false;
    }

    public final int hashCode() {
        return (this.name.hashCode() * 31) + (this.special ? 1 : 0);
    }
}
