package emobi.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Represents curl command and provides a way to serialize it through
 */
public class CurlCommand {

    private final List<Header> headers = new ArrayList<>();
    private final List<CurlCommand.FormPart> FormPart = new ArrayList<>();
    private final List<String> datas = new ArrayList<>();
    private final List<String> datasBinary = new ArrayList<>();
    private String url;
    private Optional<String> cookieHeader = Optional.empty();
    private boolean compressed;
    private boolean verbose;
    private boolean insecure;
    private Optional<String> method = Optional.empty();
    private Optional<ServerAuthentication> serverAuthentication = Optional.empty();

    /**
     * Set URL
     * @param url url
     * @return
     */
    public CurlCommand setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Add header
     *
     * @param key   key
     * @param value value
     * @return
     */
    public CurlCommand add(String key, String value) {
        headers.add(new Header(key, value));
        return this;
    }

    /**
     * remove header
     *
     * @param key key
     * @return
     */
    public CurlCommand removeHeader(String key) {
        headers.removeIf(header -> header.name.equals(key));
        return this;
    }

    /**
     * add FormPart
     *
     * @param key   key
     * @param value value
     * @return
     */
    public CurlCommand addFormPart(String key, String value) {
        FormPart.add(new FormPart(key, value));
        return this;
    }

    /**
     * Add data
     *
     * @param data
     * @return
     */
    public CurlCommand addData(String data) {
        datas.add(data);
        return this;
    }

    /**
     * Remove data
     *
     * @return
     */
    public CurlCommand removeData() {
        datas.clear();
        return this;
    }

    /**
     * Add data binary
     *
     * @param dataBinary data
     * @return
     */
    public CurlCommand addDataBinary(String dataBinary) {
        datasBinary.add(dataBinary);
        return this;
    }

    public CurlCommand setCookieHeader(String cookieHeader) {
        this.cookieHeader = Optional.of(cookieHeader);
        return this;
    }

    public CurlCommand setCompressed(boolean compressed) {
        this.compressed = compressed;
        return this;
    }

    public CurlCommand setVerbose(boolean verbose) {
        this.verbose = verbose;
        return this;
    }

    public CurlCommand setInsecure(boolean insecure) {
        this.insecure = insecure;
        return this;
    }

    public CurlCommand setMethod(String method) {
        this.method = Optional.of(method);
        return this;
    }

    public CurlCommand setServerAuthentication(String user, String password) {
        serverAuthentication = Optional.of(new ServerAuthentication(user, password));
        return this;
    }

    public static class Header {

        private final String name;
        private final String value;

        public Header(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }

    public static class FormPart {

        private final String name;
        private final String content;

        public FormPart(String name, String content) {
            this.name = name;
            this.content = content;
        }

        public String getName() {
            return name;
        }

        public String getContent() {
            return content;
        }
    }

    public static class ServerAuthentication {

        private final String user;
        private final String password;

        public ServerAuthentication(String user, String password) {
            this.user = user;
            this.password = password;
        }

        public String getPassword() {
            return password;
        }

        public String getUser() {
            return user;
        }

    }

}