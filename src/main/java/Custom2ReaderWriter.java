import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.message.internal.AbstractMessageReaderWriterProvider;


@Provider
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class Custom2ReaderWriter extends AbstractMessageReaderWriterProvider<Custom2> {

  @Override
  public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType) {
    return type == String.class || type.equals(String.class) || String.class.isAssignableFrom(type);
  }

  @Override
  public Custom2 readFrom(Class<Custom2> type, Type genericType, Annotation[] annotations,
      MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
      throws IOException, WebApplicationException {
    return Custom2.parse(readFromAsString(entityStream, mediaType));
  }

  @Override
  public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType) {
    return type == Custom2.class || Custom2.class.isAssignableFrom(type);
  }

  @Override
  public void writeTo(Custom2 t, Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
      throws IOException, WebApplicationException {
    writeToAsString(t.getValue1() + ":" + t.getValue2(), entityStream, mediaType);
  }

}
