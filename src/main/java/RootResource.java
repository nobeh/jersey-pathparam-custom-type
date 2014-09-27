import java.net.InetAddress;

import javax.inject.Singleton;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ext.Provider;

@Singleton
@Provider
@Path("")
public class RootResource {

  private final Object object;

  public RootResource(Object object) {
    this.object = object;
  }

  @Path("custom1/{name}")
  public Custom1Resource getCustom1(@PathParam("name") Custom1 name) {
    return new Custom1Resource(name);
  }

  @Path("custom2/{name}")
  public Custom2Resource getCustom2(@PathParam("name") Custom2 name) {
    return new Custom2Resource(name);
  }

  // XXX
  // If the following sub-resource is enabled,
  // MyServer fails to start.
  @Path("address/{address}")
  public InetAddressSubResource getAddressResource(@PathParam("address") InetAddress address) {
    return new InetAddressSubResource(address, object);
  }

}
