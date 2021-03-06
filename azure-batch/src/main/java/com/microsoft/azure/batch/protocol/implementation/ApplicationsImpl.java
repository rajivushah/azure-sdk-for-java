/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.implementation;

import retrofit2.Retrofit;
import com.microsoft.azure.batch.protocol.Applications;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceCall;
import com.microsoft.azure.AzureServiceResponseBuilder;
import com.microsoft.azure.batch.protocol.models.ApplicationGetHeaders;
import com.microsoft.azure.batch.protocol.models.ApplicationGetOptions;
import com.microsoft.azure.batch.protocol.models.ApplicationListHeaders;
import com.microsoft.azure.batch.protocol.models.ApplicationListNextOptions;
import com.microsoft.azure.batch.protocol.models.ApplicationListOptions;
import com.microsoft.azure.batch.protocol.models.ApplicationSummary;
import com.microsoft.azure.batch.protocol.models.BatchErrorException;
import com.microsoft.azure.batch.protocol.models.PageImpl;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.DateTimeRfc1123;
import com.microsoft.rest.RestException;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponseWithHeaders;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import org.joda.time.DateTime;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Applications.
 */
public final class ApplicationsImpl implements Applications {
    /** The Retrofit service to perform REST calls. */
    private ApplicationsService service;
    /** The service client containing this operation class. */
    private BatchServiceClientImpl client;

    /**
     * Initializes an instance of ApplicationsImpl.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ApplicationsImpl(Retrofit retrofit, BatchServiceClientImpl client) {
        this.service = retrofit.create(ApplicationsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Applications to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ApplicationsService {
        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @GET("applications")
        Observable<Response<ResponseBody>> list(@Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("maxresults") Integer maxResults, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @GET("applications/{applicationId}")
        Observable<Response<ResponseBody>> get(@Path("applicationId") String applicationId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Query("timeout") Integer timeout, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Header("User-Agent") String userAgent);

        @Headers("Content-Type: application/json; odata=minimalmetadata; charset=utf-8")
        @GET("{nextLink}")
        Observable<Response<ResponseBody>> listNext(@Path(value = "nextLink", encoded = true) String nextPageLink, @Header("accept-language") String acceptLanguage, @Header("client-request-id") String clientRequestId, @Header("return-client-request-id") Boolean returnClientRequestId, @Header("ocp-date") DateTimeRfc1123 ocpDate, @Header("User-Agent") String userAgent);

    }

    /**
     * Lists all of the applications available in the specified account.
     *
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;ApplicationSummary&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<PagedList<ApplicationSummary>, ApplicationListHeaders> list() throws BatchErrorException, IOException, IllegalArgumentException {
        ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders> response = listSinglePageAsync().toBlocking().single();
        PagedList<ApplicationSummary> pagedList = new PagedList<ApplicationSummary>(response.getBody()) {
            @Override
            public Page<ApplicationSummary> nextPage(String nextPageLink) throws RestException, IOException {
                return listNextSinglePageAsync(nextPageLink, null).toBlocking().single().getBody();
            }
        };
        return new ServiceResponseWithHeaders<PagedList<ApplicationSummary>, ApplicationListHeaders>(pagedList, response.getHeaders(), response.getResponse());
    }

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<List<ApplicationSummary>> listAsync(final ListOperationCallback<ApplicationSummary> serviceCallback) {
        return AzureServiceCall.createWithHeaders(
            listSinglePageAsync(),
            new Func1<String, Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink, null);
                }
            },
            serviceCallback);
    }

    /**
     * Lists all of the applications available in the specified account.
     *
     * @return the observable to the List&lt;ApplicationSummary&gt; object
     */
    public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> listAsync() {
        return listSinglePageAsync()
            .concatMap(new Func1<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>, Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> call(ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    return listNextSinglePageAsync(nextPageLink, null);
                }
            });
    }

    /**
     * Lists all of the applications available in the specified account.
     *
     * @return the List&lt;ApplicationSummary&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> listSinglePageAsync() {
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        final ApplicationListOptions applicationListOptions = null;
        Integer maxResults = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTime ocpDate = null;
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        return service.list(this.client.apiVersion(), this.client.acceptLanguage(), maxResults, timeout, clientRequestId, returnClientRequestId, ocpDateConverted, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponseWithHeaders<PageImpl<ApplicationSummary>, ApplicationListHeaders> result = listDelegate(response);
                        return Observable.just(new ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>(result.getBody(), result.getHeaders(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param applicationListOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;ApplicationSummary&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<PagedList<ApplicationSummary>, ApplicationListHeaders> list(final ApplicationListOptions applicationListOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders> response = listSinglePageAsync(applicationListOptions).toBlocking().single();
        PagedList<ApplicationSummary> pagedList = new PagedList<ApplicationSummary>(response.getBody()) {
            @Override
            public Page<ApplicationSummary> nextPage(String nextPageLink) throws RestException, IOException {
                ApplicationListNextOptions applicationListNextOptions = null;
                if (applicationListOptions != null) {
                    applicationListNextOptions = new ApplicationListNextOptions();
                    applicationListNextOptions.withClientRequestId(applicationListOptions.clientRequestId());
                    applicationListNextOptions.withReturnClientRequestId(applicationListOptions.returnClientRequestId());
                    applicationListNextOptions.withOcpDate(applicationListOptions.ocpDate());
                }
                return listNextSinglePageAsync(nextPageLink, applicationListNextOptions).toBlocking().single().getBody();
            }
        };
        return new ServiceResponseWithHeaders<PagedList<ApplicationSummary>, ApplicationListHeaders>(pagedList, response.getHeaders(), response.getResponse());
    }

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param applicationListOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<List<ApplicationSummary>> listAsync(final ApplicationListOptions applicationListOptions, final ListOperationCallback<ApplicationSummary> serviceCallback) {
        return AzureServiceCall.createWithHeaders(
            listSinglePageAsync(applicationListOptions),
            new Func1<String, Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> call(String nextPageLink) {
                    ApplicationListNextOptions applicationListNextOptions = null;
                    if (applicationListOptions != null) {
                        applicationListNextOptions = new ApplicationListNextOptions();
                        applicationListNextOptions.withClientRequestId(applicationListOptions.clientRequestId());
                        applicationListNextOptions.withReturnClientRequestId(applicationListOptions.returnClientRequestId());
                        applicationListNextOptions.withOcpDate(applicationListOptions.ocpDate());
                    }
                    return listNextSinglePageAsync(nextPageLink, applicationListNextOptions);
                }
            },
            serviceCallback);
    }

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param applicationListOptions Additional parameters for the operation
     * @return the observable to the List&lt;ApplicationSummary&gt; object
     */
    public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> listAsync(final ApplicationListOptions applicationListOptions) {
        return listSinglePageAsync(applicationListOptions)
            .concatMap(new Func1<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>, Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> call(ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    ApplicationListNextOptions applicationListNextOptions = null;
                    if (applicationListOptions != null) {
                        applicationListNextOptions = new ApplicationListNextOptions();
                        applicationListNextOptions.withClientRequestId(applicationListOptions.clientRequestId());
                        applicationListNextOptions.withReturnClientRequestId(applicationListOptions.returnClientRequestId());
                        applicationListNextOptions.withOcpDate(applicationListOptions.ocpDate());
                    }
                    return listNextSinglePageAsync(nextPageLink, applicationListNextOptions);
                }
            });
    }

    /**
     * Lists all of the applications available in the specified account.
     *
    ServiceResponseWithHeaders<PageImpl<ApplicationSummary>, ApplicationListHeaders> * @param applicationListOptions Additional parameters for the operation
     * @return the List&lt;ApplicationSummary&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> listSinglePageAsync(final ApplicationListOptions applicationListOptions) {
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Validator.validate(applicationListOptions);
        Integer maxResults = null;
        if (applicationListOptions != null) {
            maxResults = applicationListOptions.maxResults();
        }
        Integer timeout = null;
        if (applicationListOptions != null) {
            timeout = applicationListOptions.timeout();
        }
        String clientRequestId = null;
        if (applicationListOptions != null) {
            clientRequestId = applicationListOptions.clientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (applicationListOptions != null) {
            returnClientRequestId = applicationListOptions.returnClientRequestId();
        }
        DateTime ocpDate = null;
        if (applicationListOptions != null) {
            ocpDate = applicationListOptions.ocpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        return service.list(this.client.apiVersion(), this.client.acceptLanguage(), maxResults, timeout, clientRequestId, returnClientRequestId, ocpDateConverted, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponseWithHeaders<PageImpl<ApplicationSummary>, ApplicationListHeaders> result = listDelegate(response);
                        return Observable.just(new ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>(result.getBody(), result.getHeaders(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponseWithHeaders<PageImpl<ApplicationSummary>, ApplicationListHeaders> listDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<ApplicationSummary>, BatchErrorException>(this.client.mapperAdapter())
                .register(200, new TypeToken<PageImpl<ApplicationSummary>>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, ApplicationListHeaders.class);
    }

    /**
     * Gets information about the specified application.
     *
     * @param applicationId The id of the application.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the ApplicationSummary object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<ApplicationSummary, ApplicationGetHeaders> get(String applicationId) throws BatchErrorException, IOException, IllegalArgumentException {
        return getAsync(applicationId).toBlocking().single();
    }

    /**
     * Gets information about the specified application.
     *
     * @param applicationId The id of the application.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<ApplicationSummary> getAsync(String applicationId, final ServiceCallback<ApplicationSummary> serviceCallback) {
        return ServiceCall.createWithHeaders(getAsync(applicationId), serviceCallback);
    }

    /**
     * Gets information about the specified application.
     *
     * @param applicationId The id of the application.
     * @return the observable to the ApplicationSummary object
     */
    public Observable<ServiceResponseWithHeaders<ApplicationSummary, ApplicationGetHeaders>> getAsync(String applicationId) {
        if (applicationId == null) {
            throw new IllegalArgumentException("Parameter applicationId is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        final ApplicationGetOptions applicationGetOptions = null;
        Integer timeout = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTime ocpDate = null;
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        return service.get(applicationId, this.client.apiVersion(), this.client.acceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponseWithHeaders<ApplicationSummary, ApplicationGetHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<ApplicationSummary, ApplicationGetHeaders>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponseWithHeaders<ApplicationSummary, ApplicationGetHeaders> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * Gets information about the specified application.
     *
     * @param applicationId The id of the application.
     * @param applicationGetOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the ApplicationSummary object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<ApplicationSummary, ApplicationGetHeaders> get(String applicationId, ApplicationGetOptions applicationGetOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        return getAsync(applicationId, applicationGetOptions).toBlocking().single();
    }

    /**
     * Gets information about the specified application.
     *
     * @param applicationId The id of the application.
     * @param applicationGetOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<ApplicationSummary> getAsync(String applicationId, ApplicationGetOptions applicationGetOptions, final ServiceCallback<ApplicationSummary> serviceCallback) {
        return ServiceCall.createWithHeaders(getAsync(applicationId, applicationGetOptions), serviceCallback);
    }

    /**
     * Gets information about the specified application.
     *
     * @param applicationId The id of the application.
     * @param applicationGetOptions Additional parameters for the operation
     * @return the observable to the ApplicationSummary object
     */
    public Observable<ServiceResponseWithHeaders<ApplicationSummary, ApplicationGetHeaders>> getAsync(String applicationId, ApplicationGetOptions applicationGetOptions) {
        if (applicationId == null) {
            throw new IllegalArgumentException("Parameter applicationId is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Validator.validate(applicationGetOptions);
        Integer timeout = null;
        if (applicationGetOptions != null) {
            timeout = applicationGetOptions.timeout();
        }
        String clientRequestId = null;
        if (applicationGetOptions != null) {
            clientRequestId = applicationGetOptions.clientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (applicationGetOptions != null) {
            returnClientRequestId = applicationGetOptions.returnClientRequestId();
        }
        DateTime ocpDate = null;
        if (applicationGetOptions != null) {
            ocpDate = applicationGetOptions.ocpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        return service.get(applicationId, this.client.apiVersion(), this.client.acceptLanguage(), timeout, clientRequestId, returnClientRequestId, ocpDateConverted, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponseWithHeaders<ApplicationSummary, ApplicationGetHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<ApplicationSummary, ApplicationGetHeaders>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponseWithHeaders<ApplicationSummary, ApplicationGetHeaders> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponseWithHeaders<ApplicationSummary, ApplicationGetHeaders> getDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<ApplicationSummary, BatchErrorException>(this.client.mapperAdapter())
                .register(200, new TypeToken<ApplicationSummary>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, ApplicationGetHeaders.class);
    }

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;ApplicationSummary&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<PagedList<ApplicationSummary>, ApplicationListHeaders> listNext(final String nextPageLink) throws BatchErrorException, IOException, IllegalArgumentException {
        ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders> response = listNextSinglePageAsync(nextPageLink).toBlocking().single();
        PagedList<ApplicationSummary> pagedList = new PagedList<ApplicationSummary>(response.getBody()) {
            @Override
            public Page<ApplicationSummary> nextPage(String nextPageLink) throws RestException, IOException {
                return listNextSinglePageAsync(nextPageLink, null).toBlocking().single().getBody();
            }
        };
        return new ServiceResponseWithHeaders<PagedList<ApplicationSummary>, ApplicationListHeaders>(pagedList, response.getHeaders(), response.getResponse());
    }

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<List<ApplicationSummary>> listNextAsync(final String nextPageLink, final ServiceCall<List<ApplicationSummary>> serviceCall, final ListOperationCallback<ApplicationSummary> serviceCallback) {
        return AzureServiceCall.createWithHeaders(
            listNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink, null);
                }
            },
            serviceCallback);
    }

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the observable to the List&lt;ApplicationSummary&gt; object
     */
    public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> listNextAsync(final String nextPageLink) {
        return listNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>, Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> call(ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    return listNextSinglePageAsync(nextPageLink, null);
                }
            });
    }

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @return the List&lt;ApplicationSummary&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> listNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        final ApplicationListNextOptions applicationListNextOptions = null;
        String clientRequestId = null;
        Boolean returnClientRequestId = null;
        DateTime ocpDate = null;
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        return service.listNext(nextPageLink, this.client.acceptLanguage(), clientRequestId, returnClientRequestId, ocpDateConverted, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponseWithHeaders<PageImpl<ApplicationSummary>, ApplicationListHeaders> result = listNextDelegate(response);
                        return Observable.just(new ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>(result.getBody(), result.getHeaders(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param applicationListNextOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;ApplicationSummary&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public ServiceResponseWithHeaders<PagedList<ApplicationSummary>, ApplicationListHeaders> listNext(final String nextPageLink, final ApplicationListNextOptions applicationListNextOptions) throws BatchErrorException, IOException, IllegalArgumentException {
        ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders> response = listNextSinglePageAsync(nextPageLink, applicationListNextOptions).toBlocking().single();
        PagedList<ApplicationSummary> pagedList = new PagedList<ApplicationSummary>(response.getBody()) {
            @Override
            public Page<ApplicationSummary> nextPage(String nextPageLink) throws RestException, IOException {
                return listNextSinglePageAsync(nextPageLink, applicationListNextOptions).toBlocking().single().getBody();
            }
        };
        return new ServiceResponseWithHeaders<PagedList<ApplicationSummary>, ApplicationListHeaders>(pagedList, response.getHeaders(), response.getResponse());
    }

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param applicationListNextOptions Additional parameters for the operation
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    public ServiceCall<List<ApplicationSummary>> listNextAsync(final String nextPageLink, final ApplicationListNextOptions applicationListNextOptions, final ServiceCall<List<ApplicationSummary>> serviceCall, final ListOperationCallback<ApplicationSummary> serviceCallback) {
        return AzureServiceCall.createWithHeaders(
            listNextSinglePageAsync(nextPageLink, applicationListNextOptions),
            new Func1<String, Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink, applicationListNextOptions);
                }
            },
            serviceCallback);
    }

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param applicationListNextOptions Additional parameters for the operation
     * @return the observable to the List&lt;ApplicationSummary&gt; object
     */
    public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> listNextAsync(final String nextPageLink, final ApplicationListNextOptions applicationListNextOptions) {
        return listNextSinglePageAsync(nextPageLink, applicationListNextOptions)
            .concatMap(new Func1<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>, Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> call(ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders> page) {
                    String nextPageLink = page.getBody().getNextPageLink();
                    return listNextSinglePageAsync(nextPageLink, applicationListNextOptions);
                }
            });
    }

    /**
     * Lists all of the applications available in the specified account.
     *
    ServiceResponseWithHeaders<PageImpl<ApplicationSummary>, ApplicationListHeaders> * @param nextPageLink The NextLink from the previous successful call to List operation.
    ServiceResponseWithHeaders<PageImpl<ApplicationSummary>, ApplicationListHeaders> * @param applicationListNextOptions Additional parameters for the operation
     * @return the List&lt;ApplicationSummary&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> listNextSinglePageAsync(final String nextPageLink, final ApplicationListNextOptions applicationListNextOptions) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        Validator.validate(applicationListNextOptions);
        String clientRequestId = null;
        if (applicationListNextOptions != null) {
            clientRequestId = applicationListNextOptions.clientRequestId();
        }
        Boolean returnClientRequestId = null;
        if (applicationListNextOptions != null) {
            returnClientRequestId = applicationListNextOptions.returnClientRequestId();
        }
        DateTime ocpDate = null;
        if (applicationListNextOptions != null) {
            ocpDate = applicationListNextOptions.ocpDate();
        }
        DateTimeRfc1123 ocpDateConverted = null;
        if (ocpDate != null) {
            ocpDateConverted = new DateTimeRfc1123(ocpDate);
        }
        return service.listNext(nextPageLink, this.client.acceptLanguage(), clientRequestId, returnClientRequestId, ocpDateConverted, this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>>>() {
                @Override
                public Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponseWithHeaders<PageImpl<ApplicationSummary>, ApplicationListHeaders> result = listNextDelegate(response);
                        return Observable.just(new ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>(result.getBody(), result.getHeaders(), result.getResponse()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponseWithHeaders<PageImpl<ApplicationSummary>, ApplicationListHeaders> listNextDelegate(Response<ResponseBody> response) throws BatchErrorException, IOException, IllegalArgumentException {
        return new AzureServiceResponseBuilder<PageImpl<ApplicationSummary>, BatchErrorException>(this.client.mapperAdapter())
                .register(200, new TypeToken<PageImpl<ApplicationSummary>>() { }.getType())
                .registerError(BatchErrorException.class)
                .buildWithHeaders(response, ApplicationListHeaders.class);
    }

}
