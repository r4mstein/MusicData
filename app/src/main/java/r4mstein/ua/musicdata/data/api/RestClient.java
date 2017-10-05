package r4mstein.ua.musicdata.data.api;

import static r4mstein.ua.musicdata.utils.Constants.BASE_URL;

public class RestClient {

    private static volatile RestClient instance;
    private RetrofitInterface mApi;

    private RestClient() {
        setupAdapter();
    }

    public static RestClient getInstance() {
        RestClient localInstance = instance;
        if (localInstance == null) {
            synchronized (RestClient.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new RestClient();
                }
            }
        }
        return localInstance;
    }

    public void setupAdapter() {
        IRestAdapter adapter = new RetrofitAdapter();
        mApi = adapter.createApi(RetrofitInterface.class, BASE_URL);
    }

    public RetrofitInterface getApi() {
        return getInstance().mApi;
    }
}
