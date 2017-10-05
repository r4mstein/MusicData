package r4mstein.ua.musicdata.data.providers;

import r4mstein.ua.musicdata.data.api.RestClient;
import r4mstein.ua.musicdata.data.api.RetrofitInterface;

public abstract class BaseProvider {
    protected RetrofitInterface api = RestClient.getInstance().getApi();
}
