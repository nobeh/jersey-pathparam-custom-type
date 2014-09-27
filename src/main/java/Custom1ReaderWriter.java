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
public class Custom1ReaderWriter extends AbstractMessageReaderWriterProvider<Custom1> {

  @Override
  public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType) {
    return type == String.class || type.equals(String.class) || String.class.isAssignableFrom(type);
  }

  @Override
  public Custom1 readFrom(Class<Custom1> type, Type genericType, Annotation[] annotations,
      MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
      throws IOException, WebApplicationException {
    return new Custom1(readFromAsString(entityStream, mediaType));
  }

  @Override
  public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType) {
    return type == Custom1.class || Custom1.class.isAssignableFrom(type);
  }

  @Override
  public void writeTo(Custom1 t, Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
      throws IOException, WebApplicationException {
    writeToAsString(t.getValue(), entityStream, mediaType);
  }

}
