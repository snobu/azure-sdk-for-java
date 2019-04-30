/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.adhybridhealthservice.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceFuture;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in AddsServicesServiceMembers.
 */
public class AddsServicesServiceMembersInner {
    /** The Retrofit service to perform REST calls. */
    private AddsServicesServiceMembersService service;
    /** The service client containing this operation class. */
    private ADHybridHealthServiceImpl client;

    /**
     * Initializes an instance of AddsServicesServiceMembersInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public AddsServicesServiceMembersInner(Retrofit retrofit, ADHybridHealthServiceImpl client) {
        this.service = retrofit.create(AddsServicesServiceMembersService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for AddsServicesServiceMembers to be
     * used by Retrofit to perform actually REST calls.
     */
    interface AddsServicesServiceMembersService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.adhybridhealthservice.AddsServicesServiceMembers list" })
        @GET("providers/Microsoft.ADHybridHealthService/addsservices/{serviceName}/servicemembers")
        Observable<Response<ResponseBody>> list(@Path("serviceName") String serviceName, @Query("$filter") String filter, @Query("dimensionType") String dimensionType, @Query("dimensionSignature") String dimensionSignature, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.adhybridhealthservice.AddsServicesServiceMembers add" })
        @POST("providers/Microsoft.ADHybridHealthService/addsservices/{serviceName}/servicemembers")
        Observable<Response<ResponseBody>> add(@Path("serviceName") String serviceName, @Body ServiceMemberInner serviceMember, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.adhybridhealthservice.AddsServicesServiceMembers listNext" })
        @GET
        Observable<Response<ResponseBody>> listNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
     * @param serviceName The name of the service.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;ServiceMemberInner&gt; object if successful.
     */
    public PagedList<ServiceMemberInner> list(final String serviceName) {
        ServiceResponse<Page<ServiceMemberInner>> response = listSinglePageAsync(serviceName).toBlocking().single();
        return new PagedList<ServiceMemberInner>(response.body()) {
            @Override
            public Page<ServiceMemberInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
     * @param serviceName The name of the service.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<ServiceMemberInner>> listAsync(final String serviceName, final ListOperationCallback<ServiceMemberInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listSinglePageAsync(serviceName),
            new Func1<String, Observable<ServiceResponse<Page<ServiceMemberInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ServiceMemberInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
     * @param serviceName The name of the service.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;ServiceMemberInner&gt; object
     */
    public Observable<Page<ServiceMemberInner>> listAsync(final String serviceName) {
        return listWithServiceResponseAsync(serviceName)
            .map(new Func1<ServiceResponse<Page<ServiceMemberInner>>, Page<ServiceMemberInner>>() {
                @Override
                public Page<ServiceMemberInner> call(ServiceResponse<Page<ServiceMemberInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
     * @param serviceName The name of the service.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;ServiceMemberInner&gt; object
     */
    public Observable<ServiceResponse<Page<ServiceMemberInner>>> listWithServiceResponseAsync(final String serviceName) {
        return listSinglePageAsync(serviceName)
            .concatMap(new Func1<ServiceResponse<Page<ServiceMemberInner>>, Observable<ServiceResponse<Page<ServiceMemberInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ServiceMemberInner>>> call(ServiceResponse<Page<ServiceMemberInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
     * @param serviceName The name of the service.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;ServiceMemberInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<ServiceMemberInner>>> listSinglePageAsync(final String serviceName) {
        if (serviceName == null) {
            throw new IllegalArgumentException("Parameter serviceName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        final String filter = null;
        final String dimensionType = null;
        final String dimensionSignature = null;
        return service.list(serviceName, filter, dimensionType, dimensionSignature, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<ServiceMemberInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ServiceMemberInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<ServiceMemberInner>> result = listDelegate(response);
                        return Observable.just(new ServiceResponse<Page<ServiceMemberInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
     * @param serviceName The name of the service.
     * @param filter The server property filter to apply.
     * @param dimensionType The server specific dimension.
     * @param dimensionSignature The value of the dimension.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;ServiceMemberInner&gt; object if successful.
     */
    public PagedList<ServiceMemberInner> list(final String serviceName, final String filter, final String dimensionType, final String dimensionSignature) {
        ServiceResponse<Page<ServiceMemberInner>> response = listSinglePageAsync(serviceName, filter, dimensionType, dimensionSignature).toBlocking().single();
        return new PagedList<ServiceMemberInner>(response.body()) {
            @Override
            public Page<ServiceMemberInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
     * @param serviceName The name of the service.
     * @param filter The server property filter to apply.
     * @param dimensionType The server specific dimension.
     * @param dimensionSignature The value of the dimension.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<ServiceMemberInner>> listAsync(final String serviceName, final String filter, final String dimensionType, final String dimensionSignature, final ListOperationCallback<ServiceMemberInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listSinglePageAsync(serviceName, filter, dimensionType, dimensionSignature),
            new Func1<String, Observable<ServiceResponse<Page<ServiceMemberInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ServiceMemberInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
     * @param serviceName The name of the service.
     * @param filter The server property filter to apply.
     * @param dimensionType The server specific dimension.
     * @param dimensionSignature The value of the dimension.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;ServiceMemberInner&gt; object
     */
    public Observable<Page<ServiceMemberInner>> listAsync(final String serviceName, final String filter, final String dimensionType, final String dimensionSignature) {
        return listWithServiceResponseAsync(serviceName, filter, dimensionType, dimensionSignature)
            .map(new Func1<ServiceResponse<Page<ServiceMemberInner>>, Page<ServiceMemberInner>>() {
                @Override
                public Page<ServiceMemberInner> call(ServiceResponse<Page<ServiceMemberInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
     * @param serviceName The name of the service.
     * @param filter The server property filter to apply.
     * @param dimensionType The server specific dimension.
     * @param dimensionSignature The value of the dimension.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;ServiceMemberInner&gt; object
     */
    public Observable<ServiceResponse<Page<ServiceMemberInner>>> listWithServiceResponseAsync(final String serviceName, final String filter, final String dimensionType, final String dimensionSignature) {
        return listSinglePageAsync(serviceName, filter, dimensionType, dimensionSignature)
            .concatMap(new Func1<ServiceResponse<Page<ServiceMemberInner>>, Observable<ServiceResponse<Page<ServiceMemberInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ServiceMemberInner>>> call(ServiceResponse<Page<ServiceMemberInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
    ServiceResponse<PageImpl<ServiceMemberInner>> * @param serviceName The name of the service.
    ServiceResponse<PageImpl<ServiceMemberInner>> * @param filter The server property filter to apply.
    ServiceResponse<PageImpl<ServiceMemberInner>> * @param dimensionType The server specific dimension.
    ServiceResponse<PageImpl<ServiceMemberInner>> * @param dimensionSignature The value of the dimension.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;ServiceMemberInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<ServiceMemberInner>>> listSinglePageAsync(final String serviceName, final String filter, final String dimensionType, final String dimensionSignature) {
        if (serviceName == null) {
            throw new IllegalArgumentException("Parameter serviceName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(serviceName, filter, dimensionType, dimensionSignature, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<ServiceMemberInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ServiceMemberInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<ServiceMemberInner>> result = listDelegate(response);
                        return Observable.just(new ServiceResponse<Page<ServiceMemberInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<ServiceMemberInner>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<ServiceMemberInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<ServiceMemberInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Onboards  a server, for a given Active Directory Domain Controller service, to Azure Active Directory Connect Health Service.
     *
     * @param serviceName The name of the service under which the server is to be onboarded.
     * @param serviceMember The server object.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the ServiceMemberInner object if successful.
     */
    public ServiceMemberInner add(String serviceName, ServiceMemberInner serviceMember) {
        return addWithServiceResponseAsync(serviceName, serviceMember).toBlocking().single().body();
    }

    /**
     * Onboards  a server, for a given Active Directory Domain Controller service, to Azure Active Directory Connect Health Service.
     *
     * @param serviceName The name of the service under which the server is to be onboarded.
     * @param serviceMember The server object.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<ServiceMemberInner> addAsync(String serviceName, ServiceMemberInner serviceMember, final ServiceCallback<ServiceMemberInner> serviceCallback) {
        return ServiceFuture.fromResponse(addWithServiceResponseAsync(serviceName, serviceMember), serviceCallback);
    }

    /**
     * Onboards  a server, for a given Active Directory Domain Controller service, to Azure Active Directory Connect Health Service.
     *
     * @param serviceName The name of the service under which the server is to be onboarded.
     * @param serviceMember The server object.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ServiceMemberInner object
     */
    public Observable<ServiceMemberInner> addAsync(String serviceName, ServiceMemberInner serviceMember) {
        return addWithServiceResponseAsync(serviceName, serviceMember).map(new Func1<ServiceResponse<ServiceMemberInner>, ServiceMemberInner>() {
            @Override
            public ServiceMemberInner call(ServiceResponse<ServiceMemberInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Onboards  a server, for a given Active Directory Domain Controller service, to Azure Active Directory Connect Health Service.
     *
     * @param serviceName The name of the service under which the server is to be onboarded.
     * @param serviceMember The server object.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the ServiceMemberInner object
     */
    public Observable<ServiceResponse<ServiceMemberInner>> addWithServiceResponseAsync(String serviceName, ServiceMemberInner serviceMember) {
        if (serviceName == null) {
            throw new IllegalArgumentException("Parameter serviceName is required and cannot be null.");
        }
        if (serviceMember == null) {
            throw new IllegalArgumentException("Parameter serviceMember is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Validator.validate(serviceMember);
        return service.add(serviceName, serviceMember, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<ServiceMemberInner>>>() {
                @Override
                public Observable<ServiceResponse<ServiceMemberInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<ServiceMemberInner> clientResponse = addDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<ServiceMemberInner> addDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<ServiceMemberInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<ServiceMemberInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;ServiceMemberInner&gt; object if successful.
     */
    public PagedList<ServiceMemberInner> listNext(final String nextPageLink) {
        ServiceResponse<Page<ServiceMemberInner>> response = listNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<ServiceMemberInner>(response.body()) {
            @Override
            public Page<ServiceMemberInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<ServiceMemberInner>> listNextAsync(final String nextPageLink, final ServiceFuture<List<ServiceMemberInner>> serviceFuture, final ListOperationCallback<ServiceMemberInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<ServiceMemberInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ServiceMemberInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;ServiceMemberInner&gt; object
     */
    public Observable<Page<ServiceMemberInner>> listNextAsync(final String nextPageLink) {
        return listNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<ServiceMemberInner>>, Page<ServiceMemberInner>>() {
                @Override
                public Page<ServiceMemberInner> call(ServiceResponse<Page<ServiceMemberInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;ServiceMemberInner&gt; object
     */
    public Observable<ServiceResponse<Page<ServiceMemberInner>>> listNextWithServiceResponseAsync(final String nextPageLink) {
        return listNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<ServiceMemberInner>>, Observable<ServiceResponse<Page<ServiceMemberInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ServiceMemberInner>>> call(ServiceResponse<Page<ServiceMemberInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets the details of the servers, for a given Active Directory Domain Controller service, that are onboarded to Azure Active Directory Connect Health Service.
     *
    ServiceResponse<PageImpl<ServiceMemberInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;ServiceMemberInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<ServiceMemberInner>>> listNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<ServiceMemberInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<ServiceMemberInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<ServiceMemberInner>> result = listNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<ServiceMemberInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<ServiceMemberInner>> listNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<ServiceMemberInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<ServiceMemberInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
