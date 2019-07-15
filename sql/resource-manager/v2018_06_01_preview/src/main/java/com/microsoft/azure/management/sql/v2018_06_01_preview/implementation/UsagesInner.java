/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.v2018_06_01_preview.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceFuture;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Usages.
 */
public class UsagesInner {
    /** The Retrofit service to perform REST calls. */
    private UsagesService service;
    /** The service client containing this operation class. */
    private SqlManagementClientImpl client;

    /**
     * Initializes an instance of UsagesInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public UsagesInner(Retrofit retrofit, SqlManagementClientImpl client) {
        this.service = retrofit.create(UsagesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Usages to be
     * used by Retrofit to perform actually REST calls.
     */
    interface UsagesService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.sql.v2018_06_01_preview.Usages listByInstancePool" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.Sql/instancePools/{instancePoolName}/usages")
        Observable<Response<ResponseBody>> listByInstancePool(@Path("resourceGroupName") String resourceGroupName, @Path("instancePoolName") String instancePoolName, @Path("subscriptionId") String subscriptionId, @Query("expandChildren") Boolean expandChildren, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.sql.v2018_06_01_preview.Usages listByInstancePoolNext" })
        @GET
        Observable<Response<ResponseBody>> listByInstancePoolNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Gets all instance pool usage metrics.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param instancePoolName The name of the instance pool to be retrieved.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;UsageInner&gt; object if successful.
     */
    public PagedList<UsageInner> listByInstancePool(final String resourceGroupName, final String instancePoolName) {
        ServiceResponse<Page<UsageInner>> response = listByInstancePoolSinglePageAsync(resourceGroupName, instancePoolName).toBlocking().single();
        return new PagedList<UsageInner>(response.body()) {
            @Override
            public Page<UsageInner> nextPage(String nextPageLink) {
                return listByInstancePoolNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets all instance pool usage metrics.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param instancePoolName The name of the instance pool to be retrieved.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<UsageInner>> listByInstancePoolAsync(final String resourceGroupName, final String instancePoolName, final ListOperationCallback<UsageInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listByInstancePoolSinglePageAsync(resourceGroupName, instancePoolName),
            new Func1<String, Observable<ServiceResponse<Page<UsageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<UsageInner>>> call(String nextPageLink) {
                    return listByInstancePoolNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets all instance pool usage metrics.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param instancePoolName The name of the instance pool to be retrieved.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;UsageInner&gt; object
     */
    public Observable<Page<UsageInner>> listByInstancePoolAsync(final String resourceGroupName, final String instancePoolName) {
        return listByInstancePoolWithServiceResponseAsync(resourceGroupName, instancePoolName)
            .map(new Func1<ServiceResponse<Page<UsageInner>>, Page<UsageInner>>() {
                @Override
                public Page<UsageInner> call(ServiceResponse<Page<UsageInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets all instance pool usage metrics.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param instancePoolName The name of the instance pool to be retrieved.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;UsageInner&gt; object
     */
    public Observable<ServiceResponse<Page<UsageInner>>> listByInstancePoolWithServiceResponseAsync(final String resourceGroupName, final String instancePoolName) {
        return listByInstancePoolSinglePageAsync(resourceGroupName, instancePoolName)
            .concatMap(new Func1<ServiceResponse<Page<UsageInner>>, Observable<ServiceResponse<Page<UsageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<UsageInner>>> call(ServiceResponse<Page<UsageInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listByInstancePoolNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all instance pool usage metrics.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param instancePoolName The name of the instance pool to be retrieved.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;UsageInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<UsageInner>>> listByInstancePoolSinglePageAsync(final String resourceGroupName, final String instancePoolName) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (instancePoolName == null) {
            throw new IllegalArgumentException("Parameter instancePoolName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        final Boolean expandChildren = null;
        return service.listByInstancePool(resourceGroupName, instancePoolName, this.client.subscriptionId(), expandChildren, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<UsageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<UsageInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<UsageInner>> result = listByInstancePoolDelegate(response);
                        return Observable.just(new ServiceResponse<Page<UsageInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * Gets all instance pool usage metrics.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param instancePoolName The name of the instance pool to be retrieved.
     * @param expandChildren Optional request parameter to include managed instance usages within the instance pool.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;UsageInner&gt; object if successful.
     */
    public PagedList<UsageInner> listByInstancePool(final String resourceGroupName, final String instancePoolName, final Boolean expandChildren) {
        ServiceResponse<Page<UsageInner>> response = listByInstancePoolSinglePageAsync(resourceGroupName, instancePoolName, expandChildren).toBlocking().single();
        return new PagedList<UsageInner>(response.body()) {
            @Override
            public Page<UsageInner> nextPage(String nextPageLink) {
                return listByInstancePoolNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets all instance pool usage metrics.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param instancePoolName The name of the instance pool to be retrieved.
     * @param expandChildren Optional request parameter to include managed instance usages within the instance pool.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<UsageInner>> listByInstancePoolAsync(final String resourceGroupName, final String instancePoolName, final Boolean expandChildren, final ListOperationCallback<UsageInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listByInstancePoolSinglePageAsync(resourceGroupName, instancePoolName, expandChildren),
            new Func1<String, Observable<ServiceResponse<Page<UsageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<UsageInner>>> call(String nextPageLink) {
                    return listByInstancePoolNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets all instance pool usage metrics.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param instancePoolName The name of the instance pool to be retrieved.
     * @param expandChildren Optional request parameter to include managed instance usages within the instance pool.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;UsageInner&gt; object
     */
    public Observable<Page<UsageInner>> listByInstancePoolAsync(final String resourceGroupName, final String instancePoolName, final Boolean expandChildren) {
        return listByInstancePoolWithServiceResponseAsync(resourceGroupName, instancePoolName, expandChildren)
            .map(new Func1<ServiceResponse<Page<UsageInner>>, Page<UsageInner>>() {
                @Override
                public Page<UsageInner> call(ServiceResponse<Page<UsageInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets all instance pool usage metrics.
     *
     * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
     * @param instancePoolName The name of the instance pool to be retrieved.
     * @param expandChildren Optional request parameter to include managed instance usages within the instance pool.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;UsageInner&gt; object
     */
    public Observable<ServiceResponse<Page<UsageInner>>> listByInstancePoolWithServiceResponseAsync(final String resourceGroupName, final String instancePoolName, final Boolean expandChildren) {
        return listByInstancePoolSinglePageAsync(resourceGroupName, instancePoolName, expandChildren)
            .concatMap(new Func1<ServiceResponse<Page<UsageInner>>, Observable<ServiceResponse<Page<UsageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<UsageInner>>> call(ServiceResponse<Page<UsageInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listByInstancePoolNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all instance pool usage metrics.
     *
    ServiceResponse<PageImpl<UsageInner>> * @param resourceGroupName The name of the resource group that contains the resource. You can obtain this value from the Azure Resource Manager API or the portal.
    ServiceResponse<PageImpl<UsageInner>> * @param instancePoolName The name of the instance pool to be retrieved.
    ServiceResponse<PageImpl<UsageInner>> * @param expandChildren Optional request parameter to include managed instance usages within the instance pool.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;UsageInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<UsageInner>>> listByInstancePoolSinglePageAsync(final String resourceGroupName, final String instancePoolName, final Boolean expandChildren) {
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (instancePoolName == null) {
            throw new IllegalArgumentException("Parameter instancePoolName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.listByInstancePool(resourceGroupName, instancePoolName, this.client.subscriptionId(), expandChildren, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<UsageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<UsageInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<UsageInner>> result = listByInstancePoolDelegate(response);
                        return Observable.just(new ServiceResponse<Page<UsageInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<UsageInner>> listByInstancePoolDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<UsageInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<UsageInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets all instance pool usage metrics.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;UsageInner&gt; object if successful.
     */
    public PagedList<UsageInner> listByInstancePoolNext(final String nextPageLink) {
        ServiceResponse<Page<UsageInner>> response = listByInstancePoolNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<UsageInner>(response.body()) {
            @Override
            public Page<UsageInner> nextPage(String nextPageLink) {
                return listByInstancePoolNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets all instance pool usage metrics.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<UsageInner>> listByInstancePoolNextAsync(final String nextPageLink, final ServiceFuture<List<UsageInner>> serviceFuture, final ListOperationCallback<UsageInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listByInstancePoolNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<UsageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<UsageInner>>> call(String nextPageLink) {
                    return listByInstancePoolNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets all instance pool usage metrics.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;UsageInner&gt; object
     */
    public Observable<Page<UsageInner>> listByInstancePoolNextAsync(final String nextPageLink) {
        return listByInstancePoolNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<UsageInner>>, Page<UsageInner>>() {
                @Override
                public Page<UsageInner> call(ServiceResponse<Page<UsageInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets all instance pool usage metrics.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;UsageInner&gt; object
     */
    public Observable<ServiceResponse<Page<UsageInner>>> listByInstancePoolNextWithServiceResponseAsync(final String nextPageLink) {
        return listByInstancePoolNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<UsageInner>>, Observable<ServiceResponse<Page<UsageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<UsageInner>>> call(ServiceResponse<Page<UsageInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listByInstancePoolNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all instance pool usage metrics.
     *
    ServiceResponse<PageImpl<UsageInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;UsageInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<UsageInner>>> listByInstancePoolNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listByInstancePoolNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<UsageInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<UsageInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<UsageInner>> result = listByInstancePoolNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<UsageInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<UsageInner>> listByInstancePoolNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<UsageInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<UsageInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}