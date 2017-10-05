package r4mstein.ua.musicdata.data.api;


public interface IRestAdapter {

    <T> T createApi(Class<T> clazz, String base_url);

}
