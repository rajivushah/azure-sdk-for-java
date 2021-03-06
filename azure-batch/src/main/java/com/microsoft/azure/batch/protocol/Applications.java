/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol;

import com.microsoft.azure.batch.protocol.models.ApplicationGetHeaders;
import com.microsoft.azure.batch.protocol.models.ApplicationGetOptions;
import com.microsoft.azure.batch.protocol.models.ApplicationListHeaders;
import com.microsoft.azure.batch.protocol.models.ApplicationListNextOptions;
import com.microsoft.azure.batch.protocol.models.ApplicationListOptions;
import com.microsoft.azure.batch.protocol.models.ApplicationSummary;
import com.microsoft.azure.batch.protocol.models.BatchErrorException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceCall;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceResponseWithHeaders;
import java.io.IOException;
import java.util.List;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Applications.
 */
public interface Applications {
    /**
     * Lists all of the applications available in the specified account.
     *
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;ApplicationSummary&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PagedList<ApplicationSummary>, ApplicationListHeaders> list() throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    ServiceCall<List<ApplicationSummary>> listAsync(final ListOperationCallback<ApplicationSummary> serviceCallback);
    /**
     * Lists all of the applications available in the specified account.
     *
     * @param applicationListOptions Additional parameters for the operation
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;ApplicationSummary&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PagedList<ApplicationSummary>, ApplicationListHeaders> list(final ApplicationListOptions applicationListOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param applicationListOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    ServiceCall<List<ApplicationSummary>> listAsync(final ApplicationListOptions applicationListOptions, final ListOperationCallback<ApplicationSummary> serviceCallback);

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param applicationListOptions Additional parameters for the operation
     * @return the observable to the List&lt;ApplicationSummary&gt; object
     */
    Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> listAsync(final ApplicationListOptions applicationListOptions);

    /**
     * Gets information about the specified application.
     *
     * @param applicationId The id of the application.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the ApplicationSummary object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<ApplicationSummary, ApplicationGetHeaders> get(String applicationId) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Gets information about the specified application.
     *
     * @param applicationId The id of the application.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    ServiceCall<ApplicationSummary> getAsync(String applicationId, final ServiceCallback<ApplicationSummary> serviceCallback);
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
    ServiceResponseWithHeaders<ApplicationSummary, ApplicationGetHeaders> get(String applicationId, ApplicationGetOptions applicationGetOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Gets information about the specified application.
     *
     * @param applicationId The id of the application.
     * @param applicationGetOptions Additional parameters for the operation
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    ServiceCall<ApplicationSummary> getAsync(String applicationId, ApplicationGetOptions applicationGetOptions, final ServiceCallback<ApplicationSummary> serviceCallback);

    /**
     * Gets information about the specified application.
     *
     * @param applicationId The id of the application.
     * @param applicationGetOptions Additional parameters for the operation
     * @return the observable to the ApplicationSummary object
     */
    Observable<ServiceResponseWithHeaders<ApplicationSummary, ApplicationGetHeaders>> getAsync(String applicationId, ApplicationGetOptions applicationGetOptions);

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws BatchErrorException exception thrown from REST call
     * @throws IOException exception thrown from serialization/deserialization
     * @throws IllegalArgumentException exception thrown from invalid parameters
     * @return the List&lt;ApplicationSummary&gt; object wrapped in {@link ServiceResponseWithHeaders} if successful.
     */
    ServiceResponseWithHeaders<PagedList<ApplicationSummary>, ApplicationListHeaders> listNext(final String nextPageLink) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    ServiceCall<List<ApplicationSummary>> listNextAsync(final String nextPageLink, final ServiceCall<List<ApplicationSummary>> serviceCall, final ListOperationCallback<ApplicationSummary> serviceCallback);
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
    ServiceResponseWithHeaders<PagedList<ApplicationSummary>, ApplicationListHeaders> listNext(final String nextPageLink, final ApplicationListNextOptions applicationListNextOptions) throws BatchErrorException, IOException, IllegalArgumentException;

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param applicationListNextOptions Additional parameters for the operation
     * @param serviceCall the ServiceCall object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceCall} object
     */
    ServiceCall<List<ApplicationSummary>> listNextAsync(final String nextPageLink, final ApplicationListNextOptions applicationListNextOptions, final ServiceCall<List<ApplicationSummary>> serviceCall, final ListOperationCallback<ApplicationSummary> serviceCallback);

    /**
     * Lists all of the applications available in the specified account.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param applicationListNextOptions Additional parameters for the operation
     * @return the observable to the List&lt;ApplicationSummary&gt; object
     */
    Observable<ServiceResponseWithHeaders<Page<ApplicationSummary>, ApplicationListHeaders>> listNextAsync(final String nextPageLink, final ApplicationListNextOptions applicationListNextOptions);

}
