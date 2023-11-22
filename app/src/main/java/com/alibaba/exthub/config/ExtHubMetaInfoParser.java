package com.alibaba.exthub.config;

import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.ariver.kernel.api.extension.registry.NebulaConfigBase;
import com.alibaba.ariver.kernel.common.utils.StringUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/* loaded from: classes6.dex */
public class ExtHubMetaInfoParser {
    public static final String EXTHUB_METAINFO_XML = "exthub-metainfo.xml";
    public static final String KEY_EXTENSION_BUNDLE_NAME = "bundleName";
    public static final String KEY_EXTENSION_CLASS_NAME = "extensionClass";
    public static final String KEY_EXTENSION_FILTERSTRS = "filters";
    public static final String KEY_EXTENSION_INFO = "extension";
    public static final String KEY_EXTENSION_ISLAZY = "isLazy";
    public static final String KEY_EXTENSION_SCOPE_CLASS_NAME = "scope";
    public static final String KEY_EXTENSION_TYPE = "type";
    public static final String KEY_EXTHUB_METAINFO = "exthub-metainfo";
    public static final String META_INF_EXTHUB_METAINFO_MF = "META-INF/EXTHUB-METAINFO.MF";
    public static final String TAG = "ExtHubMetaInfoParser";

    /* renamed from: a  reason: collision with root package name */
    private int f6266a = -1;

    private List<NebulaConfigBase<?>> a(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                XMLReader createXMLReader = XMLReaderFactory.createXMLReader();
                PluginInfoContentHandler pluginInfoContentHandler = new PluginInfoContentHandler();
                createXMLReader.setContentHandler(pluginInfoContentHandler);
                createXMLReader.setErrorHandler(new PluginInfoErrorHandler());
                createXMLReader.parse(new InputSource(inputStream));
                return pluginInfoContentHandler.getList();
            } catch (SAXException e) {
                throw new IOException("Failed to parse xml.", e);
            }
        }
        return null;
    }

    public List<NebulaConfigBase<?>> readExtHubMetaInfo(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        List<NebulaConfigBase<?>> a2 = a(inputStream);
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                InstrumentInjector.log_e(TAG, e.getMessage());
            }
        }
        return a2;
    }

    public List<NebulaConfigBase<?>> readExtHubMetaInfo(File file) throws IOException {
        return readExtHubMetaInfo(new FileInputStream(file));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class PluginInfoContentHandler implements ContentHandler {
        StringBuilder buff;
        NebulaConfigBase<?> desc;
        List<NebulaConfigBase<?>> list;

        @Override // org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String str) throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
        }

        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) throws SAXException {
        }

        private PluginInfoContentHandler() {
        }

        public List<NebulaConfigBase<?>> getList() {
            return this.list;
        }

        @Override // org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if (ExtHubMetaInfoParser.KEY_EXTHUB_METAINFO.equals(str3)) {
                this.list = new ArrayList();
                this.buff = new StringBuilder();
            } else if (ExtHubMetaInfoParser.KEY_EXTENSION_INFO.equals(str3)) {
                try {
                    this.desc = new ExtensionMetaInfo((String) null, (String) null, (String) null, (String) null, "bridge", true);
                } catch (Throwable unused) {
                }
                this.list.add(this.desc);
            } else if ((this.desc instanceof ExtensionMetaInfo) && ExtHubMetaInfoParser.KEY_EXTENSION_BUNDLE_NAME.equals(str3)) {
                ExtHubMetaInfoParser.this.f6266a = 21;
            } else if ((this.desc instanceof ExtensionMetaInfo) && ExtHubMetaInfoParser.KEY_EXTENSION_CLASS_NAME.equals(str3)) {
                ExtHubMetaInfoParser.this.f6266a = 22;
            } else if ((this.desc instanceof ExtensionMetaInfo) && ExtHubMetaInfoParser.KEY_EXTENSION_FILTERSTRS.equals(str3)) {
                ExtHubMetaInfoParser.this.f6266a = 24;
            } else if ((this.desc instanceof ExtensionMetaInfo) && ExtHubMetaInfoParser.KEY_EXTENSION_SCOPE_CLASS_NAME.equals(str3)) {
                ExtHubMetaInfoParser.this.f6266a = 23;
            } else if ((this.desc instanceof ExtensionMetaInfo) && ExtHubMetaInfoParser.KEY_EXTENSION_ISLAZY.equals(str3)) {
                ExtHubMetaInfoParser.this.f6266a = 26;
            } else if ((this.desc instanceof ExtensionMetaInfo) && "type".equals(str3)) {
                ExtHubMetaInfoParser.this.f6266a = 25;
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            System.out.println(String.format("endElement(uri=%s, localName=%s, qName=%s)", str, str2, str3));
            ExtHubMetaInfoParser.this.f6266a = -1;
            if (this.buff.length() > 0) {
                StringBuilder sb = this.buff;
                sb.delete(0, sb.length());
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            String str = new String(cArr, i, i2);
            if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str.trim())) {
                return;
            }
            this.buff.append(cArr, i, i2);
            String trim = this.buff.toString().trim();
            switch (ExtHubMetaInfoParser.this.f6266a) {
                case 21:
                    ((ExtensionMetaInfo) this.desc).bundleName = trim;
                    return;
                case 22:
                    ((ExtensionMetaInfo) this.desc).extensionClass = trim;
                    return;
                case 23:
                    ((ExtensionMetaInfo) this.desc).scopeClassName = trim;
                    return;
                case 24:
                    ((ExtensionMetaInfo) this.desc).filterStrs = trim;
                    return;
                case 25:
                    ((ExtensionMetaInfo) this.desc).typeString = trim;
                    return;
                case 26:
                    ((ExtensionMetaInfo) this.desc).isLazy = Boolean.parseBoolean(trim);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class PluginInfoErrorHandler implements ErrorHandler {
        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) throws SAXException {
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) throws SAXException {
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) throws SAXException {
        }

        private PluginInfoErrorHandler() {
        }
    }
}
