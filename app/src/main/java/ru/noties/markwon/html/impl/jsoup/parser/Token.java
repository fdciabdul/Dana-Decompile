package ru.noties.markwon.html.impl.jsoup.parser;

import com.j256.ormlite.stmt.query.SimpleComparison;
import ru.noties.markwon.html.impl.jsoup.helper.Normalizer;
import ru.noties.markwon.html.impl.jsoup.helper.Validate;
import ru.noties.markwon.html.impl.jsoup.nodes.Attributes;

/* loaded from: classes6.dex */
public abstract class Token {
    public final TokenType BuiltInFictitiousFunctionClassFactory;

    /* loaded from: classes6.dex */
    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    public abstract Token PlaceComponentResult();

    protected Token(TokenType tokenType) {
        this.BuiltInFictitiousFunctionClassFactory = tokenType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getAuthRequestContext(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    /* loaded from: classes6.dex */
    public static final class Doctype extends Token {
        String KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        final StringBuilder NetworkUserEntityData$$ExternalSyntheticLambda0;
        final StringBuilder PlaceComponentResult;
        final StringBuilder getAuthRequestContext;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Doctype() {
            super(TokenType.Doctype);
            this.PlaceComponentResult = new StringBuilder();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.getAuthRequestContext = new StringBuilder();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new StringBuilder();
            this.MyBillsEntityDataFactory = false;
        }

        @Override // ru.noties.markwon.html.impl.jsoup.parser.Token
        public final Token PlaceComponentResult() {
            StringBuilder sb = this.PlaceComponentResult;
            if (sb != null) {
                sb.delete(0, sb.length());
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            StringBuilder sb2 = this.getAuthRequestContext;
            if (sb2 != null) {
                sb2.delete(0, sb2.length());
            }
            StringBuilder sb3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (sb3 != null) {
                sb3.delete(0, sb3.length());
            }
            this.MyBillsEntityDataFactory = false;
            return this;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class Tag extends Token {
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        String MyBillsEntityDataFactory;
        public String NetworkUserEntityData$$ExternalSyntheticLambda0;
        public Attributes PlaceComponentResult;
        boolean getAuthRequestContext;
        private boolean getErrorConfigVersion;
        private StringBuilder lookAheadTest;
        private String moveToNextValue;
        public boolean scheduleImpl;

        protected Tag(TokenType tokenType) {
            super(tokenType);
            this.lookAheadTest = new StringBuilder();
            this.getAuthRequestContext = false;
            this.getErrorConfigVersion = false;
            this.scheduleImpl = false;
        }

        @Override // ru.noties.markwon.html.impl.jsoup.parser.Token
        /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
        public Tag PlaceComponentResult() {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            this.MyBillsEntityDataFactory = null;
            StringBuilder sb = this.lookAheadTest;
            if (sb != null) {
                sb.delete(0, sb.length());
            }
            this.moveToNextValue = null;
            this.getAuthRequestContext = false;
            this.getErrorConfigVersion = false;
            this.scheduleImpl = false;
            this.PlaceComponentResult = null;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void BuiltInFictitiousFunctionClassFactory() {
            String str;
            if (this.PlaceComponentResult == null) {
                this.PlaceComponentResult = new Attributes();
            }
            String str2 = this.MyBillsEntityDataFactory;
            if (str2 != null) {
                String trim = str2.trim();
                this.MyBillsEntityDataFactory = trim;
                if (trim.length() > 0) {
                    if (this.getErrorConfigVersion) {
                        str = this.lookAheadTest.length() > 0 ? this.lookAheadTest.toString() : this.moveToNextValue;
                    } else {
                        str = this.getAuthRequestContext ? "" : null;
                    }
                    Attributes attributes = this.PlaceComponentResult;
                    String str3 = this.MyBillsEntityDataFactory;
                    int BuiltInFictitiousFunctionClassFactory = attributes.BuiltInFictitiousFunctionClassFactory(str3);
                    if (BuiltInFictitiousFunctionClassFactory != -1) {
                        attributes.PlaceComponentResult[BuiltInFictitiousFunctionClassFactory] = str;
                    } else {
                        int i = attributes.getAuthRequestContext + 1;
                        Validate.PlaceComponentResult(i >= attributes.getAuthRequestContext);
                        String[] strArr = attributes.BuiltInFictitiousFunctionClassFactory;
                        int length = strArr.length;
                        if (length < i) {
                            int i2 = length >= 4 ? attributes.getAuthRequestContext * 2 : 4;
                            if (i <= i2) {
                                i = i2;
                            }
                            String[] strArr2 = new String[i];
                            System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i));
                            attributes.BuiltInFictitiousFunctionClassFactory = strArr2;
                            String[] strArr3 = attributes.PlaceComponentResult;
                            String[] strArr4 = new String[i];
                            System.arraycopy(strArr3, 0, strArr4, 0, Math.min(strArr3.length, i));
                            attributes.PlaceComponentResult = strArr4;
                        }
                        String[] strArr5 = attributes.BuiltInFictitiousFunctionClassFactory;
                        int i3 = attributes.getAuthRequestContext;
                        strArr5[i3] = str3;
                        attributes.PlaceComponentResult[i3] = str;
                        attributes.getAuthRequestContext = i3 + 1;
                    }
                }
            }
            this.MyBillsEntityDataFactory = null;
            this.getAuthRequestContext = false;
            this.getErrorConfigVersion = false;
            StringBuilder sb = this.lookAheadTest;
            if (sb != null) {
                sb.delete(0, sb.length());
            }
            this.moveToNextValue = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void MyBillsEntityDataFactory(char c) {
            String valueOf = String.valueOf(c);
            String str = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (str != null) {
                valueOf = str.concat(valueOf);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = valueOf;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Normalizer.getAuthRequestContext(valueOf);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void KClassImpl$Data$declaredNonStaticMembers$2(char c) {
            this.getErrorConfigVersion = true;
            String str = this.moveToNextValue;
            if (str != null) {
                this.lookAheadTest.append(str);
                this.moveToNextValue = null;
            }
            this.lookAheadTest.append(c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void getAuthRequestContext(String str) {
            this.getErrorConfigVersion = true;
            String str2 = this.moveToNextValue;
            if (str2 != null) {
                this.lookAheadTest.append(str2);
                this.moveToNextValue = null;
            }
            if (this.lookAheadTest.length() == 0) {
                this.moveToNextValue = str;
            } else {
                this.lookAheadTest.append(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void PlaceComponentResult(int[] iArr) {
            this.getErrorConfigVersion = true;
            String str = this.moveToNextValue;
            if (str != null) {
                this.lookAheadTest.append(str);
                this.moveToNextValue = null;
            }
            for (int i : iArr) {
                this.lookAheadTest.appendCodePoint(i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class StartTag extends Tag {
        public StartTag() {
            super(TokenType.StartTag);
            this.PlaceComponentResult = new Attributes();
        }

        @Override // ru.noties.markwon.html.impl.jsoup.parser.Token.Tag
        /* renamed from: MyBillsEntityDataFactory */
        public final Tag PlaceComponentResult() {
            super.PlaceComponentResult();
            this.PlaceComponentResult = new Attributes();
            return this;
        }

        public final String toString() {
            if (this.PlaceComponentResult != null && this.PlaceComponentResult.getAuthRequestContext > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(SimpleComparison.LESS_THAN_OPERATION);
                String str = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Validate.BuiltInFictitiousFunctionClassFactory(str == null || str.length() == 0);
                sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                sb.append(" ");
                sb.append(this.PlaceComponentResult.toString());
                sb.append(SimpleComparison.GREATER_THAN_OPERATION);
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(SimpleComparison.LESS_THAN_OPERATION);
            String str2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Validate.BuiltInFictitiousFunctionClassFactory(str2 == null || str2.length() == 0);
            sb2.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb2.append(SimpleComparison.GREATER_THAN_OPERATION);
            return sb2.toString();
        }

        @Override // ru.noties.markwon.html.impl.jsoup.parser.Token.Tag, ru.noties.markwon.html.impl.jsoup.parser.Token
        public final /* synthetic */ Token PlaceComponentResult() {
            super.PlaceComponentResult();
            this.PlaceComponentResult = new Attributes();
            return this;
        }
    }

    /* loaded from: classes6.dex */
    public static final class EndTag extends Tag {
        /* JADX INFO: Access modifiers changed from: package-private */
        public EndTag() {
            super(TokenType.EndTag);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("</");
            String str = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Validate.BuiltInFictitiousFunctionClassFactory(str == null || str.length() == 0);
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static final class Comment extends Token {
        final StringBuilder MyBillsEntityDataFactory;
        boolean getAuthRequestContext;

        @Override // ru.noties.markwon.html.impl.jsoup.parser.Token
        public final Token PlaceComponentResult() {
            StringBuilder sb = this.MyBillsEntityDataFactory;
            if (sb != null) {
                sb.delete(0, sb.length());
            }
            this.getAuthRequestContext = false;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Comment() {
            super(TokenType.Comment);
            this.MyBillsEntityDataFactory = new StringBuilder();
            this.getAuthRequestContext = false;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("<!--");
            sb.append(this.MyBillsEntityDataFactory.toString());
            sb.append("-->");
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static class Character extends Token {
        public String PlaceComponentResult;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Character() {
            super(TokenType.Character);
        }

        @Override // ru.noties.markwon.html.impl.jsoup.parser.Token
        public final Token PlaceComponentResult() {
            this.PlaceComponentResult = null;
            return this;
        }

        public String toString() {
            return this.PlaceComponentResult;
        }
    }

    /* loaded from: classes6.dex */
    public static final class CData extends Character {
        /* JADX INFO: Access modifiers changed from: package-private */
        public CData(String str) {
            this.PlaceComponentResult = str;
        }

        @Override // ru.noties.markwon.html.impl.jsoup.parser.Token.Character
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("<![CDATA[");
            sb.append(this.PlaceComponentResult);
            sb.append("]]>");
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static final class EOF extends Token {
        @Override // ru.noties.markwon.html.impl.jsoup.parser.Token
        public final Token PlaceComponentResult() {
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public EOF() {
            super(TokenType.EOF);
        }
    }
}
