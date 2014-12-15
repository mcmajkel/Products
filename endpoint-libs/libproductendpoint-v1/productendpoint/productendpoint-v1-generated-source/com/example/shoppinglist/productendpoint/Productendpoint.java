/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2014-11-17 18:43:33 UTC)
 * on 2014-12-15 at 20:48:17 UTC 
 * Modify at your own risk.
 */

package com.example.shoppinglist.productendpoint;

/**
 * Service definition for Productendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link ProductendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Productendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the productendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://myapp.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "productendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Productendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Productendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getProduct".
   *
   * This request holds the parameters needed by the productendpoint server.  After setting any
   * optional parameters, call the {@link GetProduct#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetProduct getProduct(java.lang.Long id) throws java.io.IOException {
    GetProduct result = new GetProduct(id);
    initialize(result);
    return result;
  }

  public class GetProduct extends ProductendpointRequest<com.example.shoppinglist.productendpoint.model.Product> {

    private static final String REST_PATH = "product/{id}";

    /**
     * Create a request for the method "getProduct".
     *
     * This request holds the parameters needed by the the productendpoint server.  After setting any
     * optional parameters, call the {@link GetProduct#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetProduct#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetProduct(java.lang.Long id) {
      super(Productendpoint.this, "GET", REST_PATH, null, com.example.shoppinglist.productendpoint.model.Product.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetProduct setAlt(java.lang.String alt) {
      return (GetProduct) super.setAlt(alt);
    }

    @Override
    public GetProduct setFields(java.lang.String fields) {
      return (GetProduct) super.setFields(fields);
    }

    @Override
    public GetProduct setKey(java.lang.String key) {
      return (GetProduct) super.setKey(key);
    }

    @Override
    public GetProduct setOauthToken(java.lang.String oauthToken) {
      return (GetProduct) super.setOauthToken(oauthToken);
    }

    @Override
    public GetProduct setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetProduct) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetProduct setQuotaUser(java.lang.String quotaUser) {
      return (GetProduct) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetProduct setUserIp(java.lang.String userIp) {
      return (GetProduct) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetProduct setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetProduct set(String parameterName, Object value) {
      return (GetProduct) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertProduct".
   *
   * This request holds the parameters needed by the productendpoint server.  After setting any
   * optional parameters, call the {@link InsertProduct#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.example.shoppinglist.productendpoint.model.Product}
   * @return the request
   */
  public InsertProduct insertProduct(com.example.shoppinglist.productendpoint.model.Product content) throws java.io.IOException {
    InsertProduct result = new InsertProduct(content);
    initialize(result);
    return result;
  }

  public class InsertProduct extends ProductendpointRequest<com.example.shoppinglist.productendpoint.model.Product> {

    private static final String REST_PATH = "product";

    /**
     * Create a request for the method "insertProduct".
     *
     * This request holds the parameters needed by the the productendpoint server.  After setting any
     * optional parameters, call the {@link InsertProduct#execute()} method to invoke the remote
     * operation. <p> {@link InsertProduct#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.example.shoppinglist.productendpoint.model.Product}
     * @since 1.13
     */
    protected InsertProduct(com.example.shoppinglist.productendpoint.model.Product content) {
      super(Productendpoint.this, "POST", REST_PATH, content, com.example.shoppinglist.productendpoint.model.Product.class);
    }

    @Override
    public InsertProduct setAlt(java.lang.String alt) {
      return (InsertProduct) super.setAlt(alt);
    }

    @Override
    public InsertProduct setFields(java.lang.String fields) {
      return (InsertProduct) super.setFields(fields);
    }

    @Override
    public InsertProduct setKey(java.lang.String key) {
      return (InsertProduct) super.setKey(key);
    }

    @Override
    public InsertProduct setOauthToken(java.lang.String oauthToken) {
      return (InsertProduct) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertProduct setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertProduct) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertProduct setQuotaUser(java.lang.String quotaUser) {
      return (InsertProduct) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertProduct setUserIp(java.lang.String userIp) {
      return (InsertProduct) super.setUserIp(userIp);
    }

    @Override
    public InsertProduct set(String parameterName, Object value) {
      return (InsertProduct) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listProduct".
   *
   * This request holds the parameters needed by the productendpoint server.  After setting any
   * optional parameters, call the {@link ListProduct#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListProduct listProduct() throws java.io.IOException {
    ListProduct result = new ListProduct();
    initialize(result);
    return result;
  }

  public class ListProduct extends ProductendpointRequest<com.example.shoppinglist.productendpoint.model.CollectionResponseProduct> {

    private static final String REST_PATH = "product";

    /**
     * Create a request for the method "listProduct".
     *
     * This request holds the parameters needed by the the productendpoint server.  After setting any
     * optional parameters, call the {@link ListProduct#execute()} method to invoke the remote
     * operation. <p> {@link
     * ListProduct#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListProduct() {
      super(Productendpoint.this, "GET", REST_PATH, null, com.example.shoppinglist.productendpoint.model.CollectionResponseProduct.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListProduct setAlt(java.lang.String alt) {
      return (ListProduct) super.setAlt(alt);
    }

    @Override
    public ListProduct setFields(java.lang.String fields) {
      return (ListProduct) super.setFields(fields);
    }

    @Override
    public ListProduct setKey(java.lang.String key) {
      return (ListProduct) super.setKey(key);
    }

    @Override
    public ListProduct setOauthToken(java.lang.String oauthToken) {
      return (ListProduct) super.setOauthToken(oauthToken);
    }

    @Override
    public ListProduct setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListProduct) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListProduct setQuotaUser(java.lang.String quotaUser) {
      return (ListProduct) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListProduct setUserIp(java.lang.String userIp) {
      return (ListProduct) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListProduct setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Integer limit;

    /**

     */
    public java.lang.Integer getLimit() {
      return limit;
    }

    public ListProduct setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListProduct set(String parameterName, Object value) {
      return (ListProduct) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeProduct".
   *
   * This request holds the parameters needed by the productendpoint server.  After setting any
   * optional parameters, call the {@link RemoveProduct#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveProduct removeProduct(java.lang.Long id) throws java.io.IOException {
    RemoveProduct result = new RemoveProduct(id);
    initialize(result);
    return result;
  }

  public class RemoveProduct extends ProductendpointRequest<Void> {

    private static final String REST_PATH = "product/{id}";

    /**
     * Create a request for the method "removeProduct".
     *
     * This request holds the parameters needed by the the productendpoint server.  After setting any
     * optional parameters, call the {@link RemoveProduct#execute()} method to invoke the remote
     * operation. <p> {@link RemoveProduct#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveProduct(java.lang.Long id) {
      super(Productendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveProduct setAlt(java.lang.String alt) {
      return (RemoveProduct) super.setAlt(alt);
    }

    @Override
    public RemoveProduct setFields(java.lang.String fields) {
      return (RemoveProduct) super.setFields(fields);
    }

    @Override
    public RemoveProduct setKey(java.lang.String key) {
      return (RemoveProduct) super.setKey(key);
    }

    @Override
    public RemoveProduct setOauthToken(java.lang.String oauthToken) {
      return (RemoveProduct) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveProduct setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveProduct) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveProduct setQuotaUser(java.lang.String quotaUser) {
      return (RemoveProduct) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveProduct setUserIp(java.lang.String userIp) {
      return (RemoveProduct) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveProduct setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveProduct set(String parameterName, Object value) {
      return (RemoveProduct) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateProduct".
   *
   * This request holds the parameters needed by the productendpoint server.  After setting any
   * optional parameters, call the {@link UpdateProduct#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.example.shoppinglist.productendpoint.model.Product}
   * @return the request
   */
  public UpdateProduct updateProduct(com.example.shoppinglist.productendpoint.model.Product content) throws java.io.IOException {
    UpdateProduct result = new UpdateProduct(content);
    initialize(result);
    return result;
  }

  public class UpdateProduct extends ProductendpointRequest<com.example.shoppinglist.productendpoint.model.Product> {

    private static final String REST_PATH = "product";

    /**
     * Create a request for the method "updateProduct".
     *
     * This request holds the parameters needed by the the productendpoint server.  After setting any
     * optional parameters, call the {@link UpdateProduct#execute()} method to invoke the remote
     * operation. <p> {@link UpdateProduct#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.example.shoppinglist.productendpoint.model.Product}
     * @since 1.13
     */
    protected UpdateProduct(com.example.shoppinglist.productendpoint.model.Product content) {
      super(Productendpoint.this, "PUT", REST_PATH, content, com.example.shoppinglist.productendpoint.model.Product.class);
    }

    @Override
    public UpdateProduct setAlt(java.lang.String alt) {
      return (UpdateProduct) super.setAlt(alt);
    }

    @Override
    public UpdateProduct setFields(java.lang.String fields) {
      return (UpdateProduct) super.setFields(fields);
    }

    @Override
    public UpdateProduct setKey(java.lang.String key) {
      return (UpdateProduct) super.setKey(key);
    }

    @Override
    public UpdateProduct setOauthToken(java.lang.String oauthToken) {
      return (UpdateProduct) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateProduct setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateProduct) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateProduct setQuotaUser(java.lang.String quotaUser) {
      return (UpdateProduct) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateProduct setUserIp(java.lang.String userIp) {
      return (UpdateProduct) super.setUserIp(userIp);
    }

    @Override
    public UpdateProduct set(String parameterName, Object value) {
      return (UpdateProduct) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Productendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Productendpoint}. */
    @Override
    public Productendpoint build() {
      return new Productendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link ProductendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setProductendpointRequestInitializer(
        ProductendpointRequestInitializer productendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(productendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
