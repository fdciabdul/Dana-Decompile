package io.michaelrocks.libphonenumber.android;

import android.content.Context;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import id.dana.cashier.view.InputCardNumberView;
import io.michaelrocks.libphonenumber.android.NumberParseException;
import io.michaelrocks.libphonenumber.android.PhoneNumberMatcher;
import io.michaelrocks.libphonenumber.android.Phonemetadata;
import io.michaelrocks.libphonenumber.android.Phonenumber;
import io.michaelrocks.libphonenumber.android.internal.MatcherApi;
import io.michaelrocks.libphonenumber.android.internal.RegexBasedMatcher;
import io.michaelrocks.libphonenumber.android.internal.RegexCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Typography;

/* loaded from: classes6.dex */
public class PhoneNumberUtil {
    private static final Map<Character, Character> ALL_PLUS_NUMBER_GROUPING_SYMBOLS;
    private static final Map<Character, Character> ALPHA_MAPPINGS;
    private static final Map<Character, Character> ALPHA_PHONE_MAPPINGS;
    private static final Pattern CAPTURING_DIGIT_PATTERN;
    private static final String CAPTURING_EXTN_DIGITS = "(\\p{Nd}{1,7})";
    private static final String CC_STRING = "$CC";
    private static final String COLOMBIA_MOBILE_TO_FIXED_LINE_PREFIX = "3";
    private static final String DEFAULT_EXTN_PREFIX = " ext. ";
    private static final Map<Character, Character> DIALLABLE_CHAR_MAPPINGS;
    private static final String DIGITS = "\\p{Nd}";
    private static final Pattern EXTN_PATTERN;
    static final String EXTN_PATTERNS_FOR_MATCHING;
    private static final String EXTN_PATTERNS_FOR_PARSING;
    private static final String FG_STRING = "$FG";
    private static final Pattern FIRST_GROUP_ONLY_PREFIX_PATTERN;
    private static final Pattern FIRST_GROUP_PATTERN;
    private static final Set<Integer> GEO_MOBILE_COUNTRIES;
    private static final Set<Integer> GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES;
    private static final int MAX_INPUT_STRING_LENGTH = 250;
    static final int MAX_LENGTH_COUNTRY_CODE = 3;
    static final int MAX_LENGTH_FOR_NSN = 17;
    private static final int MIN_LENGTH_FOR_NSN = 2;
    private static final Map<Integer, String> MOBILE_TOKEN_MAPPINGS;
    private static final int NANPA_COUNTRY_CODE = 1;
    static final Pattern NON_DIGITS_PATTERN;
    private static final String NP_STRING = "$NP";
    static final String PLUS_CHARS = "+＋";
    static final Pattern PLUS_CHARS_PATTERN;
    static final char PLUS_SIGN = '+';
    static final int REGEX_FLAGS = 66;
    public static final String REGION_CODE_FOR_NON_GEO_ENTITY = "001";
    private static final String RFC3966_EXTN_PREFIX = ";ext=";
    private static final String RFC3966_ISDN_SUBADDRESS = ";isub=";
    private static final String RFC3966_PHONE_CONTEXT = ";phone-context=";
    private static final String RFC3966_PREFIX = "tel:";
    private static final String SECOND_NUMBER_START = "[\\\\/] *x";
    static final Pattern SECOND_NUMBER_START_PATTERN;
    private static final Pattern SEPARATOR_PATTERN;
    private static final Pattern SINGLE_INTERNATIONAL_PREFIX;
    private static final char STAR_SIGN = '*';
    private static final String UNKNOWN_REGION = "ZZ";
    private static final String UNWANTED_END_CHARS = "[[\\P{N}&&\\P{L}]&&[^#]]+$";
    static final Pattern UNWANTED_END_CHAR_PATTERN;
    private static final String VALID_ALPHA;
    private static final Pattern VALID_ALPHA_PHONE_PATTERN;
    private static final String VALID_PHONE_NUMBER;
    private static final Pattern VALID_PHONE_NUMBER_PATTERN;
    static final String VALID_PUNCTUATION = "-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～";
    private static final String VALID_START_CHAR = "[+＋\\p{Nd}]";
    private static final Pattern VALID_START_CHAR_PATTERN;
    private static final Logger logger = Logger.getLogger(PhoneNumberUtil.class.getName());
    private final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap;
    private final MetadataSource metadataSource;
    private volatile ShortNumberInfo shortNumberInfo;
    private final MatcherApi matcherApi = RegexBasedMatcher.create();
    private final Set<String> nanpaRegions = new HashSet(35);
    private final RegexCache regexCache = new RegexCache(100);
    private final Set<String> supportedRegions = new HashSet(320);
    private final Set<Integer> countryCodesForNonGeographicalRegion = new HashSet();

    /* loaded from: classes9.dex */
    public enum Leniency {
        POSSIBLE { // from class: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency.1
            @Override // io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency
            final boolean verify(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil) {
                return phoneNumberUtil.isPossibleNumber(phoneNumber);
            }
        },
        VALID { // from class: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency.2
            @Override // io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency
            final boolean verify(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil) {
                if (phoneNumberUtil.isValidNumber(phoneNumber) && PhoneNumberMatcher.containsOnlyValidXChars(phoneNumber, charSequence.toString(), phoneNumberUtil)) {
                    return PhoneNumberMatcher.isNationalPrefixPresentIfRequired(phoneNumber, phoneNumberUtil);
                }
                return false;
            }
        },
        STRICT_GROUPING { // from class: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency.3
            @Override // io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency
            final boolean verify(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil) {
                String charSequence2 = charSequence.toString();
                if (phoneNumberUtil.isValidNumber(phoneNumber) && PhoneNumberMatcher.containsOnlyValidXChars(phoneNumber, charSequence2, phoneNumberUtil) && !PhoneNumberMatcher.containsMoreThanOneSlashInNationalNumber(phoneNumber, charSequence2) && PhoneNumberMatcher.isNationalPrefixPresentIfRequired(phoneNumber, phoneNumberUtil)) {
                    return PhoneNumberMatcher.checkNumberGroupingIsValid(phoneNumber, charSequence, phoneNumberUtil, new PhoneNumberMatcher.NumberGroupingChecker() { // from class: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency.3.1
                        @Override // io.michaelrocks.libphonenumber.android.PhoneNumberMatcher.NumberGroupingChecker
                        public boolean checkGroups(PhoneNumberUtil phoneNumberUtil2, Phonenumber.PhoneNumber phoneNumber2, StringBuilder sb, String[] strArr) {
                            return PhoneNumberMatcher.allNumberGroupsRemainGrouped(phoneNumberUtil2, phoneNumber2, sb, strArr);
                        }
                    });
                }
                return false;
            }
        },
        EXACT_GROUPING { // from class: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency.4
            @Override // io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency
            final boolean verify(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil) {
                String charSequence2 = charSequence.toString();
                if (phoneNumberUtil.isValidNumber(phoneNumber) && PhoneNumberMatcher.containsOnlyValidXChars(phoneNumber, charSequence2, phoneNumberUtil) && !PhoneNumberMatcher.containsMoreThanOneSlashInNationalNumber(phoneNumber, charSequence2) && PhoneNumberMatcher.isNationalPrefixPresentIfRequired(phoneNumber, phoneNumberUtil)) {
                    return PhoneNumberMatcher.checkNumberGroupingIsValid(phoneNumber, charSequence, phoneNumberUtil, new PhoneNumberMatcher.NumberGroupingChecker() { // from class: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.Leniency.4.1
                        @Override // io.michaelrocks.libphonenumber.android.PhoneNumberMatcher.NumberGroupingChecker
                        public boolean checkGroups(PhoneNumberUtil phoneNumberUtil2, Phonenumber.PhoneNumber phoneNumber2, StringBuilder sb, String[] strArr) {
                            return PhoneNumberMatcher.allNumberGroupsAreExactlyPresent(phoneNumberUtil2, phoneNumber2, sb, strArr);
                        }
                    });
                }
                return false;
            }
        };

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract boolean verify(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence, PhoneNumberUtil phoneNumberUtil);
    }

    /* loaded from: classes9.dex */
    public enum MatchType {
        NOT_A_NUMBER,
        NO_MATCH,
        SHORT_NSN_MATCH,
        NSN_MATCH,
        EXACT_MATCH
    }

    /* loaded from: classes6.dex */
    public enum PhoneNumberFormat {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    /* loaded from: classes6.dex */
    public enum PhoneNumberType {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    /* loaded from: classes6.dex */
    public enum ValidationResult {
        IS_POSSIBLE,
        IS_POSSIBLE_LOCAL_ONLY,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        INVALID_LENGTH,
        TOO_LONG
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(52, "1");
        hashMap.put(54, PrepareException.ERROR_OFFLINE_APP);
        MOBILE_TOKEN_MAPPINGS = Collections.unmodifiableMap(hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add(86);
        GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES = Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(52);
        hashSet2.add(54);
        hashSet2.add(55);
        hashSet2.add(62);
        hashSet2.addAll(hashSet);
        GEO_MOBILE_COUNTRIES = Collections.unmodifiableSet(hashSet2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put('0', '0');
        hashMap2.put('1', '1');
        hashMap2.put('2', '2');
        hashMap2.put('3', '3');
        hashMap2.put('4', '4');
        hashMap2.put('5', '5');
        hashMap2.put('6', '6');
        hashMap2.put('7', '7');
        hashMap2.put('8', '8');
        hashMap2.put('9', '9');
        HashMap hashMap3 = new HashMap(40);
        hashMap3.put('A', '2');
        hashMap3.put('B', '2');
        hashMap3.put('C', '2');
        hashMap3.put('D', '3');
        hashMap3.put('E', '3');
        hashMap3.put('F', '3');
        hashMap3.put('G', '4');
        hashMap3.put('H', '4');
        hashMap3.put('I', '4');
        hashMap3.put('J', '5');
        hashMap3.put('K', '5');
        hashMap3.put('L', '5');
        hashMap3.put('M', '6');
        hashMap3.put('N', '6');
        hashMap3.put('O', '6');
        hashMap3.put('P', '7');
        hashMap3.put('Q', '7');
        hashMap3.put('R', '7');
        hashMap3.put('S', '7');
        hashMap3.put('T', '8');
        hashMap3.put('U', '8');
        hashMap3.put('V', '8');
        hashMap3.put('W', '9');
        hashMap3.put('X', '9');
        hashMap3.put('Y', '9');
        hashMap3.put('Z', '9');
        Map<Character, Character> unmodifiableMap = Collections.unmodifiableMap(hashMap3);
        ALPHA_MAPPINGS = unmodifiableMap;
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(unmodifiableMap);
        hashMap4.putAll(hashMap2);
        ALPHA_PHONE_MAPPINGS = Collections.unmodifiableMap(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll(hashMap2);
        Character valueOf = Character.valueOf(PLUS_SIGN);
        hashMap5.put(valueOf, valueOf);
        Character valueOf2 = Character.valueOf(STAR_SIGN);
        hashMap5.put(valueOf2, valueOf2);
        hashMap5.put('#', '#');
        DIALLABLE_CHAR_MAPPINGS = Collections.unmodifiableMap(hashMap5);
        HashMap hashMap6 = new HashMap();
        Iterator<Character> it = unmodifiableMap.keySet().iterator();
        while (it.hasNext()) {
            char charValue = it.next().charValue();
            hashMap6.put(Character.valueOf(Character.toLowerCase(charValue)), Character.valueOf(charValue));
            hashMap6.put(Character.valueOf(charValue), Character.valueOf(charValue));
        }
        hashMap6.putAll(hashMap2);
        hashMap6.put('-', '-');
        hashMap6.put((char) 65293, '-');
        hashMap6.put((char) 8208, '-');
        hashMap6.put((char) 8209, '-');
        hashMap6.put((char) 8210, '-');
        hashMap6.put(Character.valueOf(Typography.ndash), '-');
        hashMap6.put(Character.valueOf(Typography.mdash), '-');
        hashMap6.put((char) 8213, '-');
        hashMap6.put((char) 8722, '-');
        hashMap6.put('/', '/');
        hashMap6.put((char) 65295, '/');
        hashMap6.put(Character.valueOf(InputCardNumberView.DIVIDER), Character.valueOf(InputCardNumberView.DIVIDER));
        hashMap6.put((char) 12288, Character.valueOf(InputCardNumberView.DIVIDER));
        hashMap6.put((char) 8288, Character.valueOf(InputCardNumberView.DIVIDER));
        hashMap6.put('.', '.');
        hashMap6.put((char) 65294, '.');
        ALL_PLUS_NUMBER_GROUPING_SYMBOLS = Collections.unmodifiableMap(hashMap6);
        SINGLE_INTERNATIONAL_PREFIX = Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> map = ALPHA_MAPPINGS;
        sb.append(Arrays.toString(map.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        sb.append(Arrays.toString(map.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        String obj = sb.toString();
        VALID_ALPHA = obj;
        PLUS_CHARS_PATTERN = Pattern.compile("[+＋]+");
        SEPARATOR_PATTERN = Pattern.compile("[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～]+");
        CAPTURING_DIGIT_PATTERN = Pattern.compile("(\\p{Nd})");
        VALID_START_CHAR_PATTERN = Pattern.compile(VALID_START_CHAR);
        SECOND_NUMBER_START_PATTERN = Pattern.compile(SECOND_NUMBER_START);
        UNWANTED_END_CHAR_PATTERN = Pattern.compile(UNWANTED_END_CHARS);
        VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  \u00ad\u200b\u2060\u3000()（）［］.\\[\\]/~⁓∼～*");
        sb2.append(obj);
        sb2.append(DIGITS);
        sb2.append("]*");
        String obj2 = sb2.toString();
        VALID_PHONE_NUMBER = obj2;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(",;");
        sb3.append("xｘ#＃~～");
        String createExtnPattern = createExtnPattern(sb3.toString());
        EXTN_PATTERNS_FOR_PARSING = createExtnPattern;
        EXTN_PATTERNS_FOR_MATCHING = createExtnPattern("xｘ#＃~～");
        StringBuilder sb4 = new StringBuilder();
        sb4.append("(?:");
        sb4.append(createExtnPattern);
        sb4.append(")$");
        EXTN_PATTERN = Pattern.compile(sb4.toString(), 66);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(obj2);
        sb5.append("(?:");
        sb5.append(createExtnPattern);
        sb5.append(")?");
        VALID_PHONE_NUMBER_PATTERN = Pattern.compile(sb5.toString(), 66);
        NON_DIGITS_PATTERN = Pattern.compile("(\\D+)");
        FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
        FIRST_GROUP_ONLY_PREFIX_PATTERN = Pattern.compile("\\(?\\$1\\)?");
    }

    private static String createExtnPattern(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|[");
        sb.append(str);
        sb.append("]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*");
        sb.append(CAPTURING_EXTN_DIGITS);
        sb.append("#?|[- ]+(");
        sb.append(DIGITS);
        sb.append("{1,5})#");
        return sb.toString();
    }

    PhoneNumberUtil(MetadataSource metadataSource, Map<Integer, List<String>> map) {
        this.metadataSource = metadataSource;
        this.countryCallingCodeToRegionCodeMap = map;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            if (value.size() == 1 && "001".equals(value.get(0))) {
                this.countryCodesForNonGeographicalRegion.add(entry.getKey());
            } else {
                this.supportedRegions.addAll(value);
            }
        }
        if (this.supportedRegions.remove("001")) {
            logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.nanpaRegions.addAll(map.get(1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MetadataSource getMetadataSource() {
        return this.metadataSource;
    }

    public ShortNumberInfo getShortNumberInfo() {
        if (this.shortNumberInfo == null) {
            synchronized (this) {
                if (this.shortNumberInfo == null) {
                    this.shortNumberInfo = new ShortNumberInfo(this.metadataSource, RegexBasedMatcher.create());
                }
            }
        }
        return this.shortNumberInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CharSequence extractPossibleNumber(CharSequence charSequence) {
        Matcher matcher = VALID_START_CHAR_PATTERN.matcher(charSequence);
        if (matcher.find()) {
            CharSequence subSequence = charSequence.subSequence(matcher.start(), charSequence.length());
            Matcher matcher2 = UNWANTED_END_CHAR_PATTERN.matcher(subSequence);
            if (matcher2.find()) {
                subSequence = subSequence.subSequence(0, matcher2.start());
            }
            Matcher matcher3 = SECOND_NUMBER_START_PATTERN.matcher(subSequence);
            return matcher3.find() ? subSequence.subSequence(0, matcher3.start()) : subSequence;
        }
        return "";
    }

    static boolean isViablePhoneNumber(CharSequence charSequence) {
        if (charSequence.length() < 2) {
            return false;
        }
        return VALID_PHONE_NUMBER_PATTERN.matcher(charSequence).matches();
    }

    static StringBuilder normalize(StringBuilder sb) {
        if (VALID_ALPHA_PHONE_PATTERN.matcher(sb).matches()) {
            sb.replace(0, sb.length(), normalizeHelper(sb, ALPHA_PHONE_MAPPINGS, true));
        } else {
            sb.replace(0, sb.length(), normalizeDigitsOnly(sb));
        }
        return sb;
    }

    public static String normalizeDigitsOnly(CharSequence charSequence) {
        return normalizeDigits(charSequence, false).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder normalizeDigits(CharSequence charSequence, boolean z) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            int digit = Character.digit(charAt, 10);
            if (digit != -1) {
                sb.append(digit);
            } else if (z) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    public static String normalizeDiallableCharsOnly(CharSequence charSequence) {
        return normalizeHelper(charSequence, DIALLABLE_CHAR_MAPPINGS, true);
    }

    public static String convertAlphaCharactersInNumber(CharSequence charSequence) {
        return normalizeHelper(charSequence, ALPHA_PHONE_MAPPINGS, false);
    }

    public int getLengthOfGeographicalAreaCode(Phonenumber.PhoneNumber phoneNumber) {
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(getRegionCodeForNumber(phoneNumber));
        if (metadataForRegion == null) {
            return 0;
        }
        if (metadataForRegion.hasNationalPrefix() || phoneNumber.isItalianLeadingZero()) {
            PhoneNumberType numberType = getNumberType(phoneNumber);
            int countryCode = phoneNumber.getCountryCode();
            if (!(numberType == PhoneNumberType.MOBILE && GEO_MOBILE_COUNTRIES_WITHOUT_MOBILE_AREA_CODES.contains(Integer.valueOf(countryCode))) && isNumberGeographical(numberType, countryCode)) {
                return getLengthOfNationalDestinationCode(phoneNumber);
            }
            return 0;
        }
        return 0;
    }

    public int getLengthOfNationalDestinationCode(Phonenumber.PhoneNumber phoneNumber) {
        Phonenumber.PhoneNumber phoneNumber2;
        if (phoneNumber.hasExtension()) {
            phoneNumber2 = new Phonenumber.PhoneNumber();
            phoneNumber2.mergeFrom(phoneNumber);
            phoneNumber2.clearExtension();
        } else {
            phoneNumber2 = phoneNumber;
        }
        String[] split = NON_DIGITS_PATTERN.split(format(phoneNumber2, PhoneNumberFormat.INTERNATIONAL));
        if (split.length <= 3) {
            return 0;
        }
        if (getNumberType(phoneNumber) == PhoneNumberType.MOBILE && !getCountryMobileToken(phoneNumber.getCountryCode()).equals("")) {
            return split[2].length() + split[3].length();
        }
        return split[2].length();
    }

    public static String getCountryMobileToken(int i) {
        Map<Integer, String> map = MOBILE_TOKEN_MAPPINGS;
        return map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)) : "";
    }

    private static String normalizeHelper(CharSequence charSequence, Map<Character, Character> map, boolean z) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            Character ch = map.get(Character.valueOf(Character.toUpperCase(charAt)));
            if (ch != null) {
                sb.append(ch);
            } else if (!z) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public Set<String> getSupportedRegions() {
        return Collections.unmodifiableSet(this.supportedRegions);
    }

    public Set<Integer> getSupportedGlobalNetworkCallingCodes() {
        return Collections.unmodifiableSet(this.countryCodesForNonGeographicalRegion);
    }

    public Set<Integer> getSupportedCallingCodes() {
        return Collections.unmodifiableSet(this.countryCallingCodeToRegionCodeMap.keySet());
    }

    private static boolean descHasPossibleNumberData(Phonemetadata.PhoneNumberDesc phoneNumberDesc) {
        return (phoneNumberDesc.getPossibleLengthCount() == 1 && phoneNumberDesc.getPossibleLength(0) == -1) ? false : true;
    }

    private static boolean descHasData(Phonemetadata.PhoneNumberDesc phoneNumberDesc) {
        return phoneNumberDesc.hasExampleNumber() || descHasPossibleNumberData(phoneNumberDesc) || phoneNumberDesc.hasNationalNumberPattern();
    }

    private Set<PhoneNumberType> getSupportedTypesForMetadata(Phonemetadata.PhoneMetadata phoneMetadata) {
        TreeSet treeSet = new TreeSet();
        for (PhoneNumberType phoneNumberType : PhoneNumberType.values()) {
            if (phoneNumberType != PhoneNumberType.FIXED_LINE_OR_MOBILE && phoneNumberType != PhoneNumberType.UNKNOWN && descHasData(getNumberDescByType(phoneMetadata, phoneNumberType))) {
                treeSet.add(phoneNumberType);
            }
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public Set<PhoneNumberType> getSupportedTypesForRegion(String str) {
        if (!isValidRegionCode(str)) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid or unknown region code provided: ");
            sb.append(str);
            logger2.log(level, sb.toString());
            return Collections.unmodifiableSet(new TreeSet());
        }
        return getSupportedTypesForMetadata(getMetadataForRegion(str));
    }

    public Set<PhoneNumberType> getSupportedTypesForNonGeoEntity(int i) {
        Phonemetadata.PhoneMetadata metadataForNonGeographicalRegion = getMetadataForNonGeographicalRegion(i);
        if (metadataForNonGeographicalRegion == null) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Unknown country calling code for a non-geographical entity provided: ");
            sb.append(i);
            logger2.log(level, sb.toString());
            return Collections.unmodifiableSet(new TreeSet());
        }
        return getSupportedTypesForMetadata(metadataForNonGeographicalRegion);
    }

    public static PhoneNumberUtil createInstance(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context could not be null.");
        }
        return createInstance(new AssetsMetadataLoader(context.getAssets()));
    }

    public static PhoneNumberUtil createInstance(MetadataSource metadataSource) {
        if (metadataSource == null) {
            throw new IllegalArgumentException("metadataSource could not be null.");
        }
        return new PhoneNumberUtil(metadataSource, CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap());
    }

    public static PhoneNumberUtil createInstance(MetadataLoader metadataLoader) {
        if (metadataLoader == null) {
            throw new IllegalArgumentException("metadataLoader could not be null.");
        }
        return createInstance(new MultiFileMetadataSourceImpl(metadataLoader));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean formattingRuleHasFirstGroupOnly(String str) {
        return str.length() == 0 || FIRST_GROUP_ONLY_PREFIX_PATTERN.matcher(str).matches();
    }

    public boolean isNumberGeographical(Phonenumber.PhoneNumber phoneNumber) {
        return isNumberGeographical(getNumberType(phoneNumber), phoneNumber.getCountryCode());
    }

    public boolean isNumberGeographical(PhoneNumberType phoneNumberType, int i) {
        return phoneNumberType == PhoneNumberType.FIXED_LINE || phoneNumberType == PhoneNumberType.FIXED_LINE_OR_MOBILE || (GEO_MOBILE_COUNTRIES.contains(Integer.valueOf(i)) && phoneNumberType == PhoneNumberType.MOBILE);
    }

    private boolean isValidRegionCode(String str) {
        return str != null && this.supportedRegions.contains(str);
    }

    private boolean hasValidCountryCallingCode(int i) {
        return this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(i));
    }

    public String format(Phonenumber.PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat) {
        if (phoneNumber.getNationalNumber() == 0 && phoneNumber.hasRawInput()) {
            String rawInput = phoneNumber.getRawInput();
            if (rawInput.length() > 0) {
                return rawInput;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        format(phoneNumber, phoneNumberFormat, sb);
        return sb.toString();
    }

    public void format(Phonenumber.PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        sb.setLength(0);
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (phoneNumberFormat == PhoneNumberFormat.E164) {
            sb.append(nationalSignificantNumber);
            prefixNumberWithCountryCallingCode(countryCode, PhoneNumberFormat.E164, sb);
        } else if (!hasValidCountryCallingCode(countryCode)) {
            sb.append(nationalSignificantNumber);
        } else {
            Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
            sb.append(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, phoneNumberFormat));
            maybeAppendFormattedExtension(phoneNumber, metadataForRegionOrCallingCode, phoneNumberFormat, sb);
            prefixNumberWithCountryCallingCode(countryCode, phoneNumberFormat, sb);
        }
    }

    public String formatByPattern(Phonenumber.PhoneNumber phoneNumber, PhoneNumberFormat phoneNumberFormat, List<Phonemetadata.NumberFormat> list) {
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (hasValidCountryCallingCode(countryCode)) {
            Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
            StringBuilder sb = new StringBuilder(20);
            Phonemetadata.NumberFormat chooseFormattingPatternForNumber = chooseFormattingPatternForNumber(list, nationalSignificantNumber);
            if (chooseFormattingPatternForNumber == null) {
                sb.append(nationalSignificantNumber);
            } else {
                Phonemetadata.NumberFormat.Builder newBuilder = Phonemetadata.NumberFormat.newBuilder();
                newBuilder.mergeFrom(chooseFormattingPatternForNumber);
                String nationalPrefixFormattingRule = chooseFormattingPatternForNumber.getNationalPrefixFormattingRule();
                if (nationalPrefixFormattingRule.length() > 0) {
                    String nationalPrefix = metadataForRegionOrCallingCode.getNationalPrefix();
                    if (nationalPrefix.length() > 0) {
                        newBuilder.setNationalPrefixFormattingRule(nationalPrefixFormattingRule.replace(NP_STRING, nationalPrefix).replace(FG_STRING, "$1"));
                    } else {
                        newBuilder.clearNationalPrefixFormattingRule();
                    }
                }
                sb.append(formatNsnUsingPattern(nationalSignificantNumber, newBuilder, phoneNumberFormat));
            }
            maybeAppendFormattedExtension(phoneNumber, metadataForRegionOrCallingCode, phoneNumberFormat, sb);
            prefixNumberWithCountryCallingCode(countryCode, phoneNumberFormat, sb);
            return sb.toString();
        }
        return nationalSignificantNumber;
    }

    public String formatNationalNumberWithCarrierCode(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence) {
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (hasValidCountryCallingCode(countryCode)) {
            Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
            StringBuilder sb = new StringBuilder(20);
            sb.append(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, PhoneNumberFormat.NATIONAL, charSequence));
            maybeAppendFormattedExtension(phoneNumber, metadataForRegionOrCallingCode, PhoneNumberFormat.NATIONAL, sb);
            prefixNumberWithCountryCallingCode(countryCode, PhoneNumberFormat.NATIONAL, sb);
            return sb.toString();
        }
        return nationalSignificantNumber;
    }

    private Phonemetadata.PhoneMetadata getMetadataForRegionOrCallingCode(int i, String str) {
        if ("001".equals(str)) {
            return getMetadataForNonGeographicalRegion(i);
        }
        return getMetadataForRegion(str);
    }

    public String formatNationalNumberWithPreferredCarrierCode(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence) {
        if (phoneNumber.getPreferredDomesticCarrierCode().length() > 0) {
            charSequence = phoneNumber.getPreferredDomesticCarrierCode();
        }
        return formatNationalNumberWithCarrierCode(phoneNumber, charSequence);
    }

    public String formatNumberForMobileDialing(Phonenumber.PhoneNumber phoneNumber, String str, boolean z) {
        int countryCode = phoneNumber.getCountryCode();
        String str2 = "";
        if (!hasValidCountryCallingCode(countryCode)) {
            return phoneNumber.hasRawInput() ? phoneNumber.getRawInput() : "";
        }
        Phonenumber.PhoneNumber clearExtension = new Phonenumber.PhoneNumber().mergeFrom(phoneNumber).clearExtension();
        String regionCodeForCountryCode = getRegionCodeForCountryCode(countryCode);
        PhoneNumberType numberType = getNumberType(clearExtension);
        boolean z2 = numberType != PhoneNumberType.UNKNOWN;
        if (str.equals(regionCodeForCountryCode)) {
            boolean z3 = numberType == PhoneNumberType.FIXED_LINE || numberType == PhoneNumberType.MOBILE || numberType == PhoneNumberType.FIXED_LINE_OR_MOBILE;
            if (regionCodeForCountryCode.equals("CO") && numberType == PhoneNumberType.FIXED_LINE) {
                str2 = formatNationalNumberWithCarrierCode(clearExtension, "3");
            } else if (regionCodeForCountryCode.equals("BR") && z3) {
                if (clearExtension.getPreferredDomesticCarrierCode().length() > 0) {
                    str2 = formatNationalNumberWithPreferredCarrierCode(clearExtension, "");
                }
            } else if (z2 && regionCodeForCountryCode.equals("HU")) {
                StringBuilder sb = new StringBuilder();
                sb.append(getNddPrefixForRegion(regionCodeForCountryCode, true));
                sb.append(" ");
                sb.append(format(clearExtension, PhoneNumberFormat.NATIONAL));
                str2 = sb.toString();
            } else if (countryCode == 1) {
                Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
                if (canBeInternationallyDialled(clearExtension) && testNumberLength(getNationalSignificantNumber(clearExtension), metadataForRegion) != ValidationResult.TOO_SHORT) {
                    str2 = format(clearExtension, PhoneNumberFormat.INTERNATIONAL);
                } else {
                    str2 = format(clearExtension, PhoneNumberFormat.NATIONAL);
                }
            } else if ((regionCodeForCountryCode.equals("001") || ((regionCodeForCountryCode.equals("MX") || regionCodeForCountryCode.equals("CL") || regionCodeForCountryCode.equals("UZ")) && z3)) && canBeInternationallyDialled(clearExtension)) {
                str2 = format(clearExtension, PhoneNumberFormat.INTERNATIONAL);
            } else {
                str2 = format(clearExtension, PhoneNumberFormat.NATIONAL);
            }
        } else if (z2 && canBeInternationallyDialled(clearExtension)) {
            if (z) {
                return format(clearExtension, PhoneNumberFormat.INTERNATIONAL);
            }
            return format(clearExtension, PhoneNumberFormat.E164);
        }
        return !z ? normalizeDiallableCharsOnly(str2) : str2;
    }

    public String formatOutOfCountryCallingNumber(Phonenumber.PhoneNumber phoneNumber, String str) {
        if (!isValidRegionCode(str)) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Trying to format number from invalid region ");
            sb.append(str);
            sb.append(". International formatting applied.");
            logger2.log(level, sb.toString());
            return format(phoneNumber, PhoneNumberFormat.INTERNATIONAL);
        }
        int countryCode = phoneNumber.getCountryCode();
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        if (hasValidCountryCallingCode(countryCode)) {
            if (countryCode == 1) {
                if (isNANPACountry(str)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(countryCode);
                    sb2.append(" ");
                    sb2.append(format(phoneNumber, PhoneNumberFormat.NATIONAL));
                    return sb2.toString();
                }
            } else if (countryCode == getCountryCodeForValidRegion(str)) {
                return format(phoneNumber, PhoneNumberFormat.NATIONAL);
            }
            Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
            String internationalPrefix = metadataForRegion.getInternationalPrefix();
            if (!SINGLE_INTERNATIONAL_PREFIX.matcher(internationalPrefix).matches()) {
                internationalPrefix = metadataForRegion.hasPreferredInternationalPrefix() ? metadataForRegion.getPreferredInternationalPrefix() : "";
            }
            Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
            StringBuilder sb3 = new StringBuilder(formatNsn(nationalSignificantNumber, metadataForRegionOrCallingCode, PhoneNumberFormat.INTERNATIONAL));
            maybeAppendFormattedExtension(phoneNumber, metadataForRegionOrCallingCode, PhoneNumberFormat.INTERNATIONAL, sb3);
            if (internationalPrefix.length() > 0) {
                sb3.insert(0, " ").insert(0, countryCode).insert(0, " ").insert(0, internationalPrefix);
            } else {
                prefixNumberWithCountryCallingCode(countryCode, PhoneNumberFormat.INTERNATIONAL, sb3);
            }
            return sb3.toString();
        }
        return nationalSignificantNumber;
    }

    public String formatInOriginalFormat(Phonenumber.PhoneNumber phoneNumber, String str) {
        String format;
        String nationalPrefixFormattingRule;
        int indexOf;
        if (phoneNumber.hasRawInput() && !hasFormattingPatternForNumber(phoneNumber)) {
            return phoneNumber.getRawInput();
        }
        if (!phoneNumber.hasCountryCodeSource()) {
            return format(phoneNumber, PhoneNumberFormat.NATIONAL);
        }
        int i = AnonymousClass2.$SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource[phoneNumber.getCountryCodeSource().ordinal()];
        if (i == 1) {
            format = format(phoneNumber, PhoneNumberFormat.INTERNATIONAL);
        } else if (i == 2) {
            format = formatOutOfCountryCallingNumber(phoneNumber, str);
        } else if (i == 3) {
            format = format(phoneNumber, PhoneNumberFormat.INTERNATIONAL).substring(1);
        } else {
            String regionCodeForCountryCode = getRegionCodeForCountryCode(phoneNumber.getCountryCode());
            String nddPrefixForRegion = getNddPrefixForRegion(regionCodeForCountryCode, true);
            format = format(phoneNumber, PhoneNumberFormat.NATIONAL);
            if (nddPrefixForRegion != null && nddPrefixForRegion.length() != 0 && !rawInputContainsNationalPrefix(phoneNumber.getRawInput(), nddPrefixForRegion, regionCodeForCountryCode)) {
                Phonemetadata.NumberFormat chooseFormattingPatternForNumber = chooseFormattingPatternForNumber(getMetadataForRegion(regionCodeForCountryCode).numberFormats(), getNationalSignificantNumber(phoneNumber));
                if (chooseFormattingPatternForNumber != null && (indexOf = (nationalPrefixFormattingRule = chooseFormattingPatternForNumber.getNationalPrefixFormattingRule()).indexOf("$1")) > 0 && normalizeDigitsOnly(nationalPrefixFormattingRule.substring(0, indexOf)).length() != 0) {
                    Phonemetadata.NumberFormat.Builder newBuilder = Phonemetadata.NumberFormat.newBuilder();
                    newBuilder.mergeFrom(chooseFormattingPatternForNumber);
                    newBuilder.clearNationalPrefixFormattingRule();
                    List<Phonemetadata.NumberFormat> arrayList = new ArrayList<>(1);
                    arrayList.add(newBuilder);
                    format = formatByPattern(phoneNumber, PhoneNumberFormat.NATIONAL, arrayList);
                }
            }
        }
        String rawInput = phoneNumber.getRawInput();
        return (format == null || rawInput.length() <= 0 || normalizeDiallableCharsOnly(format).equals(normalizeDiallableCharsOnly(rawInput))) ? format : rawInput;
    }

    private boolean rawInputContainsNationalPrefix(String str, String str2, String str3) {
        String normalizeDigitsOnly = normalizeDigitsOnly(str);
        if (normalizeDigitsOnly.startsWith(str2)) {
            try {
                return isValidNumber(parse(normalizeDigitsOnly.substring(str2.length()), str3));
            } catch (NumberParseException unused) {
                return false;
            }
        }
        return false;
    }

    private boolean hasFormattingPatternForNumber(Phonenumber.PhoneNumber phoneNumber) {
        int countryCode = phoneNumber.getCountryCode();
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode));
        if (metadataForRegionOrCallingCode == null) {
            return false;
        }
        return chooseFormattingPatternForNumber(metadataForRegionOrCallingCode.numberFormats(), getNationalSignificantNumber(phoneNumber)) != null;
    }

    public String formatOutOfCountryKeepingAlphaChars(Phonenumber.PhoneNumber phoneNumber, String str) {
        String str2;
        int indexOf;
        String rawInput = phoneNumber.getRawInput();
        if (rawInput.length() == 0) {
            return formatOutOfCountryCallingNumber(phoneNumber, str);
        }
        int countryCode = phoneNumber.getCountryCode();
        if (hasValidCountryCallingCode(countryCode)) {
            String normalizeHelper = normalizeHelper(rawInput, ALL_PLUS_NUMBER_GROUPING_SYMBOLS, true);
            String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
            if (nationalSignificantNumber.length() > 3 && (indexOf = normalizeHelper.indexOf(nationalSignificantNumber.substring(0, 3))) != -1) {
                normalizeHelper = normalizeHelper.substring(indexOf);
            }
            Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
            if (countryCode == 1) {
                if (isNANPACountry(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(countryCode);
                    sb.append(" ");
                    sb.append(normalizeHelper);
                    return sb.toString();
                }
            } else if (metadataForRegion != null && countryCode == getCountryCodeForValidRegion(str)) {
                Phonemetadata.NumberFormat chooseFormattingPatternForNumber = chooseFormattingPatternForNumber(metadataForRegion.numberFormats(), nationalSignificantNumber);
                if (chooseFormattingPatternForNumber == null) {
                    return normalizeHelper;
                }
                Phonemetadata.NumberFormat.Builder newBuilder = Phonemetadata.NumberFormat.newBuilder();
                newBuilder.mergeFrom(chooseFormattingPatternForNumber);
                newBuilder.setPattern("(\\d+)(.*)");
                newBuilder.setFormat("$1$2");
                return formatNsnUsingPattern(normalizeHelper, newBuilder, PhoneNumberFormat.NATIONAL);
            }
            if (metadataForRegion != null) {
                str2 = metadataForRegion.getInternationalPrefix();
                if (!SINGLE_INTERNATIONAL_PREFIX.matcher(str2).matches()) {
                    str2 = metadataForRegion.getPreferredInternationalPrefix();
                }
            } else {
                str2 = "";
            }
            StringBuilder sb2 = new StringBuilder(normalizeHelper);
            maybeAppendFormattedExtension(phoneNumber, getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode)), PhoneNumberFormat.INTERNATIONAL, sb2);
            if (str2.length() > 0) {
                sb2.insert(0, " ").insert(0, countryCode).insert(0, " ").insert(0, str2);
            } else {
                if (!isValidRegionCode(str)) {
                    Logger logger2 = logger;
                    Level level = Level.WARNING;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Trying to format number from invalid region ");
                    sb3.append(str);
                    sb3.append(". International formatting applied.");
                    logger2.log(level, sb3.toString());
                }
                prefixNumberWithCountryCallingCode(countryCode, PhoneNumberFormat.INTERNATIONAL, sb2);
            }
            return sb2.toString();
        }
        return rawInput;
    }

    public String getNationalSignificantNumber(Phonenumber.PhoneNumber phoneNumber) {
        StringBuilder sb = new StringBuilder();
        if (phoneNumber.isItalianLeadingZero() && phoneNumber.getNumberOfLeadingZeros() > 0) {
            char[] cArr = new char[phoneNumber.getNumberOfLeadingZeros()];
            Arrays.fill(cArr, '0');
            sb.append(new String(cArr));
        }
        sb.append(phoneNumber.getNationalNumber());
        return sb.toString();
    }

    private void prefixNumberWithCountryCallingCode(int i, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        int i2 = AnonymousClass2.$SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat[phoneNumberFormat.ordinal()];
        if (i2 == 1) {
            sb.insert(0, i).insert(0, PLUS_SIGN);
        } else if (i2 == 2) {
            sb.insert(0, " ").insert(0, i).insert(0, PLUS_SIGN);
        } else if (i2 != 3) {
        } else {
            sb.insert(0, "-").insert(0, i).insert(0, PLUS_SIGN).insert(0, RFC3966_PREFIX);
        }
    }

    private String formatNsn(String str, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat) {
        return formatNsn(str, phoneMetadata, phoneNumberFormat, null);
    }

    private String formatNsn(String str, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat, CharSequence charSequence) {
        List<Phonemetadata.NumberFormat> numberFormats;
        if (phoneMetadata.intlNumberFormats().size() == 0 || phoneNumberFormat == PhoneNumberFormat.NATIONAL) {
            numberFormats = phoneMetadata.numberFormats();
        } else {
            numberFormats = phoneMetadata.intlNumberFormats();
        }
        Phonemetadata.NumberFormat chooseFormattingPatternForNumber = chooseFormattingPatternForNumber(numberFormats, str);
        return chooseFormattingPatternForNumber != null ? formatNsnUsingPattern(str, chooseFormattingPatternForNumber, phoneNumberFormat, charSequence) : str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Phonemetadata.NumberFormat chooseFormattingPatternForNumber(List<Phonemetadata.NumberFormat> list, String str) {
        for (Phonemetadata.NumberFormat numberFormat : list) {
            int leadingDigitsPatternSize = numberFormat.leadingDigitsPatternSize();
            if (leadingDigitsPatternSize == 0 || this.regexCache.getPatternForRegex(numberFormat.getLeadingDigitsPattern(leadingDigitsPatternSize - 1)).matcher(str).lookingAt()) {
                if (this.regexCache.getPatternForRegex(numberFormat.getPattern()).matcher(str).matches()) {
                    return numberFormat;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String formatNsnUsingPattern(String str, Phonemetadata.NumberFormat numberFormat, PhoneNumberFormat phoneNumberFormat) {
        return formatNsnUsingPattern(str, numberFormat, phoneNumberFormat, null);
    }

    private String formatNsnUsingPattern(String str, Phonemetadata.NumberFormat numberFormat, PhoneNumberFormat phoneNumberFormat, CharSequence charSequence) {
        String replaceAll;
        String format = numberFormat.getFormat();
        Matcher matcher = this.regexCache.getPatternForRegex(numberFormat.getPattern()).matcher(str);
        if (phoneNumberFormat == PhoneNumberFormat.NATIONAL && charSequence != null && charSequence.length() > 0 && numberFormat.getDomesticCarrierCodeFormattingRule().length() > 0) {
            replaceAll = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher(format).replaceFirst(numberFormat.getDomesticCarrierCodeFormattingRule().replace(CC_STRING, charSequence)));
        } else {
            String nationalPrefixFormattingRule = numberFormat.getNationalPrefixFormattingRule();
            if (phoneNumberFormat == PhoneNumberFormat.NATIONAL && nationalPrefixFormattingRule != null && nationalPrefixFormattingRule.length() > 0) {
                replaceAll = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher(format).replaceFirst(nationalPrefixFormattingRule));
            } else {
                replaceAll = matcher.replaceAll(format);
            }
        }
        if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
            Matcher matcher2 = SEPARATOR_PATTERN.matcher(replaceAll);
            if (matcher2.lookingAt()) {
                replaceAll = matcher2.replaceFirst("");
            }
            return matcher2.reset(replaceAll).replaceAll("-");
        }
        return replaceAll;
    }

    public Phonenumber.PhoneNumber getExampleNumber(String str) {
        return getExampleNumberForType(str, PhoneNumberType.FIXED_LINE);
    }

    /*  JADX ERROR: NullPointerException in pass: BlockProcessor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getPredecessors()" because "to" is null
        	at jadx.core.dex.visitors.blocks.BlockSplitter.connect(BlockSplitter.java:150)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectSplittersAndHandlers(BlockExceptionHandler.java:452)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.wrapBlocksWithTryCatch(BlockExceptionHandler.java:353)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.connectExcHandlers(BlockExceptionHandler.java:85)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:60)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:323)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:51)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public io.michaelrocks.libphonenumber.android.Phonenumber.PhoneNumber getInvalidExampleNumber(java.lang.String r6) {
        /*
            r5 = this;
            boolean r0 = r5.isValidRegionCode(r6)
            r1 = 0
            if (r0 != 0) goto L20
            java.util.logging.Logger r0 = io.michaelrocks.libphonenumber.android.PhoneNumberUtil.logger
            java.util.logging.Level r2 = java.util.logging.Level.WARNING
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Invalid or unknown region code provided: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            r0.log(r2, r6)
            return r1
        L20:
            io.michaelrocks.libphonenumber.android.Phonemetadata$PhoneMetadata r0 = r5.getMetadataForRegion(r6)
            io.michaelrocks.libphonenumber.android.PhoneNumberUtil$PhoneNumberType r2 = io.michaelrocks.libphonenumber.android.PhoneNumberUtil.PhoneNumberType.FIXED_LINE
            io.michaelrocks.libphonenumber.android.Phonemetadata$PhoneNumberDesc r0 = r5.getNumberDescByType(r0, r2)
            boolean r2 = r0.hasExampleNumber()
            if (r2 != 0) goto L31
            return r1
        L31:
            java.lang.String r0 = r0.getExampleNumber()
            int r2 = r0.length()
            int r2 = r2 + (-1)
        L3b:
            r3 = 2
            if (r2 < r3) goto L51
            r3 = 0
            java.lang.String r3 = r0.substring(r3, r2)
            io.michaelrocks.libphonenumber.android.Phonenumber$PhoneNumber r3 = r5.parse(r3, r6)     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> L4e
            boolean r4 = r5.isValidNumber(r3)     // Catch: io.michaelrocks.libphonenumber.android.NumberParseException -> L4e
            if (r4 != 0) goto L4e
            return r3
        L4e:
            int r2 = r2 + (-1)
            goto L3b
        L51:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.getInvalidExampleNumber(java.lang.String):io.michaelrocks.libphonenumber.android.Phonenumber$PhoneNumber");
    }

    public Phonenumber.PhoneNumber getExampleNumberForType(String str, PhoneNumberType phoneNumberType) {
        if (!isValidRegionCode(str)) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid or unknown region code provided: ");
            sb.append(str);
            logger2.log(level, sb.toString());
            return null;
        }
        Phonemetadata.PhoneNumberDesc numberDescByType = getNumberDescByType(getMetadataForRegion(str), phoneNumberType);
        try {
            if (numberDescByType.hasExampleNumber()) {
                return parse(numberDescByType.getExampleNumber(), str);
            }
        } catch (NumberParseException e) {
            logger.log(Level.SEVERE, e.toString());
        }
        return null;
    }

    public Phonenumber.PhoneNumber getExampleNumberForType(PhoneNumberType phoneNumberType) {
        Iterator<String> it = getSupportedRegions().iterator();
        while (it.hasNext()) {
            Phonenumber.PhoneNumber exampleNumberForType = getExampleNumberForType(it.next(), phoneNumberType);
            if (exampleNumberForType != null) {
                return exampleNumberForType;
            }
        }
        Iterator<Integer> it2 = getSupportedGlobalNetworkCallingCodes().iterator();
        while (it2.hasNext()) {
            int intValue = it2.next().intValue();
            Phonemetadata.PhoneNumberDesc numberDescByType = getNumberDescByType(getMetadataForNonGeographicalRegion(intValue), phoneNumberType);
            try {
            } catch (NumberParseException e) {
                logger.log(Level.SEVERE, e.toString());
            }
            if (numberDescByType.hasExampleNumber()) {
                StringBuilder sb = new StringBuilder();
                sb.append("+");
                sb.append(intValue);
                sb.append(numberDescByType.getExampleNumber());
                return parse(sb.toString(), UNKNOWN_REGION);
            }
            continue;
        }
        return null;
    }

    public Phonenumber.PhoneNumber getExampleNumberForNonGeoEntity(int i) {
        Phonemetadata.PhoneMetadata metadataForNonGeographicalRegion = getMetadataForNonGeographicalRegion(i);
        if (metadataForNonGeographicalRegion != null) {
            for (Phonemetadata.PhoneNumberDesc phoneNumberDesc : Arrays.asList(metadataForNonGeographicalRegion.getMobile(), metadataForNonGeographicalRegion.getTollFree(), metadataForNonGeographicalRegion.getSharedCost(), metadataForNonGeographicalRegion.getVoip(), metadataForNonGeographicalRegion.getVoicemail(), metadataForNonGeographicalRegion.getUan(), metadataForNonGeographicalRegion.getPremiumRate())) {
                if (phoneNumberDesc != null) {
                    try {
                        if (phoneNumberDesc.hasExampleNumber()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("+");
                            sb.append(i);
                            sb.append(phoneNumberDesc.getExampleNumber());
                            return parse(sb.toString(), UNKNOWN_REGION);
                        }
                        continue;
                    } catch (NumberParseException e) {
                        logger.log(Level.SEVERE, e.toString());
                    }
                }
            }
            return null;
        }
        Logger logger2 = logger;
        Level level = Level.WARNING;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Invalid or unknown country calling code provided: ");
        sb2.append(i);
        logger2.log(level, sb2.toString());
        return null;
    }

    private void maybeAppendFormattedExtension(Phonenumber.PhoneNumber phoneNumber, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        if (!phoneNumber.hasExtension() || phoneNumber.getExtension().length() <= 0) {
            return;
        }
        if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
            sb.append(RFC3966_EXTN_PREFIX);
            sb.append(phoneNumber.getExtension());
        } else if (phoneMetadata.hasPreferredExtnPrefix()) {
            sb.append(phoneMetadata.getPreferredExtnPrefix());
            sb.append(phoneNumber.getExtension());
        } else {
            sb.append(DEFAULT_EXTN_PREFIX);
            sb.append(phoneNumber.getExtension());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.michaelrocks.libphonenumber.android.PhoneNumberUtil$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat;
        static final /* synthetic */ int[] $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType;
        static final /* synthetic */ int[] $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource;

        static {
            int[] iArr = new int[PhoneNumberType.values().length];
            $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType = iArr;
            try {
                iArr[PhoneNumberType.PREMIUM_RATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.TOLL_FREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.MOBILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.FIXED_LINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.FIXED_LINE_OR_MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.SHARED_COST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.VOIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.PERSONAL_NUMBER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.PAGER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.UAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[PhoneNumberType.VOICEMAIL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr2 = new int[PhoneNumberFormat.values().length];
            $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat = iArr2;
            try {
                iArr2[PhoneNumberFormat.E164.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.INTERNATIONAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.RFC3966.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberFormat[PhoneNumberFormat.NATIONAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr3 = new int[Phonenumber.PhoneNumber.CountryCodeSource.values().length];
            $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource = iArr3;
            try {
                iArr3[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$io$michaelrocks$libphonenumber$android$Phonenumber$PhoneNumber$CountryCodeSource[Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    Phonemetadata.PhoneNumberDesc getNumberDescByType(Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberType phoneNumberType) {
        switch (AnonymousClass2.$SwitchMap$io$michaelrocks$libphonenumber$android$PhoneNumberUtil$PhoneNumberType[phoneNumberType.ordinal()]) {
            case 1:
                return phoneMetadata.getPremiumRate();
            case 2:
                return phoneMetadata.getTollFree();
            case 3:
                return phoneMetadata.getMobile();
            case 4:
            case 5:
                return phoneMetadata.getFixedLine();
            case 6:
                return phoneMetadata.getSharedCost();
            case 7:
                return phoneMetadata.getVoip();
            case 8:
                return phoneMetadata.getPersonalNumber();
            case 9:
                return phoneMetadata.getPager();
            case 10:
                return phoneMetadata.getUan();
            case 11:
                return phoneMetadata.getVoicemail();
            default:
                return phoneMetadata.getGeneralDesc();
        }
    }

    public PhoneNumberType getNumberType(Phonenumber.PhoneNumber phoneNumber) {
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(phoneNumber.getCountryCode(), getRegionCodeForNumber(phoneNumber));
        if (metadataForRegionOrCallingCode == null) {
            return PhoneNumberType.UNKNOWN;
        }
        return getNumberTypeHelper(getNationalSignificantNumber(phoneNumber), metadataForRegionOrCallingCode);
    }

    private PhoneNumberType getNumberTypeHelper(String str, Phonemetadata.PhoneMetadata phoneMetadata) {
        if (!isNumberMatchingDesc(str, phoneMetadata.getGeneralDesc())) {
            return PhoneNumberType.UNKNOWN;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getPremiumRate())) {
            return PhoneNumberType.PREMIUM_RATE;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getTollFree())) {
            return PhoneNumberType.TOLL_FREE;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getSharedCost())) {
            return PhoneNumberType.SHARED_COST;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getVoip())) {
            return PhoneNumberType.VOIP;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getPersonalNumber())) {
            return PhoneNumberType.PERSONAL_NUMBER;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getPager())) {
            return PhoneNumberType.PAGER;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getUan())) {
            return PhoneNumberType.UAN;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getVoicemail())) {
            return PhoneNumberType.VOICEMAIL;
        }
        if (isNumberMatchingDesc(str, phoneMetadata.getFixedLine())) {
            if (phoneMetadata.getSameMobileAndFixedLinePattern()) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            if (isNumberMatchingDesc(str, phoneMetadata.getMobile())) {
                return PhoneNumberType.FIXED_LINE_OR_MOBILE;
            }
            return PhoneNumberType.FIXED_LINE;
        } else if (!phoneMetadata.getSameMobileAndFixedLinePattern() && isNumberMatchingDesc(str, phoneMetadata.getMobile())) {
            return PhoneNumberType.MOBILE;
        } else {
            return PhoneNumberType.UNKNOWN;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Phonemetadata.PhoneMetadata getMetadataForRegion(String str) {
        if (isValidRegionCode(str)) {
            return this.metadataSource.getMetadataForRegion(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int i) {
        if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(i))) {
            return this.metadataSource.getMetadataForNonGeographicalRegion(i);
        }
        return null;
    }

    boolean isNumberMatchingDesc(String str, Phonemetadata.PhoneNumberDesc phoneNumberDesc) {
        int length = str.length();
        List<Integer> possibleLengthList = phoneNumberDesc.getPossibleLengthList();
        if (possibleLengthList.size() <= 0 || possibleLengthList.contains(Integer.valueOf(length))) {
            return this.matcherApi.matchNationalNumber(str, phoneNumberDesc, false);
        }
        return false;
    }

    public boolean isValidNumber(Phonenumber.PhoneNumber phoneNumber) {
        return isValidNumberForRegion(phoneNumber, getRegionCodeForNumber(phoneNumber));
    }

    public boolean isValidNumberForRegion(Phonenumber.PhoneNumber phoneNumber, String str) {
        int countryCode = phoneNumber.getCountryCode();
        Phonemetadata.PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(countryCode, str);
        if (metadataForRegionOrCallingCode != null) {
            return ("001".equals(str) || countryCode == getCountryCodeForValidRegion(str)) && getNumberTypeHelper(getNationalSignificantNumber(phoneNumber), metadataForRegionOrCallingCode) != PhoneNumberType.UNKNOWN;
        }
        return false;
    }

    public String getRegionCodeForNumber(Phonenumber.PhoneNumber phoneNumber) {
        int countryCode = phoneNumber.getCountryCode();
        List<String> list = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(countryCode));
        if (list == null) {
            Logger logger2 = logger;
            Level level = Level.INFO;
            StringBuilder sb = new StringBuilder();
            sb.append("Missing/invalid country_code (");
            sb.append(countryCode);
            sb.append(")");
            logger2.log(level, sb.toString());
            return null;
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return getRegionCodeForNumberFromRegionList(phoneNumber, list);
        }
    }

    private String getRegionCodeForNumberFromRegionList(Phonenumber.PhoneNumber phoneNumber, List<String> list) {
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        for (String str : list) {
            Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
            if (metadataForRegion.hasLeadingDigits()) {
                if (this.regexCache.getPatternForRegex(metadataForRegion.getLeadingDigits()).matcher(nationalSignificantNumber).lookingAt()) {
                    return str;
                }
            } else if (getNumberTypeHelper(nationalSignificantNumber, metadataForRegion) != PhoneNumberType.UNKNOWN) {
                return str;
            }
        }
        return null;
    }

    public String getRegionCodeForCountryCode(int i) {
        List<String> list = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i));
        return list == null ? UNKNOWN_REGION : list.get(0);
    }

    public List<String> getRegionCodesForCountryCode(int i) {
        List<String> list = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList<>(0);
        }
        return Collections.unmodifiableList(list);
    }

    public int getCountryCodeForRegion(String str) {
        if (!isValidRegionCode(str)) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid or missing region code (");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(") provided.");
            logger2.log(level, sb.toString());
            return 0;
        }
        return getCountryCodeForValidRegion(str);
    }

    private int getCountryCodeForValidRegion(String str) {
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        if (metadataForRegion == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid region code: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
        return metadataForRegion.getCountryCode();
    }

    public String getNddPrefixForRegion(String str, boolean z) {
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        if (metadataForRegion == null) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid or missing region code (");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(") provided.");
            logger2.log(level, sb.toString());
            return null;
        }
        String nationalPrefix = metadataForRegion.getNationalPrefix();
        if (nationalPrefix.length() == 0) {
            return null;
        }
        return z ? nationalPrefix.replace("~", "") : nationalPrefix;
    }

    public boolean isNANPACountry(String str) {
        return this.nanpaRegions.contains(str);
    }

    public boolean isAlphaNumber(CharSequence charSequence) {
        if (isViablePhoneNumber(charSequence)) {
            StringBuilder sb = new StringBuilder(charSequence);
            maybeStripExtension(sb);
            return VALID_ALPHA_PHONE_PATTERN.matcher(sb).matches();
        }
        return false;
    }

    public boolean isPossibleNumber(Phonenumber.PhoneNumber phoneNumber) {
        ValidationResult isPossibleNumberWithReason = isPossibleNumberWithReason(phoneNumber);
        return isPossibleNumberWithReason == ValidationResult.IS_POSSIBLE || isPossibleNumberWithReason == ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
    }

    public boolean isPossibleNumberForType(Phonenumber.PhoneNumber phoneNumber, PhoneNumberType phoneNumberType) {
        ValidationResult isPossibleNumberForTypeWithReason = isPossibleNumberForTypeWithReason(phoneNumber, phoneNumberType);
        return isPossibleNumberForTypeWithReason == ValidationResult.IS_POSSIBLE || isPossibleNumberForTypeWithReason == ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
    }

    private ValidationResult testNumberLength(CharSequence charSequence, Phonemetadata.PhoneMetadata phoneMetadata) {
        return testNumberLength(charSequence, phoneMetadata, PhoneNumberType.UNKNOWN);
    }

    private ValidationResult testNumberLength(CharSequence charSequence, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberType phoneNumberType) {
        ArrayList possibleLengthList;
        List<Integer> possibleLengthLocalOnlyList;
        List<Integer> possibleLengthList2;
        List<Integer> arrayList;
        while (true) {
            Phonemetadata.PhoneNumberDesc numberDescByType = getNumberDescByType(phoneMetadata, phoneNumberType);
            possibleLengthList = numberDescByType.getPossibleLengthList().isEmpty() ? phoneMetadata.getGeneralDesc().getPossibleLengthList() : numberDescByType.getPossibleLengthList();
            possibleLengthLocalOnlyList = numberDescByType.getPossibleLengthLocalOnlyList();
            if (phoneNumberType != PhoneNumberType.FIXED_LINE_OR_MOBILE) {
                break;
            } else if (!descHasPossibleNumberData(getNumberDescByType(phoneMetadata, PhoneNumberType.FIXED_LINE))) {
                phoneNumberType = PhoneNumberType.MOBILE;
            } else {
                Phonemetadata.PhoneNumberDesc numberDescByType2 = getNumberDescByType(phoneMetadata, PhoneNumberType.MOBILE);
                if (descHasPossibleNumberData(numberDescByType2)) {
                    ArrayList arrayList2 = new ArrayList(possibleLengthList);
                    if (numberDescByType2.getPossibleLengthList().size() == 0) {
                        possibleLengthList2 = phoneMetadata.getGeneralDesc().getPossibleLengthList();
                    } else {
                        possibleLengthList2 = numberDescByType2.getPossibleLengthList();
                    }
                    arrayList2.addAll(possibleLengthList2);
                    Collections.sort(arrayList2);
                    if (possibleLengthLocalOnlyList.isEmpty()) {
                        arrayList = numberDescByType2.getPossibleLengthLocalOnlyList();
                    } else {
                        arrayList = new ArrayList<>(possibleLengthLocalOnlyList);
                        arrayList.addAll(numberDescByType2.getPossibleLengthLocalOnlyList());
                        Collections.sort(arrayList);
                    }
                    possibleLengthLocalOnlyList = arrayList;
                    possibleLengthList = arrayList2;
                }
            }
        }
        if (possibleLengthList.get(0).intValue() == -1) {
            return ValidationResult.INVALID_LENGTH;
        }
        int length = charSequence.length();
        if (possibleLengthLocalOnlyList.contains(Integer.valueOf(length))) {
            return ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
        }
        int intValue = possibleLengthList.get(0).intValue();
        if (intValue == length) {
            return ValidationResult.IS_POSSIBLE;
        }
        if (intValue > length) {
            return ValidationResult.TOO_SHORT;
        }
        if (possibleLengthList.get(possibleLengthList.size() - 1).intValue() < length) {
            return ValidationResult.TOO_LONG;
        }
        return possibleLengthList.subList(1, possibleLengthList.size()).contains(Integer.valueOf(length)) ? ValidationResult.IS_POSSIBLE : ValidationResult.INVALID_LENGTH;
    }

    public ValidationResult isPossibleNumberWithReason(Phonenumber.PhoneNumber phoneNumber) {
        return isPossibleNumberForTypeWithReason(phoneNumber, PhoneNumberType.UNKNOWN);
    }

    public ValidationResult isPossibleNumberForTypeWithReason(Phonenumber.PhoneNumber phoneNumber, PhoneNumberType phoneNumberType) {
        String nationalSignificantNumber = getNationalSignificantNumber(phoneNumber);
        int countryCode = phoneNumber.getCountryCode();
        if (!hasValidCountryCallingCode(countryCode)) {
            return ValidationResult.INVALID_COUNTRY_CODE;
        }
        return testNumberLength(nationalSignificantNumber, getMetadataForRegionOrCallingCode(countryCode, getRegionCodeForCountryCode(countryCode)), phoneNumberType);
    }

    public boolean isPossibleNumber(CharSequence charSequence, String str) {
        try {
            return isPossibleNumber(parse(charSequence, str));
        } catch (NumberParseException unused) {
            return false;
        }
    }

    public boolean truncateTooLongNumber(Phonenumber.PhoneNumber phoneNumber) {
        if (isValidNumber(phoneNumber)) {
            return true;
        }
        Phonenumber.PhoneNumber phoneNumber2 = new Phonenumber.PhoneNumber();
        phoneNumber2.mergeFrom(phoneNumber);
        long nationalNumber = phoneNumber.getNationalNumber();
        do {
            nationalNumber /= 10;
            phoneNumber2.setNationalNumber(nationalNumber);
            if (isPossibleNumberWithReason(phoneNumber2) == ValidationResult.TOO_SHORT || nationalNumber == 0) {
                return false;
            }
        } while (!isValidNumber(phoneNumber2));
        phoneNumber.setNationalNumber(nationalNumber);
        return true;
    }

    public AsYouTypeFormatter getAsYouTypeFormatter(String str) {
        return new AsYouTypeFormatter(this, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int extractCountryCode(StringBuilder sb, StringBuilder sb2) {
        if (sb.length() != 0 && sb.charAt(0) != '0') {
            int length = sb.length();
            for (int i = 1; i <= 3 && i <= length; i++) {
                int parseInt = Integer.parseInt(sb.substring(0, i));
                if (this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(parseInt))) {
                    sb2.append(sb.substring(i));
                    return parseInt;
                }
            }
        }
        return 0;
    }

    int maybeExtractCountryCode(CharSequence charSequence, Phonemetadata.PhoneMetadata phoneMetadata, StringBuilder sb, boolean z, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        if (charSequence.length() == 0) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder(charSequence);
        Phonenumber.PhoneNumber.CountryCodeSource maybeStripInternationalPrefixAndNormalize = maybeStripInternationalPrefixAndNormalize(sb2, phoneMetadata != null ? phoneMetadata.getInternationalPrefix() : "NonMatch");
        if (z) {
            phoneNumber.setCountryCodeSource(maybeStripInternationalPrefixAndNormalize);
        }
        if (maybeStripInternationalPrefixAndNormalize != Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (sb2.length() <= 2) {
                throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
            }
            int extractCountryCode = extractCountryCode(sb2, sb);
            if (extractCountryCode != 0) {
                phoneNumber.setCountryCode(extractCountryCode);
                return extractCountryCode;
            }
            throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
        }
        if (phoneMetadata != null) {
            int countryCode = phoneMetadata.getCountryCode();
            String valueOf = String.valueOf(countryCode);
            String obj = sb2.toString();
            if (obj.startsWith(valueOf)) {
                StringBuilder sb3 = new StringBuilder(obj.substring(valueOf.length()));
                Phonemetadata.PhoneNumberDesc generalDesc = phoneMetadata.getGeneralDesc();
                maybeStripNationalPrefixAndCarrierCode(sb3, phoneMetadata, null);
                if ((!this.matcherApi.matchNationalNumber(sb2, generalDesc, false) && this.matcherApi.matchNationalNumber(sb3, generalDesc, false)) || testNumberLength(sb2, phoneMetadata) == ValidationResult.TOO_LONG) {
                    sb.append((CharSequence) sb3);
                    if (z) {
                        phoneNumber.setCountryCodeSource(Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                    }
                    phoneNumber.setCountryCode(countryCode);
                    return countryCode;
                }
            }
        }
        phoneNumber.setCountryCode(0);
        return 0;
    }

    private boolean parsePrefixAsIdd(Pattern pattern, StringBuilder sb) {
        Matcher matcher = pattern.matcher(sb);
        if (matcher.lookingAt()) {
            int end = matcher.end();
            Matcher matcher2 = CAPTURING_DIGIT_PATTERN.matcher(sb.substring(end));
            if (matcher2.find() && normalizeDigitsOnly(matcher2.group(1)).equals("0")) {
                return false;
            }
            sb.delete(0, end);
            return true;
        }
        return false;
    }

    Phonenumber.PhoneNumber.CountryCodeSource maybeStripInternationalPrefixAndNormalize(StringBuilder sb, String str) {
        if (sb.length() == 0) {
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
        }
        Matcher matcher = PLUS_CHARS_PATTERN.matcher(sb);
        if (matcher.lookingAt()) {
            sb.delete(0, matcher.end());
            normalize(sb);
            return Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
        }
        Pattern patternForRegex = this.regexCache.getPatternForRegex(str);
        normalize(sb);
        return parsePrefixAsIdd(patternForRegex, sb) ? Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD : Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean maybeStripNationalPrefixAndCarrierCode(StringBuilder sb, Phonemetadata.PhoneMetadata phoneMetadata, StringBuilder sb2) {
        int length = sb.length();
        String nationalPrefixForParsing = phoneMetadata.getNationalPrefixForParsing();
        if (length != 0 && nationalPrefixForParsing.length() != 0) {
            Matcher matcher = this.regexCache.getPatternForRegex(nationalPrefixForParsing).matcher(sb);
            if (matcher.lookingAt()) {
                Phonemetadata.PhoneNumberDesc generalDesc = phoneMetadata.getGeneralDesc();
                boolean matchNationalNumber = this.matcherApi.matchNationalNumber(sb, generalDesc, false);
                int groupCount = matcher.groupCount();
                String nationalPrefixTransformRule = phoneMetadata.getNationalPrefixTransformRule();
                if (nationalPrefixTransformRule == null || nationalPrefixTransformRule.length() == 0 || matcher.group(groupCount) == null) {
                    if (!matchNationalNumber || this.matcherApi.matchNationalNumber(sb.substring(matcher.end()), generalDesc, false)) {
                        if (sb2 != null && groupCount > 0 && matcher.group(groupCount) != null) {
                            sb2.append(matcher.group(1));
                        }
                        sb.delete(0, matcher.end());
                        return true;
                    }
                    return false;
                }
                StringBuilder sb3 = new StringBuilder(sb);
                sb3.replace(0, length, matcher.replaceFirst(nationalPrefixTransformRule));
                if (!matchNationalNumber || this.matcherApi.matchNationalNumber(sb3.toString(), generalDesc, false)) {
                    if (sb2 != null && groupCount > 1) {
                        sb2.append(matcher.group(1));
                    }
                    sb.replace(0, sb.length(), sb3.toString());
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    String maybeStripExtension(StringBuilder sb) {
        Matcher matcher = EXTN_PATTERN.matcher(sb);
        if (matcher.find() && isViablePhoneNumber(sb.substring(0, matcher.start()))) {
            int groupCount = matcher.groupCount();
            for (int i = 1; i <= groupCount; i++) {
                if (matcher.group(i) != null) {
                    String group = matcher.group(i);
                    sb.delete(matcher.start(), sb.length());
                    return group;
                }
            }
            return "";
        }
        return "";
    }

    private boolean checkRegionForParsing(CharSequence charSequence, String str) {
        if (isValidRegionCode(str)) {
            return true;
        }
        return (charSequence == null || charSequence.length() == 0 || !PLUS_CHARS_PATTERN.matcher(charSequence).lookingAt()) ? false : true;
    }

    public Phonenumber.PhoneNumber parse(CharSequence charSequence, String str) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
        parse(charSequence, str, phoneNumber);
        return phoneNumber;
    }

    public void parse(CharSequence charSequence, String str, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        parseHelper(charSequence, str, false, true, phoneNumber);
    }

    public Phonenumber.PhoneNumber parseAndKeepRawInput(CharSequence charSequence, String str) throws NumberParseException {
        Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
        parseAndKeepRawInput(charSequence, str, phoneNumber);
        return phoneNumber;
    }

    public void parseAndKeepRawInput(CharSequence charSequence, String str, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        parseHelper(charSequence, str, true, true, phoneNumber);
    }

    public Iterable<PhoneNumberMatch> findNumbers(CharSequence charSequence, String str) {
        return findNumbers(charSequence, str, Leniency.VALID, LongCompanionObject.MAX_VALUE);
    }

    public Iterable<PhoneNumberMatch> findNumbers(final CharSequence charSequence, final String str, final Leniency leniency, final long j) {
        return new Iterable<PhoneNumberMatch>() { // from class: io.michaelrocks.libphonenumber.android.PhoneNumberUtil.1
            @Override // java.lang.Iterable
            public Iterator<PhoneNumberMatch> iterator() {
                return new PhoneNumberMatcher(PhoneNumberUtil.this, charSequence, str, leniency, j);
            }
        };
    }

    static void setItalianLeadingZerosForPhoneNumber(CharSequence charSequence, Phonenumber.PhoneNumber phoneNumber) {
        if (charSequence.length() <= 1 || charSequence.charAt(0) != '0') {
            return;
        }
        phoneNumber.setItalianLeadingZero(true);
        int i = 1;
        while (i < charSequence.length() - 1 && charSequence.charAt(i) == '0') {
            i++;
        }
        if (i != 1) {
            phoneNumber.setNumberOfLeadingZeros(i);
        }
    }

    private void parseHelper(CharSequence charSequence, String str, boolean z, boolean z2, Phonenumber.PhoneNumber phoneNumber) throws NumberParseException {
        int maybeExtractCountryCode;
        if (charSequence == null) {
            throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
        }
        if (charSequence.length() > 250) {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        }
        StringBuilder sb = new StringBuilder();
        String charSequence2 = charSequence.toString();
        buildNationalNumberForParsing(charSequence2, sb);
        if (!isViablePhoneNumber(sb)) {
            throw new NumberParseException(NumberParseException.ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
        }
        if (z2 && !checkRegionForParsing(sb, str)) {
            throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
        }
        if (z) {
            phoneNumber.setRawInput(charSequence2);
        }
        String maybeStripExtension = maybeStripExtension(sb);
        if (maybeStripExtension.length() > 0) {
            phoneNumber.setExtension(maybeStripExtension);
        }
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        StringBuilder sb2 = new StringBuilder();
        try {
            maybeExtractCountryCode = maybeExtractCountryCode(sb, metadataForRegion, sb2, z, phoneNumber);
        } catch (NumberParseException e) {
            Matcher matcher = PLUS_CHARS_PATTERN.matcher(sb);
            if (e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE && matcher.lookingAt()) {
                maybeExtractCountryCode = maybeExtractCountryCode(sb.substring(matcher.end()), metadataForRegion, sb2, z, phoneNumber);
                if (maybeExtractCountryCode == 0) {
                    throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                }
            } else {
                throw new NumberParseException(e.getErrorType(), e.getMessage());
            }
        }
        if (maybeExtractCountryCode != 0) {
            String regionCodeForCountryCode = getRegionCodeForCountryCode(maybeExtractCountryCode);
            if (!regionCodeForCountryCode.equals(str)) {
                metadataForRegion = getMetadataForRegionOrCallingCode(maybeExtractCountryCode, regionCodeForCountryCode);
            }
        } else {
            sb2.append(normalize(sb));
            if (str != null) {
                phoneNumber.setCountryCode(metadataForRegion.getCountryCode());
            } else if (z) {
                phoneNumber.clearCountryCodeSource();
            }
        }
        if (sb2.length() < 2) {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        }
        if (metadataForRegion != null) {
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder(sb2);
            maybeStripNationalPrefixAndCarrierCode(sb4, metadataForRegion, sb3);
            ValidationResult testNumberLength = testNumberLength(sb4, metadataForRegion);
            if (testNumberLength != ValidationResult.TOO_SHORT && testNumberLength != ValidationResult.IS_POSSIBLE_LOCAL_ONLY && testNumberLength != ValidationResult.INVALID_LENGTH) {
                if (z && sb3.length() > 0) {
                    phoneNumber.setPreferredDomesticCarrierCode(sb3.toString());
                }
                sb2 = sb4;
            }
        }
        int length = sb2.length();
        if (length < 2) {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
        }
        if (length > 17) {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
        }
        setItalianLeadingZerosForPhoneNumber(sb2, phoneNumber);
        phoneNumber.setNationalNumber(Long.parseLong(sb2.toString()));
    }

    private void buildNationalNumberForParsing(String str, StringBuilder sb) {
        int indexOf = str.indexOf(RFC3966_PHONE_CONTEXT);
        if (indexOf >= 0) {
            int i = indexOf + 15;
            if (i < str.length() - 1 && str.charAt(i) == '+') {
                int indexOf2 = str.indexOf(59, i);
                if (indexOf2 > 0) {
                    sb.append(str.substring(i, indexOf2));
                } else {
                    sb.append(str.substring(i));
                }
            }
            int indexOf3 = str.indexOf(RFC3966_PREFIX);
            sb.append(str.substring(indexOf3 >= 0 ? indexOf3 + 4 : 0, indexOf));
        } else {
            sb.append(extractPossibleNumber(str));
        }
        int indexOf4 = sb.indexOf(RFC3966_ISDN_SUBADDRESS);
        if (indexOf4 > 0) {
            sb.delete(indexOf4, sb.length());
        }
    }

    private static Phonenumber.PhoneNumber copyCoreFieldsOnly(Phonenumber.PhoneNumber phoneNumber) {
        Phonenumber.PhoneNumber phoneNumber2 = new Phonenumber.PhoneNumber();
        phoneNumber2.setCountryCode(phoneNumber.getCountryCode());
        phoneNumber2.setNationalNumber(phoneNumber.getNationalNumber());
        if (phoneNumber.getExtension().length() > 0) {
            phoneNumber2.setExtension(phoneNumber.getExtension());
        }
        if (phoneNumber.isItalianLeadingZero()) {
            phoneNumber2.setItalianLeadingZero(true);
            phoneNumber2.setNumberOfLeadingZeros(phoneNumber.getNumberOfLeadingZeros());
        }
        return phoneNumber2;
    }

    public MatchType isNumberMatch(Phonenumber.PhoneNumber phoneNumber, Phonenumber.PhoneNumber phoneNumber2) {
        Phonenumber.PhoneNumber copyCoreFieldsOnly = copyCoreFieldsOnly(phoneNumber);
        Phonenumber.PhoneNumber copyCoreFieldsOnly2 = copyCoreFieldsOnly(phoneNumber2);
        if (copyCoreFieldsOnly.hasExtension() && copyCoreFieldsOnly2.hasExtension() && !copyCoreFieldsOnly.getExtension().equals(copyCoreFieldsOnly2.getExtension())) {
            return MatchType.NO_MATCH;
        }
        int countryCode = copyCoreFieldsOnly.getCountryCode();
        int countryCode2 = copyCoreFieldsOnly2.getCountryCode();
        if (countryCode != 0 && countryCode2 != 0) {
            if (copyCoreFieldsOnly.exactlySameAs(copyCoreFieldsOnly2)) {
                return MatchType.EXACT_MATCH;
            }
            if (countryCode == countryCode2 && isNationalNumberSuffixOfTheOther(copyCoreFieldsOnly, copyCoreFieldsOnly2)) {
                return MatchType.SHORT_NSN_MATCH;
            }
            return MatchType.NO_MATCH;
        }
        copyCoreFieldsOnly.setCountryCode(countryCode2);
        if (copyCoreFieldsOnly.exactlySameAs(copyCoreFieldsOnly2)) {
            return MatchType.NSN_MATCH;
        }
        if (isNationalNumberSuffixOfTheOther(copyCoreFieldsOnly, copyCoreFieldsOnly2)) {
            return MatchType.SHORT_NSN_MATCH;
        }
        return MatchType.NO_MATCH;
    }

    private boolean isNationalNumberSuffixOfTheOther(Phonenumber.PhoneNumber phoneNumber, Phonenumber.PhoneNumber phoneNumber2) {
        String valueOf = String.valueOf(phoneNumber.getNationalNumber());
        String valueOf2 = String.valueOf(phoneNumber2.getNationalNumber());
        return valueOf.endsWith(valueOf2) || valueOf2.endsWith(valueOf);
    }

    public MatchType isNumberMatch(CharSequence charSequence, CharSequence charSequence2) {
        try {
            return isNumberMatch(parse(charSequence, UNKNOWN_REGION), charSequence2);
        } catch (NumberParseException e) {
            if (e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
                try {
                    return isNumberMatch(parse(charSequence2, UNKNOWN_REGION), charSequence);
                } catch (NumberParseException e2) {
                    if (e2.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
                        try {
                            Phonenumber.PhoneNumber phoneNumber = new Phonenumber.PhoneNumber();
                            Phonenumber.PhoneNumber phoneNumber2 = new Phonenumber.PhoneNumber();
                            parseHelper(charSequence, null, false, false, phoneNumber);
                            parseHelper(charSequence2, null, false, false, phoneNumber2);
                            return isNumberMatch(phoneNumber, phoneNumber2);
                        } catch (NumberParseException unused) {
                            return MatchType.NOT_A_NUMBER;
                        }
                    }
                    return MatchType.NOT_A_NUMBER;
                }
            }
            return MatchType.NOT_A_NUMBER;
        }
    }

    public MatchType isNumberMatch(Phonenumber.PhoneNumber phoneNumber, CharSequence charSequence) {
        try {
            return isNumberMatch(phoneNumber, parse(charSequence, UNKNOWN_REGION));
        } catch (NumberParseException e) {
            if (e.getErrorType() == NumberParseException.ErrorType.INVALID_COUNTRY_CODE) {
                String regionCodeForCountryCode = getRegionCodeForCountryCode(phoneNumber.getCountryCode());
                try {
                    if (!regionCodeForCountryCode.equals(UNKNOWN_REGION)) {
                        MatchType isNumberMatch = isNumberMatch(phoneNumber, parse(charSequence, regionCodeForCountryCode));
                        return isNumberMatch == MatchType.EXACT_MATCH ? MatchType.NSN_MATCH : isNumberMatch;
                    }
                    Phonenumber.PhoneNumber phoneNumber2 = new Phonenumber.PhoneNumber();
                    parseHelper(charSequence, null, false, false, phoneNumber2);
                    return isNumberMatch(phoneNumber, phoneNumber2);
                } catch (NumberParseException unused) {
                    return MatchType.NOT_A_NUMBER;
                }
            }
            return MatchType.NOT_A_NUMBER;
        }
    }

    public boolean canBeInternationallyDialled(Phonenumber.PhoneNumber phoneNumber) {
        if (getMetadataForRegion(getRegionCodeForNumber(phoneNumber)) == null) {
            return true;
        }
        return !isNumberMatchingDesc(getNationalSignificantNumber(phoneNumber), r0.getNoInternationalDialling());
    }

    public boolean isMobileNumberPortableRegion(String str) {
        Phonemetadata.PhoneMetadata metadataForRegion = getMetadataForRegion(str);
        if (metadataForRegion == null) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid or unknown region code provided: ");
            sb.append(str);
            logger2.log(level, sb.toString());
            return false;
        }
        return metadataForRegion.isMobileNumberPortableRegion();
    }
}
