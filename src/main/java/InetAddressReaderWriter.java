import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
public class InetAddressReaderWriter extends AbstractMessageReaderWriterProvider<InetAddress> {

  @Override
  public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType) {
    return type == String.class;
  }

  @Override
  public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType) {
    return type == InetAddress.class;
  }

  @Override
  public InetAddress readFrom(Class<InetAddress> type, Type genericType, Annotation[] annotations,
      MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
      throws IOException, WebApplicationException {
    String value = readFromAsString(entityStream, mediaType);
    try {
      return InetAddress.getByName(value);
    } catch (UnknownHostException e) {
      throw new RuntimeException("Cannot parse " + value, e);
    }
  }

  @Override
  public void writeTo(InetAddress t, Class<?> type, Type genericType, Annotation[] annotations,
      MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
      throws IOException, WebApplicationException {
    writeToAsString(t.getHostAddress(), entityStream, mediaType);
  }

}
