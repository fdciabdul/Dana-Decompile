package ru.noties.markwon.html.impl.jsoup.parser;

import com.huawei.hms.framework.common.ContainerUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import id.dana.cashier.view.InputCardNumberView;
import kotlin.text.Typography;
import ru.noties.markwon.html.impl.jsoup.helper.Normalizer;
import ru.noties.markwon.html.impl.jsoup.parser.Token;

/* loaded from: classes6.dex */
public enum TokeniserState {
    Data { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.1
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char NetworkUserEntityData$$ExternalSyntheticLambda0 = characterReader.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.PlaceComponentResult(String.valueOf(characterReader.MyBillsEntityDataFactory()));
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 == '&') {
                TokeniserState tokeniserState = CharacterReferenceInData;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 != '<') {
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == 65535) {
                    tokeniser.getAuthRequestContext(new Token.EOF());
                } else {
                    tokeniser.PlaceComponentResult(characterReader.KClassImpl$Data$declaredNonStaticMembers$2());
                }
            } else {
                TokeniserState tokeniserState2 = TagOpen;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState2;
            }
        }
    },
    CharacterReferenceInData { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.2
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readCharRef(tokeniser, Data);
        }
    },
    Rcdata { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.3
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char NetworkUserEntityData$$ExternalSyntheticLambda0 = characterReader.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) {
                tokeniser.getAuthRequestContext(this);
                characterReader.MyBillsEntityDataFactory++;
                tokeniser.PlaceComponentResult("�");
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 == '&') {
                TokeniserState tokeniserState = CharacterReferenceInRcdata;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 != '<') {
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == 65535) {
                    tokeniser.getAuthRequestContext(new Token.EOF());
                } else {
                    tokeniser.PlaceComponentResult(characterReader.MyBillsEntityDataFactory(Typography.amp, Typography.less, 0));
                }
            } else {
                TokeniserState tokeniserState2 = RcdataLessthanSign;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState2;
            }
        }
    },
    CharacterReferenceInRcdata { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.4
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readCharRef(tokeniser, Rcdata);
        }
    },
    Rawtext { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.5
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readData(tokeniser, characterReader, this, RawtextLessthanSign);
        }
    },
    ScriptData { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.6
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readData(tokeniser, characterReader, this, ScriptDataLessthanSign);
        }
    },
    PLAINTEXT { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.7
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char NetworkUserEntityData$$ExternalSyntheticLambda0 = characterReader.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) {
                tokeniser.getAuthRequestContext(this);
                characterReader.MyBillsEntityDataFactory++;
                tokeniser.PlaceComponentResult("�");
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 == 65535) {
                tokeniser.getAuthRequestContext(new Token.EOF());
            } else {
                tokeniser.PlaceComponentResult(characterReader.getAuthRequestContext((char) 0));
            }
        }
    },
    TagOpen { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.8
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char NetworkUserEntityData$$ExternalSyntheticLambda0 = characterReader.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 == '!') {
                TokeniserState tokeniserState = MarkupDeclarationOpen;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 == '/') {
                TokeniserState tokeniserState2 = EndTagOpen;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState2;
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 == '?') {
                TokeniserState tokeniserState3 = BogusComment;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState3;
            } else if (!characterReader.GetContactSyncConfig()) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.PlaceComponentResult(SimpleComparison.LESS_THAN_OPERATION);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1 = tokeniser.DatabaseTableConfigUtil.PlaceComponentResult();
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = TagName;
            }
        }
    },
    EndTagOpen { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.9
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.scheduleImpl()) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.PlaceComponentResult("</");
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (!characterReader.GetContactSyncConfig()) {
                if (characterReader.PlaceComponentResult(Typography.greater)) {
                    tokeniser.getAuthRequestContext(this);
                    TokeniserState tokeniserState = Data;
                    tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
                    return;
                }
                tokeniser.getAuthRequestContext(this);
                TokeniserState tokeniserState2 = BogusComment;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState2;
            } else {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1 = tokeniser.lookAheadTest.PlaceComponentResult();
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = TagName;
            }
        }
    },
    TagName { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.10
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String moveToNextValue = characterReader.moveToNextValue();
            Token.Tag tag = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
            String str = tag.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (str != null) {
                moveToNextValue = str.concat(moveToNextValue);
            }
            tag.NetworkUserEntityData$$ExternalSyntheticLambda0 = moveToNextValue;
            tag.KClassImpl$Data$declaredNonStaticMembers$2 = Normalizer.getAuthRequestContext(moveToNextValue);
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                Token.Tag tag2 = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                String str2 = TokeniserState.replacementStr;
                String str3 = tag2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (str3 != null) {
                    str2 = str3.concat(str2);
                }
                tag2.NetworkUserEntityData$$ExternalSyntheticLambda0 = str2;
                tag2.KClassImpl$Data$declaredNonStaticMembers$2 = Normalizer.getAuthRequestContext(str2);
                return;
            }
            if (MyBillsEntityDataFactory != ' ') {
                if (MyBillsEntityDataFactory == '/') {
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = SelfClosingStartTag;
                    return;
                } else if (MyBillsEntityDataFactory == '>') {
                    Token.Tag tag3 = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (tag3.MyBillsEntityDataFactory != null) {
                        tag3.BuiltInFictitiousFunctionClassFactory();
                    }
                    tokeniser.getAuthRequestContext(tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                    return;
                } else if (MyBillsEntityDataFactory == 65535) {
                    tokeniser.MyBillsEntityDataFactory(this);
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                    return;
                } else if (MyBillsEntityDataFactory != '\t' && MyBillsEntityDataFactory != '\n' && MyBillsEntityDataFactory != '\f' && MyBillsEntityDataFactory != '\r') {
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(MyBillsEntityDataFactory);
                    return;
                }
            }
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BeforeAttributeName;
        }
    },
    RcdataLessthanSign { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.11
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.PlaceComponentResult('/')) {
                if (characterReader.GetContactSyncConfig() && tokeniser.GetContactSyncConfig != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("</");
                    sb.append(tokeniser.GetContactSyncConfig);
                    if (!characterReader.MyBillsEntityDataFactory(sb.toString())) {
                        Token.Tag PlaceComponentResult = tokeniser.lookAheadTest.PlaceComponentResult();
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1 = PlaceComponentResult;
                        String str = tokeniser.GetContactSyncConfig;
                        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
                        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = Normalizer.getAuthRequestContext(str);
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1 = PlaceComponentResult;
                        Token.Tag tag = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                        if (tag.MyBillsEntityDataFactory != null) {
                            tag.BuiltInFictitiousFunctionClassFactory();
                        }
                        tokeniser.getAuthRequestContext(tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1);
                        characterReader.MyBillsEntityDataFactory--;
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                        return;
                    }
                }
                tokeniser.PlaceComponentResult(SimpleComparison.LESS_THAN_OPERATION);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Rcdata;
                return;
            }
            Token.getAuthRequestContext(tokeniser.moveToNextValue);
            TokeniserState tokeniserState = RCDATAEndTagOpen;
            tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
        }
    },
    RCDATAEndTagOpen { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.12
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.GetContactSyncConfig()) {
                tokeniser.PlaceComponentResult("</");
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Rcdata;
                return;
            }
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1 = tokeniser.lookAheadTest.PlaceComponentResult();
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(characterReader.NetworkUserEntityData$$ExternalSyntheticLambda0());
            tokeniser.moveToNextValue.append(characterReader.NetworkUserEntityData$$ExternalSyntheticLambda0());
            TokeniserState tokeniserState = RCDATAEndTagName;
            tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
        }
    },
    RCDATAEndTagName { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.13
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.GetContactSyncConfig()) {
                String authRequestContext = characterReader.getAuthRequestContext();
                Token.Tag tag = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                String str = tag.NetworkUserEntityData$$ExternalSyntheticLambda0;
                String concat = str != null ? str.concat(authRequestContext) : authRequestContext;
                tag.NetworkUserEntityData$$ExternalSyntheticLambda0 = concat;
                tag.KClassImpl$Data$declaredNonStaticMembers$2 = Normalizer.getAuthRequestContext(concat);
                tokeniser.moveToNextValue.append(authRequestContext);
                return;
            }
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == '\t' || MyBillsEntityDataFactory == '\n' || MyBillsEntityDataFactory == '\f' || MyBillsEntityDataFactory == '\r' || MyBillsEntityDataFactory == ' ') {
                if (tokeniser.PlaceComponentResult()) {
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BeforeAttributeName;
                    return;
                }
            } else if (MyBillsEntityDataFactory == '/') {
                if (!tokeniser.PlaceComponentResult()) {
                    anythingElse(tokeniser, characterReader);
                    return;
                } else {
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = SelfClosingStartTag;
                    return;
                }
            } else if (MyBillsEntityDataFactory == '>') {
                if (!tokeniser.PlaceComponentResult()) {
                    anythingElse(tokeniser, characterReader);
                    return;
                }
                Token.Tag tag2 = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (tag2.MyBillsEntityDataFactory != null) {
                    tag2.BuiltInFictitiousFunctionClassFactory();
                }
                tokeniser.getAuthRequestContext(tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                return;
            }
            anythingElse(tokeniser, characterReader);
        }

        private void anythingElse(Tokeniser tokeniser, CharacterReader characterReader) {
            StringBuilder sb = new StringBuilder();
            sb.append("</");
            sb.append(tokeniser.moveToNextValue.toString());
            tokeniser.PlaceComponentResult(sb.toString());
            characterReader.MyBillsEntityDataFactory--;
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Rcdata;
        }
    },
    RawtextLessthanSign { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.14
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.PlaceComponentResult('/')) {
                Token.getAuthRequestContext(tokeniser.moveToNextValue);
                TokeniserState tokeniserState = RawtextEndTagOpen;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
                return;
            }
            tokeniser.PlaceComponentResult(SimpleComparison.LESS_THAN_OPERATION);
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Rawtext;
        }
    },
    RawtextEndTagOpen { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.15
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readEndTag(tokeniser, characterReader, RawtextEndTagName, Rawtext);
        }
    },
    RawtextEndTagName { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.16
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, Rawtext);
        }
    },
    ScriptDataLessthanSign { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.17
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == '!') {
                tokeniser.PlaceComponentResult("<!");
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataEscapeStart;
            } else if (MyBillsEntityDataFactory != '/') {
                tokeniser.PlaceComponentResult(SimpleComparison.LESS_THAN_OPERATION);
                characterReader.MyBillsEntityDataFactory--;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptData;
            } else {
                Token.getAuthRequestContext(tokeniser.moveToNextValue);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataEndTagOpen;
            }
        }
    },
    ScriptDataEndTagOpen { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.18
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.readEndTag(tokeniser, characterReader, ScriptDataEndTagName, ScriptData);
        }
    },
    ScriptDataEndTagName { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.19
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, ScriptData);
        }
    },
    ScriptDataEscapeStart { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.20
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.PlaceComponentResult('-')) {
                tokeniser.PlaceComponentResult("-");
                TokeniserState tokeniserState = ScriptDataEscapeStartDash;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
                return;
            }
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptData;
        }
    },
    ScriptDataEscapeStartDash { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.21
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.PlaceComponentResult('-')) {
                tokeniser.PlaceComponentResult("-");
                TokeniserState tokeniserState = ScriptDataEscapedDashDash;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
                return;
            }
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptData;
        }
    },
    ScriptDataEscaped { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.22
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.scheduleImpl()) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                return;
            }
            char NetworkUserEntityData$$ExternalSyntheticLambda0 = characterReader.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) {
                tokeniser.getAuthRequestContext(this);
                characterReader.MyBillsEntityDataFactory++;
                tokeniser.PlaceComponentResult("�");
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 == '-') {
                tokeniser.PlaceComponentResult("-");
                TokeniserState tokeniserState = ScriptDataEscapedDash;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 == '<') {
                TokeniserState tokeniserState2 = ScriptDataEscapedLessthanSign;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState2;
            } else {
                tokeniser.PlaceComponentResult(characterReader.MyBillsEntityDataFactory('-', Typography.less, 0));
            }
        }
    },
    ScriptDataEscapedDash { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.23
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.scheduleImpl()) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                return;
            }
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.PlaceComponentResult("�");
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataEscaped;
            } else if (MyBillsEntityDataFactory == '-') {
                tokeniser.PlaceComponentResult(String.valueOf(MyBillsEntityDataFactory));
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataEscapedDashDash;
            } else if (MyBillsEntityDataFactory != '<') {
                tokeniser.PlaceComponentResult(String.valueOf(MyBillsEntityDataFactory));
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataEscaped;
            } else {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataEscapedLessthanSign;
            }
        }
    },
    ScriptDataEscapedDashDash { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.24
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.scheduleImpl()) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                return;
            }
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.PlaceComponentResult("�");
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataEscaped;
            } else if (MyBillsEntityDataFactory == '-') {
                tokeniser.PlaceComponentResult(String.valueOf(MyBillsEntityDataFactory));
            } else if (MyBillsEntityDataFactory == '<') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataEscapedLessthanSign;
            } else if (MyBillsEntityDataFactory != '>') {
                tokeniser.PlaceComponentResult(String.valueOf(MyBillsEntityDataFactory));
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataEscaped;
            } else {
                tokeniser.PlaceComponentResult(String.valueOf(MyBillsEntityDataFactory));
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptData;
            }
        }
    },
    ScriptDataEscapedLessthanSign { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.25
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.GetContactSyncConfig()) {
                if (characterReader.PlaceComponentResult('/')) {
                    Token.getAuthRequestContext(tokeniser.moveToNextValue);
                    TokeniserState tokeniserState = ScriptDataEscapedEndTagOpen;
                    tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
                    return;
                }
                tokeniser.PlaceComponentResult(SimpleComparison.LESS_THAN_OPERATION);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataEscaped;
                return;
            }
            Token.getAuthRequestContext(tokeniser.moveToNextValue);
            tokeniser.moveToNextValue.append(characterReader.NetworkUserEntityData$$ExternalSyntheticLambda0());
            StringBuilder sb = new StringBuilder();
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(characterReader.NetworkUserEntityData$$ExternalSyntheticLambda0());
            tokeniser.PlaceComponentResult(sb.toString());
            TokeniserState tokeniserState2 = ScriptDataDoubleEscapeStart;
            tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState2;
        }
    },
    ScriptDataEscapedEndTagOpen { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.26
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.GetContactSyncConfig()) {
                tokeniser.PlaceComponentResult("</");
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataEscaped;
                return;
            }
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1 = tokeniser.lookAheadTest.PlaceComponentResult();
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.MyBillsEntityDataFactory(characterReader.NetworkUserEntityData$$ExternalSyntheticLambda0());
            tokeniser.moveToNextValue.append(characterReader.NetworkUserEntityData$$ExternalSyntheticLambda0());
            TokeniserState tokeniserState = ScriptDataEscapedEndTagName;
            tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
        }
    },
    ScriptDataEscapedEndTagName { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.27
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.28
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataDoubleEscapeTag(tokeniser, characterReader, ScriptDataDoubleEscaped, ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.29
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char NetworkUserEntityData$$ExternalSyntheticLambda0 = characterReader.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) {
                tokeniser.getAuthRequestContext(this);
                characterReader.MyBillsEntityDataFactory++;
                tokeniser.PlaceComponentResult("�");
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 == '-') {
                tokeniser.PlaceComponentResult(String.valueOf(NetworkUserEntityData$$ExternalSyntheticLambda0));
                TokeniserState tokeniserState = ScriptDataDoubleEscapedDash;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 != '<') {
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == 65535) {
                    tokeniser.MyBillsEntityDataFactory(this);
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                    return;
                }
                tokeniser.PlaceComponentResult(characterReader.MyBillsEntityDataFactory('-', Typography.less, 0));
            } else {
                tokeniser.PlaceComponentResult(String.valueOf(NetworkUserEntityData$$ExternalSyntheticLambda0));
                TokeniserState tokeniserState2 = ScriptDataDoubleEscapedLessthanSign;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState2;
            }
        }
    },
    ScriptDataDoubleEscapedDash { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.30
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.PlaceComponentResult("�");
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataDoubleEscaped;
            } else if (MyBillsEntityDataFactory == '-') {
                tokeniser.PlaceComponentResult(String.valueOf(MyBillsEntityDataFactory));
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataDoubleEscapedDashDash;
            } else if (MyBillsEntityDataFactory == '<') {
                tokeniser.PlaceComponentResult(String.valueOf(MyBillsEntityDataFactory));
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataDoubleEscapedLessthanSign;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.PlaceComponentResult(String.valueOf(MyBillsEntityDataFactory));
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataDoubleEscaped;
            }
        }
    },
    ScriptDataDoubleEscapedDashDash { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.31
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.PlaceComponentResult("�");
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataDoubleEscaped;
            } else if (MyBillsEntityDataFactory == '-') {
                tokeniser.PlaceComponentResult(String.valueOf(MyBillsEntityDataFactory));
            } else if (MyBillsEntityDataFactory == '<') {
                tokeniser.PlaceComponentResult(String.valueOf(MyBillsEntityDataFactory));
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataDoubleEscapedLessthanSign;
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.PlaceComponentResult(String.valueOf(MyBillsEntityDataFactory));
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptData;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.PlaceComponentResult(String.valueOf(MyBillsEntityDataFactory));
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataDoubleEscaped;
            }
        }
    },
    ScriptDataDoubleEscapedLessthanSign { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.32
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.PlaceComponentResult('/')) {
                tokeniser.PlaceComponentResult("/");
                Token.getAuthRequestContext(tokeniser.moveToNextValue);
                TokeniserState tokeniserState = ScriptDataDoubleEscapeEnd;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
                return;
            }
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = ScriptDataDoubleEscaped;
        }
    },
    ScriptDataDoubleEscapeEnd { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.33
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataDoubleEscapeTag(tokeniser, characterReader, ScriptDataEscaped, ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.34
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory();
                characterReader.MyBillsEntityDataFactory--;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AttributeName;
            } else if (MyBillsEntityDataFactory != ' ') {
                if (MyBillsEntityDataFactory != '\"' && MyBillsEntityDataFactory != '\'') {
                    if (MyBillsEntityDataFactory == '/') {
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = SelfClosingStartTag;
                        return;
                    } else if (MyBillsEntityDataFactory == 65535) {
                        tokeniser.MyBillsEntityDataFactory(this);
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                        return;
                    } else if (MyBillsEntityDataFactory == '\t' || MyBillsEntityDataFactory == '\n' || MyBillsEntityDataFactory == '\f' || MyBillsEntityDataFactory == '\r') {
                        return;
                    } else {
                        switch (MyBillsEntityDataFactory) {
                            case '<':
                            case '=':
                                break;
                            case '>':
                                Token.Tag tag = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                if (tag.MyBillsEntityDataFactory != null) {
                                    tag.BuiltInFictitiousFunctionClassFactory();
                                }
                                tokeniser.getAuthRequestContext(tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                                return;
                            default:
                                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory();
                                characterReader.MyBillsEntityDataFactory--;
                                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AttributeName;
                                return;
                        }
                    }
                }
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory();
                Token.Tag tag2 = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                String valueOf = String.valueOf(MyBillsEntityDataFactory);
                String str = tag2.MyBillsEntityDataFactory;
                if (str != null) {
                    valueOf = str.concat(valueOf);
                }
                tag2.MyBillsEntityDataFactory = valueOf;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AttributeName;
            }
        }
    },
    AttributeName { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.35
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String BuiltInFictitiousFunctionClassFactory = characterReader.BuiltInFictitiousFunctionClassFactory(attributeNameCharsSorted);
            Token.Tag tag = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
            String str = tag.MyBillsEntityDataFactory;
            if (str != null) {
                BuiltInFictitiousFunctionClassFactory = str.concat(BuiltInFictitiousFunctionClassFactory);
            }
            tag.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                Token.Tag tag2 = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                String str2 = tag2.MyBillsEntityDataFactory;
                tag2.MyBillsEntityDataFactory = str2 != null ? str2.concat("�") : "�";
                return;
            }
            if (MyBillsEntityDataFactory != ' ') {
                if (MyBillsEntityDataFactory != '\"' && MyBillsEntityDataFactory != '\'') {
                    if (MyBillsEntityDataFactory == '/') {
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = SelfClosingStartTag;
                        return;
                    } else if (MyBillsEntityDataFactory == 65535) {
                        tokeniser.MyBillsEntityDataFactory(this);
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                        return;
                    } else if (MyBillsEntityDataFactory != '\t' && MyBillsEntityDataFactory != '\n' && MyBillsEntityDataFactory != '\f' && MyBillsEntityDataFactory != '\r') {
                        switch (MyBillsEntityDataFactory) {
                            case '<':
                                break;
                            case '=':
                                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BeforeAttributeValue;
                                return;
                            case '>':
                                Token.Tag tag3 = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                if (tag3.MyBillsEntityDataFactory != null) {
                                    tag3.BuiltInFictitiousFunctionClassFactory();
                                }
                                tokeniser.getAuthRequestContext(tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                                return;
                            default:
                                Token.Tag tag4 = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                String valueOf = String.valueOf(MyBillsEntityDataFactory);
                                String str3 = tag4.MyBillsEntityDataFactory;
                                if (str3 != null) {
                                    valueOf = str3.concat(valueOf);
                                }
                                tag4.MyBillsEntityDataFactory = valueOf;
                                return;
                        }
                    }
                }
                tokeniser.getAuthRequestContext(this);
                Token.Tag tag5 = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                String valueOf2 = String.valueOf(MyBillsEntityDataFactory);
                String str4 = tag5.MyBillsEntityDataFactory;
                if (str4 != null) {
                    valueOf2 = str4.concat(valueOf2);
                }
                tag5.MyBillsEntityDataFactory = valueOf2;
                return;
            }
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AfterAttributeName;
        }
    },
    AfterAttributeName { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.36
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                Token.Tag tag = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                String str = tag.MyBillsEntityDataFactory;
                tag.MyBillsEntityDataFactory = str != null ? str.concat("�") : "�";
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AttributeName;
            } else if (MyBillsEntityDataFactory != ' ') {
                if (MyBillsEntityDataFactory != '\"' && MyBillsEntityDataFactory != '\'') {
                    if (MyBillsEntityDataFactory == '/') {
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = SelfClosingStartTag;
                        return;
                    } else if (MyBillsEntityDataFactory == 65535) {
                        tokeniser.MyBillsEntityDataFactory(this);
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                        return;
                    } else if (MyBillsEntityDataFactory == '\t' || MyBillsEntityDataFactory == '\n' || MyBillsEntityDataFactory == '\f' || MyBillsEntityDataFactory == '\r') {
                        return;
                    } else {
                        switch (MyBillsEntityDataFactory) {
                            case '<':
                                break;
                            case '=':
                                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BeforeAttributeValue;
                                return;
                            case '>':
                                Token.Tag tag2 = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                if (tag2.MyBillsEntityDataFactory != null) {
                                    tag2.BuiltInFictitiousFunctionClassFactory();
                                }
                                tokeniser.getAuthRequestContext(tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                                return;
                            default:
                                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory();
                                characterReader.MyBillsEntityDataFactory--;
                                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AttributeName;
                                return;
                        }
                    }
                }
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory();
                Token.Tag tag3 = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                String valueOf = String.valueOf(MyBillsEntityDataFactory);
                String str2 = tag3.MyBillsEntityDataFactory;
                if (str2 != null) {
                    valueOf = str2.concat(valueOf);
                }
                tag3.MyBillsEntityDataFactory = valueOf;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AttributeName;
            }
        }
    },
    BeforeAttributeValue { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.37
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(TokeniserState.replacementChar);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AttributeValue_unquoted;
            } else if (MyBillsEntityDataFactory != ' ') {
                if (MyBillsEntityDataFactory != '\"') {
                    if (MyBillsEntityDataFactory != '`') {
                        if (MyBillsEntityDataFactory == 65535) {
                            tokeniser.MyBillsEntityDataFactory(this);
                            Token.Tag tag = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                            if (tag.MyBillsEntityDataFactory != null) {
                                tag.BuiltInFictitiousFunctionClassFactory();
                            }
                            tokeniser.getAuthRequestContext(tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1);
                            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                            return;
                        } else if (MyBillsEntityDataFactory == '\t' || MyBillsEntityDataFactory == '\n' || MyBillsEntityDataFactory == '\f' || MyBillsEntityDataFactory == '\r') {
                            return;
                        } else {
                            if (MyBillsEntityDataFactory == '&') {
                                characterReader.MyBillsEntityDataFactory--;
                                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AttributeValue_unquoted;
                                return;
                            } else if (MyBillsEntityDataFactory != '\'') {
                                switch (MyBillsEntityDataFactory) {
                                    case '<':
                                    case '=':
                                        break;
                                    case '>':
                                        tokeniser.getAuthRequestContext(this);
                                        Token.Tag tag2 = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                        if (tag2.MyBillsEntityDataFactory != null) {
                                            tag2.BuiltInFictitiousFunctionClassFactory();
                                        }
                                        tokeniser.getAuthRequestContext(tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                                        return;
                                    default:
                                        characterReader.MyBillsEntityDataFactory--;
                                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AttributeValue_unquoted;
                                        return;
                                }
                            } else {
                                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AttributeValue_singleQuoted;
                                return;
                            }
                        }
                    }
                    tokeniser.getAuthRequestContext(this);
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AttributeValue_unquoted;
                    return;
                }
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AttributeValue_doubleQuoted;
            }
        }
    },
    AttributeValue_doubleQuoted { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.38
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory(attributeDoubleValueCharsSorted);
            if (MyBillsEntityDataFactory.length() > 0) {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext(MyBillsEntityDataFactory);
            } else {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext = true;
            }
            char MyBillsEntityDataFactory2 = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory2 == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(TokeniserState.replacementChar);
            } else if (MyBillsEntityDataFactory2 == '\"') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AfterAttributeValue_quoted;
            } else if (MyBillsEntityDataFactory2 != '&') {
                if (MyBillsEntityDataFactory2 == 65535) {
                    tokeniser.MyBillsEntityDataFactory(this);
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                    return;
                }
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2);
            } else {
                int[] authRequestContext = tokeniser.getAuthRequestContext(Character.valueOf(Typography.quote), true);
                if (authRequestContext != null) {
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult(authRequestContext);
                } else {
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(Typography.amp);
                }
            }
        }
    },
    AttributeValue_singleQuoted { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.39
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory(attributeSingleValueCharsSorted);
            if (MyBillsEntityDataFactory.length() > 0) {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext(MyBillsEntityDataFactory);
            } else {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext = true;
            }
            char MyBillsEntityDataFactory2 = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory2 == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(TokeniserState.replacementChar);
            } else if (MyBillsEntityDataFactory2 == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory2 != '&') {
                if (MyBillsEntityDataFactory2 != '\'') {
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2);
                } else {
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AfterAttributeValue_quoted;
                }
            } else {
                int[] authRequestContext = tokeniser.getAuthRequestContext('\'', true);
                if (authRequestContext != null) {
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult(authRequestContext);
                } else {
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(Typography.amp);
                }
            }
        }
    },
    AttributeValue_unquoted { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.40
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String BuiltInFictitiousFunctionClassFactory = characterReader.BuiltInFictitiousFunctionClassFactory(attributeValueUnquoted);
            if (BuiltInFictitiousFunctionClassFactory.length() > 0) {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory);
            }
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(TokeniserState.replacementChar);
                return;
            }
            if (MyBillsEntityDataFactory != ' ') {
                if (MyBillsEntityDataFactory != '\"' && MyBillsEntityDataFactory != '`') {
                    if (MyBillsEntityDataFactory == 65535) {
                        tokeniser.MyBillsEntityDataFactory(this);
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                        return;
                    } else if (MyBillsEntityDataFactory != '\t' && MyBillsEntityDataFactory != '\n' && MyBillsEntityDataFactory != '\f' && MyBillsEntityDataFactory != '\r') {
                        if (MyBillsEntityDataFactory == '&') {
                            int[] authRequestContext = tokeniser.getAuthRequestContext(Character.valueOf(Typography.greater), true);
                            if (authRequestContext != null) {
                                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult(authRequestContext);
                                return;
                            } else {
                                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(Typography.amp);
                                return;
                            }
                        } else if (MyBillsEntityDataFactory != '\'') {
                            switch (MyBillsEntityDataFactory) {
                                case '<':
                                case '=':
                                    break;
                                case '>':
                                    Token.Tag tag = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                    if (tag.MyBillsEntityDataFactory != null) {
                                        tag.BuiltInFictitiousFunctionClassFactory();
                                    }
                                    tokeniser.getAuthRequestContext(tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1);
                                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                                    return;
                                default:
                                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
                                    return;
                            }
                        }
                    }
                }
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
                return;
            }
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BeforeAttributeName;
        }
    },
    AfterAttributeValue_quoted { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.41
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory != '\t' && MyBillsEntityDataFactory != '\n' && MyBillsEntityDataFactory != '\f' && MyBillsEntityDataFactory != '\r' && MyBillsEntityDataFactory != ' ') {
                if (MyBillsEntityDataFactory == '/') {
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = SelfClosingStartTag;
                    return;
                } else if (MyBillsEntityDataFactory == '>') {
                    Token.Tag tag = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (tag.MyBillsEntityDataFactory != null) {
                        tag.BuiltInFictitiousFunctionClassFactory();
                    }
                    tokeniser.getAuthRequestContext(tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                    return;
                } else if (MyBillsEntityDataFactory == 65535) {
                    tokeniser.MyBillsEntityDataFactory(this);
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                    return;
                } else {
                    tokeniser.getAuthRequestContext(this);
                    characterReader.MyBillsEntityDataFactory--;
                }
            }
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BeforeAttributeName;
        }
    },
    SelfClosingStartTag { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.42
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == '>') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1.scheduleImpl = true;
                Token.Tag tag = tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (tag.MyBillsEntityDataFactory != null) {
                    tag.BuiltInFictitiousFunctionClassFactory();
                }
                tokeniser.getAuthRequestContext(tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getAuthRequestContext(this);
                characterReader.MyBillsEntityDataFactory--;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BeforeAttributeName;
            }
        }
    },
    BogusComment { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.43
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            characterReader.MyBillsEntityDataFactory--;
            Token.Comment comment = new Token.Comment();
            comment.getAuthRequestContext = true;
            comment.MyBillsEntityDataFactory.append(characterReader.getAuthRequestContext(Typography.greater));
            tokeniser.getAuthRequestContext(comment);
            TokeniserState tokeniserState = Data;
            tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
        }
    },
    MarkupDeclarationOpen { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.44
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.KClassImpl$Data$declaredNonStaticMembers$2("--")) {
                if (!characterReader.BuiltInFictitiousFunctionClassFactory("DOCTYPE")) {
                    if (!characterReader.KClassImpl$Data$declaredNonStaticMembers$2("[CDATA[")) {
                        tokeniser.getAuthRequestContext(this);
                        TokeniserState tokeniserState = BogusComment;
                        tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
                        return;
                    }
                    Token.getAuthRequestContext(tokeniser.moveToNextValue);
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = CdataSection;
                    return;
                }
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Doctype;
                return;
            }
            tokeniser.getAuthRequestContext.PlaceComponentResult();
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = CommentStart;
        }
    },
    CommentStart { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.45
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getAuthRequestContext.MyBillsEntityDataFactory.append(TokeniserState.replacementChar);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Comment;
            } else if (MyBillsEntityDataFactory == '-') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = CommentStartDash;
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getAuthRequestContext(tokeniser.getAuthRequestContext);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getAuthRequestContext(tokeniser.getAuthRequestContext);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getAuthRequestContext.MyBillsEntityDataFactory.append(MyBillsEntityDataFactory);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Comment;
            }
        }
    },
    CommentStartDash { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.46
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getAuthRequestContext.MyBillsEntityDataFactory.append(TokeniserState.replacementChar);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Comment;
            } else if (MyBillsEntityDataFactory == '-') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = CommentStartDash;
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getAuthRequestContext(tokeniser.getAuthRequestContext);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getAuthRequestContext(tokeniser.getAuthRequestContext);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getAuthRequestContext.MyBillsEntityDataFactory.append(MyBillsEntityDataFactory);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Comment;
            }
        }
    },
    Comment { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.47
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char NetworkUserEntityData$$ExternalSyntheticLambda0 = characterReader.NetworkUserEntityData$$ExternalSyntheticLambda0();
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) {
                tokeniser.getAuthRequestContext(this);
                characterReader.MyBillsEntityDataFactory++;
                tokeniser.getAuthRequestContext.MyBillsEntityDataFactory.append(TokeniserState.replacementChar);
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 == '-') {
                TokeniserState tokeniserState = CommentEndDash;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getAuthRequestContext(tokeniser.getAuthRequestContext);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getAuthRequestContext.MyBillsEntityDataFactory.append(characterReader.MyBillsEntityDataFactory('-', 0));
            }
        }
    },
    CommentEndDash { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.48
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                StringBuilder sb = tokeniser.getAuthRequestContext.MyBillsEntityDataFactory;
                sb.append('-');
                sb.append(TokeniserState.replacementChar);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Comment;
            } else if (MyBillsEntityDataFactory == '-') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = CommentEnd;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getAuthRequestContext(tokeniser.getAuthRequestContext);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                StringBuilder sb2 = tokeniser.getAuthRequestContext.MyBillsEntityDataFactory;
                sb2.append('-');
                sb2.append(MyBillsEntityDataFactory);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Comment;
            }
        }
    },
    CommentEnd { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.49
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                StringBuilder sb = tokeniser.getAuthRequestContext.MyBillsEntityDataFactory;
                sb.append("--");
                sb.append(TokeniserState.replacementChar);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Comment;
            } else if (MyBillsEntityDataFactory == '!') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = CommentEndBang;
            } else if (MyBillsEntityDataFactory == '-') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getAuthRequestContext.MyBillsEntityDataFactory.append('-');
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(tokeniser.getAuthRequestContext);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getAuthRequestContext(tokeniser.getAuthRequestContext);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getAuthRequestContext(this);
                StringBuilder sb2 = tokeniser.getAuthRequestContext.MyBillsEntityDataFactory;
                sb2.append("--");
                sb2.append(MyBillsEntityDataFactory);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Comment;
            }
        }
    },
    CommentEndBang { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.50
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                StringBuilder sb = tokeniser.getAuthRequestContext.MyBillsEntityDataFactory;
                sb.append("--!");
                sb.append(TokeniserState.replacementChar);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Comment;
            } else if (MyBillsEntityDataFactory == '-') {
                tokeniser.getAuthRequestContext.MyBillsEntityDataFactory.append("--!");
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = CommentEndDash;
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(tokeniser.getAuthRequestContext);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getAuthRequestContext(tokeniser.getAuthRequestContext);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                StringBuilder sb2 = tokeniser.getAuthRequestContext.MyBillsEntityDataFactory;
                sb2.append("--!");
                sb2.append(MyBillsEntityDataFactory);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Comment;
            }
        }
    },
    Doctype { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.51
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory != '\t' && MyBillsEntityDataFactory != '\n' && MyBillsEntityDataFactory != '\f' && MyBillsEntityDataFactory != '\r' && MyBillsEntityDataFactory != ' ') {
                if (MyBillsEntityDataFactory != '>') {
                    if (MyBillsEntityDataFactory == 65535) {
                        tokeniser.MyBillsEntityDataFactory(this);
                    } else {
                        tokeniser.getAuthRequestContext(this);
                    }
                }
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.PlaceComponentResult();
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                return;
            }
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BeforeDoctypeName;
        }
    },
    BeforeDoctypeName { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.52
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (!characterReader.GetContactSyncConfig()) {
                char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
                if (MyBillsEntityDataFactory == 0) {
                    tokeniser.getAuthRequestContext(this);
                    tokeniser.getErrorConfigVersion.PlaceComponentResult();
                    tokeniser.getErrorConfigVersion.PlaceComponentResult.append(TokeniserState.replacementChar);
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypeName;
                    return;
                } else if (MyBillsEntityDataFactory != ' ') {
                    if (MyBillsEntityDataFactory == 65535) {
                        tokeniser.MyBillsEntityDataFactory(this);
                        tokeniser.getErrorConfigVersion.PlaceComponentResult();
                        tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                        tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                        return;
                    } else if (MyBillsEntityDataFactory == '\t' || MyBillsEntityDataFactory == '\n' || MyBillsEntityDataFactory == '\f' || MyBillsEntityDataFactory == '\r') {
                        return;
                    } else {
                        tokeniser.getErrorConfigVersion.PlaceComponentResult();
                        tokeniser.getErrorConfigVersion.PlaceComponentResult.append(MyBillsEntityDataFactory);
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypeName;
                        return;
                    }
                } else {
                    return;
                }
            }
            tokeniser.getErrorConfigVersion.PlaceComponentResult();
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypeName;
        }
    },
    DoctypeName { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.53
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.GetContactSyncConfig()) {
                tokeniser.getErrorConfigVersion.PlaceComponentResult.append(characterReader.getAuthRequestContext());
                return;
            }
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.PlaceComponentResult.append(TokeniserState.replacementChar);
                return;
            }
            if (MyBillsEntityDataFactory != ' ') {
                if (MyBillsEntityDataFactory == '>') {
                    tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                    return;
                } else if (MyBillsEntityDataFactory == 65535) {
                    tokeniser.MyBillsEntityDataFactory(this);
                    tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                    tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
                    return;
                } else if (MyBillsEntityDataFactory != '\t' && MyBillsEntityDataFactory != '\n' && MyBillsEntityDataFactory != '\f' && MyBillsEntityDataFactory != '\r') {
                    tokeniser.getErrorConfigVersion.PlaceComponentResult.append(MyBillsEntityDataFactory);
                    return;
                }
            }
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AfterDoctypeName;
        }
    },
    AfterDoctypeName { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.54
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.scheduleImpl()) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (!characterReader.PlaceComponentResult('\t', '\n', '\r', '\f', InputCardNumberView.DIVIDER)) {
                if (!characterReader.PlaceComponentResult(Typography.greater)) {
                    if (characterReader.BuiltInFictitiousFunctionClassFactory("PUBLIC")) {
                        tokeniser.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 = "PUBLIC";
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AfterDoctypePublicKeyword;
                        return;
                    } else if (characterReader.BuiltInFictitiousFunctionClassFactory("SYSTEM")) {
                        tokeniser.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2 = "SYSTEM";
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AfterDoctypeSystemKeyword;
                        return;
                    } else {
                        tokeniser.getAuthRequestContext(this);
                        tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                        TokeniserState tokeniserState = BogusDoctype;
                        tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
                        return;
                    }
                }
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                TokeniserState tokeniserState2 = Data;
                tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState2;
            } else {
                characterReader.MyBillsEntityDataFactory++;
            }
        }
    },
    AfterDoctypePublicKeyword { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.55
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == '\t' || MyBillsEntityDataFactory == '\n' || MyBillsEntityDataFactory == '\f' || MyBillsEntityDataFactory == '\r' || MyBillsEntityDataFactory == ' ') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BeforeDoctypePublicIdentifier;
            } else if (MyBillsEntityDataFactory == '\"') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypePublicIdentifier_doubleQuoted;
            } else if (MyBillsEntityDataFactory == '\'') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypePublicIdentifier_singleQuoted;
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BogusDoctype;
            }
        }
    },
    BeforeDoctypePublicIdentifier { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.56
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == '\t' || MyBillsEntityDataFactory == '\n' || MyBillsEntityDataFactory == '\f' || MyBillsEntityDataFactory == '\r' || MyBillsEntityDataFactory == ' ') {
                return;
            }
            if (MyBillsEntityDataFactory == '\"') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypePublicIdentifier_doubleQuoted;
            } else if (MyBillsEntityDataFactory == '\'') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypePublicIdentifier_singleQuoted;
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BogusDoctype;
            }
        }
    },
    DoctypePublicIdentifier_doubleQuoted { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.57
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.getAuthRequestContext.append(TokeniserState.replacementChar);
            } else if (MyBillsEntityDataFactory == '\"') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AfterDoctypePublicIdentifier;
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getErrorConfigVersion.getAuthRequestContext.append(MyBillsEntityDataFactory);
            }
        }
    },
    DoctypePublicIdentifier_singleQuoted { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.58
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.getAuthRequestContext.append(TokeniserState.replacementChar);
            } else if (MyBillsEntityDataFactory == '\'') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AfterDoctypePublicIdentifier;
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getErrorConfigVersion.getAuthRequestContext.append(MyBillsEntityDataFactory);
            }
        }
    },
    AfterDoctypePublicIdentifier { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.59
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == '\t' || MyBillsEntityDataFactory == '\n' || MyBillsEntityDataFactory == '\f' || MyBillsEntityDataFactory == '\r' || MyBillsEntityDataFactory == ' ') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BetweenDoctypePublicAndSystemIdentifiers;
            } else if (MyBillsEntityDataFactory == '\"') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypeSystemIdentifier_doubleQuoted;
            } else if (MyBillsEntityDataFactory == '\'') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypeSystemIdentifier_singleQuoted;
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BogusDoctype;
            }
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.60
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == '\t' || MyBillsEntityDataFactory == '\n' || MyBillsEntityDataFactory == '\f' || MyBillsEntityDataFactory == '\r' || MyBillsEntityDataFactory == ' ') {
                return;
            }
            if (MyBillsEntityDataFactory == '\"') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypeSystemIdentifier_doubleQuoted;
            } else if (MyBillsEntityDataFactory == '\'') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypeSystemIdentifier_singleQuoted;
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BogusDoctype;
            }
        }
    },
    AfterDoctypeSystemKeyword { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.61
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == '\t' || MyBillsEntityDataFactory == '\n' || MyBillsEntityDataFactory == '\f' || MyBillsEntityDataFactory == '\r' || MyBillsEntityDataFactory == ' ') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BeforeDoctypeSystemIdentifier;
            } else if (MyBillsEntityDataFactory == '\"') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypeSystemIdentifier_doubleQuoted;
            } else if (MyBillsEntityDataFactory == '\'') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypeSystemIdentifier_singleQuoted;
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
            }
        }
    },
    BeforeDoctypeSystemIdentifier { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.62
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == '\t' || MyBillsEntityDataFactory == '\n' || MyBillsEntityDataFactory == '\f' || MyBillsEntityDataFactory == '\r' || MyBillsEntityDataFactory == ' ') {
                return;
            }
            if (MyBillsEntityDataFactory == '\"') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypeSystemIdentifier_doubleQuoted;
            } else if (MyBillsEntityDataFactory == '\'') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = DoctypeSystemIdentifier_singleQuoted;
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BogusDoctype;
            }
        }
    },
    DoctypeSystemIdentifier_doubleQuoted { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.63
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0.append(TokeniserState.replacementChar);
            } else if (MyBillsEntityDataFactory == '\"') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AfterDoctypeSystemIdentifier;
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0.append(MyBillsEntityDataFactory);
            }
        }
    },
    DoctypeSystemIdentifier_singleQuoted { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.64
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == 0) {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0.append(TokeniserState.replacementChar);
            } else if (MyBillsEntityDataFactory == '\'') {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = AfterDoctypeSystemIdentifier;
            } else if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.MyBillsEntityDataFactory(this);
                tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else {
                tokeniser.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda0.append(MyBillsEntityDataFactory);
            }
        }
    },
    AfterDoctypeSystemIdentifier { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.65
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == '\t' || MyBillsEntityDataFactory == '\n' || MyBillsEntityDataFactory == '\f' || MyBillsEntityDataFactory == '\r' || MyBillsEntityDataFactory == ' ') {
                return;
            }
            if (MyBillsEntityDataFactory != '>') {
                if (MyBillsEntityDataFactory == 65535) {
                    tokeniser.MyBillsEntityDataFactory(this);
                    tokeniser.getErrorConfigVersion.MyBillsEntityDataFactory = true;
                } else {
                    tokeniser.getAuthRequestContext(this);
                    tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = BogusDoctype;
                    return;
                }
            }
            tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
        }
    },
    BogusDoctype { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.66
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
            if (MyBillsEntityDataFactory == '>') {
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            } else if (MyBillsEntityDataFactory == 65535) {
                tokeniser.getAuthRequestContext(tokeniser.getErrorConfigVersion);
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            }
        }
    },
    CdataSection { // from class: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.67
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // ru.noties.markwon.html.impl.jsoup.parser.TokeniserState
        public final void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String lookAheadTest;
            int authRequestContext = characterReader.getAuthRequestContext("]]>");
            if (authRequestContext != -1) {
                lookAheadTest = CharacterReader.BuiltInFictitiousFunctionClassFactory(characterReader.KClassImpl$Data$declaredNonStaticMembers$2, characterReader.PlaceComponentResult, characterReader.MyBillsEntityDataFactory, authRequestContext);
                characterReader.MyBillsEntityDataFactory += authRequestContext;
            } else {
                lookAheadTest = characterReader.lookAheadTest();
            }
            tokeniser.moveToNextValue.append(lookAheadTest);
            if (characterReader.KClassImpl$Data$declaredNonStaticMembers$2("]]>") || characterReader.scheduleImpl()) {
                tokeniser.getAuthRequestContext(new Token.CData(tokeniser.moveToNextValue.toString()));
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data;
            }
        }
    };

    private static final char eof = 65535;
    static final char nullChar = 0;
    private static final char replacementChar = 65533;
    static final char[] attributeSingleValueCharsSorted = {0, Typography.amp, '\''};
    static final char[] attributeDoubleValueCharsSorted = {0, Typography.quote, Typography.amp};
    static final char[] attributeNameCharsSorted = {0, '\t', '\n', '\f', '\r', InputCardNumberView.DIVIDER, Typography.quote, '\'', '/', Typography.less, '=', Typography.greater};
    static final char[] attributeValueUnquoted = {0, '\t', '\n', '\f', '\r', InputCardNumberView.DIVIDER, Typography.quote, Typography.amp, '\'', Typography.less, '=', Typography.greater, '`'};
    private static final String replacementStr = "�";

    public abstract void read(Tokeniser tokeniser, CharacterReader characterReader);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void handleDataEndTag(ru.noties.markwon.html.impl.jsoup.parser.Tokeniser r3, ru.noties.markwon.html.impl.jsoup.parser.CharacterReader r4, ru.noties.markwon.html.impl.jsoup.parser.TokeniserState r5) {
        /*
            boolean r0 = r4.GetContactSyncConfig()
            if (r0 == 0) goto L24
            java.lang.String r4 = r4.getAuthRequestContext()
            ru.noties.markwon.html.impl.jsoup.parser.Token$Tag r5 = r3.NetworkUserEntityData$$ExternalSyntheticLambda1
            java.lang.String r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda0
            if (r0 == 0) goto L15
            java.lang.String r0 = r0.concat(r4)
            goto L16
        L15:
            r0 = r4
        L16:
            r5.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0
            java.lang.String r0 = ru.noties.markwon.html.impl.jsoup.helper.Normalizer.getAuthRequestContext(r0)
            r5.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            java.lang.StringBuilder r3 = r3.moveToNextValue
            r3.append(r4)
            return
        L24:
            boolean r0 = r3.PlaceComponentResult()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L75
            boolean r0 = r4.scheduleImpl()
            if (r0 != 0) goto L75
            char r4 = r4.MyBillsEntityDataFactory()
            r0 = 9
            if (r4 == r0) goto L70
            r0 = 10
            if (r4 == r0) goto L70
            r0 = 12
            if (r4 == r0) goto L70
            r0 = 13
            if (r4 == r0) goto L70
            r0 = 32
            if (r4 == r0) goto L70
            r0 = 47
            if (r4 == r0) goto L6b
            r0 = 62
            if (r4 == r0) goto L58
            java.lang.StringBuilder r0 = r3.moveToNextValue
            r0.append(r4)
            goto L75
        L58:
            ru.noties.markwon.html.impl.jsoup.parser.Token$Tag r4 = r3.NetworkUserEntityData$$ExternalSyntheticLambda1
            java.lang.String r0 = r4.MyBillsEntityDataFactory
            if (r0 == 0) goto L61
            r4.BuiltInFictitiousFunctionClassFactory()
        L61:
            ru.noties.markwon.html.impl.jsoup.parser.Token$Tag r4 = r3.NetworkUserEntityData$$ExternalSyntheticLambda1
            r3.getAuthRequestContext(r4)
            ru.noties.markwon.html.impl.jsoup.parser.TokeniserState r4 = ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.Data
            r3.NetworkUserEntityData$$ExternalSyntheticLambda2 = r4
            goto L76
        L6b:
            ru.noties.markwon.html.impl.jsoup.parser.TokeniserState r4 = ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.SelfClosingStartTag
            r3.NetworkUserEntityData$$ExternalSyntheticLambda2 = r4
            goto L76
        L70:
            ru.noties.markwon.html.impl.jsoup.parser.TokeniserState r4 = ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.BeforeAttributeName
            r3.NetworkUserEntityData$$ExternalSyntheticLambda2 = r4
            goto L76
        L75:
            r1 = 1
        L76:
            if (r1 == 0) goto L94
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "</"
            r4.append(r0)
            java.lang.StringBuilder r0 = r3.moveToNextValue
            java.lang.String r0 = r0.toString()
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r3.PlaceComponentResult(r4)
            r3.NetworkUserEntityData$$ExternalSyntheticLambda2 = r5
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.noties.markwon.html.impl.jsoup.parser.TokeniserState.handleDataEndTag(ru.noties.markwon.html.impl.jsoup.parser.Tokeniser, ru.noties.markwon.html.impl.jsoup.parser.CharacterReader, ru.noties.markwon.html.impl.jsoup.parser.TokeniserState):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readData(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        char NetworkUserEntityData$$ExternalSyntheticLambda0 = characterReader.NetworkUserEntityData$$ExternalSyntheticLambda0();
        if (NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) {
            tokeniser.getAuthRequestContext(tokeniserState);
            characterReader.MyBillsEntityDataFactory++;
            tokeniser.PlaceComponentResult("�");
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 == '<') {
            tokeniser.initRecordTimeStamp.MyBillsEntityDataFactory++;
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState2;
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda0 == 65535) {
            tokeniser.getAuthRequestContext(new Token.EOF());
        } else {
            tokeniser.PlaceComponentResult(characterReader.MyBillsEntityDataFactory(Typography.less, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readCharRef(Tokeniser tokeniser, TokeniserState tokeniserState) {
        int[] authRequestContext = tokeniser.getAuthRequestContext(null, false);
        if (authRequestContext == null) {
            tokeniser.PlaceComponentResult(ContainerUtils.FIELD_DELIMITER);
        } else {
            tokeniser.PlaceComponentResult(new String(authRequestContext, 0, authRequestContext.length));
        }
        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void readEndTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (!characterReader.GetContactSyncConfig()) {
            tokeniser.PlaceComponentResult("</");
            tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState2;
            return;
        }
        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda1 = tokeniser.lookAheadTest.PlaceComponentResult();
        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleDataDoubleEscapeTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.GetContactSyncConfig()) {
            String authRequestContext = characterReader.getAuthRequestContext();
            tokeniser.moveToNextValue.append(authRequestContext);
            tokeniser.PlaceComponentResult(authRequestContext);
            return;
        }
        char MyBillsEntityDataFactory = characterReader.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory == '\t' || MyBillsEntityDataFactory == '\n' || MyBillsEntityDataFactory == '\f' || MyBillsEntityDataFactory == '\r' || MyBillsEntityDataFactory == ' ' || MyBillsEntityDataFactory == '/' || MyBillsEntityDataFactory == '>') {
            if (tokeniser.moveToNextValue.toString().equals("script")) {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState;
            } else {
                tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState2;
            }
            tokeniser.PlaceComponentResult(String.valueOf(MyBillsEntityDataFactory));
            return;
        }
        characterReader.MyBillsEntityDataFactory--;
        tokeniser.NetworkUserEntityData$$ExternalSyntheticLambda2 = tokeniserState2;
    }
}
