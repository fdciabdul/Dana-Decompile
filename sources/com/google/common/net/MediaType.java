package com.google.common.net;

import com.alibaba.griver.image.framework.api.APImageFormat;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import com.google.errorprone.annotations.concurrent.LazyInit;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.profilemenu.MyProfileMenuAction;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class MediaType {
    private static final String AUDIO_TYPE = "audio";
    private static final String IMAGE_TYPE = "image";
    private static final String TEXT_TYPE = "text";
    private static final String VIDEO_TYPE = "video";
    private static final String WILDCARD = "*";
    @LazyInit
    private int hashCode;
    private final ImmutableListMultimap<String, String> parameters;
    @CheckForNull
    @LazyInit
    private Optional<Charset> parsedCharset;
    private final String subtype;
    @CheckForNull
    @LazyInit
    private String toString;
    private final String type;
    private static final String CHARSET_ATTRIBUTE = "charset";
    private static final ImmutableListMultimap<String, String> UTF_8_CONSTANT_PARAMETERS = ImmutableListMultimap.of(CHARSET_ATTRIBUTE, Ascii.toLowerCase(Charsets.UTF_8.name()));
    private static final CharMatcher TOKEN_MATCHER = CharMatcher.ascii().and(CharMatcher.javaIsoControl().negate()).and(CharMatcher.isNot(InputCardNumberView.DIVIDER)).and(CharMatcher.noneOf("()<>@,;:\\\"/[]?="));
    private static final CharMatcher QUOTED_TEXT_MATCHER = CharMatcher.ascii().and(CharMatcher.noneOf("\"\\\r"));
    private static final CharMatcher LINEAR_WHITE_SPACE = CharMatcher.anyOf(" \t\r\n");
    private static final Map<MediaType, MediaType> KNOWN_TYPES = Maps.newHashMap();
    public static final MediaType ANY_TYPE = createConstant("*", "*");
    public static final MediaType ANY_TEXT_TYPE = createConstant("text", "*");
    public static final MediaType ANY_IMAGE_TYPE = createConstant("image", "*");
    public static final MediaType ANY_AUDIO_TYPE = createConstant("audio", "*");
    public static final MediaType ANY_VIDEO_TYPE = createConstant("video", "*");
    private static final String APPLICATION_TYPE = "application";
    public static final MediaType ANY_APPLICATION_TYPE = createConstant(APPLICATION_TYPE, "*");
    private static final String FONT_TYPE = "font";
    public static final MediaType ANY_FONT_TYPE = createConstant(FONT_TYPE, "*");
    public static final MediaType CACHE_MANIFEST_UTF_8 = createConstantUtf8("text", "cache-manifest");
    public static final MediaType CSS_UTF_8 = createConstantUtf8("text", "css");
    public static final MediaType CSV_UTF_8 = createConstantUtf8("text", "csv");
    public static final MediaType HTML_UTF_8 = createConstantUtf8("text", "html");
    public static final MediaType I_CALENDAR_UTF_8 = createConstantUtf8("text", "calendar");
    public static final MediaType PLAIN_TEXT_UTF_8 = createConstantUtf8("text", "plain");
    public static final MediaType TEXT_JAVASCRIPT_UTF_8 = createConstantUtf8("text", "javascript");
    public static final MediaType TSV_UTF_8 = createConstantUtf8("text", "tab-separated-values");
    public static final MediaType VCARD_UTF_8 = createConstantUtf8("text", "vcard");
    public static final MediaType WML_UTF_8 = createConstantUtf8("text", "vnd.wap.wml");
    public static final MediaType XML_UTF_8 = createConstantUtf8("text", "xml");
    public static final MediaType VTT_UTF_8 = createConstantUtf8("text", "vtt");
    public static final MediaType BMP = createConstant("image", "bmp");
    public static final MediaType CRW = createConstant("image", "x-canon-crw");
    public static final MediaType GIF = createConstant("image", APImageFormat.SUFFIX_GIF);
    public static final MediaType ICO = createConstant("image", "vnd.microsoft.icon");
    public static final MediaType JPEG = createConstant("image", "jpeg");
    public static final MediaType PNG = createConstant("image", APImageFormat.SUFFIX_PNG);
    public static final MediaType PSD = createConstant("image", "vnd.adobe.photoshop");
    public static final MediaType SVG_UTF_8 = createConstantUtf8("image", "svg+xml");
    public static final MediaType TIFF = createConstant("image", "tiff");
    public static final MediaType WEBP = createConstant("image", APImageFormat.SUFFIX_WEBP);
    public static final MediaType HEIF = createConstant("image", "heif");
    public static final MediaType JP2K = createConstant("image", "jp2");
    public static final MediaType MP4_AUDIO = createConstant("audio", "mp4");
    public static final MediaType MPEG_AUDIO = createConstant("audio", "mpeg");
    public static final MediaType OGG_AUDIO = createConstant("audio", "ogg");
    public static final MediaType WEBM_AUDIO = createConstant("audio", "webm");
    public static final MediaType L16_AUDIO = createConstant("audio", "l16");
    public static final MediaType L24_AUDIO = createConstant("audio", "l24");
    public static final MediaType BASIC_AUDIO = createConstant("audio", "basic");
    public static final MediaType AAC_AUDIO = createConstant("audio", "aac");
    public static final MediaType VORBIS_AUDIO = createConstant("audio", "vorbis");
    public static final MediaType WMA_AUDIO = createConstant("audio", "x-ms-wma");
    public static final MediaType WAX_AUDIO = createConstant("audio", "x-ms-wax");
    public static final MediaType VND_REAL_AUDIO = createConstant("audio", "vnd.rn-realaudio");
    public static final MediaType VND_WAVE_AUDIO = createConstant("audio", "vnd.wave");
    public static final MediaType MP4_VIDEO = createConstant("video", "mp4");
    public static final MediaType MPEG_VIDEO = createConstant("video", "mpeg");
    public static final MediaType OGG_VIDEO = createConstant("video", "ogg");
    public static final MediaType QUICKTIME = createConstant("video", "quicktime");
    public static final MediaType WEBM_VIDEO = createConstant("video", "webm");
    public static final MediaType WMV = createConstant("video", "x-ms-wmv");
    public static final MediaType FLV_VIDEO = createConstant("video", "x-flv");
    public static final MediaType THREE_GPP_VIDEO = createConstant("video", "3gpp");
    public static final MediaType THREE_GPP2_VIDEO = createConstant("video", "3gpp2");
    public static final MediaType APPLICATION_XML_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "xml");
    public static final MediaType ATOM_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "atom+xml");
    public static final MediaType BZIP2 = createConstant(APPLICATION_TYPE, "x-bzip2");
    public static final MediaType DART_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "dart");
    public static final MediaType APPLE_PASSBOOK = createConstant(APPLICATION_TYPE, "vnd.apple.pkpass");
    public static final MediaType EOT = createConstant(APPLICATION_TYPE, "vnd.ms-fontobject");
    public static final MediaType EPUB = createConstant(APPLICATION_TYPE, "epub+zip");
    public static final MediaType FORM_DATA = createConstant(APPLICATION_TYPE, "x-www-form-urlencoded");
    public static final MediaType KEY_ARCHIVE = createConstant(APPLICATION_TYPE, "pkcs12");
    public static final MediaType APPLICATION_BINARY = createConstant(APPLICATION_TYPE, "binary");
    public static final MediaType GEO_JSON = createConstant(APPLICATION_TYPE, "geo+json");
    public static final MediaType GZIP = createConstant(APPLICATION_TYPE, "x-gzip");
    public static final MediaType HAL_JSON = createConstant(APPLICATION_TYPE, "hal+json");
    public static final MediaType JAVASCRIPT_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "javascript");
    public static final MediaType JOSE = createConstant(APPLICATION_TYPE, "jose");
    public static final MediaType JOSE_JSON = createConstant(APPLICATION_TYPE, "jose+json");
    public static final MediaType JSON_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "json");
    public static final MediaType JWT = createConstant(APPLICATION_TYPE, "jwt");
    public static final MediaType MANIFEST_JSON_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "manifest+json");
    public static final MediaType KML = createConstant(APPLICATION_TYPE, "vnd.google-earth.kml+xml");
    public static final MediaType KMZ = createConstant(APPLICATION_TYPE, "vnd.google-earth.kmz");
    public static final MediaType MBOX = createConstant(APPLICATION_TYPE, "mbox");
    public static final MediaType APPLE_MOBILE_CONFIG = createConstant(APPLICATION_TYPE, "x-apple-aspen-config");
    public static final MediaType MICROSOFT_EXCEL = createConstant(APPLICATION_TYPE, "vnd.ms-excel");
    public static final MediaType MICROSOFT_OUTLOOK = createConstant(APPLICATION_TYPE, "vnd.ms-outlook");
    public static final MediaType MICROSOFT_POWERPOINT = createConstant(APPLICATION_TYPE, "vnd.ms-powerpoint");
    public static final MediaType MICROSOFT_WORD = createConstant(APPLICATION_TYPE, "msword");
    public static final MediaType MEDIA_PRESENTATION_DESCRIPTION = createConstant(APPLICATION_TYPE, "dash+xml");
    public static final MediaType WASM_APPLICATION = createConstant(APPLICATION_TYPE, "wasm");
    public static final MediaType NACL_APPLICATION = createConstant(APPLICATION_TYPE, "x-nacl");
    public static final MediaType NACL_PORTABLE_APPLICATION = createConstant(APPLICATION_TYPE, "x-pnacl");
    public static final MediaType OCTET_STREAM = createConstant(APPLICATION_TYPE, "octet-stream");
    public static final MediaType OGG_CONTAINER = createConstant(APPLICATION_TYPE, "ogg");
    public static final MediaType OOXML_DOCUMENT = createConstant(APPLICATION_TYPE, "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final MediaType OOXML_PRESENTATION = createConstant(APPLICATION_TYPE, "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final MediaType OOXML_SHEET = createConstant(APPLICATION_TYPE, "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final MediaType OPENDOCUMENT_GRAPHICS = createConstant(APPLICATION_TYPE, "vnd.oasis.opendocument.graphics");
    public static final MediaType OPENDOCUMENT_PRESENTATION = createConstant(APPLICATION_TYPE, "vnd.oasis.opendocument.presentation");
    public static final MediaType OPENDOCUMENT_SPREADSHEET = createConstant(APPLICATION_TYPE, "vnd.oasis.opendocument.spreadsheet");
    public static final MediaType OPENDOCUMENT_TEXT = createConstant(APPLICATION_TYPE, "vnd.oasis.opendocument.text");
    public static final MediaType OPENSEARCH_DESCRIPTION_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "opensearchdescription+xml");
    public static final MediaType PDF = createConstant(APPLICATION_TYPE, "pdf");
    public static final MediaType POSTSCRIPT = createConstant(APPLICATION_TYPE, "postscript");
    public static final MediaType PROTOBUF = createConstant(APPLICATION_TYPE, "protobuf");
    public static final MediaType RDF_XML_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "rdf+xml");
    public static final MediaType RTF_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "rtf");
    public static final MediaType SFNT = createConstant(APPLICATION_TYPE, "font-sfnt");
    public static final MediaType SHOCKWAVE_FLASH = createConstant(APPLICATION_TYPE, "x-shockwave-flash");
    public static final MediaType SKETCHUP = createConstant(APPLICATION_TYPE, "vnd.sketchup.skp");
    public static final MediaType SOAP_XML_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "soap+xml");
    public static final MediaType TAR = createConstant(APPLICATION_TYPE, "x-tar");
    public static final MediaType WOFF = createConstant(APPLICATION_TYPE, "font-woff");
    public static final MediaType WOFF2 = createConstant(APPLICATION_TYPE, "font-woff2");
    public static final MediaType XHTML_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "xhtml+xml");
    public static final MediaType XRD_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "xrd+xml");
    public static final MediaType ZIP = createConstant(APPLICATION_TYPE, "zip");
    public static final MediaType FONT_COLLECTION = createConstant(FONT_TYPE, MyProfileMenuAction.COLLECTION);
    public static final MediaType FONT_OTF = createConstant(FONT_TYPE, "otf");
    public static final MediaType FONT_SFNT = createConstant(FONT_TYPE, "sfnt");
    public static final MediaType FONT_TTF = createConstant(FONT_TYPE, "ttf");
    public static final MediaType FONT_WOFF = createConstant(FONT_TYPE, "woff");
    public static final MediaType FONT_WOFF2 = createConstant(FONT_TYPE, "woff2");
    private static final Joiner.MapJoiner PARAMETER_JOINER = Joiner.on("; ").withKeyValueSeparator("=");

    private static MediaType createConstant(String str, String str2) {
        MediaType addKnownType = addKnownType(new MediaType(str, str2, ImmutableListMultimap.of()));
        addKnownType.parsedCharset = Optional.absent();
        return addKnownType;
    }

    private static MediaType createConstantUtf8(String str, String str2) {
        MediaType addKnownType = addKnownType(new MediaType(str, str2, UTF_8_CONSTANT_PARAMETERS));
        addKnownType.parsedCharset = Optional.of(Charsets.UTF_8);
        return addKnownType;
    }

    private static MediaType addKnownType(MediaType mediaType) {
        KNOWN_TYPES.put(mediaType, mediaType);
        return mediaType;
    }

    private MediaType(String str, String str2, ImmutableListMultimap<String, String> immutableListMultimap) {
        this.type = str;
        this.subtype = str2;
        this.parameters = immutableListMultimap;
    }

    public final String type() {
        return this.type;
    }

    public final String subtype() {
        return this.subtype;
    }

    public final ImmutableListMultimap<String, String> parameters() {
        return this.parameters;
    }

    private Map<String, ImmutableMultiset<String>> parametersAsMap() {
        return Maps.transformValues(this.parameters.asMap(), new Function() { // from class: com.google.common.net.MediaType$$ExternalSyntheticLambda0
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ImmutableMultiset.copyOf((Collection) obj);
            }
        });
    }

    public final Optional<Charset> charset() {
        Optional<Charset> optional = this.parsedCharset;
        if (optional == null) {
            optional = Optional.absent();
            UnmodifiableIterator<String> it = this.parameters.get((ImmutableListMultimap<String, String>) CHARSET_ATTRIBUTE).iterator();
            String str = null;
            while (it.hasNext()) {
                String next = it.next();
                if (str == null) {
                    optional = Optional.of(Charset.forName(next));
                    str = next;
                } else if (!str.equals(next)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Multiple charset values defined: ");
                    sb.append(str);
                    sb.append(", ");
                    sb.append(next);
                    throw new IllegalStateException(sb.toString());
                }
            }
            this.parsedCharset = optional;
        }
        return optional;
    }

    public final MediaType withoutParameters() {
        return this.parameters.isEmpty() ? this : create(this.type, this.subtype);
    }

    public final MediaType withParameters(Multimap<String, String> multimap) {
        return create(this.type, this.subtype, multimap);
    }

    public final MediaType withParameters(String str, Iterable<String> iterable) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(iterable);
        String normalizeToken = normalizeToken(str);
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        UnmodifiableIterator<Map.Entry<String, String>> it = this.parameters.entries().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            if (!normalizeToken.equals(key)) {
                builder.put((ImmutableListMultimap.Builder) key, next.getValue());
            }
        }
        Iterator<String> it2 = iterable.iterator();
        while (it2.hasNext()) {
            builder.put((ImmutableListMultimap.Builder) normalizeToken, normalizeParameterValue(normalizeToken, it2.next()));
        }
        MediaType mediaType = new MediaType(this.type, this.subtype, builder.build());
        if (!normalizeToken.equals(CHARSET_ATTRIBUTE)) {
            mediaType.parsedCharset = this.parsedCharset;
        }
        return (MediaType) MoreObjects.firstNonNull(KNOWN_TYPES.get(mediaType), mediaType);
    }

    public final MediaType withParameter(String str, String str2) {
        return withParameters(str, ImmutableSet.of(str2));
    }

    public final MediaType withCharset(Charset charset) {
        Preconditions.checkNotNull(charset);
        MediaType withParameter = withParameter(CHARSET_ATTRIBUTE, charset.name());
        withParameter.parsedCharset = Optional.of(charset);
        return withParameter;
    }

    public final boolean hasWildcard() {
        return "*".equals(this.type) || "*".equals(this.subtype);
    }

    public final boolean is(MediaType mediaType) {
        return (mediaType.type.equals("*") || mediaType.type.equals(this.type)) && (mediaType.subtype.equals("*") || mediaType.subtype.equals(this.subtype)) && this.parameters.entries().containsAll(mediaType.parameters.entries());
    }

    public static MediaType create(String str, String str2) {
        MediaType create = create(str, str2, ImmutableListMultimap.of());
        create.parsedCharset = Optional.absent();
        return create;
    }

    private static MediaType create(String str, String str2, Multimap<String, String> multimap) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(multimap);
        String normalizeToken = normalizeToken(str);
        String normalizeToken2 = normalizeToken(str2);
        Preconditions.checkArgument(!"*".equals(normalizeToken) || "*".equals(normalizeToken2), "A wildcard type cannot be used with a non-wildcard subtype");
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        for (Map.Entry<String, String> entry : multimap.entries()) {
            String normalizeToken3 = normalizeToken(entry.getKey());
            builder.put((ImmutableListMultimap.Builder) normalizeToken3, normalizeParameterValue(normalizeToken3, entry.getValue()));
        }
        MediaType mediaType = new MediaType(normalizeToken, normalizeToken2, builder.build());
        return (MediaType) MoreObjects.firstNonNull(KNOWN_TYPES.get(mediaType), mediaType);
    }

    static MediaType createApplicationType(String str) {
        return create(APPLICATION_TYPE, str);
    }

    static MediaType createAudioType(String str) {
        return create("audio", str);
    }

    static MediaType createFontType(String str) {
        return create(FONT_TYPE, str);
    }

    static MediaType createImageType(String str) {
        return create("image", str);
    }

    static MediaType createTextType(String str) {
        return create("text", str);
    }

    static MediaType createVideoType(String str) {
        return create("video", str);
    }

    private static String normalizeToken(String str) {
        Preconditions.checkArgument(TOKEN_MATCHER.matchesAllOf(str));
        Preconditions.checkArgument(!str.isEmpty());
        return Ascii.toLowerCase(str);
    }

    private static String normalizeParameterValue(String str, String str2) {
        Preconditions.checkNotNull(str2);
        Preconditions.checkArgument(CharMatcher.ascii().matchesAllOf(str2), "parameter values must be ASCII: %s", str2);
        return CHARSET_ATTRIBUTE.equals(str) ? Ascii.toLowerCase(str2) : str2;
    }

    public static MediaType parse(String str) {
        String consumeToken;
        Preconditions.checkNotNull(str);
        Tokenizer tokenizer = new Tokenizer(str);
        try {
            CharMatcher charMatcher = TOKEN_MATCHER;
            String consumeToken2 = tokenizer.consumeToken(charMatcher);
            tokenizer.consumeCharacter('/');
            String consumeToken3 = tokenizer.consumeToken(charMatcher);
            ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
            while (tokenizer.hasMore()) {
                CharMatcher charMatcher2 = LINEAR_WHITE_SPACE;
                tokenizer.consumeTokenIfPresent(charMatcher2);
                tokenizer.consumeCharacter(';');
                tokenizer.consumeTokenIfPresent(charMatcher2);
                CharMatcher charMatcher3 = TOKEN_MATCHER;
                String consumeToken4 = tokenizer.consumeToken(charMatcher3);
                tokenizer.consumeCharacter('=');
                if ('\"' == tokenizer.previewChar()) {
                    tokenizer.consumeCharacter(Typography.quote);
                    StringBuilder sb = new StringBuilder();
                    while ('\"' != tokenizer.previewChar()) {
                        if ('\\' == tokenizer.previewChar()) {
                            tokenizer.consumeCharacter('\\');
                            sb.append(tokenizer.consumeCharacter(CharMatcher.ascii()));
                        } else {
                            sb.append(tokenizer.consumeToken(QUOTED_TEXT_MATCHER));
                        }
                    }
                    consumeToken = sb.toString();
                    tokenizer.consumeCharacter(Typography.quote);
                } else {
                    consumeToken = tokenizer.consumeToken(charMatcher3);
                }
                builder.put((ImmutableListMultimap.Builder) consumeToken4, consumeToken);
            }
            return create(consumeToken2, consumeToken3, builder.build());
        } catch (IllegalStateException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not parse '");
            sb2.append(str);
            sb2.append("'");
            throw new IllegalArgumentException(sb2.toString(), e);
        }
    }

    /* loaded from: classes7.dex */
    static final class Tokenizer {
        final String input;
        int position = 0;

        Tokenizer(String str) {
            this.input = str;
        }

        final String consumeTokenIfPresent(CharMatcher charMatcher) {
            Preconditions.checkState(hasMore());
            int i = this.position;
            this.position = charMatcher.negate().indexIn(this.input, i);
            return hasMore() ? this.input.substring(i, this.position) : this.input.substring(i);
        }

        final String consumeToken(CharMatcher charMatcher) {
            int i = this.position;
            String consumeTokenIfPresent = consumeTokenIfPresent(charMatcher);
            Preconditions.checkState(this.position != i);
            return consumeTokenIfPresent;
        }

        final char consumeCharacter(CharMatcher charMatcher) {
            Preconditions.checkState(hasMore());
            char previewChar = previewChar();
            Preconditions.checkState(charMatcher.matches(previewChar));
            this.position++;
            return previewChar;
        }

        final char consumeCharacter(char c) {
            Preconditions.checkState(hasMore());
            Preconditions.checkState(previewChar() == c);
            this.position++;
            return c;
        }

        final char previewChar() {
            Preconditions.checkState(hasMore());
            return this.input.charAt(this.position);
        }

        final boolean hasMore() {
            int i = this.position;
            return i >= 0 && i < this.input.length();
        }
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MediaType) {
            MediaType mediaType = (MediaType) obj;
            return this.type.equals(mediaType.type) && this.subtype.equals(mediaType.subtype) && parametersAsMap().equals(mediaType.parametersAsMap());
        }
        return false;
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = Objects.hashCode(this.type, this.subtype, parametersAsMap());
            this.hashCode = hashCode;
            return hashCode;
        }
        return i;
    }

    public final String toString() {
        String str = this.toString;
        if (str == null) {
            String computeToString = computeToString();
            this.toString = computeToString;
            return computeToString;
        }
        return str;
    }

    private String computeToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.type);
        sb.append('/');
        sb.append(this.subtype);
        if (!this.parameters.isEmpty()) {
            sb.append("; ");
            PARAMETER_JOINER.appendTo(sb, Multimaps.transformValues((ListMultimap) this.parameters, new Function() { // from class: com.google.common.net.MediaType$$ExternalSyntheticLambda1
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return MediaType.lambda$computeToString$0((String) obj);
                }
            }).entries());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$computeToString$0(String str) {
        return (!TOKEN_MATCHER.matchesAllOf(str) || str.isEmpty()) ? escapeAndQuote(str) : str;
    }

    private static String escapeAndQuote(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 16);
        sb.append(Typography.quote);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\r' || charAt == '\\' || charAt == '\"') {
                sb.append('\\');
            }
            sb.append(charAt);
        }
        sb.append(Typography.quote);
        return sb.toString();
    }
}
